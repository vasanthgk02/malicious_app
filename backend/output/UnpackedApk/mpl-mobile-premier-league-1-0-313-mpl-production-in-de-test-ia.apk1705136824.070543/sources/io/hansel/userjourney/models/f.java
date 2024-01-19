package io.hansel.userjourney.models;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.userjourney.h;
import io.hansel.userjourney.prompts.j;
import io.hansel.userjourney.r.a;
import io.hansel.userjourney.r.a.C0085a;
import io.hansel.userjourney.r.b;
import io.hansel.userjourney.r.c;
import io.hansel.userjourney.r.d;
import io.hansel.userjourney.r.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, HashMap<String, PromptGoalEventInfo>> f5458a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public String f5459b = "";

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Object> f5460c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f5461d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, String> f5462e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, CoreJSONObject> f5463f = new HashMap<>();
    public TreeSet<j> g = new TreeSet<>();
    public HashSet<String> h = new HashSet<>();
    public Set<String> i = new HashSet();
    public Set<String> j = new HashSet();
    public final Set<CoreJSONArray> k = new HashSet();

    public f(Context context, List<c> list, String str, h hVar) {
        List<c> list2 = list;
        String str2 = str;
        HSLLogger.d("Started creating journeyValue object with id " + str2);
        int size = list2 == null ? 0 : list.size();
        HSLLogger.d("The number of nodes in branch is " + size);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list2.get(i2);
            ArrayList<a> a2 = cVar.a();
            int size2 = a2 == null ? 0 : a2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                a(context, str, a2.get(i3), hashMap, hVar);
            }
            if (cVar instanceof b) {
                a(((b) cVar).c());
            } else if (cVar instanceof e) {
                a((e) cVar, hashMap);
            } else if (cVar instanceof d) {
                this.f5459b = ((d) cVar).c();
            } else {
                HSLLogger.w("JourneyValue: Not of any three node types.", LogGroup.CJ);
            }
            HSLLogger.d("In the journey " + str2 + " the node at " + i2 + " is " + cVar.getClass().getName());
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("Created journeyValue object with id ", str2, " and leafNodeId ");
        outline80.append(this.f5459b);
        HSLLogger.d(outline80.toString());
    }

    private c a(CoreJSONObject coreJSONObject) {
        c cVar = new c(coreJSONObject.optString("id"), coreJSONObject.optString("nm"), coreJSONObject.optString("ven"), coreJSONObject.optJSONObject(HSLCriteriaBuilder.CRITERIA), coreJSONObject.optJSONObject("type"));
        return cVar;
    }

    private void a(Context context, String str, a aVar, HashMap<String, Set<PromptGoalEventCriteriaInfo>> hashMap, h hVar) {
        ArrayList<C0085a> a2 = aVar.a();
        int size = a2 == null ? 0 : a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0085a aVar2 = a2.get(i2);
            if (aVar2 instanceof a.b) {
                this.f5460c.putAll(((a.b) aVar2).a());
            } else if (aVar2 instanceof a.c) {
                a.c cVar = (a.c) aVar2;
                this.f5461d.putAll(cVar.f());
                this.f5462e.putAll(cVar.c());
                this.f5463f.putAll(cVar.h());
                this.g.addAll(cVar.b());
                this.h.addAll(cVar.g());
                this.j.addAll(cVar.a());
                g d2 = cVar.d();
                for (Entry next : hashMap.entrySet()) {
                    d2.a((String) next.getKey(), (Set) next.getValue());
                }
                for (String next2 : d2.c().keySet()) {
                    if (!this.f5458a.containsKey(next2)) {
                        this.f5458a.put(next2, new HashMap());
                    }
                    this.f5458a.get(next2).put(cVar.e(), new PromptGoalEventInfo(d2.a(), d2.c().get(next2)));
                }
                hVar.b(context, cVar.e(), str);
            }
        }
    }

    private void a(g gVar) {
        CoreJSONArray b2 = gVar.b();
        if (b2 != null) {
            this.k.add(b2);
        }
    }

    private void a(g gVar, HashMap<String, Set<PromptGoalEventCriteriaInfo>> hashMap) {
        HashMap<String, Set<PromptGoalEventCriteriaInfo>> c2 = gVar.c();
        if (hashMap.isEmpty()) {
            hashMap.putAll(c2);
            return;
        }
        for (Entry next : c2.entrySet()) {
            if (!hashMap.containsKey(next.getKey())) {
                hashMap.put(next.getKey(), new HashSet());
            }
            hashMap.get(next.getKey()).addAll((Collection) next.getValue());
        }
    }

    private void a(e eVar, HashMap<String, Set<PromptGoalEventCriteriaInfo>> hashMap) {
        g c2 = eVar.c();
        a(c2);
        if (eVar.d()) {
            a(c2, hashMap);
        }
    }

    private void a(List<a> list) {
        int size = list == null ? 0 : list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.i.add(list.get(i2).b());
        }
    }

    public HashMap<String, Object> a() {
        return this.f5460c;
    }

    public Set<String> b() {
        return this.j;
    }

    public String c() {
        return this.f5459b;
    }

    public TreeSet<j> d() {
        return this.g;
    }

    public HashMap<String, String> e() {
        return this.f5462e;
    }

    public HashMap<String, HashMap<String, PromptGoalEventInfo>> f() {
        return this.f5458a;
    }

    public HashMap<String, String> g() {
        return this.f5461d;
    }

    public HashSet<String> h() {
        return this.h;
    }

    public Set<c> i() {
        HashSet hashSet = new HashSet();
        for (CoreJSONArray next : this.k) {
            for (int i2 = 0; i2 < next.length(); i2++) {
                try {
                    hashSet.add(a(next.optJSONObject(i2)));
                } catch (Exception e2) {
                    HSLLogger.printStackTrace(e2, "Error creating rollout node goal event", LogGroup.PT);
                }
            }
        }
        return hashSet;
    }

    public Set<String> j() {
        HashSet hashSet = new HashSet();
        for (CoreJSONArray next : this.k) {
            for (int i2 = 0; i2 < next.length(); i2++) {
                try {
                    CoreJSONObject optJSONObject = next.optJSONObject(i2);
                    if (!(optJSONObject == null || optJSONObject.optString("id") == null)) {
                        hashSet.add(optJSONObject.optString("id"));
                    }
                } catch (Exception e2) {
                    HSLLogger.printStackTrace(e2, "Error adding rollout node goal IDs", LogGroup.PT);
                }
            }
        }
        return hashSet;
    }

    public Set<String> k() {
        return this.i;
    }

    public HashMap<String, CoreJSONObject> l() {
        return this.f5463f;
    }
}
