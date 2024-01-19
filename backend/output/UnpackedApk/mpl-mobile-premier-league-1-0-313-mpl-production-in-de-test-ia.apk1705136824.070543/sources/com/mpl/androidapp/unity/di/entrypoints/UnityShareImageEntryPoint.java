package com.mpl.androidapp.unity.di.entrypoints;

import com.mpl.androidapp.share.repositories.MplShareRepository;
import com.mpl.androidapp.share.usecases.CheckSharePlatformIsPresent;
import com.mpl.androidapp.share.usecases.PrepareShareIntent;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/unity/di/entrypoints/UnityShareImageEntryPoint;", "", "CheckSharePlatformIsPresent", "Lcom/mpl/androidapp/share/usecases/CheckSharePlatformIsPresent;", "MplShareRepository", "Lcom/mpl/androidapp/share/repositories/MplShareRepository;", "PrepareShareIntent", "Lcom/mpl/androidapp/share/usecases/PrepareShareIntent;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityShareImageEntryPoint.kt */
public interface UnityShareImageEntryPoint {
    CheckSharePlatformIsPresent CheckSharePlatformIsPresent();

    MplShareRepository MplShareRepository();

    PrepareShareIntent PrepareShareIntent();

    @IoDispatcher
    CoroutineDispatcher ioDispatcher();
}
