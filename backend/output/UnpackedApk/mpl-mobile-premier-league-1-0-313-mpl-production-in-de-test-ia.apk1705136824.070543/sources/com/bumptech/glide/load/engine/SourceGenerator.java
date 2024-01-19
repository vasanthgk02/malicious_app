package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

public class SourceGenerator implements DataFetcherGenerator, FetcherReadyCallback {
    public final FetcherReadyCallback cb;
    public Object dataToCache;
    public final DecodeHelper<?> helper;
    public volatile LoadData<?> loadData;
    public int loadDataListIndex;
    public DataCacheKey originalKey;
    public DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper<?> decodeHelper, FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    public void cancel() {
        LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: finally extract failed */
    public boolean startNext() {
        Object obj = this.dataToCache;
        if (obj != null) {
            this.dataToCache = null;
            long logTime = LogTime.getLogTime();
            try {
                DataCacheWriter dataCacheWriter = new DataCacheWriter(this.helper.glideContext.getRegistry().getSourceEncoder(obj), obj, this.helper.options);
                this.originalKey = new DataCacheKey(this.loadData.sourceKey, this.helper.signature);
                this.helper.getDiskCache().put(this.originalKey, dataCacheWriter);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    "Finished encoding source to cache, key: " + this.originalKey + ", data: " + obj + ", encoder: " + r4 + ", duration: " + LogTime.getElapsedMillis(logTime);
                }
                this.loadData.fetcher.cleanup();
                this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
            } catch (Throwable th) {
                this.loadData.fetcher.cleanup();
                throw th;
            }
        }
        DataCacheGenerator dataCacheGenerator = this.sourceCacheGenerator;
        if (dataCacheGenerator != null && dataCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z) {
            if (!(this.loadDataListIndex < this.helper.getLoadData().size())) {
                break;
            }
            List<LoadData<?>> loadData2 = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData2.get(i);
            if (this.loadData != null && (this.helper.diskCacheStrategy.isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                final LoadData<?> loadData3 = this.loadData;
                this.loadData.fetcher.loadData(this.helper.priority, new DataCallback<Object>() {
                    public void onDataReady(Object obj) {
                        SourceGenerator sourceGenerator = SourceGenerator.this;
                        LoadData<?> loadData = loadData3;
                        LoadData<?> loadData2 = sourceGenerator.loadData;
                        if (loadData2 != null && loadData2 == loadData) {
                            SourceGenerator sourceGenerator2 = SourceGenerator.this;
                            LoadData loadData3 = loadData3;
                            DiskCacheStrategy diskCacheStrategy = sourceGenerator2.helper.diskCacheStrategy;
                            if (obj == null || !diskCacheStrategy.isDataCacheable(loadData3.fetcher.getDataSource())) {
                                FetcherReadyCallback fetcherReadyCallback = sourceGenerator2.cb;
                                Key key = loadData3.sourceKey;
                                DataFetcher<Data> dataFetcher = loadData3.fetcher;
                                fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), sourceGenerator2.originalKey);
                                return;
                            }
                            sourceGenerator2.dataToCache = obj;
                            sourceGenerator2.cb.reschedule();
                        }
                    }

                    public void onLoadFailed(Exception exc) {
                        SourceGenerator sourceGenerator = SourceGenerator.this;
                        LoadData<?> loadData = loadData3;
                        LoadData<?> loadData2 = sourceGenerator.loadData;
                        if (loadData2 != null && loadData2 == loadData) {
                            SourceGenerator sourceGenerator2 = SourceGenerator.this;
                            LoadData loadData3 = loadData3;
                            FetcherReadyCallback fetcherReadyCallback = sourceGenerator2.cb;
                            DataCacheKey dataCacheKey = sourceGenerator2.originalKey;
                            DataFetcher<Data> dataFetcher = loadData3.fetcher;
                            fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
                        }
                    }
                });
                z = true;
            }
        }
        return z;
    }
}
