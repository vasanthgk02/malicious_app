package io.hansel.userjourney;

import android.content.Context;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.GetDataStatusListener;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.segments.k;
import io.hansel.ujmtracker.e;
import io.hansel.userjourney.models.PromptGoalEventCriteriaInfo;
import io.hansel.userjourney.models.PromptGoalEventInfo;
import io.hansel.userjourney.models.b;
import io.hansel.userjourney.prompts.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f extends e implements GetDataStatusListener {

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<io.hansel.userjourney.models.e>> f5426b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f5427c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, String> f5428d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public Set<String> f5429e;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f5430f = new HashMap<>();
    public Boolean g = Boolean.FALSE;
    public HashMap<String, ArrayList<String>> h = new HashMap<>();
    public HashMap<String, String> i = new HashMap<>();
    public HashMap<String, String> j = new HashMap<>();
    public Set<String> k;
    public HashMap<String, String> l = new HashMap<>();
    public HashMap<String, Set<String>> m;
    public HashMap<String, HashMap<String, HashMap<String, PromptGoalEventInfo>>> n = new HashMap<>();
    public HashMap<String, ?> o = new HashMap<>();
    public k p = new k();

    public f(Context context) {
        super(context);
    }

    private String a(Context context, String str, String str2) {
        String str3;
        String a2 = b.a(str, str2);
        if (this.f5430f.containsKey(a2)) {
            str3 = this.f5430f.get(a2);
        } else {
            str3 = p.e(context, a2);
            if (str3 == null) {
                return null;
            }
            this.f5430f.put(str3, a2);
        }
        return str3;
    }

    private String a(String str) {
        String str2;
        String str3;
        String outline50 = GeneratedOutlineSupport.outline50("Getting hansel data for journey ", str);
        LogGroup logGroup = LogGroup.CJ;
        HSLLogger.d(outline50, logGroup);
        if (this.f5428d.containsKey(str)) {
            str2 = this.f5428d.get(str);
        } else {
            str2 = p.f(this.f5317a, str);
            this.f5428d.put(str, str2);
        }
        if (this.f5427c.containsKey(str)) {
            str3 = this.f5427c.get(str);
        } else {
            str3 = p.m(this.f5317a, str);
            this.f5427c.put(str, str3);
        }
        HSLLogger.d(GeneratedOutlineSupport.outline54("Hansel data for journey ", str, " is ", str2, str3), logGroup);
        return str2 + str3;
    }

    private String a(String str, String str2) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyEventsSource: tempEventHashIdMap in getEventIdFromCache is ");
        outline73.append(this.l);
        HSLLogger.d(outline73.toString(), LogGroup.GT);
        return this.l.get(b.a(str, str2));
    }

    private Set<String> a(io.hansel.userjourney.models.e eVar) {
        HashSet hashSet = new HashSet();
        HSLCriteriaAttributes b2 = eVar.b();
        if (b2 != null) {
            hashSet.addAll(b2.getAllRuleFields());
        }
        hashSet.addAll(eVar.a());
        return hashSet;
    }

    private Set<String> a(String str, String str2, Map<String, Object> map, Set<String> set) {
        Set<String> set2 = set;
        try {
            String a2 = b.a(str, str2);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            if (this.g.booleanValue()) {
                HashMap<String, Set<String>> hashMap = this.m;
                if (hashMap != null) {
                    Set<String> set3 = hashMap.get(a2);
                    if (set3 != null) {
                        for (String str3 : set3) {
                            HashMap<String, PromptGoalEventInfo> a3 = this.p.a(a2, this.n.get(str3), this.o);
                            for (String next : a3.keySet()) {
                                a(a3.get(next), next, str3, hashSet3, hashSet2, hashSet, map);
                                a3 = a3;
                            }
                        }
                    }
                }
            } else {
                Set<String> a4 = j.a(this.f5317a, a2);
                if (a4 != null) {
                    for (String next2 : a4) {
                        HashMap<String, PromptGoalEventInfo> a5 = this.p.a(this.f5317a, next2, a2);
                        for (String next3 : a5.keySet()) {
                            a(a5.get(next3), next3, next2, hashSet3, hashSet2, hashSet, map);
                            a5 = a5;
                        }
                    }
                }
            }
            a(set2, (Set<String>) hashSet2, this.g.booleanValue());
            a(set2, (Set<String>) hashSet3);
            return hashSet;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return new HashSet();
        }
    }

    private Set<String> a(String str, String str2, Set<String> set, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (this.g.booleanValue()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyEventsSource: tempEventIdJourneyInfoListMap in getEventData is ");
            outline73.append(this.h);
            HSLLogger.d(outline73.toString(), LogGroup.GT);
            String a2 = a(str, str2);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList2 = this.h.get(a2);
            if (arrayList2 == null || arrayList2.isEmpty()) {
                return null;
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(c((String) it.next()));
            }
        } else {
            String a3 = a(this.f5317a, str, str2);
            if (a3 == null) {
                return null;
            }
            if (this.f5426b.containsKey(a3)) {
                arrayList = this.f5426b.get(a3);
            } else {
                Set<String> i2 = p.i(this.f5317a, a3);
                i2.addAll(p.j(this.f5317a, a3));
                for (String c2 : i2) {
                    arrayList.add(c(c2));
                }
                this.f5426b.put(a3, arrayList);
            }
            if (arrayList == null) {
                return null;
            }
        }
        return a(arrayList, map, set, this.g.booleanValue());
    }

    private Set<String> a(ArrayList<io.hansel.userjourney.models.e> arrayList, Map<String, Object> map, Set<String> set, boolean z) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<io.hansel.userjourney.models.e> it = arrayList.iterator();
        while (it.hasNext()) {
            io.hansel.userjourney.models.e next = it.next();
            String c2 = next.c();
            HSLCriteriaAttributes b2 = next.b();
            boolean z2 = false;
            if (b2 == null || b2.getHslCriteriaNode().evaluateFromMap(map)) {
                z2 = true;
            }
            if (z2) {
                hashSet2.add(c2);
                hashSet.addAll(a(next));
            }
        }
        a(set, (Set<String>) hashSet2, z);
        return hashSet;
    }

    private void a(PromptGoalEventInfo promptGoalEventInfo, String str, String str2, Set<String> set, Set<String> set2, Set<String> set3, Map<String, Object> map) {
        if (promptGoalEventInfo != null) {
            try {
                for (PromptGoalEventCriteriaInfo next : promptGoalEventInfo.getPromptEventCriteriaInfoSet()) {
                    HSLCriteriaAttributes criteriaAttributes = next.getCriteriaAttributes();
                    boolean z = true;
                    if (criteriaAttributes != null && !criteriaAttributes.getHslCriteriaNode().evaluateFromMap(map)) {
                        z = false;
                    }
                    if (z) {
                        set2.add(str2);
                        set.add(str);
                        set3.addAll(next.getPropertiesToKeep());
                    }
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    private void a(Set<String> set, Set<String> set2) {
        for (String b2 : set2) {
            set.add(h0.b(b2));
        }
    }

    private void a(Set<String> set, Set<String> set2, boolean z) {
        for (String next : set2) {
            set.add(z ? b(next) : a(next));
        }
    }

    private String b(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyEventsSource: tempJourneyIdJourneyHashMap in getHanselDataForJourneyFromCache is ");
        outline73.append(this.j);
        String sb = outline73.toString();
        LogGroup logGroup = LogGroup.GT;
        HSLLogger.d(sb, logGroup);
        HSLLogger.d("JourneyEventsSource: tempJourneyIdLeafNodeIdMap in getHanselDataForJourneyFromCache is " + this.i, logGroup);
        String str2 = this.j.get(str);
        if (str2 == null) {
            return null;
        }
        String str3 = this.i.get(str);
        if (str3 == null) {
            return null;
        }
        return GeneratedOutlineSupport.outline50(str2, str3);
    }

    public static io.hansel.userjourney.models.e c(String str) {
        HSLCriteriaAttributes hSLCriteriaAttributes;
        String[] split = str.split(";");
        int length = split.length;
        String str2 = split[0];
        CoreJSONObject coreJSONObject = null;
        if (length > 1) {
            try {
                hSLCriteriaAttributes = HSLCriteriaBuilder.build("", new CoreJSONObject(split[1]), null, new HSLCriteriaAttributes(), true, null);
            } catch (Exception e2) {
                e = e2;
                hSLCriteriaAttributes = null;
                HSLLogger.e(e.toString());
                return new io.hansel.userjourney.models.e(str2, hSLCriteriaAttributes, coreJSONObject);
            }
        } else {
            hSLCriteriaAttributes = null;
        }
        if (length > 2) {
            try {
                coreJSONObject = new CoreJSONObject(split[2]);
            } catch (Exception e3) {
                e = e3;
                HSLLogger.e(e.toString());
                return new io.hansel.userjourney.models.e(str2, hSLCriteriaAttributes, coreJSONObject);
            }
        }
        return new io.hansel.userjourney.models.e(str2, hSLCriteriaAttributes, coreJSONObject);
    }

    public Pair<ArrayList<String>, Set<String>> a(String str, String str2, Map<String, Object> map) {
        try {
            HashSet hashSet = new HashSet();
            Set<String> a2 = a(str, str2, (Set<String>) hashSet, map);
            Set<String> a3 = a(str, str2, map, (Set<String>) hashSet);
            if (a2 == null) {
                a2 = new HashSet<>();
            }
            a2.addAll(a3);
            return Pair.create(new ArrayList(hashSet), a2);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return Pair.create(new ArrayList(), new HashSet());
        }
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        int i2 = 0;
        if (this.g.booleanValue()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyEventsSource: tempAllJourneys in getHanselDataForAllJourneys is ");
            outline73.append(this.k);
            HSLLogger.d(outline73.toString(), LogGroup.GT);
            if (this.k == null) {
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(this.k);
            while (i2 < arrayList2.size()) {
                arrayList.add(b((String) arrayList2.get(i2)));
                i2++;
            }
        } else {
            if (this.f5429e == null) {
                this.f5429e = p.d(this.f5317a);
            }
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("All Journey present at this time are ");
            outline732.append(this.f5429e);
            HSLLogger.d(outline732.toString(), LogGroup.CJ);
            ArrayList arrayList3 = new ArrayList(this.f5429e);
            int size = arrayList3.size();
            while (i2 < size) {
                arrayList.add(a((String) arrayList3.get(i2)));
                i2++;
            }
        }
        return arrayList;
    }

    public void b() {
        this.f5426b = new HashMap<>();
        this.f5427c = new HashMap<>();
        this.f5428d = new HashMap<>();
        this.f5429e = null;
        this.f5430f = new HashMap<>();
        this.m = null;
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }

    public void b(String str, String str2) {
        this.f5427c.put(str, str2);
    }

    public void onGetDataFinished() {
        HSLLogger.d("JourneyEventsSource: onGetDataFinished method begin.", LogGroup.GT);
        this.g = Boolean.FALSE;
    }

    public void onGetDataStarted() {
        HSLLogger.d("JourneyEventsSource: onGetDataStarted method begin.", LogGroup.GT);
        this.k = p.d(this.f5317a);
        this.j = new HashMap<>();
        this.i = new HashMap<>();
        Set<String> set = this.k;
        if (set != null) {
            for (String next : set) {
                String f2 = p.f(this.f5317a, next);
                this.i.put(next, p.m(this.f5317a, next));
                this.j.put(next, f2);
                HashMap<String, HashMap<String, PromptGoalEventInfo>> b2 = j.b(this.f5317a, next);
                if (b2 != null) {
                    this.n.put(next, b2);
                }
            }
        }
        this.h = p.g(this.f5317a);
        for (Entry next2 : p.i(this.f5317a).entrySet()) {
            if (this.h.containsKey(next2.getKey())) {
                this.h.get(next2.getKey()).addAll((Collection) next2.getValue());
            } else {
                this.h.put(next2.getKey(), next2.getValue());
            }
        }
        this.l = p.f(this.f5317a);
        this.m = j.b(this.f5317a);
        this.o = new HashMap<>(k.a(this.f5317a));
        this.g = Boolean.TRUE;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JourneyEventsSource: tempAllJourneys in onGetDataStarted is ");
        outline73.append(this.k);
        String sb = outline73.toString();
        LogGroup logGroup = LogGroup.GT;
        HSLLogger.d(sb, logGroup);
        HSLLogger.d("JourneyEventsSource: tempJourneyIdJourneyHashMap in onGetDataStarted is " + this.j, logGroup);
        HSLLogger.d("JourneyEventsSource: tempJourneyIdLeafNodeIdMap in onGetDataStarted is " + this.i, logGroup);
        HSLLogger.d("JourneyEventsSource: tempEventIdJourneyInfoListMap in onGetDataStarted is " + this.h, logGroup);
        HSLLogger.d("JourneyEventsSource: tempEventHashIdMap in onGetDataStarted is " + this.l, logGroup);
        HSLLogger.d("JourneyEventsSource: onGetDataStarted method end.", logGroup);
    }
}
