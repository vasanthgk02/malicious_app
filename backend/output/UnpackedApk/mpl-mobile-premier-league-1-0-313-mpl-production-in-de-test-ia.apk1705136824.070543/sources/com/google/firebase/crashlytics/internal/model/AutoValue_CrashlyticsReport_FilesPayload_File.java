package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import java.util.Arrays;

public final class AutoValue_CrashlyticsReport_FilesPayload_File extends File {
    public final byte[] contents;
    public final String filename;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder {
        public byte[] contents;
        public String filename;

        public File build() {
            String str = this.filename == null ? " filename" : "";
            if (this.contents == null) {
                str = GeneratedOutlineSupport.outline50(str, " contents");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(this.filename, this.contents);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] bArr) {
            if (bArr != null) {
                this.contents = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder setFilename(String str) {
            if (str != null) {
                this.filename = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (java.util.Arrays.equals(r4.contents, r5 instanceof com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File ? ((com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File) r5).contents : r5.getContents()) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File
            r2 = 0
            if (r1 == 0) goto L_0x002f
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File) r5
            java.lang.String r1 = r4.filename
            java.lang.String r3 = r5.getFilename()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            byte[] r1 = r4.contents
            boolean r3 = r5 instanceof com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File
            if (r3 == 0) goto L_0x0022
            com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File r5 = (com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File) r5
            byte[] r5 = r5.contents
            goto L_0x0026
        L_0x0022:
            byte[] r5 = r5.getContents()
        L_0x0026:
            boolean r5 = java.util.Arrays.equals(r1, r5)
            if (r5 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            return r0
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File.equals(java.lang.Object):boolean");
    }

    public byte[] getContents() {
        return this.contents;
    }

    public String getFilename() {
        return this.filename;
    }

    public int hashCode() {
        return ((this.filename.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.contents);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("File{filename=");
        outline73.append(this.filename);
        outline73.append(", contents=");
        outline73.append(Arrays.toString(this.contents));
        outline73.append("}");
        return outline73.toString();
    }

    public AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.filename = str;
        this.contents = bArr;
    }
}
