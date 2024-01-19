package com.facebook.common.memory;

public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    public static NoOpMemoryTrimmableRegistry sInstance;

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistry;
        synchronized (NoOpMemoryTrimmableRegistry.class) {
            try {
                if (sInstance == null) {
                    sInstance = new NoOpMemoryTrimmableRegistry();
                }
                noOpMemoryTrimmableRegistry = sInstance;
            }
        }
        return noOpMemoryTrimmableRegistry;
    }

    public void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
    }
}
