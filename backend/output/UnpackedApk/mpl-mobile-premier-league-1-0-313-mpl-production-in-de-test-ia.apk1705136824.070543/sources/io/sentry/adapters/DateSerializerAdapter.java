package io.sentry.adapters;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import io.sentry.DateUtils;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class DateSerializerAdapter implements JsonSerializer<Date> {
    public final SentryOptions options;

    public DateSerializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = null;
        if (date != null) {
            try {
                jsonElement = new JsonPrimitive(DateUtils.getTimestamp(date));
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when serializing Date", (Throwable) e2);
                return null;
            }
        }
        return jsonElement;
    }
}
