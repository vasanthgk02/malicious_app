package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.SentryId;
import java.lang.reflect.Type;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryIdDeserializerAdapter implements JsonDeserializer<SentryId> {
    public final SentryOptions options;

    public SentryIdDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public SentryId deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SentryId sentryId = null;
        if (jsonElement != null) {
            try {
                sentryId = new SentryId(jsonElement.getAsString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing SentryId", (Throwable) e2);
                return null;
            }
        }
        return sentryId;
    }
}
