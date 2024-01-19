package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mpl.payment.routing.RoutingConstants;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0005()*+,B«\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001fH\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0&2\u0006\u0010#\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "", "context", "Landroid/content/Context;", "billingClient", "billingClientClazz", "Ljava/lang/Class;", "purchaseResultClazz", "purchaseClazz", "skuDetailsClazz", "purchaseHistoryRecordClazz", "skuDetailsResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "queryPurchasesMethod", "Ljava/lang/reflect/Method;", "getPurchaseListMethod", "getOriginalJsonMethod", "getOriginalJsonSkuMethod", "getOriginalJsonPurchaseHistoryMethod", "querySkuDetailsAsyncMethod", "queryPurchaseHistoryAsyncMethod", "inAppPurchaseSkuDetailsWrapper", "Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/facebook/appevents/iap/InAppPurchaseSkuDetailsWrapper;)V", "historyPurchaseSet", "", "", "queryPurchase", "", "skuType", "querySkuRunnable", "Ljava/lang/Runnable;", "queryPurchaseHistory", "queryPurchaseHistoryRunnable", "queryPurchaseHistoryAsync", "runnable", "querySkuDetailsAsync", "skuIDs", "", "startConnection", "BillingClientStateListenerWrapper", "Companion", "PurchaseHistoryResponseListenerWrapper", "PurchasesUpdatedListenerWrapper", "SkuDetailsResponseListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseBillingClientWrapper.kt */
public final class InAppPurchaseBillingClientWrapper {
    public static final Companion Companion = new Companion(null);
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static InAppPurchaseBillingClientWrapper instance;
    public static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    public static final Map<String, JSONObject> purchaseDetailsMap = new ConcurrentHashMap();
    public static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();
    public final Object billingClient;
    public final Class<?> billingClientClazz;
    public final Context context;
    public final Method getOriginalJsonMethod;
    public final Method getOriginalJsonPurchaseHistoryMethod;
    public final Method getOriginalJsonSkuMethod;
    public final Method getPurchaseListMethod;
    public final Set<String> historyPurchaseSet = new CopyOnWriteArraySet();
    public final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    public final Class<?> purchaseClazz;
    public final Class<?> purchaseHistoryRecordClazz;
    public final Class<?> purchaseHistoryResponseListenerClazz;
    public final Class<?> purchaseResultClazz;
    public final Method queryPurchaseHistoryAsyncMethod;
    public final Method queryPurchasesMethod;
    public final Method querySkuDetailsAsyncMethod;
    public final Class<?> skuDetailsClazz;
    public final Class<?> skuDetailsResponseListenerClazz;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$BillingClientStateListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, "m");
                if (Intrinsics.areEqual(method.getName(), "onBillingSetupFinished")) {
                    InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(true);
                } else {
                    String name = method.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "m.name");
                    if (CharsKt__CharKt.endsWith$default(name, (String) "onBillingServiceDisconnected", false, 2)) {
                        InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().set(false);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010,\u001a\u0004\u0018\u00010\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020.H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)¨\u00064"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$Companion;", "", "()V", "CLASSNAME_BILLING_CLIENT", "", "CLASSNAME_BILLING_CLIENT_BUILDER", "CLASSNAME_BILLING_CLIENT_STATE_LISTENER", "CLASSNAME_PURCHASE", "CLASSNAME_PURCHASES_RESULT", "CLASSNAME_PURCHASE_HISTORY_RECORD", "CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER", "CLASSNAME_PURCHASE_UPDATED_LISTENER", "CLASSNAME_SKU_DETAILS", "CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER", "IN_APP", "METHOD_BUILD", "METHOD_ENABLE_PENDING_PURCHASES", "METHOD_GET_ORIGINAL_JSON", "METHOD_GET_PURCHASE_LIST", "METHOD_NEW_BUILDER", "METHOD_ON_BILLING_SERVICE_DISCONNECTED", "METHOD_ON_BILLING_SETUP_FINISHED", "METHOD_ON_PURCHASE_HISTORY_RESPONSE", "METHOD_ON_SKU_DETAILS_RESPONSE", "METHOD_QUERY_PURCHASES", "METHOD_QUERY_PURCHASE_HISTORY_ASYNC", "METHOD_QUERY_SKU_DETAILS_ASYNC", "METHOD_SET_LISTENER", "METHOD_START_CONNECTION", "PACKAGE_NAME", "PRODUCT_ID", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "isServiceConnected", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "purchaseDetailsMap", "", "Lorg/json/JSONObject;", "getPurchaseDetailsMap", "()Ljava/util/Map;", "skuDetailsMap", "getSkuDetailsMap", "createBillingClient", "context", "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "createInstance", "", "getOrCreateInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0163  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0165  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0199 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x019a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void createInstance(android.content.Context r27) {
            /*
                r26 = this;
                java.lang.Class<com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper> r1 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.class
                java.lang.Class<java.lang.String> r2 = java.lang.String.class
                com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper r0 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.Companion
                java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.access$getInitialized$cp()
                boolean r0 = r0.get()
                r3 = 0
                r4 = 1
                java.lang.String r5 = "build"
                java.lang.String r6 = "newBuilder"
                if (r0 == 0) goto L_0x001c
                com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper r0 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.access$getInstance$cp()
            L_0x001a:
                r15 = r0
                goto L_0x007b
            L_0x001c:
                java.lang.String r0 = "com.android.billingclient.api.SkuDetailsParams"
                java.lang.Class r8 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.SkuDetailsParams$Builder"
                java.lang.Class r9 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                if (r8 == 0) goto L_0x006f
                if (r9 != 0) goto L_0x002d
                goto L_0x006f
            L_0x002d:
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.reflect.Method r10 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r8, r6, r0)
                java.lang.Class[] r0 = new java.lang.Class[r4]
                r0[r3] = r2
                java.lang.String r7 = "setType"
                java.lang.reflect.Method r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r9, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r4]
                java.lang.Class<java.util.List> r7 = java.util.List.class
                r0[r3] = r7
                java.lang.String r7 = "setSkusList"
                java.lang.reflect.Method r12 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r9, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.reflect.Method r13 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r9, r5, r0)
                if (r10 == 0) goto L_0x006f
                if (r11 == 0) goto L_0x006f
                if (r12 == 0) goto L_0x006f
                if (r13 != 0) goto L_0x0058
                goto L_0x006f
            L_0x0058:
                com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper r0 = new com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper
                r7 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13)
                java.lang.Class<com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper> r7 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.class
                boolean r8 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                if (r8 == 0) goto L_0x0067
                goto L_0x006f
            L_0x0067:
                com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.instance = r0     // Catch:{ all -> 0x006a }
                goto L_0x006f
            L_0x006a:
                r0 = move-exception
                r8 = r0
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r7)
            L_0x006f:
                java.util.concurrent.atomic.AtomicBoolean r0 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.access$getInitialized$cp()
                r0.set(r4)
                com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper r0 = com.facebook.appevents.iap.InAppPurchaseSkuDetailsWrapper.access$getInstance$cp()
                goto L_0x001a
            L_0x007b:
                if (r15 != 0) goto L_0x007e
                return
            L_0x007e:
                java.lang.String r0 = "com.android.billingclient.api.BillingClient"
                java.lang.Class r10 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.Purchase"
                java.lang.Class r12 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.Purchase$PurchasesResult"
                java.lang.Class r11 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.SkuDetails"
                java.lang.Class r13 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.PurchaseHistoryRecord"
                java.lang.Class r14 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.SkuDetailsResponseListener"
                java.lang.Class r16 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                java.lang.String r0 = "com.android.billingclient.api.PurchaseHistoryResponseListener"
                java.lang.Class r17 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r0)
                if (r10 == 0) goto L_0x01e4
                if (r11 == 0) goto L_0x01e4
                if (r12 == 0) goto L_0x01e4
                if (r13 == 0) goto L_0x01e4
                if (r16 == 0) goto L_0x01e4
                if (r14 == 0) goto L_0x01e4
                if (r17 != 0) goto L_0x00b8
                goto L_0x01e4
            L_0x00b8:
                java.lang.Class[] r0 = new java.lang.Class[r4]
                r0[r3] = r2
                java.lang.String r7 = "queryPurchases"
                java.lang.reflect.Method r18 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r10, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.String r7 = "getPurchasesList"
                java.lang.reflect.Method r19 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r11, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.String r7 = "getOriginalJson"
                java.lang.reflect.Method r20 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r12, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.reflect.Method r21 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r13, r7, r0)
                java.lang.Class[] r0 = new java.lang.Class[r3]
                java.lang.reflect.Method r22 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r14, r7, r0)
                r7 = 2
                java.lang.Class[] r8 = new java.lang.Class[r7]
                boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r15)
                if (r0 == 0) goto L_0x00e8
                goto L_0x00f0
            L_0x00e8:
                java.lang.Class<?> r0 = r15.skuDetailsParamsClazz     // Catch:{ all -> 0x00eb }
                goto L_0x00f1
            L_0x00eb:
                r0 = move-exception
                r9 = r0
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r15)
            L_0x00f0:
                r0 = 0
            L_0x00f1:
                r8[r3] = r0
                r8[r4] = r16
                java.lang.String r0 = "querySkuDetailsAsync"
                java.lang.reflect.Method r0 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r10, r0, r8)
                java.lang.Class[] r7 = new java.lang.Class[r7]
                r7[r3] = r2
                r7[r4] = r17
                java.lang.String r2 = "queryPurchaseHistoryAsync"
                java.lang.reflect.Method r23 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r10, r2, r7)
                if (r18 == 0) goto L_0x01e4
                if (r19 == 0) goto L_0x01e4
                if (r20 == 0) goto L_0x01e4
                if (r21 == 0) goto L_0x01e4
                if (r22 == 0) goto L_0x01e4
                if (r0 == 0) goto L_0x01e4
                if (r23 != 0) goto L_0x0117
                goto L_0x01e4
            L_0x0117:
                java.lang.String r2 = "com.android.billingclient.api.BillingClient$Builder"
                java.lang.Class r2 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r2)
                java.lang.String r7 = "com.android.billingclient.api.PurchasesUpdatedListener"
                java.lang.Class r7 = com.facebook.appevents.iap.InAppPurchaseUtils.getClass(r7)
                if (r2 == 0) goto L_0x0193
                if (r7 != 0) goto L_0x0129
                goto L_0x0193
            L_0x0129:
                java.lang.Class[] r8 = new java.lang.Class[r4]
                java.lang.Class<android.content.Context> r9 = android.content.Context.class
                r8[r3] = r9
                java.lang.reflect.Method r6 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r10, r6, r8)
                java.lang.Class[] r3 = new java.lang.Class[r3]
                java.lang.String r8 = "enablePendingPurchases"
                java.lang.reflect.Method r3 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r2, r8, r3)
                java.lang.Class[] r4 = new java.lang.Class[r4]
                r8 = 0
                r4[r8] = r7
                java.lang.String r9 = "setListener"
                java.lang.reflect.Method r4 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r2, r9, r4)
                java.lang.Class[] r9 = new java.lang.Class[r8]
                java.lang.reflect.Method r5 = com.facebook.appevents.iap.InAppPurchaseUtils.getMethod(r2, r5, r9)
                if (r6 == 0) goto L_0x0193
                if (r3 == 0) goto L_0x0193
                if (r4 == 0) goto L_0x0193
                if (r5 != 0) goto L_0x0155
                goto L_0x0193
            L_0x0155:
                r9 = 1
                r24 = r15
                java.lang.Object[] r15 = new java.lang.Object[r9]
                r15[r8] = r27
                r8 = 0
                java.lang.Object r6 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r10, r6, r8, r15)
                if (r6 != 0) goto L_0x0165
                r9 = r8
                goto L_0x0197
            L_0x0165:
                java.lang.ClassLoader r8 = r7.getClassLoader()
                java.lang.Class[] r9 = new java.lang.Class[r9]
                r15 = 0
                r9[r15] = r7
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper r7 = new com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper
                r7.<init>()
                java.lang.Object r7 = java.lang.reflect.Proxy.newProxyInstance(r8, r9, r7)
                r8 = 1
                java.lang.Object[] r8 = new java.lang.Object[r8]
                r8[r15] = r7
                java.lang.Object r4 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r2, r4, r6, r8)
                if (r4 != 0) goto L_0x0183
                goto L_0x0195
            L_0x0183:
                java.lang.Object[] r6 = new java.lang.Object[r15]
                java.lang.Object r3 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r2, r3, r4, r6)
                if (r3 != 0) goto L_0x018c
                goto L_0x0195
            L_0x018c:
                java.lang.Object[] r4 = new java.lang.Object[r15]
                java.lang.Object r2 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r2, r5, r3, r4)
                goto L_0x0196
            L_0x0193:
                r24 = r15
            L_0x0195:
                r2 = 0
            L_0x0196:
                r9 = r2
            L_0x0197:
                if (r9 != 0) goto L_0x019a
                return
            L_0x019a:
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r2 = new com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
                r7 = r2
                r25 = 0
                r8 = r27
                r3 = r24
                r15 = r16
                r16 = r17
                r17 = r18
                r18 = r19
                r19 = r20
                r20 = r21
                r21 = r22
                r22 = r0
                r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
                boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                if (r0 == 0) goto L_0x01bd
                goto L_0x01c5
            L_0x01bd:
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.instance = r2     // Catch:{ all -> 0x01c0 }
                goto L_0x01c5
            L_0x01c0:
                r0 = move-exception
                r2 = r0
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r1)
            L_0x01c5:
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r0 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.access$getInstance$cp()
                if (r0 == 0) goto L_0x01dc
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                if (r2 == 0) goto L_0x01d2
                goto L_0x01db
            L_0x01d2:
                r0.startConnection()     // Catch:{ all -> 0x01d6 }
                goto L_0x01db
            L_0x01d6:
                r0 = move-exception
                r2 = r0
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r1)
            L_0x01db:
                return
            L_0x01dc:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                java.lang.String r1 = "null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper"
                r0.<init>(r1)
                throw r0
            L_0x01e4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion.createInstance(android.content.Context):void");
        }

        public final Map<String, JSONObject> getPurchaseDetailsMap() {
            Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
            Map<String, JSONObject> map = null;
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return map;
            }
            try {
                return InAppPurchaseBillingClientWrapper.purchaseDetailsMap;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return map;
            }
        }

        public final Map<String, JSONObject> getSkuDetailsMap() {
            Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
            Map<String, JSONObject> map = null;
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return map;
            }
            try {
                return InAppPurchaseBillingClientWrapper.skuDetailsMap;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return map;
            }
        }

        public final AtomicBoolean isServiceConnected() {
            Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
            AtomicBoolean atomicBoolean = null;
            if (CrashShieldHandler.isObjectCrashing(cls)) {
                return atomicBoolean;
            }
            try {
                return InAppPurchaseBillingClientWrapper.isServiceConnected;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return atomicBoolean;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J0\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchaseHistoryResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "getPurchaseHistoryRecord", "", "purchaseHistoryRecordList", "", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;
        public final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public PurchaseHistoryResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r2v6, types: [android.content.Context] */
        /* JADX WARNING: type inference failed for: r5v1, types: [java.util.Set] */
        /* JADX WARNING: type inference failed for: r5v4, types: [java.util.Set<java.lang.String>] */
        /* JADX WARNING: type inference failed for: r2v10 */
        /* JADX WARNING: type inference failed for: r2v12, types: [android.content.Context] */
        /* JADX WARNING: type inference failed for: r5v5 */
        /* JADX WARNING: type inference failed for: r2v15 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0047 A[Catch:{ Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x004a A[Catch:{ Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x004d A[Catch:{ Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x004e A[Catch:{ Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0073 A[Catch:{ Exception -> 0x000f }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x000f A[SYNTHETIC] */
        /* JADX WARNING: Unknown variable types count: 2 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void getPurchaseHistoryRecord(java.util.List<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "productId"
                java.lang.Class<com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper> r1 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                if (r2 == 0) goto L_0x000b
                return
            L_0x000b:
                java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00a0 }
            L_0x000f:
                boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00a0 }
                if (r2 == 0) goto L_0x009a
                java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00a0 }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r3 = r7.this$0     // Catch:{ Exception -> 0x000f }
                boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x000f }
                r5 = 0
                if (r4 == 0) goto L_0x0023
                goto L_0x002a
            L_0x0023:
                java.lang.Class<?> r3 = r3.purchaseHistoryRecordClazz     // Catch:{ all -> 0x0026 }
                goto L_0x002b
            L_0x0026:
                r3 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ Exception -> 0x000f }
            L_0x002a:
                r3 = r5
            L_0x002b:
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r4 = r7.this$0     // Catch:{ Exception -> 0x000f }
                boolean r6 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x000f }
                if (r6 == 0) goto L_0x0034
                goto L_0x003b
            L_0x0034:
                java.lang.reflect.Method r4 = r4.getOriginalJsonPurchaseHistoryMethod     // Catch:{ all -> 0x0037 }
                goto L_0x003c
            L_0x0037:
                r4 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ Exception -> 0x000f }
            L_0x003b:
                r4 = r5
            L_0x003c:
                r6 = 0
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x000f }
                java.lang.Object r2 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r3, r4, r2, r6)     // Catch:{ Exception -> 0x000f }
                boolean r3 = r2 instanceof java.lang.String     // Catch:{ Exception -> 0x000f }
                if (r3 == 0) goto L_0x004a
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x000f }
                goto L_0x004b
            L_0x004a:
                r2 = r5
            L_0x004b:
                if (r2 != 0) goto L_0x004e
                goto L_0x000f
            L_0x004e:
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x000f }
                r3.<init>(r2)     // Catch:{ Exception -> 0x000f }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r2 = r7.this$0     // Catch:{ Exception -> 0x000f }
                boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x000f }
                if (r4 == 0) goto L_0x005c
                goto L_0x0063
            L_0x005c:
                android.content.Context r2 = r2.context     // Catch:{ all -> 0x005f }
                goto L_0x0064
            L_0x005f:
                r2 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r1)     // Catch:{ Exception -> 0x000f }
            L_0x0063:
                r2 = r5
            L_0x0064:
                java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x000f }
                java.lang.String r4 = "packageName"
                r3.put(r4, r2)     // Catch:{ Exception -> 0x000f }
                boolean r2 = r3.has(r0)     // Catch:{ Exception -> 0x000f }
                if (r2 == 0) goto L_0x000f
                java.lang.String r2 = r3.getString(r0)     // Catch:{ Exception -> 0x000f }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r4 = r7.this$0     // Catch:{ Exception -> 0x000f }
                boolean r6 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x000f }
                if (r6 == 0) goto L_0x0080
                goto L_0x0087
            L_0x0080:
                java.util.Set<java.lang.String> r5 = r4.historyPurchaseSet     // Catch:{ all -> 0x0083 }
                goto L_0x0087
            L_0x0083:
                r4 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ Exception -> 0x000f }
            L_0x0087:
                r5.add(r2)     // Catch:{ Exception -> 0x000f }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$Companion r4 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion     // Catch:{ Exception -> 0x000f }
                java.util.Map r4 = r4.getPurchaseDetailsMap()     // Catch:{ Exception -> 0x000f }
                java.lang.String r5 = "skuID"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ Exception -> 0x000f }
                r4.put(r2, r3)     // Catch:{ Exception -> 0x000f }
                goto L_0x000f
            L_0x009a:
                java.lang.Runnable r8 = r7.runnable     // Catch:{ all -> 0x00a0 }
                r8.run()     // Catch:{ all -> 0x00a0 }
                return
            L_0x00a0:
                r8 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.PurchaseHistoryResponseListenerWrapper.getPurchaseHistoryRecord(java.util.List):void");
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, AnalyticsConstants.METHOD);
                if (Intrinsics.areEqual(method.getName(), "onPurchaseHistoryResponse")) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        getPurchaseHistoryRecord(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$PurchasesUpdatedListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "()V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, "m");
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper$SkuDetailsResponseListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "runnable", "Ljava/lang/Runnable;", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;Ljava/lang/Runnable;)V", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "invoke", "", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "parseSkuDetails", "", "skuDetailsObjectList", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        public Runnable runnable;
        public final /* synthetic */ InAppPurchaseBillingClientWrapper this$0;

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable2) {
            Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
            Intrinsics.checkNotNullParameter(runnable2, "runnable");
            this.this$0 = inAppPurchaseBillingClientWrapper;
            this.runnable = runnable2;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            List list;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, "proxy");
                Intrinsics.checkNotNullParameter(method, "m");
                if (Intrinsics.areEqual(method.getName(), "onSkuDetailsResponse")) {
                    if (objArr == null) {
                        list = null;
                    } else {
                        list = objArr[1];
                    }
                    if (list != null && (list instanceof List)) {
                        parseSkuDetails(list);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A[SYNTHETIC, Splitter:B:22:0x0039] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[Catch:{ Exception -> 0x0014 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0051 A[Catch:{ Exception -> 0x0014 }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0052 A[Catch:{ Exception -> 0x0014 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void parseSkuDetails(java.util.List<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "productId"
                java.lang.Class<com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper> r1 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
                if (r2 == 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.String r2 = "skuDetailsObjectList"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)     // Catch:{ all -> 0x0076 }
                java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0076 }
            L_0x0014:
                boolean r2 = r8.hasNext()     // Catch:{ all -> 0x0076 }
                if (r2 == 0) goto L_0x0070
                java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x0076 }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r3 = r7.this$0     // Catch:{ Exception -> 0x0014 }
                boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x0014 }
                r5 = 0
                if (r4 == 0) goto L_0x0028
                goto L_0x002f
            L_0x0028:
                java.lang.Class<?> r3 = r3.skuDetailsClazz     // Catch:{ all -> 0x002b }
                goto L_0x0030
            L_0x002b:
                r3 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ Exception -> 0x0014 }
            L_0x002f:
                r3 = r5
            L_0x0030:
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper r4 = r7.this$0     // Catch:{ Exception -> 0x0014 }
                boolean r6 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ Exception -> 0x0014 }
                if (r6 == 0) goto L_0x0039
                goto L_0x0040
            L_0x0039:
                java.lang.reflect.Method r4 = r4.getOriginalJsonSkuMethod     // Catch:{ all -> 0x003c }
                goto L_0x0041
            L_0x003c:
                r4 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ Exception -> 0x0014 }
            L_0x0040:
                r4 = r5
            L_0x0041:
                r6 = 0
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0014 }
                java.lang.Object r2 = com.facebook.appevents.iap.InAppPurchaseUtils.invokeMethod(r3, r4, r2, r6)     // Catch:{ Exception -> 0x0014 }
                boolean r3 = r2 instanceof java.lang.String     // Catch:{ Exception -> 0x0014 }
                if (r3 == 0) goto L_0x004f
                r5 = r2
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0014 }
            L_0x004f:
                if (r5 != 0) goto L_0x0052
                goto L_0x0014
            L_0x0052:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0014 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x0014 }
                boolean r3 = r2.has(r0)     // Catch:{ Exception -> 0x0014 }
                if (r3 == 0) goto L_0x0014
                java.lang.String r3 = r2.getString(r0)     // Catch:{ Exception -> 0x0014 }
                com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper$Companion r4 = com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.Companion     // Catch:{ Exception -> 0x0014 }
                java.util.Map r4 = r4.getSkuDetailsMap()     // Catch:{ Exception -> 0x0014 }
                java.lang.String r5 = "skuID"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ Exception -> 0x0014 }
                r4.put(r3, r2)     // Catch:{ Exception -> 0x0014 }
                goto L_0x0014
            L_0x0070:
                java.lang.Runnable r8 = r7.runnable     // Catch:{ all -> 0x0076 }
                r8.run()     // Catch:{ all -> 0x0076 }
                return
            L_0x0076:
                r8 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper.SkuDetailsResponseListenerWrapper.parseSkuDetails(java.util.List):void");
        }
    }

    public InAppPurchaseBillingClientWrapper(Context context2, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper2, DefaultConstructorMarker defaultConstructorMarker) {
        this.context = context2;
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper2;
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialized$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapper access$getInstance$cp() {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: queryPurchaseHistory$lambda-0  reason: not valid java name */
    public static final void m171queryPurchaseHistory$lambda0(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable) {
        Class<InAppPurchaseBillingClientWrapper> cls = InAppPurchaseBillingClientWrapper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(inAppPurchaseBillingClientWrapper, "this$0");
                Intrinsics.checkNotNullParameter(runnable, "$queryPurchaseHistoryRunnable");
                inAppPurchaseBillingClientWrapper.querySkuDetailsAsync("inapp", new ArrayList(inAppPurchaseBillingClientWrapper.historyPurchaseSet), runnable);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void queryPurchase(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(str, "skuType");
                Intrinsics.checkNotNullParameter(runnable, "querySkuRunnable");
                Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseResultClazz, this.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchasesMethod, this.billingClient, "inapp"), new Object[0]);
                List<Object> list = invokeMethod instanceof List ? (List) invokeMethod : null;
                if (list != null) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Object invokeMethod2 : list) {
                            Object invokeMethod3 = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.getOriginalJsonMethod, invokeMethod2, new Object[0]);
                            String str2 = invokeMethod3 instanceof String ? (String) invokeMethod3 : null;
                            if (str2 != null) {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.has(RoutingConstants.KILLBILL_TPSL_PRODUCT_ID)) {
                                    String string = jSONObject.getString(RoutingConstants.KILLBILL_TPSL_PRODUCT_ID);
                                    arrayList.add(string);
                                    Map<String, JSONObject> map = purchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(string, "skuID");
                                    map.put(string, jSONObject);
                                }
                            }
                        }
                        querySkuDetailsAsync(str, arrayList, runnable);
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void queryPurchaseHistoryAsync(String str, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this, runnable));
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.queryPurchaseHistoryAsyncMethod, this.billingClient, str, newProxyInstance);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void querySkuDetailsAsync(String str, List<String> list, Runnable runnable) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(this.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this, runnable));
                Object skuDetailsParams = this.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(str, list);
                InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.querySkuDetailsAsyncMethod, this.billingClient, skuDetailsParams, newProxyInstance);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void startConnection() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Class<?> cls = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClientStateListener");
                if (cls != null) {
                    Method method = InAppPurchaseUtils.getMethod(this.billingClientClazz, "startConnection", cls);
                    if (method != null) {
                        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper());
                        InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, this.billingClient, newProxyInstance);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
