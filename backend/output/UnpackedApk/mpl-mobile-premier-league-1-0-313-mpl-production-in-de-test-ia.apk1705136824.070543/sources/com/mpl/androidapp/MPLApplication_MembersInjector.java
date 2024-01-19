package com.mpl.androidapp;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MPLApplication_MembersInjector implements MembersInjector<MPLApplication> {
    public final Provider<HiltWorkerFactory> workerFactoryProvider;

    public MPLApplication_MembersInjector(Provider<HiltWorkerFactory> provider) {
        this.workerFactoryProvider = provider;
    }

    public static MembersInjector<MPLApplication> create(Provider<HiltWorkerFactory> provider) {
        return new MPLApplication_MembersInjector(provider);
    }

    public static void injectWorkerFactory(MPLApplication mPLApplication, HiltWorkerFactory hiltWorkerFactory) {
        mPLApplication.workerFactory = hiltWorkerFactory;
    }

    public void injectMembers(MPLApplication mPLApplication) {
        injectWorkerFactory(mPLApplication, (HiltWorkerFactory) this.workerFactoryProvider.get());
    }
}
