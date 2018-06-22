package com.example.olayg.comcastchallenge

import com.example.olayg.comcastchallenge.models.Shows
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class RemoteDataSource(retrofit: Retrofit) : ComcastChallengeService {
    private val api = retrofit.create(ComcastChallengeService::class.java)

    override fun getCharacters(url: String): Observable<Shows> =
            api.getCharacters(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
}