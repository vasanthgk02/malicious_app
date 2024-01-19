package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Device.DeviceOrientation;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class OrientationDeserializerAdapter implements JsonDeserializer<DeviceOrientation> {
    public final SentryOptions options;

    public OrientationDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public DeviceOrientation deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        DeviceOrientation deviceOrientation = null;
        if (jsonElement != null) {
            try {
                deviceOrientation = DeviceOrientation.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing DeviceOrientation", (Throwable) e2);
                return null;
            }
        }
        return deviceOrientation;
    }
}
