package com.natiqhaciyef.dailynewskmp.presentation.articles

import com.natiqhaciyef.dailynewskmp.network.usecases.GetTopNewsUseCase
import com.natiqhaciyef.dailynewskmp.BaseViewModel
import com.natiqhaciyef.dailynewskmp.network.usecases.GetPreviousNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//provideArticleViewModel()

class ArticleViewModel(
    private var getTopNewsUseCase: GetTopNewsUseCase,
    private var getPreviousNewsUseCase: GetPreviousNewsUseCase
) : BaseViewModel() {
    private val _articleState = MutableStateFlow(ArticleUIState(isLoading = true))
    val articleState: StateFlow<ArticleUIState>
        get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val articles = getTopNewsUseCase.getArticles()
            _articleState.emit(ArticleUIState(articles = articles))
        }
    }

    fun getPreviousArticles(date: String) {
        scope.launch {
            val articles = getPreviousNewsUseCase.getArticles(date)
            _articleState.emit(ArticleUIState(articles = articles))
        }
    }
}