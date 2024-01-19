package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_EventStoreConfig extends EventStoreConfig {
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final int maxBlobByteSizePerRow;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3, AnonymousClass1 r8) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = i3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = (AutoValue_EventStoreConfig) ((EventStoreConfig) obj);
        if (!(this.maxStorageSizeInBytes == autoValue_EventStoreConfig.maxStorageSizeInBytes && this.loadBatchSize == autoValue_EventStoreConfig.loadBatchSize && this.criticalSectionEnterTimeoutMs == autoValue_EventStoreConfig.criticalSectionEnterTimeoutMs && this.eventCleanUpAge == autoValue_EventStoreConfig.eventCleanUpAge && this.maxBlobByteSizePerRow == autoValue_EventStoreConfig.maxBlobByteSizePerRow)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.maxStorageSizeInBytes;
        long j2 = this.eventCleanUpAge;
        return this.maxBlobByteSizePerRow ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EventStoreConfig{maxStorageSizeInBytes=");
        outline73.append(this.maxStorageSizeInBytes);
        outline73.append(", loadBatchSize=");
        outline73.append(this.loadBatchSize);
        outline73.append(", criticalSectionEnterTimeoutMs=");
        outline73.append(this.criticalSectionEnterTimeoutMs);
        outline73.append(", eventCleanUpAge=");
        outline73.append(this.eventCleanUpAge);
        outline73.append(", maxBlobByteSizePerRow=");
        return GeneratedOutlineSupport.outline57(outline73, this.maxBlobByteSizePerRow, "}");
    }
}
