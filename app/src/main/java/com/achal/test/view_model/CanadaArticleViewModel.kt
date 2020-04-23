package com.achal.test.view_model

import com.achal.test.network.response.CanadaResponse


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.achal.test.repository.CanadaArticleRepository


class CanadaArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val articleRepository: CanadaArticleRepository
    val articleResponseLiveData: LiveData<CanadaResponse>

    init {

        articleRepository = CanadaArticleRepository()
        this.articleResponseLiveData = articleRepository.movieArticles
    }
}
