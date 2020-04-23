package com.achal.test.view

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.achal.test.R
import com.achal.test.adapter.CanadaArticleAdapter
import com.achal.test.model.Canada
import com.achal.test.view_model.CanadaArticleViewModel
import java.util.ArrayList

import android.view.*


class ArticlesFragment : Fragment() {
    private var my_recycler_view: RecyclerView? = null
    private var progress_circular_movie_article: ProgressBar? = null
    private var layoutManager: LinearLayoutManager? = null
    private var adapter: CanadaArticleAdapter? = null
    private val articleArrayList = ArrayList<Canada>()
    internal lateinit var articleViewModel: CanadaArticleViewModel


    companion object {

        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = return inflater.inflate(R.layout.fragment_main, null, false)

    }

    override fun onCreateOptionsMenu(
            menu: Menu, inflater: MenuInflater) {

        inflater.inflate(com.achal.test.R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }


    //This is a redundant code .As we are using livedata no explicit refresh required

    //Just for demo
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        getMovieArticles()
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialization()
        getMovieArticles()
    }


    private fun initialization() {
        progress_circular_movie_article = view?.findViewById<View>(com.achal.test.R.id.progress_circular_movie_article) as ProgressBar
        my_recycler_view = view?.findViewById<View>(com.achal.test.R.id.my_recycler_view) as RecyclerView

        // use a linear layout manager
        val activity = activity as Context
        layoutManager = LinearLayoutManager(activity)
        my_recycler_view!!.layoutManager = layoutManager


        my_recycler_view!!.setHasFixedSize(true)
        // adapter

        adapter = CanadaArticleAdapter(activity, articleArrayList)
        my_recycler_view!!.adapter = adapter

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(CanadaArticleViewModel::class.java)
    }

    private fun getMovieArticles() {

        articleViewModel.articleResponseLiveData.observe(getViewLifecycleOwner(), androidx.lifecycle.Observer {

            if (it != null) {
                activity?.setTitle(it!!.title)
                progress_circular_movie_article!!.visibility = View.GONE
                val canadaarticles = it.articles
                if (canadaarticles != null) {
                    articleArrayList.addAll(canadaarticles)
                }
                adapter!!.notifyDataSetChanged()
            }


        })


    }
}