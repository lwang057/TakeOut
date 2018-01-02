package com.lwang.takeout.app;

import android.content.Context;
import android.content.Intent;

import com.lwang.takeout.ui.activity.LoginActivity;

/**
 * TakeOutNavigate.class
 *
 * @author lwang
 * @date 2017/12/24.
 */

public class TakeOutNavigate {

    public void goToLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
