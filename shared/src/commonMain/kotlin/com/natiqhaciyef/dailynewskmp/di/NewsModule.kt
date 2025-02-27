package com.natiqhaciyef.dailynewskmp.di

import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.network.usecases.GetPreviousNewsUseCase
import com.natiqhaciyef.dailynewskmp.network.usecases.GetTopNewsUseCase
import com.natiqhaciyef.dailynewskmp.presentation.articles.ArticleViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val httpClient = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}

val networkModule = module {
    single<NewsService> { NewsService(get()) }
}

val useCaseModule = module {
    single<GetPreviousNewsUseCase> { GetPreviousNewsUseCase(get()) }
    single<GetTopNewsUseCase> { GetTopNewsUseCase(get()) }
}

val iosViewModelModule = module {
    single<ArticleViewModel> { ArticleViewModel(
        getPreviousNewsUseCase = get(),
        getTopNewsUseCase = get()
    ) }
}