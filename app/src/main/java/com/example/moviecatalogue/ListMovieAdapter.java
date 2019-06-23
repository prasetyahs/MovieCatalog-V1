package com.example.moviecatalogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListMovieAdapter extends BaseAdapter {

    private List<MovieModel> movies;

    public ListMovieAdapter(List<MovieModel> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_rows, viewGroup, false);
        }
        ViewHolder vh = new ViewHolder(view);
        MovieModel movieModel = movies.get(i);
        vh.txt_desc.setText(movieModel.getDescription());
        vh.txt_date.setText(movieModel.getDate());
        vh.txt_title.setText(movieModel.getTitle());
        vh.img_movie.setImageResource(movieModel.getImg());
        return view;
    }


    private class ViewHolder {
        private ImageView img_movie;
        private TextView txt_title;
        private TextView txt_date;
        private TextView txt_desc;
        ViewHolder(View v) {
            img_movie = v.findViewById(R.id.img_movie);
            txt_title = v.findViewById(R.id.txt_title);
            txt_date = v.findViewById(R.id.txt_date);
            txt_desc = v.findViewById(R.id.txt_desc);
        }
    }
}
