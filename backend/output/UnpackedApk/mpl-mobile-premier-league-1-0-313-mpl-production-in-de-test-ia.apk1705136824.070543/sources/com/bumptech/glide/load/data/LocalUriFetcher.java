package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    public final ContentResolver contentResolver;
    public T data;
    public final Uri uri;

    public LocalUriFetcher(ContentResolver contentResolver2, Uri uri2) {
        this.contentResolver = contentResolver2;
        this.uri = uri2;
    }

    public void cancel() {
    }

    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void close(T t) throws IOException;

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public final void loadData(Priority priority, DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.uri, this.contentResolver);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (FileNotFoundException e2) {
            boolean isLoggable = Log.isLoggable("LocalUriFetcher", 3);
            dataCallback.onLoadFailed(e2);
        }
    }

    public abstract T loadResource(Uri uri2, ContentResolver contentResolver2) throws FileNotFoundException;
}
