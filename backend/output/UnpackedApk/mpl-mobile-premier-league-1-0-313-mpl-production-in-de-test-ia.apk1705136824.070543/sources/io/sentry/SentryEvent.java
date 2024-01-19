package io.sentry;

import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryThread;
import io.sentry.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SentryEvent extends SentryBaseEvent implements IUnknownPropertiesConsumer {
    public DebugMeta debugMeta;
    public SentryValues<SentryException> exception;
    public List<String> fingerprint;
    public SentryLevel level;
    public String logger;
    public Message message;
    public Map<String, String> modules;
    public SentryValues<SentryThread> threads;
    public final Date timestamp;
    public String transaction;
    public Map<String, Object> unknown;

    public SentryEvent(SentryId sentryId, Date date) {
        super(sentryId);
        this.timestamp = date;
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public List<SentryException> getExceptions() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues == null) {
            return null;
        }
        return sentryValues.getValues();
    }

    public List<String> getFingerprints() {
        return this.fingerprint;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public String getLogger() {
        return this.logger;
    }

    public Message getMessage() {
        return this.message;
    }

    public String getModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public Map<String, String> getModules() {
        return this.modules;
    }

    public List<SentryThread> getThreads() {
        SentryValues<SentryThread> sentryValues = this.threads;
        if (sentryValues != null) {
            return sentryValues.getValues();
        }
        return null;
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public String getTransaction() {
        return this.transaction;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public boolean isCrashed() {
        SentryValues<SentryException> sentryValues = this.exception;
        if (sentryValues != null) {
            for (SentryException sentryException : sentryValues.getValues()) {
                if (sentryException.getMechanism() != null && sentryException.getMechanism().isHandled() != null && !sentryException.getMechanism().isHandled().booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isErrored() {
        SentryValues<SentryException> sentryValues = this.exception;
        return sentryValues != null && !sentryValues.getValues().isEmpty();
    }

    public void removeModule(String str) {
        Map<String, String> map = this.modules;
        if (map != null) {
            map.remove(str);
        }
    }

    public void setDebugMeta(DebugMeta debugMeta2) {
        this.debugMeta = debugMeta2;
    }

    public void setExceptions(List<SentryException> list) {
        this.exception = new SentryValues<>(list);
    }

    public void setFingerprints(List<String> list) {
        this.fingerprint = list != null ? new ArrayList(list) : null;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public void setLogger(String str) {
        this.logger = str;
    }

    public void setMessage(Message message2) {
        this.message = message2;
    }

    public void setModule(String str, String str2) {
        if (this.modules == null) {
            this.modules = new HashMap();
        }
        this.modules.put(str, str2);
    }

    public void setModules(Map<String, String> map) {
        this.modules = CollectionUtils.newHashMap(map);
    }

    public void setThreads(List<SentryThread> list) {
        this.threads = new SentryValues<>(list);
    }

    public void setTransaction(String str) {
        this.transaction = str;
    }

    public SentryEvent(Throwable th) {
        this();
        this.throwable = th;
    }

    public SentryEvent() {
        this(new SentryId(), DateUtils.getCurrentDateTime());
    }

    public SentryEvent(Date date) {
        this(new SentryId(), date);
    }
}
