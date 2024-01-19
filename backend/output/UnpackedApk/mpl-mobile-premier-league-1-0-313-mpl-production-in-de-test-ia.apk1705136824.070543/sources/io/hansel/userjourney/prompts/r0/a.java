package io.hansel.userjourney.prompts.r0;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.R;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.lifecycle.HanselActivityLifecycleManager;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.IMessageBroker;
import io.hansel.userjourney.h;
import io.hansel.userjourney.prompts.e0;
import io.hansel.userjourney.prompts.g;
import io.hansel.userjourney.prompts.j0;
import io.hansel.userjourney.prompts.k;
import io.hansel.userjourney.prompts.l;
import io.hansel.userjourney.prompts.m;
import io.hansel.userjourney.prompts.q0;
import io.hansel.userjourney.prompts.r;
import io.hansel.userjourney.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMap;

public class a extends b implements io.hansel.segments.a {
    public final io.hansel.segments.b g;
    public final List<g> h = new ArrayList();
    public final Object i = new Object();
    public final io.hansel.userjourney.prompts.c j;
    public g k = null;
    public Pair<String, q0> l;
    public Pair<String, q0> m;
    public boolean n = false;

    /* renamed from: io.hansel.userjourney.prompts.r0.a$a  reason: collision with other inner class name */
    public class C0083a implements Runnable {
        public C0083a() {
        }

