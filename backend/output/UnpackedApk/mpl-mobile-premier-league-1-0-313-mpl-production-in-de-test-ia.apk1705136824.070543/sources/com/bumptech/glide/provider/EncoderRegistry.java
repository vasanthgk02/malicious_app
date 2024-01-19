package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class EncoderRegistry {
    public final List<Entry<?>> encoders = new ArrayList();

    public static final class Entry<T> {
        public final Class<T> dataClass;
        public final Encoder<T> encoder;

        public Entry(Class<T> cls, Encoder<T> encoder2) {
            this.dataClass = cls;
            this.encoder = encoder2;
        }
    }
}
