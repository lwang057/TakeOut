package com.lwang.takeout.ui.fragment;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.fragment.HomeFragmentPresenter;
import com.lwang.takeout.presenter.fragment.OrderFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;

/**
 * OrderFragment.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class OrderFragment extends BaseFragment<OrderFragmentPresenter> implements AppContract.OrderFragmentView {

    @Override
    protected void inject(ApiComponent apiComponent) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.order_frg;
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