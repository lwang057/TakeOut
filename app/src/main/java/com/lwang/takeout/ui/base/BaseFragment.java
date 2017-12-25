package com.lwang.takeout.ui.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lwang.takeout.app.App;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.base.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseFragment.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView {

    @Inject
    protected T mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject(((App) getActivity().getApplication()).getApiComponent());
        mPresenter.attachView(this);
        initView();
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();

    protected abstract void initView();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder = null;
    }


}
