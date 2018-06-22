package com.example.olayg.comcastchallenge.view.mainactivity

import com.example.olayg.comcastchallenge.RemoteDataSource
import com.example.olayg.comcastchallenge.Utils
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.models.Shows
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(private val view: MainActivityContract.View, private val remoteDataSource: RemoteDataSource)
    : MainActivityContract.Presenter {

/*
     fun getData() {
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
                })
    }
*/

}