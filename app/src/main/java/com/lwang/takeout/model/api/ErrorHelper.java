package com.lwang.takeout.model.api;

import android.content.Context;

import com.facebook.stetho.common.LogUtil;
import com.lwang.takeout.R;
import com.lwang.takeout.utils.ToastUtils;

/**
 * ErrorHelper.class
 *
 * @author lwang
 * @date 2017/12/25.
 */

public class ErrorHelper {

    public static void onError(Context context, Throwable throwable) {

        String errorString = throwable.toString();
        LogUtil.e("aaaa==============" + throwable.toString());
        //返回的错误为空
        if (errorString == null) {
            ToastUtils.initToast(context.getString(R.string.generic_server_down));
        }
        //请求超时
        if (errorString.contains("TimeoutException") || errorString.contains("SocketTimeoutException")) {
            ToastUtils.initToast(context.getString(R.string.request_time_out));
        }
        //能识别的请求异常，忽略不提示
        if (errorString.contains("SSLException")) {

        }
        //403、404等服务错误
        if (errorString.contains("ServiceConfigurationError") || errorString.contains("AuthenticatorException")) {
            ToastUtils.initToast(context.getString(R.string.generic_server_down));
        }
        //网络未连接
        if (errorString.contains("NetworkErrorException") || errorString.contains("NoConnectionPendingException") || errorString.contains("UnknownHostException")) {
            ToastUtils.initToast(context.getString(R.string.network_hint));
        }
        //连接不到服务器
        if (errorString.contains("ConnectException")) {
            ToastUtils.initToast(context.getString(R.string.fail_to_connected));
        }
    }
}
