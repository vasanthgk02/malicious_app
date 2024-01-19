package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    public final Pools$Pool<List<Throwable>> exceptionListPool;
    public final List<ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataCallback<Data> {
        public DataCallback<? super Data> callback;
        public int currentIndex;
        public List<Throwable> exceptions;
        public final List<DataFetcher<Data>> fetchers;
        public boolean isCancelled;
        public Priority priority;
        public final Pools$Pool<List<Throwable>> throwableListPool;

        public MultiFetcher(List<DataFetcher<Data>> list, Pools$Pool<List<Throwable>> pools$Pool) {
            this.throwableListPool = pools$Pool;
            if (!list.isEmpty()) {
                this.fetchers = list;
                this.currentIndex = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        public void cancel() {
            this.isCancelled = true;
            for (DataFetcher<Data> cancel : this.fetchers) {
                cancel.cancel();
            }
        }

        public void cleanup() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.throwableListPool.release(list);
            }
            this.exceptions = null;
            for (DataFetcher<Data> cleanup : this.fetchers) {
                cleanup.cleanup();
            }
        }

        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        public DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        public void loadData(Priority priority2, DataCallback<? super Data> dataCallback) {
            this.priority = priority2;
            this.callback = dataCallback;
            this.exceptions = (List) this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(priority2, this);
            if (this.isCancelled) {
                cancel();
            }
        }

        public void onDataReady(Data data) {
            if (data != null) {
                this.callback.onDataReady(data);
            } else {
                startNextOrFail();
            }
        }

        public void onLoadFailed(Exception exc) {
            List<Throwable> list = this.exceptions;
            k.checkNotNull(list, (String) "Argument must not be null");
            list.add(exc);
            startNextOrFail();
        }

        public final void startNextOrFail() {
            if (!this.isCancelled) {
                if (this.currentIndex < this.fetchers.size() - 1) {
                    this.currentIndex++;
                    loadData(this.priority, this.callback);
                } else {
                    k.checkNotNull(this.exceptions, (String) "Argument must not be null");
                    this.callback.onLoadFailed(new GlideException((String) "Fetch failed", (List<Throwable>) new ArrayList<Throwable>(this.exceptions)));
                }
            }
        }
    }

    public MultiModelLoader(List<ModelLoader<Model, Data>> list, Pools$Pool<List<Throwable>> pools$Pool) {
        this.modelLoaders = list;
        this.exceptionListPool = pools$Pool;
    }

    public LoadData<Data> buildLoadData(Model model, int i, int i2, Options options) {
        int size = this.modelLoaders.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = this.modelLoaders.get(i3);
            if (modelLoader.handles(model)) {
                LoadData buildLoadData = modelLoader.buildLoadData(model, i, i2, options);
                if (buildLoadData != null) {
                    key = buildLoadData.sourceKey;
                    arrayList.add(buildLoadData.fetcher);
                }
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new LoadData<>(key, new MultiFetcher(arrayList, this.exceptionListPool));
    }

    public boolean handles(Model model) {
        for (ModelLoader<Model, Data> handles : this.modelLoaders) {
            if (handles.handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MultiModelLoader{modelLoaders=");
        outline73.append(Arrays.toString(this.modelLoaders.toArray()));
        outline73.append('}');
        return outline73.toString();
    }
}
