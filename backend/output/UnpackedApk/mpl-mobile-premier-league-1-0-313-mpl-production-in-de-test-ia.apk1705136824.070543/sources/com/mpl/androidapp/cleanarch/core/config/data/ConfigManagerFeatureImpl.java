package com.mpl.androidapp.cleanarch.core.config.data;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.config.ConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/data/ConfigManagerFeatureImpl;", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigManagerFeature;", "logger", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "(Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;)V", "getLogger", "()Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "getNormalConfig", "Lorg/json/JSONObject;", "getPlatformConfig", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigManagerFeatureImpl.kt */
public final class ConfigManagerFeatureImpl implements ConfigManagerFeature {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "ConfigManagerFeatureImpl";
    public final LoggerFeature logger;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/data/ConfigManagerFeatureImpl$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigManagerFeatureImpl.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConfigManagerFeatureImpl(LoggerFeature loggerFeature) {
        Intrinsics.checkNotNullParameter(loggerFeature, "logger");
        this.logger = loggerFeature;
    }

    public final LoggerFeature getLogger() {
        return this.logger;
    }

    public JSONObject getNormalConfig() {
        this.logger.i(TAG, "getNormalConfig");
        JSONObject normalConfig = ConfigManager.getNormalConfig();
        Intrinsics.checkNotNullExpressionValue(normalConfig, "getNormalConfig()");
        return normalConfig;
    }

    public JSONObject getPlatformConfig() {
        this.logger.i(TAG, "getPlatformConfig");
        JSONObject platformConfig = ConfigManager.getPlatformConfig();
        Intrinsics.checkNotNullExpressionValue(platformConfig, "getPlatformConfig()");
        return platformConfig;
    }
}
