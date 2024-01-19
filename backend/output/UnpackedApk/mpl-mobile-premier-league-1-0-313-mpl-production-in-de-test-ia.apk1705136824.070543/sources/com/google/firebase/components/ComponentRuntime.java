package com.google.firebase.components;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime extends AbstractComponentContainer implements ComponentLoader {
    public static final Provider<Set<Object>> EMPTY_PROVIDER = $$Lambda$YvUg5P3xbIDNjKaj5yOyBMxsxX0.INSTANCE;
    public final Map<Component<?>, Provider<?>> components = new HashMap();
    public final AtomicReference<Boolean> eagerComponentsInitializedWith = new AtomicReference<>();
    public final EventBus eventBus;
    public final Map<Class<?>, Provider<?>> lazyInstanceMap = new HashMap();
    public final Map<Class<?>, LazySet<?>> lazySetMap = new HashMap();
    public final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {
        public final List<Component<?>> additionalComponents = new ArrayList();
        public final Executor defaultExecutor;
        public final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:21|22|53) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r8.remove();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00a8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ComponentRuntime(java.util.concurrent.Executor r6, java.lang.Iterable<java.lang.Object> r7, java.util.Collection<com.google.firebase.components.Component> r8, com.google.firebase.components.ComponentRuntime.AnonymousClass1 r9) {
        /*
            r5 = this;
            r5.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r5.components = r9
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r5.lazyInstanceMap = r9
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            r5.lazySetMap = r9
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference
            r9.<init>()
            r5.eagerComponentsInitializedWith = r9
            com.google.firebase.components.EventBus r9 = new com.google.firebase.components.EventBus
            r9.<init>(r6)
            r5.eventBus = r9
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.google.firebase.components.EventBus r9 = r5.eventBus
            java.lang.Class<com.google.firebase.components.EventBus> r0 = com.google.firebase.components.EventBus.class
            r1 = 2
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<com.google.firebase.events.Subscriber> r2 = com.google.firebase.events.Subscriber.class
            r3 = 0
            r1[r3] = r2
            r2 = 1
            java.lang.Class<com.google.firebase.events.Publisher> r4 = com.google.firebase.events.Publisher.class
            r1[r2] = r4
            com.google.firebase.components.Component r9 = com.google.firebase.components.Component.of(r9, r0, r1)
            r6.add(r9)
            java.lang.Class<com.google.firebase.dynamicloading.ComponentLoader> r9 = com.google.firebase.dynamicloading.ComponentLoader.class
            java.lang.Class[] r0 = new java.lang.Class[r3]
            com.google.firebase.components.Component r9 = com.google.firebase.components.Component.of(r5, r9, r0)
            r6.add(r9)
            java.util.Iterator r8 = r8.iterator()
        L_0x0052:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0064
            java.lang.Object r9 = r8.next()
            com.google.firebase.components.Component r9 = (com.google.firebase.components.Component) r9
            if (r9 == 0) goto L_0x0052
            r6.add(r9)
            goto L_0x0052
        L_0x0064:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x006d:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x007b
            java.lang.Object r9 = r7.next()
            r8.add(r9)
            goto L_0x006d
        L_0x007b:
            r5.unprocessedRegistrarProviders = r8
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            monitor-enter(r5)
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r8 = r5.unprocessedRegistrarProviders     // Catch:{ all -> 0x0123 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0123 }
        L_0x0089:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0123 }
            if (r9 == 0) goto L_0x00ac
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0123 }
            com.google.firebase.inject.Provider r9 = (com.google.firebase.inject.Provider) r9     // Catch:{ all -> 0x0123 }
            java.lang.Object r9 = r9.get()     // Catch:{ InvalidRegistrarException -> 0x00a8 }
            com.google.firebase.components.ComponentRegistrar r9 = (com.google.firebase.components.ComponentRegistrar) r9     // Catch:{ InvalidRegistrarException -> 0x00a8 }
            if (r9 == 0) goto L_0x0089
            java.util.List r9 = r9.getComponents()     // Catch:{ InvalidRegistrarException -> 0x00a8 }
            r6.addAll(r9)     // Catch:{ InvalidRegistrarException -> 0x00a8 }
            r8.remove()     // Catch:{ InvalidRegistrarException -> 0x00a8 }
            goto L_0x0089
        L_0x00a8:
            r8.remove()     // Catch:{ all -> 0x0123 }
            goto L_0x0089
        L_0x00ac:
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r8 = r5.components     // Catch:{ all -> 0x0123 }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x0123 }
            if (r8 == 0) goto L_0x00b8
            com.google.android.material.resources.TextAppearanceConfig.detect(r6)     // Catch:{ all -> 0x0123 }
            goto L_0x00c9
        L_0x00b8:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0123 }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r9 = r5.components     // Catch:{ all -> 0x0123 }
            java.util.Set r9 = r9.keySet()     // Catch:{ all -> 0x0123 }
            r8.<init>(r9)     // Catch:{ all -> 0x0123 }
            r8.addAll(r6)     // Catch:{ all -> 0x0123 }
            com.google.android.material.resources.TextAppearanceConfig.detect(r8)     // Catch:{ all -> 0x0123 }
        L_0x00c9:
            java.util.Iterator r8 = r6.iterator()     // Catch:{ all -> 0x0123 }
        L_0x00cd:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x0123 }
            if (r9 == 0) goto L_0x00e9
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x0123 }
            com.google.firebase.components.Component r9 = (com.google.firebase.components.Component) r9     // Catch:{ all -> 0x0123 }
            com.google.firebase.components.Lazy r0 = new com.google.firebase.components.Lazy     // Catch:{ all -> 0x0123 }
            com.google.firebase.components.-$$Lambda$ComponentRuntime$CLI-XObGztS2iu7RD22eoA3PpJU r1 = new com.google.firebase.components.-$$Lambda$ComponentRuntime$CLI-XObGztS2iu7RD22eoA3PpJU     // Catch:{ all -> 0x0123 }
            r1.<init>(r9)     // Catch:{ all -> 0x0123 }
            r0.<init>(r1)     // Catch:{ all -> 0x0123 }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r1 = r5.components     // Catch:{ all -> 0x0123 }
            r1.put(r9, r0)     // Catch:{ all -> 0x0123 }
            goto L_0x00cd
        L_0x00e9:
            java.util.List r6 = r5.processInstanceComponents(r6)     // Catch:{ all -> 0x0123 }
            r7.addAll(r6)     // Catch:{ all -> 0x0123 }
            java.util.List r6 = r5.processSetComponents()     // Catch:{ all -> 0x0123 }
            r7.addAll(r6)     // Catch:{ all -> 0x0123 }
            r5.processDependencies()     // Catch:{ all -> 0x0123 }
            monitor-exit(r5)     // Catch:{ all -> 0x0123 }
            java.util.Iterator r6 = r7.iterator()
        L_0x00ff:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x010f
            java.lang.Object r7 = r6.next()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r7.run()
            goto L_0x00ff
        L_0x010f:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r6 = r5.eagerComponentsInitializedWith
            java.lang.Object r6 = r6.get()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 == 0) goto L_0x0122
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r7 = r5.components
            boolean r6 = r6.booleanValue()
            r5.doInitializeEagerComponents(r7, r6)
        L_0x0122:
            return
        L_0x0123:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0123 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentRuntime.<init>(java.util.concurrent.Executor, java.lang.Iterable, java.util.Collection, com.google.firebase.components.ComponentRuntime$1):void");
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    public static void lambda$processInstanceComponents$2(OptionalProvider optionalProvider, Provider provider) {
        DeferredHandler<T> deferredHandler;
        if (optionalProvider.delegate == OptionalProvider.EMPTY_PROVIDER) {
            synchronized (optionalProvider) {
                deferredHandler = optionalProvider.handler;
                optionalProvider.handler = null;
                optionalProvider.delegate = provider;
            }
            deferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public static void lambda$processSetComponents$3(LazySet lazySet, Provider provider) {
        synchronized (lazySet) {
            if (lazySet.actualSet == null) {
                lazySet.providers.add(provider);
            } else {
                lazySet.actualSet.add(provider.get());
            }
        }
    }

    public final void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        Queue<Event> queue;
        Set<Entry> emptySet;
        for (Entry next : map.entrySet()) {
            Component component = (Component) next.getKey();
            Provider provider = (Provider) next.getValue();
            boolean z2 = false;
            if (!(component.instantiation == 1)) {
                if (component.instantiation == 2) {
                    z2 = true;
                }
                if (z2) {
                    if (!z) {
                    }
                }
            }
            provider.get();
        }
        EventBus eventBus2 = this.eventBus;
        synchronized (eventBus2) {
            if (eventBus2.pendingEvents != null) {
                queue = eventBus2.pendingEvents;
                eventBus2.pendingEvents = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event event : queue) {
                if (event != null) {
                    synchronized (eventBus2) {
                        if (eventBus2.pendingEvents != null) {
                            eventBus2.pendingEvents.add(event);
                        } else {
                            synchronized (eventBus2) {
                                Map map2 = eventBus2.handlerMap.get(null);
                                emptySet = map2 == null ? Collections.emptySet() : map2.entrySet();
                            }
                            for (Entry entry : emptySet) {
                                ((Executor) entry.getValue()).execute(new Runnable(entry, event) {
                                    public final /* synthetic */ Entry f$0;
                                    public final /* synthetic */ Event f$1;

                                    {
                                        this.f$0 = r1;
                                        this.f$1 = r2;
                                    }

                                    public final void run() {
                                        ((EventHandler) this.f$0.getKey()).handle(this.f$1);
                                    }
                                });
                            }
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    public <T> Deferred<T> getDeferred(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER);
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return new OptionalProvider(null, provider);
    }

    public synchronized <T> Provider<T> getProvider(Class<T> cls) {
        try {
            TextAppearanceConfig.checkNotNull(cls, "Null interface requested.");
        }
        return this.lazyInstanceMap.get(cls);
    }

    public Object lambda$discoverComponents$0$ComponentRuntime(Component component) {
        return component.factory.create(new RestrictedComponentContainer(component, this));
    }

    public final void processDependencies() {
        for (Component next : this.components.keySet()) {
            Iterator<Dependency> it = next.dependencies.iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isSet() && !this.lazySetMap.containsKey(next2.anInterface)) {
                        this.lazySetMap.put(next2.anInterface, new LazySet(Collections.emptySet()));
                    } else if (this.lazyInstanceMap.containsKey(next2.anInterface)) {
                        continue;
                    } else {
                        if (next2.type == 1) {
                            throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.anInterface}));
                        } else if (!next2.isSet()) {
                            this.lazyInstanceMap.put(next2.anInterface, new OptionalProvider(OptionalProvider.NOOP_HANDLER, OptionalProvider.EMPTY_PROVIDER));
                        }
                    }
                }
            }
        }
    }

    public final List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component next : list) {
            if (next.isValue()) {
                Provider provider = this.components.get(next);
                for (Class next2 : next.providedInterfaces) {
                    if (!this.lazyInstanceMap.containsKey(next2)) {
                        this.lazyInstanceMap.put(next2, provider);
                    } else {
                        arrayList.add(new Runnable(provider) {
                            public final /* synthetic */ Provider f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                ComponentRuntime.lambda$processInstanceComponents$2(OptionalProvider.this, this.f$1);
                            }
                        });
                    }
                }
            }
        }
        return arrayList;
    }

    public final List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Provider provider = (Provider) next.getValue();
                for (Class next2 : component.providedInterfaces) {
                    if (!hashMap.containsKey(next2)) {
                        hashMap.put(next2, new HashSet());
                    }
                    ((Set) hashMap.get(next2)).add(provider);
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            if (!this.lazySetMap.containsKey(entry.getKey())) {
                this.lazySetMap.put((Class) entry.getKey(), new LazySet((Set) ((Collection) entry.getValue())));
            } else {
                LazySet lazySet = this.lazySetMap.get(entry.getKey());
                for (Provider r4 : (Set) entry.getValue()) {
                    arrayList.add(new Runnable(r4) {
                        public final /* synthetic */ Provider f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            ComponentRuntime.lambda$processSetComponents$3(LazySet.this, this.f$1);
                        }
                    });
                }
            }
        }
        return arrayList;
    }

    public synchronized <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        LazySet lazySet = this.lazySetMap.get(cls);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }
}
