package com.lwang.takeout.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.MainPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements AppContract.MainView {

    @Override
    protected void inject(ApiComponent apiComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult() {

    }
}
