package com.lwang.takeout.presenter.fragment;

import com.lwang.takeout.model.api.AppApi;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.presenter.base.BasePresenter;
import com.lwang.takeout.ui.base.AppContract;

import javax.inject.Inject;

/**
 * @Author lwang
 * @Date 2017/12/25 08:00
 * @Description
 */

public class UserFragmentPresenter extends BasePresenter<AppContract.UserFragmentView>{

    private AppApi appApi;

    @Inject
    public UserFragmentPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

    public void goToLogin() {
        mTakeOutNavigate.goToLogin(context);
    }

}
