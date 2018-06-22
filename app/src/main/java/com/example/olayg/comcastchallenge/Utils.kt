package com.example.olayg.comcastchallenge

object Utils {

    fun getUrl(): String {
        return if (BuildConfig.FLAVOR.toLowerCase().contains("simpons"))
            "http://api.duckduckgo.com/?q=simpsons+characters&format=json"
        else
            "http://api.duckduckgo.com/?q=the+wire+characters&format=json"
    }
}