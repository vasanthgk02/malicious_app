package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;

public final class AutoValue_CrashlyticsReport_Session_Event_Device extends Device {
    public final Double batteryLevel;
    public final int batteryVelocity;
    public final long diskUsed;
    public final int orientation;
    public final boolean proximityOn;
    public final long ramUsed;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder {
        public Double batteryLevel;
        public Integer batteryVelocity;
        public Long diskUsed;
        public Integer orientation;
        public Boolean proximityOn;
        public Long ramUsed;

        public Device build() {
            String str = this.batteryVelocity == null ? " batteryVelocity" : "";
            if (this.proximityOn == null) {
                str = GeneratedOutlineSupport.outline50(str, " proximityOn");
            }
            if (this.orientation == null) {
                str = GeneratedOutlineSupport.outline50(str, " orientation");
            }
            if (this.ramUsed == null) {
                str = GeneratedOutlineSupport.outline50(str, " ramUsed");
            }
            if (this.diskUsed == null) {
                str = GeneratedOutlineSupport.outline50(str, " diskUsed");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Device autoValue_CrashlyticsReport_Session_Event_Device = new AutoValue_CrashlyticsReport_Session_Event_Device(this.batteryLevel, this.batteryVelocity.intValue(), this.proximityOn.booleanValue(), this.orientation.intValue(), this.ramUsed.longValue(), this.diskUsed.longValue());
                return autoValue_CrashlyticsReport_Session_Event_Device;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double d2) {
            this.batteryLevel = d2;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i) {
            this.batteryVelocity = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long j) {
            this.diskUsed = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i) {
            this.orientation = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z) {
            this.proximityOn = Boolean.valueOf(z);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long j) {
            this.ramUsed = Long.valueOf(j);
            return this;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r7.diskUsed == r8.getDiskUsed()) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
            r2 = 0
            if (r1 == 0) goto L_0x004f
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device) r8
            java.lang.Double r1 = r7.batteryLevel
            if (r1 != 0) goto L_0x0016
            java.lang.Double r1 = r8.getBatteryLevel()
            if (r1 != 0) goto L_0x004d
            goto L_0x0020
        L_0x0016:
            java.lang.Double r3 = r8.getBatteryLevel()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x004d
        L_0x0020:
            int r1 = r7.batteryVelocity
            int r3 = r8.getBatteryVelocity()
            if (r1 != r3) goto L_0x004d
            boolean r1 = r7.proximityOn
            boolean r3 = r8.isProximityOn()
            if (r1 != r3) goto L_0x004d
            int r1 = r7.orientation
            int r3 = r8.getOrientation()
            if (r1 != r3) goto L_0x004d
            long r3 = r7.ramUsed
            long r5 = r8.getRamUsed()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x004d
            long r3 = r7.diskUsed
            long r5 = r8.getDiskUsed()
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            return r0
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device.equals(java.lang.Object):boolean");
    }

    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    public int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    public long getDiskUsed() {
        return this.diskUsed;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public long getRamUsed() {
        return this.ramUsed;
    }

    public int hashCode() {
        Double d2 = this.batteryLevel;
        int hashCode = ((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.batteryVelocity) * 1000003;
        int i = this.proximityOn ? 1231 : 1237;
        long j = this.ramUsed;
        long j2 = this.diskUsed;
        return ((((((hashCode ^ i) * 1000003) ^ this.orientation) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isProximityOn() {
        return this.proximityOn;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Device{batteryLevel=");
        outline73.append(this.batteryLevel);
        outline73.append(", batteryVelocity=");
        outline73.append(this.batteryVelocity);
        outline73.append(", proximityOn=");
        outline73.append(this.proximityOn);
        outline73.append(", orientation=");
        outline73.append(this.orientation);
        outline73.append(", ramUsed=");
        outline73.append(this.ramUsed);
        outline73.append(", diskUsed=");
        return GeneratedOutlineSupport.outline58(outline73, this.diskUsed, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Event_Device(Double d2, int i, boolean z, int i2, long j, long j2) {
        this.batteryLevel = d2;
        this.batteryVelocity = i;
        this.proximityOn = z;
        this.orientation = i2;
        this.ramUsed = j;
        this.diskUsed = j2;
    }
}
