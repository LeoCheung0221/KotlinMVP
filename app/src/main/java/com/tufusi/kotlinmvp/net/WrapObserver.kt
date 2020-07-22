package com.tufusi.kotlinmvp.net

import android.content.Context
import com.tufusi.kotlinmvp.entity.BaseResponse
import com.tufusi.kotlinmvp.view.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description 自定义RxJava操作符
 */
abstract class WrapObserver<T>(val context: Context) : Observer<BaseResponse<T>> {

    private var isShow: Boolean = true

    //次构造
    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShow = isShow
    }

    abstract fun onSuccess(data: T?)

    abstract fun onFailure(errorMsg: String?)

    override fun onSubscribe(d: Disposable) {
        if (isShow) {
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: BaseResponse<T>) {
        if (t.data == null) {
            onFailure("哎呀，请求出错啦：${t.errorMsg}")
        } else {
            onSuccess(t.data)
        }
    }

    override fun onError(e: Throwable) {
        LoadingDialog.dismiss()
        onFailure(e.message)
    }

    override fun onComplete() {
        LoadingDialog.dismiss()
    }

}