package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    public static final UnitTranscoder<?> UNIT_TRANSCODER = new UnitTranscoder<>();

    public Resource<Z> transcode(Resource<Z> resource, Options options) {
        return resource;
    }
}
