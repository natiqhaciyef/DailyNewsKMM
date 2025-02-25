package com.natiqhaciyef.dailynewskmp.articles

data class ArticleUIState(
    var error: String? = null,
    var isLoading: Boolean = false,
    var articles: List<ArticleModel> = listOf()
)
