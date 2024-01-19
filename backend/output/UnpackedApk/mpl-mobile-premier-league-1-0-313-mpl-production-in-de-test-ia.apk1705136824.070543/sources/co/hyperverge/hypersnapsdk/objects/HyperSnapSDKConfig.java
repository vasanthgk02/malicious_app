package co.hyperverge.hypersnapsdk.objects;

import com.android.tools.r8.GeneratedOutlineSupport;

public class HyperSnapSDKConfig {
    public String accessToken;
    public String appId;
    public String appKey;
    public int connectTimeOut = 120;
    public HyperKYCConfigs hyperKYCConfigs;
    public HyperSnapParams$Product hyperSnapProduct;
    public HyperSnapParams$Region hyperSnapRegion;
    public String mixpanelToken;
    public int readTimeOut = 120;
    public boolean shouldActivateDeviceBlocklist = true;
    public boolean shouldEnableSSLPinning;
    public boolean shouldLogOnlyErrors;
    public boolean shouldReturnRawResponse;
    public boolean shouldUseLocation;
    public boolean shouldUseRemoteConfig = true;
    public boolean shouldUseSensorBiometrics = true;
    public boolean shouldUseSignature;
    public int writeTimeOut = 120;

    public HyperSnapSDKConfig() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HyperSnapSDKConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HyperSnapSDKConfig)) {
            return false;
        }
        HyperSnapSDKConfig hyperSnapSDKConfig = (HyperSnapSDKConfig) obj;
        if (!hyperSnapSDKConfig.canEqual(this) || isShouldEnableSSLPinning() != hyperSnapSDKConfig.isShouldEnableSSLPinning() || isShouldUseSignature() != hyperSnapSDKConfig.isShouldUseSignature() || isShouldLogOnlyErrors() != hyperSnapSDKConfig.isShouldLogOnlyErrors() || isShouldReturnRawResponse() != hyperSnapSDKConfig.isShouldReturnRawResponse() || isShouldActivateDeviceBlocklist() != hyperSnapSDKConfig.isShouldActivateDeviceBlocklist() || getConnectTimeOut() != hyperSnapSDKConfig.getConnectTimeOut() || getReadTimeOut() != hyperSnapSDKConfig.getReadTimeOut() || getWriteTimeOut() != hyperSnapSDKConfig.getWriteTimeOut() || isShouldUseSensorBiometrics() != hyperSnapSDKConfig.isShouldUseSensorBiometrics() || isShouldUseRemoteConfig() != hyperSnapSDKConfig.isShouldUseRemoteConfig() || isShouldUseLocation() != hyperSnapSDKConfig.isShouldUseLocation()) {
            return false;
        }
        String appId2 = getAppId();
        String appId3 = hyperSnapSDKConfig.getAppId();
        if (appId2 != null ? !appId2.equals(appId3) : appId3 != null) {
            return false;
        }
        String appKey2 = getAppKey();
        String appKey3 = hyperSnapSDKConfig.getAppKey();
        if (appKey2 != null ? !appKey2.equals(appKey3) : appKey3 != null) {
            return false;
        }
        String accessToken2 = getAccessToken();
        String accessToken3 = hyperSnapSDKConfig.getAccessToken();
        if (accessToken2 != null ? !accessToken2.equals(accessToken3) : accessToken3 != null) {
            return false;
        }
        HyperSnapParams$Region hyperSnapRegion2 = getHyperSnapRegion();
        HyperSnapParams$Region hyperSnapRegion3 = hyperSnapSDKConfig.getHyperSnapRegion();
        if (hyperSnapRegion2 != null ? !hyperSnapRegion2.equals(hyperSnapRegion3) : hyperSnapRegion3 != null) {
            return false;
        }
        HyperSnapParams$Product hyperSnapProduct2 = getHyperSnapProduct();
        HyperSnapParams$Product hyperSnapProduct3 = hyperSnapSDKConfig.getHyperSnapProduct();
        if (hyperSnapProduct2 != null ? !hyperSnapProduct2.equals(hyperSnapProduct3) : hyperSnapProduct3 != null) {
            return false;
        }
        String mixpanelToken2 = getMixpanelToken();
        String mixpanelToken3 = hyperSnapSDKConfig.getMixpanelToken();
        if (mixpanelToken2 != null ? !mixpanelToken2.equals(mixpanelToken3) : mixpanelToken3 != null) {
            return false;
        }
        HyperKYCConfigs hyperKYCConfigs2 = getHyperKYCConfigs();
        HyperKYCConfigs hyperKYCConfigs3 = hyperSnapSDKConfig.getHyperKYCConfigs();
        return hyperKYCConfigs2 != null ? hyperKYCConfigs2.equals(hyperKYCConfigs3) : hyperKYCConfigs3 == null;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public int getConnectTimeOut() {
        return this.connectTimeOut;
    }

    public HyperKYCConfigs getHyperKYCConfigs() {
        return this.hyperKYCConfigs;
    }

    public HyperSnapParams$Product getHyperSnapProduct() {
        return this.hyperSnapProduct;
    }

    public HyperSnapParams$Region getHyperSnapRegion() {
        return this.hyperSnapRegion;
    }

    public String getMixpanelToken() {
        return this.mixpanelToken;
    }

    public int getReadTimeOut() {
        return this.readTimeOut;
    }

    public int getWriteTimeOut() {
        return this.writeTimeOut;
    }

    public int hashCode() {
        int i = 79;
        int writeTimeOut2 = (((((getWriteTimeOut() + ((getReadTimeOut() + ((getConnectTimeOut() + (((((((((((isShouldEnableSSLPinning() ? 79 : 97) + 59) * 59) + (isShouldUseSignature() ? 79 : 97)) * 59) + (isShouldLogOnlyErrors() ? 79 : 97)) * 59) + (isShouldReturnRawResponse() ? 79 : 97)) * 59) + (isShouldActivateDeviceBlocklist() ? 79 : 97)) * 59)) * 59)) * 59)) * 59) + (isShouldUseSensorBiometrics() ? 79 : 97)) * 59) + (isShouldUseRemoteConfig() ? 79 : 97)) * 59;
        if (!isShouldUseLocation()) {
            i = 97;
        }
        String appId2 = getAppId();
        int i2 = (writeTimeOut2 + i) * 59;
        int i3 = 43;
        int hashCode = i2 + (appId2 == null ? 43 : appId2.hashCode());
        String appKey2 = getAppKey();
        int hashCode2 = (hashCode * 59) + (appKey2 == null ? 43 : appKey2.hashCode());
        String accessToken2 = getAccessToken();
        int hashCode3 = (hashCode2 * 59) + (accessToken2 == null ? 43 : accessToken2.hashCode());
        HyperSnapParams$Region hyperSnapRegion2 = getHyperSnapRegion();
        int hashCode4 = (hashCode3 * 59) + (hyperSnapRegion2 == null ? 43 : hyperSnapRegion2.hashCode());
        HyperSnapParams$Product hyperSnapProduct2 = getHyperSnapProduct();
        int hashCode5 = (hashCode4 * 59) + (hyperSnapProduct2 == null ? 43 : hyperSnapProduct2.hashCode());
        String mixpanelToken2 = getMixpanelToken();
        int hashCode6 = (hashCode5 * 59) + (mixpanelToken2 == null ? 43 : mixpanelToken2.hashCode());
        HyperKYCConfigs hyperKYCConfigs2 = getHyperKYCConfigs();
        int i4 = hashCode6 * 59;
        if (hyperKYCConfigs2 != null) {
            i3 = hyperKYCConfigs2.hashCode();
        }
        return i4 + i3;
    }

    public boolean isShouldActivateDeviceBlocklist() {
        return this.shouldActivateDeviceBlocklist;
    }

    public boolean isShouldEnableSSLPinning() {
        return this.shouldEnableSSLPinning;
    }

    public boolean isShouldLogOnlyErrors() {
        return this.shouldLogOnlyErrors;
    }

    public boolean isShouldReturnRawResponse() {
        return this.shouldReturnRawResponse;
    }

    public boolean isShouldUseLocation() {
        return this.shouldUseLocation;
    }

    public boolean isShouldUseRemoteConfig() {
        return this.shouldUseRemoteConfig;
    }

    public boolean isShouldUseSensorBiometrics() {
        return this.shouldUseSensorBiometrics;
    }

    public boolean isShouldUseSignature() {
        return this.shouldUseSignature;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setConnectTimeOut(int i) {
        this.connectTimeOut = i;
    }

    public void setHttpTimeoutValues(int i, int i2, int i3) {
        this.connectTimeOut = i;
        this.readTimeOut = i2;
        this.writeTimeOut = i3;
    }

    public void setHyperKYCConfigs(HyperKYCConfigs hyperKYCConfigs2) {
        this.hyperKYCConfigs = hyperKYCConfigs2;
    }

    public void setHyperSnapProduct(HyperSnapParams$Product hyperSnapParams$Product) {
        this.hyperSnapProduct = hyperSnapParams$Product;
    }

    public void setHyperSnapRegion(HyperSnapParams$Region hyperSnapParams$Region) {
        this.hyperSnapRegion = hyperSnapParams$Region;
    }

    public void setMixpanelToken(String str) {
        this.mixpanelToken = str;
    }

    public void setReadTimeOut(int i) {
        this.readTimeOut = i;
    }

    public void setShouldActivateDeviceBlocklist(boolean z) {
        this.shouldActivateDeviceBlocklist = z;
    }

    public void setShouldEnableSSLPinning(boolean z) {
        this.shouldEnableSSLPinning = z;
    }

    public void setShouldLogOnlyErrors(boolean z) {
        this.shouldLogOnlyErrors = z;
    }

    public void setShouldReturnRawResponse(boolean z) {
        this.shouldReturnRawResponse = z;
    }

    public void setShouldUseLocation(boolean z) {
        this.shouldUseLocation = z;
    }

    public void setShouldUseRemoteConfig(boolean z) {
        this.shouldUseRemoteConfig = z;
    }

    public void setShouldUseSensorBiometrics(boolean z) {
        this.shouldUseSensorBiometrics = z;
    }

    public void setShouldUseSignature(boolean z) {
        this.shouldUseSignature = z;
    }

    public void setWriteTimeOut(int i) {
        this.writeTimeOut = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HyperSnapSDKConfig(appId=");
        outline73.append(getAppId());
        outline73.append(", appKey=");
        outline73.append(getAppKey());
        outline73.append(", accessToken=");
        outline73.append(getAccessToken());
        outline73.append(", hyperSnapRegion=");
        outline73.append(getHyperSnapRegion());
        outline73.append(", hyperSnapProduct=");
        outline73.append(getHyperSnapProduct());
        outline73.append(", shouldEnableSSLPinning=");
        outline73.append(isShouldEnableSSLPinning());
        outline73.append(", shouldUseSignature=");
        outline73.append(isShouldUseSignature());
        outline73.append(", shouldLogOnlyErrors=");
        outline73.append(isShouldLogOnlyErrors());
        outline73.append(", mixpanelToken=");
        outline73.append(getMixpanelToken());
        outline73.append(", shouldReturnRawResponse=");
        outline73.append(isShouldReturnRawResponse());
        outline73.append(", shouldActivateDeviceBlocklist=");
        outline73.append(isShouldActivateDeviceBlocklist());
        outline73.append(", connectTimeOut=");
        outline73.append(getConnectTimeOut());
        outline73.append(", readTimeOut=");
        outline73.append(getReadTimeOut());
        outline73.append(", writeTimeOut=");
        outline73.append(getWriteTimeOut());
        outline73.append(", hyperKYCConfigs=");
        outline73.append(getHyperKYCConfigs());
        outline73.append(", shouldUseSensorBiometrics=");
        outline73.append(isShouldUseSensorBiometrics());
        outline73.append(", shouldUseRemoteConfig=");
        outline73.append(isShouldUseRemoteConfig());
        outline73.append(", shouldUseLocation=");
        outline73.append(isShouldUseLocation());
        outline73.append(")");
        return outline73.toString();
    }

    public HyperSnapSDKConfig(String str, String str2, HyperSnapParams$Region hyperSnapParams$Region) {
        this.appId = str;
        this.appKey = str2;
        this.hyperSnapRegion = hyperSnapParams$Region;
        this.hyperSnapProduct = HyperSnapParams$Product.FACEID;
    }
}
