package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Maintainer(
        @SerializedName("github")
        @Expose
        var github: String? = null
) : Parcelable