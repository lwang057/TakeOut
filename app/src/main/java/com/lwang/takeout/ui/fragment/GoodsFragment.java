package com.lwang.takeout.ui.fragment;

import com.lwang.takeout.R;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.fragment.GoodsFragmentPresenter;
import com.lwang.takeout.presenter.fragment.HomeFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;
import com.lwang.takeout.ui.base.LazyFragment;

/**
 * GoodsFragment.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class GoodsFragment extends LazyFragment<GoodsFragmentPresenter> implements AppContract.GoodsFragmentView {

    @Override
    protected void inject(ApiComponent apiComponent) {

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
