package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.base.BaseCommonActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: xpf
 * time: 2020/2/2 6:11
 * describe: 登录注册界面
 */
public class LoginOrRegisterActivity extends BaseCommonActivity {

    private static final String TAG = "LoginOrRegisterActivity";
    /**
     * 登录按钮
     */
    @BindView(R.id.bt_login)
    Button bt_login;

    /**
     * 注册按钮
     */
    @BindView(R.id.bt_register)
    Button bt_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
    }

    @Override
    protected void initViews() {
        super.initViews();

        //透明状态栏
        lightStatusBar();

//        //登录按钮
//        bt_login = findViewById(R.id.bt_login);
//
//        //注册按钮
//        bt_register = findViewById(R.id.bt_register);
    }



/*    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                //登录按钮点击
                Log.d(TAG, "onClick: login");
                startActivity(LoginActivity.class);
                break;
            case R.id.bt_register:
                //注册按钮点击
                Log.d(TAG, "onClick: register");
                break;
        }
    }*/

    /**
     * 登录按钮点击事件
     */
    @OnClick(R.id.bt_login)
    public void onLoginClick(View view) {
        startActivity(LoginActivity.class);
    }

    /**
     * 注册按钮点击事件
     */
    @OnClick(R.id.bt_register)
    public void onRegisterClick(View view) {
        startActivity(RegisterActivity.class);
    }
}
