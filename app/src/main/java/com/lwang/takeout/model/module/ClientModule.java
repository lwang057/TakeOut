package com.lwang.takeout.model.module;

import android.app.Application;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.model.api.HttpsUtils;
import com.lwang.takeout.model.api.RequestInterceptor;
import com.lwang.takeout.model.api.RxErrorHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * ClientModule.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

@Module
public class ClientModule {

    private static int TIME_OUT = 60_000;


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkhttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    Interceptor provodeInterceptor() {
        return new StethoInterceptor();
    }

//    @Singleton
//    @Provides
//    HttpsUtils.SSLParams provideSSLParams(Application context) {
//        InputStream bks = null, cer = null;
//        try {
//            bks = context.getAssets().open(CLIENT_PRI_KEY);
//            cer = context.getAssets().open(TRUSTSTORE_PUB_KEY);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bks.close();
//                cer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return HttpsUtils.getSslSocketFactory(bks, CLIENT_BKS_PASSWORD, cer);
//    }

    @Singleton
    @Provides
    List<Interceptor> provideInterceptors(Application context) {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new RequestInterceptor(context));
        interceptors.add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return interceptors;
    }


    @Singleton
    @Provides
    HostnameVerifier provideHostnameVerifier() {
        return new HttpsUtils.UnSafeHostnameVerifier();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder,
                               Interceptor interceptor,
//                               HttpsUtils.SSLParams sslParams,
                               List<Interceptor> interceptors,
                               HostnameVerifier hostnameVerifier) {


        builder.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .addNetworkInterceptor(interceptor)
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .hostnameVerifier(hostnameVerifier);

        for (Interceptor tempInterceptor : interceptors) {
            builder.addInterceptor(tempInterceptor);
        }
        return builder.build();
    }


    @Singleton
    @Provides
    ErrorListener provideErrorHanler() {
        return new RxErrorHandler();
    }

}
