package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelCache.ModelKey;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public static final Option<Integer> TIMEOUT = Option.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(2500));
    public final ModelCache<GlideUrl, GlideUrl> modelCache;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        public final ModelCache<GlideUrl, GlideUrl> modelCache = new ModelCache<>(500);

        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.modelCache);
        }

        public void teardown() {
        }
    }

    public HttpGlideUrlLoader(ModelCache<GlideUrl, GlideUrl> modelCache2) {
        this.modelCache = modelCache2;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        GlideUrl glideUrl = (GlideUrl) obj;
        ModelCache<GlideUrl, GlideUrl> modelCache2 = this.modelCache;
        if (modelCache2 != null) {
            ModelKey modelKey = ModelKey.get(glideUrl, 0, 0);
            Object obj2 = modelCache2.cache.get(modelKey);
            synchronized (ModelKey.KEY_QUEUE) {
                ModelKey.KEY_QUEUE.offer(modelKey);
            }
            GlideUrl glideUrl2 = (GlideUrl) obj2;
            if (glideUrl2 == null) {
                ModelCache<GlideUrl, GlideUrl> modelCache3 = this.modelCache;
                if (modelCache3 != null) {
                    modelCache3.cache.put(ModelKey.get(glideUrl, 0, 0), glideUrl);
                } else {
                    throw null;
                }
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new LoadData(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.get(TIMEOUT)).intValue()));
    }

    public boolean handles(Object obj) {
        GlideUrl glideUrl = (GlideUrl) obj;
        return true;
    }
}
