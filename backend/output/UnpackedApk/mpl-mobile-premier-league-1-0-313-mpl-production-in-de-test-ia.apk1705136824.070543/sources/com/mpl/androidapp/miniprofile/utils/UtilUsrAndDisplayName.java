package com.mpl.androidapp.miniprofile.utils;

import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/miniprofile/utils/UtilUsrAndDisplayName;", "", "()V", "toggleNameBasedOnConfig", "", "isUsrNameEnabled", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UtilUsrAndDisplayName.kt */
public final class UtilUsrAndDisplayName {
    public final String toggleNameBasedOnConfig(boolean z) {
        if (z) {
            String userName = MSharedPreferencesUtils.getUserName();
            Intrinsics.checkNotNullExpressionValue(userName, "{ MSharedPreferencesUtils.getUserName() }");
            return userName;
        }
        String displayName = MSharedPreferencesUtils.getUserInfo().getDisplayName();
        Intrinsics.checkNotNullExpressionValue(displayName, "{ MSharedPreferencesUtil…tUserInfo().displayName }");
        return displayName;
    }
}
