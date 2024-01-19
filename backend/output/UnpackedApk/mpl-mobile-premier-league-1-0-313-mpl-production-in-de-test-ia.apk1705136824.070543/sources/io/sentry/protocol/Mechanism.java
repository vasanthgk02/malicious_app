package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Mechanism implements IUnknownPropertiesConsumer {
    public Map<String, Object> data;
    public String description;
    public Boolean handled;
    public String helpLink;
    public Map<String, Object> meta;
    public Boolean synthetic;
    public final transient Thread thread;
    public String type;
    public Map<String, Object> unknown;

    public Mechanism() {
        this(null);
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public String getHelpLink() {
        return this.helpLink;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public Boolean getSynthetic() {
        return this.synthetic;
    }

    public Thread getThread() {
        return this.thread;
    }

    public String getType() {
        return this.type;
    }

    public Boolean isHandled() {
        return this.handled;
    }

    public void setData(Map<String, Object> map) {
        this.data = CollectionUtils.newHashMap(map);
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHandled(Boolean bool) {
        this.handled = bool;
    }

    public void setHelpLink(String str) {
        this.helpLink = str;
    }

    public void setMeta(Map<String, Object> map) {
        this.meta = CollectionUtils.newHashMap(map);
    }

    public void setSynthetic(Boolean bool) {
        this.synthetic = bool;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Mechanism(Thread thread2) {
        this.thread = thread2;
    }
}
