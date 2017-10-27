package movil.themovieapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_movie.view.*
import movil.themovieapp.R
import movil.themovieapp.api.MoviesApi
import movil.themovieapp.extensions.loadImage
import movil.themovieapp.models.Movie

/**
 * Created by haurbano on 25/10/2017.
 */

class MoviesListAdapter(val data : List<Movie>, val listener : (Movie) -> Unit ) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(movie : Movie, listener : (Movie) -> Unit){
            with(itemView){
                setOnClickListener{listener(movie)}
                title_movie.text = movie.title
                calification_movie.text = movie.vote_average.toString()
                poster_movie.loadImage(MoviesApi.BASE_IMAGE_PATH + movie.poster_path)
            }
        }
    }
    // TODO: ask for the false in inflating
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_movie, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MoviesListAdapter.ViewHolder, position: Int) {
        val movie : Movie = data[position]
        holder.bind(movie, listener)
    }

    override fun getItemCount(): Int = data.size
}