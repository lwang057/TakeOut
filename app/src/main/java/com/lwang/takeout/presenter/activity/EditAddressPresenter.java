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

public class EditAddressPresenter extends BasePresenter<AppContract.EditAddressView> {


    private AppApi appApi;

    @Inject
    public EditAddressPresenter(ErrorListener errorListener, AppApi appApi) {
        super(errorListener);
        this.appApi = appApi;
    }


}
