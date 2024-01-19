package com.mpl.androidapp;

import androidx.multidex.MultiDexApplication;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;

public abstract class Hilt_MPLApplication extends MultiDexApplication implements GeneratedComponentManager {
    public final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() {
        public Object get() {
            return DaggerMPLApplication_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_MPLApplication.this)).build();
        }
    });

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public void onCreate() {
        ((MPLApplication_GeneratedInjector) generatedComponent()).injectMPLApplication((MPLApplication) this);
        super.onCreate();
    }

    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }
}
