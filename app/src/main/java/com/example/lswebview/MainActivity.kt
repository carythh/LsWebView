package com.example.lswebview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.autoservice.IWebViewService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val url1 = "https://test.hdkj.zmlearn.com/zmpark/web-mobile/index.html?device=aPad&msgSendModle=jsb&env=test&userId=1326319398&token=eyJhbGciOiJSUzI1NiJ9.eyJqdGkiOiJmWVhuSlZwYVZMd1I0VmJWVnRESnVBPT0iLCJmcm9tIjoiS2lkc1BhZCIsIm5iZiI6MTYwMDgzMDk4OX0.OepxWJ48rYuYlkt3BA6OZJZmSC2iimfkY6W6JAy37ZRz3b1ayABsLyDCBukvUBqrEXXCS3-PBg-I58mEjPUxsKQ9m9uosDIhdZhhjWhAMuxhsK4CDOmA-FBiiuQcnn4WcNqDSS_6_pIUSah0sfzpTc9B_LNR3u_bvgqq-qVaNGg"
        const val url2 = "https://www.baidu.com"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myButton.setOnClickListener {
            val service = ServiceLoader.load(IWebViewService::class.java).iterator().next()
            service.startWebViewActivity(this@MainActivity,url2,"学习乐园",false)
        }
    }
}