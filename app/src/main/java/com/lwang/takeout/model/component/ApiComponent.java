package com.lwang.takeout.model.component;

import com.lwang.takeout.app.AppDeletage;
import com.lwang.takeout.model.module.ApiModule;
import com.lwang.takeout.ui.activity.MainActivity;
import com.lwang.takeout.ui.activity.ShopCarActivity;
import com.lwang.takeout.ui.fragment.HomeFragment;
import com.lwang.takeout.ui.fragment.MoreFragment;
import com.lwang.takeout.ui.fragment.OrderFragment;
import com.lwang.takeout.ui.fragment.UserFragment;

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

    void inject(HomeFragment fragment);

    void inject(MoreFragment fragment);

    void inject(UserFragment fragment);

    void inject(OrderFragment fragment);

//    void inject(ShopCarActivity shopCarActivity);

}
