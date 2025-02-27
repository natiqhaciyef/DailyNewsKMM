package com.natiqhaciyef.dailynewskmp.android.di

import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val androidViewModelModule = module {
    viewModelOf(::ArticleViewModel)
}