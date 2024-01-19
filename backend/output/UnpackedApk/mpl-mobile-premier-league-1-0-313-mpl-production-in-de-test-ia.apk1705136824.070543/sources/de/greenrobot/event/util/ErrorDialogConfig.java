package de.greenrobot.event.util;

import android.content.res.Resources;
import de.greenrobot.event.EventBus;

public class ErrorDialogConfig {
    public int defaultDialogIconId;
    public final int defaultErrorMsgId;
    public Class<?> defaultEventTypeOnDialogClosed;
    public final int defaultTitleId;
    public EventBus eventBus;
    public boolean logExceptions = true;
    public final ExceptionToResourceMapping mapping;
    public final Resources resources;
    public String tagForLoggingExceptions;

    public ErrorDialogConfig(Resources resources2, int i, int i2) {
        this.resources = resources2;
        this.defaultTitleId = i;
        this.defaultErrorMsgId = i2;
        this.mapping = new ExceptionToResourceMapping();
    }

    public ErrorDialogConfig addMapping(Class<? extends Throwable> cls, int i) {
        this.mapping.addMapping(cls, i);
        return this;
    }

    public void disableExceptionLogging() {
        this.logExceptions = false;
    }

    public EventBus getEventBus() {
        EventBus eventBus2 = this.eventBus;
        return eventBus2 != null ? eventBus2 : EventBus.getDefault();
    }

    public int getMessageIdForThrowable(Throwable th) {
        Integer mapThrowable = this.mapping.mapThrowable(th);
        if (mapThrowable != null) {
            return mapThrowable.intValue();
        }
        String str = EventBus.TAG;
        "No specific message ressource ID found for " + th;
        return this.defaultErrorMsgId;
    }

    public void setDefaultDialogIconId(int i) {
        this.defaultDialogIconId = i;
    }

    public void setDefaultEventTypeOnDialogClosed(Class<?> cls) {
        this.defaultEventTypeOnDialogClosed = cls;
    }

    public void setEventBus(EventBus eventBus2) {
        this.eventBus = eventBus2;
    }

    public void setTagForLoggingExceptions(String str) {
        this.tagForLoggingExceptions = str;
    }
}
