package io.sentry;

import io.sentry.IHub.CC;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class NoOpHub implements IHub {
    public static final NoOpHub instance = new NoOpHub();
    public final SentryOptions emptyOptions = SentryOptions.empty();

    public static NoOpHub getInstance() {
        return instance;
    }

    public /* synthetic */ void addBreadcrumb(Breadcrumb breadcrumb) {
        CC.$default$addBreadcrumb((IHub) this, breadcrumb);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
    }

    public /* synthetic */ void addBreadcrumb(String str) {
        CC.$default$addBreadcrumb((IHub) this, str);
    }

    public /* synthetic */ void addBreadcrumb(String str, String str2) {
        CC.$default$addBreadcrumb(this, str, str2);
    }

    public void bindClient(ISentryClient iSentryClient) {
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

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return CC.$default$captureException(this, th);
    }

    public SentryId captureException(Throwable th, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public /* synthetic */ SentryId captureMessage(String str) {
        return CC.$default$captureMessage(this, str);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return SentryId.EMPTY_ID;
    }

    @Internal
    public /* synthetic */ SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return CC.$default$captureTransaction(this, sentryTransaction);
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, Object obj) {
        return SentryId.EMPTY_ID;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
    }

    public void clearBreadcrumbs() {
    }

    public void close() {
    }

    public void configureScope(ScopeCallback scopeCallback) {
    }

    public void endSession() {
    }

    public void flush(long j) {
    }

    public SentryId getLastEventId() {
        return SentryId.EMPTY_ID;
    }

    public SentryOptions getOptions() {
        return this.emptyOptions;
    }

    public ISpan getSpan() {
        return null;
    }

    public boolean isEnabled() {
        return false;
    }

    public void popScope() {
    }

    public void pushScope() {
    }

    public void removeExtra(String str) {
    }

    public void removeTag(String str) {
    }

    public void setExtra(String str, String str2) {
    }

    public void setFingerprint(List<String> list) {
    }

    public void setLevel(SentryLevel sentryLevel) {
    }

    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
    }

    public void setTag(String str, String str2) {
    }

    public void setTransaction(String str) {
    }

    public void setUser(User user) {
    }

    public void startSession() {
    }

    public ITransaction startTransaction(TransactionContext transactionContext) {
        return NoOpTransaction.getInstance();
    }

    public /* synthetic */ ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        return CC.$default$startTransaction((IHub) this, transactionContext, customSamplingContext);
    }

    public /* synthetic */ ITransaction startTransaction(TransactionContext transactionContext, boolean z) {
        return CC.$default$startTransaction((IHub) this, transactionContext, z);
    }

    public /* synthetic */ ITransaction startTransaction(String str, String str2) {
        return CC.$default$startTransaction((IHub) this, str, str2);
    }

    public /* synthetic */ ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext) {
        return CC.$default$startTransaction((IHub) this, str, str2, customSamplingContext);
    }

    public /* synthetic */ ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext, boolean z) {
        return CC.$default$startTransaction((IHub) this, str, str2, customSamplingContext, z);
    }

    @Internal
    public /* synthetic */ ITransaction startTransaction(String str, String str2, Date date, boolean z) {
        return CC.$default$startTransaction((IHub) this, str, str2, date, z);
    }

    public /* synthetic */ ITransaction startTransaction(String str, String str2, boolean z) {
        return CC.$default$startTransaction((IHub) this, str, str2, z);
    }

    public SentryTraceHeader traceHeaders() {
        return new SentryTraceHeader(SentryId.EMPTY_ID, SpanId.EMPTY_ID, Boolean.TRUE);
    }

    public void withScope(ScopeCallback scopeCallback) {
    }

    public IHub clone() {
        return instance;
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z) {
        return NoOpTransaction.getInstance();
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date) {
        return NoOpTransaction.getInstance();
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2) {
        return NoOpTransaction.getInstance();
    }
}
