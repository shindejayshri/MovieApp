package com.shindejayshri.movieapp.Service;

import com.shindejayshri.movieapp.Utils.Credentials;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {

    private static retrofit2.Retrofit retrofit = null;
   // private static final String BASE_URL = "https://api.themoviedb.org";

    public static retrofit2.Retrofit getAPiCLinet() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create()).build();


        return retrofit;
    }

}
