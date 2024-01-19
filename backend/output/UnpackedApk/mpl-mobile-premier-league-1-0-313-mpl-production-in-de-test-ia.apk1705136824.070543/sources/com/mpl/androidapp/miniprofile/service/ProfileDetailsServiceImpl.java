package com.mpl.androidapp.miniprofile.service;

import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/ProfileDetailsServiceImpl;", "", "profileInfoApiFailureResponse", "", "success", "", "responseString", "", "profileInfoApiSuccessResponse", "profileDetails", "Lcom/mpl/androidapp/miniprofile/models/ProfileDetails;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileDetailsService.kt */
public interface ProfileDetailsServiceImpl {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProfileDetailsService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void profileInfoApiFailureResponse$default(ProfileDetailsServiceImpl profileDetailsServiceImpl, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                profileDetailsServiceImpl.profileInfoApiFailureResponse(z, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: profileInfoApiFailureResponse");
        }
    }

    void profileInfoApiFailureResponse(boolean z, String str);

    void profileInfoApiSuccessResponse(boolean z, ProfileDetails profileDetails);
}
