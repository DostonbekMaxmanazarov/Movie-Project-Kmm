package uz.apexsoftuz.movieskmm.domain.usecase

import uz.apexsoftuz.movieskmm.domain.model.Movie

interface GetMovieUseCase {
    suspend operator fun invoke(movieId: Int): Movie
}