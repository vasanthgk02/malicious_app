package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/FollowDetails;", "", "followed", "", "followerCount", "", "following", "followingCount", "(ZIZI)V", "getFollowed", "()Z", "getFollowerCount", "()I", "getFollowing", "getFollowingCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowDetails.kt */
public final class FollowDetails {
    @SerializedName("followed")
    public final boolean followed;
    @SerializedName("followerCount")
    public final int followerCount;
    @SerializedName("following")
    public final boolean following;
    @SerializedName("followingCount")
    public final int followingCount;

    public FollowDetails(boolean z, int i, boolean z2, int i2) {
        this.followed = z;
        this.followerCount = i;
        this.following = z2;
        this.followingCount = i2;
    }

    public static /* synthetic */ FollowDetails copy$default(FollowDetails followDetails, boolean z, int i, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = followDetails.followed;
        }
        if ((i3 & 2) != 0) {
            i = followDetails.followerCount;
        }
        if ((i3 & 4) != 0) {
            z2 = followDetails.following;
        }
        if ((i3 & 8) != 0) {
            i2 = followDetails.followingCount;
        }
        return followDetails.copy(z, i, z2, i2);
    }

    public final boolean component1() {
        return this.followed;
    }

    public final int component2() {
        return this.followerCount;
    }

    public final boolean component3() {
        return this.following;
    }

    public final int component4() {
        return this.followingCount;
    }

    public final FollowDetails copy(boolean z, int i, boolean z2, int i2) {
        return new FollowDetails(z, i, z2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowDetails)) {
            return false;
        }
        FollowDetails followDetails = (FollowDetails) obj;
        return this.followed == followDetails.followed && this.followerCount == followDetails.followerCount && this.following == followDetails.following && this.followingCount == followDetails.followingCount;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    public final int getFollowerCount() {
        return this.followerCount;
    }

    public final boolean getFollowing() {
        return this.following;
    }

    public final int getFollowingCount() {
        return this.followingCount;
    }

    public int hashCode() {
        boolean z = this.followed;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (((z ? 1 : 0) * true) + this.followerCount) * 31;
        boolean z2 = this.following;
        if (!z2) {
            i = z2;
        }
        return ((i2 + i) * 31) + this.followingCount;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FollowDetails(followed=");
        outline73.append(this.followed);
        outline73.append(", followerCount=");
        outline73.append(this.followerCount);
        outline73.append(", following=");
        outline73.append(this.following);
        outline73.append(", followingCount=");
        return GeneratedOutlineSupport.outline56(outline73, this.followingCount, ')');
    }
}
