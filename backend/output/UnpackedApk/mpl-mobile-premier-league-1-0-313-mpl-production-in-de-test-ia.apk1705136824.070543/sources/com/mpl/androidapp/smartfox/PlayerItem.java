package com.mpl.androidapp.smartfox;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class PlayerItem {
    public boolean isCurrentUser;
    public boolean isJoined;
    public int mUserId;
    public String playerAvatar;
    public CharSequence playerName;

    public PlayerItem(String str, CharSequence charSequence, int i) {
        this.playerAvatar = str;
        this.playerName = charSequence;
        this.mUserId = i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PlayerItem) || getUserId() != ((PlayerItem) obj).getUserId()) {
            return false;
        }
        return true;
    }

    public String getPlayerAvatar() {
        return this.playerAvatar;
    }

    public CharSequence getPlayerName() {
        return this.playerName;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public int hashCode() {
        return getUserId();
    }

    public boolean isCurrentUser() {
        return this.isCurrentUser;
    }

    public boolean isJoined() {
        return this.isJoined;
    }

    public void setCurrentUser(boolean z) {
        this.isCurrentUser = z;
    }

    public void setJoined(boolean z) {
        this.isJoined = z;
    }

    public void setPlayerAvatar(String str) {
        this.playerAvatar = str;
    }

    public void setPlayerName(CharSequence charSequence) {
        this.playerName = charSequence;
    }

    public void setUserId(int i) {
        this.mUserId = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PlayerItem{playerAvatar='");
        GeneratedOutlineSupport.outline99(outline73, this.playerAvatar, ExtendedMessageFormat.QUOTE, ", playerName=");
        outline73.append(this.playerName);
        outline73.append(", mUserId=");
        outline73.append(this.mUserId);
        outline73.append(", isJoined=");
        outline73.append(this.isJoined);
        outline73.append(", isCurrentUser=");
        return GeneratedOutlineSupport.outline65(outline73, this.isCurrentUser, '}');
    }

    public PlayerItem(String str, CharSequence charSequence, int i, boolean z, boolean z2) {
        this.playerAvatar = str;
        this.playerName = charSequence;
        this.mUserId = i;
        this.isCurrentUser = z;
        this.isJoined = z2;
    }

    public PlayerItem() {
    }
}
