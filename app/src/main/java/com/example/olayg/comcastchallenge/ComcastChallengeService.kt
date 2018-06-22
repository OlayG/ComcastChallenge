package com.example.olayg.comcastchallenge

import com.example.olayg.comcastchallenge.models.Shows
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ComcastChallengeService {
    @GET
    fun getCharacters(@Url url: String) : Observable<Shows>
}