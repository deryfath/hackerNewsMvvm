package com.cobamvvm.project.module.viewmodel

import androidx.lifecycle.MutableLiveData
import com.cobamvvm.project.data.DataRepository
import com.cobamvvm.project.data.model.ArticleResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DataRepository):AbstractVIewModel() {

    val topStoryListArticle = MutableLiveData<List<Int>>()
    val topStoryDetail = MutableLiveData<ArticleResponse>()

    fun getListTopStories(){
        launch {
            try {
                setLoading()

                val dataTopStoriesArticle = repository.getListTopStories()
                topStoryListArticle.postValue(dataTopStoriesArticle)

            }catch (t:Throwable){
                println("ERROR COROUTINE "+t.message)

                setError(t)
            }finally {
                setLoading(false)
            }
        }
    }

    fun getTopStoriesDetail(id:Int){
        launch {
            try {
                setLoading()

                val dataTopStoriesArticleDetail = repository.getArticleTopStories(id)
                topStoryDetail.postValue(dataTopStoriesArticleDetail)

            }catch (t:Throwable){
                println("ERROR COROUTINE "+t.message)

                setError(t)
            }finally {
                setLoading(false)
            }
        }
    }

    fun start(){
        topStoryListArticle.value = emptyList()
        topStoryDetail.value = null
    }
}