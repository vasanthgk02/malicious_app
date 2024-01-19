package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    public static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        public final File file;

        public ByteBufferFetcher(File file2) {
            this.file = file2;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(Priority priority, DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.onDataReady(ByteBufferUtil.fromFile(this.file));
            } catch (IOException e2) {
                boolean isLoggable = Log.isLoggable("ByteBufferFileLoader", 3);
                dataCallback.onLoadFailed(e2);
            }
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public ModelLoader<File, ByteBuffer> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }

        public void teardown() {
        }
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        File file = (File) obj;
        return new LoadData(new ObjectKey(file), new ByteBufferFetcher(file));
    }

    public boolean handles(Object obj) {
        File file = (File) obj;
        return true;
    }
}
