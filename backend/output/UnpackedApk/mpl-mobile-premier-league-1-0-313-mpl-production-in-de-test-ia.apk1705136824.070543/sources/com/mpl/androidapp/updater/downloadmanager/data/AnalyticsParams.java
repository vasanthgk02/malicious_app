package com.mpl.androidapp.updater.downloadmanager.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/data/AnalyticsParams;", "", "errorOnDownload", "", "message", "", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "(ZLjava/lang/String;Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "getErrorOnDownload", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsParams.kt */
public final class AnalyticsParams {
    public final DownloadTaskParams downloadTaskParams;
    public final boolean errorOnDownload;
    public final String message;

    public AnalyticsParams(boolean z, String str, DownloadTaskParams downloadTaskParams2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "downloadTaskParams");
        this.errorOnDownload = z;
        this.message = str;
        this.downloadTaskParams = downloadTaskParams2;
    }

    public static /* synthetic */ AnalyticsParams copy$default(AnalyticsParams analyticsParams, boolean z, String str, DownloadTaskParams downloadTaskParams2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = analyticsParams.errorOnDownload;
        }
        if ((i & 2) != 0) {
            str = analyticsParams.message;
        }
        if ((i & 4) != 0) {
            downloadTaskParams2 = analyticsParams.downloadTaskParams;
        }
        return analyticsParams.copy(z, str, downloadTaskParams2);
    }

    public final boolean component1() {
        return this.errorOnDownload;
    }

    public final String component2() {
        return this.message;
    }

    public final DownloadTaskParams component3() {
        return this.downloadTaskParams;
    }

    public final AnalyticsParams copy(boolean z, String str, DownloadTaskParams downloadTaskParams2) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(downloadTaskParams2, "downloadTaskParams");
        return new AnalyticsParams(z, str, downloadTaskParams2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsParams)) {
            return false;
        }
        AnalyticsParams analyticsParams = (AnalyticsParams) obj;
        return this.errorOnDownload == analyticsParams.errorOnDownload && Intrinsics.areEqual(this.message, analyticsParams.message) && Intrinsics.areEqual(this.downloadTaskParams, analyticsParams.downloadTaskParams);
    }

    public final DownloadTaskParams getDownloadTaskParams() {
        return this.downloadTaskParams;
    }

    public final boolean getErrorOnDownload() {
        return this.errorOnDownload;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        boolean z = this.errorOnDownload;
        if (z) {
            z = true;
        }
        return this.downloadTaskParams.hashCode() + GeneratedOutlineSupport.outline11(this.message, (z ? 1 : 0) * true, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AnalyticsParams(errorOnDownload=");
        outline73.append(this.errorOnDownload);
        outline73.append(", message=");
        outline73.append(this.message);
        outline73.append(", downloadTaskParams=");
        outline73.append(this.downloadTaskParams);
        outline73.append(')');
        return outline73.toString();
    }
}
