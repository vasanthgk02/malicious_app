package com.mpl.androidapp.miniprofile.service.utils;

import com.razorpay.AnalyticsConstants;
import java.util.IdentityHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tB\u0005¢\u0006\u0002\u0010\nJ\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0017J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u001a\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplQueryParams;", "", "count", "", "start", "gameBroadcastId", "", "(IILjava/lang/String;)V", "userId", "(Ljava/lang/String;)V", "()V", "getCount", "()I", "setCount", "(I)V", "getGameBroadcastId", "()Ljava/lang/String;", "setGameBroadcastId", "getStart", "setStart", "getUserId", "setUserId", "preparePlayersApiHeader", "Ljava/util/IdentityHashMap;", "prepareProfileDetails", "prepareRecommendedVideosHeaderApiHeader", "viewingGameBroadcastId", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplQueryParams.kt */
public final class MplQueryParams {
    public int count;
    public String gameBroadcastId;
    public int start;
    public String userId;

    public MplQueryParams() {
        this.userId = "";
        this.gameBroadcastId = "";
    }

    public final int getCount() {
        return this.count;
    }

    public final String getGameBroadcastId() {
        return this.gameBroadcastId;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final IdentityHashMap<String, String> preparePlayersApiHeader() {
        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("count", String.valueOf(this.count));
        identityHashMap.put(AnalyticsConstants.START, String.valueOf(this.start));
        identityHashMap.put("gameBroadcastId", this.gameBroadcastId);
        return identityHashMap;
    }

    public final IdentityHashMap<String, String> prepareProfileDetails() {
        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("userId", this.userId);
        return identityHashMap;
    }

    public final IdentityHashMap<String, String> prepareRecommendedVideosHeaderApiHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "viewingGameBroadcastId");
        IdentityHashMap<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("viewingGameBroadcastId", str);
        return identityHashMap;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setGameBroadcastId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameBroadcastId = str;
    }

    public final void setStart(int i) {
        this.start = i;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplQueryParams(int i, int i2, String str) {
        // Intrinsics.checkNotNullParameter(str, "gameBroadcastId");
        this();
        this.count = i;
        this.start = i2;
        this.gameBroadcastId = str;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MplQueryParams(String str) {
        // Intrinsics.checkNotNullParameter(str, "userId");
        this();
        this.userId = str;
    }
}
