package com.lwang.takeout.presenter.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lwang.takeout.model.api.ErrorHelper;
import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.model.dao.DBHelper;
import com.lwang.takeout.ui.base.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * BasePresenter.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class BasePresenter<View extends IBaseView> implements ErrorListener {

    protected View mView;
    protected Reference<View> reference;
    protected ErrorListener errorListener;
    protected Context context;
    private boolean isViewAttach;
    protected DBHelper mDBHelper;

    public BasePresenter(ErrorListener errorListener) {
        this.errorListener = errorListener;
    }


    public void attachView(View view) {

        // 使用弱引用得到view，可以及时回收
        reference = new WeakReference<>(view);
        mView = (View) reference.get();
    }


    public void detachView() {
        if (reference != null) {
            reference.clear();
        }
        reference = null;
    }

    @Override
    public void handleError(Throwable throwable) {
        ErrorHelper.onError(context,throwable);
    }

    public void getContext(Context context) {
        this.context = context;
    }

    /**
     * 页面跳转 携带数据过来 Pst写此方法拿数据
     * @param intent
     */
    public void getData(Intent intent) {

    }

    /**
     * 页面跳转 数据回传 Pst写此方法拿回传数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


    /**
     * 如果需要进来就要联网请求数据，Pst 中覆写此方法
     */
    public void onTakeView() {

        if (!isViewAttach) {
            isViewAttach = true;
            onOnceTakeView();
        }

    }
    /**
     * 如果只需要第一次加载页面联网请求数据，Pst 中覆写次方法
     */
    public void onOnceTakeView() {

    }

    public void setDBHelper(DBHelper instance) {
        mDBHelper = instance;
    }

    /**
     * Fragment显示与隐藏的监听
     * @param hidden
     */
    public void onHiddenChanged(boolean hidden) {

    }

    public void getArguments(Bundle bundle) {

    }

}
