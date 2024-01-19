package com.mpl.androidapp.smartfox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FollowDetails implements Serializable, Parcelable {
    public static final Creator<FollowDetails> CREATOR = new Creator<FollowDetails>() {
        public FollowDetails createFromParcel(Parcel parcel) {
            return new FollowDetails(parcel);
        }

        public FollowDetails[] newArray(int i) {
            return new FollowDetails[i];
        }
    };
    public static final long serialVersionUID = -3261630628017399708L;
    @SerializedName("followed")
    @Expose
    public Boolean followed;
    @SerializedName("followerCount")
    @Expose
    public Integer followerCount;
    @SerializedName("following")
    @Expose
    public Boolean following;
    @SerializedName("followingCount")
    @Expose
    public Integer followingCount;

    public FollowDetails(Parcel parcel) {
        Class<Boolean> cls = Boolean.class;
        Class<Integer> cls2 = Integer.class;
        this.followerCount = (Integer) parcel.readValue(cls2.getClassLoader());
        this.followingCount = (Integer) parcel.readValue(cls2.getClassLoader());
        this.following = (Boolean) parcel.readValue(cls.getClassLoader());
        this.followed = (Boolean) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getFollowed() {
        return this.followed;
    }

    public Integer getFollowerCount() {
        return this.followerCount;
    }

    public Boolean getFollowing() {
        return this.following;
    }

    public Integer getFollowingCount() {
        return this.followingCount;
    }

    public void setFollowed(Boolean bool) {
        this.followed = bool;
    }

    public void setFollowerCount(Integer num) {
        this.followerCount = num;
    }

    public void setFollowing(Boolean bool) {
        this.following = bool;
    }

    public void setFollowingCount(Integer num) {
        this.followingCount = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.followerCount);
        parcel.writeValue(this.followingCount);
        parcel.writeValue(this.following);
        parcel.writeValue(this.followed);
    }

    public FollowDetails() {
    }
}
