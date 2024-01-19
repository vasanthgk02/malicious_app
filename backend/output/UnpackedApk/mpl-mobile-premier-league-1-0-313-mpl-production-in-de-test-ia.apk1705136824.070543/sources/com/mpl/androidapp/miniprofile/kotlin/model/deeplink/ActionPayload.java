package com.mpl.androidapp.miniprofile.kotlin.model.deeplink;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0011\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/ActionPayload;", "T", "", "route", "", "param", "sender", "Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/Sender;", "(Ljava/lang/String;Ljava/lang/Object;Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/Sender;)V", "getParam", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getRoute", "()Ljava/lang/String;", "getSender", "()Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/Sender;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/Sender;)Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/ActionPayload;", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionPayload.kt */
public final class ActionPayload<T> {
    public final T param;
    public final String route;
    @SerializedName("_sender")
    public final Sender sender;

    public ActionPayload(String str, T t, Sender sender2) {
        Intrinsics.checkNotNullParameter(str, "route");
        this.route = str;
        this.param = t;
        this.sender = sender2;
    }

    public static /* synthetic */ ActionPayload copy$default(ActionPayload actionPayload, String str, T t, Sender sender2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionPayload.route;
        }
        if ((i & 2) != 0) {
            t = actionPayload.param;
        }
        if ((i & 4) != 0) {
            sender2 = actionPayload.sender;
        }
        return actionPayload.copy(str, t, sender2);
    }

    public final String component1() {
        return this.route;
    }

    public final T component2() {
        return this.param;
    }

    public final Sender component3() {
        return this.sender;
    }

    public final ActionPayload<T> copy(String str, T t, Sender sender2) {
        Intrinsics.checkNotNullParameter(str, "route");
        return new ActionPayload<>(str, t, sender2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionPayload)) {
            return false;
        }
        ActionPayload actionPayload = (ActionPayload) obj;
        return Intrinsics.areEqual(this.route, actionPayload.route) && Intrinsics.areEqual(this.param, actionPayload.param) && Intrinsics.areEqual(this.sender, actionPayload.sender);
    }

    public final T getParam() {
        return this.param;
    }

    public final String getRoute() {
        return this.route;
    }

    public final Sender getSender() {
        return this.sender;
    }

    public int hashCode() {
        int hashCode = this.route.hashCode() * 31;
        T t = this.param;
        int i = 0;
        int hashCode2 = (hashCode + (t == null ? 0 : t.hashCode())) * 31;
        Sender sender2 = this.sender;
        if (sender2 != null) {
            i = sender2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ActionPayload(route=");
        outline73.append(this.route);
        outline73.append(", param=");
        outline73.append(this.param);
        outline73.append(", sender=");
        outline73.append(this.sender);
        outline73.append(')');
        return outline73.toString();
    }

    public /* synthetic */ ActionPayload(String str, Object obj, Sender sender2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? null : sender2);
    }
}
