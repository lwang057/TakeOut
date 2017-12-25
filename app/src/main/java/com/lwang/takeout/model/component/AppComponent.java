package com.lwang.takeout.model.component;

import com.lwang.takeout.app.AppDeletage;
import com.lwang.takeout.model.module.AppModule;

import dagger.Component;

/**
 * AppComponent.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(AppDeletage appDeletage);
}
