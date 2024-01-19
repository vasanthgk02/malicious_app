package io.hansel.userjourney.prompts.r0;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.lifecycle.HanselActivityLifecycleManager;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.segments.c;
import io.hansel.segments.d;
import io.hansel.segments.l;
import io.hansel.userjourney.p;
import io.hansel.userjourney.prompts.a0;
import io.hansel.userjourney.prompts.e0;
import io.hansel.userjourney.prompts.f;
import io.hansel.userjourney.prompts.h;
import io.hansel.userjourney.prompts.k;
import io.hansel.userjourney.prompts.m;
import io.hansel.userjourney.prompts.q0;
import io.hansel.userjourney.prompts.r;
import java.util.HashMap;

public abstract class b {

    /* renamed from: e  reason: collision with root package name */
    public static l f5676e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile m f5677f;

    /* renamed from: a  reason: collision with root package name */
    public final Context f5678a;

    /* renamed from: b  reason: collision with root package name */
    public final e0 f5679b;

    /* renamed from: c  reason: collision with root package name */
    public final IMessageBroker f5680c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f5681d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                b.this.d();
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception in dismissAllPrompts Handler ");
                outline73.append(e2.toString());
                HSLLogger.d(outline73.toString());
            }
        }
    }

    public b(Context context, IMessageBroker iMessageBroker, m mVar, e0 e0Var) {
        this.f5678a = context;
        this.f5680c = iMessageBroker;
        this.f5679b = e0Var;
        this.f5681d = new a0(iMessageBroker);
        synchronized (this) {
            if (f5677f == null) {
                f5677f = mVar;
            }
        }
    }

    public static void a(l lVar) {
        f5676e = lVar;
    }

    public View a(k kVar, String str) {
        HashMap outline87 = GeneratedOutlineSupport.outline87("eid", str);
        if (kVar.F() != io.hansel.userjourney.prompts.l.SPOTLIGHT) {
            outline87.put("posx", Double.valueOf(kVar.u()));
            outline87.put("posy", Double.valueOf(kVar.v()));
        }
        return (View) this.f5680c.returnEventData(EventsConstants.GET_EID_VIEW.name(), outline87);
    }

    public h a(String str, k kVar, io.hansel.segments.b bVar) {
        try {
            CoreJSONObject coreJSONObject = new CoreJSONObject(p.r(this.f5678a, str));
            CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("changes");
            CoreJSONObject optJSONObject2 = optJSONObject.getJSONObject("prompt").optJSONObject("props");
            h a2 = kVar.K() ? q0.a(optJSONObject, this.f5680c, str) : new r(optJSONObject, this.f5680c, null, str);
            Pair pair = new Pair(str, coreJSONObject);
            Pair pair2 = (Pair) this.f5680c.returnEventData(EventsConstants.GET_PROMPT_SHOW_EVENT_MAP.name(), pair);
            Pair pair3 = (Pair) this.f5680c.returnEventData(EventsConstants.GET_PROMPT_DISMISS_EVENT_MAP.name(), pair);
            a2.a(bVar, (c) new d());
            a2.a(optJSONObject2, kVar);
            a2.a((HashMap) pair2.first, (HashMap) pair3.first, (HashMap) pair2.second, (HashMap) pair3.second);
            a2.a(g());
            return a2;
        } catch (CoreJSONException unused) {
            HSLLogger.d("Error creating NudgeView for nudge " + str);
            return null;
        }
    }

    public void a(io.hansel.userjourney.prompts.c cVar) {
        try {
            if (!h()) {
                Activity g = g();
                if (g != null) {
                    cVar.b(g);
                }
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2, "Error stopping activity tracker.", LogGroup.PT);
        }
    }

    public void a(io.hansel.userjourney.prompts.c cVar, Activity activity, boolean z) {
        try {
            if (h() || z) {
                cVar.a(activity);
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2, "Error starting activity tracker.", LogGroup.PT);
        }
    }

    public void a(h hVar) {
        io.hansel.segments.k.a(this.f5678a, hVar.b(), System.currentTimeMillis());
    }

    public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2) {
        this.f5681d.b(hashMap, hashMap2);
    }

    public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, r rVar) {
        this.f5679b.a(rVar, System.currentTimeMillis(), f.SESSION == rVar.i().o());
        this.f5681d.a(hashMap);
        rVar.f();
        this.f5681d.a(hashMap, hashMap2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        if (r2.startsWith(g().getClass().getName() + ",") != false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(io.hansel.userjourney.prompts.k r5) {
        /*
            r4 = this;
            boolean r0 = r5.M()
            r1 = 1
            if (r0 != 0) goto L_0x000f
            boolean r0 = r5.L()
            if (r0 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            return r1
        L_0x000f:
            r0 = 0
            java.lang.String r2 = r5.p()
            boolean r3 = io.hansel.core.utils.HSLUtils.isSet(r2)
            if (r3 == 0) goto L_0x004e
            java.lang.String r5 = r5.z()
            io.hansel.segments.l r3 = f5676e
            java.lang.String r3 = r3.a()
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x004e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.app.Activity r3 = r4.g()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            r5.append(r3)
            java.lang.String r3 = ","
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            boolean r5 = r2.startsWith(r5)
            if (r5 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r0.b.a(io.hansel.userjourney.prompts.k):boolean");
    }

    public void b(h hVar) {
        if (hVar != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Update prompt position for prompt with id ");
            outline73.append(hVar.b());
            HSLLogger.d(outline73.toString(), LogGroup.PT);
            hVar.a();
        }
    }

    public void c() {
        if (Looper.myLooper() == this.f5678a.getMainLooper()) {
            d();
        } else {
            new Handler(this.f5678a.getMainLooper()).post(new a());
        }
    }

    public abstract void d();

    public m e() {
        return f5677f;
    }

    public l f() {
        return f5676e;
    }

    public Activity g() {
        if (f5677f == null) {
            return null;
        }
        return f5677f.a();
    }

    public abstract boolean h();

    public void i() {
        HSLLogger.d("Dismissing nudge on screen change.");
        c();
    }

    public boolean j() {
        LogGroup logGroup = LogGroup.PT;
        HSLLogger.d("Anchor point position changed.", logGroup);
        if (!HanselActivityLifecycleManager.getInstance().isMidTransition()) {
            return true;
        }
        HSLLogger.d("Activity is between transition hence ignoring any layout changes.", logGroup);
        return false;
    }
}
