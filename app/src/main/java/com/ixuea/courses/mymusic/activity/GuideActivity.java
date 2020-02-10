package com.ixuea.courses.mymusic.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.ixuea.courses.mymusic.MainActivity;
import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.base.BaseCommonActivity;
import com.ixuea.courses.mymusic.adapter.GuideAdapter;
import com.ixuea.courses.mymusic.util.Constant;
import com.ixuea.courses.mymusic.util.LogUtil;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * 引导界面
 */
public class GuideActivity extends BaseCommonActivity implements View.OnClickListener {


    private static final String TAG = "GuideActivity";
    /**
     * ViewPager左右滚动控件
     */
    private ViewPager vp;

    /**
     * 指示器
     */
    private CircleIndicator ci;

    /**
     * 适配器
     */
    private GuideAdapter adapter;

    /**
     * 登录注册按钮
     */
    private Button bt_login_or_register;
    private Button bt_enter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //测试productFlavors
        //获取ENDPOINT常量
        LogUtil.d(TAG, "ENDPOINT: " + Constant.ENDPOINT);
    }

    @Override
    protected void initViews() {
        super.initViews();
        // 隐藏状态栏
//        hideStatusBar();

        //找控件
        //ViewPager
        vp = findViewById(R.id.vp);
        //指示器
        ci = findViewById(R.id.ci);

        //登录注册按钮
        bt_login_or_register=findViewById(R.id.bt_login_or_register);

        //注册按钮
        bt_enter=findViewById(R.id.bt_enter);

        //测试显示fragment
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, GuideFragment.newInstance(R.drawable.guide1))
//                .commit();
    }


    @Override
    protected void initListeners() {
        super.initListeners();
        //设置点击事件
        //登录注册按钮
        bt_login_or_register.setOnClickListener(this);

        //立即体验按钮
        bt_enter.setOnClickListener(this);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        //测试使用SharedPreference
        //testSharePreferences();

        //创建适配器
        adapter = new GuideAdapter(getSupportFragmentManager(), getMainActivity().getApplicationContext());

        //添加数据
        ArrayList<Integer> data = new ArrayList<>();
        data.add(R.drawable.guide1);
        data.add(R.drawable.guide2);
        data.add(R.drawable.guide3);
        data.add(R.drawable.guide4);
        data.add(R.drawable.guide5);
        adapter.setData(data);

        //设置适配器到控件
        vp.setAdapter(adapter);

        //让指示器根据ViewPager配合工作
        ci.setViewPager(vp);

        //适配器注册数据原观察者
        adapter.registerDataSetObserver(ci.getDataSetObserver());
    }


    /**
     * 点击回调事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        //因为有很多个按钮都设置同一个监听器
        //所以这里需要区分到底是哪一个按钮点击
        switch (view.getId()) {
            case R.id.bt_login_or_register:
                //注册登录按钮点击
                //设置是否显示了引导界面
                setShowGuide();
                Log.d(TAG, "onClick login or register");
                startActivityAfterFinishThis(LoginOrRegisterActivity.class);
                break;
            case R.id.bt_enter:
                //进入按钮
                //设置是否显示了引导界面
                setShowGuide();
                Log.d(TAG, "onClick enter");
                startActivityAfterFinishThis(MainActivity.class);
                break;
        }
    }

    /**
     * 设置是否显示了引导界面
     */
    private void setShowGuide() {
        //false表示下次启动将不再显示引导界面
        //PreferencesUtil.getInstance(getMainActivity()).setShowGuide(false);
        sp.setShowGuide(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销监听
        adapter.unregisterDataSetObserver(ci.getDataSetObserver());
    }

    /**
     * 测试使用SharedPreference
     */
    private void testSharePreferences() {
        //获取偏移设置对象
        SharedPreferences preferences = getSharedPreferences("ixuea", Context.MODE_PRIVATE);

        //保存一个字符串"我们是爱学啊"
        //存储的键为：username
        preferences.edit().putString("username","我们是爱学啊").apply();

        //通过键找到上面存储的值
        String username = preferences.getString("username",null);

        //打印出来，方便调试
        Log.d(TAG, "initDatum: "+"第一次获取的值：username = "+username);

        //删除该key对应的值
        preferences.edit().remove("username").apply();

        //再次获取
        username=preferences.getString("username",null);

        Log.d(TAG, "initDatum: "+"删除后再次获取的值：username = "+username);


        //测试productFlavors
        //获取ENDPOINT常量
        LogUtil.d(TAG, "ENDPOINT: " + Constant.ENDPOINT);
    }
}
