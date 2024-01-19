package com.mpl.androidapp.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Icons implements Serializable, Parcelable {
    public static final Creator<Icons> CREATOR = new Creator<Icons>() {
        public Icons createFromParcel(Parcel parcel) {
            return new Icons(parcel);
        }

        public Icons[] newArray(int i) {
            return new Icons[i];
        }
    };
    public static final long serialVersionUID = -222620228354240469L;
    @SerializedName("background")
    @Expose
    public String background;
    @SerializedName("badgeShortCut")
    @Expose
    public String badgeShortCut;
    @SerializedName("logo")
    @Expose
    public String logo;
    @SerializedName("logoType")
    @Expose
    public String logoType;
    @SerializedName("mmScreen")
    @Expose
    public String mmScreen;
    @SerializedName("normalShortCut")
    @Expose
    public String normalShortCut;
    @SerializedName("showFormatIcons")
    @Expose
    public Boolean showFormatIcons;

    public Icons(Parcel parcel) {
        Class<String> cls = String.class;
        this.logo = (String) parcel.readValue(cls.getClassLoader());
        this.logoType = (String) parcel.readValue(cls.getClassLoader());
        this.background = (String) parcel.readValue(cls.getClassLoader());
        this.badgeShortCut = (String) parcel.readValue(cls.getClassLoader());
        this.normalShortCut = (String) parcel.readValue(cls.getClassLoader());
        this.showFormatIcons = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public String getBackground() {
        return this.background;
    }

    public String getBadgeShortCut() {
        return this.badgeShortCut;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getLogoType() {
        return this.logoType;
    }

    public String getMmScreen() {
        return this.mmScreen;
    }

    public String getNormalShortCut() {
        return this.normalShortCut;
    }

    public Boolean getShowFormatIcons() {
        return this.showFormatIcons;
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public void setBadgeShortCut(String str) {
        this.badgeShortCut = str;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setLogoType(String str) {
        this.logoType = str;
    }

    public void setMmScreen(String str) {
        this.mmScreen = str;
    }

    public void setNormalShortCut(String str) {
        this.normalShortCut = str;
    }

    public void setShowFormatIcons(Boolean bool) {
        this.showFormatIcons = bool;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.logo);
        parcel.writeValue(this.logoType);
        parcel.writeValue(this.background);
        parcel.writeValue(this.badgeShortCut);
        parcel.writeValue(this.normalShortCut);
        parcel.writeValue(this.showFormatIcons);
    }

    public Icons() {
    }
}
