package io.sentry.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.sentry.DateUtils;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.lang.reflect.Type;
import java.util.Date;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class DateDeserializerAdapter implements JsonDeserializer<Date> {
    public final SentryOptions options;

    public DateDeserializerAdapter(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Date date = null;
        if (jsonElement != null) {
            try {
                date = DateUtils.getDateTime(jsonElement.getAsString());
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Error when deserializing UTC timestamp format, it might be millis timestamp format.", (Throwable) e2);
                try {
                    return DateUtils.getDateTimeWithMillisPrecision(jsonElement.getAsString());
                } catch (Exception e3) {
                    this.options.getLogger().log(SentryLevel.ERROR, (String) "Error when deserializing millis timestamp format.", (Throwable) e3);
                    return null;
                }
            }
        }
        return date;
    }
}
