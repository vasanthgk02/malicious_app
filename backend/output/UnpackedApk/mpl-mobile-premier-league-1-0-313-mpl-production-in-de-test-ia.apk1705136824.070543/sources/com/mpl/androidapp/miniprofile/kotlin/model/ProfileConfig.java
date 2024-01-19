package com.mpl.androidapp.miniprofile.kotlin.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/ProfileConfig;", "", "usernameEnabled", "", "showKycVerifiedStatus", "profileShowWinRate", "(ZZZ)V", "getProfileShowWinRate", "()Z", "setProfileShowWinRate", "(Z)V", "getShowKycVerifiedStatus", "setShowKycVerifiedStatus", "getUsernameEnabled", "setUsernameEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileConfig.kt */
public final class ProfileConfig {
    @SerializedName("profileShowWinRate")
    public boolean profileShowWinRate;
    @SerializedName("showKycVerifiedStatus")
    public boolean showKycVerifiedStatus;
    @SerializedName("usernameEnabled")
    public boolean usernameEnabled;

    public ProfileConfig() {
        this(false, false, false, 7, null);
    }

    public ProfileConfig(boolean z, boolean z2, boolean z3) {
        this.usernameEnabled = z;
        this.showKycVerifiedStatus = z2;
        this.profileShowWinRate = z3;
    }

    public static /* synthetic */ ProfileConfig copy$default(ProfileConfig profileConfig, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = profileConfig.usernameEnabled;
        }
        if ((i & 2) != 0) {
            z2 = profileConfig.showKycVerifiedStatus;
        }
        if ((i & 4) != 0) {
            z3 = profileConfig.profileShowWinRate;
        }
        return profileConfig.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.usernameEnabled;
    }

    public final boolean component2() {
        return this.showKycVerifiedStatus;
    }

    public final boolean component3() {
        return this.profileShowWinRate;
    }

    public final ProfileConfig copy(boolean z, boolean z2, boolean z3) {
        return new ProfileConfig(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileConfig)) {
            return false;
        }
        ProfileConfig profileConfig = (ProfileConfig) obj;
        return this.usernameEnabled == profileConfig.usernameEnabled && this.showKycVerifiedStatus == profileConfig.showKycVerifiedStatus && this.profileShowWinRate == profileConfig.profileShowWinRate;
    }

    public final boolean getProfileShowWinRate() {
        return this.profileShowWinRate;
    }

    public final boolean getShowKycVerifiedStatus() {
        return this.showKycVerifiedStatus;
    }

    public final boolean getUsernameEnabled() {
        return this.usernameEnabled;
    }

    public int hashCode() {
        boolean z = this.usernameEnabled;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z2 = this.showKycVerifiedStatus;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.profileShowWinRate;
        if (!z3) {
            i = z3;
        }
        return i3 + i;
    }

    public final void setProfileShowWinRate(boolean z) {
        this.profileShowWinRate = z;
    }

    public final void setShowKycVerifiedStatus(boolean z) {
        this.showKycVerifiedStatus = z;
    }

    public final void setUsernameEnabled(boolean z) {
        this.usernameEnabled = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProfileConfig(usernameEnabled=");
        outline73.append(this.usernameEnabled);
        outline73.append(", showKycVerifiedStatus=");
        outline73.append(this.showKycVerifiedStatus);
        outline73.append(", profileShowWinRate=");
        return GeneratedOutlineSupport.outline65(outline73, this.profileShowWinRate, ')');
    }

    public /* synthetic */ ProfileConfig(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
