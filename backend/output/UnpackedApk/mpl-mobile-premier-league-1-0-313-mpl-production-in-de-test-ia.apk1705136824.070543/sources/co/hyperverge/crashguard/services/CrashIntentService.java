package co.hyperverge.crashguard.services;

import android.content.Intent;
import androidx.core.app.JobIntentService;
import co.hyperverge.crashguard.data.models.CrashEvent;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.Json.Default;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lco/hyperverge/crashguard/services/CrashIntentService;", "Landroidx/core/app/JobIntentService;", "()V", "crashEventsRepo", "Lco/hyperverge/crashguard/data/repo/CrashEventsRepo;", "getCrashEventsRepo", "()Lco/hyperverge/crashguard/data/repo/CrashEventsRepo;", "crashEventsRepo$delegate", "Lkotlin/Lazy;", "prefsRepo", "Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "getPrefsRepo", "()Lco/hyperverge/crashguard/data/repo/PrefsRepo;", "prefsRepo$delegate", "sentryApiInterface", "Lco/hyperverge/crashguard/data/network/SentryApi;", "getSentryApiInterface", "()Lco/hyperverge/crashguard/data/network/SentryApi;", "sentryApiInterface$delegate", "onDestroy", "", "onHandleWork", "intent", "Landroid/content/Intent;", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashIntentService.kt */
public final class CrashIntentService extends JobIntentService {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = Reflection.getOrCreateKotlinClass(CrashIntentService.class).getQualifiedName();
    public static boolean isEnqueueingEvents;
    public final Lazy crashEventsRepo$delegate = TweetUtils.lazy((Function0<? extends T>) new CrashIntentService$crashEventsRepo$2<Object>(this));
    public final Lazy prefsRepo$delegate = TweetUtils.lazy((Function0<? extends T>) new CrashIntentService$prefsRepo$2<Object>(this));
    public final Lazy sentryApiInterface$delegate = TweetUtils.lazy((Function0<? extends T>) CrashIntentService$sentryApiInterface$2.INSTANCE);

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lco/hyperverge/crashguard/services/CrashIntentService$Companion;", "", "()V", "ARG_CRASH_EVENT", "", "JOB_ID", "", "TAG", "isEnqueueingEvents", "", "addWork", "", "context", "Landroid/content/Context;", "crashEvent", "Lco/hyperverge/crashguard/data/models/CrashEvent;", "enqueue", "enqueuePending", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashIntentService.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049 A[Catch:{ all -> 0x007f }, LOOP:0: B:16:0x0039->B:24:0x0049, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0078 A[EDGE_INSN: B:33:0x0078->B:25:0x0078 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void enqueuePending(android.content.Context r8) {
            /*
                r7 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.String r0 = co.hyperverge.crashguard.services.CrashIntentService.TAG
                boolean r0 = androidx.core.widget.CompoundButtonCompat.isNetworkAvailable(r8)
                if (r0 != 0) goto L_0x0010
                java.lang.String r8 = co.hyperverge.crashguard.services.CrashIntentService.TAG
                return
            L_0x0010:
                boolean r0 = co.hyperverge.crashguard.services.CrashIntentService.isEnqueueingEvents     // Catch:{ all -> 0x007f }
                if (r0 != 0) goto L_0x007c
                co.hyperverge.crashguard.data.repo.CrashEventsRepo$Companion r0 = co.hyperverge.crashguard.data.repo.CrashEventsRepo.Companion     // Catch:{ all -> 0x007f }
                co.hyperverge.crashguard.data.repo.CrashEventsRepo r0 = r0.getInstance(r8)     // Catch:{ all -> 0x007f }
                com.squareup.tape2.ObjectQueue<co.hyperverge.crashguard.data.models.CrashEvent> r1 = r0.eventQueue     // Catch:{ all -> 0x007f }
                if (r1 != 0) goto L_0x0020
                r1 = 0
                goto L_0x0024
            L_0x0020:
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x007f }
            L_0x0024:
                java.lang.String r2 = co.hyperverge.crashguard.services.CrashIntentService.TAG     // Catch:{ all -> 0x007f }
                java.lang.String r2 = "enqueuePending() events to be queued: "
                com.squareup.tape2.ObjectQueue<co.hyperverge.crashguard.data.models.CrashEvent> r0 = r0.eventQueue     // Catch:{ all -> 0x007f }
                if (r0 != 0) goto L_0x002e
                r0 = -1
                goto L_0x0032
            L_0x002e:
                int r0 = r0.size()     // Catch:{ all -> 0x007f }
            L_0x0032:
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x007f }
                kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)     // Catch:{ all -> 0x007f }
            L_0x0039:
                r0 = 0
                r2 = 1
                if (r1 != 0) goto L_0x003e
                goto L_0x0046
            L_0x003e:
                boolean r3 = r1.hasNext()     // Catch:{ all -> 0x007f }
                if (r3 != r2) goto L_0x0046
                r3 = 1
                goto L_0x0047
            L_0x0046:
                r3 = 0
            L_0x0047:
                if (r3 == 0) goto L_0x0078
                co.hyperverge.crashguard.services.CrashIntentService.isEnqueueingEvents = r2     // Catch:{ all -> 0x007f }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x007f }
                java.lang.Class<co.hyperverge.crashguard.services.CrashIntentService> r2 = co.hyperverge.crashguard.services.CrashIntentService.class
                r0.<init>(r8, r2)     // Catch:{ all -> 0x007f }
                java.lang.String r2 = "crash_event"
                kotlinx.serialization.json.Json$Default r3 = kotlinx.serialization.json.Json.Default     // Catch:{ all -> 0x007f }
                java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x007f }
                kotlinx.serialization.modules.SerializersModule r5 = r3.serializersModule     // Catch:{ all -> 0x007f }
                java.lang.Class<co.hyperverge.crashguard.data.models.CrashEvent> r6 = co.hyperverge.crashguard.data.models.CrashEvent.class
                kotlin.reflect.KType r6 = kotlin.jvm.internal.Reflection.typeOf(r6)     // Catch:{ all -> 0x007f }
                kotlinx.serialization.KSerializer r5 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.serializer(r5, r6)     // Catch:{ all -> 0x007f }
                java.lang.String r3 = r3.encodeToString(r5, r4)     // Catch:{ all -> 0x007f }
                r0.putExtra(r2, r3)     // Catch:{ all -> 0x007f }
                java.lang.Class<co.hyperverge.crashguard.services.CrashIntentService> r2 = co.hyperverge.crashguard.services.CrashIntentService.class
                r3 = 2345(0x929, float:3.286E-42)
                androidx.core.app.JobIntentService.enqueueWork(r8, r2, r3, r0)     // Catch:{ all -> 0x007f }
                r1.remove()     // Catch:{ all -> 0x007f }
                goto L_0x0039
            L_0x0078:
                java.lang.String r8 = co.hyperverge.crashguard.services.CrashIntentService.TAG     // Catch:{ all -> 0x007f }
                co.hyperverge.crashguard.services.CrashIntentService.isEnqueueingEvents = r0     // Catch:{ all -> 0x007f }
            L_0x007c:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007f }
                goto L_0x0084
            L_0x007f:
                r8 = move-exception
                java.lang.Object r8 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r8)
            L_0x0084:
                java.lang.Throwable r8 = kotlin.Result.m884exceptionOrNullimpl(r8)
                if (r8 == 0) goto L_0x0095
                java.lang.String r0 = co.hyperverge.crashguard.services.CrashIntentService.TAG
                java.lang.String r8 = r8.getMessage()
                java.lang.String r0 = "enqueuePending failed: "
                kotlin.jvm.internal.Intrinsics.stringPlus(r0, r8)
            L_0x0095:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.hyperverge.crashguard.services.CrashIntentService.Companion.enqueuePending(android.content.Context):void");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onHandleWork(Intent intent) {
        Object obj;
        Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
        try {
            Default defaultR = Json.Default;
            String stringExtra = intent.getStringExtra("crash_event");
            Intrinsics.checkNotNull(stringExtra);
            Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(ARG_CRASH_EVENT)!!");
            obj = (CrashEvent) defaultR.decodeFromString(TypeUtilsKt.serializer(defaultR.serializersModule, Reflection.typeOf(CrashEvent.class)), stringExtra);
        } catch (Throwable th) {
            obj = TweetUtils.createFailure(th);
        }
        Throwable r0 = Result.m884exceptionOrNullimpl(obj);
        if (r0 != null) {
            Intrinsics.stringPlus("onHandleWork: crashEvent from intent : ", r0);
        }
        if (Result.m884exceptionOrNullimpl(obj) == null) {
            TypeUtilsKt.runBlocking$default(null, new CrashIntentService$onHandleWork$1(this, (CrashEvent) obj, null), 1, null);
        }
    }
}
