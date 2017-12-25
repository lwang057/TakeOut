package com.lwang.takeout.presenter.activity;

import com.lwang.takeout.model.api.AppApi;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.presenter.base.BasePresenter;
import com.lwang.takeout.ui.base.AppContract;

import javax.inject.Inject;

/**
 * MainPresenter.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class MainPresenter extends BasePresenter<AppContract.MainView>{

    private AppApi appApi;

    @Inject
    public MainPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

}
