package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;

public final class AutoValue_CrashlyticsReport_Session extends Session {
    public final Application app;
    public final boolean crashed;
    public final Device device;
    public final Long endedAt;
    public final ImmutableList<Event> events;
    public final String generator;
    public final int generatorType;
    public final String identifier;
    public final OperatingSystem os;
    public final long startedAt;
    public final User user;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder {
        public Application app;
        public Boolean crashed;
        public Device device;
        public Long endedAt;
        public ImmutableList<Event> events;
        public String generator;
        public Integer generatorType;
        public String identifier;
        public OperatingSystem os;
        public Long startedAt;
        public User user;

        public Session build() {
            String str = this.generator == null ? " generator" : "";
            if (this.identifier == null) {
                str = GeneratedOutlineSupport.outline50(str, " identifier");
            }
            if (this.startedAt == null) {
                str = GeneratedOutlineSupport.outline50(str, " startedAt");
            }
            if (this.crashed == null) {
                str = GeneratedOutlineSupport.outline50(str, " crashed");
            }
            if (this.app == null) {
                str = GeneratedOutlineSupport.outline50(str, " app");
            }
            if (this.generatorType == null) {
                str = GeneratedOutlineSupport.outline50(str, " generatorType");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session autoValue_CrashlyticsReport_Session = new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.os, this.device, this.events, this.generatorType.intValue());
                return autoValue_CrashlyticsReport_Session;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setApp(Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.crashed = Boolean.valueOf(z);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setDevice(Device device2) {
            this.device = device2;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setEndedAt(Long l) {
            this.endedAt = l;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setEvents(ImmutableList<Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setGenerator(String str) {
            if (str != null) {
                this.generator = str;
                return this;
            }
            throw new NullPointerException("Null generator");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.generatorType = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setOs(OperatingSystem operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setStartedAt(long j) {
            this.startedAt = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setUser(User user2) {
            this.user = user2;
            return this;
        }

        public Builder() {
        }

        public Builder(Session session) {
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b0, code lost:
        if (r7.generatorType == r8.getGeneratorType()) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
            r2 = 0
            if (r1 == 0) goto L_0x00b5
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session) r8
            java.lang.String r1 = r7.generator
            java.lang.String r3 = r8.getGenerator()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            java.lang.String r1 = r7.identifier
            java.lang.String r3 = r8.getIdentifier()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            long r3 = r7.startedAt
            long r5 = r8.getStartedAt()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00b3
            java.lang.Long r1 = r7.endedAt
            if (r1 != 0) goto L_0x0038
            java.lang.Long r1 = r8.getEndedAt()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0042
        L_0x0038:
            java.lang.Long r3 = r8.getEndedAt()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0042:
            boolean r1 = r7.crashed
            boolean r3 = r8.isCrashed()
            if (r1 != r3) goto L_0x00b3
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r1 = r7.app
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application r3 = r8.getApp()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r7.user
            if (r1 != 0) goto L_0x0061
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r1 = r8.getUser()
            if (r1 != 0) goto L_0x00b3
            goto L_0x006b
        L_0x0061:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User r3 = r8.getUser()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x006b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r7.os
            if (r1 != 0) goto L_0x0076
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r1 = r8.getOs()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0080
        L_0x0076:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem r3 = r8.getOs()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0080:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r7.device
            if (r1 != 0) goto L_0x008b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r1 = r8.getDevice()
            if (r1 != 0) goto L_0x00b3
            goto L_0x0095
        L_0x008b:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device r3 = r8.getDevice()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x0095:
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event> r1 = r7.events
            if (r1 != 0) goto L_0x00a0
            com.google.firebase.crashlytics.internal.model.ImmutableList r1 = r8.getEvents()
            if (r1 != 0) goto L_0x00b3
            goto L_0x00aa
        L_0x00a0:
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r8.getEvents()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b3
        L_0x00aa:
            int r1 = r7.generatorType
            int r8 = r8.getGeneratorType()
            if (r1 != r8) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r0 = 0
        L_0x00b4:
            return r0
        L_0x00b5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.equals(java.lang.Object):boolean");
    }

    public Application getApp() {
        return this.app;
    }

    public Device getDevice() {
        return this.device;
    }

    public Long getEndedAt() {
        return this.endedAt;
    }

    public ImmutableList<Event> getEvents() {
        return this.events;
    }

    public String getGenerator() {
        return this.generator;
    }

    public int getGeneratorType() {
        return this.generatorType;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public OperatingSystem getOs() {
        return this.os;
    }

    public long getStartedAt() {
        return this.startedAt;
    }

    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        long j = this.startedAt;
        int hashCode = (((((this.generator.hashCode() ^ 1000003) * 1000003) ^ this.identifier.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.endedAt;
        int i = 0;
        int hashCode2 = (((((hashCode ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.crashed ? 1231 : 1237)) * 1000003) ^ this.app.hashCode()) * 1000003;
        User user2 = this.user;
        int hashCode3 = (hashCode2 ^ (user2 == null ? 0 : user2.hashCode())) * 1000003;
        OperatingSystem operatingSystem = this.os;
        int hashCode4 = (hashCode3 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        Device device2 = this.device;
        int hashCode5 = (hashCode4 ^ (device2 == null ? 0 : device2.hashCode())) * 1000003;
        ImmutableList<Event> immutableList = this.events;
        if (immutableList != null) {
            i = immutableList.hashCode();
        }
        return ((hashCode5 ^ i) * 1000003) ^ this.generatorType;
    }

    public boolean isCrashed() {
        return this.crashed;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Session{generator=");
        outline73.append(this.generator);
        outline73.append(", identifier=");
        outline73.append(this.identifier);
        outline73.append(", startedAt=");
        outline73.append(this.startedAt);
        outline73.append(", endedAt=");
        outline73.append(this.endedAt);
        outline73.append(", crashed=");
        outline73.append(this.crashed);
        outline73.append(", app=");
        outline73.append(this.app);
        outline73.append(", user=");
        outline73.append(this.user);
        outline73.append(", os=");
        outline73.append(this.os);
        outline73.append(", device=");
        outline73.append(this.device);
        outline73.append(", events=");
        outline73.append(this.events);
        outline73.append(", generatorType=");
        return GeneratedOutlineSupport.outline57(outline73, this.generatorType, "}");
    }

    public AutoValue_CrashlyticsReport_Session(String str, String str2, long j, Long l, boolean z, Application application, User user2, OperatingSystem operatingSystem, Device device2, ImmutableList<Event> immutableList, int i) {
        this.generator = str;
        this.identifier = str2;
        this.startedAt = j;
        this.endedAt = l;
        this.crashed = z;
        this.app = application;
        this.user = user2;
        this.os = operatingSystem;
        this.device = device2;
        this.events = immutableList;
        this.generatorType = i;
    }
}
