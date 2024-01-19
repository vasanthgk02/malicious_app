package io.sentry;

import io.sentry.IHub.CC;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class HubAdapter implements IHub {
    public static final HubAdapter INSTANCE = new HubAdapter();

    public static HubAdapter getInstance() {
        return INSTANCE;
    }

    public /* synthetic */ void addBreadcrumb(Breadcrumb breadcrumb) {
        CC.$default$addBreadcrumb((IHub) this, breadcrumb);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        Sentry.addBreadcrumb(breadcrumb, obj);
    }

    public /* synthetic */ void addBreadcrumb(String str) {
        CC.$default$addBreadcrumb((IHub) this, str);
    }

    public /* synthetic */ void addBreadcrumb(String str, String str2) {
        CC.$default$addBreadcrumb(this, str, str2);
    }

    public void bindClient(ISentryClient iSentryClient) {
        Sentry.bindClient(iSentryClient);
    }

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    @Internal
    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        return Sentry.getCurrentHub().captureEnvelope(sentryEnvelope, obj);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return CC.$default$captureEvent(this, sentryEvent);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return Sentry.captureEvent(sentryEvent, obj);
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return CC.$default$captureException(this, th);
    }

    public SentryId captureException(Throwable th, Object obj) {
        return Sentry.captureException(th, obj);
    }

    public /* synthetic */ SentryId captureMessage(String str) {
        return CC.$default$captureMessage(this, str);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return Sentry.captureMessage(str, sentryLevel);
    }

    @Internal
    public /* synthetic */ SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return CC.$default$captureTransaction(this, sentryTransaction);
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, Object obj) {
        return Sentry.getCurrentHub().captureTransaction(sentryTransaction, obj);
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Sentry.captureUserFeedback(userFeedback);
    }

    public void clearBreadcrumbs() {
        Sentry.clearBreadcrumbs();
    }

    public void close() {
        Sentry.close();
    }

    public void configureScope(ScopeCallback scopeCallback) {
        Sentry.configureScope(scopeCallback);
    }

    public void endSession() {
        Sentry.endSession();
    }

    public void flush(long j) {
        Sentry.flush(j);
    }

    public SentryId getLastEventId() {
        return Sentry.getLastEventId();
    }

    public SentryOptions getOptions() {
        return Sentry.getCurrentHub().getOptions();
    }

    public ISpan getSpan() {
        return Sentry.getCurrentHub().getSpan();
    }

    public boolean isEnabled() {
        return Sentry.isEnabled();
    }

    public void popScope() {
        Sentry.popScope();
    }

    public void pushScope() {
        Sentry.pushScope();
    }

    public void removeExtra(String str) {
        Sentry.removeExtra(str);
    }

    public void removeTag(String str) {
        Sentry.removeTag(str);
    }

    public void setExtra(String str, String str2) {
        Sentry.setExtra(str, str2);
    }

    public void setFingerprint(List<String> list) {
        Sentry.setFingerprint(list);
    }

    public void setLevel(SentryLevel sentryLevel) {
        Sentry.setLevel(sentryLevel);
    }

    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
        Sentry.getCurrentHub().setSpanContext(th, iSpan, str);
    }

    public void setTag(String str, String str2) {
        Sentry.setTag(str, str2);
    }

    public void setTransaction(String str) {
        Sentry.setTransaction(str);
    }

    public void setUser(User user) {
        Sentry.setUser(user);
    }

    public void startSession() {
        Sentry.startSession();
    }

    public ITransaction startTransaction(TransactionContext transactionContext) {
        return Sentry.startTransaction(transactionContext);
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
        return Sentry.traceHeaders();
    }

    public void withScope(ScopeCallback scopeCallback) {
        Sentry.withScope(scopeCallback);
    }

    public IHub clone() {
        return Sentry.getCurrentHub().clone();
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z) {
        return Sentry.startTransaction(transactionContext, customSamplingContext, z);
    }

    @Internal
    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date) {
        return Sentry.startTransaction(transactionContext, customSamplingContext, z, date);
    }

    @Internal
    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2) {
        return Sentry.startTransaction(transactionContext, customSamplingContext, z, date, z2);
    }
}
