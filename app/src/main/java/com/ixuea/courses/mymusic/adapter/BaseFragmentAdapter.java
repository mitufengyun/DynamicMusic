package com.ixuea.courses.mymusic.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: xpf
 * time: 2020/2/4 9:18
 * describe: 通用FragmentPagerAdapter
 * 主要是创建了列表
 * 实现了通用的方法
 * 直接用FragmentPagerAdapter有可能有内存泄漏
 * 所以使用FragmentStatePagerAdapter
 * todo 后续会处理
 */
public abstract class BaseFragmentAdapter<T> extends FragmentPagerAdapter {

    /**
     * 上下文
     */
    protected final Context context;

    /**
     * 列表数据源
     */
    protected List<T> data = new ArrayList<>();

    /**
     * 构造方法
     * @param fm Fragment管理器
     * @param context 上下文
     */
    public BaseFragmentAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }



    /**
     * 获取条目数量
     * @return
     */
    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }


    /**
     * 获取当前位置的数据
     *
     * @param position
     * @return
     */
    protected T getData(int position) {
        return data.get(position);
    }

    /**
     * 设置数据
     *
     * @param datum
     */
    public void setData(List<T> datum) {
        if (datum != null && datum.size() > 0) {
            this.data.clear();
            this.data.addAll(datum);

            //通知数据改变了
            notifyDataSetChanged();
        }
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<T> data) {
        if (data != null && data.size() > 0) {
            this.data.addAll(data);
            //通知数据改变了
            notifyDataSetChanged();
        }
    }
}
