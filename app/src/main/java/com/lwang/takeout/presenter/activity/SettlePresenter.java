package com.lwang.takeout.presenter.activity;

import com.lwang.takeout.model.api.AppApi;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.presenter.base.BasePresenter;
import com.lwang.takeout.ui.base.AppContract;

import javax.inject.Inject;

/**
 * LoginPresenter.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class SettlePresenter extends BasePresenter<AppContract.SettleView> {

    private AppApi appApi;

    @Inject
    public SettlePresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

}
