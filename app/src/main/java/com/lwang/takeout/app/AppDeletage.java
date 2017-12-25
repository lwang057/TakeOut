package com.lwang.takeout.app;

import android.app.Application;

import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.model.component.AppComponent;
import com.lwang.takeout.model.component.DaggerApiComponent;
import com.lwang.takeout.model.component.DaggerAppComponent;
import com.lwang.takeout.model.module.ApiModule;
import com.lwang.takeout.model.module.AppModule;
import com.lwang.takeout.utils.PreferenceTool;
import com.lwang.takeout.utils.ToastUtils;


/**
 * AppDeletage.class
 *
 * @author lwang
 * @date 2017/11/2.
 *
 * 初始化Dagger2
 */

public class AppDeletage {

    public Application appContext;
    private AppComponent appComponent;
    private ApiComponent apiComponent;


    public AppDeletage(Application application) {
        this.appContext = application;
    }


    public void onCreate(){
        initInject();
        ToastUtils.init(appContext);        //吐司初始化
        PreferenceTool.init(appContext);    //Preference参数
    }


    public void initInject(){

        appComponent = DaggerAppComponent.builder()
                .appModule(getAppModule())
                .build();

        apiComponent = DaggerApiComponent.builder()
                .apiModule(new ApiModule())
                .appModule(getAppModule())
                .build();
    }


    private AppModule getAppModule(){
        return new AppModule(appContext);
    }


    public ApiComponent getApiComponent(){
        return apiComponent;
    }


    public void onTerminate(){
        this.appComponent = null;
        this.apiComponent = null;
        this.appComponent = null;
    }


}
