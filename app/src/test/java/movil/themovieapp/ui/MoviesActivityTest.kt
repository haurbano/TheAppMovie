package movil.themovieapp.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.adapter_movie.view.*
import movil.themovieapp.R
import movil.themovieapp.models.Movie
import movil.themovieapp.ui.adapters.MoviesListAdapter
import org.jetbrains.anko.find
import org.jetbrains.anko.firstChild
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows
import org.robolectric.android.controller.ActivityController

/**
 * Created by haurbano on 27/10/2017.
 */

@RunWith(RobolectricTestRunner::class)
class MoviesActivityTest{

    lateinit var moviesActivity : MoviesActivity
    lateinit var  controller : ActivityController<MoviesActivity>

    @Before
    fun setup(){
        moviesActivity = Robolectric.setupActivity(MoviesActivity::class.java)
        controller = Robolectric.buildActivity(MoviesActivity::class.java)
    }

    @Test
    fun validateMovieTitle(){
        val txtTitle : TextView  = moviesActivity.txt_movies_title
        assertEquals("Validate if the movies activity has title","Peliculas",txtTitle.text)
    }

    @Test
    fun testActivityLifeCycle(){
        // Start process
        controller.create().start().resume()

        // Interrunp proccess
        controller.pause().resume()

        // add asserts
    }

    @Test
    fun testClickInItems(){
        val movies : MutableList<Movie> = mutableListOf()
        val movi1 = Movie(1,"Movie 1","ES","Good movie", "/paht",5f,"2017-07-12")
        val movie2 = Movie(1,"Movie 1","ES","Good movie", "/paht",5f,"2017-07-12")
        movies.add(movi1)
        movies.add(movie2)

        val ryclerView = moviesActivity.recycler_view_movies
        ryclerView.adapter = MoviesListAdapter(movies,{})
        ryclerView.layoutManager = LinearLayoutManager(moviesActivity)
        val movieTitleExpected = movi1.title

        ryclerView.firstChild { view -> view.performClick() }

        val shadoMoviesActivity = Shadows.shadowOf(moviesActivity)

        val intent = shadoMoviesActivity.nextStartedActivity
        val movieTitleActual = intent.getParcelableExtra<Movie>("movie")
        assertEquals("Titles are the same ",movieTitleExpected,movieTitleActual)

    }

    @Test
    fun testResource(){
        val contex : Context = RuntimeEnvironment.application
        val res = contex.resources.getString(R.string.my_resource)
        assertEquals("Resource is correct","This is my resource",res)
    }

}