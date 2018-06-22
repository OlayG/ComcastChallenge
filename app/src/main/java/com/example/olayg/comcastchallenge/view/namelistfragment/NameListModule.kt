package com.example.olayg.comcastchallenge.view.namelistfragment

import com.example.olayg.comcastchallenge.CustomScope
import dagger.Module
import dagger.Provides

@Module
class NameListModule(val view: NameListContract.View) {

    @CustomScope
    @Provides
    internal fun proviesNameListContractView(): NameListContract.View = view
}