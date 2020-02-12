package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.base.BaseTitleActivity;
import com.ixuea.courses.mymusic.bean.SheetDetailWrapper;
import com.ixuea.courses.mymusic.network.Service;
import com.ixuea.courses.mymusic.util.Constant;
import com.ixuea.courses.mymusic.util.LogUtil;
import com.ixuea.courses.mymusic.util.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: xpf
 * time: 2020/2/5 7:20
 * describe: 登录界面
 */
public class LoginActivity extends BaseTitleActivity {
    private static final String TAG = "LoginActivity";
    /**
     * 用户名输入框
     */
    @BindView(R.id.et_username)
    EditText et_username;

    /**
     * 密码输入框
     */
    @BindView(R.id.et_password)
    EditText et_password;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * 登录按钮点击了
     */
    @OnClick(R.id.bt_login)
    public void onLoginClick(Button view) {
        LogUtil.d(TAG, "onLoginClick");

        //测试网络请求
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //让retrofit使用okHttp
                .client(okHttpClientBuilder.build())
                //api地址
                .baseUrl(Constant.ENDPOINT)
                //适配RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //使用Gson解析json
                .addConverterFactory(GsonConverterFactory.create())
                //创建retrofit
                .build();

        //创建service
        Service service = retrofit.create(Service.class);

        //请求歌单详情
        service.sheetDetail("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SheetDetailWrapper>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    //请求成功
                    @Override
                    public void onNext(SheetDetailWrapper sheetDetailWrapper) {
                        LogUtil.d(TAG, "request sheet detail success:" + sheetDetailWrapper.getData().getTitle());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        LogUtil.d(TAG, "request sheet detail success:" + e.getLocalizedMessage());

                        //判断错误类型
                        if (e instanceof UnknownHostException) {
                            ToastUtil.errorShortToast(R.string.error_network_unknown_host);
                        } else if (e instanceof ConnectException) {
                            ToastUtil.errorShortToast(R.string.error_network_connect);
                        } else if (e instanceof SocketTimeoutException) {
                            ToastUtil.errorShortToast(R.string.error_network_timeout);
                        } else if (e instanceof HttpException) {
                            HttpException exception = (HttpException) e;

                            //获取响应码
                            int code = exception.code();

                            if (code == 401) {
                                ToastUtil.errorShortToast(R.string.error_network_not_auth);
                            } else if (code == 403) {
                                ToastUtil.errorShortToast(R.string.error_network_not_permission);
                            } else if (code == 404) {
                                ToastUtil.errorShortToast(R.string.error_network_not_found);
                            } else if (code > 500) {
                                ToastUtil.errorShortToast(R.string.error_network_server);
                            } else {
                                ToastUtil.errorShortToast(R.string.error_network_unknown);
                            }
                        } else {
                            ToastUtil.errorShortToast(R.string.error_network_unknown);
                        }

                    }

                    @Override
                    public void onComplete() {

                    }
                });





        /*//获取用户名
        String username = et_username.getText().toString().trim();
        if (StringUtils.isBlank(username)) {
            LogUtil.w(TAG, "onLoginClick user empty");
            //Toast.makeText(getMainActivity(), R.string.enter_username, Toast.LENGTH_SHORT).show();
            ToastUtil.errorShortToast(R.string.enter_username);
            return;
        }


         //验证用户名格式
         //手机号或邮箱
        if (!(StringUtil.isPhone(username) || StringUtil.isEmail(username))) {
            ToastUtil.errorShortToast(R.string.error_username_format);
            return;
        }

        //获取密码
        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            LogUtil.w(TAG, "onLoginClick");
//            Toast.makeText(getMainActivity(), R.string.enter_password, Toast.LENGTH_SHORT).show();
            ToastUtil.errorShortToast(R.string.enter_password);
            return;
        }

        //校验密码格式
        if (!StringUtil.isPassword(password)) {
            ToastUtil.errorShortToast(R.string.error_password_format);
            return;
        }


        // TODO: 2020/2/6 调用登录方法
        ToastUtil.successShortToast(R.string.login_success);*/
    }

    /**
     * 忘记密码按钮点击了
     */
    @OnClick(R.id.bt_forget_password)
    public void onForgetPasswordClick() {
        LogUtil.w(TAG, "onForgetPasswordClick");
    }

}
