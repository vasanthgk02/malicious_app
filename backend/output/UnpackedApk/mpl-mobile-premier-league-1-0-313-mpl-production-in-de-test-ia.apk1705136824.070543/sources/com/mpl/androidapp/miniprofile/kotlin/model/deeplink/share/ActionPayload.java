package com.mpl.androidapp.miniprofile.kotlin.model.deeplink.share;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionPayload;", "", "param", "Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/Param;", "route", "", "(Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/Param;Ljava/lang/String;)V", "getParam", "()Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/Param;", "setParam", "(Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/Param;)V", "getRoute", "()Ljava/lang/String;", "setRoute", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionPayload.kt */
public final class ActionPayload {
    public Param param;
    public String route;

    public ActionPayload() {
        this(null, null, 3, null);
    }

    public ActionPayload(Param param2, String str) {
        Intrinsics.checkNotNullParameter(param2, "param");
        Intrinsics.checkNotNullParameter(str, "route");
        this.param = param2;
        this.route = str;
    }

    public static /* synthetic */ ActionPayload copy$default(ActionPayload actionPayload, Param param2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            param2 = actionPayload.param;
        }
        if ((i & 2) != 0) {
            str = actionPayload.route;
        }
        return actionPayload.copy(param2, str);
    }

    public final Param component1() {
        return this.param;
    }

    public final String component2() {
        return this.route;
    }

    public final ActionPayload copy(Param param2, String str) {
        Intrinsics.checkNotNullParameter(param2, "param");
        Intrinsics.checkNotNullParameter(str, "route");
        return new ActionPayload(param2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionPayload)) {
            return false;
        }
        ActionPayload actionPayload = (ActionPayload) obj;
        return Intrinsics.areEqual(this.param, actionPayload.param) && Intrinsics.areEqual(this.route, actionPayload.route);
    }

    public final Param getParam() {
        return this.param;
    }

    public final String getRoute() {
        return this.route;
    }

    public int hashCode() {
        return this.route.hashCode() + (this.param.hashCode() * 31);
    }

    public final void setParam(Param param2) {
        Intrinsics.checkNotNullParameter(param2, "<set-?>");
        this.param = param2;
    }

    public final void setRoute(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.route = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ActionPayload(param=");
        outline73.append(this.param);
        outline73.append(", route=");
        return GeneratedOutlineSupport.outline59(outline73, this.route, ')');
    }

    public /* synthetic */ ActionPayload(Param param2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Param(null, 1, null) : param2, (i & 2) != 0 ? "" : str);
    }
}
