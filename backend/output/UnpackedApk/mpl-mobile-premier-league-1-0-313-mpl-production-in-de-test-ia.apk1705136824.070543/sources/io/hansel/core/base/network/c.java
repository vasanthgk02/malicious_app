package io.hansel.core.base.network;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.base.task.b;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.HSLServerResponseHandler;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public HSLServerResponseHandler f5102d;

    public c(Context context, HSLSDKIdentifiers hSLSDKIdentifiers, HSLTaskHandler hSLTaskHandler, HSLServerResponseHandler hSLServerResponseHandler) {
        super(context, hSLSDKIdentifiers, hSLTaskHandler);
        this.f5102d = hSLServerResponseHandler;
    }

    public static synchronized CoreJSONArray a(Context context) {
        CoreJSONArray coreJSONArray;
        synchronized (c.class) {
            coreJSONArray = null;
            String stringFromSharedPreferences = HSLInternalUtils.getStringFromSharedPreferences(context, HSLInternalUtils.KEY_INIT_SDK_DATA, null);
            if (stringFromSharedPreferences != null) {
                try {
                    coreJSONArray = new CoreJSONArray(stringFromSharedPreferences);
                } catch (CoreJSONException e2) {
                    HSLLogger.printStackTrace(e2);
                }
            }
            if (coreJSONArray == null) {
                coreJSONArray = new CoreJSONArray();
            }
        }
        return coreJSONArray;
    }

    public static synchronized void a(Context context, b bVar) {
        synchronized (c.class) {
            CoreJSONArray a2 = a(context);
            if (a2.length() > 200) {
                for (int i = 0; i < 10; i++) {
                    a2.remove(0);
                }
            }
            a2.put((Object) bVar.a());
            HSLInternalUtils.setStringInSharedPreferences(context, HSLInternalUtils.KEY_INIT_SDK_DATA, a2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r10, java.util.ArrayList<io.hansel.core.base.network.b> r11) {
        /*
            java.lang.Class<io.hansel.core.base.network.c> r0 = io.hansel.core.base.network.c.class
            monitor-enter(r0)
            if (r11 == 0) goto L_0x0053
            boolean r1 = r11.isEmpty()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0053
        L_0x000c:
            io.hansel.core.json.CoreJSONArray r1 = a(r10)     // Catch:{ all -> 0x0050 }
            int r2 = r11.size()     // Catch:{ all -> 0x0050 }
        L_0x0014:
            boolean r3 = r11.isEmpty()     // Catch:{ CoreJSONException -> 0x0041 }
            if (r3 != 0) goto L_0x0045
            r3 = 0
            java.lang.Object r4 = r11.remove(r3)     // Catch:{ CoreJSONException -> 0x0041 }
            io.hansel.core.base.network.b r4 = (io.hansel.core.base.network.b) r4     // Catch:{ CoreJSONException -> 0x0041 }
        L_0x0021:
            if (r3 >= r2) goto L_0x0014
            io.hansel.core.base.network.b r5 = new io.hansel.core.base.network.b     // Catch:{ CoreJSONException -> 0x0041 }
            java.lang.Object r6 = r1.get(r3)     // Catch:{ CoreJSONException -> 0x0041 }
            io.hansel.core.json.CoreJSONObject r6 = (io.hansel.core.json.CoreJSONObject) r6     // Catch:{ CoreJSONException -> 0x0041 }
            r5.<init>(r6)     // Catch:{ CoreJSONException -> 0x0041 }
            long r5 = r5.b()     // Catch:{ CoreJSONException -> 0x0041 }
            long r7 = r4.b()     // Catch:{ CoreJSONException -> 0x0041 }
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x003e
            r1.remove(r3)     // Catch:{ CoreJSONException -> 0x0041 }
            goto L_0x0014
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0041:
            r11 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r11)     // Catch:{ all -> 0x0050 }
        L_0x0045:
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = "KEY_INIT_SDK_DATA"
            io.hansel.core.base.utils.HSLInternalUtils.setStringInSharedPreferences(r10, r1, r11)     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)
            return
        L_0x0050:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        L_0x0053:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.base.network.c.a(android.content.Context, java.util.ArrayList):void");
    }

    private boolean a(CoreJSONObject coreJSONObject) {
        HSLFiltersInternal.getInstance().put((String) "os_version", VERSION.RELEASE);
        HSLFiltersInternal.getInstance().put((String) "device", Build.MODEL);
        HSLFiltersInternal.getInstance().put((String) "manufacturer", Build.MANUFACTURER);
        HashMap<String, CoreJSONObject> all = HSLFiltersInternal.getInstance().getAll();
        if (coreJSONObject == null) {
            return false;
        }
        CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("savedFilters");
        Set set = (Set) coreJSONObject.opt("serverEvaluatedList");
        if (set == null || set.isEmpty()) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                CoreJSONObject optJSONObject = optJSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), optJSONObject);
            }
        }
        ArrayList arrayList = new ArrayList(set);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = (String) arrayList.get(i2);
            boolean containsKey = hashMap.containsKey(str);
            if (containsKey == all.containsKey(str)) {
                if (containsKey) {
                    CoreJSONObject coreJSONObject2 = (CoreJSONObject) hashMap.get(str);
                    String str2 = null;
                    String optString = coreJSONObject2 != null ? coreJSONObject2.optString(HSLCriteriaBuilder.VALUE) : null;
                    CoreJSONObject coreJSONObject3 = all.get(str);
                    if (coreJSONObject3 != null) {
                        str2 = coreJSONObject3.optString(HSLCriteriaBuilder.VALUE);
                    }
                    if (!HSLInternalUtils.equals(optString, str2)) {
                    }
                }
                i2++;
            }
            return true;
        }
        return false;
    }

    private void f() {
        d().schedule(new a(b(), c(), this.f5102d));
    }

    public void a() {
        f();
    }

    public void a(b bVar, CoreJSONObject coreJSONObject) {
        String str;
        if (a(coreJSONObject)) {
            HSLInternalUtils.setLongInSharedPreferences(this.f5115a, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL, 0);
            HSLInternalUtils.setStringInSharedPreferences(this.f5115a, HSLInternalUtils.KEY_PATCH_LIST_VERSION, null);
            HSLInternalUtils.setStringInSharedPreferences(this.f5115a, HSLInternalUtils.KEY_STATIC_CRITERIA_VERSION, null);
        }
        a(b(), bVar);
        long currentTimeMillis = System.currentTimeMillis() - HSLInternalUtils.getLongFromSharedPreferences(this.f5115a, HSLInternalUtils.KEY_INITSDK_REQUEST_SILENCE_INTERVAL);
        if (currentTimeMillis > 0) {
            f();
            str = "Trying to sync hotfixes with Hansel servers.";
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Won't sync the hotfixes for another ");
            outline73.append((currentTimeMillis * -1) / 1000);
            outline73.append(" sec. If you want to sync the hotfixes right away, please delete your application cache or reinstall the application");
            str = outline73.toString();
        }
        HSLLogger.i(str);
    }
}
