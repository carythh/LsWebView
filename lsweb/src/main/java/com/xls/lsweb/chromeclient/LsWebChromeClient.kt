package com.xls.lsweb.chromeclient

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.xls.lsweb.LsCallback
import com.xls.lsweb.utils.Constants

class LsWebChromeClient(private val callback:LsCallback?) :WebChromeClient(){

    var lastProgress = 0

    /**
     * 进度到了100，可能出现多次回调（一般为2次）
     */
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        Log.i(Constants.TAG,"onProgressChanged : $newProgress")
        if(newProgress==lastProgress && newProgress==100){
            //解决重复回调
        }else{
            callback?.onProgressChanged(newProgress)
        }
        lastProgress = newProgress
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
       Log.i(Constants.TAG,"onReceivedTitle : $title")
        callback?.updateTitle(title)
    }

    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        Log.i(Constants.TAG,"onReceivedIcon : $icon")
    }

}