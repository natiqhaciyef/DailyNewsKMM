package com.natiqhaciyef.dailynewskmp.datasource

import com.natiqhaciyef.dailynewskmp.db.DailyNewsDatabase
import com.natiqhaciyef.dailynewskmp.mapper.databaseMapNews
import com.natiqhaciyef.dailynewskmp.network.reponse.ArticleResponse

class NewsDataSource(private val db: DailyNewsDatabase) {

    fun getAllNews(): List<ArticleResponse> {
        return db.dailyNewsDatabaseQueries.selectAllNews(::databaseMapNews)
            .executeAsList()
    }

    fun insertAllNews(list: List<ArticleResponse>) {
        return db.dailyNewsDatabaseQueries.transaction {
            for (article in list) {
                insertSingleNews(article)
            }
        }
    }

    private fun insertSingleNews(article: ArticleResponse) {
        return db.dailyNewsDatabaseQueries
            .insertNews(
                title = article.title ?: "",
                desc = article.description,
                date = article.publishDate ?: "Yesterday",
                imageUrl = article.imageUrl
            )
    }

    fun clearNews() {
        return db.dailyNewsDatabaseQueries.removeAllNews()
    }
}