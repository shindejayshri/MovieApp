package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieapp.ModelClass.MovieResult;
import com.example.movieapp.Utils.Credentials;

public class MovieDetails extends AppCompatActivity {


    TextView
            tv_title,
            tv_datetime,
            tv_reviews,
            tv_synopsis;
    ImageView img_movie;

    CardView card_booknow;
    MovieResult movieDetails = new MovieResult();
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        bindview();

        setTitle("Movie Details");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().hasExtra("movieResult")) {
            movieDetails = (MovieResult) getIntent().getSerializableExtra("movieResult");
        }
        tv_title.setText(movieDetails.getTitle());
        tv_datetime.setText(movieDetails.getOriginalLanguage() + " | " + movieDetails.getReleaseDate());
        tv_reviews.setText("Popularity -" + movieDetails.getPopularity());
        tv_synopsis.setText(movieDetails.getOverview());
        Glide.with(this)
                .load(Credentials.IMG_BASE_URL + movieDetails.getPosterPath())
                .placeholder(R.drawable.camera)
                .into(img_movie);
        //card_booknow.setText(movieDetails.getTitle());
        ratingBar.setClickable(false);
        ratingBar.setEnabled(false);
        ratingBar.setRating(movieDetails.getVoteAverage()/2);

    }

    private void bindview() {
        ratingBar = findViewById(R.id.ratingBar);
        tv_title = findViewById(R.id.tv_title);
        tv_datetime = findViewById(R.id.tv_datetime);
        tv_reviews = findViewById(R.id.tv_reviews);
        tv_synopsis = findViewById(R.id.tv_synopsis);
        card_booknow = findViewById(R.id.card_booknow);
        img_movie = findViewById(R.id.img_movie);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}