package com.lwang.takeout.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lwang.takeout.R;
import com.lwang.takeout.app.Constants;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.model.dao.bean.UserBean;
import com.lwang.takeout.presenter.fragment.UserFragmentPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseFragment;
import com.lwang.takeout.utils.LogUtils;
import com.lwang.takeout.utils.PreferenceTool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * UserFragment.class
 *
 * @author lwang
 * @date 2017/11/9.
 */

public class UserFragment extends BaseFragment<UserFragmentPresenter> implements AppContract.UserFragmentView {

    @BindView(R.id.tv_user_setting)
    ImageView mTvUserSetting;
    @BindView(R.id.login)
    ImageView mLogin;
    @BindView(R.id.username)
    TextView mUsername;
    @BindView(R.id.phone)
    TextView mPhone;
    @BindView(R.id.ll_userinfo)
    LinearLayout mLlUserinfo;

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.user_frg;
    }

    @Override
    protected void initView() {
        LogUtils.i("UserFragment");

    }

    @Override
    public void onResume() {
        super.onResume();

        String userInfo = PreferenceTool.getString(Constants.SP_Info.SP_USER_INFO, "");
        UserBean userBean = JSON.parseObject(userInfo, UserBean.class);
        if (userBean != null) {

            //立即登录 隐藏
            mLogin.setVisibility(View.GONE);

            mUsername.setText(userBean.name);
            mPhone.setText(userBean.phone.substring(0, 3) + "****" + userBean.phone.substring(7, 11));
            mLlUserinfo.setVisibility(View.VISIBLE);

        } else {
            mLogin.setVisibility(View.VISIBLE);
            mLlUserinfo.setVisibility(View.GONE);
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

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @OnClick({R.id.tv_user_setting, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_setting:
                break;
            case R.id.login:
                mPresenter.goToLogin();
                break;
        }
    }

}