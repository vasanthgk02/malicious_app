package com.mpl.androidapp.smartfox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CoverPhotos implements Serializable, Parcelable {
    public static final Creator<CoverPhotos> CREATOR = new Creator<CoverPhotos>() {
        public CoverPhotos createFromParcel(Parcel parcel) {
            return new CoverPhotos(parcel);
        }

        public CoverPhotos[] newArray(int i) {
            return new CoverPhotos[i];
        }
    };
    public static final long serialVersionUID = -7836017131429896543L;
    @SerializedName("regular")
    @Expose
    public String regular;
    @SerializedName("small")
    @Expose
    public String small;

    public CoverPhotos(Parcel parcel) {
        Class<String> cls = String.class;
        this.small = (String) parcel.readValue(cls.getClassLoader());
        this.regular = (String) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getRegular() {
        return this.regular;
    }

    public String getSmall() {
        return this.small;
    }

    public void setRegular(String str) {
        this.regular = str;
    }

    public void setSmall(String str) {
        this.small = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.small);
        parcel.writeValue(this.regular);
    }

    public CoverPhotos() {
    }
}
