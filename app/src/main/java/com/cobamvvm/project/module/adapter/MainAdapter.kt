package com.cobamvvm.project.module.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cobamvvm.project.R
import com.cobamvvm.project.Utils.Constants.Companion.IMAGE_BASE_URL
import com.cobamvvm.project.data.model.ArticleResponse
import com.cobamvvm.project.module.DetailActivity
import kotlinx.android.extensions.LayoutContainer
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter (private var items:MutableList<ArticleResponse>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view=holder.itemView
        val data=items[position]

        view.let {
            it.visibility = View.VISIBLE

            (it.findViewById(R.id.tv_title) as TextView).text = data.title
            (it.findViewById(R.id.tv_by) as TextView).text = "By : "+data.by
            (it.findViewById(R.id.tv_type) as TextView).text = "Type : "+data.type
            (it.findViewById(R.id.tv_score) as TextView).text = "Score : "+data.score
            (it.findViewById(R.id.tv_time) as TextView).text = "Date : "+getDateTime(data.time.toString())

        }

        view.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("article_url",data.url)
            context.startActivity(intent)
        }

    }

    private fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    fun addItem(articleResponse: ArticleResponse){
        items.add(articleResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    }
}