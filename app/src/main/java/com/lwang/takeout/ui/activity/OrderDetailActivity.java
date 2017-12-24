package com.lwang.takeout.ui.activity;

import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.OrderDetailPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;
import com.lwang.takeout.ui.base.IBaseView;

/**
 * OrderDetailActivity.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements AppContract.ShopCarView{


    @Override
    protected void inject(ApiComponent apiComponent) {
//        apiComponent.inject(this);
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
