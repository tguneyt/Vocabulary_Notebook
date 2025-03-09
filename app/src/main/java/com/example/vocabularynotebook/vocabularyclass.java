package com.example.vocabularynotebook;

import android.os.Parcel;
import android.os.Parcelable;

public class vocabularyclass implements Parcelable {


    public String orj;
    public String mean1;
    public String mean2;
    public String mean3;


    protected vocabularyclass(Parcel in) {
        orj = in.readString();
        mean1 = in.readString();
        mean2 = in.readString();
        mean3 = in.readString();
    }

    public static final Creator<vocabularyclass> CREATOR = new Creator<vocabularyclass>() {
        @Override
        public vocabularyclass createFromParcel(Parcel in) {
            return new vocabularyclass(in);
        }

        @Override
        public vocabularyclass[] newArray(int size) {
            return new vocabularyclass[size];
        }
    };

    public vocabularyclass() {

    }

    public String getOrj() {
        return orj;
    }

    public void setOrj(String orj) {
        this.orj = orj;
    }

    public String getMean1() {
        return mean1;
    }

    public void setMean1(String mean1) {
        this.mean1 = mean1;
    }

    public String getMean2() {
        return mean2;
    }

    public void setMean2(String mean2) {
        this.mean2 = mean2;
    }

    public String getMean3() {
        return mean3;
    }

    public void setMean3(String mean3) {
        this.mean3 = mean3;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orj);
        dest.writeString(mean1);
        dest.writeString(mean2);
        dest.writeString(mean3);
    }
}


