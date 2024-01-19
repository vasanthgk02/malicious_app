package io.hansel.actions.configs;

import io.hansel.actions.HSLConfigDataType;
import io.hansel.actions.HSLConfigSource;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.sdkmodels.HSLModuleInitializationData;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {

    /* renamed from: c  reason: collision with root package name */
    public static h f5069c = new h();

    /* renamed from: a  reason: collision with root package name */
    public k f5070a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<Integer, HSLConfigSource> f5071b = new TreeMap<>();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5072a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                io.hansel.core.module.EventsConstants[] r0 = io.hansel.core.module.EventsConstants.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5072a = r0
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.HANSEL_DATA_STORE_EVENT_APP_START     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 50
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = f5072a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.module.EventsConstants r1 = io.hansel.core.module.EventsConstants.REGISTER_CONFIG_SOURCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 14
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.configs.h.a.<clinit>():void");
        }
    }

    public static h a() {
        return f5069c;
    }

    private Object a(String str, HSLConfigDataType hSLConfigDataType) {
        try {
            e eVar = new e();
            ArrayList arrayList = new ArrayList(this.f5071b.keySet());
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                HSLConfigSource hSLConfigSource = this.f5071b.get((Integer) arrayList.get(i));
                if (eVar.isEmpty() || eVar.contains(hSLConfigSource.getConfigSourceCode())) {
                    String b2 = a.b(str);
                    if (!HSLUtils.isSet(b2)) {
                        b2 = str;
                    }
                    if (hSLConfigSource != null) {
                        Object config = hSLConfigSource.getConfig(b2, hSLConfigDataType);
                        if (config == null) {
                            continue;
                        } else if (!(config instanceof e)) {
                            return config;
                        } else {
                            eVar.addAll((e) config);
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return null;
    }

    public static k b() {
        return f5069c.f5070a;
    }

    public double a(String str, double d2) {
        try {
            Object a2 = a(str, HSLConfigDataType.num);
            if (a2 != null) {
                return Double.valueOf(String.valueOf(a2)).doubleValue();
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return d2;
    }

    public int a(String str, int i) {
        try {
            Object a2 = a(str, HSLConfigDataType.num);
            if (a2 != null) {
                return Integer.valueOf(String.valueOf(a2)).intValue();
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return i;
    }

    public String a(String str, String str2) {
        try {
            Object a2 = a(str, HSLConfigDataType.str);
            if (a2 != null) {
                return String.valueOf(a2);
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return str2;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        try {
            Object a2 = a(str, HSLConfigDataType.json);
            if (a2 != null) {
                return new JSONArray(String.valueOf(a2));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return jSONArray;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            Object a2 = a(str, HSLConfigDataType.json);
            if (a2 != null) {
                return new JSONObject(String.valueOf(a2));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return jSONObject;
    }

    public void a(HSLModuleInitializationData hSLModuleInitializationData, IMessageBroker iMessageBroker) {
        k kVar = new k(hSLModuleInitializationData.app.getApplicationContext(), hSLModuleInitializationData.sdkIdentifiers.getAppVersion());
        this.f5070a = kVar;
        this.f5071b.put(Integer.valueOf(kVar.getPriority()), this.f5070a);
        iMessageBroker.publishEvent(EventsConstants.HANSEL_DATA_STORE_EVENT_INIT_MESSAGE.name(), this);
    }

    public boolean a(String str, Object obj) {
        int i = a.f5072a[EventsConstants.valueOf(str).ordinal()];
        if (i == 1) {
            this.f5070a.c();
            this.f5070a.a();
            this.f5070a.d();
            return true;
        } else if (i != 2) {
            return false;
        } else {
            if (obj instanceof HSLConfigSource) {
                HSLConfigSource hSLConfigSource = (HSLConfigSource) obj;
                this.f5071b.put(Integer.valueOf(hSLConfigSource.getPriority()), hSLConfigSource);
            }
            return true;
        }
    }

    public boolean a(String str, boolean z) {
        try {
            Object a2 = a(str, HSLConfigDataType.bool);
            if (a2 != null) {
                return Boolean.parseBoolean(String.valueOf(a2));
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
        return z;
    }
}
