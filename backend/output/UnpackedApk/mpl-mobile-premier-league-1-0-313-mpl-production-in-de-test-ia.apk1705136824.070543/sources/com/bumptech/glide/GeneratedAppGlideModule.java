package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;

public abstract class GeneratedAppGlideModule extends AppGlideModule {
    public abstract Set<Class<?>> getExcludedModuleClasses();

    public RequestManagerFactory getRequestManagerFactory() {
        return null;
    }
}
