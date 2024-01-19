package com.netcore.android.workmgr;

import android.content.Context;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Failure;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.e.b.a;
import com.netcore.android.event.b;
import com.netcore.android.event.d;
import com.netcore.android.event.f;
import com.netcore.android.event.g;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.models.SMTResponse;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0005\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0005\u0010\rJ\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\b\u0010\"¨\u0006("}, d2 = {"Lcom/netcore/android/workmgr/EventSyncWorker;", "Landroidx/work/Worker;", "", "a", "()V", "b", "d", "", "c", "()Z", "", "", "idArray", "([Ljava/lang/Integer;)V", "Landroidx/work/ListenableWorker$Result;", "doWork", "()Landroidx/work/ListenableWorker$Result;", "onStopped", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Lcom/netcore/android/event/b;", "Lcom/netcore/android/event/b;", "eventPayload", "Lcom/netcore/android/event/f;", "Lcom/netcore/android/event/f;", "smtEventsBatchProcessor", "Landroidx/work/WorkerParameters;", "param", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: EventSyncWorker.kt */
public final class EventSyncWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public final String f1326a;

    /* renamed from: b  reason: collision with root package name */
    public b f1327b;

    /* renamed from: c  reason: collision with root package name */
    public f f1328c;
    public Context context;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public EventSyncWorker(Context context2, WorkerParameters workerParameters) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(workerParameters, "param");
        super(context2, workerParameters);
        String simpleName = EventSyncWorker.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "EventSyncWorker::class.java.simpleName");
        this.f1326a = simpleName;
    }

    private final void a() {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        sMTLogger.i(this.f1326a, "Event sync worker stopped");
        if (this.f1327b != null) {
            a aVar = com.netcore.android.e.b.f1030c;
            Context context2 = this.context;
            if (context2 != null) {
                com.netcore.android.e.b b2 = aVar.b(new WeakReference(context2));
                b bVar = this.f1327b;
                if (bVar != null) {
                    b2.a(bVar.b(), "syncStatus", 4);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                    throw null;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                throw null;
            }
        } else {
            sMTLogger.i(this.f1326a, "EventPayload is not initialised.");
        }
    }

    public static final /* synthetic */ b access$getEventPayload$p(EventSyncWorker eventSyncWorker) {
        b bVar = eventSyncWorker.f1327b;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
        throw null;
    }

    private final void b() {
        d();
    }

    private final boolean c() {
        f fVar = this.f1328c;
        if (fVar != null) {
            Context context2 = this.context;
            if (context2 != null) {
                return fVar.a(new WeakReference(context2), g.EventWorker);
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("smtEventsBatchProcessor");
        throw null;
    }

    private final void d() {
        f fVar = this.f1328c;
        if (fVar != null) {
            b b2 = fVar.b(new WeakReference(getApplicationContext()), g.EventWorker);
            this.f1327b = b2;
            if (b2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                throw null;
            } else if (b2.a().length() <= 0) {
                SMTLogger.INSTANCE.v(this.f1326a, "EventsArray size is 0");
            } else {
                f fVar2 = this.f1328c;
                if (fVar2 != null) {
                    b bVar = this.f1327b;
                    if (bVar != null) {
                        SMTResponse b3 = d.f1076c.b().b(fVar2.a(bVar.a()));
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str = this.f1326a;
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request code is :");
                        outline73.append(b3 != null ? b3.getHttpCode() : null);
                        sMTLogger.v(str, outline73.toString());
                        if (b3 == null) {
                            b bVar2 = this.f1327b;
                            if (bVar2 != null) {
                                a(bVar2.b());
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                                throw null;
                            }
                        } else if (b3.isSuccess()) {
                            b bVar3 = this.f1327b;
                            if (bVar3 != null) {
                                b(bVar3.b());
                                if (c()) {
                                    sMTLogger.internal(this.f1326a, "Still events are present in DB to be processed.");
                                    d();
                                } else {
                                    sMTLogger.internal(this.f1326a, "No events are present in DB to be processed.");
                                }
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                                throw null;
                            }
                        } else {
                            b bVar4 = this.f1327b;
                            if (bVar4 != null) {
                                a(bVar4.b());
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                                throw null;
                            }
                        }
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("smtEventsBatchProcessor");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("smtEventsBatchProcessor");
            throw null;
        }
    }

    public Result doWork() {
        try {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            this.context = applicationContext;
            this.f1328c = f.g.b(applicationContext);
            b();
            Success success = new Success();
            Intrinsics.checkNotNullExpressionValue(success, "Result.success()");
            return success;
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.f1326a;
            sMTLogger.e(str, String.valueOf(e2.getMessage()));
            sMTLogger.e(str, String.valueOf(Unit.INSTANCE));
            a();
            Failure failure = new Failure();
            Intrinsics.checkNotNullExpressionValue(failure, "Result.failure()");
            return failure;
        }
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }

    public final String getTAG() {
        return this.f1326a;
    }

    public void onStopped() {
        super.onStopped();
        SMTLogger.INSTANCE.v(this.f1326a, "On stopped called ");
        a();
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    private final void b(Integer[] numArr) {
        a aVar = com.netcore.android.e.b.f1030c;
        Context context2 = this.context;
        if (context2 != null) {
            aVar.b(new WeakReference(context2)).a(numArr, "syncStatus", 3);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
    }

    private final void a(Integer[] numArr) {
        a aVar = com.netcore.android.e.b.f1030c;
        Context context2 = this.context;
        if (context2 != null) {
            aVar.b(new WeakReference(context2)).a(numArr, "syncStatus", 4);
            Context context3 = this.context;
            if (context3 != null) {
                aVar.b(new WeakReference(context3)).c();
                SMTLogger.INSTANCE.v(this.f1326a, "Events failed.");
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }
}
