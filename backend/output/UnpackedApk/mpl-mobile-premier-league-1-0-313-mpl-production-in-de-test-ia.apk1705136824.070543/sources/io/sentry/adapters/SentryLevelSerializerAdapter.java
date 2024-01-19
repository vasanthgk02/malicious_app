package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryLevelSerializerAdapter implements JsonSerializer<SentryLevel> {
    public final SentryOptions options;

    public SentryLevelSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(SentryLevel sentryLevel, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (sentryLevel != null) {
            try {
                jsonElement = new JsonPrimitive(sentryLevel.name().toLowerCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing SentryLevel", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
