package com.example.olayg.comcastchallenge.component

import com.example.olayg.comcastchallenge.App
import com.example.olayg.comcastchallenge.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton @Component( modules = [(AppModule::class)])
interface AppComponent {
    fun inject(app: App)
}