package com.natiqhaciyef.dailynewskmp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel(){
    val scope: CoroutineScope
}