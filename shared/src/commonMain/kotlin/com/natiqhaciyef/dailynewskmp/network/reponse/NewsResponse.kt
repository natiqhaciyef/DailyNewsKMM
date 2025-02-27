package com.natiqhaciyef.dailynewskmp.network.reponse

import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val articles: List<ArticleResponse>?,
    val status: String?,
    val totalResults: Int?
)