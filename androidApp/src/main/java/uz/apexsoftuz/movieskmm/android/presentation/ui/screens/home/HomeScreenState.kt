package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.home

import uz.apexsoftuz.movieskmm.domain.model.Movie

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)
