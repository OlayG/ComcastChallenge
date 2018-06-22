package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.example.olayg.comcastchallenge.AdapterConstants
import com.example.olayg.comcastchallenge.ViewType
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class RelatedTopic(
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
) : Parcelable, ViewType {
        override fun getViewType(): Int = AdapterConstants.RELATED_TOPICS
}
