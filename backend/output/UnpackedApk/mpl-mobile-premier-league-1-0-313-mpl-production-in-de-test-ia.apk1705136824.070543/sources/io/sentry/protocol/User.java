package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class User implements IUnknownPropertiesConsumer {
    public String email;
    public String id;
    public String ipAddress;
    public Map<String, String> other;
    public Map<String, Object> unknown;
    public String username;

    public User() {
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public String getEmail() {
        return this.email;
    }

    public String getId() {
        return this.id;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public Map<String, String> getOthers() {
        return this.other;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public String getUsername() {
        return this.username;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setOthers(Map<String, String> map) {
        this.other = CollectionUtils.newConcurrentHashMap(map);
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public User(User user) {
        this.email = user.email;
        this.username = user.username;
        this.id = user.id;
        this.ipAddress = user.ipAddress;
        this.other = CollectionUtils.newConcurrentHashMap(user.other);
        this.unknown = CollectionUtils.newConcurrentHashMap(user.unknown);
    }
}
