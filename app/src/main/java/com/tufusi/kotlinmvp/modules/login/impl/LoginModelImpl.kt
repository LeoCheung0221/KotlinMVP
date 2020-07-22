package com.tufusi.kotlinmvp.modules.login.impl

import android.content.Context
import android.util.Log
import com.tufusi.kotlinmvp.api.WanAndroidApi
import com.tufusi.kotlinmvp.constant.WanConstants
import com.tufusi.kotlinmvp.entity.LoginRegisterResponse
import com.tufusi.kotlinmvp.modules.login.LoginModule
import com.tufusi.kotlinmvp.modules.login.LoginPresenter
import com.tufusi.kotlinmvp.net.ApiClient
import com.tufusi.kotlinmvp.net.WrapObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description Model层的实现
 */
class LoginModelImpl : LoginModule {

    override fun cancelRequest() {
    }

    override fun login(
        context: Context,
        userName: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        ApiClient.instance.createRetrofit(WanAndroidApi::class.java)
            .loginAction(userName, password)
            .subscribeOn(Schedulers.io()) //分配异步线程处理服务器请求
            .observeOn(AndroidSchedulers.mainThread()) //分配主线程给下面的UI操作
            .subscribe(object : WrapObserver<LoginRegisterResponse>(context) {

                override fun onSuccess(data: LoginRegisterResponse?) {
                    Log.e(WanConstants.TAG, "success: $data")
                    onLoginListener.loginSuccess(data)
                }

                override fun onFailure(errorMsg: String?) {
                    Log.e(WanConstants.TAG, "failure: errorMsg:$errorMsg")
                    onLoginListener.loginFailure(errorMsg)
                }
            })
    }
}