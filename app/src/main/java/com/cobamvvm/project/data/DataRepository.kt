package com.cobamvvm.project.data

import com.cobamvvm.project.data.api.ApiService
import com.cobamvvm.project.data.model.ArticleResponse

class DataRepository(private val apiDataRepository: ApiService
                     ) {

    suspend fun getListTopStories():List<Int>{
        return apiDataRepository.getListTopStories().await()
    }

    suspend fun getArticleTopStories(id:Int):ArticleResponse{
        return apiDataRepository.getArticlesDetail(id).await()
    }

}