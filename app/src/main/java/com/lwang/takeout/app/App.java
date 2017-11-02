package com.lwang.takeout.app;

import android.app.Application;

import com.lwang.takeout.model.component.ApiComponent;

/**
 * App.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class App extends Application {

    private AppDeletage appDeletage;

    @Override
    public void onCreate() {
        super.onCreate();

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

}
