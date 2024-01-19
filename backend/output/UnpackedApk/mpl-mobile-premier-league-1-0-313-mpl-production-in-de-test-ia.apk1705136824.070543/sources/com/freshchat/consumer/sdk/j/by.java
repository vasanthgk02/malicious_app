package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.UserEvent;
import com.freshchat.consumer.sdk.beans.UserEventsConfig;
import com.freshchat.consumer.sdk.exception.InvalidEventException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class by {
    public static by mH;
    public final a mI = new a();
    public Handler mJ;
    public b mK;
    public final Set<String> mL = new HashSet();

    public class a {
        public ab cS = new ab();

        public a() {
        }

        private boolean bT(Context context) {
            try {
                long fP = n.fP();
                e i = e.i(context);
                if (n.c(i.gL(), fP)) {
                    i.gK();
                    return true;
                } else if (!e.i(context).bl()) {
                    return true;
                } else {
                    int gJ = i.gJ();
                    UserEventsConfig eventsConfig = ap.bD(context).getEventsConfig();
                    if (((long) gJ) < eventsConfig.getMaxAllowedEventsPerDay()) {
                        return true;
                    }
                    ai.e("FRESHCHAT", "User events have reached the daily limit of " + eventsConfig.getMaxAllowedEventsPerDay());
                    return false;
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }

        private Map<String, UserEvent> bk(String str) {
            try {
                return (Map) this.cS.fromJson(str, new cb(this).getType());
            } catch (Exception e2) {
                q.a(e2);
                return new LinkedHashMap();
            }
        }

        private void d(Context context, Map<String, UserEvent> map) {
            try {
                e.i(context).aa(this.cS.toJson(map));
            } catch (Exception e2) {
                q.a(e2);
            }
        }

        private void e(Context context, Map<String, UserEvent> map) {
            try {
                e.i(context).Z(this.cS.toJson(map));
            } catch (Exception e2) {
                q.a(e2);
            }
        }

        public void a(Context context, UserEvent userEvent) {
            if (bT(context)) {
                e i = e.i(context);
                i.E(i.gJ() + 1);
                UserEventsConfig eventsConfig = ap.bD(context).getEventsConfig();
                Map<String, UserEvent> bR = bR(context);
                if (((long) bR.size()) > eventsConfig.getMaxAllowedEventsPerDay()) {
                    bR.remove(bR.keySet().iterator().next());
                }
                bR.put(UUID.randomUUID().toString(), userEvent);
                e(context, bR);
                i.w(userEvent.getOccTime());
            }
        }

        public void a(Context context, Set<String> set) {
            if (!k.isEmpty(set)) {
                Map<String, UserEvent> bS = bS(context);
                if (!k.c(bS)) {
                    for (String remove : set) {
                        bS.remove(remove);
                    }
                    d(context, bS);
                }
            }
        }

        public Map<String, UserEvent> bR(Context context) {
            return bk(e.i(context).gG());
        }

        public Map<String, UserEvent> bS(Context context) {
            return bk(e.i(context).gI());
        }

        public void c(Context context, Map<String, UserEvent> map) {
            try {
                Map<String, UserEvent> bS = bS(context);
                bS.putAll(map);
                d(context, bS);
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public class b implements Runnable {
        public final WeakReference<Context> lk;

        public b(Context context) {
            this.lk = new WeakReference<>(context.getApplicationContext());
        }

        public /* synthetic */ b(by byVar, Context context, bz bzVar) {
            this(context);
        }

        public void run() {
            if (this.lk.get() != null) {
                by.this.d((Context) this.lk.get(), false);
            } else {
                by.this.gO();
            }
        }
    }

    /* access modifiers changed from: private */
    public void E(Context context, String str) throws InvalidEventException {
        int maxCharsPerEventName = e.i(context).getMaxCharsPerEventName();
        if (!av.d(str, maxCharsPerEventName)) {
            throw new InvalidEventException(str, maxCharsPerEventName);
        }
    }

    private void a(c cVar, String str, long j) {
        ai.e("FRESHCHAT", cVar.toString().replace("{{user_event_key_placeholder}}", str).replace("{{user_event_property_limit_placeholder}}", String.valueOf(j)));
    }

    /* access modifiers changed from: private */
    public Map<String, Object> b(Context context, Map<String, Object> map) {
        c cVar;
        Map<String, Object> map2 = map;
        HashMap hashMap = new HashMap();
        if (map2 != null && !k.c(map)) {
            long maxAllowedPropertiesPerEvent = ap.bD(context).getEventsConfig().getMaxAllowedPropertiesPerEvent();
            c cVar2 = null;
            Iterator<String> it = map.keySet().iterator();
            String str = "";
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (((long) i) >= maxAllowedPropertiesPerEvent) {
                    cVar2 = c.USER_EVENT_PROPERTY_COUNT_EXCEEDED_ERROR;
                    a(cVar2, next, maxAllowedPropertiesPerEvent);
                    break;
                }
                i++;
                e i2 = e.i(context);
                if (!av.d(next, i2.getMaxCharsPerEventPropertyName())) {
                    cVar2 = c.USER_EVENT_PROPERTY_KEY_LENGTH_ERROR;
                    if (as.isEmpty(next)) {
                        cVar2 = c.USER_EVENT_PROPERTY_KEY_EMPTY_ERROR;
                    }
                    str = as.b(next) > ((long) i2.getMaxCharsPerEventPropertyName()) ? next.substring(0, i2.getMaxCharsPerEventPropertyName() - 1) : next;
                    a(cVar2, str, maxAllowedPropertiesPerEvent);
                } else {
                    Object obj = map2.get(next);
                    if (!av.e(obj)) {
                        cVar = c.USER_EVENT_PROPERTY_VALUE_UNSUPPORTED_ERROR;
                    } else if (!av.d(String.valueOf(obj), i2.getMaxCharsPerEventPropertyValue())) {
                        cVar = c.USER_EVENT_PROPERTY_VALUE_LENGTH_ERROR;
                        if (as.isEmpty(String.valueOf(obj))) {
                            cVar = c.USER_EVENT_PROPERTY_VALUE_EMPTY_ERROR;
                        }
                    } else {
                        hashMap.put(next, obj);
                    }
                    a(cVar2, next, maxAllowedPropertiesPerEvent);
                    str = next;
                }
            }
            if (cVar2 != null) {
                hashMap.put("fc_error", cVar2.getErrorMessage().replace("{{user_event_key_placeholder}}", str).replace("{{user_event_property_limit_placeholder}}", String.valueOf(maxAllowedPropertiesPerEvent)));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public Map<String, UserEvent> bO(Context context) {
        HashMap hashMap = new HashMap();
        Map<String, UserEvent> bS = this.mI.bS(context);
        for (String next : bS.keySet()) {
            if (!this.mL.contains(next)) {
                hashMap.put(next, bS.get(next));
            }
        }
        return hashMap;
    }

    private void bP(Context context) {
        e.i(context).gH();
    }

    /* access modifiers changed from: private */
    public void c(Context context, String str, Map<String, UserEvent> map) {
        if (!k.c(map)) {
            this.mL.addAll(map.keySet());
            this.mI.c(context, map);
            long maxEventsPerBatch = e.i(context).getMaxEventsPerBatch();
            int size = map.size();
            if (((long) size) > maxEventsPerBatch) {
                int i = 0;
                loop0:
                while (true) {
                    Map map2 = null;
                    for (String next : map.keySet()) {
                        if (map2 == null) {
                            map2 = new HashMap();
                        }
                        try {
                            if (map.get(next) != null) {
                                map2.put(next, map.get(next));
                                i++;
                                if (((long) i) % maxEventsPerBatch == 0 || i == size) {
                                    b.a(context, str, map2);
                                }
                            }
                        } catch (Exception e2) {
                            q.a(e2);
                        }
                    }
                    break loop0;
                }
            } else {
                b.a(context, str, map);
            }
        }
    }

    /* access modifiers changed from: private */
    public void e(Context context, boolean z) {
        if (e.i(context).bl()) {
            try {
                UserEventsConfig eventsConfig = ap.bD(context).getEventsConfig();
                e i = e.i(context);
                Map<String, UserEvent> bR = this.mI.bR(context);
                int f2 = k.f(bR);
                if (f2 > 0 && (z || ((long) f2) >= eventsConfig.getTriggerUploadOnEventsCount())) {
                    gO();
                    c(context, i.bj(), bR);
                    bP(context);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static by gN() {
        if (mH == null) {
            synchronized (by.class) {
                try {
                    if (mH == null) {
                        mH = new by();
                    }
                }
            }
        }
        return mH;
    }

    /* access modifiers changed from: private */
    public void gO() {
        Handler handler = this.mJ;
        if (handler != null) {
            b bVar = this.mK;
            if (bVar != null) {
                handler.removeCallbacks(bVar);
            }
        }
        this.mJ = null;
        this.mK = null;
    }

    public void a(Context context, Set<String> set, boolean z) {
        if (!k.isEmpty(set)) {
            for (String remove : set) {
                this.mL.remove(remove);
            }
            if (z) {
                this.mI.a(context, set);
            }
        }
    }

    public void b(Context context, String str, Map<String, Object> map) {
        be.eC().gx().execute(new bz(this, context, str, map));
    }

    public void bQ(Context context) {
        if (this.mJ == null || this.mK == null) {
            this.mJ = new Handler(Looper.getMainLooper());
            this.mK = new b(this, context, null);
            this.mJ.postDelayed(this.mK, e.i(context).getMaxDelayInMillisUntilUpload());
        }
    }

    public void d(Context context, boolean z) {
        be.eC().gx().execute(new ca(this, z, context));
    }
}
