package com.xls.lsweb.loadsir

import com.kingja.loadsir.callback.Callback
import com.xls.lsweb.R

/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_empty
    }
}