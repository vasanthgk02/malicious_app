package com.clevertap.android.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CTLockManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.events.EventGroup;
import com.clevertap.android.sdk.response.ARPResponse;
import com.clevertap.android.sdk.response.BaseResponse;
import com.clevertap.android.sdk.response.CleverTapResponse;
import com.clevertap.android.sdk.response.CleverTapResponseHelper;
import com.clevertap.android.sdk.response.ConsoleResponse;
import com.clevertap.android.sdk.response.DisplayUnitResponse;
import com.clevertap.android.sdk.response.FeatureFlagResponse;
import com.clevertap.android.sdk.response.GeofenceResponse;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.response.InboxResponse;
import com.clevertap.android.sdk.response.MetadataResponse;
import com.clevertap.android.sdk.response.ProductConfigResponse;
import com.clevertap.android.sdk.response.PushAmpResponse;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.json.JSONObject;

public class NetworkManager extends BaseNetworkManager {
    public static SSLContext sslContext;
    public static SSLSocketFactory sslSocketFactory;
    public final BaseCallbackManager callbackManager;
    public CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ControllerManager controllerManager;
    public final CoreMetaData coreMetaData;
    public int currentRequestTimestamp = 0;
    public final BaseDatabaseManager databaseManager;
    public final DeviceInfo deviceInfo;
    public final Logger logger;
    public int networkRetryCount = 0;
    public int responseFailureCount = 0;
    public final ValidationResultStack validationResultStack;

    public NetworkManager(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo2, CoreMetaData coreMetaData2, ValidationResultStack validationResultStack2, ControllerManager controllerManager2, BaseDatabaseManager baseDatabaseManager, BaseCallbackManager baseCallbackManager, CTLockManager cTLockManager, Validator validator, LocalDataStore localDataStore) {
        CleverTapInstanceConfig cleverTapInstanceConfig2 = cleverTapInstanceConfig;
        DeviceInfo deviceInfo3 = deviceInfo2;
        CoreMetaData coreMetaData3 = coreMetaData2;
        ControllerManager controllerManager3 = controllerManager2;
        BaseCallbackManager baseCallbackManager2 = baseCallbackManager;
        this.context = context2;
        this.config = cleverTapInstanceConfig2;
        this.deviceInfo = deviceInfo3;
        this.callbackManager = baseCallbackManager2;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.coreMetaData = coreMetaData3;
        this.validationResultStack = validationResultStack2;
        this.controllerManager = controllerManager3;
        this.databaseManager = baseDatabaseManager;
        PushAmpResponse pushAmpResponse = new PushAmpResponse(new DisplayUnitResponse(new FeatureFlagResponse(new ProductConfigResponse(new GeofenceResponse(new CleverTapResponseHelper(), cleverTapInstanceConfig2, baseCallbackManager2), cleverTapInstanceConfig2, coreMetaData3, controllerManager3), cleverTapInstanceConfig2, controllerManager3), cleverTapInstanceConfig2, baseCallbackManager2, controllerManager3), context2, cleverTapInstanceConfig, baseDatabaseManager, baseCallbackManager, controllerManager2);
        CleverTapInstanceConfig cleverTapInstanceConfig3 = cleverTapInstanceConfig;
        InboxResponse inboxResponse = new InboxResponse(pushAmpResponse, cleverTapInstanceConfig3, cTLockManager, baseCallbackManager2, controllerManager3);
        ARPResponse aRPResponse = new ARPResponse(new ConsoleResponse(inboxResponse, cleverTapInstanceConfig2), cleverTapInstanceConfig3, this, validator, controllerManager3);
        LocalDataStore localDataStore2 = localDataStore;
        this.cleverTapResponse = new BaseResponse(cleverTapInstanceConfig2, this, localDataStore2, new InAppResponse(new MetadataResponse(aRPResponse, cleverTapInstanceConfig2, deviceInfo3, this), cleverTapInstanceConfig2, controllerManager3, false));
    }

