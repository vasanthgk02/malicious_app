package io.sentry;

import com.razorpay.AnalyticsConstants;
import com.squareup.picasso.NetworkRequestHandler;
import io.sentry.util.CollectionUtils;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Breadcrumb implements IUnknownPropertiesConsumer {
    public String category;
    public Map<String, Object> data;
    public SentryLevel level;
    public String message;
    public final Date timestamp;
    public String type;
    public Map<String, Object> unknown;

    public Breadcrumb(Date date) {
        this.data = new ConcurrentHashMap();
        this.timestamp = date;
    }

    public static Breadcrumb http(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(NetworkRequestHandler.SCHEME_HTTP);
        breadcrumb.setCategory(NetworkRequestHandler.SCHEME_HTTP);
        breadcrumb.setData("url", str);
        breadcrumb.setData(AnalyticsConstants.METHOD, str2.toUpperCase(Locale.ROOT));
        return breadcrumb;
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public String getCategory() {
        return this.category;
    }

    @Internal
    public Map<String, Object> getData() {
        return this.data;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public String getType() {
        return this.type;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void removeData(String str) {
        this.data.remove(str);
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setData(String str, Object obj) {
        this.data.put(str, obj);
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Object getData(String str) {
        return this.data.get(str);
    }

    public Breadcrumb(Breadcrumb breadcrumb) {
        this.data = new ConcurrentHashMap();
        this.timestamp = breadcrumb.timestamp;
        this.message = breadcrumb.message;
        this.type = breadcrumb.type;
        this.category = breadcrumb.category;
        Map<String, Object> newConcurrentHashMap = CollectionUtils.newConcurrentHashMap(breadcrumb.data);
        if (newConcurrentHashMap != null) {
            this.data = newConcurrentHashMap;
        }
        this.unknown = CollectionUtils.newConcurrentHashMap(breadcrumb.unknown);
        this.level = breadcrumb.level;
    }

    public static Breadcrumb http(String str, String str2, Integer num) {
        Breadcrumb http = http(str, str2);
        if (num != null) {
            http.setData("status_code", num);
        }
        return http;
    }

    public Breadcrumb() {
        this(DateUtils.getCurrentDateTime());
    }

    public Breadcrumb(String str) {
        this();
        this.message = str;
    }
}
