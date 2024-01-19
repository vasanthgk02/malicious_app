package io.hansel.segments;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.config.RemoteConfigManager;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.h;
import io.hansel.userjourney.p;
import io.hansel.userjourney.prompts.e0;
import io.hansel.userjourney.prompts.g;
import io.hansel.userjourney.prompts.h0;
import io.hansel.userjourney.prompts.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i implements m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5250a;

    /* renamed from: b  reason: collision with root package name */
    public final IMessageBroker f5251b;

    /* renamed from: c  reason: collision with root package name */
    public final e0 f5252c;

    /* renamed from: d  reason: collision with root package name */
    public final io.hansel.userjourney.prompts.r0.c f5253d;

    /* renamed from: e  reason: collision with root package name */
    public final io.hansel.userjourney.prompts.r0.a f5254e;

    /* renamed from: f  reason: collision with root package name */
    public final h f5255f;
    public l g;
    public final ThreadPoolExecutor h;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IMessageBroker f5256a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ io.hansel.userjourney.models.b f5257b;

        public a(IMessageBroker iMessageBroker, io.hansel.userjourney.models.b bVar) {
            this.f5256a = iMessageBroker;
            this.f5257b = bVar;
        }

        public void run() {
            try {
                i.this.b(this.f5256a, this.f5257b);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2, "Exception in createAndShowTrigger Handler ", LogGroup.PT);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f5259a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5260b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ io.hansel.userjourney.models.b f5261c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IMessageBroker f5262d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g[] f5263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f5264f;

        public b(List list, int i, io.hansel.userjourney.models.b bVar, IMessageBroker iMessageBroker, g[] gVarArr, CountDownLatch countDownLatch) {
            this.f5259a = list;
            this.f5260b = i;
            this.f5261c = bVar;
            this.f5262d = iMessageBroker;
            this.f5263e = gVarArr;
            this.f5264f = countDownLatch;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x00d4 A[Catch:{ all -> 0x00fe, all -> 0x0104 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.util.List r0 = r8.f5259a     // Catch:{ all -> 0x00fe }
                int r1 = r8.f5260b     // Catch:{ all -> 0x00fe }
                java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00fe }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00fe }
                io.hansel.segments.i r1 = io.hansel.segments.i.this     // Catch:{ all -> 0x00fe }
                android.content.Context r1 = r1.f5250a     // Catch:{ all -> 0x00fe }
                java.lang.String r1 = io.hansel.userjourney.p.r(r1, r0)     // Catch:{ all -> 0x00fe }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
                r2.<init>()     // Catch:{ all -> 0x00fe }
                java.lang.String r3 = "Active threads: "
                r2.append(r3)     // Catch:{ all -> 0x00fe }
                io.hansel.segments.i r3 = io.hansel.segments.i.this     // Catch:{ all -> 0x00fe }
                java.util.concurrent.ThreadPoolExecutor r3 = r3.h     // Catch:{ all -> 0x00fe }
                int r3 = r3.getActiveCount()     // Catch:{ all -> 0x00fe }
                r2.append(r3)     // Catch:{ all -> 0x00fe }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00fe }
                io.hansel.core.logger.HSLLogger.d(r2)     // Catch:{ all -> 0x00fe }
                if (r1 != 0) goto L_0x003a
            L_0x0034:
                java.util.concurrent.CountDownLatch r0 = r8.f5264f
                r0.countDown()
                return
            L_0x003a:
                io.hansel.userjourney.models.b r2 = r8.f5261c     // Catch:{ all -> 0x00fe }
                io.hansel.core.json.CoreJSONObject r2 = r2.b()     // Catch:{ all -> 0x00fe }
                io.hansel.core.json.CoreJSONObject r3 = new io.hansel.core.json.CoreJSONObject     // Catch:{ all -> 0x00fe }
                r3.<init>(r1)     // Catch:{ all -> 0x00fe }
                java.lang.String r1 = "frequency"
                io.hansel.core.json.CoreJSONObject r1 = r3.optJSONObject(r1)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = "duration"
                java.lang.String r1 = r1.optString(r4)     // Catch:{ all -> 0x00fe }
                io.hansel.userjourney.prompts.f r1 = io.hansel.userjourney.prompts.f.a(r1)     // Catch:{ all -> 0x00fe }
                io.hansel.segments.i r4 = io.hansel.segments.i.this     // Catch:{ all -> 0x00fe }
                io.hansel.userjourney.prompts.e0 r4 = r4.f5252c     // Catch:{ all -> 0x00fe }
                boolean r2 = r4.a(r3, r0, r2)     // Catch:{ all -> 0x00fe }
                if (r2 == 0) goto L_0x00e3
                java.lang.String r2 = "prompt_type"
                java.lang.String r2 = r3.optString(r2)     // Catch:{ all -> 0x00fe }
                io.hansel.segments.i r4 = io.hansel.segments.i.this     // Catch:{ all -> 0x00fe }
                android.app.Activity r4 = r4.a()     // Catch:{ all -> 0x00fe }
                io.hansel.core.module.IMessageBroker r5 = r8.f5262d     // Catch:{ all -> 0x00fe }
                io.hansel.userjourney.prompts.k r1 = io.hansel.userjourney.prompts.k.a(r4, r3, r1, r2, r5)     // Catch:{ all -> 0x00fe }
                io.hansel.userjourney.models.b r2 = r8.f5261c     // Catch:{ all -> 0x00fe }
                java.lang.String r2 = r2.a()     // Catch:{ all -> 0x00fe }
                java.lang.String r3 = "hansel_nudge_event"
                boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00fe }
                r3 = 1
                if (r2 == 0) goto L_0x0086
                r1.b(r3)     // Catch:{ all -> 0x00fe }
                goto L_0x00d6
            L_0x0086:
                boolean r2 = r1.M()     // Catch:{ all -> 0x00fe }
                if (r2 != 0) goto L_0x0092
                boolean r2 = r1.L()     // Catch:{ all -> 0x00fe }
                if (r2 == 0) goto L_0x00d6
            L_0x0092:
                r2 = 0
                java.lang.String r5 = r1.p()     // Catch:{ all -> 0x00fe }
                boolean r6 = io.hansel.core.utils.HSLUtils.isSet(r5)     // Catch:{ all -> 0x00fe }
                if (r6 == 0) goto L_0x00d1
                java.lang.String r6 = r1.z()     // Catch:{ all -> 0x00fe }
                io.hansel.segments.i r7 = io.hansel.segments.i.this     // Catch:{ all -> 0x00fe }
                io.hansel.segments.l r7 = r7.g     // Catch:{ all -> 0x00fe }
                java.lang.String r7 = r7.a()     // Catch:{ all -> 0x00fe }
                boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x00fe }
                if (r6 == 0) goto L_0x00d1
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
                r6.<init>()     // Catch:{ all -> 0x00fe }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x00fe }
                r6.append(r4)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = ","
                r6.append(r4)     // Catch:{ all -> 0x00fe }
                java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00fe }
                boolean r4 = r5.startsWith(r4)     // Catch:{ all -> 0x00fe }
                if (r4 == 0) goto L_0x00d1
                goto L_0x00d2
            L_0x00d1:
                r3 = 0
            L_0x00d2:
                if (r3 != 0) goto L_0x00d6
                goto L_0x0034
            L_0x00d6:
                io.hansel.userjourney.prompts.g[] r2 = r8.f5263e     // Catch:{ all -> 0x00fe }
                int r3 = r8.f5260b     // Catch:{ all -> 0x00fe }
                io.hansel.userjourney.prompts.g r4 = new io.hansel.userjourney.prompts.g     // Catch:{ all -> 0x00fe }
                r4.<init>(r0, r1)     // Catch:{ all -> 0x00fe }
                r2[r3] = r4     // Catch:{ all -> 0x00fe }
                goto L_0x0034
            L_0x00e3:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
                r1.<init>()     // Catch:{ all -> 0x00fe }
                java.lang.String r2 = "Prompt with id "
                r1.append(r2)     // Catch:{ all -> 0x00fe }
                r1.append(r0)     // Catch:{ all -> 0x00fe }
                java.lang.String r0 = " is not eligible for display"
                r1.append(r0)     // Catch:{ all -> 0x00fe }
                java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00fe }
                io.hansel.core.logger.HSLLogger.d(r0)     // Catch:{ all -> 0x00fe }
                goto L_0x0034
            L_0x00fe:
                r0 = move-exception
                io.hansel.core.logger.HSLLogger.printStackTrace(r0)     // Catch:{ all -> 0x0104 }
                goto L_0x0034
            L_0x0104:
                r0 = move-exception
                java.util.concurrent.CountDownLatch r1 = r8.f5264f
                r1.countDown()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.segments.i.b.run():void");
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f5265a;

        public c(List list) {
            this.f5265a = list;
        }

        public void run() {
            i.this.b(this.f5265a);
            i.this.h();
        }
    }

    public i(Context context, IMessageBroker iMessageBroker) {
        Context context2 = context;
        this.f5250a = context2;
        this.f5251b = iMessageBroker;
        h hVar = new h();
        this.f5255f = hVar;
        e0 e0Var = new e0(context2);
        this.f5252c = e0Var;
        Context context3 = context;
        IMessageBroker iMessageBroker2 = iMessageBroker;
        e0 e0Var2 = e0Var;
        h hVar2 = hVar;
        io.hansel.userjourney.prompts.r0.c cVar = new io.hansel.userjourney.prompts.r0.c(context3, iMessageBroker2, this, e0Var2, hVar2);
        this.f5253d = cVar;
        io.hansel.userjourney.prompts.r0.a aVar = new io.hansel.userjourney.prompts.r0.a(context3, iMessageBroker2, this, e0Var2, hVar2);
        this.f5254e = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 6, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.h = threadPoolExecutor;
    }

    private void a(io.hansel.userjourney.models.b bVar) {
        if (bVar != null) {
            j.a(this.f5250a, bVar.a(), bVar.g(), bVar.b());
        }
    }

    private void a(List<g> list) {
        HSLUtils.cleanList(list);
        ArrayList arrayList = new ArrayList();
        for (g next : list) {
            if (next.b() != null) {
                arrayList.add(next.b());
            }
        }
        this.f5255f.c(this.f5250a, (List<String>) arrayList);
        List<String> b2 = this.f5255f.b(this.f5250a, (List<String>) arrayList);
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            if (!b2.contains(h0.b(it.next().b()))) {
                it.remove();
            }
        }
        a(list, b2);
    }

    private void a(List<g> list, List<String> list2) {
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            list.set(list2.indexOf(h0.b(gVar.b())), gVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(IMessageBroker iMessageBroker, io.hansel.userjourney.models.b bVar) {
        a(bVar);
        String str = bVar.a() + bVar.g();
        List<String> q = p.q(this.f5250a, str);
        int size = q.size();
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            HSLLogger.w(GeneratedOutlineSupport.outline62(sb, "No prompt attached to event : ", str), LogGroup.PT);
            return;
        }
        sb.append("Prompts attached to event : ");
        sb.append(str);
        sb.append(" are   ");
        sb.append(q);
        HSLLogger.d(sb.toString(), LogGroup.PT);
        g[] gVarArr = new g[size];
        CountDownLatch countDownLatch = new CountDownLatch(size);
        int i = 0;
        while (i < size) {
            try {
                ThreadPoolExecutor threadPoolExecutor = this.h;
                b bVar2 = r1;
                b bVar3 = new b(q, i, bVar, iMessageBroker, gVarArr, countDownLatch);
                threadPoolExecutor.execute(bVar2);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Something went wrong while enqueueing a nudge", LogGroup.PT);
                countDownLatch.countDown();
            }
            i++;
            io.hansel.userjourney.models.b bVar4 = bVar;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            HSLLogger.printStackTrace(e2);
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(gVarArr));
        a((List<g>) arrayList);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b((List<g>) arrayList);
            h();
        } else {
            new Handler(this.f5250a.getMainLooper()).post(new c(arrayList));
        }
    }

    /* access modifiers changed from: private */
    public void b(List<g> list) {
        HSLLogger.d("Populating nudge queues");
        for (g next : list) {
            if (next != null) {
                if (next.a().K()) {
                    this.f5254e.a(next);
                } else {
                    this.f5253d.a(next);
                }
            }
        }
        b();
    }

    /* access modifiers changed from: private */
    public void h() {
        HSLLogger.d("Showing nudges on main.");
        this.f5254e.s();
        this.f5253d.s();
    }

    public Activity a() {
        Object returnEventData = this.f5251b.returnEventData(EventsConstants.GET_TOP_ACTIVITY.name(), null);
        if (returnEventData instanceof Activity) {
            return (Activity) returnEventData;
        }
        return null;
    }

    public void a(IMessageBroker iMessageBroker, io.hansel.userjourney.models.b bVar) {
        new Thread(new a(iMessageBroker, bVar)).start();
    }

    public void a(l lVar) {
        this.g = lVar;
        io.hansel.userjourney.prompts.r0.b.a(lVar);
    }

    public void a(String[] strArr) {
        this.f5254e.a(strArr);
        this.f5253d.a(strArr);
    }

    public void b() {
        String str = this.f5254e.n() + this.f5253d.n();
        HSLLogger.d("All detached nudges are " + str);
    }

    public void c() {
        this.f5254e.c();
        this.f5253d.c();
    }

    public void d() {
        this.f5254e.i();
        this.f5253d.i();
    }

    public boolean e() {
        return this.f5253d.o() || this.f5254e.p();
    }

    public void f() {
        HSLLogger.d("Triggering next nudge in newScreenAdded.");
        this.f5254e.s();
        this.f5253d.s();
    }

    public void g() {
        this.f5254e.s();
        this.f5253d.s();
    }
}
