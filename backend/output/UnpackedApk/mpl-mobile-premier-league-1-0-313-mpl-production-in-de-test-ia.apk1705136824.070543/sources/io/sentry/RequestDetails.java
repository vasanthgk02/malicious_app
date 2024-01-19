package io.sentry;

import io.sentry.util.Objects;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public final class RequestDetails {
    public final Map<String, String> headers;
    public final URL url;

    public RequestDetails(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "url is required");
        Objects.requireNonNull(map, "headers is required");
        try {
            this.url = URI.create(str).toURL();
            this.headers = map;
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e2);
        }
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public URL getUrl() {
        return this.url;
    }
}
