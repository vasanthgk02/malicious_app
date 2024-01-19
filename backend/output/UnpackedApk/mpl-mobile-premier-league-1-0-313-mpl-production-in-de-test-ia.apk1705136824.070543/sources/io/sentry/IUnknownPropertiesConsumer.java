package io.sentry;

import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public interface IUnknownPropertiesConsumer {
    void acceptUnknownProperties(Map<String, Object> map);
}
