package com.susana.task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.susana.task.adapter.NewsAdapter
import com.susana.task.R
import com.susana.task.data.Article
import com.susana.task.data.NewsModel
import com.susana.task.data.client.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var newsList : List<Article>
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.news_rv)
        rv.layoutManager=LinearLayoutManager(applicationContext)

        getNews()
    }

    private fun getNews() {
        //retrofit call

RetrofitClient.instance.getAllNews().enqueue(object : retrofit2.Callback<NewsModel> {

    override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
if (response.body()!=null){

    newsList= response.body()!!.articles

    rv.layoutManager = LinearLayoutManager(applicationContext)
    rv.setHasFixedSize(true)
    rv.adapter= NewsAdapter(applicationContext,response)

}

    }

    override fun onFailure(call: Call<NewsModel>, t: Throwable) {

    }


})

    }

}