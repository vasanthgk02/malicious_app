package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SentryThread implements IUnknownPropertiesConsumer {
    public Boolean crashed;
    public Boolean current;
    public Boolean daemon;
    public Long id;
    public String name;
    public Integer priority;
    public SentryStackTrace stacktrace;
    public String state;
    public Map<String, Object> unknown;

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public String getState() {
        return this.state;
    }

    public Boolean isCrashed() {
        return this.crashed;
    }

    public Boolean isCurrent() {
        return this.current;
    }

    public Boolean isDaemon() {
        return this.daemon;
    }

    public void setCrashed(Boolean bool) {
        this.crashed = bool;
    }

    public void setCurrent(Boolean bool) {
        this.current = bool;
    }

    public void setDaemon(Boolean bool) {
        this.daemon = bool;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public void setStacktrace(SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public void setState(String str) {
        this.state = str;
    }
}
