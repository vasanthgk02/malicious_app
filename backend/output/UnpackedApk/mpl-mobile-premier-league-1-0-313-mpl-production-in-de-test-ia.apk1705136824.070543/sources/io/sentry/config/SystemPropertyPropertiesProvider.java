package io.sentry.config;

public final class SystemPropertyPropertiesProvider extends AbstractPropertiesProvider {
    public static final String PREFIX = "sentry.";

    public SystemPropertyPropertiesProvider() {
        super(PREFIX, System.getProperties());
    }
}
