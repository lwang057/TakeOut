package com.lwang.takeout.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabWidget;
import android.widget.TextView;

import com.lwang.takeout.R;
import com.lwang.takeout.app.Constants;
import com.lwang.takeout.model.component.ApiComponent;
import com.lwang.takeout.presenter.activity.MainPresenter;
import com.lwang.takeout.ui.base.AppContract;
import com.lwang.takeout.ui.base.BaseActivity;
import com.lwang.takeout.ui.fragment.HomeFragment;
import com.lwang.takeout.ui.fragment.MoreFragment;
import com.lwang.takeout.ui.fragment.OrderFragment;
import com.lwang.takeout.ui.fragment.UserFragment;
import com.lwang.takeout.ui.view.TabFragmentHost;

import butterknife.BindView;

/**
 * MainActivity.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements AppContract.MainView {


    @BindView(android.R.id.tabcontent)
    FrameLayout mTabcontent;
    @BindView(android.R.id.tabs)
    TabWidget mTabs;
    @BindView(R.id.tabFragmentHost)
    TabFragmentHost mTabFragmentHost;

    private int[] tabImgRes;
    private Class[] fragments;
    private String[] tabTags;

    @Override
    protected void inject(ApiComponent apiComponent) {
        apiComponent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        tabImgRes = new int[]{R.drawable.selector_icon_main_home,
                R.drawable.selector_icon_main_order,
                R.drawable.selector_icon_main_me,
                R.drawable.selector_icon_main_more};

        fragments = new Class[]{HomeFragment.class, OrderFragment.class, UserFragment.class, MoreFragment.class};
        tabTags = new String[]{Constants.MAIN_HOME , Constants.MAIN_ORDER , Constants.MAIN_USER , Constants.MAIN_MORE};


        mTabFragmentHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        Bundle bundle = new Bundle();
        for (int i = 0; i < fragments.length; i++) {
            mTabFragmentHost.addTab(mTabFragmentHost.newTabSpec(tabTags[i]).setIndicator(getTab(i)), fragments[i], bundle);
        }
        mTabFragmentHost.getTabWidget().setDividerDrawable(null);
    }


    private View getTab(int i) {
        View view = getLayoutInflater().inflate(R.layout.item_main_tab, null);
        TextView mainTextView = (TextView) view.findViewById(R.id.mainTextView);
        mainTextView.setText(tabTags[i]);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        img.setImageResource(tabImgRes[i]);

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}
