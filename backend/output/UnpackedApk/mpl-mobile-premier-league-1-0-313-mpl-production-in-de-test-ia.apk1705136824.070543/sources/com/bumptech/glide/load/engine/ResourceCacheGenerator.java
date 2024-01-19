package com.bumptech.glide.load.engine;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

public class ResourceCacheGenerator implements DataFetcherGenerator, DataCallback<Object> {
    public File cacheFile;
    public final FetcherReadyCallback cb;
    public ResourceCacheKey currentKey;
    public final DecodeHelper<?> helper;
    public volatile LoadData<?> loadData;
    public int modelLoaderIndex;
    public List<ModelLoader<File, ?>> modelLoaders;
    public int resourceClassIndex = -1;
    public int sourceIdIndex;
    public Key sourceKey;

    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    public void cancel() {
        LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    public void onLoadFailed(Exception exc) {
        this.cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    public boolean startNext() {
        List<Key> cacheKeys = this.helper.getCacheKeys();
        if (cacheKeys.isEmpty()) {
            return false;
        }
        DecodeHelper<?> decodeHelper = this.helper;
        List<Class<?>> registeredResourceClasses = decodeHelper.glideContext.getRegistry().getRegisteredResourceClasses(decodeHelper.model.getClass(), decodeHelper.resourceClass, decodeHelper.transcodeClass);
        if (!registeredResourceClasses.isEmpty()) {
            while (true) {
                List<ModelLoader<File, ?>> list = this.modelLoaders;
                if (list != null) {
                    if (this.modelLoaderIndex < list.size()) {
                        this.loadData = null;
                        boolean z = false;
                        while (!z) {
                            if (!(this.modelLoaderIndex < this.modelLoaders.size())) {
                                break;
                            }
                            List<ModelLoader<File, ?>> list2 = this.modelLoaders;
                            int i = this.modelLoaderIndex;
                            this.modelLoaderIndex = i + 1;
                            File file = this.cacheFile;
                            DecodeHelper<?> decodeHelper2 = this.helper;
                            this.loadData = list2.get(i).buildLoadData(file, decodeHelper2.width, decodeHelper2.height, decodeHelper2.options);
                            if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                                this.loadData.fetcher.loadData(this.helper.priority, this);
                                z = true;
                            }
                        }
                        return z;
                    }
                }
                int i2 = this.resourceClassIndex + 1;
                this.resourceClassIndex = i2;
                if (i2 >= registeredResourceClasses.size()) {
                    int i3 = this.sourceIdIndex + 1;
                    this.sourceIdIndex = i3;
                    if (i3 >= cacheKeys.size()) {
                        return false;
                    }
                    this.resourceClassIndex = 0;
                }
                Key key = cacheKeys.get(this.sourceIdIndex);
                Class cls = registeredResourceClasses.get(this.resourceClassIndex);
                Transformation transformation = this.helper.getTransformation(cls);
                ArrayPool arrayPool = this.helper.glideContext.getArrayPool();
                DecodeHelper<?> decodeHelper3 = this.helper;
                ResourceCacheKey resourceCacheKey = new ResourceCacheKey(arrayPool, key, decodeHelper3.signature, decodeHelper3.width, decodeHelper3.height, transformation, cls, decodeHelper3.options);
                this.currentKey = resourceCacheKey;
                File file2 = this.helper.getDiskCache().get(this.currentKey);
                this.cacheFile = file2;
                if (file2 != null) {
                    this.sourceKey = key;
                    this.modelLoaders = this.helper.glideContext.getRegistry().getModelLoaders(file2);
                    this.modelLoaderIndex = 0;
                }
            }
        } else if (File.class.equals(this.helper.transcodeClass)) {
            return false;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to find any load path from ");
            outline73.append(this.helper.model.getClass());
            outline73.append(" to ");
            outline73.append(this.helper.transcodeClass);
            throw new IllegalStateException(outline73.toString());
        }
    }
}
