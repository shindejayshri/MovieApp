package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.movieapp.Adapter.MovieListAdapter;
import com.example.movieapp.Interface.ApiInterface;
import com.example.movieapp.ModelClass.MovieBaseResponse;
import com.example.movieapp.ModelClass.MovieResult;
import com.example.movieapp.Service.Retrofit;
import com.example.movieapp.Utils.Credentials;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   RecyclerView recyclerview;

   ArrayList<MovieResult> list = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);

        recyclerview.setLayoutManager(new GridLayoutManager(this,3));


        getMovieList();



    }

    private void getMovieList() {


        ApiInterface apiInterface = Retrofit.getAPiCLinet().create(ApiInterface.class);
        Call<MovieBaseResponse> call = apiInterface.getMovieList(Credentials.API_KEY);

        call.enqueue(new Callback<MovieBaseResponse>() {
            @Override
            public void onResponse(Call<MovieBaseResponse> call, Response<MovieBaseResponse> response) {



                if (response.body()!= null){

                    list = response.body().getResults();

                    MovieListAdapter movieListAdapter = new MovieListAdapter(MainActivity.this,list);
                    recyclerview.setAdapter(movieListAdapter);
                }
                else {

                }

            }

            @Override
            public void onFailure(Call<MovieBaseResponse> call, Throwable t) {

            }
        });

    }
}