package com.cobamvvm.project.data.api

import com.cobamvvm.project.data.model.ArticleResponse
import retrofit2.http.GET
import kotlinx.coroutines.Deferred
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/v0/topstories.json?print=pretty")
    fun getListTopStories():Deferred<List<Int>>

    @GET("v0/item/{id}.json?print=pretty")
    fun getArticlesDetail(@Path("id") id :Int ):Deferred<ArticleResponse>
}