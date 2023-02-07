package com.yogadarma.watchmovie.utils

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val main: CoroutineDispatcher

    val io: CoroutineDispatcher

    val default: CoroutineDispatcher
}