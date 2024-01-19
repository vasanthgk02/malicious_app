package com.clevertap.android.sdk;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationManagerCompat;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.events.EventDetail;
import com.clevertap.android.sdk.inbox.CTInboxActivity;
import com.clevertap.android.sdk.inbox.CTInboxActivity.InboxActivityListener;
import com.clevertap.android.sdk.inbox.CTInboxController;
import com.clevertap.android.sdk.inbox.CTInboxMessage;
import com.clevertap.android.sdk.inbox.CTMessageDAO;
import com.clevertap.android.sdk.interfaces.ActionButtonClickHandler;
import com.clevertap.android.sdk.login.IdentityRepo;
import com.clevertap.android.sdk.login.LoginController;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.pushnotification.CoreNotificationRenderer;
import com.clevertap.android.sdk.pushnotification.INotificationRenderer;
import com.clevertap.android.sdk.pushnotification.NotificationInfo;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.Validator;
import com.clevertap.android.sdk.validation.Validator.ValidationContext;
import com.mpl.androidapp.MPLApplicationLifeCycleCallback;
import com.mpl.androidapp.utils.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class CleverTapAPI implements InboxActivityListener {
    public static int debugLevel = LogLevel.INFO.intValue();
    public static CleverTapInstanceConfig defaultConfig;
    public static HashMap<String, CleverTapAPI> instances;
    public static ActionButtonClickHandler sNotificationHandler;
    public final Context context;
    public CoreState coreState;

    public interface DevicePushTokenRefreshListener {
        void devicePushTokenDidRefresh(String str, PushType pushType);
    }

    public enum LogLevel {
        OFF(-1),
        INFO(0),
        DEBUG(2),
        VERBOSE(3);
        
        public final int value;

        /* access modifiers changed from: public */
        LogLevel(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0380  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CleverTapAPI(android.content.Context r29, com.clevertap.android.sdk.CleverTapInstanceConfig r30, java.lang.String r31) {
        /*
            r28 = this;
            r1 = r28
            r15 = r29
            r14 = r30
            r28.<init>()
            r1.context = r15
            com.clevertap.android.sdk.CoreState r13 = new com.clevertap.android.sdk.CoreState
            r13.<init>(r15)
            com.clevertap.android.sdk.CoreMetaData r12 = new com.clevertap.android.sdk.CoreMetaData
            r12.<init>()
            r13.coreMetaData = r12
            com.clevertap.android.sdk.validation.Validator r0 = new com.clevertap.android.sdk.validation.Validator
            r0.<init>()
            com.clevertap.android.sdk.validation.ValidationResultStack r16 = new com.clevertap.android.sdk.validation.ValidationResultStack
            r16.<init>()
            com.clevertap.android.sdk.CTLockManager r11 = new com.clevertap.android.sdk.CTLockManager
            r11.<init>()
            r13.ctLockManager = r11
            com.clevertap.android.sdk.task.MainLooperHandler r17 = new com.clevertap.android.sdk.task.MainLooperHandler
            r17.<init>()
            com.clevertap.android.sdk.CleverTapInstanceConfig r10 = new com.clevertap.android.sdk.CleverTapInstanceConfig
            r10.<init>(r14)
            r13.config = r10
            com.clevertap.android.sdk.events.EventMediator r9 = new com.clevertap.android.sdk.events.EventMediator
            r9.<init>(r15, r10, r12)
            com.clevertap.android.sdk.LocalDataStore r8 = new com.clevertap.android.sdk.LocalDataStore
            r8.<init>(r15, r10)
            r13.localDataStore = r8
            com.clevertap.android.sdk.DeviceInfo r7 = new com.clevertap.android.sdk.DeviceInfo
            r2 = r31
            r7.<init>(r15, r10, r2, r12)
            r13.deviceInfo = r7
            com.clevertap.android.sdk.CallbackManager r6 = new com.clevertap.android.sdk.CallbackManager
            r6.<init>(r10, r7)
            r13.callbackManager = r6
            com.clevertap.android.sdk.SessionManager r5 = new com.clevertap.android.sdk.SessionManager
            r5.<init>(r10, r12, r0, r8)
            r13.sessionManager = r5
            com.clevertap.android.sdk.db.DBManager r4 = new com.clevertap.android.sdk.db.DBManager
            r4.<init>(r10, r11)
            com.clevertap.android.sdk.ControllerManager r3 = new com.clevertap.android.sdk.ControllerManager
            r2 = r3
            r1 = r3
            r3 = r29
            r18 = r4
            r4 = r10
            r19 = r5
            r5 = r11
            r20 = r6
            r21 = r7
            r22 = r8
            r8 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r13.controllerManager = r1
            com.clevertap.android.sdk.task.CTExecutors r2 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r10)
            com.clevertap.android.sdk.task.Task r2 = r2.ioTask()
            com.clevertap.android.sdk.CleverTapFactory$1 r3 = new com.clevertap.android.sdk.CleverTapFactory$1
            r3.<init>(r13, r1, r10, r15)
            java.util.concurrent.Executor r4 = r2.executor
            com.clevertap.android.sdk.task.Task$1 r5 = new com.clevertap.android.sdk.task.Task$1
            java.lang.String r6 = "initFCManager"
            r5.<init>(r6, r3)
            r4.execute(r5)
            com.clevertap.android.sdk.network.NetworkManager r23 = new com.clevertap.android.sdk.network.NetworkManager
            r2 = r23
            r3 = r29
            r4 = r10
            r5 = r21
            r6 = r12
            r7 = r16
            r8 = r1
            r24 = r9
            r9 = r18
            r31 = r10
            r10 = r20
            r25 = r11
            r26 = r12
            r12 = r0
            r27 = r13
            r13 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.clevertap.android.sdk.events.EventQueueManager r13 = new com.clevertap.android.sdk.events.EventQueueManager
            r2 = r13
            r3 = r18
            r4 = r29
            r5 = r31
            r6 = r24
            r7 = r19
            r8 = r20
            r9 = r17
            r10 = r21
            r11 = r16
            r12 = r23
            r23 = r13
            r13 = r26
            r14 = r25
            r15 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            com.clevertap.android.sdk.AnalyticsManager r14 = new com.clevertap.android.sdk.AnalyticsManager
            r2 = r14
            r3 = r29
            r4 = r31
            r5 = r23
            r6 = r0
            r7 = r16
            r8 = r26
            r9 = r22
            r11 = r20
            r12 = r1
            r13 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15 = r27
            r15.analyticsManager = r14
            com.clevertap.android.sdk.inapp.InAppController r10 = new com.clevertap.android.sdk.inapp.InAppController
            r2 = r10
            r5 = r17
            r6 = r1
            r7 = r20
            r8 = r14
            r9 = r26
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            r15.inAppController = r10
            com.clevertap.android.sdk.ControllerManager r0 = r15.controllerManager
            r0.inAppController = r10
            com.clevertap.android.sdk.task.CTExecutors r0 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r31)
            com.clevertap.android.sdk.task.Task r0 = r0.ioTask()
            com.clevertap.android.sdk.CleverTapFactory$2 r9 = new com.clevertap.android.sdk.CleverTapFactory$2
            r2 = r9
            r4 = r1
            r5 = r31
            r6 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r2 = r0.executor
            com.clevertap.android.sdk.task.Task$1 r3 = new com.clevertap.android.sdk.task.Task$1
            java.lang.String r4 = "initFeatureFlags"
            r3.<init>(r4, r9)
            r2.execute(r3)
            com.clevertap.android.sdk.LocationManager r0 = new com.clevertap.android.sdk.LocationManager
            r13 = r29
            r11 = r31
            r9 = r23
            r12 = r26
            r0.<init>(r13, r11, r12, r9)
            r15.baseLocationManager = r0
            com.clevertap.android.sdk.pushnotification.PushProviders r8 = new com.clevertap.android.sdk.pushnotification.PushProviders
            r2 = r8
            r3 = r29
            r4 = r11
            r5 = r18
            r6 = r16
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7)
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r8.config
            java.util.ArrayList<java.lang.String> r0 = r0.allowedPushTypes
            r2 = 0
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType[] r2 = new com.clevertap.android.sdk.pushnotification.PushConstants.PushType[r2]
            if (r0 == 0) goto L_0x0168
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0168
            int r2 = r0.size()
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType[] r2 = new com.clevertap.android.sdk.pushnotification.PushConstants.PushType[r2]
            r3 = 0
        L_0x0153:
            int r4 = r0.size()
            if (r3 >= r4) goto L_0x0168
            java.lang.Object r4 = r0.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r4 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.valueOf(r4)
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x0153
        L_0x0168:
            int r3 = r2.length
            r0 = 0
            r4 = 0
        L_0x016b:
            java.lang.String r5 = "PushProvider"
            if (r4 >= r3) goto L_0x0247
            r0 = r2[r4]
            java.lang.String r6 = r0.getMessagingSDKClassName()
            java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x0217 }
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r7 = r8.allEnabledPushTypes     // Catch:{ Exception -> 0x0217 }
            r7.add(r0)     // Catch:{ Exception -> 0x0217 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r7 = r8.config     // Catch:{ Exception -> 0x0217 }
            r17 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0213 }
            r2.<init>()     // Catch:{ Exception -> 0x0213 }
            r23 = r3
            java.lang.String r3 = "SDK Class Available :"
            r2.append(r3)     // Catch:{ Exception -> 0x020f }
            r2.append(r6)     // Catch:{ Exception -> 0x020f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x020f }
            com.clevertap.android.sdk.Logger r3 = r7.logger     // Catch:{ Exception -> 0x020f }
            java.lang.String r7 = r7.getDefaultSuffix(r5)     // Catch:{ Exception -> 0x020f }
            r3.verbose(r7, r2)     // Catch:{ Exception -> 0x020f }
            int r2 = r0.getRunningDevices()     // Catch:{ Exception -> 0x020f }
            java.lang.String r3 = "disabling "
            r7 = 3
            if (r2 != r7) goto L_0x01d2
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allEnabledPushTypes     // Catch:{ Exception -> 0x020f }
            r2.remove(r0)     // Catch:{ Exception -> 0x020f }
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allDisabledPushTypes     // Catch:{ Exception -> 0x020f }
            r2.add(r0)     // Catch:{ Exception -> 0x020f }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ Exception -> 0x020f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020f }
            r7.<init>()     // Catch:{ Exception -> 0x020f }
            r7.append(r3)     // Catch:{ Exception -> 0x020f }
            r7.append(r0)     // Catch:{ Exception -> 0x020f }
            r24 = r9
            java.lang.String r9 = " due to flag set as PushConstants.NO_DEVICES"
            r7.append(r9)     // Catch:{ Exception -> 0x020d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x020d }
            com.clevertap.android.sdk.Logger r9 = r2.logger     // Catch:{ Exception -> 0x020d }
            java.lang.String r2 = r2.getDefaultSuffix(r5)     // Catch:{ Exception -> 0x020d }
            r9.verbose(r2, r7)     // Catch:{ Exception -> 0x020d }
            goto L_0x01d4
        L_0x01d2:
            r24 = r9
        L_0x01d4:
            int r2 = r0.getRunningDevices()     // Catch:{ Exception -> 0x020d }
            r7 = 2
            if (r2 != r7) goto L_0x023d
            android.content.Context r2 = r8.context     // Catch:{ Exception -> 0x020d }
            boolean r2 = co.hyperverge.hypersnapsdk.c.k.isXiaomiDeviceRunningMiui(r2)     // Catch:{ Exception -> 0x020d }
            if (r2 != 0) goto L_0x023d
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allEnabledPushTypes     // Catch:{ Exception -> 0x020d }
            r2.remove(r0)     // Catch:{ Exception -> 0x020d }
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allDisabledPushTypes     // Catch:{ Exception -> 0x020d }
            r2.add(r0)     // Catch:{ Exception -> 0x020d }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config     // Catch:{ Exception -> 0x020d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020d }
            r7.<init>()     // Catch:{ Exception -> 0x020d }
            r7.append(r3)     // Catch:{ Exception -> 0x020d }
            r7.append(r0)     // Catch:{ Exception -> 0x020d }
            java.lang.String r0 = " due to flag set as PushConstants.XIAOMI_MIUI_DEVICES"
            r7.append(r0)     // Catch:{ Exception -> 0x020d }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x020d }
            com.clevertap.android.sdk.Logger r3 = r2.logger     // Catch:{ Exception -> 0x020d }
            java.lang.String r2 = r2.getDefaultSuffix(r5)     // Catch:{ Exception -> 0x020d }
            r3.verbose(r2, r0)     // Catch:{ Exception -> 0x020d }
            goto L_0x023d
        L_0x020d:
            r0 = move-exception
            goto L_0x021b
        L_0x020f:
            r0 = move-exception
        L_0x0210:
            r24 = r9
            goto L_0x021b
        L_0x0213:
            r0 = move-exception
        L_0x0214:
            r23 = r3
            goto L_0x0210
        L_0x0217:
            r0 = move-exception
            r17 = r2
            goto L_0x0214
        L_0x021b:
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r8.config
            java.lang.String r3 = "SDK class Not available "
            java.lang.String r7 = " Exception:"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r3, r6, r7)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.clevertap.android.sdk.Logger r3 = r2.logger
            java.lang.String r2 = r2.getDefaultSuffix(r5)
            r3.verbose(r2, r0)
        L_0x023d:
            int r4 = r4 + 1
            r2 = r17
            r3 = r23
            r9 = r24
            goto L_0x016b
        L_0x0247:
            r24 = r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allEnabledPushTypes
            java.util.Iterator r2 = r2.iterator()
        L_0x0254:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x026c
            java.lang.Object r3 = r2.next()
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r3 = (com.clevertap.android.sdk.pushnotification.PushConstants.PushType) r3
            com.clevertap.android.sdk.pushnotification.CTPushProvider r3 = r8.getCTPushProviderFromPushType(r3, r4)
            if (r3 != 0) goto L_0x0268
            goto L_0x0254
        L_0x0268:
            r0.add(r3)
            goto L_0x0254
        L_0x026c:
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allDisabledPushTypes
            java.util.Iterator r2 = r2.iterator()
        L_0x0272:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02b9
            java.lang.Object r3 = r2.next()
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r3 = (com.clevertap.android.sdk.pushnotification.PushConstants.PushType) r3
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r6 = com.clevertap.android.sdk.pushnotification.PushConstants.PushType.XPS
            if (r3 != r6) goto L_0x0272
            java.lang.String r6 = r8.getCachedToken(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0272
            r6 = 0
            com.clevertap.android.sdk.pushnotification.CTPushProvider r6 = r8.getCTPushProviderFromPushType(r3, r6)
            boolean r7 = r6 instanceof com.clevertap.android.sdk.pushnotification.UnregistrableCTPushProvider
            if (r7 == 0) goto L_0x0272
            com.clevertap.android.sdk.pushnotification.UnregistrableCTPushProvider r6 = (com.clevertap.android.sdk.pushnotification.UnregistrableCTPushProvider) r6
            android.content.Context r7 = r8.context
            r6.unregisterPush(r7)
            com.clevertap.android.sdk.CleverTapInstanceConfig r6 = r8.config
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "unregistering existing token for disabled "
            r7.append(r9)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            com.clevertap.android.sdk.Logger r7 = r6.logger
            java.lang.String r6 = r6.getDefaultSuffix(r5)
            r7.verbose(r6, r3)
            goto L_0x0272
        L_0x02b9:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x02ce
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r8.config
            com.clevertap.android.sdk.Logger r2 = r0.logger
            java.lang.String r0 = r0.getDefaultSuffix(r5)
            java.lang.String r3 = "No push providers found!. Make sure to install at least one push provider"
            r2.verbose(r0, r3)
            goto L_0x03d6
        L_0x02ce:
            java.util.Iterator r0 = r0.iterator()
        L_0x02d2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x03d6
            java.lang.Object r2 = r0.next()
            com.clevertap.android.sdk.pushnotification.CTPushProvider r2 = (com.clevertap.android.sdk.pushnotification.CTPushProvider) r2
            int r3 = r2.minSDKSupportVersionCode()
            r6 = 40601(0x9e99, float:5.6894E-41)
            java.lang.String r7 = "Invalid Provider: "
            if (r6 >= r3) goto L_0x02f7
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            com.clevertap.android.sdk.Logger r6 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            java.lang.String r9 = "Provider: %s version %s does not match the SDK version %s. Make sure all CleverTap dependencies are the same version."
            r6.verbose(r3, r9)
            goto L_0x0366
        L_0x02f7:
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r3 = r2.getPushType()
            int r3 = r3.ordinal()
            if (r3 == 0) goto L_0x033a
            if (r3 == r4) goto L_0x033a
            r6 = 2
            if (r3 == r6) goto L_0x033a
            r9 = 3
            if (r3 == r9) goto L_0x033a
            r9 = 4
            if (r3 == r9) goto L_0x030d
            goto L_0x0368
        L_0x030d:
            int r3 = r2.getPlatform()
            if (r3 == r6) goto L_0x0368
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.Class r9 = r2.getClass()
            r6.append(r9)
            java.lang.String r9 = " ADM delivery is only available for Amazon platforms."
            r6.append(r9)
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r9 = r2.getPushType()
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            com.clevertap.android.sdk.Logger r9 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r9.verbose(r3, r6)
            goto L_0x0366
        L_0x033a:
            int r3 = r2.getPlatform()
            if (r3 == r4) goto L_0x0368
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.Class r9 = r2.getClass()
            r6.append(r9)
            java.lang.String r9 = " delivery is only available for Android platforms."
            r6.append(r9)
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r9 = r2.getPushType()
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            com.clevertap.android.sdk.Logger r9 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r9.verbose(r3, r6)
        L_0x0366:
            r3 = 0
            goto L_0x0369
        L_0x0368:
            r3 = 1
        L_0x0369:
            if (r3 != 0) goto L_0x0380
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline34(r2, r6)
            com.clevertap.android.sdk.Logger r6 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r6.verbose(r3, r2)
            goto L_0x02d2
        L_0x0380:
            boolean r3 = r2.isSupported()
            if (r3 != 0) goto L_0x039d
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.String r6 = "Unsupported Provider: "
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline34(r2, r6)
            com.clevertap.android.sdk.Logger r6 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r6.verbose(r3, r2)
            goto L_0x02d2
        L_0x039d:
            boolean r3 = r2.isAvailable()
            if (r3 == 0) goto L_0x03bf
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.String r6 = "Available Provider: "
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline34(r2, r6)
            com.clevertap.android.sdk.Logger r7 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r7.verbose(r3, r6)
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.CTPushProvider> r3 = r8.availableCTPushProviders
            r3.add(r2)
            goto L_0x02d2
        L_0x03bf:
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r8.config
            java.lang.String r6 = "Unavailable Provider: "
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline34(r2, r6)
            com.clevertap.android.sdk.Logger r6 = r3.logger
            java.lang.String r3 = r3.getDefaultSuffix(r5)
            r6.verbose(r3, r2)
            goto L_0x02d2
        L_0x03d6:
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r0 = r8.customEnabledPushTypes
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r2 = r8.allEnabledPushTypes
            r0.addAll(r2)
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.CTPushProvider> r0 = r8.availableCTPushProviders
            java.util.Iterator r0 = r0.iterator()
        L_0x03e3:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x03f9
            java.lang.Object r2 = r0.next()
            com.clevertap.android.sdk.pushnotification.CTPushProvider r2 = (com.clevertap.android.sdk.pushnotification.CTPushProvider) r2
            java.util.ArrayList<com.clevertap.android.sdk.pushnotification.PushConstants$PushType> r3 = r8.customEnabledPushTypes
            com.clevertap.android.sdk.pushnotification.PushConstants$PushType r2 = r2.getPushType()
            r3.remove(r2)
            goto L_0x03e3
        L_0x03f9:
            r1.pushProviders = r8
            r15.pushProviders = r8
            com.clevertap.android.sdk.ActivityLifeCycleManager r0 = new com.clevertap.android.sdk.ActivityLifeCycleManager
            r2 = r0
            r3 = r29
            r4 = r11
            r5 = r14
            r6 = r12
            r7 = r19
            r17 = r24
            r9 = r20
            r23 = r11
            r11 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.activityLifeCycleManager = r0
            com.clevertap.android.sdk.login.LoginController r0 = new com.clevertap.android.sdk.login.LoginController
            r2 = r0
            r4 = r23
            r5 = r21
            r6 = r16
            r7 = r17
            r8 = r14
            r9 = r12
            r10 = r1
            r11 = r19
            r12 = r22
            r1 = r13
            r13 = r20
            r14 = r18
            r1 = r15
            r15 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1.loginController = r0
            r2 = r28
            r2.coreState = r1
            com.clevertap.android.sdk.Logger r0 = r28.getConfigLogger()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = r30
            java.lang.String r4 = r3.accountId
            java.lang.String r5 = ":async_deviceID"
            java.lang.String r6 = "CoreState is set"
            com.android.tools.r8.GeneratedOutlineSupport.outline101(r1, r4, r5, r0, r6)
            com.clevertap.android.sdk.task.CTExecutors r0 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r30)
            com.clevertap.android.sdk.task.Task r0 = r0.postAsyncSafelyTask()
            com.clevertap.android.sdk.CleverTapAPI$10 r1 = new com.clevertap.android.sdk.CleverTapAPI$10
            r1.<init>(r3)
            java.util.concurrent.Executor r4 = r0.executor
            com.clevertap.android.sdk.task.Task$1 r5 = new com.clevertap.android.sdk.task.Task$1
            java.lang.String r6 = "CleverTapAPI#initializeDeviceInfo"
            r5.<init>(r6, r1)
            r4.execute(r5)
            int r0 = com.clevertap.android.sdk.Utils.getNow()
            int r1 = com.clevertap.android.sdk.CoreMetaData.initialAppEnteredForegroundTime
            int r0 = r0 - r1
            r1 = 5
            if (r0 <= r1) goto L_0x0475
            com.clevertap.android.sdk.CoreState r0 = r2.coreState
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config
            r1 = 1
            r0.createdPostAppLaunch = r1
        L_0x0475:
            com.clevertap.android.sdk.task.CTExecutors r0 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r30)
            com.clevertap.android.sdk.task.Task r0 = r0.postAsyncSafelyTask()
            com.clevertap.android.sdk.CleverTapAPI$11 r1 = new com.clevertap.android.sdk.CleverTapAPI$11
            r1.<init>()
            java.util.concurrent.Executor r4 = r0.executor
            com.clevertap.android.sdk.task.Task$1 r5 = new com.clevertap.android.sdk.task.Task$1
            java.lang.String r6 = "setStatesAsync"
            r5.<init>(r6, r1)
            r4.execute(r5)
            com.clevertap.android.sdk.task.CTExecutors r0 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r30)
            com.clevertap.android.sdk.task.Task r0 = r0.postAsyncSafelyTask()
            com.clevertap.android.sdk.CleverTapAPI$12 r1 = new com.clevertap.android.sdk.CleverTapAPI$12
            r4 = r29
            r1.<init>(r2, r3, r4)
            java.util.concurrent.Executor r4 = r0.executor
            com.clevertap.android.sdk.task.Task$1 r5 = new com.clevertap.android.sdk.task.Task$1
            java.lang.String r6 = "saveConfigtoSharedPrefs"
            r5.<init>(r6, r1)
            r4.execute(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CleverTap SDK initialized with accountId: "
            r0.append(r1)
            java.lang.String r1 = r3.accountId
            r0.append(r1)
            java.lang.String r1 = " accountToken: "
            r0.append(r1)
            java.lang.String r1 = r3.accountToken
            r0.append(r1)
            java.lang.String r1 = " accountRegion: "
            r0.append(r1)
            java.lang.String r1 = r3.accountRegion
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.clevertap.android.sdk.Logger.i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.<init>(android.content.Context, com.clevertap.android.sdk.CleverTapInstanceConfig, java.lang.String):void");
    }

    public static CleverTapAPI createInstanceIfAvailable(Context context2, String str, String str2) {
        CleverTapInstanceConfig cleverTapInstanceConfig;
        CleverTapAPI cleverTapAPI = null;
        if (str == null) {
            try {
                return getDefaultInstance(context2, str2);
            } catch (Throwable unused) {
            }
        } else {
            String string = k.getString(context2, "instance:" + str, "");
            if (!string.isEmpty()) {
                try {
                    cleverTapInstanceConfig = new CleverTapInstanceConfig(string);
                } catch (Throwable unused2) {
                    cleverTapInstanceConfig = null;
                }
                Logger.v("Inflated Instance Config: " + string);
                if (cleverTapInstanceConfig != null) {
                    cleverTapAPI = instanceWithConfig(context2, cleverTapInstanceConfig, str2);
                }
                return cleverTapAPI;
            }
            try {
                CleverTapAPI defaultInstance = getDefaultInstance(context2);
                if (defaultInstance != null && defaultInstance.coreState.config.accountId.equals(str)) {
                    cleverTapAPI = defaultInstance;
                }
                return cleverTapAPI;
            } catch (Throwable th) {
                Logger.v((String) "Error creating shared Instance: ", th.getCause());
                return null;
            }
        }
    }

    public static void createNotification(final Context context2, final Bundle bundle, final int i) {
        CleverTapAPI fromAccountId = fromAccountId(context2, bundle.getString(MPLApplicationLifeCycleCallback.WZRK_ACCT_ID_KEY));
        if (fromAccountId != null) {
            final CoreState coreState2 = fromAccountId.coreState;
            CleverTapInstanceConfig cleverTapInstanceConfig = coreState2.config;
            try {
                Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
                postAsyncSafelyTask.executor.execute(new Runnable("CleverTapAPI#createNotification", new Callable<Void>() {
                    public Object call() throws Exception {
                        synchronized (CoreState.this.pushProviders.pushRenderingLock) {
                            CoreState.this.pushProviders.iNotificationRenderer = new CoreNotificationRenderer();
                            CoreState.this.pushProviders._createNotification(context2, bundle, i);
                        }
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
            } catch (Throwable th) {
                cleverTapInstanceConfig.getLogger().debug(cleverTapInstanceConfig.accountId, "Failed to process createNotification()", th);
            }
        }
    }

    public static void createNotificationChannel(Context context2, String str, CharSequence charSequence, String str2, int i, boolean z) {
        CleverTapAPI defaultInstanceOrFirstOther = getDefaultInstanceOrFirstOther(context2);
        if (defaultInstanceOrFirstOther == null) {
            Logger.v("No CleverTap Instance found in CleverTapAPI#createNotificatonChannel");
            return;
        }
        try {
            if (VERSION.SDK_INT >= 26) {
                Task postAsyncSafelyTask = CTExecutorFactory.executors(defaultInstanceOrFirstOther.coreState.config).postAsyncSafelyTask();
                final Context context3 = context2;
                final String str3 = str;
                final CharSequence charSequence2 = charSequence;
                final int i2 = i;
                final String str4 = str2;
                final boolean z2 = z;
                final CleverTapAPI cleverTapAPI = defaultInstanceOrFirstOther;
                AnonymousClass2 r1 = new Callable<Void>() {
                    public Object call() throws Exception {
                        NotificationManager notificationManager = (NotificationManager) context3.getSystemService("notification");
                        if (notificationManager != null) {
                            NotificationChannel notificationChannel = new NotificationChannel(str3, charSequence2, i2);
                            notificationChannel.setDescription(str4);
                            notificationChannel.setShowBadge(z2);
                            notificationManager.createNotificationChannel(notificationChannel);
                            Logger configLogger = cleverTapAPI.getConfigLogger();
                            String accountId = cleverTapAPI.getAccountId();
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Notification channel ");
                            outline73.append(charSequence2.toString());
                            outline73.append(" has been created");
                            configLogger.info(accountId, outline73.toString());
                        }
                        return null;
                    }
                };
                postAsyncSafelyTask.executor.execute(new Runnable("createNotificationChannel", r1) {
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
            }
        } catch (Throwable th) {
            defaultInstanceOrFirstOther.getConfigLogger().verbose(defaultInstanceOrFirstOther.getAccountId(), "Failure creating Notification Channel", th);
        }
    }

    public static CleverTapAPI fromAccountId(Context context2, String str) {
        HashMap<String, CleverTapAPI> hashMap = instances;
        if (hashMap == null) {
            return createInstanceIfAvailable(context2, str, null);
        }
        for (String str2 : hashMap.keySet()) {
            CleverTapAPI cleverTapAPI = instances.get(str2);
            boolean z = false;
            if (cleverTapAPI != null && ((str == null && cleverTapAPI.coreState.config.isDefaultInstance) || cleverTapAPI.getAccountId().equals(str))) {
                z = true;
                continue;
            }
            if (z) {
                return cleverTapAPI;
            }
        }
        return null;
    }

    public static CleverTapAPI getDefaultInstance(Context context2, String str) {
        CleverTapInstanceConfig cleverTapInstanceConfig;
        CleverTapInstanceConfig cleverTapInstanceConfig2 = defaultConfig;
        if (cleverTapInstanceConfig2 != null) {
            return instanceWithConfig(context2, cleverTapInstanceConfig2, str);
        }
        ManifestInfo instance = ManifestInfo.getInstance(context2);
        if (instance != null) {
            String str2 = ManifestInfo.accountId;
            String str3 = ManifestInfo.accountToken;
            String accountRegion = instance.getAccountRegion();
            if (str2 == null || str3 == null) {
                Logger.i("Account ID or Account token is missing from AndroidManifest.xml, unable to create default instance");
                cleverTapInstanceConfig = null;
            } else {
                if (accountRegion == null) {
                    Logger.i("Account Region not specified in the AndroidManifest - using default region");
                }
                cleverTapInstanceConfig = new CleverTapInstanceConfig(context2, str2, str3, accountRegion, true);
            }
            defaultConfig = cleverTapInstanceConfig;
            if (cleverTapInstanceConfig != null) {
                return instanceWithConfig(context2, cleverTapInstanceConfig, str);
            }
            return null;
        }
        throw null;
    }

    public static CleverTapAPI getDefaultInstanceOrFirstOther(Context context2) {
        CleverTapAPI defaultInstance = getDefaultInstance(context2);
        if (defaultInstance == null) {
            HashMap<String, CleverTapAPI> hashMap = instances;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (String str : instances.keySet()) {
                    defaultInstance = instances.get(str);
                    if (defaultInstance != null) {
                        break;
                    }
                }
            }
        }
        return defaultInstance;
    }

    public static NotificationInfo getNotificationInfo(Bundle bundle) {
        boolean z = false;
        if (bundle == null) {
            return new NotificationInfo(false, false);
        }
        boolean containsKey = bundle.containsKey("wzrk_pn");
        if (containsKey && bundle.containsKey("nm")) {
            z = true;
        }
        return new NotificationInfo(containsKey, z);
    }

    public static void handleNotificationClicked(Context context2, Bundle bundle) {
        String str;
        try {
            str = bundle.getString(MPLApplicationLifeCycleCallback.WZRK_ACCT_ID_KEY);
        } catch (Throwable unused) {
            str = null;
        }
        HashMap<String, CleverTapAPI> hashMap = instances;
        if (hashMap == null) {
            CleverTapAPI createInstanceIfAvailable = createInstanceIfAvailable(context2, str, null);
            if (createInstanceIfAvailable != null) {
                createInstanceIfAvailable.coreState.analyticsManager.pushNotificationClickedEvent(bundle);
            }
            return;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CleverTapAPI cleverTapAPI = instances.get(it.next());
            boolean z = false;
            if (cleverTapAPI != null && ((str == null && cleverTapAPI.coreState.config.isDefaultInstance) || cleverTapAPI.getAccountId().equals(str))) {
                z = true;
                continue;
            }
            if (z) {
                cleverTapAPI.coreState.analyticsManager.pushNotificationClickedEvent(bundle);
                break;
            }
        }
    }

    public static CleverTapAPI instanceWithConfig(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig) {
        return instanceWithConfig(context2, cleverTapInstanceConfig, null);
    }

    public static boolean isAppForeground() {
        return CoreMetaData.appForeground;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005b A[SYNTHETIC, Splitter:B:29:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009d A[Catch:{ all -> 0x00b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void onActivityCreated(android.app.Activity r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "wzrk_from"
            java.lang.String r1 = "wzrk_acct_id"
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r2 = instances
            r3 = 0
            if (r2 != 0) goto L_0x0010
            android.content.Context r2 = r6.getApplicationContext()
            createInstanceIfAvailable(r2, r3, r7)
        L_0x0010:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r7 = instances
            if (r7 != 0) goto L_0x001a
            java.lang.String r6 = "Instances is null in onActivityCreated!"
            com.clevertap.android.sdk.Logger.v(r6)
            return
        L_0x001a:
            r7 = 1
            android.content.Intent r2 = r6.getIntent()     // Catch:{ all -> 0x0032 }
            android.net.Uri r2 = r2.getData()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0033
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0033 }
            android.os.Bundle r4 = co.hyperverge.hypersnapsdk.c.k.getAllKeyValuePairs(r4, r7)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r4.getString(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0034
        L_0x0032:
            r2 = r3
        L_0x0033:
            r4 = r3
        L_0x0034:
            r5 = 0
            android.content.Intent r6 = r6.getIntent()     // Catch:{ all -> 0x0087 }
            android.os.Bundle r3 = r6.getExtras()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0088
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0087 }
            if (r6 != 0) goto L_0x0088
            boolean r6 = r3.containsKey(r0)     // Catch:{ all -> 0x0087 }
            if (r6 == 0) goto L_0x0058
            java.lang.String r6 = "CTPushNotificationReceiver"
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x0087 }
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0087 }
            if (r6 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r7 = 0
        L_0x0059:
            if (r7 == 0) goto L_0x0078
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r6.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = "ActivityLifecycleCallback: Notification Clicked already processed for "
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0085 }
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = ", dropping duplicate."
            r6.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0085 }
            com.clevertap.android.sdk.Logger.v(r6)     // Catch:{ all -> 0x0085 }
        L_0x0078:
            boolean r6 = r3.containsKey(r1)     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x0085
            java.lang.Object r6 = r3.get(r1)     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0085 }
            r4 = r6
        L_0x0085:
            r5 = r7
            goto L_0x0088
        L_0x0087:
        L_0x0088:
            if (r5 == 0) goto L_0x008d
            if (r2 != 0) goto L_0x008d
            return
        L_0x008d:
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r6 = instances     // Catch:{ all -> 0x00b5 }
            java.util.Set r6 = r6.keySet()     // Catch:{ all -> 0x00b5 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00b5 }
        L_0x0097:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x00ca
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x00b5 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00b5 }
            java.util.HashMap<java.lang.String, com.clevertap.android.sdk.CleverTapAPI> r0 = instances     // Catch:{ all -> 0x00b5 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x00b5 }
            com.clevertap.android.sdk.CleverTapAPI r7 = (com.clevertap.android.sdk.CleverTapAPI) r7     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x0097
            com.clevertap.android.sdk.CoreState r7 = r7.coreState     // Catch:{ all -> 0x00b5 }
            com.clevertap.android.sdk.ActivityLifeCycleManager r7 = r7.activityLifeCycleManager     // Catch:{ all -> 0x00b5 }
            r7.onActivityCreated(r3, r2, r4)     // Catch:{ all -> 0x00b5 }
            goto L_0x0097
        L_0x00b5:
            r6 = move-exception
            java.lang.String r7 = "Throwable - "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            java.lang.String r6 = r6.getLocalizedMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.clevertap.android.sdk.Logger.v(r6)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.onActivityCreated(android.app.Activity, java.lang.String):void");
    }

    public static void onActivityPaused() {
        HashMap<String, CleverTapAPI> hashMap = instances;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                CleverTapAPI cleverTapAPI = instances.get(str);
                if (cleverTapAPI != null) {
                    try {
                        cleverTapAPI.coreState.activityLifeCycleManager.activityPaused();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void onActivityResumed(Activity activity, String str) {
        String str2 = null;
        if (instances == null) {
            createInstanceIfAvailable(activity.getApplicationContext(), null, str);
        }
        CoreMetaData.appForeground = true;
        if (instances == null) {
            Logger.v("Instances is null in onActivityResumed!");
            return;
        }
        Activity currentActivity = CoreMetaData.getCurrentActivity();
        if (currentActivity != null) {
            str2 = currentActivity.getLocalClassName();
        }
        CoreMetaData.setCurrentActivity(activity);
        if (str2 == null || !str2.equals(activity.getLocalClassName())) {
            CoreMetaData.activityCount++;
        }
        if (CoreMetaData.initialAppEnteredForegroundTime <= 0) {
            CoreMetaData.initialAppEnteredForegroundTime = Utils.getNow();
        }
        for (String str3 : instances.keySet()) {
            CleverTapAPI cleverTapAPI = instances.get(str3);
            if (cleverTapAPI != null) {
                try {
                    cleverTapAPI.coreState.activityLifeCycleManager.activityResumed(activity);
                } catch (Throwable th) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Throwable - ");
                    outline73.append(th.getLocalizedMessage());
                    Logger.v(outline73.toString());
                }
            }
        }
    }

    public static void setAppForeground(boolean z) {
        CoreMetaData.appForeground = z;
    }

    public static void tokenRefresh(Context context2, String str, PushType pushType) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, CleverTapAPI> hashMap = instances;
        if (hashMap == null || hashMap.isEmpty()) {
            CleverTapAPI defaultInstance = getDefaultInstance(context2);
            if (defaultInstance != null) {
                arrayList.add(defaultInstance);
            }
        } else {
            arrayList.addAll(instances.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CleverTapAPI) it.next()).coreState.pushProviders.doTokenRefresh(str, pushType);
        }
    }

    public void addMultiValueForKey(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            this.coreState.analyticsManager._generateEmptyMultiValueError(str);
        } else {
            addMultiValuesForKey(str, new ArrayList(Collections.singletonList(str2)));
        }
    }

    public void addMultiValuesForKey(String str, ArrayList<String> arrayList) {
        AnalyticsManager analyticsManager = this.coreState.analyticsManager;
        Task postAsyncSafelyTask = CTExecutorFactory.executors(analyticsManager.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("addMultiValuesForKey", new Callable<Void>(str, arrayList) {
            public final /* synthetic */ String val$key;
            public final /* synthetic */ ArrayList val$values;

            {
                this.val$key = r2;
                this.val$values = r3;
            }

            public Object call() throws Exception {
                AnalyticsManager.access$100(AnalyticsManager.this, this.val$values, this.val$key, AnalyticsManager.this.localDataStore.getProfileValueForKey(this.val$key) != null ? "$add" : "$set");
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
    }

    public void enableDeviceNetworkInfoReporting(boolean z) {
        DeviceInfo deviceInfo = this.coreState.deviceInfo;
        deviceInfo.enableNetworkInfoReporting = z;
        Context context2 = deviceInfo.context;
        k.persist(k.getPreferences(context2).edit().putBoolean(k.storageKeyWithSuffix(deviceInfo.config, "NetworkInfo"), deviceInfo.enableNetworkInfoReporting));
        Logger logger = deviceInfo.config.getLogger();
        String str = deviceInfo.config.accountId;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Device Network Information reporting set to ");
        outline73.append(deviceInfo.enableNetworkInfoReporting);
        logger.verbose(str, outline73.toString());
    }

    public String getAccountId() {
        return this.coreState.config.accountId;
    }

    public ArrayList<CTInboxMessage> getAllInboxMessages() {
        Logger.d("CleverTapAPI:getAllInboxMessages: called");
        ArrayList<CTInboxMessage> arrayList = new ArrayList<>();
        synchronized (this.coreState.ctLockManager.inboxControllerLock) {
            try {
                if (this.coreState.controllerManager.ctInboxController != null) {
                    Iterator<CTMessageDAO> it = this.coreState.controllerManager.ctInboxController.getMessages().iterator();
                    while (it.hasNext()) {
                        CTMessageDAO next = it.next();
                        Logger.v("CTMessage Dao - " + next.toJSON().toString());
                        arrayList.add(new CTInboxMessage(next.toJSON()));
                    }
                    return arrayList;
                }
                getConfigLogger().debug(getAccountId(), "Notification Inbox not initialized");
                return arrayList;
            }
        }
    }

    public String getCleverTapID() {
        return this.coreState.deviceInfo.getDeviceID();
    }

    public final Logger getConfigLogger() {
        return this.coreState.config.getLogger();
    }

    public Map<String, EventDetail> getHistory() {
        String str;
        LocalDataStore localDataStore = this.coreState.localDataStore;
        Context context2 = this.context;
        if (localDataStore != null) {
            try {
                if (!localDataStore.config.isDefaultInstance) {
                    str = "local_events:" + localDataStore.config.accountId;
                } else {
                    str = "local_events";
                }
                Map<String, ?> all = k.getPreferences(context2, str).getAll();
                HashMap hashMap = new HashMap();
                for (String next : all.keySet()) {
                    hashMap.put(next, localDataStore.decodeEventDetails(next, all.get(next).toString()));
                }
                return hashMap;
            } catch (Throwable th) {
                localDataStore.getConfigLogger().verbose(localDataStore.config.accountId, "Failed to retrieve local event history", th);
                return null;
            }
        } else {
            throw null;
        }
    }

    public int getInboxMessageCount() {
        synchronized (this.coreState.ctLockManager.inboxControllerLock) {
            try {
                if (this.coreState.controllerManager.ctInboxController != null) {
                    int size = this.coreState.controllerManager.ctInboxController.getMessages().size();
                    return size;
                }
                getConfigLogger().debug(getAccountId(), "Notification Inbox not initialized");
                return -1;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.clevertap.android.sdk.inbox.CTInboxMessage getInboxMessageForId(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CleverTapAPI:getInboxMessageForId() called with: messageId = ["
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.clevertap.android.sdk.Logger.d(r0)
            com.clevertap.android.sdk.CoreState r0 = r4.coreState
            com.clevertap.android.sdk.CTLockManager r0 = r0.ctLockManager
            java.lang.Object r0 = r0.inboxControllerLock
            monitor-enter(r0)
            com.clevertap.android.sdk.CoreState r1 = r4.coreState     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.ControllerManager r1 = r1.controllerManager     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.inbox.CTInboxController r1 = r1.ctInboxController     // Catch:{ all -> 0x004f }
            r2 = 0
            if (r1 == 0) goto L_0x0040
            com.clevertap.android.sdk.CoreState r1 = r4.coreState     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.ControllerManager r1 = r1.controllerManager     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.inbox.CTInboxController r1 = r1.ctInboxController     // Catch:{ all -> 0x004f }
            com.clevertap.android.sdk.inbox.CTMessageDAO r5 = r1.findMessageById(r5)     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x003e
            com.clevertap.android.sdk.inbox.CTInboxMessage r2 = new com.clevertap.android.sdk.inbox.CTInboxMessage     // Catch:{ all -> 0x004f }
            org.json.JSONObject r5 = r5.toJSON()     // Catch:{ all -> 0x004f }
            r2.<init>(r5)     // Catch:{ all -> 0x004f }
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r2
        L_0x0040:
            com.clevertap.android.sdk.Logger r5 = r4.getConfigLogger()     // Catch:{ all -> 0x004f }
            java.lang.String r1 = r4.getAccountId()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "Notification Inbox not initialized"
            r5.debug(r1, r3)     // Catch:{ all -> 0x004f }
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r2
        L_0x004f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.getInboxMessageForId(java.lang.String):com.clevertap.android.sdk.inbox.CTInboxMessage");
    }

    public void markReadInboxMessage(CTInboxMessage cTInboxMessage) {
        CTInboxController cTInboxController = this.coreState.controllerManager.ctInboxController;
        if (cTInboxController != null) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cTInboxController.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("markReadInboxMessage", new Callable<Void>(cTInboxMessage) {
                public final /* synthetic */ CTInboxMessage val$message;

                {
                    this.val$message = r2;
                }

                public Object call() throws Exception {
                    synchronized (CTInboxController.this.ctLockManager.inboxControllerLock) {
                        if (CTInboxController.this._markReadForMessageWithId(this.val$message.messageId)) {
                            CTInboxController.this.callbackManager._notifyInboxMessagesDidUpdate();
                        }
                    }
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
        getConfigLogger().debug(getAccountId(), "Notification Inbox not initialized");
    }

    public void messageDidClick(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z) {
        this.coreState.analyticsManager.pushInboxMessageStateEvent(true, cTInboxMessage, bundle);
        if (hashMap != null) {
            boolean isEmpty = hashMap.isEmpty();
        }
    }

    public void messageDidShow(CTInboxActivity cTInboxActivity, final CTInboxMessage cTInboxMessage, final Bundle bundle) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.coreState.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("handleMessageDidShow", new Callable<Void>() {
            public Object call() throws Exception {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("CleverTapAPI:messageDidShow() called  in async with: messageId = [");
                outline73.append(cTInboxMessage.messageId);
                outline73.append(CMapParser.MARK_END_OF_ARRAY);
                Logger.d(outline73.toString());
                if (!CleverTapAPI.this.getInboxMessageForId(cTInboxMessage.messageId).isRead) {
                    CleverTapAPI.this.markReadInboxMessage(cTInboxMessage);
                    CleverTapAPI.this.coreState.analyticsManager.pushInboxMessageStateEvent(false, cTInboxMessage, bundle);
                }
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
    }

    public void onUserLogin(Map<String, Object> map) {
        String str;
        LoginController loginController = this.coreState.loginController;
        if (loginController.config.enableCustomCleverTapId) {
            Logger.i("CLEVERTAP_USE_CUSTOM_ID has been specified in the AndroidManifest.xml Please call onUserlogin() and pass a custom CleverTap ID");
        }
        if (map != null) {
            try {
                String deviceID = loginController.deviceInfo.getDeviceID();
                if (deviceID != null) {
                    LoginInfoProvider loginInfoProvider = new LoginInfoProvider(loginController.context, loginController.config, loginController.deviceInfo);
                    IdentityRepo repo = k.getRepo(loginController.context, loginController.config, loginController.deviceInfo, loginController.validationResultStack);
                    Iterator<String> it = map.keySet().iterator();
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            Object obj = map.get(next);
                            if (repo.hasIdentity(next)) {
                                if (obj != null) {
                                    try {
                                        str = obj.toString();
                                    } catch (Throwable unused) {
                                        continue;
                                    }
                                } else {
                                    str = null;
                                }
                                if (str != null && str.length() > 0) {
                                    try {
                                        String gUIDForIdentifier = loginInfoProvider.getGUIDForIdentifier(next, str);
                                        loginController.cachedGUID = gUIDForIdentifier;
                                        if (gUIDForIdentifier != null) {
                                            z2 = true;
                                            break;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    z2 = true;
                                }
                            }
                        }
                    }
                    if (!loginController.deviceInfo.isErrorDeviceId() && (!z2 || loginInfoProvider.isAnonymousDevice())) {
                        loginController.config.getLogger().debug(loginController.config.accountId, "onUserLogin: no identifier provided or device is anonymous, pushing on current user profile");
                        loginController.analyticsManager.pushProfile(map);
                    } else if (loginController.cachedGUID == null || !loginController.cachedGUID.equals(deviceID)) {
                        String obj2 = map.toString();
                        synchronized (LoginController.processingUserLoginLock) {
                            if (loginController.processingUserLoginIdentifier != null && loginController.processingUserLoginIdentifier.equals(obj2)) {
                                z = true;
                            }
                        }
                        if (z) {
                            loginController.config.getLogger().debug(loginController.config.accountId, "Already processing onUserLogin for " + obj2);
                            return;
                        }
                        synchronized (LoginController.processingUserLoginLock) {
                            loginController.processingUserLoginIdentifier = obj2;
                        }
                        Logger logger = loginController.config.getLogger();
                        String str2 = loginController.config.accountId;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onUserLogin: queuing reset profile for ");
                        sb.append(obj2);
                        sb.append(" with Cached GUID ");
                        sb.append(loginController.cachedGUID != null ? loginController.cachedGUID : "NULL");
                        logger.verbose(str2, sb.toString());
                        loginController.asyncProfileSwitchUser(map, loginController.cachedGUID, null);
                    } else {
                        loginController.config.getLogger().debug(loginController.config.accountId, "onUserLogin: " + map.toString() + " maps to current device id " + deviceID + " pushing on current profile");
                        loginController.analyticsManager.pushProfile(map);
                    }
                }
            } catch (Throwable th) {
                loginController.config.getLogger().verbose(loginController.config.accountId, "onUserLogin failed", th);
            }
        }
    }

    public void pushChargedEvent(HashMap<String, Object> hashMap, ArrayList<HashMap<String, Object>> arrayList) {
        String str;
        Object obj;
        String obj2;
        HashMap<String, Object> hashMap2 = hashMap;
        AnalyticsManager analyticsManager = this.coreState.analyticsManager;
        if (analyticsManager == null) {
            throw null;
        } else if (hashMap2 == null || arrayList == null) {
            analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, "Invalid Charged event: details and or items is null");
        } else {
            if (arrayList.size() > 50) {
                ValidationResult create = k.create(522, -1, new String[0]);
                analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create.errorDesc);
                analyticsManager.validationResultStack.pushValidationResult(create);
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                Iterator<String> it = hashMap.keySet().iterator();
                while (true) {
                    str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    obj = hashMap2.get(next);
                    ValidationResult cleanObjectKey = analyticsManager.validator.cleanObjectKey(next);
                    obj2 = cleanObjectKey.object.toString();
                    if (cleanObjectKey.errorCode != 0) {
                        jSONObject2.put("wzrk_error", k.getErrorObject(cleanObjectKey));
                    }
                    ValidationResult cleanObjectValue = analyticsManager.validator.cleanObjectValue(obj, ValidationContext.Event);
                    Object obj3 = cleanObjectValue.object;
                    if (cleanObjectValue.errorCode != 0) {
                        jSONObject2.put("wzrk_error", k.getErrorObject(cleanObjectValue));
                    }
                    jSONObject.put(obj2, obj3);
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<HashMap<String, Object>> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    HashMap next2 = it2.next();
                    JSONObject jSONObject3 = new JSONObject();
                    for (String str2 : next2.keySet()) {
                        Object obj4 = next2.get(str2);
                        ValidationResult cleanObjectKey2 = analyticsManager.validator.cleanObjectKey(str2);
                        String obj5 = cleanObjectKey2.object.toString();
                        if (cleanObjectKey2.errorCode != 0) {
                            jSONObject2.put("wzrk_error", k.getErrorObject(cleanObjectKey2));
                        }
                        try {
                            ValidationResult cleanObjectValue2 = analyticsManager.validator.cleanObjectValue(obj4, ValidationContext.Event);
                            Object obj6 = cleanObjectValue2.object;
                            if (cleanObjectValue2.errorCode != 0) {
                                jSONObject2.put("wzrk_error", k.getErrorObject(cleanObjectValue2));
                            }
                            jSONObject3.put(obj5, obj6);
                        } catch (IllegalArgumentException unused) {
                            String[] strArr = new String[2];
                            strArr[0] = obj5;
                            strArr[1] = obj4 != null ? obj4.toString() : str;
                            ValidationResult create2 = k.create(FrameMetricsAggregator.EVERY_DURATION, 15, strArr);
                            analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create2.errorDesc);
                            analyticsManager.validationResultStack.pushValidationResult(create2);
                        }
                    }
                    jSONArray.put(jSONObject3);
                }
                jSONObject.put("Items", jSONArray);
                jSONObject2.put("evtName", "Charged");
                jSONObject2.put("evtData", jSONObject);
                analyticsManager.baseEventQueueManager.queueEvent(analyticsManager.context, jSONObject2, 4);
            } catch (IllegalArgumentException unused2) {
                String[] strArr2 = new String[3];
                strArr2[0] = "Charged";
                strArr2[1] = obj2;
                if (obj != null) {
                    str = obj.toString();
                }
                strArr2[2] = str;
                ValidationResult create3 = k.create(FrameMetricsAggregator.EVERY_DURATION, 7, strArr2);
                analyticsManager.validationResultStack.pushValidationResult(create3);
                analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create3.errorDesc);
            } catch (Throwable unused3) {
            }
        }
    }

    public void pushEvent(String str) {
        if (str != null && !str.trim().equals("")) {
            pushEvent(str, null);
        }
    }

    public void pushFcmRegistrationId(String str, boolean z) {
        this.coreState.pushProviders.handleToken(str, PushType.FCM, z);
    }

    public void pushNotificationViewedEvent(Bundle bundle) {
        this.coreState.analyticsManager.pushNotificationViewedEvent(bundle);
    }

    public void removeMultiValueForKey(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            this.coreState.analyticsManager._generateEmptyMultiValueError(str);
        } else {
            removeMultiValuesForKey(str, new ArrayList(Collections.singletonList(str2)));
        }
    }

    public void removeMultiValuesForKey(String str, ArrayList<String> arrayList) {
        AnalyticsManager analyticsManager = this.coreState.analyticsManager;
        Task postAsyncSafelyTask = CTExecutorFactory.executors(analyticsManager.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("removeMultiValuesForKey", new Callable<Void>(arrayList, str) {
            public final /* synthetic */ String val$key;
            public final /* synthetic */ ArrayList val$values;

            {
                this.val$values = r2;
                this.val$key = r3;
            }

            public Object call() throws Exception {
                AnalyticsManager.access$100(AnalyticsManager.this, this.val$values, this.val$key, "$remove");
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
    }

    public void removeValueForKey(String str) {
        AnalyticsManager analyticsManager = this.coreState.analyticsManager;
        Task postAsyncSafelyTask = CTExecutorFactory.executors(analyticsManager.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("removeValueForKey", new Callable<Void>(str) {
            public final /* synthetic */ String val$key;

            {
                this.val$key = r2;
            }

            public Object call() throws Exception {
                AnalyticsManager analyticsManager = AnalyticsManager.this;
                String str = this.val$key;
                if (analyticsManager != null) {
                    if (str == null) {
                        str = "";
                    }
                    try {
                        ValidationResult cleanObjectKey = analyticsManager.validator.cleanObjectKey(str);
                        str = cleanObjectKey.object.toString();
                        if (str.isEmpty()) {
                            ValidationResult create = k.create(512, 6, new String[0]);
                            analyticsManager.validationResultStack.pushValidationResult(create);
                            analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create.errorDesc);
                        } else {
                            if (cleanObjectKey.errorCode != 0) {
                                analyticsManager.validationResultStack.pushValidationResult(cleanObjectKey);
                            }
                            if (str.toLowerCase().contains("identity")) {
                                Logger logger = analyticsManager.config.getLogger();
                                String str2 = analyticsManager.config.accountId;
                                logger.verbose(str2, "Cannot remove value for key " + str + " from user profile");
                            } else {
                                analyticsManager.localDataStore.removeProfileField(str, Boolean.FALSE, true);
                                analyticsManager.baseEventQueueManager.pushBasicProfile(new JSONObject().put(str, new JSONObject().put("$delete", true)), true);
                                Logger logger2 = analyticsManager.config.getLogger();
                                String str3 = analyticsManager.config.accountId;
                                logger2.verbose(str3, "removing value for key " + str + " from user profile");
                            }
                        }
                    } catch (Throwable th) {
                        Logger logger3 = analyticsManager.config.getLogger();
                        String str4 = analyticsManager.config.accountId;
                        logger3.verbose(str4, "Failed to remove profile value for key " + str, th);
                    }
                    return null;
                }
                throw null;
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
    }

    public void renderPushNotification(final INotificationRenderer iNotificationRenderer, final Context context2, final Bundle bundle) {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.coreState.config;
        try {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("CleverTapAPI#renderPushNotification", new Callable<Void>() {
                public Object call() throws Exception {
                    synchronized (CleverTapAPI.this.coreState.pushProviders.pushRenderingLock) {
                        CleverTapAPI.this.coreState.pushProviders.iNotificationRenderer = iNotificationRenderer;
                        if (bundle == null || !bundle.containsKey(Constant.NOTIFICATION_ID)) {
                            CleverTapAPI.this.coreState.pushProviders._createNotification(context2, bundle, NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
                        } else {
                            CleverTapAPI.this.coreState.pushProviders._createNotification(context2, bundle, bundle.getInt(Constant.NOTIFICATION_ID));
                        }
                    }
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
        } catch (Throwable th) {
            cleverTapInstanceConfig.getLogger().debug(cleverTapInstanceConfig.accountId, "Failed to process renderPushNotification()", th);
        }
    }

    public void setLocation(Location location) {
        LocationManager locationManager = this.coreState.baseLocationManager;
        if (locationManager == null) {
            throw null;
        } else if (location != null) {
            locationManager.mCoreMetaData.locationFromUser = location;
            Logger logger = locationManager.mLogger;
            String str = locationManager.mConfig.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Location updated (");
            outline73.append(location.getLatitude());
            outline73.append(", ");
            outline73.append(location.getLongitude());
            outline73.append(")");
            logger.verbose(str, outline73.toString());
            if (locationManager.mCoreMetaData.isLocationForGeofence || CoreMetaData.appForeground) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (locationManager.mCoreMetaData.isLocationForGeofence && currentTimeMillis > locationManager.lastLocationPingTimeForGeofence + 10) {
                    locationManager.mBaseEventQueueManager.queueEvent(locationManager.mContext, new JSONObject(), 2);
                    locationManager.lastLocationPingTimeForGeofence = currentTimeMillis;
                    Logger logger2 = locationManager.mLogger;
                    String str2 = locationManager.mConfig.accountId;
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Queuing location ping event for geofence location (");
                    outline732.append(location.getLatitude());
                    outline732.append(", ");
                    outline732.append(location.getLongitude());
                    outline732.append(")");
                    logger2.verbose(str2, outline732.toString());
                } else if (!locationManager.mCoreMetaData.isLocationForGeofence && currentTimeMillis > locationManager.lastLocationPingTime + 10) {
                    locationManager.mBaseEventQueueManager.queueEvent(locationManager.mContext, new JSONObject(), 2);
                    locationManager.lastLocationPingTime = currentTimeMillis;
                    Logger logger3 = locationManager.mLogger;
                    String str3 = locationManager.mConfig.accountId;
                    StringBuilder outline733 = GeneratedOutlineSupport.outline73("Queuing location ping event for location (");
                    outline733.append(location.getLatitude());
                    outline733.append(", ");
                    outline733.append(location.getLongitude());
                    outline733.append(")");
                    logger3.verbose(str3, outline733.toString());
                }
            }
        }
    }

    public void setOptOut(final boolean z) {
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.coreState.config).postAsyncSafelyTask();
        postAsyncSafelyTask.executor.execute(new Runnable("setOptOut", new Callable<Void>() {
            public Object call() throws Exception {
                HashMap hashMap = new HashMap();
                hashMap.put("ct_optout", Boolean.valueOf(z));
                if (z) {
                    CleverTapAPI.this.coreState.analyticsManager.pushProfile(hashMap);
                    CleverTapAPI.this.coreState.coreMetaData.setCurrentUserOptedOut(true);
                } else {
                    CleverTapAPI.this.coreState.coreMetaData.setCurrentUserOptedOut(false);
                    CleverTapAPI.this.coreState.analyticsManager.pushProfile(hashMap);
                }
                String optOutKey = CleverTapAPI.this.coreState.deviceInfo.optOutKey();
                if (optOutKey == null) {
                    CleverTapAPI.this.getConfigLogger().verbose(CleverTapAPI.this.getAccountId(), (String) "Unable to persist user OptOut state, storage key is null");
                } else {
                    CleverTapAPI cleverTapAPI = CleverTapAPI.this;
                    Context context = cleverTapAPI.context;
                    k.persist(k.getPreferences(context).edit().putBoolean(k.storageKeyWithSuffix(cleverTapAPI.coreState.config, optOutKey), z));
                    Logger configLogger = CleverTapAPI.this.getConfigLogger();
                    String accountId = CleverTapAPI.this.getAccountId();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Set current user OptOut state to: ");
                    outline73.append(z);
                    configLogger.verbose(accountId, outline73.toString());
                }
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
    }

    /* JADX INFO: used method not loaded: com.clevertap.android.sdk.CTInboxStyleConfig.<init>(com.clevertap.android.sdk.CTInboxStyleConfig):null, types can be incorrect */
    /* JADX INFO: used method not loaded: com.clevertap.android.sdk.Logger.v(java.lang.String, java.lang.Throwable):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = com.clevertap.android.sdk.CoreMetaData.getCurrentActivity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        if (r0 == null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r0.startActivity(r4);
        com.clevertap.android.sdk.Logger.d("Displaying Notification Inbox");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        throw new java.lang.IllegalStateException("Current activity reference not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        com.clevertap.android.sdk.Logger.v((java.lang.String) "Please verify the integration of your app. It is not setup to support Notification Inbox yet.", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r0 = new com.clevertap.android.sdk.CTInboxStyleConfig(r4);
        r4 = new android.content.Intent(r3.context, com.clevertap.android.sdk.inbox.CTInboxActivity.class);
        r4.putExtra("styleConfig", r0);
        r0 = new android.os.Bundle();
        r0.putParcelable("config", r3.coreState.config);
        r4.putExtra("configBundle", r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showAppInbox(com.clevertap.android.sdk.CTInboxStyleConfig r4) {
        /*
            r3 = this;
            com.clevertap.android.sdk.CoreState r0 = r3.coreState
            com.clevertap.android.sdk.CTLockManager r0 = r0.ctLockManager
            java.lang.Object r0 = r0.inboxControllerLock
            monitor-enter(r0)
            com.clevertap.android.sdk.CoreState r1 = r3.coreState     // Catch:{ all -> 0x0063 }
            com.clevertap.android.sdk.ControllerManager r1 = r1.controllerManager     // Catch:{ all -> 0x0063 }
            com.clevertap.android.sdk.inbox.CTInboxController r1 = r1.ctInboxController     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x001e
            com.clevertap.android.sdk.Logger r4 = r3.getConfigLogger()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r3.getAccountId()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "Notification Inbox not initialized"
            r4.debug(r1, r2)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            com.clevertap.android.sdk.CTInboxStyleConfig r0 = new com.clevertap.android.sdk.CTInboxStyleConfig
            r0.<init>(r4)
            android.content.Intent r4 = new android.content.Intent
            android.content.Context r1 = r3.context
            java.lang.Class<com.clevertap.android.sdk.inbox.CTInboxActivity> r2 = com.clevertap.android.sdk.inbox.CTInboxActivity.class
            r4.<init>(r1, r2)
            java.lang.String r1 = "styleConfig"
            r4.putExtra(r1, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "config"
            com.clevertap.android.sdk.CoreState r2 = r3.coreState
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r2.config
            r0.putParcelable(r1, r2)
            java.lang.String r1 = "configBundle"
            r4.putExtra(r1, r0)
            android.app.Activity r0 = com.clevertap.android.sdk.CoreMetaData.getCurrentActivity()     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0054
            r0.startActivity(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "Displaying Notification Inbox"
            com.clevertap.android.sdk.Logger.d(r4)     // Catch:{ all -> 0x005c }
            goto L_0x0062
        L_0x0054:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005c }
            java.lang.String r0 = "Current activity reference not found"
            r4.<init>(r0)     // Catch:{ all -> 0x005c }
            throw r4     // Catch:{ all -> 0x005c }
        L_0x005c:
            r4 = move-exception
            java.lang.String r0 = "Please verify the integration of your app. It is not setup to support Notification Inbox yet."
            com.clevertap.android.sdk.Logger.v(r0, r4)
        L_0x0062:
            return
        L_0x0063:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.CleverTapAPI.showAppInbox(com.clevertap.android.sdk.CTInboxStyleConfig):void");
    }

    public static CleverTapAPI instanceWithConfig(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, String str) {
        if (cleverTapInstanceConfig == null) {
            Logger.v("CleverTapInstanceConfig cannot be null");
            return null;
        }
        if (instances == null) {
            instances = new HashMap<>();
        }
        CleverTapAPI cleverTapAPI = instances.get(cleverTapInstanceConfig.accountId);
        if (cleverTapAPI == null) {
            cleverTapAPI = new CleverTapAPI(context2, cleverTapInstanceConfig, str);
            instances.put(cleverTapInstanceConfig.accountId, cleverTapAPI);
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapAPI.coreState.config).postAsyncSafelyTask();
            postAsyncSafelyTask.executor.execute(new Runnable("recordDeviceIDErrors", new Callable<Void>() {
                public Object call() throws Exception {
                    if (CleverTapAPI.this.getCleverTapID() != null) {
                        CleverTapAPI.this.coreState.loginController.recordDeviceIDErrors();
                    }
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
        } else if (cleverTapAPI.coreState.deviceInfo.isErrorDeviceId() && cleverTapAPI.coreState.config.enableCustomCleverTapId && Utils.validateCTID(str)) {
            cleverTapAPI.coreState.loginController.asyncProfileSwitchUser(null, null, str);
        }
        String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), cleverTapInstanceConfig.accountId, ":async_deviceID");
        Logger.v(outline62, "CleverTapAPI instance = " + cleverTapAPI);
        return cleverTapAPI;
    }

    public void pushEvent(String str, Map<String, Object> map) {
        String obj;
        Object obj2;
        String obj3;
        String str2;
        AnalyticsManager analyticsManager = this.coreState.analyticsManager;
        if (analyticsManager == null) {
            throw null;
        } else if (str != null && !str.equals("")) {
            if (analyticsManager.validator != null) {
                ValidationResult validationResult = new ValidationResult();
                String[] strArr = Validator.restrictedNames;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (str.equalsIgnoreCase(strArr[i])) {
                        ValidationResult create = k.create(GL20.GL_LESS, 16, str);
                        validationResult.errorCode = create.errorCode;
                        validationResult.errorDesc = create.errorDesc;
                        Logger.v(create.errorDesc);
                        break;
                    } else {
                        i++;
                    }
                }
                if (validationResult.errorCode > 0) {
                    analyticsManager.validationResultStack.pushValidationResult(validationResult);
                    return;
                }
                Validator validator = analyticsManager.validator;
                if (validator != null) {
                    ValidationResult validationResult2 = new ValidationResult();
                    ArrayList<String> arrayList = validator.discardedEvents;
                    if (arrayList != null) {
                        Iterator<String> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (str.equalsIgnoreCase(it.next())) {
                                    ValidationResult create2 = k.create(GL20.GL_LESS, 17, str);
                                    validationResult2.errorCode = create2.errorCode;
                                    validationResult2.errorDesc = create2.errorDesc;
                                    Logger.d(str + " s a discarded event name as per CleverTap. Dropping event at SDK level. Check discarded events in CleverTap Dashboard settings.");
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (validationResult2.errorCode > 0) {
                        analyticsManager.validationResultStack.pushValidationResult(validationResult2);
                        return;
                    }
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        ValidationResult cleanEventName = analyticsManager.validator.cleanEventName(str);
                        if (cleanEventName.errorCode != 0) {
                            jSONObject.put("wzrk_error", k.getErrorObject(cleanEventName));
                        }
                        obj = cleanEventName.object.toString();
                        JSONObject jSONObject2 = new JSONObject();
                        for (String next : map.keySet()) {
                            obj2 = map.get(next);
                            ValidationResult cleanObjectKey = analyticsManager.validator.cleanObjectKey(next);
                            obj3 = cleanObjectKey.object.toString();
                            if (cleanObjectKey.errorCode != 0) {
                                jSONObject.put("wzrk_error", k.getErrorObject(cleanObjectKey));
                            }
                            ValidationResult cleanObjectValue = analyticsManager.validator.cleanObjectValue(obj2, ValidationContext.Event);
                            Object obj4 = cleanObjectValue.object;
                            if (cleanObjectValue.errorCode != 0) {
                                jSONObject.put("wzrk_error", k.getErrorObject(cleanObjectValue));
                            }
                            jSONObject2.put(obj3, obj4);
                        }
                        jSONObject.put("evtName", obj);
                        jSONObject.put("evtData", jSONObject2);
                        analyticsManager.baseEventQueueManager.queueEvent(analyticsManager.context, jSONObject, 4);
                    } catch (IllegalArgumentException unused) {
                        String[] strArr2 = new String[3];
                        strArr2[0] = obj;
                        strArr2[1] = obj3;
                        if (obj2 != null) {
                            str2 = obj2.toString();
                        } else {
                            str2 = "";
                        }
                        strArr2[2] = str2;
                        ValidationResult create3 = k.create(512, 7, strArr2);
                        analyticsManager.config.getLogger().debug(analyticsManager.config.accountId, create3.errorDesc);
                        analyticsManager.validationResultStack.pushValidationResult(create3);
                    } catch (Throwable unused2) {
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }
    }

    public static CleverTapAPI getDefaultInstance(Context context2) {
        return getDefaultInstance(context2, null);
    }
}
