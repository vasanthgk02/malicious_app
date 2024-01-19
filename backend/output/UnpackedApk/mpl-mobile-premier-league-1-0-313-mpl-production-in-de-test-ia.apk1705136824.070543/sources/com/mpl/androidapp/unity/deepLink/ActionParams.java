package com.mpl.androidapp.unity.deepLink;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/unity/deepLink/ActionParams;", "T", "", "actionType", "", "actionPayload", "Lcom/mpl/androidapp/unity/deepLink/ActionPayload;", "(Ljava/lang/String;Lcom/mpl/androidapp/unity/deepLink/ActionPayload;)V", "getActionPayload", "()Lcom/mpl/androidapp/unity/deepLink/ActionPayload;", "getActionType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionParams.kt */
public final class ActionParams<T> {
    public static final String ACTION_OPEN_DEEP_LINK = "OPEN_DEEP_LINK";
    public static final String ACTION_TYPE_CHAT = "chat";
    public static final String ACTION_TYPE_NAV = "nav";
    public static final String ACTION_TYPE_OPEN_PLAYER = "open_game_broadcast_player";
    public static final Companion Companion = new Companion(null);
    public static final String ENTRY_ANDROID_GBC_RECOMMENDED_SECTION = "ANDROID_GBC_RECOMMENDED_SECTION";
    public static final String ENTRY_FROM_MINI_PROFILE = "UserProfileMini";
    public static final String ENTRY_GAME_BROADCAST = "GAME_BROADCAST_USER_PROFILE";
    public static final String ENTRY_UNITY_USER_PROFILE = "UNITY_USER_PROFILE";
    public static final String KEY_ACTION = "action";
    public static final String KEY_ACTION_PARAMS = "actionParams";
    public static final String KNOCK_OUT_DETAILS = "KnockoutDetails";
    public static final String ROUTE_GAME_BROADCAST_TAB = "GameBroadcastDiscoveryTab";
    public static final String ROUTE_MESSAGES_DIRECT = "MessagesDirect";
    public static final String ROUTE_USER_PROFILE = "UserProfile";
    public final ActionPayload<T> actionPayload;
    public final String actionType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/unity/deepLink/ActionParams$Companion;", "", "()V", "ACTION_OPEN_DEEP_LINK", "", "ACTION_TYPE_CHAT", "ACTION_TYPE_NAV", "ACTION_TYPE_OPEN_PLAYER", "ENTRY_ANDROID_GBC_RECOMMENDED_SECTION", "ENTRY_FROM_MINI_PROFILE", "ENTRY_GAME_BROADCAST", "ENTRY_UNITY_USER_PROFILE", "KEY_ACTION", "KEY_ACTION_PARAMS", "KNOCK_OUT_DETAILS", "ROUTE_GAME_BROADCAST_TAB", "ROUTE_MESSAGES_DIRECT", "ROUTE_USER_PROFILE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionParams.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ActionParams(String str, ActionPayload<T> actionPayload2) {
        Intrinsics.checkNotNullParameter(str, OneSingnalConstant.PARAM_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(actionPayload2, OneSingnalConstant.PARAM_ACTION_PAYLOAD);
        this.actionType = str;
        this.actionPayload = actionPayload2;
    }

    public static /* synthetic */ ActionParams copy$default(ActionParams actionParams, String str, ActionPayload<T> actionPayload2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionParams.actionType;
        }
        if ((i & 2) != 0) {
            actionPayload2 = actionParams.actionPayload;
        }
        return actionParams.copy(str, actionPayload2);
    }

    public final String component1() {
        return this.actionType;
    }

    public final ActionPayload<T> component2() {
        return this.actionPayload;
    }

    public final ActionParams<T> copy(String str, ActionPayload<T> actionPayload2) {
        Intrinsics.checkNotNullParameter(str, OneSingnalConstant.PARAM_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(actionPayload2, OneSingnalConstant.PARAM_ACTION_PAYLOAD);
        return new ActionParams<>(str, actionPayload2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionParams)) {
            return false;
        }
        ActionParams actionParams = (ActionParams) obj;
        return Intrinsics.areEqual(this.actionType, actionParams.actionType) && Intrinsics.areEqual(this.actionPayload, actionParams.actionPayload);
    }

    public final ActionPayload<T> getActionPayload() {
        return this.actionPayload;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public int hashCode() {
        return this.actionPayload.hashCode() + (this.actionType.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ActionParams(actionType=");
        outline73.append(this.actionType);
        outline73.append(", actionPayload=");
        outline73.append(this.actionPayload);
        outline73.append(')');
        return outline73.toString();
    }
}
