package com.xls.lsweb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.xls.lsweb.chromeclient.LsWebChromeClient
import com.xls.lsweb.loadsir.ErrorCallback
import com.xls.lsweb.loadsir.LoadingCallback
import com.xls.lsweb.utils.Constants
import com.xls.lsweb.viewclient.LsWebViewClient
import kotlinx.android.synthetic.main.fragment_web.view.*

class LsWebViewFragment:Fragment(),LsCallback{

    var mUrl:String? = ""
    lateinit var mWebView:WebView
    lateinit var mRefreshLayout: SwipeRefreshLayout
    private var mLoadService:LoadService<*>? = null
    var mIsError = false

    companion object{

        @JvmStatic
        fun newInstance(url:String?):LsWebViewFragment {
            val args = Bundle()
            args.putString(Constants.KEY_URL,url)
            val fragment = LsWebViewFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mUrl = it.getString(Constants.KEY_URL)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.fragment_web, container,false)
        mWebView = contentView.webView
        mRefreshLayout = contentView.webRootSrl
        configWebView(mWebView)
        initRefresh(mRefreshLayout)
        mWebView.loadUrl(mUrl)
        mLoadService = LoadSir.getDefault().register(mRefreshLayout) { mWebView.reload() }
        return mLoadService!!.loadLayout
    }

    private fun initRefresh(refreshLayout: SwipeRefreshLayout){
        refreshLayout.setOnRefreshListener(object :SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                mWebView.reload()
            }
        })
    }

    private fun configWebView(webView: WebView?){
        if(webView==null){
            Log.e(Constants.TAG,"configWebView exception,webView is null")
            return
        }
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.webChromeClient = LsWebChromeClient(this)
        webView.webViewClient = LsWebViewClient(this)

    }




    override fun onProgressChanged(progress: Int) {

    }

    override fun updateTitle(title: String?) {

    }

    override fun onError(errorMsg: String?) {
        mIsError = true
    }

    override fun onPageStarted(url: String?) {
        mLoadService?.showCallback(LoadingCallback::class.java)
    }

    override fun onPageFinished(url: String?) {

        if(mRefreshLayout.isRefreshing){
            mRefreshLayout.isRefreshing = false
        }
        if(mIsError){
            mLoadService?.showCallback(ErrorCallback::class.java)
        }else{
            mLoadService?.showSuccess()
        }


        mIsError = false
    }
}