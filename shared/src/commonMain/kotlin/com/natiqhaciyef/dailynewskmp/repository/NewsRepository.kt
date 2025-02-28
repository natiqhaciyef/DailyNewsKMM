package com.natiqhaciyef.dailynewskmp.repository

import com.natiqhaciyef.dailynewskmp.datasource.NewsDataSource
import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.network.reponse.ArticleResponse

class NewsRepository(
    private val service: NewsService,
    private val dataSource: NewsDataSource,
) {

    suspend fun getArticles(): List<ArticleResponse> {
        val localNews = dataSource.getAllNews()

        if (localNews.isEmpty()){
            val fetchedNews = service.getTopNews() ?: listOf()
            dataSource.insertAllNews(fetchedNews)
            return fetchedNews
        }

        return localNews
    }
}