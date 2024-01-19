package com.mpl.androidapp.webview.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/webview/models/Status;", "", "code", "", "message", "", "reason", "type", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getReason", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Status.kt */
public final class Status {
    @SerializedName("code")
    public final int code;
    @SerializedName("message")
    public final String message;
    @SerializedName("reason")
    public final String reason;
    @SerializedName("type")
    public final String type;

    public Status(int i, String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "message", str2, "reason", str3, "type");
        this.code = i;
        this.message = str;
        this.reason = str2;
        this.type = str3;
    }

    public static /* synthetic */ Status copy$default(Status status, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = status.code;
        }
        if ((i2 & 2) != 0) {
            str = status.message;
        }
        if ((i2 & 4) != 0) {
            str2 = status.reason;
        }
        if ((i2 & 8) != 0) {
            str3 = status.type;
        }
        return status.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.reason;
    }

    public final String component4() {
        return this.type;
    }

    public final Status copy(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "reason");
        Intrinsics.checkNotNullParameter(str3, "type");
        return new Status(i, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.code == status.code && Intrinsics.areEqual(this.message, status.message) && Intrinsics.areEqual(this.reason, status.reason) && Intrinsics.areEqual(this.type, status.type);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + GeneratedOutlineSupport.outline11(this.reason, GeneratedOutlineSupport.outline11(this.message, this.code * 31, 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Status(code=");
        outline73.append(this.code);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", reason=");
        outline73.append(this.reason);
        outline73.append(", type=");
        return GeneratedOutlineSupport.outline59(outline73, this.type, ')');
    }
}
