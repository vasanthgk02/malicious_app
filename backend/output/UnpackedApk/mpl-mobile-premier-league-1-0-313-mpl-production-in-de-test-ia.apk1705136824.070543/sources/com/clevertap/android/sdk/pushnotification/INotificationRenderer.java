package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat.Builder;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import org.json.JSONArray;

public interface INotificationRenderer {

    /* renamed from: com.clevertap.android.sdk.pushnotification.INotificationRenderer$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            r6 = java.lang.Class.forName("com.clevertap.android.sdk.pushnotification.CTNotificationIntentService");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
            com.clevertap.android.sdk.Logger.d("No Intent Service found");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x001e */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A[SYNTHETIC, Splitter:B:44:0x00ba] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00ec A[Catch:{ all -> 0x0089, all -> 0x017d }] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x010b A[Catch:{ all -> 0x0089, all -> 0x017d }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x012e A[Catch:{ all -> 0x0089, all -> 0x017d }] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0152 A[Catch:{ all -> 0x017b }] */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0162 A[Catch:{ all -> 0x017b }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0166 A[Catch:{ all -> 0x017b }] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x016b A[Catch:{ all -> 0x017b }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static androidx.core.app.NotificationCompat.Builder $default$setActionButtons(com.clevertap.android.sdk.pushnotification.INotificationRenderer r16, android.content.Context r17, android.os.Bundle r18, int r19, androidx.core.app.NotificationCompat.Builder r20, org.json.JSONArray r21) {
            /*
                r1 = r17
                r2 = r18
                r3 = r20
                r4 = r21
                java.lang.String r5 = "dl"
                com.clevertap.android.sdk.ManifestInfo r0 = com.clevertap.android.sdk.ManifestInfo.getInstance(r17)
                r6 = 0
                if (r0 == 0) goto L_0x0199
                java.lang.String r0 = com.clevertap.android.sdk.ManifestInfo.intentServiceName
                java.lang.String r7 = "No Intent Service found"
                java.lang.String r8 = "com.clevertap.android.sdk.pushnotification.CTNotificationIntentService"
                if (r0 == 0) goto L_0x0027
                java.lang.Class r6 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x001e }
                goto L_0x002f
            L_0x001e:
                java.lang.Class r6 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0023 }
                goto L_0x002f
            L_0x0023:
                com.clevertap.android.sdk.Logger.d(r7)
                goto L_0x002f
            L_0x0027:
                java.lang.Class r6 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x002c }
                goto L_0x002f
            L_0x002c:
                com.clevertap.android.sdk.Logger.d(r7)
            L_0x002f:
                boolean r6 = com.clevertap.android.sdk.Utils.isServiceAvailable(r1, r6)
                if (r4 == 0) goto L_0x0198
                int r0 = r21.length()
                if (r0 <= 0) goto L_0x0198
                r0 = 0
                r7 = 0
            L_0x003d:
                int r0 = r21.length()
                if (r7 >= r0) goto L_0x0198
                org.json.JSONObject r0 = r4.getJSONObject(r7)     // Catch:{ all -> 0x017d }
                java.lang.String r8 = "l"
                java.lang.String r8 = r0.optString(r8)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = r0.optString(r5)     // Catch:{ all -> 0x017d }
                java.lang.String r10 = r16.getActionButtonIconKey()     // Catch:{ all -> 0x017d }
                java.lang.String r10 = r0.optString(r10)     // Catch:{ all -> 0x017d }
                java.lang.String r11 = "id"
                java.lang.String r11 = r0.optString(r11)     // Catch:{ all -> 0x017d }
                java.lang.String r12 = "ac"
                r13 = 1
                boolean r12 = r0.optBoolean(r12, r13)     // Catch:{ all -> 0x017d }
                boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x017d }
                if (r0 != 0) goto L_0x0173
                boolean r0 = r11.isEmpty()     // Catch:{ all -> 0x017d }
                if (r0 == 0) goto L_0x0074
                goto L_0x0173
            L_0x0074:
                boolean r0 = r10.isEmpty()     // Catch:{ all -> 0x017d }
                if (r0 != 0) goto L_0x00a2
                android.content.res.Resources r0 = r17.getResources()     // Catch:{ all -> 0x0089 }
                java.lang.String r13 = "drawable"
                java.lang.String r14 = r17.getPackageName()     // Catch:{ all -> 0x0089 }
                int r0 = r0.getIdentifier(r10, r13, r14)     // Catch:{ all -> 0x0089 }
                goto L_0x00a3
            L_0x0089:
                r0 = move-exception
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x017d }
                r10.<init>()     // Catch:{ all -> 0x017d }
                java.lang.String r13 = "unable to add notification action icon: "
                r10.append(r13)     // Catch:{ all -> 0x017d }
                java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x017d }
                r10.append(r0)     // Catch:{ all -> 0x017d }
                java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x017d }
                com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ all -> 0x017d }
            L_0x00a2:
                r0 = 0
            L_0x00a3:
                int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x017d }
                r13 = 31
                if (r10 >= r13) goto L_0x00af
                if (r12 == 0) goto L_0x00af
                if (r6 == 0) goto L_0x00af
                r10 = 1
                goto L_0x00b0
            L_0x00af:
                r10 = 0
            L_0x00b0:
                java.lang.String r13 = "pt_dismiss_on_click"
                java.lang.String r13 = r2.getString(r13)     // Catch:{ all -> 0x017d }
                java.lang.String r14 = "true"
                if (r10 != 0) goto L_0x00d5
                boolean r15 = com.clevertap.android.sdk.pushnotification.PushNotificationHandler.isForPushTemplates(r18)     // Catch:{ all -> 0x017d }
                if (r15 == 0) goto L_0x00d5
                java.lang.String r15 = "remind"
                boolean r15 = r11.contains(r15)     // Catch:{ all -> 0x017d }
                if (r15 == 0) goto L_0x00d5
                if (r13 == 0) goto L_0x00d5
                boolean r15 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x017d }
                if (r15 == 0) goto L_0x00d5
                if (r12 == 0) goto L_0x00d5
                if (r6 == 0) goto L_0x00d5
                r10 = 1
            L_0x00d5:
                if (r10 != 0) goto L_0x00ea
                boolean r15 = com.clevertap.android.sdk.pushnotification.PushNotificationHandler.isForPushTemplates(r18)     // Catch:{ all -> 0x017d }
                if (r15 == 0) goto L_0x00ea
                if (r13 == 0) goto L_0x00ea
                boolean r13 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x017d }
                if (r13 == 0) goto L_0x00ea
                if (r12 == 0) goto L_0x00ea
                if (r6 == 0) goto L_0x00ea
                r10 = 1
            L_0x00ea:
                if (r10 == 0) goto L_0x010b
                android.content.Intent r13 = new android.content.Intent     // Catch:{ all -> 0x017d }
                java.lang.String r14 = "com.clevertap.PUSH_EVENT"
                r13.<init>(r14)     // Catch:{ all -> 0x017d }
                java.lang.String r14 = r17.getPackageName()     // Catch:{ all -> 0x017d }
                r13.setPackage(r14)     // Catch:{ all -> 0x017d }
                java.lang.String r14 = "ct_type"
                java.lang.String r15 = "com.clevertap.ACTION_BUTTON_CLICK"
                r13.putExtra(r14, r15)     // Catch:{ all -> 0x017d }
                boolean r14 = r9.isEmpty()     // Catch:{ all -> 0x017d }
                if (r14 != 0) goto L_0x012c
                r13.putExtra(r5, r9)     // Catch:{ all -> 0x017d }
                goto L_0x012c
            L_0x010b:
                boolean r13 = r9.isEmpty()     // Catch:{ all -> 0x017d }
                if (r13 != 0) goto L_0x0120
                android.content.Intent r13 = new android.content.Intent     // Catch:{ all -> 0x017d }
                java.lang.String r14 = "android.intent.action.VIEW"
                android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x017d }
                r13.<init>(r14, r9)     // Catch:{ all -> 0x017d }
                com.clevertap.android.sdk.Utils.setPackageNameFromResolveInfoList(r1, r13)     // Catch:{ all -> 0x017d }
                goto L_0x012c
            L_0x0120:
                android.content.pm.PackageManager r9 = r17.getPackageManager()     // Catch:{ all -> 0x017d }
                java.lang.String r13 = r17.getPackageName()     // Catch:{ all -> 0x017d }
                android.content.Intent r13 = r9.getLaunchIntentForPackage(r13)     // Catch:{ all -> 0x017d }
            L_0x012c:
                if (r13 == 0) goto L_0x0152
                r13.putExtras(r2)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = "wzrk_acts"
                r13.removeExtra(r9)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = "actionId"
                r13.putExtra(r9, r11)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = "autoCancel"
                r13.putExtra(r9, r12)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = "wzrk_c2a"
                r13.putExtra(r9, r11)     // Catch:{ all -> 0x017d }
                java.lang.String r9 = "notificationId"
                r11 = r19
                r13.putExtra(r9, r11)     // Catch:{ all -> 0x017b }
                r9 = 603979776(0x24000000, float:2.7755576E-17)
                r13.setFlags(r9)     // Catch:{ all -> 0x017b }
                goto L_0x0154
            L_0x0152:
                r11 = r19
            L_0x0154:
                long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x017b }
                int r9 = (int) r14     // Catch:{ all -> 0x017b }
                int r9 = r9 + r7
                r12 = 134217728(0x8000000, float:3.85186E-34)
                int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x017b }
                r15 = 23
                if (r14 < r15) goto L_0x0164
                r12 = 201326592(0xc000000, float:9.8607613E-32)
            L_0x0164:
                if (r10 == 0) goto L_0x016b
                android.app.PendingIntent r9 = android.app.PendingIntent.getService(r1, r9, r13, r12)     // Catch:{ all -> 0x017b }
                goto L_0x016f
            L_0x016b:
                android.app.PendingIntent r9 = android.app.PendingIntent.getActivity(r1, r9, r13, r12)     // Catch:{ all -> 0x017b }
            L_0x016f:
                r3.addAction(r0, r8, r9)     // Catch:{ all -> 0x017b }
                goto L_0x0194
            L_0x0173:
                r11 = r19
                java.lang.String r0 = "not adding push notification action: action label or id missing"
                com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ all -> 0x017b }
                goto L_0x0194
            L_0x017b:
                r0 = move-exception
                goto L_0x0180
            L_0x017d:
                r0 = move-exception
                r11 = r19
            L_0x0180:
                java.lang.String r8 = "error adding notification action : "
                java.lang.StringBuilder r8 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
                java.lang.String r0 = r0.getLocalizedMessage()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                com.clevertap.android.sdk.Logger.d(r0)
            L_0x0194:
                int r7 = r7 + 1
                goto L_0x003d
            L_0x0198:
                return r3
            L_0x0199:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.INotificationRenderer.CC.$default$setActionButtons(com.clevertap.android.sdk.pushnotification.INotificationRenderer, android.content.Context, android.os.Bundle, int, androidx.core.app.NotificationCompat$Builder, org.json.JSONArray):androidx.core.app.NotificationCompat$Builder");
        }
    }

    String getActionButtonIconKey();

    Object getCollapseKey(Bundle bundle);

    String getMessage(Bundle bundle);

    String getTitle(Bundle bundle, Context context);

    Builder renderNotification(Bundle bundle, Context context, Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i);

    Builder setActionButtons(Context context, Bundle bundle, int i, Builder builder, JSONArray jSONArray);

    void setSmallIcon(int i, Context context);
}
