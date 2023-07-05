package uz.apexsoftuz.movieskmm.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal class IosDispatcher : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.Default

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
}

internal actual fun provideDispatcher(): Dispatcher = IosDispatcher()