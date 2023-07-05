package uz.apexsoftuz.movieskmm.data.model.response

@kotlinx.serialization.Serializable
internal data class MoviesResponse(
    val results: List<MovieResponse>
)
