package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryLevelDeserializerAdapter implements JsonDeserializer<SentryLevel> {
    public final SentryOptions options;

    public SentryLevelDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public SentryLevel deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SentryLevel sentryLevel = null;
        if (jsonElement != null) {
            try {
                sentryLevel = SentryLevel.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing SentryLevel", (Throwable) e2);
                return null;
            }
        }
        return sentryLevel;
    }
}
