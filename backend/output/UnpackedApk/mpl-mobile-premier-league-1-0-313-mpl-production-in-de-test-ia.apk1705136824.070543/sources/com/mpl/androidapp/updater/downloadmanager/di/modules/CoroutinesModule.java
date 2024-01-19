package com.mpl.androidapp.updater.downloadmanager.di.modules;

import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.DefaultDispatcher;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.MainDispatcher;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/di/modules/CoroutinesModule;", "", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "providesIoDispatcher", "providesMainDispatcher", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineModule.kt */
public final class CoroutinesModule {
    public static final CoroutinesModule INSTANCE = new CoroutinesModule();

    @DefaultDispatcher
    public static final CoroutineDispatcher providesDefaultDispatcher() {
        return Dispatchers.Default;
    }

    @IoDispatcher
    public static final CoroutineDispatcher providesIoDispatcher() {
        return Dispatchers.IO;
    }

    @MainDispatcher
    public static final CoroutineDispatcher providesMainDispatcher() {
        return Dispatchers.getMain();
    }
}
