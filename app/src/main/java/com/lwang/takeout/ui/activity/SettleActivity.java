package com.lwang.takeout.ui.activity;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.LocationPresenter;
import com.lwang.takeout.presenter.activity.SettlePresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * LocationActivity.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class SettleActivity extends BaseActivity<SettlePresenter> implements AppContract.SettleView {

    @Override
    protected void inject(ApiComponent apiComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settle;
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
