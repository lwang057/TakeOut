package com.lwang.takeout.ui.activity;

import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.OnLinePayPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * OnLinePayActivity.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class OnLinePayActivity extends BaseActivity<OnLinePayPresenter> implements AppContract.OnLinePayView {

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
