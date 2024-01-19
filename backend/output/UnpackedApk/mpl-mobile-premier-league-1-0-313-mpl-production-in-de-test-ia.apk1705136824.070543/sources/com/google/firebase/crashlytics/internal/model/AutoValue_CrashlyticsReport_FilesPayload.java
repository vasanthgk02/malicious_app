package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;

public final class AutoValue_CrashlyticsReport_FilesPayload extends FilesPayload {
    public final ImmutableList<File> files;
    public final String orgId;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder {
        public ImmutableList<File> files;
        public String orgId;

        public FilesPayload build() {
            String str = this.files == null ? " files" : "";
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder setFiles(ImmutableList<File> immutableList) {
            if (immutableList != null) {
                this.files = immutableList;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder setOrgId(String str) {
            this.orgId = str;
            return this;
        }

        public Builder() {
        }

        public Builder(FilesPayload filesPayload) {
            this.files = filesPayload.getFiles();
            this.orgId = filesPayload.getOrgId();
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FilesPayload)) {
            return false;
        }
        FilesPayload filesPayload = (FilesPayload) obj;
        if (this.files.equals(filesPayload.getFiles())) {
            String str = this.orgId;
            if (str != null) {
            }
        }
        z = false;
        return z;
    }

    public ImmutableList<File> getFiles() {
        return this.files;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public int hashCode() {
        int hashCode = (this.files.hashCode() ^ 1000003) * 1000003;
        String str = this.orgId;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FilesPayload{files=");
        outline73.append(this.files);
        outline73.append(", orgId=");
        return GeneratedOutlineSupport.outline62(outline73, this.orgId, "}");
    }

    public AutoValue_CrashlyticsReport_FilesPayload(ImmutableList<File> immutableList, String str) {
        this.files = immutableList;
        this.orgId = str;
    }
}
