package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;

public final class AutoValue_CrashlyticsReport_Session_Device extends Device {
    public final int arch;
    public final int cores;
    public final long diskSpace;
    public final String manufacturer;
    public final String model;
    public final String modelClass;
    public final long ram;
    public final boolean simulator;
    public final int state;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder {
        public Integer arch;
        public Integer cores;
        public Long diskSpace;
        public String manufacturer;
        public String model;
        public String modelClass;
        public Long ram;
        public Boolean simulator;
        public Integer state;

        public Device build() {
            String str = this.arch == null ? " arch" : "";
            if (this.model == null) {
                str = GeneratedOutlineSupport.outline50(str, " model");
            }
            if (this.cores == null) {
                str = GeneratedOutlineSupport.outline50(str, " cores");
            }
            if (this.ram == null) {
                str = GeneratedOutlineSupport.outline50(str, " ram");
            }
            if (this.diskSpace == null) {
                str = GeneratedOutlineSupport.outline50(str, " diskSpace");
            }
            if (this.simulator == null) {
                str = GeneratedOutlineSupport.outline50(str, " simulator");
            }
            if (this.state == null) {
                str = GeneratedOutlineSupport.outline50(str, " state");
            }
            if (this.manufacturer == null) {
                str = GeneratedOutlineSupport.outline50(str, " manufacturer");
            }
            if (this.modelClass == null) {
                str = GeneratedOutlineSupport.outline50(str, " modelClass");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Device autoValue_CrashlyticsReport_Session_Device = new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass);
                return autoValue_CrashlyticsReport_Session_Device;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setArch(int i) {
            this.arch = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setCores(int i) {
            this.cores = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setDiskSpace(long j) {
            this.diskSpace = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setManufacturer(String str) {
            if (str != null) {
                this.manufacturer = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setModel(String str) {
            if (str != null) {
                this.model = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setModelClass(String str) {
            if (str != null) {
                this.modelClass = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setRam(long j) {
            this.ram = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setSimulator(boolean z) {
            this.simulator = Boolean.valueOf(z);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setState(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        if (!(this.arch == device.getArch() && this.model.equals(device.getModel()) && this.cores == device.getCores() && this.ram == device.getRam() && this.diskSpace == device.getDiskSpace() && this.simulator == device.isSimulator() && this.state == device.getState() && this.manufacturer.equals(device.getManufacturer()) && this.modelClass.equals(device.getModelClass()))) {
            z = false;
        }
        return z;
    }

    public int getArch() {
        return this.arch;
    }

    public int getCores() {
        return this.cores;
    }

    public long getDiskSpace() {
        return this.diskSpace;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getModelClass() {
        return this.modelClass;
    }

    public long getRam() {
        return this.ram;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        long j = this.ram;
        long j2 = this.diskSpace;
        return ((((((((((((((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cores) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.simulator ? 1231 : 1237)) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    public boolean isSimulator() {
        return this.simulator;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Device{arch=");
        outline73.append(this.arch);
        outline73.append(", model=");
        outline73.append(this.model);
        outline73.append(", cores=");
        outline73.append(this.cores);
        outline73.append(", ram=");
        outline73.append(this.ram);
        outline73.append(", diskSpace=");
        outline73.append(this.diskSpace);
        outline73.append(", simulator=");
        outline73.append(this.simulator);
        outline73.append(", state=");
        outline73.append(this.state);
        outline73.append(", manufacturer=");
        outline73.append(this.manufacturer);
        outline73.append(", modelClass=");
        return GeneratedOutlineSupport.outline62(outline73, this.modelClass, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Device(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.arch = i;
        this.model = str;
        this.cores = i2;
        this.ram = j;
        this.diskSpace = j2;
        this.simulator = z;
        this.state = i3;
        this.manufacturer = str2;
        this.modelClass = str3;
    }
}
