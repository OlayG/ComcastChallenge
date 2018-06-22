package com.example.olayg.comcastchallenge.view.searchactivity

import com.example.olayg.comcastchallenge.CustomScope
import dagger.Module
import dagger.Provides

@Module
class SearchActivityModule(val view: SearchCharacterContract.View) {

    @CustomScope
    @Provides
    internal fun providesSearchCharacterContractView(): SearchCharacterContract.View = view
}