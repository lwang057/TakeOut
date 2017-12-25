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

public class MoreFragmentPresenter extends BasePresenter<AppContract.MoreFragmentView>{

    private AppApi appApi;

    @Inject
    public MoreFragmentPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }

}
