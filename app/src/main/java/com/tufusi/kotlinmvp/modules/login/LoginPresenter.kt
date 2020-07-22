package com.tufusi.kotlinmvp.modules.login

import android.content.Context
import com.tufusi.kotlinmvp.base.IBasePresenter
import com.tufusi.kotlinmvp.entity.LoginRegisterResponse

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
interface LoginPresenter : IBasePresenter {

    //登录
    fun loginAction(context: Context, userName: String, password: String)

    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFailure(errorMsg: String?)
    }

}