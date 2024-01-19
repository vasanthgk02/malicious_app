package io.sentry;

import com.facebook.react.modules.network.NetworkingModule;
import io.sentry.ISentryClient.CC;
import io.sentry.Scope.IWithSession;
import io.sentry.SentryOptions.BeforeSendCallback;
import io.sentry.Session.State;
import io.sentry.hints.DiskFlushNotification;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransport;
import io.sentry.util.ApplyScopeUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SentryClient implements ISentryClient {
    public static final String SENTRY_PROTOCOL_VERSION = "7";
    public boolean enabled;
    public final SentryOptions options;
    public final Random random;
    public final SortBreadcrumbsByDate sortBreadcrumbsByDate = new SortBreadcrumbsByDate();
    public final ITransport transport;

    public static final class SortBreadcrumbsByDate implements Comparator<Breadcrumb> {
        public SortBreadcrumbsByDate() {
        }

        public int compare(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
            return breadcrumb.getTimestamp().compareTo(breadcrumb2.getTimestamp());
        }
    }

    public SentryClient(SentryOptions sentryOptions) {
        Random random2 = null;
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.enabled = true;
        ITransportFactory transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof NoOpTransportFactory) {
            transportFactory = new AsyncHttpTransportFactory();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.transport = transportFactory.create(sentryOptions, new RequestDetailsResolver(sentryOptions).resolve());
        this.random = sentryOptions.getSampleRate() != null ? new Random() : random2;
    }

    private SentryEvent applyScope(SentryEvent sentryEvent, Scope scope, Object obj) {
        if (scope == null) {
            return sentryEvent;
        }
        applyScope(sentryEvent, scope);
        if (sentryEvent.getTransaction() == null) {
            sentryEvent.setTransaction(scope.getTransactionName());
        }
        if (sentryEvent.getFingerprints() == null) {
            sentryEvent.setFingerprints(scope.getFingerprint());
        }
        if (scope.getLevel() != null) {
            sentryEvent.setLevel(scope.getLevel());
        }
        ISpan span = scope.getSpan();
        if (sentryEvent.getContexts().getTrace() == null && span != null) {
            sentryEvent.getContexts().setTrace(span.getSpanContext());
        }
        return processEvent(sentryEvent, obj, scope.getEventProcessors());
    }

    private SentryEnvelope buildEnvelope(SentryBaseEvent sentryBaseEvent, List<Attachment> list) throws IOException {
        return buildEnvelope(sentryBaseEvent, list, null);
    }

    private SentryEvent executeBeforeSend(SentryEvent sentryEvent, Object obj) {
        BeforeSendCallback beforeSend = this.options.getBeforeSend();
        if (beforeSend == null) {
            return sentryEvent;
        }
        try {
            return beforeSend.execute(sentryEvent, obj);
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", (Throwable) e2);
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setMessage("BeforeSend callback failed.");
            breadcrumb.setCategory("SentryClient");
            breadcrumb.setLevel(SentryLevel.ERROR);
            if (e2.getMessage() != null) {
                breadcrumb.setData("sentry:message", e2.getMessage());
            }
            sentryEvent.addBreadcrumb(breadcrumb);
            return sentryEvent;
        }
    }

    private List<Attachment> filterForTransaction(List<Attachment> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Attachment next : list) {
            if (next.isAddToTransactions()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<Attachment> getAttachmentsFromScope(Scope scope) {
        if (scope != null) {
            return scope.getAttachments();
        }
        return null;
    }

    private SentryEvent processEvent(SentryEvent sentryEvent, Object obj, List<EventProcessor> list) {
        Iterator<EventProcessor> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor next = it.next();
            try {
                sentryEvent = next.process(sentryEvent, obj);
                continue;
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, e2, "An exception occurred while processing event by processor: %s", next.getClass().getName());
                continue;
            }
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event was dropped by a processor: %s", next.getClass().getName());
                break;
            }
        }
        return sentryEvent;
    }

    private SentryTransaction processTransaction(SentryTransaction sentryTransaction, Object obj, List<EventProcessor> list) {
        Iterator<EventProcessor> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor next = it.next();
            try {
                sentryTransaction = next.process(sentryTransaction, obj);
                continue;
            } catch (Exception e2) {
                this.options.getLogger().log(SentryLevel.ERROR, e2, "An exception occurred while processing transaction by processor: %s", next.getClass().getName());
                continue;
            }
            if (sentryTransaction == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Transaction was dropped by a processor: %s", next.getClass().getName());
                break;
            }
        }
        return sentryTransaction;
    }

    private boolean sample() {
        if (this.options.getSampleRate() == null || this.random == null || this.options.getSampleRate().doubleValue() >= this.random.nextDouble()) {
            return true;
        }
        return false;
    }

    private boolean shouldApplyScopeData(SentryBaseEvent sentryBaseEvent, Object obj) {
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event was cached so not applying scope: %s", sentryBaseEvent.getEventId());
        return false;
    }

    private void sortBreadcrumbsByDate(SentryBaseEvent sentryBaseEvent, Collection<Breadcrumb> collection) {
        List<Breadcrumb> breadcrumbs = sentryBaseEvent.getBreadcrumbs();
        if (breadcrumbs != null && !collection.isEmpty()) {
            breadcrumbs.addAll(collection);
            Collections.sort(breadcrumbs, this.sortBreadcrumbsByDate);
        }
    }

    public /* synthetic */ SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return CC.$default$captureEnvelope(this, sentryEnvelope);
    }

    @Internal
    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Object obj) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        try {
            this.transport.send(sentryEnvelope, obj);
            SentryId eventId = sentryEnvelope.getHeader().getEventId();
            if (eventId != null) {
                return eventId;
            }
            return SentryId.EMPTY_ID;
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to capture envelope.", (Throwable) e2);
            return SentryId.EMPTY_ID;
        }
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent) {
        return CC.$default$captureEvent(this, sentryEvent);
    }

    public /* synthetic */ SentryId captureEvent(SentryEvent sentryEvent, Scope scope) {
        return CC.$default$captureEvent((ISentryClient) this, sentryEvent, scope);
    }

    public SentryId captureEvent(SentryEvent sentryEvent, Scope scope, Object obj) {
        Objects.requireNonNull(sentryEvent, "SentryEvent is required.");
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Capturing event: %s", sentryEvent.getEventId());
        if (shouldApplyScopeData(sentryEvent, obj)) {
            sentryEvent = applyScope(sentryEvent, scope, obj);
            if (sentryEvent == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event was dropped by applyScope", new Object[0]);
                return SentryId.EMPTY_ID;
            }
        }
        SentryEvent processEvent = processEvent(sentryEvent, obj, this.options.getEventProcessors());
        Session session = null;
        if (processEvent != null) {
            Session updateSessionData = updateSessionData(processEvent, obj, scope);
            if (!sample()) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event %s was dropped due to sampling decision.", processEvent.getEventId());
                processEvent = null;
            }
            session = updateSessionData;
        }
        if (processEvent != null) {
            if (processEvent.getThrowable() == null || !this.options.containsIgnoredExceptionForType(processEvent.getThrowable())) {
                processEvent = executeBeforeSend(processEvent, obj);
                if (processEvent == null) {
                    this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event was dropped by beforeSend", new Object[0]);
                }
            } else {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Event was dropped as the exception %s is ignored", processEvent.getThrowable().getClass());
                return SentryId.EMPTY_ID;
            }
        }
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!(processEvent == null || processEvent.getEventId() == null)) {
            sentryId = processEvent.getEventId();
        }
        try {
            SentryEnvelope buildEnvelope = buildEnvelope(processEvent, getAttachmentsFromScope(scope), session);
            if (buildEnvelope != null) {
                this.transport.send(buildEnvelope, obj);
            }
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.WARNING, e2, "Capturing event %s failed.", sentryId);
            sentryId = SentryId.EMPTY_ID;
        }
        return sentryId;
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

    @Internal
    public void captureSession(Session session, Object obj) {
        Objects.requireNonNull(session, "Session is required.");
        if (session.getRelease() == null || session.getRelease().isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            captureEnvelope(SentryEnvelope.from(this.options.getSerializer(), session, this.options.getSdkVersion()), obj);
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "Failed to capture session.", (Throwable) e2);
        }
    }

    public /* synthetic */ SentryId captureTransaction(SentryTransaction sentryTransaction) {
        return CC.$default$captureTransaction(this, sentryTransaction);
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, Scope scope, Object obj) {
        Objects.requireNonNull(sentryTransaction, "Transaction is required.");
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Capturing transaction: %s", sentryTransaction.getEventId());
        SentryId sentryId = SentryId.EMPTY_ID;
        if (sentryTransaction.getEventId() != null) {
            sentryId = sentryTransaction.getEventId();
        }
        if (shouldApplyScopeData(sentryTransaction, obj)) {
            sentryTransaction = (SentryTransaction) applyScope(sentryTransaction, scope);
            if (!(sentryTransaction == null || scope == null)) {
                sentryTransaction = processTransaction(sentryTransaction, obj, scope.getEventProcessors());
            }
            if (sentryTransaction == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, (String) "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (sentryTransaction != null) {
            sentryTransaction = processTransaction(sentryTransaction, obj, this.options.getEventProcessors());
        }
        if (sentryTransaction == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, (String) "Transaction was dropped by Event processors.", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        processTransaction(sentryTransaction);
        try {
            SentryEnvelope buildEnvelope = buildEnvelope(sentryTransaction, filterForTransaction(getAttachmentsFromScope(scope)));
            if (buildEnvelope != null) {
                this.transport.send(buildEnvelope, obj);
            } else {
                sentryId = SentryId.EMPTY_ID;
            }
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.WARNING, e2, "Capturing transaction %s failed.", sentryId);
            sentryId = SentryId.EMPTY_ID;
        }
        return sentryId;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Objects.requireNonNull(userFeedback, "SentryEvent is required.");
        if (SentryId.EMPTY_ID.equals(userFeedback.getEventId())) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Capturing userFeedback without a Sentry Id.", new Object[0]);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, (String) "Capturing userFeedback: %s", userFeedback.getEventId());
        try {
            this.transport.send(buildEnvelope(userFeedback));
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.WARNING, e2, "Capturing user feedback %s failed.", userFeedback.getEventId());
        }
    }

    public void close() {
        this.options.getLogger().log(SentryLevel.INFO, (String) "Closing SentryClient.", new Object[0]);
        try {
            flush(this.options.getShutdownTimeout());
            this.transport.close();
        } catch (IOException e2) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Failed to close the connection to the Sentry Server.", (Throwable) e2);
        }
        this.enabled = false;
    }

    public void flush(long j) {
        this.transport.flush(j);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public /* synthetic */ void lambda$updateSessionData$0$SentryClient(SentryEvent sentryEvent, Object obj, Session session) {
        boolean z = false;
        if (session != null) {
            String str = null;
            State state = sentryEvent.isCrashed() ? State.Crashed : null;
            if (State.Crashed == state || sentryEvent.isErrored()) {
                z = true;
            }
            if (!(sentryEvent.getRequest() == null || sentryEvent.getRequest().getHeaders() == null || !sentryEvent.getRequest().getHeaders().containsKey(NetworkingModule.USER_AGENT_HEADER_NAME))) {
                str = sentryEvent.getRequest().getHeaders().get(NetworkingModule.USER_AGENT_HEADER_NAME);
            }
            if (session.update(state, str, z) && (obj instanceof DiskFlushNotification)) {
                session.end();
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, (String) "Session is null on scope.withSession", new Object[0]);
    }

    public Session updateSessionData(SentryEvent sentryEvent, Object obj, Scope scope) {
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            if (scope != null) {
                return scope.withSession(new IWithSession(sentryEvent, obj) {
                    public final /* synthetic */ SentryEvent f$1;
                    public final /* synthetic */ Object f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void accept(Session session) {
                        SentryClient.this.lambda$updateSessionData$0$SentryClient(this.f$1, this.f$2, session);
                    }
                });
            }
            this.options.getLogger().log(SentryLevel.INFO, (String) "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    private SentryEnvelope buildEnvelope(SentryBaseEvent sentryBaseEvent, List<Attachment> list, Session session) throws IOException {
        SentryId sentryId;
        ArrayList arrayList = new ArrayList();
        if (sentryBaseEvent != null) {
            arrayList.add(SentryEnvelopeItem.fromEvent(this.options.getSerializer(), sentryBaseEvent));
            sentryId = sentryBaseEvent.getEventId();
        } else {
            sentryId = null;
        }
        if (session != null) {
            arrayList.add(SentryEnvelopeItem.fromSession(this.options.getSerializer(), session));
        }
        if (list != null) {
            for (Attachment fromAttachment : list) {
                arrayList.add(SentryEnvelopeItem.fromAttachment(fromAttachment, this.options.getMaxAttachmentSize()));
            }
        }
        if (!arrayList.isEmpty()) {
            return new SentryEnvelope(new SentryEnvelopeHeader(sentryId, this.options.getSdkVersion()), arrayList);
        }
        return null;
    }

    private SentryTransaction processTransaction(SentryTransaction sentryTransaction) {
        ArrayList arrayList = new ArrayList();
        for (SentrySpan next : sentryTransaction.getSpans()) {
            if (!next.isFinished()) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, (String) "Dropping %d unfinished spans", Integer.valueOf(arrayList.size()));
        }
        sentryTransaction.getSpans().removeAll(arrayList);
        return sentryTransaction;
    }

    private <T extends SentryBaseEvent> T applyScope(T t, Scope scope) {
        if (scope != null) {
            if (t.getRequest() == null) {
                t.setRequest(scope.getRequest());
            }
            if (t.getUser() == null) {
                t.setUser(scope.getUser());
            }
            if (t.getTags() == null) {
                t.setTags(new HashMap(scope.getTags()));
            } else {
                for (Entry next : scope.getTags().entrySet()) {
                    if (!t.getTags().containsKey(next.getKey())) {
                        t.getTags().put((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            if (t.getBreadcrumbs() == null) {
                t.setBreadcrumbs(new ArrayList(scope.getBreadcrumbs()));
            } else {
                sortBreadcrumbsByDate(t, scope.getBreadcrumbs());
            }
            if (t.getExtras() == null) {
                t.setExtras(new HashMap(scope.getExtras()));
            } else {
                for (Entry next2 : scope.getExtras().entrySet()) {
                    if (!t.getExtras().containsKey(next2.getKey())) {
                        t.getExtras().put((String) next2.getKey(), next2.getValue());
                    }
                }
            }
            Contexts contexts = t.getContexts();
            for (Entry entry : new Contexts(scope.getContexts()).entrySet()) {
                if (!contexts.containsKey(entry.getKey())) {
                    contexts.put((String) entry.getKey(), entry.getValue());
                }
            }
        }
        return t;
    }

    private SentryEnvelope buildEnvelope(UserFeedback userFeedback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromUserFeedback(this.options.getSerializer(), userFeedback));
        return new SentryEnvelope(new SentryEnvelopeHeader(userFeedback.getEventId(), this.options.getSdkVersion()), arrayList);
    }
}
