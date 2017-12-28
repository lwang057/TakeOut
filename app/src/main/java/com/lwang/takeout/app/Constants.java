package com.lwang.takeout.app;

import com.amap.api.services.core.LatLonPoint;

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


    public static class Location {
        public static boolean isChange = false;
        public static String TITLE = "";
        public static String SNIPPET = "";
        public static double LATITUDE = 0;
        public static double LONGITUDE = 0;

        public static LatLonPoint LOCATION = null;
    }

}