    public HttpsURLConnection buildHttpsURLConnection(String str) throws IOException {
        SSLContext sSLContext;
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpsURLConnection.setRequestProperty("X-CleverTap-Account-ID", this.config.accountId);
        httpsURLConnection.setRequestProperty("X-CleverTap-Token", this.config.accountToken);
        httpsURLConnection.setInstanceFollowRedirects(false);
        if (this.config.sslPinning) {
            synchronized (NetworkManager.class) {
                try {
                    if (sslContext == null) {
                        sslContext = new SSLContextBuilder().build();
                    }
                    sSLContext = sslContext;
                }
            }
            if (sSLContext != null) {
                if (sslSocketFactory == null) {
                    try {
                        sslSocketFactory = sSLContext.getSocketFactory();
                        Logger.d("Pinning SSL session to DigiCertGlobalRoot CA certificate");
                    } catch (Throwable unused) {
                        int i = CleverTapAPI.debugLevel;
                        LogLevel.INFO.intValue();
                    }
                }
                httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
            }
        }
        return httpsURLConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0099 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0296 A[SYNTHETIC, Splitter:B:95:0x0296] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushDBQueue(android.content.Context r13, com.clevertap.android.sdk.events.EventGroup r14) {
        /*
            r12 = this;
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r12.config
            com.clevertap.android.sdk.Logger r0 = r0.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r12.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "Somebody has invoked me to send the queue to CleverTap servers"
            r0.verbose(r1, r2)
            r0 = 1
            r1 = 0
            r3 = r1
        L_0x0012:
            r2 = 1
        L_0x0013:
            if (r2 == 0) goto L_0x02d1
            com.clevertap.android.sdk.db.BaseDatabaseManager r2 = r12.databaseManager
            r4 = 50
            com.clevertap.android.sdk.db.DBManager r2 = (com.clevertap.android.sdk.db.DBManager) r2
            if (r2 == 0) goto L_0x02d0
            com.clevertap.android.sdk.events.EventGroup r5 = com.clevertap.android.sdk.events.EventGroup.PUSH_NOTIFICATION_VIEWED
            if (r14 != r5) goto L_0x0038
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r2.config
            com.clevertap.android.sdk.Logger r5 = r5.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r2.config
            java.lang.String r6 = r6.accountId
            java.lang.String r7 = "Returning Queued Notification Viewed events"
            r5.verbose(r6, r7)
            com.clevertap.android.sdk.db.DBAdapter$Table r5 = com.clevertap.android.sdk.db.DBAdapter.Table.PUSH_NOTIFICATION_VIEWED
            com.clevertap.android.sdk.db.QueueCursor r2 = r2.getQueueCursor(r13, r5, r4, r3)
            r3 = r2
            goto L_0x0078
        L_0x0038:
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r2.config
            com.clevertap.android.sdk.Logger r5 = r5.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r2.config
            java.lang.String r6 = r6.accountId
            java.lang.String r7 = "Returning Queued events"
            r5.verbose(r6, r7)
            com.clevertap.android.sdk.CTLockManager r5 = r2.ctLockManager
            java.lang.Boolean r5 = r5.eventLock
            monitor-enter(r5)
            com.clevertap.android.sdk.db.DBAdapter$Table r6 = com.clevertap.android.sdk.db.DBAdapter.Table.EVENTS     // Catch:{ all -> 0x02cd }
            com.clevertap.android.sdk.db.QueueCursor r3 = r2.getQueueCursor(r13, r6, r4, r3)     // Catch:{ all -> 0x02cd }
            java.lang.Boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x02cd }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x02cd }
            if (r6 == 0) goto L_0x006c
            com.clevertap.android.sdk.db.DBAdapter$Table r6 = r3.tableName     // Catch:{ all -> 0x02cd }
            com.clevertap.android.sdk.db.DBAdapter$Table r7 = com.clevertap.android.sdk.db.DBAdapter.Table.EVENTS     // Catch:{ all -> 0x02cd }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x02cd }
            if (r6 == 0) goto L_0x006c
            com.clevertap.android.sdk.db.DBAdapter$Table r3 = com.clevertap.android.sdk.db.DBAdapter.Table.PROFILE_EVENTS     // Catch:{ all -> 0x02cd }
            com.clevertap.android.sdk.db.QueueCursor r3 = r2.getQueueCursor(r13, r3, r4, r1)     // Catch:{ all -> 0x02cd }
        L_0x006c:
            java.lang.Boolean r2 = r3.isEmpty()     // Catch:{ all -> 0x02cd }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02cd }
            if (r2 == 0) goto L_0x0077
            r3 = r1
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x02cd }
        L_0x0078:
            if (r3 == 0) goto L_0x02bd
            java.lang.Boolean r2 = r3.isEmpty()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0086
            goto L_0x02bd
        L_0x0086:
            org.json.JSONArray r2 = r3.data
            if (r2 == 0) goto L_0x02ad
            int r4 = r2.length()
            if (r4 > 0) goto L_0x0092
            goto L_0x02ad
        L_0x0092:
            r4 = 0
            int r5 = r2.length()
            if (r5 > 0) goto L_0x009c
        L_0x0099:
            r2 = 0
            goto L_0x0013
        L_0x009c:
            com.clevertap.android.sdk.DeviceInfo r5 = r12.deviceInfo
            java.lang.String r5 = r5.getDeviceID()
            if (r5 != 0) goto L_0x00b0
            com.clevertap.android.sdk.Logger r2 = r12.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r12.config
            java.lang.String r5 = r5.accountId
            java.lang.String r6 = "CleverTap Id not finalized, unable to send queue"
            r2.debug(r5, r6)
            goto L_0x0099
        L_0x00b0:
            java.lang.String r5 = r12.getEndpoint(r4, r14)     // Catch:{ all -> 0x0272 }
            if (r5 != 0) goto L_0x00c2
            com.clevertap.android.sdk.Logger r2 = r12.logger     // Catch:{ all -> 0x0272 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r12.config     // Catch:{ all -> 0x0272 }
            java.lang.String r5 = r5.accountId     // Catch:{ all -> 0x0272 }
            java.lang.String r6 = "Problem configuring queue endpoint, unable to send queue"
            r2.debug(r5, r6)     // Catch:{ all -> 0x0272 }
            goto L_0x0099
        L_0x00c2:
            javax.net.ssl.HttpsURLConnection r6 = r12.buildHttpsURLConnection(r5)     // Catch:{ all -> 0x0272 }
            java.lang.String r7 = r12.insertHeader(r13, r2)     // Catch:{ all -> 0x0270 }
            if (r7 != 0) goto L_0x00e2
            com.clevertap.android.sdk.Logger r2 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r5.accountId     // Catch:{ all -> 0x0270 }
            java.lang.String r7 = "Problem configuring queue request, unable to send queue"
            r2.debug(r5, r7)     // Catch:{ all -> 0x0270 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x0099 }
            r2.close()     // Catch:{ all -> 0x0099 }
        L_0x00de:
            r6.disconnect()     // Catch:{ all -> 0x0099 }
            goto L_0x0099
        L_0x00e2:
            com.clevertap.android.sdk.Logger r8 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r10.<init>()     // Catch:{ all -> 0x0270 }
            java.lang.String r11 = "Send queue contains "
            r10.append(r11)     // Catch:{ all -> 0x0270 }
            int r11 = r2.length()     // Catch:{ all -> 0x0270 }
            r10.append(r11)     // Catch:{ all -> 0x0270 }
            java.lang.String r11 = " items: "
            r10.append(r11)     // Catch:{ all -> 0x0270 }
            r10.append(r7)     // Catch:{ all -> 0x0270 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0270 }
            r8.debug(r9, r10)     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.Logger r8 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r9 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = r9.accountId     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r10.<init>()     // Catch:{ all -> 0x0270 }
            java.lang.String r11 = "Sending queue to: "
            r10.append(r11)     // Catch:{ all -> 0x0270 }
            r10.append(r5)     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x0270 }
            r8.debug(r9, r5)     // Catch:{ all -> 0x0270 }
            r6.setDoOutput(r0)     // Catch:{ all -> 0x0270 }
            java.io.OutputStream r5 = r6.getOutputStream()     // Catch:{ all -> 0x0270 }
            java.lang.String r8 = "UTF-8"
            byte[] r7 = r7.getBytes(r8)     // Catch:{ all -> 0x0270 }
            r5.write(r7)     // Catch:{ all -> 0x0270 }
            int r5 = r6.getResponseCode()     // Catch:{ all -> 0x0270 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r5 != r7) goto L_0x0259
            java.lang.String r5 = "X-WZRK-RD"
            java.lang.String r5 = r6.getHeaderField(r5)     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x0188
            java.lang.String r7 = r5.trim()     // Catch:{ all -> 0x0270 }
            int r7 = r7.length()     // Catch:{ all -> 0x0270 }
            if (r7 <= 0) goto L_0x0188
            android.content.Context r7 = r12.context     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = "comms_dmn"
            java.lang.String r7 = co.hyperverge.hypersnapsdk.c.k.getStringFromPrefs(r7, r8, r9, r1)     // Catch:{ all -> 0x0270 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x0270 }
            r7 = r7 ^ r0
            if (r7 == 0) goto L_0x0188
            r12.setDomain(r13, r5)     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.Logger r2 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r7 = r7.accountId     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r8.<init>()     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = "The domain has changed to "
            r8.append(r9)     // Catch:{ all -> 0x0270 }
            r8.append(r5)     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = ". The request will be retried shortly."
            r8.append(r5)     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x0270 }
            r2.debug(r7, r5)     // Catch:{ all -> 0x0270 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x0099 }
            r2.close()     // Catch:{ all -> 0x0099 }
            goto L_0x00de
        L_0x0188:
            boolean r5 = r12.processIncomingHeaders(r13, r6)     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x01b8
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0270 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x0270 }
            java.io.InputStream r8 = r6.getInputStream()     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = "utf-8"
            r7.<init>(r8, r9)     // Catch:{ all -> 0x0270 }
            r5.<init>(r7)     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r7.<init>()     // Catch:{ all -> 0x0270 }
        L_0x01a3:
            java.lang.String r8 = r5.readLine()     // Catch:{ all -> 0x0270 }
            if (r8 == 0) goto L_0x01ad
            r7.append(r8)     // Catch:{ all -> 0x0270 }
            goto L_0x01a3
        L_0x01ad:
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.response.CleverTapResponse r7 = r12.cleverTapResponse     // Catch:{ all -> 0x0270 }
            android.content.Context r8 = r12.context     // Catch:{ all -> 0x0270 }
            r7.processResponse(r1, r5, r8)     // Catch:{ all -> 0x0270 }
        L_0x01b8:
            int r5 = r12.currentRequestTimestamp     // Catch:{ all -> 0x0270 }
            android.content.Context r7 = r12.context     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = "comms_last_ts"
            java.lang.String r8 = co.hyperverge.hypersnapsdk.c.k.storageKeyWithSuffix(r8, r9)     // Catch:{ all -> 0x0270 }
            co.hyperverge.hypersnapsdk.c.k.putInt(r7, r8, r5)     // Catch:{ all -> 0x0270 }
            int r5 = r12.currentRequestTimestamp     // Catch:{ all -> 0x0270 }
            android.content.Context r7 = r12.context     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r9 = "comms_first_ts"
            int r7 = co.hyperverge.hypersnapsdk.c.k.getIntFromPrefs(r7, r8, r9, r4)     // Catch:{ all -> 0x0270 }
            if (r7 <= 0) goto L_0x01d6
            goto L_0x01e1
        L_0x01d6:
            android.content.Context r7 = r12.context     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r8 = co.hyperverge.hypersnapsdk.c.k.storageKeyWithSuffix(r8, r9)     // Catch:{ all -> 0x0270 }
            co.hyperverge.hypersnapsdk.c.k.putInt(r7, r8, r5)     // Catch:{ all -> 0x0270 }
        L_0x01e1:
            com.clevertap.android.sdk.events.EventGroup r5 = com.clevertap.android.sdk.events.EventGroup.PUSH_NOTIFICATION_VIEWED     // Catch:{ all -> 0x0270 }
            if (r14 != r5) goto L_0x023e
            int r5 = r2.length()     // Catch:{ all -> 0x0270 }
            int r5 = r5 - r0
            org.json.JSONObject r2 = r2.getJSONObject(r5)     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = "evtData"
            org.json.JSONObject r2 = r2.optJSONObject(r5)     // Catch:{ all -> 0x0270 }
            if (r2 == 0) goto L_0x0233
            java.lang.String r5 = "wzrk_pid"
            java.lang.String r2 = r2.optString(r5)     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CoreMetaData r5 = r12.coreMetaData     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r5.lastNotificationId     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x0233
            com.clevertap.android.sdk.CoreMetaData r5 = r12.coreMetaData     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r5.lastNotificationId     // Catch:{ all -> 0x0270 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x0233
            com.clevertap.android.sdk.BaseCallbackManager r5 = r12.callbackManager     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CallbackManager r5 = (com.clevertap.android.sdk.CallbackManager) r5     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.interfaces.NotificationRenderedListener r5 = r5.notificationRenderedListener     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.Logger r7 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r8 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r8 = r8.accountId     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r9.<init>()     // Catch:{ all -> 0x0270 }
            java.lang.String r10 = "push notification viewed event sent successfully for push id = "
            r9.append(r10)     // Catch:{ all -> 0x0270 }
            r9.append(r2)     // Catch:{ all -> 0x0270 }
            java.lang.String r2 = r9.toString()     // Catch:{ all -> 0x0270 }
            r7.verbose(r8, r2)     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x0233
            com.clevertap.android.pushsdk.CTFirebaseMessagingReceiver r5 = (com.clevertap.android.pushsdk.CTFirebaseMessagingReceiver) r5     // Catch:{ all -> 0x0270 }
            r5.finishReceiverAndCancelTimer()     // Catch:{ all -> 0x0270 }
        L_0x0233:
            com.clevertap.android.sdk.Logger r2 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r5.accountId     // Catch:{ all -> 0x0270 }
            java.lang.String r7 = "push notification viewed event sent successfully"
            r2.verbose(r5, r7)     // Catch:{ all -> 0x0270 }
        L_0x023e:
            com.clevertap.android.sdk.Logger r2 = r12.logger     // Catch:{ all -> 0x0270 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r12.config     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r5.accountId     // Catch:{ all -> 0x0270 }
            java.lang.String r7 = "Queue sent successfully"
            r2.debug(r5, r7)     // Catch:{ all -> 0x0270 }
            r12.responseFailureCount = r4     // Catch:{ all -> 0x0270 }
            r12.networkRetryCount = r4     // Catch:{ all -> 0x0270 }
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x0012 }
            r2.close()     // Catch:{ all -> 0x0012 }
            r6.disconnect()     // Catch:{ all -> 0x0012 }
            goto L_0x0012
        L_0x0259:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0270 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
            r7.<init>()     // Catch:{ all -> 0x0270 }
            java.lang.String r8 = "Response code is not 200. It is "
            r7.append(r8)     // Catch:{ all -> 0x0270 }
            r7.append(r5)     // Catch:{ all -> 0x0270 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0270 }
            r2.<init>(r5)     // Catch:{ all -> 0x0270 }
            throw r2     // Catch:{ all -> 0x0270 }
        L_0x0270:
            r2 = move-exception
            goto L_0x0274
        L_0x0272:
            r2 = move-exception
            r6 = r1
        L_0x0274:
            com.clevertap.android.sdk.Logger r5 = r12.logger     // Catch:{ all -> 0x029f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r12.config     // Catch:{ all -> 0x029f }
            java.lang.String r7 = r7.accountId     // Catch:{ all -> 0x029f }
            java.lang.String r8 = "An exception occurred while sending the queue, will retry: "
            r5.debug(r7, r8, r2)     // Catch:{ all -> 0x029f }
            int r2 = r12.responseFailureCount     // Catch:{ all -> 0x029f }
            int r2 = r2 + r0
            r12.responseFailureCount = r2     // Catch:{ all -> 0x029f }
            int r2 = r12.networkRetryCount     // Catch:{ all -> 0x029f }
            int r2 = r2 + r0
            r12.networkRetryCount = r2     // Catch:{ all -> 0x029f }
            com.clevertap.android.sdk.BaseCallbackManager r2 = r12.callbackManager     // Catch:{ all -> 0x029f }
            com.clevertap.android.sdk.CallbackManager r2 = (com.clevertap.android.sdk.CallbackManager) r2     // Catch:{ all -> 0x029f }
            com.clevertap.android.sdk.FailureFlushListener r2 = r2.failureFlushListener     // Catch:{ all -> 0x029f }
            com.clevertap.android.sdk.events.EventQueueManager r2 = (com.clevertap.android.sdk.events.EventQueueManager) r2     // Catch:{ all -> 0x029f }
            r2.scheduleQueueFlush(r13)     // Catch:{ all -> 0x029f }
            if (r6 == 0) goto L_0x0099
            java.io.InputStream r2 = r6.getInputStream()     // Catch:{ all -> 0x0099 }
            r2.close()     // Catch:{ all -> 0x0099 }
            goto L_0x00de
        L_0x029f:
            r13 = move-exception
            if (r6 == 0) goto L_0x02ac
            java.io.InputStream r14 = r6.getInputStream()     // Catch:{ all -> 0x02ac }
            r14.close()     // Catch:{ all -> 0x02ac }
            r6.disconnect()     // Catch:{ all -> 0x02ac }
        L_0x02ac:
            throw r13
        L_0x02ad:
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r12.config
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r14 = r12.config
            java.lang.String r14 = r14.accountId
            java.lang.String r0 = "No events in the queue, failing"
            r13.verbose(r14, r0)
            goto L_0x02d1
        L_0x02bd:
            com.clevertap.android.sdk.CleverTapInstanceConfig r13 = r12.config
            com.clevertap.android.sdk.Logger r13 = r13.getLogger()
            com.clevertap.android.sdk.CleverTapInstanceConfig r14 = r12.config
            java.lang.String r14 = r14.accountId
            java.lang.String r0 = "No events in the queue, failing"
            r13.verbose(r14, r0)
            goto L_0x02d1
        L_0x02cd:
            r13 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x02cd }
            throw r13
        L_0x02d0:
            throw r1
        L_0x02d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.network.NetworkManager.flushDBQueue(android.content.Context, com.clevertap.android.sdk.events.EventGroup):void");
    }

    public final JSONObject getARP() {
        SharedPreferences sharedPreferences;
        try {
            String newNamespaceARPKey = getNewNamespaceARPKey();
            if (newNamespaceARPKey == null) {
                return null;
            }
            if (!k.getPreferences(this.context, newNamespaceARPKey).getAll().isEmpty()) {
                sharedPreferences = k.getPreferences(this.context, newNamespaceARPKey);
            } else {
                sharedPreferences = migrateARPToNewNameSpace(newNamespaceARPKey, getNamespaceARPKey());
            }
            Map<String, ?> all = sharedPreferences.getAll();
            Iterator<Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if ((value instanceof Number) && ((Number) value).intValue() == -1) {
                    it.remove();
                }
            }
            JSONObject jSONObject = new JSONObject(all);
            Logger logger2 = this.logger;
            String str = this.config.accountId;
            logger2.verbose(str, "Fetched ARP for namespace key: " + newNamespaceARPKey + " values: " + all.toString());
            return jSONObject;
        } catch (Throwable th) {
            this.logger.verbose(this.config.accountId, "Failed to construct ARP object", th);
            return null;
        }
    }

    public String getDomainFromPrefsOrMetadata(EventGroup eventGroup) {
        try {
            String str = this.config.accountRegion;
            if (str != null && str.trim().length() > 0) {
                this.responseFailureCount = 0;
                if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
                    return str.trim().toLowerCase() + eventGroup.httpResource + "." + "wzrkt.com";
                }
                return str.trim().toLowerCase() + "." + "wzrkt.com";
            }
        } catch (Throwable unused) {
        }
        if (eventGroup.equals(EventGroup.PUSH_NOTIFICATION_VIEWED)) {
            return k.getStringFromPrefs(this.context, this.config, "comms_dmn_spiky", null);
        }
        return k.getStringFromPrefs(this.context, this.config, "comms_dmn", null);
    }

    public String getEndpoint(boolean z, EventGroup eventGroup) {
        String domainFromPrefsOrMetadata = getDomainFromPrefsOrMetadata(eventGroup);
        boolean z2 = domainFromPrefsOrMetadata == null || domainFromPrefsOrMetadata.trim().length() == 0;
        String outline50 = (!z2 || z) ? z2 ? "wzrkt.com/hello" : GeneratedOutlineSupport.outline50(domainFromPrefsOrMetadata, "/a1") : null;
        if (outline50 == null) {
            this.logger.verbose(this.config.accountId, (String) "Unable to configure endpoint, domain is null");
            return null;
        }
        String str = this.config.accountId;
        if (str == null) {
            this.logger.verbose(str, (String) "Unable to configure endpoint, accountID is null");
            return null;
        }
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("https://", outline50, "?os=Android&t=");
        outline80.append(this.deviceInfo.getSdkVersion());
        String outline52 = GeneratedOutlineSupport.outline52(outline80.toString(), "&z=", str);
        if (needsHandshakeForDomain(eventGroup)) {
            return outline52;
        }
        this.currentRequestTimestamp = (int) (System.currentTimeMillis() / 1000);
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(outline52, "&ts=");
        outline78.append(this.currentRequestTimestamp);
        return outline78.toString();
    }

    public final String getNamespaceARPKey() {
        String str = this.config.accountId;
        if (str == null) {
            return null;
        }
        Logger logger2 = this.logger;
        logger2.verbose(str, "Old ARP Key = ARP:" + str);
        return "ARP:" + str;
    }

    public String getNewNamespaceARPKey() {
        String str = this.config.accountId;
        if (str == null) {
            return null;
        }
        Logger logger2 = this.logger;
        StringBuilder outline80 = GeneratedOutlineSupport.outline80("New ARP Key = ARP:", str, ":");
        outline80.append(this.deviceInfo.getDeviceID());
        logger2.verbose(str, outline80.toString());
        return "ARP:" + str + ":" + this.deviceInfo.getDeviceID();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fe A[Catch:{ all -> 0x014f, all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x011e A[Catch:{ all -> 0x014f, all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0163 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0168 A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0170 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0175 A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0182 A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018d A[Catch:{ all -> 0x019c }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ab A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c1 A[Catch:{ all -> 0x014f, all -> 0x020f }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ce A[Catch:{ all -> 0x014f, all -> 0x020f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String insertHeader(android.content.Context r9, org.json.JSONArray r10) {
        /*
            r8 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x020f }
            r0.<init>()     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.DeviceInfo r1 = r8.deviceInfo     // Catch:{ all -> 0x020f }
            java.lang.String r1 = r1.getDeviceID()     // Catch:{ all -> 0x020f }
            if (r1 == 0) goto L_0x001b
            java.lang.String r2 = ""
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x020f }
            if (r2 != 0) goto L_0x001b
            java.lang.String r2 = "g"
            r0.put(r2, r1)     // Catch:{ all -> 0x020f }
            goto L_0x0026
        L_0x001b:
            com.clevertap.android.sdk.Logger r1 = r8.logger     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r2 = r2.accountId     // Catch:{ all -> 0x020f }
            java.lang.String r3 = "CRITICAL: Couldn't finalise on a device ID! Using error device ID instead!"
            r1.verbose(r2, r3)     // Catch:{ all -> 0x020f }
        L_0x0026:
            java.lang.String r1 = "type"
            java.lang.String r2 = "meta"
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.DeviceInfo r1 = r8.deviceInfo     // Catch:{ all -> 0x020f }
            org.json.JSONObject r1 = r1.getAppLaunchedFields()     // Catch:{ all -> 0x020f }
            java.lang.String r2 = "af"
            r0.put(r2, r1)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r1.customSdkVersions     // Catch:{ all -> 0x020f }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x020f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x020f }
        L_0x0044:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x005e
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x020f }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x020f }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x020f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x020f }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x020f }
            r0.put(r3, r2)     // Catch:{ all -> 0x020f }
            goto L_0x0044
        L_0x005e:
            android.content.Context r1 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r3 = "comms_i"
            java.lang.String r4 = "IJ"
            r5 = 0
            long r1 = co.hyperverge.hypersnapsdk.c.k.getLongFromPrefs(r1, r2, r3, r5, r4)     // Catch:{ all -> 0x020f }
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x0076
            java.lang.String r6 = "_i"
            r0.put(r6, r1)     // Catch:{ all -> 0x020f }
        L_0x0076:
            android.content.Context r1 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r6 = "comms_j"
            java.lang.String r7 = "IJ"
            long r1 = co.hyperverge.hypersnapsdk.c.k.getLongFromPrefs(r1, r2, r6, r5, r7)     // Catch:{ all -> 0x020f }
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x008b
            java.lang.String r3 = "_j"
            r0.put(r3, r1)     // Catch:{ all -> 0x020f }
        L_0x008b:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r1 = r1.accountId     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r2 = r2.accountToken     // Catch:{ all -> 0x020f }
            if (r1 == 0) goto L_0x0202
            if (r2 != 0) goto L_0x0099
            goto L_0x0202
        L_0x0099:
            java.lang.String r3 = "id"
            r0.put(r3, r1)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "tk"
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "l_ts"
            android.content.Context r2 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r4 = "comms_last_ts"
            int r2 = co.hyperverge.hypersnapsdk.c.k.getIntFromPrefs(r2, r3, r4, r5)     // Catch:{ all -> 0x020f }
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "f_ts"
            android.content.Context r2 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r4 = "comms_first_ts"
            int r2 = co.hyperverge.hypersnapsdk.c.k.getIntFromPrefs(r2, r3, r4, r5)     // Catch:{ all -> 0x020f }
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "ct_pi"
            android.content.Context r2 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.DeviceInfo r4 = r8.deviceInfo     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.validation.ValidationResultStack r6 = r8.validationResultStack     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.login.IdentityRepo r2 = co.hyperverge.hypersnapsdk.c.k.getRepo(r2, r3, r4, r6)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.login.IdentitySet r2 = r2.getIdentitySet()     // Catch:{ all -> 0x020f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x020f }
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "ddnd"
            com.clevertap.android.sdk.DeviceInfo r2 = r8.deviceInfo     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.DeviceInfo$DeviceCachedInfo r2 = r2.getDeviceCachedInfo()     // Catch:{ all -> 0x020f }
            boolean r2 = r2.notificationsEnabled     // Catch:{ all -> 0x020f }
            r3 = 1
            if (r2 == 0) goto L_0x00f4
            com.clevertap.android.sdk.ControllerManager r2 = r8.controllerManager     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.pushnotification.PushProviders r2 = r2.pushProviders     // Catch:{ all -> 0x020f }
            boolean r2 = r2.isNotificationSupported()     // Catch:{ all -> 0x020f }
            if (r2 != 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r2 = 0
            goto L_0x00f5
        L_0x00f4:
            r2 = 1
        L_0x00f5:
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            boolean r1 = r1.isBgPing     // Catch:{ all -> 0x020f }
            if (r1 == 0) goto L_0x0107
            java.lang.String r1 = "bk"
            r0.put(r1, r3)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            r1.isBgPing = r5     // Catch:{ all -> 0x020f }
        L_0x0107:
            java.lang.String r1 = "rtl"
            com.clevertap.android.sdk.db.BaseDatabaseManager r2 = r8.databaseManager     // Catch:{ all -> 0x020f }
            android.content.Context r4 = r8.context     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.db.DBAdapter r2 = r2.loadDBAdapter(r4)     // Catch:{ all -> 0x020f }
            org.json.JSONArray r2 = co.hyperverge.hypersnapsdk.c.k.getRenderedTargetList(r2)     // Catch:{ all -> 0x020f }
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            boolean r1 = r1.installReferrerDataSent     // Catch:{ all -> 0x020f }
            if (r1 != 0) goto L_0x0130
            java.lang.String r1 = "rct"
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            long r6 = r2.referrerClickTime     // Catch:{ all -> 0x020f }
            r0.put(r1, r6)     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "ait"
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            long r6 = r2.appInstallTime     // Catch:{ all -> 0x020f }
            r0.put(r1, r6)     // Catch:{ all -> 0x020f }
        L_0x0130:
            java.lang.String r1 = "frs"
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            boolean r2 = r2.firstRequestInSession     // Catch:{ all -> 0x020f }
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            r1.firstRequestInSession = r5     // Catch:{ all -> 0x020f }
            org.json.JSONObject r1 = r8.getARP()     // Catch:{ all -> 0x014f }
            if (r1 == 0) goto L_0x015b
            int r2 = r1.length()     // Catch:{ all -> 0x014f }
            if (r2 <= 0) goto L_0x015b
            java.lang.String r2 = "arp"
            r0.put(r2, r1)     // Catch:{ all -> 0x014f }
            goto L_0x015b
        L_0x014f:
            r1 = move-exception
            com.clevertap.android.sdk.Logger r2 = r8.logger     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r4 = r4.accountId     // Catch:{ all -> 0x020f }
            java.lang.String r5 = "Failed to attach ARP"
            r2.verbose(r4, r5, r1)     // Catch:{ all -> 0x020f }
        L_0x015b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x020f }
            r1.<init>()     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x019c }
            monitor-enter(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r2.source     // Catch:{ all -> 0x0199 }
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x016d
            java.lang.String r2 = "us"
            r1.put(r2, r4)     // Catch:{ all -> 0x019c }
        L_0x016d:
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x019c }
            monitor-enter(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r2.medium     // Catch:{ all -> 0x0196 }
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x017a
            java.lang.String r2 = "um"
            r1.put(r2, r4)     // Catch:{ all -> 0x019c }
        L_0x017a:
            com.clevertap.android.sdk.CoreMetaData r2 = r8.coreMetaData     // Catch:{ all -> 0x019c }
            monitor-enter(r2)     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r2.campaign     // Catch:{ all -> 0x0193 }
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x0187
            java.lang.String r2 = "uc"
            r1.put(r2, r4)     // Catch:{ all -> 0x019c }
        L_0x0187:
            int r2 = r1.length()     // Catch:{ all -> 0x019c }
            if (r2 <= 0) goto L_0x01a8
            java.lang.String r2 = "ref"
            r0.put(r2, r1)     // Catch:{ all -> 0x019c }
            goto L_0x01a8
        L_0x0193:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            throw r1     // Catch:{ all -> 0x019c }
        L_0x0196:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            throw r1     // Catch:{ all -> 0x019c }
        L_0x0199:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x019c }
            throw r1     // Catch:{ all -> 0x019c }
        L_0x019c:
            r1 = move-exception
            com.clevertap.android.sdk.Logger r2 = r8.logger     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r4 = r4.accountId     // Catch:{ all -> 0x020f }
            java.lang.String r5 = "Failed to attach ref"
            r2.verbose(r4, r5, r1)     // Catch:{ all -> 0x020f }
        L_0x01a8:
            com.clevertap.android.sdk.CoreMetaData r1 = r8.coreMetaData     // Catch:{ all -> 0x020f }
            monitor-enter(r1)     // Catch:{ all -> 0x020f }
            org.json.JSONObject r2 = r1.wzrkParams     // Catch:{ all -> 0x01ff }
            monitor-exit(r1)     // Catch:{ all -> 0x020f }
            if (r2 == 0) goto L_0x01bb
            int r1 = r2.length()     // Catch:{ all -> 0x020f }
            if (r1 <= 0) goto L_0x01bb
            java.lang.String r1 = "wzrk_ref"
            r0.put(r1, r2)     // Catch:{ all -> 0x020f }
        L_0x01bb:
            com.clevertap.android.sdk.ControllerManager r1 = r8.controllerManager     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.InAppFCManager r1 = r1.inAppFCManager     // Catch:{ all -> 0x020f }
            if (r1 == 0) goto L_0x01ce
            java.lang.String r1 = "Attaching InAppFC to Header"
            com.clevertap.android.sdk.Logger.v(r1)     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.ControllerManager r1 = r8.controllerManager     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.InAppFCManager r1 = r1.inAppFCManager     // Catch:{ all -> 0x020f }
            r1.attachToHeader(r9, r0)     // Catch:{ all -> 0x020f }
            goto L_0x01d9
        L_0x01ce:
            com.clevertap.android.sdk.Logger r9 = r8.logger     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r1 = r1.accountId     // Catch:{ all -> 0x020f }
            java.lang.String r2 = "controllerManager.getInAppFCManager() is NULL, not Attaching InAppFC to Header"
            r9.verbose(r1, r2)     // Catch:{ all -> 0x020f }
        L_0x01d9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x020f }
            r9.<init>()     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "["
            r9.append(r1)     // Catch:{ all -> 0x020f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x020f }
            r9.append(r0)     // Catch:{ all -> 0x020f }
            java.lang.String r0 = ", "
            r9.append(r0)     // Catch:{ all -> 0x020f }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x020f }
            java.lang.String r0 = r0.substring(r3)     // Catch:{ all -> 0x020f }
            r9.append(r0)     // Catch:{ all -> 0x020f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x020f }
            return r9
        L_0x01ff:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x020f }
            throw r9     // Catch:{ all -> 0x020f }
        L_0x0202:
            com.clevertap.android.sdk.Logger r9 = r8.logger     // Catch:{ all -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r8.config     // Catch:{ all -> 0x020f }
            java.lang.String r0 = r0.accountId     // Catch:{ all -> 0x020f }
            java.lang.String r1 = "Account ID/token not found, unable to configure queue request"
            r9.debug(r0, r1)     // Catch:{ all -> 0x020f }
            r9 = 0
            return r9
        L_0x020f:
            r9 = move-exception
            com.clevertap.android.sdk.Logger r0 = r8.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r8.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "CommsManager: Failed to attach header"
            r0.verbose(r1, r2, r9)
            java.lang.String r9 = r10.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.network.NetworkManager.insertHeader(android.content.Context, org.json.JSONArray):java.lang.String");
    }

    public final SharedPreferences migrateARPToNewNameSpace(String str, String str2) {
        SharedPreferences preferences = k.getPreferences(this.context, str2);
        SharedPreferences preferences2 = k.getPreferences(this.context, str);
        Editor edit = preferences2.edit();
        for (Entry next : preferences.getAll().entrySet()) {
            Object value = next.getValue();
            if (value instanceof Number) {
                edit.putInt((String) next.getKey(), ((Number) value).intValue());
            } else if (value instanceof String) {
                String str3 = (String) value;
                if (str3.length() < 100) {
                    edit.putString((String) next.getKey(), str3);
                } else {
                    Logger logger2 = this.logger;
                    String str4 = this.config.accountId;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("ARP update for key ");
                    outline73.append((String) next.getKey());
                    outline73.append(" rejected (string value too long)");
                    logger2.verbose(str4, outline73.toString());
                }
            } else if (value instanceof Boolean) {
                edit.putBoolean((String) next.getKey(), ((Boolean) value).booleanValue());
            } else {
                Logger logger3 = this.logger;
                String str5 = this.config.accountId;
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("ARP update for key ");
                outline732.append((String) next.getKey());
                outline732.append(" rejected (invalid data type)");
                logger3.verbose(str5, outline732.toString());
            }
        }
        Logger logger4 = this.logger;
        String str6 = this.config.accountId;
        logger4.verbose(str6, "Completed ARP update for namespace key: " + str + "");
        k.persist(edit);
        preferences.edit().clear().apply();
        return preferences2;
    }

    public boolean needsHandshakeForDomain(EventGroup eventGroup) {
        String domainFromPrefsOrMetadata = getDomainFromPrefsOrMetadata(eventGroup);
        boolean z = this.responseFailureCount > 5;
        if (z) {
            setDomain(this.context, null);
        }
        if (domainFromPrefsOrMetadata == null || z) {
            return true;
        }
        return false;
    }

    public boolean processIncomingHeaders(Context context2, HttpsURLConnection httpsURLConnection) {
        String headerField = httpsURLConnection.getHeaderField("X-WZRK-MUTE");
        if (headerField != null && headerField.trim().length() > 0) {
            if (headerField.equals(BaseParser.TRUE)) {
                setMuted(context2, true);
                return false;
            }
            setMuted(context2, false);
        }
        String headerField2 = httpsURLConnection.getHeaderField("X-WZRK-RD");
        Logger.v("Getting domain from header - " + headerField2);
        if (!(headerField2 == null || headerField2.trim().length() == 0)) {
            String headerField3 = httpsURLConnection.getHeaderField("X-WZRK-SPIKY-RD");
            Logger.v("Getting spiky domain from header - " + headerField3);
            setMuted(context2, false);
            setDomain(context2, headerField2);
            Logger.v("Setting spiky domain from header as -" + headerField3);
            if (headerField3 == null) {
                setSpikyDomain(context2, headerField2);
            } else {
                setSpikyDomain(context2, headerField3);
            }
        }
        return true;
    }

    public void setDomain(Context context2, String str) {
        Logger logger2 = this.logger;
        String str2 = this.config.accountId;
        logger2.verbose(str2, "Setting domain to " + str);
        k.putString(context2, k.storageKeyWithSuffix(this.config, "comms_dmn"), str);
        if (((CallbackManager) this.callbackManager) == null) {
            throw null;
        }
    }

    public final void setMuted(final Context context2, boolean z) {
        if (z) {
            k.putInt(context2, k.storageKeyWithSuffix(this.config, "comms_mtd"), (int) (System.currentTimeMillis() / 1000));
            setDomain(context2, null);
            Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("CommsManager#setMuted", new Callable<Void>() {
                public Object call() throws Exception {
                    NetworkManager.this.databaseManager.clearQueues(context2);
                    return null;
                }
            }) {
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ String val$logTag;

                {
                    this.val$logTag = r2;
                    this.val$callable = r3;
                }

                public void run() {
                    try {
                        Logger logger = Task.this.config.getLogger();
                        logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                        TResult call = this.val$callable.call();
                        Logger logger2 = Task.this.config.getLogger();
                        logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                        Task task = Task.this;
                        if (task != null) {
                            STATE state = STATE.SUCCESS;
                            task.result = call;
                            for (SuccessExecutable<TResult> execute : task.successExecutables) {
                                execute.execute(task.result);
                            }
                            return;
                        }
                        throw null;
                    } catch (Exception e2) {
                        Task task2 = Task.this;
                        if (task2 != null) {
                            STATE state2 = STATE.FAILED;
                            for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                                execute2.execute(e2);
                            }
                            Logger logger3 = Task.this.config.getLogger();
                            logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                            e2.printStackTrace();
                            return;
                        }
                        throw null;
                    }
                }
            });
            return;
        }
        k.putInt(context2, k.storageKeyWithSuffix(this.config, "comms_mtd"), 0);
    }

    public void setSpikyDomain(Context context2, String str) {
        Logger logger2 = this.logger;
        String str2 = this.config.accountId;
        logger2.verbose(str2, "Setting spiky domain to " + str);
        k.putString(context2, k.storageKeyWithSuffix(this.config, "comms_dmn_spiky"), str);
    }
}
