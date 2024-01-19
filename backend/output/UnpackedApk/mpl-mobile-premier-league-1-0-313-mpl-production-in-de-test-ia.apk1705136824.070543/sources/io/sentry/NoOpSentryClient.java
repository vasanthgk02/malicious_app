package io.sentry;

import io.sentry.ISentryClient.CC;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;

public final class NoOpSentryClient implements ISentryClient {
    public static final NoOpSentryClient instance = new NoOpSentryClient();

    public static NoOpSentryClient getInstance() {
        return instance;
    }

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return CC.$default$captureEvent(this, sentryEvent);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent, Scope scope) {
        return CC.$default$captureEvent((ISentryClient) this, sentryEvent, scope);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Scope scope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return CC.$default$captureEvent((ISentryClient) this, sentryEvent, obj);
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return CC.$default$captureException(this, th);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Scope scope) {
        return CC.$default$captureException((ISentryClient) this, th, scope);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Scope scope, Object obj) {
        return CC.$default$captureException(this, th, scope, obj);
    }

    public /* synthetic */ SentryId captureException(Throwable th, Object obj) {
        return CC.$default$captureException((ISentryClient) this, th, obj);
    }

    public /* synthetic */ SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return CC.$default$captureMessage(this, str, sentryLevel);
    }

    public /* synthetic */ SentryId captureMessage(String str, SentryLevel sentryLevel, Scope scope) {
        return CC.$default$captureMessage(this, str, sentryLevel, scope);
    }

    public /* synthetic */ void captureSession(Session session) {
        CC.$default$captureSession(this, session);
    }

    public void captureSession(Session session, Object obj) {
    }

    public /* synthetic */ SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return CC.$default$captureTransaction(this, sentryTransaction);
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, Scope scope, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
    }

    public void close() {
    }

    public void flush(long j) {
    }

    public boolean isEnabled() {
        return false;
    }
}
