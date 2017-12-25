package com.lwang.takeout.model.module;

import android.app.Application;

import com.lwang.takeout.app.TakeOutNavigate;

import dagger.Module;
import dagger.Provides;

/**
 * AppModule.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

@Module
public class AppModule {

    public Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    TakeOutNavigate provideWyNavigate() {
        return new TakeOutNavigate();
    }

}
