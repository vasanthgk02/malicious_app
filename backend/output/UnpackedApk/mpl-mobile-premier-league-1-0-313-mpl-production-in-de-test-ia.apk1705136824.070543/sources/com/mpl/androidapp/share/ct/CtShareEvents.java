package com.mpl.androidapp.share.ct;

import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/share/ct/CtShareEvents;", "", "()V", "shareEvent", "", "shareData", "Lcom/mpl/androidapp/share/models/ShareData;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CtShareEvents.kt */
public final class CtShareEvents {
    public static final CtShareEvents INSTANCE = new CtShareEvents();

    public final void shareEvent(ShareData shareData) {
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        HashMap hashMap = new HashMap();
        hashMap.put("Entry Point", shareData.getEntryPoint());
        hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, shareData.getPackageName());
        hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, shareData.getScreenName());
        hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_SKIP_SCREEN, Boolean.valueOf(shareData.getShareSkipScreen()));
        CleverTapAnalyticsUtils.sendEvent((String) "Share Initiated", hashMap);
    }
}
