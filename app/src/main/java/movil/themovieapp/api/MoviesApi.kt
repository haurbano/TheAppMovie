package movil.themovieapp.api

import io.reactivex.Observable
import movil.themovieapp.models.Movies
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by haurbano on 23/10/2017.
 */
interface MoviesApi {
    companion object {
        const val API_KEY = "c2cbc555c3d7c7a1ee0e46081ca3869e"
        const val BASE_IMAGE_PATH = "https://image.tmdb.org/t/p/w500/"
    }


    @GET("list/1?page=1&api_key=c2cbc555c3d7c7a1ee0e46081ca3869e")
    fun getMovies() : Observable<Movies>
}