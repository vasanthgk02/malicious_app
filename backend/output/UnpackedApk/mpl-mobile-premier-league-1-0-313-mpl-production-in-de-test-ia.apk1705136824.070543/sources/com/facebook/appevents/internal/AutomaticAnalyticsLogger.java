package com.facebook.appevents.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J.\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", "", "()V", "APP_EVENTS_IF_AUTO_LOG_SUBS", "", "TAG", "kotlin.jvm.PlatformType", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getPurchaseLoggingParameters", "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "purchase", "skuDetails", "extraParameter", "", "isImplicitPurchaseLoggingEnabled", "", "logActivateAppEvent", "", "logActivityTimeSpentEvent", "activityName", "timeSpentInSeconds", "", "logPurchase", "isSubscription", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AutomaticAnalyticsLogger.kt */
public final class AutomaticAnalyticsLogger {
    public static final AutomaticAnalyticsLogger INSTANCE = null;
    public static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "param", "Landroid/os/Bundle;", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AutomaticAnalyticsLogger.kt */
    public static final class PurchaseLoggingParameters {
        public Currency currency;
        public Bundle param;
        public BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency2, Bundle bundle) {
            Intrinsics.checkNotNullParameter(bigDecimal, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency2, "currency");
            Intrinsics.checkNotNullParameter(bundle, "param");
            this.purchaseAmount = bigDecimal;
            this.currency = currency2;
            this.param = bundle;
        }
    }

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
    }

    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        if (appSettingsWithoutQuery != null) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.iAPAutomaticLoggingEnabled) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014e, code lost:
        if ((r13.length() > 0) != false) goto L_0x0152;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void logPurchase(java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            java.lang.String r0 = "freeTrialPeriod"
            java.lang.String r1 = "purchase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "skuDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            boolean r1 = isImplicitPurchaseLoggingEnabled()
            if (r1 != 0) goto L_0x0013
            return
        L_0x0013:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "introductoryPriceCycles"
            r3 = 0
            r4 = 1
            r5 = 0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0111 }
            r6.<init>(r12)     // Catch:{ JSONException -> 0x0111 }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0111 }
            r12.<init>(r13)     // Catch:{ JSONException -> 0x0111 }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ JSONException -> 0x0111 }
            r7.<init>(r4)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_product_id"
            java.lang.String r9 = "productId"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_purchase_time"
            java.lang.String r9 = "purchaseTime"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_purchase_token"
            java.lang.String r9 = "purchaseToken"
            java.lang.String r9 = r6.getString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_package_name"
            java.lang.String r9 = "packageName"
            java.lang.String r9 = r6.optString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_product_title"
            java.lang.String r9 = "title"
            java.lang.String r9 = r12.optString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "fb_iap_product_description"
            java.lang.String r9 = "description"
            java.lang.String r9 = r12.optString(r9)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r8 = "type"
            java.lang.String r8 = r12.optString(r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r9 = "fb_iap_product_type"
            r7.putCharSequence(r9, r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r9 = "subs"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)     // Catch:{ JSONException -> 0x0111 }
            if (r8 == 0) goto L_0x00c6
            java.lang.String r8 = "fb_iap_subs_auto_renewing"
            java.lang.String r9 = "autoRenewing"
            boolean r6 = r6.optBoolean(r9, r5)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = java.lang.Boolean.toString(r6)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r8, r6)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = "fb_iap_subs_period"
            java.lang.String r8 = "subscriptionPeriod"
            java.lang.String r8 = r12.optString(r8)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r6, r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = "fb_free_trial_period"
            java.lang.String r8 = r12.optString(r0)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r6, r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = r12.optString(r2)     // Catch:{ JSONException -> 0x0111 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch:{ JSONException -> 0x0111 }
            int r2 = r6.length()     // Catch:{ JSONException -> 0x0111 }
            if (r2 != 0) goto L_0x00b3
            r2 = 1
            goto L_0x00b4
        L_0x00b3:
            r2 = 0
        L_0x00b4:
            if (r2 != 0) goto L_0x00c6
            java.lang.String r2 = "fb_intro_price_amount_micros"
            java.lang.String r8 = "introductoryPriceAmountMicros"
            java.lang.String r8 = r12.optString(r8)     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r2, r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r2 = "fb_intro_price_cycles"
            r7.putCharSequence(r2, r6)     // Catch:{ JSONException -> 0x0111 }
        L_0x00c6:
            java.util.Set r1 = r1.entrySet()     // Catch:{ JSONException -> 0x0111 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ JSONException -> 0x0111 }
        L_0x00ce:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x0111 }
            if (r2 == 0) goto L_0x00ea
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x0111 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ JSONException -> 0x0111 }
            java.lang.Object r6 = r2.getKey()     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x0111 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x0111 }
            r7.putCharSequence(r6, r2)     // Catch:{ JSONException -> 0x0111 }
            goto L_0x00ce
        L_0x00ea:
            com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters r1 = new com.facebook.appevents.internal.AutomaticAnalyticsLogger$PurchaseLoggingParameters     // Catch:{ JSONException -> 0x0111 }
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = "price_amount_micros"
            long r8 = r12.getLong(r6)     // Catch:{ JSONException -> 0x0111 }
            double r8 = (double) r8     // Catch:{ JSONException -> 0x0111 }
            r10 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r8 = r8 / r10
            r2.<init>(r8)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = "price_currency_code"
            java.lang.String r12 = r12.getString(r6)     // Catch:{ JSONException -> 0x0111 }
            java.util.Currency r12 = java.util.Currency.getInstance(r12)     // Catch:{ JSONException -> 0x0111 }
            java.lang.String r6 = "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r6)     // Catch:{ JSONException -> 0x0111 }
            r1.<init>(r2, r12, r7)     // Catch:{ JSONException -> 0x0111 }
            goto L_0x0112
        L_0x0111:
            r1 = r3
        L_0x0112:
            if (r1 != 0) goto L_0x0115
            return
        L_0x0115:
            if (r14 == 0) goto L_0x0129
            com.facebook.internal.FetchedAppGateKeepersManager r12 = com.facebook.internal.FetchedAppGateKeepersManager.INSTANCE
            com.facebook.FacebookSdk r12 = com.facebook.FacebookSdk.INSTANCE
            java.lang.String r12 = com.facebook.FacebookSdk.getApplicationId()
            java.lang.String r14 = "app_events_if_auto_log_subs"
            boolean r12 = com.facebook.internal.FetchedAppGateKeepersManager.getGateKeeperForKey(r14, r12, r5)
            if (r12 == 0) goto L_0x0129
            r12 = 1
            goto L_0x012a
        L_0x0129:
            r12 = 0
        L_0x012a:
            if (r12 == 0) goto L_0x01b3
            com.facebook.appevents.iap.InAppPurchaseEventManager r12 = com.facebook.appevents.iap.InAppPurchaseEventManager.INSTANCE
            boolean r14 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            if (r14 == 0) goto L_0x0135
            goto L_0x0158
        L_0x0135:
            java.lang.String r14 = "skuDetail"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r14)     // Catch:{ all -> 0x0154 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0151 }
            r14.<init>(r13)     // Catch:{ JSONException -> 0x0151 }
            java.lang.String r13 = r14.optString(r0)     // Catch:{ JSONException -> 0x0151 }
            if (r13 == 0) goto L_0x0151
            int r12 = r13.length()     // Catch:{ JSONException -> 0x0151 }
            if (r12 <= 0) goto L_0x014d
            r12 = 1
            goto L_0x014e
        L_0x014d:
            r12 = 0
        L_0x014e:
            if (r12 == 0) goto L_0x0151
            goto L_0x0152
        L_0x0151:
            r4 = 0
        L_0x0152:
            r5 = r4
            goto L_0x0158
        L_0x0154:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
        L_0x0158:
            if (r5 == 0) goto L_0x015d
            java.lang.String r12 = "StartTrial"
            goto L_0x015f
        L_0x015d:
            java.lang.String r12 = "Subscribe"
        L_0x015f:
            r5 = r12
            com.facebook.appevents.InternalAppEventsLogger r12 = internalAppEventsLogger
            java.math.BigDecimal r13 = r1.purchaseAmount
            java.util.Currency r14 = r1.currency
            android.os.Bundle r0 = r1.param
            if (r12 == 0) goto L_0x01b2
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            boolean r1 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()
            if (r1 == 0) goto L_0x01da
            com.facebook.appevents.AppEventsLoggerImpl r12 = r12.loggerImpl
            if (r12 == 0) goto L_0x01b1
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            if (r1 == 0) goto L_0x017d
            goto L_0x01da
        L_0x017d:
            if (r13 == 0) goto L_0x01a7
            if (r14 != 0) goto L_0x0182
            goto L_0x01a7
        L_0x0182:
            if (r0 != 0) goto L_0x0189
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x01ac }
            r0.<init>()     // Catch:{ all -> 0x01ac }
        L_0x0189:
            r7 = r0
            java.lang.String r0 = "fb_currency"
            java.lang.String r14 = r14.getCurrencyCode()     // Catch:{ all -> 0x01ac }
            r7.putString(r0, r14)     // Catch:{ all -> 0x01ac }
            double r13 = r13.doubleValue()     // Catch:{ all -> 0x01ac }
            java.lang.Double r6 = java.lang.Double.valueOf(r13)     // Catch:{ all -> 0x01ac }
            r8 = 1
            com.facebook.appevents.internal.ActivityLifecycleTracker r13 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch:{ all -> 0x01ac }
            java.util.UUID r9 = com.facebook.appevents.internal.ActivityLifecycleTracker.getCurrentSessionGuid()     // Catch:{ all -> 0x01ac }
            r4 = r12
            r4.logEvent(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x01ac }
            goto L_0x01da
        L_0x01a7:
            com.facebook.FacebookSdk r13 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x01ac }
            boolean r12 = com.facebook.FacebookSdk.isDebugEnabledField     // Catch:{ all -> 0x01ac }
            goto L_0x01da
        L_0x01ac:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            goto L_0x01da
        L_0x01b1:
            throw r3
        L_0x01b2:
            throw r3
        L_0x01b3:
            com.facebook.appevents.InternalAppEventsLogger r12 = internalAppEventsLogger
            java.math.BigDecimal r13 = r1.purchaseAmount
            java.util.Currency r14 = r1.currency
            android.os.Bundle r0 = r1.param
            if (r12 == 0) goto L_0x01db
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE
            boolean r1 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()
            if (r1 == 0) goto L_0x01da
            com.facebook.appevents.AppEventsLoggerImpl r12 = r12.loggerImpl
            if (r12 == 0) goto L_0x01d9
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            if (r1 == 0) goto L_0x01d0
            goto L_0x01da
        L_0x01d0:
            r12.logPurchase(r13, r14, r0, r4)     // Catch:{ all -> 0x01d4 }
            goto L_0x01da
        L_0x01d4:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            goto L_0x01da
        L_0x01d9:
            throw r3
        L_0x01da:
            return
        L_0x01db:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchase(java.lang.String, java.lang.String, boolean):void");
    }
}
