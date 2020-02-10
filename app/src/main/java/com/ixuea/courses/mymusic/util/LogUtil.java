package com.ixuea.courses.mymusic.util;

import android.util.Log;

import com.ixuea.courses.mymusic.BuildConfig;

/**
 * author: xpf
 * time: 2020/2/6 13:39
 * describe: 日志工具类
 * 对Android日志API做一层简单的封装
 */
public class LogUtil {

    /**
     * 是否是调试状态
     */
    public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * 调试级别日志
     * @param tag
     * @param value
     */
    public static void d(String tag, String value) {
        if (isDebug) {
            Log.d(tag,value);
        }
    }

    /**
     * 警告级别日志
     * @param tag
     * @param value
     */
    public static void w(String tag, String value) {
        if (isDebug) {
            Log.w(tag,value);
        }
    }
}
