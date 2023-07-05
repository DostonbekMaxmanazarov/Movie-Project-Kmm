package uz.apexsoftuz.movieskmm.data.mapper.impl

import uz.apexsoftuz.movieskmm.data.mapper.SingleMapper
import uz.apexsoftuz.movieskmm.data.model.response.MovieResponse
import uz.apexsoftuz.movieskmm.domain.model.Movie

internal class MovieRemoteToMovieMapper : SingleMapper<MovieResponse, Movie> {
    override fun invoke(value: MovieResponse): Movie = Movie(
        id = value.id,
        title = value.title,
        description = value.overview,
        imageUrl = getImageUrl(value.posterImage),
        releaseDate = value.releaseDate
    )
}

private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"