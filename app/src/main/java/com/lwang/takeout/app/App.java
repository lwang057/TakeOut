package com.lwang.takeout.app;

import android.app.Application;
import android.content.Context;

import com.lwang.takeout.model.component.ApiComponent;

/**
 * App.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class App extends Application {

    private AppDeletage appDeletage;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        //通过AppDeletage来初始化Dagger2
        appDeletage = new AppDeletage(this);
        appDeletage.onCreate();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        // 程序在内存清理的时候执行
        appDeletage.onTerminate();
    }


    public ApiComponent getApiComponent() {
        return appDeletage.getApiComponent();
    }


    public static Context getContext() {
        return sContext;
    }

}
