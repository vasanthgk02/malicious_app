package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.utils.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b2\b\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\fHÆ\u0001J\u0013\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\nHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001e\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010%R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\u0013\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001e¨\u0006>"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/BasicUser;", "", "avatar", "", "avatars", "Lcom/mpl/androidapp/miniprofile/models/Avatars;", "displayName", "highlight", "Lcom/mpl/androidapp/miniprofile/models/Highlight;", "id", "", "ownProfile", "", "prime", "pro", "suid", "tier", "userName", "userNameClaimed", "videoCount", "profileAccountDeleted", "(Ljava/lang/String;Lcom/mpl/androidapp/miniprofile/models/Avatars;Ljava/lang/String;Lcom/mpl/androidapp/miniprofile/models/Highlight;IZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZ)V", "getAvatar", "()Ljava/lang/String;", "getAvatars", "()Lcom/mpl/androidapp/miniprofile/models/Avatars;", "getDisplayName", "getHighlight", "()Lcom/mpl/androidapp/miniprofile/models/Highlight;", "getId", "()I", "getOwnProfile", "()Z", "getPrime", "getPro", "getProfileAccountDeleted", "setProfileAccountDeleted", "(Z)V", "getSuid", "getTier", "getUserName", "getUserNameClaimed", "getVideoCount", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicUser.kt */
public final class BasicUser {
    @SerializedName("avatar")
    public final String avatar;
    @SerializedName("avatars")
    public final Avatars avatars;
    @SerializedName("displayName")
    public final String displayName;
    @SerializedName("highlight")
    public final Highlight highlight;
    @SerializedName("id")
    public final int id;
    @SerializedName("ownProfile")
    public final boolean ownProfile;
    @SerializedName("prime")
    public final boolean prime;
    @SerializedName("pro")
    public final boolean pro;
    @SerializedName("profileAccountDeleted")
    public boolean profileAccountDeleted;
    @SerializedName("suid")
    public final String suid;
    @SerializedName("tier")
    public final String tier;
    @SerializedName("userName")
    public final String userName;
    @SerializedName("userNameClaimed")
    public final boolean userNameClaimed;
    @SerializedName("videoCount")
    public final int videoCount;

    public BasicUser(String str, Avatars avatars2, String str2, Highlight highlight2, int i, boolean z, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4, int i2, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(avatars2, "avatars");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        Intrinsics.checkNotNullParameter(highlight2, "highlight");
        Intrinsics.checkNotNullParameter(str3, Constant.HASHED_UNIQUE_ID);
        Intrinsics.checkNotNullParameter(str4, "tier");
        Intrinsics.checkNotNullParameter(str5, "userName");
        this.avatar = str;
        this.avatars = avatars2;
        this.displayName = str2;
        this.highlight = highlight2;
        this.id = i;
        this.ownProfile = z;
        this.prime = z2;
        this.pro = z3;
        this.suid = str3;
        this.tier = str4;
        this.userName = str5;
        this.userNameClaimed = z4;
        this.videoCount = i2;
        this.profileAccountDeleted = z5;
    }

