package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Device.DeviceOrientation;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class OrientationSerializerAdapter implements JsonSerializer<DeviceOrientation> {
    public final SentryOptions options;

    public OrientationSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(DeviceOrientation deviceOrientation, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (deviceOrientation != null) {
            try {
                jsonElement = new JsonPrimitive(deviceOrientation.name().toLowerCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing DeviceOrientation", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
