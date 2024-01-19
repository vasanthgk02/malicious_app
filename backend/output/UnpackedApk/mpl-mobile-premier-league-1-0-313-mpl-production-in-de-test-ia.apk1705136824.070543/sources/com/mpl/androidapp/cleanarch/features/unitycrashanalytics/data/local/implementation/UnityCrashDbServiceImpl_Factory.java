package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation;

import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.database.UnityCrashDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UnityCrashDbServiceImpl_Factory implements Factory<UnityCrashDbServiceImpl> {
    public final Provider<UnityCrashDatabase> dbProvider;

    public UnityCrashDbServiceImpl_Factory(Provider<UnityCrashDatabase> provider) {
        this.dbProvider = provider;
    }

    public static UnityCrashDbServiceImpl_Factory create(Provider<UnityCrashDatabase> provider) {
        return new UnityCrashDbServiceImpl_Factory(provider);
    }

    public static UnityCrashDbServiceImpl newInstance(UnityCrashDatabase unityCrashDatabase) {
        return new UnityCrashDbServiceImpl(unityCrashDatabase);
    }

    public UnityCrashDbServiceImpl get() {
        return newInstance((UnityCrashDatabase) this.dbProvider.get());
    }
}
