package uz.apexsoftuz.movieskmm.domain.usecase

import uz.apexsoftuz.movieskmm.domain.model.Movie

interface GetMoviesUseCase {
    suspend operator fun invoke(page: Int): List<Movie>
}