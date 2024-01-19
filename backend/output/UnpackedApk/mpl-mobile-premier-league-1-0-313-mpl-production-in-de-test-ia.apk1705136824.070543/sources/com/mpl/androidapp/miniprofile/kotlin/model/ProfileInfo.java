package com.mpl.androidapp.miniprofile.kotlin.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.miniprofile.models.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/ProfileInfo;", "", "payload", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "status", "Lcom/mpl/androidapp/miniprofile/models/Status;", "(Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;Lcom/mpl/androidapp/miniprofile/models/Status;)V", "getPayload", "()Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "getStatus", "()Lcom/mpl/androidapp/miniprofile/models/Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileInfo.kt */
public final class ProfileInfo {
    @SerializedName("payload")
    public final ProfileDetails payload;
    @SerializedName("status")
    public final Status status;

    public ProfileInfo(ProfileDetails profileDetails, Status status2) {
        Intrinsics.checkNotNullParameter(profileDetails, "payload");
        Intrinsics.checkNotNullParameter(status2, "status");
        this.payload = profileDetails;
        this.status = status2;
    }

    public static /* synthetic */ ProfileInfo copy$default(ProfileInfo profileInfo, ProfileDetails profileDetails, Status status2, int i, Object obj) {
        if ((i & 1) != 0) {
            profileDetails = profileInfo.payload;
        }
        if ((i & 2) != 0) {
            status2 = profileInfo.status;
        }
        return profileInfo.copy(profileDetails, status2);
    }

    public final ProfileDetails component1() {
        return this.payload;
    }

    public final Status component2() {
        return this.status;
    }

    public final ProfileInfo copy(ProfileDetails profileDetails, Status status2) {
        Intrinsics.checkNotNullParameter(profileDetails, "payload");
        Intrinsics.checkNotNullParameter(status2, "status");
        return new ProfileInfo(profileDetails, status2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileInfo)) {
            return false;
        }
        ProfileInfo profileInfo = (ProfileInfo) obj;
        return Intrinsics.areEqual(this.payload, profileInfo.payload) && Intrinsics.areEqual(this.status, profileInfo.status);
    }

    public final ProfileDetails getPayload() {
        return this.payload;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode() + (this.payload.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProfileInfo(payload=");
        outline73.append(this.payload);
        outline73.append(", status=");
        outline73.append(this.status);
        outline73.append(')');
        return outline73.toString();
    }
}
