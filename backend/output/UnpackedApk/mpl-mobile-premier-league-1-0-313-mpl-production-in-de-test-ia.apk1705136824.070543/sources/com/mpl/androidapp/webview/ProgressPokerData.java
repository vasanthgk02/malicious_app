package com.mpl.androidapp.webview;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/webview/ProgressPokerData;", "", "downloaded", "", "totalSize", "progress", "(III)V", "getDownloaded", "()I", "getProgress", "getTotalSize", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PokerWebViewVm.kt */
public final class ProgressPokerData {
    public final int downloaded;
    public final int progress;
    public final int totalSize;

    public ProgressPokerData(int i, int i2, int i3) {
        this.downloaded = i;
        this.totalSize = i2;
        this.progress = i3;
    }

    public static /* synthetic */ ProgressPokerData copy$default(ProgressPokerData progressPokerData, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = progressPokerData.downloaded;
        }
        if ((i4 & 2) != 0) {
            i2 = progressPokerData.totalSize;
        }
        if ((i4 & 4) != 0) {
            i3 = progressPokerData.progress;
        }
        return progressPokerData.copy(i, i2, i3);
    }

    public final int component1() {
        return this.downloaded;
    }

    public final int component2() {
        return this.totalSize;
    }

    public final int component3() {
        return this.progress;
    }

    public final ProgressPokerData copy(int i, int i2, int i3) {
        return new ProgressPokerData(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressPokerData)) {
            return false;
        }
        ProgressPokerData progressPokerData = (ProgressPokerData) obj;
        return this.downloaded == progressPokerData.downloaded && this.totalSize == progressPokerData.totalSize && this.progress == progressPokerData.progress;
    }

    public final int getDownloaded() {
        return this.downloaded;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        return (((this.downloaded * 31) + this.totalSize) * 31) + this.progress;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ProgressPokerData(downloaded=");
        outline73.append(this.downloaded);
        outline73.append(", totalSize=");
        outline73.append(this.totalSize);
        outline73.append(", progress=");
        return GeneratedOutlineSupport.outline56(outline73, this.progress, ')');
    }
}
