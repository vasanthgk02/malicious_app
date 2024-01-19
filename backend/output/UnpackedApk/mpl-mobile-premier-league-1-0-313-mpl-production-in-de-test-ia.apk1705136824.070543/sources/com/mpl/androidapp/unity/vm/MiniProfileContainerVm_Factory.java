package com.mpl.androidapp.unity.vm;

import android.app.Application;
import com.mpl.androidapp.unity.usecases.UnityViewProfileUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MiniProfileContainerVm_Factory implements Factory<MiniProfileContainerVm> {
    public final Provider<Application> applicationProvider;
    public final Provider<UnityViewProfileUseCase> unityViewProfileUseCaseProvider;

    public MiniProfileContainerVm_Factory(Provider<Application> provider, Provider<UnityViewProfileUseCase> provider2) {
        this.applicationProvider = provider;
        this.unityViewProfileUseCaseProvider = provider2;
    }

    public static MiniProfileContainerVm_Factory create(Provider<Application> provider, Provider<UnityViewProfileUseCase> provider2) {
        return new MiniProfileContainerVm_Factory(provider, provider2);
    }

    public static MiniProfileContainerVm newInstance(Application application, UnityViewProfileUseCase unityViewProfileUseCase) {
        return new MiniProfileContainerVm(application, unityViewProfileUseCase);
    }

    public MiniProfileContainerVm get() {
        return newInstance((Application) this.applicationProvider.get(), (UnityViewProfileUseCase) this.unityViewProfileUseCaseProvider.get());
    }
}
