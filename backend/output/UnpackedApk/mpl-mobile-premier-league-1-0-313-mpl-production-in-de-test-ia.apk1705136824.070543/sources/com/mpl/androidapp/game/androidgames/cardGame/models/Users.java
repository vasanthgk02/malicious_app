package com.mpl.androidapp.game.androidgames.cardGame.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/cardGame/models/Users;", "", "mplUserId", "", "mplUserName", "profilePicURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMplUserId", "()Ljava/lang/String;", "getMplUserName", "getProfilePicURL", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Users.kt */
public final class Users {
    public final String mplUserId;
    public final String mplUserName;
    public final String profilePicURL;

    public Users(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "mplUserId", str2, "mplUserName", str3, "profilePicURL");
        this.mplUserId = str;
        this.mplUserName = str2;
        this.profilePicURL = str3;
    }

    public static /* synthetic */ Users copy$default(Users users, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = users.mplUserId;
        }
        if ((i & 2) != 0) {
            str2 = users.mplUserName;
        }
        if ((i & 4) != 0) {
            str3 = users.profilePicURL;
        }
        return users.copy(str, str2, str3);
    }

    public final String component1() {
        return this.mplUserId;
    }

    public final String component2() {
        return this.mplUserName;
    }

    public final String component3() {
        return this.profilePicURL;
    }

    public final Users copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "mplUserId");
        Intrinsics.checkNotNullParameter(str2, "mplUserName");
        Intrinsics.checkNotNullParameter(str3, "profilePicURL");
        return new Users(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Users)) {
            return false;
        }
        Users users = (Users) obj;
        return Intrinsics.areEqual(this.mplUserId, users.mplUserId) && Intrinsics.areEqual(this.mplUserName, users.mplUserName) && Intrinsics.areEqual(this.profilePicURL, users.profilePicURL);
    }

    public final String getMplUserId() {
        return this.mplUserId;
    }

    public final String getMplUserName() {
        return this.mplUserName;
    }

    public final String getProfilePicURL() {
        return this.profilePicURL;
    }

    public int hashCode() {
        return this.profilePicURL.hashCode() + GeneratedOutlineSupport.outline11(this.mplUserName, this.mplUserId.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Users(mplUserId=");
        outline73.append(this.mplUserId);
        outline73.append(", mplUserName=");
        outline73.append(this.mplUserName);
        outline73.append(", profilePicURL=");
        return GeneratedOutlineSupport.outline59(outline73, this.profilePicURL, ')');
    }
}
