package com.natiqhaciyef.dailynewskmp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

actual open class BaseViewModel {
    actual val scope: CoroutineScope = CoroutineScope(providedDispatcher().io)


    fun clear(){ scope.cancel() }
}