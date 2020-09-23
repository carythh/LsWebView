package com.xls.lsweb.loadsir

import com.kingja.loadsir.callback.Callback
import com.xls.lsweb.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:20
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class ErrorCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_error
    }
}