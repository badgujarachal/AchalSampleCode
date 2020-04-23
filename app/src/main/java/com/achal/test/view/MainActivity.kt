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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialization()
        getMovieArticles()
    }

    /**
     * initialization of views and others
     *
     * @param @null
     */
    private fun initialization() {
        progress_circular_movie_article = findViewById<View>(R.id.progress_circular_movie_article) as ProgressBar
        my_recycler_view = findViewById<View>(R.id.my_recycler_view) as RecyclerView

        // use a linear layout manager
        layoutManager = LinearLayoutManager(this@MainActivity)
        my_recycler_view!!.layoutManager = layoutManager

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        my_recycler_view!!.setHasFixedSize(true)

        // adapter
        adapter = CanadaArticleAdapter(this@MainActivity, articleArrayList)
        my_recycler_view!!.adapter = adapter
        // View Model
        articleViewModel = ViewModelProviders.of(this).get(CanadaArticleViewModel::class.java)
    }

    /**
     * get movies articles from news api
     *
     * @param @null
     */
    private fun getMovieArticles() {

        articleViewModel.articleResponseLiveData.observe(this,androidx.lifecycle.Observer {

            if (it != null) {
                setTitle(it!!.title)
                progress_circular_movie_article!!.visibility = View.GONE
                val canadaarticles = it.articles
                if (canadaarticles != null) {
                    articleArrayList.addAll(canadaarticles)
                }
                adapter!!.notifyDataSetChanged()
            }


        })



    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName
    }
}

