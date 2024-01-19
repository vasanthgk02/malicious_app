package com.mpl.androidapp.smartfox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetailedProfile implements Serializable, Parcelable {
    public static final Creator<DetailedProfile> CREATOR = new Creator<DetailedProfile>() {
        public DetailedProfile createFromParcel(Parcel parcel) {
            return new DetailedProfile(parcel);
        }

        public DetailedProfile[] newArray(int i) {
            return new DetailedProfile[i];
        }
    };
    public static final long serialVersionUID = -1677261177346698188L;
    @SerializedName("battlesPlayed")
    @Expose
    public Integer battlesPlayed;
    @SerializedName("gameCount")
    @Expose
    public List<Object> gameCount = new ArrayList();
    @SerializedName("gamesPlayed")
    @Expose
    public Integer gamesPlayed;
    @SerializedName("profileViews")
    @Expose
    public ProfileViews profileViews;
    @SerializedName("totalCash")
    @Expose
    public Integer totalCash;
    @SerializedName("totalHeart")
    @Expose
    public Integer totalHeart;
    @SerializedName("totalReferrals")
    @Expose
    public Integer totalReferrals;
    @SerializedName("totalTokens")
    @Expose
    public Integer totalTokens;
    @SerializedName("tournamentsPlayed")
    @Expose
    public Integer tournamentsPlayed;
    @SerializedName("tournamentsWon")
    @Expose
    public Integer tournamentsWon;

    public DetailedProfile(Parcel parcel) {
        Class<Integer> cls = Integer.class;
        this.totalCash = (Integer) parcel.readValue(cls.getClassLoader());
        this.totalTokens = (Integer) parcel.readValue(cls.getClassLoader());
        this.totalReferrals = (Integer) parcel.readValue(cls.getClassLoader());
        this.gamesPlayed = (Integer) parcel.readValue(cls.getClassLoader());
        this.tournamentsPlayed = (Integer) parcel.readValue(cls.getClassLoader());
        this.tournamentsWon = (Integer) parcel.readValue(cls.getClassLoader());
        this.profileViews = (ProfileViews) parcel.readValue(ProfileViews.class.getClassLoader());
        parcel.readList(this.gameCount, Object.class.getClassLoader());
        this.battlesPlayed = (Integer) parcel.readValue(cls.getClassLoader());
        this.totalHeart = (Integer) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public Integer getBattlesPlayed() {
        return this.battlesPlayed;
    }

    public List<Object> getGameCount() {
        return this.gameCount;
    }

    public Integer getGamesPlayed() {
        return this.gamesPlayed;
    }

    public ProfileViews getProfileViews() {
        return this.profileViews;
    }

    public Integer getTotalCash() {
        return this.totalCash;
    }

    public Integer getTotalHeart() {
        return this.totalHeart;
    }

    public Integer getTotalReferrals() {
        return this.totalReferrals;
    }

    public Integer getTotalTokens() {
        return this.totalTokens;
    }

    public Integer getTournamentsPlayed() {
        return this.tournamentsPlayed;
    }

    public Integer getTournamentsWon() {
        return this.tournamentsWon;
    }

    public void setBattlesPlayed(Integer num) {
        this.battlesPlayed = num;
    }

    public void setGameCount(List<Object> list) {
        this.gameCount = list;
    }

    public void setGamesPlayed(Integer num) {
        this.gamesPlayed = num;
    }

    public void setProfileViews(ProfileViews profileViews2) {
        this.profileViews = profileViews2;
    }

    public void setTotalCash(Integer num) {
        this.totalCash = num;
    }

    public void setTotalHeart(Integer num) {
        this.totalHeart = num;
    }

    public void setTotalReferrals(Integer num) {
        this.totalReferrals = num;
    }

    public void setTotalTokens(Integer num) {
        this.totalTokens = num;
    }

    public void setTournamentsPlayed(Integer num) {
        this.tournamentsPlayed = num;
    }

    public void setTournamentsWon(Integer num) {
        this.tournamentsWon = num;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.totalCash);
        parcel.writeValue(this.totalTokens);
        parcel.writeValue(this.totalReferrals);
        parcel.writeValue(this.gamesPlayed);
        parcel.writeValue(this.tournamentsPlayed);
        parcel.writeValue(this.tournamentsWon);
        parcel.writeValue(this.profileViews);
        parcel.writeList(this.gameCount);
        parcel.writeValue(this.battlesPlayed);
        parcel.writeValue(this.totalHeart);
    }

    public DetailedProfile() {
    }
}
