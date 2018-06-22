package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.example.olayg.comcastchallenge.AdapterConstants
import com.example.olayg.comcastchallenge.ViewType
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Shows(@SerializedName("meta")
                    @Expose
                    var meta: Meta? = null,
                 @SerializedName("DefinitionSource")
                    @Expose
                    var definitionSource: String? = null,
                 @SerializedName("RelatedTopics")
                    @Expose
                    var relatedTopics: List<RelatedTopic>? = null,
                 @SerializedName("Image")
                    @Expose
                    var image: String? = null,
                 @SerializedName("AnswerType")
                    @Expose
                    var answerType: String? = null,
                 @SerializedName("Infobox")
                    @Expose
                    var infobox: String? = null,
                 @SerializedName("Answer")
                    @Expose
                    var answer: String? = null,
                 @SerializedName("ImageHeight")
                    @Expose
                    var imageHeight: Int = 0,
                 @SerializedName("AbstractURL")
                    @Expose
                    var abstractURL: String? = null,
                 @SerializedName("ImageWidth")
                    @Expose
                    var imageWidth: Int = 0,
                 @SerializedName("AbstractSource")
                    @Expose
                    var abstractSource: String? = null,
                 @SerializedName("Redirect")
                    @Expose
                    var redirect: String? = null,
                 @SerializedName("Type")
                    @Expose
                    var type: String? = null,
                 @SerializedName("Definition")
                    @Expose
                    var definition: String? = null,
                 @SerializedName("DefinitionURL")
                    @Expose
                    var definitionURL: String? = null,
                 @SerializedName("Results")
                    @Expose
                    var results: @RawValue List<Any>? = null,
                 @SerializedName("AbstractText")
                    @Expose
                    var abstractText: String? = null,
                 @SerializedName("ImageIsLogo")
                    @Expose
                    var imageIsLogo: Int = 0,
                 @SerializedName("Heading")
                    @Expose
                    var heading: String? = null,
                 @SerializedName("Entity")
                    @Expose
                    var entity: String? = null,
                 @SerializedName("Abstract")
                    @Expose
                    var _abstract: String? = null
) : Parcelable, ViewType {
    override fun getViewType(): Int = AdapterConstants.SHOWS
}