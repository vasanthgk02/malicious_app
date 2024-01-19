package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders.Builder;
import java.util.Map;

public interface Headers {
    public static final Headers DEFAULT;

    static {
        Builder builder = new Builder();
        builder.copyOnModify = true;
        DEFAULT = new LazyHeaders(builder.headers);
    }

    Map<String, String> getHeaders();
}
