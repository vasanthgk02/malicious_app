package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends Execution {
    public final ApplicationExitInfo appExitInfo;
    public final ImmutableList<BinaryImage> binaries;
    public final Exception exception;
    public final Signal signal;
    public final ImmutableList<Thread> threads;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder {
        public ApplicationExitInfo appExitInfo;
        public ImmutableList<BinaryImage> binaries;
        public Exception exception;
        public Signal signal;
        public ImmutableList<Thread> threads;

        public Execution build() {
            String str = this.signal == null ? " signal" : "";
            if (this.binaries == null) {
                str = GeneratedOutlineSupport.outline50(str, " binaries");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution autoValue_CrashlyticsReport_Session_Event_Application_Execution = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.threads, this.exception, this.appExitInfo, this.signal, this.binaries);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setAppExitInfo(ApplicationExitInfo applicationExitInfo) {
            this.appExitInfo = applicationExitInfo;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<BinaryImage> immutableList) {
            if (immutableList != null) {
                this.binaries = immutableList;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setException(Exception exception2) {
            this.exception = exception2;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(Signal signal2) {
            if (signal2 != null) {
                this.signal = signal2;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<Thread> immutableList) {
            this.threads = immutableList;
            return this;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (r4.binaries.equals(r5.getBinaries()) != false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
            r2 = 0
            if (r1 == 0) goto L_0x0065
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution) r5
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread> r1 = r4.threads
            if (r1 != 0) goto L_0x0016
            com.google.firebase.crashlytics.internal.model.ImmutableList r1 = r5.getThreads()
            if (r1 != 0) goto L_0x0063
            goto L_0x0020
        L_0x0016:
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r5.getThreads()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x0020:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r4.exception
            if (r1 != 0) goto L_0x002b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r5.getException()
            if (r1 != 0) goto L_0x0063
            goto L_0x0035
        L_0x002b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r3 = r5.getException()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x0035:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r1 = r4.appExitInfo
            if (r1 != 0) goto L_0x0040
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r1 = r5.getAppExitInfo()
            if (r1 != 0) goto L_0x0063
            goto L_0x004a
        L_0x0040:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo r3 = r5.getAppExitInfo()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
        L_0x004a:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal r1 = r4.signal
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal r3 = r5.getSignal()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0063
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage> r1 = r4.binaries
            com.google.firebase.crashlytics.internal.model.ImmutableList r5 = r5.getBinaries()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            return r0
        L_0x0065:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution.equals(java.lang.Object):boolean");
    }

    public ApplicationExitInfo getAppExitInfo() {
        return this.appExitInfo;
    }

    public ImmutableList<BinaryImage> getBinaries() {
        return this.binaries;
    }

    public Exception getException() {
        return this.exception;
    }

    public Signal getSignal() {
        return this.signal;
    }

    public ImmutableList<Thread> getThreads() {
        return this.threads;
    }

    public int hashCode() {
        ImmutableList<Thread> immutableList = this.threads;
        int i = 0;
        int hashCode = ((immutableList == null ? 0 : immutableList.hashCode()) ^ 1000003) * 1000003;
        Exception exception2 = this.exception;
        int hashCode2 = (hashCode ^ (exception2 == null ? 0 : exception2.hashCode())) * 1000003;
        ApplicationExitInfo applicationExitInfo = this.appExitInfo;
        if (applicationExitInfo != null) {
            i = applicationExitInfo.hashCode();
        }
        return ((((hashCode2 ^ i) * 1000003) ^ this.signal.hashCode()) * 1000003) ^ this.binaries.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Execution{threads=");
        outline73.append(this.threads);
        outline73.append(", exception=");
        outline73.append(this.exception);
        outline73.append(", appExitInfo=");
        outline73.append(this.appExitInfo);
        outline73.append(", signal=");
        outline73.append(this.signal);
        outline73.append(", binaries=");
        outline73.append(this.binaries);
        outline73.append("}");
        return outline73.toString();
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution(ImmutableList<Thread> immutableList, Exception exception2, ApplicationExitInfo applicationExitInfo, Signal signal2, ImmutableList<BinaryImage> immutableList2) {
        this.threads = immutableList;
        this.exception = exception2;
        this.appExitInfo = applicationExitInfo;
        this.signal = signal2;
        this.binaries = immutableList2;
    }
}
