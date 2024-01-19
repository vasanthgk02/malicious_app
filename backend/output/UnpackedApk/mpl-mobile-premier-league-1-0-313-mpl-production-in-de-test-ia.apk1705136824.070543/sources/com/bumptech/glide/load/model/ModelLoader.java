package com.bumptech.glide.load.model;

import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import java.util.Collections;
import java.util.List;

public interface ModelLoader<Model, Data> {

    public static class LoadData<Data> {
        public final List<Key> alternateKeys;
        public final DataFetcher<Data> fetcher;
        public final Key sourceKey;

        public LoadData(Key key, DataFetcher<Data> dataFetcher) {
            List<Key> emptyList = Collections.emptyList();
            k.checkNotNull(key, (String) "Argument must not be null");
            this.sourceKey = key;
            k.checkNotNull(emptyList, (String) "Argument must not be null");
            this.alternateKeys = emptyList;
            k.checkNotNull(dataFetcher, (String) "Argument must not be null");
            this.fetcher = dataFetcher;
        }
    }

    LoadData<Data> buildLoadData(Model model, int i, int i2, Options options);

    boolean handles(Model model);
}
