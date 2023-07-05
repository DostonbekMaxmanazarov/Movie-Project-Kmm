package uz.apexsoftuz.movieskmm.data.datasource.network.apiservice

import uz.apexsoftuz.movieskmm.data.model.response.MovieResponse
import uz.apexsoftuz.movieskmm.data.model.response.MoviesResponse
import uz.apexsoftuz.movieskmm.data.datasource.network.configuration.KtorConfiguration

internal class MovieApiService : KtorConfiguration() {
    suspend fun getMovies(page: Int = 1): MoviesResponse = createRequest(
        path = "movie/popular",
        parameters = arrayOf(Pair("page", page))
    )

    suspend fun getMovie(movieId: Int): MovieResponse = createRequest(
        path = "movie/${movieId}"
    )
}