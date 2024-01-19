package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

public interface ITransaction extends ISpan {
    @Deprecated
    @ScheduledForRemoval
    Contexts getContexts();

    SentryId getEventId();

    Span getLatestActiveSpan();

    String getName();

    @Deprecated
    @ScheduledForRemoval
    Request getRequest();

    List<Span> getSpans();

    Boolean isSampled();

    void setName(String str);

    @Deprecated
    @ScheduledForRemoval
    void setRequest(Request request);
}
