package com.natiqhaciyef.dailynewskmp

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun providedDispatcher(): Dispatcher