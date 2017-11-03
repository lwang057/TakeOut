package com.lwang.takeout.presenter;


import com.lwang.takeout.ui.base.IBaseView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * BasePresenter.class
 *
 * @author lwang
 * @date 2017/11/2.
 */

public class BasePresenter<View extends IBaseView> {

    protected View mView;
    protected Reference<View> reference;

    public BasePresenter() {
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

}
