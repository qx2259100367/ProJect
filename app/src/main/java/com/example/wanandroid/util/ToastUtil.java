package com.example.wanandroid.util;


import android.widget.Toast;

import com.example.wanandroid.BaseApp;

/**
 * Created by liguixiao on 2019/9/24.
 */

public class ToastUtil {
    public static void showShort(String msg){
        Toast.makeText(BaseApp.getBaseApp(), msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg){
        Toast.makeText(BaseApp.getBaseApp(), msg,Toast.LENGTH_LONG).show();
    }
}
