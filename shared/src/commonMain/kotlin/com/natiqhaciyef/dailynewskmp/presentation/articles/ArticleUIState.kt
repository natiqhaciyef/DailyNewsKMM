package com.natiqhaciyef.dailynewskmp.presentation.articles

data class ArticleUIState(
    var articles: List<ArticleModel> = listOf(),
    var error: String? = null,
    var isLoading: Boolean = false
)
