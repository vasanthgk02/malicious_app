package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends Exception {
    public final Exception causedBy;
    public final ImmutableList<Frame> frames;
    public final int overflowCount;
    public final String reason;
    public final String type;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {
        public Exception causedBy;
        public ImmutableList<Frame> frames;
        public Integer overflowCount;
        public String reason;
        public String type;

        public Exception build() {
            String str = this.type == null ? " type" : "";
            if (this.frames == null) {
                str = GeneratedOutlineSupport.outline50(str, " frames");
            }
            if (this.overflowCount == null) {
                str = GeneratedOutlineSupport.outline50(str, " overflowCount");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(this.type, this.reason, this.frames, this.causedBy, this.overflowCount.intValue());
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(Exception exception) {
            this.causedBy = exception;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(ImmutableList<Frame> immutableList) {
            if (immutableList != null) {
                this.frames = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int i) {
            this.overflowCount = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String str) {
            this.reason = str;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String str) {
            if (str != null) {
                this.type = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r4.overflowCount == r5.getOverflowCount()) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
            r2 = 0
            if (r1 == 0) goto L_0x0058
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception) r5
            java.lang.String r1 = r4.type
            java.lang.String r3 = r5.getType()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = r4.reason
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r5.getReason()
            if (r1 != 0) goto L_0x0056
            goto L_0x002c
        L_0x0022:
            java.lang.String r3 = r5.getReason()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x002c:
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame> r1 = r4.frames
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r5.getFrames()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r4.causedBy
            if (r1 != 0) goto L_0x0043
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r5.getCausedBy()
            if (r1 != 0) goto L_0x0056
            goto L_0x004d
        L_0x0043:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r3 = r5.getCausedBy()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x004d:
            int r1 = r4.overflowCount
            int r5 = r5.getOverflowCount()
            if (r1 != r5) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            return r0
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.equals(java.lang.Object):boolean");
    }

    public Exception getCausedBy() {
        return this.causedBy;
    }

    public ImmutableList<Frame> getFrames() {
        return this.frames;
    }

    public int getOverflowCount() {
        return this.overflowCount;
    }

    public String getReason() {
        return this.reason;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        String str = this.reason;
        int i = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.frames.hashCode()) * 1000003;
        Exception exception = this.causedBy;
        if (exception != null) {
            i = exception.hashCode();
        }
        return ((hashCode2 ^ i) * 1000003) ^ this.overflowCount;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception{type=");
        outline73.append(this.type);
        outline73.append(", reason=");
        outline73.append(this.reason);
        outline73.append(", frames=");
        outline73.append(this.frames);
        outline73.append(", causedBy=");
        outline73.append(this.causedBy);
        outline73.append(", overflowCount=");
        return GeneratedOutlineSupport.outline57(outline73, this.overflowCount, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList<Frame> immutableList, Exception exception, int i) {
        this.type = str;
        this.reason = str2;
        this.frames = immutableList;
        this.causedBy = exception;
        this.overflowCount = i;
    }
}
