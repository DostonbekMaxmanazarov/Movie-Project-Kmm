package uz.apexsoftuz.movieskmm.domain.repository

import uz.apexsoftuz.movieskmm.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}