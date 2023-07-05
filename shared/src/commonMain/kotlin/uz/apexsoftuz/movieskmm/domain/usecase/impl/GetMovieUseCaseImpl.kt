package uz.apexsoftuz.movieskmm.domain.usecase.impl

import uz.apexsoftuz.movieskmm.domain.model.Movie
import uz.apexsoftuz.movieskmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.apexsoftuz.movieskmm.domain.usecase.GetMovieUseCase

class GetMovieUseCaseImpl(private val repository: MovieRepository) : GetMovieUseCase {
    override suspend fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }
}