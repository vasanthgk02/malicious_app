package com.mpl.androidapp.smartfox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Profile implements Serializable {
    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    };
    public static final long serialVersionUID = 823157593691146787L;
    @SerializedName("avatar")
    @Expose
    public String avatar;
    @SerializedName("avatars")
    @Expose
    public Avatars avatars;
    @SerializedName("coverPhotos")
    @Expose
    public CoverPhotos coverPhotos;
    @SerializedName("displayName")
    @Expose
    public String displayName;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("mobileNumber")
    @Expose
    public String mobileNumber;
    @SerializedName("newUser")
    @Expose
    public Boolean newUser;
    @SerializedName("ownProfile")
    @Expose
    public Boolean ownProfile;
    @SerializedName("pro")
    @Expose
    public Boolean pro;
    @SerializedName("referralCode")
    @Expose
    public String referralCode;
    @SerializedName("tier")
    @Expose
    public String tier;

    public Profile(Parcel parcel) {
        Class<Boolean> cls = Boolean.class;
        Class<String> cls2 = String.class;
        this.id = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mobileNumber = (String) parcel.readValue(cls2.getClassLoader());
        this.displayName = (String) parcel.readValue(cls2.getClassLoader());
        this.avatars = (Avatars) parcel.readValue(Avatars.class.getClassLoader());
        this.avatar = (String) parcel.readValue(cls2.getClassLoader());
        this.newUser = (Boolean) parcel.readValue(cls.getClassLoader());
        this.referralCode = (String) parcel.readValue(cls2.getClassLoader());
        this.coverPhotos = (CoverPhotos) parcel.readValue(CoverPhotos.class.getClassLoader());
        this.tier = (String) parcel.readValue(cls2.getClassLoader());
        this.pro = (Boolean) parcel.readValue(cls.getClassLoader());
        this.ownProfile = (Boolean) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public Avatars getAvatars() {
        return this.avatars;
    }

    public CoverPhotos getCoverPhotos() {
        return this.coverPhotos;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public Boolean getNewUser() {
        return this.newUser;
    }

    public Boolean getOwnProfile() {
        return this.ownProfile;
    }

    public Boolean getPro() {
        return this.pro;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public String getTier() {
        return this.tier;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatars(Avatars avatars2) {
        this.avatars = avatars2;
    }

    public void setCoverPhotos(CoverPhotos coverPhotos2) {
        this.coverPhotos = coverPhotos2;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setNewUser(Boolean bool) {
        this.newUser = bool;
    }

    public void setOwnProfile(Boolean bool) {
        this.ownProfile = bool;
    }

    public void setPro(Boolean bool) {
        this.pro = bool;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public void setTier(String str) {
        this.tier = str;
    }

    public Profile() {
    }
}
