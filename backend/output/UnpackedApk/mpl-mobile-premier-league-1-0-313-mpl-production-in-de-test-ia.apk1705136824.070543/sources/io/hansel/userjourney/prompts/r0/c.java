package io.hansel.userjourney.prompts.r0;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.LayoutInflater;
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
import io.hansel.userjourney.n;
import io.hansel.userjourney.prompts.e0;
import io.hansel.userjourney.prompts.g;
import io.hansel.userjourney.prompts.j0;
import io.hansel.userjourney.prompts.k;
import io.hansel.userjourney.prompts.m;
import io.hansel.userjourney.prompts.r;
import io.hansel.userjourney.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;

public class c extends b implements io.hansel.segments.a {
    public final C0084c g;
    public final io.hansel.userjourney.prompts.c h;
    public final HashMap<String, Integer> i = new HashMap<>();
    public final Set<g> j = new HashSet();
    public final HashMap<String, r> k = new HashMap<>();
    public final HashMap<String, r> l = new HashMap<>();
    public final HashMap<String, r> m = new HashMap<>();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.q();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f5684a;

        public b(g gVar) {
            this.f5684a = gVar;
        }

        public void run() {
            this.f5684a.a().a(0);
            c.this.a(true, this.f5684a);
        }
    }

    /* renamed from: io.hansel.userjourney.prompts.r0.c$c  reason: collision with other inner class name */
    public class C0084c implements io.hansel.segments.b {

        /* renamed from: a  reason: collision with root package name */
        public final h f5686a;

        public C0084c(h hVar) {
            this.f5686a = hVar;
        }

        public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, io.hansel.userjourney.prompts.h hVar) {
            try {
                String b2 = hVar.b();
                int a2 = c.this.a(b2);
                if (a2 == 0) {
                    c.this.a(hVar);
                    this.f5686a.e(c.this.f5678a, b2);
                }
                c.this.i.put(b2, Integer.valueOf(a2 + 1));
                if (hashMap != null) {
                    if (a2 == 0) {
                        c.this.a(hashMap, hashMap2);
                    }
                    c.this.c(hVar);
                    LogGroup logGroup = LogGroup.PT;
                    HSLLogger.d("onDialogShow method invoked for prompt " + b2, logGroup);
                    HSLLogger.d("hansel_prompt_show_event:   " + hashMap.toString(), logGroup);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in onDialogShow", LogGroup.PT);
            }
        }

        public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, boolean z, r rVar) {
            try {
                HSLLogger.d("onDialogResult method invoked for prompt " + rVar.b(), LogGroup.PT);
                if (hashMap != null && !hashMap.containsKey("rotate")) {
                    c.this.e(rVar);
                    c cVar = c.this;
                    cVar.a(cVar.h);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in onDialogResult", LogGroup.PT);
            }
        }

        public void a(boolean z, r rVar) {
            try {
                c.this.m.remove(rVar.b());
                c.this.b(rVar);
                c cVar = c.this;
                cVar.a(cVar.h);
                HSLLogger.d("onDialogError method invoked for prompt " + rVar.b(), LogGroup.PT);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in onDialogError method ", LogGroup.PT);
            }
        }
    }

    public c(Context context, IMessageBroker iMessageBroker, m mVar, e0 e0Var, h hVar) {
        super(context, iMessageBroker, mVar, e0Var);
        this.g = new C0084c(hVar);
        this.h = new io.hansel.userjourney.prompts.c(this);
    }

    /* access modifiers changed from: private */
    public int a(String str) {
        Integer num = this.i.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private Boolean a(k kVar, Activity activity) {
        try {
            kVar.a(new j0().c(activity));
            String p = kVar.p();
            boolean z = true;
            LogGroup logGroup = LogGroup.PT;
            HSLLogger.d("Configuration detected Portrait:  " + r7.e(), logGroup);
            View a2 = a(kVar, p);
            if (a2 == null) {
                HSLLogger.d("No anchor view found for the given element identifier.", logGroup);
                z = false;
            } else {
                HSLLogger.d("Anchor view found is ." + a2.getClass().getName(), logGroup);
                q.a(a2, new CoreJSONObject());
                HSLLogger.d("The attributes of the view are " + r1.opt("x") + CMap.SPACE + r1.opt("y") + CMap.SPACE + r1.opt("w") + CMap.SPACE + r1.opt(com.userexperior.e.h.f3998a));
                kVar.a(a2);
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught while setting anchorView.", LogGroup.PT);
            return Boolean.FALSE;
        }
    }

    private void a(r rVar) {
        if (rVar == null) {
            HSLLogger.d("Hidden nudge is null.");
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Adding back hidden nudge ");
        outline73.append(rVar.b());
        HSLLogger.d(outline73.toString());
        try {
            a(rVar, g());
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught while adding back the hidden nudge.", LogGroup.PT);
        }
    }

    private void a(r rVar, Activity activity) {
        if (d(rVar, activity)) {
            c(rVar, activity);
        } else {
            d(rVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(r rVar) {
        if (!this.l.containsKey(rVar.b())) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Adding persistent nudge ");
            outline73.append(rVar.b());
            outline73.append(" to hidden state.");
            HSLLogger.d(outline73.toString());
            this.l.put(rVar.b(), rVar);
        }
    }

    private void b(r rVar, Activity activity) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Scheduling persistent nudge ");
        outline73.append(rVar.b());
        HSLLogger.d(outline73.toString());
        this.l.remove(rVar.b());
        this.m.put(rVar.b(), rVar);
        if (!a(activity, rVar)) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Moving persistent nudge ");
            outline732.append(rVar.b());
            outline732.append(" from scheduled state to hidden state.");
            HSLLogger.d(outline732.toString());
            this.m.remove(rVar.b());
            b(rVar);
        }
    }

    private boolean b(k kVar) {
        if (!kVar.M()) {
            return true;
        }
        kVar.O();
        return kVar.H();
    }

    private void c(r rVar, Activity activity) {
        if (b(rVar.i())) {
            b(rVar, activity);
        } else {
            c(rVar);
        }
    }

    private void d(r rVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Anchor view not found for nudge ");
        outline73.append(rVar.b());
        outline73.append(".");
        HSLLogger.d(outline73.toString());
        b(rVar);
    }

    private boolean d(r rVar, Activity activity) {
        return a(rVar.i(), activity).booleanValue();
    }

    private void k() {
        j0 j0Var = new j0();
        Activity g2 = g();
        j0 c2 = j0Var.c(g2);
        if (g2 != null) {
            ViewGroup viewGroup = (ViewGroup) g2.getWindow().getDecorView();
            if (((ViewGroup) viewGroup.findViewById(R.id.frag_all_tags_container_main)) == null) {
                ViewGroup viewGroup2 = (ViewGroup) g2.getLayoutInflater().inflate(R.layout.hansel_layout_tag_container, viewGroup, false);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) viewGroup2.getLayoutParams();
                marginLayoutParams.width = c2.d();
                marginLayoutParams.height = c2.c();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                viewGroup2.setLayoutParams(marginLayoutParams);
                viewGroup.addView(viewGroup2);
            }
        }
    }

    private void l() {
        this.l.clear();
        this.k.clear();
        this.m.clear();
        this.i.clear();
    }

    private void p() {
        Activity g2 = g();
        if (g2 != null) {
            ViewGroup viewGroup = (ViewGroup) g2.getWindow().getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.frag_all_tags_container_main);
            if (viewGroup2 != null) {
                viewGroup.removeView(viewGroup2);
            }
        }
    }

    private void r() {
        for (r a2 : this.l.values()) {
            a(a2);
        }
    }

    public void a() {
        r();
    }

    public void a(g gVar) {
        this.j.add(gVar);
    }

    public void a(String[] strArr) {
    }

    public boolean a(Activity activity, r rVar) {
        if (rVar.i().J()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Simulating nudge ");
            outline73.append(rVar.b());
            HSLLogger.d(outline73.toString());
            this.g.a(null, null, rVar);
            this.m.remove(rVar.b());
            return true;
        }
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Adding persistent nudge ");
        outline732.append(rVar.b());
        outline732.append(" to Activity.");
        HSLLogger.d(outline732.toString());
        ViewGroup a2 = n.a(activity);
        ViewGroup viewGroup = (ViewGroup) a2.findViewById(R.id.frag_all_tags_container_main);
        if (viewGroup == null) {
            k();
            viewGroup = (ViewGroup) a2.findViewById(R.id.frag_all_tags_container_main);
        }
        Pair<Boolean, View> a3 = rVar.a((LayoutInflater) this.f5678a.getSystemService("layout_inflater"), a2);
        a(this.h, activity, false);
        View view = (View) a3.second;
        Boolean bool = (Boolean) a3.first;
        if (view == null || !bool.booleanValue()) {
            return false;
        }
        viewGroup.addView(view);
        return true;
    }

    public boolean a(boolean z, g gVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Entered triggerNudge method for persistent nudge ");
        outline73.append(gVar.b());
        HSLLogger.d(outline73.toString());
        try {
            if (gVar.a() == null) {
                HSLLogger.d("Not showing persistent nudge. Nudge blueprint is null");
                return true;
            }
            if (!z) {
                long n = gVar.a().n();
                if (n > 0) {
                    HSLLogger.d("HanselScreenLogging: Delaying the persistent nudge for " + (n / 1000) + " seconds");
                    new Handler().postDelayed(new b(gVar), n);
                    return true;
                }
            }
            if (gVar.a().q() && !a(gVar.a())) {
                return true;
            }
            if (!this.l.containsKey(gVar.b()) && !this.k.containsKey(gVar.b())) {
                if (!this.m.containsKey(gVar.b())) {
                    Activity g2 = g();
                    if (g2 == null) {
                        HSLLogger.d("Not showing persistent nudge. Activity is null");
                        return true;
                    }
                    String name = g2.getClass().getName();
                    HSLLogger.d("HanselScreenLogging:      Activity:   " + name + "    Screen:     " + f().a() + "  delayFinished: " + z, LogGroup.PT);
                    if (HanselActivityLifecycleManager.getInstance().isMidTransition()) {
                        HSLLogger.d("Not showing persistent nudge. Activity is in the middle of a transition");
                        return false;
                    } else if (!this.f5679b.a(gVar.b(), gVar.a())) {
                        HSLLogger.d("Not showing the persistent nudge " + gVar.b() + " because frequency or stop condition is not met.");
                        return true;
                    } else {
                        a(this.h, g2, true);
                        a((r) a(gVar.b(), gVar.a(), (io.hansel.segments.b) this.g), g2);
                        return true;
                    }
                }
            }
            HSLLogger.d("Not showing persistent nudge. Nudge " + gVar.b() + " is already present");
            return true;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Error while triggering persistent nudge", LogGroup.PT);
            return true;
        }
    }

    public void b() {
        if (j()) {
            Iterator it = new HashSet(this.k.keySet()).iterator();
            while (it.hasNext()) {
                b(this.k.get((String) it.next()));
            }
            Iterator it2 = new HashSet(this.m.keySet()).iterator();
            while (it2.hasNext()) {
                b(this.m.get((String) it2.next()));
            }
        }
    }

    public void c(io.hansel.userjourney.prompts.h hVar) {
        this.m.remove(hVar.b());
        this.k.put(hVar.b(), (r) hVar);
        HSLLogger.d("Showing persistent nudge " + hVar.b());
    }

    public void c(r rVar) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Prompt ");
        outline73.append(rVar.b());
        outline73.append(" not created. Anchor point is not visible.");
        HSLLogger.d(outline73.toString(), LogGroup.PT);
        b(rVar);
    }

    public void d() {
        m();
        a(this.h);
        p();
        l();
    }

    public void e(r rVar) {
        this.k.remove(rVar.b());
        b(rVar);
    }

    public boolean h() {
        return !this.l.isEmpty() || !this.k.isEmpty() || !this.m.isEmpty();
    }

    public void m() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.k);
            hashMap.putAll(this.l);
            hashMap.putAll(this.m);
            Iterator it = new HashSet(this.k.keySet()).iterator();
            while (it.hasNext()) {
                this.k.get((String) it.next()).a((String) "prompt_screen_nav,Nudge_screen_nav", (String) null, false);
            }
            for (String str : hashMap.keySet()) {
                r rVar = (r) hashMap.get(str);
                if (a(str) > 0) {
                    a(new HashMap<>(rVar.j()), new HashMap<>(rVar.k()), rVar);
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught while dismissing all persistent nudges", LogGroup.PT);
        }
    }

    public String n() {
        StringBuilder sb = new StringBuilder("");
        for (g b2 : this.j) {
            sb.append(b2.b());
            sb.append(CMap.SPACE);
        }
        return sb.toString();
    }

    public boolean o() {
        return false;
    }

    public void q() {
        try {
            HSLLogger.d("Showing all persistent nudges");
            if (this.j.size() > 0) {
                k();
            }
            Iterator<g> it = this.j.iterator();
            while (it.hasNext()) {
                if (a(false, it.next())) {
                    it.remove();
                }
            }
            a(this.h, g(), false);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception in displaying persistent nudges ");
            outline73.append(e2.toString());
            HSLLogger.d(outline73.toString());
        }
    }

    public void s() {
        if (Looper.myLooper() == this.f5678a.getMainLooper()) {
            q();
        } else {
            new Handler(this.f5678a.getMainLooper()).post(new a());
        }
    }
}
