package com.app.wonderland;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Option implements Parcelable {
    private final String option;

    protected Option(Parcel in) {
        option = in.readString();
    }

    public static final Creator<Option> CREATOR = new Creator<Option>() {
        @Override
        public Option createFromParcel(Parcel in) {
            return new Option(in);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };

    public String getOption() {
        return option;
    }

    public Option(String option) {
        this.option = option;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(option);
    }
}