package com.natiqhaciyef.dailynewskmp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.natiqhaciyef.dailynewskmp.db.DailyNewsDatabase
import com.natiqhaciyef.dailynewskmp.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<DailyNewsDatabase> { DailyNewsDatabase(get()) }
}
