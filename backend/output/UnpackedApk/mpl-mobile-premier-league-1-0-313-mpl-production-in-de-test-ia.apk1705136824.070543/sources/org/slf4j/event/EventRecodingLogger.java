package org.slf4j.event;

import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.SubstituteLogger;

public class EventRecodingLogger implements Logger {
    public Queue<SubstituteLoggingEvent> eventQueue;
    public SubstituteLogger logger;
    public String name;

    public EventRecodingLogger(SubstituteLogger substituteLogger, Queue<SubstituteLoggingEvent> queue) {
        this.logger = substituteLogger;
        this.name = substituteLogger.name;
        this.eventQueue = queue;
    }

    public void debug(String str) {
        recordEvent_0Args(Level.DEBUG, null, str, null);
    }

    public void error(String str) {
        recordEvent_0Args(Level.ERROR, null, str, null);
    }

    public String getName() {
        return this.name;
    }

    public void info(String str) {
        recordEvent_0Args(Level.INFO, null, str, null);
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public final void recordEvent(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
        System.currentTimeMillis();
        substituteLoggingEvent.logger = this.logger;
        Thread.currentThread().getName();
        substituteLoggingEvent.argArray = objArr;
        this.eventQueue.add(substituteLoggingEvent);
    }

    public final void recordEvent_0Args(Level level, Marker marker, String str, Throwable th) {
        recordEvent(level, null, str, null, th);
    }

    public void warn(String str) {
        recordEvent_0Args(Level.WARN, null, str, null);
    }

    public void debug(String str, Throwable th) {
        recordEvent_0Args(Level.DEBUG, null, str, th);
    }

    public void error(String str, Throwable th) {
        recordEvent_0Args(Level.ERROR, null, str, th);
    }

    public void info(String str, Object obj) {
        recordEvent(Level.INFO, null, str, new Object[]{obj}, null);
    }

    public void warn(String str, Throwable th) {
        recordEvent_0Args(Level.WARN, null, str, th);
    }

    public void info(String str, Throwable th) {
        recordEvent_0Args(Level.INFO, null, str, th);
    }
}
