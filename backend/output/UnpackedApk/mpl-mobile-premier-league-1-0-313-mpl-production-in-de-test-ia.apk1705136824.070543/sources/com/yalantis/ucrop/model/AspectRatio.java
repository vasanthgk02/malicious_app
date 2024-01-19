package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AspectRatio implements Parcelable {
    public static final Creator<AspectRatio> CREATOR = new Creator<AspectRatio>() {
        public Object createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        public Object[] newArray(int i) {
            return new AspectRatio[i];
        }
    };
    public final String mAspectRatioTitle;
    public final float mAspectRatioX;
    public final float mAspectRatioY;

    public AspectRatio(String str, float f2, float f3) {
        this.mAspectRatioTitle = str;
        this.mAspectRatioX = f2;
        this.mAspectRatioY = f3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAspectRatioTitle);
        parcel.writeFloat(this.mAspectRatioX);
        parcel.writeFloat(this.mAspectRatioY);
    }

    public AspectRatio(Parcel parcel) {
        this.mAspectRatioTitle = parcel.readString();
        this.mAspectRatioX = parcel.readFloat();
        this.mAspectRatioY = parcel.readFloat();
    }
}
