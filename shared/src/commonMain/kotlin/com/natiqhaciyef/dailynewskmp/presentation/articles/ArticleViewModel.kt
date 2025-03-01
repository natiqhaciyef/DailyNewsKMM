package com.natiqhaciyef.dailynewskmp.presentation.articles

import com.natiqhaciyef.dailynewskmp.usecases.GetTopNewsUseCase
import com.natiqhaciyef.dailynewskmp.BaseViewModel
import com.natiqhaciyef.dailynewskmp.usecases.GetPreviousNewsUseCase
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

    fun getArticles(isRefresh: Boolean = false) {
        scope.launch {
            _articleState.emit(ArticleUIState(isLoading = true))
            val articles = getTopNewsUseCase.getArticles(isRefresh)
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