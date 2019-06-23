package com.example.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] title;
    private TypedArray img;
    private String[] desc;
    private String[] date;
    private int[] score;
    private String[] revenue;
    private String[] runtime;
    private String[] budget;
    private String[] art;
    private ListMovieAdapter listMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lv_movies = findViewById(R.id.ls_view);
        prepareSetData();
        if (setData().size() > 0) {
            listMovieAdapter = new ListMovieAdapter(setData());
        }
        lv_movies.setAdapter(listMovieAdapter);
        lv_movies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MovieModel movieModel = (MovieModel) listMovieAdapter.getItem(i);
                Intent intentdetail = new Intent(MainActivity.this, DetailMovie.class);
                intentdetail.putExtra("movie", movieModel);
                startActivity(intentdetail);
            }
        });
    }


    private List<MovieModel> setData() {
        List<MovieModel> movieModels = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            movieModels.add(new MovieModel(title[i], img.getResourceId(i, 0), date[i], desc[i], score[i], revenue[i], budget[i], runtime[i],art[i]));
        }
        return movieModels;
    }

    private void prepareSetData() {
        title = getResources().getStringArray(R.array.title);
        img = getResources().obtainTypedArray(R.array.image);
        desc = getResources().getStringArray(R.array.desc);
        date = getResources().getStringArray(R.array.date);
        score = getResources().getIntArray(R.array.score);
        budget = getResources().getStringArray(R.array.budget);
        revenue = getResources().getStringArray(R.array.revenue);
        runtime = getResources().getStringArray(R.array.minutes);
        art = getResources().getStringArray(R.array.arts);

    }
}
