package com.xls.lsweb

interface LsCallback{

    fun onProgressChanged(progress: Int)

    fun updateTitle(title:String?)

    fun onError(errorMsg:String?)

    fun onPageStarted(url:String?)

    fun onPageFinished(url:String?)

}