package com.ixuea.courses.mymusic.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ixuea.courses.mymusic.fragment.GuideFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xpf
 * time: 2020/2/4 7:14
 * describe: 引导界面适配器
 */
public class GuideAdapter extends BaseFragmentAdapter<Integer> {

    /**
     * 列表数据源
     */
    private List<Integer> data = new ArrayList<>();


    /**
     * 构造方法
     * @param fm
     */
    public GuideAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, context);
    }


    /**
     * 返回当前要显示的item
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return GuideFragment.newInstance(getData(position));
    }



}
