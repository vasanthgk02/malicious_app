package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

public interface IHub {

    /* renamed from: io.sentry.IHub$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addBreadcrumb(IHub _this, Breadcrumb breadcrumb) {
            _this.addBreadcrumb(breadcrumb, (Object) null);
        }

        public static SentryId $default$captureEnvelope(IHub _this, SentryEnvelope sentryEnvelope) {
            return _this.captureEnvelope(sentryEnvelope, null);
        }

        public static SentryId $default$captureEvent(IHub _this, SentryEvent sentryEvent) {
            return _this.captureEvent(sentryEvent, null);
        }

        public static SentryId $default$captureException(IHub _this, Throwable th) {
            return _this.captureException(th, null);
        }

        public static SentryId $default$captureMessage(IHub _this, String str) {
            return _this.captureMessage(str, SentryLevel.INFO);
        }

        @Internal
        public static SentryId $default$captureTransaction(IHub _this, SentryTransaction sentryTransaction) {
            return _this.captureTransaction(sentryTransaction, null);
        }

        public static ITransaction $default$startTransaction(IHub _this, TransactionContext transactionContext) {
            return _this.startTransaction(transactionContext, false);
        }

        public static void $default$addBreadcrumb(IHub _this, String str) {
            _this.addBreadcrumb(new Breadcrumb(str));
        }

        public static ITransaction $default$startTransaction(IHub _this, TransactionContext transactionContext, boolean z) {
            return _this.startTransaction(transactionContext, (CustomSamplingContext) null, z);
        }

        public static void $default$addBreadcrumb(IHub _this, String str, String str2) {
            Breadcrumb breadcrumb = new Breadcrumb(str);
            breadcrumb.setCategory(str2);
            _this.addBreadcrumb(breadcrumb);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str, String str2, CustomSamplingContext customSamplingContext) {
            return _this.startTransaction(str, str2, customSamplingContext, false);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str, String str2, CustomSamplingContext customSamplingContext, boolean z) {
            return _this.startTransaction(new TransactionContext(str, str2), customSamplingContext, z);
        }

        public static ITransaction $default$startTransaction(IHub _this, TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
            return _this.startTransaction(transactionContext, customSamplingContext, false);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str, String str2) {
            return _this.startTransaction(str, str2, (CustomSamplingContext) null);
        }

        @Internal
        public static ITransaction $default$startTransaction(IHub _this, String str, String str2, Date date, boolean z) {
            return _this.startTransaction(new TransactionContext(str, str2), null, false, date, z);
        }

        public static ITransaction $default$startTransaction(IHub _this, String str, String str2, boolean z) {
            return _this.startTransaction(str, str2, (CustomSamplingContext) null, z);
        }
    }

    void addBreadcrumb(Breadcrumb breadcrumb);

    void addBreadcrumb(Breadcrumb breadcrumb, Object obj);

    void addBreadcrumb(String str);

    void addBreadcrumb(String str, String str2);

    void bindClient(ISentryClient iSentryClient);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj);

    SentryId captureEvent(SentryEvent sentryEvent);

    SentryId captureEvent(SentryEvent sentryEvent, Object obj);

    SentryId captureException(Throwable th);

    SentryId captureException(Throwable th, Object obj);

    SentryId captureMessage(String str);

    SentryId captureMessage(String str, SentryLevel sentryLevel);

    @Internal
    SentryId captureTransaction(SentryTransaction sentryTransaction);

    @Internal
    SentryId captureTransaction(SentryTransaction sentryTransaction, Object obj);

    void captureUserFeedback(UserFeedback userFeedback);

    void clearBreadcrumbs();

    IHub clone();

    void close();

    void configureScope(ScopeCallback scopeCallback);

    void endSession();

    void flush(long j);

    SentryId getLastEventId();

    SentryOptions getOptions();

    ISpan getSpan();

    boolean isEnabled();

    void popScope();

    void pushScope();

    void removeExtra(String str);

    void removeTag(String str);

    void setExtra(String str, String str2);

    void setFingerprint(List<String> list);

    void setLevel(SentryLevel sentryLevel);

    @Internal
    void setSpanContext(Throwable th, ISpan iSpan, String str);

    void setTag(String str, String str2);

    void setTransaction(String str);

    void setUser(User user);

    void startSession();

    ITransaction startTransaction(TransactionContext transactionContext);

    ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext);

    ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z);

    @Internal
    ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date);

    @Internal
    ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2);

    ITransaction startTransaction(TransactionContext transactionContext, boolean z);

    ITransaction startTransaction(String str, String str2);

    ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext);

    ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext, boolean z);

    @Internal
    ITransaction startTransaction(String str, String str2, Date date, boolean z);

    ITransaction startTransaction(String str, String str2, boolean z);

    SentryTraceHeader traceHeaders();

    void withScope(ScopeCallback scopeCallback);
}
