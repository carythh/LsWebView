package com.example.lswebview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.common.autoservice.IWebViewService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object{
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