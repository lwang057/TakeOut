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

public class LoginPresenter extends BasePresenter<AppContract.LoginView> {


    private AppApi appApi;

    @Inject
    public LoginPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

}
