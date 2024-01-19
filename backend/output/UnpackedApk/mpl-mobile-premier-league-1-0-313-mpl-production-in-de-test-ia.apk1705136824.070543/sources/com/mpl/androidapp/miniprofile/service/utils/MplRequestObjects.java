package com.mpl.androidapp.miniprofile.service.utils;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.payment.routing.RoutingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplRequestObjects;", "", "()V", "prepareFollowPlayerRequest", "Lorg/json/JSONObject;", "userId", "", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MplRequestObjects.kt */
public final class MplRequestObjects {
    public static final String BROADCAST_ID_PARAM = "gameBroadcastId";
    public static final String CARD_TYPE = RoutingConstants.MI_REACT_SAVED_CARD_TYPE;
    public static final String CHANNEL_URLS = "channelUrls";
    public static final String COUNT_PARAM = "count";
    public static final Companion Companion = new Companion(null);
    public static final String DATA = "data";
    public static final String DEEP_LINK = "deepLink";
    public static final String FOLLOW_USER_ID = "followUserId";
    public static final String GENERATED_BY = "generatedBy";
    public static final String MESSAGE_ID = "messageId";
    public static final String MIN_APP_VERSION = "minAppVersion";
    public static final String SOURCE = DefaultSettingsSpiCall.SOURCE_PARAM;
    public static final String TARGET_USERS_IDS = "targetUserIds";
    public static final String TITLE = "title";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/miniprofile/service/utils/MplRequestObjects$Companion;", "", "()V", "BROADCAST_ID_PARAM", "", "CARD_TYPE", "CHANNEL_URLS", "COUNT_PARAM", "DATA", "DEEP_LINK", "FOLLOW_USER_ID", "GENERATED_BY", "MESSAGE_ID", "MIN_APP_VERSION", "SOURCE", "TARGET_USERS_IDS", "TITLE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MplRequestObjects.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final JSONObject prepareFollowPlayerRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        JSONObject put = new JSONObject().put(FOLLOW_USER_ID, str).put(SOURCE, "add source");
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject().put(FOLLOW_…put(SOURCE, \"add source\")");
        return put;
    }
}
