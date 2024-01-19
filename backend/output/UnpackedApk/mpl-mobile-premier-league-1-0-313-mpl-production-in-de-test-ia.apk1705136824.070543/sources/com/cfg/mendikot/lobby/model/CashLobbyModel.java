package com.cfg.mendikot.lobby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CashLobbyModel implements Parcelable {
    public static final Creator<CashLobbyModel> CREATOR = new a();
    public int ID;
    public boolean active;
    public int activePlayers;
    public float allowedBonus;
    public int fee;
    public String gameID;
    public boolean isPlayerSeated;
    public String lobbyID;
    public int maxPlayers;
    public int prize;
    public double[] prizeBreakdown;
    public double rake;
    public String roomName;
    public int rounds;
    public String speed;
    public String tableName;
    public int turnTime;
    public String type;
    public int winners;

    public class a implements Creator<CashLobbyModel> {
        public Object createFromParcel(Parcel parcel) {
            return new CashLobbyModel(parcel);
        }

        public Object[] newArray(int i) {
            return new CashLobbyModel[i];
        }
    }

    public CashLobbyModel() {
    }

    public CashLobbyModel(Parcel parcel) {
        this.ID = parcel.readInt();
        this.lobbyID = parcel.readString();
        this.gameID = parcel.readString();
        this.roomName = parcel.readString();
        this.type = parcel.readString();
        this.fee = parcel.readInt();
        this.maxPlayers = parcel.readInt();
        this.activePlayers = parcel.readInt();
        this.winners = parcel.readInt();
        this.rounds = parcel.readInt();
        this.allowedBonus = parcel.readFloat();
        this.prize = parcel.readInt();
        this.tableName = parcel.readString();
        boolean z = true;
        this.isPlayerSeated = parcel.readInt() != 0;
        this.active = parcel.readInt() == 0 ? false : z;
        this.speed = parcel.readString();
        this.turnTime = parcel.readInt();
        this.rake = parcel.readDouble();
        this.prizeBreakdown = parcel.createDoubleArray();
    }

    public int describeContents() {
        return 0;
    }

    public int getActivePlayers() {
        return this.activePlayers;
    }

    public float getAllowedBonus() {
        return this.allowedBonus;
    }

    public int getFee() {
        return this.fee;
    }

    public String getGameID() {
        return this.gameID;
    }

    public int getID() {
        return this.ID;
    }

    public String getLobbyID() {
        return this.lobbyID;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }

    public int getPrize() {
        return this.prize;
    }

    public double[] getPrizeBreakdown() {
        return this.prizeBreakdown;
    }

    public double getRake() {
        return this.rake;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int getRounds() {
        return this.rounds;
    }

    public String getSpeed() {
        return this.speed;
    }

    public String getTableName() {
        return this.tableName;
    }

    public int getTurnTime() {
        return this.turnTime;
    }

    public String getType() {
        return this.type;
    }

    public int getWinners() {
        return this.winners;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isPlayerSeated() {
        return this.isPlayerSeated;
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public void setActivePlayers(int i) {
        this.activePlayers = i;
    }

    public void setAllowedBonus(float f2) {
        this.allowedBonus = f2;
    }

    public void setFee(int i) {
        this.fee = i;
    }

    public void setGameID(String str) {
        this.gameID = str;
    }

    public void setID(int i) {
        this.ID = i;
    }

    public void setLobbyID(String str) {
        this.lobbyID = str;
    }

    public void setMaxPlayers(int i) {
        this.maxPlayers = i;
    }

    public void setPlayerSeated(boolean z) {
        this.isPlayerSeated = z;
    }

    public void setPrize(int i) {
        this.prize = i;
    }

    public void setPrizeBreakdown(double[] dArr) {
        this.prizeBreakdown = dArr;
    }

    public void setRake(double d2) {
        this.rake = d2;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setRounds(int i) {
        this.rounds = i;
    }

    public void setSpeed(String str) {
        this.speed = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public void setTurnTime(int i) {
        this.turnTime = i;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setWinners(int i) {
        this.winners = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CashLobbyModel{ID=");
        outline73.append(this.ID);
        outline73.append(", lobbyID='");
        GeneratedOutlineSupport.outline99(outline73, this.lobbyID, ExtendedMessageFormat.QUOTE, ", roomName='");
        GeneratedOutlineSupport.outline99(outline73, this.roomName, ExtendedMessageFormat.QUOTE, ", type='");
        GeneratedOutlineSupport.outline99(outline73, this.type, ExtendedMessageFormat.QUOTE, ", fee=");
        outline73.append(this.fee);
        outline73.append(", maxPlayers=");
        outline73.append(this.maxPlayers);
        outline73.append(", activePlayers=");
        outline73.append(this.activePlayers);
        outline73.append(", winners=");
        outline73.append(this.winners);
        outline73.append(", rounds=");
        outline73.append(this.rounds);
        outline73.append(", allowedBonus=");
        outline73.append(this.allowedBonus);
        outline73.append(", prize=");
        outline73.append(this.prize);
        outline73.append(", tableName='");
        GeneratedOutlineSupport.outline99(outline73, this.tableName, ExtendedMessageFormat.QUOTE, ", isPlayerSeated=");
        outline73.append(this.isPlayerSeated);
        outline73.append(", active=");
        outline73.append(this.active);
        outline73.append(", speed='");
        GeneratedOutlineSupport.outline99(outline73, this.speed, ExtendedMessageFormat.QUOTE, ", turnTime=");
        outline73.append(this.turnTime);
        outline73.append(", rake=");
        outline73.append(this.rake);
        outline73.append(", prizeBreakdown=");
        outline73.append(Arrays.toString(this.prizeBreakdown));
        outline73.append('}');
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.ID);
        parcel.writeString(this.lobbyID);
        parcel.writeString(this.gameID);
        parcel.writeString(this.roomName);
        parcel.writeString(this.type);
        parcel.writeInt(this.fee);
        parcel.writeInt(this.maxPlayers);
        parcel.writeInt(this.activePlayers);
        parcel.writeInt(this.winners);
        parcel.writeInt(this.rounds);
        parcel.writeFloat(this.allowedBonus);
        parcel.writeInt(this.prize);
        parcel.writeString(this.tableName);
        parcel.writeInt(this.isPlayerSeated ? 1 : 0);
        parcel.writeInt(this.active ? 1 : 0);
        parcel.writeString(this.speed);
        parcel.writeInt(this.turnTime);
        parcel.writeDouble(this.rake);
        parcel.writeDoubleArray(this.prizeBreakdown);
    }
}
