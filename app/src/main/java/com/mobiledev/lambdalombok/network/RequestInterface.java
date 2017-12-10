package com.mobiledev.lambdalombok.network;

/**
 * Created by manu on 11/22/2017.
 */



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("movies?")
    Observable<PopularMovieModel> getPopularMovies(@Query("q") String query, @Query("page") Integer page);
}