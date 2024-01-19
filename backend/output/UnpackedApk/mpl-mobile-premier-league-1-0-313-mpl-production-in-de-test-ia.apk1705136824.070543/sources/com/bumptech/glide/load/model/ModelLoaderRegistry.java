package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {
    public final ModelLoaderCache cache = new ModelLoaderCache();
    public final MultiModelLoaderFactory multiModelLoaderFactory;

    public static class ModelLoaderCache {
        public final Map<Class<?>, Entry<?>> cachedModelLoaders = new HashMap();

        public static class Entry<Model> {
            public final List<ModelLoader<Model, ?>> loaders;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.loaders = list;
            }
        }
    }

    public ModelLoaderRegistry(Pools$Pool<List<Throwable>> pools$Pool) {
        MultiModelLoaderFactory multiModelLoaderFactory2 = new MultiModelLoaderFactory(pools$Pool);
        this.multiModelLoaderFactory = multiModelLoaderFactory2;
    }
}
