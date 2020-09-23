package com.xls.lsweb.viewclient

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.util.Log
import android.webkit.*
import com.xls.lsweb.LsCallback
import com.xls.lsweb.utils.Constants

class LsWebViewClient(private val callback: LsCallback?) :WebViewClient(){

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        Log.i(Constants.TAG,"onPageStarted")
        callback?.onPageStarted(url)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        Log.i(Constants.TAG,"onPageFinished")
        callback?.onPageFinished(url)
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        val errorMsg = if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            "onReceivedError url = ${request?.url} error = (${error?.errorCode},${error?.description})"
        }else{
            "onReceivedError url = ${request?.url} )"
        }
        Log.e(Constants.TAG,errorMsg)
        callback?.onError(errorMsg)
    }

    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        super.onReceivedHttpError(view, request, errorResponse)
        Log.e(Constants.TAG,"onReceivedHttpError url = ${request?.url} errorCode = ${errorResponse?.statusCode}")
        callback?.onError("onReceivedHttpError url = ${request?.url} errorCode = ${errorResponse?.statusCode}")
    }

    override fun onReceivedSslError(
        view: WebView?,
        handler: SslErrorHandler?,
        error: SslError?
    ) {
        super.onReceivedSslError(view, handler, error)
        Log.e(Constants.TAG,"onReceivedSslError error = ${error.toString()}")
        callback?.onError("onReceivedSslError error = ${error.toString()}")
    }


}