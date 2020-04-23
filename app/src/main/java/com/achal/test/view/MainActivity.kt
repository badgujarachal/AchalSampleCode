package com.achal.test.view




import android.os.Bundle
import android.view.View
import android.widget.ProgressBar

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.achal.test.R
import com.achal.test.adapter.CanadaArticleAdapter
import com.achal.test.model.Canada
import com.achal.test.view_model.CanadaArticleViewModel
import java.util.*



class MainActivity : AppCompatActivity() {
    private var my_recycler_view: RecyclerView? = null
    private var progress_circular_movie_article: ProgressBar? = null
    private var layoutManager: LinearLayoutManager? = null
    private var adapter: CanadaArticleAdapter? = null
    private val articleArrayList = ArrayList<Canada>()
    internal lateinit var articleViewModel: CanadaArticleViewModel

    companion object {

        private val TAG = MainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
                        supportFragmentManager
                    .beginTransaction()
                    .add(com.achal.test.R.id.frame_container, ArticlesFragment.newInstance(), "dogList")
                    .commit()
        }


    }


    }






