package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Developer(@SerializedName("url")
                     @Expose
                     var url: String? = null,
                     @SerializedName("type")
                     @Expose
                     var type: String? = null,
                     @SerializedName("name")
                     @Expose
                     var name: String? = null
) : Parcelable