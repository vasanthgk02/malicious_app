package com.mpl.androidapp.miniprofile.vm;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SharedGameStreamViewModel_Factory implements Factory<SharedGameStreamViewModel> {
    public final Provider<Context> contextProvider;

    public SharedGameStreamViewModel_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static SharedGameStreamViewModel_Factory create(Provider<Context> provider) {
        return new SharedGameStreamViewModel_Factory(provider);
    }

    public static SharedGameStreamViewModel newInstance(Context context) {
        return new SharedGameStreamViewModel(context);
    }

    public SharedGameStreamViewModel get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
