package com.example.olayg.comcastchallenge.module

import com.example.olayg.comcastchallenge.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app
}