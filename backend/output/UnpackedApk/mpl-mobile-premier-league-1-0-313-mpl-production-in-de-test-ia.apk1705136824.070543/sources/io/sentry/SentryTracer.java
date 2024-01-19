package io.sentry;

import io.sentry.Scope.IWithTransaction;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.ScheduledForRemoval;

@Internal
public final class SentryTracer implements ITransaction {
    public final List<Span> children;
    public final Contexts contexts;
    public final SentryId eventId;
    public FinishStatus finishStatus;
    public final IHub hub;
    public String name;
    public Request request;
    public final Span root;
    public final boolean waitForChildren;

    public static final class FinishStatus {
        public static final FinishStatus NOT_FINISHED = notFinished();
        public final boolean isFinishing;
        public final SpanStatus spanStatus;

        public FinishStatus(boolean z, SpanStatus spanStatus2) {
            this.isFinishing = z;
            this.spanStatus = spanStatus2;
        }

        public static FinishStatus finishing(SpanStatus spanStatus2) {
            return new FinishStatus(true, spanStatus2);
        }

        public static FinishStatus notFinished() {
            return new FinishStatus(false, null);
        }
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub) {
        this(transactionContext, iHub, (Date) null);
    }

    private ISpan createChild(SpanId spanId, String str) {
        return createChild(spanId, str, null, null);
    }

    private boolean hasAllChildrenFinished() {
        ArrayList arrayList = new ArrayList(this.children);
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((Span) it.next()).isFinished()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void finish() {
        finish(getStatus());
    }

    public List<Span> getChildren() {
        return this.children;
    }

    @Deprecated
    @ScheduledForRemoval
    public Contexts getContexts() {
        return this.contexts;
    }

    public String getDescription() {
        return this.root.getDescription();
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public Span getLatestActiveSpan() {
        ArrayList arrayList = new ArrayList(this.children);
        if (!arrayList.isEmpty()) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!((Span) arrayList.get(size)).isFinished()) {
                    return (Span) arrayList.get(size);
                }
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getOperation() {
        return this.root.getOperation();
    }

    @Deprecated
    @ScheduledForRemoval
    public Request getRequest() {
        return this.request;
    }

    public Span getRoot() {
        return this.root;
    }

    public SpanContext getSpanContext() {
        return this.root.getSpanContext();
    }

    public List<Span> getSpans() {
        return this.children;
    }

    public Date getStartTimestamp() {
        return this.root.getStartTimestamp();
    }

    public SpanStatus getStatus() {
        return this.root.getStatus();
    }

    public String getTag(String str) {
        return this.root.getTag(str);
    }

    public Throwable getThrowable() {
        return this.root.getThrowable();
    }

    public Date getTimestamp() {
        return this.root.getTimestamp();
    }

    public boolean isFinished() {
        return this.root.isFinished();
    }

    public Boolean isSampled() {
        return this.root.isSampled();
    }

    public /* synthetic */ void lambda$createChild$0$SentryTracer(Span span) {
        FinishStatus finishStatus2 = this.finishStatus;
        if (finishStatus2.isFinishing) {
            finish(finishStatus2.spanStatus);
        }
    }

    public /* synthetic */ void lambda$finish$1$SentryTracer(Scope scope, ITransaction iTransaction) {
        if (iTransaction == this) {
            scope.clearTransaction();
        }
    }

    public /* synthetic */ void lambda$finish$2$SentryTracer(Scope scope) {
        scope.withTransaction(new IWithTransaction(scope) {
            public final /* synthetic */ Scope f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(ITransaction iTransaction) {
                SentryTracer.this.lambda$finish$1$SentryTracer(this.f$1, iTransaction);
            }
        });
    }

    public void setDescription(String str) {
        this.root.setDescription(str);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperation(String str) {
        this.root.setOperation(str);
    }

    @Deprecated
    @ScheduledForRemoval
    public void setRequest(Request request2) {
        this.request = request2;
    }

    public void setStatus(SpanStatus spanStatus) {
        this.root.setStatus(spanStatus);
    }

    public void setTag(String str, String str2) {
        this.root.setTag(str, str2);
    }

    public void setThrowable(Throwable th) {
        this.root.setThrowable(th);
    }

    public ISpan startChild(SpanId spanId, String str, String str2) {
        ISpan createChild = createChild(spanId, str);
        createChild.setDescription(str2);
        return createChild;
    }

    public SentryTraceHeader toSentryTrace() {
        return this.root.toSentryTrace();
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub, boolean z) {
        this(transactionContext, iHub, null, z);
    }

    private ISpan createChild(SpanId spanId, String str, String str2, Date date) {
        Objects.requireNonNull(spanId, "parentSpanId is required");
        Objects.requireNonNull(str, "operation is required");
        Span span = new Span(this.root.getTraceId(), spanId, this, str, this.hub, date, new SpanListener() {
            public final void onSpanFinished(Span span) {
                SentryTracer.this.lambda$createChild$0$SentryTracer(span);
            }
        });
        span.setDescription(str2);
        this.children.add(span);
        return span;
    }

    public void finish(SpanStatus spanStatus) {
        this.finishStatus = FinishStatus.finishing(spanStatus);
        if (this.root.isFinished()) {
            return;
        }
        if (!this.waitForChildren || hasAllChildrenFinished()) {
            this.root.finish(this.finishStatus.spanStatus);
            this.hub.configureScope(new ScopeCallback() {
                public final void run(Scope scope) {
                    SentryTracer.this.lambda$finish$2$SentryTracer(scope);
                }
            });
            this.hub.captureTransaction(new SentryTransaction(this));
        }
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub, Date date) {
        this(transactionContext, iHub, date, false);
    }

    public ISpan startChild(SpanId spanId, String str, String str2, Date date) {
        return createChild(spanId, str, str2, date);
    }

    public SentryTracer(TransactionContext transactionContext, IHub iHub, Date date, boolean z) {
        this.eventId = new SentryId();
        this.children = new CopyOnWriteArrayList();
        this.contexts = new Contexts();
        this.finishStatus = FinishStatus.NOT_FINISHED;
        Objects.requireNonNull(transactionContext, "context is required");
        Objects.requireNonNull(iHub, "hub is required");
        this.root = new Span(transactionContext, this, iHub, date);
        this.name = transactionContext.getName();
        this.hub = iHub;
        this.waitForChildren = z;
    }

    public ISpan startChild(String str) {
        return startChild(str, null);
    }

    public ISpan startChild(String str, String str2, Date date) {
        return createChild(str, str2, date);
    }

    public ISpan startChild(String str, String str2) {
        return createChild(str, str2, null);
    }

    private ISpan createChild(String str, String str2, Date date) {
        if (this.children.size() < this.hub.getOptions().getMaxSpans()) {
            return this.root.startChild(str, str2, date);
        }
        this.hub.getOptions().getLogger().log(SentryLevel.WARNING, (String) "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return NoOpSpan.getInstance();
    }
}
