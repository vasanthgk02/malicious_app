package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/FollowRoot;", "", "message", "", "success", "", "(Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowRoot.kt */
public final class FollowRoot {
    @SerializedName("message")
    public final String message;
    @SerializedName("success")
    public final boolean success;

    public FollowRoot(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.message = str;
        this.success = z;
    }

    public static /* synthetic */ FollowRoot copy$default(FollowRoot followRoot, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = followRoot.message;
        }
        if ((i & 2) != 0) {
            z = followRoot.success;
        }
        return followRoot.copy(str, z);
    }

    public final String component1() {
        return this.message;
    }

    public final boolean component2() {
        return this.success;
    }

    public final FollowRoot copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new FollowRoot(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowRoot)) {
            return false;
        }
        FollowRoot followRoot = (FollowRoot) obj;
        return Intrinsics.areEqual(this.message, followRoot.message) && this.success == followRoot.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int hashCode = this.message.hashCode() * 31;
        boolean z = this.success;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FollowRoot(message=");
        outline73.append(this.message);
        outline73.append(", success=");
        return GeneratedOutlineSupport.outline65(outline73, this.success, ')');
    }
}
