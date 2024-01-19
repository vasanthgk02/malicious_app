package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.signature.ObjectKey;
import com.squareup.picasso.AssetRequestHandler;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {
    public final AssetManager assetManager;
    public final AssetFetcherFactory<Data> factory;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> buildFetcher(AssetManager assetManager, String str);
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {
        public final AssetManager assetManager;

        public FileDescriptorFactory(AssetManager assetManager2) {
            this.assetManager = assetManager2;
        }

        public ModelLoader<Uri, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.assetManager, this);
        }

        public DataFetcher<ParcelFileDescriptor> buildFetcher(AssetManager assetManager2, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager2, str);
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {
        public final AssetManager assetManager;

        public StreamFactory(AssetManager assetManager2) {
            this.assetManager = assetManager2;
        }

        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.assetManager, this);
        }

        public DataFetcher<InputStream> buildFetcher(AssetManager assetManager2, String str) {
            return new StreamAssetPathFetcher(assetManager2, str);
        }

        public void teardown() {
        }
    }

    public AssetUriLoader(AssetManager assetManager2, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.assetManager = assetManager2;
        this.factory = assetFetcherFactory;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        Uri uri = (Uri) obj;
        return new LoadData(new ObjectKey(uri), this.factory.buildFetcher(this.assetManager, uri.toString().substring(22)));
    }

    public boolean handles(Object obj) {
        Uri uri = (Uri) obj;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !AssetRequestHandler.ANDROID_ASSET.equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
