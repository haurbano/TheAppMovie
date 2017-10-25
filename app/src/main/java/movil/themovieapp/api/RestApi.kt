package movil.themovieapp.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by haurbano on 23/10/2017.
 */


class RestApi{

    val retrofit :Retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/4/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val moviesApi = retrofit.create(MoviesApi::class.java)

}


