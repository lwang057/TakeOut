package com.lwang.takeout.model.component;

import com.lwang.takeout.app.AppDeletage;
import com.lwang.takeout.model.module.ApiModule;
import com.lwang.takeout.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ApiComponent.class
 *
 * @author lwang
 * @date 2017/11/2.
 */
@Singleton
@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);

}
