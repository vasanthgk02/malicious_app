package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData;

public final class AutoValue_StaticSessionData_DeviceData extends DeviceData {
    public final int arch;
    public final int availableProcessors;
    public final long diskSpace;
    public final boolean isEmulator;
    public final String manufacturer;
    public final String model;
    public final String modelClass;
    public final int state;
    public final long totalRam;

    public AutoValue_StaticSessionData_DeviceData(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.arch = i;
        if (str != null) {
            this.model = str;
            this.availableProcessors = i2;
            this.totalRam = j;
            this.diskSpace = j2;
            this.isEmulator = z;
            this.state = i3;
            if (str2 != null) {
                this.manufacturer = str2;
                if (str3 != null) {
                    this.modelClass = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    public int arch() {
        return this.arch;
    }

    public int availableProcessors() {
        return this.availableProcessors;
    }

    public long diskSpace() {
        return this.diskSpace;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceData)) {
            return false;
        }
        DeviceData deviceData = (DeviceData) obj;
        if (!(this.arch == deviceData.arch() && this.model.equals(deviceData.model()) && this.availableProcessors == deviceData.availableProcessors() && this.totalRam == deviceData.totalRam() && this.diskSpace == deviceData.diskSpace() && this.isEmulator == deviceData.isEmulator() && this.state == deviceData.state() && this.manufacturer.equals(deviceData.manufacturer()) && this.modelClass.equals(deviceData.modelClass()))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.totalRam;
        long j2 = this.diskSpace;
        return ((((((((((((((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.availableProcessors) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.isEmulator ? 1231 : 1237)) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    public boolean isEmulator() {
        return this.isEmulator;
    }

    public String manufacturer() {
        return this.manufacturer;
    }

    public String model() {
        return this.model;
    }

    public String modelClass() {
        return this.modelClass;
    }

    public int state() {
        return this.state;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DeviceData{arch=");
        outline73.append(this.arch);
        outline73.append(", model=");
        outline73.append(this.model);
        outline73.append(", availableProcessors=");
        outline73.append(this.availableProcessors);
        outline73.append(", totalRam=");
        outline73.append(this.totalRam);
        outline73.append(", diskSpace=");
        outline73.append(this.diskSpace);
        outline73.append(", isEmulator=");
        outline73.append(this.isEmulator);
        outline73.append(", state=");
        outline73.append(this.state);
        outline73.append(", manufacturer=");
        outline73.append(this.manufacturer);
        outline73.append(", modelClass=");
        return GeneratedOutlineSupport.outline62(outline73, this.modelClass, "}");
    }

    public long totalRam() {
        return this.totalRam;
    }
}
