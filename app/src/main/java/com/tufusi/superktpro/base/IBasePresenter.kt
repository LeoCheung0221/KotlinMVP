package com.tufusi.superktpro.base

/**
 * File: IBasePresenter.java
 * Author: leocheung
 * Version: V100R001C01
 * Create: 2020/6/30 1:24 PM
 * Description:
 *
 * Changes (from 2020/6/30)
 * -----------------------------------------------------------------
 * 2020/6/30 : Create IBasePresenter.java (leocheung);
 * -----------------------------------------------------------------
 */
interface IBasePresenter {
    fun attachView();
    fun detachView();
}