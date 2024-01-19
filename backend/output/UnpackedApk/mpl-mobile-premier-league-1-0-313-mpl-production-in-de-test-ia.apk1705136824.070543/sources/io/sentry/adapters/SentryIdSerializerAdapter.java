package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.SentryId;
import java.lang.reflect.Type;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryIdSerializerAdapter implements JsonSerializer<SentryId> {
    public final SentryOptions options;

    public SentryIdSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(SentryId sentryId, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (sentryId != null) {
            try {
                jsonElement = new JsonPrimitive(sentryId.toString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing SentryId", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
