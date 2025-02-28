package com.natiqhaciyef.dailynewskmp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory(
    private val androidContext: Context
) {

    actual fun createDriver(): SqlDriver{
        return AndroidSqliteDriver(
            schema = DailyNewsDatabase.Schema,
            context = androidContext,
            name = "DailyNewsDatabase"
        )
    }
}