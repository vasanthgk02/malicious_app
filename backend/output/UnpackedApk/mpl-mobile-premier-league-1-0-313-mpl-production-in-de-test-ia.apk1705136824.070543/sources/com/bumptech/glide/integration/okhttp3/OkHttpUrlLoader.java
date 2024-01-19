package com.bumptech.glide.integration.okhttp3;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.OkHttpClient;

public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    public final okhttp3.Call.Factory client;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        public static volatile okhttp3.Call.Factory internalClient;
        public final okhttp3.Call.Factory client;

        public Factory() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = new OkHttpClient();
                    }
                }
            }
            this.client = internalClient;
        }

        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }

        public void teardown() {
        }

        public Factory(okhttp3.Call.Factory factory) {
            this.client = factory;
        }
    }

    public OkHttpUrlLoader(okhttp3.Call.Factory factory) {
        this.client = factory;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        GlideUrl glideUrl = (GlideUrl) obj;
        return new LoadData(glideUrl, new OkHttpStreamFetcher(this.client, glideUrl));
    }

    public boolean handles(Object obj) {
        GlideUrl glideUrl = (GlideUrl) obj;
        return true;
    }
}
