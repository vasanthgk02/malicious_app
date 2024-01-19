package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SdkVersion implements IUnknownPropertiesConsumer {
    public List<String> integrations;
    public String name;
    public List<SentryPackage> packages;
    public Map<String, Object> unknown;
    public String version;

    public SdkVersion(String str, String str2) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
        this.version = (String) Objects.requireNonNull(str2, "version is required.");
    }

    public static SdkVersion updateSdkVersion(SdkVersion sdkVersion, String str, String str2) {
        Objects.requireNonNull(str, "name is required.");
        Objects.requireNonNull(str2, "version is required.");
        if (sdkVersion == null) {
            return new SdkVersion(str, str2);
        }
        sdkVersion.setName(str);
        sdkVersion.setVersion(str2);
        return sdkVersion;
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public void addIntegration(String str) {
        Objects.requireNonNull(str, "integration is required.");
        if (this.integrations == null) {
            this.integrations = new ArrayList();
        }
        this.integrations.add(str);
    }

    public void addPackage(String str, String str2) {
        Objects.requireNonNull(str, "name is required.");
        Objects.requireNonNull(str2, "version is required.");
        SentryPackage sentryPackage = new SentryPackage(str, str2);
        if (this.packages == null) {
            this.packages = new ArrayList();
        }
        this.packages.add(sentryPackage);
    }

    public List<String> getIntegrations() {
        return this.integrations;
    }

    public String getName() {
        return this.name;
    }

    public List<SentryPackage> getPackages() {
        return this.packages;
    }

    public String getVersion() {
        return this.version;
    }

    public void setName(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
    }

    public void setVersion(String str) {
        this.version = (String) Objects.requireNonNull(str, "version is required.");
    }

    @Deprecated
    public SdkVersion() {
        this("", "");
    }
}
