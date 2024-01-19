package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "", "basicUser", "Lcom/mpl/androidapp/miniprofile/models/BasicUser;", "detailedProfile", "Lcom/mpl/androidapp/miniprofile/models/DetailedProfile;", "extendedFields", "Lcom/mpl/androidapp/miniprofile/models/ExtendedFields;", "followDetails", "Lcom/mpl/androidapp/miniprofile/models/FollowDetails;", "(Lcom/mpl/androidapp/miniprofile/models/BasicUser;Lcom/mpl/androidapp/miniprofile/models/DetailedProfile;Lcom/mpl/androidapp/miniprofile/models/ExtendedFields;Lcom/mpl/androidapp/miniprofile/models/FollowDetails;)V", "getBasicUser", "()Lcom/mpl/androidapp/miniprofile/models/BasicUser;", "getDetailedProfile", "()Lcom/mpl/androidapp/miniprofile/models/DetailedProfile;", "getExtendedFields", "()Lcom/mpl/androidapp/miniprofile/models/ExtendedFields;", "getFollowDetails", "()Lcom/mpl/androidapp/miniprofile/models/FollowDetails;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileDetails.kt */
public final class ProfileDetails {
    @SerializedName("basicUser")
    public final BasicUser basicUser;
    @SerializedName("detailedProfile")
    public final DetailedProfile detailedProfile;
    @SerializedName("extendedFields")
    public final ExtendedFields extendedFields;
    @SerializedName("followDetails")
    public final FollowDetails followDetails;

    public ProfileDetails(BasicUser basicUser2, DetailedProfile detailedProfile2, ExtendedFields extendedFields2, FollowDetails followDetails2) {
        Intrinsics.checkNotNullParameter(basicUser2, "basicUser");
        Intrinsics.checkNotNullParameter(detailedProfile2, "detailedProfile");
        Intrinsics.checkNotNullParameter(extendedFields2, "extendedFields");
        Intrinsics.checkNotNullParameter(followDetails2, "followDetails");
        this.basicUser = basicUser2;
        this.detailedProfile = detailedProfile2;
        this.extendedFields = extendedFields2;
        this.followDetails = followDetails2;
    }

    public static /* synthetic */ ProfileDetails copy$default(ProfileDetails profileDetails, BasicUser basicUser2, DetailedProfile detailedProfile2, ExtendedFields extendedFields2, FollowDetails followDetails2, int i, Object obj) {
        if ((i & 1) != 0) {
            basicUser2 = profileDetails.basicUser;
        }
        if ((i & 2) != 0) {
            detailedProfile2 = profileDetails.detailedProfile;
        }
        if ((i & 4) != 0) {
            extendedFields2 = profileDetails.extendedFields;
        }
        if ((i & 8) != 0) {
            followDetails2 = profileDetails.followDetails;
        }
        return profileDetails.copy(basicUser2, detailedProfile2, extendedFields2, followDetails2);
    }

    public final BasicUser component1() {
        return this.basicUser;
    }

    public final DetailedProfile component2() {
        return this.detailedProfile;
    }

    public final ExtendedFields component3() {
        return this.extendedFields;
    }

    public final FollowDetails component4() {
        return this.followDetails;
    }

    public final ProfileDetails copy(BasicUser basicUser2, DetailedProfile detailedProfile2, ExtendedFields extendedFields2, FollowDetails followDetails2) {
        Intrinsics.checkNotNullParameter(basicUser2, "basicUser");
        Intrinsics.checkNotNullParameter(detailedProfile2, "detailedProfile");
        Intrinsics.checkNotNullParameter(extendedFields2, "extendedFields");
        Intrinsics.checkNotNullParameter(followDetails2, "followDetails");
        return new ProfileDetails(basicUser2, detailedProfile2, extendedFields2, followDetails2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDetails)) {
            return false;
        }
        ProfileDetails profileDetails = (ProfileDetails) obj;
        return Intrinsics.areEqual(this.basicUser, profileDetails.basicUser) && Intrinsics.areEqual(this.detailedProfile, profileDetails.detailedProfile) && Intrinsics.areEqual(this.extendedFields, profileDetails.extendedFields) && Intrinsics.areEqual(this.followDetails, profileDetails.followDetails);
    }

    public final BasicUser getBasicUser() {
        return this.basicUser;
    }

    public final DetailedProfile getDetailedProfile() {
        return this.detailedProfile;
    }

    public final ExtendedFields getExtendedFields() {
        return this.extendedFields;
    }

    public final FollowDetails getFollowDetails() {
        return this.followDetails;
    }

    public int hashCode() {
        int hashCode = this.detailedProfile.hashCode();
        int hashCode2 = this.extendedFields.hashCode();
        return this.followDetails.hashCode() + ((hashCode2 + ((hashCode + (this.basicUser.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProfileDetails(basicUser=");
        outline73.append(this.basicUser);
        outline73.append(", detailedProfile=");
        outline73.append(this.detailedProfile);
        outline73.append(", extendedFields=");
        outline73.append(this.extendedFields);
        outline73.append(", followDetails=");
        outline73.append(this.followDetails);
        outline73.append(')');
        return outline73.toString();
    }
}
