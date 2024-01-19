package io.hansel.actions.configs;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import io.hansel.actions.HSLConfigDataType;
import io.hansel.actions.HSLConfigPriority;
import io.hansel.actions.HSLConfigSource;
import io.hansel.actions.HSLConfigSourceCode;
import io.hansel.core.base.utils.HSLVersion;
import io.hansel.core.logger.HSLLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NavigableSet;
import java.util.TreeSet;

public class k extends HSLConfigSource {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f5074a;

    /* renamed from: b  reason: collision with root package name */
    public TreeSet<String> f5075b = new TreeSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, LinkedList> f5076c;

    /* renamed from: d  reason: collision with root package name */
    public TreeSet<String> f5077d;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5078a;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
        static {
            /*
                io.hansel.actions.HSLConfigDataType[] r0 = io.hansel.actions.HSLConfigDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5078a = r0
                io.hansel.actions.HSLConfigDataType r1 = io.hansel.actions.HSLConfigDataType.num     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r1 = f5078a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.bool     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5078a     // Catch:{ NoSuchFieldError -> 0x001f }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.hashmap     // Catch:{ NoSuchFieldError -> 0x001f }
                r3 = 9
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r2 = f5078a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.linkedlist     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3 = 10
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = f5078a     // Catch:{ NoSuchFieldError -> 0x002f }
                io.hansel.actions.HSLConfigDataType r3 = io.hansel.actions.HSLConfigDataType.str     // Catch:{ NoSuchFieldError -> 0x002f }
                r3 = 5
                r2[r0] = r3     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                int[] r0 = f5078a     // Catch:{ NoSuchFieldError -> 0x0036 }
                io.hansel.actions.HSLConfigDataType r2 = io.hansel.actions.HSLConfigDataType.json     // Catch:{ NoSuchFieldError -> 0x0036 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0036 }
            L_0x0036:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.actions.configs.k.a.<clinit>():void");
        }
    }

    public k(Context context, HSLVersion hSLVersion) {
        super(context, hSLVersion);
        this.f5074a = context.getSharedPreferences("e8acbd4424704c9686a3HANSEL_IO_DATA_STORE", 0);
        b();
    }

    private HashMap<String, Object> a(String str, HashMap hashMap) {
        HashMap<String, Object> b2 = b(str);
        Object obj = b2.get("data_type");
        return !"hashmap".equalsIgnoreCase(obj == null ? "" : obj.toString()) ? hashMap : (HashMap) b2.get("data");
    }

    private HashMap<String, Object> b(String str) {
        String string = this.f5074a.getString(str, null);
        if (string == null) {
            return null;
        }
        HashMap<String, Object> hashMap = (HashMap) i.a(string);
        Object obj = hashMap.get("cache_expiry");
        long j = 0;
        long parseLong = obj == null ? 0 : Long.parseLong(obj.toString());
        if (parseLong == -1) {
            d(str);
        } else if (!(parseLong == -2 || parseLong == -3)) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj2 = hashMap.get("created_at");
            if (obj2 != null) {
                j = Long.parseLong(obj2.toString());
            }
            if (j + parseLong < currentTimeMillis) {
                d(str);
                return null;
            }
        }
        return hashMap;
    }

    private void b() {
        this.f5075b = (TreeSet) i.a(this.f5074a.getString("e8acbd4424704c9686a3hansel_app_session", null));
        this.f5077d = (TreeSet) i.a(this.f5074a.getString("e8acbd4424704c9686a3hansel_ttl", null));
        this.f5076c = (HashMap) i.a(this.f5074a.getString("e8acbd4424704c9686a3hansel_ttl_to_key", null));
        if (this.f5075b == null) {
            this.f5075b = new TreeSet<>();
        }
        if (this.f5077d == null) {
            this.f5077d = new TreeSet<>();
        }
        if (this.f5076c == null) {
            this.f5076c = new HashMap<>();
        }
    }

    private void d(String str) {
        GeneratedOutlineSupport.outline93(this.f5074a, str);
    }

    public Boolean a(String str) {
        HashMap<String, Object> b2 = b(str);
        if (b2 == null || !"bool".equalsIgnoreCase(b2.get("data_type").toString())) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(b2.get("data").toString()));
    }

    public Object a(String str, Object obj, HSLConfigDataType hSLConfigDataType) {
        if (hSLConfigDataType != null) {
            try {
                switch (a.f5078a[hSLConfigDataType.ordinal()]) {
                    case 1:
                        return c(str);
                    case 2:
                        return a(str);
                    case 3:
                        return a(str, (HashMap) null);
                    case 4:
                        return a(str, (LinkedList) null);
                    case 5:
                        return a(str, (String) null);
                    case 6:
                        return a(str, (String) null);
                }
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
        return obj;
    }

    public String a(String str, String str2) {
        HashMap<String, Object> b2 = b(str);
        return (b2 == null || !NetworkingModule.REQUEST_BODY_KEY_STRING.equalsIgnoreCase(b2.get("data_type").toString())) ? str2 : (String) b2.get("data");
    }

    public LinkedList a(String str, LinkedList linkedList) {
        HashMap<String, Object> b2 = b(str);
        if (b2 == null) {
            return linkedList;
        }
        return !"array".equalsIgnoreCase(b2.get("data_type") == null ? "" : b2.get("data_type").toString()) ? linkedList : (LinkedList) b2.get("data");
    }

    public void a() {
        NavigableSet<String> headSet = this.f5077d.headSet(Long.toString(System.currentTimeMillis()), true);
        ArrayList arrayList = new ArrayList(headSet);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            LinkedList linkedList = this.f5076c.get(str);
            int size2 = linkedList == null ? 0 : linkedList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                d((String) linkedList.get(i2));
            }
            this.f5076c.remove(str);
        }
        this.f5077d.removeAll(headSet);
    }

    public Double c(String str) {
        HashMap<String, Object> b2 = b(str);
        if (b2 == null || !"double".equalsIgnoreCase(b2.get("data_type").toString())) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(b2.get("data").toString()));
    }

    public void c() {
        ArrayList arrayList = new ArrayList(this.f5075b);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            d((String) arrayList.get(i));
        }
        this.f5075b = new TreeSet<>();
    }

    public void clear() {
    }

    public void d() {
        String a2 = i.a((Serializable) this.f5075b);
        String a3 = i.a((Serializable) this.f5077d);
        this.f5074a.edit().putString("e8acbd4424704c9686a3hansel_app_session", a2).putString("e8acbd4424704c9686a3hansel_ttl", a3).putString("e8acbd4424704c9686a3hansel_ttl_to_key", i.a((Serializable) this.f5076c)).apply();
    }

    public Object getConfig(String str, HSLConfigDataType hSLConfigDataType) {
        return a(str, null, hSLConfigDataType);
    }

    public HSLConfigSourceCode getConfigSourceCode() {
        return HSLConfigSourceCode.hc;
    }

    public int getPriority() {
        return HSLConfigPriority.SUPER_CONFIG.getPriority();
    }
}
