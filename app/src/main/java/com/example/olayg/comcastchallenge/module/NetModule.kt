package com.example.olayg.comcastchallenge.module

import android.app.Application
import android.preference.PreferenceManager
import com.example.olayg.comcastchallenge.BuildConfig
import com.example.olayg.comcastchallenge.RemoteDataSource
import com.example.olayg.comcastchallenge.log
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {


/*
    @Provides @Singleton
    internal fun providePreferences(application: Application) = PreferenceManager.getDefaultSharedPreferences(application)!!
*/

    @Provides @Singleton
    internal fun providesGson(): Gson =
            GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

    @Provides
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }


    @Provides @Singleton
    internal fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit{
        val url: String = if (BuildConfig.FLAVOR.toLowerCase().contains("simpons"))
            "http://api.duckduckgo.com/?q=simpsons+characters&format=json"
        else
            "http://api.duckduckgo.com/?q=the+wire+characters&format=json"

        url.log()
        return  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .client(client)
                .build()

    }


    @Provides @Singleton
    internal fun provideRemoteDataSource(retrofit: Retrofit): RemoteDataSource = RemoteDataSource(retrofit)


}