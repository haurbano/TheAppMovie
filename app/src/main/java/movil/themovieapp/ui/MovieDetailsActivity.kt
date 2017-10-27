package movil.themovieapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*
import movil.themovieapp.R
import movil.themovieapp.api.MoviesApi
import movil.themovieapp.extensions.loadImage
import movil.themovieapp.models.Movie

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie : Movie = intent.getParcelableExtra("movie")
        loadData(movie)
    }

    fun loadData(movie : Movie){
        image_movie.loadImage(MoviesApi.BASE_IMAGE_PATH + movie.poster_path)
        title_movie.text = movie.title
        override_movie.text = movie.overview
    }
}
