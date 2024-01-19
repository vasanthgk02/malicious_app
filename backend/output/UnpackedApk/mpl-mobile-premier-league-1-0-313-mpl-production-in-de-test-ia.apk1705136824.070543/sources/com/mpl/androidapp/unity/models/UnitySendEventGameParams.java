package com.mpl.androidapp.unity.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/mpl/androidapp/unity/models/UnitySendEventGameParams;", "", "event", "", "eventProp", "gameConfigJson", "url", "callback", "Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;)V", "getCallback", "()Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;", "getEvent", "()Ljava/lang/String;", "getEventProp", "getGameConfigJson", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnitySendEventGameParams.kt */
public final class UnitySendEventGameParams {
    public final GameEventCallback callback;
    public final String event;
    public final String eventProp;
    public final String gameConfigJson;
    public final String url;

    public UnitySendEventGameParams(String str, String str2, String str3, String str4, GameEventCallback gameEventCallback) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str2, "eventProp");
        Intrinsics.checkNotNullParameter(str3, "gameConfigJson");
        Intrinsics.checkNotNullParameter(str4, "url");
        Intrinsics.checkNotNullParameter(gameEventCallback, "callback");
        this.event = str;
        this.eventProp = str2;
        this.gameConfigJson = str3;
        this.url = str4;
        this.callback = gameEventCallback;
    }

    public static /* synthetic */ UnitySendEventGameParams copy$default(UnitySendEventGameParams unitySendEventGameParams, String str, String str2, String str3, String str4, GameEventCallback gameEventCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unitySendEventGameParams.event;
        }
        if ((i & 2) != 0) {
            str2 = unitySendEventGameParams.eventProp;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = unitySendEventGameParams.gameConfigJson;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = unitySendEventGameParams.url;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            gameEventCallback = unitySendEventGameParams.callback;
        }
        return unitySendEventGameParams.copy(str, str5, str6, str7, gameEventCallback);
    }

    public final String component1() {
        return this.event;
    }

    public final String component2() {
        return this.eventProp;
    }

    public final String component3() {
        return this.gameConfigJson;
    }

    public final String component4() {
        return this.url;
    }

    public final GameEventCallback component5() {
        return this.callback;
    }

    public final UnitySendEventGameParams copy(String str, String str2, String str3, String str4, GameEventCallback gameEventCallback) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str2, "eventProp");
        Intrinsics.checkNotNullParameter(str3, "gameConfigJson");
        Intrinsics.checkNotNullParameter(str4, "url");
        Intrinsics.checkNotNullParameter(gameEventCallback, "callback");
        UnitySendEventGameParams unitySendEventGameParams = new UnitySendEventGameParams(str, str2, str3, str4, gameEventCallback);
        return unitySendEventGameParams;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnitySendEventGameParams)) {
            return false;
        }
        UnitySendEventGameParams unitySendEventGameParams = (UnitySendEventGameParams) obj;
        return Intrinsics.areEqual(this.event, unitySendEventGameParams.event) && Intrinsics.areEqual(this.eventProp, unitySendEventGameParams.eventProp) && Intrinsics.areEqual(this.gameConfigJson, unitySendEventGameParams.gameConfigJson) && Intrinsics.areEqual(this.url, unitySendEventGameParams.url) && Intrinsics.areEqual(this.callback, unitySendEventGameParams.callback);
    }

    public final GameEventCallback getCallback() {
        return this.callback;
    }

    public final String getEvent() {
        return this.event;
    }

    public final String getEventProp() {
        return this.eventProp;
    }

    public final String getGameConfigJson() {
        return this.gameConfigJson;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.callback.hashCode() + GeneratedOutlineSupport.outline11(this.url, GeneratedOutlineSupport.outline11(this.gameConfigJson, GeneratedOutlineSupport.outline11(this.eventProp, this.event.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnitySendEventGameParams(event=");
        outline73.append(this.event);
        outline73.append(", eventProp=");
        outline73.append(this.eventProp);
        outline73.append(", gameConfigJson=");
        outline73.append(this.gameConfigJson);
        outline73.append(", url=");
        outline73.append(this.url);
        outline73.append(", callback=");
        outline73.append(this.callback);
        outline73.append(')');
        return outline73.toString();
    }
}
