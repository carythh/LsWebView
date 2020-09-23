package com.xls.lsweb

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.xls.lsweb.utils.Constants
import kotlinx.android.synthetic.main.activity_lswebview.*

class LsWebViewActivity :AppCompatActivity(){

    var mUrl:String? = null
    var mTitle:String? = ""
    var isShowActionBar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lswebview)
        parseIntentArguments()
        if(isShowActionBar){
            rvBar.visibility = View.VISIBLE
            tvTitle.text = mTitle
            ivBack.setOnClickListener{
                finish()
            }
        }else{
            rvBar.visibility = View.GONE
        }
        supportFragmentManager.apply {
            val transaction = this.beginTransaction()
            val fragment = LsWebViewFragment.newInstance(mUrl)
            transaction.replace(R.id.webContainer,fragment)
            transaction.commitNow()
        }
    }






    private fun parseIntentArguments(){
        intent?.let {
            mUrl = it.getStringExtra(Constants.KEY_URL)
            mTitle = it.getStringExtra(Constants.KEY_TITLE)
            isShowActionBar = it.getBooleanExtra(Constants.KEY_SHOW_ACTION_BAR,false)
        }

    }


}