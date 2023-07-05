package uz.apexsoftuz.movieskmm.data.datasource.network.datasources.impl

import kotlinx.coroutines.withContext
import uz.apexsoftuz.movieskmm.data.datasource.network.apiservice.MovieApiService
import uz.apexsoftuz.movieskmm.data.datasource.network.datasources.MovieRemoteDataSource
import uz.apexsoftuz.movieskmm.util.Dispatcher

internal class MovieRemoteDataSourceImpl(
    private val apiService: MovieApiService,
    private val dispatcher: Dispatcher
) : MovieRemoteDataSource {

    override suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    override suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId = movieId)
    }
}