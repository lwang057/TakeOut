package com.lwang.takeout.ui.fragment;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.fragment.HomeFragmentPresenter;
import com.lwang.takeout.presenter.fragment.UserFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;
import com.lwang.takeout.utils.LogUtils;

/**
 * UserFragment.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class UserFragment extends BaseFragment<UserFragmentPresenter> implements AppContract.UserFragmentView {

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_frg;
    }

    @Override
    protected void initView() {
        LogUtils.i("UserFragment");

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