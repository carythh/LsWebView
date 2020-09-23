package com.xls.lsweb.service

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.common.autoservice.IWebViewService
import com.google.auto.service.AutoService
import com.xls.lsweb.LsWebViewActivity
import com.xls.lsweb.LsWebViewFragment
import com.xls.lsweb.utils.Constants

@AutoService(IWebViewService::class)
class WebViewServiceImpl : IWebViewService{

    override fun startWebViewActivity(
        context: Context?,
        url: String?,
        title: String?,
        isShowActionBar: Boolean
    ) {

        if(context!=null){
            context.startActivity(Intent(context, LsWebViewActivity::class.java).apply {
                this.putExtra(Constants.KEY_URL,url)
                this.putExtra(Constants.KEY_TITLE,title)
                this.putExtra(Constants.KEY_SHOW_ACTION_BAR,isShowActionBar)
            })
        }else{
           Log.e(Constants.TAG,"startWebViewActivity failed,context is null")
        }

    }

    override fun getWebViewFragment(url: String?): Fragment {
        return LsWebViewFragment.newInstance(url)
    }
}