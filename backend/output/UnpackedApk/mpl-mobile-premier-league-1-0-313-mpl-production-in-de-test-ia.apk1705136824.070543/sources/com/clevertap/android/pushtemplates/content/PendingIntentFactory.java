package com.clevertap.android.pushtemplates.content;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.pushnotification.CTNotificationIntentService;
import com.mpl.androidapp.utils.Constant;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J<\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J*\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/clevertap/android/pushtemplates/content/PendingIntentFactory;", "", "()V", "launchIntent", "Landroid/content/Intent;", "getLaunchIntent", "()Landroid/content/Intent;", "setLaunchIntent", "(Landroid/content/Intent;)V", "getCtaLaunchPendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "dl", "", "notificationId", "", "getPendingIntent", "isLauncher", "", "identifier", "renderer", "Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "setDismissIntent", "intent", "setPendingIntent", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PendingIntentFactory.kt */
public final class PendingIntentFactory {
    public static Intent launchIntent;

    public static final PendingIntent getCtaLaunchPendingIntent(Context context, Bundle bundle, String str, int i) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(str, "dl");
        try {
            cls = Class.forName("com.clevertap.android.sdk.pushnotification.CTNotificationIntentService");
        } catch (ClassNotFoundException unused) {
            k.debug("No Intent Service found");
            cls = null;
        }
        boolean isServiceAvailable = Utils.isServiceAvailable(context, cls);
        if (VERSION.SDK_INT >= 31 || !isServiceAvailable) {
            bundle.putString("wzrk_dl", str);
            PendingIntent activityIntent = k.getActivityIntent(bundle, context);
            Intrinsics.checkNotNullExpressionValue(activityIntent, "{\n            extras.put…xtras, context)\n        }");
            return activityIntent;
        }
        bundle.putBoolean("autoCancel", true);
        bundle.putInt(Constant.NOTIFICATION_ID, i);
        Intent intent = new Intent(CTNotificationIntentService.MAIN_ACTION);
        launchIntent = intent;
        Intrinsics.checkNotNull(intent);
        intent.putExtras(bundle);
        Intent intent2 = launchIntent;
        Intrinsics.checkNotNull(intent2);
        intent2.putExtra("dl", str);
        Intent intent3 = launchIntent;
        Intrinsics.checkNotNull(intent3);
        intent3.setPackage(context.getPackageName());
        Intent intent4 = launchIntent;
        Intrinsics.checkNotNull(intent4);
        intent4.putExtra("ct_type", CTNotificationIntentService.TYPE_BUTTON_CLICK);
        int i2 = 134217728;
        if (VERSION.SDK_INT >= 23) {
            i2 = 201326592;
        }
        int currentTimeMillis = (int) System.currentTimeMillis();
        Intent intent5 = launchIntent;
        Intrinsics.checkNotNull(intent5);
        PendingIntent service = PendingIntent.getService(context, currentTimeMillis, intent5, i2);
        Intrinsics.checkNotNullExpressionValue(service, "{\n            extras.put…t\n            )\n        }");
        return service;
    }

    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v8, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v10, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v11, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v13, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v16, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v17, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v18, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v20, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v22, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v23, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v24, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v25, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v26, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r0v27, types: [java.util.ArrayList<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r0v28, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r0v29, types: [com.clevertap.android.sdk.CleverTapInstanceConfig] */
    /* JADX WARNING: type inference failed for: r0v30 */
    /* JADX WARNING: type inference failed for: r0v31 */
    /* JADX WARNING: type inference failed for: r0v32 */
    /* JADX WARNING: type inference failed for: r0v33 */
    /* JADX WARNING: type inference failed for: r0v34 */
    /* JADX WARNING: type inference failed for: r0v35 */
    /* JADX WARNING: type inference failed for: r0v36 */
    /* JADX WARNING: type inference failed for: r0v37 */
    /* JADX WARNING: type inference failed for: r0v38 */
    /* JADX WARNING: type inference failed for: r0v39 */
    /* JADX WARNING: type inference failed for: r0v40 */
    /* JADX WARNING: type inference failed for: r0v41 */
    /* JADX WARNING: type inference failed for: r0v42 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.clevertap.android.sdk.CleverTapInstanceConfig, java.lang.String, java.util.ArrayList<java.lang.String>]
      uses: [java.lang.String, android.os.Parcelable, java.lang.Object, java.util.ArrayList]
      mth insns count: 400
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.app.PendingIntent getPendingIntent(android.content.Context r10, int r11, android.os.Bundle r12, boolean r13, int r14, com.clevertap.android.pushtemplates.TemplateRenderer r15) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 0
            launchIntent = r0
            r1 = 31
            if (r13 == 0) goto L_0x001f
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 >= r1) goto L_0x001f
            android.content.Intent r13 = new android.content.Intent
            java.lang.Class<com.clevertap.android.pushtemplates.PTPushNotificationReceiver> r2 = com.clevertap.android.pushtemplates.PTPushNotificationReceiver.class
            r13.<init>(r10, r2)
            launchIntent = r13
            goto L_0x002a
        L_0x001f:
            if (r13 != 0) goto L_0x002a
            android.content.Intent r13 = new android.content.Intent
            java.lang.Class<com.clevertap.android.pushtemplates.PushTemplateReceiver> r2 = com.clevertap.android.pushtemplates.PushTemplateReceiver.class
            r13.<init>(r10, r2)
            launchIntent = r13
        L_0x002a:
            int r13 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 0
            if (r13 < r2) goto L_0x0034
            r13 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0035
        L_0x0034:
            r13 = 0
        L_0x0035:
            java.lang.String r2 = "right_swipe"
            r4 = 2
            java.lang.String r5 = "clickedStar"
            java.lang.String r6 = "config"
            java.lang.String r7 = "wzrk_dl"
            java.lang.String r8 = "notificationId"
            r9 = 1
            switch(r14) {
                case 1: goto L_0x03e6;
                case 2: goto L_0x03e6;
                case 3: goto L_0x03e6;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01ce;
                case 6: goto L_0x01c2;
                case 7: goto L_0x01aa;
                case 8: goto L_0x0168;
                case 9: goto L_0x0126;
                case 10: goto L_0x00e3;
                case 11: goto L_0x00a0;
                case 12: goto L_0x005d;
                case 13: goto L_0x0053;
                default: goto L_0x0044;
            }
        L_0x0044:
            java.lang.String r1 = "pt_current_position"
            java.lang.String r2 = "pt_buy_now_dl"
            switch(r14) {
                case 19: goto L_0x041e;
                case 20: goto L_0x03e6;
                case 21: goto L_0x03a5;
                case 22: goto L_0x0364;
                case 23: goto L_0x0323;
                case 24: goto L_0x030b;
                case 25: goto L_0x02f3;
                case 26: goto L_0x02db;
                case 27: goto L_0x0280;
                case 28: goto L_0x0274;
                case 29: goto L_0x03e6;
                case 30: goto L_0x03e6;
                case 31: goto L_0x03e6;
                case 32: goto L_0x020c;
                default: goto L_0x004b;
            }
        L_0x004b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "invalid pendingIntentType"
            r10.<init>(r11)
            throw r10
        L_0x0053:
            r12.putString(r7, r0)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x005d:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r14 = "click5"
            r12.putExtra(r14, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r14 = 5
            r12.putExtra(r5, r14)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x008a:
            r11.putExtra(r6, r0)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x00a0:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r14 = "click4"
            r12.putExtra(r14, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r14 = 4
            r12.putExtra(r5, r14)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x00cb
            goto L_0x00cd
        L_0x00cb:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x00cd:
            r11.putExtra(r6, r0)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x00e3:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r14 = "click3"
            r12.putExtra(r14, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r14 = 3
            r12.putExtra(r5, r14)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x010e
            goto L_0x0110
        L_0x010e:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x0110:
            r11.putExtra(r6, r0)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x0126:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r14 = "click2"
            r12.putExtra(r14, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r5, r4)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x0152:
            r11.putExtra(r6, r0)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x0168:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.String r14 = "click1"
            r12.putExtra(r14, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r5, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x0192
            goto L_0x0194
        L_0x0192:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x0194:
            r11.putExtra(r6, r0)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x01aa:
            if (r15 != 0) goto L_0x01ad
            goto L_0x01af
        L_0x01ad:
            java.lang.String r0 = r15.pt_rating_default_dl
        L_0x01af:
            r12.putString(r7, r0)
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 >= r1) goto L_0x01bd
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            goto L_0x01c1
        L_0x01bd:
            android.app.PendingIntent r10 = co.hyperverge.hypersnapsdk.c.k.getActivityIntent(r12, r10)
        L_0x01c1:
            return r10
        L_0x01c2:
            android.content.Intent r11 = new android.content.Intent
            java.lang.Class<com.clevertap.android.pushtemplates.PushTemplateReceiver> r13 = com.clevertap.android.pushtemplates.PushTemplateReceiver.class
            r11.<init>(r10, r13)
            android.app.PendingIntent r10 = setDismissIntent(r10, r12, r11)
            return r10
        L_0x01ce:
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtra(r2, r3)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtra(r8, r11)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtras(r12)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x01ed:
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtra(r2, r9)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtra(r8, r11)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            r13.putExtras(r12)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x020c:
            if (r15 != 0) goto L_0x0210
            r13 = r0
            goto L_0x0212
        L_0x0210:
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
        L_0x0212:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x022d
            if (r15 != 0) goto L_0x021f
            r13 = r0
            goto L_0x0221
        L_0x021f:
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
        L_0x0221:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Object r13 = r13.get(r3)
            java.lang.String r13 = (java.lang.String) r13
            r12.putString(r7, r13)
        L_0x022d:
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            if (r15 != 0) goto L_0x0236
            r14 = r0
            goto L_0x0238
        L_0x0236:
            java.lang.String r14 = r15.pt_input_feedback
        L_0x0238:
            java.lang.String r1 = "pt_input_feedback"
            r13.putExtra(r1, r14)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            if (r15 != 0) goto L_0x0246
            r14 = r0
            goto L_0x0248
        L_0x0246:
            java.lang.String r14 = r15.pt_input_auto_open
        L_0x0248:
            java.lang.String r1 = "pt_input_auto_open"
            r13.putExtra(r1, r14)
            android.content.Intent r13 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            if (r15 != 0) goto L_0x0256
            r14 = r0
            goto L_0x0258
        L_0x0256:
            com.clevertap.android.sdk.CleverTapInstanceConfig r14 = r15.config
        L_0x0258:
            r13.putExtra(r6, r14)
            if (r15 != 0) goto L_0x025f
            r13 = r0
            goto L_0x0261
        L_0x025f:
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
        L_0x0261:
            if (r13 == 0) goto L_0x026a
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            goto L_0x0273
        L_0x026a:
            r12.putString(r7, r0)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
        L_0x0273:
            return r10
        L_0x0274:
            android.content.Intent r11 = new android.content.Intent
            java.lang.Class<com.clevertap.android.pushtemplates.PushTemplateReceiver> r13 = com.clevertap.android.pushtemplates.PushTemplateReceiver.class
            r11.<init>(r10, r13)
            android.app.PendingIntent r10 = setDismissIntent(r10, r12, r11)
            return r10
        L_0x0280:
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            java.lang.String r1 = "img1"
            r14.putExtra(r1, r9)
            android.content.Intent r14 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            r14.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x029b
            r14 = r0
            goto L_0x029d
        L_0x029b:
            java.util.ArrayList<java.lang.String> r14 = r15.deepLinkList
        L_0x029d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            java.lang.Object r14 = r14.get(r3)
            java.lang.String r14 = (java.lang.String) r14
            r11.putExtra(r2, r14)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.String r14 = "buynow"
            r11.putExtra(r14, r9)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x02bb
            goto L_0x02bd
        L_0x02bb:
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r15.config
        L_0x02bd:
            r11.putExtra(r6, r0)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.putExtras(r12)
            java.util.Random r11 = new java.util.Random
            r11.<init>()
            int r11 = r11.nextInt()
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r11, r12, r13)
            return r10
        L_0x02db:
            if (r15 != 0) goto L_0x02de
            goto L_0x02e0
        L_0x02de:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x02e0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r13 = r0.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            r12.putString(r7, r13)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x02f3:
            if (r15 != 0) goto L_0x02f6
            goto L_0x02f8
        L_0x02f6:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x02f8:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r13 = r0.get(r9)
            java.lang.String r13 = (java.lang.String) r13
            r12.putString(r7, r13)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x030b:
            if (r15 != 0) goto L_0x030e
            goto L_0x0310
        L_0x030e:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x0310:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r13 = r0.get(r3)
            java.lang.String r13 = (java.lang.String) r13
            r12.putString(r7, r13)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            return r10
        L_0x0323:
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            int r14 = r14.nextInt()
            android.content.Intent r3 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r1, r4)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x034c
            goto L_0x034e
        L_0x034c:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x034e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r12 = r0.get(r4)
            java.lang.String r12 = (java.lang.String) r12
            r11.putExtra(r2, r12)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r14, r11, r13)
            return r10
        L_0x0364:
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            int r14 = r14.nextInt()
            android.content.Intent r3 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r3.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r1, r9)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x038d
            goto L_0x038f
        L_0x038d:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x038f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r12 = r0.get(r9)
            java.lang.String r12 = (java.lang.String) r12
            r11.putExtra(r2, r12)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r14, r11, r13)
            return r10
        L_0x03a5:
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            int r14 = r14.nextInt()
            android.content.Intent r4 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r4.putExtras(r12)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r1, r3)
            android.content.Intent r12 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            r12.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            if (r15 != 0) goto L_0x03ce
            goto L_0x03d0
        L_0x03ce:
            java.util.ArrayList<java.lang.String> r0 = r15.deepLinkList
        L_0x03d0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r12 = r0.get(r3)
            java.lang.String r12 = (java.lang.String) r12
            r11.putExtra(r2, r12)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r14, r11, r13)
            return r10
        L_0x03e6:
            if (r15 != 0) goto L_0x03ea
            r13 = r0
            goto L_0x03ec
        L_0x03ea:
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
        L_0x03ec:
            if (r13 == 0) goto L_0x040e
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.size()
            if (r13 <= 0) goto L_0x040e
            java.util.ArrayList<java.lang.String> r13 = r15.deepLinkList
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Object r13 = r13.get(r3)
            java.lang.String r13 = (java.lang.String) r13
            r12.putString(r7, r13)
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
            goto L_0x041d
        L_0x040e:
            java.lang.Object r13 = r12.get(r7)
            if (r13 != 0) goto L_0x0417
            r12.putString(r7, r0)
        L_0x0417:
            android.content.Intent r13 = launchIntent
            android.app.PendingIntent r10 = setPendingIntent(r10, r11, r12, r13)
        L_0x041d:
            return r10
        L_0x041e:
            java.util.Random r14 = new java.util.Random
            r14.<init>()
            int r14 = r14.nextInt()
            android.content.Intent r15 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            java.lang.String r0 = "close"
            r15.putExtra(r0, r9)
            android.content.Intent r15 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r15.putExtra(r8, r11)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r11.putExtras(r12)
            android.content.Intent r11 = launchIntent
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            android.app.PendingIntent r10 = android.app.PendingIntent.getBroadcast(r10, r14, r11, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.content.PendingIntentFactory.getPendingIntent(android.content.Context, int, android.os.Bundle, boolean, int, com.clevertap.android.pushtemplates.TemplateRenderer):android.app.PendingIntent");
    }

    public static final PendingIntent setDismissIntent(Context context, Bundle bundle, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
        intent.putExtras(bundle);
        intent.putExtra("pt_dismiss_intent", true);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, VERSION.SDK_INT >= 31 ? 301989888 : ClientDefaults.MAX_MSG_SIZE);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …chPendingIntent\n        )");
        return broadcast;
    }

    public static final PendingIntent setPendingIntent(Context context, int i, Bundle bundle, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Object obj = bundle.get("wzrk_dl");
        bundle.putInt(Constant.NOTIFICATION_ID, i);
        if (obj != null) {
            bundle.putBoolean("default_dl", true);
        }
        if (intent == null) {
            PendingIntent activityIntent = k.getActivityIntent(bundle, context);
            Intrinsics.checkNotNullExpressionValue(activityIntent, "getActivityIntent(extras, context)");
            return activityIntent;
        }
        intent.putExtras(bundle);
        intent.removeExtra("wzrk_acts");
        intent.putExtra("wzrk_from", "CTPushNotificationReceiver");
        intent.setFlags(872415232);
        int i2 = 134217728;
        if (VERSION.SDK_INT >= 31) {
            i2 = 167772160;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, i2);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …ndingIntent\n            )");
        return broadcast;
    }
}
