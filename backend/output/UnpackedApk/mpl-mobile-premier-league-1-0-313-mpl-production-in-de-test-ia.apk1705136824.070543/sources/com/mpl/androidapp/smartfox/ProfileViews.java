package com.mpl.androidapp.smartfox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProfileViews implements Serializable, Parcelable {
    public static final Creator<ProfileViews> CREATOR = new Creator<ProfileViews>() {
        public ProfileViews createFromParcel(Parcel parcel) {
            return new ProfileViews(parcel);
        }

        public ProfileViews[] newArray(int i) {
            return new ProfileViews[i];
        }
    };
    public static final long serialVersionUID = -8713872138564982024L;
    @SerializedName("allTime")
    @Expose
    public Integer allTime;
    @SerializedName("today")
    @Expose
    public Integer today;

    public ProfileViews(Parcel parcel) {
        Class<Integer> cls = Integer.class;
        this.allTime = (Integer) parcel.readValue(cls.getClassLoader());
        this.today = (Integer) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Integer getAllTime() {
        return this.allTime;
    }

    public Integer getToday() {
        return this.today;
    }

    public void setAllTime(Integer num) {
        this.allTime = num;
    }

    public void setToday(Integer num) {
        this.today = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.allTime);
        parcel.writeValue(this.today);
    }

    public ProfileViews() {
    }
}
