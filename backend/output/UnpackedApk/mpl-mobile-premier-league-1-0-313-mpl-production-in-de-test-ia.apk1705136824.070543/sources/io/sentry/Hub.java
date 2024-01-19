package io.sentry;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.IHub.CC;
import io.sentry.Scope.SessionPair;
import io.sentry.Stack.StackItem;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.util.ExceptionUtils;
import io.sentry.util.Objects;
import io.sentry.util.Pair;
import java.io.Closeable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Hub implements IHub {
    public volatile boolean isEnabled;
    public volatile SentryId lastEventId;
    public final SentryOptions options;
    public final Stack stack;
    public final Map<Throwable, Pair<ISpan, String>> throwableToSpan;
    public final TracesSampler tracesSampler;

    public Hub(SentryOptions sentryOptions) {
        this(sentryOptions, createRootStackItem(sentryOptions));
    }

    private void assignTraceContext(SentryEvent sentryEvent) {
        if (sentryEvent.getThrowable() != null) {
            Pair pair = this.throwableToSpan.get(ExceptionUtils.findRootCause(sentryEvent.getThrowable()));
            if (pair != null) {
                ISpan iSpan = (ISpan) pair.getFirst();
                if (sentryEvent.getContexts().getTrace() == null && iSpan != null) {
                    sentryEvent.getContexts().setTrace(iSpan.getSpanContext());
                }
                String str = (String) pair.getSecond();
                if (sentryEvent.getTransaction() == null && str != null) {
                    sentryEvent.setTransaction(str);
                }
            }
        }
    }

    public static StackItem createRootStackItem(SentryOptions sentryOptions) {
        validateOptions(sentryOptions);
        return new StackItem(sentryOptions, new SentryClient(sentryOptions), new Scope(sentryOptions));
    }

    private ITransaction createTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2) {
        ITransaction iTransaction;
        Objects.requireNonNull(transactionContext, "transactionContext is required");
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransaction = NoOpTransaction.getInstance();
        } else if (!this.options.isTracingEnabled()) {
            this.options.getLogger().log(SentryLevel.INFO, (String) "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransaction = NoOpTransaction.getInstance();
        } else {
            transactionContext.setSampled(Boolean.valueOf(this.tracesSampler.sample(new SamplingContext(transactionContext, customSamplingContext))));
            iTransaction = new SentryTracer(transactionContext, this, date, z2);
        }
        if (z) {
            configureScope(new ScopeCallback() {
                public final void run(Scope scope) {
                    scope.setTransaction(ITransaction.this);
                }
            });
        }
        return iTransaction;
    }

    public static void validateOptions(SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub is no DSN is available.");
        }
    }

    public /* synthetic */ void addBreadcrumb(Breadcrumb breadcrumb) {
        CC.$default$addBreadcrumb((IHub) this, breadcrumb);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().addBreadcrumb(breadcrumb, obj);
        }
    }

    public /* synthetic */ void addBreadcrumb(String str) {
        CC.$default$addBreadcrumb((IHub) this, str);
    }

    public /* synthetic */ void addBreadcrumb(String str, String str2) {
        CC.$default$addBreadcrumb(this, str, str2);
    }

    public void bindClient(ISentryClient iSentryClient) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'bindClient' call is a no-op.", new Object[0]);
            return;
        }
        StackItem peek = this.stack.peek();
        if (iSentryClient != null) {
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "New client bound to scope.", new Object[0]);
            peek.setClient(iSentryClient);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "NoOp client bound to scope.", new Object[0]);
        peek.setClient(NoOpSentryClient.getInstance());
    }

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    @Internal
    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
        } else {
            try {
                SentryId captureEnvelope = this.stack.peek().getClient().captureEnvelope(sentryEnvelope, obj);
                if (captureEnvelope != null) {
                    sentryId = captureEnvelope;
                }
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, (String) "Error while capturing envelope.", (Throwable) e2);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return CC.$default$captureEvent(this, sentryEvent);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryId;
        } else if (sentryEvent == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "captureEvent called with null parameter.", new Object[0]);
            return sentryId;
        } else {
            try {
                assignTraceContext(sentryEvent);
                StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureEvent(sentryEvent, peek.getScope(), obj);
                this.lastEventId = sentryId;
                return sentryId;
            } catch (Exception e2) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while capturing event with id: ");
                outline73.append(sentryEvent.getEventId());
                logger.log(sentryLevel, outline73.toString(), (Throwable) e2);
                return sentryId;
            }
        }
    }

    public /* synthetic */ SentryId captureException(Throwable th) {
        return CC.$default$captureException(this, th);
    }

    public SentryId captureException(Throwable th, Object obj) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                StackItem peek = this.stack.peek();
                SentryEvent sentryEvent = new SentryEvent(th);
                assignTraceContext(sentryEvent);
                sentryId = peek.getClient().captureEvent(sentryEvent, peek.getScope(), obj);
            } catch (Exception e2) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while capturing exception: ");
                outline73.append(th.getMessage());
                logger.log(sentryLevel, outline73.toString(), (Throwable) e2);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public /* synthetic */ SentryId captureMessage(String str) {
        return CC.$default$captureMessage(this, str);
    }

    public SentryId captureMessage(String str, SentryLevel sentryLevel) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureMessage' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "captureMessage called with null parameter.", new Object[0]);
        } else {
            try {
                StackItem peek = this.stack.peek();
                sentryId = peek.getClient().captureMessage(str, sentryLevel, peek.getScope());
            } catch (Exception e2) {
                ILogger logger = this.options.getLogger();
                SentryLevel sentryLevel2 = SentryLevel.ERROR;
                logger.log(sentryLevel2, "Error while capturing message: " + str, (Throwable) e2);
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    @Internal
    public /* synthetic */ SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return CC.$default$captureTransaction(this, sentryTransaction);
    }

    @Internal
    public SentryId captureTransaction(SentryTransaction sentryTransaction, Object obj) {
        Objects.requireNonNull(sentryTransaction, "transaction is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
        } else {
            if (!sentryTransaction.isFinished()) {
                this.options.getLogger().log(SentryLevel.WARNING, (String) "Capturing unfinished transaction: %s", sentryTransaction.getEventId());
            }
            if (!Boolean.TRUE.equals(Boolean.valueOf(sentryTransaction.isSampled()))) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Transaction %s was dropped due to sampling decision.", sentryTransaction.getEventId());
            } else {
                try {
                    StackItem peek = this.stack.peek();
                    sentryId = peek.getClient().captureTransaction(sentryTransaction, peek.getScope(), obj);
                } catch (Exception e2) {
                    ILogger logger = this.options.getLogger();
                    SentryLevel sentryLevel = SentryLevel.ERROR;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while capturing transaction with id: ");
                    outline73.append(sentryTransaction.getEventId());
                    logger.log(sentryLevel, outline73.toString(), (Throwable) e2);
                }
            }
        }
        this.lastEventId = sentryId;
        return sentryId;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'captureUserFeedback' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().captureUserFeedback(userFeedback);
        } catch (Exception e2) {
            ILogger logger = this.options.getLogger();
            SentryLevel sentryLevel = SentryLevel.ERROR;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error while capturing captureUserFeedback: ");
            outline73.append(userFeedback.toString());
            logger.log(sentryLevel, outline73.toString(), (Throwable) e2);
        }
    }

    public void clearBreadcrumbs() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().clearBreadcrumbs();
        }
    }

    public void close() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration next : this.options.getIntegrations()) {
                if (next instanceof Closeable) {
                    ((Closeable) next).close();
                }
            }
            this.options.getExecutorService().close(this.options.getShutdownTimeout());
            this.stack.peek().getClient().close();
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Error while closing the Hub.", (Throwable) e2);
        }
        this.isEnabled = false;
    }

    public void configureScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.stack.peek().getScope());
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Error in the 'configureScope' callback.", (Throwable) e2);
        }
    }

    public void endSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        StackItem peek = this.stack.peek();
        Session endSession = peek.getScope().endSession();
        if (endSession != null) {
            peek.getClient().captureSession(endSession, new SessionEndHint());
        }
    }

    public void flush(long j) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.stack.peek().getClient().flush(j);
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Error in the 'client.flush'.", (Throwable) e2);
        }
    }

    public SentryId getLastEventId() {
        return this.lastEventId;
    }

    public SentryOptions getOptions() {
        return this.stack.peek().getOptions();
    }

    public ISpan getSpan() {
        if (isEnabled()) {
            return this.stack.peek().getScope().getSpan();
        }
        this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'getSpan' call is a no-op.", new Object[0]);
        return null;
    }

    public SpanContext getSpanContext(Throwable th) {
        Objects.requireNonNull(th, "throwable is required");
        Pair pair = this.throwableToSpan.get(ExceptionUtils.findRootCause(th));
        if (pair != null) {
            ISpan iSpan = (ISpan) pair.getFirst();
            if (iSpan != null) {
                return iSpan.getSpanContext();
            }
        }
        return null;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void popScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'popScope' call is a no-op.", new Object[0]);
        } else {
            this.stack.pop();
        }
    }

    public void pushScope() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'pushScope' call is a no-op.", new Object[0]);
            return;
        }
        StackItem peek = this.stack.peek();
        this.stack.push(new StackItem(this.options, peek.getClient(), new Scope(peek.getScope())));
    }

    public void removeExtra(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "removeExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeExtra(str);
        }
    }

    public void removeTag(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        } else if (str == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "removeTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().removeTag(str);
        }
    }

    public void setExtra(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "setExtra called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setExtra(str, str2);
        }
    }

    public void setFingerprint(List<String> list) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setFingerprint' call is a no-op.", new Object[0]);
        } else if (list == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "setFingerprint called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setFingerprint(list);
        }
    }

    public void setLevel(SentryLevel sentryLevel) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setLevel' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setLevel(sentryLevel);
        }
    }

    @Internal
    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
        Objects.requireNonNull(th, "throwable is required");
        Objects.requireNonNull(iSpan, "span is required");
        Objects.requireNonNull(str, "transactionName is required");
        Throwable findRootCause = ExceptionUtils.findRootCause(th);
        if (!this.throwableToSpan.containsKey(findRootCause)) {
            this.throwableToSpan.put(findRootCause, new Pair(iSpan, str));
        }
    }

    public void setTag(String str, String str2) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "setTag called with null parameter.", new Object[0]);
        } else {
            this.stack.peek().getScope().setTag(str, str2);
        }
    }

    public void setTransaction(String str) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setTransaction' call is a no-op.", new Object[0]);
        } else if (str != null) {
            this.stack.peek().getScope().setTransaction(str);
        } else {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Transaction cannot be null", new Object[0]);
        }
    }

    public void setUser(User user) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        } else {
            this.stack.peek().getScope().setUser(user);
        }
    }

    public void startSession() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        StackItem peek = this.stack.peek();
        SessionPair startSession = peek.getScope().startSession();
        if (startSession != null) {
            if (startSession.getPrevious() != null) {
                peek.getClient().captureSession(startSession.getPrevious(), new SessionEndHint());
            }
            peek.getClient().captureSession(startSession.getCurrent(), new SessionStartHint());
            return;
        }
        this.options.getLogger().log(SentryLevel.WARNING, (String) "Session could not be started.", new Object[0]);
    }

    public /* synthetic */ ITransaction startTransaction(TransactionContext transactionContext) {
        return CC.$default$startTransaction(this, transactionContext);
    }

    public /* synthetic */ ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        return CC.$default$startTransaction((IHub) this, transactionContext, customSamplingContext);
    }

    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z) {
        return createTransaction(transactionContext, customSamplingContext, z, null, false);
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
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'traceHeaders' call is a no-op.", new Object[0]);
        } else {
            ISpan span = this.stack.peek().getScope().getSpan();
            if (span != null) {
                return span.toSentryTrace();
            }
        }
        return null;
    }

    public void withScope(ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Instance is disabled and this 'withScope' call is a no-op.", new Object[0]);
            return;
        }
        pushScope();
        try {
            scopeCallback.run(this.stack.peek().getScope());
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Error in the 'withScope' callback.", (Throwable) e2);
        }
        popScope();
    }

    public Hub(SentryOptions sentryOptions, Stack stack2) {
        this.throwableToSpan = Collections.synchronizedMap(new WeakHashMap());
        validateOptions(sentryOptions);
        this.options = sentryOptions;
        this.tracesSampler = new TracesSampler(sentryOptions);
        this.stack = stack2;
        this.lastEventId = SentryId.EMPTY_ID;
        this.isEnabled = true;
    }

    public IHub clone() {
        if (!isEnabled()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Disabled Hub cloned.", new Object[0]);
        }
        return new Hub(this.options, new Stack(this.stack));
    }

    @Internal
    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date) {
        return createTransaction(transactionContext, customSamplingContext, z, date, false);
    }

    @Internal
    public ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2) {
        return createTransaction(transactionContext, customSamplingContext, z, date, z2);
    }

    public Hub(SentryOptions sentryOptions, StackItem stackItem) {
        this(sentryOptions, new Stack(sentryOptions.getLogger(), stackItem));
    }
}
