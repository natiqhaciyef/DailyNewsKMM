package com.natiqhaciyef.dailynewskmp.network

import com.natiqhaciyef.dailynewskmp.network.reponse.ArticleResponse
import com.natiqhaciyef.dailynewskmp.network.reponse.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsService(private val httpClient: HttpClient) {
    private val apiVersion = "v2"
    private val country = "us"
    private val lang = "us"
    private val baseUrl = "https://newsapi.org/"
    private val category = "technology"
    private val query = "Google"
    private val fromDate = "2025-02-14"
    private val sortBy = "popularity"
    private val apiKey = "a32c206ee7d74b68bb1b799220046159"

    suspend fun getEverythingArticles(): List<ArticleResponse>? {
        val response = httpClient.get(
            "$baseUrl$apiVersion/everything?q=$query&language=$lang&from=$fromDate&sortBy=$sortBy&apiKey=$apiKey"
        ).body<NewsResponse>()

        return response.articles
    }

    suspend fun getTopNews(): List<ArticleResponse>? {
        val response = httpClient.get(
            "$baseUrl$apiVersion/top-headlines?country=$country&category=$category&apiKey=$apiKey"
        ).body<NewsResponse>()

        return response.articles
    }

    suspend fun getPreviousNews(date: String): List<ArticleResponse>? {
        val response = httpClient.get(
            "$baseUrl$apiVersion/everything?q=$query&language=$lang&from=$date&sortBy=$sortBy&apiKey=$apiKey"
        ).body<NewsResponse>()

        return response.articles
    }

}