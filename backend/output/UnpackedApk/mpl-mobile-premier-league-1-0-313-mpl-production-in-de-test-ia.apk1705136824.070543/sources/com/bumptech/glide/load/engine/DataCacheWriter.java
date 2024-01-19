package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;

public class DataCacheWriter<DataType> implements Writer {
    public final DataType data;
    public final Encoder<DataType> encoder;
    public final Options options;

    public DataCacheWriter(Encoder<DataType> encoder2, DataType datatype, Options options2) {
        this.encoder = encoder2;
        this.data = datatype;
        this.options = options2;
    }
}
