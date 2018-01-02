package com.lwang.takeout.app;

import com.amap.api.services.core.LatLonPoint;

import java.util.HashMap;
import java.util.Observable;

/**
 * @Author lwang
 * @Date 2017/12/28 15:13
 * @Description 全局常量类
 */

public class Constants {

    public static final String MAIN_HOME = "首页";
    public static final String MAIN_ORDER = "订单";
    public static final String MAIN_USER = "个人";
    public static final String MAIN_MORE = "更多";

    // 本地存储的用户信息
    public static class SP_Info {
        public static final String SP_USER_INFO = "data1";
    }

    public static class Location {
        public static boolean isChange = false;
        public static String TITLE = "";
        public static String SNIPPET = "";
        public static double LATITUDE = 0;
        public static double LONGITUDE = 0;

        public static LatLonPoint LOCATION = null;
    }


    public static int LOGIN_TYPE_SMS = 2; //短信登录
    public static boolean TEST_PUSH = false;

    public static class OrderObserver extends Observable {

        private static OrderObserver sOrderObserver = new OrderObserver();

        private OrderObserver() {}

        public static OrderObserver getOrderObserver() {
            return sOrderObserver;
        }

        public void changeOrderInfo(HashMap<String, String> data) {
            setChanged();
            notifyObservers(data);
        }

        /* 订单状态
                         * 1 未支付 2 已提交订单 3 商家接单  4 配送中,等待送达 5已送达 6 取消的订单*/
        public static final String ORDERTYPE_UNPAYMENT = "10";
        public static final String ORDERTYPE_SUBMIT = "20";
        public static final String ORDERTYPE_RECEIVEORDER = "30";
        public static final String ORDERTYPE_DISTRIBUTION = "40";
        public static final String ORDERTYPE_SERVED = "50";
        public static final String ORDERTYPE_CANCELLEDORDER = "60";

    }

}
