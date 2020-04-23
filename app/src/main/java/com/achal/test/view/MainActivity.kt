package com.achal.test.view




import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
        setContentView(com.achal.test.R.layout.activity_main)

        if (savedInstanceState == null) {
                        supportFragmentManager
                    .beginTransaction()
                    .add(com.achal.test.R.id.frame_container, ArticlesFragment.newInstance(), "dogList")
                    .commit()
        }


    }

//    override fun onCreateOptionsMenu(
//            menu: Menu, inflater: MenuInflater) {
//       // setHasOptionsMenu(true)
//        inflater.inflate(com.achal.test.R.menu.main, menu)
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        //this.optionsMenu = menu;
//        //MenuInflater inflater = getMenuInflater(); //ERROR<-----------
//        menuInflater.inflate(com.achal.test.R.menu.main, menu)
//        //return super.onCreateOptionsMenu(menu); // in Fragment cannot be applied <------------
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//
//      //  getMovieArticles()
//        return super.onOptionsItemSelected(item)
//    }




    }






