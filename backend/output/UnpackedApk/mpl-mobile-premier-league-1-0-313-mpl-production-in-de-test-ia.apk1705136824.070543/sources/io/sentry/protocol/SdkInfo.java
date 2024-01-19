package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SdkInfo implements IUnknownPropertiesConsumer {
    public String sdkName;
    public Map<String, Object> unknown;
    public Integer versionMajor;
    public Integer versionMinor;
    public Integer versionPatchlevel;

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public Integer getVersionMajor() {
        return this.versionMajor;
    }

    public Integer getVersionMinor() {
        return this.versionMinor;
    }

    public Integer getVersionPatchlevel() {
        return this.versionPatchlevel;
    }

    public void setSdkName(String str) {
        this.sdkName = str;
    }

    public void setVersionMajor(Integer num) {
        this.versionMajor = num;
    }

    public void setVersionMinor(Integer num) {
        this.versionMinor = num;
    }

    public void setVersionPatchlevel(Integer num) {
        this.versionPatchlevel = num;
    }
}
