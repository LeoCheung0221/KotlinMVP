package com.tufusi.kotlinmvp.modules.login

import android.content.Context

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
interface LoginModule {

    /**
     * 取消请求
     */
    fun cancelRequest()

    /**
     * 登录请求
     */
    fun login(
        context: Context,
        userName: String,
        password: String,

        onLoginListener: LoginPresenter.OnLoginListener
    )
}