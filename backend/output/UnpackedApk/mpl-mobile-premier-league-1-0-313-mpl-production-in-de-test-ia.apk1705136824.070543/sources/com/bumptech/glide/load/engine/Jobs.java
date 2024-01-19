package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

public final class Jobs {
    public final Map<Key, EngineJob<?>> jobs = new HashMap();
    public final Map<Key, EngineJob<?>> onlyCacheJobs = new HashMap();

    public final Map<Key, EngineJob<?>> getJobMap(boolean z) {
        return z ? this.onlyCacheJobs : this.jobs;
    }
}
