package com.susana.task.data.client

import com.susana.task.data.NewsModel
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("top-headlines?country=eg&apiKey=63b1f94dad044add871d1e319c630265")
    fun getAllNews(): Call<NewsModel>
}