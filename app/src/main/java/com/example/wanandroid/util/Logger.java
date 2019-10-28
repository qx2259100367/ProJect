package com.example.wanandroid.util;


import android.util.Log;

import com.example.wanandroid.base.Constants;

/**
 * Created by liguixiao on 2019/9/24.
 */

public class Logger {
    public static void log(String tag,String msg){
        if (Constants.isDebug){
            Log.d(tag, msg);
        }
    }

    public static void println(String msg){
        if (Constants.isDebug){
            System.out.println(msg);
        }
    }
}
