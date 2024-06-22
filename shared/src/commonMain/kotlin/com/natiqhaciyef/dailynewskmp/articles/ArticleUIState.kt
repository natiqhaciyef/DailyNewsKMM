package com.natiqhaciyef.dailynewskmp.articles

data class ArticleUIState(
    var isLoading: Boolean = false,
    var articleList: List<ArticleModel>? = null
)
