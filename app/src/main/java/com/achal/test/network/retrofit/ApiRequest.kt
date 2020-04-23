package com.achal.test.network.retrofit

import com.achal.test.network.response.CanadaResponse



import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @get:GET("facts.json")
    val movieArticles: Call<CanadaResponse>
}
