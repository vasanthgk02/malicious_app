package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.service.e.ag;
import java.util.List;

public class FAQCategoryFetchResponse extends ag {
    public static final Creator<FAQCategoryFetchResponse> CREATOR = new Creator<FAQCategoryFetchResponse>() {
        public FAQCategoryFetchResponse createFromParcel(Parcel parcel) {
            return new FAQCategoryFetchResponse(parcel);
        }

        public FAQCategoryFetchResponse[] newArray(int i) {
            return new FAQCategoryFetchResponse[i];
        }
    };
    public List<FAQCategory> categories;
    public Pagination pagination;

    public FAQCategoryFetchResponse() {
    }

    public FAQCategoryFetchResponse(Parcel parcel) {
        super(parcel);
        this.categories = parcel.createTypedArrayList(FAQCategory.CREATOR);
        this.pagination = (Pagination) parcel.readParcelable(Pagination.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<FAQCategory> getCategoryList() {
        return this.categories;
    }

    public Pagination getPagination() {
        return this.pagination;
    }

    public void setPagination(Pagination pagination2) {
        this.pagination = pagination2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.categories);
        parcel.writeParcelable(this.pagination, i);
    }
}
