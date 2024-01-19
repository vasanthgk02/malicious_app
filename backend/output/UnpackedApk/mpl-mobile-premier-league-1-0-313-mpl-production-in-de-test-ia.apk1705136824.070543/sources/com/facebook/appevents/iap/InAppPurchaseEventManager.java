package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mpl.payment.routing.RoutingConstants;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` X\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseEventManager;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "DETAILS_LIST", "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", "INAPP_CONTINUATION_TOKEN", "INAPP_PURCHASE_DATA_LIST", "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", "ITEM_ID_LIST", "LAST_CLEARED_TIME", "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", "RESPONSE_CODE", "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", "asInterface", "context", "Landroid/content/Context;", "service", "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", "getPurchaseHistory", "inAppBillingObj", "type", "getPurchaseHistoryInapp", "getPurchases", "getPurchasesInapp", "getPurchasesSubs", "getSkuDetails", "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "isBillingSupported", "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseEventManager.kt */
public final class InAppPurchaseEventManager {
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    public static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    public static final HashMap<String, Class<?>> classMap = new HashMap<>();
    public static final HashMap<String, Method> methodMap = new HashMap<>();
    public static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    public static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
    }

    public static final ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        Class<InAppPurchaseEventManager> cls = InAppPurchaseEventManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            return INSTANCE.filterPurchases(INSTANCE.getPurchases(context, obj, "inapp"));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Editor edit = purchaseInappSharedPrefs.edit();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    JSONObject jSONObject = new JSONObject(next);
                    String string = jSONObject.getString(RoutingConstants.KILLBILL_TPSL_PRODUCT_ID);
                    long j = jSONObject.getLong("purchaseTime");
                    String string2 = jSONObject.getString("purchaseToken");
                    if (currentTimeMillis - (j / 1000) <= 86400) {
                        if (!Intrinsics.areEqual(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                            edit.putString(string, string2);
                            arrayList2.add(next);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            edit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[Catch:{ all -> 0x0030, all -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Class<?> getClass(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.HashMap<java.lang.String, java.lang.Class<?>> r0 = classMap     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x003d }
            java.lang.Class r0 = (java.lang.Class) r0     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0013
            return r0
        L_0x0013:
            java.lang.Class<com.facebook.appevents.iap.InAppPurchaseUtils> r0 = com.facebook.appevents.iap.InAppPurchaseUtils.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x001d
        L_0x001b:
            r4 = r1
            goto L_0x0035
        L_0x001d:
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "className"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)     // Catch:{ all -> 0x0030 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x001b }
            java.lang.Class r4 = r4.loadClass(r5)     // Catch:{ ClassNotFoundException -> 0x001b }
            goto L_0x0035
        L_0x0030:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r0)     // Catch:{ all -> 0x003d }
            goto L_0x001b
        L_0x0035:
            if (r4 == 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.lang.Class<?>> r0 = classMap     // Catch:{ all -> 0x003d }
            r0.put(r5, r4)     // Catch:{ all -> 0x003d }
        L_0x003c:
            return r4
        L_0x003d:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getClass(android.content.Context, java.lang.String):java.lang.Class");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.reflect.Method getMethod(java.lang.Class<?> r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r10)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = methodMap     // Catch:{ all -> 0x00be }
            java.lang.Object r1 = r1.get(r12)     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ all -> 0x00be }
            if (r1 == 0) goto L_0x0015
            return r1
        L_0x0015:
            int r1 = r12.hashCode()     // Catch:{ all -> 0x00be }
            r3 = 4
            r4 = 2
            java.lang.String r5 = "TYPE"
            r6 = 3
            r7 = 0
            r8 = 1
            switch(r1) {
                case -1801122596: goto L_0x0086;
                case -1450694211: goto L_0x006f;
                case -1123215065: goto L_0x005f;
                case -594356707: goto L_0x0041;
                case -573310373: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x009f
        L_0x0025:
            java.lang.String r1 = "getSkuDetails"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00be }
            if (r1 != 0) goto L_0x002f
            goto L_0x009f
        L_0x002f:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00be }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00be }
            r1[r7] = r3     // Catch:{ all -> 0x00be }
            r1[r8] = r0     // Catch:{ all -> 0x00be }
            r1[r4] = r0     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r1[r6] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x0041:
            java.lang.String r1 = "getPurchaseHistory"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00be }
            if (r1 != 0) goto L_0x004a
            goto L_0x009f
        L_0x004a:
            r1 = 5
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ all -> 0x00be }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)     // Catch:{ all -> 0x00be }
            r1[r7] = r9     // Catch:{ all -> 0x00be }
            r1[r8] = r0     // Catch:{ all -> 0x00be }
            r1[r4] = r0     // Catch:{ all -> 0x00be }
            r1[r6] = r0     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.Bundle> r0 = android.os.Bundle.class
            r1[r3] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x005f:
            java.lang.String r0 = "asInterface"
            boolean r0 = r12.equals(r0)     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x0068
            goto L_0x009f
        L_0x0068:
            java.lang.Class[] r1 = new java.lang.Class[r8]     // Catch:{ all -> 0x00be }
            java.lang.Class<android.os.IBinder> r0 = android.os.IBinder.class
            r1[r7] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x006f:
            java.lang.String r1 = "isBillingSupported"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00be }
            if (r1 != 0) goto L_0x0078
            goto L_0x009f
        L_0x0078:
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00be }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00be }
            r1[r7] = r3     // Catch:{ all -> 0x00be }
            r1[r8] = r0     // Catch:{ all -> 0x00be }
            r1[r4] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x0086:
            java.lang.String r1 = "getPurchases"
            boolean r1 = r12.equals(r1)     // Catch:{ all -> 0x00be }
            if (r1 != 0) goto L_0x008f
            goto L_0x009f
        L_0x008f:
            java.lang.Class[] r1 = new java.lang.Class[r3]     // Catch:{ all -> 0x00be }
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00be }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x00be }
            r1[r7] = r3     // Catch:{ all -> 0x00be }
            r1[r8] = r0     // Catch:{ all -> 0x00be }
            r1[r4] = r0     // Catch:{ all -> 0x00be }
            r1[r6] = r0     // Catch:{ all -> 0x00be }
            goto L_0x00a0
        L_0x009f:
            r1 = r2
        L_0x00a0:
            if (r1 != 0) goto L_0x00ab
            java.lang.Class[] r0 = new java.lang.Class[r8]     // Catch:{ all -> 0x00be }
            r0[r7] = r2     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r11, r12, r0)     // Catch:{ all -> 0x00be }
            goto L_0x00b6
        L_0x00ab:
            int r0 = r1.length     // Catch:{ all -> 0x00be }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)     // Catch:{ all -> 0x00be }
            java.lang.Class[] r0 = (java.lang.Class[]) r0     // Catch:{ all -> 0x00be }
            java.lang.reflect.Method r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r11, r12, r0)     // Catch:{ all -> 0x00be }
        L_0x00b6:
            if (r11 == 0) goto L_0x00bd
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = methodMap     // Catch:{ all -> 0x00be }
            r0.put(r12, r11)     // Catch:{ all -> 0x00be }
        L_0x00bd:
            return r11
        L_0x00be:
            r11 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r11, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    public final ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            if (isBillingSupported(context, obj, str)) {
                Object obj2 = null;
                int i = 0;
                boolean z = false;
                do {
                    Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{Integer.valueOf(6), PACKAGE_NAME, str, obj2, new Bundle()});
                    if (invokeMethod != null) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        Bundle bundle = (Bundle) invokeMethod;
                        if (bundle.getInt("RESPONSE_CODE") == 0) {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                            if (stringArrayList != null) {
                                Iterator<String> it = stringArrayList.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    String next = it.next();
                                    try {
                                        if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                            z = true;
                                            break;
                                        }
                                        arrayList.add(next);
                                        i++;
                                    } catch (JSONException unused) {
                                    }
                                }
                                obj2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                                if (i >= 30 || obj2 == null) {
                                    break;
                                }
                            }
                        }
                    }
                    obj2 = null;
                } while (!z);
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0062 A[EDGE_INSN: B:27:0x0062->B:21:0x0062 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            if (r14 != 0) goto L_0x0010
            return r0
        L_0x0010:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0062
            r2 = 0
            r3 = r1
            r4 = 0
        L_0x0019:
            r5 = 4
            java.lang.Object[] r11 = new java.lang.Object[r5]     // Catch:{ all -> 0x0063 }
            r5 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0063 }
            r11[r2] = r6     // Catch:{ all -> 0x0063 }
            r6 = 1
            java.lang.String r7 = PACKAGE_NAME     // Catch:{ all -> 0x0063 }
            r11[r6] = r7     // Catch:{ all -> 0x0063 }
            r6 = 2
            r11[r6] = r15     // Catch:{ all -> 0x0063 }
            r11[r5] = r3     // Catch:{ all -> 0x0063 }
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r3 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x005b
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)     // Catch:{ all -> 0x0063 }
            if (r5 != 0) goto L_0x005b
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x0062
            int r6 = r5.size()     // Catch:{ all -> 0x0063 }
            int r4 = r4 + r6
            r0.addAll(r5)     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ all -> 0x0063 }
            goto L_0x005c
        L_0x005b:
            r3 = r1
        L_0x005c:
            r5 = 30
            if (r4 >= r5) goto L_0x0062
            if (r3 != 0) goto L_0x0019
        L_0x0062:
            return r0
        L_0x0063:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (obj != null) {
                if (!arrayList.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
                    Object[] objArr = new Object[4];
                    int i = 0;
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = PACKAGE_NAME;
                    objArr[2] = z ? "subs" : "inapp";
                    objArr[3] = bundle;
                    Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
                    if (invokeMethod != null) {
                        Bundle bundle2 = (Bundle) invokeMethod;
                        if (bundle2.getInt("RESPONSE_CODE") == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                                int size = arrayList.size() - 1;
                                if (size >= 0) {
                                    while (true) {
                                        int i2 = i + 1;
                                        String str = arrayList.get(i);
                                        Intrinsics.checkNotNullExpressionValue(str, "skuList[i]");
                                        String str2 = stringArrayList.get(i);
                                        Intrinsics.checkNotNullExpressionValue(str2, "skuDetailsList[i]");
                                        linkedHashMap.put(str, str2);
                                        if (i2 > size) {
                                            break;
                                        }
                                        i = i2;
                                    }
                                }
                            }
                            writeSkuDetailsToCache(linkedHashMap);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null) {
                return null;
            }
            Method method = getMethod(cls, str2);
            if (method == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean isBillingSupported(Context context, Object obj, String str) {
        boolean z = false;
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
            Object invokeMethod = invokeMethod(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{Integer.valueOf(3), PACKAGE_NAME, str});
            if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                String string = skuDetailSharedPrefs.getString(next, null);
                if (string != null) {
                    List split$default = CharsKt__CharKt.split$default((CharSequence) string, new String[]{";"}, false, 2, 2);
                    if (currentTimeMillis - Long.parseLong((String) split$default.get(0)) < 43200) {
                        Intrinsics.checkNotNullExpressionValue(next, "sku");
                        linkedHashMap.put(next, split$default.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void writeSkuDetailsToCache(Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Editor edit = skuDetailSharedPrefs.edit();
                for (Entry next : map.entrySet()) {
                    edit.putString((String) next.getKey(), currentTimeMillis + DefaultObjectDumpFormatter.TOKEN_DIVIDER + ((String) next.getValue()));
                }
                edit.apply();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
