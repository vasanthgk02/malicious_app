package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class RestrictedComponentContainer extends AbstractComponentContainer {
    public final Set<Class<?>> allowedDeferredInterfaces;
    public final Set<Class<?>> allowedDirectInterfaces;
    public final Set<Class<?>> allowedProviderInterfaces;
    public final Set<Class<?>> allowedPublishedEvents;
    public final Set<Class<?>> allowedSetDirectInterfaces;
    public final Set<Class<?>> allowedSetProviderInterfaces;
    public final ComponentContainer delegateContainer;

    public static class RestrictedPublisher implements Publisher {
        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
        }
    }

    public RestrictedComponentContainer(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency next : component.dependencies) {
            boolean z = false;
            if (!(next.injection == 0)) {
                if (next.injection == 2 ? true : z) {
                    hashSet3.add(next.anInterface);
                } else if (next.isSet()) {
                    hashSet5.add(next.anInterface);
                } else {
                    hashSet2.add(next.anInterface);
                }
            } else if (next.isSet()) {
                hashSet4.add(next.anInterface);
            } else {
                hashSet.add(next.anInterface);
            }
        }
        if (!component.publishedEvents.isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedDeferredInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet5);
        this.allowedPublishedEvents = component.publishedEvents;
        this.delegateContainer = componentContainer;
    }

    public <T> T get(Class<T> cls) {
        if (this.allowedDirectInterfaces.contains(cls)) {
            T t = this.delegateContainer.get(cls);
            if (!cls.equals(Publisher.class)) {
                return t;
            }
            return new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) t);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public <T> Deferred<T> getDeferred(Class<T> cls) {
        if (this.allowedDeferredInterfaces.contains(cls)) {
            return this.delegateContainer.getDeferred(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[]{cls}));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.allowedProviderInterfaces.contains(cls)) {
            return this.delegateContainer.getProvider(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{cls}));
    }

    public <T> Set<T> setOf(Class<T> cls) {
        if (this.allowedSetDirectInterfaces.contains(cls)) {
            return this.delegateContainer.setOf(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{cls}));
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.allowedSetProviderInterfaces.contains(cls)) {
            return this.delegateContainer.setOfProvider(cls);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{cls}));
    }
}
