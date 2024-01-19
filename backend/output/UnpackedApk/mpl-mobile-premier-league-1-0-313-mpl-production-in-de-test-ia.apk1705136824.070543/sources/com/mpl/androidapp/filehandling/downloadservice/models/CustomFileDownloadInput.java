package com.mpl.androidapp.filehandling.downloadservice.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mpl/androidapp/filehandling/downloadservice/models/CustomFileDownloadInput;", "", "file", "Ljava/io/File;", "urlToDownload", "", "(Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getUrlToDownload", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomFileDownloadInput.kt */
public final class CustomFileDownloadInput {
    public final File file;
    public final String urlToDownload;

    public CustomFileDownloadInput(File file2, String str) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(str, "urlToDownload");
        this.file = file2;
        this.urlToDownload = str;
    }

    public static /* synthetic */ CustomFileDownloadInput copy$default(CustomFileDownloadInput customFileDownloadInput, File file2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            file2 = customFileDownloadInput.file;
        }
        if ((i & 2) != 0) {
            str = customFileDownloadInput.urlToDownload;
        }
        return customFileDownloadInput.copy(file2, str);
    }

    public final File component1() {
        return this.file;
    }

    public final String component2() {
        return this.urlToDownload;
    }

    public final CustomFileDownloadInput copy(File file2, String str) {
        Intrinsics.checkNotNullParameter(file2, "file");
        Intrinsics.checkNotNullParameter(str, "urlToDownload");
        return new CustomFileDownloadInput(file2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomFileDownloadInput)) {
            return false;
        }
        CustomFileDownloadInput customFileDownloadInput = (CustomFileDownloadInput) obj;
        return Intrinsics.areEqual(this.file, customFileDownloadInput.file) && Intrinsics.areEqual(this.urlToDownload, customFileDownloadInput.urlToDownload);
    }

    public final File getFile() {
        return this.file;
    }

    public final String getUrlToDownload() {
        return this.urlToDownload;
    }

    public int hashCode() {
        return this.urlToDownload.hashCode() + (this.file.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CustomFileDownloadInput(file=");
        outline73.append(this.file);
        outline73.append(", urlToDownload=");
        return GeneratedOutlineSupport.outline59(outline73, this.urlToDownload, ')');
    }
}
