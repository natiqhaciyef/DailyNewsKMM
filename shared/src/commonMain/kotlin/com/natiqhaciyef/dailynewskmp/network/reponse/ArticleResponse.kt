package com.natiqhaciyef.dailynewskmp.network.reponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val author: String?,
    val content: String?,
    val description: String?,
    @SerialName("publishedAt")
    val publishDate: String?,
    val source: Source?,
    val title: String?,
    @SerialName("urlToImage")
    val imageUrl: String?
)