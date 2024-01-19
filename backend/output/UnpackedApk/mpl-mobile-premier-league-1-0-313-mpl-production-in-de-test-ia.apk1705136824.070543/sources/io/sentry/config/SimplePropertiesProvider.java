package io.sentry.config;

import java.util.Properties;

public final class SimplePropertiesProvider extends AbstractPropertiesProvider {
    public SimplePropertiesProvider(Properties properties) {
        super(properties);
    }
}
