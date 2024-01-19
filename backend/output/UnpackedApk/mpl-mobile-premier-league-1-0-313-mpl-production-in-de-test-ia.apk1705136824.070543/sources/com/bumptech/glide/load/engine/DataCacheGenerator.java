package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.File;
import java.util.List;

public class DataCacheGenerator implements DataFetcherGenerator, DataCallback<Object> {
    public File cacheFile;
    public final List<Key> cacheKeys;
    public final FetcherReadyCallback cb;
    public final DecodeHelper<?> helper;
    public volatile LoadData<?> loadData;
    public int modelLoaderIndex;
    public List<ModelLoader<File, ?>> modelLoaders;
    public int sourceIdIndex = -1;
    public Key sourceKey;

    public DataCacheGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        List<Key> cacheKeys2 = decodeHelper.getCacheKeys();
        this.cacheKeys = cacheKeys2;
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
        this.cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    public void onLoadFailed(Exception exc) {
        this.cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public boolean startNext() {
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
                        DecodeHelper<?> decodeHelper = this.helper;
                        this.loadData = list2.get(i).buildLoadData(file, decodeHelper.width, decodeHelper.height, decodeHelper.options);
                        if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                            this.loadData.fetcher.loadData(this.helper.priority, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            int i2 = this.sourceIdIndex + 1;
            this.sourceIdIndex = i2;
            if (i2 >= this.cacheKeys.size()) {
                return false;
            }
            Key key = this.cacheKeys.get(this.sourceIdIndex);
            File file2 = this.helper.getDiskCache().get(new DataCacheKey(key, this.helper.signature));
            this.cacheFile = file2;
            if (file2 != null) {
                this.sourceKey = key;
                this.modelLoaders = this.helper.glideContext.getRegistry().getModelLoaders(file2);
                this.modelLoaderIndex = 0;
            }
        }
    }

    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }
}
