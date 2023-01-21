package com.example.movieapp.Interface;

import com.example.movieapp.ModelClass.MovieBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {



    @GET("3/movie/popular")
    Call<MovieBaseResponse> getMovieList(@Query("api_key") String api_key);
}
