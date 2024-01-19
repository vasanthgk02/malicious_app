package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.squareup.picasso.NetworkRequestHandler;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader implements ModelLoader<Uri, InputStream> {
    public static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{NetworkRequestHandler.SCHEME_HTTP, NetworkRequestHandler.SCHEME_HTTPS})));
    public final ModelLoader<GlideUrl, InputStream> urlLoader;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.urlLoader = modelLoader;
    }

    public LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        return this.urlLoader.buildLoadData(new GlideUrl(((Uri) obj).toString(), Headers.DEFAULT), i, i2, options);
    }

    public boolean handles(Object obj) {
        return SCHEMES.contains(((Uri) obj).getScheme());
    }
}
