package uz.apexsoftuz.movieskmm.android.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail.DetailViewModel
import uz.apexsoftuz.movieskmm.android.presentation.ui.screens.home.HomeViewModel

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}