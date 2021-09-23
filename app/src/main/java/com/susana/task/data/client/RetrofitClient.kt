package com.susana.task.data.client

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL="https://newsapi.org/v2/"


    private val okHttpClient:OkHttpClient.Builder= OkHttpClient.Builder()





    val instance: Api by lazy{
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(Api::class.java)
    }


}
