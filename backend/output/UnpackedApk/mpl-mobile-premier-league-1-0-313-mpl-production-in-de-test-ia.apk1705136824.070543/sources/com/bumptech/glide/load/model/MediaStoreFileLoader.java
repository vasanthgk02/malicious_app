package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {
    public final Context context;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {
        public final Context context;

        public Factory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Uri, File> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.context);
        }

        public void teardown() {
        }
    }

    public static class FilePathFetcher implements DataFetcher<File> {
        public static final String[] PROJECTION = {"_data"};
        public final Context context;
        public final Uri uri;

        public FilePathFetcher(Context context2, Uri uri2) {
            this.context = context2;
            this.uri = uri2;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        public Class<File> getDataClass() {
            return File.class;
        }

        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        public void loadData(Priority priority, DataCallback<? super File> dataCallback) {
            Cursor query = this.context.getContentResolver().query(this.uri, PROJECTION, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to find file path for: ");
                outline73.append(this.uri);
                dataCallback.onLoadFailed(new FileNotFoundException(outline73.toString()));
                return;
            }
            dataCallback.onDataReady(new File(str));
        }
    }

    public MediaStoreFileLoader(Context context2) {
        this.context = context2;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return new LoadData(new ObjectKey(uri), new FilePathFetcher(this.context, uri));
    }

    public boolean handles(Object obj) {
        return k.isMediaStoreUri((Uri) obj);
    }
}
