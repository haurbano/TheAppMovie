package movil.themovieapp.models

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by haurbano on 23/10/2017.
 */

@SuppressLint("ParcelCreator")
@Parcelize
class Movie(val id : Int, val title : String, val original_language : String,
                 val overview : String, val poster_path: String,  val vote_average : Float,
                 val release_date : String) : Parcelable



data class Movies(val results : List<Movie>)