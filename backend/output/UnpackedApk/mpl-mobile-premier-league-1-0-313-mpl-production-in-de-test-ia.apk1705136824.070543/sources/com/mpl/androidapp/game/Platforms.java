package com.mpl.androidapp.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Platforms implements Serializable, Parcelable {
    public static final Creator<Platforms> CREATOR = new Creator<Platforms>() {
        public Platforms createFromParcel(Parcel parcel) {
            return new Platforms(parcel);
        }

        public Platforms[] newArray(int i) {
            return new Platforms[i];
        }
    };
    public static final long serialVersionUID = 1784485770657799215L;
    @SerializedName("android")
    @Expose

    /* renamed from: android  reason: collision with root package name */
    public Android f960android;

    public Platforms(Parcel parcel) {
        this.f960android = (Android) parcel.readValue(Android.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Android getAndroid() {
        return this.f960android;
    }

    public void setAndroid(Android android2) {
        this.f960android = android2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.f960android);
    }

    public Platforms() {
    }
}
