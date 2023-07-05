package uz.apexsoftuz.movieskmm.android.application

import android.app.Application
import org.koin.core.context.startKoin
import uz.apexsoftuz.movieskmm.android.presentation.di.appModule
import uz.apexsoftuz.movieskmm.di.getSharedModules

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}