package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Deferred.DeferredHandler;
import com.google.firebase.inject.Provider;

public class OptionalProvider<T> implements Provider<T>, Deferred<T> {
    public static final Provider<Object> EMPTY_PROVIDER = $$Lambda$OptionalProvider$V5P2P1pkwQDT7xyfdsKcTNI9lRw.INSTANCE;
    public static final DeferredHandler<Object> NOOP_HANDLER = $$Lambda$OptionalProvider$p0l832a_x78_I5CnOiVPKec4M.INSTANCE;
    public volatile Provider<T> delegate;
    public DeferredHandler<T> handler;

    public OptionalProvider(DeferredHandler<T> deferredHandler, Provider<T> provider) {
        this.handler = deferredHandler;
        this.delegate = provider;
    }

    public static /* synthetic */ void lambda$static$0(Provider provider) {
    }

    public static /* synthetic */ Object lambda$static$1() {
        return null;
    }

    public static /* synthetic */ void lambda$whenAvailable$2(DeferredHandler deferredHandler, DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }

    public T get() {
        return this.delegate.get();
    }

    public void whenAvailable(DeferredHandler<T> deferredHandler) {
        Provider<T> provider;
        Provider<T> provider2 = this.delegate;
        if (provider2 != EMPTY_PROVIDER) {
            deferredHandler.handle(provider2);
            return;
        }
        Provider<T> provider3 = null;
        synchronized (this) {
            provider = this.delegate;
            if (provider != EMPTY_PROVIDER) {
                provider3 = provider;
            } else {
                this.handler = new DeferredHandler(deferredHandler) {
                    public final /* synthetic */ DeferredHandler f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void handle(Provider provider) {
                        OptionalProvider.lambda$whenAvailable$2(DeferredHandler.this, this.f$1, provider);
                    }
                };
            }
        }
        if (provider3 != null) {
            deferredHandler.handle(provider);
        }
    }
}
