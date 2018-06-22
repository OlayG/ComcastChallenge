package com.example.olayg.comcastchallenge.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Meta(
        @SerializedName("tab")
        @Expose
        var tab: String? = null,
        @SerializedName("src_id")
        @Expose
        var srcId: Int = 0,
        @SerializedName("live_date")
        @Expose
        var liveDate: @RawValue Any? = null,
        @SerializedName("dev_date")
        @Expose
        var devDate: @RawValue Any? = null,
        @SerializedName("dev_milestone")
        @Expose
        var devMilestone: String? = null,
        @SerializedName("example_query")
        @Expose
        var exampleQuery: String? = null,
        @SerializedName("unsafe")
        @Expose
        var unsafe: Int = 0,
        @SerializedName("perl_module")
        @Expose
        var perlModule: String? = null,
        @SerializedName("description")
        @Expose
        var description: String? = null,
        @SerializedName("created_date")
        @Expose
        var createdDate: @RawValue Any? = null,
        @SerializedName("src_url")
        @Expose
        var srcUrl: @RawValue Any? = null,
        @SerializedName("status")
        @Expose
        var status: String? = null,
        @SerializedName("attribution")
        @Expose
        var attribution: @RawValue Any? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("producer")
        @Expose
        var producer: @RawValue Any? = null,
        @SerializedName("id")
        @Expose
        var id: String? = null,
        @SerializedName("src_options")
        @Expose
        var srcOptions: SrcOptions? = null,
        @SerializedName("is_stackexchange")
        @Expose
        var isStackexchange: @RawValue Any? = null,
        @SerializedName("maintainer")
        @Expose
        var maintainer: Maintainer? = null,
        @SerializedName("src_name")
        @Expose
        var srcName: String? = null,
        @SerializedName("designer")
        @Expose
        var designer: @RawValue Any? = null,
        @SerializedName("signal_from")
        @Expose
        var signalFrom: String? = null,
        @SerializedName("repo")
        @Expose
        var repo: String? = null,
        @SerializedName("topic")
        @Expose
        var topic: List<String>? = null,
        @SerializedName("blockgroup")
        @Expose
        var blockgroup: @RawValue Any? = null,
        @SerializedName("src_domain")
        @Expose
        var srcDomain: String? = null,
        @SerializedName("production_state")
        @Expose
        var productionState: String? = null,
        @SerializedName("js_callback_name")
        @Expose
        var jsCallbackName: String? = null,
        @SerializedName("developer")
        @Expose
        var developer: List<Developer>? = null

) : Parcelable