package com.mpl.androidapp.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServerGame implements Serializable, Parcelable {
    public static final Creator<ServerGame> CREATOR = new Creator<ServerGame>() {
        public ServerGame createFromParcel(Parcel parcel) {
            return new ServerGame(parcel);
        }

        public ServerGame[] newArray(int i) {
            return new ServerGame[i];
        }
    };
    public static final long serialVersionUID = 4805922111582048820L;
    @SerializedName("allGames")
    @Expose
    public List<AllGame> allGames = new ArrayList();
    @SerializedName("inactiveGames")
    @Expose
    public List<Object> inactiveGames = new ArrayList();
    @SerializedName("processed")
    @Expose
    public Boolean processed;

    public ServerGame(Parcel parcel) {
        parcel.readList(this.allGames, AllGame.class.getClassLoader());
        parcel.readList(this.inactiveGames, Object.class.getClassLoader());
        this.processed = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<AllGame> getAllGames() {
        return this.allGames;
    }

    public List<Object> getInactiveGames() {
        return this.inactiveGames;
    }

    public Boolean getProcessed() {
        return this.processed;
    }

    public void setAllGames(List<AllGame> list) {
        this.allGames = list;
    }

    public void setInactiveGames(List<Object> list) {
        this.inactiveGames = list;
    }

    public void setProcessed(Boolean bool) {
        this.processed = bool;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.allGames);
        parcel.writeList(this.inactiveGames);
        parcel.writeValue(this.processed);
    }

    public ServerGame() {
    }
}
