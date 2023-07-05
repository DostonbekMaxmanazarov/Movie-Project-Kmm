package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.detail

import androidx.compose.runtime.*
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import uz.apexsoftuz.movieskmm.domain.usecase.GetMovieUseCase

class DetailViewModel(
    val getMovieUseCase: GetMovieUseCase,
    val movieId: Int
) : ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            val movie = getMovieUseCase(movieId)
            uiState = uiState.copy(loading = false, movie = movie)
        }
    }

}