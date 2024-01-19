package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher.VideoThumbnailQuery;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {
    public final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        public final Context context;

        public Factory(Context context2) {
            this.context = context2;
        }

        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.context);
        }

        public void teardown() {
        }
    }

    public MediaStoreVideoThumbLoader(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        if (k.isThumbnailSize(i, i2)) {
            Long l = (Long) options.get(VideoDecoder.TARGET_FRAME);
            if (l != null && l.longValue() == -1) {
                ObjectKey objectKey = new ObjectKey(uri);
                Context context2 = this.context;
                return new LoadData(objectKey, ThumbFetcher.build(context2, uri, new VideoThumbnailQuery(context2.getContentResolver())));
            }
        }
        return null;
    }

    public boolean handles(Object obj) {
        Uri uri = (Uri) obj;
        return k.isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }
}
