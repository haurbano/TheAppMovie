package movil.themovieapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_movies.*
import movil.themovieapp.R
import movil.themovieapp.api.MoviesApi
import movil.themovieapp.api.RestApi
import movil.themovieapp.models.Movies
import movil.themovieapp.ui.adapters.MoviesListAdapter

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        getMovies()

    }

    fun getMovies(page : Int = 1) {
        val moviesApi : MoviesApi = RestApi().moviesApi
        moviesApi.getMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    movies ->
                    loadData(movies)
                },{
                    error ->
                    snackbar(error.message.toString())
                })

    }

    fun snackbar(msg : String, length : Int = Snackbar.LENGTH_SHORT){
        Snackbar.make(father_linear_activity_movies,msg,length).show()
    }

    fun loadData(data : Movies){
        recycler_view_movies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recycler_view_movies.adapter = MoviesListAdapter(data.results)
    }
}
