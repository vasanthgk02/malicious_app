package com.google.firebase.crashlytics.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

public final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {
    public final CrashlyticsReport report;
    public final File reportFile;
    public final String sessionId;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport != null) {
            this.report = crashlyticsReport;
            if (str != null) {
                this.sessionId = str;
                if (file != null) {
                    this.reportFile = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (!this.report.equals(crashlyticsReportWithSessionId.getReport()) || !this.sessionId.equals(crashlyticsReportWithSessionId.getSessionId()) || !this.reportFile.equals(crashlyticsReportWithSessionId.getReportFile())) {
            z = false;
        }
        return z;
    }

    public CrashlyticsReport getReport() {
        return this.report;
    }

    public File getReportFile() {
        return this.reportFile;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return ((((this.report.hashCode() ^ 1000003) * 1000003) ^ this.sessionId.hashCode()) * 1000003) ^ this.reportFile.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CrashlyticsReportWithSessionId{report=");
        outline73.append(this.report);
        outline73.append(", sessionId=");
        outline73.append(this.sessionId);
        outline73.append(", reportFile=");
        outline73.append(this.reportFile);
        outline73.append("}");
        return outline73.toString();
    }
}
