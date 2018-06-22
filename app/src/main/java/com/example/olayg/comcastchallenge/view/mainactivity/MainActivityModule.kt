package com.example.olayg.comcastchallenge.view.mainactivity

import com.example.olayg.comcastchallenge.CustomScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(val view: MainActivityContract.View) {

    @CustomScope
    @Provides
    internal fun providesCreateUserContractView(): MainActivityContract.View = view
}