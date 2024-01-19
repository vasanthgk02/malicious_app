package io.hansel.userjourney;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventData;
import io.hansel.core.module.EventsConstants;
import io.hansel.segments.n;
import io.hansel.userjourney.models.PromptGoalEventInfo;
import io.hansel.userjourney.models.c;
import io.hansel.userjourney.models.d;
import io.hansel.userjourney.models.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import sfs2x.client.requests.CreateRoomRequest;

public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f5422c;

    /* renamed from: d  reason: collision with root package name */
    public static long f5423d;

    /* renamed from: a  reason: collision with root package name */
    public Context f5424a;

    /* renamed from: b  reason: collision with root package name */
    public Pair<HashSet<String>, HashSet<String>> f5425b = new Pair<>(new HashSet(), new HashSet());

    public e(Context context) {
        this.f5424a = context;
    }

    public static e a(Context context) {
        if (f5422c == null) {
            synchronized (e.class) {
                try {
                    if (f5422c == null) {
                        f5422c = new e(context);
                    }
                }
            }
        }
        return f5422c;
    }

    private String a(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(";");
        }
        return sb.toString();
    }

    private void a(d dVar, String str) {
        p.A(this.f5424a, dVar.c());
        HashMap<String, HashMap<String, PromptGoalEventInfo>> b2 = j.b(this.f5424a, str);
        if (b2 != null) {
            for (String b3 : b2.keySet()) {
                j.b(this.f5424a, b3, str);
            }
        }
        j.c(this.f5424a, str);
    }

    private void a(f fVar, d dVar) {
        String d2 = dVar.d();
        p.I(this.f5424a, d2);
        ArrayList arrayList = new ArrayList(fVar.k());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            p.k(this.f5424a, (String) arrayList.get(i), d2);
        }
        p.M(this.f5424a, d2);
        ArrayList arrayList2 = new ArrayList(fVar.a().keySet());
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            p.E(this.f5424a, (String) arrayList2.get(i2));
        }
        p.B(this.f5424a, d2);
        p.a(this.f5424a, fVar.g().keySet());
        p.J(this.f5424a, d2);
        p.K(this.f5424a, d2);
    }

    private void a(f fVar, d dVar, CoreJSONObject coreJSONObject) {
        String d2 = dVar.d();
        b(fVar, dVar);
        p.b(this.f5424a, d2, dVar.c());
        p.g(this.f5424a, d2, dVar.e());
        p.a(this.f5424a, d2, coreJSONObject);
        p.a(this.f5424a, d2);
        Set<String> a2 = dVar.a();
        Set<c> b2 = dVar.b();
        p.a(this.f5424a, d2, a2);
        a(b2, d2, false);
    }

    private void a(f fVar, d dVar, h hVar) {
        String d2 = dVar.d();
        a(fVar, dVar);
        p.D(this.f5424a, d2);
        p.H(this.f5424a, d2);
        Set<c> b2 = dVar.b();
        a(d2);
        if (b2 != null) {
            for (c next : b2) {
                String c2 = next.c();
                ArrayList arrayList = new ArrayList();
                arrayList.add(d2);
                CoreJSONObject a2 = next.a();
                CoreJSONObject d3 = next.d();
                if (a2 != null) {
                    arrayList.add(a2.toString());
                }
                if (d3 != null) {
                    arrayList.add(d3.toString());
                }
                p.j(this.f5424a, c2, a(arrayList));
            }
        }
        p.C(this.f5424a, d2);
        a(dVar, d2);
        hVar.b(this.f5424a, d2);
    }

    private void a(String str, f fVar) {
        Set<String> j = fVar.j();
        Set<c> i = fVar.i();
        p.d(this.f5424a, str, j);
        a(i, str, true);
    }

    private void a(Set<c> set, String str, boolean z) {
        if (set != null) {
            for (c next : set) {
                String c2 = next.c();
                p.a(this.f5424a, next.b(), next.c());
                ArrayList arrayList = new ArrayList();
                CoreJSONObject d2 = next.d();
                arrayList.add(str);
                CoreJSONObject a2 = next.a();
                if (a2 != null) {
                    arrayList.add(a2.toString());
                }
                if (d2 != null) {
                    arrayList.add(d2.toString());
                }
                String a3 = a(arrayList);
                Context context = this.f5424a;
                if (z) {
                    p.f(context, c2, a3);
                } else {
                    p.e(context, c2, a3);
                }
            }
        }
    }

    private void b(f fVar, d dVar) {
        String d2 = dVar.d();
        p.h(this.f5424a, d2, fVar.c());
        Set<String> k = fVar.k();
        p.e(this.f5424a, d2, k);
        ArrayList arrayList = new ArrayList(k);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            p.d(this.f5424a, (String) arrayList.get(i), d2);
        }
        HashMap<String, Object> a2 = fVar.a();
        ArrayList arrayList2 = new ArrayList(a2.keySet());
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            p.c(this.f5424a, (String) arrayList2.get(i2), d2);
        }
        p.a(this.f5424a, a2, d2);
        HashMap<String, String> g = fVar.g();
        HashMap<String, String> e2 = fVar.e();
        a(this.f5424a, fVar.l());
        p.a(this.f5424a, g);
        p.a(this.f5424a, fVar.d());
        ((HashSet) this.f5425b.second).addAll(e2.keySet());
        p.b(this.f5424a, d2, e2.keySet());
        p.c(this.f5424a, d2, (Set<String>) fVar.h());
        ((HashSet) this.f5425b.first).addAll(fVar.b());
        b(d2, fVar);
        a(d2, fVar);
    }

    private void b(String str, f fVar) {
        j.a(this.f5424a, str, fVar.f());
        for (String a2 : fVar.f().keySet()) {
            j.a(this.f5424a, a2, str);
        }
    }

    public long a() {
        return f5423d;
    }

    public Pair<HashSet<String>, HashSet<String>> a(String str, String str2, CoreJSONObject coreJSONObject, h hVar) {
        p.a(this.f5424a, str, coreJSONObject);
        d a2 = g.a(str, str2, coreJSONObject, this.f5424a);
        io.hansel.userjourney.r.f f2 = a2 == null ? null : a2.f();
        if (f2 == null) {
            HSLLogger.w(GeneratedOutlineSupport.outline50("Unable to create tree for journeyId", str), LogGroup.CJ);
        } else {
            a(new f(this.f5424a, f2.a(str, str2), str, hVar), a2, coreJSONObject);
        }
        return this.f5425b;
    }

    public void a(long j) {
        f5423d = j;
    }

    public void a(Context context, HashMap<String, CoreJSONObject> hashMap) {
        EventData eventData = new EventData(EventsConstants.GET_DATA_JOURNS, null, a(context).a());
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                n.a(context).a(next, hashMap.get(next), eventData);
            }
        }
    }

    public void a(h hVar) {
        HSLLogger.d("Deleting data for all journeys", LogGroup.CJ);
        Set<String> d2 = p.d(this.f5424a);
        HSLLogger.d("All journeys at this point are " + d2);
        ArrayList arrayList = new ArrayList(d2);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a((String) arrayList.get(i), (String) null, hVar);
        }
        p.l(this.f5424a);
        HSLLogger.d("Finished deleting data for all journeys.", LogGroup.CJ);
    }

    public void a(String str) {
        for (String G : p.w(this.f5424a, str)) {
            p.G(this.f5424a, G);
        }
        p.L(this.f5424a, str);
    }

    public void a(String str, String str2, h hVar) {
        String outline50 = GeneratedOutlineSupport.outline50("Deleting data for journey: ", str);
        LogGroup logGroup = LogGroup.CJ;
        HSLLogger.d(outline50, logGroup);
        CoreJSONObject k = p.k(this.f5424a, str);
        if (k == null) {
            HSLLogger.w("Unable to journey json fo journey with id " + str, logGroup);
            return;
        }
        io.hansel.userjourney.r.f fVar = new io.hansel.userjourney.r.f(p.f(this.f5424a, str), null, k.optJSONObject("dt"), this.f5424a);
        d dVar = new d(str, k.optString("jh"), fVar, k.optJSONArray(CreateRoomRequest.KEY_EVENTS), k.optString("jn"));
        a(new f(this.f5424a, fVar.a(str, str2), str, hVar), dVar, hVar);
    }

    public HashMap<String, String> b() {
        Set<String> d2 = p.d(this.f5424a);
        HashMap<String, String> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList(d2);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            hashMap.put(str, p.m(this.f5424a, str));
        }
        return hashMap;
    }

    public Set<String> b(String str, String str2, h hVar) {
        try {
            LogGroup logGroup = LogGroup.CJ;
            HSLLogger.d("Evaluating journey:" + str, logGroup);
            CoreJSONObject k = p.k(this.f5424a, str);
            if (k == null) {
                HSLLogger.w("Unable to create tree for journeyId" + str, logGroup);
                return new HashSet();
            }
            io.hansel.userjourney.r.f fVar = new io.hansel.userjourney.r.f(p.f(this.f5424a, str), p.n(this.f5424a, str), k.getJSONObject("dt"), this.f5424a);
            d dVar = new d(str, k.optString("jh"), fVar, k.optJSONArray(CreateRoomRequest.KEY_EVENTS), k.optString("jn"));
            f fVar2 = new f(this.f5424a, fVar.a(str, str2), str, hVar);
            ArrayList arrayList = new ArrayList(fVar2.k());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                p.k(this.f5424a, (String) arrayList.get(i), str);
            }
            Context context = this.f5424a;
            p.a(context, p.s(context, str));
            p.J(this.f5424a, str);
            p.K(this.f5424a, str);
            p.B(this.f5424a, str);
            b(fVar2, dVar);
            HSLLogger.d("Finished re-evaluating journey:" + str + " with leafnode Id " + fVar2.c(), LogGroup.CJ);
            return (Set) this.f5425b.first;
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }
}
