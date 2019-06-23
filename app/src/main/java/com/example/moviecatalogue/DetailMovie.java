package com.example.moviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMovie extends AppCompatActivity {

    private ImageView[] starimg;

    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        MovieModel movieModel = getIntent().getParcelableExtra("movie");
        ImageView img_moview = findViewById(R.id.img_movie);
        TextView txt_title = findViewById(R.id.txt_title);
        TextView txt_date = findViewById(R.id.txt_date);
        TextView txt_desc = findViewById(R.id.txt_desc);
        TextView txt_bud = findViewById(R.id.txtbudget);
        TextView txt_run = findViewById(R.id.txtruntime);
        TextView txt_rev = findViewById(R.id.txtrevenue);
        TextView txt_art = findViewById(R.id.txt_art);
        if (movieModel != null) {
            img_moview.setImageResource(movieModel.getImg());
            txt_title.setText(movieModel.getTitle());
            txt_date.setText(movieModel.getDate());
            txt_desc.setText(movieModel.getDescription());
            count = (int) Math.floor((movieModel.getScore() / 100.0) * 5);
            txt_bud.setText("Budget  : " + movieModel.getBudget());
            txt_run.setText("Runtime : " + movieModel.getRuntime());
            txt_rev.setText("Revenue : " + movieModel.getRevenue());
            txt_art.setText(movieModel.getArt());
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        showStar();
    }

    private ImageView[] countStar() {
        starimg = new ImageView[count];
        for (int i = 0; i < count; i++) {
            ImageView star = new ImageView(this);
            star.setMaxWidth(20);
            star.setMaxHeight(20);
            star.setImageResource(R.drawable.ic_star_black_24dp);
            starimg[i] = star;
        }
        return starimg;
    }

    private void showStar() {
        LinearLayout linearLayout = findViewById(R.id.containerstar);
        for (int i = 0; i < countStar().length; i++) {
            linearLayout.addView(countStar()[i]);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
