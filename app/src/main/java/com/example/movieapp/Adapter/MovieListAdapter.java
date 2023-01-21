package com.example.movieapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapp.ModelClass.MovieBaseResponse;
import com.example.movieapp.ModelClass.MovieResult;
import com.example.movieapp.MovieDetails;
import com.example.movieapp.R;
import com.example.movieapp.Utils.Credentials;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {


    Context context;
    ArrayList<MovieResult> list = new ArrayList<>();

    public MovieListAdapter(Context context, ArrayList<MovieResult> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovieListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movie_list,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.ViewHolder holder, int position) {

        MovieResult movieResult = list.get(position);

       /* holder.tv_overview.setText(movieResult.getOverview());
        holder.tv_popularity.setText(movieResult.getPopularity().toString());
        holder.tv_vote_count.setText(movieResult.getVoteCount());*/
        holder.tv_title.setText(movieResult.getTitle());

        Glide.with(context)
                .load(Credentials.IMG_BASE_URL+movieResult.getPosterPath())
                .placeholder(R.drawable.camera)
                .into(holder.img_poster_path);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   "adult": false,
                        "backdrop_path": "/53BC9F2tpZnsGno2cLhzvGprDYS.jpg",
                        "genre_ids": [
                14,
                        28,
                        12,
                        53
            ],
                "id": 736526,
                        "original_language": "no",
                        "original_title": "Troll",
                        "overview": "Deep inside the mountain of Dovre, something gigantic awakens after being trapped for a thousand years. Destroying everything in its path, the creature is fast approaching the capital of Norway. But how do you stop something you thought only existed in Norwegian folklore?",
                        "popularity": 1406.265,
                        "poster_path": "/9z4jRr43JdtU66P0iy8h18OyLql.jpg",
                        "release_date": "2022-12-01",
                        "title": "Troll",
                        "video": false,
                        "vote_average": 6.7,
                        "vote_count": 1032
            },
*/
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("movieResult",movieResult);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;
          ImageView img_poster_path;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            img_poster_path = itemView.findViewById(R.id.img_poster_path);

        }
    }
}
