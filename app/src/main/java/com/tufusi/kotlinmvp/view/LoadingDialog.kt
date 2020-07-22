package com.tufusi.kotlinmvp.view

import android.app.Dialog
import android.content.Context
import com.tufusi.kotlinmvp.R

/**
 * Created by 鼠夏目 on 2020/7/22.
 * @author 鼠夏目
 * @see
 * @description 加载进度框  object: 既没有主构造 也没有次构造
 */
object LoadingDialog {

    private var dialog: Dialog? = null

    fun show(context: Context) {
        dismiss()

        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog!!.show()
    }

    fun dismiss() {
        dialog?.dismiss()
    }

}