package com.clevertap.android.sdk.inapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CallbackManager;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.InAppFCManager;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.InAppNotificationListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.inapp.CTInAppNotification.CTInAppNotificationListener;
import com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.ImageCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

public class InAppController implements CTInAppNotificationListener, InAppListener {
    public static CTInAppNotification currentlyDisplayingInApp;
    public static final List<CTInAppNotification> pendingNotifications = Collections.synchronizedList(new ArrayList());
    public final AnalyticsManager analyticsManager;
    public final BaseCallbackManager callbackManager;
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final ControllerManager controllerManager;
    public final CoreMetaData coreMetaData;
    public InAppState inAppState;
    public HashSet<String> inappActivityExclude = null;
    public final Logger logger;
    public final MainLooperHandler mainLooperHandler;

    public enum InAppState {
        DISCARDED(-1),
        SUSPENDED(0),
        RESUMED(1);
        
        public final int state;

        /* access modifiers changed from: public */
        InAppState(int i) {
            this.state = i;
        }

        public int intValue() {
            return this.state;
        }
    }

    public final class NotificationPrepareRunnable implements Runnable {
        public final WeakReference<InAppController> inAppControllerWeakReference;
        public final JSONObject jsonObject;
        public final boolean videoSupport = Utils.haveVideoPlayerSupport;

