package com.example.jy.nytimesmoviereview.APIResponses;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Review implements Parcelable{
    private String display_title;
    private String mpaa_rating;
    private String byline;
    private String headline;
    private String publication_date;
    private String summary_short;
    private Multimedia multimedia;


    protected Review(Parcel in) {
        display_title = in.readString();
        mpaa_rating = in.readString();
        byline = in.readString();
        headline = in.readString();
        publication_date = in.readString();
        summary_short = in.readString();
        multimedia = in.readParcelable(Multimedia.class.getClassLoader());
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getMpaa_rating() {
        return mpaa_rating;
    }

    public void setMpaa_rating(String mpaa_rating) {
        this.mpaa_rating = mpaa_rating;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary_short() {
        return summary_short;
    }

    public void setSummary_short(String summary_short) {
        this.summary_short = summary_short;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(display_title);
        parcel.writeString(mpaa_rating);
        parcel.writeString(byline);
        parcel.writeString(headline);
        parcel.writeString(summary_short);
        parcel.writeString(publication_date);
        parcel.writeParcelable(multimedia, i);
    }

    public static class ReviewResult {
        private List<Review> results;

        public List<Review> getResults() {
            return results;
        }
    }
}
