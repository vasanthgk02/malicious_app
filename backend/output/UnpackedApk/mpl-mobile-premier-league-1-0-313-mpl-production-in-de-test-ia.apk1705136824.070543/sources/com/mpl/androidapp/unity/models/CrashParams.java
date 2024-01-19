package com.mpl.androidapp.unity.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/unity/models/CrashParams;", "", "msg", "", "stacktrace", "gameId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGameId", "()Ljava/lang/String;", "getMsg", "getStacktrace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CrashParams.kt */
public final class CrashParams {
    public final String gameId;
    public final String msg;
    public final String stacktrace;

    public CrashParams(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "msg", str2, "stacktrace", str3, "gameId");
        this.msg = str;
        this.stacktrace = str2;
        this.gameId = str3;
    }

    public static /* synthetic */ CrashParams copy$default(CrashParams crashParams, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = crashParams.msg;
        }
        if ((i & 2) != 0) {
            str2 = crashParams.stacktrace;
        }
        if ((i & 4) != 0) {
            str3 = crashParams.gameId;
        }
        return crashParams.copy(str, str2, str3);
    }

    public final String component1() {
        return this.msg;
    }

    public final String component2() {
        return this.stacktrace;
    }

    public final String component3() {
        return this.gameId;
    }

    public final CrashParams copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(str2, "stacktrace");
        Intrinsics.checkNotNullParameter(str3, "gameId");
        return new CrashParams(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CrashParams)) {
            return false;
        }
        CrashParams crashParams = (CrashParams) obj;
        return Intrinsics.areEqual(this.msg, crashParams.msg) && Intrinsics.areEqual(this.stacktrace, crashParams.stacktrace) && Intrinsics.areEqual(this.gameId, crashParams.gameId);
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getStacktrace() {
        return this.stacktrace;
    }

    public int hashCode() {
        return this.gameId.hashCode() + GeneratedOutlineSupport.outline11(this.stacktrace, this.msg.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CrashParams(msg=");
        outline73.append(this.msg);
        outline73.append(", stacktrace=");
        outline73.append(this.stacktrace);
        outline73.append(", gameId=");
        return GeneratedOutlineSupport.outline59(outline73, this.gameId, ')');
    }
}
