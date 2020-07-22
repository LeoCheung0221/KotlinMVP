package com.tufusi.kotlinmvp.modules.login.impl

import android.content.Context
import com.tufusi.kotlinmvp.entity.LoginRegisterResponse
import com.tufusi.kotlinmvp.modules.login.LoginPresenter
import com.tufusi.kotlinmvp.modules.login.LoginView

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    private val loginModel: LoginModelImpl = LoginModelImpl()

    /**
     * 处理具体的网络请求相关的业务逻辑
     */
    override fun loginAction(context: Context, userName: String, password: String) {
        loginModel.login(context, userName, password, this)
    }

    override fun detachView() {
        loginView = null
        loginModel.cancelRequest()
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg)
    }
}