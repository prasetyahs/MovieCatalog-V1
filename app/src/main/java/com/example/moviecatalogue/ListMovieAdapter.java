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
        vh.txtDesc.setText(movieModel.getDescription());
        vh.txtDate.setText(movieModel.getDate());
        vh.txtTitle.setText(movieModel.getTitle());
        vh.imgMovie.setImageResource(movieModel.getImg());
        return view;
    }


    private class ViewHolder {
        private ImageView imgMovie;
        private TextView txtTitle;
        private TextView txtDate;
        private TextView txtDesc;
        ViewHolder(View v) {
            imgMovie = v.findViewById(R.id.img_movie);
            txtTitle = v.findViewById(R.id.txt_title);
            txtDate = v.findViewById(R.id.txt_date);
            txtDesc = v.findViewById(R.id.txt_desc);
        }
    }
}
