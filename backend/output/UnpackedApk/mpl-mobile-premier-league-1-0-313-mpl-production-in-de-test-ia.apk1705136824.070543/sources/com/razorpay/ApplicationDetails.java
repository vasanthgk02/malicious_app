package com.razorpay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ApplicationDetails implements Parcelable {
    public static final Creator<ApplicationDetails> CREATOR = new Creator<ApplicationDetails>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ApplicationDetails(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ApplicationDetails[i];
        }
    };
    public String G__G_;
    public String a_$P$;
    public String d__1_;

    public ApplicationDetails(String str, String str2, String str3) {
        this.d__1_ = str;
        this.a_$P$ = str2;
        this.G__G_ = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String getAppName() {
        return this.d__1_;
    }

    public String getIconBase64() {
        return this.a_$P$;
    }

    public String getPackageName() {
        return this.G__G_;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d__1_);
        parcel.writeString(this.a_$P$);
        parcel.writeString(this.G__G_);
    }

    public ApplicationDetails(Parcel parcel) {
        this.d__1_ = parcel.readString();
        this.a_$P$ = parcel.readString();
        this.G__G_ = parcel.readString();
    }
}
