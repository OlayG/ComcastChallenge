package com.example.olayg.comcastchallenge

import android.app.Application
import com.example.olayg.comcastchallenge.component.DaggerNetComponent
import com.example.olayg.comcastchallenge.component.NetComponent
import com.example.olayg.comcastchallenge.module.AppModule
import com.example.olayg.comcastchallenge.module.NetModule

class App : Application() {
    private val component: NetComponent by lazy {
        DaggerNetComponent
                .builder()
                .netModule(NetModule())
                .appModule(AppModule(this))
                .build()
    }

    fun getNetComponent() = component
}