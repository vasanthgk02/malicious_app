package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder.Factory;
import java.util.HashMap;
import java.util.Map;

public class DataRewinderRegistry {
    public static final Factory<?> DEFAULT_FACTORY = new Factory<Object>() {
        public DataRewinder<Object> build(Object obj) {
            return new DefaultRewinder(obj);
        }

        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    };
    public final Map<Class<?>, Factory<?>> rewinders = new HashMap();

    public static final class DefaultRewinder implements DataRewinder<Object> {
        public final Object data;

        public DefaultRewinder(Object obj) {
            this.data = obj;
        }

        public void cleanup() {
        }

        public Object rewindAndGet() {
            return this.data;
        }
    }
}
