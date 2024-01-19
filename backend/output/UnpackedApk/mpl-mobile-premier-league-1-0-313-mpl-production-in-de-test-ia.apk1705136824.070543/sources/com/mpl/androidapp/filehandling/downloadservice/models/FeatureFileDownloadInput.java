package com.mpl.androidapp.filehandling.downloadservice.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "", "isInternalStorage", "", "baseUrl", "", "path", "fileName", "featureName", "fileDestination", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getFeatureName", "setFeatureName", "getFileDestination", "setFileDestination", "getFileName", "setFileName", "()Z", "setInternalStorage", "(Z)V", "getPath", "setPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeatureFileDownloadInput.kt */
public final class FeatureFileDownloadInput {
    public String baseUrl;
    public String featureName;
    public String fileDestination;
    public String fileName;
    public boolean isInternalStorage;
    public String path;

    public FeatureFileDownloadInput(boolean z, String str, String str2, String str3, String str4, String str5) {
        this.isInternalStorage = z;
        this.baseUrl = str;
        this.path = str2;
        this.fileName = str3;
        this.featureName = str4;
        this.fileDestination = str5;
    }

    public static /* synthetic */ FeatureFileDownloadInput copy$default(FeatureFileDownloadInput featureFileDownloadInput, boolean z, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = featureFileDownloadInput.isInternalStorage;
        }
        if ((i & 2) != 0) {
            str = featureFileDownloadInput.baseUrl;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = featureFileDownloadInput.path;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = featureFileDownloadInput.fileName;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = featureFileDownloadInput.featureName;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = featureFileDownloadInput.fileDestination;
        }
        return featureFileDownloadInput.copy(z, str6, str7, str8, str9, str5);
    }

    public final boolean component1() {
        return this.isInternalStorage;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final String component3() {
        return this.path;
    }

    public final String component4() {
        return this.fileName;
    }

    public final String component5() {
        return this.featureName;
    }

    public final String component6() {
        return this.fileDestination;
    }

    public final FeatureFileDownloadInput copy(boolean z, String str, String str2, String str3, String str4, String str5) {
        FeatureFileDownloadInput featureFileDownloadInput = new FeatureFileDownloadInput(z, str, str2, str3, str4, str5);
        return featureFileDownloadInput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeatureFileDownloadInput)) {
            return false;
        }
        FeatureFileDownloadInput featureFileDownloadInput = (FeatureFileDownloadInput) obj;
        return this.isInternalStorage == featureFileDownloadInput.isInternalStorage && Intrinsics.areEqual(this.baseUrl, featureFileDownloadInput.baseUrl) && Intrinsics.areEqual(this.path, featureFileDownloadInput.path) && Intrinsics.areEqual(this.fileName, featureFileDownloadInput.fileName) && Intrinsics.areEqual(this.featureName, featureFileDownloadInput.featureName) && Intrinsics.areEqual(this.fileDestination, featureFileDownloadInput.fileDestination);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getFeatureName() {
        return this.featureName;
    }

    public final String getFileDestination() {
        return this.fileDestination;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        boolean z = this.isInternalStorage;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.baseUrl;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.path;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.featureName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fileDestination;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public final boolean isInternalStorage() {
        return this.isInternalStorage;
    }

    public final void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public final void setFeatureName(String str) {
        this.featureName = str;
    }

    public final void setFileDestination(String str) {
        this.fileDestination = str;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final void setInternalStorage(boolean z) {
        this.isInternalStorage = z;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FeatureFileDownloadInput(isInternalStorage=");
        outline73.append(this.isInternalStorage);
        outline73.append(", baseUrl=");
        outline73.append(this.baseUrl);
        outline73.append(", path=");
        outline73.append(this.path);
        outline73.append(", fileName=");
        outline73.append(this.fileName);
        outline73.append(", featureName=");
        outline73.append(this.featureName);
        outline73.append(", fileDestination=");
        outline73.append(this.fileDestination);
        outline73.append(')');
        return outline73.toString();
    }
}
