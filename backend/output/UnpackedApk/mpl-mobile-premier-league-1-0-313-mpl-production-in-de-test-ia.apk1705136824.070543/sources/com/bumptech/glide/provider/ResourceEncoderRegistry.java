package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

public class ResourceEncoderRegistry {
    public final List<Entry<?>> encoders = new ArrayList();

    public static final class Entry<T> {
        public final ResourceEncoder<T> encoder;
        public final Class<T> resourceClass;

        public Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.resourceClass = cls;
            this.encoder = resourceEncoder;
        }
    }

    public synchronized <Z> ResourceEncoder<Z> get(Class<Z> cls) {
        try {
            int size = this.encoders.size();
            for (int i = 0; i < size; i++) {
                Entry entry = this.encoders.get(i);
                if (entry.resourceClass.isAssignableFrom(cls)) {
                    return entry.encoder;
                }
            }
            return null;
        }
    }
}
