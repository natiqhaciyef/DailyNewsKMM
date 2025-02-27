package com.natiqhaciyef.dailynewskmp

import com.natiqhaciyef.dailynewskmp.di.sharedModules
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedModules
    startKoin {
        modules(sharedModules)
    }
}


object ProvideViewModel : KoinComponent {
    fun getArticleViewModel(): ArticleViewModel = get() // No need for KoinPlatform
}
