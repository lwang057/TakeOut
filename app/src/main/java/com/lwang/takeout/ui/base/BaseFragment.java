package com.lwang.takeout.ui.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
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

public abstract class BaseFragment<T extends BasePresenter> extends AppCompatDialogFragment implements IBaseView {

    @Inject
    protected T mPresenter;
    private Unbinder unbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((App)getActivity().getApplication()).getApiComponent());
        mPresenter.attachView(this);
        mPresenter.getContext(getActivity());
        mPresenter.getData(getActivity().getIntent());
        mPresenter.getArguments(getArguments());
    }

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
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onTakeView();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder = null;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mPresenter.onHiddenChanged(hidden);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode ,resultCode ,data);
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();

    protected abstract void initView();

}
