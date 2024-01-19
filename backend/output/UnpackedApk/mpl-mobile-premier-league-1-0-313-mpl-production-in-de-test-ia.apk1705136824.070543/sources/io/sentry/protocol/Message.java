package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Message implements IUnknownPropertiesConsumer {
    public String formatted;
    public String message;
    public List<String> params;
    public Map<String, Object> unknown;

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getFormatted() {
        return this.formatted;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getParams() {
        return this.params;
    }

    public void setFormatted(String str) {
        this.formatted = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setParams(List<String> list) {
        this.params = CollectionUtils.newArrayList(list);
    }
}
