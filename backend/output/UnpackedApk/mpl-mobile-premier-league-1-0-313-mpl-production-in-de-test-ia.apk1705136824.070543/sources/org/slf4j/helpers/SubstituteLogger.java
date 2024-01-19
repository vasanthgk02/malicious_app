package org.slf4j.helpers;

import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecodingLogger;
import org.slf4j.event.LoggingEvent;
import org.slf4j.event.SubstituteLoggingEvent;

public class SubstituteLogger implements Logger {
    public volatile Logger _delegate;
    public final boolean createdPostInitialization;
    public Boolean delegateEventAware;
    public Queue<SubstituteLoggingEvent> eventQueue;
    public EventRecodingLogger eventRecodingLogger;
    public Method logMethodCache;
    public final String name;

    public SubstituteLogger(String str, Queue<SubstituteLoggingEvent> queue, boolean z) {
        this.name = str;
        this.eventQueue = queue;
        this.createdPostInitialization = z;
    }

    public void debug(String str) {
        delegate().debug(str);
    }

    public Logger delegate() {
        if (this._delegate != null) {
            return this._delegate;
        }
        if (this.createdPostInitialization) {
            return NOPLogger.NOP_LOGGER;
        }
        if (this.eventRecodingLogger == null) {
            this.eventRecodingLogger = new EventRecodingLogger(this, this.eventQueue);
        }
        return this.eventRecodingLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && SubstituteLogger.class == obj.getClass() && this.name.equals(((SubstituteLogger) obj).name);
    }

    public void error(String str) {
        delegate().error(str);
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public void info(String str) {
        delegate().info(str);
    }

    public boolean isDebugEnabled() {
        return delegate().isDebugEnabled();
    }

    public boolean isDelegateEventAware() {
        Boolean bool = this.delegateEventAware;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.logMethodCache = this._delegate.getClass().getMethod(AnalyticsConstants.LOG, new Class[]{LoggingEvent.class});
            this.delegateEventAware = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.delegateEventAware = Boolean.FALSE;
        }
        return this.delegateEventAware.booleanValue();
    }

    public boolean isErrorEnabled() {
        return delegate().isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return delegate().isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return delegate().isWarnEnabled();
    }

    public void warn(String str) {
        delegate().warn(str);
    }

    public void debug(String str, Throwable th) {
        delegate().debug(str, th);
    }

    public void error(String str, Throwable th) {
        delegate().error(str, th);
    }

    public void info(String str, Object obj) {
        delegate().info(str, obj);
    }

    public void warn(String str, Throwable th) {
        delegate().warn(str, th);
    }

    public void info(String str, Throwable th) {
        delegate().info(str, th);
    }
}
