package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/ProfileViews;", "", "allTime", "", "today", "(II)V", "getAllTime", "()I", "getToday", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProfileViews.kt */
public final class ProfileViews {
    @SerializedName("allTime")
    public final int allTime;
    @SerializedName("today")
    public final int today;

    public ProfileViews(int i, int i2) {
        this.allTime = i;
        this.today = i2;
    }

    public static /* synthetic */ ProfileViews copy$default(ProfileViews profileViews, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = profileViews.allTime;
        }
        if ((i3 & 2) != 0) {
            i2 = profileViews.today;
        }
        return profileViews.copy(i, i2);
    }

    public final int component1() {
        return this.allTime;
    }

    public final int component2() {
        return this.today;
    }

    public final ProfileViews copy(int i, int i2) {
        return new ProfileViews(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileViews)) {
            return false;
        }
        ProfileViews profileViews = (ProfileViews) obj;
        return this.allTime == profileViews.allTime && this.today == profileViews.today;
    }

    public final int getAllTime() {
        return this.allTime;
    }

    public final int getToday() {
        return this.today;
    }

    public int hashCode() {
        return (this.allTime * 31) + this.today;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProfileViews(allTime=");
        outline73.append(this.allTime);
        outline73.append(", today=");
        return GeneratedOutlineSupport.outline56(outline73, this.today, ')');
    }
}
