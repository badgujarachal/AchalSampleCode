package com.achal.test.network.response



import com.achal.test.model.Canada
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CanadaResponse {

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("rows")
    @Expose
    var articles: List<Canada>? = null
}
