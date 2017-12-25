package com.lwang.takeout.presenter.activity;

import com.lwang.takeout.model.api.AppApi;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.presenter.base.BasePresenter;
import com.lwang.takeout.ui.base.AppContract;

import javax.inject.Inject;

/**
 * ShopCarPresenter.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class ShopCarPresenter extends BasePresenter<AppContract.ShopCarView> {

    private AppApi appApi;

    @Inject
    public ShopCarPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

}
