package com.lwang.takeout.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lwang.takeout.app.App;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.model.dao.DBHelper;
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
        mPresenter.setDBHelper(DBHelper.getInstance());
        mPresenter.getContext(mContext);//此方法是给P 传递 当前Act的上下文 必须写在getData前面
        mPresenter.getData(getIntent());

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onTakeView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onActivityResult(requestCode, resultCode, data);
    }

    protected abstract void inject(ApiComponent apiComponent);

    protected abstract int getLayoutId();

    protected abstract void initView();

}
