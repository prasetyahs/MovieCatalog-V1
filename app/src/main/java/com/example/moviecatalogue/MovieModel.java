package com.example.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    private String title;
    private String date;
    private String description;
    private int img;
    private int score;
    private String budget;
    private String revenue;
    private String runtime;

    private String art;

    public String getArt() {
        return art;
    }

    public String getBudget() {
        return budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public String getRuntime() {
        return runtime;
    }


    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getScore() {
        return score;
    }

    public MovieModel(String title, int img, String date, String description, int score, String revenue, String budget, String runtime,String art) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.img = img;
        this.score = score;
        this.revenue = revenue;
        this.budget = budget;
        this.runtime = runtime;
        this.art = art;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.description);
        dest.writeInt(this.img);
        dest.writeInt(this.score);
        dest.writeString(this.runtime);
        dest.writeString(this.budget);
        dest.writeString(this.revenue);
        dest.writeString(this.art);
    }

    protected MovieModel(Parcel in) {
        this.title = in.readString();
        this.date = in.readString();
        this.description = in.readString();
        this.img = in.readInt();
        this.score = in.readInt();
        this.runtime = in.readString();
        this.budget = in.readString();
        this.revenue = in.readString();
        this.art = in.readString();
    }


    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };
}
