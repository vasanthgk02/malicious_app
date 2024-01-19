package io.sentry;

import io.sentry.protocol.SentryId;
import java.util.Date;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public final class NoOpSpan implements ISpan {
    public static final NoOpSpan instance = new NoOpSpan();

    public static NoOpSpan getInstance() {
        return instance;
    }

    public void finish() {
    }

    public void finish(SpanStatus spanStatus) {
    }

    public String getDescription() {
        return null;
    }

    public String getOperation() {
        return "";
    }

    public SpanContext getSpanContext() {
        SpanContext spanContext = new SpanContext(SentryId.EMPTY_ID, SpanId.EMPTY_ID, JoinRoomInvitationRequest.KEY_OPTIONAL_PARAMS, null, null);
        return spanContext;
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
        return false;
    }

    public void setDescription(String str) {
    }

    public void setOperation(String str) {
    }

    public void setStatus(SpanStatus spanStatus) {
    }

    public void setTag(String str, String str2) {
    }

    public void setThrowable(Throwable th) {
    }

    public ISpan startChild(String str) {
        return getInstance();
    }

    public SentryTraceHeader toSentryTrace() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, Boolean.FALSE);
    }

    public ISpan startChild(String str, String str2, Date date) {
        return getInstance();
    }

    public ISpan startChild(String str, String str2) {
        return getInstance();
    }
}
