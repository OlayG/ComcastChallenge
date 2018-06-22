package com.example.olayg.comcastchallenge.view.searchactivity

import com.example.olayg.comcastchallenge.CustomScope
import com.example.olayg.comcastchallenge.component.NetComponent
import dagger.Component

@CustomScope
@Component( dependencies = [(NetComponent::class)], modules = [(SearchActivityModule::class)])
interface SearchActivityComponent {
    fun inject(searchCharacterActivity: SearchCharacterActivity)
}