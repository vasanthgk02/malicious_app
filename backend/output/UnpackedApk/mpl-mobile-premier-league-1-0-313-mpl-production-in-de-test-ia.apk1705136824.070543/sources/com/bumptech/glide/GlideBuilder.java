package com.bumptech.glide;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.Glide.RequestOptionsFactory;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory;
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class GlideBuilder {
    public GlideExecutor animationExecutor;
    public ArrayPool arrayPool;
    public BitmapPool bitmapPool;
    public ConnectivityMonitorFactory connectivityMonitorFactory;
    public List<RequestListener<Object>> defaultRequestListeners;
    public RequestOptionsFactory defaultRequestOptionsFactory = new RequestOptionsFactory() {
        public RequestOptions build() {
            return new RequestOptions();
        }
    };
    public final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions = new ArrayMap();
    public GlideExecutor diskCacheExecutor;
    public Factory diskCacheFactory;
    public Engine engine;
    public boolean isActiveResourceRetentionAllowed;
    public boolean isImageDecoderEnabledForBitmaps;
    public boolean isLoggingRequestOriginsEnabled;
    public int logLevel = 4;
    public MemoryCache memoryCache;
    public MemorySizeCalculator memorySizeCalculator;
    public RequestManagerFactory requestManagerFactory;
    public GlideExecutor sourceExecutor;

    public GlideBuilder addGlobalRequestListener(RequestListener<Object> requestListener) {
        if (this.defaultRequestListeners == null) {
            this.defaultRequestListeners = new ArrayList();
        }
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    public Glide build(Context context) {
        Context context2 = context;
        if (this.sourceExecutor == null) {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;
            int calculateBestThreadCount = GlideExecutor.calculateBestThreadCount();
            if (!TextUtils.isEmpty(DefaultSettingsSpiCall.SOURCE_PARAM)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(calculateBestThreadCount, calculateBestThreadCount, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(DefaultSettingsSpiCall.SOURCE_PARAM, uncaughtThrowableStrategy, false));
                this.sourceExecutor = new GlideExecutor(threadPoolExecutor);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Name must be non-null and non-empty, but given: ", DefaultSettingsSpiCall.SOURCE_PARAM));
            }
        }
        if (this.diskCacheExecutor == null) {
            this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
        }
        if (this.animationExecutor == null) {
            int i = GlideExecutor.calculateBestThreadCount() >= 4 ? 2 : 1;
            UncaughtThrowableStrategy uncaughtThrowableStrategy2 = UncaughtThrowableStrategy.DEFAULT;
            if (!TextUtils.isEmpty("animation")) {
                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i, i, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory("animation", uncaughtThrowableStrategy2, true));
                this.animationExecutor = new GlideExecutor(threadPoolExecutor2);
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Name must be non-null and non-empty, but given: ", "animation"));
            }
        }
        if (this.memorySizeCalculator == null) {
            this.memorySizeCalculator = new MemorySizeCalculator(new Builder(context2));
        }
        if (this.connectivityMonitorFactory == null) {
            this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
        }
        if (this.bitmapPool == null) {
            int i2 = this.memorySizeCalculator.bitmapPoolSize;
            if (i2 > 0) {
                this.bitmapPool = new LruBitmapPool((long) i2);
            } else {
                this.bitmapPool = new BitmapPoolAdapter();
            }
        }
        if (this.arrayPool == null) {
            this.arrayPool = new LruArrayPool(this.memorySizeCalculator.arrayPoolSize);
        }
        if (this.memoryCache == null) {
            this.memoryCache = new LruResourceCache((long) this.memorySizeCalculator.memoryCacheSize);
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(context2);
        }
        if (this.engine == null) {
            MemoryCache memoryCache2 = this.memoryCache;
            Factory factory = this.diskCacheFactory;
            GlideExecutor glideExecutor = this.diskCacheExecutor;
            GlideExecutor glideExecutor2 = this.sourceExecutor;
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, GlideExecutor.KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", UncaughtThrowableStrategy.DEFAULT, false));
            Engine engine2 = new Engine(memoryCache2, factory, glideExecutor, glideExecutor2, new GlideExecutor(threadPoolExecutor3), this.animationExecutor, this.isActiveResourceRetentionAllowed);
            this.engine = engine2;
        }
        List<RequestListener<Object>> list = this.defaultRequestListeners;
        if (list == null) {
            this.defaultRequestListeners = Collections.emptyList();
        } else {
            this.defaultRequestListeners = Collections.unmodifiableList(list);
        }
        Glide glide = new Glide(context, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, this.isLoggingRequestOriginsEnabled, this.isImageDecoderEnabledForBitmaps);
        return glide;
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor glideExecutor) {
        this.animationExecutor = glideExecutor;
        return this;
    }

    public GlideBuilder setArrayPool(ArrayPool arrayPool2) {
        this.arrayPool = arrayPool2;
        return this;
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool2) {
        this.bitmapPool = bitmapPool2;
        return this;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory connectivityMonitorFactory2) {
        this.connectivityMonitorFactory = connectivityMonitorFactory2;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(RequestOptionsFactory requestOptionsFactory) {
        k.checkNotNull(requestOptionsFactory, (String) "Argument must not be null");
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        return this;
    }

    public <T> GlideBuilder setDefaultTransitionOptions(Class<T> cls, TransitionOptions<?, T> transitionOptions) {
        this.defaultTransitionOptions.put(cls, transitionOptions);
        return this;
    }

    public GlideBuilder setDiskCache(Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor glideExecutor) {
        this.diskCacheExecutor = glideExecutor;
        return this;
    }

    public GlideBuilder setEngine(Engine engine2) {
        this.engine = engine2;
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        if (!(VERSION.SDK_INT >= 29)) {
            return this;
        }
        this.isImageDecoderEnabledForBitmaps = z;
        return this;
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.isActiveResourceRetentionAllowed = z;
        return this;
    }

    public GlideBuilder setLogLevel(int i) {
        if (i < 2 || i > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.logLevel = i;
        return this;
    }

    public GlideBuilder setLogRequestOrigins(boolean z) {
        this.isLoggingRequestOriginsEnabled = z;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache2) {
        this.memoryCache = memoryCache2;
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(Builder builder) {
        if (builder != null) {
            return setMemorySizeCalculator(new MemorySizeCalculator(builder));
        }
        throw null;
    }

    public void setRequestManagerFactory(RequestManagerFactory requestManagerFactory2) {
        this.requestManagerFactory = requestManagerFactory2;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    public GlideBuilder setSourceExecutor(GlideExecutor glideExecutor) {
        this.sourceExecutor = glideExecutor;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(final RequestOptions requestOptions) {
        return setDefaultRequestOptions((RequestOptionsFactory) new RequestOptionsFactory() {
            public RequestOptions build() {
                RequestOptions requestOptions = requestOptions;
                return requestOptions != null ? requestOptions : new RequestOptions();
            }
        });
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator memorySizeCalculator2) {
        this.memorySizeCalculator = memorySizeCalculator2;
        return this;
    }
}
