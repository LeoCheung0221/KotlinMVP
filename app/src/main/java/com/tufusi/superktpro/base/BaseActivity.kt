package com.tufusi.superktpro.base

import android.os.Bundle
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import java.io.Serializable

/**
 * File: BaseActivity.java
 * Author: leocheung
 * Version: V100R001C01
 * Create: 2020/6/30 1:22 PM
 * Description:
 *
 * Changes (from 2020/6/30)
 * -----------------------------------------------------------------
 * 2020/6/30 : Create BaseActivity.java (leocheung);
 * -----------------------------------------------------------------
 */
abstract class BaseActivity<P> : RxAppCompatActivity() where P : IBasePresenter, P : Serializable {

    /**
     * 懒加载实现层
     */
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun createPresenter(): P

}