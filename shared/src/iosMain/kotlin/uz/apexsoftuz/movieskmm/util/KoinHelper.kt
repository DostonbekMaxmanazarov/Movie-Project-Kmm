package uz.apexsoftuz.movieskmm.util

import org.koin.core.context.startKoin
import uz.apexsoftuz.movieskmm.di.getSharedModules

fun initKoin() {
    startKoin { modules(getSharedModules()) }
}