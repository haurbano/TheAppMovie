package movil.themovieapp.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by haurbano on 25/10/2017.
 */

fun ImageView.loadImage(url: String){
    Picasso.with(context).load(url).into(this)
}