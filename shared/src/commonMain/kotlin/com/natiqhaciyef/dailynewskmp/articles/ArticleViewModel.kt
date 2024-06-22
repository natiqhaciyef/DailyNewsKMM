package com.natiqhaciyef.dailynewskmp.articles

import com.natiqhaciyef.dailynewskmp.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {
    private val _articleState = MutableStateFlow(ArticleUIState())
    val articleState: StateFlow<ArticleUIState>
        get() = _articleState

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch {
            _articleState.emit(ArticleUIState())
        }
    }
}