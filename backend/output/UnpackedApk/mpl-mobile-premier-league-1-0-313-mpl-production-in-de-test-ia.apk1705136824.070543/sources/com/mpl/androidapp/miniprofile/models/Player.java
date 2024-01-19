package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b3\b\b\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\rHÆ\u0003J\t\u0010;\u001a\u00020\u000fHÆ\u0003J\t\u0010<\u001a\u00020\u000fHÆ\u0003J\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\nHÖ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010!\"\u0004\b\"\u0010#R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!¨\u0006B"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/Player;", "", "acr", "Lcom/mpl/androidapp/miniprofile/models/Acr;", "avatar", "", "displayName", "highlight", "Lcom/mpl/androidapp/miniprofile/models/Highlight;", "id", "", "lastSeen", "liveStream", "Lcom/mpl/androidapp/miniprofile/models/LiveStream;", "prime", "", "pro", "profileName", "state", "tier", "userName", "userNameClaimed", "isFollowing", "(Lcom/mpl/androidapp/miniprofile/models/Acr;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/androidapp/miniprofile/models/Highlight;ILjava/lang/String;Lcom/mpl/androidapp/miniprofile/models/LiveStream;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAcr", "()Lcom/mpl/androidapp/miniprofile/models/Acr;", "getAvatar", "()Ljava/lang/String;", "getDisplayName", "getHighlight", "()Lcom/mpl/androidapp/miniprofile/models/Highlight;", "getId", "()I", "()Z", "setFollowing", "(Z)V", "getLastSeen", "getLiveStream", "()Lcom/mpl/androidapp/miniprofile/models/LiveStream;", "getPrime", "getPro", "getProfileName", "getState", "getTier", "getUserName", "getUserNameClaimed", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Player.kt */
public final class Player {
    @SerializedName("acr")
    public final Acr acr;
    @SerializedName("avatar")
    public final String avatar;
    @SerializedName("displayName")
    public final String displayName;
    @SerializedName("highlight")
    public final Highlight highlight;
    @SerializedName("id")
    public final int id;
    public boolean isFollowing;
    @SerializedName("lastSeen")
    public final String lastSeen;
    @SerializedName("liveStream")
    public final LiveStream liveStream;
    @SerializedName("prime")
    public final boolean prime;
    @SerializedName("pro")
    public final boolean pro;
    @SerializedName("profileName")
    public final String profileName;
    @SerializedName("state")
    public final String state;
    @SerializedName("tier")
    public final String tier;
    @SerializedName("userName")
    public final String userName;
    @SerializedName("userNameClaimed")
    public final boolean userNameClaimed;

    public Player(Acr acr2, String str, String str2, Highlight highlight2, int i, String str3, LiveStream liveStream2, boolean z, boolean z2, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        Highlight highlight3 = highlight2;
        String str8 = str3;
        LiveStream liveStream3 = liveStream2;
        String str9 = str4;
        String str10 = str5;
        String str11 = str6;
        String str12 = str7;
        Intrinsics.checkNotNullParameter(acr2, "acr");
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(highlight3, "highlight");
        Intrinsics.checkNotNullParameter(str8, "lastSeen");
        Intrinsics.checkNotNullParameter(liveStream3, "liveStream");
        Intrinsics.checkNotNullParameter(str9, "profileName");
        Intrinsics.checkNotNullParameter(str10, "state");
        Intrinsics.checkNotNullParameter(str11, "tier");
        Intrinsics.checkNotNullParameter(str12, "userName");
        this.acr = acr2;
        this.avatar = str;
        this.displayName = str2;
        this.highlight = highlight3;
        this.id = i;
        this.lastSeen = str8;
        this.liveStream = liveStream3;
        this.prime = z;
        this.pro = z2;
        this.profileName = str9;
        this.state = str10;
        this.tier = str11;
        this.userName = str12;
        this.userNameClaimed = z3;
        this.isFollowing = z4;
    }

    public static /* synthetic */ Player copy$default(Player player, Acr acr2, String str, String str2, Highlight highlight2, int i, String str3, LiveStream liveStream2, boolean z, boolean z2, String str4, String str5, String str6, String str7, boolean z3, boolean z4, int i2, Object obj) {
        Player player2 = player;
        int i3 = i2;
        return player.copy((i3 & 1) != 0 ? player2.acr : acr2, (i3 & 2) != 0 ? player2.avatar : str, (i3 & 4) != 0 ? player2.displayName : str2, (i3 & 8) != 0 ? player2.highlight : highlight2, (i3 & 16) != 0 ? player2.id : i, (i3 & 32) != 0 ? player2.lastSeen : str3, (i3 & 64) != 0 ? player2.liveStream : liveStream2, (i3 & 128) != 0 ? player2.prime : z, (i3 & 256) != 0 ? player2.pro : z2, (i3 & 512) != 0 ? player2.profileName : str4, (i3 & 1024) != 0 ? player2.state : str5, (i3 & 2048) != 0 ? player2.tier : str6, (i3 & 4096) != 0 ? player2.userName : str7, (i3 & 8192) != 0 ? player2.userNameClaimed : z3, (i3 & 16384) != 0 ? player2.isFollowing : z4);
    }

    public final Acr component1() {
        return this.acr;
    }

    public final String component10() {
        return this.profileName;
    }

    public final String component11() {
        return this.state;
    }

    public final String component12() {
        return this.tier;
    }

    public final String component13() {
        return this.userName;
    }

    public final boolean component14() {
        return this.userNameClaimed;
    }

    public final boolean component15() {
        return this.isFollowing;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.displayName;
    }

    public final Highlight component4() {
        return this.highlight;
    }

    public final int component5() {
        return this.id;
    }

    public final String component6() {
        return this.lastSeen;
    }

    public final LiveStream component7() {
        return this.liveStream;
    }

    public final boolean component8() {
        return this.prime;
    }

    public final boolean component9() {
        return this.pro;
    }

    public final Player copy(Acr acr2, String str, String str2, Highlight highlight2, int i, String str3, LiveStream liveStream2, boolean z, boolean z2, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        Acr acr3 = acr2;
        Intrinsics.checkNotNullParameter(acr3, "acr");
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, "avatar");
        String str9 = str2;
        Intrinsics.checkNotNullParameter(str9, "displayName");
        Highlight highlight3 = highlight2;
        Intrinsics.checkNotNullParameter(highlight3, "highlight");
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "lastSeen");
        LiveStream liveStream3 = liveStream2;
        Intrinsics.checkNotNullParameter(liveStream3, "liveStream");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "profileName");
        String str12 = str5;
        Intrinsics.checkNotNullParameter(str12, "state");
        String str13 = str6;
        Intrinsics.checkNotNullParameter(str13, "tier");
        String str14 = str7;
        Intrinsics.checkNotNullParameter(str14, "userName");
        Player player = new Player(acr3, str8, str9, highlight3, i, str10, liveStream3, z, z2, str11, str12, str13, str14, z3, z4);
        return player;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        Player player = (Player) obj;
        return Intrinsics.areEqual(this.acr, player.acr) && Intrinsics.areEqual(this.avatar, player.avatar) && Intrinsics.areEqual(this.displayName, player.displayName) && Intrinsics.areEqual(this.highlight, player.highlight) && this.id == player.id && Intrinsics.areEqual(this.lastSeen, player.lastSeen) && Intrinsics.areEqual(this.liveStream, player.liveStream) && this.prime == player.prime && this.pro == player.pro && Intrinsics.areEqual(this.profileName, player.profileName) && Intrinsics.areEqual(this.state, player.state) && Intrinsics.areEqual(this.tier, player.tier) && Intrinsics.areEqual(this.userName, player.userName) && this.userNameClaimed == player.userNameClaimed && this.isFollowing == player.isFollowing;
    }

    public final Acr getAcr() {
        return this.acr;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Highlight getHighlight() {
        return this.highlight;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLastSeen() {
        return this.lastSeen;
    }

    public final LiveStream getLiveStream() {
        return this.liveStream;
    }

    public final boolean getPrime() {
        return this.prime;
    }

    public final boolean getPro() {
        return this.pro;
    }

    public final String getProfileName() {
        return this.profileName;
    }

    public final String getState() {
        return this.state;
    }

    public final String getTier() {
        return this.tier;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean getUserNameClaimed() {
        return this.userNameClaimed;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.displayName, GeneratedOutlineSupport.outline11(this.avatar, this.acr.hashCode() * 31, 31), 31);
        int hashCode = (this.liveStream.hashCode() + GeneratedOutlineSupport.outline11(this.lastSeen, (((this.highlight.hashCode() + outline11) * 31) + this.id) * 31, 31)) * 31;
        boolean z = this.prime;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.pro;
        if (z2) {
            z2 = true;
        }
        int outline112 = GeneratedOutlineSupport.outline11(this.userName, GeneratedOutlineSupport.outline11(this.tier, GeneratedOutlineSupport.outline11(this.state, GeneratedOutlineSupport.outline11(this.profileName, (i2 + (z2 ? 1 : 0)) * 31, 31), 31), 31), 31);
        boolean z3 = this.userNameClaimed;
        if (z3) {
            z3 = true;
        }
        int i3 = (outline112 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isFollowing;
        if (!z4) {
            i = z4;
        }
        return i3 + i;
    }

    public final boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setFollowing(boolean z) {
        this.isFollowing = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Player(acr=");
        outline73.append(this.acr);
        outline73.append(", avatar=");
        outline73.append(this.avatar);
        outline73.append(", displayName=");
        outline73.append(this.displayName);
        outline73.append(", highlight=");
        outline73.append(this.highlight);
        outline73.append(", id=");
        outline73.append(this.id);
        outline73.append(", lastSeen=");
        outline73.append(this.lastSeen);
        outline73.append(", liveStream=");
        outline73.append(this.liveStream);
        outline73.append(", prime=");
        outline73.append(this.prime);
        outline73.append(", pro=");
        outline73.append(this.pro);
        outline73.append(", profileName=");
        outline73.append(this.profileName);
        outline73.append(", state=");
        outline73.append(this.state);
        outline73.append(", tier=");
        outline73.append(this.tier);
        outline73.append(", userName=");
        outline73.append(this.userName);
        outline73.append(", userNameClaimed=");
        outline73.append(this.userNameClaimed);
        outline73.append(", isFollowing=");
        return GeneratedOutlineSupport.outline65(outline73, this.isFollowing, ')');
    }

    public /* synthetic */ Player(Acr acr2, String str, String str2, Highlight highlight2, int i, String str3, LiveStream liveStream2, boolean z, boolean z2, String str4, String str5, String str6, String str7, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(acr2, str, str2, highlight2, i, str3, liveStream2, z, z2, str4, str5, str6, str7, z3, (i2 & 16384) != 0 ? false : z4);
    }
}
