package com.example.jy.nytimesmoviereview.APIResponses;

import android.os.Parcel;
import android.os.Parcelable;

public class Multimedia implements Parcelable{
    private String src;

    protected Multimedia(Parcel in) {
        src = in.readString();
    }

    public static final Creator<Multimedia> CREATOR = new Creator<Multimedia>() {
        @Override
        public Multimedia createFromParcel(Parcel in) {
            return new Multimedia(in);
        }

        @Override
        public Multimedia[] newArray(int size) {
            return new Multimedia[size];
        }
    };

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(src);
    }
}
