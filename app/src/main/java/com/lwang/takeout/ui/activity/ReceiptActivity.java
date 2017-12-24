package com.lwang.takeout.ui.activity;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.ReceiptPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;

/**
 * ReceiptActivity.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class ReceiptActivity extends BaseActivity<ReceiptPresenter>implements AppContract.ReceiptView {


    @Override
    protected void inject(ApiComponent apiComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receipt_address;
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
