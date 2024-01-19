package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;
import java.lang.reflect.Type;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SpanStatusDeserializerAdapter implements JsonDeserializer<SpanStatus> {
    public final SentryOptions options;

    public SpanStatusDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public SpanStatus deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SpanStatus spanStatus = null;
        if (jsonElement != null) {
            try {
                spanStatus = SpanStatus.valueOf(jsonElement.getAsString().toUpperCase(Locale.ROOT));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing SpanStatus", (Throwable) e2);
                return null;
            }
        }
        return spanStatus;
    }
}
