package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage.Entry;

public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public EntryEvictionComparator get() {
        return new EntryEvictionComparator(this) {
            public int compare(Object obj, Object obj2) {
                long timestamp = ((Entry) obj).getTimestamp();
                long timestamp2 = ((Entry) obj2).getTimestamp();
                if (timestamp < timestamp2) {
                    return -1;
                }
                return timestamp2 == timestamp ? 0 : 1;
            }
        };
    }
}
