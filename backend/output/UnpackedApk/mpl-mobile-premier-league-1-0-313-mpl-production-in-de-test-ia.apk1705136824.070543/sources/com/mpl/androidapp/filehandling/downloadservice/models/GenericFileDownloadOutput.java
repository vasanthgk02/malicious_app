package com.mpl.androidapp.filehandling.downloadservice.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/models/GenericFileDownloadOutput;", "", "status", "", "filepath", "", "feature", "isConnectivityPresent", "responseMsg", "fullPath", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getFeature", "()Ljava/lang/String;", "getFilepath", "getFullPath", "()Z", "getResponseMsg", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenericFileDownloadOutput.kt */
public final class GenericFileDownloadOutput {
    public final String feature;
    public final String filepath;
    public final String fullPath;
    public final boolean isConnectivityPresent;
    public final String responseMsg;
    public final boolean status;

    public GenericFileDownloadOutput(boolean z, String str, String str2, boolean z2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "filepath");
        Intrinsics.checkNotNullParameter(str2, "feature");
        Intrinsics.checkNotNullParameter(str3, "responseMsg");
        Intrinsics.checkNotNullParameter(str4, "fullPath");
        this.status = z;
        this.filepath = str;
        this.feature = str2;
        this.isConnectivityPresent = z2;
        this.responseMsg = str3;
        this.fullPath = str4;
    }

    public static /* synthetic */ GenericFileDownloadOutput copy$default(GenericFileDownloadOutput genericFileDownloadOutput, boolean z, String str, String str2, boolean z2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = genericFileDownloadOutput.status;
        }
        if ((i & 2) != 0) {
            str = genericFileDownloadOutput.filepath;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = genericFileDownloadOutput.feature;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            z2 = genericFileDownloadOutput.isConnectivityPresent;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            str3 = genericFileDownloadOutput.responseMsg;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = genericFileDownloadOutput.fullPath;
        }
        return genericFileDownloadOutput.copy(z, str5, str6, z3, str7, str4);
    }

    public final boolean component1() {
        return this.status;
    }

    public final String component2() {
        return this.filepath;
    }

    public final String component3() {
        return this.feature;
    }

    public final boolean component4() {
        return this.isConnectivityPresent;
    }

    public final String component5() {
        return this.responseMsg;
    }

    public final String component6() {
        return this.fullPath;
    }

    public final GenericFileDownloadOutput copy(boolean z, String str, String str2, boolean z2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "filepath");
        Intrinsics.checkNotNullParameter(str2, "feature");
        Intrinsics.checkNotNullParameter(str3, "responseMsg");
        Intrinsics.checkNotNullParameter(str4, "fullPath");
        GenericFileDownloadOutput genericFileDownloadOutput = new GenericFileDownloadOutput(z, str, str2, z2, str3, str4);
        return genericFileDownloadOutput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericFileDownloadOutput)) {
            return false;
        }
        GenericFileDownloadOutput genericFileDownloadOutput = (GenericFileDownloadOutput) obj;
        return this.status == genericFileDownloadOutput.status && Intrinsics.areEqual(this.filepath, genericFileDownloadOutput.filepath) && Intrinsics.areEqual(this.feature, genericFileDownloadOutput.feature) && this.isConnectivityPresent == genericFileDownloadOutput.isConnectivityPresent && Intrinsics.areEqual(this.responseMsg, genericFileDownloadOutput.responseMsg) && Intrinsics.areEqual(this.fullPath, genericFileDownloadOutput.fullPath);
    }

    public final String getFeature() {
        return this.feature;
    }

    public final String getFilepath() {
        return this.filepath;
    }

    public final String getFullPath() {
        return this.fullPath;
    }

    public final String getResponseMsg() {
        return this.responseMsg;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public int hashCode() {
        boolean z = this.status;
        int i = 1;
        if (z) {
            z = true;
        }
        int outline11 = GeneratedOutlineSupport.outline11(this.feature, GeneratedOutlineSupport.outline11(this.filepath, (z ? 1 : 0) * true, 31), 31);
        boolean z2 = this.isConnectivityPresent;
        if (!z2) {
            i = z2;
        }
        return this.fullPath.hashCode() + GeneratedOutlineSupport.outline11(this.responseMsg, (outline11 + i) * 31, 31);
    }

    public final boolean isConnectivityPresent() {
        return this.isConnectivityPresent;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GenericFileDownloadOutput(status=");
        outline73.append(this.status);
        outline73.append(", filepath=");
        outline73.append(this.filepath);
        outline73.append(", feature=");
        outline73.append(this.feature);
        outline73.append(", isConnectivityPresent=");
        outline73.append(this.isConnectivityPresent);
        outline73.append(", responseMsg=");
        outline73.append(this.responseMsg);
        outline73.append(", fullPath=");
        return GeneratedOutlineSupport.outline59(outline73, this.fullPath, ')');
    }
}
