package com.natiqhaciyef.dailynewskmp.usecases

import com.natiqhaciyef.dailynewskmp.mapper.toArticleModel
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleModel
import com.natiqhaciyef.dailynewskmp.repository.NewsRepository

class GetTopNewsUseCase(private val repository: NewsRepository) {

    suspend fun getArticles(): List<ArticleModel>{
        val articles = repository.getArticles().map { it.toArticleModel() }
        return articles
    }
}