package com.example.olayg.comcastchallenge.component

import com.example.olayg.comcastchallenge.RemoteDataSource
import com.example.olayg.comcastchallenge.module.AppModule
import com.example.olayg.comcastchallenge.module.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [(AppModule::class), (NetModule::class)])
interface NetComponent {
    fun remoteDataSource() : RemoteDataSource
}