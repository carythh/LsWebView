package com.example.lswebview

import com.example.common.BaseApplication
import com.kingja.loadsir.core.LoadSir
import com.xls.lsweb.loadsir.*

class LsApplication :BaseApplication(){

    override fun onCreate() {
        super.onCreate()
        initLoadSir()
    }


    private fun initLoadSir(){
        LoadSir.beginBuilder()
            .addCallback(ErrorCallback())
            .addCallback(EmptyCallback())
            .addCallback(LoadingCallback())
            .addCallback(TimeoutCallback())
            .addCallback(CustomCallback())
            .setDefaultCallback(LoadingCallback::class.java)
            .commit()
    }
}