package com.mpl.androidapp.miniprofile.ct;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.ct.C.BroadcastEndSlateClicked;
import com.mpl.androidapp.miniprofile.ct.C.BroadcastEndSlateViewed;
import com.mpl.androidapp.miniprofile.ct.C.CtaEventClicked;
import com.mpl.androidapp.miniprofile.ct.C.InternalShare;
import com.mpl.androidapp.miniprofile.ct.C.OrientationChanged;
import com.mpl.androidapp.miniprofile.ct.C.ProfileFollowed;
import com.mpl.androidapp.miniprofile.ct.C.ViewerPropertyGroup;
import com.mpl.androidapp.miniprofile.kotlin.model.Broadcast;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J4\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00042\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\tH\u0002J4\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00042\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/miniprofile/ct/GameBroadcastCt;", "", "()V", "TAG", "", "kafkaOnlyEvents", "", "getViewerPropertyGroupMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "broadcast", "Lcom/mpl/androidapp/miniprofile/kotlin/model/Broadcast;", "entryPoint", "sessionId", "sendCTAEvent", "", "broadcastId", "ctaId", "userId", "sendEventToCleverTapAndKafka", "eventName", "properties", "sendEventToKafka", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameBroadcastCt.kt */
public final class GameBroadcastCt {
    public static final GameBroadcastCt INSTANCE = new GameBroadcastCt();
    public static final String TAG = "GameBroadcastCt";
    public static final Set<String> kafkaOnlyEvents = TweetUtils.setOf((T[]) new String[]{BroadcastEndSlateViewed.EVENT_NAME, BroadcastEndSlateClicked.EVENT_NAME, OrientationChanged.EVENT_NAME, InternalShare.EVENT_DISCLAIMER_ACCEPTED, InternalShare.EVENT_SHARE_COMPLETED, ProfileFollowed.EVENT_NAME});

    private final HashMap<String, Object> getViewerPropertyGroupMap(Context context, Broadcast broadcast, String str, String str2) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(ViewerPropertyGroup.VIEWER_ID, String.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(context)));
        String userName = MSharedPreferencesUtils.getUserName();
        Intrinsics.checkNotNullExpressionValue(userName, "getUserName()");
        hashMap.put(ViewerPropertyGroup.USER_NAME, userName);
        hashMap.put(ViewerPropertyGroup.ENTRY_POINT, str);
        if (broadcast != null) {
            hashMap.put(ViewerPropertyGroup.BROADCAST_ID, broadcast.getGameBroadcastId());
            hashMap.put(ViewerPropertyGroup.BROADCAST_NAME, broadcast.getHostedBy());
            hashMap.put(ViewerPropertyGroup.BROADCAST_STATUS, broadcast.getStatus());
        }
        hashMap.put(ViewerPropertyGroup.SESSION_ID, str2);
        return hashMap;
    }

    private final void sendEventToCleverTapAndKafka(String str, HashMap<String, Object> hashMap) {
        MLogger.d(TAG, "sendEventToCleverTapAndKafka");
        CleverTapAnalyticsUtils.sendEvent(str, hashMap);
    }

    private final void sendEventToKafka(String str, HashMap<String, Object> hashMap) {
        MLogger.d(TAG, "sendEventToKafka");
        CleverTapAnalyticsUtils.addKafkaEvent(str, hashMap);
    }

    public final void sendCTAEvent(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "broadcastId", str2, "ctaId", str3, "userId");
        CleverTapAnalyticsUtils.sendEvent((String) CtaEventClicked.EVENT_NAME_CTA, ArraysKt___ArraysJvmKt.hashMapOf(new Pair(CtaEventClicked.PROPERTY_CTA_ID, str2), new Pair(CtaEventClicked.PROPERTY_GB_ID, str), new Pair("User ID", str3)));
    }
}
