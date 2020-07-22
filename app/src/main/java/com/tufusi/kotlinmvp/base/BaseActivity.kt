package com.tufusi.kotlinmvp.base

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description 基类 MVP架构
 */
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {

    /**
     * 定义懒加载变量 - P
     */
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        presenter = createP()
        //由子类去判断要不要覆写
        initView()
        initListener()
        initData()
    }

    open fun initData() {
    }

    open fun initView() {
    }

    open fun initListener() {
    }

    fun showActionBar() {
        supportActionBar?.show()
    }

    fun hideActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

    /**
     * 子类布局ID提供
     */
    abstract fun getLayoutId(): Int

    /**
     * 由子类提供各自的Presenter实现类
     */
    abstract fun createP(): P

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}