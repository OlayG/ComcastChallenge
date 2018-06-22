package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Icon(@SerializedName("URL")
                @Expose
                var uRL: String? = null,
                @SerializedName("Width")
                @Expose
                var width: String? = null,
                @SerializedName("Height")
                @Expose
                var height: String? = null
) : Parcelable