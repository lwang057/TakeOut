package com.lwang.takeout.ui.base;

import android.view.View;

import com.lwang.takeout.ui.activity.LoginActivity;

/**
 * AppContract.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public interface AppContract {

    interface MainView extends IBaseView{
        void showResult();
    }
    interface LoginView extends IBaseView{
        void showResult();
    }

    interface ShopCarView extends IBaseView{
        void showResult();
    }

    interface OrderDetailView extends IBaseView{
        void showResult();
    }

    interface LocationView extends IBaseView{
        void showResult();
    }

    interface SellerDetailView extends IBaseView{
        void showResult();
    }

    interface OnLinePayView extends IBaseView{
        void showResult();
    }

    interface ReceiptView extends IBaseView{
        void showResult();
    }

    interface SettleView extends IBaseView{
        void showResult();
    }

    interface EditAddressView extends IBaseView{
        void showResult();
    }

    interface HomeFragmentView extends IBaseView{
        void showResult();
    }

    interface GoodsFragmentView extends IBaseView{
        void showResult();
    }

    interface OrderFragmentView extends IBaseView{
        void showResult();
    }

    interface UserFragmentView extends IBaseView{
        void showResult();
    }

}
