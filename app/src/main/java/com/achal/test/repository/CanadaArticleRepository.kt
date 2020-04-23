package com.achal.test.repository




import android.util.Log

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.achal.test.network.response.CanadaResponse
import com.achal.test.network.retrofit.ApiRequest
import com.achal.test.network.retrofit.RetrofitRequest


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CanadaArticleRepository {
    private val apiRequest: ApiRequest

    init {
        apiRequest = RetrofitRequest.retrofitInstance!!.create(ApiRequest::class.java)

    }

    companion object {
        private val TAG = CanadaArticleRepository::class.java.simpleName
    }
    val movieArticles: LiveData<CanadaResponse>
        get() {
            val data = MutableLiveData<CanadaResponse>()
            apiRequest.movieArticles
                      .enqueue(object : Callback<CanadaResponse> {


                        override fun onResponse(call: Call<CanadaResponse>, response: Response<CanadaResponse>) {
                            Log.d(TAG, "onResponse response:: $response")


                            if (response.body() != null) {
                                data.setValue(response.body())
                                Log.d(TAG, "articles size:: " + response.body()!!.title)
                                Log.d(TAG, "articles title pos 0:: " + response.body()!!.articles?.get(0)?.title)
                            }
                        }

                        override fun onFailure(call: Call<CanadaResponse>, t: Throwable) {
                            data.setValue(null)
                        }
                    })
            return data
        }


}
