package com.natiqhaciyef.dailynewskmp.repository

import com.natiqhaciyef.dailynewskmp.datasource.NewsDataSource
import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.network.reponse.ArticleResponse

class NewsRepository(
    private val service: NewsService,
    private val dataSource: NewsDataSource,
) {

    suspend fun getArticles(isRefreshed: Boolean): List<ArticleResponse> {
        val localNews = dataSource.getAllNews()
        if (localNews.isEmpty() || isRefreshed) {
            return fetchData(isRefreshed)
        }
        return localNews
    }


    private suspend fun fetchData(isRefreshed: Boolean): List<ArticleResponse> {
        if (isRefreshed) dataSource.clearNews()

        val fetchedNews = service.getTopNews() ?: listOf()
        dataSource.insertAllNews(fetchedNews)
        return fetchedNews
    }
}