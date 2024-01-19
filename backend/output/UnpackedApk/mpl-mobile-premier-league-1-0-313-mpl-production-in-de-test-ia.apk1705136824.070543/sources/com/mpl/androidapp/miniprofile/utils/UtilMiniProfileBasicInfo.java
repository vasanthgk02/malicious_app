package com.mpl.androidapp.miniprofile.utils;

import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\r\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/mpl/androidapp/miniprofile/utils/UtilMiniProfileBasicInfo;", "", "profileDetails", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "loggedInUser", "", "(Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;I)V", "getLoggedInUser", "()I", "setLoggedInUser", "(I)V", "getProfileDetails", "()Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "setProfileDetails", "(Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;)V", "cashWon", "", "followers", "following", "getAvatar", "getBadge", "()Ljava/lang/Integer;", "getBio", "getName", "isBioPresent", "", "isFollowing", "isLoggedInUser", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UtilMiniProfileBasicInfo.kt */
public final class UtilMiniProfileBasicInfo {
    public int loggedInUser;
    public ProfileDetails profileDetails;

    public UtilMiniProfileBasicInfo(ProfileDetails profileDetails2, int i) {
        Intrinsics.checkNotNullParameter(profileDetails2, "profileDetails");
        this.profileDetails = profileDetails2;
        this.loggedInUser = i;
    }

    public final String cashWon() {
        return String.valueOf(this.profileDetails.getDetailedProfile().getTotalCash());
    }

    public final String followers() {
        return String.valueOf(this.profileDetails.getFollowDetails().getFollowerCount());
    }

    public final String following() {
        return String.valueOf(this.profileDetails.getFollowDetails().getFollowingCount());
    }

    public final String getAvatar() {
        return this.profileDetails.getBasicUser().getAvatar();
    }

    public final Integer getBadge() {
        return new UtilBadgeMatcher().getBadge(this.profileDetails.getBasicUser().getTier());
    }

    public final String getBio() {
        return this.profileDetails.getExtendedFields().getBio();
    }

    public final int getLoggedInUser() {
        return this.loggedInUser;
    }

    public final String getName() {
        return this.profileDetails.getBasicUser().getDisplayName();
    }

    public final ProfileDetails getProfileDetails() {
        return this.profileDetails;
    }

    public final boolean isBioPresent() {
        return this.profileDetails.getExtendedFields().getBio().length() > 0;
    }

    public final boolean isFollowing() {
        return this.profileDetails.getFollowDetails().getFollowing();
    }

    public final boolean isLoggedInUser() {
        return this.profileDetails.getBasicUser().getId() == this.loggedInUser;
    }

    public final void setLoggedInUser(int i) {
        this.loggedInUser = i;
    }

    public final void setProfileDetails(ProfileDetails profileDetails2) {
        Intrinsics.checkNotNullParameter(profileDetails2, "<set-?>");
        this.profileDetails = profileDetails2;
    }
}
