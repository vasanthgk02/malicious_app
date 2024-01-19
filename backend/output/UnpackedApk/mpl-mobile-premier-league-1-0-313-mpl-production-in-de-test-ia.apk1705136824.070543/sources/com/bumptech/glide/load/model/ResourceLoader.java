package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {
    public final Resources resources;
    public final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
        public final Resources resources;

        public AssetFileDescriptorFactory(Resources resources2) {
            this.resources = resources2;
        }

        public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        public final Resources resources;

        public FileDescriptorFactory(Resources resources2) {
            this.resources = resources2;
        }

        public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {
        public final Resources resources;

        public StreamFactory(Resources resources2) {
            this.resources = resources2;
        }

        public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {
        public final Resources resources;

        public UriFactory(Resources resources2) {
            this.resources = resources2;
        }

        public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.resources, UnitModelLoader.INSTANCE);
        }

        public void teardown() {
        }
    }

    public ResourceLoader(Resources resources2, ModelLoader<Uri, Data> modelLoader) {
        this.resources = resources2;
        this.uriLoader = modelLoader;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        Object obj2;
        Integer num = (Integer) obj;
        try {
            obj2 = Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (NotFoundException unused) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                "Received invalid resource id: " + num;
            }
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return this.uriLoader.buildLoadData(obj2, i, i2, options);
    }

    public boolean handles(Object obj) {
        Integer num = (Integer) obj;
        return true;
    }
}
