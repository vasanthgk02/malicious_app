package com.mpl.androidapp.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/model/LiveStatus;", "", "isVOD", "", "isCurrentPositionLive", "(ZZ)V", "()Z", "setCurrentPositionLive", "(Z)V", "setVOD", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveStatus.kt */
public final class LiveStatus {
    public boolean isCurrentPositionLive;
    public boolean isVOD;

    public LiveStatus(boolean z, boolean z2) {
        this.isVOD = z;
        this.isCurrentPositionLive = z2;
    }

    public static /* synthetic */ LiveStatus copy$default(LiveStatus liveStatus, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = liveStatus.isVOD;
        }
        if ((i & 2) != 0) {
            z2 = liveStatus.isCurrentPositionLive;
        }
        return liveStatus.copy(z, z2);
    }

    public final boolean component1() {
        return this.isVOD;
    }

    public final boolean component2() {
        return this.isCurrentPositionLive;
    }

    public final LiveStatus copy(boolean z, boolean z2) {
        return new LiveStatus(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveStatus)) {
            return false;
        }
        LiveStatus liveStatus = (LiveStatus) obj;
        return this.isVOD == liveStatus.isVOD && this.isCurrentPositionLive == liveStatus.isCurrentPositionLive;
    }

    public int hashCode() {
        boolean z = this.isVOD;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z2 = this.isCurrentPositionLive;
        if (!z2) {
            i = z2;
        }
        return i2 + i;
    }

    public final boolean isCurrentPositionLive() {
        return this.isCurrentPositionLive;
    }

    public final boolean isVOD() {
        return this.isVOD;
    }

    public final void setCurrentPositionLive(boolean z) {
        this.isCurrentPositionLive = z;
    }

    public final void setVOD(boolean z) {
        this.isVOD = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LiveStatus(isVOD=");
        outline73.append(this.isVOD);
        outline73.append(", isCurrentPositionLive=");
        return GeneratedOutlineSupport.outline65(outline73, this.isCurrentPositionLive, ')');
    }
}
