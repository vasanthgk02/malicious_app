package com.mpl.androidapp.miniprofile.kotlin.model.deeplink.share;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/Param;", "", "broadcastId", "", "(Ljava/lang/String;)V", "getBroadcastId", "()Ljava/lang/String;", "setBroadcastId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Param.kt */
public final class Param {
    public String broadcastId;

    public Param() {
        this(null, 1, null);
    }

    public Param(String str) {
        Intrinsics.checkNotNullParameter(str, "broadcastId");
        this.broadcastId = str;
    }

    public static /* synthetic */ Param copy$default(Param param, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = param.broadcastId;
        }
        return param.copy(str);
    }

    public final String component1() {
        return this.broadcastId;
    }

    public final Param copy(String str) {
        Intrinsics.checkNotNullParameter(str, "broadcastId");
        return new Param(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Param) && Intrinsics.areEqual(this.broadcastId, ((Param) obj).broadcastId);
    }

    public final String getBroadcastId() {
        return this.broadcastId;
    }

    public int hashCode() {
        return this.broadcastId.hashCode();
    }

    public final void setBroadcastId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.broadcastId = str;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("Param(broadcastId="), this.broadcastId, ')');
    }

    public /* synthetic */ Param(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }
}
