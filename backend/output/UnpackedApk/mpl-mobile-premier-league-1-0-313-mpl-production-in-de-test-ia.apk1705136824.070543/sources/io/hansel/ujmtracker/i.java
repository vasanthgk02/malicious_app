package io.hansel.ujmtracker;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class i {

    /* renamed from: c  reason: collision with root package name */
    public static i f5338c = new i();

    /* renamed from: a  reason: collision with root package name */
    public HanselInternalEventsListener f5339a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f5340b = new ArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5341a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Object> f5342b;

        public a(String str, HashMap<String, Object> hashMap) {
            this.f5341a = str;
            this.f5342b = hashMap;
        }

        public String a() {
            return this.f5341a;
        }

        public HashMap<String, Object> b() {
            return this.f5342b;
        }
    }

    public static HashMap<String, Object> a(List<String> list) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int size = list == null ? 0 : list.size();
        for (int i = 0; i < size; i++) {
            hashMap.put(Integer.toString(i), list.get(i));
        }
        return hashMap;
    }

    public void a(HanselInternalEventsListener hanselInternalEventsListener) {
        this.f5339a = null;
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        HanselInternalEventsListener hanselInternalEventsListener = this.f5339a;
        if (hanselInternalEventsListener != null) {
            try {
                hanselInternalEventsListener.onEvent(str, hashMap);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Exception caught in hansel event callback handled by client for the event: " + str + " & props: " + hashMap, LogGroup.PT);
            }
        }
    }

    public void a(String str, List<String> list) {
        HashMap<String, Object> a2 = a(list);
        HanselInternalEventsListener hanselInternalEventsListener = this.f5339a;
        if (hanselInternalEventsListener == null) {
            this.f5340b.add(new a(str, a2));
            return;
        }
        try {
            hanselInternalEventsListener.onEvent(str, a2);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in hansel event callback handled by client for the event: " + str + " & props: " + a2, LogGroup.PT);
        }
    }

    public void b(HanselInternalEventsListener hanselInternalEventsListener) {
        this.f5339a = hanselInternalEventsListener;
        int size = this.f5340b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f5340b.get(i);
            try {
                hanselInternalEventsListener.onEvent(aVar.a(), aVar.b());
            } catch (Throwable th) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception caught in hansel event callback handled by client for the event: ");
                outline73.append(aVar.a());
                outline73.append(" & props: ");
                outline73.append(aVar.b());
                HSLLogger.printStackTrace(th, outline73.toString(), LogGroup.PT);
            }
        }
        this.f5340b.clear();
    }
}
