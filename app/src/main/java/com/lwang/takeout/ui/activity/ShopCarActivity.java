package com.lwang.takeout.ui.activity;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.ShopCarPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * ShopCarActivity.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class ShopCarActivity extends BaseActivity<ShopCarPresenter> implements AppContract.ShopCarView {


    @Override
    protected void inject(ApiComponent apiComponent) {
//        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_car;
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
