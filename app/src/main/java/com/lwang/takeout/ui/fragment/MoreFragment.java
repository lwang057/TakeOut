package com.lwang.takeout.ui.fragment;

import com.alibaba.fastjson.JSON;
import com.lwang.takeout.R;
import com.lwang.takeout.app.Constants;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.model.dao.bean.UserBean;
import com.lwang.takeout.presenter.fragment.MoreFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;
import com.lwang.takeout.utils.LogUtils;
import com.lwang.takeout.utils.PreferenceTool;
import com.lwang.takeout.utils.ToastUtils;

import java.util.HashMap;

import butterknife.OnClick;

/**
 * HomeFragment.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class MoreFragment extends BaseFragment<MoreFragmentPresenter> implements AppContract.MoreFragmentView {

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.more_frg;
    }

    @Override
    protected void initView() {
        LogUtils.i("MoreFragment");
    }


    @OnClick(R.id.buttonView)
    public void onViewClicked() {
        if (isLogin()) {
            initData();
            ToastUtils.initToast(getString(R.string.test_push));
            Constants.TEST_PUSH = true;
        } else {
            ToastUtils.initToast(getString(R.string.no_login));
        }
    }

    public void initData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("type", "20");
        data.put("orderId", "1010 8027 3652 5689 39");
        if (data.size() > 0) {
            Constants.OrderObserver.getOrderObserver().changeOrderInfo(data);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showResult() {

    }

    public static boolean isLogin() {
        String userInfo = PreferenceTool.getString(Constants.SP_Info.SP_USER_INFO, "");
        UserBean userBean = JSON.parseObject(userInfo, UserBean.class);
        if (userBean != null) {
            return true;
        }
        return false;
    }
}
