package com.natiqhaciyef.dailynewskmp

import app.cash.sqldelight.db.SqlDriver
import com.natiqhaciyef.dailynewskmp.db.DailyNewsDatabase
import com.natiqhaciyef.dailynewskmp.db.DatabaseDriverFactory
import com.natiqhaciyef.dailynewskmp.di.sharedModules
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyNewsDatabase> { DailyNewsDatabase(get()) }
}

val iosViewModelModule = module {
    single<ArticleViewModel> { ArticleViewModel(
        getPreviousNewsUseCase = get(),
        getTopNewsUseCase = get()
    ) }
}

fun initKoin(){
    startKoin {
        modules(
            sharedModules + databaseModule + iosViewModelModule
        )
    }
}


class ProvideViewModel : KoinComponent {
    fun getArticleViewModel(): ArticleViewModel = get<ArticleViewModel>()
}
