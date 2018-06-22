package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SrcOptions(
        @SerializedName("FirstURL")
        @Expose
        var firstURL: String? = null,
        @SerializedName("Icon")
        @Expose
        var icon: Icon? = null,
        @SerializedName("Text")
        @Expose
        var text: String? = null,
        @SerializedName("Result")
        @Expose
        var result: String? = null
) : Parcelable