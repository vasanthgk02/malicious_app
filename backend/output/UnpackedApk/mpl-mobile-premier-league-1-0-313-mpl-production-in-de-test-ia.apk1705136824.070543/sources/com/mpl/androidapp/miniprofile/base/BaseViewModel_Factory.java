package com.mpl.androidapp.miniprofile.base;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BaseViewModel_Factory implements Factory<BaseViewModel> {
    public final Provider<Application> applicationProvider;

    public BaseViewModel_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    public static BaseViewModel_Factory create(Provider<Application> provider) {
        return new BaseViewModel_Factory(provider);
    }

    public static BaseViewModel newInstance(Application application) {
        return new BaseViewModel(application);
    }

    public BaseViewModel get() {
        return newInstance((Application) this.applicationProvider.get());
    }
}
