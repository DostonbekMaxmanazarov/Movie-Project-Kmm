package uz.apexsoftuz.movieskmm.domain.usecase.impl

import uz.apexsoftuz.movieskmm.domain.model.Movie
import uz.apexsoftuz.movieskmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import uz.apexsoftuz.movieskmm.domain.usecase.GetMoviesUseCase

class GetMoviesUseCaseImpl : GetMoviesUseCase, KoinComponent {
    private val repository: MovieRepository by inject()
    override suspend fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page = page)
    }
}