package com.tufusi.kotlinmvp.modules.login

import com.tufusi.kotlinmvp.entity.LoginRegisterResponse

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
interface LoginView {

    fun loginSuccess(loginBean: LoginRegisterResponse?)

    fun loginFailure(errorMsg: String?)
}