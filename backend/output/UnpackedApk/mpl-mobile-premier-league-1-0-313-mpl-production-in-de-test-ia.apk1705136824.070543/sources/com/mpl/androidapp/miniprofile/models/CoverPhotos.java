package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/CoverPhotos;", "", "avatar", "", "x8367641585053989744", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getX8367641585053989744", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoverPhotos.kt */
public final class CoverPhotos {
    @SerializedName("avatar")
    public final String avatar;
    @SerializedName("8367641585053989744")
    public final String x8367641585053989744;

    public CoverPhotos(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "x8367641585053989744");
        this.avatar = str;
        this.x8367641585053989744 = str2;
    }

    public static /* synthetic */ CoverPhotos copy$default(CoverPhotos coverPhotos, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coverPhotos.avatar;
        }
        if ((i & 2) != 0) {
            str2 = coverPhotos.x8367641585053989744;
        }
        return coverPhotos.copy(str, str2);
    }

    public final String component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.x8367641585053989744;
    }

    public final CoverPhotos copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "avatar");
        Intrinsics.checkNotNullParameter(str2, "x8367641585053989744");
        return new CoverPhotos(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoverPhotos)) {
            return false;
        }
        CoverPhotos coverPhotos = (CoverPhotos) obj;
        return Intrinsics.areEqual(this.avatar, coverPhotos.avatar) && Intrinsics.areEqual(this.x8367641585053989744, coverPhotos.x8367641585053989744);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getX8367641585053989744() {
        return this.x8367641585053989744;
    }

    public int hashCode() {
        return this.x8367641585053989744.hashCode() + (this.avatar.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CoverPhotos(avatar=");
        outline73.append(this.avatar);
        outline73.append(", x8367641585053989744=");
        return GeneratedOutlineSupport.outline59(outline73, this.x8367641585053989744, ')');
    }
}
