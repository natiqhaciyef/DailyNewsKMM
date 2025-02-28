package com.natiqhaciyef.dailynewskmp.di

import com.natiqhaciyef.dailynewskmp.datasource.NewsDataSource
import com.natiqhaciyef.dailynewskmp.network.NewsService
import com.natiqhaciyef.dailynewskmp.usecases.GetPreviousNewsUseCase
import com.natiqhaciyef.dailynewskmp.usecases.GetTopNewsUseCase
import com.natiqhaciyef.dailynewskmp.repository.NewsRepository
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

val localModule = module {
    single<NewsDataSource> { NewsDataSource(get())  }
}

val networkModule = module {
    single<NewsService> { NewsService(get()) }
}

val repositoryModule = module {
    single<NewsRepository> { NewsRepository(get(), get()) }
}

val useCaseModule = module {
    single<GetPreviousNewsUseCase> { GetPreviousNewsUseCase(get()) }
    single<GetTopNewsUseCase> { GetTopNewsUseCase(get()) }
}