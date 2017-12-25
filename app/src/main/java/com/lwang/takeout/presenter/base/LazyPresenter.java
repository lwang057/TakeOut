package com.lwang.takeout.presenter.base;

import com.lwang.takeout.model.api.ErrorListener;
import com.lwang.takeout.ui.base.IBaseView;

/**
 * @Author lwang
 * @Date 2017/12/25 07:55
 * @Description
 */

public abstract class LazyPresenter<View extends IBaseView> extends BasePresenter<View> {

    protected boolean isPrepared;
    protected boolean allowLoad = true; // 如果需要（重新）加载，这个变量设置为true
    private boolean mBoolean;

    public LazyPresenter(ErrorListener errorListener) {
        super(errorListener);
    }

    @Override
    public void onTakeView() {
        super.onTakeView();
        isPrepared = true;
        preLazyLoad();
    }

    public void preLazyLoad() {
        if (!isPrepared || !mBoolean) {
            return;
        }
        if (!allowLoad) {
            return;
        }
        allowLoad = false;
        lazyLoad();
    }

    protected abstract void lazyLoad();

    public void setVisible(boolean isVisible) {
        mBoolean = isVisible;
    }

}
