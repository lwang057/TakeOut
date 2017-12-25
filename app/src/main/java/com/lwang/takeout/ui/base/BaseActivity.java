package com.lwang.takeout.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lwang.takeout.app.App;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.base.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * BaseActivity.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {

    @Inject
    protected T mPresenter;
    protected Context mContext;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mContext = this;
        inject(((App) getApplication()).getApiComponent());

        mPresenter.attachView(this);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder = null;
    }


}
