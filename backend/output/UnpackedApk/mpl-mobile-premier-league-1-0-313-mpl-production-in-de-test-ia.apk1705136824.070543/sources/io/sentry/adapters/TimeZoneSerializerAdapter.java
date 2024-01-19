package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class TimeZoneSerializerAdapter implements JsonSerializer<TimeZone> {
    public final SentryOptions options;

    public TimeZoneSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(TimeZone timeZone, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (timeZone != null) {
            try {
                jsonElement = new JsonPrimitive(timeZone.getID());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing TimeZone", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
