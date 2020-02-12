package com.ixuea.courses.mymusic.network;

import com.ixuea.courses.mymusic.bean.SheetDetailWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * author: xpf
 * time: 2020/2/10 6:58
 * describe: 网络接口配置
 * 之所以调用接口还能返回数据
 * 是因为Retrofit框架内部处理了
 * 这里不讲解原理
 * 在《详解Retrofit》课程中讲解
 */
public interface Service {
    @GET("v1/sheets/{id}")
    Observable<SheetDetailWrapper> sheetDetail(@Path("id") String id);
}
