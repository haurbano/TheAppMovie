package movil.themovieapp.api

import io.reactivex.Observable
import movil.themovieapp.models.Movies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by haurbano on 23/10/2017.
 */
interface MoviesApi {
    companion object {
        const val BASE_IMAGE_PATH = "https://image.tmdb.org/t/p/w500/"
    }


    @GET("list/1")
    fun getMovies(@Query("api_key") api_key : String, @Query("page") page : Int = 1) : Observable<Movies>
}