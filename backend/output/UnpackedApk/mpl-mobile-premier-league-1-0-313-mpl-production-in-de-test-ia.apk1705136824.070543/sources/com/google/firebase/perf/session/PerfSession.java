package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession.Builder;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;

public class PerfSession implements Parcelable {
    public static final Creator<PerfSession> CREATOR = new Creator<PerfSession>() {
        public Object createFromParcel(Parcel parcel) {
            return new PerfSession(parcel, (AnonymousClass1) null);
        }

        public Object[] newArray(int i) {
            return new PerfSession[i];
        }
    };
    public final Timer creationTime;
    public boolean isGaugeAndEventCollectionEnabled = false;
    public final String sessionId;

    public PerfSession(String str, Clock clock) {
        this.sessionId = str;
        this.creationTime = new Timer();
    }

    public static com.google.firebase.perf.v1.PerfSession[] buildAndSort(List<PerfSession> list) {
        if (list.isEmpty()) {
            return null;
        }
        com.google.firebase.perf.v1.PerfSession[] perfSessionArr = new com.google.firebase.perf.v1.PerfSession[list.size()];
        com.google.firebase.perf.v1.PerfSession build = list.get(0).build();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            com.google.firebase.perf.v1.PerfSession build2 = list.get(i).build();
            if (z || !list.get(i).isGaugeAndEventCollectionEnabled) {
                perfSessionArr[i] = build2;
            } else {
                perfSessionArr[0] = build2;
                perfSessionArr[i] = build;
                z = true;
            }
        }
        if (!z) {
            perfSessionArr[0] = build;
        }
        return perfSessionArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0089, code lost:
        if (r0.isSamplingRateValid(r2) != false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fb, code lost:
        if (r5 >= ((double) r2)) goto L_0x0101;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.perf.session.PerfSession create() {
        /*
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "-"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replace(r1, r2)
            com.google.firebase.perf.session.PerfSession r1 = new com.google.firebase.perf.session.PerfSession
            com.google.firebase.perf.util.Clock r2 = new com.google.firebase.perf.util.Clock
            r2.<init>()
            r1.<init>(r0, r2)
            com.google.firebase.perf.config.ConfigResolver r0 = com.google.firebase.perf.config.ConfigResolver.getInstance()
            boolean r2 = r0.isPerformanceMonitoringEnabled()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0101
            double r5 = java.lang.Math.random()
            java.lang.Class<com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate> r2 = com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate.class
            monitor-enter(r2)
            com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate r7 = com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate.instance     // Catch:{ all -> 0x00fe }
            if (r7 != 0) goto L_0x0038
            com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate r7 = new com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate     // Catch:{ all -> 0x00fe }
            r7.<init>()     // Catch:{ all -> 0x00fe }
            com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate.instance = r7     // Catch:{ all -> 0x00fe }
        L_0x0038:
            com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate r7 = com.google.firebase.perf.config.ConfigurationConstants$SessionsSamplingRate.instance     // Catch:{ all -> 0x00fe }
            monitor-exit(r2)
            com.google.firebase.perf.util.ImmutableBundle r2 = r0.metadataBundle
            java.lang.String r8 = r7.getMetadataFlag()
            boolean r9 = r2.containsKey(r8)
            if (r9 != 0) goto L_0x004d
            com.google.firebase.perf.util.Optional r2 = new com.google.firebase.perf.util.Optional
            r2.<init>()
            goto L_0x0072
        L_0x004d:
            android.os.Bundle r2 = r2.bundle     // Catch:{ ClassCastException -> 0x005a }
            java.lang.Object r2 = r2.get(r8)     // Catch:{ ClassCastException -> 0x005a }
            java.lang.Float r2 = (java.lang.Float) r2     // Catch:{ ClassCastException -> 0x005a }
            com.google.firebase.perf.util.Optional r2 = com.google.firebase.perf.util.Optional.fromNullable(r2)     // Catch:{ ClassCastException -> 0x005a }
            goto L_0x0072
        L_0x005a:
            r2 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r9 = com.google.firebase.perf.util.ImmutableBundle.logger
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r4] = r8
            java.lang.String r2 = r2.getMessage()
            r10[r3] = r2
            java.lang.String r2 = "Metadata key %s contains type other than float: %s"
            r9.debug(r2, r10)
            com.google.firebase.perf.util.Optional r2 = new com.google.firebase.perf.util.Optional
            r2.<init>()
        L_0x0072:
            boolean r8 = r2.isAvailable()
            if (r8 == 0) goto L_0x008c
            java.lang.Object r2 = r2.get()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r8 = 1120403456(0x42c80000, float:100.0)
            float r2 = r2 / r8
            boolean r8 = r0.isSamplingRateValid(r2)
            if (r8 == 0) goto L_0x008c
            goto L_0x00f8
        L_0x008c:
            com.google.firebase.perf.config.RemoteConfigManager r2 = r0.remoteConfigManager
            java.lang.String r8 = r7.getRemoteConfigFlag()
            com.google.firebase.perf.util.Optional r2 = r2.getFloat(r8)
            boolean r8 = r2.isAvailable()
            if (r8 == 0) goto L_0x00c8
            java.lang.Object r8 = r2.get()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            boolean r8 = r0.isSamplingRateValid(r8)
            if (r8 == 0) goto L_0x00c8
            com.google.firebase.perf.config.DeviceCacheManager r0 = r0.deviceCacheManager
            java.lang.String r7 = "com.google.firebase.perf.SessionSamplingRate"
            java.lang.Object r8 = r2.get()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r0.setValue(r7, r8)
            java.lang.Object r0 = r2.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r2 = r0.floatValue()
            goto L_0x00f8
        L_0x00c8:
            com.google.firebase.perf.util.Optional r2 = r0.getDeviceCacheFloat(r7)
            boolean r7 = r2.isAvailable()
            if (r7 == 0) goto L_0x00ed
            java.lang.Object r7 = r2.get()
            java.lang.Float r7 = (java.lang.Float) r7
            float r7 = r7.floatValue()
            boolean r0 = r0.isSamplingRateValid(r7)
            if (r0 == 0) goto L_0x00ed
            java.lang.Object r0 = r2.get()
            java.lang.Float r0 = (java.lang.Float) r0
            float r2 = r0.floatValue()
            goto L_0x00f8
        L_0x00ed:
            r0 = 1008981770(0x3c23d70a, float:0.01)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            float r2 = r0.floatValue()
        L_0x00f8:
            double r7 = (double) r2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0101
            goto L_0x0102
        L_0x00fe:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0101:
            r3 = 0
        L_0x0102:
            r1.isGaugeAndEventCollectionEnabled = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.session.PerfSession.create():com.google.firebase.perf.session.PerfSession");
    }

    public com.google.firebase.perf.v1.PerfSession build() {
        Builder builder = (Builder) com.google.firebase.perf.v1.PerfSession.DEFAULT_INSTANCE.createBuilder();
        String str = this.sessionId;
        builder.copyOnWrite();
        com.google.firebase.perf.v1.PerfSession.access$100((com.google.firebase.perf.v1.PerfSession) builder.instance, str);
        if (this.isGaugeAndEventCollectionEnabled) {
            SessionVerbosity sessionVerbosity = SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
            builder.copyOnWrite();
            com.google.firebase.perf.v1.PerfSession.access$500((com.google.firebase.perf.v1.PerfSession) builder.instance, sessionVerbosity);
        }
        return (com.google.firebase.perf.v1.PerfSession) builder.build();
    }

    public int describeContents() {
        return 0;
    }

    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    public String sessionId() {
        return this.sessionId;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sessionId);
        parcel.writeByte(this.isGaugeAndEventCollectionEnabled ? (byte) 1 : 0);
        parcel.writeParcelable(this.creationTime, 0);
    }

    public PerfSession(Parcel parcel, AnonymousClass1 r3) {
        boolean z = false;
        this.sessionId = parcel.readString();
        this.isGaugeAndEventCollectionEnabled = parcel.readByte() != 0 ? true : z;
        this.creationTime = (Timer) parcel.readParcelable(Timer.class.getClassLoader());
    }
}
