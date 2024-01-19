package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class DebugMeta implements IUnknownPropertiesConsumer {
    public List<DebugImage> images;
    public SdkInfo sdkInfo;
    public Map<String, Object> unknown;

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public List<DebugImage> getImages() {
        return this.images;
    }

    public SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public void setImages(List<DebugImage> list) {
        this.images = list != null ? new ArrayList(list) : null;
    }

    public void setSdkInfo(SdkInfo sdkInfo2) {
        this.sdkInfo = sdkInfo2;
    }
}
