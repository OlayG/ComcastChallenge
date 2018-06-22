package com.example.olayg.comcastchallenge.view.mainactivity

import com.example.olayg.comcastchallenge.CustomScope
import com.example.olayg.comcastchallenge.component.NetComponent
import dagger.Component

@CustomScope
@Component( dependencies = [(NetComponent::class)], modules = [(MainActivityModule::class)])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}