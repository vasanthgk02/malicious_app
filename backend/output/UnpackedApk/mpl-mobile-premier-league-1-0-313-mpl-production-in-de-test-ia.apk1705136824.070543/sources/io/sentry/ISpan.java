package io.sentry;

import java.util.Date;
import org.jetbrains.annotations.ApiStatus.Internal;

public interface ISpan {
    void finish();

    void finish(SpanStatus spanStatus);

    String getDescription();

    String getOperation();

    SpanContext getSpanContext();

    SpanStatus getStatus();

    String getTag(String str);

    Throwable getThrowable();

    boolean isFinished();

    void setDescription(String str);

    void setOperation(String str);

    void setStatus(SpanStatus spanStatus);

    void setTag(String str, String str2);

    void setThrowable(Throwable th);

    ISpan startChild(String str);

    ISpan startChild(String str, String str2);

    @Internal
    ISpan startChild(String str, String str2, Date date);

    SentryTraceHeader toSentryTrace();
}
