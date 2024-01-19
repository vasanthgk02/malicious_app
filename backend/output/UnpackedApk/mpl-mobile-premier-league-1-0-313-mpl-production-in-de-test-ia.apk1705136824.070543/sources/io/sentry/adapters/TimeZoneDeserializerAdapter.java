package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class TimeZoneDeserializerAdapter implements JsonDeserializer<TimeZone> {
    public final SentryOptions options;

    public TimeZoneDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public TimeZone deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        TimeZone timeZone = null;
        if (jsonElement != null) {
            try {
                timeZone = TimeZone.getTimeZone(jsonElement.getAsString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing TimeZone", (Throwable) e2);
                return null;
            }
        }
        return timeZone;
    }
}
