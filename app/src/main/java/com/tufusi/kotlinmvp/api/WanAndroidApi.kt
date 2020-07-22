package com.tufusi.kotlinmvp.api

import com.tufusi.kotlinmvp.entity.BaseResponse
import com.tufusi.kotlinmvp.entity.LoginRegisterResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description 客户端api接口类
 */
interface WanAndroidApi {

    /**
     * 登录
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): Observable<BaseResponse<LoginRegisterResponse>>

    /**
     * 注册
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<BaseResponse<LoginRegisterResponse>>

}