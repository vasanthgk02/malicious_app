package com.bumptech.glide.load.model;

import androidx.core.util.Pools$Pool;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {
    public static final Factory DEFAULT_FACTORY = new Factory();
    public static final ModelLoader<Object, Object> EMPTY_MODEL_LOADER = new EmptyModelLoader();
    public final Set<Entry<?, ?>> alreadyUsedEntries = new HashSet();
    public final List<Entry<?, ?>> entries = new ArrayList();
    public final Factory factory;
    public final Pools$Pool<List<Throwable>> throwableListPool;

    public static class EmptyModelLoader implements ModelLoader<Object, Object> {
        public LoadData<Object> buildLoadData(Object obj, int i, int i2, Options options) {
            return null;
        }

        public boolean handles(Object obj) {
            return false;
        }
    }

    public static class Entry<Model, Data> {
        public final Class<Data> dataClass;
        public final ModelLoaderFactory<? extends Model, ? extends Data> factory;
        public final Class<Model> modelClass;

        public Entry(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.modelClass = cls;
            this.dataClass = cls2;
            this.factory = modelLoaderFactory;
        }

        public boolean handles(Class<?> cls, Class<?> cls2) {
            return this.modelClass.isAssignableFrom(cls) && this.dataClass.isAssignableFrom(cls2);
        }
    }

    public static class Factory {
    }

    public MultiModelLoaderFactory(Pools$Pool<List<Throwable>> pools$Pool) {
        Factory factory2 = DEFAULT_FACTORY;
        this.throwableListPool = pools$Pool;
        this.factory = factory2;
    }

    public synchronized <Model, Data> void append(Class<Model> cls, Class<Data> cls2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        Entry entry = new Entry(cls, cls2, modelLoaderFactory);
        List<Entry<?, ?>> list = this.entries;
        list.add(list.size(), entry);
    }

    public synchronized <Model> List<ModelLoader<Model, ?>> build(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry next : this.entries) {
                if (!this.alreadyUsedEntries.contains(next)) {
                    if (next.modelClass.isAssignableFrom(cls)) {
                        this.alreadyUsedEntries.add(next);
                        ModelLoader build = next.factory.build(this);
                        k.checkNotNull(build, (String) "Argument must not be null");
                        arrayList.add(build);
                        this.alreadyUsedEntries.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized List<Class<?>> getDataClasses(Class<?> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry next : this.entries) {
                if (!arrayList.contains(next.dataClass) && next.modelClass.isAssignableFrom(cls)) {
                    arrayList.add(next.dataClass);
                }
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> remove(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator<Entry<?, ?>> it = this.entries.iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                if (next.handles(cls, cls2)) {
                    it.remove();
                    arrayList.add(next.factory);
                }
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Entry next : this.entries) {
                if (this.alreadyUsedEntries.contains(next)) {
                    z = true;
                } else if (next.handles(cls, cls2)) {
                    this.alreadyUsedEntries.add(next);
                    arrayList.add(build(next));
                    this.alreadyUsedEntries.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                Factory factory2 = this.factory;
                Pools$Pool<List<Throwable>> pools$Pool = this.throwableListPool;
                if (factory2 != null) {
                    return new MultiModelLoader(arrayList, pools$Pool);
                }
                throw null;
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return EMPTY_MODEL_LOADER;
            } else {
                throw new NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.alreadyUsedEntries.clear();
            throw th;
        }
    }

    public final <Model, Data> ModelLoader<Model, Data> build(Entry<?, ?> entry) {
        ModelLoader<Model, Data> build = entry.factory.build(this);
        k.checkNotNull(build, (String) "Argument must not be null");
        return build;
    }
}
