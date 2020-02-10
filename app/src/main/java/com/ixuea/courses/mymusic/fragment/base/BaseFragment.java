package com.ixuea.courses.mymusic.fragment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * author: xpf
 * time: 2020/2/3 8:31
 * describe: 所有Fragment通用父类
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 找控件
     */
    protected void initViews(){

    }

    /**
     * 设置数据
     */
    protected void initDatum(){

    }

    /**
     * 绑定监听器
     */
    protected void initListeners() {

    }

    /**
     * 返回要显示的View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutView(inflater,container,savedInstanceState);
    }

    /**
     * 返回View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * View创建完毕了
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }

    /**
     * 找控件
     * @param id
     * @param <T>
     * @return
     */
    public final <T extends View> T findViewById(@IdRes int id) {
        return getView().findViewById(id);
    }


}
