package com.google.firebase.components;

import com.google.android.material.resources.TextAppearanceConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Component<T> {
    public final Set<Dependency> dependencies;
    public final ComponentFactory<T> factory;
    public final int instantiation;
    public final Set<Class<? super T>> providedInterfaces;
    public final Set<Class<?>> publishedEvents;
    public final int type;

    public static class Builder<T> {
        public final Set<Dependency> dependencies = new HashSet();
        public ComponentFactory<T> factory;
        public int instantiation;
        public final Set<Class<? super T>> providedInterfaces = new HashSet();
        public Set<Class<?>> publishedEvents;
        public int type;

        public Builder(Class cls, Class[] clsArr, AnonymousClass1 r5) {
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            TextAppearanceConfig.checkNotNull(cls, "Null interface");
            this.providedInterfaces.add(cls);
            for (Class checkNotNull : clsArr) {
                TextAppearanceConfig.checkNotNull(checkNotNull, "Null interface");
            }
            Collections.addAll(this.providedInterfaces, clsArr);
        }

        public Builder<T> add(Dependency dependency) {
            TextAppearanceConfig.checkNotNull(dependency, "Null dependency");
            if (!this.providedInterfaces.contains(dependency.anInterface)) {
                this.dependencies.add(dependency);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public Component<T> build() {
            if (this.factory != null) {
                Component component = new Component(new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents, null);
                return component;
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            TextAppearanceConfig.checkNotNull(componentFactory, "Null factory");
            this.factory = componentFactory;
            return this;
        }

        public final Builder<T> setInstantiation(int i) {
            if (this.instantiation == 0) {
                this.instantiation = i;
                return this;
            }
            throw new IllegalStateException("Instantiation type has already been set.");
        }
    }

    public Component(Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3, AnonymousClass1 r7) {
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i;
        this.type = i2;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t, Class<T> cls, Class<? super T>... clsArr) {
        Builder builder = new Builder(cls, clsArr, null);
        builder.factory(new ComponentFactory(t) {
            public final /* synthetic */ Object f$0;

            {
                this.f$0 = r1;
            }

            public final Object create(ComponentContainer componentContainer) {
                return this.f$0;
            }
        });
        return builder.build();
    }

    public boolean isValue() {
        return this.type == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }
}
