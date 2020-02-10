package com.ixuea.courses.mymusic.fragment.base;

import android.content.Intent;

import com.ixuea.courses.mymusic.activity.base.BaseCommonActivity;
import com.ixuea.courses.mymusic.util.PreferencesUtil;

/**
 * author: xpf
 * time: 2020/2/3 8:57
 * describe: 通用Fragment逻辑
 */
public abstract class BaseCommonFragment extends BaseFragment {

    protected PreferencesUtil sp;

    @Override
    protected void initViews() {
        super.initViews();

        //初始化偏好工具类
        sp = PreferencesUtil.getInstance(getMainActivity().getApplicationContext());
    }

    /**
     * 启动界面
     *
     * @param clazz
     */
    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * 启动界面并关闭当前界面
     *
     * @param clazz
     */
    protected void startActivityAfterFinishThis(Class<?> clazz) {
        startActivity(new Intent(getMainActivity(), clazz));
        getActivity().finish();
    }

    /**
     * 获取当前Fragment所在的Activity
     */
    public BaseCommonActivity getMainActivity() {
        return (BaseCommonActivity) getActivity();
    }



}
