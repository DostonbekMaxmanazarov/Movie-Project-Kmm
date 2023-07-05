package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail

import uz.apexsoftuz.movieskmm.domain.model.Movie

data class DetailScreenState(
    val movie: Movie? = null,
    val loading: Boolean = false,
    val errorMessage: String? = null
)
