package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.StreamFactory;
import com.bumptech.glide.load.model.ResourceLoader.UriFactory;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader.Factory;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.InputStreamFactory;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder.AssetFileDescriptorInitializer;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder.ParcelFileDescriptorInitializer;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    public static final String TAG = "Glide";
    public static volatile Glide glide;
    public static volatile boolean isInitializing;
    public final ArrayPool arrayPool;
    public final BitmapPool bitmapPool;
    public BitmapPreFiller bitmapPreFiller;
    public final ConnectivityMonitorFactory connectivityMonitorFactory;
    public final RequestOptionsFactory defaultRequestOptionsFactory;
    public final Engine engine;
    public final GlideContext glideContext;
    public final List<RequestManager> managers = new ArrayList();
    public final MemoryCache memoryCache;
    public MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    public final Registry registry;
    public final RequestManagerRetriever requestManagerRetriever;

    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    public Glide(Context context, Engine engine2, MemoryCache memoryCache2, BitmapPool bitmapPool2, ArrayPool arrayPool2, RequestManagerRetriever requestManagerRetriever2, ConnectivityMonitorFactory connectivityMonitorFactory2, int i, RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, boolean z, boolean z2) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Context context2 = context;
        BitmapPool bitmapPool3 = bitmapPool2;
        ArrayPool arrayPool3 = arrayPool2;
        Class<GifDecoder> cls = GifDecoder.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        this.engine = engine2;
        this.bitmapPool = bitmapPool3;
        this.arrayPool = arrayPool3;
        this.memoryCache = memoryCache2;
        this.requestManagerRetriever = requestManagerRetriever2;
        this.connectivityMonitorFactory = connectivityMonitorFactory2;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.registry = registry2;
        registry2.register((ImageHeaderParser) new DefaultImageHeaderParser());
        if (VERSION.SDK_INT >= 27) {
            this.registry.register((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> imageHeaderParsers = this.registry.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, imageHeaderParsers, bitmapPool3, arrayPool3);
        VideoDecoder videoDecoder = new VideoDecoder(bitmapPool3, new ParcelFileDescriptorInitializer());
        Downsampler downsampler = new Downsampler(this.registry.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool3, arrayPool3);
        if (!z2 || VERSION.SDK_INT < 28) {
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool3);
        } else {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        Class<byte[]> cls5 = cls4;
        StreamFactory streamFactory = new StreamFactory(resources);
        UriFactory uriFactory = new UriFactory(resources);
        Class<String> cls6 = cls2;
        FileDescriptorFactory fileDescriptorFactory = new FileDescriptorFactory(resources);
        UriFactory uriFactory2 = uriFactory;
        AssetFileDescriptorFactory assetFileDescriptorFactory = new AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool3);
        Class<Integer> cls7 = cls3;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        this.registry.append(ByteBuffer.class, (Encoder<Data>) new ByteBufferEncoder<Data>()).append(InputStream.class, (Encoder<Data>) new StreamEncoder<Data>(arrayPool3)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, resourceDecoder).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, resourceDecoder2);
        this.registry.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        Class<GifDecoder> cls8 = cls;
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        this.registry.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, videoDecoder).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, new VideoDecoder(bitmapPool3, new AssetFileDescriptorInitializer(null))).append(Bitmap.class, Bitmap.class, (ModelLoaderFactory<Model, Data>) Factory.FACTORY).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, (ResourceEncoder<TResource>) bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoder2)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, videoDecoder)).append(BitmapDrawable.class, (ResourceEncoder<TResource>) new BitmapDrawableEncoder<TResource>(bitmapPool3, bitmapEncoder)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool3)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, (ResourceEncoder<TResource>) new GifDrawableEncoder<TResource>()).append(cls8, cls8, (ModelLoaderFactory<Model, Data>) Factory.FACTORY).append(Registry.BUCKET_BITMAP, cls8, Bitmap.class, new GifFrameResourceDecoder(bitmapPool3)).append(Uri.class, Drawable.class, (ResourceDecoder<Data, TResource>) resourceDrawableDecoder2).append(Uri.class, Bitmap.class, (ResourceDecoder<Data, TResource>) new ResourceBitmapDecoder<Data,TResource>(resourceDrawableDecoder2, bitmapPool3)).register((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory<Object>()).append(File.class, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new ByteBufferFileLoader.Factory<Model,Data>()).append(File.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new FileLoader.StreamFactory<Model,Data>()).append(File.class, File.class, (ResourceDecoder<Data, TResource>) new FileDecoder<Data,TResource>()).append(File.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new FileLoader.FileDescriptorFactory<Model,Data>()).append(File.class, File.class, (ModelLoaderFactory<Model, Data>) Factory.FACTORY).register((DataRewinder.Factory<?>) new InputStreamRewinder.Factory<Object>(arrayPool3));
        this.registry.register((DataRewinder.Factory<?>) new ParcelFileDescriptorRewinder.Factory<Object>());
        StreamFactory streamFactory2 = streamFactory;
        FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        Class<Integer> cls9 = cls7;
        UriFactory uriFactory3 = uriFactory2;
        AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        Class<String> cls10 = cls6;
        Context context3 = context;
        this.registry.append(Integer.TYPE, InputStream.class, (ModelLoaderFactory<Model, Data>) streamFactory2).append(Integer.TYPE, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) fileDescriptorFactory3).append(cls9, InputStream.class, (ModelLoaderFactory<Model, Data>) streamFactory2).append(cls9, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) fileDescriptorFactory3).append(cls9, Uri.class, (ModelLoaderFactory<Model, Data>) uriFactory3).append(Integer.TYPE, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) assetFileDescriptorFactory2).append(cls9, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) assetFileDescriptorFactory2).append(Integer.TYPE, Uri.class, (ModelLoaderFactory<Model, Data>) uriFactory3).append(cls10, InputStream.class, (ModelLoaderFactory<Model, Data>) new DataUrlLoader.StreamFactory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new DataUrlLoader.StreamFactory<Model,Data>()).append(cls10, InputStream.class, (ModelLoaderFactory<Model, Data>) new StringLoader.StreamFactory<Model,Data>()).append(cls10, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new StringLoader.FileDescriptorFactory<Model,Data>()).append(cls10, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new StringLoader.AssetFileDescriptorFactory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new HttpUriLoader.Factory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new AssetUriLoader.StreamFactory<Model,Data>(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new AssetUriLoader.FileDescriptorFactory<Model,Data>(context.getAssets())).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreImageThumbLoader.Factory<Model,Data>(context3)).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreVideoThumbLoader.Factory<Model,Data>(context3));
        if (VERSION.SDK_INT >= 29) {
            this.registry.append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new InputStreamFactory<Model,Data>(context3));
            this.registry.append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new QMediaStoreUriLoader.FileDescriptorFactory<Model,Data>(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls11 = cls5;
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        this.registry.append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UriLoader.StreamFactory<Model,Data>(contentResolver2)).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new UriLoader.FileDescriptorFactory<Model,Data>(contentResolver2)).append(Uri.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new UriLoader.AssetFileDescriptorFactory<Model,Data>(contentResolver2)).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UrlUriLoader.StreamFactory<Model,Data>()).append(URL.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UrlLoader.StreamFactory<Model,Data>()).append(Uri.class, File.class, (ModelLoaderFactory<Model, Data>) new MediaStoreFileLoader.Factory<Model,Data>(context3)).append(GlideUrl.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new HttpGlideUrlLoader.Factory<Model,Data>()).append(cls11, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new ByteBufferFactory<Model,Data>()).append(cls11, InputStream.class, (ModelLoaderFactory<Model, Data>) new ByteArrayLoader.StreamFactory<Model,Data>()).append(Uri.class, Uri.class, (ModelLoaderFactory<Model, Data>) Factory.FACTORY).append(Drawable.class, Drawable.class, (ModelLoaderFactory<Model, Data>) Factory.FACTORY).append(Drawable.class, Drawable.class, (ResourceDecoder<Data, TResource>) new UnitDrawableDecoder<Data,TResource>()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, cls11, bitmapBytesTranscoder2).register(Drawable.class, cls11, new DrawableBytesTranscoder(bitmapPool3, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).register(GifDrawable.class, cls11, gifDrawableBytesTranscoder2);
        if (VERSION.SDK_INT >= 23) {
            VideoDecoder videoDecoder2 = new VideoDecoder(bitmapPool3, new ByteBufferInitializer());
            this.registry.append(ByteBuffer.class, Bitmap.class, (ResourceDecoder<Data, TResource>) videoDecoder2);
            this.registry.append(ByteBuffer.class, BitmapDrawable.class, (ResourceDecoder<Data, TResource>) new BitmapDrawableDecoder<Data,TResource>(resources, videoDecoder2));
        }
        Context context4 = context;
        ArrayPool arrayPool4 = arrayPool2;
        GlideContext glideContext2 = new GlideContext(context4, arrayPool4, this.registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine2, z, i);
        this.glideContext = glideContext2;
    }

    public static void checkAndInitializeGlide(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!isInitializing) {
            isInitializing = true;
            initializeGlide(context, generatedAppGlideModule);
            isInitializing = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static Glide get(Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (Glide.class) {
                if (glide == null) {
                    checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                }
            }
        }
        return glide;
    }

    public static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            boolean isLoggable = Log.isLoggable(TAG, 5);
        } catch (InstantiationException e2) {
            throwIncorrectGlideModule(e2);
        } catch (IllegalAccessException e3) {
            throwIncorrectGlideModule(e3);
        } catch (NoSuchMethodException e4) {
            throwIncorrectGlideModule(e4);
        } catch (InvocationTargetException e5) {
            throwIncorrectGlideModule(e5);
        }
        return null;
    }

    public static File getPhotoCacheDir(Context context) {
        return getPhotoCacheDir(context, DEFAULT_DISK_CACHE_DIR);
    }

    public static RequestManagerRetriever getRetriever(Context context) {
        k.checkNotNull(context, (String) "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            glide = glide2;
        }
    }

    public static void initializeGlide(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new GlideBuilder(), generatedAppGlideModule);
    }

    public static synchronized void tearDown() {
        synchronized (Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                glide.engine.shutdown();
            }
            glide = null;
        }
    }

    public static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static RequestManager with(Context context) {
        return getRetriever(context).get(context);
    }

    public void clearDiskCache() {
        if (Util.isOnBackgroundThread()) {
            this.engine.diskCacheProvider.getDiskCache().clear();
            return;
        }
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public void clearMemory() {
        Util.assertMainThread();
        ((LruCache) this.memoryCache).trimToSize(0);
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    public Registry getRegistry() {
        return this.registry;
    }

    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        clearMemory();
    }

    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public synchronized void preFillBitmapPool(Builder... builderArr) {
        if (this.bitmapPreFiller == null) {
            this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT));
        }
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void registerRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (!this.managers.contains(requestManager)) {
                this.managers.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public boolean removeFromManagers(Target<?> target) {
        synchronized (this.managers) {
            for (RequestManager untrack : this.managers) {
                if (untrack.untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public MemoryCategory setMemoryCategory(MemoryCategory memoryCategory2) {
        Util.assertMainThread();
        MemoryCache memoryCache2 = this.memoryCache;
        float multiplier = memoryCategory2.getMultiplier();
        LruCache lruCache = (LruCache) memoryCache2;
        synchronized (lruCache) {
            if (multiplier >= 0.0f) {
                long round = (long) Math.round(((float) lruCache.initialMaxSize) * multiplier);
                lruCache.maxSize = round;
                lruCache.trimToSize(round);
            } else {
                throw new IllegalArgumentException("Multiplier must be >= 0");
            }
        }
        this.bitmapPool.setSizeMultiplier(memoryCategory2.getMultiplier());
        MemoryCategory memoryCategory3 = this.memoryCategory;
        this.memoryCategory = memoryCategory2;
        return memoryCategory3;
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        for (RequestManager onTrimMemory : this.managers) {
            onTrimMemory.onTrimMemory(i);
        }
        LruResourceCache lruResourceCache = (LruResourceCache) this.memoryCache;
        if (lruResourceCache != null) {
            if (i >= 40) {
                lruResourceCache.trimToSize(0);
            } else if (i >= 20 || i == 15) {
                lruResourceCache.trimToSize(lruResourceCache.getMaxSize() / 2);
            }
            this.bitmapPool.trimMemory(i);
            this.arrayPool.trimMemory(i);
            return;
        }
        throw null;
    }

    public void unregisterRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (this.managers.contains(requestManager)) {
                this.managers.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public static File getPhotoCacheDir(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        boolean isLoggable = Log.isLoggable(TAG, 6);
        return null;
    }

    public static void initializeGlide(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            Log.isLoggable("ManifestParser", 3);
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo.metaData == null) {
                    Log.isLoggable("ManifestParser", 3);
                } else {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        "Got app info metadata: " + applicationInfo.metaData;
                    }
                    for (String str : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                            arrayList.add(ManifestParser.parseModule(str));
                            Log.isLoggable("ManifestParser", 3);
                        }
                    }
                    Log.isLoggable("ManifestParser", 3);
                }
                emptyList = arrayList;
            } catch (NameNotFoundException e2) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
            }
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                if (excludedModuleClasses.contains(((GlideModule) it.next()).getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        "AppGlideModule excludes manifest GlideModule: " + r5;
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            for (GlideModule glideModule : emptyList) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Discovered GlideModule from manifest: ");
                outline73.append(glideModule.getClass());
                outline73.toString();
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        for (GlideModule applyOptions : emptyList) {
            applyOptions.applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        Glide build = glideBuilder.build(applicationContext);
        for (GlideModule glideModule2 : emptyList) {
            try {
                glideModule2.registerComponents(applicationContext, build, build.registry);
            } catch (AbstractMethodError e3) {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                outline732.append(glideModule2.getClass().getName());
                throw new IllegalStateException(outline732.toString(), e3);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, build, build.registry);
        }
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    public static RequestManager with(Activity activity) {
        return getRetriever(activity).get(activity);
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    public static RequestManager with(Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    public static void init(Context context, GlideBuilder glideBuilder) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
        }
    }

    @Deprecated
    public static RequestManager with(android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    public static RequestManager with(View view) {
        RequestManagerRetriever retriever = getRetriever(view.getContext());
        if (retriever == null) {
            throw null;
        } else if (Util.isOnBackgroundThread()) {
            return retriever.get(view.getContext().getApplicationContext());
        } else {
            k.checkNotNull(view, (String) "Argument must not be null");
            k.checkNotNull(view.getContext(), (String) "Unable to obtain a request manager for a view without a Context");
            Activity findActivity = RequestManagerRetriever.findActivity(view.getContext());
            if (findActivity == null) {
                return retriever.get(view.getContext().getApplicationContext());
            }
            if (findActivity instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) findActivity;
                retriever.tempViewToSupportFragment.clear();
                RequestManagerRetriever.findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), retriever.tempViewToSupportFragment);
                View findViewById = fragmentActivity.findViewById(16908290);
                Fragment fragment = null;
                while (!view.equals(findViewById)) {
                    fragment = (Fragment) retriever.tempViewToSupportFragment.getOrDefault(view, null);
                    if (fragment != null || !(view.getParent() instanceof View)) {
                        break;
                    }
                    view = (View) view.getParent();
                }
                retriever.tempViewToSupportFragment.clear();
                return fragment != null ? retriever.get(fragment) : retriever.get(fragmentActivity);
            }
            retriever.tempViewToFragment.clear();
            retriever.findAllFragmentsWithViews(findActivity.getFragmentManager(), retriever.tempViewToFragment);
            View findViewById2 = findActivity.findViewById(16908290);
            android.app.Fragment fragment2 = null;
            while (!view.equals(findViewById2)) {
                fragment2 = (android.app.Fragment) retriever.tempViewToFragment.getOrDefault(view, null);
                if (fragment2 != null || !(view.getParent() instanceof View)) {
                    break;
                }
                view = (View) view.getParent();
            }
            retriever.tempViewToFragment.clear();
            if (fragment2 == null) {
                return retriever.get(findActivity);
            }
            return retriever.get(fragment2);
        }
    }
}
