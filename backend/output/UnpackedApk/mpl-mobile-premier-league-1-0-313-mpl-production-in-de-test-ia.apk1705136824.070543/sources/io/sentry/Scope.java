package io.sentry;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.sentry.SentryOptions.BeforeBreadcrumbCallback;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Scope {
    public List<Attachment> attachments = new CopyOnWriteArrayList();
    public Queue<Breadcrumb> breadcrumbs;
    public Contexts contexts = new Contexts();
    public List<EventProcessor> eventProcessors = new CopyOnWriteArrayList();
    public Map<String, Object> extra = new ConcurrentHashMap();
    public List<String> fingerprint = new ArrayList();
    public SentryLevel level;
    public final SentryOptions options;
    public Request request;
    public volatile Session session;
    public final Object sessionLock = new Object();
    public Map<String, String> tags = new ConcurrentHashMap();
    public ITransaction transaction;
    public final Object transactionLock = new Object();
    public String transactionName;
    public User user;

    public interface IWithSession {
        void accept(Session session);
    }

    @Internal
    public interface IWithTransaction {
        void accept(ITransaction iTransaction);
    }

    public static final class SessionPair {
        public final Session current;
        public final Session previous;

        public SessionPair(Session session, Session session2) {
            this.current = session;
            this.previous = session2;
        }

        public Session getCurrent() {
            return this.current;
        }

        public Session getPrevious() {
            return this.previous;
        }
    }

    public Scope(SentryOptions sentryOptions) {
        SentryOptions sentryOptions2 = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.options = sentryOptions2;
        this.breadcrumbs = createBreadcrumbsList(sentryOptions2.getMaxBreadcrumbs());
    }

    private Queue<Breadcrumb> createBreadcrumbsList(int i) {
        return SynchronizedQueue.synchronizedQueue(new CircularFifoQueue(i));
    }

    private Breadcrumb executeBeforeBreadcrumb(BeforeBreadcrumbCallback beforeBreadcrumbCallback, Breadcrumb breadcrumb, Object obj) {
        try {
            return beforeBreadcrumbCallback.execute(breadcrumb, obj);
        } catch (Exception e2) {
            this.options.getLogger().log(SentryLevel.ERROR, (String) "The BeforeBreadcrumbCallback callback threw an exception. It will be added as breadcrumb and continue.", (Throwable) e2);
            if (e2.getMessage() == null) {
                return breadcrumb;
            }
            breadcrumb.setData("sentry:message", e2.getMessage());
            return breadcrumb;
        }
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        if (breadcrumb != null) {
            BeforeBreadcrumbCallback beforeBreadcrumb = this.options.getBeforeBreadcrumb();
            if (beforeBreadcrumb != null) {
                breadcrumb = executeBeforeBreadcrumb(beforeBreadcrumb, breadcrumb, obj);
            }
            if (breadcrumb != null) {
                this.breadcrumbs.add(breadcrumb);
                if (this.options.isEnableScopeSync()) {
                    for (IScopeObserver addBreadcrumb : this.options.getScopeObservers()) {
                        addBreadcrumb.addBreadcrumb(breadcrumb);
                    }
                }
            } else {
                this.options.getLogger().log(SentryLevel.INFO, (String) "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
            }
        }
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public void clear() {
        this.level = null;
        this.user = null;
        this.request = null;
        this.fingerprint.clear();
        clearBreadcrumbs();
        this.tags.clear();
        this.extra.clear();
        this.eventProcessors.clear();
        clearTransaction();
        clearAttachments();
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    public void clearBreadcrumbs() {
        this.breadcrumbs.clear();
    }

    public void clearTransaction() {
        synchronized (this.transactionLock) {
            this.transaction = null;
        }
        this.transactionName = null;
    }

    public Session endSession() {
        Session session2;
        synchronized (this.sessionLock) {
            try {
                session2 = null;
                if (this.session != null) {
                    this.session.end();
                    Session clone = this.session.clone();
                    this.session = null;
                    session2 = clone;
                }
            }
        }
        return session2;
    }

    public List<Attachment> getAttachments() {
        return new CopyOnWriteArrayList(this.attachments);
    }

    public Queue<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public List<String> getFingerprint() {
        return this.fingerprint;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public Request getRequest() {
        return this.request;
    }

    public ISpan getSpan() {
        ITransaction iTransaction = this.transaction;
        if (iTransaction != null) {
            Span latestActiveSpan = iTransaction.getLatestActiveSpan();
            if (latestActiveSpan != null) {
                return latestActiveSpan;
            }
        }
        return iTransaction;
    }

    @Internal
    public Map<String, String> getTags() {
        return CollectionUtils.newConcurrentHashMap(this.tags);
    }

    public ITransaction getTransaction() {
        return this.transaction;
    }

    public String getTransactionName() {
        ITransaction iTransaction = this.transaction;
        return iTransaction != null ? iTransaction.getName() : this.transactionName;
    }

    public User getUser() {
        return this.user;
    }

    public void removeContexts(String str) {
        this.contexts.remove(str);
    }

    public void removeExtra(String str) {
        this.extra.remove(str);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver removeExtra : this.options.getScopeObservers()) {
                removeExtra.removeExtra(str);
            }
        }
    }

    public void removeTag(String str) {
        this.tags.remove(str);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver removeTag : this.options.getScopeObservers()) {
                removeTag.removeTag(str);
            }
        }
    }

    public void setContexts(String str, Object obj) {
        this.contexts.put(str, obj);
    }

    public void setExtra(String str, String str2) {
        this.extra.put(str, str2);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver extra2 : this.options.getScopeObservers()) {
                extra2.setExtra(str, str2);
            }
        }
    }

    public void setFingerprint(List<String> list) {
        if (list != null) {
            this.fingerprint = new ArrayList(list);
        }
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver tag : this.options.getScopeObservers()) {
                tag.setTag(str, str2);
            }
        }
    }

    public void setTransaction(String str) {
        if (str != null) {
            ITransaction iTransaction = this.transaction;
            if (iTransaction != null) {
                iTransaction.setName(str);
            }
            this.transactionName = str;
            return;
        }
        this.options.getLogger().log(SentryLevel.WARNING, (String) "Transaction cannot be null", new Object[0]);
    }

    public void setUser(User user2) {
        this.user = user2;
        if (this.options.isEnableScopeSync()) {
            for (IScopeObserver user3 : this.options.getScopeObservers()) {
                user3.setUser(user2);
            }
        }
    }

    public SessionPair startSession() {
        SessionPair sessionPair;
        synchronized (this.sessionLock) {
            try {
                if (this.session != null) {
                    this.session.end();
                }
                Session session2 = this.session;
                Session session3 = 0;
                if (this.options.getRelease() != null) {
                    this.session = new Session(this.options.getDistinctId(), this.user, this.options.getEnvironment(), this.options.getRelease());
                    if (session2 != null) {
                        session3 = session2.clone();
                    }
                    sessionPair = new SessionPair(this.session.clone(), session3);
                } else {
                    this.options.getLogger().log(SentryLevel.WARNING, (String) "Release is not set on SentryOptions. Session could not be started", new Object[0]);
                    sessionPair = session3;
                }
            }
        }
        return sessionPair;
    }

    public Session withSession(IWithSession iWithSession) {
        Session clone;
        synchronized (this.sessionLock) {
            try {
                iWithSession.accept(this.session);
                clone = this.session != null ? this.session.clone() : null;
            }
        }
        return clone;
    }

    @Internal
    public void withTransaction(IWithTransaction iWithTransaction) {
        synchronized (this.transactionLock) {
            iWithTransaction.accept(this.transaction);
        }
    }

    public void setContexts(String str, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put(HSLCriteriaBuilder.VALUE, bool);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HSLCriteriaBuilder.VALUE, str2);
        setContexts(str, (Object) hashMap);
    }

    public void setTransaction(ITransaction iTransaction) {
        synchronized (this.transactionLock) {
            this.transaction = iTransaction;
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, null);
    }

    public void setContexts(String str, Number number) {
        HashMap hashMap = new HashMap();
        hashMap.put(HSLCriteriaBuilder.VALUE, number);
        setContexts(str, (Object) hashMap);
    }

    public Scope(Scope scope) {
        this.transaction = scope.transaction;
        this.transactionName = scope.transactionName;
        this.session = scope.session;
        this.options = scope.options;
        this.level = scope.level;
        User user2 = scope.user;
        Request request2 = null;
        this.user = user2 != null ? new User(user2) : null;
        Request request3 = scope.request;
        this.request = request3 != null ? new Request(request3) : request2;
        this.fingerprint = new ArrayList(scope.fingerprint);
        this.eventProcessors = new CopyOnWriteArrayList(scope.eventProcessors);
        Queue<Breadcrumb> queue = scope.breadcrumbs;
        Queue<Breadcrumb> createBreadcrumbsList = createBreadcrumbsList(scope.options.getMaxBreadcrumbs());
        for (Breadcrumb breadcrumb : queue) {
            createBreadcrumbsList.add(new Breadcrumb(breadcrumb));
        }
        this.breadcrumbs = createBreadcrumbsList;
        Map<String, String> map = scope.tags;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Entry next : map.entrySet()) {
            if (next != null) {
                concurrentHashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        this.tags = concurrentHashMap;
        Map<String, Object> map2 = scope.extra;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Entry next2 : map2.entrySet()) {
            if (next2 != null) {
                concurrentHashMap2.put((String) next2.getKey(), next2.getValue());
            }
        }
        this.extra = concurrentHashMap2;
        this.contexts = new Contexts(this.contexts);
        this.attachments = new CopyOnWriteArrayList(scope.attachments);
    }
}
