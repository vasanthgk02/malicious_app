package com.mpl.androidapp.unity.deepLink;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/unity/deepLink/UserProfileParam;", "", "id", "", "entryPoint", "", "(ILjava/lang/String;)V", "getEntryPoint", "()Ljava/lang/String;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserProfileParam.kt */
public final class UserProfileParam {
    public final String entryPoint;
    public final int id;

    public UserProfileParam(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        this.id = i;
        this.entryPoint = str;
    }

    public static /* synthetic */ UserProfileParam copy$default(UserProfileParam userProfileParam, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userProfileParam.id;
        }
        if ((i2 & 2) != 0) {
            str = userProfileParam.entryPoint;
        }
        return userProfileParam.copy(i, str);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.entryPoint;
    }

    public final UserProfileParam copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        return new UserProfileParam(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileParam)) {
            return false;
        }
        UserProfileParam userProfileParam = (UserProfileParam) obj;
        return this.id == userProfileParam.id && Intrinsics.areEqual(this.entryPoint, userProfileParam.entryPoint);
    }

    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return this.entryPoint.hashCode() + (this.id * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UserProfileParam(id=");
        outline73.append(this.id);
        outline73.append(", entryPoint=");
        return GeneratedOutlineSupport.outline59(outline73, this.entryPoint, ')');
    }
}
