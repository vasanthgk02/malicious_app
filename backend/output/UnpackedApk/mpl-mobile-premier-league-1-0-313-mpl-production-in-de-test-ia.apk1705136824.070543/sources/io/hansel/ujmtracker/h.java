package io.hansel.ujmtracker;

import android.content.Context;
import android.os.HandlerThread;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.ujmtracker.m.a.C0081a;
import io.hansel.ujmtracker.m.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public class h {
    public static final h k = new h();
    public static Set<String> l = new HashSet(Arrays.asList(new String[]{"prompt_btn1", "prompt_btn2", "prompt_btn3", "prompt_btnx", "prompt_backdrop", "prompt_screen_nav", "prompt_selfDestruct"}));
    public static Set<String> m = new HashSet(Arrays.asList(new String[]{"prompt_rating", "prompt_nps", "hsl_counter", "time_spent"}));

    /* renamed from: a  reason: collision with root package name */
    public HSLSDKIdentifiers f5321a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5322b;

    /* renamed from: c  reason: collision with root package name */
    public HSLTaskHandler f5323c;

    /* renamed from: d  reason: collision with root package name */
    public f f5324d = new f();

    /* renamed from: e  reason: collision with root package name */
    public io.hansel.ujmtracker.m.h f5325e;

    /* renamed from: f  reason: collision with root package name */
    public io.hansel.ujmtracker.m.a f5326f;
    public HSLTrackerModule g;
    public boolean h = false;
    public List<io.hansel.userjourney.models.b> i = new ArrayList();
    public d j;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                h.this.f5326f.a(h.this.f5325e);
                h.this.f();
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5328a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5329b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f5330c;

        public b(String str, String str2, HashMap hashMap) {
            this.f5328a = str;
            this.f5329b = str2;
            this.f5330c = hashMap;
        }

        public void run() {
            try {
                h.this.f(this.f5328a, this.f5329b, this.f5330c);
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5332a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5333b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f5334c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HanselEventDataListener f5335d;

        public c(String str, String str2, HashMap hashMap, HanselEventDataListener hanselEventDataListener) {
            this.f5332a = str;
            this.f5333b = str2;
            this.f5334c = hashMap;
            this.f5335d = hanselEventDataListener;
        }

        public void run() {
            io.hansel.userjourney.models.b b2;
            try {
                b2 = h.this.a(this.f5332a, this.f5333b, this.f5334c);
                h.this.b(b2);
                HashMap a2 = h.this.a(this.f5332a, this.f5334c, this.f5333b);
                HanselEventDataListener hanselEventDataListener = this.f5335d;
                if (hanselEventDataListener != null) {
                    hanselEventDataListener.onEvent(this.f5332a, this.f5333b, a2);
                }
            } catch (Throwable th) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception caught while evaluating in background for event ");
                outline73.append(this.f5332a);
                outline73.append(" vendor ");
                outline73.append(this.f5333b);
                HSLLogger.printStackTrace(th, outline73.toString(), LogGroup.PT);
                return;
            }
            h.this.c(b2);
        }
    }

    public class d extends io.hansel.ujmtracker.m.h {
        public d(Context context, String str, String str2, i iVar) {
            super(context, str, str2, iVar);
        }

        public io.hansel.ujmtracker.m.d b(io.hansel.ujmtracker.m.d dVar) {
            try {
                io.hansel.ujmtracker.m.d a2 = h.this.a(dVar);
                h.this.f();
                return a2;
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
                return null;
            }
        }
    }

    public class e implements d {
        public e() {
        }

        public void a(String str, String str2, HashMap<String, Object> hashMap) {
            h.this.e(str, str2, hashMap);
            h.this.e();
        }
    }

    public h() {
        new HandlerThread("events").start();
        this.j = new e();
    }

    public static h a() {
        return k;
    }

    /* access modifiers changed from: private */
    public io.hansel.ujmtracker.m.d a(io.hansel.ujmtracker.m.d dVar) {
        if (dVar != null) {
            dVar.a((Object) (io.hansel.ujmtracker.n.a) dVar.b());
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    public io.hansel.userjourney.models.b a(String str, String str2, HashMap<String, Object> hashMap) {
        try {
            return io.hansel.segments.e.a(this.f5322b).a(str, str2, HSLFiltersInternal.getInstance().getUniqueId(), hashMap);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return null;
        }
    }

    public static Boolean a(String str, int i2) {
        if (i2 == -1) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(str.length() > i2);
    }

    private Runnable a(String str, HashMap<String, Object> hashMap, String str2, HanselEventDataListener hanselEventDataListener) {
        c cVar = new c(str, str2, new HashMap(hashMap), hanselEventDataListener);
        return cVar;
    }

    private HashMap<String, Object> a(String str, String str2, HashMap<String, Object> hashMap, HanselEventDataListener hanselEventDataListener, boolean z) {
        if (z && hanselEventDataListener != null) {
            try {
                hanselEventDataListener.onEvent(str, str2, hashMap);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline53("Exception caught in hansel event callback handled by client for the event ", str, " vendor ", str2), LogGroup.PT);
            }
        }
        return new HashMap<>();
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> a(String str, HashMap<String, Object> hashMap, String str2) {
        try {
            Pair<HashMap<String, Object>, Set<String>> c2 = c(str, str2, hashMap);
            HashMap<String, Object> hashMap2 = (HashMap) c2.first;
            a(str, str2, hashMap, hashMap2, (Set) c2.second);
            HSLLogger.d("Triggered Hansel Event:  " + str + "    Vendor:    " + str2 + "  Properties:     " + hashMap + "   HanselData: " + hashMap2, LogGroup.PT);
            return hashMap2;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline53("Exception caught in getHanselData method for event ", str, " vendor ", str2), LogGroup.PT);
            return new HashMap<>();
        }
    }

    private HashMap<String, Object> a(ArrayList<String> arrayList, String str) {
        String str2;
        Integer b2 = k.b(this.f5322b, str);
        HashMap<String, Object> hashMap = new HashMap<>();
        int i2 = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        String str3 = "";
        int i3 = 0;
        while (true) {
            str2 = "hsl_data";
            if (i2 >= size) {
                break;
            }
            String outline59 = GeneratedOutlineSupport.outline59(new StringBuilder(), arrayList.get(i2), ',');
            if (a(GeneratedOutlineSupport.outline50(str3, outline59), b2.intValue()).booleanValue()) {
                if (i3 != 0) {
                    str2 = GeneratedOutlineSupport.outline41(str2, i3);
                }
                hashMap.put(str2, str3);
                i3++;
                str3 = outline59;
            } else {
                str3 = GeneratedOutlineSupport.outline50(str3, outline59);
            }
            i2++;
        }
        if (i3 == 0) {
            hashMap.put(str2, str3);
        } else {
            hashMap.put(str2 + i3, str3);
        }
        hashMap.put("hsl_counter", Integer.valueOf(i3 + 1));
        hashMap.put("hsl_ven", str);
        return hashMap;
    }

    private HashMap<String, Object> a(HashMap<String, Object> hashMap, Set<String> set) {
        HashMap<String, Object> hashMap2 = new HashMap<>(hashMap);
        Iterator it = new HashSet(hashMap2.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!set.contains(str)) {
                hashMap2.remove(str);
            }
        }
        return hashMap2;
    }

    private void a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        e();
        io.hansel.ujmtracker.m.a c2 = io.hansel.ujmtracker.m.a.c();
        this.f5326f = c2;
        c2.a(context.getApplicationContext(), hSLSDKIdentifiers, hSLTaskHandler);
        this.f5323c.schedule(b());
    }

    public static void a(HanselInternalEventsListener hanselInternalEventsListener) {
        try {
            i.f5338c.a(hanselInternalEventsListener);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while de-registering Tracker Listener.");
        }
    }

    private void a(io.hansel.userjourney.models.b bVar) {
        try {
            if (HSLInternalUtils.isInTestGroup(this.f5322b)) {
                b bVar2 = new b(this.f5322b, this.f5321a, l.a(this.f5322b), bVar, new a());
                this.f5323c.schedule(bVar2);
                HSLLogger.d("fireAddEvent: " + bVar.a(), LogGroup.PT);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    private void a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Set<String> set) {
        String str3;
        try {
            HashMap hashMap3 = new HashMap(hashMap);
            if (HSLInternalUtils.getBooleanFromSharedPreferences(this.f5322b, "is_analytics_enabled")) {
                String stringFromSharedPreferences = HSLInternalUtils.getStringFromSharedPreferences(this.f5322b, "ha_type");
                if ("sel".equals(stringFromSharedPreferences)) {
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        a(hashMap2, str, str2, a(hashMap3, set));
                        str3 = "Hansel Push Selected: " + str;
                    } else {
                        return;
                    }
                } else if (ChannelPipelineCoverage.ALL.equals(stringFromSharedPreferences)) {
                    a(hashMap2, str, str2, a(hashMap3, set));
                    str3 = "Hansel Push All: " + str;
                } else {
                    return;
                }
                HSLLogger.d(str3, LogGroup.PT);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public static void a(HashMap<String, Object> hashMap) {
        Object valueOf;
        if (hashMap != null) {
            for (Entry next : hashMap.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (l.contains(str)) {
                    if (value != null && (value instanceof String)) {
                        valueOf = Boolean.valueOf(Boolean.parseBoolean((String) value));
                    }
                } else if (m.contains(str) && value != null && (value instanceof String)) {
                    valueOf = Long.valueOf(Long.parseLong((String) value));
                }
                next.setValue(valueOf);
            }
        }
    }

    private void a(HashMap<String, Object> hashMap, String str, String str2, HashMap<String, Object> hashMap2) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str3 = (String) arrayList.get(i2);
            Object obj = hashMap.get(str3);
            if (obj == null || ((obj instanceof String) && ((String) obj).isEmpty())) {
                break;
            }
            hashMap2.put(str3, obj);
        }
        if (!str2.equals("hsl") || (!str.equals("_hsl_onAppLoad") && !str.equals("_hsl_page_load") && !str.equals("hansel_nudge_event"))) {
            this.j.a(str, str2, hashMap2);
        }
    }

    private Runnable b() {
        return new a();
    }

    public static void b(HanselInternalEventsListener hanselInternalEventsListener) {
        try {
            i.f5338c.b(hanselInternalEventsListener);
        } catch (Throwable th) {
            HSLLogger.printStackTraceMin(th, "Something went wrong while registering Tracker Listener.");
        }
    }

    /* access modifiers changed from: private */
    public void b(io.hansel.userjourney.models.b bVar) {
        try {
            this.g.displayPrompts(bVar);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    private void b(String str, String str2, HashMap<String, Object> hashMap) {
        try {
            a(new io.hansel.userjourney.models.b(str, str2, hashMap));
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    private Pair<HashMap<String, Object>, Set<String>> c(String str, String str2, HashMap<String, Object> hashMap) {
        try {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            Pair<ArrayList<String>, Set<String>> a2 = this.f5324d.a(str, str2, hashMap);
            ArrayList arrayList = (ArrayList) a2.first;
            if (arrayList != null && arrayList.size() > 0) {
                hashMap2 = a(arrayList, str2);
            }
            return Pair.create(hashMap2, a2.second);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void c(io.hansel.userjourney.models.b bVar) {
        try {
            this.g.reevaluateJourneys(bVar);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        d dVar = new d(this.f5322b, C0081a.eventtrackerujm.name(), j.a(this.f5322b.getApplicationContext()), new i());
        this.f5325e = dVar;
    }

    /* access modifiers changed from: private */
    public void e(String str, String str2, HashMap<String, Object> hashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        io.hansel.ujmtracker.n.a aVar = new io.hansel.ujmtracker.n.a(this.f5321a.getAppId(), HSLFiltersInternal.getInstance().getUniqueId(), str, str2, hashMap, currentTimeMillis);
        this.f5326f.a(aVar, io.hansel.ujmtracker.m.e.app_event.name(), currentTimeMillis, C0081a.eventtrackerujm.name());
    }

    /* access modifiers changed from: private */
    public void f() {
        io.hansel.ujmtracker.m.a aVar = this.f5326f;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    /* access modifiers changed from: private */
    public void f(String str, String str2, HashMap<String, Object> hashMap) {
        io.hansel.userjourney.models.b a2 = a(str, str2, hashMap);
        b(a2);
        c(a2);
    }

    private void h() {
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            io.hansel.userjourney.models.b bVar = this.i.get(i2);
            c(bVar.a(), bVar.g(), bVar.c(), null, true);
        }
        this.i.clear();
    }

    public void a(Context context, HSLTrackerModule hSLTrackerModule, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler) {
        this.f5322b = context;
        this.g = hSLTrackerModule;
        this.f5324d.b();
        this.f5321a = hSLSDKIdentifiers;
        this.f5323c = hSLTaskHandler;
        a(context, hSLSDKIdentifiers, hSLTaskHandler);
    }

    public void a(d dVar) {
        if (dVar == null) {
            dVar = new e();
        }
        this.j = dVar;
    }

    public void a(e eVar) {
        this.f5324d.a(eVar);
    }

    public void a(String str) {
        try {
            ArrayList<String> a2 = this.f5324d.a();
            if (l.c(this.f5322b)) {
                String b2 = l.b(this.f5322b);
                if (b2 != null && b2.equals(ChannelPipelineCoverage.ALL)) {
                    HSLLogger.d("Sending internal event " + str);
                    HSLLogger.d("Data for internal event " + str + "is " + a2, LogGroup.PT);
                    i.f5338c.a(str, (List<String>) a2);
                }
            }
            if (HSLInternalUtils.getBooleanFromSharedPreferences(this.f5322b, "is_analytics_enabled")) {
                HashMap hashMap = new HashMap();
                HashMap<String, Object> hashMap2 = null;
                if (a2 != null && a2.size() > 0) {
                    hashMap2 = a(a2, (String) "hsl");
                }
                if (hashMap2 != null) {
                    a(hashMap2, str, (String) "hsl", hashMap);
                }
                HSLLogger.d("fireInternalEvent: " + str + "    Formatted hsl_data:    " + hashMap2, LogGroup.PT);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            if (HSLInternalUtils.getBooleanFromSharedPreferences(this.f5322b, "is_analytics_enabled")) {
                this.j.a(str, "hsl", hashMap);
                HSLLogger.d("firePromptEvent: " + str + " # data: " + hashMap, LogGroup.PT);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        g.a().a(this.f5322b, hashMap, hashMap2);
    }

    public HashMap<String, Object> b(String str, String str2, HashMap<String, Object> hashMap, HanselEventDataListener hanselEventDataListener, boolean z) {
        try {
            return l.a(str).booleanValue() ? new HashMap<>() : c(str, str2, hashMap, hanselEventDataListener, z);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return new HashMap<>();
        }
    }

    public void b(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2) {
        g.a().b(this.f5322b, hashMap, hashMap2);
    }

    public HashMap<String, Object> c(String str, String str2, HashMap<String, Object> hashMap, HanselEventDataListener hanselEventDataListener, boolean z) {
        try {
            if (!this.h) {
                this.i.add(new io.hansel.userjourney.models.b(str, str2, hashMap));
                return a(str, str2, hashMap, hanselEventDataListener, z);
            }
            HSLLogger.d("LogEventHSL: " + str + str2 + " props: " + hashMap, LogGroup.PT);
            if (!HSLInternalUtils.isEmpty(str)) {
                if (!HSLInternalUtils.isEmpty(str2)) {
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    String trim = str.trim();
                    b(trim, str2, hashMap);
                    if (z) {
                        this.g.getLinkedMessageBroker().enqueue(a(trim, hashMap, str2, hanselEventDataListener));
                        return new HashMap<>();
                    }
                    HashMap<String, Object> a2 = a(trim, hashMap, str2);
                    this.g.getLinkedMessageBroker().enqueue(new b(trim, str2, hashMap));
                    return a2;
                }
            }
            HSLLogger.wMin("HanselTracker   Invalid Event with EventName : " + str + " for vendor : " + str2);
            return a(str, str2, hashMap, hanselEventDataListener, z);
        } catch (Throwable th) {
            String str3 = str;
            HSLLogger.printStackTraceMin(th, "Something went wrong. Hansel sdk is not able to trigger event " + str3 + "     ");
            return a(str3, str2, hashMap, hanselEventDataListener, z);
        }
    }

    public void c() {
        if (!this.h) {
            boolean booleanFromSharedPreferences = HSLInternalUtils.getBooleanFromSharedPreferences(this.f5322b, "is_first_get_data_sync_done", false);
            this.h = booleanFromSharedPreferences;
            if (booleanFromSharedPreferences) {
                h();
            }
        }
    }

    public void d() {
        c.b().a();
        this.h = true;
        h();
    }

    public void d(String str, String str2, HashMap<String, Object> hashMap) {
        f(str, str2, hashMap);
    }

    public void g() {
        Context context = this.f5322b;
        if (context != null) {
            io.hansel.ujmtracker.m.h hVar = this.f5325e;
            if (hVar != null) {
                hVar.a(j.a(context));
            }
        }
    }
}
