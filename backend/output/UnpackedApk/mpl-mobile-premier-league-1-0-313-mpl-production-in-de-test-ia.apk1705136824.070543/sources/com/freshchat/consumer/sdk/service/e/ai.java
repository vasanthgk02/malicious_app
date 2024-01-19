package com.freshchat.consumer.sdk.service.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.beans.Pagination;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ai extends ag {
    public static final Creator<ai> CREATOR = new aj();
    public Pagination pagination;
    @SerializedName("articles")
    public List<FAQ> ri;

    public ai() {
    }

    public ai(Parcel parcel) {
        super(parcel);
        this.ri = parcel.createTypedArrayList(FAQ.CREATOR);
        this.pagination = (Pagination) parcel.readParcelable(Pagination.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<FAQ> iV() {
        return this.ri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.ri);
        parcel.writeParcelable(this.pagination, i);
    }
}
