package com.freshchat.consumer.sdk.beans;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class FAQCategory implements Parcelable, ICategory {
    public static final Creator<FAQCategory> CREATOR = new Creator<FAQCategory>() {
        public FAQCategory createFromParcel(Parcel parcel) {
            return new FAQCategory(parcel);
        }

        public FAQCategory[] newArray(int i) {
            return new FAQCategory[i];
        }
    };
    public String categoryId;
    public String description;
    @SerializedName("icon")
    public String iconUrl;
    public String title;

    public FAQCategory(Parcel parcel) {
        this.categoryId = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.iconUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getCategoryAlias() {
        return this.categoryId;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.categoryId);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.iconUrl);
    }
}
