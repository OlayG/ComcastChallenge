package com.example.olayg.comcastchallenge.view.namelistfragment

import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.view.base.BasePresenter
import com.example.olayg.comcastchallenge.view.base.BaseView

interface NameListContract {
    interface View : BaseView {
        fun loadNameList(topics : MutableList<RelatedTopic>)
        fun dismissProgressBar()
        fun showProgressBar()
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}