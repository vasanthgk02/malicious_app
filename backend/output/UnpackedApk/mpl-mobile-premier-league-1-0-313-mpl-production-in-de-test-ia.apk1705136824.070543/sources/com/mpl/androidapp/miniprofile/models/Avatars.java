package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/Avatars;", "", "regular", "", "small", "(Ljava/lang/String;Ljava/lang/String;)V", "getRegular", "()Ljava/lang/String;", "getSmall", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Avatars.kt */
public final class Avatars {
    @SerializedName("regular")
    public final String regular;
    @SerializedName("small")
    public final String small;

    public Avatars(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "regular");
        Intrinsics.checkNotNullParameter(str2, "small");
        this.regular = str;
        this.small = str2;
    }

    public static /* synthetic */ Avatars copy$default(Avatars avatars, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = avatars.regular;
        }
        if ((i & 2) != 0) {
            str2 = avatars.small;
        }
        return avatars.copy(str, str2);
    }

    public final String component1() {
        return this.regular;
    }

    public final String component2() {
        return this.small;
    }

    public final Avatars copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "regular");
        Intrinsics.checkNotNullParameter(str2, "small");
        return new Avatars(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Avatars)) {
            return false;
        }
        Avatars avatars = (Avatars) obj;
        return Intrinsics.areEqual(this.regular, avatars.regular) && Intrinsics.areEqual(this.small, avatars.small);
    }

    public final String getRegular() {
        return this.regular;
    }

    public final String getSmall() {
        return this.small;
    }

    public int hashCode() {
        return this.small.hashCode() + (this.regular.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Avatars(regular=");
        outline73.append(this.regular);
        outline73.append(", small=");
        return GeneratedOutlineSupport.outline59(outline73, this.small, ')');
    }
}