        public NotificationPrepareRunnable(InAppController inAppController, JSONObject jSONObject) {
            this.inAppControllerWeakReference = new WeakReference<>(inAppController);
            this.jsonObject = jSONObject;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x0074 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x013c  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0206  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0074 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r11 = this;
                com.clevertap.android.sdk.inapp.CTInAppNotification r0 = new com.clevertap.android.sdk.inapp.CTInAppNotification
                r0.<init>()
                org.json.JSONObject r1 = r11.jsonObject
                boolean r2 = r11.videoSupport
                java.lang.String r3 = "type"
                r0.videoSupported = r2
                r0.jsonDescription = r1
                r2 = 0
                boolean r4 = r1.has(r3)     // Catch:{ JSONException -> 0x0031 }
                if (r4 == 0) goto L_0x001b
                java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x0031 }
                goto L_0x001c
            L_0x001b:
                r3 = r2
            L_0x001c:
                r0.type = r3     // Catch:{ JSONException -> 0x0031 }
                if (r3 == 0) goto L_0x002d
                java.lang.String r4 = "custom-html"
                boolean r3 = r3.equals(r4)     // Catch:{ JSONException -> 0x0031 }
                if (r3 == 0) goto L_0x0029
                goto L_0x002d
            L_0x0029:
                r0.configureWithJson(r1)     // Catch:{ JSONException -> 0x0031 }
                goto L_0x0045
            L_0x002d:
                r0.legacyConfigureWithJson(r1)     // Catch:{ JSONException -> 0x0031 }
                goto L_0x0045
            L_0x0031:
                r1 = move-exception
                java.lang.String r3 = "Invalid JSON : "
                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                java.lang.String r1 = r1.getLocalizedMessage()
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r0.error = r1
            L_0x0045:
                java.lang.String r1 = r0.error
                if (r1 == 0) goto L_0x0064
                com.clevertap.android.sdk.inapp.InAppController r1 = com.clevertap.android.sdk.inapp.InAppController.this
                com.clevertap.android.sdk.Logger r2 = r1.logger
                com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r1.config
                java.lang.String r1 = r1.accountId
                java.lang.String r3 = "Unable to parse inapp notification "
                java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
                java.lang.String r0 = r0.error
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.debug(r1, r0)
                return
            L_0x0064:
                java.lang.ref.WeakReference<com.clevertap.android.sdk.inapp.InAppController> r1 = r11.inAppControllerWeakReference
                java.lang.Object r1 = r1.get()
                com.clevertap.android.sdk.inapp.CTInAppNotification$CTInAppNotificationListener r1 = (com.clevertap.android.sdk.inapp.CTInAppNotification.CTInAppNotificationListener) r1
                r0.listener = r1
                java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r1 = r0.mediaList
                java.util.Iterator r1 = r1.iterator()
            L_0x0074:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x022d
                java.lang.Object r3 = r1.next()
                com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r3 = (com.clevertap.android.sdk.inapp.CTInAppNotificationMedia) r3
                boolean r4 = r3.isGIF()
                r5 = 1
                if (r4 == 0) goto L_0x0142
                com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.init()
                byte[] r4 = r0.getGifByteArray(r3)
                if (r4 == 0) goto L_0x0097
                com.clevertap.android.sdk.inapp.CTInAppNotification$CTInAppNotificationListener r1 = r0.listener
                r1.notificationReady(r0)
                goto L_0x0232
            L_0x0097:
                java.lang.String r4 = r3.mediaUrl
                if (r4 == 0) goto L_0x0074
                java.lang.String r4 = "CTInAppNotification: downloading GIF :"
                java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
                java.lang.String r6 = r3.mediaUrl
                r4.append(r6)
                java.lang.String r4 = r4.toString()
                com.clevertap.android.sdk.Logger.v(r4)
                java.lang.String r4 = r3.mediaUrl
                byte[] r4 = com.clevertap.android.sdk.Utils.getByteArrayFromImageURL(r4)
                if (r4 == 0) goto L_0x0074
                java.lang.String r6 = "GIF Downloaded from url: "
                java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
                java.lang.String r7 = r3.mediaUrl
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.clevertap.android.sdk.Logger.v(r6)
                java.lang.String r3 = r3.cacheKey
                android.util.LruCache<java.lang.String, byte[]> r6 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.mMemoryCache
                if (r6 != 0) goto L_0x00ce
                goto L_0x011a
            L_0x00ce:
                byte[] r6 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.getByteArray(r3)
                if (r6 != 0) goto L_0x013a
                java.lang.Class<com.clevertap.android.sdk.inapp.CTInAppNotification$GifCache> r6 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.class
                monitor-enter(r6)
                int r7 = r4.length     // Catch:{ all -> 0x0137 }
                int r7 = r7 / 1024
                int r8 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.getAvailableMemory()     // Catch:{ all -> 0x0137 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
                r9.<init>()     // Catch:{ all -> 0x0137 }
                java.lang.String r10 = "CTInAppNotification.GifCache: gif size: "
                r9.append(r10)     // Catch:{ all -> 0x0137 }
                r9.append(r7)     // Catch:{ all -> 0x0137 }
                java.lang.String r10 = "KB. Available mem: "
                r9.append(r10)     // Catch:{ all -> 0x0137 }
                r9.append(r8)     // Catch:{ all -> 0x0137 }
                java.lang.String r8 = "KB."
                r9.append(r8)     // Catch:{ all -> 0x0137 }
                java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0137 }
                com.clevertap.android.sdk.Logger.v(r8)     // Catch:{ all -> 0x0137 }
                int r8 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.getAvailableMemory()     // Catch:{ all -> 0x0137 }
                if (r7 <= r8) goto L_0x011c
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
                r4.<init>()     // Catch:{ all -> 0x0137 }
                java.lang.String r5 = "CTInAppNotification.GifCache: insufficient memory to add gif: "
                r4.append(r5)     // Catch:{ all -> 0x0137 }
                r4.append(r3)     // Catch:{ all -> 0x0137 }
                java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0137 }
                com.clevertap.android.sdk.Logger.v(r3)     // Catch:{ all -> 0x0137 }
                monitor-exit(r6)     // Catch:{ all -> 0x0137 }
            L_0x011a:
                r5 = 0
                goto L_0x013a
            L_0x011c:
                android.util.LruCache<java.lang.String, byte[]> r7 = com.clevertap.android.sdk.inapp.CTInAppNotification.GifCache.mMemoryCache     // Catch:{ all -> 0x0137 }
                r7.put(r3, r4)     // Catch:{ all -> 0x0137 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0137 }
                r4.<init>()     // Catch:{ all -> 0x0137 }
                java.lang.String r7 = "CTInAppNotification.GifCache: added gif for key: "
                r4.append(r7)     // Catch:{ all -> 0x0137 }
                r4.append(r3)     // Catch:{ all -> 0x0137 }
                java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0137 }
                com.clevertap.android.sdk.Logger.v(r3)     // Catch:{ all -> 0x0137 }
                monitor-exit(r6)     // Catch:{ all -> 0x0137 }
                goto L_0x013a
            L_0x0137:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0137 }
                throw r0
            L_0x013a:
                if (r5 != 0) goto L_0x0074
                java.lang.String r3 = "Error processing GIF"
                r0.error = r3
                goto L_0x0074
            L_0x0142:
                boolean r4 = r3.isImage()
                if (r4 == 0) goto L_0x0217
                com.clevertap.android.sdk.utils.ImageCache.init()
                android.graphics.Bitmap r4 = r0.getImage(r3)
                if (r4 == 0) goto L_0x0158
                com.clevertap.android.sdk.inapp.CTInAppNotification$CTInAppNotificationListener r1 = r0.listener
                r1.notificationReady(r0)
                goto L_0x0232
            L_0x0158:
                java.lang.String r4 = r3.mediaUrl
                if (r4 == 0) goto L_0x0074
                java.lang.String r4 = "CTInAppNotification: downloading Image :"
                java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
                java.lang.String r6 = r3.mediaUrl
                r4.append(r6)
                java.lang.String r4 = r4.toString()
                com.clevertap.android.sdk.Logger.v(r4)
                java.lang.String r4 = r3.mediaUrl
                android.graphics.Bitmap r4 = com.clevertap.android.sdk.Utils.getBitmapFromURL(r4)
                if (r4 == 0) goto L_0x020c
                java.lang.String r6 = "Image Downloaded from url: "
                java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
                java.lang.String r7 = r3.mediaUrl
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.clevertap.android.sdk.Logger.v(r6)
                java.lang.String r3 = r3.cacheKey
                android.util.LruCache<java.lang.String, android.graphics.Bitmap> r6 = com.clevertap.android.sdk.utils.ImageCache.memoryCache
                if (r6 != 0) goto L_0x018f
                goto L_0x01e4
            L_0x018f:
                if (r3 == 0) goto L_0x0198
                java.lang.Object r6 = r6.get(r3)
                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                goto L_0x0199
            L_0x0198:
                r6 = r2
            L_0x0199:
                if (r6 != 0) goto L_0x0204
                java.lang.Class<com.clevertap.android.sdk.utils.ImageCache> r6 = com.clevertap.android.sdk.utils.ImageCache.class
                monitor-enter(r6)
                int r7 = r4.getByteCount()     // Catch:{ all -> 0x0201 }
                int r7 = r7 / 1024
                int r8 = com.clevertap.android.sdk.utils.ImageCache.getAvailableMemory()     // Catch:{ all -> 0x0201 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
                r9.<init>()     // Catch:{ all -> 0x0201 }
                java.lang.String r10 = "CleverTap.ImageCache: image size: "
                r9.append(r10)     // Catch:{ all -> 0x0201 }
                r9.append(r7)     // Catch:{ all -> 0x0201 }
                java.lang.String r10 = "KB. Available mem: "
                r9.append(r10)     // Catch:{ all -> 0x0201 }
                r9.append(r8)     // Catch:{ all -> 0x0201 }
                java.lang.String r8 = "KB."
                r9.append(r8)     // Catch:{ all -> 0x0201 }
                java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x0201 }
                com.clevertap.android.sdk.Logger.v(r8)     // Catch:{ all -> 0x0201 }
                int r8 = com.clevertap.android.sdk.utils.ImageCache.getAvailableMemory()     // Catch:{ all -> 0x0201 }
                if (r7 <= r8) goto L_0x01e6
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
                r4.<init>()     // Catch:{ all -> 0x0201 }
                java.lang.String r5 = "CleverTap.ImageCache: insufficient memory to add image: "
                r4.append(r5)     // Catch:{ all -> 0x0201 }
                r4.append(r3)     // Catch:{ all -> 0x0201 }
                java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0201 }
                com.clevertap.android.sdk.Logger.v(r3)     // Catch:{ all -> 0x0201 }
                monitor-exit(r6)     // Catch:{ all -> 0x0201 }
            L_0x01e4:
                r5 = 0
                goto L_0x0204
            L_0x01e6:
                android.util.LruCache<java.lang.String, android.graphics.Bitmap> r7 = com.clevertap.android.sdk.utils.ImageCache.memoryCache     // Catch:{ all -> 0x0201 }
                r7.put(r3, r4)     // Catch:{ all -> 0x0201 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0201 }
                r4.<init>()     // Catch:{ all -> 0x0201 }
                java.lang.String r7 = "CleverTap.ImageCache: added image for key: "
                r4.append(r7)     // Catch:{ all -> 0x0201 }
                r4.append(r3)     // Catch:{ all -> 0x0201 }
                java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0201 }
                com.clevertap.android.sdk.Logger.v(r3)     // Catch:{ all -> 0x0201 }
                monitor-exit(r6)     // Catch:{ all -> 0x0201 }
                goto L_0x0204
            L_0x0201:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0201 }
                throw r0
            L_0x0204:
                if (r5 != 0) goto L_0x0074
                java.lang.String r3 = "Error processing image"
                r0.error = r3
                goto L_0x0074
            L_0x020c:
                java.lang.String r3 = "Image Bitmap is null"
                com.clevertap.android.sdk.Logger.d(r3)
                java.lang.String r3 = "Error processing image as bitmap was NULL"
                r0.error = r3
                goto L_0x0074
            L_0x0217:
                boolean r4 = r3.isVideo()
                if (r4 != 0) goto L_0x0223
                boolean r3 = r3.isAudio()
                if (r3 == 0) goto L_0x0074
            L_0x0223:
                boolean r3 = r0.videoSupported
                if (r3 != 0) goto L_0x0074
                java.lang.String r3 = "InApp Video/Audio is not supported"
                r0.error = r3
                goto L_0x0074
            L_0x022d:
                com.clevertap.android.sdk.inapp.CTInAppNotification$CTInAppNotificationListener r1 = r0.listener
                r1.notificationReady(r0)
            L_0x0232:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.InAppController.NotificationPrepareRunnable.run():void");
        }
    }

    public InAppController(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, MainLooperHandler mainLooperHandler2, ControllerManager controllerManager2, BaseCallbackManager baseCallbackManager, AnalyticsManager analyticsManager2, CoreMetaData coreMetaData2) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.mainLooperHandler = mainLooperHandler2;
        this.controllerManager = controllerManager2;
        this.callbackManager = baseCallbackManager;
        this.analyticsManager = analyticsManager2;
        this.coreMetaData = coreMetaData2;
        this.inAppState = InAppState.RESUMED;
    }

    public static void access$300(InAppController inAppController, Context context2) {
        if (inAppController != null) {
            SharedPreferences preferences = k.getPreferences(context2);
            try {
                if (!inAppController.canShowInAppOnActivity()) {
                    Logger.v("Not showing notification on blacklisted activity");
                } else if (inAppController.inAppState == InAppState.SUSPENDED) {
                    inAppController.logger.debug(inAppController.config.accountId, "InApp Notifications are set to be suspended, not showing the InApp Notification");
                } else {
                    checkPendingNotifications(context2, inAppController.config, inAppController);
                    JSONArray jSONArray = new JSONArray(k.getStringFromPrefs(context2, inAppController.config, "inApp", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                    if (jSONArray.length() >= 1) {
                        if (inAppController.inAppState != InAppState.DISCARDED) {
                            inAppController.prepareNotificationForDisplay(jSONArray.getJSONObject(0));
                        } else {
                            inAppController.logger.debug(inAppController.config.accountId, "InApp Notifications are set to be discarded, dropping the InApp Notification");
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            if (i != 0) {
                                jSONArray2.put(jSONArray.get(i));
                            }
                        }
                        k.persist(preferences.edit().putString(k.storageKeyWithSuffix(inAppController.config, "inApp"), jSONArray2.toString()));
                    }
                }
            } catch (Throwable th) {
                inAppController.logger.verbose(inAppController.config.accountId, "InApp: Couldn't parse JSON array string from prefs", th);
            }
        } else {
            throw null;
        }
    }

    public static void checkPendingNotifications(final Context context2, final CleverTapInstanceConfig cleverTapInstanceConfig, final InAppController inAppController) {
        Logger.v(cleverTapInstanceConfig.accountId, (String) "checking Pending Notifications");
        List<CTInAppNotification> list = pendingNotifications;
        if (list != null && !list.isEmpty()) {
            try {
                final CTInAppNotification cTInAppNotification = pendingNotifications.get(0);
                pendingNotifications.remove(0);
                new MainLooperHandler().post(new Runnable() {
                    public void run() {
                        InAppController.showInApp(context2, cTInAppNotification, cleverTapInstanceConfig);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public static void showInApp(Context context2, CTInAppNotification cTInAppNotification, CleverTapInstanceConfig cleverTapInstanceConfig) {
        Logger.v(cleverTapInstanceConfig.accountId, (String) "Attempting to show next In-App");
        if (!CoreMetaData.appForeground) {
            pendingNotifications.add(cTInAppNotification);
            Logger.v(cleverTapInstanceConfig.accountId, (String) "Not in foreground, queueing this In App");
        } else if (currentlyDisplayingInApp != null) {
            pendingNotifications.add(cTInAppNotification);
            Logger.v(cleverTapInstanceConfig.accountId, (String) "In App already displaying, queueing this In App");
        } else if (System.currentTimeMillis() / 1000 > cTInAppNotification.timeToLive) {
            Logger.d("InApp has elapsed its time to live, not showing the InApp");
        } else {
            currentlyDisplayingInApp = cTInAppNotification;
            CTInAppType cTInAppType = cTInAppNotification.inAppType;
            Fragment fragment = null;
            switch (cTInAppType.ordinal()) {
                case 1:
                case 2:
                case 5:
                case 6:
                case 7:
                case 8:
                case 11:
                case 12:
                case 13:
                case 14:
                    Intent intent = new Intent(context2, InAppNotificationActivity.class);
                    intent.putExtra("inApp", cTInAppNotification);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("config", cleverTapInstanceConfig);
                    intent.putExtra("configBundle", bundle);
                    try {
                        Activity currentActivity = CoreMetaData.getCurrentActivity();
                        if (currentActivity != null) {
                            Logger logger2 = cleverTapInstanceConfig.getLogger();
                            String str = cleverTapInstanceConfig.accountId;
                            logger2.verbose(str, "calling InAppActivity for notification: " + cTInAppNotification.jsonDescription);
                            currentActivity.startActivity(intent);
                            Logger.d("Displaying In-App: " + cTInAppNotification.jsonDescription);
                            break;
                        } else {
                            throw new IllegalStateException("Current activity reference not found");
                        }
                    } catch (Throwable th) {
                        Logger.v((String) "Please verify the integration of your app. It is not setup to support in-app notifications yet.", th);
                        break;
                    }
                case 3:
                    fragment = new CTInAppHtmlHeaderFragment();
                    break;
                case 4:
                    fragment = new CTInAppHtmlFooterFragment();
                    break;
                case 9:
                    fragment = new CTInAppNativeHeaderFragment();
                    break;
                case 10:
                    fragment = new CTInAppNativeFooterFragment();
                    break;
                default:
                    String str2 = cleverTapInstanceConfig.accountId;
                    Logger.d(str2, "Unknown InApp Type found: " + cTInAppType);
                    currentlyDisplayingInApp = null;
                    return;
            }
            if (fragment != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Displaying In-App: ");
                outline73.append(cTInAppNotification.jsonDescription);
                Logger.d(outline73.toString());
                try {
                    FragmentTransaction beginTransaction = ((FragmentActivity) CoreMetaData.getCurrentActivity()).getSupportFragmentManager().beginTransaction();
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable("inApp", cTInAppNotification);
                    bundle2.putParcelable("config", cleverTapInstanceConfig);
                    fragment.setArguments(bundle2);
                    beginTransaction.setCustomAnimations(17498112, 17498113);
                    beginTransaction.add(16908290, fragment, cTInAppNotification.type);
                    String str3 = cleverTapInstanceConfig.accountId;
                    Logger.v(str3, "calling InAppFragment " + cTInAppNotification.campaignId);
                    beginTransaction.commit();
                } catch (ClassCastException e2) {
                    String str4 = cleverTapInstanceConfig.accountId;
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Fragment not able to render, please ensure your Activity is an instance of AppCompatActivity");
                    outline732.append(e2.getMessage());
                    Logger.v(str4, outline732.toString());
                } catch (Throwable unused) {
                    int i = CleverTapAPI.debugLevel;
                    LogLevel.DEBUG.intValue();
                }
            }
        }
    }

    public final boolean canShowInAppOnActivity() {
        if (this.inappActivityExclude == null) {
            this.inappActivityExclude = new HashSet<>();
            try {
                if (ManifestInfo.getInstance(this.context) != null) {
                    String str = ManifestInfo.excludedActivitiesForInApps;
                    if (str != null) {
                        for (String trim : str.split(",")) {
                            this.inappActivityExclude.add(trim.trim());
                        }
                    }
                    Logger logger2 = this.logger;
                    String str2 = this.config.accountId;
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("In-app notifications will not be shown on ");
                    outline73.append(Arrays.toString(this.inappActivityExclude.toArray()));
                    logger2.debug(str2, outline73.toString());
                } else {
                    throw null;
                }
            } catch (Throwable unused) {
            }
        }
        Iterator<String> it = this.inappActivityExclude.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Activity currentActivity = CoreMetaData.getCurrentActivity();
            String localClassName = currentActivity != null ? currentActivity.getLocalClassName() : null;
            if (localClassName != null && localClassName.contains(next)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0086, code lost:
        if (r0.getInAppCountsFromPersistentStore(r4)[1] >= r11.totalLifetimeCount) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b9, code lost:
        if (r0.getInAppCountsFromPersistentStore(r4)[0] >= r6) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00bf, code lost:
        if (r0 != false) goto L_0x00c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071 A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e A[SYNTHETIC, Splitter:B:49:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void displayNotification(final com.clevertap.android.sdk.inapp.CTInAppNotification r11) {
        /*
            r10 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x0015
            com.clevertap.android.sdk.task.MainLooperHandler r0 = r10.mainLooperHandler
            com.clevertap.android.sdk.inapp.InAppController$4 r1 = new com.clevertap.android.sdk.inapp.InAppController$4
            r1.<init>(r11)
            r0.post(r1)
            return
        L_0x0015:
            com.clevertap.android.sdk.ControllerManager r0 = r10.controllerManager
            com.clevertap.android.sdk.InAppFCManager r0 = r0.inAppFCManager
            if (r0 == 0) goto L_0x01a6
            java.lang.String r1 = "istc_inapp"
            r2 = 1
            r3 = 0
            if (r11 != 0) goto L_0x0023
            goto L_0x00c3
        L_0x0023:
            java.lang.String r4 = r0.getInAppID(r11)     // Catch:{ all -> 0x00c3 }
            if (r4 != 0) goto L_0x002b
            goto L_0x00c1
        L_0x002b:
            boolean r4 = r11.excludeFromCaps     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x0031
            goto L_0x00c1
        L_0x0031:
            java.lang.String r4 = r0.getInAppID(r11)     // Catch:{ all -> 0x00c3 }
            if (r4 != 0) goto L_0x0038
            goto L_0x006c
        L_0x0038:
            java.util.ArrayList<java.lang.String> r5 = r0.mDismissedThisSession     // Catch:{ all -> 0x00c3 }
            boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x00c3 }
            if (r5 == 0) goto L_0x0041
            goto L_0x006e
        L_0x0041:
            int r5 = r11.maxPerSession     // Catch:{ all -> 0x006e }
            if (r5 < 0) goto L_0x0048
            int r5 = r11.maxPerSession     // Catch:{ all -> 0x006e }
            goto L_0x004a
        L_0x0048:
            r5 = 1000(0x3e8, float:1.401E-42)
        L_0x004a:
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r0.mShownThisSession     // Catch:{ all -> 0x006e }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x006e }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x006e }
            if (r4 == 0) goto L_0x005b
            int r4 = r4.intValue()     // Catch:{ all -> 0x006e }
            if (r4 < r5) goto L_0x005b
            goto L_0x006e
        L_0x005b:
            java.lang.String r4 = r0.deviceId     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = "imc"
            java.lang.String r4 = r0.getKeyWithDeviceId(r5, r4)     // Catch:{ all -> 0x00c3 }
            int r4 = r0.getIntFromPrefs(r4, r2)     // Catch:{ all -> 0x00c3 }
            int r5 = r0.mShownThisSessionCount     // Catch:{ all -> 0x00c3 }
            if (r5 < r4) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r4 = 0
            goto L_0x006f
        L_0x006e:
            r4 = 1
        L_0x006f:
            if (r4 != 0) goto L_0x00c3
            java.lang.String r4 = r0.getInAppID(r11)     // Catch:{ all -> 0x00c3 }
            r5 = -1
            if (r4 != 0) goto L_0x0079
            goto L_0x0089
        L_0x0079:
            int r6 = r11.totalLifetimeCount     // Catch:{ all -> 0x00c3 }
            if (r6 != r5) goto L_0x007e
            goto L_0x0089
        L_0x007e:
            int[] r4 = r0.getInAppCountsFromPersistentStore(r4)     // Catch:{ Exception -> 0x008b }
            r4 = r4[r2]     // Catch:{ Exception -> 0x008b }
            int r6 = r11.totalLifetimeCount     // Catch:{ Exception -> 0x008b }
            if (r4 < r6) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r4 = 0
            goto L_0x008c
        L_0x008b:
            r4 = 1
        L_0x008c:
            if (r4 != 0) goto L_0x00c3
            java.lang.String r4 = r0.getInAppID(r11)     // Catch:{ all -> 0x00c3 }
            if (r4 != 0) goto L_0x0095
            goto L_0x00bc
        L_0x0095:
            java.lang.String r6 = r0.deviceId     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = r0.getKeyWithDeviceId(r1, r6)     // Catch:{ all -> 0x00c3 }
            int r6 = r0.getIntFromPrefs(r6, r3)     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = r0.deviceId     // Catch:{ all -> 0x00c3 }
            java.lang.String r8 = "istmcd_inapp"
            java.lang.String r7 = r0.getKeyWithDeviceId(r8, r7)     // Catch:{ all -> 0x00c3 }
            int r7 = r0.getIntFromPrefs(r7, r2)     // Catch:{ all -> 0x00c3 }
            if (r6 < r7) goto L_0x00ae
            goto L_0x00be
        L_0x00ae:
            int r6 = r11.totalDailyCount     // Catch:{ all -> 0x00be }
            if (r6 != r5) goto L_0x00b3
            goto L_0x00bc
        L_0x00b3:
            int[] r0 = r0.getInAppCountsFromPersistentStore(r4)     // Catch:{ all -> 0x00be }
            r0 = r0[r3]     // Catch:{ all -> 0x00be }
            if (r0 < r6) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r0 = 0
            goto L_0x00bf
        L_0x00be:
            r0 = 1
        L_0x00bf:
            if (r0 != 0) goto L_0x00c3
        L_0x00c1:
            r0 = 1
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            if (r0 != 0) goto L_0x00e2
            com.clevertap.android.sdk.Logger r0 = r10.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r10.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "InApp has been rejected by FC, not showing "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r11 = r11.campaignId
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r0.verbose(r1, r11)
            r10.showInAppNotificationIfAny()
            return
        L_0x00e2:
            com.clevertap.android.sdk.ControllerManager r0 = r10.controllerManager
            com.clevertap.android.sdk.InAppFCManager r0 = r0.inAppFCManager
            android.content.Context r4 = r10.context
            java.lang.String r5 = r0.getInAppID(r11)
            if (r5 != 0) goto L_0x00ef
            goto L_0x0166
        L_0x00ef:
            int r6 = r0.mShownThisSessionCount
            int r6 = r6 + r2
            r0.mShownThisSessionCount = r6
            java.util.HashMap<java.lang.String, java.lang.Integer> r6 = r0.mShownThisSession
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 != 0) goto L_0x0102
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
        L_0x0102:
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r0.mShownThisSession
            int r6 = r6.intValue()
            int r6 = r6 + r2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.put(r5, r6)
            int[] r6 = r0.getInAppCountsFromPersistentStore(r5)
            r7 = r6[r3]
            int r7 = r7 + r2
            r6[r3] = r7
            r7 = r6[r2]
            int r7 = r7 + r2
            r6[r2] = r7
            android.content.Context r7 = r0.context
            java.lang.String r8 = r0.deviceId
            java.lang.String r9 = "counts_per_inapp"
            java.lang.String r8 = r0.getKeyWithDeviceId(r9, r8)
            android.content.SharedPreferences r7 = co.hyperverge.hypersnapsdk.c.k.getPreferences(r7, r8)
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = r6[r3]
            r8.append(r9)
            java.lang.String r9 = ","
            r8.append(r9)
            r6 = r6[r2]
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.putString(r5, r6)
            co.hyperverge.hypersnapsdk.c.k.persist(r7)
            java.lang.String r5 = r0.deviceId
            java.lang.String r5 = r0.getKeyWithDeviceId(r1, r5)
            int r3 = r0.getIntFromPrefs(r5, r3)
            java.lang.String r5 = r0.deviceId
            java.lang.String r1 = r0.getKeyWithDeviceId(r1, r5)
            java.lang.String r0 = r0.storageKeyWithSuffix(r1)
            int r3 = r3 + r2
            co.hyperverge.hypersnapsdk.c.k.putInt(r4, r0, r3)
        L_0x0166:
            com.clevertap.android.sdk.BaseCallbackManager r0 = r10.callbackManager
            com.clevertap.android.sdk.CallbackManager r0 = (com.clevertap.android.sdk.CallbackManager) r0
            com.clevertap.android.sdk.InAppNotificationListener r0 = r0.inAppNotificationListener
            if (r0 == 0) goto L_0x0180
            org.json.JSONObject r1 = r11.customExtras
            if (r1 == 0) goto L_0x0177
            java.util.HashMap r1 = com.clevertap.android.sdk.Utils.convertJSONObjectToHashMap(r1)
            goto L_0x017c
        L_0x0177:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L_0x017c:
            boolean r2 = r0.beforeShow(r1)
        L_0x0180:
            if (r2 != 0) goto L_0x019e
            com.clevertap.android.sdk.Logger r0 = r10.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r10.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "Application has decided to not show this in-app notification: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r11 = r11.campaignId
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r0.verbose(r1, r11)
            r10.showInAppNotificationIfAny()
            return
        L_0x019e:
            android.content.Context r0 = r10.context
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r10.config
            showInApp(r0, r11, r1)
            return
        L_0x01a6:
            com.clevertap.android.sdk.Logger r0 = r10.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r10.config
            java.lang.String r1 = r1.accountId
            java.lang.String r2 = "getCoreState().getInAppFCManager() is NULL, not showing "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r11 = r11.campaignId
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r0.verbose(r1, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.InAppController.displayNotification(com.clevertap.android.sdk.inapp.CTInAppNotification):void");
    }

    public void inAppNotificationDidClick(CTInAppNotification cTInAppNotification, Bundle bundle, HashMap<String, String> hashMap) {
        this.analyticsManager.pushInAppNotificationStateEvent(true, cTInAppNotification, bundle);
        if (hashMap != null && !hashMap.isEmpty() && this.callbackManager.getInAppNotificationButtonListener() != null) {
            this.callbackManager.getInAppNotificationButtonListener().onInAppButtonClick(hashMap);
        }
    }

    public void inAppNotificationDidDismiss(final Context context2, final CTInAppNotification cTInAppNotification, Bundle bundle) {
        HashMap<String, Object> hashMap;
        String str;
        Iterator<CTInAppNotificationMedia> it = cTInAppNotification.mediaList.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (!(next.mediaUrl == null || next.cacheKey == null)) {
                if (!next.contentType.equals("image/gif")) {
                    ImageCache.removeBitmap(next.cacheKey, false);
                    Logger.v("Deleted image - " + next.cacheKey);
                } else {
                    GifCache.removeByteArray(next.cacheKey);
                    Logger.v("Deleted GIF - " + next.cacheKey);
                }
            }
        }
        InAppFCManager inAppFCManager = this.controllerManager.inAppFCManager;
        if (inAppFCManager != null) {
            String str2 = cTInAppNotification.id;
            if (str2 != null) {
                inAppFCManager.mDismissedThisSession.add(str2.toString());
            }
            Logger logger2 = this.logger;
            String str3 = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("InApp Dismissed: ");
            outline73.append(cTInAppNotification.campaignId);
            logger2.verbose(str3, outline73.toString());
        } else {
            Logger logger3 = this.logger;
            String str4 = this.config.accountId;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Not calling InApp Dismissed: ");
            outline732.append(cTInAppNotification.campaignId);
            outline732.append(" because InAppFCManager is null");
            logger3.verbose(str4, outline732.toString());
        }
        try {
            InAppNotificationListener inAppNotificationListener = ((CallbackManager) this.callbackManager).inAppNotificationListener;
            if (inAppNotificationListener != null) {
                if (cTInAppNotification.customExtras != null) {
                    hashMap = Utils.convertJSONObjectToHashMap(cTInAppNotification.customExtras);
                } else {
                    hashMap = new HashMap<>();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Calling the in-app listener on behalf of ");
                CoreMetaData coreMetaData2 = this.coreMetaData;
                synchronized (coreMetaData2) {
                    str = coreMetaData2.source;
                }
                sb.append(str);
                Logger.v(sb.toString());
                if (bundle != null) {
                    inAppNotificationListener.onDismissed(hashMap, Utils.convertBundleObjectToHashMap(bundle));
                } else {
                    inAppNotificationListener.onDismissed(hashMap, null);
                }
            }
        } catch (Throwable th) {
            this.logger.verbose(this.config.accountId, "Failed to call the in-app notification listener", th);
        }
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask("TAG_FEATURE_IN_APPS");
        postAsyncSafelyTask.executor.execute(new Runnable("InappController#inAppNotificationDidDismiss", new Callable<Void>() {
            public Object call() throws Exception {
                Context context = context2;
                InAppController inAppController = InAppController.this;
                CleverTapInstanceConfig cleverTapInstanceConfig = inAppController.config;
                CTInAppNotification cTInAppNotification = cTInAppNotification;
                Logger.v(cleverTapInstanceConfig.accountId, (String) "Running inAppDidDismiss");
                CTInAppNotification cTInAppNotification2 = InAppController.currentlyDisplayingInApp;
                if (cTInAppNotification2 != null && cTInAppNotification2.campaignId.equals(cTInAppNotification.campaignId)) {
                    InAppController.currentlyDisplayingInApp = null;
                    InAppController.checkPendingNotifications(context, cleverTapInstanceConfig, inAppController);
                }
                InAppController.access$300(InAppController.this, context2);
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

    public void inAppNotificationDidShow(CTInAppNotification cTInAppNotification, Bundle bundle) {
        this.analyticsManager.pushInAppNotificationStateEvent(false, cTInAppNotification, bundle);
    }

    public void notificationReady(final CTInAppNotification cTInAppNotification) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainLooperHandler.post(new Runnable() {
                public void run() {
                    InAppController.this.notificationReady(cTInAppNotification);
                }
            });
        } else if (cTInAppNotification.error != null) {
            Logger logger2 = this.logger;
            String str = this.config.accountId;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to process inapp notification ");
            outline73.append(cTInAppNotification.error);
            logger2.debug(str, outline73.toString());
        } else {
            Logger logger3 = this.logger;
            String str2 = this.config.accountId;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Notification ready: ");
            outline732.append(cTInAppNotification.jsonDescription);
            logger3.debug(str2, outline732.toString());
            displayNotification(cTInAppNotification);
        }
    }

    public final void prepareNotificationForDisplay(final JSONObject jSONObject) {
        Logger logger2 = this.logger;
        String str = this.config.accountId;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Preparing In-App for display: ");
        outline73.append(jSONObject.toString());
        logger2.debug(str, outline73.toString());
        Task postAsyncSafelyTask = CTExecutorFactory.executors(this.config).postAsyncSafelyTask("TAG_FEATURE_IN_APPS");
        postAsyncSafelyTask.executor.execute(new Runnable("InappController#prepareNotificationForDisplay", new Callable<Void>() {
            public Object call() throws Exception {
                InAppController inAppController = InAppController.this;
                new NotificationPrepareRunnable(inAppController, jSONObject).run();
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

    public final void showInAppNotificationIfAny() {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (!cleverTapInstanceConfig.analyticsOnly) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask("TAG_FEATURE_IN_APPS");
            postAsyncSafelyTask.executor.execute(new Runnable("InAppController#showInAppNotificationIfAny", new Callable<Void>() {
                public Object call() throws Exception {
                    InAppController inAppController = InAppController.this;
                    InAppController.access$300(inAppController, inAppController.context);
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
    }

    public void showNotificationIfAvailable(final Context context2) {
        CleverTapInstanceConfig cleverTapInstanceConfig = this.config;
        if (!cleverTapInstanceConfig.analyticsOnly) {
            Task postAsyncSafelyTask = CTExecutorFactory.executors(cleverTapInstanceConfig).postAsyncSafelyTask("TAG_FEATURE_IN_APPS");
            postAsyncSafelyTask.executor.execute(new Runnable("InappController#showNotificationIfAvailable", new Callable<Void>() {
                public Object call() throws Exception {
                    InAppController.access$300(InAppController.this, context2);
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
    }
}
