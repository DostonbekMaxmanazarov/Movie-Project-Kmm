package uz.apexsoftuz.movieskmm.data.repository

import uz.apexsoftuz.movieskmm.data.datasource.network.datasources.MovieRemoteDataSource
import uz.apexsoftuz.movieskmm.data.mapper.SingleMapper
import uz.apexsoftuz.movieskmm.data.model.response.MovieResponse
import uz.apexsoftuz.movieskmm.domain.model.Movie
import uz.apexsoftuz.movieskmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDateSource: MovieRemoteDataSource,
    private val movieMapper: SingleMapper<MovieResponse, Movie>
) : MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> = remoteDateSource
        .getMovies(page = page)
        .results
        .map { movieMapper(it) }

    override suspend fun getMovie(movieId: Int): Movie {
        val movieRemote = remoteDateSource.getMovie(movieId = movieId)
        return movieMapper(movieRemote)
    }
}