package uz.apexsoftuz.movieskmm.data.datasource.network.datasources

import uz.apexsoftuz.movieskmm.data.model.response.MovieResponse
import uz.apexsoftuz.movieskmm.data.model.response.MoviesResponse

internal interface MovieRemoteDataSource {
    suspend fun getMovies(page: Int): MoviesResponse
    suspend fun getMovie(movieId: Int): MovieResponse
}