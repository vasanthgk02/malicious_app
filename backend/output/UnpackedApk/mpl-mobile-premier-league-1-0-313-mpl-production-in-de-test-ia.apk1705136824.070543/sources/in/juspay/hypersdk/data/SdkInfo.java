package in.juspay.hypersdk.data;

import androidx.annotation.Keep;

@Keep
public final class SdkInfo {
    public boolean sdkDebuggable;
    public String sdkName;
    public String sdkVersion;
    public boolean usesLocalAssets;

    public SdkInfo(String str, String str2, boolean z, boolean z2) {
        this.sdkName = str;
        this.sdkVersion = str2;
        this.sdkDebuggable = z;
        this.usesLocalAssets = z2;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public boolean isSdkDebuggable() {
        return this.sdkDebuggable;
    }

    public boolean usesLocalAssets() {
        return this.usesLocalAssets;
    }
}
