package com.ixuea.courses.mymusic;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.ixuea.courses.mymusic.util.ToastUtil;

import es.dmoral.toasty.Toasty;

/**
 * author: xpf
 * time: 2020/2/6 14:26
 * describe: 全局Application
 */
public class AppContext extends Application {
    /**
     * 上下文
     */
    private static AppContext context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //初始化MultiDex
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化toast工具类
        Toasty.Config.getInstance().apply();

        //初始化toast工具类
        ToastUtil.init(getApplicationContext());
    }
}
