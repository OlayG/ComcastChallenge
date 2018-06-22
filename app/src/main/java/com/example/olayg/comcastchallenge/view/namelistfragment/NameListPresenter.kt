package com.example.olayg.comcastchallenge.view.namelistfragment

import com.example.olayg.comcastchallenge.RemoteDataSource
import com.example.olayg.comcastchallenge.Utils
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.models.Shows
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class NameListPresenter @Inject constructor(private val view: NameListContract.View, private val remoteDataSource: RemoteDataSource)
    : NameListContract.Presenter{
    override fun getData() {
        remoteDataSource.getCharacters(Utils.getUrl())
                .subscribe(object : Observer<Shows> {
                    override fun onSubscribe(d: Disposable) {
                        view.showProgressBar()
                    }

                    override fun onNext(shows: Shows) {
                        view.loadNameList(shows.relatedTopics as MutableList<RelatedTopic>)
                    }

                    override fun onError(e: Throwable) {
                        view.dismissProgressBar()
                        view.showError(e.localizedMessage)
                    }

                    override fun onComplete() {
                        view.dismissProgressBar()
                    }
                })    }
}