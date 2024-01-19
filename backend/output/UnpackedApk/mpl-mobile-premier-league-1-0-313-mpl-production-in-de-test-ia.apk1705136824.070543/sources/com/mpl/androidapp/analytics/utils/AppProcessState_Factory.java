package com.mpl.androidapp.analytics.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AppProcessState_Factory implements Factory<AppProcessState> {
    public final Provider<Context> contextProvider;

    public AppProcessState_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static AppProcessState_Factory create(Provider<Context> provider) {
        return new AppProcessState_Factory(provider);
    }

    public static AppProcessState newInstance(Context context) {
        return new AppProcessState(context);
    }

    public AppProcessState get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
