package com.mpl.androidapp.cleanarch.core.config.domain.usecases;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0019\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetJsonObjectZkUseCase;", "", "configManager", "Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigManagerFeature;", "logger", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "(Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigManagerFeature;Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;)V", "getConfigManager", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigManagerFeature;", "getJsonObjectData", "Lorg/json/JSONObject;", "config", "keyName", "", "invoke", "configType", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetJsonObjectZkUseCase.kt */
public final class GetJsonObjectZkUseCase {
    public final ConfigManagerFeature configManager;
    public final LoggerFeature logger;

    public GetJsonObjectZkUseCase(ConfigManagerFeature configManagerFeature, LoggerFeature loggerFeature) {
        Intrinsics.checkNotNullParameter(configManagerFeature, "configManager");
        Intrinsics.checkNotNullParameter(loggerFeature, "logger");
        this.configManager = configManagerFeature;
        this.logger = loggerFeature;
    }

    private final JSONObject getJsonObjectData(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                this.logger.i(ConfigZkFeatures.CONFIG_TAG, GeneratedOutlineSupport.outline52("KEY:-> ", str, " found in Zookeeper"));
                jSONObject2 = jSONObject.optJSONObject(str);
            } else {
                this.logger.i(ConfigZkFeatures.CONFIG_TAG, GeneratedOutlineSupport.outline52("KEY:-> ", str, " not found in Zookeeper"));
            }
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            if (config…e\n            }\n        }");
        } else {
            this.logger.i(ConfigZkFeatures.CONFIG_TAG, "Config object is null");
        }
        return jSONObject2;
    }

    public final ConfigManagerFeature getConfigManager() {
        return this.configManager;
    }

    public final JSONObject invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "keyName");
        Intrinsics.checkNotNullParameter(str2, "configType");
        if (CharsKt__CharKt.equals(str2, (String) ConfigZkFeatures.CONFIG_TYPE_NORMAL, true)) {
            return getJsonObjectData(this.configManager.getNormalConfig(), str);
        }
        if (CharsKt__CharKt.equals(str2, (String) "platform", true)) {
            return getJsonObjectData(this.configManager.getPlatformConfig(), str);
        }
        throw new InvalidArgumentException("Type of key is invalid");
    }
}