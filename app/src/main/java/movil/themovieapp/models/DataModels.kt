package movil.themovieapp.models

/**
 * Created by haurbano on 23/10/2017.
 */
data class Movie(val title : String, val original_language : String, val overview : String,
                 val poster_path: String,  val vote_average : Float,
                 val release_date : String)

data class Movies(val results : List<Movie>)