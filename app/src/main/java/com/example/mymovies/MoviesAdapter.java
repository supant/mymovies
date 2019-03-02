package com.example.mymovies;

/**
 * Created by Antoine on 02/12/2017.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.data.Programme;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Programme> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titre, heure, nature,tmp,chaine;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            titre = (TextView) view.findViewById(R.id.title);
            nature = (TextView) view.findViewById(R.id.genre);
            heure = (TextView) view.findViewById(R.id.year);
            photo =(ImageView) view.findViewById(R.id.thumbnail);
            tmp = (TextView) view.findViewById(R.id.tmp);
            chaine = (TextView) view.findViewById(R.id.chaine);
        }
    }


    public MoviesAdapter(List<Programme> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Programme movie = moviesList.get(position);
        holder.titre.setText(movie.getTitre());
        holder.nature.setText(movie.getFirstStyle());
        holder.heure.setText(movie.getStart().toStringJMA());
        //holder.tmp.setText(movie.getUrlDiff());
        holder.chaine.setText(movie.getChaine().getNom());

        String path = movie.getImage();
        if (path.length()>0)
            Picasso.with(holder.photo.getContext()).load(path).into(holder.photo);
            else holder.photo.setImageResource(R.drawable.imdb);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }





}