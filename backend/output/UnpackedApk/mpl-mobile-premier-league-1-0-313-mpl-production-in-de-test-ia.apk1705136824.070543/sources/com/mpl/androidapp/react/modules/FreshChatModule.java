package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.FaqOptions.FilterType;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatCallbackStatus;
import com.freshchat.consumer.sdk.FreshchatMessage;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.freshchat.consumer.sdk.FreshchatUserInteractionListener;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.LinkHandler;
import com.freshchat.consumer.sdk.UnreadCountCallback;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.ConvertUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@ReactModule(name = "FreshChatModule")
public class FreshChatModule extends ReactContextBaseJavaModule {
    public static final String ACTION_OPEN_LINKS = "ACTION_OPEN_LINKS";
    public static final String FRESHCHAT_ACTION_USER_INTERACTION = "com.freshchat.consumer.sdk.reactnative.actions.UserInteraction";
    public static final String LOG_TAG = "FreshChatModule";
    public static final String TAG = "FreshChatModule";
    public final LinkHandler linkHandler = new LinkHandler() {
        public boolean handleLink(String str, Bundle bundle) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("url", str);
            FreshChatModule freshChatModule = FreshChatModule.this;
            freshChatModule.emitEvent(freshChatModule.getReactApplicationContext(), FreshChatModule.ACTION_OPEN_LINKS, writableNativeMap);
            return true;
        }
    };
    public final FreshchatSDKBroadcastReceiver messageCountUpdatesReceiver;
    public final FreshchatSDKBroadcastReceiver notificationClickReceiver;
    public final FreshchatSDKBroadcastReceiver restoreIdUpdatesReceiver;
    public final FreshchatSDKBroadcastReceiver userActionsReceiver;
    public final FreshchatUserInteractionListener userInteractionListener = new FreshchatUserInteractionListener() {
        public void onUserInteraction() {
            FreshChatModule freshChatModule = FreshChatModule.this;
            freshChatModule.emitEvent(freshChatModule.getReactApplicationContext(), FreshChatModule.FRESHCHAT_ACTION_USER_INTERACTION, null);
        }

        public void onUserLeaveHint() {
            FreshChatModule freshChatModule = FreshChatModule.this;
            freshChatModule.emitEvent(freshChatModule.getReactApplicationContext(), FreshChatModule.FRESHCHAT_ACTION_USER_INTERACTION, null);
        }
    };

    /* renamed from: com.mpl.androidapp.react.modules.FreshChatModule$7  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                r1 = 1
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r3 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.FreshChatModule.AnonymousClass7.<clinit>():void");
        }
    }

    public class FreshchatSDKBroadcastReceiver extends BroadcastReceiver {
        public final String eventName;
        public final ReactApplicationContext reactApplicationContext;

        public FreshchatSDKBroadcastReceiver(ReactApplicationContext reactApplicationContext2, String str) {
            this.reactApplicationContext = reactApplicationContext2;
            this.eventName = str;
        }

        public void onReceive(Context context, Intent intent) {
            MLogger.i("FreshChatModule", GeneratedOutlineSupport.outline50("Broadcast triggered: ", intent.getAction()));
            if (this.reactApplicationContext == null) {
                MLogger.e("FreshChatModule", "reactContext is null. Broadcast dropped.");
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (intent.getExtras() != null) {
                if (Freshchat.FRESHCHAT_EVENTS.equals(this.eventName)) {
                    Event eventFromBundle = Freshchat.getEventFromBundle(intent.getExtras());
                    if (eventFromBundle != null) {
                        writableNativeMap.putString("event_name", eventFromBundle.getEventName().getName());
                        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                        if (eventFromBundle.getProperties() != null && eventFromBundle.getProperties().size() > 0) {
                            for (Property next : eventFromBundle.getProperties().keySet()) {
                                writableNativeMap2.putString(next.getName(), String.valueOf(eventFromBundle.getProperties().get(next)));
                            }
                        }
                        writableNativeMap.putMap(AnalyticsConstants.PROPERTIES, writableNativeMap2);
                    }
                } else if (Freshchat.FRESHCHAT_ACTION_NOTIFICATION_INTERCEPTED.equals(this.eventName)) {
                    writableNativeMap.putString("url", intent.getExtras().getString("FRESHCHAT_DEEPLINK"));
                }
            }
            FreshChatModule.this.emitEvent(this.reactApplicationContext, this.eventName, writableNativeMap);
        }
    }

    public FreshChatModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.restoreIdUpdatesReceiver = new FreshchatSDKBroadcastReceiver(reactApplicationContext, Freshchat.FRESHCHAT_USER_RESTORE_ID_GENERATED);
        this.messageCountUpdatesReceiver = new FreshchatSDKBroadcastReceiver(reactApplicationContext, "com.freshchat.consumer.sdk.MessageCountChanged");
        this.userActionsReceiver = new FreshchatSDKBroadcastReceiver(reactApplicationContext, Freshchat.FRESHCHAT_EVENTS);
        this.notificationClickReceiver = new FreshchatSDKBroadcastReceiver(reactApplicationContext, Freshchat.FRESHCHAT_ACTION_NOTIFICATION_INTERCEPTED);
        reactApplicationContext.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostDestroy() {
                FreshChatModule.this.registerForMessageCountUpdates(false);
                FreshChatModule.this.registerForOpeningLink(false);
                FreshChatModule.this.registerForRestoreIdUpdates(false);
                FreshChatModule.this.registerForUserActions(false);
                FreshChatModule.this.registerNotificationClickListener(false);
            }

            public void onHostPause() {
            }

            public void onHostResume() {
                FreshChatModule.this.registerForMessageCountUpdates(true);
                FreshChatModule.this.registerForOpeningLink(true);
                FreshChatModule.this.registerForRestoreIdUpdates(true);
                FreshChatModule.this.registerForUserActions(true);
                FreshChatModule.this.registerNotificationClickListener(true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void emitEvent(ReactApplicationContext reactApplicationContext, String str, WritableMap writableMap) {
        if (writableMap == null) {
            writableMap = new WritableNativeMap();
        }
        MLogger.d("FreshChatModule", "emitEvent: ", str);
        ((RCTDeviceEventEmitter) reactApplicationContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    private Context getContext() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            MLogger.d("FreshChatModule", "Using Activity Context");
            return currentActivity;
        }
        MLogger.d("FreshChatModule", "Using React Application Context");
        return getReactApplicationContext();
    }

    private void postError(Promise promise, String str, String str2) {
        if (promise != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("module", str);
            writableNativeMap.putString("errorMessage", str2);
            promise.resolve(writableNativeMap);
        }
    }

    private void registerBroadcastReceiver(FreshchatSDKBroadcastReceiver freshchatSDKBroadcastReceiver, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(freshchatSDKBroadcastReceiver, intentFilter);
    }

    private void unregisterBroadcastReceiver(FreshchatSDKBroadcastReceiver freshchatSDKBroadcastReceiver) {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(freshchatSDKBroadcastReceiver);
    }

    @ReactMethod
    public void dismissFreshchatViews() {
        LocalBroadcastManager.getInstance(getContext().getApplicationContext()).sendBroadcast(new Intent("com.freshchat.consumer.sdk.actions.DismissFreshchatScreens"));
    }

    @ReactMethod
    public void getFreshchatUserId(Promise promise) {
        promise.resolve(Freshchat.getInstance(getContext()).getFreshchatUserId());
    }

    public String getName() {
        return "FreshChatModule";
    }

    @ReactMethod
    public void getSDKVersionCode(Promise promise) {
        promise.resolve(Integer.valueOf(Freshchat.getSDKVersionCode()));
    }

    @ReactMethod
    public void getUnreadCountAsync(final Promise promise) {
        Freshchat.getInstance(getContext()).getUnreadCountAsync(new UnreadCountCallback() {
            public void onResult(FreshchatCallbackStatus freshchatCallbackStatus, int i) {
                boolean z = freshchatCallbackStatus == FreshchatCallbackStatus.STATUS_SUCCESS;
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putBoolean("status", z);
                writableNativeMap.putInt("count", i);
                promise.resolve(writableNativeMap);
            }
        });
    }

    @ReactMethod
    public void getUnreadCountAsyncForTags(ReadableMap readableMap, final Promise promise) {
        ArrayList arrayList = new ArrayList();
        if (readableMap != null && readableMap.toHashMap().size() > 0) {
            readableMap.toHashMap();
            if (readableMap.hasKey("tags")) {
                ReadableArray array = readableMap.getArray("tags");
                if (array != null) {
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                }
            }
        }
        Freshchat.getInstance(getContext()).getUnreadCountAsync(new UnreadCountCallback() {
            public void onResult(FreshchatCallbackStatus freshchatCallbackStatus, int i) {
                boolean z = freshchatCallbackStatus == FreshchatCallbackStatus.STATUS_SUCCESS;
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putBoolean("status", z);
                writableNativeMap.putInt("count", i);
                promise.resolve(writableNativeMap);
            }
        }, arrayList);
    }

    @ReactMethod
    public void getUser(Promise promise) {
        FreshchatUser user = Freshchat.getInstance(getContext()).getUser();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (user != null) {
            writableNativeMap.putString("email", user.getEmail());
            writableNativeMap.putString("firstName", user.getFirstName());
            writableNativeMap.putString("lastName", user.getLastName());
            writableNativeMap.putString("phone", user.getPhone());
            writableNativeMap.putString("phoneCountryCode", user.getPhoneCountryCode());
            writableNativeMap.putString("externalId", user.getExternalId());
            writableNativeMap.putString("restoreId", user.getRestoreId());
        }
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void getUserIdTokenStatus(Promise promise) {
        JwtTokenStatus userIdTokenStatus = Freshchat.getInstance(getContext()).getUserIdTokenStatus();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("user_id_token_status", userIdTokenStatus.name());
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    public void handlePushNotification(ReadableMap readableMap) {
        if (readableMap == null || readableMap.toHashMap().size() == 0) {
            MLogger.e("FreshChatModule", "Please provide values to handlePushNotification");
            return;
        }
        readableMap.toHashMap();
        Freshchat.handleFcmMessage(getContext(), jsonToBundle(readableMap));
    }

    @ReactMethod
    public void identifyUser(String str, String str2, Promise promise) {
        try {
            Freshchat.getInstance(getContext()).identifyUser(str, str2);
        } catch (Exception e2) {
            String exc = e2.toString();
            MLogger.e("FreshChatModule", exc);
            postError(promise, "identifyUser", exc);
        }
    }

    @ReactMethod
    public void initUser(ReadableMap readableMap) {
        if (readableMap != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("userId", readableMap.getInt("userId"));
            bundle.putString("displayName", readableMap.getString("displayName"));
            MPLReactContainerActivity.resultReceiver.send(22, bundle);
        }
    }

    @ReactMethod
    public void isFreshchatNotification(ReadableMap readableMap, Promise promise) {
        int size = readableMap.toHashMap().size();
        Integer valueOf = Integer.valueOf(0);
        if (size == 0) {
            promise.resolve(valueOf);
        } else if (Freshchat.isFreshchatNotification(jsonToBundle(readableMap))) {
            promise.resolve(Integer.valueOf(1));
        } else {
            promise.resolve(valueOf);
        }
    }

    public Bundle jsonToBundle(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (readableMap.toHashMap().size() == 0) {
            return bundle;
        }
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                int ordinal = readableMap.getType(nextKey).ordinal();
                if (ordinal == 0) {
                    bundle.putString(nextKey, null);
                } else if (ordinal == 1) {
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                } else if (ordinal == 2) {
                    bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                } else if (ordinal != 3) {
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                } else {
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                }
            } catch (Exception e2) {
                MLogger.w("FreshChatModule", e2.toString());
            }
        }
        return bundle;
    }

    @ReactMethod
    public void openFaqByTag(String str) {
        FaqOptions showContactUsOnFaqNotHelpful = new FaqOptions().showFaqCategoriesAsGrid(false).showContactUsOnAppBar(false).showContactUsOnFaqScreens(false).showContactUsOnFaqNotHelpful(false);
        showContactUsOnFaqNotHelpful.filterByTags(Collections.singletonList(str), "", FilterType.ARTICLE);
        Freshchat.showFAQs(getContext(), showContactUsOnFaqNotHelpful);
    }

    @ReactMethod
    public void openFreshchatDeeplink(String str) {
        MLogger.i("FreshChatModule", GeneratedOutlineSupport.outline50("openFreshchatDeeplink: ", str));
        if (getContext() instanceof Activity) {
            MLogger.i("FreshChatModule", "openFreshchatDeeplink: React: Activity Context");
        } else {
            MLogger.i("FreshChatModule", "openFreshchatDeeplink: React: Application Context");
        }
        Freshchat.openFreshchatDeeplink(getContext(), str);
    }

    @ReactMethod
    public void registerForMessageCountUpdates(boolean z) {
        MLogger.i("FreshChatModule", "enableRegisterForMessageCountUpdates: " + z);
        if (z) {
            registerBroadcastReceiver(this.messageCountUpdatesReceiver, "com.freshchat.consumer.sdk.MessageCountChanged");
        } else {
            unregisterBroadcastReceiver(this.messageCountUpdatesReceiver);
        }
    }

    @ReactMethod
    public void registerForOpeningLink(boolean z) {
        MLogger.i("FreshChatModule", "registerForOpeningLink: " + z);
        if (z) {
            Freshchat.getInstance(getContext()).setCustomLinkHandler(this.linkHandler);
        } else {
            Freshchat.getInstance(getContext()).setCustomLinkHandler(null);
        }
    }

    @ReactMethod
    public void registerForRestoreIdUpdates(boolean z) {
        MLogger.i("FreshChatModule", "enableRegisterForRestoreIdUpdates: " + z);
        if (z) {
            registerBroadcastReceiver(this.restoreIdUpdatesReceiver, Freshchat.FRESHCHAT_USER_RESTORE_ID_GENERATED);
        } else {
            unregisterBroadcastReceiver(this.restoreIdUpdatesReceiver);
        }
    }

    @ReactMethod
    public void registerForUserActions(boolean z) {
        MLogger.i("FreshChatModule", "registerForUserActions: " + z);
        if (z) {
            registerBroadcastReceiver(this.userActionsReceiver, Freshchat.FRESHCHAT_EVENTS);
        } else {
            unregisterBroadcastReceiver(this.userActionsReceiver);
        }
    }

    @ReactMethod
    public void registerNotificationClickListener(boolean z) {
        MLogger.i("FreshChatModule", "registerNotificationClickListener: " + z);
        if (z) {
            registerBroadcastReceiver(this.notificationClickReceiver, Freshchat.FRESHCHAT_ACTION_NOTIFICATION_INTERCEPTED);
        } else {
            unregisterBroadcastReceiver(this.notificationClickReceiver);
        }
    }

    @ReactMethod
    public void registerUserInteractionListerner(boolean z) {
        MLogger.i("FreshChatModule", "registerUserInteractionListerner: " + z);
        if (z) {
            Freshchat.getInstance(getContext()).setFreshchatUserInteractionListener(this.userInteractionListener);
        } else {
            Freshchat.getInstance(getContext()).setFreshchatUserInteractionListener(null);
        }
    }

    @ReactMethod
    public void resetUser() {
        Freshchat.resetUser(getContext());
    }

    @ReactMethod
    public void restoreUser(String str, Promise promise) {
        try {
            Freshchat.getInstance(getContext()).restoreUser(str);
        } catch (Exception e2) {
            postError(promise, "setUserWithIdToken", e2.toString());
        }
    }

    @ReactMethod
    public void sendMessage(ReadableMap readableMap) {
        if (readableMap != null) {
            FreshchatMessage freshchatMessage = new FreshchatMessage();
            if ("ID".equalsIgnoreCase(MBuildConfigUtils.getCountryCode())) {
                freshchatMessage.setTag("indonesia").setMessage(readableMap.getString("message"));
            } else {
                freshchatMessage.setTag(readableMap.getString(InlineAnimation.TAG)).setMessage(readableMap.getString("message"));
            }
            Freshchat.sendMessage(getContext(), freshchatMessage);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.mpl.androidapp.utils.MLogger.i("FreshChatModule", "smallIcon parsing failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.mpl.androidapp.utils.MLogger.i("FreshChatModule", "largeIcon parsing failed");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0049 */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNotificationConfig(com.facebook.react.bridge.ReadableMap r13) {
        /*
            r12 = this;
            java.lang.String r0 = "overrideNotificationClickListener"
            java.lang.String r1 = "priority"
            java.lang.String r2 = "activityToLaunchOnFinish"
            java.lang.String r3 = "drawable"
            java.lang.String r4 = "largeIcon"
            java.lang.String r5 = "smallIcon"
            java.lang.String r6 = "notificationSoundEnabled"
            java.lang.String r7 = "FreshChatModule"
            r8 = 0
            r9 = 1
            r13.toHashMap()     // Catch:{ Exception -> 0x00b0 }
            com.freshchat.consumer.sdk.FreshchatNotificationConfig r10 = new com.freshchat.consumer.sdk.FreshchatNotificationConfig     // Catch:{ Exception -> 0x00b0 }
            r10.<init>()     // Catch:{ Exception -> 0x00b0 }
            boolean r11 = r13.hasKey(r6)     // Catch:{ Exception -> 0x00b0 }
            if (r11 == 0) goto L_0x0027
            boolean r6 = r13.getBoolean(r6)     // Catch:{ Exception -> 0x00b0 }
            r10.setNotificationSoundEnabled(r6)     // Catch:{ Exception -> 0x00b0 }
        L_0x0027:
            boolean r6 = r13.hasKey(r5)     // Catch:{ Exception -> 0x0049 }
            if (r6 == 0) goto L_0x0052
            java.lang.String r5 = r13.getString(r5)     // Catch:{ Exception -> 0x0049 }
            android.content.Context r6 = r12.getContext()     // Catch:{ Exception -> 0x0049 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0049 }
            android.content.Context r11 = r12.getContext()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ Exception -> 0x0049 }
            int r5 = r6.getIdentifier(r5, r3, r11)     // Catch:{ Exception -> 0x0049 }
            r10.setSmallIcon(r5)     // Catch:{ Exception -> 0x0049 }
            goto L_0x0052
        L_0x0049:
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r6 = "smallIcon parsing failed"
            r5[r8] = r6     // Catch:{ Exception -> 0x00b0 }
            com.mpl.androidapp.utils.MLogger.i(r7, r5)     // Catch:{ Exception -> 0x00b0 }
        L_0x0052:
            boolean r5 = r13.hasKey(r4)     // Catch:{ Exception -> 0x0074 }
            if (r5 == 0) goto L_0x007d
            java.lang.String r4 = r13.getString(r4)     // Catch:{ Exception -> 0x0074 }
            android.content.Context r5 = r12.getContext()     // Catch:{ Exception -> 0x0074 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0074 }
            android.content.Context r6 = r12.getContext()     // Catch:{ Exception -> 0x0074 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0074 }
            int r3 = r5.getIdentifier(r4, r3, r6)     // Catch:{ Exception -> 0x0074 }
            r10.setLargeIcon(r3)     // Catch:{ Exception -> 0x0074 }
            goto L_0x007d
        L_0x0074:
            java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r4 = "largeIcon parsing failed"
            r3[r8] = r4     // Catch:{ Exception -> 0x00b0 }
            com.mpl.androidapp.utils.MLogger.i(r7, r3)     // Catch:{ Exception -> 0x00b0 }
        L_0x007d:
            boolean r3 = r13.hasKey(r2)     // Catch:{ Exception -> 0x00b0 }
            if (r3 == 0) goto L_0x008a
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00b0 }
            r10.launchActivityOnFinish(r2)     // Catch:{ Exception -> 0x00b0 }
        L_0x008a:
            boolean r2 = r13.hasKey(r1)     // Catch:{ Exception -> 0x00b0 }
            if (r2 == 0) goto L_0x0097
            int r1 = r13.getInt(r1)     // Catch:{ Exception -> 0x00b0 }
            r10.setPriority(r1)     // Catch:{ Exception -> 0x00b0 }
        L_0x0097:
            boolean r1 = r13.hasKey(r0)     // Catch:{ Exception -> 0x00b0 }
            if (r1 == 0) goto L_0x00a4
            boolean r13 = r13.getBoolean(r0)     // Catch:{ Exception -> 0x00b0 }
            r10.setNotificationInterceptionEnabled(r13)     // Catch:{ Exception -> 0x00b0 }
        L_0x00a4:
            android.content.Context r13 = r12.getContext()     // Catch:{ Exception -> 0x00b0 }
            com.freshchat.consumer.sdk.Freshchat r13 = com.freshchat.consumer.sdk.Freshchat.getInstance(r13)     // Catch:{ Exception -> 0x00b0 }
            r13.setNotificationConfig(r10)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00c9
        L_0x00b0:
            r13 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.String r1 = "setNotificationConfig error: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r13 = r13.toString()
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0[r8] = r13
            com.mpl.androidapp.utils.MLogger.e(r7, r0)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.FreshChatModule.setNotificationConfig(com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void setPushRegistrationToken(String str) {
        Freshchat.getInstance(getContext()).setPushRegistrationToken(str);
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap, Promise promise) {
        if (readableMap == null || readableMap.toHashMap().size() == 0) {
            MLogger.e("FreshChatModule", "Please provide parameters to setUser");
            return;
        }
        try {
            FreshchatUser user = Freshchat.getInstance(getContext()).getUser();
            user.setFirstName(readableMap.getString("firstName"));
            user.setLastName(readableMap.getString("lastName"));
            user.setEmail(readableMap.getString("email"));
            user.setPhone(readableMap.getString("phoneCountryCode"), readableMap.getString("phone"));
            Freshchat.getInstance(getContext()).setUser(user);
        } catch (Exception e2) {
            String exc = e2.toString();
            MLogger.e("FreshChatModule", exc);
            postError(promise, "setUser", exc);
        }
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap, Promise promise) {
        MLogger.d("FreshChatModule", "setUserProperties: ", readableMap);
        if (readableMap == null) {
            MLogger.e("FreshChatModule", "Please provide user properties to update the user");
            return;
        }
        try {
            HashMap<String, Object> jsonToMap = Util.jsonToMap(ConvertUtils.convertMapToJson(readableMap));
            HashMap hashMap = new HashMap();
            for (String next : jsonToMap.keySet()) {
                hashMap.put(next, String.valueOf(jsonToMap.get(next)));
            }
            Freshchat.getInstance(getContext()).setUserProperties(hashMap);
            if (promise != null) {
                promise.resolve("ok");
            }
        } catch (Exception e2) {
            String exc = e2.toString();
            MLogger.e("FreshChatModule", exc);
            postError(promise, "setUserProperties", exc);
        }
    }

    @ReactMethod
    public void setUserWithIdToken(String str, Promise promise) {
        try {
            Freshchat.getInstance(getContext()).setUser(str);
        } catch (Exception e2) {
            postError(promise, "setUserWithIdToken", e2.toString());
        }
    }

    @ReactMethod
    public void showConversations() {
        MLogger.d("FreshChatModule", "showConversations: ");
        Freshchat.showConversations(getContext());
    }

    @ReactMethod
    public void showConversationsWithOptions(final ReadableMap readableMap) {
        String str;
        MLogger.d("FreshChatModule", "showConversationsWithOptions: ", readableMap, MBuildConfigUtils.getCountryCode());
        ConversationOptions conversationOptions = new ConversationOptions();
        ArrayList arrayList = new ArrayList();
        if (readableMap.hasKey("tags")) {
            ReadableArray array = readableMap.getArray("tags");
            if (array != null) {
                for (int i = 0; i < array.size(); i++) {
                    arrayList.add(array.getString(i));
                }
            }
            conversationOptions.filterByTags(arrayList, readableMap.getString("filteredViewTitle"));
        } else if (readableMap.hasKey(InlineAnimation.TAG)) {
            if ("ID".equalsIgnoreCase(MBuildConfigUtils.getCountryCode())) {
                str = "indonesia";
            } else {
                str = readableMap.getString(InlineAnimation.TAG);
            }
            conversationOptions.filterByTags(Collections.singletonList(str), readableMap.getString("filteredViewTitle"));
        }
        Freshchat.showConversations(getContext(), conversationOptions);
        if (MSharedPreferencesUtils.getBooleanInNormalPref(getContext(), "first_chat_launch", true)) {
            MLogger.d("FreshChatModule", "first_chat_launch");
            MSharedPreferencesUtils.saveBooleanInNormalPref(getContext(), "first_chat_launch", false);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (readableMap.hasKey("message")) {
                        FreshChatModule.this.sendMessage(readableMap);
                    }
                }
            }, 1000);
        } else if (readableMap.hasKey("message")) {
            sendMessage(readableMap);
        }
    }

    @ReactMethod
    public void showFAQs() {
        MLogger.d("FreshChatModule", "showFAQs: ");
        if (getCurrentActivity() != null) {
            FaqOptions showContactUsOnFaqNotHelpful = new FaqOptions().showFaqCategoriesAsGrid(false).showContactUsOnAppBar(false).showContactUsOnFaqScreens(false).showContactUsOnFaqNotHelpful(false);
            if ("ID".equalsIgnoreCase(MBuildConfigUtils.getCountryCode())) {
                showContactUsOnFaqNotHelpful.filterByTags(Collections.singletonList("indo"), "", FilterType.CATEGORY);
            }
            if ("IN".equalsIgnoreCase(MBuildConfigUtils.getCountryCode())) {
                showContactUsOnFaqNotHelpful.filterByTags(Collections.singletonList("india"), "", FilterType.CATEGORY);
            }
            Freshchat.showFAQs(getCurrentActivity(), showContactUsOnFaqNotHelpful);
        }
    }

    @ReactMethod
    public void showFAQsWithOptions(ReadableMap readableMap) {
        try {
            MLogger.d("FreshChatModule", "showFAQsWithOptions: ");
            if (readableMap != null) {
                FaqOptions faqOptions = new FaqOptions();
                if (readableMap.hasKey("showFaqCategoriesAsGrid")) {
                    faqOptions.showFaqCategoriesAsGrid(readableMap.getBoolean("showFaqCategoriesAsGrid"));
                }
                if (readableMap.hasKey("showContactUsOnAppBar")) {
                    faqOptions.showContactUsOnAppBar(readableMap.getBoolean("showContactUsOnAppBar"));
                }
                if (readableMap.hasKey("showContactUsOnFaqScreens")) {
                    faqOptions.showContactUsOnFaqScreens(readableMap.getBoolean("showContactUsOnFaqScreens"));
                }
                if (readableMap.hasKey("showContactUsOnFaqNotHelpful")) {
                    faqOptions.showContactUsOnFaqNotHelpful(readableMap.getBoolean("showContactUsOnFaqNotHelpful"));
                }
                ArrayList arrayList = new ArrayList();
                if (readableMap.hasKey("tags")) {
                    ReadableArray array = readableMap.getArray("tags");
                    if (array != null) {
                        for (int i = 0; i < array.size(); i++) {
                            arrayList.add(array.getString(i));
                        }
                        String string = readableMap.getString("filteredViewTitle");
                        if ("category".equals(readableMap.getString("filterType"))) {
                            faqOptions.filterByTags(arrayList, string, FilterType.CATEGORY);
                        } else {
                            faqOptions.filterByTags(arrayList, string, FilterType.ARTICLE);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                if (readableMap.hasKey("contactusFilterTags")) {
                    ReadableArray array2 = readableMap.getArray("contactusFilterTags");
                    if (array2 != null) {
                        for (int i2 = 0; i2 < array2.size(); i2++) {
                            arrayList2.add(array2.getString(i2));
                        }
                        faqOptions.filterContactUsByTags(arrayList2, readableMap.getString("contactusFilterTitle"));
                    }
                }
                Freshchat.showFAQs(getContext(), faqOptions);
            }
        } catch (Exception e2) {
            MLogger.e("FreshChatModule", e2.toString());
        }
    }

    @ReactMethod
    public void trackEvent(String str, ReadableMap readableMap) {
        HashMap<String, Object> hashMap;
        try {
            hashMap = readableMap.toHashMap();
            if (hashMap == null) {
            }
        } catch (Exception e2) {
            MLogger.e("FreshChatModule", e2.toString());
        } finally {
            new HashMap();
        }
        Freshchat.trackEvent(getContext(), str, hashMap);
    }
}
