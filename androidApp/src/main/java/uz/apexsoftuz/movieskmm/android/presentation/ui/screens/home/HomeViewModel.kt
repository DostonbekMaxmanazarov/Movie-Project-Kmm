package uz.apexsoftuz.movieskmm.android.presentation.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.apexsoftuz.movieskmm.domain.usecase.GetMoviesUseCase

class HomeViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {
    var uiState by mutableStateOf(HomeScreenState())
    private var currentPage = 1

    init {
        loadMovies()
    }

    fun loadMovies(reload: Boolean = false) {
        if (uiState.loading) return
        if (reload) {
            currentPage = 1
            uiState = uiState.copy(refreshing = true)
        }
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            val resultMovies = getMoviesUseCase(page = currentPage)
            val movies = if (currentPage == 1) resultMovies else uiState.movies + resultMovies
            currentPage = currentPage.plus(1)
            uiState = uiState.copy(
                loading = false,
                refreshing = false,
                loadFinished = resultMovies.isEmpty(),
                movies = movies
            )
        }
    }
}