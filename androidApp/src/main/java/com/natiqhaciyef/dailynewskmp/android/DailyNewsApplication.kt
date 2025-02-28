package com.natiqhaciyef.dailynewskmp.android

import android.app.Application
import com.natiqhaciyef.dailynewskmp.android.di.androidViewModelModule
import com.natiqhaciyef.dailynewskmp.android.di.databaseModule
import com.natiqhaciyef.dailynewskmp.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class DailyNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        val modules = sharedModules + androidViewModelModule + databaseModule
        startKoin {
            androidContext(this@DailyNewsApplication)
            modules(modules)
        }
    }
}