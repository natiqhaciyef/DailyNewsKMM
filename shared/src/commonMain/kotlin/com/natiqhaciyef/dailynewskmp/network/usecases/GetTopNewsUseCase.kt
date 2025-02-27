package com.natiqhaciyef.dailynewskmp.network.usecases

import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.network.mapper.toArticleModel
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleModel

class GetTopNewsUseCase(private val service: NewsService) {

    suspend fun getArticles(): List<ArticleModel>{
        val articles = service.getTopNews()?.map { it.toArticleModel() }
        return articles ?: listOf()
    }
}