package com.bumptech.glide;

import androidx.collection.ArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.DataRewinderRegistry;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import com.bumptech.glide.load.model.ModelLoaderRegistry.ModelLoaderCache;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.provider.EncoderRegistry;
import com.bumptech.glide.provider.ImageHeaderParserRegistry;
import com.bumptech.glide.provider.LoadPathCache;
import com.bumptech.glide.provider.ModelToResourceClassCache;
import com.bumptech.glide.provider.ResourceDecoderRegistry;
import com.bumptech.glide.provider.ResourceDecoderRegistry.Entry;
import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.bumptech.glide.util.MultiClassKey;
import com.bumptech.glide.util.pool.FactoryPools.Factory;
import com.bumptech.glide.util.pool.FactoryPools.FactoryPool;
import com.bumptech.glide.util.pool.FactoryPools.Resetter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Registry {
    public static final String BUCKET_APPEND_ALL = "legacy_append";
    public static final String BUCKET_BITMAP = "Bitmap";
    public static final String BUCKET_BITMAP_DRAWABLE = "BitmapDrawable";
    public static final String BUCKET_GIF = "Gif";
    public static final String BUCKET_PREPEND_ALL = "legacy_prepend_all";
    public final DataRewinderRegistry dataRewinderRegistry;
    public final ResourceDecoderRegistry decoderRegistry;
    public final EncoderRegistry encoderRegistry;
    public final ImageHeaderParserRegistry imageHeaderParserRegistry;
    public final LoadPathCache loadPathCache = new LoadPathCache();
    public final ModelLoaderRegistry modelLoaderRegistry;
    public final ModelToResourceClassCache modelToResourceClassCache = new ModelToResourceClassCache();
    public final ResourceEncoderRegistry resourceEncoderRegistry;
    public final Pools$Pool<List<Throwable>> throwableListPool;
    public final TranscoderRegistry transcoderRegistry;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public NoModelLoaderAvailableException(Object obj) {
            // StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to find any ModelLoaders registered for model class: ");
            // outline73.append(obj.getClass());
            super(outline73.toString());
        }

        public <M> NoModelLoaderAvailableException(M m, List<ModelLoader<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        FactoryPool factoryPool = new FactoryPool(new Pools$SynchronizedPool(20), new Factory<List<T>>() {
            public Object create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() {
            public void reset(Object obj) {
                ((List) obj).clear();
            }
        });
        this.throwableListPool = factoryPool;
        this.modelLoaderRegistry = new ModelLoaderRegistry(factoryPool);
        this.encoderRegistry = new EncoderRegistry();
        this.decoderRegistry = new ResourceDecoderRegistry();
        this.resourceEncoderRegistry = new ResourceEncoderRegistry();
        this.dataRewinderRegistry = new DataRewinderRegistry();
        this.transcoderRegistry = new TranscoderRegistry();
        this.imageHeaderParserRegistry = new ImageHeaderParserRegistry();
        setResourceDecoderBucketPriorityList(Arrays.asList(new String[]{BUCKET_GIF, BUCKET_BITMAP, BUCKET_BITMAP_DRAWABLE}));
    }

    private <Data, TResource, Transcode> List<DecodePath<Data, TResource, Transcode>> getDecodePaths(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList;
        ResourceTranscoder resourceTranscoder;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((ArrayList) this.decoderRegistry.getResourceClasses(cls, cls2)).iterator();
        while (it.hasNext()) {
            Class cls4 = (Class) it.next();
            Iterator it2 = ((ArrayList) this.transcoderRegistry.getTranscodeClasses(cls4, cls3)).iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class cls5 = (Class) it2.next();
                    ResourceDecoderRegistry resourceDecoderRegistry = this.decoderRegistry;
                    synchronized (resourceDecoderRegistry) {
                        arrayList = new ArrayList();
                        for (String str : resourceDecoderRegistry.bucketPriorityList) {
                            List<Entry> list = resourceDecoderRegistry.decoders.get(str);
                            if (list != null) {
                                for (Entry entry : list) {
                                    if (entry.handles(cls, cls4)) {
                                        arrayList.add(entry.decoder);
                                    }
                                }
                            }
                        }
                    }
                    TranscoderRegistry transcoderRegistry2 = this.transcoderRegistry;
                    synchronized (transcoderRegistry2) {
                        if (cls5.isAssignableFrom(cls4)) {
                            resourceTranscoder = UnitTranscoder.UNIT_TRANSCODER;
                        } else {
                            for (TranscoderRegistry.Entry next : transcoderRegistry2.transcoders) {
                                if (next.handles(cls4, cls5)) {
                                    resourceTranscoder = next.transcoder;
                                }
                            }
                            throw new IllegalArgumentException("No transcoder registered to transcode from " + cls4 + " to " + cls5);
                        }
                    }
                    ResourceTranscoder resourceTranscoder2 = resourceTranscoder;
                    DecodePath decodePath = new DecodePath(cls, cls4, cls5, arrayList, resourceTranscoder2, this.throwableListPool);
                    arrayList2.add(decodePath);
                }
            }
        }
        return arrayList2;
    }

    public <Data> Registry append(Class<Data> cls, Encoder<Data> encoder) {
        EncoderRegistry encoderRegistry2 = this.encoderRegistry;
        synchronized (encoderRegistry2) {
            try {
                encoderRegistry2.encoders.add(new EncoderRegistry.Entry(cls, encoder));
            }
        }
        return this;
    }

    public List<ImageHeaderParser> getImageHeaderParsers() {
        List<ImageHeaderParser> list;
        ImageHeaderParserRegistry imageHeaderParserRegistry2 = this.imageHeaderParserRegistry;
        synchronized (imageHeaderParserRegistry2) {
            try {
                list = imageHeaderParserRegistry2.parsers;
            }
        }
        if (!list.isEmpty()) {
            return list;
        }
        throw new NoImageHeaderParserException();
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> getLoadPath(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath loadPath;
        LoadPath loadPath2;
        LoadPathCache loadPathCache2 = this.loadPathCache;
        LoadPath loadPath3 = null;
        MultiClassKey andSet = loadPathCache2.keyRef.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.first = cls;
        andSet.second = cls2;
        andSet.third = cls3;
        synchronized (loadPathCache2.cache) {
            loadPath = (LoadPath) loadPathCache2.cache.getOrDefault(andSet, null);
        }
        loadPathCache2.keyRef.set(andSet);
        if (this.loadPathCache == null) {
            throw null;
        } else if (LoadPathCache.NO_PATHS_SIGNAL.equals(loadPath)) {
            return null;
        } else {
            if (loadPath == null) {
                List<DecodePath<Data, TResource, Transcode>> decodePaths = getDecodePaths(cls, cls2, cls3);
                if (!decodePaths.isEmpty()) {
                    loadPath3 = new LoadPath(cls, cls2, cls3, decodePaths, this.throwableListPool);
                }
                LoadPathCache loadPathCache3 = this.loadPathCache;
                synchronized (loadPathCache3.cache) {
                    ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = loadPathCache3.cache;
                    MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
                    if (loadPath3 != null) {
                        loadPath2 = loadPath3;
                    } else {
                        loadPath2 = LoadPathCache.NO_PATHS_SIGNAL;
                    }
                    arrayMap.put(multiClassKey, loadPath2);
                }
                loadPath = loadPath3;
            }
            return loadPath;
        }
    }

    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model model) {
        ModelLoaderRegistry modelLoaderRegistry2 = this.modelLoaderRegistry;
        List<ModelLoader<Model, ?>> list = null;
        if (modelLoaderRegistry2 != null) {
            Class cls = model.getClass();
            synchronized (modelLoaderRegistry2) {
                ModelLoaderCache.Entry entry = modelLoaderRegistry2.cache.cachedModelLoaders.get(cls);
                if (entry != null) {
                    list = entry.loaders;
                }
                if (list == null) {
                    list = Collections.unmodifiableList(modelLoaderRegistry2.multiModelLoaderFactory.build(cls));
                    if (modelLoaderRegistry2.cache.cachedModelLoaders.put(cls, new ModelLoaderCache.Entry(list)) != null) {
                        throw new IllegalStateException("Already cached loaders for model: " + cls);
                    }
                }
            }
            if (!list.isEmpty()) {
                int size = list.size();
                List<ModelLoader<Model, ?>> emptyList = Collections.emptyList();
                boolean z = true;
                for (int i = 0; i < size; i++) {
                    ModelLoader modelLoader = list.get(i);
                    if (modelLoader.handles(model)) {
                        if (z) {
                            emptyList = new ArrayList<>(size - i);
                            z = false;
                        }
                        emptyList.add(modelLoader);
                    }
                }
                if (!emptyList.isEmpty()) {
                    return emptyList;
                }
                throw new NoModelLoaderAvailableException(model, list);
            }
            throw new NoModelLoaderAvailableException(model);
        }
        throw null;
    }

    public <Model, TResource, Transcode> List<Class<?>> getRegisteredResourceClasses(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> list;
        List<Class<?>> dataClasses;
        ModelToResourceClassCache modelToResourceClassCache2 = this.modelToResourceClassCache;
        MultiClassKey andSet = modelToResourceClassCache2.resourceClassKeyRef.getAndSet(null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.first = cls;
            andSet.second = cls2;
            andSet.third = cls3;
        }
        synchronized (modelToResourceClassCache2.registeredResourceClassCache) {
            list = (List) modelToResourceClassCache2.registeredResourceClassCache.getOrDefault(andSet, null);
        }
        modelToResourceClassCache2.resourceClassKeyRef.set(andSet);
        if (list == 0) {
            ArrayList arrayList = new ArrayList();
            ModelLoaderRegistry modelLoaderRegistry2 = this.modelLoaderRegistry;
            synchronized (modelLoaderRegistry2) {
                dataClasses = modelLoaderRegistry2.multiModelLoaderFactory.getDataClasses(cls);
            }
            Iterator it = ((ArrayList) dataClasses).iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) this.decoderRegistry.getResourceClasses((Class) it.next(), cls2)).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!((ArrayList) this.transcoderRegistry.getTranscodeClasses(cls4, cls3)).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            ModelToResourceClassCache modelToResourceClassCache3 = this.modelToResourceClassCache;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (modelToResourceClassCache3.registeredResourceClassCache) {
                modelToResourceClassCache3.registeredResourceClassCache.put(new MultiClassKey(cls, cls2, cls3), unmodifiableList);
            }
            list = arrayList;
        }
        return list;
    }

    public <X> ResourceEncoder<X> getResultEncoder(Resource<X> resource) throws NoResultEncoderAvailableException {
        ResourceEncoder<X> resourceEncoder = this.resourceEncoderRegistry.get(resource.getResourceClass());
        if (resourceEncoder != null) {
            return resourceEncoder;
        }
        throw new NoResultEncoderAvailableException(resource.getResourceClass());
    }

    public <X> DataRewinder<X> getRewinder(X x) {
        DataRewinder<X> build;
        DataRewinderRegistry dataRewinderRegistry2 = this.dataRewinderRegistry;
        synchronized (dataRewinderRegistry2) {
            k.checkNotNull(x, (String) "Argument must not be null");
            DataRewinder.Factory factory = dataRewinderRegistry2.rewinders.get(x.getClass());
            if (factory == null) {
                Iterator<DataRewinder.Factory<?>> it = dataRewinderRegistry2.rewinders.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DataRewinder.Factory next = it.next();
                    if (next.getDataClass().isAssignableFrom(x.getClass())) {
                        factory = next;
                        break;
                    }
                }
            }
            if (factory == null) {
                factory = DataRewinderRegistry.DEFAULT_FACTORY;
            }
            build = factory.build(x);
        }
        return build;
    }

    public <X> Encoder<X> getSourceEncoder(X x) throws NoSourceEncoderAvailableException {
        Encoder<T> encoder;
        EncoderRegistry encoderRegistry2 = this.encoderRegistry;
        Class<?> cls = x.getClass();
        synchronized (encoderRegistry2) {
            Iterator<EncoderRegistry.Entry<?>> it = encoderRegistry2.encoders.iterator();
            while (true) {
                if (!it.hasNext()) {
                    encoder = null;
                    break;
                }
                EncoderRegistry.Entry next = it.next();
                if (next.dataClass.isAssignableFrom(cls)) {
                    encoder = next.encoder;
                    break;
                }
            }
        }
        if (encoder != null) {
            return encoder;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.resourceEncoderRegistry.get(resource.getResourceClass()) != null;
    }

    public <Data> Registry prepend(Class<Data> cls, Encoder<Data> encoder) {
        EncoderRegistry encoderRegistry2 = this.encoderRegistry;
        synchronized (encoderRegistry2) {
            encoderRegistry2.encoders.add(0, new EncoderRegistry.Entry(cls, encoder));
        }
        return this;
    }

    @Deprecated
    public <Data> Registry register(Class<Data> cls, Encoder<Data> encoder) {
        return append(cls, encoder);
    }

    public <Model, Data> Registry replace(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> remove;
        ModelLoaderRegistry modelLoaderRegistry2 = this.modelLoaderRegistry;
        synchronized (modelLoaderRegistry2) {
            MultiModelLoaderFactory multiModelLoaderFactory = modelLoaderRegistry2.multiModelLoaderFactory;
            synchronized (multiModelLoaderFactory) {
                remove = multiModelLoaderFactory.remove(cls, cls2);
                multiModelLoaderFactory.append(cls, cls2, modelLoaderFactory);
            }
            Iterator it = ((ArrayList) remove).iterator();
            while (it.hasNext()) {
                ((ModelLoaderFactory) it.next()).teardown();
            }
            modelLoaderRegistry2.cache.cachedModelLoaders.clear();
        }
        return this;
    }

    public final Registry setResourceDecoderBucketPriorityList(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, BUCKET_PREPEND_ALL);
        arrayList.add(BUCKET_APPEND_ALL);
        ResourceDecoderRegistry resourceDecoderRegistry = this.decoderRegistry;
        synchronized (resourceDecoderRegistry) {
            ArrayList arrayList2 = new ArrayList(resourceDecoderRegistry.bucketPriorityList);
            resourceDecoderRegistry.bucketPriorityList.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                resourceDecoderRegistry.bucketPriorityList.add((String) it.next());
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                if (!arrayList.contains(str)) {
                    resourceDecoderRegistry.bucketPriorityList.add(str);
                }
            }
        }
        return this;
    }

    @Deprecated
    public <TResource> Registry register(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        return append(cls, resourceEncoder);
    }

    public Registry register(DataRewinder.Factory<?> factory) {
        DataRewinderRegistry dataRewinderRegistry2 = this.dataRewinderRegistry;
        synchronized (dataRewinderRegistry2) {
            try {
                dataRewinderRegistry2.rewinders.put(factory.getDataClass(), factory);
            }
        }
        return this;
    }

    public <Data, TResource> Registry append(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        append(BUCKET_APPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> Registry prepend(Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        prepend(BUCKET_PREPEND_ALL, cls, cls2, resourceDecoder);
        return this;
    }

    public <Data, TResource> Registry append(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        ResourceDecoderRegistry resourceDecoderRegistry = this.decoderRegistry;
        synchronized (resourceDecoderRegistry) {
            try {
                resourceDecoderRegistry.getOrAddEntryList(str).add(new Entry(cls, cls2, resourceDecoder));
            }
        }
        return this;
    }

    public <Data, TResource> Registry prepend(String str, Class<Data> cls, Class<TResource> cls2, ResourceDecoder<Data, TResource> resourceDecoder) {
        ResourceDecoderRegistry resourceDecoderRegistry = this.decoderRegistry;
        synchronized (resourceDecoderRegistry) {
            resourceDecoderRegistry.getOrAddEntryList(str).add(0, new Entry(cls, cls2, resourceDecoder));
        }
        return this;
    }

    public <TResource, Transcode> Registry register(Class<TResource> cls, Class<Transcode> cls2, ResourceTranscoder<TResource, Transcode> resourceTranscoder) {
        TranscoderRegistry transcoderRegistry2 = this.transcoderRegistry;
        synchronized (transcoderRegistry2) {
            try {
                transcoderRegistry2.transcoders.add(new TranscoderRegistry.Entry(cls, cls2, resourceTranscoder));
            }
        }
        return this;
    }

    public <TResource> Registry append(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        ResourceEncoderRegistry resourceEncoderRegistry2 = this.resourceEncoderRegistry;
        synchronized (resourceEncoderRegistry2) {
            try {
                resourceEncoderRegistry2.encoders.add(new ResourceEncoderRegistry.Entry(cls, resourceEncoder));
            }
        }
        return this;
    }

    public <TResource> Registry prepend(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        ResourceEncoderRegistry resourceEncoderRegistry2 = this.resourceEncoderRegistry;
        synchronized (resourceEncoderRegistry2) {
            resourceEncoderRegistry2.encoders.add(0, new ResourceEncoderRegistry.Entry(cls, resourceEncoder));
        }
        return this;
    }

    public Registry register(ImageHeaderParser imageHeaderParser) {
        ImageHeaderParserRegistry imageHeaderParserRegistry2 = this.imageHeaderParserRegistry;
        synchronized (imageHeaderParserRegistry2) {
            imageHeaderParserRegistry2.parsers.add(imageHeaderParser);
        }
        return this;
    }

    public <Model, Data> Registry append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        ModelLoaderRegistry modelLoaderRegistry2 = this.modelLoaderRegistry;
        synchronized (modelLoaderRegistry2) {
            try {
                modelLoaderRegistry2.multiModelLoaderFactory.append(cls, cls2, modelLoaderFactory);
                modelLoaderRegistry2.cache.cachedModelLoaders.clear();
            }
        }
        return this;
    }

    public <Model, Data> Registry prepend(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<Model, Data> modelLoaderFactory) {
        ModelLoaderRegistry modelLoaderRegistry2 = this.modelLoaderRegistry;
        synchronized (modelLoaderRegistry2) {
            MultiModelLoaderFactory multiModelLoaderFactory = modelLoaderRegistry2.multiModelLoaderFactory;
            synchronized (multiModelLoaderFactory) {
                multiModelLoaderFactory.entries.add(0, new MultiModelLoaderFactory.Entry(cls, cls2, modelLoaderFactory));
            }
            modelLoaderRegistry2.cache.cachedModelLoaders.clear();
        }
        return this;
    }
}
