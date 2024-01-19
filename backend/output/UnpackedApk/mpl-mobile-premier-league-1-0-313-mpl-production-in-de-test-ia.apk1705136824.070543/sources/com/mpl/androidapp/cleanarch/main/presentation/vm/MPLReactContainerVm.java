package com.mpl.androidapp.cleanarch.main.presentation.vm;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest.Builder;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.mpl.androidapp.cleanarch.core.base.BaseViewModel;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.services.UnityCrashSyncService;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.SendUnityCrashFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.states.ReactContainerState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/cleanarch/main/presentation/vm/MPLReactContainerVm;", "Lcom/mpl/androidapp/cleanarch/core/base/BaseViewModel;", "app", "Landroid/content/Context;", "features", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;", "unityCrashModule", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;", "config", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "(Landroid/content/Context;Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/SendUnityCrashFeature;Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;)V", "_state", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/states/ReactContainerState;", "getApp", "()Landroid/content/Context;", "getConfig", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "state", "Landroidx/lifecycle/LiveData;", "getState", "()Landroidx/lifecycle/LiveData;", "clearUnityCrashTable", "", "crashLogged", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* compiled from: MPLReactContainerVm.kt */
public final class MPLReactContainerVm extends BaseViewModel {
    public final MutableLiveData<ReactContainerState> _state;
    public final Context app;
    public final ConfigZkFeatures config;
    public final SendUnityCrashFeature features;
    public final LiveData<ReactContainerState> state;
    public final UnityCrashModule unityCrashModule;

    public MPLReactContainerVm(Context context, SendUnityCrashFeature sendUnityCrashFeature, UnityCrashModule unityCrashModule2, ConfigZkFeatures configZkFeatures) {
        Intrinsics.checkNotNullParameter(context, "app");
        Intrinsics.checkNotNullParameter(sendUnityCrashFeature, SettingsJsonConstants.FEATURES_KEY);
        Intrinsics.checkNotNullParameter(unityCrashModule2, "unityCrashModule");
        Intrinsics.checkNotNullParameter(configZkFeatures, "config");
        this.app = context;
        this.features = sendUnityCrashFeature;
        this.unityCrashModule = unityCrashModule2;
        this.config = configZkFeatures;
        MutableLiveData<ReactContainerState> mutableLiveData = new MutableLiveData<>();
        this._state = mutableLiveData;
        this.state = mutableLiveData;
    }

    public final void clearUnityCrashTable() {
        this.unityCrashModule.clearTable();
    }

    public final void crashLogged() {
        if (this.unityCrashModule.isUnityCrashFeatureEnabled()) {
            Builder builder = new Builder(UnityCrashSyncService.class);
            builder.mTags.add(UnityCrashSyncService.CRASH_SERVICE_NAME);
            WorkRequest build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "OneTimeWorkRequestBuilde…ASH_SERVICE_NAME).build()");
            WorkManagerImpl.getInstance(this.app).beginUniqueWork(UnityCrashSyncService.CRASH_SERVICE_NAME, ExistingWorkPolicy.REPLACE, (OneTimeWorkRequest) build).enqueue();
        }
    }

    public final Context getApp() {
        return this.app;
    }

    public final ConfigZkFeatures getConfig() {
        return this.config;
    }

    public final LiveData<ReactContainerState> getState() {
        return this.state;
    }
}
