package com.ixuea.courses.mymusic.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.fragment.base.BaseCommonFragment;
import com.ixuea.courses.mymusic.util.Constant;

/**
 * 引导界面Fragment
 */
public class GuideFragment extends BaseCommonFragment {


    /**
     * 图片控件
     */
    private ImageView iv;

    /**
     * 构造方法
     */
    public GuideFragment() {

    }

    /**
     * 创建方法
     */
    public static GuideFragment newInstance(int id) {
        //创建fragment
        GuideFragment fragment = new GuideFragment();

        //创建Bundle
        Bundle args = new Bundle();

        //添加Id
        args.putInt(Constant.ID,id);

        //将Bundle设置到fragment
        fragment.setArguments(args);

        return fragment;
    }

    /**
     * 返回要显示的View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);

        return view;
    }

    /**
     * 返回要显示的view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    protected View getLayoutView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }

    @Override
    protected void initViews() {
        super.initViews();

        //找控件
        iv = findViewById(R.id.iv);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        //取出传递的数据
        int id = getArguments().getInt(Constant.ID,-1);

        //判断数据格式
        if (id == -1) {
            //如果图片不存在
            //就关闭当前界面
            //但在我们这里不会发生该情况
            getActivity().finish();
            return;
        }

        //显示图片
        iv.setImageResource(id);
    }





}
