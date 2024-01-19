package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.cleanarch.core.analytics.AnalyticsConstants;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.implementation.UnityCrashDbServiceImpl;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.feature.UnityCrashLogFeature;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobSupport;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J*\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001dH\u0002J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/domain/feature/UnityCrashLogFeature;", "unityCrashDbServiceImpl", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "logger", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "config", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getConfig", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getLogger", "()Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "getUnityCrashDbServiceImpl", "()Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/implementation/UnityCrashDbServiceImpl;", "cleanUp", "", "clearTable", "crashInterceptedExceptionHandler", "data", "", "battleId", "crashMessage", "isEnabledInCt", "", "isEnabledInKafka", "isUnityCrashFeatureEnabled", "prepareEventData", "gameConfigInput", "isCrashTriggered", "unityGameClosedNormally", "unityGameInstantiated", "unityGameUpdated", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashModule.kt */
public final class UnityCrashModule implements CoroutineScope, UnityCrashLogFeature {
    public static final String CONFIG_TYPE = "platform";
    public static final Companion Companion = new Companion(null);
    public static final String KEY_CRASH_TRIGGERED = "IsCrashTriggered";
    public static final String KEY_DATA = "data";
    public static final String TAG = "UnityCrashModule";
    public final ConfigZkFeatures config;
    public final CoroutineDispatcher ioDispatcher;
    public final LoggerFeature logger;
    public final UnityCrashDbServiceImpl unityCrashDbServiceImpl;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule$Companion;", "", "()V", "CONFIG_TYPE", "", "KEY_CRASH_TRIGGERED", "KEY_DATA", "TAG", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityCrashModule.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnityCrashModule(UnityCrashDbServiceImpl unityCrashDbServiceImpl2, LoggerFeature loggerFeature, ConfigZkFeatures configZkFeatures, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(unityCrashDbServiceImpl2, "unityCrashDbServiceImpl");
        Intrinsics.checkNotNullParameter(loggerFeature, "logger");
        Intrinsics.checkNotNullParameter(configZkFeatures, "config");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.unityCrashDbServiceImpl = unityCrashDbServiceImpl2;
        this.logger = loggerFeature;
        this.config = configZkFeatures;
        this.ioDispatcher = coroutineDispatcher;
    }

    private final void cleanUp() {
        TypeUtilsKt.cancel$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    private final void prepareEventData(String str, boolean z, String str2, String str3) {
        try {
            CoroutineScope CoroutineScope = TypeUtilsKt.CoroutineScope(this.ioDispatcher);
            UnityCrashModule$prepareEventData$1 unityCrashModule$prepareEventData$1 = new UnityCrashModule$prepareEventData$1(str2, str3, this, z, str, null);
            TypeUtilsKt.launch$default(CoroutineScope, null, null, unityCrashModule$prepareEventData$1, 3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void prepareEventData$default(UnityCrashModule unityCrashModule, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "Unity Crash";
        }
        unityCrashModule.prepareEventData(str, z, str2, str3);
    }

    public void clearTable() {
        try {
            TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(this.ioDispatcher), null, null, new UnityCrashModule$clearTable$1(this, null), 3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void crashInterceptedExceptionHandler(String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, "data", str2, WebViewGameVm.KEY_BATTLE_ID, str3, "crashMessage");
        prepareEventData(str, true, str2, str3);
    }

    public final ConfigZkFeatures getConfig() {
        return this.config;
    }

    public CoroutineContext getCoroutineContext() {
        return DefaultImpls.plus((JobSupport) TypeUtilsKt.SupervisorJob$default(null, 1), this.ioDispatcher);
    }

    public final CoroutineDispatcher getIoDispatcher() {
        return this.ioDispatcher;
    }

    public final LoggerFeature getLogger() {
        return this.logger;
    }

    public final UnityCrashDbServiceImpl getUnityCrashDbServiceImpl() {
        return this.unityCrashDbServiceImpl;
    }

    public boolean isEnabledInCt() {
        return this.config.getGetBooleanZkUseCase().invoke(AnalyticsConstants.KEY_IS_UNITY_CRASH_CT_ENABLED, "platform");
    }

    public boolean isEnabledInKafka() {
        return this.config.getGetBooleanZkUseCase().invoke(AnalyticsConstants.KEY_IS_UNITY_CRASH_KAFKA_ENABLED, "platform");
    }

    public boolean isUnityCrashFeatureEnabled() {
        return this.config.getGetBooleanZkUseCase().invoke(AnalyticsConstants.KEY_IS_UNITY_CRASH_CT_ENABLED, "platform") || this.config.getGetBooleanZkUseCase().invoke(AnalyticsConstants.KEY_IS_UNITY_CRASH_KAFKA_ENABLED, "platform");
    }

    public void unityGameClosedNormally(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        this.logger.d(TAG, "unityGameClosedNormally");
        prepareEventData$default(this, str, false, str2, null, 8, null);
    }

    public void unityGameInstantiated(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        this.logger.d(TAG, "unityGameInstantiated");
        prepareEventData$default(this, str, true, com.razorpay.AnalyticsConstants.NOT_AVAILABLE, null, 8, null);
    }

    public void unityGameUpdated(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        this.logger.d(TAG, "unityGameUpdated");
        prepareEventData$default(this, str, true, str2, null, 8, null);
    }
}
