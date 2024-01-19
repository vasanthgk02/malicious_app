package co.hyperverge.crashguard.data.repo;

import android.content.Context;
import co.hyperverge.crashguard.data.models.CrashEvent;
import com.squareup.tape2.ObjectQueue;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0004H\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lco/hyperverge/crashguard/data/repo/CrashEventsRepo;", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "(Ljava/lang/ref/WeakReference;)V", "eventQueue", "Lcom/squareup/tape2/ObjectQueue;", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "events", "", "getEvents", "()Ljava/util/Iterator;", "eventsCount", "", "getEventsCount", "()I", "addEvent", "", "event", "getOrCreateCrashEventsFile", "Ljava/io/File;", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashEventsRepo.kt */
public final class CrashEventsRepo {
    public static final Companion Companion = new Companion(null);
    public static CrashEventsRepo INSTANCE;
    public static final String TAG = Reflection.getOrCreateKotlinClass(CrashEventsRepo.class).getQualifiedName();
    public ObjectQueue<CrashEvent> eventQueue;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lco/hyperverge/crashguard/data/repo/CrashEventsRepo$Companion;", "", "()V", "CRASH_EVENTS_FILENAME", "", "CRASH_EVENTS_FOLDER", "INSTANCE", "Lco/hyperverge/crashguard/data/repo/CrashEventsRepo;", "TAG", "getInstance", "context", "Landroid/content/Context;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashEventsRepo.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final CrashEventsRepo getInstance(Context context) {
            Object obj;
            Intrinsics.checkNotNullParameter(context, "context");
            CrashEventsRepo crashEventsRepo = CrashEventsRepo.INSTANCE;
            if (crashEventsRepo != null) {
                return crashEventsRepo;
            }
            try {
                CrashEventsRepo crashEventsRepo2 = new CrashEventsRepo(new WeakReference(context), null);
                CrashEventsRepo.INSTANCE = crashEventsRepo2;
                obj = crashEventsRepo2;
            } catch (Throwable th) {
                obj = TweetUtils.createFailure(th);
            }
            TweetUtils.throwOnFailure(obj);
            return (CrashEventsRepo) obj;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CrashEventsRepo(java.lang.ref.WeakReference r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r5 = r5.get()
            android.content.Context r5 = (android.content.Context) r5
            r6 = 0
            if (r5 != 0) goto L_0x000d
            goto L_0x004f
        L_0x000d:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0051 }
            java.io.File r5 = r5.getFilesDir()     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = "crash_events"
            r0.<init>(r5, r1)     // Catch:{ all -> 0x0051 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = "crashes.txt"
            r5.<init>(r0, r1)     // Catch:{ all -> 0x0051 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0056
            boolean r1 = r0.mkdirs()     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0056
            java.lang.String r5 = "getOrCreateSyncFile: "
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r2.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "Sync dir: "
            r2.append(r3)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0051 }
            r2.append(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = " could not be created"
            r2.append(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0051 }
            r1.<init>(r0)     // Catch:{ all -> 0x0051 }
            kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            r5 = r6
            goto L_0x0056
        L_0x0051:
            r5 = move-exception
            java.lang.Object r5 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r5)
        L_0x0056:
            boolean r0 = r5 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r6 = r5
        L_0x005c:
            java.io.File r6 = (java.io.File) r6
            com.squareup.tape2.QueueFile$Builder r5 = new com.squareup.tape2.QueueFile$Builder     // Catch:{ all -> 0x0078 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ all -> 0x0078 }
            r5.<init>(r6)     // Catch:{ all -> 0x0078 }
            com.squareup.tape2.QueueFile r5 = r5.build()     // Catch:{ all -> 0x0078 }
            co.hyperverge.crashguard.data.converters.CrashEventConverter r0 = new co.hyperverge.crashguard.data.converters.CrashEventConverter     // Catch:{ all -> 0x0078 }
            r0.<init>()     // Catch:{ all -> 0x0078 }
            com.squareup.tape2.ObjectQueue r5 = com.squareup.tape2.ObjectQueue.create(r5, r0)     // Catch:{ all -> 0x0078 }
            r4.eventQueue = r5     // Catch:{ all -> 0x0078 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0078 }
            goto L_0x007d
        L_0x0078:
            r5 = move-exception
            java.lang.Object r5 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r5)
        L_0x007d:
            java.lang.Throwable r5 = kotlin.Result.m884exceptionOrNullimpl(r5)
            if (r5 == 0) goto L_0x00b1
            java.lang.String r0 = r5.getMessage()
            java.lang.String r1 = "Error creating crash events queue file "
            kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            boolean r0 = r5 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x009d }
            if (r0 != 0) goto L_0x0094
            boolean r5 = r5 instanceof java.io.IOException     // Catch:{ all -> 0x009d }
            if (r5 == 0) goto L_0x009a
        L_0x0094:
            if (r6 != 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r6.delete()     // Catch:{ all -> 0x009d }
        L_0x009a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009d }
            goto L_0x00a2
        L_0x009d:
            r5 = move-exception
            java.lang.Object r5 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r5)
        L_0x00a2:
            java.lang.Throwable r5 = kotlin.Result.m884exceptionOrNullimpl(r5)
            if (r5 == 0) goto L_0x00b1
            java.lang.String r5 = r5.getMessage()
            java.lang.String r6 = "Error deleting crash events queue file "
            kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.data.repo.CrashEventsRepo.<init>(java.lang.ref.WeakReference, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void addEvent(CrashEvent crashEvent) {
        Object obj;
        Intrinsics.checkNotNullParameter(crashEvent, "event");
        "addEvent() called with: event = [" + crashEvent.timestamp + ']';
        try {
            ObjectQueue<CrashEvent> objectQueue = this.eventQueue;
            Intrinsics.checkNotNull(objectQueue);
            objectQueue.add(crashEvent);
            obj = Unit.INSTANCE;
        } catch (Throwable th) {
            obj = TweetUtils.createFailure(th);
        }
        Throwable r0 = Result.m884exceptionOrNullimpl(obj);
        if (r0 != null) {
            Intrinsics.stringPlus("addEvent failed: ", r0);
        }
        if (!(obj instanceof Failure)) {
            Unit unit = (Unit) obj;
            ObjectQueue<CrashEvent> objectQueue2 = this.eventQueue;
            if (objectQueue2 != null) {
                objectQueue2.size();
            }
        }
    }
}
