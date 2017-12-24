package com.lwang.takeout.ui.activity;

import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.LocationPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * LocationActivity.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class LocationActivity extends BaseActivity<LocationPresenter> implements AppContract.LocationView {

    @Override
    protected void inject(ApiComponent apiComponent) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
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
