package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import javax.inject.Provider;

public final class EventStoreModule_PackageNameFactory implements Object<String> {
    public final Provider<Context> contextProvider;

    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public Object get() {
        String packageName = ((Context) this.contextProvider.get()).getPackageName();
        ImageOriginUtils.checkNotNull(packageName, "Cannot return null from a non-@Nullable @Provides method");
        return packageName;
    }
}
