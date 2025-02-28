package com.natiqhaciyef.dailynewskmp.android.di

import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidViewModelModule = module {
    viewModel { ArticleViewModel(get(), get()) }
}