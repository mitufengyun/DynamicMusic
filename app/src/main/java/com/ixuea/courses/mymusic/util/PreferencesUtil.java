package com.ixuea.courses.mymusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * author: xpf
 * time: 2020/2/2 6:41
 * describe: 偏好设计工具类
 * 是否登录了，是否显示引导界面，用户Id
 */
public class PreferencesUtil {

    /**
     * 偏好设置文件名称
     */
    private static final String NAME = "ixuea_my_cloud_music";

    /**
     * 是否显示引导界面key
     */
    private static final String SHOW_GUIDE = "SHOW_GUIDE";

    /**
     * 实例
     */
    private static volatile PreferencesUtil instance;

    /**
     * 上下文
     */
    private final Context context;
    private final SharedPreferences preference;

    /**
     * 构造方法
     * @param context
     */
    public PreferencesUtil(Context context) {


        //这样写有内存泄漏
        //因为当前工具类不会马上释放
        //如果当前工具类引用了界面实例
        //当界面关闭后
        //因为界面对应在这里还有引用
        //所以会导致界面对象不会被释放
        //this.context = context;

        //保存上下文
        this.context=context.getApplicationContext();

        //获取偏好设置
        preference = this.context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    /**
     * 获取偏好设置单例
     * @param context
     * @return
     */
    public static PreferencesUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (PreferencesUtil.class) {
                if (instance == null) {
                    instance=new PreferencesUtil(context);
                }
            }
        }
        return instance;
    }

    /**
     * 是否显示引导界面
     * @return
     */
    public boolean isShowGuide() {
        return preference.getBoolean(SHOW_GUIDE,true);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public void setShowGuide(boolean value) {
        preference.edit().putBoolean(SHOW_GUIDE,value).apply();
    }
}
