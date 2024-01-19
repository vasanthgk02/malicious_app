package com.mpl.androidapp.appsanity;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/mpl/androidapp/appsanity/APPSanityModel;", "", "url", "", "(Ljava/lang/String;)V", "currTotalRxByte", "", "getCurrTotalRxByte", "()J", "setCurrTotalRxByte", "(J)V", "endTime", "getEndTime", "setEndTime", "prevTotalRxByte", "getPrevTotalRxByte", "setPrevTotalRxByte", "startTime", "getStartTime", "setStartTime", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: APPSanityModel.kt */
public final class APPSanityModel {
    public long currTotalRxByte;
    public long endTime;
    public long prevTotalRxByte;
    public long startTime;
    public final String url;

    public APPSanityModel(String str) {
        this.url = str;
    }

    public static /* synthetic */ APPSanityModel copy$default(APPSanityModel aPPSanityModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aPPSanityModel.url;
        }
        return aPPSanityModel.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final APPSanityModel copy(String str) {
        return new APPSanityModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof APPSanityModel) && Intrinsics.areEqual(this.url, ((APPSanityModel) obj).url);
    }

    public final long getCurrTotalRxByte() {
        return this.currTotalRxByte;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getPrevTotalRxByte() {
        return this.prevTotalRxByte;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setCurrTotalRxByte(long j) {
        this.currTotalRxByte = j;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setPrevTotalRxByte(long j) {
        this.prevTotalRxByte = j;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("APPSanityModel(url=");
        outline73.append(this.url);
        outline73.append(')');
        return outline73.toString();
    }
}
