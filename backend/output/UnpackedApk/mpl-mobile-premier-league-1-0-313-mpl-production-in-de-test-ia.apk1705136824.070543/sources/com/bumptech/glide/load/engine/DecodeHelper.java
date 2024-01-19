package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider;
import com.bumptech.glide.load.engine.Engine.LazyDiskCacheProvider;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class DecodeHelper<Transcode> {
    public final List<Key> cacheKeys = new ArrayList();
    public DiskCacheProvider diskCacheProvider;
    public DiskCacheStrategy diskCacheStrategy;
    public GlideContext glideContext;
    public int height;
    public boolean isCacheKeysSet;
    public boolean isLoadDataSet;
    public boolean isScaleOnlyOrNoTransform;
    public boolean isTransformationRequired;
    public final List<LoadData<?>> loadData = new ArrayList();
    public Object model;
    public Options options;
    public Priority priority;
    public Class<?> resourceClass;
    public Key signature;
    public Class<Transcode> transcodeClass;
    public Map<Class<?>, Transformation<?>> transformations;
    public int width;

    public List<Key> getCacheKeys() {
        if (!this.isCacheKeysSet) {
            this.isCacheKeysSet = true;
            this.cacheKeys.clear();
            List<LoadData<?>> loadData2 = getLoadData();
            int size = loadData2.size();
            for (int i = 0; i < size; i++) {
                LoadData loadData3 = loadData2.get(i);
                if (!this.cacheKeys.contains(loadData3.sourceKey)) {
                    this.cacheKeys.add(loadData3.sourceKey);
                }
                for (int i2 = 0; i2 < loadData3.alternateKeys.size(); i2++) {
                    if (!this.cacheKeys.contains(loadData3.alternateKeys.get(i2))) {
                        this.cacheKeys.add(loadData3.alternateKeys.get(i2));
                    }
                }
            }
        }
        return this.cacheKeys;
    }

    public DiskCache getDiskCache() {
        return ((LazyDiskCacheProvider) this.diskCacheProvider).getDiskCache();
    }

    public List<LoadData<?>> getLoadData() {
        if (!this.isLoadDataSet) {
            this.isLoadDataSet = true;
            this.loadData.clear();
            List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                LoadData buildLoadData = ((ModelLoader) modelLoaders.get(i)).buildLoadData(this.model, this.width, this.height, this.options);
                if (buildLoadData != null) {
                    this.loadData.add(buildLoadData);
                }
            }
        }
        return this.loadData;
    }

    public <Z> Transformation<Z> getTransformation(Class<Z> cls) {
        Transformation<Z> transformation = this.transformations.get(cls);
        if (transformation == null) {
            Iterator<Entry<Class<?>, Transformation<?>>> it = this.transformations.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.transformations.isEmpty() || !this.isTransformationRequired) {
            return (UnitTransformation) UnitTransformation.TRANSFORMATION;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public boolean hasLoadPath(Class<?> cls) {
        return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass) != null;
    }
}
