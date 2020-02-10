package com.ixuea.courses.mymusic.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.base.BaseCommonActivity;

public class SplashActivity extends BaseCommonActivity {

    private static final String TAG = "SplashActivity";

    /**
     * 下一步常量
     */
    private static final int MESSAGE_NEXT = 100;

    /**
     * 默认延时时间
     */
    private static final long DEFAULT_DELAY_TIME = 3000;

    /**
     * 创建Handler
     *
     * 这样创建有内存泄漏
     * 在性能优化我们具体讲解
     */
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        /**
         * 收到消息后会调用该方法
         * @param msg
         */
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            //根据消息类型做出不同的处理
            switch (msg.what) {
                case MESSAGE_NEXT:
                    // 下一步
                    next();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.NoStatusTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 设置全屏
//        fullScreen();

        // 模拟广告倒计时延迟3秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(MESSAGE_NEXT);
            }
        }, DEFAULT_DELAY_TIME);
    }

    /**
     * 下一步
     */
    private void next() {
        Log.d(TAG, "next: ");

//        if (sp.isShowGuide()) {//已经显示过引导界面
            // 使用重构后的方法
            startActivityAfterFinishThis(GuideActivity.class);
//        } else {
            // 跳转到登录注册界面
//            startActivityAfterFinishThis(LoginOrRegisterActivity.class);
//        }


    }

}
