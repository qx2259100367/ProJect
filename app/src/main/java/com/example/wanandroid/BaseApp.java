package com.example.wanandroid;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 裘翔 on 2019/10/22.
 */

public class BaseApp extends Application{
    private RefWatcher refWatcher;
    private static BaseApp baseApp;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApp=this;
        refWatcher= setupLeakCanary();
        CrashReport.initCrashReport(getApplicationContext(), "24a7ad7b51", false);
        UMConfigure.init(this,"5daec9843fc1951ca00010b6"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        PlatformConfig.setWeixin("wx1d742c320a524f62", "27188e7f7a55e406f8c727607cb14c72");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("2250239490", "e287577f93302b86e5696bf0b7377c9d","http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // 选用AUTO页面采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        UMConfigure.setLogEnabled(true);
        if (LeakCanary.isInAnalyzerProcess(this)) {//1
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

    }
    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        BaseApp leakApplication = (BaseApp) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
    public static BaseApp getBaseApp(){
        return baseApp;
    }
    public static Resources getRes() {
        return baseApp.getResources();
    }
}
