package com.adciasis.recoveryfy.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

interface DispatcherProvider {

    @MainDispatcher
    fun main(): CoroutineDispatcher = Dispatchers.Main

    @IoDispatcher
    fun io(): CoroutineDispatcher = Dispatchers.IO
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher


open class DefaultDispatcherProvider : DispatcherProvider