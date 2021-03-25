package com.cobamvvm.project.module

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cobamvvm.project.R
import com.cobamvvm.project.Utils.observe
import com.cobamvvm.project.data.model.ArticleResponse
import com.cobamvvm.project.module.adapter.MainAdapter
import com.cobamvvm.project.module.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel


class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private val handler = Handler()
    var listArticle: MutableList<ArticleResponse> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        viewModel.start()
        viewModel.getListTopStories()

        progressBar.visibility = View.VISIBLE
        rv_article.visibility = View.GONE

        adapter = MainAdapter(listArticle!!,this)
        val mLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_article.setLayoutManager(mLayoutManager)
        rv_article.adapter = adapter

        observe(viewModel.topStoryListArticle, {
            it?.forEachIndexed { index, i ->
                viewModel.getTopStoriesDetail(i)

                if (index==it.size-1){
                    rv_article.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            }
        })

        observe(viewModel.topStoryDetail,{
            it?.let { it1 -> adapter.addItem(it1) }
        })


    }


}
