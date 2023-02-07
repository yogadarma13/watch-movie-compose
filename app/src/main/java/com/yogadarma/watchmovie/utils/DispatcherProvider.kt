package com.yogadarma.watchmovie.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherProvider @Inject constructor() : Dispatcher {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

}