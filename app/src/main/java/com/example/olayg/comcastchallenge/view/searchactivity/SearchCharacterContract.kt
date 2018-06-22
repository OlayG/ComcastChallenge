package com.example.olayg.comcastchallenge.view.searchactivity

import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.base.BasePresenter
import com.example.olayg.comcastchallenge.view.base.BaseView

interface SearchCharacterContract {

    interface View : BaseView {
        fun loadData(topics : MutableList<RelatedTopic>)
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}
