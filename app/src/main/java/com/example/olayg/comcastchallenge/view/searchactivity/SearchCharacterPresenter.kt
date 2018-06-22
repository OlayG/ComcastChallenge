package com.example.olayg.comcastchallenge.view.searchactivity

import com.example.olayg.comcastchallenge.RemoteDataSource
import com.example.olayg.comcastchallenge.Utils
import com.example.olayg.comcastchallenge.models.RelatedTopic
import com.example.olayg.comcastchallenge.models.Shows
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SearchCharacterPresenter@Inject constructor(private val view: SearchCharacterContract.View, private val remoteDataSource: RemoteDataSource)
    : SearchCharacterContract.Presenter {
    override fun getData() {
        remoteDataSource.getCharacters(Utils.getUrl())
                .subscribe(object : Observer<Shows> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(shows: Shows) {
                        view.loadData(shows.relatedTopics as MutableList<RelatedTopic>)
                    }
                    override fun onError(e: Throwable) {}
                    override fun onComplete() {}
                })
    }
}