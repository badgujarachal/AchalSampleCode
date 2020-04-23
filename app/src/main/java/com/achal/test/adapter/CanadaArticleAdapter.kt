package com.achal.test.adapter



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.achal.test.R
import com.achal.test.model.Canada
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

import java.util.ArrayList

class CanadaArticleAdapter(private val context: Context, internal var articleArrayList: ArrayList<Canada>) : RecyclerView.Adapter<CanadaArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CanadaArticleAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_each_row_article, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CanadaArticleAdapter.ViewHolder, i: Int) {
        val article = articleArrayList[i]
        viewHolder.tvTitle.text = article.title
        // viewHolder.tvAuthorAndPublishedAt.setText("-"+article.getAuthor() +" | "+"Piblishetd At: "+article.getPublishedAt());

        viewHolder.tvDescription.text = article.description

        val options = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .dontAnimate()
                .dontTransform()


        Glide.with(context)
                .load(article.imageHref)
                .apply(options)
                .into(viewHolder.imgViewCover)
    }

    override fun getItemCount(): Int {
        return articleArrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgViewCover: ImageView
        val tvTitle: TextView
        val tvDescription: TextView

        init {

            imgViewCover = itemView.findViewById<View>(R.id.imgViewCover) as ImageView
            tvTitle = itemView.findViewById<View>(R.id.tvTitle) as TextView
            tvDescription = itemView.findViewById<View>(R.id.tvDescription) as TextView
        }
    }
}
