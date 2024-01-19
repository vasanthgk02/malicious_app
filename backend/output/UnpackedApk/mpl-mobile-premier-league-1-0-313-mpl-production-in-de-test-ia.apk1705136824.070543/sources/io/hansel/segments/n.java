package io.hansel.segments;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.utilities.k;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventData;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.security.ICrypto;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public class n {
    public static n i;

    /* renamed from: a  reason: collision with root package name */
    public Context f5275a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, m> f5276b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, Boolean> f5277c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, Object> f5278d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, ?> f5279e = null;

    /* renamed from: f  reason: collision with root package name */
    public IMessageBroker f5280f;
    public ICrypto g;
    public boolean h;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5281a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5281a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.USER_ID_CHANGED     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 40
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5281a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FILTER_CHANGED     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 43
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r0 = f5281a     // Catch:{ NoSuchFieldError -> 0x0022 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.INSERT_IPA     // Catch:{ NoSuchFieldError -> 0x0022 }
                r1 = 55
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                int[] r0 = f5281a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.FILTERS_CLEARED     // Catch:{ NoSuchFieldError -> 0x002b }
                r1 = 44
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r0 = f5281a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.APPLICATION_DID_MOVE_TO_FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                r1 = 0
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.segments.n.a.<clinit>():void");
        }
    }

    public n(Context context) {
        this.f5275a = context;
    }

    public static n a(Context context) {
        if (i == null) {
            i = new n(context);
        }
        return i;
    }

    private Set<String> a(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        int size = list.size();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet(list);
        if (size > 0) {
            this.f5278d = null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            if (HSLUtils.isSet(str)) {
                m b2 = b(str);
                if ((b2 == null || !b2.d()) ? true : !b2.a((EventData) null)) {
                    hashSet.add(str);
                    a(str, true);
                    p.a(this.f5275a, str, true);
                    this.f5277c.put(str, Boolean.TRUE);
                }
            }
        }
        Map<String, ?> d2 = p.d(this.f5275a);
        this.f5279e = d2;
        boolean z = false;
        for (Entry<String, ?> key : d2.entrySet()) {
            String str2 = (String) key.getKey();
            if (!hashSet2.contains(str2)) {
                a(str2, false);
                p.g(this.f5275a, str2);
                this.f5277c.put(str2, Boolean.FALSE);
                hashSet.add(str2);
                HSLLogger.d("Hansel Segments:Removing segments - " + str2);
                z = true;
            }
        }
        if (z) {
            this.f5279e = p.d(this.f5275a);
        }
        if (hashSet.size() > 0) {
            IMessageBroker iMessageBroker = this.f5280f;
            if (iMessageBroker != null) {
                iMessageBroker.publishBlockingEvent(EventsConstants.DIL_SEG_CHANGED.name(), hashSet);
            }
        }
        HSLLogger.d("Hansel Segments:Done with Re-evaluating segments - " + hashSet + " from " + hashSet2);
        return hashSet;
    }

    private void a() {
        this.f5277c = new HashMap<>();
        this.f5276b = new HashMap<>();
    }

    private void a(CoreJSONObject coreJSONObject) {
        try {
            HSLLogger.d("Hansel Segments: Deleting of segments", LogGroup.CS);
            CoreJSONArray jSONArray = coreJSONObject.getJSONArray(k.f4287a);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                ArrayList arrayList = new ArrayList(jSONArray.getJSONObject(i2).keySet());
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    a((String) arrayList.get(i3));
                }
            }
        } catch (CoreJSONException e2) {
            HSLLogger.w("Hansel Segments: Exception while deleting of segments", LogGroup.CS);
            HSLLogger.printStackTrace(e2);
        }
    }

    private void a(String str) {
        HSLLogger.d("Hansel Segments:Deleting segment - " + str);
        m b2 = b(str);
        HSLLogger.d("Hansel Segments:Deleting attributes - segment map for " + str);
        if (b2 != null) {
            HSLCriteriaAttributes a2 = b2.a();
            if (a2 != null) {
                p.a(this.f5275a, a2.getAttributes(), str, false);
                p.b(this.f5275a, a2.getEvents(), str, false);
                p.i(this.f5275a, str);
                p.k(this.f5275a, str);
                p.j(this.f5275a, str);
            }
        }
        HSLLogger.d("Hansel Segments:Deleting SegmentId - criteriaJson map for " + str);
        o.a(this.g).a(this.f5275a, str);
        HSLLogger.d("Hansel Segments:Deleting SegmentId - segmentValue map for " + str);
        p.h(this.f5275a, str);
    }

    private void a(String str, CoreJSONObject coreJSONObject, EventData eventData, boolean z) {
        try {
            HSLLogger.d("Hansel SegmentsUpserting segment for " + str + " with Json " + coreJSONObject);
            m b2 = b(str);
            if (!z) {
                b2 = new m(this.f5275a, str, coreJSONObject, false);
                a(str, b2);
                o.a(this.g).a(this.f5275a, str, coreJSONObject, this.h);
            }
            HSLCriteriaAttributes a2 = b2.a();
            if (a2 != null) {
                HSLLogger.d("Hansel SegmentsThe attributes for segment are " + b2.a().getAttributes());
                a(a2.getAttributes(), str);
                HSLLogger.d("Hansel SegmentsThe events for segment are " + b2.a().getEvents());
                b(a2.getEvents(), str);
                a(a2.getSubSegmentFields(), str);
                p.a(this.f5275a, b2.c(), b2.b());
                a(eventData.getSubSegmentValue(), eventData.getSubSegmentTs());
            } else if (!b2.d()) {
                return;
            }
            a(str, b2.a(eventData));
        } catch (Throwable th) {
            HSLLogger.w(GeneratedOutlineSupport.outline50("Unable to create the segment ", str), LogGroup.CS);
            HSLLogger.printStackTrace(th);
        }
    }

    private void a(String str, m mVar) {
        this.f5276b.put(str, mVar);
    }

    private void a(String str, boolean z) {
        HSLLogger.d("Hansel Segments: Updating the value of the segment " + str + " with value " + z, LogGroup.CS);
        p.a(this.f5275a, str, Boolean.valueOf(z));
    }

    private void a(HashMap<String, Set<String>> hashMap, String str) {
        p.b(this.f5275a, hashMap.keySet(), str);
        p.a(this.f5275a, hashMap);
    }

    private void a(HashMap<String, Boolean> hashMap, HashMap<String, Long> hashMap2) {
        if (hashMap != null) {
            p.c(this.f5275a, hashMap);
        }
        if (hashMap2 != null) {
            p.b(this.f5275a, hashMap2);
        }
    }

    private void a(Set<String> set, String str) {
        if (set != null) {
            p.a(this.f5275a, set, str, true);
        }
    }

    private m b(String str) {
        return this.f5276b.containsKey(str) ? this.f5276b.get(str) : o.a(this.g).c(this.f5275a, str);
    }

    private void b(CoreJSONObject coreJSONObject, EventData eventData) {
        Set<String> keySet = coreJSONObject.keySet();
        try {
            HSLLogger.d("Hansel Segments: Handling upserting of segments", LogGroup.CS);
            ArrayList arrayList = new ArrayList(keySet);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = (String) arrayList.get(i2);
                a(str, coreJSONObject.getJSONObject(str), eventData, false);
            }
        } catch (CoreJSONException e2) {
            HSLLogger.w("Hansel Segments: Exception while upserting segments", LogGroup.CS);
            HSLLogger.printStackTrace(e2);
        }
    }

    private void b(Set<String> set, String str) {
        if (set != null) {
            p.b(this.f5275a, set, str, true);
        }
    }

    private void c(CoreJSONObject coreJSONObject, EventData eventData) {
        try {
            Set<String> keySet = coreJSONObject.keySet();
            HashSet hashSet = new HashSet(b());
            HSLLogger.d("Hansel Segments: Handling upserting of segments", LogGroup.CS);
            ArrayList arrayList = new ArrayList(keySet);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = (String) arrayList.get(i2);
                a(str, coreJSONObject.getJSONObject(str), eventData, false);
                hashSet.remove(str);
            }
            ArrayList arrayList2 = new ArrayList(hashSet);
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                a((String) arrayList2.get(i3));
            }
            HSLLogger.d("Hansel Segments: Handling upserting. Number of Segments added: " + size + ", deleted: " + size2, LogGroup.CS);
        } catch (CoreJSONException e2) {
            HSLLogger.w("Hansel Segments: Exception while upserting segments", LogGroup.CS);
            HSLLogger.printStackTrace(e2);
        }
    }

    public Set<String> a(EventsConstants eventsConstants, String str) {
        return eventsConstants == EventsConstants.USER_ID_CHANGED ? o.a(this.g).a(this.f5275a) : p.c(this.f5275a, str);
    }

    public Set<String> a(Set<String> set, EventData eventData) {
        Map<String, ?> map;
        Set<String> set2 = set;
        EventData eventData2 = eventData;
        HSLLogger.d("Hansel Segments:Re-evaluating segments - " + set2);
        Map<String, ?> f2 = p.f(this.f5275a);
        Map<String, ?> k = p.k(this.f5275a);
        Map<String, ?> l = p.l(this.f5275a);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList(set2);
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = k.get((String) arrayList.get(i2));
            ArrayList arrayList2 = new ArrayList(obj == null ? new HashSet() : (HashSet) obj);
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                String str = (String) arrayList2.get(i3);
                if (str != null) {
                    int i4 = a.f5281a[eventData.getEvent().ordinal()];
                    map = k;
                    if (i4 == 1) {
                        Long l2 = (Long) l.get(str);
                        if (l2 != null) {
                            if (l2.longValue() <= -2) {
                            }
                        }
                    } else if (i4 == 2 || i4 == 3) {
                        Set set3 = (Set) f2.get(str);
                        if (set3 != null) {
                            if (!set3.contains(eventData.getData())) {
                            }
                        }
                    } else if (i4 == 4) {
                        Long l3 = (Long) l.get(str);
                        if (l3 != null) {
                            if (l3.longValue() != -2) {
                            }
                        }
                    } else if (i4 == 5) {
                        Long l4 = (Long) l.get(str);
                        if (l4 != null) {
                            if (l4.longValue() > -1) {
                                if (eventData.getTs() < l4.longValue()) {
                                }
                            }
                        }
                    }
                    hashSet2.add(str);
                } else {
                    map = k;
                }
                i3++;
                k = map;
            }
            Map<String, ?> map2 = k;
        }
        this.f5278d = null;
        eventData2.setSubSegIds(hashSet2);
        eventData2.setValuesMap(p.m(this.f5275a));
        ArrayList arrayList3 = new ArrayList(set2);
        int size3 = arrayList.size();
        for (int i5 = 0; i5 < size3; i5++) {
            String str2 = (String) arrayList3.get(i5);
            boolean c2 = c(str2);
            m b2 = b(str2);
            if (b2 != null) {
                boolean a2 = b2.a(eventData2);
                a(str2, a2);
                a(eventData.getSubSegmentValue(), eventData.getSubSegmentTs());
                this.f5277c.put(str2, Boolean.valueOf(a2));
                if (a2 != c2) {
                    hashSet.add(str2);
                }
            }
        }
        HSLLogger.d("Hansel Segments:Done with Re-evaluating segments - " + set2);
        return hashSet;
    }

    public void a(CoreJSONObject coreJSONObject, EventData eventData) {
        HSLLogger.d("Hansel Segments: Handling segments response of get Data");
        a(this.f5275a).a();
        try {
            if (coreJSONObject.getJSONObject("d").getBoolean(ChannelPipelineCoverage.ALL)) {
                HSLLogger.d("Hansel Segments: Handling deleting of all segments", LogGroup.CS);
                c(coreJSONObject.getJSONObject("up"), eventData);
                return;
            }
            a(coreJSONObject.getJSONObject("d"));
            b(coreJSONObject.getJSONObject("up"), eventData);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public void a(IMessageBroker iMessageBroker, ICrypto iCrypto, Boolean bool) {
        this.f5280f = iMessageBroker;
        this.g = iCrypto;
        this.h = bool.booleanValue();
    }

    public void a(String str, CoreJSONObject coreJSONObject, EventData eventData) {
        o.a(this.g).b(this.f5275a, str, coreJSONObject, this.h);
        a(str, coreJSONObject, eventData, true);
    }

    public Set<String> b() {
        return o.a(this.g).a(this.f5275a);
    }

    public synchronized void b(List<String> list) {
        HSLLogger.d("Hansel Sub Segments: Handling sub segments set by smartech", LogGroup.CS);
        try {
            a(list);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return;
    }

    public HashMap<String, Object> c() {
        if (this.f5278d == null) {
            this.f5278d = HSLFiltersInternal.getInstance().getAllFilters();
        }
        return this.f5278d;
    }

    public boolean c(String str) {
        if (this.f5277c.containsKey(str)) {
            Boolean bool = this.f5277c.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        Boolean b2 = p.b(this.f5275a, str);
        this.f5277c.put(str, b2);
        return b2.booleanValue();
    }

    public Set<String> d(String str) {
        return p.d(this.f5275a, str);
    }
}