        public void run() {
            try {
                a.this.v();
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception in triggerPrompt Handler ");
                outline73.append(e2.toString());
                HSLLogger.d(outline73.toString());
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f5670a;

        public b(q0 q0Var) {
            this.f5670a = q0Var;
        }

        public void run() {
            this.f5670a.c().a(0);
            a.this.a(this.f5670a, true);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f5672a;

        public c(String[] strArr) {
            this.f5672a = strArr;
        }

        public void run() {
            try {
                if (a.this.m != null) {
                    ((q0) a.this.m.second).a(this.f5672a);
                }
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception in triggerPrompt Handler ");
                outline73.append(e2.toString());
                HSLLogger.d(outline73.toString());
            }
        }
    }

    public class d implements io.hansel.segments.b {

        /* renamed from: a  reason: collision with root package name */
        public final h f5674a;

        public d(h hVar) {
            this.f5674a = hVar;
        }

        public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, io.hansel.userjourney.prompts.h hVar) {
            try {
                a.this.a(hVar);
                this.f5674a.e(a.this.f5678a, hVar.b());
                if (hashMap != null) {
                    a.this.c(hVar);
                    if (!((q0) a.this.m.second).c().J()) {
                        a.this.a(hashMap, hashMap2);
                    }
                    a aVar = a.this;
                    aVar.a(aVar.j, a.this.g(), false);
                    HSLLogger.d("hansel_prompt_show_event:   " + hashMap.toString(), LogGroup.PT);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in onDialogShow", LogGroup.PT);
                a.this.h.clear();
            }
        }

        public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, boolean z, r rVar) {
            try {
                a.this.m = null;
                if (hashMap != null && !hashMap.containsKey("rotate")) {
                    HashMap hashMap3 = new HashMap(hashMap);
                    a.this.a(hashMap3, new HashMap<>(hashMap2), rVar);
                    HSLLogger.d("hansel_prompt_dismiss_event:   " + hashMap3, LogGroup.PT);
                    a.this.e().b();
                    if (z) {
                        HSLLogger.d("Triggering next prompt in onDialogResult.");
                        a.this.t();
                    }
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in onDialogResult", LogGroup.PT);
                a.this.m = null;
            }
        }

        public void a(boolean z, r rVar) {
            try {
                a.this.m = null;
                a.this.e().b();
                if (z) {
                    HSLLogger.d("Triggering next prompt in onDialogError.");
                    a.this.t();
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2, "Exception caught in onDialogError", LogGroup.PT);
                a.this.k();
            }
        }
    }

    public a(Context context, IMessageBroker iMessageBroker, m mVar, e0 e0Var, h hVar) {
        super(context, iMessageBroker, mVar, e0Var);
        this.g = new d(hVar);
        this.j = new io.hansel.userjourney.prompts.c(this);
    }

    private void a(FragmentTransaction fragmentTransaction, q0 q0Var) {
        if (q0Var != null) {
            fragmentTransaction.replace(R.id.frag_hsl_container_main, q0Var, q0.class.getSimpleName());
            try {
                fragmentTransaction.commitAllowingStateLoss();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
                t();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(q0 q0Var, boolean z) {
        Activity g2 = g();
        if (z) {
            if (HanselActivityLifecycleManager.getInstance().isMidTransition()) {
                this.l = null;
                return;
            } else if (g2 == null) {
                HSLLogger.d("Not displaying prompt. Activity is null");
                k();
                return;
            } else if (!q0Var.c().q() || a(q0Var.c())) {
                b(q0Var.c());
                if (!q0Var.c().H()) {
                    t();
                    return;
                }
            } else {
                l();
                return;
            }
        }
        if (!this.f5679b.a(q0Var.b(), q0Var.c())) {
            HSLLogger.d("Not showing the prompt because frequency or stop condition is not met.");
            l();
        } else if (q0Var.c().J()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Simulating nudge ");
            outline73.append(q0Var.b());
            HSLLogger.d(outline73.toString());
            q0Var.a((HashMap<String, String>) null, (HashMap<String, Object>) null);
            l();
        } else {
            q();
            q0Var.a(g2);
            a(g2, new j0().c(g2), q0Var);
        }
    }

    private Pair<String, q0> b(g gVar) {
        q0 q0Var = (q0) a(gVar.b(), gVar.a(), this.g);
        return new Pair<>(q0Var.b(), q0Var);
    }

    private void b(k kVar) {
        if (g() == null) {
            kVar.a((View) null);
            return;
        }
        j0 c2 = new j0().c(g());
        kVar.a(c2);
        if (kVar.M()) {
            String p = kVar.p();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Configuration detected Portrait:  ");
            outline73.append(c2.e());
            String sb = outline73.toString();
            LogGroup logGroup = LogGroup.PT;
            HSLLogger.d(sb, logGroup);
            View a2 = a(kVar, p);
            kVar.a(a2);
            if (a2 == null) {
                HSLLogger.d("No anchor view found for the given element identifier.", logGroup);
            } else {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Anchor view found is .");
                outline732.append(a2.getClass().getName());
                HSLLogger.d(outline732.toString(), logGroup);
                CoreJSONObject coreJSONObject = new CoreJSONObject();
                q.a(a2, coreJSONObject);
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("The attributes of the view are ");
                outline733.append(coreJSONObject.opt("x"));
                outline733.append(CMap.SPACE);
                outline733.append(coreJSONObject.opt("y"));
                outline733.append(CMap.SPACE);
                outline733.append(coreJSONObject.opt("w"));
                outline733.append(CMap.SPACE);
                outline733.append(coreJSONObject.opt(com.userexperior.e.h.f3998a));
                HSLLogger.d(outline733.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        a(this.j);
        this.l = null;
        this.m = null;
        Iterator<g> it = this.h.iterator();
        while (it.hasNext()) {
            if (!it.next().a().q()) {
                it.remove();
            }
        }
    }

    private void l() {
        q();
        t();
    }

    private Pair<String, q0> m() {
        Pair<String, q0> pair = this.m;
        if (pair != null) {
            return pair;
        }
        Pair<String, q0> pair2 = this.l;
        if (pair2 != null) {
            return pair2;
        }
        return null;
    }

    private boolean o() {
        return (this.l == null && this.m == null) ? false : true;
    }

    private void q() {
        this.h.remove(this.k);
        this.k = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r5.k = r1;
        r5.l = b(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r() {
        /*
            r5 = this;
            android.util.Pair<java.lang.String, io.hansel.userjourney.prompts.q0> r0 = r5.l
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.List<io.hansel.userjourney.prompts.g> r0 = r5.h
            java.util.Iterator r0 = r0.iterator()
        L_0x000b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            io.hansel.userjourney.prompts.g r1 = (io.hansel.userjourney.prompts.g) r1
            java.lang.String r2 = r1.b()
            io.hansel.userjourney.prompts.k r3 = r1.a()
            r5.b(r3)
            boolean r4 = r3.M()
            if (r4 == 0) goto L_0x0040
            r3.O()
            boolean r3 = r3.H()
            if (r3 == 0) goto L_0x0032
            goto L_0x0040
        L_0x0032:
            java.lang.String r1 = "Nudge "
            java.lang.String r3 = " not created. Anchor point is not visible."
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r1, r2, r3)
            io.hansel.core.logger.LogGroup r2 = io.hansel.core.logger.LogGroup.PT
            io.hansel.core.logger.HSLLogger.d(r1, r2)
            goto L_0x000b
        L_0x0040:
            r5.k = r1
            android.util.Pair r0 = r5.b(r1)
            r5.l = r0
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r0.a.r():void");
    }

    /* access modifiers changed from: private */
    public void t() {
        this.l = null;
        HSLLogger.d("HanselScreenLogging: Triggering next prompt in triggerPromptOnMain.");
        u();
    }

    private void w() {
        Pair<String, q0> pair = this.m;
        if (pair != null && ((q0) pair.second).c().F() != l.NONE) {
            b(((q0) this.m.second).c());
            b((io.hansel.userjourney.prompts.h) this.m.second);
        }
    }

    public void a() {
        this.n = false;
        if (!o() && j()) {
            u();
        }
    }

    public void a(Activity activity, j0 j0Var, q0 q0Var) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Adding non-persistent prompt with id ");
        outline73.append(q0Var.b());
        outline73.append(" to Activity.");
        HSLLogger.d(outline73.toString());
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        View findViewById = activity.findViewById(R.id.frag_hsl_container_main);
        if (findViewById != null) {
            viewGroup.removeViewInLayout(findViewById);
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.hansel_layout_frag, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) inflate.getLayoutParams();
        marginLayoutParams.width = j0Var.d();
        marginLayoutParams.height = j0Var.c();
        marginLayoutParams.setMargins(0, 0, 0, 0);
        inflate.setLayoutParams(marginLayoutParams);
        viewGroup.addView(inflate);
        a(activity.getFragmentManager().beginTransaction(), q0Var);
    }

    public void a(g gVar) {
        this.h.add(gVar);
    }

    public void a(String[] strArr) {
        if (Looper.myLooper() == this.f5678a.getMainLooper()) {
            Pair<String, q0> pair = this.m;
            if (pair != null) {
                ((q0) pair.second).a(strArr);
                return;
            }
            return;
        }
        new Handler(this.f5678a.getMainLooper()).post(new c(strArr));
    }

    public void b() {
        this.n = true;
        if (j()) {
            w();
        }
    }

    public void c(io.hansel.userjourney.prompts.h hVar) {
        this.m = Pair.create(hVar.b(), (q0) hVar);
        this.l = null;
    }

    public void d() {
        Pair<String, q0> m2 = m();
        if (m2 != null) {
            ((q0) m2.second).a((String) "prompt_screen_nav,Nudge_screen_nav", (String) null, false);
        }
        k();
    }

    public boolean h() {
        Pair<String, q0> m2 = m();
        return (m2 == null || ((q0) m2.second).c().F() == l.NONE) ? false : true;
    }

    public String n() {
        StringBuilder sb = new StringBuilder();
        for (g b2 : this.h) {
            sb.append(b2.b());
            sb.append(CMap.SPACE);
        }
        return sb.toString();
    }

    public boolean p() {
        synchronized (this.i) {
            try {
                Pair<String, q0> pair = this.m;
                if (pair == null) {
                    return false;
                }
                ((q0) pair.second).d();
                return true;
            }
        }
    }

    public void s() {
        HSLLogger.d("Showing all non-persistent nudges");
        if (!o()) {
            u();
        }
    }

    public void u() {
        if (!this.n) {
            if (Looper.myLooper() == this.f5678a.getMainLooper()) {
                v();
            } else {
                new Handler(this.f5678a.getMainLooper()).post(new C0083a());
            }
        }
    }

    public void v() {
        if (!this.h.isEmpty() && !o() && !HanselActivityLifecycleManager.getInstance().isMidTransition()) {
            try {
                Activity g2 = g();
                if (g2 == null) {
                    HSLLogger.d("Not displaying prompt. Activity is null");
                    k();
                    return;
                }
                String localClassName = g2.getLocalClassName();
                HSLLogger.d("HanselScreenLogging:      Activity:   " + localClassName + "    Screen:     " + f().a(), LogGroup.PT);
                a(this.j, g2, true);
                r();
                if (this.l == null) {
                    HSLLogger.d("No nudge found for scheduling.");
                    return;
                }
                HSLLogger.d("Entered triggerPromptOnMain method for prompt with id " + ((String) this.l.first));
                q0 q0Var = (q0) this.l.second;
                if (q0Var == null) {
                    HSLLogger.d("Error displaying nudge. Fragment is null");
                    l();
                    return;
                }
                long n2 = q0Var.c().n();
                if (n2 > 0) {
                    HSLLogger.d("HanselScreenLogging: Delaying the prompt for " + (n2 / 1000) + " seconds");
                    new Handler().postDelayed(new b(q0Var), n2);
                } else {
                    a(q0Var, false);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Some error in the process of triggering prompt", LogGroup.PT);
            }
        }
    }
}
