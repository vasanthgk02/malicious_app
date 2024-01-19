package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public final class NoOpTransaction implements ITransaction {
    public static final NoOpTransaction instance = new NoOpTransaction();

    public static NoOpTransaction getInstance() {
        return instance;
    }

    public void finish() {
    }

    public void finish(SpanStatus spanStatus) {
    }

    @Deprecated
    @ScheduledForRemoval
    public Contexts getContexts() {
        return new Contexts();
    }

    public String getDescription() {
        return null;
    }

    public SentryId getEventId() {
        return SentryId.EMPTY_ID;
    }

    public Span getLatestActiveSpan() {
        return null;
    }

    public String getName() {
        return "";
    }

    public String getOperation() {
        return "";
    }

    @Deprecated
    @ScheduledForRemoval
    public Request getRequest() {
        return null;
    }

    public SpanContext getSpanContext() {
        SpanContext spanContext = new SpanContext(SentryId.EMPTY_ID, SpanId.EMPTY_ID, JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS, null, null);
        return spanContext;
    }

    public List<Span> getSpans() {
        return Collections.emptyList();
    }

    public SpanStatus getStatus() {
        return null;
    }

    public String getTag(String str) {
        return null;
    }

    public Throwable getThrowable() {
        return null;
    }

    public boolean isFinished() {
        return true;
    }

    public Boolean isSampled() {
        return null;
    }

    public void setDescription(String str) {
    }

    public void setName(String str) {
    }

    public void setOperation(String str) {
    }

    @Deprecated
    @ScheduledForRemoval
    public void setRequest(Request request) {
    }

    public void setStatus(SpanStatus spanStatus) {
    }

    public void setTag(String str, String str2) {
    }

    public void setThrowable(Throwable th) {
    }

    public ISpan startChild(String str) {
        return NoOpSpan.getInstance();
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, Boolean.FALSE);
    }

    public ISpan startChild(String str, String str2, Date date) {
        return NoOpSpan.getInstance();
    }

    public ISpan startChild(String str, String str2) {
        return NoOpSpan.getInstance();
    }
}
