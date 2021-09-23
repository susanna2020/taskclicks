package com.susana.task.data

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)