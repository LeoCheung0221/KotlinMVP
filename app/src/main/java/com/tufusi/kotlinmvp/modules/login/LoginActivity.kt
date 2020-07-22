package com.tufusi.kotlinmvp.modules.login

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.tufusi.kotlinmvp.MainActivity
import com.tufusi.kotlinmvp.R
import com.tufusi.kotlinmvp.base.BaseActivity
import com.tufusi.kotlinmvp.entity.LoginRegisterResponse
import com.tufusi.kotlinmvp.modules.login.impl.LoginPresenterImpl
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun createP(): LoginPresenter = LoginPresenterImpl(this)

    override fun initView() {
        hideActionBar()
    }

    override fun initListener() {
        user_login_bt.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString()
                val password = user_password_et.text.toString()

                presenter.loginAction(this@LoginActivity, userName, password)
            }
        }
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()

        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailure(errorMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
    }
}