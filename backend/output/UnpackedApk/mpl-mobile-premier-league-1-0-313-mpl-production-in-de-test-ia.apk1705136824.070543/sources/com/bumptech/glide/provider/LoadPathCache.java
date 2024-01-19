package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {
    public static final LoadPath<?, ?, ?> NO_PATHS_SIGNAL;
    public final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> cache = new ArrayMap<>();
    public final AtomicReference<MultiClassKey> keyRef = new AtomicReference<>();

    static {
        DecodePath decodePath = new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null);
        LoadPath loadPath = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(decodePath), null);
        NO_PATHS_SIGNAL = loadPath;
    }
}