    public static /* synthetic */ BasicUser copy$default(BasicUser basicUser, String str, Avatars avatars2, String str2, Highlight highlight2, int i, boolean z, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4, int i2, boolean z5, int i3, Object obj) {
        BasicUser basicUser2 = basicUser;
        int i4 = i3;
        return basicUser.copy((i4 & 1) != 0 ? basicUser2.avatar : str, (i4 & 2) != 0 ? basicUser2.avatars : avatars2, (i4 & 4) != 0 ? basicUser2.displayName : str2, (i4 & 8) != 0 ? basicUser2.highlight : highlight2, (i4 & 16) != 0 ? basicUser2.id : i, (i4 & 32) != 0 ? basicUser2.ownProfile : z, (i4 & 64) != 0 ? basicUser2.prime : z2, (i4 & 128) != 0 ? basicUser2.pro : z3, (i4 & 256) != 0 ? basicUser2.suid : str3, (i4 & 512) != 0 ? basicUser2.tier : str4, (i4 & 1024) != 0 ? basicUser2.userName : str5, (i4 & 2048) != 0 ? basicUser2.userNameClaimed : z4, (i4 & 4096) != 0 ? basicUser2.videoCount : i2, (i4 & 8192) != 0 ? basicUser2.profileAccountDeleted : z5);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component10() {
        return this.tier;
    }

    public final String component11() {
        return this.userName;
    }

    public final boolean component12() {
        return this.userNameClaimed;
    }

    public final int component13() {
        return this.videoCount;
    }

    public final boolean component14() {
        return this.profileAccountDeleted;
    }

    public final Avatars component2() {
        return this.avatars;
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

    public final boolean component6() {
        return this.ownProfile;
    }

    public final boolean component7() {
        return this.prime;
    }

    public final boolean component8() {
        return this.pro;
    }

    public final String component9() {
        return this.suid;
    }

    public final BasicUser copy(String str, Avatars avatars2, String str2, Highlight highlight2, int i, boolean z, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4, int i2, boolean z5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "avatar");
        Avatars avatars3 = avatars2;
        Intrinsics.checkNotNullParameter(avatars3, "avatars");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "displayName");
        Highlight highlight3 = highlight2;
        Intrinsics.checkNotNullParameter(highlight3, "highlight");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, Constant.HASHED_UNIQUE_ID);
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "tier");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "userName");
        BasicUser basicUser = new BasicUser(str6, avatars3, str7, highlight3, i, z, z2, z3, str8, str9, str10, z4, i2, z5);
        return basicUser;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicUser)) {
            return false;
        }
        BasicUser basicUser = (BasicUser) obj;
        return Intrinsics.areEqual(this.avatar, basicUser.avatar) && Intrinsics.areEqual(this.avatars, basicUser.avatars) && Intrinsics.areEqual(this.displayName, basicUser.displayName) && Intrinsics.areEqual(this.highlight, basicUser.highlight) && this.id == basicUser.id && this.ownProfile == basicUser.ownProfile && this.prime == basicUser.prime && this.pro == basicUser.pro && Intrinsics.areEqual(this.suid, basicUser.suid) && Intrinsics.areEqual(this.tier, basicUser.tier) && Intrinsics.areEqual(this.userName, basicUser.userName) && this.userNameClaimed == basicUser.userNameClaimed && this.videoCount == basicUser.videoCount && this.profileAccountDeleted == basicUser.profileAccountDeleted;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final Avatars getAvatars() {
        return this.avatars;
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

    public final boolean getOwnProfile() {
        return this.ownProfile;
    }

    public final boolean getPrime() {
        return this.prime;
    }

    public final boolean getPro() {
        return this.pro;
    }

    public final boolean getProfileAccountDeleted() {
        return this.profileAccountDeleted;
    }

    public final String getSuid() {
        return this.suid;
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

    public final int getVideoCount() {
        return this.videoCount;
    }

    public int hashCode() {
        int hashCode = this.avatars.hashCode();
        int hashCode2 = (((this.highlight.hashCode() + GeneratedOutlineSupport.outline11(this.displayName, (hashCode + (this.avatar.hashCode() * 31)) * 31, 31)) * 31) + this.id) * 31;
        boolean z = this.ownProfile;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.prime;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.pro;
        if (z3) {
            z3 = true;
        }
        int outline11 = GeneratedOutlineSupport.outline11(this.userName, GeneratedOutlineSupport.outline11(this.tier, GeneratedOutlineSupport.outline11(this.suid, (i3 + (z3 ? 1 : 0)) * 31, 31), 31), 31);
        boolean z4 = this.userNameClaimed;
        if (z4) {
            z4 = true;
        }
        int i4 = (((outline11 + (z4 ? 1 : 0)) * 31) + this.videoCount) * 31;
        boolean z5 = this.profileAccountDeleted;
        if (!z5) {
            i = z5;
        }
        return i4 + i;
    }

    public final void setProfileAccountDeleted(boolean z) {
        this.profileAccountDeleted = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BasicUser(avatar=");
        outline73.append(this.avatar);
        outline73.append(", avatars=");
        outline73.append(this.avatars);
        outline73.append(", displayName=");
        outline73.append(this.displayName);
        outline73.append(", highlight=");
        outline73.append(this.highlight);
        outline73.append(", id=");
        outline73.append(this.id);
        outline73.append(", ownProfile=");
        outline73.append(this.ownProfile);
        outline73.append(", prime=");
        outline73.append(this.prime);
        outline73.append(", pro=");
        outline73.append(this.pro);
        outline73.append(", suid=");
        outline73.append(this.suid);
        outline73.append(", tier=");
        outline73.append(this.tier);
        outline73.append(", userName=");
        outline73.append(this.userName);
        outline73.append(", userNameClaimed=");
        outline73.append(this.userNameClaimed);
        outline73.append(", videoCount=");
        outline73.append(this.videoCount);
        outline73.append(", profileAccountDeleted=");
        return GeneratedOutlineSupport.outline65(outline73, this.profileAccountDeleted, ')');
    }

    public /* synthetic */ BasicUser(String str, Avatars avatars2, String str2, Highlight highlight2, int i, boolean z, boolean z2, boolean z3, String str3, String str4, String str5, boolean z4, int i2, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, avatars2, str2, highlight2, i, z, z2, z3, str3, str4, str5, z4, i2, (i3 & 8192) != 0 ? false : z5);
    }
}
