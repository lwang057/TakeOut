package com.lwang.takeout.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;

import com.lwang.takeout.app.App;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.base.LazyPresenter;

import javax.inject.Inject;

/**
 * @Author lwang
 * @Date 2017/12/25 22:44
 * @Description 懒加载的fragment
 */

public abstract class LazyFragment<T extends LazyPresenter> extends AppCompatDialogFragment implements IBaseView {

    @Inject
    protected T mPresenter;
    protected boolean presenterFactoryPrepared;
    protected boolean isVisible;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(((App)getActivity().getApplication()).getApiComponent());
        mPresenter.attachView(this);
        presenterFactoryPrepared = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getContext(getActivity());
        mPresenter.getData(getActivity().getIntent());
        mPresenter.getArguments(getArguments());
        onVisible();
        mPresenter.onTakeView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //判断是否可见
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mPresenter.onHiddenChanged(hidden);
    }

    protected void onVisible() {
        if (!presenterFactoryPrepared)
            return;
        lazyLoad();
    }

    protected void onInvisible() {
    }

    //懒加载的方法,在这个方法里面我们为Fragment的各个组件去添加数据
    protected void lazyLoad(){
        mPresenter.setVisible(isVisible);
        mPresenter.preLazyLoad();
    }

    protected abstract void inject(ApiComponent apiComponent);

}
