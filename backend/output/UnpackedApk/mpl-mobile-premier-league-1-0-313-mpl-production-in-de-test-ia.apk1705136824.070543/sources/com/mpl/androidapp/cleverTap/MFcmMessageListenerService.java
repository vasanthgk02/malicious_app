package com.mpl.androidapp.cleverTap;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AppsFlyerLib;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.freshchat.consumer.sdk.Freshchat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mpl.androidapp.database.repo.MutedChannelRepo;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import io.hansel.hanselsdk.Hansel;
import java.util.Map;
import org.json.JSONObject;

public class MFcmMessageListenerService extends FirebaseMessagingService {
    public static final String TAG = "MFcmMessageListenerServ";

    private boolean isNotificationMuted(RemoteMessage remoteMessage) {
        try {
            MutedChannelRepo mutedChannelRepo = new MutedChannelRepo();
            if (!(remoteMessage == null || remoteMessage.getData() == null || remoteMessage.getData().size() <= 0)) {
                Map<String, String> data = remoteMessage.getData();
                if (data.containsKey("type") && "CHANNEL".equalsIgnoreCase(data.get("type"))) {
                    String str = data.get("channelUrl");
                    MLogger.d(TAG, "Channel Url : " + str);
                    if (mutedChannelRepo.isChannelMuted(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in blockNotification : ")));
        }
        return false;
    }

    private boolean isSbGroupNotification(JSONObject jSONObject) {
        boolean z = true;
        try {
            if (!jSONObject.has("channel")) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("channel");
            if (!jSONObject2.has("custom_type") || !"group".equals(jSONObject2.getString("custom_type"))) {
                z = false;
            }
            return z;
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in isSbGroupNotification : ")));
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: type inference failed for: r27v3 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r27v4 */
    /* JADX WARNING: type inference failed for: r1v26, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v27, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v28, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r27v13 */
    /* JADX WARNING: type inference failed for: r27v14 */
    /* JADX WARNING: type inference failed for: r27v15 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v37 */
    /* JADX WARNING: type inference failed for: r1v38 */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0191, code lost:
        if (com.mpl.androidapp.config.ConfigManager.getPlatformConfig().optBoolean("notification.drawer.enabled", false) == false) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x019c, code lost:
        if (com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(getApplicationContext(), "notification.drawer.enabled", false) != false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019e, code lost:
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r1 = new org.json.JSONObject();
        r2 = r12.keySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01af, code lost:
        if (r2.hasNext() == false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b1, code lost:
        r0 = (java.lang.String) r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r1.put(r0, org.json.JSONObject.wrap(r12.get(r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c4, code lost:
        r27 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        java.lang.System.out.println(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ce, code lost:
        r0 = new org.json.JSONObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01da, code lost:
        if (r1.optBoolean("isShownInAppDrawer", true) == false) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01dc, code lost:
        r0.put("title", r1.optString("nt", ""));
        r0.put(com.netcore.android.notification.SMTNotificationConstants.NOTIF_BODY_KEY, r1.optString("nm", ""));
        r0.put("largeIcon", r1.optString("ico", ""));
        r0.put("actionParams", r1.optString("actionParams", ""));
        r0.put("action_type", r1.optString("action", ""));
        r0.put("category", r1.optString("category", ""));
        r2 = r24;
        r10 = r23;
        r0.put(r10, r1.optString("NotificationName", r2));
        r3 = r18;
        r0.put(r3, r1.optString(r3, ""));
        r18 = r5;
        r23 = r12;
        com.mpl.androidapp.MPLApplication.getNotificationDataManager().addNotificationData(r0.toString(), java.lang.String.valueOf(java.lang.System.currentTimeMillis()), false);
        r0 = new java.util.HashMap();
        r0.put("title", r1.optString("nt", ""));
        r0.put(com.netcore.android.notification.SMTNotificationConstants.NOTIF_BODY_KEY, r1.optString("nm", ""));
        r0.put("Notif Category", r1.optString("category", ""));
        r0.put(r10, r1.optString("NotificationName", r2));
        r0.put("Notif Subcategory", r1.optString(r3, ""));
        r0.put("Deeplink", r1.optString("actionParams", ""));
        com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent((java.lang.String) "Notification added", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x027b, code lost:
        r18 = r5;
        r23 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r1 = getApplicationContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r0 = new android.os.Bundle();
        r3 = r31.getData().entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x029a, code lost:
        if (r3.hasNext() == false) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x029c, code lost:
        r4 = r3.next();
        r0.putString((java.lang.String) r4.getKey(), (java.lang.String) r4.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02b2, code lost:
        com.clevertap.android.sdk.Logger.d("PushProvider", com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG + "Found Valid Notification Message ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r0.printStackTrace();
        com.clevertap.android.sdk.Logger.d("PushProvider", com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG + "Invalid Notification Message ", r0);
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v4
      assigns: []
      uses: []
      mth insns count: 406
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void showNotification(com.google.firebase.messaging.RemoteMessage r31) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            java.lang.String r3 = "default"
            java.lang.String r4 = "NotificationName"
            java.lang.String r5 = "Notification Name"
            java.lang.String r6 = "nm"
            java.lang.String r7 = "body"
            java.lang.String r0 = "name"
            java.lang.String r8 = "nt"
            java.lang.String r9 = "title"
            java.lang.String r10 = "minVersion"
            java.lang.String r11 = "onMessageReceived: "
            java.lang.String r12 = "subCategory"
            java.lang.String r13 = "category"
            java.lang.String r14 = "actionParams"
            java.lang.String r15 = "wzrk_cid"
            r16 = r0
            java.lang.String r0 = "notification.drawer.enabled"
            java.lang.String r1 = "custom_type"
            r17 = r1
            java.lang.String r1 = "MFcmMessageListenerServ"
            r18 = r12
            boolean r21 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUserPlayingGame()     // Catch:{ Exception -> 0x04d6 }
            if (r2 == 0) goto L_0x04d9
            java.util.Map r22 = r31.getData()     // Catch:{ Exception -> 0x04d6 }
            if (r22 == 0) goto L_0x04d9
            java.util.Map r22 = r31.getData()     // Catch:{ Exception -> 0x04d6 }
            int r22 = r22.size()     // Catch:{ Exception -> 0x04d6 }
            if (r22 <= 0) goto L_0x04d9
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ Exception -> 0x04d6 }
            r12.<init>()     // Catch:{ Exception -> 0x04d6 }
            r23 = r5
            r2 = 1
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d6 }
            r2 = 0
            r5[r2] = r11     // Catch:{ Exception -> 0x04d6 }
            com.mpl.androidapp.utils.MLogger.d(r1, r5)     // Catch:{ Exception -> 0x04d6 }
            java.util.Map r2 = r31.getData()     // Catch:{ Exception -> 0x04d6 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x04d6 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x04d6 }
            r5 = 0
        L_0x005f:
            boolean r24 = r2.hasNext()     // Catch:{ Exception -> 0x04d6 }
            r25 = r5
            r26 = 0
            if (r24 == 0) goto L_0x00d8
            java.lang.Object r24 = r2.next()     // Catch:{ Exception -> 0x04d6 }
            java.util.Map$Entry r24 = (java.util.Map.Entry) r24     // Catch:{ Exception -> 0x04d6 }
            if (r24 != 0) goto L_0x0076
            r27 = r2
        L_0x0073:
            r24 = r3
            goto L_0x00d1
        L_0x0076:
            java.lang.Object r27 = r24.getKey()     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r5 = java.lang.String.valueOf(r27)     // Catch:{ Exception -> 0x04d6 }
            java.lang.Object r24 = r24.getValue()     // Catch:{ Exception -> 0x04d6 }
            r27 = r2
            java.lang.String r2 = java.lang.String.valueOf(r24)     // Catch:{ Exception -> 0x04d6 }
            boolean r24 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x04d6 }
            if (r24 != 0) goto L_0x0073
            boolean r24 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x04d6 }
            if (r24 == 0) goto L_0x0095
            goto L_0x0073
        L_0x0095:
            r24 = r3
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x04d6 }
            r22 = 0
            r3[r22] = r11     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r29 = "key: "
            r20 = 1
            r3[r20] = r29     // Catch:{ Exception -> 0x04d6 }
            r19 = 2
            r3[r19] = r5     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r29 = "value: "
            r28 = 3
            r3[r28] = r29     // Catch:{ Exception -> 0x04d6 }
            r29 = 4
            r3[r29] = r2     // Catch:{ Exception -> 0x04d6 }
            com.mpl.androidapp.utils.MLogger.d(r1, r3)     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r3 = "sendbird"
            boolean r3 = r5.equals(r3)     // Catch:{ Exception -> 0x04d6 }
            if (r3 == 0) goto L_0x00c4
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x04d6 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x04d6 }
            r2 = 1
            goto L_0x00dd
        L_0x00c4:
            r12.putString(r5, r2)     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r2 = "FCM"
            boolean r2 = r5.equals(r2)     // Catch:{ Exception -> 0x04d6 }
            if (r2 == 0) goto L_0x00d1
            r25 = 1
        L_0x00d1:
            r5 = r25
            r3 = r24
            r2 = r27
            goto L_0x005f
        L_0x00d8:
            r24 = r3
            r3 = r26
            r2 = 0
        L_0x00dd:
            boolean r5 = r12.containsKey(r10)     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r11 = ""
            if (r5 == 0) goto L_0x010e
            java.lang.String r5 = r12.getString(r10, r11)     // Catch:{ Exception -> 0x04d6 }
            if (r5 == 0) goto L_0x0109
            boolean r10 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x04d6 }
            if (r10 != 0) goto L_0x0109
            int r10 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x04d6 }
            r27 = r5
            int r5 = com.mpl.androidapp.utils.MBuildConfigUtils.getMinVersionForChecking()     // Catch:{ Exception -> 0x04d6 }
            if (r10 <= r5) goto L_0x010b
            r5 = 1
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x04d6 }
            java.lang.String r2 = "Does not support min version so not showing notification"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d6 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d6 }
            return
        L_0x0109:
            r27 = r5
        L_0x010b:
            r5 = r27
            goto L_0x010f
        L_0x010e:
            r5 = r11
        L_0x010f:
            com.clevertap.android.sdk.pushnotification.NotificationInfo r10 = com.clevertap.android.sdk.CleverTapAPI.getNotificationInfo(r12)     // Catch:{ Exception -> 0x04d6 }
            boolean r27 = com.freshchat.consumer.sdk.Freshchat.isFreshchatNotification(r31)     // Catch:{ Exception -> 0x04d6 }
            if (r27 == 0) goto L_0x011e
            com.freshchat.consumer.sdk.Freshchat.handleFcmMessage(r30, r31)     // Catch:{ Exception -> 0x04d6 }
            goto L_0x0326
        L_0x011e:
            boolean r10 = r10.fromCleverTap     // Catch:{ Exception -> 0x04d6 }
            if (r10 == 0) goto L_0x0335
            if (r21 == 0) goto L_0x015b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04d6 }
            r3 = 26
            java.lang.String r10 = "low"
            r27 = r1
            java.lang.String r1 = "pr"
            if (r2 < r3) goto L_0x014b
            boolean r2 = r12.containsKey(r1)     // Catch:{ Exception -> 0x0158 }
            if (r2 == 0) goto L_0x013c
            r12.remove(r1)     // Catch:{ Exception -> 0x0158 }
            r12.putString(r1, r10)     // Catch:{ Exception -> 0x0158 }
        L_0x013c:
            boolean r1 = r12.containsKey(r15)     // Catch:{ Exception -> 0x0158 }
            if (r1 == 0) goto L_0x015d
            r12.remove(r15)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r1 = "GAME"
            r12.putString(r15, r1)     // Catch:{ Exception -> 0x0158 }
            goto L_0x015d
        L_0x014b:
            boolean r2 = r12.containsKey(r1)     // Catch:{ Exception -> 0x0158 }
            if (r2 == 0) goto L_0x015d
            r12.remove(r1)     // Catch:{ Exception -> 0x0158 }
            r12.putString(r1, r10)     // Catch:{ Exception -> 0x0158 }
            goto L_0x015d
        L_0x0158:
            r0 = move-exception
            goto L_0x0275
        L_0x015b:
            r27 = r1
        L_0x015d:
            android.content.Context r1 = r30.getApplicationContext()     // Catch:{ Exception -> 0x0331 }
            org.json.JSONObject r2 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x0331 }
            r3 = 1
            boolean r2 = r2.optBoolean(r0, r3)     // Catch:{ Exception -> 0x0331 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r1, r0, r2)     // Catch:{ Exception -> 0x0331 }
            java.lang.String r1 = "NotificationDataManager"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0331 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x0331 }
            r10 = 0
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r3, r0, r10)     // Catch:{ Exception -> 0x0331 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0331 }
            r2[r10] = r3     // Catch:{ Exception -> 0x0331 }
            com.mpl.androidapp.utils.MLogger.d(r1, r2)     // Catch:{ Exception -> 0x0331 }
            org.json.JSONObject r1 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x0331 }
            if (r1 == 0) goto L_0x0193
            org.json.JSONObject r1 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = r1.optBoolean(r0, r10)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x019e
        L_0x0193:
            android.content.Context r1 = r30.getApplicationContext()     // Catch:{ Exception -> 0x0331 }
            r2 = 0
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r0, r2)     // Catch:{ Exception -> 0x0331 }
            if (r0 == 0) goto L_0x027b
        L_0x019e:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0158 }
            r1.<init>()     // Catch:{ Exception -> 0x0158 }
            java.util.Set r0 = r12.keySet()     // Catch:{ Exception -> 0x0158 }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ Exception -> 0x0158 }
        L_0x01ab:
            boolean r0 = r2.hasNext()     // Catch:{ Exception -> 0x0158 }
            if (r0 == 0) goto L_0x01ce
            java.lang.Object r0 = r2.next()     // Catch:{ Exception -> 0x0158 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0158 }
            java.lang.Object r3 = r12.get(r0)     // Catch:{ JSONException -> 0x01c3 }
            java.lang.Object r3 = org.json.JSONObject.wrap(r3)     // Catch:{ JSONException -> 0x01c3 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x01c3 }
            goto L_0x01ab
        L_0x01c3:
            r0 = move-exception
            java.io.PrintStream r3 = java.lang.System.out     // Catch:{ Exception -> 0x0158 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0158 }
            r3.println(r0)     // Catch:{ Exception -> 0x0158 }
            goto L_0x01ab
        L_0x01ce:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0158 }
            r0.<init>()     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "isShownInAppDrawer"
            r3 = 1
            boolean r2 = r1.optBoolean(r2, r3)     // Catch:{ Exception -> 0x0158 }
            if (r2 == 0) goto L_0x027b
            java.lang.String r2 = r1.optString(r8, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r9, r2)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = r1.optString(r6, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r7, r2)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "largeIcon"
            java.lang.String r3 = "ico"
            java.lang.String r3 = r1.optString(r3, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = r1.optString(r14, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r14, r2)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "action_type"
            java.lang.String r3 = "action"
            java.lang.String r3 = r1.optString(r3, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = r1.optString(r13, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r13, r2)     // Catch:{ Exception -> 0x0158 }
            r2 = r24
            java.lang.String r3 = r1.optString(r4, r2)     // Catch:{ Exception -> 0x0158 }
            r10 = r23
            r0.put(r10, r3)     // Catch:{ Exception -> 0x0158 }
            r3 = r18
            java.lang.String r15 = r1.optString(r3, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r3, r15)     // Catch:{ Exception -> 0x0158 }
            com.mpl.androidapp.database.NotificationDataManager r15 = com.mpl.androidapp.MPLApplication.getNotificationDataManager()     // Catch:{ Exception -> 0x0158 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0158 }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0158 }
            r18 = r5
            java.lang.String r5 = java.lang.String.valueOf(r16)     // Catch:{ Exception -> 0x0158 }
            r23 = r12
            r12 = 0
            r15.addNotificationData(r0, r5, r12)     // Catch:{ Exception -> 0x0158 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0158 }
            r0.<init>()     // Catch:{ Exception -> 0x0158 }
            java.lang.String r5 = r1.optString(r8, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r9, r5)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r5 = r1.optString(r6, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r7, r5)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r5 = "Notif Category"
            java.lang.String r6 = r1.optString(r13, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r5, r6)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = r1.optString(r4, r2)     // Catch:{ Exception -> 0x0158 }
            r0.put(r10, r2)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "Notif Subcategory"
            java.lang.String r3 = r1.optString(r3, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "Deeplink"
            java.lang.String r1 = r1.optString(r14, r11)     // Catch:{ Exception -> 0x0158 }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0158 }
            java.lang.String r1 = "Notification added"
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent(r1, r0)     // Catch:{ Exception -> 0x0158 }
            goto L_0x027f
        L_0x0275:
            r4 = r30
            r1 = r27
            goto L_0x04e7
        L_0x027b:
            r18 = r5
            r23 = r12
        L_0x027f:
            android.content.Context r1 = r30.getApplicationContext()     // Catch:{ Exception -> 0x0331 }
            java.lang.String r2 = "PushProvider"
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x02c9 }
            r0.<init>()     // Catch:{ all -> 0x02c9 }
            java.util.Map r3 = r31.getData()     // Catch:{ all -> 0x02c9 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x02c9 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x02c9 }
        L_0x0296:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x02c9 }
            if (r4 == 0) goto L_0x02b2
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x02c9 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x02c9 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x02c9 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02c9 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x02c9 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02c9 }
            r0.putString(r5, r4)     // Catch:{ all -> 0x02c9 }
            goto L_0x0296
        L_0x02b2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02c9 }
            r3.<init>()     // Catch:{ all -> 0x02c9 }
            java.lang.String r4 = com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG     // Catch:{ all -> 0x02c9 }
            r3.append(r4)     // Catch:{ all -> 0x02c9 }
            java.lang.String r4 = "Found Valid Notification Message "
            r3.append(r4)     // Catch:{ all -> 0x02c9 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02c9 }
            com.clevertap.android.sdk.Logger.d(r2, r3)     // Catch:{ all -> 0x02c9 }
            goto L_0x02e5
        L_0x02c9:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0331 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0331 }
            r3.<init>()     // Catch:{ Exception -> 0x0331 }
            java.lang.String r4 = com.clevertap.android.sdk.pushnotification.PushConstants.FCM_LOG_TAG     // Catch:{ Exception -> 0x0331 }
            r3.append(r4)     // Catch:{ Exception -> 0x0331 }
            java.lang.String r4 = "Invalid Notification Message "
            r3.append(r4)     // Catch:{ Exception -> 0x0331 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0331 }
            com.clevertap.android.sdk.Logger.d(r2, r3, r0)     // Catch:{ Exception -> 0x0331 }
            r0 = r26
        L_0x02e5:
            if (r0 == 0) goto L_0x0306
            java.lang.String r2 = "wzrk_pn_h"
            java.lang.String r3 = "true"
            r0.putString(r2, r3)     // Catch:{ Exception -> 0x0331 }
            java.lang.String r2 = "nh_source"
            boolean r3 = r0.containsKey(r2)     // Catch:{ Exception -> 0x0331 }
            if (r3 != 0) goto L_0x02fb
            java.lang.String r3 = "FcmMessageListenerService"
            r0.putString(r2, r3)     // Catch:{ Exception -> 0x0331 }
        L_0x02fb:
            com.clevertap.android.sdk.pushnotification.PushNotificationHandler r2 = com.clevertap.android.sdk.pushnotification.PushNotificationHandler.SingletonNotificationHandler.INSTANCE     // Catch:{ Exception -> 0x0331 }
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r3 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.FCM     // Catch:{ Exception -> 0x0331 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0331 }
            r2.onMessageReceived(r1, r0, r3)     // Catch:{ Exception -> 0x0331 }
        L_0x0306:
            android.content.Context r0 = r30.getApplicationContext()     // Catch:{ Exception -> 0x0331 }
            r1 = r23
            r2 = 0
            com.mpl.androidapp.notification.NotificationBuilder.sendEvent(r0, r1, r2)     // Catch:{ Exception -> 0x0331 }
            r1 = 3
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0331 }
            java.lang.String r1 = "onMessageReceived from cleverTap: sending to cleverTap"
            r0[r2] = r1     // Catch:{ Exception -> 0x0331 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r21)     // Catch:{ Exception -> 0x0331 }
            r2 = 1
            r0[r2] = r1     // Catch:{ Exception -> 0x0331 }
            r1 = 2
            r0[r1] = r18     // Catch:{ Exception -> 0x032a }
            r1 = r27
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d6 }
        L_0x0326:
            r4 = r30
            goto L_0x04f5
        L_0x032a:
            r0 = move-exception
            r1 = r27
        L_0x032d:
            r4 = r30
            goto L_0x04e7
        L_0x0331:
            r0 = move-exception
            r1 = r27
            goto L_0x032d
        L_0x0335:
            r18 = r5
            java.util.Map r0 = r31.getData()     // Catch:{ Exception -> 0x04d6 }
            boolean r0 = io.hansel.hanselsdk.Hansel.isPushFromHansel(r0)     // Catch:{ Exception -> 0x04d6 }
            if (r0 == 0) goto L_0x0357
            java.util.Map r0 = r31.getData()     // Catch:{ Exception -> 0x04d6 }
            r4 = r30
            io.hansel.hanselsdk.Hansel.handlePushPayload(r4, r0)     // Catch:{ Exception -> 0x04d4 }
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "onMessageReceived from Hansel: "
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x04f5
        L_0x0357:
            r4 = r30
            r0 = r17
            if (r2 == 0) goto L_0x04a6
            r2 = 1
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "onMessageReceived:sendbird not connected "
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r5)     // Catch:{ Exception -> 0x04d4 }
            if (r3 == 0) goto L_0x0497
            int r2 = r3.length()     // Catch:{ Exception -> 0x04d4 }
            if (r2 <= 0) goto L_0x0497
            java.lang.String r2 = "chat_notification_received"
            r5 = 1
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x04d4 }
            r5 = 0
            com.mpl.androidapp.utils.MSharedPreferencesUtils.putStringPref(r2, r6, r5)     // Catch:{ Exception -> 0x04d4 }
            boolean r2 = r3.has(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r2 == 0) goto L_0x039d
            java.lang.String r2 = "challenge"
            java.lang.String r5 = r3.optString(r0, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x04d4 }
            if (r2 == 0) goto L_0x039d
            com.mpl.androidapp.notification.NotificationBuilder r0 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r2 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            r2 = r31
            r0.createSendBirdChallengeNotification(r2)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x039d:
            r2 = r31
            boolean r5 = r3.has(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r5 == 0) goto L_0x03bf
            java.lang.String r5 = "file"
            java.lang.String r6 = r3.optString(r0, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r5 = r5.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x04d4 }
            if (r5 == 0) goto L_0x03bf
            com.mpl.androidapp.notification.NotificationBuilder r0 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r2 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            r0.createSendBirdNotification(r3)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x03bf:
            boolean r5 = r4.isSbGroupNotification(r3)     // Catch:{ Exception -> 0x04d4 }
            if (r5 == 0) goto L_0x03d3
            com.mpl.androidapp.notification.NotificationBuilder r0 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x04d4 }
            r0.createSendBirdGroupNotification(r2)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x03d3:
            boolean r2 = r3.has(r0)     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r5 = "data"
            if (r2 == 0) goto L_0x0416
            java.lang.String r2 = "knockOut Tournament"
            java.lang.String r0 = r3.optString(r0, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r0 = r2.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r0 == 0) goto L_0x0416
            java.lang.String r0 = r3.optString(r5)     // Catch:{ Exception -> 0x04d4 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r0 != 0) goto L_0x0416
            java.lang.String r0 = r3.optString(r5, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r0 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r0 == 0) goto L_0x0416
            com.google.firebase.messaging.RemoteMessage r0 = new com.google.firebase.messaging.RemoteMessage     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = r3.optString(r5)     // Catch:{ Exception -> 0x04d4 }
            android.os.Bundle r2 = com.mpl.androidapp.utils.Util.jsonToBundle(r2)     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.notification.NotificationBuilder r2 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x04d4 }
            r2.createFCMNotificationDeepLink(r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x0416:
            java.lang.String r0 = r3.optString(r5, r11)     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "channel"
            org.json.JSONObject r2 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x04d4 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r6 != 0) goto L_0x0432
            boolean r6 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r6 == 0) goto L_0x0432
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x04d4 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0434
        L_0x0432:
            r6 = r26
        L_0x0434:
            if (r6 == 0) goto L_0x0466
            if (r2 == 0) goto L_0x0466
            r0 = r16
            java.lang.String r7 = r2.optString(r0, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x04d4 }
            if (r7 != 0) goto L_0x0466
            java.lang.String r7 = "MPL Reminder Bot"
            java.lang.String r0 = r2.optString(r0, r11)     // Catch:{ Exception -> 0x04d4 }
            boolean r0 = r7.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x04d4 }
            if (r0 == 0) goto L_0x0466
            com.google.firebase.messaging.RemoteMessage r0 = new com.google.firebase.messaging.RemoteMessage     // Catch:{ Exception -> 0x04d4 }
            android.os.Bundle r2 = com.mpl.androidapp.utils.Util.jsonToBundle(r6)     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.notification.NotificationBuilder r2 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x04d4 }
            r2.createFCMNotificationDeepLink(r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x0466:
            if (r6 == 0) goto L_0x048b
            java.lang.String r0 = "shouldSendSBNotification"
            r2 = 0
            boolean r0 = r6.optBoolean(r0, r2)     // Catch:{ Exception -> 0x04d4 }
            if (r0 == 0) goto L_0x048b
            com.google.firebase.messaging.RemoteMessage r0 = new com.google.firebase.messaging.RemoteMessage     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = r3.optString(r5)     // Catch:{ Exception -> 0x04d4 }
            android.os.Bundle r2 = com.mpl.androidapp.utils.Util.jsonToBundle(r2)     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.notification.NotificationBuilder r2 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x04d4 }
            r2.createFCMNotificationDeepLink(r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x0497
        L_0x048b:
            com.mpl.androidapp.notification.NotificationBuilder r0 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r2 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x04d4 }
            r0.createSendBirdNotification(r3)     // Catch:{ Exception -> 0x04d4 }
        L_0x0497:
            r2 = 2
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "onMessageReceived from sendBird"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d4 }
            r2 = 1
            r0[r2] = r18     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x04f5
        L_0x04a6:
            r2 = r31
            if (r25 == 0) goto L_0x04c5
            com.mpl.androidapp.notification.NotificationBuilder r0 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x04d4 }
            android.content.Context r3 = r30.getApplicationContext()     // Catch:{ Exception -> 0x04d4 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x04d4 }
            r0.createFCMNotificationDeepLink(r2)     // Catch:{ Exception -> 0x04d4 }
            r2 = 2
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "onMessageReceived from FCM"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d4 }
            r2 = 1
            r0[r2] = r18     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x04f5
        L_0x04c5:
            r2 = 2
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "onMessageReceived not from any provider"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d4 }
            r2 = 1
            r0[r2] = r18     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x04f5
        L_0x04d4:
            r0 = move-exception
            goto L_0x04e7
        L_0x04d6:
            r0 = move-exception
            goto L_0x032d
        L_0x04d9:
            r4 = r30
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x04d4 }
            java.lang.String r2 = "FCM data is null"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x04d4 }
            com.mpl.androidapp.utils.MLogger.d(r1, r0)     // Catch:{ Exception -> 0x04d4 }
            goto L_0x04f5
        L_0x04e7:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "Error parsing FCM message"
            r5 = 0
            r2[r5] = r3
            r3 = 1
            r2[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r1, r2)
        L_0x04f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.cleverTap.MFcmMessageListenerService.showNotification(com.google.firebase.messaging.RemoteMessage):void");
    }

    public void onDeletedMessages() {
        super.onDeletedMessages();
        MLogger.d(TAG, "onDeletedMessages");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        MLogger.d(TAG, "onMessageReceived: ");
        if (!isNotificationMuted(remoteMessage)) {
            showNotification(remoteMessage);
        }
    }

    public void onMessageSent(String str) {
        super.onMessageSent(str);
        MLogger.d(TAG, "onMessageSent", str);
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        MLogger.d(TAG, "onNewToken", str);
        MSharedPreferencesUtils.putOneSignalPushToken(str);
        AppsFlyerLib.getInstance().updateServerUninstallToken(getApplicationContext(), str);
        Freshchat.getInstance(this).setPushRegistrationToken(str);
        Hansel.setNewToken(this, str);
        CommonUtils.saveFireBaseTokenToServer(str);
        if (CleverTapAPI.getDefaultInstance(getApplicationContext()) != null) {
            CleverTapAPI.getDefaultInstance(getApplicationContext()).coreState.pushProviders.handleToken(str, PushType.FCM, true);
        }
    }

    public void onSendError(String str, Exception exc) {
        super.onSendError(str, exc);
        MLogger.e(TAG, "onSendError", exc);
    }
}
