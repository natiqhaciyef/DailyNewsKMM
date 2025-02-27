package com.natiqhaciyef.dailynewskmp.network.usecases

import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.network.mapper.toArticleModel
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleModel

class GetPreviousNewsUseCase(private val service: NewsService) {

    suspend fun getArticles(date: String): List<ArticleModel> {
        val articles = service.getPreviousNews(date)?.map { it.toArticleModel() }
        return articles ?: listOf()
    }
}