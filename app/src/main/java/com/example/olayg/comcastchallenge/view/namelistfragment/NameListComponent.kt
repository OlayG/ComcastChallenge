package com.example.olayg.comcastchallenge.view.namelistfragment

import com.example.olayg.comcastchallenge.CustomScope
import com.example.olayg.comcastchallenge.component.NetComponent
import dagger.Component

@CustomScope
@Component(dependencies = [(NetComponent::class)], modules = [(NameListModule::class)])
interface NameListComponent {
    fun inject(nameListFragment: NameListFragment)
}