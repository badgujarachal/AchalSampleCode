package com.achal.test.network.retrofit



import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRequest {

    private var retrofit: Retrofit? = null
    val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return this!!.retrofit
        }
}
