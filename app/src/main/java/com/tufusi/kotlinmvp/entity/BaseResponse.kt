package com.tufusi.kotlinmvp.entity

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description
 */
data class BaseResponse<T>(val data: T, val errorCode: Int, val errorMsg: String)