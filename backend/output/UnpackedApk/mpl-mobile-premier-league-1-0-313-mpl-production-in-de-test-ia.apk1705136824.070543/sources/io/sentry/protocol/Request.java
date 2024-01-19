package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Request implements IUnknownPropertiesConsumer {
    public String cookies;
    public Object data;
    public Map<String, String> env;
    public Map<String, String> headers;
    public String method;
    public Map<String, String> other;
    public String queryString;
    public Map<String, Object> unknown;
    public String url;

    public Request() {
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getCookies() {
        return this.cookies;
    }

    public Object getData() {
        return this.data;
    }

    public Map<String, String> getEnvs() {
        return this.env;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getOthers() {
        return this.other;
    }

    public String getQueryString() {
        return this.queryString;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCookies(String str) {
        this.cookies = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setEnvs(Map<String, String> map) {
        this.env = CollectionUtils.newConcurrentHashMap(map);
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = CollectionUtils.newConcurrentHashMap(map);
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setOthers(Map<String, String> map) {
        this.other = CollectionUtils.newConcurrentHashMap(map);
    }

    public void setQueryString(String str) {
        this.queryString = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public Request(Request request) {
        this.url = request.url;
        this.cookies = request.cookies;
        this.method = request.method;
        this.queryString = request.queryString;
        this.headers = CollectionUtils.newConcurrentHashMap(request.headers);
        this.env = CollectionUtils.newConcurrentHashMap(request.env);
        this.other = CollectionUtils.newConcurrentHashMap(request.other);
        this.unknown = CollectionUtils.newConcurrentHashMap(request.unknown);
        this.data = request.data;
    }
}
