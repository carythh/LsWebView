package com.xls.lsweb.loadsir

import android.content.Context
import android.view.View
import com.kingja.loadsir.callback.Callback
import com.xls.lsweb.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class LottieLoadingCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_lottie_loading
    }

    override fun onReloadEvent(
        context: Context,
        view: View
    ): Boolean {
        return true
    }
}