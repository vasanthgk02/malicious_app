package com.mpl.androidapp.react;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat.CarExtender;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.clevertap.android.sdk.CleverTapAPI;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.CallbackManager;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.PermissionListener;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatNotificationConfig;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.inca.security.AppGuard.AppGuardClient;
import com.mpl.analytics.kafka.Callback;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.backgroundmanager.NotificationWorker;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.states.ReactContainerState;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.domain.states.ReactContainerState.ERROR;
import com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.database.DatabaseClient;
import com.mpl.androidapp.database.entity.Contact;
import com.mpl.androidapp.databinding.ActivityReactContainerBinding;
import com.mpl.androidapp.databinding.SplashScreenBinding;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.game.ApkInfo;
import com.mpl.androidapp.game.disconnection.GameDisconnection;
import com.mpl.androidapp.imagepicker.ImagePickerModule;
import com.mpl.androidapp.notification.ApkDownloadNotificationData;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.okhttp3.MemoryLruCache;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.react.modules.SharedPrefModule;
import com.mpl.androidapp.responsiblegaming.RgSessionManager;
import com.mpl.androidapp.responsiblegaming.RgWarningListener;
import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.ui.NonSealedApkFragment;
import com.mpl.androidapp.ui.ReferralNudgeApkFragment;
import com.mpl.androidapp.unity.reactNavigation.UnityReactNavigation;
import com.mpl.androidapp.unity.reactNavigation.UnityReactNavigationImpl;
import com.mpl.androidapp.updater.AppInitialization;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.job.JobSchedulerHelper;
import com.mpl.androidapp.updater.repo.AppUpdater;
import com.mpl.androidapp.updater.repo.AppUpdater.AppBinder;
import com.mpl.androidapp.updater.repo.BundleUpdater;
import com.mpl.androidapp.updater.repo.BundleUpdater.BundleBinder;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.util.ServiceUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import com.mpl.androidapp.updater.util.UpdaterConstant.Event;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.AppsflyerUtils;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ActivityConstant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.DialogData;
import com.mpl.androidapp.utils.DialogData.TYPE;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.IPAddressConversion;
import com.mpl.androidapp.utils.KafkaUtils;
import com.mpl.androidapp.utils.LocaleHelper;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MPLAuthTokenProvider;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.MessageEvent;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkMonitorUtil.NetworkStateChange;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.OriginalGameConstant;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.utils.VideoRecordingUtils;
import com.mpl.androidapp.worker.StoriesCleanUpWorker;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.payment.braintree.BraintreeConstants;
import com.mpl.payment.common.AuthTokenProvider;
import com.mpl.payment.juspayhypersdk.HyperServiceWrapper;
import com.mpl.payment.juspayhypersdk.JuspayHyperPaymentConstants;
import com.mpl.payment.juspayhypersdk.customer.FetchCustomerIdUseCase;
import com.mpl.securepreferences.MPreferences;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.SMTEventParamKeys;
import com.netcore.android.notification.SMTNotificationConstants;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.razorpay.AnalyticsConstants;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import in.juspay.hypersdk.core.PaymentConstants.ENVIRONMENT;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.hanselsdk.Hansel;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionLaunch;
import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MPLReactContainerActivity extends Hilt_MPLReactContainerActivity implements MPLReactContainerInterface, UnityReactNavigation, NetworkStateChange {
    public static final String ACTION = "action";
    public static final String ACTION_BANNED_APP = "com.mpl.androidapp.deviceinfo.action.BANNED_APP";
    public static final String ACTION_GAME_COMPETITOR_APP = "com.mpl.androidapp.deviceinfo.action.GAME_COMPETITOR_APP";
    public static final String ACTION_GAME_TEMPERED_APP = "com.mpl.androidapp.deviceinfo.action.GAME_TEMPERED_APP";
    public static final String ACTION_GOOGLE_ID = "com.mpl.androidapp.deviceinfo.action.GOOGLE_ID";
    public static final String ACTION_ID = "actionId";
    public static final String ACTION_PARAMS = "actionParams";
    public static final String MPL_SIGNUP_OFFER = "MPLSignupOffer";
    public static final String MQTT_TAG = "Mqtt:";
    public static final String OPEN_DEEP_LINK = "OPEN_DEEP_LINK";
    public static final String SIGNUP_OFFER = "Signup_offer";
    public static final String TAG = "MPLReactContainerActivity";
    public static final String TAG_INTEGRITY = "IntegrityCheck";
    public static final String TAG_RES = "ResponsibleGamingTimer";
    public static boolean activityStarted;
    public static DownloadProgressReceiver resultReceiver;
    public String actionId = null;
    public AlertDialog alertDialog;
    public final AuthTokenProvider authTokenProvider = new MPLAuthTokenProvider();
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String restoreId = Freshchat.getInstance(MPLReactContainerActivity.this.getApplicationContext()).getUser().getRestoreId();
            MSharedPreferencesUtils.saveStringInNormalPref(MPLReactContainerActivity.this.getApplicationContext(), "freshChatRestoreId", restoreId);
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:3 FreshChat ", restoreId);
        }
    };
    public StatusType buttonStatus;
    public HashMap<String, Object> conversionDataAppsflyer = new HashMap<>();
    public final AppsFlyerConversionListener conversionDataListener = new AppsFlyerConversionListener() {
        public void onAppOpenAttribution(Map<String, String> map) {
            if (MSharedPreferencesUtils.getUserIdInNormalPrefV2(MPLReactContainerActivity.this.getApplicationContext()) != 0) {
                map.put("is_new_user", BaseParser.FALSE);
                map.put("signup_offer_provided", BaseParser.FALSE);
                CleverTapAnalyticsUtils.sendEvent((String) "Attribution Detected Post Login", map);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("onAppOpenAttribution: ", next, " = ");
                    outline80.append(map.get(next));
                    MLogger.d(MPLReactContainerActivity.TAG, outline80.toString());
                }
                if (map.containsKey("MPLReferralCode") && !TextUtils.isEmpty(String.valueOf(map.get("MPLReferralCode"))) && !"null".equalsIgnoreCase(String.valueOf(map.get("MPLReferralCode"))) && MSharedPreferencesUtils.getUserIdInNormalPref(MPLApplication.getInstance()) == 0) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending referral code to react 2");
                    if (!(MPLReactContainerActivity.this.mReactInstanceManager == null || MPLReactContainerActivity.this.mReactContext == null)) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("referral_code", map.get("MPLReferralCode"));
                    }
                    MSharedPreferencesUtils.putAFReferralData(new JSONObject(map));
                    MSharedPreferencesUtils.putAFReferralCode(String.valueOf(map.get("MPLReferralCode")));
                    MSharedPreferencesUtils.setAFReferralSource(String.valueOf(map.get(AFInAppEventParameterName.AF_CHANNEL)));
                }
                if (!map.containsKey("isDeepLinkRequired") || map.get("isDeepLinkRequired") == null || !Boolean.parseBoolean(String.valueOf(map.get("isDeepLinkRequired")))) {
                    if (map.containsKey("notification_data") && map.get("notification_data") != null) {
                        MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 4 ", String.valueOf(map.get("notification_data")));
                        MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("notification_data")));
                        MSharedPreferencesUtils.setAppsflyerredirectiondata(MPLReactContainerActivity.this.mNotificationData);
                    }
                } else if (map.containsKey("deepLinkPayLoad")) {
                    MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 3 ", map.get("deepLinkPayLoad"));
                    MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("deepLinkPayLoad")));
                    MSharedPreferencesUtils.saveDeepLinkForInstall(String.valueOf(map.get("deepLinkPayLoad")));
                } else if (map.containsKey("redirect") || map.containsKey("route")) {
                    MPLReactContainerActivity.this.getCreateDeepLinkData(map);
                } else if (map.containsKey("notification_data") && map.get("notification_data") != null) {
                    MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 4 ", String.valueOf(map.get("notification_data")));
                    MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("notification_data")));
                    MSharedPreferencesUtils.setAppsflyerredirectiondata(MPLReactContainerActivity.this.mNotificationData);
                }
                if (!map.containsKey("shouldSkipFTUE") || map.get("shouldSkipFTUE") == null || !Boolean.parseBoolean(map.get("shouldSkipFTUE"))) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onAppOpenAttribution:shouldSkipFTUE is false ");
                } else {
                    MSharedPreferencesUtils.saveBooleanInNormalPref(MPLReactContainerActivity.this, "shouldSkipFTUE", Boolean.parseBoolean(map.get("shouldSkipFTUE")));
                }
                if (map.containsKey("channel_url") && map.get("channel_url") != null && !TextUtils.isEmpty(String.valueOf(map.get("channel_url")))) {
                    MSharedPreferencesUtils.saveStringInNormalPref(MPLReactContainerActivity.this, "groupFtueUrl", String.valueOf(map.get("channel_url")));
                }
                if (map.containsKey("Entry Point") && map.get("Entry Point") != null && !TextUtils.isEmpty(String.valueOf(map.get("Entry Point")))) {
                    MSharedPreferencesUtils.saveStringInNormalPref(MPLApplication.getInstance(), Constant.APPS_FLYER_ENTRY_POINT, String.valueOf(map.get("Entry Point")));
                }
            }
        }

        public void onAttributionFailure(String str) {
            MLogger.d(MPLReactContainerActivity.TAG, "onAttributionFailure error getting conversion data: ", str);
        }

        public void onConversionDataFail(String str) {
            MLogger.d(MPLReactContainerActivity.TAG, GeneratedOutlineSupport.outline52("onConversionDataFail() called with: s = [", str, CMapParser.MARK_END_OF_ARRAY));
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(EventsConstants.FAIL_REASON, str);
            }
            CleverTapAnalyticsUtils.sendEvent((String) "AppsFlyer Conversion Failed", hashMap);
        }

        public void onConversionDataSuccess(Map<String, Object> map) {
            Class cls = RCTDeviceEventEmitter.class;
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap hashMap2 = new HashMap();
            if (map != null) {
                if (map.containsKey("MPLReferralCode") && !TextUtils.isEmpty(String.valueOf(map.get("MPLReferralCode"))) && !"null".equalsIgnoreCase(String.valueOf(map.get("MPLReferralCode")))) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending referral code to react 1");
                    if (MPLReactContainerActivity.this.mReactContext != null && MPLReactContainerActivity.this.mReactContext.getJSModule(cls) != null) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(cls)).emit("referral_code", map.get("MPLReferralCode"));
                        MPLReactContainerActivity.this.isReferralCodeEmitDone = true;
                        MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending referral code 1");
                    } else if (MPLReactContainerActivity.this.reactEmitter != null) {
                        MPLReactContainerActivity.this.reactEmitter.emit("referral_code", map.get("MPLReferralCode"));
                        MPLReactContainerActivity.this.isReferralCodeEmitDone = true;
                        MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending referral code 2");
                    }
                    MSharedPreferencesUtils.putAFReferralCode(String.valueOf(map.get("MPLReferralCode")));
                    MSharedPreferencesUtils.setAFReferralSource(String.valueOf(map.get(AFInAppEventParameterName.AF_CHANNEL)));
                    if (MSharedPreferencesUtils.getUserIdInNormalPref(MPLReactContainerActivity.this) != 0) {
                        CleverTapAnalyticsUtils.sendEvent("AppsFlyer Referral Code Delayed");
                    }
                }
                if (!map.containsKey(MPLReactContainerActivity.MPL_SIGNUP_OFFER) || TextUtils.isEmpty(String.valueOf(map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER))) || "null".equalsIgnoreCase(String.valueOf(map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER)))) {
                    hashMap.put("signup_offer_provided", BaseParser.FALSE);
                } else {
                    Object[] objArr = new Object[7];
                    objArr[0] = "onConversionDataSuccess: Sending signup offer to react 1";
                    objArr[1] = "React Manager:";
                    objArr[2] = Boolean.valueOf(MPLReactContainerActivity.this.mReactInstanceManager == null);
                    objArr[3] = "React Context:";
                    objArr[4] = Boolean.valueOf(MPLReactContainerActivity.this.mReactContext == null);
                    objArr[5] = "React Emitter:";
                    objArr[6] = Boolean.valueOf(MPLReactContainerActivity.this.reactEmitter == null);
                    MLogger.d(MPLReactContainerActivity.TAG, objArr);
                    if (MPLReactContainerActivity.this.mReactContext != null && MPLReactContainerActivity.this.mReactContext.getJSModule(cls) != null) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(cls)).emit(MPLReactContainerActivity.SIGNUP_OFFER, map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER));
                        hashMap.put("signup_offer_provided", BaseParser.TRUE);
                        hashMap.put("signup_offer", map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER));
                        MPLReactContainerActivity.this.isSignupCodeEmitDone = true;
                        MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending signup code 1");
                    } else if (MPLReactContainerActivity.this.reactEmitter != null) {
                        MPLReactContainerActivity.this.reactEmitter.emit(MPLReactContainerActivity.SIGNUP_OFFER, map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER));
                        MPLReactContainerActivity.this.isSignupCodeEmitDone = true;
                        MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: Sending signup code 2");
                    }
                    MSharedPreferencesUtils.putAFSignupCode(String.valueOf(map.get(MPLReactContainerActivity.MPL_SIGNUP_OFFER)));
                }
                for (String next : map.keySet()) {
                    StringBuilder outline80 = GeneratedOutlineSupport.outline80("onConversionDataSuccess: ", next, " = ");
                    outline80.append(map.get(next));
                    MLogger.d(MPLReactContainerActivity.TAG, outline80.toString());
                    if (map.get(next) != null) {
                        hashMap.put(next, map.get(next));
                        hashMap2.put(next, String.valueOf(map.get(next)));
                    }
                }
                if (map.containsKey(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH) && map.get(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH) != null && (map.get(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH) instanceof Boolean) && Boolean.parseBoolean(String.valueOf(map.get(SMTPreferenceConstants.SMT_IS_FIRST_LAUNCH)))) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onConversionDataSuccess: This first launch");
                    if (!map.containsKey("isDeepLinkRequired") || map.get("isDeepLinkRequired") == null || !Boolean.parseBoolean(String.valueOf(map.get("isDeepLinkRequired")))) {
                        if (map.containsKey("notification_data") && map.get("notification_data") != null) {
                            MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 2 ", String.valueOf(map.get("notification_data")));
                            MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("notification_data")));
                            MSharedPreferencesUtils.setAppsflyerredirectiondata(MPLReactContainerActivity.this.mNotificationData);
                        }
                    } else if (map.containsKey("deepLinkPayLoad")) {
                        MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 1 ", map.get("deepLinkPayLoad"));
                        MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("deepLinkPayLoad")));
                        MSharedPreferencesUtils.saveDeepLinkForInstall(String.valueOf(map.get("deepLinkPayLoad")));
                    } else if (map.containsKey("redirect") || map.containsKey("route")) {
                        MPLReactContainerActivity.this.getCreateDeepLinkData(hashMap2);
                    } else if (map.containsKey("notification_data") && map.get("notification_data") != null) {
                        MLogger.d(MPLReactContainerActivity.TAG, "saving notification data:--> 4 ", String.valueOf(map.get("notification_data")));
                        MPLReactContainerActivity.this.mNotificationData = AppsflyerUtils.setIsAppsFlyerData(String.valueOf(map.get("notification_data")));
                        MSharedPreferencesUtils.setAppsflyerredirectiondata(MPLReactContainerActivity.this.mNotificationData);
                    }
                    CleverTapAnalyticsUtils.sendEvent((String) Constant.ATTRIBUTION_DETECTED, hashMap);
                    MPLReactContainerActivity.this.conversionDataAppsflyer = hashMap;
                    AppsflyerUtils.fetchAndSaveReferralRelatedInfo(map);
                    AppsflyerUtils.fetchAndSavePlayWithFriendData(map);
                }
            }
        }
    };
    public FusedLocationProviderClient fusedLocationClient;
    public final BroadcastReceiver geoSpoofingDetectedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                NonSealedApkFragment.newInstance(MPLReactContainerActivity.this.getString(R.string.gps_spoof_title), MPLReactContainerActivity.this.getString(R.string.gps_spoof_message), MPLReactContainerActivity.this.getString(R.string.ok_got_it), true, Constant.GPS_SPOOFING_DIALOG).show(MPLReactContainerActivity.this.getSupportFragmentManager(), (String) "gps_spoofing");
                HashMap hashMap = new HashMap();
                hashMap.put(EventsConstants.POP_UP_NAME, "Shield GPS Spoofer Pop Up");
                CleverTapAnalyticsUtils.sendEvent((String) "Android GPS Spoofer", hashMap);
            } catch (Exception unused) {
            }
        }
    };
    public boolean hasReleaseNotes = false;
    public long initTime;
    public boolean isAnimationEnded;
    public Boolean isAppIntegrityFail = Boolean.FALSE;
    public boolean isBoundService = false;
    public boolean isLaunchFromShortCut = false;
    public boolean isReactInitHappened = false;
    public boolean isReactLoadCalled;
    public boolean isReferralCodeEmitDone;
    public boolean isRegister;
    public boolean isSignupCodeEmitDone;
    public boolean isSplitDialog = false;
    public boolean isSubmitScoreRequire = false;
    public boolean isWarmLaunch = false;
    public final BroadcastReceiver mAssetsDownloadedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Class cls = RCTDeviceEventEmitter.class;
            Bundle bundleExtra = intent.getBundleExtra(Event.DOWNLOADED_ASSETS_DATA);
            if (bundleExtra != null) {
                String string = bundleExtra.getString(Event.DOWNLOADED_ASSETS_DATA);
                String str = Constant.GAME_DOWNLOAD_PROGRESS;
                String str2 = null;
                boolean z = false;
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.optInt("progress", 0) == -3333) {
                        str = Constant.GAME_ASSETS_DOWNLOADING_FAILED;
                    } else if (jSONObject.optInt("progress", 0) == 100) {
                        str2 = Constant.GAME_ASSETS_DOWNLOAD_COMPLETED;
                    }
                } catch (Exception unused) {
                }
                MLogger.d(MPLReactContainerActivity.TAG, "onReceive:download_assets 1", string, str);
                if (MPLReactContainerActivity.this.mReactContext != null) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onReceive:download_assets 2", string);
                    ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(cls)).emit(str, string);
                    if (str2 != null) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(cls)).emit(str2, string);
                    }
                } else if (MPLReactContainerActivity.this.mReactInstanceManager != null && MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext() != null && MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls) != null) {
                    MLogger.d(MPLReactContainerActivity.TAG, "onReceive:download_assets 3", string);
                    ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls)).emit(str, string);
                    if (str2 != null) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls)).emit(str2, string);
                    }
                } else if (MPLReactContainerActivity.this.reactEmitter != null) {
                    MPLReactContainerActivity.this.reactEmitter.emit(str, string);
                    if (str2 != null) {
                        MPLReactContainerActivity.this.reactEmitter.emit(str2, string);
                    }
                } else {
                    Object[] objArr = new Object[4];
                    objArr[0] = "download_assets mReactInstanceManager is null in assets download";
                    objArr[1] = Boolean.valueOf(MPLReactContainerActivity.this.mReactInstanceManager == null);
                    objArr[2] = Boolean.valueOf(MPLReactContainerActivity.this.mReactContext == null);
                    if (MPLReactContainerActivity.this.reactEmitter == null) {
                        z = true;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    MLogger.d(MPLReactContainerActivity.TAG, objArr);
                }
            }
        }
    };
    public final BroadcastReceiver mBackgroundTaskReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.hasExtra("taskName") && !TextUtils.isEmpty(intent.getStringExtra("taskName"))) {
                String stringExtra = intent.getStringExtra("taskName");
                if (stringExtra == null) {
                    return;
                }
                if (stringExtra.equalsIgnoreCase("BannedAppCheck")) {
                    if (intent.hasExtra("isBannedAppPresent")) {
                        boolean booleanExtra = intent.getBooleanExtra("isBannedAppPresent", false);
                        HashMap hashMap = new HashMap();
                        hashMap.put("Is Banned App Present", Boolean.valueOf(booleanExtra));
                        hashMap.put("Is USB Debugging ON", Boolean.valueOf(Util.isUsbDebuggingEnabled(MPLReactContainerActivity.this.getApplicationContext())));
                        hashMap.put("Is Developer Option ON", Boolean.valueOf(Util.isDeveloperOptionEnabled(MPLReactContainerActivity.this.getApplicationContext())));
                        MSharedPreferencesUtils.setBannedAppPresent(booleanExtra);
                        CleverTapAnalyticsUtils.pushProfileEvent(hashMap);
                    }
                } else if (stringExtra.equalsIgnoreCase("GameCompetitorApp")) {
                    if (intent.hasExtra("isGameCompetitorAppPresent")) {
                        String stringExtra2 = intent.getStringExtra("gameCompetitorApps");
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("Competitor Apps", stringExtra2);
                        CleverTapAnalyticsUtils.sendEvent((String) "Competitor App Present", hashMap2);
                        MSharedPreferencesUtils.setCompetitorsAppsListEventSend(MPLReactContainerActivity.this, true);
                    }
                } else if (stringExtra.equalsIgnoreCase("GameTemperedApp")) {
                    if (intent.hasExtra("isGameTemperedAppPresent")) {
                        boolean booleanExtra2 = intent.getBooleanExtra("isGameTemperedAppPresent", false);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("Is Game Tampered App Present", Boolean.valueOf(booleanExtra2));
                        hashMap3.put("Is USB Debugging ON", Boolean.valueOf(Util.isUsbDebuggingEnabled(MPLReactContainerActivity.this.getApplicationContext())));
                        hashMap3.put("Is Developer Option ON", Boolean.valueOf(Util.isDeveloperOptionEnabled(MPLReactContainerActivity.this.getApplicationContext())));
                        MSharedPreferencesUtils.setGameTamperedAppPresent(booleanExtra2);
                        CleverTapAnalyticsUtils.pushProfileEvent(hashMap3);
                    }
                } else if (!stringExtra.equalsIgnoreCase("GoogleIdTask")) {
                } else {
                    if (intent.hasExtra("googleId") || intent.hasExtra(Constant.HEADER_ANDROID_DEVICE_ID)) {
                        String stringExtra3 = intent.getStringExtra("googleId");
                        String stringExtra4 = intent.getStringExtra(Constant.HEADER_ANDROID_DEVICE_ID);
                        HashMap hashMap4 = new HashMap();
                        if (!TextUtils.isEmpty(stringExtra4)) {
                            hashMap4.put("Device Id", stringExtra4);
                            MSharedPreferencesUtils.putStringPref(Constant.DEVICE_ID, stringExtra4, false);
                            MSharedPreferencesUtils.setDeviceId(context, stringExtra4);
                        }
                        if (!TextUtils.isEmpty(stringExtra3)) {
                            hashMap4.put("Google Id", stringExtra3);
                        }
                        if (hashMap4.size() > 0) {
                            CleverTapAnalyticsUtils.pushProfileEvent(hashMap4);
                        }
                    }
                }
            }
        }
    };
    public BroadcastReceiver mBindServiceReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MPLReactContainerActivity.this.bindService(intent.getBooleanExtra(Event.IS_APP_SERVICE, false));
        }
    };
    public SplashScreenBinding mBinding;
    public CallbackManager mCallbackManager;
    public final Messenger mClientMessenger = new Messenger(new ClientHandler(this));
    public AlertDialog mFraudAlertDialog;
    public final BroadcastReceiver mGameDisconnectReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getStringExtra(Constant.GAME_DATA) != null) {
                try {
                    MLogger.v(MPLReactContainerActivity.TAG, "onReceive called: gameDisconnection-->");
                    JSONObject jSONObject = new JSONObject(intent.getStringExtra(Constant.GAME_DATA));
                    jSONObject.put("BattleDisconnectionReason", "User Led App Minimisation");
                    MPLReactContainerActivity.this.pendingResult = goAsync();
                    new GameDisconnection(context, MPLReactContainerActivity.this.pendingResult).sendGameDisconnectionData(jSONObject.toString(), intent.getStringExtra(Constant.GAME_CONFIG));
                } catch (Exception e2) {
                    MLogger.e(MPLReactContainerActivity.TAG, e2.getMessage());
                }
            }
        }
    };
    public PaymentCallBackListener mImagePickerCallBackListener;
    public BroadcastReceiver mInstallBroadCastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mInstallBroadCastReceiver ");
            if (intent != null) {
                try {
                    if (intent.getData() != null && !TextUtils.isEmpty(intent.getData().getSchemeSpecificPart())) {
                        String action = intent.getAction();
                        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                        ApkInfo thirdPartyAppInfoBasedOnPackageName = CommonUtils.getThirdPartyAppInfoBasedOnPackageName(schemeSpecificPart);
                        if (thirdPartyAppInfoBasedOnPackageName == null) {
                            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mInstallBroadCastReceiver Game info is null");
                        } else if ("android.intent.action.PACKAGE_ADDED".equalsIgnoreCase(action)) {
                            if (thirdPartyAppInfoBasedOnPackageName.isOriginals()) {
                                MPLReactContainerActivity.this.relaunchActivityForOriginals(context, thirdPartyAppInfoBasedOnPackageName, schemeSpecificPart);
                            } else {
                                Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(MPLReactContainerActivity.this, thirdPartyAppInfoBasedOnPackageName.getGameId().intValue(), Long.parseLong(thirdPartyAppInfoBasedOnPackageName.getGameVersion())));
                            }
                            long installedApkVersion = Util.getInstalledApkVersion(context, schemeSpecificPart);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("Game Id", thirdPartyAppInfoBasedOnPackageName.getGameId());
                            jSONObject.put("Game Name", thirdPartyAppInfoBasedOnPackageName.getGameName());
                            jSONObject.put(AssetsAnalytics.PROP_GAME_VERSION, installedApkVersion);
                            jSONObject.put(AssetsAnalytics.PROP_GAME_INSTALLED_VERSION, installedApkVersion);
                            jSONObject.put(AssetsAnalytics.PROP_GAME_SERVER_VERSION, thirdPartyAppInfoBasedOnPackageName.getGameVersion());
                            jSONObject.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, thirdPartyAppInfoBasedOnPackageName.getForceUpdate());
                            jSONObject.put("Entry Point", "App Opened");
                            CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_INSTALLED_COMPLETED, jSONObject.toString());
                            MLogger.d(MPLReactContainerActivity.TAG, "onReceive: ", Boolean.valueOf(thirdPartyAppInfoBasedOnPackageName.isShowInstallToast()));
                            if (thirdPartyAppInfoBasedOnPackageName.isShowInstallToast()) {
                                MPLReactContainerActivity.this.sendInstallStatusToReact("Install Succeeded!", thirdPartyAppInfoBasedOnPackageName.getGameId().intValue());
                            }
                        } else if ("android.intent.action.PACKAGE_FULLY_REMOVED".equalsIgnoreCase(action) && thirdPartyAppInfoBasedOnPackageName.isShowInstallToast()) {
                            MPLReactContainerActivity.this.sendInstallStatusToReact("Uninstall Success", thirdPartyAppInfoBasedOnPackageName.getGameId().intValue());
                        }
                    }
                } catch (Exception unused) {
                    MLogger.e(MPLReactContainerActivity.TAG, "onReceive:mInstallBroadCastReceiver ");
                }
            }
        }
    };
    public final BroadcastReceiver mIntegrityCheckReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            StatusType statusType = (StatusType) intent.getSerializableExtra(Event.STATUS);
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive: ", statusType);
            MPLReactContainerActivity.this.updateView(statusType);
        }
    };
    public LifecycleState mLifecycleState = LifecycleState.BEFORE_RESUME;
    public MqttAndroidClient mMQTTClient;
    public final BroadcastReceiver mMQTTMessageReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            com.mpl.androidapp.utils.MLogger.e(com.mpl.androidapp.react.MPLReactContainerActivity.TAG, "onReceive: notification parsing error");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r14, android.content.Intent r15) {
            /*
                r13 = this;
                java.lang.Class<com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter> r0 = com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter.class
                java.lang.String r1 = "sentTimeStamp"
                java.lang.String r2 = "notificationType"
                java.lang.String r3 = "mqttMessageResponse"
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]
                java.lang.String r6 = "mMQTTMessageReceiver onReceive: "
                r7 = 0
                r5[r7] = r6
                java.lang.String r6 = "Mqtt:"
                com.mpl.androidapp.utils.MLogger.d(r6, r5)
                java.lang.String r5 = "onReceive: "
                java.lang.String r8 = "MPLReactContainerActivity"
                if (r15 == 0) goto L_0x00f8
                boolean r9 = r15.hasExtra(r3)     // Catch:{ Exception -> 0x0100 }
                if (r9 == 0) goto L_0x00f8
                java.lang.String r15 = r15.getStringExtra(r3)     // Catch:{ Exception -> 0x0100 }
                if (r15 == 0) goto L_0x0107
                boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0100 }
                if (r3 != 0) goto L_0x0107
                boolean r3 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r15)     // Catch:{ Exception -> 0x0100 }
                if (r3 == 0) goto L_0x0107
                java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0100 }
                java.lang.String r9 = "onReceive: sending data"
                r3[r7] = r9     // Catch:{ Exception -> 0x0100 }
                com.mpl.androidapp.utils.MLogger.d(r6, r3)     // Catch:{ Exception -> 0x0100 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0082 }
                r3.<init>(r15)     // Catch:{ Exception -> 0x0082 }
                boolean r9 = r3.has(r2)     // Catch:{ Exception -> 0x0082 }
                if (r9 == 0) goto L_0x008b
                boolean r9 = r3.has(r1)     // Catch:{ Exception -> 0x0082 }
                if (r9 == 0) goto L_0x008b
                java.lang.String r9 = ""
                java.lang.String r2 = r3.optString(r2, r9)     // Catch:{ Exception -> 0x0082 }
                r9 = 0
                long r11 = r3.optLong(r1, r9)     // Catch:{ Exception -> 0x0082 }
                int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r1 == 0) goto L_0x008b
                long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0082 }
                long r9 = r9 - r11
                long r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getMQTTTimeEscape()     // Catch:{ Exception -> 0x0082 }
                int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r1 <= 0) goto L_0x008b
                boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0082 }
                if (r1 != 0) goto L_0x008b
                java.lang.String r1 = "USER_ONLINE"
                boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0082 }
                if (r1 == 0) goto L_0x008b
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0082 }
                java.lang.String r2 = "onReceive:notification is before than 10 minutes "
                r1[r7] = r2     // Catch:{ Exception -> 0x0082 }
                com.mpl.androidapp.utils.MLogger.d(r6, r1)     // Catch:{ Exception -> 0x0082 }
                return
            L_0x0082:
                java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0100 }
                java.lang.String r2 = "onReceive: notification parsing error"
                r1[r7] = r2     // Catch:{ Exception -> 0x0100 }
                com.mpl.androidapp.utils.MLogger.e(r8, r1)     // Catch:{ Exception -> 0x0100 }
            L_0x008b:
                com.mpl.androidapp.react.MPLReactContainerActivity r1 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.ReactInstanceManager r1 = r1.mReactInstanceManager     // Catch:{ Exception -> 0x0100 }
                java.lang.String r2 = "}"
                java.lang.String r3 = "{\"mqtt_response\":"
                java.lang.String r6 = "global"
                if (r1 == 0) goto L_0x00d4
                com.mpl.androidapp.react.MPLReactContainerActivity r1 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.bridge.ReactContext r1 = r1.mReactContext     // Catch:{ Exception -> 0x0100 }
                if (r1 == 0) goto L_0x00d4
                com.mpl.androidapp.react.MPLReactContainerActivity r1 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.bridge.ReactContext r1 = r1.mReactContext     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.bridge.JavaScriptModule r1 = r1.getJSModule(r0)     // Catch:{ Exception -> 0x0100 }
                if (r1 == 0) goto L_0x00d4
                com.mpl.androidapp.react.MPLReactContainerActivity r1 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.bridge.ReactContext r1 = r1.mReactContext     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.bridge.JavaScriptModule r0 = r1.getJSModule(r0)     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r0 = (com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r0     // Catch:{ Exception -> 0x0100 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
                r1.<init>()     // Catch:{ Exception -> 0x0100 }
                r1.append(r3)     // Catch:{ Exception -> 0x0100 }
                r1.append(r15)     // Catch:{ Exception -> 0x0100 }
                r1.append(r2)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0100 }
                r0.emit(r6, r1)     // Catch:{ Exception -> 0x0100 }
                com.mpl.androidapp.react.MPLReactContainerActivity r0 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                r0.sendNotificationThroughMQTT(r14, r15)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0107
            L_0x00d4:
                com.mpl.androidapp.react.MPLReactContainerActivity r14 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r14 = r14.reactEmitter     // Catch:{ Exception -> 0x0100 }
                if (r14 == 0) goto L_0x0107
                com.mpl.androidapp.react.MPLReactContainerActivity r14 = com.mpl.androidapp.react.MPLReactContainerActivity.this     // Catch:{ Exception -> 0x0100 }
                com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r14 = r14.reactEmitter     // Catch:{ Exception -> 0x0100 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
                r0.<init>()     // Catch:{ Exception -> 0x0100 }
                r0.append(r3)     // Catch:{ Exception -> 0x0100 }
                r0.append(r15)     // Catch:{ Exception -> 0x0100 }
                r0.append(r2)     // Catch:{ Exception -> 0x0100 }
                java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x0100 }
                r14.emit(r6, r15)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0107
            L_0x00f8:
                java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0100 }
                r14[r7] = r5     // Catch:{ Exception -> 0x0100 }
                com.mpl.androidapp.utils.MLogger.e(r8, r14)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0107
            L_0x0100:
                java.lang.Object[] r14 = new java.lang.Object[r4]
                r14[r7] = r5
                com.mpl.androidapp.utils.MLogger.e(r8, r14)
            L_0x0107:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.AnonymousClass9.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    public final BroadcastReceiver mMQTTSubscriptionReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mMQTTSubscriptionReceiver ");
                if (!(intent == null || intent.getAction() == null)) {
                    String action = intent.getAction();
                    MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mMQTTSubscriptionReceiver ", action);
                    if (Event.ACTION_MQTT_SUBSCRIPTION.equalsIgnoreCase(action)) {
                        String stringExtra = intent.getStringExtra(OneSingnalConstant.PARAM_ACTION_TYPE);
                        if (MqttServiceConstants.SUBSCRIBE_ACTION.equalsIgnoreCase(stringExtra)) {
                            String[] stringArrayExtra = intent.getStringArrayExtra(Constants.EXTRA_KEY_TOPICS);
                            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                                int[] iArr = new int[stringArrayExtra.length];
                                Arrays.fill(iArr, 1);
                                if (MPLReactContainerActivity.this.mMQTTClient != null) {
                                    MPLReactContainerActivity.this.mMQTTClient.subscribe(stringArrayExtra, iArr);
                                }
                            }
                        } else if ("publish".equalsIgnoreCase(stringExtra)) {
                            String stringExtra2 = intent.getStringExtra(MiPushMessage.KEY_TOPIC);
                            String stringExtra3 = intent.getStringExtra("message");
                            if (!TextUtils.isEmpty(stringExtra2)) {
                                if (!TextUtils.isEmpty(stringExtra3)) {
                                    MqttMessage mqttMessage = new MqttMessage(stringExtra3.getBytes());
                                    mqttMessage.setQos(1);
                                    mqttMessage.setRetained(false);
                                    if (MPLReactContainerActivity.this.mMQTTClient != null) {
                                        MPLReactContainerActivity.this.mMQTTClient.publish(stringExtra2, mqttMessage);
                                    }
                                }
                            }
                        } else if (MqttServiceConstants.UNSUBSCRIBE_ACTION.equalsIgnoreCase(stringExtra)) {
                            String[] stringArrayExtra2 = intent.getStringArrayExtra(Constants.EXTRA_KEY_TOPICS);
                            if (!(stringArrayExtra2 == null || stringArrayExtra2.length <= 0 || MPLReactContainerActivity.this.mMQTTClient == null)) {
                                MPLReactContainerActivity.this.mMQTTClient.unsubscribe(stringArrayExtra2);
                            }
                        } else if (!(!"sendBirdNotificationReceived".equalsIgnoreCase(stringExtra) || MPLReactContainerActivity.this.mReactInstanceManager == null || MPLReactContainerActivity.this.mReactContext == null)) {
                            String stringExtra4 = intent.getStringExtra(MiPushMessage.KEY_TOPIC);
                            String stringExtra5 = intent.getStringExtra("message");
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString(AnalyticsConstants.METHOD, stringExtra4);
                            createMap.putString("sendBirdNotification", stringExtra5);
                            ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(CarExtender.KEY_MESSAGES, createMap);
                        }
                    }
                }
            } catch (Exception unused) {
                MLogger.e(MPLReactContainerActivity.TAG, "onReceive: ");
            }
        }
    };
    public NotificationBuilder mNotificationBuilder;
    public String mNotificationData = null;
    public PaymentCallBackListener mPaymentCallBackListener;
    public PermissionListener mPermissionListener;
    public final BroadcastReceiver mProceedAfterLoginDataReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mProceedAfterLoginDataReceiver");
            MPLReactContainerActivity.this.processAfterLoginData();
        }
    };
    public final BroadcastReceiver mProceedHomeDataLoadCompletedReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mProceedHomeDataLoadCompletedReceiver [START]");
            MPLReactContainerActivity mPLReactContainerActivity = MPLReactContainerActivity.this;
            mPLReactContainerActivity.runTasksOnBackgroundThreadAfterHomeLoaded(mPLReactContainerActivity);
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mProceedHomeDataLoadCompletedReceiver [END]");
        }
    };
    public final BroadcastReceiver mProceedHomeDataReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mProceedHomeDataReceiver [START]");
            MPLReactContainerActivity.this.checkForSubmitScore();
            MPLReactContainerActivity.this.runBackgroundTasks();
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mProceedHomeDataReceiver [END]");
        }
    };
    public ReactContext mReactContext;
    public ReactInstanceManager mReactInstanceManager;
    public ReactRootView mReactRootView;
    public final BroadcastReceiver mRecordingMonitorReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            MLogger.d(MPLReactContainerActivity.TAG, "onReceive() called with: intent = [" + intent + CMapParser.MARK_END_OF_ARRAY);
            if (intent != null) {
                boolean hasExtra = intent.hasExtra(Constant.IS_LOCAL_VOICE_CHAT_MUTED);
                boolean hasExtra2 = intent.hasExtra(Constant.IS_REMOTE_VOICE_CHAT_MUTED);
                boolean hasExtra3 = intent.hasExtra(GameConstant.IS_SUBMIT_SCORE);
                String stringExtra = intent.getStringExtra(Constant.TOGGLE_USER_FOLLOW_STATUS);
                if (!TextUtils.isEmpty(stringExtra) && "toggle".equals(stringExtra)) {
                    boolean booleanExtra = intent.getBooleanExtra(Constant.SHOULD_FOLLOW_USER, false);
                    MPLReactContainerActivity.this.toggleUserFollowStatus(intent.getIntExtra(Constant.FOLLOWED_USER_ID, -2323), booleanExtra);
                }
                MLogger.d(VideoRecordingConstants.TAG, "onReceive() called with: shouldPauseRecording = ", "hasMuteValue", Boolean.valueOf(hasExtra));
                if (hasExtra) {
                    MSharedPreferencesUtils.putBooleanPref(Constant.IS_LOCAL_VOICE_CHAT_MUTED, intent.getBooleanExtra(Constant.IS_LOCAL_VOICE_CHAT_MUTED, false), false);
                }
                if (hasExtra2) {
                    MSharedPreferencesUtils.putBooleanPref(Constant.IS_REMOTE_VOICE_CHAT_MUTED, intent.getBooleanExtra(Constant.IS_REMOTE_VOICE_CHAT_MUTED, false), false);
                }
                if (hasExtra3) {
                    MPLReactContainerActivity.this.doSubmitFromNative(intent);
                }
            }
        }
    };
    public Intent mResultIntentAfterUnity;
    public Typeface mRobotoBoldFont;
    public Typeface mRobotoRegularFont;
    public String mScore = null;
    public AlertDialog mScreenMagnificationAlertDialog;
    public ContentObserver mScreenShotContentObserver;
    public Uri mScreenShotURI;
    public final ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MPLReactContainerActivity.this.isBoundService = true;
            if (iBinder instanceof AppBinder) {
                ((AppBinder) iBinder).setMessenger(MPLReactContainerActivity.this.mClientMessenger);
            } else if (iBinder instanceof BundleBinder) {
                ((BundleBinder) iBinder).setMessenger(MPLReactContainerActivity.this.mClientMessenger);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            MPLReactContainerActivity.this.isBoundService = false;
        }
    };
    public final BroadcastReceiver mSetContentViewReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && MPLReactContainerActivity.this.mReactRootView != null) {
                MLogger.d(MPLReactContainerActivity.TAG, "onReceive called: isAppIntegrityFail-->", MPLReactContainerActivity.this.isAppIntegrityFail + " isReactInitHappened-->", Boolean.valueOf(MPLReactContainerActivity.this.isReactInitHappened));
                CleverTapAnalyticsUtils.pushProfileEvent(new HashMap());
                if (!MPLReactContainerActivity.this.isAppIntegrityFail.booleanValue()) {
                    MPLReactContainerActivity.this.setReactView();
                    return;
                }
                MLogger.d(MPLReactContainerActivity.TAG, "onReceive:mSetContentViewReceiver AppIntegrityFail");
            }
        }
    };
    public JSONObject mSplashConfig;
    public AsyncTask<Void, Void, Void> mStartMqttChannelAsyncTask;
    public String mWarningJson;
    public int minOSForSplashOS = 26;
    public final Moshi moshi = new Builder().build();
    public BroadcastReceiver notificationCancelReciever = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("game_id", 0);
                if (MPLReactContainerActivity.this.mReactInstanceManager == null || MPLReactContainerActivity.this.mReactContext == null) {
                    MLogger.d(Constant.NOTIFICATION_CANCELLED, "context not found");
                    return;
                }
                ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(Constant.NOTIFICATION_CANCELLED, Integer.valueOf(intExtra));
                MLogger.d(Constant.NOTIFICATION_CANCELLED, GeneratedOutlineSupport.outline41("download_cancelled_clicked:: gameId ", intExtra));
                MSharedPreferencesUtils.putNotificationCancelReceiverId(null);
            }
        }
    };
    public int notificationId = -1;
    public PendingResult pendingResult;
    public Long reactContainerOnCreateTime;
    public RCTDeviceEventEmitter reactEmitter;
    public long reactStartProcess;
    public final RgWarningListener rgWarningListener = new RgWarningListener() {
        public void onShowWarning(String str) {
            if (MPLReactContainerActivity.this.mReactInstanceManager == null || MPLReactContainerActivity.this.mReactContext == null) {
                MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline50(" Can NOT emit warning to react from MPLREACTCONTAINERACTIVITY, saving it for after init!", str));
                MPLReactContainerActivity.this.mWarningJson = str;
                return;
            }
            ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("rg_time_warning", str);
            MLogger.d("ResponsibleGamingTimer", GeneratedOutlineSupport.outline50("Emitting warning to react from MPLREACTCONTAINERACTIVITY--->", str));
            MPLReactContainerActivity.this.mWarningJson = null;
        }
    };
    public boolean shouldChangeInFirstLaunch = false;
    public boolean shouldShow;
    public boolean shouldWait = true;
    public boolean skipLaunchData = false;
    public String splashLotteEndId;
    public String splashLotteEndUrl;
    public String splashLotteId;
    public String splashLotteUrl;
    public MPLReactContainerVm viewModel;

    /* renamed from: com.mpl.androidapp.react.MPLReactContainerActivity$33  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass33 {
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$androidapp$updater$util$StatusType;
        public static final /* synthetic */ int[] $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|29|30|(2:31|32)|33|(2:35|36)|37|39|40|41|43|44|45|46|47|(2:49|50)|51|53|54|55|57|58|59|60|61|63|64|65|66|(3:67|68|70)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|29|30|31|32|33|35|36|37|39|40|41|43|44|45|46|47|49|50|51|53|54|55|57|58|59|60|61|63|64|65|66|(3:67|68|70)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0098 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00a0 */
        static {
            /*
                com.mpl.androidapp.utils.DialogData$TYPE[] r0 = com.mpl.androidapp.utils.DialogData.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE = r0
                r1 = 1
                com.mpl.androidapp.utils.DialogData$TYPE r2 = com.mpl.androidapp.utils.DialogData.TYPE.DEVELOPER_OPTION     // Catch:{ NoSuchFieldError -> 0x000e }
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 0
                r2 = 2
                int[] r3 = $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.mpl.androidapp.utils.DialogData$TYPE r4 = com.mpl.androidapp.utils.DialogData.TYPE.USB_DEBUGGING     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r3 = 3
                int[] r4 = $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mpl.androidapp.utils.DialogData$TYPE r5 = com.mpl.androidapp.utils.DialogData.TYPE.MAGNIFICATION     // Catch:{ NoSuchFieldError -> 0x001d }
                r4[r3] = r3     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r4 = 4
                int[] r5 = $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.mpl.androidapp.utils.DialogData$TYPE r6 = com.mpl.androidapp.utils.DialogData.TYPE.SPLIT_SCREEN     // Catch:{ NoSuchFieldError -> 0x0024 }
                r5[r2] = r4     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r5 = 5
                int[] r6 = $SwitchMap$com$mpl$androidapp$utils$DialogData$TYPE     // Catch:{ NoSuchFieldError -> 0x002b }
                com.mpl.androidapp.utils.DialogData$TYPE r7 = com.mpl.androidapp.utils.DialogData.TYPE.COMMON     // Catch:{ NoSuchFieldError -> 0x002b }
                r6[r5] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.mpl.androidapp.updater.util.StatusType[] r6 = com.mpl.androidapp.updater.util.StatusType.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$com$mpl$androidapp$updater$util$StatusType = r6
                com.mpl.androidapp.updater.util.StatusType r7 = com.mpl.androidapp.updater.util.StatusType.CRITICAL     // Catch:{ NoSuchFieldError -> 0x0038 }
                r6[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r6 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mpl.androidapp.updater.util.StatusType r7 = com.mpl.androidapp.updater.util.StatusType.INTEGRITY_BUNDLE_RESOURCE_FAIL     // Catch:{ NoSuchFieldError -> 0x003e }
                r6[r0] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0044 }
                com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.DOWNLOADED_APK_INTEGRITY_FAIL     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                r0 = 9
                int[] r2 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x004c }
                com.mpl.androidapp.updater.util.StatusType r6 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL     // Catch:{ NoSuchFieldError -> 0x004c }
                r2[r0] = r4     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                int[] r2 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.mpl.androidapp.updater.util.StatusType r6 = com.mpl.androidapp.updater.util.StatusType.INSTALL     // Catch:{ NoSuchFieldError -> 0x0052 }
                r2[r3] = r5     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                r2 = 6
                int[] r3 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.CHECKING_UPDATE     // Catch:{ NoSuchFieldError -> 0x0059 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                r3 = 7
                int[] r4 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.DOWNLOADING     // Catch:{ NoSuchFieldError -> 0x0060 }
                r4[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                r1 = 8
                r4 = 13
                int[] r5 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x006a }
                com.mpl.androidapp.updater.util.StatusType r6 = com.mpl.androidapp.updater.util.StatusType.INIT_REACT     // Catch:{ NoSuchFieldError -> 0x006a }
                r5[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r5 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0070 }
                com.mpl.androidapp.updater.util.StatusType r6 = com.mpl.androidapp.updater.util.StatusType.PROCEED     // Catch:{ NoSuchFieldError -> 0x0070 }
                r5[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
            L_0x0070:
                r0 = 10
                int[] r2 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.NO_STORAGE     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                r1 = 11
                int[] r2 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0080 }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.INTERNET_ABSENT     // Catch:{ NoSuchFieldError -> 0x0080 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0080 }
            L_0x0080:
                r2 = 12
                int[] r3 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x008a }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.GENERIC_CONNECTION_ERROR     // Catch:{ NoSuchFieldError -> 0x008a }
                r5 = 17
                r3[r5] = r2     // Catch:{ NoSuchFieldError -> 0x008a }
            L_0x008a:
                int[] r3 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mpl.androidapp.updater.util.StatusType r5 = com.mpl.androidapp.updater.util.StatusType.MIN_ROOT_VERSION_FAILED     // Catch:{ NoSuchFieldError -> 0x0090 }
                r3[r0] = r4     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                r0 = 14
                int[] r3 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x0098 }
                com.mpl.androidapp.updater.util.StatusType r4 = com.mpl.androidapp.updater.util.StatusType.INSTALL_APK_LOW_STORAGE     // Catch:{ NoSuchFieldError -> 0x0098 }
                r3[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                int[] r1 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x00a0 }
                com.mpl.androidapp.updater.util.StatusType r3 = com.mpl.androidapp.updater.util.StatusType.ROOT_STATUS     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r3 = 15
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                int[] r1 = $SwitchMap$com$mpl$androidapp$updater$util$StatusType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.PLAY_STORE_DOWNLOAD_CRITICAL     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 16
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.AnonymousClass33.<clinit>():void");
        }
    }

    public class AppsCheckingAsyncTask extends AsyncTask<ArrayList<String>, Void, Void> {
        public AppsCheckingAsyncTask() {
        }

        @SafeVarargs
        public final Void doInBackground(ArrayList<String>... arrayListArr) {
            if (arrayListArr != null) {
                try {
                    if (arrayListArr.length > 0) {
                        Iterator<String> it = arrayListArr[0].iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (MPLReactContainerActivity.ACTION_BANNED_APP.equals(next)) {
                                MPLReactContainerActivity.this.handleActionBannedApp();
                            } else if (MPLReactContainerActivity.ACTION_GAME_TEMPERED_APP.equals(next)) {
                                MPLReactContainerActivity.this.handleActionGameTemperedApp();
                            } else if (MPLReactContainerActivity.ACTION_GAME_COMPETITOR_APP.equals(next)) {
                                MPLReactContainerActivity.this.handleActionGameCompetitorApp();
                            } else if (MPLReactContainerActivity.ACTION_GOOGLE_ID.equals(next)) {
                                MPLReactContainerActivity.this.getIdThread();
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public class ClientHandler extends Handler {
        public final WeakReference<Context> mContextRef;

        public ClientHandler(Context context) {
            this.mContextRef = new WeakReference<>(context);
        }

        public void handleMessage(Message message) {
            Class cls = RCTDeviceEventEmitter.class;
            MLogger.d(MPLReactContainerActivity.TAG, "handleMessage:publishProgress ");
            if (((Context) this.mContextRef.get()) == null) {
                MLogger.d(MPLReactContainerActivity.TAG, "handleMessage:publishProgress context is null ");
                return;
            }
            if (message != null && message.what == 1) {
                try {
                    MLogger.d(MPLReactContainerActivity.TAG, "handleMessage:publishProgress ");
                    int i = message.getData().getInt("progress");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", 999);
                    jSONObject.put("progress", i);
                    MLogger.d(MPLReactContainerActivity.TAG, "handleMessage: publishProgress sending progress to react[START]", Integer.valueOf(i));
                    if (MPLReactContainerActivity.this.reactEmitter != null) {
                        MLogger.d(MPLReactContainerActivity.TAG, "handleMessage: publishProgress sending progress to react 1 [END]", Integer.valueOf(i));
                        MPLReactContainerActivity.this.reactEmitter.emit("apk_download_progress", jSONObject.toString());
                    } else if (MPLReactContainerActivity.this.mReactContext != null && MPLReactContainerActivity.this.mReactContext.getJSModule(cls) != null) {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactContext.getJSModule(cls)).emit("apk_download_progress", jSONObject.toString());
                        MLogger.d(MPLReactContainerActivity.TAG, "handleMessage: publishProgress sending progress to react 2 [END]", Integer.valueOf(i));
                    } else if (MPLReactContainerActivity.this.mReactInstanceManager == null || MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext() == null || MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls) == null) {
                        Object[] objArr = new Object[4];
                        objArr[0] = "handleMessage: publishProgress mReactInstanceManager or mReactContext is null: ";
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Boolean.valueOf(MPLReactContainerActivity.this.mReactInstanceManager == null);
                        objArr[3] = Boolean.valueOf(MPLReactContainerActivity.this.mReactContext == null);
                        MLogger.d(MPLReactContainerActivity.TAG, objArr);
                    } else {
                        ((RCTDeviceEventEmitter) MPLReactContainerActivity.this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls)).emit("apk_download_progress", jSONObject.toString());
                        MLogger.d(MPLReactContainerActivity.TAG, "handleMessage: publishProgress sending progress to react 3 [END]", Integer.valueOf(i));
                    }
                    if (MPLReactContainerActivity.this.mBinding.progress != null && MPLReactContainerActivity.this.mBinding.progress.isShown()) {
                        MPLReactContainerActivity.this.mBinding.progress.setProgress(i);
                        TextView textView = MPLReactContainerActivity.this.mBinding.txtProgress;
                        textView.setText(i + "% " + MPLReactContainerActivity.this.getString(R.string.progress_text));
                    }
                } catch (Exception e2) {
                    MLogger.e(MPLReactContainerActivity.TAG, "ClientHandler:publishProgress", e2);
                }
            } else if (message != null && message.what == 2) {
                MLogger.d(MPLReactContainerActivity.TAG, GeneratedOutlineSupport.outline41("React progress:publishProgress ", message.getData().getInt("progress")));
            }
            super.handleMessage(message);
        }
    }

    public class FetchNotificationData extends AsyncTask<Intent, Void, Void> {
        public final boolean isAppOpen;

        public FetchNotificationData(boolean z) {
            this.isAppOpen = z;
        }

        public Void doInBackground(Intent... intentArr) {
            if (!(intentArr == null || intentArr.length <= 0 || intentArr[0] == null)) {
                MPLReactContainerActivity.this.getDataFromNotification(intentArr[0], this.isAppOpen);
            }
            return null;
        }
    }

    public interface GameEventCallback {
        void onFailure(String str);

        void onSuccess(String str);
    }

    public class IntegrityAppCheck extends AsyncTask<Void, Void, Boolean> {
        public IntegrityAppCheck() {
        }

        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(MPLReactContainerActivity.this.isIntegrityCheckFail());
        }

        public void onPostExecute(Boolean bool) {
            MPLReactContainerActivity.this.isAppIntegrityFail = bool;
        }
    }

    public class StartMqttChannelAsyncTask extends AsyncTask<Void, Void, Void> {
        public StartMqttChannelAsyncTask() {
        }

        public Void doInBackground(Void... voidArr) {
            MPLReactContainerActivity.this.mqttCalling();
            return null;
        }

        public void onCancelled() {
            super.onCancelled();
            MLogger.d(MPLReactContainerActivity.MQTT_TAG, "onCancelled: ");
        }

        public void onCancelled(Void voidR) {
            super.onCancelled(voidR);
            MLogger.e(MPLReactContainerActivity.MQTT_TAG, "onCancelled: ");
        }
    }

    private void assetBundleDownloadEventReceived(MessageEvent messageEvent) {
        Class cls = RCTDeviceEventEmitter.class;
        Bundle bundle = messageEvent.getBundle();
        if (bundle != null) {
            String string = bundle.getString(Event.DOWNLOADED_ASSETS_DATA);
            String str = Constant.GAME_DOWNLOAD_PROGRESS;
            String str2 = null;
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.optInt("progress", 0) == -3333) {
                    str = Constant.GAME_ASSETS_DOWNLOADING_FAILED;
                } else if (jSONObject.optInt("progress", 0) == 100) {
                    str2 = Constant.GAME_ASSETS_DOWNLOAD_COMPLETED;
                }
            } catch (Exception unused) {
            }
            MLogger.d(TAG, "onReceive:download_assets 1", string, str);
            if (this.mReactContext != null) {
                MLogger.d(TAG, "onReceive:download_assets 2", string);
                ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(str, string);
                if (str2 != null) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(str2, string);
                    return;
                }
                return;
            }
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
            if (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null || this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls) == null) {
                RCTDeviceEventEmitter rCTDeviceEventEmitter = this.reactEmitter;
                if (rCTDeviceEventEmitter != null) {
                    rCTDeviceEventEmitter.emit(str, string);
                    if (str2 != null) {
                        this.reactEmitter.emit(str2, string);
                        return;
                    }
                    return;
                }
                Object[] objArr = new Object[4];
                objArr[0] = "download_assets mReactInstanceManager is null in assets download";
                objArr[1] = Boolean.valueOf(this.mReactInstanceManager == null);
                objArr[2] = Boolean.valueOf(this.mReactContext == null);
                if (this.reactEmitter == null) {
                    z = true;
                }
                objArr[3] = Boolean.valueOf(z);
                MLogger.d(TAG, objArr);
                return;
            }
            MLogger.d(TAG, "onReceive:download_assets 3", string);
            ((RCTDeviceEventEmitter) this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls)).emit(str, string);
            if (str2 != null) {
                ((RCTDeviceEventEmitter) this.mReactInstanceManager.getCurrentReactContext().getJSModule(cls)).emit(str2, string);
            }
        }
    }

    /* access modifiers changed from: private */
    public void bindService(boolean z) {
        Intent intent;
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "bindService:isAppUpdateService ", Boolean.valueOf(z));
        if (!this.isBoundService) {
            if (z) {
                intent = new Intent(this, AppUpdater.class);
            } else {
                intent = new Intent(this, BundleUpdater.class);
            }
            bindService(intent, this.mServiceConnection, 1);
        }
    }

    private String calculateGameSubmitData(String str) {
        String str2;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                long optInt = ((long) jSONObject2.optInt("Score")) + jSONObject2.optLong(GameConstant.GAME_END_TIME);
                String optString = jSONObject2.optString(GameConstant.GAME_SIGNATURE);
                String optString2 = jSONObject2.optString(GameConstant.GAME_FRAUD_DETECTION_FLAGS);
                if (TextUtils.isEmpty(optString2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("-1");
                    sb.append(MSharedPreferencesUtils.isPhoneRooted() ? 1 : 0);
                    sb.append(MSharedPreferencesUtils.isGameTamperedAppPresent() ? 1 : 0);
                    str2 = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(optString2);
                    sb2.append("-1");
                    sb2.append(MSharedPreferencesUtils.isPhoneRooted() ? 1 : 0);
                    sb2.append(MSharedPreferencesUtils.isGameTamperedAppPresent() ? 1 : 0);
                    str2 = sb2.toString();
                }
                jSONObject2.put(GameConstant.GAME_FRAUD_DETECTION_FLAGS, str2);
                String privateData = MSharedPreferencesUtils.getPrivateData();
                Object[] objArr = new Object[2];
                if (TextUtils.isEmpty(privateData)) {
                    privateData = "";
                }
                objArr[0] = MemoryLruCache.pickKey(privateData, optInt);
                objArr[1] = optString;
                String encodeToString = Base64.encodeToString(String.format("%s-%s", objArr).getBytes(), 2);
                jSONObject2.put("signature", "V7/" + encodeToString);
                if (jSONObject2.has(GameConstant.GAME_SIGNATURE)) {
                    jSONObject2.remove(GameConstant.GAME_SIGNATURE);
                }
                return jSONObject2.toString();
            } catch (JSONException e2) {
                e = e2;
                jSONObject = jSONObject2;
                jSONObject.remove(GameConstant.GAME_SIGNATURE);
                MLogger.d(TAG, e);
                return str;
            }
        } catch (JSONException e3) {
            e = e3;
            if (jSONObject != null && jSONObject.has(GameConstant.GAME_SIGNATURE)) {
                jSONObject.remove(GameConstant.GAME_SIGNATURE);
            }
            MLogger.d(TAG, e);
            return str;
        }
    }

    private void cancelNotification(int i) {
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(i);
    }

    private void checkAllNotificationChannels() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels != null && notificationChannels.size() > 0) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                boolean areNotificationsEnabled = NotificationManagerCompat.from(getApplicationContext()).areNotificationsEnabled();
                hashMap.put("Show Global Notification", Boolean.valueOf(areNotificationsEnabled));
                for (NotificationChannel next : notificationChannels) {
                    String charSequence = next.getName() != null ? next.getName().toString() : "";
                    String id = next.getId();
                    boolean isNotificationChannelEnabled = Util.isNotificationChannelEnabled(this, next.getId());
                    MLogger.d(TAG, "checkAllNotificationChannels:channelName ", charSequence, "channelId: ", id, "channelSubscriptionStatus: ", Boolean.valueOf(isNotificationChannelEnabled));
                    boolean booleanInNormalPref = MSharedPreferencesUtils.getBooleanInNormalPref(this, id, true);
                    hashMap2.put(charSequence, Boolean.valueOf(isNotificationChannelEnabled));
                    if (booleanInNormalPref != isNotificationChannelEnabled) {
                        hashMap.put("Category Name", charSequence);
                        hashMap.put("Show Category Notification", Boolean.valueOf(isNotificationChannelEnabled));
                        CleverTapAnalyticsUtils.sendEvent((String) "Category Notification Button Toggled", hashMap);
                        MSharedPreferencesUtils.saveBooleanInNormalPref(this, id, isNotificationChannelEnabled);
                    }
                }
                CleverTapAnalyticsUtils.pushProfileEvent(hashMap2);
                if (MSharedPreferencesUtils.getBooleanInNormalPref(this, "globalNotificationToggle", true) != areNotificationsEnabled) {
                    CleverTapAnalyticsUtils.sendEvent((String) "Global Notification Button Toggled V2", hashMap);
                    MSharedPreferencesUtils.saveBooleanInNormalPref(this, "globalNotificationToggle", areNotificationsEnabled);
                    return;
                }
                return;
            }
            return;
        }
        HashMap hashMap3 = new HashMap();
        boolean booleanInNormalPref2 = MSharedPreferencesUtils.getBooleanInNormalPref(this, "globalNotificationToggle", true);
        boolean areNotificationsEnabled2 = NotificationManagerCompat.from(getApplicationContext()).areNotificationsEnabled();
        if (booleanInNormalPref2 != areNotificationsEnabled2) {
            hashMap3.put("Show Global Notification", Boolean.valueOf(areNotificationsEnabled2));
            CleverTapAnalyticsUtils.sendEvent((String) "Global Notification Button Toggled V2", hashMap3);
            MSharedPreferencesUtils.saveBooleanInNormalPref(this, "globalNotificationToggle", areNotificationsEnabled2);
        }
    }

    private void checkAndSendRgWarning() {
        RgSessionManager.logSeperator("START: checkAndSendRgWarning()");
        MLogger.d("ResponsibleGamingTimer", "Init done going to check mWarningJson");
        if (this.mWarningJson != null) {
            if (this.mReactInstanceManager != null) {
                ReactContext reactContext = this.mReactContext;
                if (reactContext != null) {
                    ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("rg_time_warning", this.mWarningJson);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Emitting warning to react from  MPLREACTCONTAINERACTIVITY --->");
                    outline73.append(this.mWarningJson);
                    MLogger.d("ResponsibleGamingTimer", outline73.toString());
                    this.mWarningJson = null;
                }
            }
            StringBuilder outline732 = GeneratedOutlineSupport.outline73(" Can NOT emit warning to react from  MPLREACTCONTAINERACTIVITY, saving it for after init!");
            outline732.append(this.mWarningJson);
            MLogger.d("ResponsibleGamingTimer", outline732.toString());
        }
        RgSessionManager.logSeperator("END: checkAndSendRgWarning()");
    }

    private void checkAppGuardServices() {
        AppGuardClient appGuardClient = this.mAppGuardClient;
        if (appGuardClient != null) {
            MLogger.d(TAG, "checkAppGuardServices:isInitialized ", Boolean.valueOf(appGuardClient.isInitialized()));
            MLogger.d(TAG, "checkAppGuardServices:getVersion ", this.mAppGuardClient.getVersion());
            this.mAppGuardClient.setUserId(String.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(this)));
        }
    }

    /* access modifiers changed from: private */
    public void checkForSubmitScore() {
        MLogger.d(TAG, "checkForSubmitScore: start ", this.mNotificationData, MSharedPreferencesUtils.getAppsflyerredirectiondata() + " Thread name " + Thread.currentThread().getName());
        if (!this.isSubmitScoreRequire || TextUtils.isEmpty(this.mScore) || this.mResultIntentAfterUnity == null) {
            String str = this.mNotificationData;
            if (str != null && !TextUtils.isEmpty(str)) {
                MLogger.d(TAG, TAG, "saving notification data:--> 10 ", this.mNotificationData);
                emitDataToReact(this.mNotificationData);
                MSharedPreferencesUtils.removeDeepLinkForInstall();
            } else if (MSharedPreferencesUtils.getAppsflyerredirectiondata() != null && !TextUtils.isEmpty(MSharedPreferencesUtils.getAppsflyerredirectiondata())) {
                MLogger.d(TAG, TAG, "saving redirection data: ", MSharedPreferencesUtils.getAppsflyerredirectiondata());
                emitDataToReact(MSharedPreferencesUtils.getAppsflyerredirectiondata());
                MSharedPreferencesUtils.setAppsflyerredirectiondata(null);
            } else if (!MSharedPreferencesUtils.isAppFirstLaunch(this)) {
                MLogger.d(TAG, "onReceiveResult: mNotificationData is null");
            } else if (Util.isFantasyGameId()) {
                try {
                    Bundle bundle = new Bundle();
                    JSONObject jSONObject = new JSONObject();
                    bundle.putString("action", "OPEN_DEEP_LINK");
                    bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SuperTeamHome\",\"param\":{}}}");
                    for (String str2 : bundle.keySet()) {
                        jSONObject.put(str2, JSONObject.wrap(bundle.get(str2)));
                    }
                    MLogger.d(TAG, "mNotificationData " + jSONObject);
                    emitDataToReact(jSONObject.toString());
                    MSharedPreferencesUtils.setAppFirstLaunch(this, false);
                } catch (Exception unused) {
                }
            } else if (Util.shouldRedirectToListingScreen()) {
                Bundle bundle2 = new Bundle();
                JSONObject jSONObject2 = new JSONObject();
                bundle2.putString("action", "OPEN_DEEP_LINK");
                if (MBuildConfigUtils.getLaunchingGameId() == 2048) {
                    bundle2.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"param\":{\"gameId\":\"" + MBuildConfigUtils.getLaunchingGameId() + "\",\"isThirdPartyApk\":\"true\",\"isWebApkFlow\":\"true\",\"internalRouteObject\":{}},\"route\":\"GameView\"}}");
                } else {
                    bundle2.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + MBuildConfigUtils.getLaunchingGameId() + "}}}");
                }
                for (String str3 : bundle2.keySet()) {
                    jSONObject2.put(str3, JSONObject.wrap(bundle2.get(str3)));
                }
                MLogger.d(TAG, "mNotificationData " + jSONObject2);
                emitDataToReact(jSONObject2.toString());
                MSharedPreferencesUtils.setAppFirstLaunch(this, false);
            }
        } else if (MSharedPreferencesUtils.isNativeSubmitScoreEnabled() && this.mResultIntentAfterUnity != null) {
            MLogger.d(ActivityConstant.MEMORY_TAG, "onReceiveResult:called from HOME_PAGE_LOADED_REACT to native side");
            doSubmitFromNative(this.mResultIntentAfterUnity);
        } else if (!(this.mReactInstanceManager == null || this.mReactContext == null)) {
            MLogger.d(ActivityConstant.MEMORY_TAG, "onReceiveResult:called from HOME_PAGE_LOADED_REACT to react side");
            doSubmitScore(this.mResultIntentAfterUnity);
        }
        ConfigManager.setPostLoginCalledFromReact(false);
        MLogger.d(TAG, "checkForSubmitScore: end ", this.mNotificationData, MSharedPreferencesUtils.getAppsflyerredirectiondata() + " Thread name " + Thread.currentThread().getName());
    }

    /* access modifiers changed from: private */
    public void checkFraudApps() {
        char c2;
        boolean z;
        MLogger.d(TAG, "checkFraudApps:[START]", Long.valueOf(System.currentTimeMillis()));
        Object[] objArr = new Object[2];
        objArr[0] = "checkFraudApps:[START] is running on main thread";
        objArr[1] = Boolean.valueOf(Looper.myLooper() == Looper.getMainLooper());
        MLogger.d(TAG, objArr);
        try {
            if (ConfigManager.getNormalConfig() != null && ConfigManager.getNormalConfig().has("fraud.apps") && ConfigManager.getNormalConfig().optJSONArray("fraud.apps") != null && ConfigManager.getNormalConfig().optJSONArray("fraud.apps").length() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONArray optJSONArray = ConfigManager.getNormalConfig().optJSONArray("fraud.apps");
                String optString = ConfigManager.getNormalConfig().optString("fraud.apps.title", "Suspicious App detected");
                String optString2 = ConfigManager.getNormalConfig().optString("fraud.apps.message", "Please uninstall this app and try again after relaunch");
                int i = 0;
                while (true) {
                    if (optJSONArray == null || i >= optJSONArray.length()) {
                        z = false;
                    } else {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString3 = optJSONObject.optString("packageName", "");
                            String optString4 = optJSONObject.optString("appName", "");
                            if (Util.isAppInstalled(MPLApplication.getInstance(), optString3)) {
                                MLogger.d(TAG, "checkFraudApps: found fraud app", optString4);
                                $$Lambda$MPLReactContainerActivity$NAbGfmJx4tZcRM5roR29bM1PdKw r0 = new Runnable(currentTimeMillis, optString4, optString, (TextUtils.isEmpty(optString2) || !optString2.contains("$APP_NAME")) ? optString2 : optString2.replace("$APP_NAME", optString4)) {
                                    public final /* synthetic */ long f$1;
                                    public final /* synthetic */ String f$2;
                                    public final /* synthetic */ String f$3;
                                    public final /* synthetic */ String f$4;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r4;
                                        this.f$3 = r5;
                                        this.f$4 = r6;
                                    }

                                    public final void run() {
                                        MPLReactContainerActivity.this.lambda$checkFraudApps$17$MPLReactContainerActivity(this.f$1, this.f$2, this.f$3, this.f$4);
                                    }
                                };
                                runOnUiThread(r0);
                                MLogger.d(TAG, "checkFraudApps: Time taken after detecting apps: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                z = true;
                            }
                        }
                        i++;
                    }
                }
                if (!z) {
                    runOnUiThread(new Runnable(currentTimeMillis) {
                        public final /* synthetic */ long f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            MPLReactContainerActivity.this.lambda$checkFraudApps$18$MPLReactContainerActivity(this.f$1);
                        }
                    });
                    MLogger.d(TAG, "checkFraudApps: ", "Time taken after no App detection: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
            c2 = 1;
        } catch (Exception unused) {
            c2 = 1;
            MLogger.e(TAG, "checkFraudApps: ");
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "checkFraudApps:[END]";
        objArr2[c2] = Long.valueOf(System.currentTimeMillis());
        MLogger.d(TAG, objArr2);
    }

    private MqttConnectOptions createMqttConnectOptions(String str, int i) {
        String str2 = "";
        try {
            String userProfile = MSharedPreferencesUtils.getUserProfile();
            if (userProfile != null && !TextUtils.isEmpty(userProfile)) {
                str2 = new JSONObject(userProfile).optString("displayName", str2);
            }
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
        }
        MqttConnectOptions mqttConnectOptions = null;
        try {
            MqttConnectOptions mqttConnectOptions2 = new MqttConnectOptions();
            try {
                mqttConnectOptions2.setAutomaticReconnect(true);
                mqttConnectOptions2.setMqttVersion(4);
                mqttConnectOptions2.setSocketFactory(SSLContext.getDefault().getSocketFactory());
                mqttConnectOptions2.setUserName(str2);
                mqttConnectOptions2.setPassword(str.toCharArray());
                mqttConnectOptions2.setWill(MSharedPreferencesUtils.getMQTTServerPrefix() + i, getWillData().getBytes(), 1, false);
                mqttConnectOptions2.setKeepAliveInterval(MSharedPreferencesUtils.getMqttKeepAliveInterval());
                mqttConnectOptions2.setCleanSession(false);
                return mqttConnectOptions2;
            } catch (NoSuchAlgorithmException unused) {
                mqttConnectOptions = mqttConnectOptions2;
            }
        } catch (NoSuchAlgorithmException unused2) {
            MLogger.e(TAG, "createMqttConnectOptions: ");
            return mqttConnectOptions;
        }
    }

    private void deleteOldAssets() {
        int lastInstalledAppVersion = MSharedPreferencesUtils.getLastInstalledAppVersion();
        if (MBuildConfigUtils.getInstalledAppVersionCode() % 1000000 == 70 || (lastInstalledAppVersion != 0 && lastInstalledAppVersion % 1000000 < 70)) {
            GEInteractor.getInstance().deleteRummyAssetsForFirstTime(this, 1000044);
        }
        if (!ConfigManager.getPlatformConfig().optBoolean("assets.poker.delete.enabled")) {
            return;
        }
        if (MBuildConfigUtils.getInstalledAppVersionCode() % 1000000 == 98 || (lastInstalledAppVersion != 0 && lastInstalledAppVersion % 1000000 < 98)) {
            GEInteractor.getInstance().deletePokerAssetsForFirstTime(this, 1000067);
        }
    }

    private void deleteThirdPartiesApks() {
        try {
            ArrayList<ApkInfo> allThirdPartyGamesItems = CommonUtils.getAllThirdPartyGamesItems();
            if (allThirdPartyGamesItems != null && allThirdPartyGamesItems.size() > 0) {
                for (int i = 0; i < allThirdPartyGamesItems.size(); i++) {
                    ApkInfo apkInfo = allThirdPartyGamesItems.get(i);
                    if (apkInfo != null) {
                        boolean isAppInstalled = Util.isAppInstalled(this, apkInfo.getPackageName());
                        long installedApkVersion = Util.getInstalledApkVersion(this, apkInfo.getPackageName());
                        File thirdPartyAppDownloadDir = FileUtils.getThirdPartyAppDownloadDir(this, apkInfo.getGameId().intValue(), Long.parseLong(apkInfo.getGameVersion()));
                        MLogger.d(TAG, "deleteThirdPartiesApks:deleteRecursive ", apkInfo.getGameName(), Boolean.valueOf(isAppInstalled), Long.valueOf(installedApkVersion), thirdPartyAppDownloadDir);
                        if (isAppInstalled && thirdPartyAppDownloadDir.exists() && apkInfo.getGameVersion() != null && Long.parseLong(apkInfo.getGameVersion()) >= installedApkVersion) {
                            Util.deleteRecursive(thirdPartyAppDownloadDir);
                        }
                        if (apkInfo.getGameVersion() != null && Long.parseLong(apkInfo.getGameVersion()) == installedApkVersion) {
                            boolean isEventSentForInstall = isEventSentForInstall(apkInfo.getGameId().intValue(), apkInfo.getGameVersion());
                            if (isAppInstalled && !isEventSentForInstall) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("Game Id", apkInfo.getGameId());
                                hashMap.put("Game Name", apkInfo.getGameName());
                                hashMap.put(AssetsAnalytics.PROP_GAME_VERSION, Long.valueOf(installedApkVersion));
                                hashMap.put(AssetsAnalytics.PROP_GAME_INSTALLED_VERSION, Long.valueOf(installedApkVersion));
                                hashMap.put(AssetsAnalytics.PROP_GAME_SERVER_VERSION, apkInfo.getGameVersion());
                                hashMap.put(AssetsAnalytics.PROP_IS_FORCE_UPDATE, Boolean.valueOf(apkInfo.getForceUpdate()));
                                hashMap.put("Entry Point", PDActionLaunch.SUB_TYPE);
                                CleverTapAnalyticsUtils.sendEvent((String) AssetsAnalytics.EVENT_GAME_INSTALLED_COMPLETED, hashMap);
                                saveEventSentForInstall(apkInfo.getGameId().intValue(), apkInfo.getGameVersion(), true);
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "deleteThirdPartiesApks: ", e2);
        }
    }

    private void detectAccessibilitySetting() {
        try {
            runOnUiThread(new Runnable() {
                public final void run() {
                    MPLReactContainerActivity.this.lambda$detectAccessibilitySetting$16$MPLReactContainerActivity();
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "detectAccessibilitySetting: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void doSubmitFromNative(final Intent intent) {
        Class cls = RCTDeviceEventEmitter.class;
        MLogger.d(TAG, "doSubmitFromNative: ");
        final String str = null;
        if (intent != null) {
            try {
                if (intent.hasExtra(Constant.GAME_SCORE)) {
                    str = intent.getStringExtra(Constant.GAME_SCORE);
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "doSubmitFromNative: ", e2);
                return;
            }
        }
        MSharedPreferencesUtils.setIsUserPlayingGame(false);
        if (str == null || TextUtils.isEmpty(str)) {
            MLogger.d(TAG, "doSubmitFromNative:string data is null ");
            if (this.mReactInstanceManager == null || this.mReactContext == null || this.mReactContext.getJSModule(cls) == null) {
                this.mScore = str;
                this.isSubmitScoreRequire = true;
                return;
            }
            ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GAME_SCORE, "Quit game");
        } else if (!str.startsWith("quitGame")) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            int optInt = new JSONObject(str).optInt(GameConstant.TOURNAMENT_ID_ANDROID, -1);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("gameSession", new JSONObject(calculateGameSubmitData(str)));
            jSONObject.put("gameSession", jSONObject2);
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            NetworkUtils.doPostRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + String.format(ApiEndPoints.SUBMIT_CORE, new Object[]{Integer.valueOf(optInt)})).setConnectionTimeOut(10000).setWriteTimeOut(10000).setMHeaders(arrayList).setReadTimeOut(10000).setRetryOption(true).setMRequestBody(jSONObject.toString()).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "onResponseFail:doSubmitFromNative ", exc);
                    try {
                        MPLReactContainerActivity.this.showSubmitScoreFailDialog(intent);
                        if (exc != null && exc.getMessage() != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("success", true);
                            jSONObject.put("payload", new JSONObject(exc.getMessage()));
                            MSharedPreferencesUtils.saveSubmitScoreData(jSONObject.toString());
                            if (MPLReactContainerActivity.this.mReactInstanceManager != null && MPLReactContainerActivity.this.mReactContext != null) {
                                MPLReactContainerActivity.this.submitGameScore(MPLReactContainerActivity.this.mReactContext, str);
                            }
                        }
                    } catch (Exception e2) {
                        MLogger.e(IResponseListener.TAG, "onResponseFail", e2);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "doSubmitFromNative success");
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("success", true);
                        jSONObject.put("payload", new JSONObject(str).optJSONObject("payload"));
                        MSharedPreferencesUtils.saveSubmitScoreData(jSONObject.toString());
                        if (MPLReactContainerActivity.this.mReactInstanceManager != null && MPLReactContainerActivity.this.mReactContext != null) {
                            MPLReactContainerActivity.this.submitGameScore(MPLReactContainerActivity.this.mReactContext, str);
                        }
                    } catch (JSONException e2) {
                        MLogger.e(IResponseListener.TAG, "doSubmitFromNative fail ", e2);
                    }
                }
            }, "submit_request");
        } else if (this.mReactInstanceManager == null || this.mReactContext == null) {
            this.mScore = str;
            this.isSubmitScoreRequire = true;
        } else {
            submitGameScore(this.mReactContext, str);
        }
    }

    private void doSubmitScore(Intent intent) {
        if (intent != null) {
            try {
                if (!(this.mReactInstanceManager == null || this.mReactContext == null)) {
                    submitGameScore(this.mReactContext, intent.getStringExtra(Constant.GAME_SCORE));
                    MLogger.d(TAG, "doSubmitScore called without Context null,Calling Submit score ");
                    return;
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "doSubmitScore: ", e2);
                return;
            }
        }
        if (intent != null) {
            if (this.mReactInstanceManager != null) {
                this.mScore = intent.getStringExtra(Constant.GAME_SCORE);
                this.isSubmitScoreRequire = true;
                MLogger.d(TAG, "doSubmitScore called with Context null,onReactContextInitialized should called to Submit score ");
                return;
            }
        }
        if (intent != null) {
            this.mScore = intent.getStringExtra(Constant.GAME_SCORE);
            this.isSubmitScoreRequire = true;
            MLogger.d(TAG, "doSubmitScore called with Context null,onReactContextInitialized should called to Submit score ");
        } else if (this.mReactInstanceManager != null) {
            MLogger.d(TAG, "doSubmitScore called with null data, Calling submit data");
            submitGameScore(this.mReactContext, "");
        } else {
            MLogger.d(TAG, "doSubmitScore called with null data, and null reactManager");
            this.mScore = "";
            this.isSubmitScoreRequire = true;
        }
    }

    private void emitDataToReact(String str) {
        Class cls = RCTDeviceEventEmitter.class;
        MLogger.d(TAG, "Sending notification data to react: ", str);
        if (this.mReactInstanceManager != null) {
            ReactContext reactContext = this.mReactContext;
            if (!(reactContext == null || reactContext.getJSModule(cls) == null || str == null)) {
                Object[] objArr = new Object[5];
                objArr[0] = "emitDataToReact: 1wqeqw2";
                objArr[1] = Boolean.valueOf(this.mReactContext != null);
                objArr[2] = Boolean.valueOf(this.mReactInstanceManager != null);
                objArr[3] = Boolean.valueOf(this.mReactContext.getJSModule(cls) != null);
                objArr[4] = Boolean.valueOf(true);
                MLogger.d(TAG, objArr);
                ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit("notification_data", "{\"notification_data\":" + str + "}");
                try {
                    if (!isAppsFlyerDeepLinkData(str)) {
                        CleverTapAnalyticsUtils.sendNotificationClickEvent(new JSONObject(str));
                    }
                } catch (Exception e2) {
                    MLogger.d(TAG, "emitDataToReact: 1wqeqw2", e2.getMessage());
                }
                this.mNotificationData = null;
                return;
            }
        }
        if (this.reactEmitter != null) {
            MLogger.d(TAG, "emitDataToReact: 1wqeqw2");
            RCTDeviceEventEmitter rCTDeviceEventEmitter = this.reactEmitter;
            rCTDeviceEventEmitter.emit("notification_data", "{\"notification_data\":" + str + "}");
            return;
        }
        MLogger.d(TAG, "Some params are null in emitDataToReact");
    }

    /* access modifiers changed from: private */
    public void getCreateDeepLinkData(Map<String, String> map) {
        int i;
        String str;
        Map<String, String> map2 = map;
        char c2 = 0;
        try {
            for (String next : map.keySet()) {
                Object[] objArr = new Object[2];
                objArr[c2] = TAG;
                objArr[1] = "conversion_attribute: " + next + " = " + map2.get(next);
                MLogger.d(TAG, objArr);
                c2 = 0;
            }
            String str2 = map2.get("deepLinkPayLoad");
            String str3 = map2.get("redirect");
            if (TextUtils.isEmpty(str3)) {
                if (map2.containsKey("route")) {
                    str3 = map2.get("route");
                }
            }
            if ((str2 == null || TextUtils.isEmpty(str2)) && str3 != null && !TextUtils.isEmpty(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "OPEN_DEEP_LINK");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(OneSingnalConstant.PARAM_ACTION_TYPE, "nav");
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    boolean equalsIgnoreCase = "GamesTab".equalsIgnoreCase(str3);
                    String str4 = TAG;
                    if (equalsIgnoreCase) {
                        try {
                            String str5 = map2.get("gameId");
                            if (str5 != null) {
                                jSONObject4.put("id", Integer.parseInt(str5));
                            }
                            if (map2.get("type") != null) {
                                jSONObject4.put("type", map2.get("type"));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = str4;
                            i = 2;
                            try {
                                Object[] objArr2 = new Object[2];
                                try {
                                    objArr2[0] = " redirect createDeepLinkPayload: ";
                                    objArr2[1] = e;
                                    MLogger.e(str, objArr2);
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                Object[] objArr3 = new Object[i];
                                objArr3[0] = "getCreateDeepLinkData: ";
                                objArr3[1] = e;
                                MLogger.e(str, objArr3);
                            }
                        }
                    } else {
                        if (!"LobbyDetails".equalsIgnoreCase(str3) && !"TournamentDetails".equalsIgnoreCase(str3)) {
                            if (!"KnockoutDetails".equalsIgnoreCase(str3)) {
                                if ("SuperTeamContestDetail".equalsIgnoreCase(str3)) {
                                    String str6 = map2.get("matchId");
                                    String str7 = map2.get("contestId");
                                    String str8 = map2.get("sportId");
                                    if (str6 != null) {
                                        jSONObject4.put("matchId", Integer.parseInt(str6));
                                    }
                                    if (str7 != null) {
                                        jSONObject4.put("contestId", Integer.parseInt(str7));
                                    }
                                    if (str8 != null) {
                                        jSONObject4.put("sportId", Integer.parseInt(str8));
                                    }
                                } else if ("SuperTeamContests".equalsIgnoreCase(str3)) {
                                    String str9 = map2.get("matchId");
                                    String str10 = map2.get("sportId");
                                    if (str9 != null) {
                                        jSONObject4.put("matchId", Integer.parseInt(str9));
                                    }
                                    if (str10 != null) {
                                        jSONObject4.put("sportId", Integer.parseInt(str10));
                                    }
                                } else if ("LeagueHome".equalsIgnoreCase(str3)) {
                                    String str11 = map2.get("leagueId");
                                    if (map2.containsKey("from")) {
                                        jSONObject4.put("from", String.valueOf(map2.get("from")));
                                    }
                                    if (str11 != null && !TextUtils.isEmpty(str11)) {
                                        jSONObject4.put("leagueId", Integer.parseInt(str11));
                                    }
                                }
                            }
                        }
                        String str12 = map2.get("id");
                        if (str12 != null) {
                            jSONObject4.put("id", Integer.parseInt(str12));
                        }
                        if (map2.containsKey("tabIndex") && map2.get("tabIndex") != null) {
                            jSONObject4.put("tabIndex", Integer.parseInt(map2.get("tabIndex")));
                        }
                    }
                    if (map2.containsKey(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY) && map2.get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY) != null) {
                        String[] split = map2.get(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY).split("55");
                        if (split != null && split.length > 0) {
                            for (String str13 : split) {
                                if (map2.containsKey(str13)) {
                                    jSONObject4.put(str13, map2.get(str13));
                                }
                            }
                        }
                    }
                    jSONObject3.put("param", jSONObject4);
                    jSONObject3.put("route", str3);
                    jSONObject2.put(OneSingnalConstant.PARAM_ACTION_PAYLOAD, jSONObject3);
                    jSONObject.put("actionParams", jSONObject2);
                    MSharedPreferencesUtils.saveDeepLinkForInstall(jSONObject.toString());
                    String isAppsFlyerData = AppsflyerUtils.setIsAppsFlyerData(jSONObject.toString());
                    try {
                        this.mNotificationData = isAppsFlyerData;
                        MSharedPreferencesUtils.setAppsflyerredirectiondata(isAppsFlyerData);
                        str = str4;
                        try {
                            MLogger.d(str, "getCreateDeepLinkData: ", jSONObject.toString());
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str = str4;
                        i = 2;
                        Object[] objArr22 = new Object[2];
                        objArr22[0] = " redirect createDeepLinkPayload: ";
                        objArr22[1] = e;
                        MLogger.e(str, objArr22);
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = TAG;
                    i = 2;
                    Object[] objArr222 = new Object[2];
                    objArr222[0] = " redirect createDeepLinkPayload: ";
                    objArr222[1] = e;
                    MLogger.e(str, objArr222);
                }
            }
        } catch (Exception e8) {
            e = e8;
            str = TAG;
            i = 2;
            Object[] objArr32 = new Object[i];
            objArr32[0] = "getCreateDeepLinkData: ";
            objArr32[1] = e;
            MLogger.e(str, objArr32);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x021d, code lost:
        if (r3 == 2) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0220, code lost:
        if (r3 == 3) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x022c, code lost:
        if ("call".equalsIgnoreCase(r2) != false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0234, code lost:
        if ("chat".equalsIgnoreCase(r2) == false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0238, code lost:
        r3 = r2.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x023f, code lost:
        if (r3 == -786681338) goto L_0x0260;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0244, code lost:
        if (r3 == -502535187) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0249, code lost:
        if (r3 == 93166550) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0252, code lost:
        if (r2.equals("audio") == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0254, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x025c, code lost:
        if (r2.equals("report-abuse") == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x025e, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0266, code lost:
        if (r2.equals("payment") == false) goto L_0x026a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0268, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x026a, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x026b, code lost:
        if (r3 == 0) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x026e, code lost:
        if (r3 == 1) goto L_0x027b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0271, code lost:
        if (r3 == 2) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0273, code lost:
        r2 = r2.toUpperCase();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0278, code lost:
        r2 = "Report abuse";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x027b, code lost:
        r2 = "Audio Show/Livestream";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x027e, code lost:
        r2 = "Deposits/Withdrawals/KYC";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0280, code lost:
        r6.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SupportRequestDetails\",\"param\":{\"selectedTopicId\":\"" + r2 + "\",\"selectedTopicTitle\":\"" + r2 + "\",\"isDeepLink\":true}}}");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02a0, code lost:
        r6.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SupportRequestNew\",\"param\":{\"supportType\":\"" + r2.toUpperCase() + "\",\"isDeepLink\":true}}}");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02bc, code lost:
        r6.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SuperTeamHome\",\"param\":{}}}");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02c2, code lost:
        r6.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":" + r2 + "}}}");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02da, code lost:
        r6.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":" + r2 + "}}}");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02f5, code lost:
        if (r6.has("actionParams") == false) goto L_0x0307;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02f7, code lost:
        if (r22 == false) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02f9, code lost:
        emitDataToReact(r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0301, code lost:
        r1.mNotificationData = r6.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0214, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0217, code lost:
        if (r3 == 0) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x021a, code lost:
        if (r3 == 1) goto L_0x02c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getDataFromNotification(android.content.Intent r21, boolean r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "notification_data"
            java.lang.String r3 = "redirectReact"
            java.lang.String r4 = "isAddMoneyRequired"
            java.lang.String r5 = "Notification Type"
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r7 = "OPEN_DEEP_LINK"
            java.lang.String r8 = "notification"
            java.lang.String r9 = "action"
            java.lang.String r10 = "action_notification_id"
            java.lang.String r12 = "MPLReactContainerActivity"
            java.lang.String r13 = "actionParams"
            if (r0 == 0) goto L_0x018b
            android.os.Bundle r17 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            if (r17 == 0) goto L_0x018b
            android.os.Bundle r15 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "wzrk_acct_id"
            java.lang.String r14 = r15.getString(r14)     // Catch:{ Exception -> 0x0187 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0187 }
            if (r14 == 0) goto L_0x00f7
            android.os.Bundle r14 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = r14.getString(r13)     // Catch:{ Exception -> 0x0187 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0187 }
            if (r14 == 0) goto L_0x00f7
            android.os.Bundle r14 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r15 = "actionPayload"
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x0187 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0187 }
            if (r14 != 0) goto L_0x0055
            goto L_0x00f7
        L_0x0055:
            android.os.Bundle r3 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "FCM"
            java.lang.String r3 = r3.getString(r14)     // Catch:{ Exception -> 0x0187 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 != 0) goto L_0x018b
            android.os.Bundle r3 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.util.Set r14 = r3.keySet()     // Catch:{ Exception -> 0x0187 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0187 }
        L_0x0071:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0187 }
            if (r15 == 0) goto L_0x0089
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r19 = r3.get(r15)     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r11 = org.json.JSONObject.wrap(r19)     // Catch:{ Exception -> 0x0187 }
            r6.put(r15, r11)     // Catch:{ Exception -> 0x0187 }
            goto L_0x0071
        L_0x0089:
            boolean r11 = r3.containsKey(r2)     // Catch:{ Exception -> 0x0187 }
            if (r11 == 0) goto L_0x009f
            boolean r11 = r3.containsKey(r9)     // Catch:{ Exception -> 0x0187 }
            if (r11 != 0) goto L_0x009f
            java.lang.String r2 = r3.getString(r2)     // Catch:{ Exception -> 0x0187 }
            r6.put(r9, r7)     // Catch:{ Exception -> 0x0187 }
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
        L_0x009f:
            boolean r2 = r3.containsKey(r10)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x00ca
            r2 = -1
            int r3 = r3.getInt(r10, r2)     // Catch:{ Exception -> 0x0187 }
            r2 = 2
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03ef }
            java.lang.String r2 = "getDataFromNotification: from FCM "
            r14 = 0
            r11[r14] = r2     // Catch:{ Exception -> 0x0187 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0187 }
            r14 = 1
            r11[r14] = r2     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r11)     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r2 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0187 }
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2     // Catch:{ Exception -> 0x0187 }
            r11 = -1
            if (r3 == r11) goto L_0x00ca
            if (r2 == 0) goto L_0x00ca
            r2.cancel(r3)     // Catch:{ Exception -> 0x0187 }
        L_0x00ca:
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0187 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r2.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r11 = "mNotificationData 2 "
            r2.append(r11)     // Catch:{ Exception -> 0x0187 }
            r2.append(r6)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0187 }
            r11 = 0
            r3[r11] = r2     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r3)     // Catch:{ Exception -> 0x0187 }
            if (r22 == 0) goto L_0x00ef
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.emitDataToReact(r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x018b
        L_0x00ef:
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.mNotificationData = r2     // Catch:{ Exception -> 0x0187 }
            goto L_0x018b
        L_0x00f7:
            android.os.Bundle r2 = r21.getExtras()     // Catch:{ Exception -> 0x0187 }
            java.util.Set r11 = r2.keySet()     // Catch:{ Exception -> 0x0187 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0187 }
        L_0x0103:
            boolean r14 = r11.hasNext()     // Catch:{ Exception -> 0x0187 }
            if (r14 == 0) goto L_0x011b
            java.lang.Object r14 = r11.next()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r15 = r2.get(r14)     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r15 = org.json.JSONObject.wrap(r15)     // Catch:{ Exception -> 0x0187 }
            r6.put(r14, r15)     // Catch:{ Exception -> 0x0187 }
            goto L_0x0103
        L_0x011b:
            r11 = 1
            java.lang.Object[] r14 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0187 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r11.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r15 = "mNotificationData 1 "
            r11.append(r15)     // Catch:{ Exception -> 0x0187 }
            r11.append(r6)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0187 }
            r15 = 0
            r14[r15] = r11     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r14)     // Catch:{ Exception -> 0x0187 }
            boolean r11 = r2.containsKey(r10)     // Catch:{ Exception -> 0x0187 }
            if (r11 == 0) goto L_0x0162
            r11 = -1
            int r14 = r2.getInt(r10, r11)     // Catch:{ Exception -> 0x0187 }
            r11 = 2
            java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x0187 }
            java.lang.String r11 = "getDataFromNotification: not from FCM "
            r17 = 0
            r15[r17] = r11     // Catch:{ Exception -> 0x0187 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0187 }
            r16 = 1
            r15[r16] = r11     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r15)     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r11 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0187 }
            android.app.NotificationManager r11 = (android.app.NotificationManager) r11     // Catch:{ Exception -> 0x0187 }
            r15 = -1
            if (r14 == r15) goto L_0x0162
            if (r11 == 0) goto L_0x0162
            r11.cancel(r14)     // Catch:{ Exception -> 0x0187 }
        L_0x0162:
            boolean r11 = r2.containsKey(r3)     // Catch:{ Exception -> 0x0187 }
            if (r11 == 0) goto L_0x0176
            r11 = 0
            boolean r2 = r2.getBoolean(r3, r11)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x0176
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.mNotificationData = r2     // Catch:{ Exception -> 0x0187 }
            goto L_0x018b
        L_0x0176:
            if (r22 == 0) goto L_0x0180
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.emitDataToReact(r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x018b
        L_0x0180:
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.mNotificationData = r2     // Catch:{ Exception -> 0x0187 }
            goto L_0x018b
        L_0x0187:
            r0 = move-exception
            r2 = 2
            goto L_0x0441
        L_0x018b:
            if (r0 == 0) goto L_0x0307
            java.lang.String r3 = r21.getAction()     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0307
            java.lang.String r3 = r21.getAction()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r6 = "android.intent.action.VIEW"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0307
            android.net.Uri r3 = r21.getData()     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0307
            android.net.Uri r3 = r21.getData()     // Catch:{ Exception -> 0x0187 }
            java.util.List r3 = r3.getPathSegments()     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0307
            int r6 = r3.size()     // Catch:{ Exception -> 0x0187 }
            r11 = 2
            if (r6 != r11) goto L_0x0307
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0187 }
            r6.<init>()     // Catch:{ Exception -> 0x0187 }
            r6.put(r9, r7)     // Catch:{ Exception -> 0x0187 }
            int r11 = r3.size()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = ""
            r15 = 1
            if (r11 == r15) goto L_0x01db
            r2 = 2
            if (r11 == r2) goto L_0x01cc
            r2 = r14
            goto L_0x01e4
        L_0x01cc:
            r2 = 0
            java.lang.Object r11 = r3.get(r2)     // Catch:{ Exception -> 0x0187 }
            r14 = r11
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0187 }
            java.lang.Object r2 = r3.get(r15)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0187 }
            goto L_0x01e4
        L_0x01db:
            r2 = 0
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0187 }
            r2 = r14
            r14 = r3
        L_0x01e4:
            int r3 = r14.hashCode()     // Catch:{ Exception -> 0x0187 }
            switch(r3) {
                case -1854767153: goto L_0x020a;
                case -1396158280: goto L_0x0200;
                case -995993111: goto L_0x01f6;
                case -331908008: goto L_0x01ec;
                default: goto L_0x01eb;
            }     // Catch:{ Exception -> 0x0187 }
        L_0x01eb:
            goto L_0x0214
        L_0x01ec:
            java.lang.String r3 = "superteam"
            boolean r3 = r14.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0214
            r3 = 2
            goto L_0x0215
        L_0x01f6:
            java.lang.String r3 = "tournament"
            boolean r3 = r14.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0214
            r3 = 0
            goto L_0x0215
        L_0x0200:
            java.lang.String r3 = "battle"
            boolean r3 = r14.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0214
            r3 = 1
            goto L_0x0215
        L_0x020a:
            java.lang.String r3 = "support"
            boolean r3 = r14.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0214
            r3 = 3
            goto L_0x0215
        L_0x0214:
            r3 = -1
        L_0x0215:
            java.lang.String r11 = "}}}"
            if (r3 == 0) goto L_0x02da
            r14 = 1
            if (r3 == r14) goto L_0x02c2
            r14 = 2
            if (r3 == r14) goto L_0x02bc
            r11 = 3
            if (r3 == r11) goto L_0x0224
            goto L_0x02f1
        L_0x0224:
            java.lang.String r3 = "call"
            boolean r3 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r11 = "\",\"isDeepLink\":true}}}"
            if (r3 != 0) goto L_0x02a0
            java.lang.String r3 = "chat"
            boolean r3 = r3.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x0238
            goto L_0x02a0
        L_0x0238:
            int r3 = r2.hashCode()     // Catch:{ Exception -> 0x0187 }
            r14 = -786681338(0xffffffffd11c3206, float:-4.1928385E10)
            if (r3 == r14) goto L_0x0260
            r14 = -502535187(0xffffffffe20bebed, float:-6.452744E20)
            if (r3 == r14) goto L_0x0256
            r14 = 93166550(0x58d9bd6, float:1.3316821E-35)
            if (r3 == r14) goto L_0x024c
            goto L_0x026a
        L_0x024c:
            java.lang.String r3 = "audio"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x026a
            r3 = 1
            goto L_0x026b
        L_0x0256:
            java.lang.String r3 = "report-abuse"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x026a
            r3 = 2
            goto L_0x026b
        L_0x0260:
            java.lang.String r3 = "payment"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x026a
            r3 = 0
            goto L_0x026b
        L_0x026a:
            r3 = -1
        L_0x026b:
            if (r3 == 0) goto L_0x027e
            r14 = 1
            if (r3 == r14) goto L_0x027b
            r14 = 2
            if (r3 == r14) goto L_0x0278
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ Exception -> 0x0187 }
            goto L_0x0280
        L_0x0278:
            java.lang.String r2 = "Report abuse"
            goto L_0x0280
        L_0x027b:
            java.lang.String r2 = "Audio Show/Livestream"
            goto L_0x0280
        L_0x027e:
            java.lang.String r2 = "Deposits/Withdrawals/KYC"
        L_0x0280:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r3.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SupportRequestDetails\",\"param\":{\"selectedTopicId\":\""
            r3.append(r14)     // Catch:{ Exception -> 0x0187 }
            r3.append(r2)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "\",\"selectedTopicTitle\":\""
            r3.append(r14)     // Catch:{ Exception -> 0x0187 }
            r3.append(r2)     // Catch:{ Exception -> 0x0187 }
            r3.append(r11)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0187 }
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x02f1
        L_0x02a0:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r3.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SupportRequestNew\",\"param\":{\"supportType\":\""
            r3.append(r14)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r2.toUpperCase()     // Catch:{ Exception -> 0x0187 }
            r3.append(r2)     // Catch:{ Exception -> 0x0187 }
            r3.append(r11)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0187 }
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x02f1
        L_0x02bc:
            java.lang.String r2 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SuperTeamHome\",\"param\":{}}}"
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x02f1
        L_0x02c2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r3.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":"
            r3.append(r14)     // Catch:{ Exception -> 0x0187 }
            r3.append(r2)     // Catch:{ Exception -> 0x0187 }
            r3.append(r11)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0187 }
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x02f1
        L_0x02da:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0187 }
            r3.<init>()     // Catch:{ Exception -> 0x0187 }
            java.lang.String r14 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":"
            r3.append(r14)     // Catch:{ Exception -> 0x0187 }
            r3.append(r2)     // Catch:{ Exception -> 0x0187 }
            r3.append(r11)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0187 }
            r6.put(r13, r2)     // Catch:{ Exception -> 0x0187 }
        L_0x02f1:
            boolean r2 = r6.has(r13)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x0307
            if (r22 == 0) goto L_0x0301
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.emitDataToReact(r2)     // Catch:{ Exception -> 0x0187 }
            goto L_0x0307
        L_0x0301:
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0187 }
            r1.mNotificationData = r2     // Catch:{ Exception -> 0x0187 }
        L_0x0307:
            if (r0 == 0) goto L_0x03a8
            java.lang.String r2 = "launched_from_shortcut"
            r3 = 0
            boolean r2 = r0.getBooleanExtra(r2, r3)     // Catch:{ Exception -> 0x0187 }
            r1.isLaunchFromShortCut = r2     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = "launched_after_app_install"
            boolean r2 = r0.getBooleanExtra(r2, r3)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r3 = "launched_game_id"
            r6 = -1
            int r3 = r0.getIntExtra(r3, r6)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r6 = "gameData"
            java.lang.String r6 = r0.getStringExtra(r6)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r11 = "launched_game_package_name"
            java.lang.String r11 = r0.getStringExtra(r11)     // Catch:{ Exception -> 0x0187 }
            r14 = 12
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0187 }
            java.lang.String r15 = "gameLauncherDeepLink: isLaunchFromShortCut"
            r17 = 0
            r14[r17] = r15     // Catch:{ Exception -> 0x0187 }
            boolean r15 = r1.isLaunchFromShortCut     // Catch:{ Exception -> 0x0187 }
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)     // Catch:{ Exception -> 0x0187 }
            r16 = 1
            r14[r16] = r15     // Catch:{ Exception -> 0x0187 }
            java.lang.String r15 = "gameDeepLinkData:"
            r18 = 2
            r14[r18] = r15     // Catch:{ Exception -> 0x0187 }
            r15 = 3
            r14[r15] = r6     // Catch:{ Exception -> 0x0187 }
            r15 = 4
            java.lang.String r19 = "isAppOpen:"
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 5
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r22)     // Catch:{ Exception -> 0x0187 }
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 6
            java.lang.String r19 = "launchedGameId:"
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 7
            java.lang.Integer r19 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0187 }
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 8
            java.lang.String r19 = "installedPackageName:"
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 9
            r14[r15] = r11     // Catch:{ Exception -> 0x0187 }
            r15 = 10
            java.lang.String r19 = "isLaunchFromAppInstalled:"
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            r15 = 11
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0187 }
            r14[r15] = r19     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r14)     // Catch:{ Exception -> 0x0187 }
            boolean r14 = r1.isLaunchFromShortCut     // Catch:{ Exception -> 0x0187 }
            if (r14 != 0) goto L_0x0381
            if (r2 == 0) goto L_0x03a8
        L_0x0381:
            r1.mNotificationData = r6     // Catch:{ Exception -> 0x0187 }
            if (r22 == 0) goto L_0x03a8
            r1.emitDataToReact(r6)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x03a8
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0187 }
            if (r2 != 0) goto L_0x03a8
            boolean r2 = com.mpl.androidapp.utils.Util.isAppInstalled(r1, r11)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x03a8
            r2 = 1
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = "getDataFromNotification: Sending install event to react"
            r11 = 0
            r6[r11] = r2     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r6)     // Catch:{ Exception -> 0x0187 }
            com.facebook.react.bridge.ReactContext r2 = r1.mReactContext     // Catch:{ Exception -> 0x0187 }
            java.lang.String r6 = "Install Succeeded!"
            com.mpl.androidapp.utils.CommonUtils.sendInstallStatusToReact(r2, r6, r3)     // Catch:{ Exception -> 0x0187 }
        L_0x03a8:
            if (r0 == 0) goto L_0x03c3
            boolean r2 = r0.hasExtra(r5)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x03c3
            java.lang.String r2 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x0187 }
            java.lang.String r3 = "Time To Send"
            r5 = 0
            long r5 = r0.getLongExtra(r3, r5)     // Catch:{ Exception -> 0x0187 }
            org.json.JSONObject r2 = r1.getEventProps(r2, r5)     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendLocalNotificationClickEvent(r2)     // Catch:{ Exception -> 0x0187 }
        L_0x03c3:
            if (r0 == 0) goto L_0x03f1
            boolean r2 = r0.hasExtra(r10)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x03f1
            r2 = -1
            int r3 = r0.getIntExtra(r10, r2)     // Catch:{ Exception -> 0x0187 }
            r2 = 2
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03ef }
            java.lang.String r2 = "getDataFromNotification: from intent "
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x0187 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0187 }
            r6 = 1
            r5[r6] = r2     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r5)     // Catch:{ Exception -> 0x0187 }
            r2 = -1
            if (r3 == r2) goto L_0x03fc
            java.lang.Object r2 = r1.getSystemService(r8)     // Catch:{ Exception -> 0x0187 }
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2     // Catch:{ Exception -> 0x0187 }
            r2.cancel(r3)     // Catch:{ Exception -> 0x0187 }
            goto L_0x03fc
        L_0x03ef:
            r0 = move-exception
            goto L_0x0441
        L_0x03f1:
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0187 }
            java.lang.String r2 = "getDataFromNotification: does not have notification id"
            r5 = 0
            r3[r5] = r2     // Catch:{ Exception -> 0x0187 }
            com.mpl.androidapp.utils.MLogger.d(r12, r3)     // Catch:{ Exception -> 0x0187 }
        L_0x03fc:
            if (r0 == 0) goto L_0x044e
            java.lang.String r2 = r21.getAction()     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x044e
            java.lang.String r2 = "com.mpl.androidapp.ADD_MONEY"
            java.lang.String r3 = r21.getAction()     // Catch:{ Exception -> 0x0187 }
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0187 }
            if (r2 == 0) goto L_0x044e
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0187 }
            r2.<init>()     // Catch:{ Exception -> 0x0187 }
            r2.put(r9, r7)     // Catch:{ Exception -> 0x0187 }
            boolean r3 = r0.hasExtra(r4)     // Catch:{ Exception -> 0x0187 }
            if (r3 == 0) goto L_0x042b
            r3 = 0
            boolean r0 = r0.getBooleanExtra(r4, r3)     // Catch:{ Exception -> 0x0187 }
            if (r0 == 0) goto L_0x042b
            java.lang.String r0 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"AddMoney\",\"param\":{}}}"
            r2.put(r13, r0)     // Catch:{ Exception -> 0x0187 }
            goto L_0x0430
        L_0x042b:
            java.lang.String r0 = "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Home\",\"param\":{}}}"
            r2.put(r13, r0)     // Catch:{ Exception -> 0x0187 }
        L_0x0430:
            if (r22 == 0) goto L_0x043a
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0187 }
            r1.emitDataToReact(r0)     // Catch:{ Exception -> 0x0187 }
            goto L_0x044e
        L_0x043a:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0187 }
            r1.mNotificationData = r0     // Catch:{ Exception -> 0x0187 }
            goto L_0x044e
        L_0x0441:
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "getDataFromNotification: "
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r0
            com.mpl.androidapp.utils.MLogger.e(r12, r2)
        L_0x044e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.getDataFromNotification(android.content.Intent, boolean):void");
    }

    private JSONObject getEventProps(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Type", str);
            jSONObject.put("Time To Click", Calendar.getInstance().getTimeInMillis());
            jSONObject.put("Time Gap", Calendar.getInstance().getTimeInMillis() - j);
            jSONObject.put("Game ID", MBuildConfigUtils.getLaunchingGameId());
            jSONObject.put("Game Name", CommonUtils.getGameNameForID(MBuildConfigUtils.getLaunchingGameId()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0220 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.ReactInstanceManager getReactInstanceManager() {
        /*
            r24 = this;
            r0 = r24
            com.facebook.internal.CallbackManagerImpl r1 = new com.facebook.internal.CallbackManagerImpl
            r1.<init>()
            r0.mCallbackManager = r1
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.content.Context r1 = r24.getApplicationContext()
            r3 = r1
            com.mpl.androidapp.MPLApplication r3 = (com.mpl.androidapp.MPLApplication) r3
            r1 = 7
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.String r4 = "getReactInstanceManager: "
            r1[r2] = r4
            r5 = 1
            java.lang.String r6 = "getServiceUrl: "
            r1[r5] = r6
            java.lang.String r6 = com.microsoft.codepush.react.CodePush.mServerUrl
            r7 = 2
            r1[r7] = r6
            r6 = 3
            java.lang.String r7 = "isUsingTestConfiguration: "
            r1[r6] = r7
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r7 = 4
            r1[r7] = r6
            r6 = 5
            java.lang.String r7 = "Code push app version ::"
            r1[r6] = r7
            java.lang.String r7 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionNameForCodePush()
            r8 = 6
            r1[r8] = r7
            java.lang.String r7 = "MPLReactContainerActivity"
            com.mpl.androidapp.utils.MLogger.d(r7, r1)
            java.lang.String r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getCurrentAppVersionNameForCodePush()
            com.microsoft.codepush.react.CodePush.sAppVersion = r1
            java.lang.String r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getCodePushApiKey()
            org.json.JSONObject r8 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            if (r8 == 0) goto L_0x0062
            java.lang.String r10 = "react.codepush.key"
            java.lang.String r11 = r8.optString(r10)
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0062
            java.lang.String r1 = r8.optString(r10, r1)
        L_0x0062:
            com.microsoft.codepush.react.CodePush r8 = new com.microsoft.codepush.react.CodePush
            android.content.Context r10 = r24.getApplicationContext()
            r8.<init>(r1, r10, r2)
            com.microsoft.codepush.react.CodePush r10 = com.microsoft.codepush.react.CodePush.mCurrentInstance
            if (r10 == 0) goto L_0x0246
            java.lang.String r11 = "codepushapp.bundle"
            java.lang.String r10 = r10.getJSBundleFileInternal(r11)
            java.lang.String r11 = "assets://codepushapp.bundle"
            boolean r11 = r11.equals(r10)
            java.lang.String r12 = "assets://"
            if (r11 == 0) goto L_0x00b7
            boolean r11 = com.mpl.androidapp.updater.interactor.FileInteractor.isLoadFromAssets(r24)
            if (r11 == 0) goto L_0x0088
            java.lang.String r11 = "assets://bundle/app.bundle"
            goto L_0x00be
        L_0x0088:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r13 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()
            long r13 = (long) r13
            java.lang.String r13 = com.mpl.androidapp.utils.FileUtils.getRNExtractOrDownloadDirPath(r0, r13)
            r11.append(r13)
            java.lang.String r13 = java.io.File.separator
            r11.append(r13)
            java.lang.String r13 = "reactapp"
            r11.append(r13)
            java.lang.String r13 = java.io.File.separator
            java.lang.String r14 = "app.bundle"
            java.lang.String r11 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r11, r13, r14)
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x00b2
            goto L_0x00be
        L_0x00b2:
            com.facebook.react.bridge.JSBundleLoader r11 = com.facebook.react.bridge.JSBundleLoader.createFileLoader(r11)
            goto L_0x00c4
        L_0x00b7:
            boolean r11 = r10.startsWith(r12)
            if (r11 == 0) goto L_0x00c0
            r11 = r10
        L_0x00be:
            r12 = 0
            goto L_0x00ca
        L_0x00c0:
            com.facebook.react.bridge.JSBundleLoader r11 = com.facebook.react.bridge.JSBundleLoader.createFileLoader(r10)
        L_0x00c4:
            r12 = 0
            r23 = r12
            r12 = r11
            r11 = r23
        L_0x00ca:
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r4
            java.lang.String r4 = "developmentKey: "
            r6[r5] = r4
            r4 = 2
            r6[r4] = r1
            java.lang.String r1 = "jsBundleFileName: "
            r4 = 3
            r6[r4] = r1
            r1 = 4
            r6[r1] = r10
            com.mpl.androidapp.utils.MLogger.d(r7, r6)
            com.facebook.react.shell.MainReactPackage r1 = new com.facebook.react.shell.MainReactPackage
            r1.<init>()
            r9.add(r1)
            io.sentry.react.RNSentryPackage r1 = new io.sentry.react.RNSentryPackage
            r1.<init>()
            r9.add(r1)
            com.BV.LinearGradient.LinearGradientPackage r1 = new com.BV.LinearGradient.LinearGradientPackage
            r1.<init>()
            r9.add(r1)
            com.AlexanderZaytsev.RNI18n.RNI18nPackage r1 = new com.AlexanderZaytsev.RNI18n.RNI18nPackage
            r1.<init>()
            r9.add(r1)
            com.reactnative.ivpusic.imagepicker.PickerPackage r1 = new com.reactnative.ivpusic.imagepicker.PickerPackage
            r1.<init>()
            r9.add(r1)
            com.dylanvann.fastimage.FastImageViewPackage r1 = new com.dylanvann.fastimage.FastImageViewPackage
            r1.<init>()
            r9.add(r1)
            com.RNFetchBlob.RNFetchBlobPackage r1 = new com.RNFetchBlob.RNFetchBlobPackage
            r1.<init>()
            r9.add(r1)
            com.mpl.androidapp.react.RNPackages r1 = new com.mpl.androidapp.react.RNPackages
            r1.<init>()
            r9.add(r1)
            com.como.RNTScratchView.ScratchViewPackage r1 = new com.como.RNTScratchView.ScratchViewPackage
            r1.<init>()
            r9.add(r1)
            com.reactnativecommunity.netinfo.NetInfoPackage r1 = new com.reactnativecommunity.netinfo.NetInfoPackage
            r1.<init>()
            r9.add(r1)
            com.reactnativecommunity.asyncstorage.AsyncStoragePackage r1 = new com.reactnativecommunity.asyncstorage.AsyncStoragePackage
            r1.<init>()
            r9.add(r1)
            com.reactnativecommunity.webview.RNCWebViewPackage r1 = new com.reactnativecommunity.webview.RNCWebViewPackage
            r1.<init>()
            r9.add(r1)
            com.rnfs.RNFSPackage r1 = new com.rnfs.RNFSPackage
            r1.<init>()
            r9.add(r1)
            iyegoroff.RNColorMatrixImageFilters.ColorMatrixImageFiltersPackage r1 = new iyegoroff.RNColorMatrixImageFilters.ColorMatrixImageFiltersPackage
            r1.<init>()
            r9.add(r1)
            com.reactnativecommunity.picker.RNCPickerPackage r1 = new com.reactnativecommunity.picker.RNCPickerPackage
            r1.<init>()
            r9.add(r1)
            com.nozbe.watermelondb.WatermelonDBPackage r1 = new com.nozbe.watermelondb.WatermelonDBPackage
            r1.<init>()
            r9.add(r1)
            com.airbnb.android.react.lottie.LottiePackage r1 = new com.airbnb.android.react.lottie.LottiePackage
            r1.<init>()
            r9.add(r1)
            com.swmansion.gesturehandler.RNGestureHandlerPackage r1 = new com.swmansion.gesturehandler.RNGestureHandlerPackage
            r1.<init>()
            r9.add(r1)
            com.swmansion.reanimated.ReanimatedPackage r1 = new com.swmansion.reanimated.ReanimatedPackage
            r1.<init>()
            r9.add(r1)
            com.oblador.shimmer.RNShimmerPackage r1 = new com.oblador.shimmer.RNShimmerPackage
            r1.<init>()
            r9.add(r1)
            co.apptailor.googlesignin.RNGoogleSigninPackage r1 = new co.apptailor.googlesignin.RNGoogleSigninPackage
            r1.<init>()
            r9.add(r1)
            com.swmansion.rnscreens.RNScreensPackage r1 = new com.swmansion.rnscreens.RNScreensPackage
            r1.<init>()
            r9.add(r1)
            com.th3rdwave.safeareacontext.SafeAreaContextPackage r1 = new com.th3rdwave.safeareacontext.SafeAreaContextPackage
            r1.<init>()
            r9.add(r1)
            org.reactnative.maskedview.RNCMaskedViewPackage r1 = new org.reactnative.maskedview.RNCMaskedViewPackage
            r1.<init>()
            r9.add(r1)
            com.reactnativecommunity.art.ARTPackage r1 = new com.reactnativecommunity.art.ARTPackage
            r1.<init>()
            r9.add(r1)
            com.facebook.reactnative.androidsdk.FBSDKPackage r1 = new com.facebook.reactnative.androidsdk.FBSDKPackage
            r1.<init>()
            r9.add(r1)
            com.brentvatne.react.ReactVideoPackage r1 = new com.brentvatne.react.ReactVideoPackage
            r1.<init>()
            r9.add(r1)
            com.inbrain.InBrainSurveysPackage r1 = new com.inbrain.InBrainSurveysPackage
            r1.<init>()
            r9.add(r1)
            com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerPackage r1 = new com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerPackage
            r1.<init>()
            r9.add(r1)
            r9.add(r8)
            com.userexperiorlib.react.RNUserExperiorPackage r1 = new com.userexperiorlib.react.RNUserExperiorPackage
            r1.<init>()
            r9.add(r1)
            com.facebook.hermes.reactexecutor.HermesExecutorFactory r6 = new com.facebook.hermes.reactexecutor.HermesExecutorFactory
            r6.<init>()
            boolean r10 = com.mpl.androidapp.utils.MBuildConfigUtils.isDebuggable()
            com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.BEFORE_CREATE
            java.lang.String r4 = "Application property has not been set with this builder"
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r3, r4)
            com.facebook.react.common.LifecycleState r4 = com.facebook.react.common.LifecycleState.RESUMED
            if (r1 != r4) goto L_0x01ed
            java.lang.String r4 = "Activity needs to be set if initial lifecycle state is resumed"
            r7 = 0
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r7, r4)
        L_0x01ed:
            if (r10 != 0) goto L_0x01f6
            if (r11 != 0) goto L_0x01f6
            if (r12 == 0) goto L_0x01f4
            goto L_0x01f6
        L_0x01f4:
            r4 = 0
            goto L_0x01f7
        L_0x01f6:
            r4 = 1
        L_0x01f7:
            java.lang.String r7 = "JS Bundle File or Asset URL has to be provided when dev support is disabled"
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertCondition(r4, r7)
            java.lang.String r4 = "Either MainModulePath or JS Bundle File needs to be provided"
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertCondition(r5, r4)
            com.facebook.react.uimanager.UIImplementationProvider r13 = new com.facebook.react.uimanager.UIImplementationProvider
            r13.<init>()
            r3.getPackageName()
            java.lang.String r4 = android.os.Build.FINGERPRINT
            java.lang.String r5 = "vbox"
            boolean r4 = r4.contains(r5)
            if (r4 == 0) goto L_0x0216
            java.lang.String r4 = android.os.Build.MODEL
            goto L_0x021a
        L_0x0216:
            java.lang.String r4 = android.os.Build.MODEL
            java.lang.String r4 = android.os.Build.VERSION.RELEASE
        L_0x021a:
            com.facebook.react.ReactInstanceManager r22 = new com.facebook.react.ReactInstanceManager
            r4 = 0
            r5 = 0
            if (r12 != 0) goto L_0x0228
            if (r11 == 0) goto L_0x0228
            com.facebook.react.bridge.JSBundleLoader r2 = com.facebook.react.bridge.JSBundleLoader.createAssetLoader(r3, r11, r2)
            r7 = r2
            goto L_0x0229
        L_0x0228:
            r7 = r12
        L_0x0229:
            r11 = 0
            java.lang.String r2 = "Initial lifecycle state was not set"
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.assertNotNull(r1, r2)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r20 = 0
            r21 = 0
            java.lang.String r8 = "index"
            r18 = 1
            r19 = -1
            r2 = r22
            r12 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r22
        L_0x0246:
            com.microsoft.codepush.react.CodePushNotInitializedException r1 = new com.microsoft.codepush.react.CodePushNotInitializedException
            java.lang.String r2 = "A CodePush instance has not been created yet. Have you added it to your app's list of ReactPackages?"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.getReactInstanceManager():com.facebook.react.ReactInstanceManager");
    }

    private String getWillData() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            String userProfile = MSharedPreferencesUtils.getUserProfile();
            JSONObject jSONObject5 = null;
            if (userProfile != null && !TextUtils.isEmpty(userProfile)) {
                jSONObject5 = new JSONObject(userProfile);
                jSONObject5.remove("mobileNumber");
                jSONObject5.remove("detailedProfile");
                jSONObject5.remove("avatars");
                jSONObject5.remove("referralCode");
                jSONObject5.remove("coverPhotos");
            }
            if (jSONObject5 != null) {
                jSONObject5.put("message", jSONObject5.optString("displayName", "") + " went offline");
                jSONObject5.put("lastSeen", Calendar.getInstance().getTimeInMillis());
                jSONObject5.put("online", false);
                jSONObject3.put("route", "UserProfileStatus");
                jSONObject3.put("param", jSONObject5);
                jSONObject2.put(OneSingnalConstant.PARAM_ACTION_TYPE, "nav");
                jSONObject2.put(OneSingnalConstant.PARAM_ACTION_PAYLOAD, jSONObject3);
                jSONObject.put("action", "MQTT_FOREGROUND");
                jSONObject.put("actionParams", jSONObject2);
                jSONObject.put("type", "USER_OFFLINE");
                jSONObject.put(MiPushMessage.KEY_MESSAGE_TYPE, "Offline Notify");
                jSONObject.put("userid", jSONObject5.optInt("id"));
                jSONObject.put("name", jSONObject5.optString("displayName"));
                jSONObject.put("avatar", jSONObject5.optString("avatar"));
                jSONObject.put("title", "Your friend " + jSONObject5.optString("displayName") + " Offline");
                StringBuilder sb = new StringBuilder();
                sb.append(jSONObject5.optString("displayName", ""));
                sb.append(" went Offline");
                jSONObject.put("message", sb.toString());
            }
            jSONObject4.put("message", jSONObject);
            jSONObject4.put("authToken", MSharedPreferencesUtils.getAccessUserToken());
            jSONObject4.put(SMTEventParamKeys.SMT_APP_VERSION, MBuildConfigUtils.getInstalledAppVersionCode());
            jSONObject4.put(ConfigConstant.REACT_VERSION, DBInteractor.getCurrentRNBundleVersionCode());
            jSONObject4.put("state", "offline");
            jSONObject4.put("tier", MSharedPreferencesUtils.getUserTier());
            jSONObject4.put("sentTimeStamp", System.currentTimeMillis());
            jSONObject4.put(Constant.NOTIFICATION_TYPE, "USER_ONLINE");
            return jSONObject4.toString();
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void handleActionBannedApp() {
        boolean z;
        try {
            MLogger.d(TAG, "handleActionBannedApp: ");
            String[] strArr = Constant.BANNED_APPS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (Util.isAppInstalled(this, strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            Intent intent = new Intent(Constant.ACTION_BACKGROUND_TASK);
            intent.putExtra("taskName", "BannedAppCheck");
            intent.putExtra("isBannedAppPresent", z);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (Exception unused) {
            MLogger.e(TAG, "handleActionBannedApp: ");
        }
    }

    /* access modifiers changed from: private */
    public void handleActionGameCompetitorApp() {
        try {
            MLogger.d(TAG, "handleActionGameCompetitorApp: ");
            HashMap<String, String> hashMap = CommonUtils.GAME_COMPETITOR_APPS;
            hashMap.putAll(MSharedPreferencesUtils.getCompetitorAppsCheckList());
            StringBuilder sb = new StringBuilder();
            for (Entry next : hashMap.entrySet()) {
                if (Util.isAppInstalled(this, (String) next.getValue())) {
                    sb.append((String) next.getKey());
                    sb.append(",");
                }
            }
            if (!sb.toString().equals("")) {
                Intent intent = new Intent(Constant.ACTION_BACKGROUND_TASK);
                intent.putExtra("taskName", "GameCompetitorApp");
                intent.putExtra("isGameCompetitorAppPresent", true);
                intent.putExtra("gameCompetitorApps", sb.toString());
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "handleActionGameCompetitorApp");
        }
    }

    /* access modifiers changed from: private */
    public void handleActionGameTemperedApp() {
        boolean z;
        try {
            MLogger.d(TAG, "handleActionGameTemperedApp: ");
            String[] strArr = Constant.GAME_TAMPERED_APPS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (Util.isAppInstalled(this, strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            Intent intent = new Intent(Constant.ACTION_BACKGROUND_TASK);
            intent.putExtra("taskName", "GameTemperedApp");
            intent.putExtra("isGameTemperedAppPresent", z);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } catch (Exception unused) {
            MLogger.e(TAG, "handleActionGameTemperedApp");
        }
    }

    private void handleNotificationCancelOption() {
        String notificationCancelReceiverId = MSharedPreferencesUtils.getNotificationCancelReceiverId();
        if (notificationCancelReceiverId != null && notificationCancelReceiverId.length() > 0) {
            Intent intent = new Intent(Constant.NOTIFICATION_CANCELLED);
            intent.putExtra("game_id", Integer.valueOf(notificationCancelReceiverId));
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }

    private void handlePushNotificationActionButtonCallBack(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("actionId");
                if (string != null) {
                    MLogger.d(TAG, GeneratedOutlineSupport.outline50("ACTION_ID: ", string));
                    boolean z = extras.getBoolean("autoCancel", true);
                    int i = extras.getInt(Constant.NOTIFICATION_ID, -1);
                    if (z && i > -1) {
                        cancelNotification(i);
                    }
                    sendClickActionIdToReact(string);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03b1  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x044e A[Catch:{ Exception -> 0x0504 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0481 A[Catch:{ Exception -> 0x0504 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0549 A[Catch:{ AssertionError | Exception -> 0x055b }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0589  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x05a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01af A[LOOP:0: B:72:0x01a9->B:74:0x01af, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x027a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() {
        /*
            r29 = this;
            r1 = r29
            java.lang.String r2 = "react_init_timestamp"
            java.lang.String r3 = "actionId"
            java.lang.String r0 = "is_first_login_notification_schedued"
            java.lang.String r4 = "app_init_timestamp"
            boolean r5 = r1.isWarmLaunch
            java.lang.String r6 = "app_icon_click_time"
            java.lang.String r7 = "app_init_timestamp_v2"
            r8 = 0
            r9 = 1
            r10 = 0
            if (r5 != 0) goto L_0x0025
            long r11 = java.lang.System.currentTimeMillis()
            long r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getLongInNormalPref(r1, r8, r6, r11)
            java.lang.String r5 = java.lang.String.valueOf(r11)
            com.mpl.securepreferences.MPreferences.putString(r7, r5, r10)
            goto L_0x002c
        L_0x0025:
            java.lang.String r5 = "warm_launch"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r1, r5, r9)
            r1.isWarmLaunch = r10
        L_0x002c:
            com.mpl.androidapp.updater.repo.DownloadHelper r5 = com.mpl.androidapp.updater.repo.DownloadHelper.getInstance()
            android.content.Context r11 = r29.getApplicationContext()
            r5.checkCTFilterEvent(r11)
            java.lang.String r5 = com.mpl.androidapp.utils.MBuildConfigUtils.getBuildFlavor()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r11 = "production_oppo"
            boolean r5 = r5.contains(r11)     // Catch:{ Exception -> 0x0075 }
            if (r5 == 0) goto L_0x0054
            android.os.Handler r5 = new android.os.Handler     // Catch:{ Exception -> 0x0075 }
            r5.<init>()     // Catch:{ Exception -> 0x0075 }
            com.mpl.androidapp.react.-$$Lambda$MPLReactContainerActivity$N4O_hFakCbENbX_yxscYGJ79hts r11 = com.mpl.androidapp.react.$$Lambda$MPLReactContainerActivity$N4O_hFakCbENbX_yxscYGJ79hts.INSTANCE     // Catch:{ Exception -> 0x0075 }
            r12 = 10000(0x2710, double:4.9407E-320)
            r5.postDelayed(r11, r12)     // Catch:{ Exception -> 0x0075 }
            goto L_0x005b
        L_0x0054:
            com.mpl.androidapp.MPLApplication r5 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x0075 }
            com.mpl.androidapp.utils.FreshChatUtils.initFreshChat(r5)     // Catch:{ Exception -> 0x0075 }
        L_0x005b:
            r1.addScreenShotFileObserver(r1)     // Catch:{ Exception -> 0x0075 }
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendClevertapIDToFirebase()     // Catch:{ Exception -> 0x0075 }
            boolean r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUserLoggedIn()     // Catch:{ Exception -> 0x0075 }
            if (r5 != 0) goto L_0x0076
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0075 }
            r5.<init>()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r11 = "com.mpl.androidapp.deviceinfo.action.GOOGLE_ID"
            r5.add(r11)     // Catch:{ Exception -> 0x0075 }
            r1.startAppsCheckingTask(r5)     // Catch:{ Exception -> 0x0075 }
            goto L_0x0076
        L_0x0075:
        L_0x0076:
            long r11 = java.lang.System.currentTimeMillis()
            r5 = 2
            java.lang.Object[] r13 = new java.lang.Object[r5]
            java.lang.String r14 = "init:[START] "
            r13[r10] = r14
            java.lang.String r14 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAccessUserToken()
            r13[r9] = r14
            java.lang.String r14 = "AppLoading"
            com.mpl.androidapp.utils.MLogger.d(r14, r13)
            r13 = 6
            java.lang.Object[] r13 = new java.lang.Object[r13]
            java.lang.String r15 = "React initialization called: isReactInitHappened"
            r13[r10] = r15
            boolean r15 = r1.isReactInitHappened
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            r13[r9] = r15
            java.lang.String r15 = " mNotificationData: "
            r13[r5] = r15
            java.lang.String r15 = r1.mNotificationData
            r16 = 3
            r13[r16] = r15
            r15 = 4
            java.lang.String r17 = "isPostLoginCalledFromReact: "
            r13[r15] = r17
            boolean r18 = com.mpl.androidapp.config.ConfigManager.isPostLoginCalledFromReact()
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r18)
            r15 = 5
            r13[r15] = r18
            java.lang.String r15 = "MPLReactContainerActivity"
            com.mpl.androidapp.utils.MLogger.d(r15, r13)
            int r13 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()
            int r8 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentDownloadedRNBundleVersionCode()
            if (r13 == r8) goto L_0x00cb
            int r8 = com.mpl.androidapp.updater.interactor.DBInteractor.getCurrentRNBundleVersionCode()
            com.mpl.androidapp.updater.interactor.DBInteractor.setCurrentDownloadedRNBundleVersionCode(r8)
        L_0x00cb:
            com.mpl.androidapp.notification.NotificationBuilder r8 = new com.mpl.androidapp.notification.NotificationBuilder     // Catch:{ Exception -> 0x0112 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x0112 }
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isLoginReminderNotifEnabeled(r29)     // Catch:{ Exception -> 0x0112 }
            if (r13 == 0) goto L_0x00f0
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r0, r10)     // Catch:{ Exception -> 0x0112 }
            if (r13 != 0) goto L_0x00f0
            java.lang.String r13 = "isUserLoggedInV2"
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r13, r10)     // Catch:{ Exception -> 0x0112 }
            if (r13 != 0) goto L_0x00f0
            r20 = r11
            r10 = 300000(0x493e0, double:1.482197E-318)
            r8.createNotificationAlarmManagerForLogin(r10)     // Catch:{ Exception -> 0x0110 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r1, r0, r9)     // Catch:{ Exception -> 0x0110 }
            goto L_0x00f2
        L_0x00f0:
            r20 = r11
        L_0x00f2:
            java.lang.String r0 = r1.mNotificationData     // Catch:{ Exception -> 0x0110 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0110 }
            if (r0 != 0) goto L_0x00fe
            java.lang.String r0 = r1.mNotificationData     // Catch:{ Exception -> 0x0110 }
            if (r0 != 0) goto L_0x0121
        L_0x00fe:
            java.lang.String r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getDeepLinkForInstall()     // Catch:{ Exception -> 0x0110 }
            if (r0 == 0) goto L_0x0121
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0110 }
            if (r8 != 0) goto L_0x0121
            r1.mNotificationData = r0     // Catch:{ Exception -> 0x0110 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.removeDeepLinkForInstall()     // Catch:{ Exception -> 0x0110 }
            goto L_0x0121
        L_0x0110:
            r0 = move-exception
            goto L_0x0115
        L_0x0112:
            r0 = move-exception
            r20 = r11
        L_0x0115:
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.String r10 = "init: "
            r11 = 0
            r8[r11] = r10
            r8[r9] = r0
            com.mpl.androidapp.utils.MLogger.e(r15, r8)
        L_0x0121:
            boolean r0 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r0 == 0) goto L_0x012a
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.mpl.androidapp.utils.CommonUtils.hanselProConfigs
            goto L_0x012c
        L_0x012a:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = com.mpl.androidapp.utils.CommonUtils.hanselPlayStoreConfigs
        L_0x012c:
            org.json.JSONObject r0 = com.mpl.androidapp.utils.CleverTapAnalyticsUtils.getAllHanselConfigData(r0)
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.saveHanselExperienceData()
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.saveHanselExperienceVariantData()
            com.mpl.androidapp.config.ConfigManager.setHanselConfig(r0)
            com.facebook.react.ReactInstanceManager r0 = r1.mReactInstanceManager
            if (r0 != 0) goto L_0x0143
            com.facebook.react.ReactInstanceManager r0 = r29.getReactInstanceManager()
            r1.mReactInstanceManager = r0
        L_0x0143:
            com.facebook.react.ReactInstanceManager r0 = r1.mReactInstanceManager
            if (r0 == 0) goto L_0x016a
            com.facebook.react.bridge.ReactContext r8 = r1.mReactContext
            if (r8 != 0) goto L_0x0151
            com.facebook.react.bridge.ReactContext r0 = r0.getCurrentReactContext()
            r1.mReactContext = r0
        L_0x0151:
            com.facebook.react.bridge.ReactContext r0 = r1.mReactContext
            if (r0 == 0) goto L_0x0163
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r8 = r1.reactEmitter
            if (r8 != 0) goto L_0x0163
            java.lang.Class<com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter> r8 = com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter.class
            com.facebook.react.bridge.JavaScriptModule r0 = r0.getJSModule(r8)
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r0 = (com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r0
            r1.reactEmitter = r0
        L_0x0163:
            com.facebook.react.ReactInstanceManager r0 = r1.mReactInstanceManager
            java.util.Collection<com.facebook.react.ReactInstanceManager$ReactInstanceEventListener> r0 = r0.mReactInstanceEventListeners
            r0.add(r1)
        L_0x016a:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            org.json.JSONObject r8 = com.mpl.androidapp.config.ConfigManager.getNormalConfig()
            java.lang.String r10 = ""
            if (r8 == 0) goto L_0x01cb
            java.lang.String r11 = "nostra"
            boolean r12 = r8.has(r11)
            if (r12 == 0) goto L_0x01cb
            org.json.JSONObject r12 = r8.optJSONObject(r11)
            if (r12 == 0) goto L_0x01cb
            org.json.JSONObject r12 = r8.optJSONObject(r11)
            java.lang.String r13 = "device.check.enabled"
            boolean r12 = r12.optBoolean(r13)
            if (r12 == 0) goto L_0x01cb
            org.json.JSONObject r11 = r8.optJSONObject(r11)
            java.lang.String r12 = "deviceList"
            org.json.JSONArray r11 = r11.optJSONArray(r12)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            if (r11 == 0) goto L_0x01b9
            int r13 = r11.length()
            if (r13 <= 0) goto L_0x01b9
            r13 = 0
        L_0x01a9:
            int r5 = r11.length()
            if (r13 >= r5) goto L_0x01b9
            java.lang.String r5 = r11.optString(r13, r10)
            r12.add(r5)
            int r13 = r13 + 1
            goto L_0x01a9
        L_0x01b9:
            java.lang.String r5 = android.os.Build.MODEL
            if (r5 == 0) goto L_0x01cb
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x01cb
            java.lang.String r5 = android.os.Build.MODEL
            boolean r5 = r12.contains(r5)
            r5 = r5 ^ r9
            goto L_0x01cc
        L_0x01cb:
            r5 = 1
        L_0x01cc:
            java.lang.String r11 = "shouldShowNostra"
            r0.putBoolean(r11, r5)
            android.content.Context r5 = r29.getApplicationContext()
            boolean r5 = com.mpl.androidapp.utils.Util.isTrueCallerPresent(r5)
            java.lang.String r11 = "is_true_caller_present"
            r0.putBoolean(r11, r5)
            com.mpl.analytics.MPLAnalytics r5 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            java.lang.String r5 = r5.getCleverTapId()
            java.lang.String r11 = "clever_tap_id"
            r0.putString(r11, r5)
            android.content.Context r5 = r29.getApplicationContext()
            boolean r5 = com.mpl.androidapp.utils.Util.isWhatsappPresent(r5)
            java.lang.String r11 = "is_whatsapp_present"
            r0.putBoolean(r11, r5)
            android.content.Context r5 = r29.getApplicationContext()
            boolean r5 = com.mpl.androidapp.utils.Util.isTwitterPresent(r5)
            java.lang.String r11 = "is_twitter_present"
            r0.putBoolean(r11, r5)
            android.content.Context r5 = r29.getApplicationContext()
            boolean r5 = com.mpl.androidapp.utils.Util.isFacebookPresent(r5)
            java.lang.String r11 = "is_facebook_present"
            r0.putBoolean(r11, r5)
            android.content.Context r5 = r29.getApplicationContext()
            boolean r5 = com.mpl.androidapp.utils.Util.isYouTubeappPresent(r5)
            java.lang.String r11 = "is_youtube_present"
            r0.putBoolean(r11, r5)
            java.lang.String r5 = "com.instagram.android"
            boolean r5 = com.mpl.androidapp.utils.Util.isAppInstalled(r1, r5)
            java.lang.String r11 = "is_instagram_present"
            r0.putBoolean(r11, r5)
            java.lang.String r5 = "com.facebook.orca"
            boolean r5 = com.mpl.androidapp.utils.Util.isAppInstalled(r1, r5)
            java.lang.String r11 = "is_fb_messenger_present"
            r0.putBoolean(r11, r5)
            java.lang.String r5 = "org.telegram.messenger"
            boolean r5 = com.mpl.androidapp.utils.Util.isAppInstalled(r1, r5)
            java.lang.String r11 = "is_telegram_present"
            r0.putBoolean(r11, r5)
            java.lang.String r5 = "com.google.android.apps.nbu.paisa.user"
            boolean r5 = com.mpl.androidapp.utils.Util.isAppInstalled(r1, r5)
            java.lang.String r11 = "is_gpay_present"
            r0.putBoolean(r11, r5)
            com.appsflyer.AppsFlyerLib r5 = com.appsflyer.AppsFlyerLib.getInstance()
            com.mpl.androidapp.MPLApplication r11 = com.mpl.androidapp.MPLApplication.getInstance()
            java.lang.String r5 = r5.getAppsFlyerUID(r11)
            java.lang.String r11 = "appsflyer_uid"
            r0.putString(r11, r5)
            java.lang.String r5 = com.mpl.androidapp.utils.MBuildConfigUtils.getWebClientID()
            java.lang.String r11 = "webClientId"
            r0.putString(r11, r5)
            boolean r5 = com.mpl.androidapp.utils.MBuildConfigUtils.isSandboxMoneyInEnable()
            java.lang.String r11 = "isSandboxMoneyInEnabled"
            r0.putBoolean(r11, r5)
            java.lang.String r5 = r1.mNotificationData
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r11 = "true"
            java.lang.String r12 = "is_notification_data_present"
            if (r5 != 0) goto L_0x02db
            r0.putBoolean(r12, r9)
            java.lang.String r5 = r1.mNotificationData
            java.lang.String r12 = "notification_data"
            r0.putString(r12, r5)
            java.lang.String r5 = r1.mNotificationData     // Catch:{ Exception -> 0x02d9 }
            boolean r5 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r5)     // Catch:{ Exception -> 0x02d9 }
            if (r5 == 0) goto L_0x02aa
            java.lang.String r5 = r1.mNotificationData     // Catch:{ Exception -> 0x02d9 }
            boolean r5 = isAppsFlyerDeepLinkData(r5)     // Catch:{ Exception -> 0x02d9 }
            if (r5 != 0) goto L_0x02aa
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x02d9 }
            java.lang.String r12 = r1.mNotificationData     // Catch:{ Exception -> 0x02d9 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x02d9 }
            java.lang.String r12 = "shouldSendEvent"
            java.lang.String r12 = r5.optString(r12, r11)     // Catch:{ Exception -> 0x02d9 }
            boolean r12 = java.lang.Boolean.parseBoolean(r12)     // Catch:{ Exception -> 0x02d9 }
            if (r12 == 0) goto L_0x02aa
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendNotificationClickEvent(r5)     // Catch:{ Exception -> 0x02d9 }
        L_0x02aa:
            java.lang.String r5 = r1.mNotificationData     // Catch:{ Exception -> 0x02d9 }
            boolean r5 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r5)     // Catch:{ Exception -> 0x02d9 }
            if (r5 == 0) goto L_0x02d5
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x02d9 }
            java.lang.String r12 = r1.mNotificationData     // Catch:{ Exception -> 0x02d9 }
            r5.<init>(r12)     // Catch:{ Exception -> 0x02d9 }
            boolean r12 = r5.has(r3)     // Catch:{ Exception -> 0x02d9 }
            if (r12 == 0) goto L_0x02d5
            java.lang.String r3 = r5.getString(r3)     // Catch:{ Exception -> 0x02d9 }
            r1.actionId = r3     // Catch:{ Exception -> 0x02d9 }
            java.lang.String r3 = "notificationId"
            boolean r3 = r5.has(r3)     // Catch:{ Exception -> 0x02d9 }
            if (r3 == 0) goto L_0x02d5
            java.lang.String r3 = "notificationId"
            int r3 = r5.getInt(r3)     // Catch:{ Exception -> 0x02d9 }
            r1.notificationId = r3     // Catch:{ Exception -> 0x02d9 }
        L_0x02d5:
            r3 = 0
            r1.mNotificationData = r3     // Catch:{ Exception -> 0x02d9 }
            goto L_0x02df
        L_0x02d9:
            goto L_0x02df
        L_0x02db:
            r3 = 0
            r0.putBoolean(r12, r3)
        L_0x02df:
            boolean r3 = r1.isLaunchFromShortCut
            java.lang.String r5 = "launched_from_shortcut"
            r0.putBoolean(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getReferralBranch()
            java.lang.String r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getReferralSourceBranch()
            java.lang.String r12 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAFReferralCode()
            java.lang.String r22 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAFReferralSource()
            java.lang.String r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAFSignupSource()
            boolean r25 = android.text.TextUtils.isEmpty(r12)
            if (r25 == 0) goto L_0x0301
            goto L_0x0302
        L_0x0301:
            r3 = r12
        L_0x0302:
            boolean r12 = android.text.TextUtils.isEmpty(r22)
            if (r12 == 0) goto L_0x0309
            goto L_0x030b
        L_0x0309:
            r5 = r22
        L_0x030b:
            r12 = 4
            java.lang.Object[] r9 = new java.lang.Object[r12]
            java.lang.String r12 = "init: referralCode "
            r24 = 0
            r9[r24] = r12
            r12 = 1
            r9[r12] = r3
            java.lang.String r12 = "referralSource"
            r23 = 2
            r9[r23] = r12
            r9[r16] = r5
            com.mpl.androidapp.utils.MLogger.d(r15, r9)
            java.lang.String r9 = "refferreral"
            r0.putString(r9, r3)
            java.lang.String r3 = "referral_source"
            r0.putString(r3, r5)
            java.lang.String r3 = "signup_source"
            r0.putString(r3, r13)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getOneSignalId()
            java.lang.String r5 = "one_signal_id"
            r0.putString(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getOneSignalPushToken()
            java.lang.String r5 = "one_signal_push_token"
            r0.putString(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getConfigJson()
            java.lang.String r5 = "configJson"
            r0.putString(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getPlatConfigJson()
            java.lang.String r5 = "platformConfigJson"
            r0.putString(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getHanselConfig()
            java.lang.String r5 = "hanselJson"
            r0.putString(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getCountryConfig()
            java.lang.String r5 = "countryConfigJson"
            r0.putString(r5, r3)
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUserLoggedInTokenAvailable()
            java.lang.String r5 = "is_user_logged_in"
            r0.putBoolean(r5, r3)
            java.lang.String r3 = "fetchLoginInfo"
            r5 = 0
            r0.putBoolean(r3, r5)
            java.lang.String r3 = "isMPLReactLogin"
            r5 = 1
            r0.putBoolean(r3, r5)
            java.lang.String r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getApkType()
            java.lang.String r9 = "apkType"
            r0.putString(r9, r3)
            boolean r3 = r1.isSubmitScoreRequire
            r3 = r3 ^ r5
            java.lang.String r5 = "can_show_thumbs_up"
            r0.putBoolean(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGoogleKey()
            java.lang.String r5 = "googleApiKey"
            r0.putString(r5, r3)
            int r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getLaunchingGameId()
            java.lang.String r5 = "game_id"
            r0.putInt(r5, r3)
            java.lang.String r3 = "userUid"
            java.lang.String r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r1, r3, r10)
            r0.putString(r3, r5)
            java.lang.String r3 = "shared_pref_should_show_release_notes"
            r13 = 0
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r3, r13)
            if (r3 == 0) goto L_0x03b9
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isNewUpdaterChangeRequired()
            if (r3 == 0) goto L_0x03b9
            r3 = 1
            goto L_0x03ba
        L_0x03b9:
            r3 = 0
        L_0x03ba:
            boolean r5 = com.mpl.androidapp.utils.Util.isApkUpdated()
            r9 = 5
            java.lang.Object[] r12 = new java.lang.Object[r9]
            java.lang.String r9 = "init:isReleaseNoteRequired "
            r12[r13] = r9
            java.lang.String r9 = "isReleaseNoteRequired: "
            r22 = 1
            r12[r22] = r9
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            r23 = 2
            r12[r23] = r9
            java.lang.String r9 = "isApkUpdated:"
            r12[r16] = r9
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            r19 = 4
            r12[r19] = r9
            com.mpl.androidapp.utils.MLogger.d(r14, r12)
            if (r3 == 0) goto L_0x03ef
            if (r5 == 0) goto L_0x03ef
            java.lang.String r3 = "releaseNotes"
            java.lang.String r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r1, r3, r10)
            r0.putString(r3, r5)
        L_0x03ef:
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isGameEnableForDevice()
            java.lang.String r5 = "isBumpEnabledForDevice"
            r0.putBoolean(r5, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGameListToBlockBasedOnRam()
            java.lang.String r5 = "gameListToBlock"
            r0.putString(r5, r3)
            long r24 = java.lang.System.currentTimeMillis()
            long r26 = java.lang.System.currentTimeMillis()
            r3 = r14
            long r13 = java.lang.System.currentTimeMillis()
            r9 = 0
            long r5 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getLongInNormalPref(r1, r9, r6, r13)     // Catch:{ Exception -> 0x04fa }
            java.lang.String r9 = java.lang.String.valueOf(r26)     // Catch:{ Exception -> 0x04f1 }
            r12 = 0
            java.lang.String r7 = com.mpl.securepreferences.MPreferences.getString(r7, r9, r12)     // Catch:{ Exception -> 0x04f1 }
            r26 = r13
            long r12 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x04e7 }
            r7 = 1
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x04e7 }
            r14 = r8
            long r7 = r26 - r5
            java.lang.Long r25 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x04dd }
            r28 = r3
            r3 = 0
            r9[r3] = r25     // Catch:{ Exception -> 0x04df }
            com.mpl.androidapp.utils.MLogger.t(r1, r3, r9)     // Catch:{ Exception -> 0x04df }
            java.lang.String r9 = "skip_launch_data"
            boolean r3 = r1.skipLaunchData     // Catch:{ Exception -> 0x04df }
            r0.putBoolean(r9, r3)     // Catch:{ Exception -> 0x04df }
            r3 = r10
            r9 = r26
            r0.putLong(r2, r9)     // Catch:{ Exception -> 0x04e2 }
            r26 = r11
            java.lang.String r11 = "app_icon_click_time_v2"
            r27 = r14
            r14 = 0
            boolean r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r11, r14)     // Catch:{ Exception -> 0x0504 }
            if (r11 == 0) goto L_0x0481
            r0.putLong(r4, r12)     // Catch:{ Exception -> 0x0504 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0504 }
            r7.<init>()     // Catch:{ Exception -> 0x0504 }
            java.util.HashMap r7 = com.mpl.androidapp.utils.Util.jsonToMap(r7)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "cold_Launch"
            java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0504 }
            r7.put(r8, r11)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "android_Loading_Time"
            long r11 = r9 - r12
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x0504 }
            r7.put(r8, r13)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "android_loading_time"
            r0.putLong(r8, r11)     // Catch:{ Exception -> 0x0504 }
            r8 = 0
            java.util.HashMap r11 = com.mpl.androidapp.utils.CleverTapAnalyticsUtils.commonPropertiesForEvents(r8)     // Catch:{ Exception -> 0x0504 }
            r7.putAll(r11)     // Catch:{ Exception -> 0x0504 }
            com.mpl.androidapp.analytics.ExternalAnalytics r8 = com.mpl.androidapp.analytics.ExternalAnalytics.INSTANCE     // Catch:{ Exception -> 0x0504 }
            java.lang.String r11 = "ANDROID LOADING TIME"
            r8.sendKafkaEvent(r11, r7)     // Catch:{ Exception -> 0x0504 }
            goto L_0x04b1
        L_0x0481:
            r0.putLong(r4, r5)     // Catch:{ Exception -> 0x0504 }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x0504 }
            r11.<init>()     // Catch:{ Exception -> 0x0504 }
            java.util.HashMap r11 = com.mpl.androidapp.utils.Util.jsonToMap(r11)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r13 = "cold_Launch"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0504 }
            r11.put(r13, r14)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r13 = "android_Loading_Time"
            java.lang.Long r14 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0504 }
            r11.put(r13, r14)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r13 = "android_loading_time"
            r0.putLong(r13, r7)     // Catch:{ Exception -> 0x0504 }
            r7 = 0
            java.util.HashMap r8 = com.mpl.androidapp.utils.CleverTapAnalyticsUtils.commonPropertiesForEvents(r7)     // Catch:{ Exception -> 0x0504 }
            r11.putAll(r8)     // Catch:{ Exception -> 0x0504 }
            com.mpl.androidapp.analytics.ExternalAnalytics r8 = com.mpl.androidapp.analytics.ExternalAnalytics.INSTANCE     // Catch:{ Exception -> 0x0504 }
            java.lang.String r12 = "ANDROID LOADING TIME"
            r8.sendKafkaEvent(r12, r11)     // Catch:{ Exception -> 0x0504 }
        L_0x04b1:
            java.lang.String r8 = "react_process_start_from_android"
            long r11 = r1.reactStartProcess     // Catch:{ Exception -> 0x0504 }
            long r13 = r9 - r11
            r0.putLong(r8, r13)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "declutter_enabled"
            java.lang.String r11 = "declutter_enabled"
            r7 = 0
            boolean r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r11, r7)     // Catch:{ Exception -> 0x0504 }
            r0.putBoolean(r8, r11)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "is_ia_enabled"
            java.lang.String r11 = "is_ia_enabled"
            boolean r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r11, r7)     // Catch:{ Exception -> 0x0504 }
            r0.putBoolean(r8, r11)     // Catch:{ Exception -> 0x0504 }
            java.lang.String r8 = "declutter_ia_enabled"
            java.lang.String r11 = "declutter_ia_enabled"
            boolean r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r1, r11, r7)     // Catch:{ Exception -> 0x0504 }
            r0.putBoolean(r8, r11)     // Catch:{ Exception -> 0x0504 }
            goto L_0x050a
        L_0x04dd:
            r28 = r3
        L_0x04df:
            r3 = r10
            r9 = r26
        L_0x04e2:
            r26 = r11
        L_0x04e4:
            r27 = r14
            goto L_0x0504
        L_0x04e7:
            r28 = r3
            r3 = r10
            r9 = r26
            r27 = r8
            r26 = r11
            goto L_0x0504
        L_0x04f1:
            r28 = r3
            r27 = r8
            r3 = r10
            r26 = r11
            r9 = r13
            goto L_0x0504
        L_0x04fa:
            r28 = r3
            r27 = r8
            r3 = r10
            r26 = r11
            r9 = r13
            r5 = r24
        L_0x0504:
            r0.putLong(r4, r5)
            r0.putLong(r2, r9)
        L_0x050a:
            java.lang.Long r2 = r1.reactContainerOnCreateTime
            long r4 = r2.longValue()
            java.lang.String r2 = "reactContainerOnCreateTime"
            r0.putLong(r2, r4)
            java.lang.String r2 = "TimeTaken"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ AssertionError | Exception -> 0x055b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError | Exception -> 0x055b }
            r4.<init>()     // Catch:{ AssertionError | Exception -> 0x055b }
            java.lang.String r6 = "Load Time: start react"
            r4.append(r6)     // Catch:{ AssertionError | Exception -> 0x055b }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ AssertionError | Exception -> 0x055b }
            long r10 = r1.initTime     // Catch:{ AssertionError | Exception -> 0x055b }
            long r8 = r8 - r10
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ AssertionError | Exception -> 0x055b }
            r4.append(r6)     // Catch:{ AssertionError | Exception -> 0x055b }
            java.lang.String r4 = r4.toString()     // Catch:{ AssertionError | Exception -> 0x055b }
            r6 = 0
            r5[r6] = r4     // Catch:{ AssertionError | Exception -> 0x055b }
            com.mpl.androidapp.utils.MLogger.i(r2, r5)     // Catch:{ AssertionError | Exception -> 0x055b }
            com.facebook.react.ReactRootView r2 = r1.mReactRootView     // Catch:{ AssertionError | Exception -> 0x055b }
            com.facebook.react.ReactInstanceManager r4 = r1.mReactInstanceManager     // Catch:{ AssertionError | Exception -> 0x055b }
            java.lang.String r5 = "reactapp"
            r2.startReactApplication(r4, r5, r0)     // Catch:{ AssertionError | Exception -> 0x055b }
            com.facebook.react.ReactInstanceManager r0 = r1.mReactInstanceManager     // Catch:{ AssertionError | Exception -> 0x055b }
            if (r0 == 0) goto L_0x054e
            com.facebook.react.ReactInstanceManager r0 = r1.mReactInstanceManager     // Catch:{ AssertionError | Exception -> 0x055b }
            r0.onHostResume(r1, r1)     // Catch:{ AssertionError | Exception -> 0x055b }
        L_0x054e:
            java.lang.String r0 = "perfopt"
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ AssertionError | Exception -> 0x055b }
            java.lang.String r2 = "init() end "
            r5 = 0
            r4[r5] = r2     // Catch:{ AssertionError | Exception -> 0x055b }
            com.mpl.androidapp.utils.MLogger.d(r0, r4)     // Catch:{ AssertionError | Exception -> 0x055b }
        L_0x055b:
            r2 = 5
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r2 = 0
            r0[r2] = r15
            java.lang.String r2 = "saving notification data:-->8 "
            r4 = 1
            r0[r4] = r2
            java.lang.String r2 = r1.mNotificationData
            if (r2 == 0) goto L_0x056b
            goto L_0x056d
        L_0x056b:
            java.lang.String r2 = "Notification data is null"
        L_0x056d:
            r4 = 2
            r0[r4] = r2
            r0[r16] = r17
            boolean r2 = com.mpl.androidapp.config.ConfigManager.isPostLoginCalledFromReact()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4 = 4
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r15, r0)
            r2 = 1
            r1.isReactInitHappened = r2
            boolean r0 = com.mpl.androidapp.config.ConfigManager.isPostLoginCalledFromReact()
            if (r0 != 0) goto L_0x058c
            r2 = 0
            r1.mNotificationData = r2
        L_0x058c:
            com.mpl.androidapp.utils.CommonUtils.deleteToSDFile(r29)     // Catch:{ Exception -> 0x0596 }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.removeDeepLinkForInstall()     // Catch:{ Exception -> 0x0596 }
            r29.initAnalyticsHelper()     // Catch:{ Exception -> 0x0596 }
            goto L_0x05a3
        L_0x0596:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r2 = 0
            r4[r2] = r3
            r2 = 1
            r4[r2] = r0
            com.mpl.androidapp.utils.MLogger.e(r15, r4)
        L_0x05a3:
            if (r27 == 0) goto L_0x0669
            java.lang.String r0 = "rgtSessionTimeoutMinutes"
            r2 = r27
            boolean r0 = r2.has(r0)
            if (r0 == 0) goto L_0x0669
            java.lang.String r0 = "rgtPrimaryWarningIntervalMinutes"
            boolean r0 = r2.has(r0)
            if (r0 == 0) goto L_0x0669
            java.lang.String r0 = "rgtSecondaryWarningIntervalMinutes"
            boolean r0 = r2.has(r0)
            if (r0 == 0) goto L_0x0669
            java.lang.String r0 = "rgtMaxWarningCount"
            boolean r0 = r2.has(r0)
            if (r0 == 0) goto L_0x0669
            java.lang.String r0 = "rgtIsRespGameTimerOnV2"
            boolean r0 = r2.has(r0)
            if (r0 == 0) goto L_0x0669
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = "got rg configs from sever"
            r4 = 0
            r0[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r15, r0)
            com.mpl.androidapp.responsiblegaming.RgConfigs r0 = new com.mpl.androidapp.responsiblegaming.RgConfigs
            r0.<init>()
            r3 = 15
            java.lang.String r4 = "rgtSessionTimeoutMinutes"
            int r3 = r2.optInt(r4, r3)
            r0.setSessionTimeOutMinutes(r3)
            r3 = 300(0x12c, float:4.2E-43)
            java.lang.String r4 = "rgtPrimaryWarningIntervalMinutes"
            int r3 = r2.optInt(r4, r3)
            r0.setPrimaryWarningIntervalMinutes(r3)
            r3 = 60
            java.lang.String r4 = "rgtSecondaryWarningIntervalMinutes"
            int r3 = r2.optInt(r4, r3)
            r0.setSecondaryWarningIntervalMinutes(r3)
            java.lang.String r3 = "rgtMaxWarningCount"
            r4 = 4
            int r3 = r2.optInt(r3, r4)
            r0.setMaxWarningCount(r3)
            java.lang.String r3 = "rgtIsRespGameTimerOnV2"
            java.lang.String r4 = "false"
            java.lang.String r2 = r2.optString(r3, r4)
            r0.setIsRgGamingOn(r2)
            java.lang.String r2 = r0.getIsRgGamingOn()
            r3 = r26
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0653
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r2 = "init rgSessionmanager in reactContainerActivity"
            r4 = 0
            r3[r4] = r2
            java.lang.String r2 = "ResponsibleGamingTimer"
            com.mpl.androidapp.utils.MLogger.d(r2, r3)
            com.mpl.androidapp.responsiblegaming.RgSessionManager r2 = com.mpl.androidapp.MPLApplication.getRgSessionManager()
            int r3 = r0.getSessionTimeOutMinutes()
            int r4 = r0.getPrimaryWarningIntervalMinutes()
            int r5 = r0.getSecondaryWarningIntervalMinutes()
            int r6 = r0.getMaxWarningCount()
            r2.initConfig(r3, r4, r5, r6)
            com.mpl.androidapp.responsiblegaming.RgSessionManager r2 = com.mpl.androidapp.MPLApplication.getRgSessionManager()
            if (r2 == 0) goto L_0x0665
            com.mpl.androidapp.responsiblegaming.RgSessionManager r2 = com.mpl.androidapp.MPLApplication.getRgSessionManager()
            r2.onAppForeground()
            goto L_0x0665
        L_0x0653:
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r2 = "RG feature turned off from server"
            r4 = 0
            r3[r4] = r2
            java.lang.String r2 = "ResponsibleGamingTimer"
            com.mpl.androidapp.utils.MLogger.d(r2, r3)
            java.lang.String r2 = "false"
            r0.setIsRgGamingOn(r2)
        L_0x0665:
            com.mpl.androidapp.utils.MSharedPreferencesUtils.putRgConfig(r0)
            goto L_0x0686
        L_0x0669:
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "Resp. gaming config missing, setting rg as off"
            r3 = 0
            r0[r3] = r2
            com.mpl.androidapp.utils.MLogger.d(r15, r0)
            com.mpl.androidapp.responsiblegaming.RgConfigs r0 = new com.mpl.androidapp.responsiblegaming.RgConfigs
            r5 = 15
            r6 = 300(0x12c, float:4.2E-43)
            r7 = 60
            r8 = 4
            java.lang.String r9 = "false"
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            com.mpl.androidapp.utils.MSharedPreferencesUtils.putRgConfig(r0)
        L_0x0686:
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r3 = "Init done"
            r4 = 0
            r0[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r15, r0)
            r29.checkAndSendRgWarning()
            r3 = 2
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = "init:[END] "
            r0[r4] = r3
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r20
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0[r2] = r3
            r2 = r28
            com.mpl.androidapp.utils.MLogger.d(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.init():void");
    }

    private void initAnalyticsHelper() {
        MLogger.d(TAG, "initAnalyticsHelper [START]");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                if (ConfigManager.getKafkaConfig() != null) {
                    final JSONObject kafkaConfig = ConfigManager.getKafkaConfig();
                    if (kafkaConfig == null || !kafkaConfig.optBoolean("enabledv1", false)) {
                        MLogger.d(MPLReactContainerActivity.TAG, "initAnalyticsHelper:Kafka not enabled ");
                        return;
                    }
                    KafkaUtils.getAnalyticsConfig().setSendingIntervalTime((long) kafkaConfig.optInt("interval", 2000));
                    KafkaUtils.getAnalyticsConfig().setSendingOnFailure(kafkaConfig.optBoolean("sendingOnFailure", true));
                    KafkaUtils.getAnalyticsConfig().setEventCount(kafkaConfig.optInt("count", 25));
                    KafkaUtils.getAnalyticsConfig().setPostUrl(kafkaConfig.optString("url", "https://aag.mpl.live/k/1"));
                    KafkaUtils.getAnalyticsConfig().setConnectionTimeOut(30000);
                    KafkaUtils.getAnalyticsConfig().setLogEnabled(MBuildConfigUtils.isLogEnabled());
                    KafkaUtils.getAnalyticsConfig().setResponseCallback(new Callback() {
                        public void callback(String str) {
                            MLogger.d(MPLReactContainerActivity.TAG, "callback called", str);
                            if (!TextUtils.isEmpty(str) && "fail".equalsIgnoreCase(str) && KafkaUtils.getAnalyticsHelper() != null) {
                                MLogger.d(MPLReactContainerActivity.TAG, "kafka turned on ", Boolean.valueOf(kafkaConfig.optBoolean("sendingOnFailure", false)));
                            }
                        }
                    });
                    KafkaUtils.getAnalyticsHelper().setConfig(KafkaUtils.getAnalyticsConfig());
                    MPLReactContainerActivity.this.startSendingEvents();
                }
            }
        });
        MLogger.d(TAG, "initAnalyticsHelper [END]");
    }

    private void initInternalEventSdks() {
        try {
            MLogger.d(TAG, "initInternalEventSdks() called");
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    MPLReactContainerActivity.this.lambda$initInternalEventSdks$19$MPLReactContainerActivity();
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "initInternalEventSdks: ", e2);
        }
    }

    private void initPaymentJuspaySdk() {
        if ("IN".equalsIgnoreCase(MBuildConfigUtils.getCountryCode())) {
            MLogger.d("initPaymentJuspay", "initPaymentJuspaySdk: Login from India trying to init Juspay");
            String str = "mplgaming";
            String optString = ConfigManager.getNormalConfig() != null ? ConfigManager.getNormalConfig().optString("android.juspay.init.merchantId", str) : str;
            if (ConfigManager.getNormalConfig() != null) {
                str = ConfigManager.getNormalConfig().optString("android.juspay.init.clientId", str);
            }
            String str2 = str;
            HyperServiceWrapper.initialiseHyperSdk(this, optString, str2, MBuildConfigUtils.isSandboxMoneyInEnable() ? ENVIRONMENT.SANDBOX : ENVIRONMENT.PRODUCTION, $$Lambda$MPLReactContainerActivity$65IUpPzytFiiqgG8x1Pg35Lyu4o.INSTANCE, new FetchCustomerIdUseCase(MBuildConfigUtils.getMainUrl() + ApiEndPoints.PARTNER_DETAILS, CommonUtils.getCommonHeaders(), this.authTokenProvider, this.moshi));
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Country in not IN skipping juspay init country code--->");
        outline73.append(MBuildConfigUtils.getCountryCode());
        MLogger.d("initPaymentJuspay", outline73.toString());
    }

    private void initViewModel() {
        MPLReactContainerVm mPLReactContainerVm = (MPLReactContainerVm) new ViewModelProvider(this).get(MPLReactContainerVm.class);
        this.viewModel = mPLReactContainerVm;
        mPLReactContainerVm.getState().observe(this, $$Lambda$MPLReactContainerActivity$QcjZYOcHM_bxJiJieYnP2Le_c.INSTANCE);
    }

    private void initializeBranch() {
        AppsFlyerLib.getInstance().registerConversionListener(this, this.conversionDataListener);
    }

    public static void initializeFlipper(Context context, ReactInstanceManager reactInstanceManager) {
    }

    private void integrityCheck() {
        MLogger.d(Constant.LOADING_TAG, "integrityCheck: ");
        FileUtils.removeInstalledApkFiles(this);
        setUpView();
        this.initialization = AppInitialization.from(this);
        onStartInitialization();
    }

    private void isAppSealedApk() {
        try {
            if (ConfigManager.getPlatformConfig() != null) {
                boolean z = false;
                if (ConfigManager.getPlatformConfig().optBoolean("apk.integrity.check.enabledV2", false)) {
                    ComponentName componentName = new ComponentName("com.mpl.androidapp", "com.inka.appsealing.AppSealingService");
                    ComponentName componentName2 = new ComponentName("com.mpl.androidapp", "com.inka.appsealing.AppSealingIPService");
                    if (Util.isThisIsAppSealedApk(getApplication()) && Util.isComponentPresent(getApplicationContext(), componentName) && Util.isComponentPresent(getApplicationContext(), componentName2)) {
                        z = true;
                    }
                    if ((MBuildConfigUtils.getBuildFlavor().contains("production") && (MBuildConfigUtils.isDebuggable() || MBuildConfigUtils.isLogEnabled() || MBuildConfigUtils.isDevelopmentModeEnabled())) || !z) {
                        NonSealedApkFragment.newInstance(getString(R.string.non_appsealed_apk_title), getString(R.string.non_appsealed_apk_msg), getString(17039370), true, Constant.APP_SEALING_DIALOG).show(getSupportFragmentManager(), (String) "appsealing");
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isAppsFlyerDeepLinkData(String str) {
        try {
            if (TextUtils.isEmpty(str) || !CommonUtils.isJSONValid(str)) {
                return false;
            }
            return new JSONObject(str).optBoolean("isAppsFlyerData", false);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v35 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x018f, code lost:
        if (getReferrer().getAuthority().contains("cloner") == false) goto L_0x01a8;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [boolean]
      assigns: []
      uses: [?[int, short, byte, char], boolean]
      mth insns count: 406
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isIntegrityCheckFail() {
        /*
            r22 = this;
            r0 = r22
            long r1 = java.lang.System.currentTimeMillis()
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isIntegrityCheckRequired()
            java.lang.String r4 = "isIntegrityCheckFail: "
            java.lang.String r5 = "MPLReactContainerActivity"
            r6 = 2
            r7 = 0
            r8 = 1
            if (r3 == 0) goto L_0x052e
            java.lang.String r3 = "Y29tLm1wbC5hbmRyb2lkYXBw"
            byte[] r9 = android.util.Base64.decode(r3, r7)
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = java.nio.charset.StandardCharsets.UTF_8
            r10.<init>(r9, r11)
            java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r9 = com.mpl.androidapp.react.MPLReactContainerActivity.class
            java.lang.String r9 = r9.getName()
            boolean r9 = r9.contains(r10)
            r10 = 3
            java.lang.String r11 = "IntegrityCheck"
            if (r9 != 0) goto L_0x0041
            java.lang.String r1 = "Class name does not have package"
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r10, r1)
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r2)
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r7] = r1
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            return r8
        L_0x0041:
            android.content.Context r9 = r22.getBaseContext()
            java.lang.String r12 = "Y29tLm1wbC5hbmRyb2lkYXBwLnBz"
            if (r9 == 0) goto L_0x0087
            android.content.Context r9 = r22.getBaseContext()
            java.lang.String r9 = r9.getPackageCodePath()
            if (r9 == 0) goto L_0x0087
            java.lang.String r9 = new java.lang.String
            boolean r13 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r13 == 0) goto L_0x005d
            r13 = r3
            goto L_0x005e
        L_0x005d:
            r13 = r12
        L_0x005e:
            byte[] r13 = android.util.Base64.decode(r13, r7)
            r9.<init>(r13)
            android.content.Context r13 = r22.getBaseContext()
            java.lang.String r13 = r13.getPackageCodePath()
            boolean r9 = r13.contains(r9)
            if (r9 != 0) goto L_0x0087
            java.lang.String r1 = "PackageCodePath does not have package"
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r10, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            java.lang.Object[] r1 = new java.lang.Object[r8]
            java.lang.String r2 = "PackageCodePath does not have package"
            r1[r7] = r2
            com.mpl.androidapp.utils.MLogger.d(r11, r1)
            return r8
        L_0x0087:
            android.content.Context r9 = r22.getBaseContext()
            if (r9 == 0) goto L_0x00af
            android.content.Context r9 = r22.getBaseContext()
            java.lang.String[] r9 = r9.fileList()
            if (r9 == 0) goto L_0x00af
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r9 = "isIntegrityCheckFail() called"
            r6[r7] = r9
            android.content.Context r9 = r22.getBaseContext()
            java.lang.String[] r9 = r9.fileList()
            int r9 = r9.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r6[r8] = r9
            com.mpl.androidapp.utils.MLogger.d(r5, r6)
        L_0x00af:
            android.content.pm.ApplicationInfo r6 = r22.getApplicationInfo()
            android.net.Uri r9 = r22.getReferrer()
            java.lang.String r13 = "Virtual Host Found true"
            if (r9 == 0) goto L_0x00eb
            android.net.Uri r9 = r22.getReferrer()
            java.lang.String r9 = r9.getAuthority()
            if (r9 == 0) goto L_0x00eb
            java.lang.String[] r9 = com.mpl.androidapp.utils.Constant.BANNED_APPS
            java.util.List r9 = java.util.Arrays.asList(r9)
            android.net.Uri r14 = r22.getReferrer()
            java.lang.String r14 = r14.getAuthority()
            boolean r9 = r9.contains(r14)
            if (r9 == 0) goto L_0x00eb
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r1[r7] = r13
            com.mpl.androidapp.utils.MLogger.d(r11, r1)
            java.lang.String r1 = "Starting From banned app"
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r10, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            return r8
        L_0x00eb:
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r8 = "cloner"
            java.lang.String r9 = "gameplugins"
            java.lang.String r10 = "multiaccount"
            java.lang.String r14 = "dualspace"
            java.lang.String r15 = "clone"
            r16 = r5
            java.lang.String r5 = "parallel"
            r17 = r1
            java.lang.String r1 = "multiple"
            java.lang.String r2 = "virtual"
            if (r7 == 0) goto L_0x01a6
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            if (r7 == 0) goto L_0x01a6
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r2)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r1)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r5)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r15)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            r19 = r12
            java.lang.String r12 = "dual"
            boolean r7 = r7.contains(r12)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r14)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0191
            android.net.Uri r7 = r22.getReferrer()
            java.lang.String r7 = r7.getAuthority()
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x01a8
        L_0x0191:
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r13
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            java.lang.String r2 = "Virtual Host Found"
            r3 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r3, r2)
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r2)
            return r1
        L_0x01a6:
            r19 = r12
        L_0x01a8:
            boolean r7 = com.mpl.androidapp.utils.MBuildConfigUtils.isSecondaryApp()
            java.lang.String r12 = "Y29tLm1wbC5hbmRyb2lkYXBwLmZyZWU="
            if (r7 == 0) goto L_0x01b2
            r7 = r12
            goto L_0x01bc
        L_0x01b2:
            boolean r7 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r7 == 0) goto L_0x01ba
            r7 = r3
            goto L_0x01bc
        L_0x01ba:
            r7 = r19
        L_0x01bc:
            r13 = 2
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r20 = 0
            r13[r20] = r4
            r20 = r4
            java.lang.String r4 = r6.packageName
            r21 = r3
            r3 = 1
            r13[r3] = r4
            com.mpl.androidapp.utils.MLogger.d(r11, r13)
            java.lang.String r4 = r6.packageName
            byte[] r4 = r4.getBytes()
            r13 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r13)
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x01f6
            java.lang.String r1 = "Package name  is Mocked"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Package name  is Mocked"
            r4 = 0
            r1[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r11, r1)
            return r3
        L_0x01f6:
            java.lang.String r3 = r6.packageName
            java.lang.String r4 = "com.mpl.androidapp"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x022b
            java.lang.String r3 = r6.packageName
            java.lang.String r4 = "com.mpl.androidapp.ps"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x022b
            java.lang.String r3 = r6.packageName
            java.lang.String r4 = "com.mpl.androidapp.free"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x022b
            java.lang.String r1 = "Package name  is not same"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Package name  is not same"
            r4 = 0
            r2[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            return r1
        L_0x022b:
            r3 = 1
            boolean r4 = r22.isMetaTempered()
            if (r4 == 0) goto L_0x0248
            java.lang.String r1 = "Meta is tempered"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Meta is tempered"
            r4 = 0
            r1[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r11, r1)
            return r3
        L_0x0248:
            java.lang.String r4 = r6.packageName
            boolean r4 = r0.havingExtraPermissions(r4)
            if (r4 == 0) goto L_0x0266
            java.lang.String r1 = "Having extra permissions"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Having extra permissions"
            r4 = 0
            r1[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r11, r1)
            return r3
        L_0x0266:
            r4 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r6 = "checking sensor permission"
            r3[r4] = r6
            com.mpl.androidapp.utils.MLogger.d(r11, r3)
            int r3 = android.os.Binder.getCallingPid()
            int r4 = android.os.Binder.getCallingUid()
            java.lang.String r6 = "android.permission.BODY_SENSORS"
            int r3 = r0.checkPermission(r6, r3, r4)
            if (r3 == 0) goto L_0x0517
            java.lang.String r3 = "android.permission.BODY_SENSORS"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 != 0) goto L_0x028a
            goto L_0x0517
        L_0x028a:
            java.lang.String r3 = "android.permission.ACCOUNT_MANAGER"
            int r4 = r0.checkCallingOrSelfPermission(r3)
            if (r4 == 0) goto L_0x02a9
            int r4 = r0.checkCallingPermission(r3)
            if (r4 == 0) goto L_0x02a9
            int r4 = android.os.Binder.getCallingPid()
            int r6 = android.os.Binder.getCallingUid()
            int r3 = r0.checkPermission(r3, r4, r6)
            if (r3 != 0) goto L_0x02a7
            goto L_0x02a9
        L_0x02a7:
            r3 = 0
            goto L_0x02aa
        L_0x02a9:
            r3 = 1
        L_0x02aa:
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r4 < r6) goto L_0x02be
            if (r3 != 0) goto L_0x02bd
            java.lang.String r3 = "android.permission.GET_ACCOUNTS_PRIVILEGED"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 != 0) goto L_0x02bb
            goto L_0x02bd
        L_0x02bb:
            r3 = 0
            goto L_0x02be
        L_0x02bd:
            r3 = 1
        L_0x02be:
            if (r3 == 0) goto L_0x02d7
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Having Account permission"
            r4 = 0
            r2[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            java.lang.String r2 = "Having Account permission"
            r3 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r3, r2)
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r2)
            return r1
        L_0x02d7:
            java.lang.String r3 = "android.permission.WRITE_CONTACTS"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.WRITE_SETTINGS"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.READ_CALL_LOG"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.MOUNT_FORMAT_FILESYSTEMS"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.CALL_PHONE"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.WRITE_CALL_LOG"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.RECEIVE_WAP_PUSH"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "com.android.voicemail.permission.ADD_VOICEMAIL"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 == 0) goto L_0x0322
            java.lang.String r3 = "android.permission.WRITE_SECURE_SETTINGS"
            int r3 = r0.checkCallingOrSelfPermission(r3)
            if (r3 != 0) goto L_0x0320
            goto L_0x0322
        L_0x0320:
            r3 = 0
            goto L_0x0323
        L_0x0322:
            r3 = 1
        L_0x0323:
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r6 = "checkCallingOrSelfPermission:"
            r7 = 0
            r4[r7] = r6
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)
            r7 = 1
            r4[r7] = r6
            com.mpl.androidapp.utils.MLogger.d(r11, r4)
            java.io.File r4 = r22.getCodeCacheDir()
            if (r4 == 0) goto L_0x0440
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0440
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r1)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r5)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r15)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r14)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r10)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r9)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCodeCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r4 = r4.contains(r8)
            if (r4 != 0) goto L_0x0429
            java.io.File r4 = r22.getCacheDir()
            java.lang.String r4 = r4.getAbsolutePath()
            boolean r2 = r4.contains(r2)
            if (r2 != 0) goto L_0x0429
            java.io.File r2 = r22.getCacheDir()
            java.lang.String r2 = r2.getAbsolutePath()
            boolean r1 = r2.contains(r1)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r5)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r15)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r14)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r10)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r9)
            if (r1 != 0) goto L_0x0429
            java.io.File r1 = r22.getCacheDir()
            java.lang.String r1 = r1.getAbsolutePath()
            boolean r1 = r1.contains(r8)
            if (r1 == 0) goto L_0x0440
        L_0x0429:
            java.lang.String r1 = "Not having proper data dir1"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Not having proper data dir1"
            r4 = 0
            r2[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            return r1
        L_0x0440:
            java.io.File r1 = r22.getCodeCacheDir()
            if (r1 == 0) goto L_0x04fe
            java.io.File r1 = r22.getCodeCacheDir()
            java.io.File r1 = r1.getParentFile()
            if (r1 == 0) goto L_0x04fe
            boolean r1 = com.mpl.androidapp.utils.MBuildConfigUtils.isSecondaryApp()
            java.lang.String r2 = "/code_cache"
            if (r1 == 0) goto L_0x0480
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r4 = r22.getCodeCacheDir()
            java.io.File r4 = r4.getParentFile()
            java.lang.String r4 = r4.getParent()
            r1.append(r4)
            java.lang.String r4 = java.io.File.separator
            r1.append(r4)
            java.lang.String r4 = new java.lang.String
            r5 = 2
            byte[] r5 = android.util.Base64.decode(r12, r5)
            r4.<init>(r5)
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r4, r2)
            goto L_0x04d9
        L_0x0480:
            boolean r1 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r1 == 0) goto L_0x04b0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r4 = r22.getCodeCacheDir()
            java.io.File r4 = r4.getParentFile()
            java.lang.String r4 = r4.getParent()
            r1.append(r4)
            java.lang.String r4 = java.io.File.separator
            r1.append(r4)
            java.lang.String r4 = new java.lang.String
            r5 = 2
            r6 = r21
            byte[] r5 = android.util.Base64.decode(r6, r5)
            r4.<init>(r5)
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r4, r2)
            goto L_0x04d9
        L_0x04b0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r4 = r22.getCodeCacheDir()
            java.io.File r4 = r4.getParentFile()
            java.lang.String r4 = r4.getParent()
            r1.append(r4)
            java.lang.String r4 = java.io.File.separator
            r1.append(r4)
            java.lang.String r4 = new java.lang.String
            r5 = 2
            r6 = r19
            byte[] r5 = android.util.Base64.decode(r6, r5)
            r4.<init>(r5)
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r4, r2)
        L_0x04d9:
            java.io.File r2 = r22.getCodeCacheDir()
            java.lang.String r2 = r2.getAbsolutePath()
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x04fe
            java.lang.String r1 = "Not having proper data dir2"
            r2 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r1)
            com.mpl.androidapp.updater.util.StatusType r1 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r1)
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "Not having proper data dir2"
            r4 = 0
            r2[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r11, r2)
            return r1
        L_0x04fe:
            r1 = 1
            r2 = 0
            if (r3 == 0) goto L_0x0536
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.String r4 = "Having Extra permissions"
            r3[r2] = r4
            com.mpl.androidapp.utils.MLogger.d(r11, r3)
            java.lang.String r2 = "Having Extra permissions which not requested"
            r3 = 3
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r3, r2)
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r2)
            return r1
        L_0x0517:
            r1 = 1
            r2 = 3
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "Having Sensor permission"
            r4[r3] = r5
            com.mpl.androidapp.utils.MLogger.d(r11, r4)
            java.lang.String r3 = "Having Sensor permission"
            com.mpl.androidapp.config.UpdaterAnalytics.integrityCheckFailEvent(r2, r3)
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r0.updateView(r2)
            return r1
        L_0x052e:
            r17 = r1
            r20 = r4
            r16 = r5
            r1 = 1
            r2 = 0
        L_0x0536:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r20
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r17
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r3[r1] = r4
            r1 = r16
            com.mpl.androidapp.utils.MLogger.d(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.isIntegrityCheckFail():boolean");
    }

    public static /* synthetic */ void lambda$initPaymentJuspaySdk$15(String str) {
        MLogger.d("initPaymentJuspay", GeneratedOutlineSupport.outline50("sending init fail to clevertap--->", str));
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        CleverTapAnalyticsUtils.sendEvent((String) JuspayHyperPaymentConstants.INIT_FAIL_CLEVERTAP_EVENT, hashMap);
    }

    public static /* synthetic */ void lambda$initViewModel$27(ReactContainerState reactContainerState) {
        if (reactContainerState instanceof ERROR) {
            MLogger.e(TAG, "There has been some error");
            return;
        }
        MLogger.e(TAG, "Some other issue");
    }

    /* access modifiers changed from: private */
    public void mqttCalling() {
        int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(this);
        final String mQTTUrl = MSharedPreferencesUtils.getMQTTUrl();
        this.mMQTTClient = new MqttAndroidClient(getApplicationContext(), mQTTUrl, String.valueOf(userIdInNormalPref), (MqttClientPersistence) new MemoryPersistence());
        try {
            String jwtToken = MSharedPreferencesUtils.getJwtToken();
            if (!jwtToken.isEmpty()) {
                final String str = MSharedPreferencesUtils.getMQTTClientPrefix() + userIdInNormalPref;
                String str2 = MSharedPreferencesUtils.getMQTTServerPrefix() + userIdInNormalPref;
                HashSet<String> topicListForMQTTSubscription = MSharedPreferencesUtils.getTopicListForMQTTSubscription();
                MLogger.d(MQTT_TAG, "mqttCalling: ", jwtToken);
                if (TextUtils.isEmpty(jwtToken) || this.mMQTTClient.isConnected()) {
                    MLogger.d(TAG, "mqttCalling: token is null");
                    return;
                }
                MLogger.d(MQTT_TAG, "mqttCalling:starting connection ");
                MqttConnectOptions createMqttConnectOptions = createMqttConnectOptions(jwtToken, userIdInNormalPref);
                HashMap hashMap = new HashMap();
                MqttAndroidClient mqttAndroidClient = this.mMQTTClient;
                final String str3 = str2;
                final HashSet<String> hashSet = topicListForMQTTSubscription;
                final HashMap hashMap2 = hashMap;
                AnonymousClass22 r2 = new IMqttActionListener() {
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        MLogger.e(MPLReactContainerActivity.MQTT_TAG, "onFailure:mqttCalling ");
                        hashMap2.put("Is Success", Boolean.FALSE);
                        hashMap2.put("Time Stamp", Long.valueOf(System.currentTimeMillis()));
                        hashMap2.put("Broker URL", mQTTUrl);
                        hashMap2.put("Is Contact Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()));
                        hashMap2.put("Is Following Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToFollowingRequired()));
                        if (!(th == null || th.getLocalizedMessage() == null)) {
                            hashMap2.put(EventsConstants.FAIL_REASON, th.getLocalizedMessage());
                        }
                        CleverTapAnalyticsUtils.sendMQTTConnectionEvent(hashMap2);
                    }

                    public void onSuccess(IMqttToken iMqttToken) {
                        MLogger.d(MPLReactContainerActivity.MQTT_TAG, "mqttCalling onSuccess: ");
                        MPLReactContainerActivity.this.publishOnlineMessageServer(str3, false);
                        MPLReactContainerActivity.this.publishOnlineMessageOwnTopic(str);
                        MPLReactContainerActivity.this.subscribeToOwnChannel(str3);
                        MPLReactContainerActivity.this.subscribeToDynamicTopics(hashSet);
                        if (MSharedPreferencesUtils.isMQTTSubscribeToFollowingRequired()) {
                            MPLReactContainerActivity.this.subscribeToAllFollowers();
                        }
                        if (MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()) {
                            MPLReactContainerActivity.this.subscribeToAllContactOnMpl();
                        }
                        hashMap2.put("Is Success", Boolean.TRUE);
                        hashMap2.put("Time Stamp", Long.valueOf(System.currentTimeMillis()));
                        hashMap2.put("Broker URL", mQTTUrl);
                        hashMap2.put("Is Contact Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()));
                        hashMap2.put("Is Following Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToFollowingRequired()));
                        CleverTapAnalyticsUtils.sendMQTTConnectionEvent(hashMap2);
                    }
                };
                mqttAndroidClient.connect(createMqttConnectOptions, null, r2);
                return;
            }
            HashMap hashMap3 = new HashMap();
            MLogger.e(MQTT_TAG, "onFailure:mqttCalling ");
            hashMap3.put("Is Success", Boolean.FALSE);
            hashMap3.put("Time Stamp", Long.valueOf(System.currentTimeMillis()));
            hashMap3.put("Broker URL", mQTTUrl);
            hashMap3.put("Is Contact Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToContactRequired()));
            hashMap3.put("Is Following Subscription Enabled", Boolean.valueOf(MSharedPreferencesUtils.isMQTTSubscribeToFollowingRequired()));
            hashMap3.put(EventsConstants.FAIL_REASON, "Jwt token not there");
            CleverTapAnalyticsUtils.sendMQTTConnectionEvent(hashMap3);
        } catch (Exception unused) {
            MLogger.e(TAG, "mqttCalling:caught exception ");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        com.mpl.androidapp.utils.MLogger.e(TAG, "onReceive: notification parsing error");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mqttMessageEventReceived(com.mpl.androidapp.utils.MessageEvent r14) {
        /*
            r13 = this;
            java.lang.Class<com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter> r0 = com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter.class
            java.lang.String r1 = "sentTimeStamp"
            java.lang.String r2 = "notificationType"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "mqttMessageEventReceived: "
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "Mqtt:"
            com.mpl.androidapp.utils.MLogger.d(r5, r4)
            java.lang.String r4 = "onReceive: "
            java.lang.String r7 = "MPLReactContainerActivity"
            if (r14 == 0) goto L_0x0100
            com.mpl.androidapp.utils.MessageEvent$MqttObject r8 = r14.getMqttObj()     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x0100
            com.mpl.androidapp.utils.MessageEvent$MqttObject r8 = r14.getMqttObj()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x0100
            com.mpl.androidapp.utils.MessageEvent$MqttObject r14 = r14.getMqttObj()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r14 = r14.getMessage()     // Catch:{ Exception -> 0x0108 }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0108 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0108 }
            r9.<init>()     // Catch:{ Exception -> 0x0108 }
            java.lang.String r10 = "mqttMessageEventReceived message "
            r9.append(r10)     // Catch:{ Exception -> 0x0108 }
            r9.append(r14)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0108 }
            r8[r6] = r9     // Catch:{ Exception -> 0x0108 }
            com.mpl.androidapp.utils.MLogger.d(r7, r8)     // Catch:{ Exception -> 0x0108 }
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0108 }
            if (r8 != 0) goto L_0x010f
            boolean r8 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r14)     // Catch:{ Exception -> 0x0108 }
            if (r8 == 0) goto L_0x010f
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0108 }
            java.lang.String r9 = "onReceive: sending data"
            r8[r6] = r9     // Catch:{ Exception -> 0x0108 }
            com.mpl.androidapp.utils.MLogger.d(r5, r8)     // Catch:{ Exception -> 0x0108 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a4 }
            r8.<init>(r14)     // Catch:{ Exception -> 0x00a4 }
            boolean r9 = r8.has(r2)     // Catch:{ Exception -> 0x00a4 }
            if (r9 == 0) goto L_0x00ad
            boolean r9 = r8.has(r1)     // Catch:{ Exception -> 0x00a4 }
            if (r9 == 0) goto L_0x00ad
            java.lang.String r9 = ""
            java.lang.String r2 = r8.optString(r2, r9)     // Catch:{ Exception -> 0x00a4 }
            r9 = 0
            long r11 = r8.optLong(r1, r9)     // Catch:{ Exception -> 0x00a4 }
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x00ad
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a4 }
            long r8 = r8 - r11
            long r10 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getMQTTTimeEscape()     // Catch:{ Exception -> 0x00a4 }
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ad
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a4 }
            if (r1 != 0) goto L_0x00ad
            java.lang.String r1 = "USER_ONLINE"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x00a4 }
            if (r1 == 0) goto L_0x00ad
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = "onReceive:notification is before than 10 minutes "
            r1[r6] = r2     // Catch:{ Exception -> 0x00a4 }
            com.mpl.androidapp.utils.MLogger.d(r5, r1)     // Catch:{ Exception -> 0x00a4 }
            return
        L_0x00a4:
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0108 }
            java.lang.String r2 = "onReceive: notification parsing error"
            r1[r6] = r2     // Catch:{ Exception -> 0x0108 }
            com.mpl.androidapp.utils.MLogger.e(r7, r1)     // Catch:{ Exception -> 0x0108 }
        L_0x00ad:
            com.facebook.react.ReactInstanceManager r1 = r13.mReactInstanceManager     // Catch:{ Exception -> 0x0108 }
            java.lang.String r2 = "}"
            java.lang.String r5 = "{\"mqtt_response\":"
            java.lang.String r8 = "global"
            if (r1 == 0) goto L_0x00e4
            com.facebook.react.bridge.ReactContext r1 = r13.mReactContext     // Catch:{ Exception -> 0x0108 }
            if (r1 == 0) goto L_0x00e4
            com.facebook.react.bridge.ReactContext r1 = r13.mReactContext     // Catch:{ Exception -> 0x0108 }
            com.facebook.react.bridge.JavaScriptModule r1 = r1.getJSModule(r0)     // Catch:{ Exception -> 0x0108 }
            if (r1 == 0) goto L_0x00e4
            com.facebook.react.bridge.ReactContext r1 = r13.mReactContext     // Catch:{ Exception -> 0x0108 }
            com.facebook.react.bridge.JavaScriptModule r0 = r1.getJSModule(r0)     // Catch:{ Exception -> 0x0108 }
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r0 = (com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter) r0     // Catch:{ Exception -> 0x0108 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0108 }
            r1.<init>()     // Catch:{ Exception -> 0x0108 }
            r1.append(r5)     // Catch:{ Exception -> 0x0108 }
            r1.append(r14)     // Catch:{ Exception -> 0x0108 }
            r1.append(r2)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0108 }
            r0.emit(r8, r1)     // Catch:{ Exception -> 0x0108 }
            r13.sendNotificationThroughMQTT(r13, r14)     // Catch:{ Exception -> 0x0108 }
            goto L_0x010f
        L_0x00e4:
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r0 = r13.reactEmitter     // Catch:{ Exception -> 0x0108 }
            if (r0 == 0) goto L_0x010f
            com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter r0 = r13.reactEmitter     // Catch:{ Exception -> 0x0108 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0108 }
            r1.<init>()     // Catch:{ Exception -> 0x0108 }
            r1.append(r5)     // Catch:{ Exception -> 0x0108 }
            r1.append(r14)     // Catch:{ Exception -> 0x0108 }
            r1.append(r2)     // Catch:{ Exception -> 0x0108 }
            java.lang.String r14 = r1.toString()     // Catch:{ Exception -> 0x0108 }
            r0.emit(r8, r14)     // Catch:{ Exception -> 0x0108 }
            goto L_0x010f
        L_0x0100:
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0108 }
            r14[r6] = r4     // Catch:{ Exception -> 0x0108 }
            com.mpl.androidapp.utils.MLogger.e(r7, r14)     // Catch:{ Exception -> 0x0108 }
            goto L_0x010f
        L_0x0108:
            java.lang.Object[] r14 = new java.lang.Object[r3]
            r14[r6] = r4
            com.mpl.androidapp.utils.MLogger.e(r7, r14)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.mqttMessageEventReceived(com.mpl.androidapp.utils.MessageEvent):void");
    }

    private void mqttSubscriptionEventReceived(MessageEvent messageEvent) {
        try {
            MLogger.d(TAG, "onReceive:mqttEventReceived ");
            String actionType = messageEvent.getMqttObj().getActionType();
            if (MqttServiceConstants.SUBSCRIBE_ACTION.equalsIgnoreCase(actionType)) {
                String[] topics = messageEvent.getMqttObj().getTopics();
                MLogger.d(TAG, "mqttSubscriptionEventReceived subscribe topics ", topics);
                if (topics != null && topics.length > 0) {
                    int[] iArr = new int[topics.length];
                    Arrays.fill(iArr, 1);
                    if (this.mMQTTClient != null) {
                        this.mMQTTClient.subscribe(topics, iArr);
                    }
                }
            } else if ("publish".equalsIgnoreCase(actionType)) {
                String topic = messageEvent.getMqttObj().getTopic();
                String message = messageEvent.getMqttObj().getMessage();
                MLogger.d(TAG, "mqttSubscriptionEventReceived publish topic " + topic + " message " + message);
                if (!TextUtils.isEmpty(topic)) {
                    if (!TextUtils.isEmpty(message)) {
                        MqttMessage mqttMessage = new MqttMessage(message.getBytes());
                        mqttMessage.setQos(1);
                        mqttMessage.setRetained(false);
                        if (this.mMQTTClient != null) {
                            this.mMQTTClient.publish(topic, mqttMessage);
                        }
                    }
                }
            } else if (MqttServiceConstants.UNSUBSCRIBE_ACTION.equalsIgnoreCase(actionType)) {
                String[] topics2 = messageEvent.getMqttObj().getTopics();
                MLogger.d(TAG, "mqttSubscriptionEventReceived unsubscribe topics " + topics2);
                if (!(topics2 == null || topics2.length <= 0 || this.mMQTTClient == null)) {
                    this.mMQTTClient.unsubscribe(topics2);
                }
            } else if (!(!"sendBirdNotificationReceived".equalsIgnoreCase(actionType) || this.mReactInstanceManager == null || this.mReactContext == null)) {
                String topic2 = messageEvent.getMqttObj().getTopic();
                String message2 = messageEvent.getMqttObj().getMessage();
                MLogger.d(TAG, "mqttSubscriptionEventReceived sendBirdNotificationReceived method " + topic2 + " message " + message2);
                WritableMap createMap = Arguments.createMap();
                createMap.putString(AnalyticsConstants.METHOD, topic2);
                createMap.putString("sendBirdNotification", message2);
                ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(CarExtender.KEY_MESSAGES, createMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void onStartInitialization() {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "onStartInitialization: ");
        if (!this.initialization.isLocalAppUpdateAvailable() || ((!MBuildConfigUtils.isCashApp() && !MSharedPreferencesUtils.isProAppDownloadRequired()) || (MSharedPreferencesUtils.getUpdaterV2Enabled() && !MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2() && MSharedPreferencesUtils.canSkipPopup()))) {
            skipCriticalDownload();
        } else if (!this.initialization.updateApp(this)) {
            skipCriticalDownload();
        }
    }

    private void openRankResultScreenForThirdPartiesGames(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(Constant.INTENT_EXTRA_TOURNAMENT_RESULT)) {
                    String stringExtra = intent.getStringExtra(Constant.INTENT_EXTRA_TOURNAMENT_RESULT);
                    MLogger.d(TAG, "openRankResultScreenForThirdPartiesGames:tournamentResult ", stringExtra);
                    if (stringExtra == null || TextUtils.isEmpty(stringExtra) || !CommonUtils.isJSONValid(stringExtra)) {
                        MLogger.e(TAG, "openRankResultScreenForThirdPartiesGames: ");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("thirdparty_score_result", jSONObject);
                    MLogger.d(TAG, "openRankResultScreenForThirdPartiesGames: ", "resultData: ", jSONObject, "gameSession: ", jSONObject2);
                    this.reactEmitter.emit(Constant.GAME_SCORE, jSONObject2.toString());
                    return;
                }
            } catch (Exception e2) {
                MLogger.d(TAG, "openRankResultScreenForThirdPartiesGames: ", e2);
                return;
            }
        }
        MLogger.d(TAG, "openRankResultScreenForThirdPartiesGames: Does not have tournamentResult extra");
    }

    /* access modifiers changed from: private */
    public void openScreenShotNudges(Uri uri) {
        if (((LifecycleRegistry) getLifecycle()).mState.isAtLeast(State.STARTED) && uri != null) {
            String uri2 = uri.toString();
            if (uri2.matches(Media.EXTERNAL_CONTENT_URI.toString() + "/[0-9]+")) {
                Cursor cursor = null;
                try {
                    cursor = getContentResolver().query(uri, new String[]{"_display_name", "_data"}, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndex("_display_name"));
                        String string2 = cursor.getString(cursor.getColumnIndex("_data"));
                        CommonUtils.createAppsFlyerReferralLink(MPLApplication.getInstance(), "{}", new PromiseImpl(new com.facebook.react.bridge.Callback() {
                            public void invoke(Object... objArr) {
                                String replace = ConfigManager.getReferralNudgeConfig().optString("message").replace("{INVITE_CODE}", MSharedPreferencesUtils.getUserReferralCode()).replace("{URL}", objArr[0]);
                                try {
                                    String createScreenShotImagePath = SharedPrefModule.createScreenShotImagePath(MPLReactContainerActivity.this);
                                    if (createScreenShotImagePath != null) {
                                        MPLReactContainerActivity.this.startShareNudges(createScreenShotImagePath, replace);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }, new com.facebook.react.bridge.Callback() {
                            public void invoke(Object... objArr) {
                                String replace = ConfigManager.getReferralNudgeConfig().optString("message").replace("{INVITE_CODE}", MSharedPreferencesUtils.getUserReferralCode()).replace("{URL}", ConfigManager.getReferralNudgeConfig().optString("default.url", ""));
                                try {
                                    String createScreenShotImagePath = SharedPrefModule.createScreenShotImagePath(MPLReactContainerActivity.this);
                                    if (createScreenShotImagePath != null) {
                                        MPLReactContainerActivity.this.startShareNudges(createScreenShotImagePath, replace);
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        }));
                        MLogger.d(TAG, "screen shot added " + string + CMap.SPACE + string2);
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
        }
    }

    private void openSettingApplication() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    /* access modifiers changed from: private */
    public void processAfterLoginData() {
        try {
            MLogger.d(TAG, "processAfterLoginData() called");
            MSharedPreferencesUtils.putLongPref(UpdaterConstant.UPDATE_LOGIN_TIME, Util.getCurrentTime().getTime(), true);
            MSharedPreferencesUtils.setMoneyInBranchEventPushed(false);
            MSharedPreferencesUtils.setMoneyOutBranchEventPushed(false);
            MSharedPreferencesUtils.setGamePlayedBranchEventPushed(false);
            MSharedPreferencesUtils.setGamePlayedBranchEventPushedV2(false);
            MSharedPreferencesUtils.setUserLoggedIn(true);
            VideoRecordingUtils.setInitiallyUserPlayedGame(this);
            if (MSharedPreferencesUtils.getUserIdInNormalPref(this) == 0) {
                MSharedPreferencesUtils.moveUserIdInNormalPref(this);
            }
            if (TextUtils.isEmpty(MSharedPreferencesUtils.getMobileNumberInNormalPref(this))) {
                MSharedPreferencesUtils.moveMobileNumberInNormalPref(this);
            }
            String mobileNumberInNormalPref = MSharedPreferencesUtils.getMobileNumberInNormalPref(this);
            if (mobileNumberInNormalPref != null && mobileNumberInNormalPref.startsWith("+62")) {
                LocaleHelper.setLocale(MPLApplication.getInstance().getBaseContext(), "in");
            }
            MSharedPreferencesUtils.setUserCurrentTier();
            MSharedPreferencesUtils.setIsNewUserValue(this);
            if (this.conversionDataAppsflyer.size() != 0 && MSharedPreferencesUtils.getUserIdInNormalPrefV2(getApplicationContext()) != 0) {
                this.conversionDataAppsflyer.put("is_new_user", Boolean.valueOf(MSharedPreferencesUtils.isNewUser()));
                CleverTapAnalyticsUtils.sendEvent((String) "Attribution Detected Post Login", this.conversionDataAppsflyer);
                this.conversionDataAppsflyer.clear();
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "onReceive:mProceedHomeDataReceiver ", e2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0055 A[Catch:{ Exception -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publishOnlineMessageOwnTopic(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "avatar"
            java.lang.String r1 = "USER_ONLINE"
            java.lang.String r2 = "message"
            java.lang.String r3 = "displayName"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            java.lang.String r7 = "publishOnlineMessageOwnTopic: "
            r5[r6] = r7
            java.lang.String r8 = "Mqtt:"
            com.mpl.androidapp.utils.MLogger.d(r8, r5)
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserProfile()
            if (r11 == 0) goto L_0x0052
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x004f }
            if (r12 != 0) goto L_0x0052
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x004f }
            r12.<init>(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "mobileNumber"
            r12.remove(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "detailedProfile"
            r12.remove(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "avatars"
            r12.remove(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "referralCode"
            r12.remove(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "coverPhotos"
            r12.remove(r11)     // Catch:{ Exception -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = r15
            goto L_0x0115
        L_0x0052:
            r12 = 0
        L_0x0053:
            if (r12 == 0) goto L_0x00f9
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r11.<init>()     // Catch:{ Exception -> 0x004f }
            java.lang.String r13 = ""
            java.lang.String r13 = r12.optString(r3, r13)     // Catch:{ Exception -> 0x004f }
            r11.append(r13)     // Catch:{ Exception -> 0x004f }
            java.lang.String r13 = " is online"
            r11.append(r13)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x004f }
            r12.put(r2, r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "lastSeen"
            java.util.Calendar r13 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x004f }
            long r13 = r13.getTimeInMillis()     // Catch:{ Exception -> 0x004f }
            r12.put(r11, r13)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "online"
            r12.put(r11, r4)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "route"
            java.lang.String r13 = "UserProfileStatus"
            r10.put(r11, r13)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "param"
            r10.put(r11, r12)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "actionType"
            java.lang.String r13 = "nav"
            r9.put(r11, r13)     // Catch:{ Exception -> 0x004f }
            java.lang.String r11 = "actionPayload"
            r9.put(r11, r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r10 = "action"
            java.lang.String r11 = "MQTT_FOREGROUND"
            r5.put(r10, r11)     // Catch:{ Exception -> 0x004f }
            java.lang.String r10 = "actionParams"
            r5.put(r10, r9)     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = "type"
            r5.put(r9, r1)     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = "messageType"
            java.lang.String r10 = "Online Notify"
            r5.put(r9, r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = "userid"
            java.lang.String r10 = "id"
            int r10 = r12.optInt(r10)     // Catch:{ Exception -> 0x004f }
            r5.put(r9, r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = "name"
            java.lang.String r10 = r12.optString(r3)     // Catch:{ Exception -> 0x004f }
            r5.put(r9, r10)     // Catch:{ Exception -> 0x004f }
            java.lang.String r9 = r12.optString(r0)     // Catch:{ Exception -> 0x004f }
            r5.put(r0, r9)     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "title"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004f }
            r9.<init>()     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r12.optString(r3)     // Catch:{ Exception -> 0x004f }
            r9.append(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = " is Online!"
            r9.append(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = r9.toString()     // Catch:{ Exception -> 0x004f }
            r5.put(r0, r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "Send a challenge to play now"
            r5.put(r2, r0)     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "sentTimeStamp"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x004f }
            r5.put(r0, r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = "notificationType"
            r5.put(r0, r1)     // Catch:{ Exception -> 0x004f }
        L_0x00f9:
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x004f }
            org.eclipse.paho.client.mqttv3.MqttMessage r1 = new org.eclipse.paho.client.mqttv3.MqttMessage     // Catch:{ Exception -> 0x004f }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x004f }
            r1.<init>(r0)     // Catch:{ Exception -> 0x004f }
            r1.setRetained(r6)     // Catch:{ Exception -> 0x004f }
            r1.setQos(r4)     // Catch:{ Exception -> 0x004f }
            r0 = r15
            org.eclipse.paho.android.service.MqttAndroidClient r2 = r0.mMQTTClient     // Catch:{ Exception -> 0x0115 }
            r3 = r16
            r2.publish(r3, r1)     // Catch:{ Exception -> 0x0115 }
            goto L_0x011c
        L_0x0115:
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r6] = r7
            com.mpl.androidapp.utils.MLogger.e(r8, r1)
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.publishOnlineMessageOwnTopic(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void publishOnlineMessageServer(String str, boolean z) {
        JSONObject jSONObject;
        try {
            MLogger.d(MQTT_TAG, "publishOnlineMessageServer: ");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("authToken", MSharedPreferencesUtils.getAccessUserToken());
            jSONObject2.put(SMTEventParamKeys.SMT_APP_VERSION, MBuildConfigUtils.getInstalledAppVersionCode());
            jSONObject2.put(ConfigConstant.REACT_VERSION, DBInteractor.getCurrentRNBundleVersionCode());
            jSONObject2.put("state", "online");
            jSONObject2.put("reconnect", z);
            jSONObject2.put("tier", MSharedPreferencesUtils.getUserTier());
            jSONObject2.put("sentTimeStamp", System.currentTimeMillis());
            jSONObject2.put(Constant.NOTIFICATION_TYPE, "USER_ONLINE");
            String userProfile = MSharedPreferencesUtils.getUserProfile();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = null;
            if (userProfile != null && !TextUtils.isEmpty(userProfile)) {
                jSONObject6 = new JSONObject(userProfile);
                jSONObject6.remove("mobileNumber");
                jSONObject6.remove("detailedProfile");
                jSONObject6.remove("avatars");
                jSONObject6.remove("referralCode");
                jSONObject6.remove("coverPhotos");
            }
            if (jSONObject6 != null) {
                jSONObject6.put("message", jSONObject6.optString("displayName", "") + " is online");
                jSONObject = jSONObject2;
                jSONObject6.put("lastSeen", Calendar.getInstance().getTimeInMillis());
                jSONObject6.put("online", true);
                jSONObject5.put("route", "UserProfileStatus");
                jSONObject5.put("param", jSONObject6);
                jSONObject4.put(OneSingnalConstant.PARAM_ACTION_TYPE, "nav");
                jSONObject4.put(OneSingnalConstant.PARAM_ACTION_PAYLOAD, jSONObject5);
                jSONObject3.put("action", "MQTT_FOREGROUND");
                jSONObject3.put("actionParams", jSONObject4);
                jSONObject3.put("type", "USER_ONLINE");
                jSONObject3.put(MiPushMessage.KEY_MESSAGE_TYPE, "Online Notify");
                jSONObject3.put("userid", jSONObject6.optInt("id"));
                jSONObject3.put("name", jSONObject6.optString("displayName"));
                jSONObject3.put("avatar", jSONObject6.optString("avatar"));
                jSONObject3.put("title", jSONObject6.optString("displayName") + " is Online!");
                jSONObject3.put("message", "Send a challenge to play now");
                jSONObject3.put(SMTNotificationConstants.NOTIF_BODY_KEY, "Send a challenge to play now");
            } else {
                jSONObject = jSONObject2;
            }
            JSONObject jSONObject7 = jSONObject;
            jSONObject7.put("FCM", jSONObject3);
            MqttMessage mqttMessage = new MqttMessage(jSONObject7.toString().getBytes());
            mqttMessage.setQos(1);
            mqttMessage.setRetained(false);
            try {
                this.mMQTTClient.publish(str, mqttMessage);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            MLogger.e(MQTT_TAG, "publishOnlineMessageServer: ");
        }
    }

    private void registerBroadcastForAssetsDownload(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.DOWNLOAD_ASSETS_BUNDLE));
    }

    private void registerBroadcastForGeoSpoofingAlert(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Constant.ACTION_GEOSPOOFING_DETECTED));
    }

    private void registerBroadcastToBackgroundTask(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Constant.ACTION_BACKGROUND_TASK));
    }

    private void registerBroadcastToReceiveMQTTMessage(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.ACTION_MQTT_MESSAGE_RECEIVED));
    }

    private void registerBroadcastToRecordingMonitoring(BroadcastReceiver broadcastReceiver2) {
        registerReceiver(broadcastReceiver2, new IntentFilter(VideoRecordingConstants.INIT_RECORDING_MONITORING));
    }

    private void registerInstallReceiver(BroadcastReceiver broadcastReceiver2) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_NEEDS_VERIFICATION");
        intentFilter.addAction("android.intent.action.PACKAGE_VERIFIED");
        if (VERSION.SDK_INT >= 24) {
            intentFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        }
        intentFilter.addDataScheme("package");
        registerReceiver(broadcastReceiver2, intentFilter);
    }

    private void registerProceedAfterLoginData(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.ACTION_PROCEED_AFTER_LOGIN_DATA));
    }

    private void registerProceedHomeData(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.ACTION_PROCEED_HOME_DATA));
    }

    private void registerProceedHomeDataLoadCompleted(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.ACTION_PROCEED_HOME_DATA_LOAD_COMPLETED));
    }

    /* access modifiers changed from: private */
    public void relaunchActivityForOriginals(Context context, ApkInfo apkInfo, String str) {
        try {
            Intent intent = new Intent(context, MPLReactContainerActivity.class);
            int intValue = apkInfo.getGameId().intValue();
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            if (!(intValue == 0 || from == null)) {
                from.cancel(intValue);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "OPEN_DEEP_LINK");
            if (GameLaunchHelper.mOriginals.containsKey(Integer.valueOf(intValue))) {
                if (GameLaunchHelper.mOriginals.get(Integer.valueOf(intValue)) != null) {
                    OriginalGameConstant originalGameConstant = GameLaunchHelper.mOriginals.get(Integer.valueOf(intValue));
                    int tournamentId = originalGameConstant.getTournamentId();
                    if (originalGameConstant.isTournament()) {
                        jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else if (originalGameConstant.isBattle()) {
                        jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else if (originalGameConstant.isKO()) {
                        jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"KnockoutDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else {
                        jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + intValue + "}}}");
                    }
                    intent.putExtra("gameData", jSONObject.toString());
                    intent.putExtra("launched_after_app_install", true);
                    intent.putExtra("launched_game_id", intValue);
                    intent.putExtra("launched_game_package_name", str);
                    intent.setAction("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    startActivity(intent);
                }
            }
            jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + intValue + "}}}");
            intent.putExtra("gameData", jSONObject.toString());
            intent.putExtra("launched_after_app_install", true);
            intent.putExtra("launched_game_id", intValue);
            intent.putExtra("launched_game_package_name", str);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            startActivity(intent);
        } catch (Exception unused) {
            MLogger.e(TAG, "relaunchActivityForOriginals: ");
        }
    }

    private void removeAllNotifications() {
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            for (String parseInt : NotificationBuilder.mSendBirdSenderIds) {
                notificationManager.cancel(Integer.parseInt(parseInt));
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "removeAllNotifications: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void runBackgroundTasks() {
        MLogger.d(TAG, "runBackgroundTasks: ");
        try {
            initPaymentJuspaySdk();
        } catch (Exception e2) {
            MLogger.e(TAG, "runBackgroundTasks: ", e2);
        }
        try {
            runTasksOnBackgroundThread(this);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    MPLReactContainerActivity.this.checkFraudApps();
                }
            });
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public final void run() {
                    MPLReactContainerActivity.this.checkAppSealingServices();
                }
            });
            initInternalEventSdks();
            isAppSealedApk();
            checkAppGuardServices();
            AppsflyerUtils.getAppsflyerFilterEvents();
        } catch (Exception e3) {
            MLogger.e(TAG, "runBackgroundTasks: ", e3);
        }
    }

    private void runTasksOnBackgroundThread(Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MPLReactContainerActivity.this.lambda$runTasksOnBackgroundThread$13$MPLReactContainerActivity(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void runTasksOnBackgroundThreadAfterHomeLoaded(Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context) {
            public final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MPLReactContainerActivity.this.lambda$runTasksOnBackgroundThreadAfterHomeLoaded$14$MPLReactContainerActivity(this.f$1);
            }
        });
    }

    private void saveNewUserForNotif() {
        boolean z;
        try {
            MSharedPreferencesUtils.saveBooleanInNormalPref(this, Constant.IS_USER_LOGGED_IN_v2, true);
            new NotificationBuilder(this).cancelNotificationAlarmManagerForLogin();
            UserInfo userInfo = MSharedPreferencesUtils.getUserInfo();
            if (userInfo != null) {
                z = userInfo.isNewUser();
            } else {
                z = MSharedPreferencesUtils.isNewUser();
            }
            MSharedPreferencesUtils.saveBooleanInNormalPref(this, Constant.IS_NEW_USER_FOR_NOTIFICATION, z);
            if (MSharedPreferencesUtils.getLongInNormalPref(this, Constant.LOGIN_TIME, 0) == 0) {
                MSharedPreferencesUtils.saveLongInNormalPref(this, Constant.LOGIN_TIME, Calendar.getInstance().getTimeInMillis());
                if (z && MSharedPreferencesUtils.isGameReminderNotifEnabeled(this)) {
                    new NotificationBuilder(this).createNotificationAlarmManagerForGamePlayReminder(DefaultRemoteConfig.SESSION_TIMEOUT_DURATION);
                }
            }
            MLogger.d(TAG, "saveNewUserForNotif: ", Boolean.valueOf(z));
        } catch (Exception unused) {
        }
    }

    private void sendClickActionIdToReact(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "OPEN_DEEP_LINK");
            jSONObject.put("actionParams", str);
            emitDataToReact(jSONObject.toString());
        } catch (Exception e2) {
            MLogger.e(TAG, "sendClickActionIdToReact: ", e2);
        }
    }

    private void sendDauEventToAppsFlyer() {
        String lastDauEventTime = MSharedPreferencesUtils.getLastDauEventTime();
        MLogger.d(TAG, "sendDauEventToAppsFlyer: ", lastDauEventTime);
        if (lastDauEventTime == null || TextUtils.isEmpty(lastDauEventTime)) {
            CleverTapAnalyticsUtils.sendEventsToAppsFlyer(this, "af_dau", CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            CleverTapAnalyticsUtils.pushFacebookEventWithProp("MPL_DAU", CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            MSharedPreferencesUtils.setLastDauEventTime(new DateTime().toString());
            fetchFireBaseToken();
            return;
        }
        DateTime parse = DateTime.parse(lastDauEventTime);
        if (new DateTime().dayOfYear().get() > parse.dayOfYear().get() || new DateTime().getYear() > parse.getYear()) {
            CleverTapAnalyticsUtils.sendEventsToAppsFlyer(this, "af_dau", CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            CleverTapAnalyticsUtils.pushFacebookEventWithProp("MPL_DAU", CleverTapAnalyticsUtils.commonPropertiesForEvents(false));
            MSharedPreferencesUtils.setLastDauEventTime(new DateTime().toString());
            fetchFireBaseToken();
            return;
        }
        MLogger.d(TAG, "Already send dau event for today: ", lastDauEventTime);
    }

    private void sendDauEventToCleverTap() {
        try {
            String lastDauEventToClevertapTime = MSharedPreferencesUtils.getLastDauEventToClevertapTime();
            MLogger.d(TAG, "sendDauEventToAppsFlyer: ", lastDauEventToClevertapTime);
            if (lastDauEventToClevertapTime != null) {
                if (!TextUtils.isEmpty(lastDauEventToClevertapTime)) {
                    DateTime parse = DateTime.parse(lastDauEventToClevertapTime);
                    if (new DateTime().dayOfYear().get() <= parse.dayOfYear().get()) {
                        if (new DateTime().getYear() <= parse.getYear()) {
                            MLogger.d(TAG, "Already send dau event for today: ", lastDauEventToClevertapTime);
                            return;
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(EventsConstants.IS_FIRST_INSTALL, Boolean.valueOf(DBInteractor.isFirstLaunchAfterInstallation()));
                    CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.EVENT_DAU, hashMap);
                    sendInstalledAppDataToKafka();
                    DBInteractor.setIsFirstLaunchAfterInstallation();
                    MSharedPreferencesUtils.setLastDauEventToClevertapTime(new DateTime().toString());
                    return;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(EventsConstants.IS_FIRST_INSTALL, Boolean.valueOf(DBInteractor.isFirstLaunchAfterInstallation()));
            CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.EVENT_DAU, hashMap2);
            sendInstalledAppDataToKafka();
            DBInteractor.setIsFirstLaunchAfterInstallation();
            MSharedPreferencesUtils.setLastDauEventToClevertapTime(new DateTime().toString());
        } catch (Exception unused) {
            MLogger.e(TAG, "sendDauEventToCleverTap: ");
        }
    }

    /* access modifiers changed from: private */
    public void sendInstallStatusToReact(String str, int i) {
        try {
            MLogger.d(TAG, "sendInstallStatusToReact: ", str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Game ID", i);
            jSONObject.put("Status", str);
            ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(RCTDeviceEventEmitter.class)).emit("third_party_apk_status", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private void sendInstalledAppDataToKafka() throws NameNotFoundException {
        List<ApplicationInfo> installedApplications = getPackageManager().getInstalledApplications(128);
        String[] strArr = new String[installedApplications.size()];
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        for (ApplicationInfo next : installedApplications) {
            strArr[i] = next.packageName;
            String valueOf = String.valueOf(getApplicationContext().getPackageManager().getPackageInfo(strArr[i], 0).versionName);
            String valueOf2 = String.valueOf(getApplicationContext().getPackageManager().getPackageInfo(strArr[i], 0).versionCode);
            String valueOf3 = String.valueOf(getApplicationContext().getPackageManager().getPackageInfo(strArr[i], 0).firstInstallTime);
            String valueOf4 = String.valueOf(getApplicationContext().getPackageManager().getPackageInfo(strArr[i], 0).lastUpdateTime);
            String valueOf5 = String.valueOf(getApplicationContext().getPackageManager().getApplicationInfo(strArr[i], 0).name);
            i++;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", next.packageName);
                jSONObject.put("ApplicationName", valueOf5);
                jSONObject.put(Constant.HEADER_APP_VERSION_NAME, valueOf);
                jSONObject.put(Response.VERSION_CODE, valueOf2);
                jSONObject.put("fistInstallTime", valueOf3);
                jSONObject.put("LastUpdateTime", valueOf4);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        MLogger.d(TAG, jSONArray.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("installed apps", jSONArray);
        CleverTapAnalyticsUtils.sendEventToKafka("installed apps", hashMap);
    }

    private void sendLowStorageEventToReact(String str) {
        if (this.mReactInstanceManager != null) {
            ReactContext reactContext = this.mReactContext;
            if (reactContext != null) {
                ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(Constant.GLOBAL_REACT_EMIT_KEY, "{\"" + str + "\":true}");
                return;
            }
        }
        MLogger.d(TAG, "mReactInstanceManager is null in assets download");
    }

    /* access modifiers changed from: private */
    public void sendNotificationThroughMQTT(Context context, String str) {
        MLogger.d(TAG, "sendNotificationThroughMQTT: ");
        if (!TextUtils.isEmpty(str) && CommonUtils.isJSONValid(str) && Util.shouldSendNotification(str)) {
            MLogger.d(TAG, "sendNotificationThroughMQTT:[SENDING] ");
            new NotificationBuilder(context).createFCMNotificationDeepLink(new RemoteMessage(Util.jsonToBundle(str)));
        }
    }

    private void sendSendBirdEvent(ReactContext reactContext, WritableMap writableMap) {
        Class cls = RCTDeviceEventEmitter.class;
        if (reactContext != null) {
            try {
                if (reactContext.getJSModule(cls) != null) {
                    ((RCTDeviceEventEmitter) reactContext.getJSModule(cls)).emit(CarExtender.KEY_MESSAGES, writableMap);
                    return;
                }
            } catch (Error | Exception e2) {
                MLogger.e(TAG, "sendEvent: ", e2);
                return;
            }
        }
        if (this.reactEmitter != null) {
            this.reactEmitter.emit(CarExtender.KEY_MESSAGES, writableMap);
        }
    }

    /* access modifiers changed from: private */
    public void setReactView() {
        MLogger.d(TAG, "setReactView:setSplashImage ", "\nisReactLoadCalled:", Boolean.valueOf(this.isReactLoadCalled), "\nisAnimationEnded:", Boolean.valueOf(this.isAnimationEnded));
        this.isReactLoadCalled = true;
        if (this.isAnimationEnded) {
            ActivityReactContainerBinding inflate = ActivityReactContainerBinding.inflate(LayoutInflater.from(this));
            LottieAnimationView lottieAnimationView = inflate.dynamicSplashImageLottie;
            if (lottieAnimationView != null) {
                setSplashImage(lottieAnimationView, null, true);
            }
            ReactRootView reactRootView = this.mReactRootView;
            if (!(reactRootView == null || reactRootView.getParent() == null)) {
                ((ViewGroup) this.mReactRootView.getParent()).removeView(this.mReactRootView);
            }
            inflate.getRoot().addView(this.mReactRootView);
            setContentView((View) inflate.getRoot());
        }
    }

    private void setSplashImage(LottieAnimationView lottieAnimationView, ProgressBar progressBar, final boolean z) {
        try {
            if (this.mSplashConfig == null) {
                JSONObject splashConfig = CountryUtils.getSplashConfig();
                this.mSplashConfig = splashConfig;
                if (splashConfig != null) {
                    int optInt = splashConfig.optInt(Constant.SPLASH_MIN_OS_VERSION, 26);
                    this.minOSForSplashOS = optInt;
                    this.shouldShow = VERSION.SDK_INT >= optInt && this.mSplashConfig.optBoolean(Constant.SPLASH_CHANGE_SHOULD_SHOW, false);
                    this.splashLotteUrl = this.mSplashConfig.optString(Constant.SPLASH_DOWNLOAD_LOTTE_URL);
                    this.splashLotteEndUrl = this.mSplashConfig.optString(Constant.SPLASH_DOWNLOAD_END_LOTTE_URL);
                    this.splashLotteId = this.mSplashConfig.optString(Constant.SPLASH_DOWNLOAD_LOTTE_ID);
                    this.splashLotteEndId = this.mSplashConfig.optString(Constant.SPLASH_DOWNLOAD_LOTTE_END_ID);
                    this.shouldWait = this.mSplashConfig.optBoolean(Constant.SPLASH_SHOULD_WAIT_FOR_ANIMATION_COMPLETE, true);
                }
            }
            MLogger.d(TAG, "setSplashImage: ", "\nisReactLoad: ", Boolean.valueOf(z), "\nshouldShow: ", Boolean.valueOf(this.shouldShow), "\nsplashLotteId: ", this.splashLotteId, "\nsplashLotteEndId: ", this.splashLotteEndId, "\nsplashLotteEndUrl: ", this.splashLotteEndUrl, "\nshouldWait: ", Boolean.valueOf(this.shouldWait), "\nsplashLotteUrl:", this.splashLotteUrl);
            if (this.mSplashConfig == null || !this.shouldShow || TextUtils.isEmpty(this.splashLotteUrl) || TextUtils.isEmpty(this.splashLotteEndUrl) || TextUtils.isEmpty(this.splashLotteEndId) || TextUtils.isEmpty(this.splashLotteId)) {
                MLogger.d(TAG, "setSplashImage: Config is not correct");
                this.isAnimationEnded = true;
                return;
            }
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setRepeatCount(0);
            if (z) {
                lottieAnimationView.setAnimationFromUrl(this.splashLotteEndUrl, this.splashLotteEndId);
            } else {
                lottieAnimationView.setAnimationFromUrl(this.splashLotteUrl, this.splashLotteId);
            }
            if (this.shouldWait) {
                MLogger.d(TAG, "setSplashImage: Waiting for animation complete");
                lottieAnimationView.lottieDrawable.animator.listeners.add(new AnimatorListenerAdapter() {
                    public void onAnimationCancel(Animator animator) {
                        super.onAnimationCancel(animator);
                        MLogger.d(MPLReactContainerActivity.TAG, "onAnimationCancel:setSplashImage ");
                    }

                    public void onAnimationEnd(Animator animator, boolean z) {
                        super.onAnimationEnd(animator, z);
                        MLogger.d(MPLReactContainerActivity.TAG, "onAnimationEnd:setSplashImage ");
                        MPLReactContainerActivity.this.startReactAfterAnimation(z);
                    }

                    public void onAnimationStart(Animator animator, boolean z) {
                        super.onAnimationStart(animator, z);
                        MLogger.d(MPLReactContainerActivity.TAG, "onAnimationStart:setSplashImage ");
                    }
                });
            } else {
                MLogger.d(TAG, "setSplashImage: Not Waiting for animation complete");
                this.isAnimationEnded = true;
            }
            lottieAnimationView.setFailureListener(new LottieListener(z) {
                public final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResult(Object obj) {
                    MPLReactContainerActivity.this.lambda$setSplashImage$5$MPLReactContainerActivity(this.f$1, (Throwable) obj);
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "setSplashImage: ", e2);
            this.isAnimationEnded = true;
        }
    }

    private void setUnityMiniProfileListener(Intent intent) {
        UnityReactNavigationImpl unityReactNavigationImpl = new UnityReactNavigationImpl(this.mReactContext, intent);
        unityReactNavigationImpl.setListener(this);
        unityReactNavigationImpl.openFullUserProfile();
    }

    private void showAlertDialog(AlertDialog alertDialog2) {
        if (!isFinishing() && alertDialog2 != null && !alertDialog2.isShowing()) {
            alertDialog2.show();
        }
    }

    private void showLogOutDialog(String str, String str2, String str3) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.alertDialog == null || !this.alertDialog.isShowing()) {
                        if (this.alertDialog == null) {
                            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.logout_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                            Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                            TextView textView = (TextView) inflate.findViewById(R.id.dialog_msg);
                            textView.setTypeface(createFromAsset);
                            textView.setText(str2);
                            Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                            button.setTypeface(createFromAsset2);
                            button.setText(str3);
                            button.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    MPLReactContainerActivity.this.lambda$showLogOutDialog$21$MPLReactContainerActivity(view);
                                }
                            });
                            builder.setView(inflate);
                            builder.setCancelable(false);
                            builder.setIcon(R.mipmap.ic_launcher);
                            this.alertDialog = builder.create();
                        }
                        showAlertDialog(this.alertDialog);
                        new Handler(new Handler.Callback() {
                            public final boolean handleMessage(Message message) {
                                return MPLReactContainerActivity.this.lambda$showLogOutDialog$22$MPLReactContainerActivity(message);
                            }
                        }).sendEmptyMessageDelayed(0, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    private void showNetworkErrorDialog(String str, String str2, String str3, boolean z, boolean z2) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.alertDialog != null && this.alertDialog.isShowing()) {
                        this.alertDialog.dismiss();
                        this.alertDialog = null;
                    }
                    if (this.alertDialog == null) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.network_failed_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        textView.setTypeface(createFromAsset);
                        textView.setText(str);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                        textView2.setTypeface(createFromAsset2);
                        textView2.setText(str2);
                        Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                        button.setTypeface(createFromAsset);
                        button.setText(str3);
                        button.setOnClickListener(new OnClickListener(z) {
                            public final /* synthetic */ boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MPLReactContainerActivity.this.lambda$showNetworkErrorDialog$9$MPLReactContainerActivity(this.f$1, view);
                            }
                        });
                        builder.setView(inflate);
                        builder.setCancelable(z2);
                        this.alertDialog = builder.create();
                    }
                    showAlertDialog(this.alertDialog);
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    private void showOptimizationToast() {
        try {
            new Handler(new Handler.Callback() {
                public final boolean handleMessage(Message message) {
                    return MPLReactContainerActivity.this.lambda$showOptimizationToast$8$MPLReactContainerActivity(message);
                }
            }).sendEmptyMessageDelayed(0, TQConstants.COUNTDOWN_DURATION);
        } catch (Exception unused) {
        }
    }

    private void showScreenMagnificationDialog(String str, String str2) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.mScreenMagnificationAlertDialog != null && this.mScreenMagnificationAlertDialog.isShowing()) {
                        this.mScreenMagnificationAlertDialog.dismiss();
                        this.mScreenMagnificationAlertDialog = null;
                    }
                    LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
                    if (this.mScreenMagnificationAlertDialog == null && layoutInflater != null) {
                        View inflate = layoutInflater.inflate(R.layout.dialog_magnification, (ViewGroup) findViewById(R.id.magnification_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        textView.setTypeface(createFromAsset);
                        textView.setTextColor(ContextCompat.getColor(this, R.color.orange));
                        builder.setView(inflate);
                        builder.setCancelable(false);
                        this.mScreenMagnificationAlertDialog = builder.create();
                    }
                    showAlertDialog(this.mScreenMagnificationAlertDialog);
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void showSubmitScoreFailDialog(Intent intent) {
        try {
            runOnUiThread(new Runnable(intent) {
                public final /* synthetic */ Intent f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MPLReactContainerActivity.this.lambda$showSubmitScoreFailDialog$12$MPLReactContainerActivity(this.f$1);
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    private void showToast(String str, int i) {
        try {
            new Handler(new Handler.Callback(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean handleMessage(Message message) {
                    return MPLReactContainerActivity.this.lambda$showToast$2$MPLReactContainerActivity(this.f$1, message);
                }
            }).sendEmptyMessageDelayed(0, (long) i);
        } catch (Exception unused) {
        }
    }

    private void showVpnDialog(Bundle bundle) {
        try {
            String string = bundle.getString("title", "");
            String string2 = bundle.getString("message", "");
            if (TextUtils.isEmpty(string)) {
                string = "Alert!";
            }
            if (TextUtils.isEmpty(string2)) {
                string2 = "Please switch off VPN to proceed furthur";
            }
            NonSealedApkFragment.newInstance(string, string2, getString(17039370), false, Constant.VPN_DIALOG).show(getSupportFragmentManager(), (String) "vpnDialog");
            if (bundle.containsKey("vpnData")) {
                String string3 = bundle.getString("vpnData", "{}");
                if (!TextUtils.isEmpty(string3) && CommonUtils.isJSONValid(string3)) {
                    CleverTapAnalyticsUtils.sendEvent((String) "VPN Popup Shown", string3);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void skipCriticalDownload() {
        MLogger.d(TAG, "skipCriticalDownload: ");
        if (this.initialization.installedApkIntegrityCheckFail(this)) {
            UpdaterAnalytics.integrityCheckFailEvent(3, "Installed APK is corrupted");
            updateView(StatusType.INSTALLED_APK_INTEGRITY_FAIL);
        } else if (!this.initialization.isSafeToLoadRnBundle(this)) {
            UpdaterAnalytics.integrityCheckFailEvent(1, "");
            updateView(StatusType.INTEGRITY_BUNDLE_RESOURCE_FAIL);
        } else {
            MLogger.d(Constant.LOADING_TAG, "onStartInitialization() called: checkUpdateAvailableCall");
            this.initialization.checkUpdateAvailableCall(this, StatusType.CHECKING_UPDATE);
        }
    }

    private void startAppsCheckingTask(ArrayList<String> arrayList) {
        try {
            new AppsCheckingAsyncTask().execute(new ArrayList[]{arrayList});
        } catch (Exception unused) {
            MLogger.e(TAG, "startAppsCheckingTask: ");
        }
    }

    private void startMQTTservice() {
        try {
            MLogger.d(MQTT_TAG, "startMQTTservice: ");
            if (MSharedPreferencesUtils.isMQTTRequired()) {
                if (this.mStartMqttChannelAsyncTask == null) {
                    this.mStartMqttChannelAsyncTask = new StartMqttChannelAsyncTask();
                }
                MLogger.d(MQTT_TAG, "startMQTTservice: ", this.mStartMqttChannelAsyncTask.getStatus());
                if (this.mStartMqttChannelAsyncTask != null && this.mStartMqttChannelAsyncTask.getStatus() == Status.RUNNING) {
                    this.mStartMqttChannelAsyncTask.cancel(true);
                }
                if (this.mStartMqttChannelAsyncTask != null) {
                    this.mStartMqttChannelAsyncTask.execute(new Void[0]);
                }
            }
        } catch (Exception e2) {
            MLogger.e(MQTT_TAG, "startMQTTservice: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void startShareNudges(String str, String str2) {
        if (ConfigManager.getReferralNudgeConfig().optBoolean("enabledv2")) {
            HashMap outline87 = GeneratedOutlineSupport.outline87("Pop Up Title", "Screenshot Nudge");
            outline87.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, CommonUtils.getCurrentScreenName());
            CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.POP_UP_SHOWN, outline87);
            ReferralNudgeApkFragment.newInstance(str, str2, CommonUtils.getCurrentScreenName()).show(getSupportFragmentManager(), (String) "screenshot referral dialogue");
        }
    }

    private void startStoriesCleanUpWork() {
        try {
            if (!MSharedPreferencesUtils.isStoriesCleanUpWorkDone()) {
                MLogger.d("StoriesCleanUpWorker -> MPLReactContainerActivity", "StoriesCleanUpStarted");
                WorkManagerImpl.getInstance(getApplicationContext()).enqueue(new OneTimeWorkRequest.Builder(StoriesCleanUpWorker.class).build());
                MSharedPreferencesUtils.setStoriesCleanUpWorkDone(true);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void submitGameScore(ReactContext reactContext, String str) {
        Class cls = RCTDeviceEventEmitter.class;
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("submitGameScore called with: ", str));
        try {
            MSharedPreferencesUtils.setIsUserPlayingGame(false);
            if (reactContext == null || reactContext.getJSModule(cls) == null) {
                MLogger.e(TAG, "submitGameScore react context or emitter is null");
                return;
            }
            RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) reactContext.getJSModule(cls);
            if (TextUtils.isEmpty(str)) {
                rCTDeviceEventEmitter.emit(Constant.GAME_SCORE, "Quit game");
            } else if (str.startsWith("quitGame")) {
                String trim = str.replace("quitGame", "").trim();
                MLogger.d(TAG, "Data emit to react: " + trim);
                rCTDeviceEventEmitter.emit(Constant.GAME_SCORE, trim);
            } else {
                rCTDeviceEventEmitter.emit(Constant.GAME_SCORE, "{\"gameSession\":" + calculateGameSubmitData(str) + "}");
            }
            this.isSubmitScoreRequire = false;
            this.mScore = null;
            this.mResultIntentAfterUnity = null;
        } catch (Error | Exception e2) {
            MLogger.e(TAG, "submitGameScore", e2);
        }
    }

    /* access modifiers changed from: private */
    public void subscribeToAllContactOnMpl() {
        try {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    List<Contact> allMPLContacts = MPLApplication.getDatabaseClient().getAppDatabase().contactDao().getAllMPLContacts();
                    ArrayList arrayList = new ArrayList();
                    String mQTTClientPrefix = MSharedPreferencesUtils.getMQTTClientPrefix();
                    if (allMPLContacts != null && !allMPLContacts.isEmpty()) {
                        for (int i = 0; i < allMPLContacts.size(); i++) {
                            if (TextUtils.isDigitsOnly(allMPLContacts.get(i).getMplId())) {
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73(mQTTClientPrefix);
                                outline73.append(allMPLContacts.get(i).getMplId());
                                arrayList.add(outline73.toString());
                            }
                        }
                        EventPublishHelper.subscribeToMqttChannel(MPLReactContainerActivity.this, (String[]) arrayList.toArray(new String[arrayList.size()]), true);
                    }
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "subscribeAllContactOnMPL: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void subscribeToAllFollowers() {
        MqttAndroidClient mqttAndroidClient = this.mMQTTClient;
        if (mqttAndroidClient != null && mqttAndroidClient.isConnected()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
            outline73.append(MSharedPreferencesUtils.getAccessUserToken());
            arrayList.add(new MHeader("Authorization", outline73.toString()));
            NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
            NetworkUtils.doGetRequest(builder.setUrl(MBuildConfigUtils.getMainUrl() + ApiEndPoints.FOLLOWER_ID_API).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(MPLReactContainerActivity.MQTT_TAG, "onResponseFail");
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    try {
                        JSONObject optJSONObject = new JSONObject(str).optJSONObject("payload");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("followingIdList");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                ArrayList arrayList = new ArrayList();
                                String mQTTClientPrefix = MSharedPreferencesUtils.getMQTTClientPrefix();
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    if (!TextUtils.isEmpty(optJSONArray.getString(i))) {
                                        arrayList.add(mQTTClientPrefix + optJSONArray.getString(i));
                                    }
                                }
                                if (arrayList.size() > 0 && MSharedPreferencesUtils.isMQTTSubscribeToFollowingRequired()) {
                                    EventPublishHelper.subscribeToMqttChannel(MPLReactContainerActivity.this, (String[]) arrayList.toArray(new String[0]), true);
                                }
                            }
                        }
                    } catch (Exception unused) {
                        MLogger.e(MPLReactContainerActivity.MQTT_TAG, "onResponseSuccess: ");
                    }
                }
            }, "Follower_id_api_call_fail");
        }
    }

    /* access modifiers changed from: private */
    public void subscribeToDynamicTopics(HashSet<String> hashSet) {
        EventPublishHelper.subscribeToMqttChannel(this, (String[]) hashSet.toArray(new String[0]), true);
        EventPublishHelper.subscribeToMqttChannel(this, new String[]{"mpl/superteam"}, true);
    }

    /* access modifiers changed from: private */
    public void subscribeToOwnChannel(String str) {
        MLogger.d(MQTT_TAG, "subscribeToOwnChannel: ");
        try {
            if (this.mMQTTClient != null && this.mMQTTClient.isConnected()) {
                this.mMQTTClient.subscribe(str, 1, (IMqttMessageListener) new IMqttMessageListener() {
                    public final void messageArrived(String str, MqttMessage mqttMessage) {
                        MPLReactContainerActivity.this.lambda$subscribeToOwnChannel$20$MPLReactContainerActivity(str, mqttMessage);
                    }
                });
                this.mMQTTClient.setCallback(new MqttCallbackExtended() {
                    public void connectComplete(boolean z, String str) {
                        MLogger.d(MPLReactContainerActivity.MQTT_TAG, "connectComplete: ", Boolean.valueOf(z));
                        if (z) {
                            int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(MPLReactContainerActivity.this);
                            MPLReactContainerActivity.this.publishOnlineMessageServer(MSharedPreferencesUtils.getMQTTServerPrefix() + userIdInNormalPref, true);
                        }
                    }

                    public void connectionLost(Throwable th) {
                        MLogger.e(MPLReactContainerActivity.MQTT_TAG, "connectionLost: ");
                        if (th != null) {
                            MLogger.e(MPLReactContainerActivity.MQTT_TAG, th.getMessage());
                            MLogger.e(MPLReactContainerActivity.MQTT_TAG, th.getCause());
                            return;
                        }
                        MLogger.e(MPLReactContainerActivity.MQTT_TAG, "connectionLost:cause is null ");
                    }

                    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                        MLogger.d(MPLReactContainerActivity.MQTT_TAG, "deliveryComplete: ");
                    }

                    public void messageArrived(String str, MqttMessage mqttMessage) {
                        MLogger.d(MPLReactContainerActivity.MQTT_TAG, "messageArrived: ", str);
                        if (mqttMessage != null) {
                            String str2 = new String(mqttMessage.getPayload());
                            MLogger.d(MPLReactContainerActivity.MQTT_TAG, "messageArrived: ", str2);
                            EventPublishHelper.publishMqttMessageReceiveEvent(MPLReactContainerActivity.this, str2);
                            EventPublishHelper.publishChallengeCancelData(MPLReactContainerActivity.this, str2);
                            return;
                        }
                        MLogger.d(MPLReactContainerActivity.MQTT_TAG, "messageArrived: Message is null");
                    }
                });
            }
        } catch (MqttException unused) {
            MLogger.e(MQTT_TAG, "subscribeToOwnChannel: ");
        }
    }

    private void suspiciousAppsFound(DialogData dialogData) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.mFraudAlertDialog == null || !this.mFraudAlertDialog.isShowing()) {
                        this.isSplitDialog = dialogData.getDialogType() == TYPE.SPLIT_SCREEN;
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.suspicious_app_found_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                        Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        if (!TextUtils.isEmpty(dialogData.getTitle())) {
                            textView.setTypeface(createFromAsset2);
                            textView.setText(dialogData.getTitle());
                            textView.setVisibility(0);
                        } else {
                            textView.setVisibility(8);
                        }
                        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                        if (!TextUtils.isEmpty(dialogData.getBody())) {
                            textView2.setTypeface(createFromAsset);
                            textView2.setText(dialogData.getBody());
                            textView2.setVisibility(0);
                        } else {
                            textView2.setVisibility(8);
                        }
                        Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                        if (!TextUtils.isEmpty(dialogData.getOkButton())) {
                            button.setTypeface(createFromAsset2);
                            button.setText(dialogData.getOkButton());
                            button.setVisibility(0);
                        } else {
                            button.setVisibility(8);
                        }
                        Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel);
                        if (!TextUtils.isEmpty(dialogData.getCancelButton())) {
                            button2.setTypeface(createFromAsset);
                            button2.setText(dialogData.getCancelButton());
                            button2.setVisibility(0);
                        } else {
                            button2.setVisibility(8);
                        }
                        builder.setView(inflate);
                        builder.setCancelable(false);
                        builder.setIcon(R.mipmap.ic_launcher);
                        AlertDialog create = builder.create();
                        this.mFraudAlertDialog = create;
                        Window window = create.getWindow();
                        LayoutParams attributes = window.getAttributes();
                        attributes.width = -1;
                        attributes.gravity = 80;
                        attributes.flags &= -3;
                        window.setAttributes(attributes);
                        button.setOnClickListener(new OnClickListener(dialogData) {
                            public final /* synthetic */ DialogData f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                MPLReactContainerActivity.this.lambda$suspiciousAppsFound$24$MPLReactContainerActivity(this.f$1, view);
                            }
                        });
                        showAlertDialog(this.mFraudAlertDialog);
                        HashMap hashMap = new HashMap();
                        hashMap.put(EventsConstants.POP_UP_NAME, dialogData.getPopUpName());
                        CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.POP_UP_SHOWN, hashMap);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    private void syncCrash() {
        this.viewModel.crashLogged();
    }

    private void unbindService() {
        if (this.isBoundService) {
            this.isBoundService = false;
            unbindService(this.mServiceConnection);
        }
    }

    private void unregisterReceivers() {
        try {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mSetContentViewReceiver);
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mBackgroundTaskReceiver);
            if (this.mRecordingMonitorReceiver != null) {
                unregisterReceiver(this.mRecordingMonitorReceiver);
            }
            if (this.mInstallBroadCastReceiver != null) {
                unregisterReceiver(this.mInstallBroadCastReceiver);
            }
            if (this.broadcastReceiver != null) {
                LocalBroadcastManager.getInstance(getApplicationContext()).unregisterReceiver(this.broadcastReceiver);
            }
            if (this.notificationCancelReciever != null) {
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.notificationCancelReciever);
            }
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.geoSpoofingDetectedReceiver);
            unregisterReceiver(this.mGameDisconnectReceiver);
        } catch (Exception unused) {
            MLogger.d(TAG, "unregisterReceivers: ");
        } catch (Throwable th) {
            this.isRegister = false;
            throw th;
        }
        this.isRegister = false;
    }

    private void updateApkProgress(Bundle bundle) {
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        Class cls;
        String str5;
        Bundle bundle2 = bundle;
        Class cls2 = RCTDeviceEventEmitter.class;
        if (this.mReactInstanceManager != null && this.mReactContext != null) {
            JSONObject jSONObject = new JSONObject();
            int i = bundle2.getInt("progress");
            int i2 = bundle2.getInt("gameId");
            int i3 = bundle2.getInt("id");
            if (bundle2.containsKey("status")) {
                obj = bundle2.getString("status");
            } else {
                obj = "";
            }
            if (bundle2.containsKey("gameIconUrl")) {
                str = bundle2.getString("gameIconUrl");
            } else {
                str = "";
            }
            if (bundle2.containsKey("gameName")) {
                str2 = bundle2.getString("gameName");
            } else {
                str2 = "";
            }
            if (bundle2.containsKey("notificationStatus")) {
                str4 = bundle2.getString("notificationStatus");
                str3 = "";
            } else {
                str4 = "";
                str3 = str4;
            }
            if (bundle2.containsKey("packageName")) {
                str5 = bundle2.getString("packageName");
                cls = cls2;
            } else {
                cls = cls2;
                str5 = str3;
            }
            if (bundle2.containsKey("serverVersion")) {
                str3 = bundle2.getString("serverVersion");
            }
            String str6 = str5;
            boolean z = bundle2.containsKey("isForceUpdate") ? bundle2.getBoolean("isForceUpdate") : false;
            MLogger.d(TAG, "updateApkProgress:GameLaunchHelper ", Integer.valueOf(i), obj, str4);
            try {
                jSONObject.put("id", i3);
                jSONObject.put("progress", i);
                jSONObject.put("gameId", i2);
                jSONObject.put("status", obj);
                ApkDownloadNotificationData apkDownloadNotificationData = new ApkDownloadNotificationData();
                apkDownloadNotificationData.setContext(this);
                apkDownloadNotificationData.setPercentage(i);
                apkDownloadNotificationData.setGameIconUrl(str);
                apkDownloadNotificationData.setGameName(str2);
                apkDownloadNotificationData.setPackageName(str6);
                apkDownloadNotificationData.setGameId(i2);
                apkDownloadNotificationData.setDownloaded(false);
                apkDownloadNotificationData.setServerVersion(str3);
                apkDownloadNotificationData.setForceUpdate(z);
                if (i3 == 990 && this.mNotificationBuilder != null && "downloading".equalsIgnoreCase(str4)) {
                    this.mNotificationBuilder.createApkDownloadIntent(apkDownloadNotificationData, this, i);
                }
                if (i3 == 990) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit("third_party_apk_download_progress", jSONObject.toString());
                } else {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit("apk_download_progress", jSONObject.toString());
                }
            } catch (JSONException e2) {
                MLogger.e(TAG, "ClientHandler", e2);
            }
        }
    }

    private void updateItemArrayList(ArrayList<UpdateItem> arrayList, boolean z, boolean z2) {
        arrayList.add(new UpdateItem());
        arrayList.add(new UpdateItem());
        arrayList.add(new UpdateItem());
        this.mBinding.releaseNoteLayoutMain.setVisibility(0);
        this.mBinding.updateItemList.setAdapter(new UpdateListAdapter(arrayList, true));
        this.mBinding.releaseNoteBtnDownload.setOnClickListener(new OnClickListener(z2, z) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                MPLReactContainerActivity.this.lambda$updateItemArrayList$4$MPLReactContainerActivity(this.f$1, this.f$2, view);
            }
        });
        slideUp(this.mBinding.releaseNoteContainer);
    }

    public void addScreenShotFileObserver(final Context context) {
        if (!ConfigManager.getReferralNudgeConfig().optBoolean("enabledv2") || this.mScreenShotContentObserver != null) {
            unregisterScreenShotFileObserver();
            return;
        }
        MLogger.d(TAG, "addScreenShotFileObserver: ");
        HandlerThread handlerThread = new HandlerThread("content_observer");
        handlerThread.start();
        MSharedPreferencesUtils.setContentObservercount(1);
        this.mScreenShotContentObserver = new ContentObserver(new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        }) {
            public boolean deliverSelfNotifications() {
                MLogger.d(MPLReactContainerActivity.TAG, "deliverSelfNotifications");
                return super.deliverSelfNotifications();
            }

            public void onChange(boolean z) {
                super.onChange(z);
                MLogger.d(MPLReactContainerActivity.TAG, "onChange: ");
            }

            public void onChange(boolean z, Uri uri) {
                if (MSharedPreferencesUtils.getContentObservercount() == 1) {
                    MSharedPreferencesUtils.setContentObservercount(2);
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("onChange ");
                    outline73.append(uri.toString());
                    MLogger.d(MPLReactContainerActivity.TAG, outline73.toString());
                    if (MPLReactContainerActivity.this.checkPermission(SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY)) {
                        HashMap outline87 = GeneratedOutlineSupport.outline87("Storage permission", BaseParser.TRUE);
                        outline87.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, CommonUtils.getCurrentScreenName());
                        CleverTapAnalyticsUtils.sendEvent((String) "Screenshot Taken", outline87);
                        MPLReactContainerActivity.this.openScreenShotNudges(uri);
                    } else if (MSharedPreferencesUtils.getNudgePermissionDialogCount(context) < ConfigManager.getReferralNudgeConfig().optInt("permission.count", 4)) {
                        MPLReactContainerActivity.this.mScreenShotURI = uri;
                        MSharedPreferencesUtils.increaseNudgePermissionDialogCount(context);
                        ActivityCompat.requestPermissions(MPLReactContainerActivity.this, new String[]{SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY}, 1024);
                    }
                    super.onChange(z, uri);
                }
            }
        };
        getContentResolver().registerContentObserver(Media.EXTERNAL_CONTENT_URI, true, this.mScreenShotContentObserver);
    }

    public void checkAppSealingServices() {
        if (ConfigManager.getNormalConfig() != null && ConfigManager.getNormalConfig().has("appSealing.config")) {
            JSONObject optJSONObject = ConfigManager.getNormalConfig().optJSONObject("appSealing.config");
            if (optJSONObject != null) {
                if (optJSONObject.optBoolean(RNGestureHandlerModule.KEY_ENABLED, false)) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("componentList");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            ComponentName componentName = new ComponentName(getPackageName(), optJSONArray.optString(i));
                            if (!CommonUtils.isComponentEnabled(MPLApplication.getInstance(), componentName)) {
                                runOnUiThread(new Runnable(componentName, optJSONObject) {
                                    public final /* synthetic */ ComponentName f$1;
                                    public final /* synthetic */ JSONObject f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        MPLReactContainerActivity.this.lambda$checkAppSealingServices$25$MPLReactContainerActivity(this.f$1, this.f$2);
                                    }
                                });
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkPermission(String str) {
        if (VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(this, str) == 0) {
            return true;
        }
        return false;
    }

    public void cleverTapEventInstallAPKButtonClicked(boolean z) {
        if (MSharedPreferencesUtils.getUpdaterV2Enabled()) {
            HashMap outline88 = GeneratedOutlineSupport.outline88(EventsConstants.SCREEN_NAME, "Install App Update Pop Up", EventsConstants.CTA, "Install Now");
            outline88.put(EventsConstants.IS_CRITICAL, Boolean.valueOf(MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()));
            outline88.put(EventsConstants.UPDATE_VERSION, Integer.valueOf(MSharedPreferencesUtils.getUpdater2Version()));
            outline88.put(EventsConstants.IS_SKIPPABLE, Boolean.valueOf(MSharedPreferencesUtils.canSkipPopup()));
            outline88.put("Entry Point", "Splash Screen");
            outline88.put(EventsConstants.ELIGIBILITY_CRITERIA, MSharedPreferencesUtils.getEligibilityCriteria());
            outline88.put(EventsConstants.HAS_RELEASE_NOTES, Boolean.valueOf(z));
            outline88.put(EventsConstants.UPDATER_VERSION, Integer.valueOf(2));
            CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", outline88);
        }
    }

    public void downloadPokerAssets(JSONObject jSONObject) {
    }

    public void fetchFireBaseToken() {
        try {
            Task<String> token = FirebaseMessaging.getInstance().getToken();
            $$Lambda$MPLReactContainerActivity$W9ebLBxdyUGcUfsHHldltop6u8M r1 = new OnSuccessListener() {
                public final void onSuccess(Object obj) {
                    MPLReactContainerActivity.this.lambda$fetchFireBaseToken$23$MPLReactContainerActivity((String) obj);
                }
            };
            zzw zzw = (zzw) token;
            if (zzw != null) {
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r1);
                return;
            }
            throw null;
        } catch (Exception unused) {
        }
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }

    public FusedLocationProviderClient getFusedLocationClient() {
        return this.fusedLocationClient;
    }

    public void getIdThread() {
        try {
            MLogger.d(TAG, "getIdThread: [START]");
            String androidId = new DeviceInfo(this).getAndroidId();
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this);
            Intent intent = new Intent(Constant.ACTION_BACKGROUND_TASK);
            intent.putExtra("taskName", "GoogleIdTask");
            if (advertisingIdInfo != null) {
                String id = advertisingIdInfo.getId();
                if (!TextUtils.isEmpty(androidId)) {
                    intent.putExtra(Constant.HEADER_ANDROID_DEVICE_ID, androidId);
                }
                if (!TextUtils.isEmpty(id)) {
                    intent.putExtra("googleId", id);
                    MSharedPreferencesUtils.saveStringInNormalPref(getApplicationContext(), Constant.ADVERTISIING_ID, id);
                }
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                MLogger.d(TAG, "getIdThread:[END] ", id, androidId);
            }
        } catch (GooglePlayServicesNotAvailableException | IOException unused) {
        } catch (GooglePlayServicesRepairableException e2) {
            MLogger.printStackTrace(e2);
        } catch (Exception e3) {
            MLogger.e(TAG, "getIdThread: ", e3);
        }
    }

    public PaymentCallBackListener getImagePickerCallBackListener() {
        return this.mImagePickerCallBackListener;
    }

    public MqttAndroidClient getMqttClientInstance() {
        return this.mMQTTClient;
    }

    public boolean havingExtraPermissions(String str) {
        String str2;
        String str3;
        boolean z = true;
        boolean z2 = false;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(str, 4096);
            MLogger.d(TAG, "IntegrityCheck", "Total permission: ");
            if (packageInfo != null) {
                String str4 = "Y29tLm1wbC5hbmRyb2lkYXBwLmZyZWUucGVybWlzc2lvbi5NSVBVU0hfUkVDRUlWRQ==";
                if (MBuildConfigUtils.isSecondaryApp()) {
                    str3 = ConfigConstant.BONUS_TOKEN_STRING_FREE;
                    str2 = new String(Base64.decode(ConfigConstant.BONUS_STRING_FREE, 0), StandardCharsets.UTF_8);
                } else if (MBuildConfigUtils.isCashApp()) {
                    str3 = "Y29tLm1wbC5hbmRyb2lkYXBwLnBlcm1pc3Npb24uQzJEX01FU1NBR0U=";
                    str4 = ConfigConstant.BONUS_TOKEN_MI_PUSH_RECEIVE_STRING_PRO;
                    str2 = new String(Base64.decode("Y29tLm1wbC5hbmRyb2lkYXBw", 0), StandardCharsets.UTF_8);
                } else {
                    str3 = "Y29tLm1wbC5hbmRyb2lkYXBwLnBzLnBlcm1pc3Npb24uQzJEX01FU1NBR0U=";
                    str2 = new String(Base64.decode("Y29tLm1wbC5hbmRyb2lkYXBwLnBz", 0), StandardCharsets.UTF_8);
                }
                MLogger.d(TAG, "IntegrityCheck", "havingExtraPermissions() called with: ownPermission = [" + str3 + CMapParser.MARK_END_OF_ARRAY, "packageName", str2, "miPushPermission", str4);
                if (packageInfo.permissions != null) {
                    MLogger.d(TAG, "havingExtraPermissions: ", Integer.valueOf(packageInfo.permissions.length));
                    if (packageInfo.permissions.length > 2) {
                        MLogger.d(TAG, "IntegrityCheck", "havingExtraPermissions: permission: ", Integer.valueOf(packageInfo.permissions.length));
                        return true;
                    }
                    int i = 0;
                    while (i < packageInfo.permissions.length) {
                        if (!packageInfo.permissions[i].name.contains(str2)) {
                            MLogger.d(TAG, "IntegrityCheck", "havingExtraPermissions:Require permission not having package name");
                            return true;
                        } else if (str3.equalsIgnoreCase(Base64.encodeToString(packageInfo.permissions[i].name.getBytes(), 2)) || str4.equalsIgnoreCase(Base64.encodeToString(packageInfo.permissions[i].name.getBytes(), 2))) {
                            i++;
                        } else {
                            MLogger.d(TAG, "IntegrityCheck", "havingExtraPermissions: Require permission not available");
                            return true;
                        }
                    }
                }
                if (packageInfo.requestedPermissions != null) {
                    int length = packageInfo.requestedPermissions.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if ((packageInfo.requestedPermissionsFlags[i2] & 2) != 0 && !CommonUtils.requestedPermissions.contains(packageInfo.requestedPermissions[i2])) {
                                MLogger.d(TAG, "IntegrityCheck", "Not having permission: ", packageInfo.requestedPermissions[i2]);
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                    z2 = z;
                    return z2;
                }
            }
            z = false;
            z2 = z;
        } catch (Exception e2) {
            MLogger.d(TAG, "IntegrityCheck", "havingExtraPermissions: Exception in permission check", e2);
        }
        return z2;
    }

    public void hideMultiScreenDialog() {
        super.hideMultiScreenDialog();
        MLogger.d(TAG, "hideMultiScreenDialog: ");
        AlertDialog alertDialog2 = this.mFraudAlertDialog;
        if (alertDialog2 != null && alertDialog2.isShowing() && this.isSplitDialog) {
            this.mFraudAlertDialog.dismiss();
            this.mFraudAlertDialog = null;
        }
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    public boolean isEventSentForInstall(int i, String str) {
        MPLApplication instance = MPLApplication.getInstance();
        return MSharedPreferencesUtils.getBooleanInNormalPref(instance, "install_apk_event_for_" + i + "_sent_" + str, false);
    }

    public boolean isHasRequiredPermission() {
        return ContextCompat.checkSelfPermission(this, SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY) == 0 && ContextCompat.checkSelfPermission(this, SMTConfigConstants.READ_STORAGE_PERMISSION_MF_KEY) == 0 && ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0;
    }

    public boolean isMetaTempered() {
        boolean z = false;
        try {
            Set keySet = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.keySet();
            MLogger.d(TAG, "isMetaTempered: ", Integer.valueOf(keySet.size()));
            if (keySet.size() > 46) {
                return true;
            }
            MLogger.d("IntegrityCheck", "isMetaTempered() called", Integer.valueOf(keySet.size()));
            Iterator it = keySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (!str.contains("multiple") && !str.contains("parallel") && !str.contains("clone") && !str.contains("dualspace") && !str.contains("multiaccount") && !str.contains("appcloner") && !str.contains("applisto") && !str.contains("dual") && !str.contains("gameplugins")) {
                    if (str.contains("cloner")) {
                        break;
                    }
                } else {
                    z = true;
                }
            }
            z = true;
            return z;
        } catch (NameNotFoundException e2) {
            MLogger.e("IntegrityCheck", "isMetaTempered: ", e2);
        }
    }

    public /* synthetic */ void lambda$checkAppSealingServices$25$MPLReactContainerActivity(ComponentName componentName, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("Service Name", componentName.getShortClassName());
        CleverTapAnalyticsUtils.sendEvent((String) "Service Disabled Detected", hashMap);
        showNetworkErrorDialog(jSONObject.optString("title", ""), jSONObject.optString("message", ""), getString(17039370), true, false);
    }

    public /* synthetic */ void lambda$checkFraudApps$17$MPLReactContainerActivity(long j, String str, String str2, String str3) {
        try {
            CommonUtils.showToast(this, false, "Time taken after detecting apps: ", Long.valueOf(System.currentTimeMillis() - j));
            HashMap hashMap = new HashMap();
            hashMap.put("App Name", str);
            hashMap.put("Entry Point", "Home Screen");
            CleverTapAnalyticsUtils.sendEvent((String) "Banned App Present", hashMap);
            showNetworkErrorDialog(str2, str3, getString(17039370), true, false);
        } catch (Exception unused) {
            MLogger.e(TAG, "run:checkFraudApps ");
        }
    }

    public /* synthetic */ void lambda$checkFraudApps$18$MPLReactContainerActivity(long j) {
        CommonUtils.showToast(this, false, "Time taken after no App detection: ", Long.valueOf(System.currentTimeMillis() - j));
    }

    public /* synthetic */ void lambda$detectAccessibilitySetting$16$MPLReactContainerActivity() {
        if (Util.isMagnificationSettingEnabled(this)) {
            Toast.makeText(getApplicationContext(), "Screen Magnification ON", 0).show();
            showScreenMagnificationDialog("", "");
        }
    }

    public /* synthetic */ void lambda$fetchFireBaseToken$23$MPLReactContainerActivity(String str) {
        MLogger.d(TAG, str);
        if (TextUtils.isEmpty(str)) {
            str = MSharedPreferencesUtils.getOneSignalPushToken();
        }
        Hansel.setNewToken(MPLApplication.getInstance(), str);
        Freshchat.getInstance(MPLApplication.getInstance()).setPushRegistrationToken(str);
        MSharedPreferencesUtils.putOneSignalPushToken(str);
        CommonUtils.saveFireBaseTokenToServer(str);
        if (CleverTapAPI.getDefaultInstance(getApplicationContext()) != null) {
            CleverTapAPI.getDefaultInstance(getApplicationContext()).pushFcmRegistrationId(str, true);
        }
    }

    public /* synthetic */ void lambda$initInternalEventSdks$19$MPLReactContainerActivity() {
        DatabaseClient.getInstance(getApplicationContext()).sendData();
        DatabaseClient.getInstance(getApplicationContext()).sendDataAll();
    }

    public /* synthetic */ void lambda$runTasksOnBackgroundThread$13$MPLReactContainerActivity(Context context) {
        try {
            MSharedPreferencesUtils.moveUserIdInNormalPref(context);
            MSharedPreferencesUtils.moveMobileNumberInNormalPref(context);
            MSharedPreferencesUtils.removeBranchReferralData(context);
            CommonUtils.deleteToSDFile(context);
            sendUpdateInfoToServer();
            this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
            startMQTTservice();
            checkAllNotificationChannels();
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("runBGTask: Exception : ")));
        }
    }

    public /* synthetic */ void lambda$runTasksOnBackgroundThreadAfterHomeLoaded$14$MPLReactContainerActivity(Context context) {
        try {
            AppsFlyerLib.getInstance().setCurrencyCode(CountryUtils.getCurrencyCode());
            if (MSharedPreferencesUtils.isUserTierUpgraded()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("Previous Tier", MSharedPreferencesUtils.getUserCurrentTier());
                jSONObject.put("Current Tier", MSharedPreferencesUtils.getUserTier());
                Util.pushBranchEventWithProp("User Profile Upgrade");
                if (!MSharedPreferencesUtils.isBronzeTierUpgradeEventSent() && MSharedPreferencesUtils.getUserTier() != null && !TextUtils.isEmpty(MSharedPreferencesUtils.getUserTier()) && "BRONZE".equalsIgnoreCase(MSharedPreferencesUtils.getUserTier())) {
                    Util.pushBranchEventWithProp("Reached Bronze Tier");
                    MSharedPreferencesUtils.setBronzeTierUpgradeEventSent(true);
                }
                MSharedPreferencesUtils.setUserCurrentTier();
            }
            JobSchedulerHelper.scheduleJob(context);
            JobSchedulerHelper.checkAllJobScheduled(context);
            sendDauEventToAppsFlyer();
            FirebaseCrashlytics.getInstance().setUserId(String.valueOf(MSharedPreferencesUtils.getUserIdInNormalPref(context)));
            sendUserInfoToFreshChat(MSharedPreferencesUtils.getUserIdInNormalPref(context), MSharedPreferencesUtils.getUserName());
            deleteThirdPartiesApks();
            detectAccessibilitySetting();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ACTION_BANNED_APP);
            arrayList.add(ACTION_GAME_TEMPERED_APP);
            arrayList.add(ACTION_GOOGLE_ID);
            if (MSharedPreferencesUtils.getCompetitorsAppsListEventCheck()) {
                long lastTimeEventSentTime = MSharedPreferencesUtils.getLastTimeEventSentTime(this);
                if (lastTimeEventSentTime == 0 || new DateTime(lastTimeEventSentTime).plusDays(7).isBeforeNow()) {
                    arrayList.add(ACTION_GAME_COMPETITOR_APP);
                    MSharedPreferencesUtils.saveLastTimeEventSentTime(this, DateTime.now());
                }
            } else {
                MSharedPreferencesUtils.setCompetitorsAppsListEventSend(this, false);
            }
            startAppsCheckingTask(arrayList);
        } catch (Exception e2) {
            MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("runBGTask: Exception : ")));
        }
    }

    public /* synthetic */ void lambda$setScreenSecure$26$MPLReactContainerActivity(Boolean bool) {
        if (bool.booleanValue()) {
            getWindow().setFlags(8192, 8192);
        } else {
            getWindow().clearFlags(8192);
        }
    }

    public /* synthetic */ void lambda$setSplashImage$5$MPLReactContainerActivity(boolean z, Throwable th) {
        MLogger.d(TAG, "onResult:setSplashImage ");
        startReactAfterAnimation(z);
        if (th != null) {
            MLogger.d(TAG, "onResult:setSplashImage ", th.toString());
        }
    }

    public /* synthetic */ void lambda$setUpView$0$MPLReactContainerActivity(View view) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "setUpView:buttonStatus ", this.buttonStatus);
        int ordinal = this.buttonStatus.ordinal();
        if (ordinal != 3) {
            if (ordinal == 7) {
                UpdaterAnalytics.internetCheckFailed();
                integrityCheck();
                return;
            } else if (ordinal == 14) {
                Util.openAppInPlayStore(this);
                return;
            } else if (ordinal != 17) {
                switch (ordinal) {
                    case 9:
                        if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                            UpdaterAnalytics.integrityFailedCTA();
                            Util.openLinkInBrowser(this);
                            return;
                        }
                        UpdaterAnalytics.integrityFailedCTA();
                        Util.openAppInPlayStore(this);
                        return;
                    case 10:
                        if (MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()) {
                            Util.openLinkInBrowser(this);
                            return;
                        } else {
                            Util.openAppInPlayStore(this);
                            return;
                        }
                    case 11:
                        break;
                    case 12:
                        System.exit(0);
                        return;
                    default:
                        return;
                }
            } else {
                UpdaterAnalytics.internetCheckFailed();
                integrityCheck();
                return;
            }
        }
        Util.apkInstall(this);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Button Name", "App Update - Install");
            CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void lambda$showLogOutDialog$21$MPLReactContainerActivity(View view) {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            MSharedPreferencesUtils.deleteAllPref(MPLApplication.getInstance(), true);
        }
    }

    public /* synthetic */ boolean lambda$showLogOutDialog$22$MPLReactContainerActivity(Message message) {
        try {
            if (this.alertDialog != null && this.alertDialog.isShowing()) {
                this.alertDialog.dismiss();
            }
            MSharedPreferencesUtils.deleteAllPref(MPLApplication.getInstance(), true);
        } catch (Exception unused) {
        }
        return false;
    }

    public /* synthetic */ void lambda$showNetworkErrorDialog$9$MPLReactContainerActivity(boolean z, View view) {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            if (z) {
                System.exit(0);
            }
        }
    }

    public /* synthetic */ void lambda$showOptimizationToast$7$MPLReactContainerActivity() {
        try {
            View inflate = getLayoutInflater().inflate(R.layout.auto_start_permission_layout, (ViewGroup) findViewById(R.id.auto_start_toast_layout));
            Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
            ((TextView) inflate.findViewById(R.id.auto_start_title)).setTypeface(createFromAsset);
            ((TextView) inflate.findViewById(R.id.auto_start_button)).setTypeface(createFromAsset);
            Toast toast = new Toast(getApplicationContext());
            toast.setView(inflate);
            toast.setDuration(1);
            toast.setGravity(80, 0, 0);
            toast.show();
        } catch (Exception e2) {
            MLogger.e(TAG, "showOptimizationToast", e2);
        }
    }

    public /* synthetic */ boolean lambda$showOptimizationToast$8$MPLReactContainerActivity(Message message) {
        if (!isFinishing()) {
            runOnUiThread(new Runnable() {
                public final void run() {
                    MPLReactContainerActivity.this.lambda$showOptimizationToast$7$MPLReactContainerActivity();
                }
            });
        }
        return true;
    }

    public /* synthetic */ void lambda$showSubmitScoreFailDialog$10$MPLReactContainerActivity(Intent intent, View view) {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            doSubmitFromNative(intent);
        }
    }

    public /* synthetic */ void lambda$showSubmitScoreFailDialog$11$MPLReactContainerActivity(View view) {
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "OPEN_DEEP_LINK");
            jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Home\",\"param\":{}}}");
            emitDataToReact(jSONObject.toString());
        } catch (Exception e2) {
            MLogger.e(TAG, "onClick: ", e2);
        }
    }

    public /* synthetic */ void lambda$showSubmitScoreFailDialog$12$MPLReactContainerActivity(Intent intent) {
        if (!isFinishing() && !isDestroyed()) {
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null && alertDialog2.isShowing()) {
                this.alertDialog.dismiss();
                this.alertDialog = null;
            }
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
            if (this.alertDialog == null && layoutInflater != null) {
                View inflate = layoutInflater.inflate(R.layout.submit_score_fail_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                ((TextView) inflate.findViewById(R.id.dialog_title)).setTypeface(createFromAsset);
                ((TextView) inflate.findViewById(R.id.dialog_msg)).setTypeface(createFromAsset2);
                Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel);
                button.setTypeface(createFromAsset);
                button2.setTypeface(createFromAsset);
                button.setOnClickListener(new OnClickListener(intent) {
                    public final /* synthetic */ Intent f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        MPLReactContainerActivity.this.lambda$showSubmitScoreFailDialog$10$MPLReactContainerActivity(this.f$1, view);
                    }
                });
                button2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        MPLReactContainerActivity.this.lambda$showSubmitScoreFailDialog$11$MPLReactContainerActivity(view);
                    }
                });
                builder.setView(inflate);
                builder.setCancelable(false);
                this.alertDialog = builder.create();
            }
            showAlertDialog(this.alertDialog);
        }
    }

    public /* synthetic */ void lambda$showToast$1$MPLReactContainerActivity(String str) {
        String str2;
        String str3;
        String str4;
        View view;
        try {
            String str5 = "";
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("title", str5);
                str4 = jSONObject.optString("message", str5);
                str3 = jSONObject.optString("position", str5);
                str5 = jSONObject.optString("toastType", str5);
            } else {
                str2 = str5;
                str4 = str2;
                str3 = str4;
            }
            if (TextUtils.isEmpty(str5) || !"Install".equalsIgnoreCase(str5)) {
                view = getLayoutInflater().inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.custom_toast_layout));
            } else {
                view = getLayoutInflater().inflate(R.layout.toast_tooltip, (ViewGroup) findViewById(R.id.custom_toast_layout));
            }
            TextView textView = (TextView) view.findViewById(R.id.title);
            TextView textView2 = (TextView) view.findViewById(R.id.message);
            if (!TextUtils.isEmpty(str2) && textView != null) {
                textView.setText(str2);
            }
            if (!TextUtils.isEmpty(str4) && textView2 != null) {
                textView2.setText(str4);
            }
            Toast toast = new Toast(getApplicationContext());
            if (textView != null) {
                textView.setTypeface(this.mRobotoBoldFont);
            }
            if (textView2 != null) {
                textView2.setTypeface(this.mRobotoRegularFont);
            }
            toast.setView(view);
            toast.setDuration(1);
            if (TextUtils.isEmpty(str3)) {
                toast.setGravity(16, 0, 0);
            } else if (str3.equalsIgnoreCase(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM)) {
                toast.setGravity(81, 0, 0);
            } else if (str3.equalsIgnoreCase(RNGestureHandlerModule.KEY_HIT_SLOP_TOP)) {
                toast.setGravity(49, 0, 0);
            } else if (str3.equalsIgnoreCase("center")) {
                toast.setGravity(17, 0, 0);
            }
            toast.show();
        } catch (Exception e2) {
            MLogger.e(TAG, "showToast", e2);
        }
    }

    public /* synthetic */ boolean lambda$showToast$2$MPLReactContainerActivity(String str, Message message) {
        if (!isFinishing()) {
            runOnUiThread(new Runnable(str) {
                public final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MPLReactContainerActivity.this.lambda$showToast$1$MPLReactContainerActivity(this.f$1);
                }
            });
        }
        return true;
    }

    public /* synthetic */ void lambda$subscribeToOwnChannel$20$MPLReactContainerActivity(String str, MqttMessage mqttMessage) throws Exception {
        MLogger.d(MQTT_TAG, "messageArrived: ", str);
        if (mqttMessage != null) {
            String str2 = new String(mqttMessage.getPayload());
            MLogger.d(MQTT_TAG, "messageArrived: ", str2);
            EventPublishHelper.publishMqttMessageReceiveEvent(this, str2);
            EventPublishHelper.publishChallengeCancelData(this, str2);
            return;
        }
        MLogger.d(MQTT_TAG, "messageArrived: Message is null");
    }

    public /* synthetic */ void lambda$suspiciousAppsFound$24$MPLReactContainerActivity(DialogData dialogData, View view) {
        AlertDialog alertDialog2 = this.mFraudAlertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        if (!dialogData.isShouldCloseApp()) {
            openSettingApplication();
        } else {
            System.exit(0);
        }
    }

    public /* synthetic */ void lambda$updateItemArrayList$4$MPLReactContainerActivity(boolean z, boolean z2, View view) {
        ServiceUtil.clearNotification(this, ServiceUtil.INSTALL_UPDATE_NOTIF_ID);
        Util.apkInstall(this);
        if (z) {
            cleverTapEventInstallAPKButtonClicked(z2);
        }
    }

    public /* synthetic */ void lambda$updateView$3$MPLReactContainerActivity(View view) {
        ServiceUtil.clearNotification(this, ServiceUtil.INSTALL_UPDATE_NOTIF_ID);
        Util.apkInstall(this);
        cleverTapEventInstallAPKButtonClicked(true);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onActivityResult(int i, int i2, Intent intent) {
        Class cls = RCTDeviceEventEmitter.class;
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("onActivityResult() called with: requestCode = [", i, "], resultCode = [", i2, "], data = [");
        outline75.append(intent);
        outline75.append(CMapParser.MARK_END_OF_ARRAY);
        MLogger.d(TAG, outline75.toString());
        setRequestedOrientation(1);
        CallbackManager callbackManager = this.mCallbackManager;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
        if (i == 1002) {
            if (intent != null && intent.hasExtra("isExamFinished") && intent.hasExtra("gameId")) {
                boolean booleanExtra = intent.getBooleanExtra("isExamFinished", false);
                int intExtra = intent.getIntExtra("gameId", 0);
                String str = "web_app_exam_quit";
                if (this.mReactInstanceManager != null) {
                    ReactContext reactContext = this.mReactContext;
                    if (reactContext != null) {
                        RCTDeviceEventEmitter rCTDeviceEventEmitter = (RCTDeviceEventEmitter) reactContext.getJSModule(cls);
                        if (intExtra != 55 || booleanExtra) {
                            str = "web_app_quit";
                        }
                        rCTDeviceEventEmitter.emit(Constant.GAME_SCORE, str);
                    }
                }
                RCTDeviceEventEmitter rCTDeviceEventEmitter2 = this.reactEmitter;
                if (rCTDeviceEventEmitter2 != null) {
                    if (intExtra != 55 || booleanExtra) {
                        str = "web_app_quit";
                    }
                    rCTDeviceEventEmitter2.emit(Constant.GAME_SCORE, str);
                }
            } else if (intent != null && intent.hasExtra("GameId") && intent.hasExtra("TournamentId") && !TextUtils.isEmpty(intent.getStringExtra("TournamentId")) && Util.isTopQuiz((int) intent.getLongExtra("GameId", 0))) {
                openRankResultScreen(intent);
            } else if (i2 != -1 && intent == null) {
                if (this.mReactInstanceManager != null) {
                    ReactContext reactContext2 = this.mReactContext;
                    if (reactContext2 != null) {
                        ((RCTDeviceEventEmitter) reactContext2.getJSModule(cls)).emit(Constant.GAME_SCORE, "home_quit");
                    }
                }
                RCTDeviceEventEmitter rCTDeviceEventEmitter3 = this.reactEmitter;
                if (rCTDeviceEventEmitter3 != null) {
                    rCTDeviceEventEmitter3.emit(Constant.GAME_SCORE, "home_quit");
                }
            } else if (i2 != -1 && intent.hasExtra("isAddMoneyRequired")) {
                try {
                    if (intent.getBooleanExtra("isAddMoneyRequired", false)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("action", "OPEN_DEEP_LINK");
                        jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"AddMoney\",\"param\":{}}}");
                        emitDataToReact(jSONObject.toString());
                    }
                } catch (Exception unused) {
                }
            }
        } else if (i == 1008) {
            MLogger.d(TAG, "onActivityResult: Sending Poker exit data to react");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BraintreeConstants.NS_EXTRAINFO, "poker_web_quit");
            if (this.mReactInstanceManager != null && this.mReactContext != null) {
                ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GAME_SCORE, jSONObject2.toString());
            } else if (this.reactEmitter != null) {
                this.reactEmitter.emit(Constant.GAME_SCORE, jSONObject2.toString());
            }
        } else if (i == 4322) {
            MLogger.d(TAG, "onActivityResult: Sending data for third party apks");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(BraintreeConstants.NS_EXTRAINFO, "home_quit");
            if (this.mReactInstanceManager != null && this.mReactContext != null) {
                ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GAME_SCORE, jSONObject3.toString());
            } else if (this.reactEmitter != null) {
                this.reactEmitter.emit(Constant.GAME_SCORE, jSONObject3.toString());
            }
        }
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            if (reactInstanceManager.getCurrentReactContext() != null) {
                ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
                if (currentReactContext != null) {
                    currentReactContext.onActivityResult(this, i, i2, intent);
                }
            } else if (this.mPaymentCallBackListener != null && (i == 2392 || i == 2393 || i == 2394 || i == 2397)) {
                this.mPaymentCallBackListener.processResponce(this, i, i2, intent);
            } else if (this.mImagePickerCallBackListener != null && ImagePickerModule.isValidRequestCode(i)) {
                this.mImagePickerCallBackListener.processResponce(this, i, i2, intent);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        PaymentCallBackListener paymentCallBackListener = this.mPaymentCallBackListener;
        if (!(paymentCallBackListener != null ? paymentCallBackListener.onBackPressed() : false)) {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
            if (reactInstanceManager != null) {
                reactInstanceManager.onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        if (r5.clazz == r6.getSubscriberClass()) goto L_0x00cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
            r12 = this;
            r13 = 0
            super.onCreate(r13)
            r12.initViewModel()
            com.mpl.androidapp.cleanarch.main.presentation.vm.MPLReactContainerVm r0 = r12.viewModel
            r0.clearUnityCrashTable()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r12.reactContainerOnCreateTime = r0
            long r0 = java.lang.System.currentTimeMillis()
            r12.initTime = r0
            boolean r0 = activityStarted
            if (r0 == 0) goto L_0x0037
            android.content.Intent r0 = r12.getIntent()
            if (r0 == 0) goto L_0x0037
            android.content.Intent r0 = r12.getIntent()
            int r0 = r0.getFlags()
            r1 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0037
            r12.finish()
            return
        L_0x0037:
            org.greenrobot.eventbus.EventBus r0 = org.greenrobot.eventbus.EventBus.getDefault()
            boolean r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isAndroidSDKAvailable()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = "org.greenrobot.eventbus.android.AndroidComponentsImpl"
            java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x004a }
            r1 = 1
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            if (r1 == 0) goto L_0x004e
            goto L_0x0056
        L_0x004e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r0 = "It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies."
            r13.<init>(r0)
            throw r13
        L_0x0056:
            java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r1 = com.mpl.androidapp.react.MPLReactContainerActivity.class
            org.greenrobot.eventbus.SubscriberMethodFinder r4 = r0.subscriberMethodFinder
            if (r4 == 0) goto L_0x01aa
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.SubscriberMethod>> r5 = org.greenrobot.eventbus.SubscriberMethodFinder.METHOD_CACHE
            java.lang.Object r5 = r5.get(r1)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0068
            goto L_0x0104
        L_0x0068:
            boolean r5 = r4.ignoreGeneratedIndex
            if (r5 == 0) goto L_0x0087
            org.greenrobot.eventbus.SubscriberMethodFinder$FindState r5 = r4.prepareFindState()
            r5.clazz = r1
            r5.skipSuperClasses = r3
            r5.subscriberInfo = r13
        L_0x0076:
            java.lang.Class<?> r13 = r5.clazz
            if (r13 == 0) goto L_0x0081
            r4.findUsingReflectionInSingleClass(r5)
            r5.moveToSuperclass()
            goto L_0x0076
        L_0x0081:
            java.util.List r13 = r4.getMethodsAndRelease(r5)
            goto L_0x00f8
        L_0x0087:
            org.greenrobot.eventbus.SubscriberMethodFinder$FindState r5 = r4.prepareFindState()
            r5.clazz = r1
            r5.skipSuperClasses = r3
            r5.subscriberInfo = r13
        L_0x0091:
            java.lang.Class<?> r6 = r5.clazz
            if (r6 == 0) goto L_0x00f4
            org.greenrobot.eventbus.meta.SubscriberInfo r6 = r5.subscriberInfo
            if (r6 == 0) goto L_0x00ae
            org.greenrobot.eventbus.meta.SubscriberInfo r6 = r6.getSuperSubscriberInfo()
            if (r6 == 0) goto L_0x00ae
            org.greenrobot.eventbus.meta.SubscriberInfo r6 = r5.subscriberInfo
            org.greenrobot.eventbus.meta.SubscriberInfo r6 = r6.getSuperSubscriberInfo()
            java.lang.Class<?> r7 = r5.clazz
            java.lang.Class r8 = r6.getSubscriberClass()
            if (r7 != r8) goto L_0x00ae
            goto L_0x00cd
        L_0x00ae:
            java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> r6 = r4.subscriberInfoIndexes
            if (r6 == 0) goto L_0x00cc
            java.util.Iterator r6 = r6.iterator()
        L_0x00b6:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00cc
            java.lang.Object r7 = r6.next()
            org.greenrobot.eventbus.meta.SubscriberInfoIndex r7 = (org.greenrobot.eventbus.meta.SubscriberInfoIndex) r7
            java.lang.Class<?> r8 = r5.clazz
            org.greenrobot.eventbus.meta.SubscriberInfo r7 = r7.getSubscriberInfo(r8)
            if (r7 == 0) goto L_0x00b6
            r6 = r7
            goto L_0x00cd
        L_0x00cc:
            r6 = r13
        L_0x00cd:
            r5.subscriberInfo = r6
            if (r6 == 0) goto L_0x00ed
            org.greenrobot.eventbus.SubscriberMethod[] r6 = r6.getSubscriberMethods()
            int r7 = r6.length
            r8 = 0
        L_0x00d7:
            if (r8 >= r7) goto L_0x00f0
            r9 = r6[r8]
            java.lang.reflect.Method r10 = r9.method
            java.lang.Class<?> r11 = r9.eventType
            boolean r10 = r5.checkAdd(r10, r11)
            if (r10 == 0) goto L_0x00ea
            java.util.List<org.greenrobot.eventbus.SubscriberMethod> r10 = r5.subscriberMethods
            r10.add(r9)
        L_0x00ea:
            int r8 = r8 + 1
            goto L_0x00d7
        L_0x00ed:
            r4.findUsingReflectionInSingleClass(r5)
        L_0x00f0:
            r5.moveToSuperclass()
            goto L_0x0091
        L_0x00f4:
            java.util.List r13 = r4.getMethodsAndRelease(r5)
        L_0x00f8:
            r5 = r13
            boolean r13 = r5.isEmpty()
            if (r13 != 0) goto L_0x018e
            java.util.Map<java.lang.Class<?>, java.util.List<org.greenrobot.eventbus.SubscriberMethod>> r13 = org.greenrobot.eventbus.SubscriberMethodFinder.METHOD_CACHE
            r13.put(r1, r5)
        L_0x0104:
            monitor-enter(r0)
            java.util.Iterator r13 = r5.iterator()     // Catch:{ all -> 0x018b }
        L_0x0109:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x018b }
            if (r1 == 0) goto L_0x0119
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x018b }
            org.greenrobot.eventbus.SubscriberMethod r1 = (org.greenrobot.eventbus.SubscriberMethod) r1     // Catch:{ all -> 0x018b }
            r0.subscribe(r12, r1)     // Catch:{ all -> 0x018b }
            goto L_0x0109
        L_0x0119:
            monitor-exit(r0)     // Catch:{ all -> 0x018b }
            android.content.Context r13 = r12.getApplicationContext()
            com.mpl.androidapp.utils.KafkaUtils.initKafkaAnalytics(r13)
            r12.setUpView()
            com.mpl.analytics.MPLAnalytics r13 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            if (r13 == 0) goto L_0x0131
            com.mpl.analytics.MPLAnalytics r13 = com.mpl.androidapp.MPLApplication.getMplAnalytics()
            r13.setInAppNotificationButtonListener(r12)
        L_0x0131:
            java.lang.String r13 = "declutter_enabled"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r12, r13, r3)
            java.lang.String r13 = "is_first_session_instrumentation"
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.hasKeysInNormalPref(r12, r13)
            if (r13 == 0) goto L_0x0146
            java.lang.String r13 = "is_first_session_instrumentation"
            java.lang.String r0 = "false"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveStringInNormalPref(r12, r13, r0)
            goto L_0x014d
        L_0x0146:
            java.lang.String r13 = "is_first_session_instrumentation"
            java.lang.String r0 = "true"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveStringInNormalPref(r12, r13, r0)
        L_0x014d:
            boolean r13 = com.mpl.androidapp.utils.MBuildConfigUtils.isIaEnabled()
            if (r13 == 0) goto L_0x0160
            java.lang.String r13 = "is_ia_enabled"
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r12, r13, r3)
            if (r13 != 0) goto L_0x0160
            java.lang.String r13 = "is_ia_enabled"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r12, r13, r2)
        L_0x0160:
            boolean r13 = com.mpl.androidapp.utils.MBuildConfigUtils.isDeclutterIaEnabled()
            if (r13 == 0) goto L_0x0173
            java.lang.String r13 = "declutter_ia_enabled"
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r12, r13, r3)
            if (r13 != 0) goto L_0x0173
            java.lang.String r13 = "declutter_ia_enabled"
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r12, r13, r2)
        L_0x0173:
            com.mpl.androidapp.utils.NetworkMonitorUtil r13 = new com.mpl.androidapp.utils.NetworkMonitorUtil
            r13.<init>(r12, r12)
            r13.registerNetworkCallbackEvents()
            java.lang.String r13 = "app_icon_click_time_v2"
            boolean r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r12, r13, r3)
            if (r13 == 0) goto L_0x0185
            r12.isWarmLaunch = r2
        L_0x0185:
            com.facebook.react.ReactInstanceManager r13 = r12.mReactInstanceManager
            initializeFlipper(r12, r13)
            return
        L_0x018b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018b }
            throw r13
        L_0x018e:
            org.greenrobot.eventbus.EventBusException r13 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Subscriber "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " and its super classes have no public methods with the @Subscribe annotation"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x01aa:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        MLogger.d(TAG, "onDestroy: ");
        try {
            syncCrash();
            if (this.mReactRootView != null) {
                this.mReactRootView.unmountReactApplication();
                this.mReactRootView = null;
            }
            this.isReactInitHappened = false;
            if (this.mReactInstanceManager != null) {
                this.mReactInstanceManager.mReactInstanceEventListeners.remove(this);
                this.mReactInstanceManager.onHostDestroy(this);
                this.mReactInstanceManager.destroy();
            }
            unregisterReceivers();
            hideMultiScreenDialog();
            HyperServiceWrapper.terminateHyperSdk();
            unregisterScreenShotFileObserver();
            EventBus.getDefault().unregister(this);
        } catch (Exception e2) {
            MLogger.d(TAG, "onDestroy: ", e2);
        }
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventReceived(MessageEvent messageEvent) {
        try {
            switch (messageEvent.getAppEventName()) {
                case 1:
                    MLogger.d(TAG, "onEventReceived:ACTION_PROCEED_AFTER_LOGIN_DATA [START]");
                    processAfterLoginData();
                    MLogger.d(TAG, "onEventReceived:ACTION_PROCEED_AFTER_LOGIN_DATA [END]");
                    return;
                case 2:
                    MLogger.d(TAG, "onEventReceived ACTION_PROCEED_HOME_DATA [START]");
                    checkForSubmitScore();
                    runBackgroundTasks();
                    MLogger.d(TAG, "onEventReceived:ACTION_PROCEED_HOME_DATA [END]");
                    return;
                case 3:
                    MLogger.d(TAG, "onEventReceived:ACTION_MQTT_SUBSCRIPTION [START]");
                    mqttSubscriptionEventReceived(messageEvent);
                    MLogger.d(TAG, "onEventReceived:ACTION_MQTT_SUBSCRIPTION [END]");
                    return;
                case 4:
                    MLogger.d(TAG, "onEventReceived:ACTION_MQTT_MESSAGE_RECEIVED [START]");
                    mqttMessageEventReceived(messageEvent);
                    MLogger.d(TAG, "onEventReceived:ACTION_MQTT_MESSAGE_RECEIVED [END]");
                    return;
                case 5:
                    MLogger.d(TAG, "onEventReceived:ACTION_DOWNLOAD_ASSETS_BUNDLE [START]");
                    assetBundleDownloadEventReceived(messageEvent);
                    MLogger.d(TAG, "onEventReceived:ACTION_DOWNLOAD_ASSETS_BUNDLE [END]");
                    return;
                case 6:
                    MLogger.d(TAG, "onEventReceived:ACTION_REACT_BUNDLE_DOWNLOADED [START]");
                    MLogger.d(TAG, "onEventReceived:ACTION_REACT_BUNDLE_DOWNLOADED [END]");
                    return;
                case 7:
                    MLogger.d(TAG, "onEventReceived:ACTION_INTEGRITY_EVENT [START]");
                    StatusType statusType = messageEvent.getStatusType();
                    MLogger.d(TAG, "onEventReceived: ", statusType);
                    updateView(statusType);
                    MLogger.d(TAG, "onEventReceived:ACTION_INTEGRITY_EVENT [END]");
                    return;
                case 8:
                    MLogger.d(TAG, "onEventReceived:BIND_SERVICE_EVENT [START]");
                    bindService(messageEvent.isAppService());
                    MLogger.d(TAG, "onEventReceived:BIND_SERVICE_EVENT [END]");
                    break;
                case 9:
                    break;
                default:
                    return;
            }
            MLogger.d(TAG, "onEventReceived:ACTION_PROCEED_HOME_DATA_LOAD_COMPLETED [START]");
            runTasksOnBackgroundThreadAfterHomeLoaded(this);
            MLogger.d(TAG, "onEventReceived:ACTION_PROCEED_HOME_DATA_LOAD_COMPLETED [END]");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onInAppButtonClick(HashMap<String, String> hashMap) {
        MLogger.d(TAG, "onInAppButtonClick: ");
        emitDataToReact(new JSONObject(hashMap).toString());
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
            if (reactInstanceManager != null) {
                reactInstanceManager.showDevOptionsDialog();
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onNetworkConnectivityChanged(boolean z) {
        super.onNetworkConnectivityChanged(z);
        MLogger.d(MQTT_TAG, "onNetworkConnectivityChanged:isDisConnected ", Boolean.valueOf(z));
        if (!z) {
            MqttAndroidClient mqttAndroidClient = this.mMQTTClient;
            if (mqttAndroidClient != null && !mqttAndroidClient.isConnected()) {
                startMQTTservice();
            }
        }
        if (!z) {
            initInternalEventSdks();
        }
    }

    public void onNetworkStateChange() {
        MSharedPreferencesUtils.setNetworkProviders(this, CommonUtils.getSimCarrierNames(this));
        if (ConfigManager.isIpToAddressConvEnabled()) {
            IPAddressConversion.INSTANCE.getIPLocation();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        MLogger.d(TAG, "onNewIntent() called with: intent", intent);
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            MLogger.d(ActivityConstant.MEMORY_TAG, "onNewIntent() called with:", " intent ", intent, " mReactInstanceManager: ", reactInstanceManager, " getCurrentReactContext() ", this.mReactContext);
            this.mReactInstanceManager.onNewIntent(intent);
        }
        new FetchNotificationData(true).execute(new Intent[]{intent});
        if (intent != null && !TextUtils.isEmpty(intent.getStringExtra(Constant.GAME_SCORE))) {
            this.isSubmitScoreRequire = true;
            this.mScore = intent.getStringExtra(Constant.GAME_SCORE);
            this.mResultIntentAfterUnity = intent;
        }
        try {
            if (this.isSubmitScoreRequire && !TextUtils.isEmpty(this.mScore)) {
                if (MSharedPreferencesUtils.isNativeSubmitScoreEnabled()) {
                    MLogger.d(ActivityConstant.MEMORY_TAG, "submit GameScore called from new intent to Native side");
                    doSubmitFromNative(intent);
                } else if (this.mReactInstanceManager != null && this.mReactContext != null) {
                    MLogger.d(ActivityConstant.MEMORY_TAG, "submit GameScore called from new intent React side");
                    doSubmitScore(intent);
                } else if (this.reactEmitter != null) {
                    submitGameScore(this.mScore);
                } else {
                    MLogger.d(ActivityConstant.MEMORY_TAG, "Some params are null for submit score");
                }
            }
        } catch (Exception unused) {
            if (this.mReactInstanceManager != null && this.isSubmitScoreRequire && !TextUtils.isEmpty(this.mScore) && this.mReactContext != null) {
                MLogger.d(ActivityConstant.MEMORY_TAG, "submit GameScore called from new intent");
                doSubmitScore(intent);
            }
        }
        handlePushNotificationActionButtonCallBack(intent);
        openRankResultScreenForThirdPartiesGames(intent);
        setUnityMiniProfileListener(intent);
    }

    public void onPause() {
        super.onPause();
        try {
            MLogger.d(TAG, "onPause: ");
            overridePendingTransition(0, 0);
            MLogger.d(Constant.LOADING_TAG, "onPause");
            this.mLifecycleState = LifecycleState.BEFORE_RESUME;
            if (!(this.mReactInstanceManager == null || this.mReactInstanceManager.getCurrentReactContext() == null || this.mReactInstanceManager.getCurrentReactContext().getCurrentActivity() == null)) {
                this.mReactInstanceManager.onHostPause(this);
                this.mReactInstanceManager.mReactInstanceEventListeners.remove(this);
            }
            unregisterScreenShotFileObserver();
        } catch (Error | Exception unused) {
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        splitedOnCreate();
        MLogger.d(Constant.LOADING_TAG, "onPostCreate: ");
    }

    public void onPostResume() {
        super.onPostResume();
        if (this.shouldChangeInFirstLaunch) {
            long currentTimeMillis = System.currentTimeMillis();
            MSharedPreferencesUtils.saveBooleanInNormalPref(this, "warm_launch", true);
            MPreferences.putString(Constant.APP_ICON_CLICK_TIME_V2, String.valueOf(currentTimeMillis), false);
            this.shouldChangeInFirstLaunch = false;
        }
        MLogger.d(Constant.LOADING_TAG, "onPostResume: ");
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        Class cls = RCTDeviceEventEmitter.class;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("isSubmitScoreRequire: ");
        outline73.append(this.isSubmitScoreRequire);
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("isReactInitHappened: ");
        outline732.append(this.isReactInitHappened);
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("mScore: ");
        outline733.append(this.mScore);
        MLogger.d(Constant.LOADING_TAG, "onReactContextInitialized: ", "Context: " + reactContext, outline73.toString(), outline732.toString(), outline733.toString());
        this.mReactContext = reactContext;
        this.reactEmitter = (RCTDeviceEventEmitter) reactContext.getJSModule(cls);
        if (this.isReactInitHappened && !this.isAppIntegrityFail.booleanValue()) {
            CleverTapAnalyticsUtils.pushProfileEvent(new HashMap());
            setReactView();
            this.isReactInitHappened = false;
        }
        MLogger.d("ResponsibleGamingTimer", "React context init done!");
        checkAndSendRgWarning();
        if (this.actionId != null) {
            int i = this.notificationId;
            if (i > -1) {
                cancelNotification(i);
            }
            sendClickActionIdToReact(this.actionId);
            this.actionId = null;
            this.notificationId = -1;
        }
        if (!this.isReferralCodeEmitDone) {
            MLogger.d(TAG, "onReactContextInitialized: Sending referral code");
            String aFReferralCode = MSharedPreferencesUtils.getAFReferralCode();
            if (!TextUtils.isEmpty(aFReferralCode)) {
                ReactContext reactContext2 = this.mReactContext;
                if (!(reactContext2 == null || reactContext2.getJSModule(cls) == null)) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit("referral_code", aFReferralCode);
                    this.isReferralCodeEmitDone = true;
                }
            }
            if (!TextUtils.isEmpty(aFReferralCode)) {
                RCTDeviceEventEmitter rCTDeviceEventEmitter = this.reactEmitter;
                if (rCTDeviceEventEmitter != null) {
                    rCTDeviceEventEmitter.emit("referral_code", aFReferralCode);
                    this.isReferralCodeEmitDone = true;
                }
            }
        }
        if (!this.isSignupCodeEmitDone) {
            MLogger.d(TAG, "onReactContextInitialized: Sending Signup offer code");
            String aFSignUpOfferCode = MSharedPreferencesUtils.getAFSignUpOfferCode();
            if (!TextUtils.isEmpty(aFSignUpOfferCode)) {
                ReactContext reactContext3 = this.mReactContext;
                if (!(reactContext3 == null || reactContext3.getJSModule(cls) == null)) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(SIGNUP_OFFER, aFSignUpOfferCode);
                    this.isSignupCodeEmitDone = true;
                }
            }
            if (!TextUtils.isEmpty(aFSignUpOfferCode)) {
                RCTDeviceEventEmitter rCTDeviceEventEmitter2 = this.reactEmitter;
                if (rCTDeviceEventEmitter2 != null) {
                    rCTDeviceEventEmitter2.emit(SIGNUP_OFFER, aFSignUpOfferCode);
                    this.isSignupCodeEmitDone = true;
                }
            }
        }
        MLogger.d("perfopt", "onReactContextInitialized end ");
    }

    public void onReceiveResult(int i, Bundle bundle) {
        Bundle bundle2 = bundle;
        Class cls = RCTDeviceEventEmitter.class;
        String str = "";
        switch (i) {
            case 3:
                MLogger.d(TAG, "onReceiveResult: Sending progress event");
                String string = bundle2.getString(Event.DOWNLOADED_ASSETS_DATA);
                ReactContext reactContext = this.mReactContext;
                if (reactContext != null && reactContext.getJSModule(cls) != null) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GAME_DOWNLOAD_PROGRESS, string);
                    return;
                }
                return;
            case 4:
                if (this.mReactInstanceManager != null) {
                    ReactContext reactContext2 = this.mReactContext;
                    if (reactContext2 != null) {
                        ((RCTDeviceEventEmitter) reactContext2.getJSModule(cls)).emit("share_complete", BaseParser.TRUE);
                        return;
                    }
                }
                MLogger.d(TAG, "mReactInstanceManager is null for share_complete");
                return;
            case 5:
                if (this.mReactInstanceManager != null) {
                    ReactContext reactContext3 = this.mReactContext;
                    if (reactContext3 != null) {
                        ((RCTDeviceEventEmitter) reactContext3.getJSModule(cls)).emit(Constant.GLOBAL_REACT_EMIT_KEY, "{\"video_recording_toggle\":false}");
                        return;
                    }
                }
                MLogger.d(TAG, "mReactInstanceManager is null for GLOBAL_REACT_EMIT_KEY");
                return;
            case 6:
                MLogger.d(TAG, "otp false case");
                return;
            case 7:
                String string2 = bundle2.getString("failed_reason", str);
                if (this.mReactInstanceManager == null || this.mReactContext == null) {
                    MLogger.d("download_assets", "mReactInstanceManager is null in failedReason");
                    return;
                } else if (string2.equalsIgnoreCase("Login Failed")) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GLOBAL_REACT_EMIT_KEY, "{\"fb_login_failed\":true}");
                    return;
                } else if (string2.equalsIgnoreCase("Share Failed")) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GLOBAL_REACT_EMIT_KEY, "{\"fb_upload_failed\":true}");
                    return;
                } else {
                    return;
                }
            case 8:
                MLogger.d(TAG, "onReceive: react init 4");
                return;
            case 9:
                try {
                    String string3 = bundle2.getString("otp", str);
                    if (this.mReactInstanceManager == null || this.mReactContext == null) {
                        MLogger.d(ActivityConstant.MEMORY_TAG, "mReactInstanceManager or context is null for reading otp");
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("IsSuccess", Boolean.TRUE);
                    CleverTapAnalyticsUtils.sendEvent((String) "Otp Detected", hashMap);
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("otp", string3);
                    createMap.putDouble("Time To Detect", (double) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - MSharedPreferencesUtils.getLongPref(Constant.OTP_INITIATED_TIME, 0, false)));
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.EVENT_OTP, createMap);
                    return;
                } catch (Exception unused) {
                    MLogger.d(ActivityConstant.MEMORY_TAG, "mReactInstanceManager or context is null for reading otp");
                    return;
                }
            case 10:
                int i2 = 1500;
                if (bundle2 != null) {
                    try {
                        str = bundle2.getString(Constant.TOAST_DATA, str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has(InlineAnimation.DELAY)) {
                            i2 = jSONObject.getInt(InlineAnimation.DELAY);
                        }
                    } catch (Exception unused2) {
                    }
                }
                showToast(str, i2);
                return;
            case 12:
                ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
                if (reactInstanceManager != null) {
                    reactInstanceManager.showDevOptionsDialog();
                    return;
                }
                return;
            case 14:
                try {
                    showOptimizationToast();
                    return;
                } catch (Exception e2) {
                    MLogger.e(TAG, e2);
                    return;
                }
            case 15:
                showNetworkErrorDialog(bundle2.getString("title", str), bundle2.getString("message", str), getString(17039370), false, true);
                return;
            case 17:
                showLogOutDialog(getString(R.string.alert), getString(R.string.log_out_message), getString(17039370));
                return;
            case 18:
                TYPE valueOf = TYPE.valueOf(bundle2.getString(NonSealedApkFragment.ARG_DIALOG_TYPE, str));
                String string4 = bundle2.getString("title", getResources().getString(R.string.suspicious_app_detected));
                String string5 = bundle2.getString("message", "Please uninstall apps");
                String string6 = bundle2.getString(NonSealedApkFragment.ARG_BTN_TITLE, str);
                DialogData dialogData = new DialogData();
                dialogData.setTitle(string4);
                dialogData.setBody(string5);
                dialogData.setOkButton(string6);
                int ordinal = valueOf.ordinal();
                if (ordinal == 0) {
                    dialogData.setDialogType(TYPE.USB_DEBUGGING);
                    dialogData.setPopUpName("USB debugging Enabled Pop Up");
                    dialogData.setShouldCloseApp(false);
                    suspiciousAppsFound(dialogData);
                    return;
                } else if (ordinal == 1) {
                    dialogData.setDialogType(TYPE.DEVELOPER_OPTION);
                    dialogData.setPopUpName("Developer Options Enabled Pop Up");
                    dialogData.setShouldCloseApp(false);
                    suspiciousAppsFound(dialogData);
                    return;
                } else if (ordinal == 2) {
                    dialogData.setDialogType(TYPE.SPLIT_SCREEN);
                    dialogData.setPopUpName("Split Screen Pop Up");
                    dialogData.setShouldCloseApp(true);
                    suspiciousAppsFound(dialogData);
                    return;
                } else if (ordinal == 3) {
                    dialogData.setDialogType(TYPE.MAGNIFICATION);
                    dialogData.setPopUpName("Magnification Pop Up");
                    dialogData.setShouldCloseApp(false);
                    detectAccessibilitySetting();
                    return;
                } else if (ordinal == 5) {
                    dialogData.setDialogType(TYPE.COMMON);
                    dialogData.setPopUpName("Common Pop Up");
                    dialogData.setShouldCloseApp(true);
                    suspiciousAppsFound(dialogData);
                    return;
                } else {
                    return;
                }
            case 19:
                updateApkProgress(bundle2);
                return;
            case 20:
                MLogger.d(TAG, "onReceive: react init 5");
                checkForSubmitScore();
                return;
            case 22:
                int i3 = bundle2.getInt("userId", 0);
                String string7 = bundle2.getString("displayName", str);
                if (i3 != 0 && !TextUtils.isEmpty(string7)) {
                    sendUserInfoToFreshChat(i3, string7);
                    return;
                }
                return;
            case 23:
                MLogger.d(TAG, "onReceiveResult:sending failed event ");
                String string8 = bundle2.getString(Event.DOWNLOADED_ASSETS_DATA);
                ReactContext reactContext4 = this.mReactContext;
                if (reactContext4 != null && reactContext4.getJSModule(cls) != null) {
                    ((RCTDeviceEventEmitter) this.mReactContext.getJSModule(cls)).emit(Constant.GAME_ASSETS_DOWNLOADING_FAILED, string8);
                    return;
                }
                return;
            case 24:
                showVpnDialog(bundle2);
                return;
            default:
                MLogger.d(TAG, "default case");
                return;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionListener permissionListener = this.mPermissionListener;
        if (permissionListener != null && permissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
            this.mPermissionListener = null;
        }
        if (i == 1024) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                HashMap outline87 = GeneratedOutlineSupport.outline87("Storage permission", BaseParser.FALSE);
                outline87.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, CommonUtils.getCurrentScreenName());
                CleverTapAnalyticsUtils.sendEvent((String) "Screenshot Taken", outline87);
                MLogger.e(HSLCriteriaBuilder.VALUE, "Permission Denied, You cannot use local drive .");
            } else {
                MLogger.d(TAG, "Permission Granted, Now you can use local drive .");
                HashMap hashMap = new HashMap();
                hashMap.put("Storage permission", BaseParser.TRUE);
                hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_SCREEN_NAME, CommonUtils.getCurrentScreenName());
                CleverTapAnalyticsUtils.sendEvent((String) "Screenshot Taken", hashMap);
                openScreenShotNudges(this.mScreenShotURI);
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
            activityStarted = bundle.getBoolean(ActivityConstant.IS_ACTIVITY_STARTED);
        } catch (Throwable unused) {
        }
    }

    public void onResume() {
        super.onResume();
        try {
            this.mLifecycleState = LifecycleState.RESUMED;
            if (this.mReactInstanceManager != null) {
                this.mReactInstanceManager.onHostResume(this, this);
                this.mReactInstanceManager.mReactInstanceEventListeners.add(this);
            }
            this.mNotificationBuilder = new NotificationBuilder(this);
            MLogger.d("MainLaunchingActivity", "onResume() called");
            AssetsUtils.mapAllAssetsVersionFirstTime(this);
            if (this.mScreenMagnificationAlertDialog != null && this.mScreenMagnificationAlertDialog.isShowing()) {
                this.mScreenMagnificationAlertDialog.dismiss();
                this.mScreenMagnificationAlertDialog = null;
            }
            addScreenShotFileObserver(this);
            handleNotificationCancelOption();
            new GameDisconnection(this, this.pendingResult).gameDisconnectionHandling();
        } catch (Error | Exception e2) {
            MLogger.e("MainLaunchingActivity", "onResume: ", e2);
        }
        syncCrash();
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean(ActivityConstant.IS_ACTIVITY_STARTED, activityStarted);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(1:2)|3|4|5|6|(2:8|10)(1:12)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0033 A[Catch:{ Exception -> 0x003c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
            r4 = this;
            super.onStart()
            java.lang.String r0 = "app_icon_click_time_v2"
            r1 = 0
            boolean r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getBooleanInNormalPref(r4, r0, r1)
            if (r2 == 0) goto L_0x001c
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "app_init_timestamp_v2"
            com.mpl.securepreferences.MPreferences.putString(r3, r2, r1)
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveBooleanInNormalPref(r4, r0, r1)
        L_0x001c:
            r4.initializeBranch()     // Catch:{ Error | Exception -> 0x002d }
            org.joda.time.DateTime r0 = new org.joda.time.DateTime     // Catch:{ Error | Exception -> 0x002d }
            r0.<init>()     // Catch:{ Error | Exception -> 0x002d }
            java.lang.String r1 = "lastAppOpenTime"
            java.lang.String r0 = r0.toString()     // Catch:{ Error | Exception -> 0x002d }
            com.mpl.androidapp.utils.MSharedPreferencesUtils.saveStringInNormalPref(r4, r1, r0)     // Catch:{ Error | Exception -> 0x002d }
        L_0x002d:
            com.mpl.androidapp.responsiblegaming.RgSessionManager r0 = com.mpl.androidapp.MPLApplication.getRgSessionManager()     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x003c
            com.mpl.androidapp.responsiblegaming.RgSessionManager r0 = com.mpl.androidapp.MPLApplication.getRgSessionManager()     // Catch:{ Exception -> 0x003c }
            com.mpl.androidapp.responsiblegaming.RgWarningListener r1 = r4.rgWarningListener     // Catch:{ Exception -> 0x003c }
            r0.registerWarningListener(r1)     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.onStart():void");
    }

    public void onStop() {
        MLogger.d(Constant.LOADING_TAG, "onStop");
        this.shouldChangeInFirstLaunch = true;
        MSharedPreferencesUtils.saveBooleanInNormalPref(this, "warm_launch", false);
        MSharedPreferencesUtils.saveBooleanInNormalPref(this, Constant.PREF_APP_ICON_CLICK_TIME_V2, true);
        unbindService();
        if (this.mBindServiceReceiver != null) {
            this.mBindServiceReceiver = null;
        }
        if (MPLApplication.getRgSessionManager() != null) {
            MPLApplication.getRgSessionManager().unregisterWarningListener();
        }
        super.onStop();
    }

    public void openMiniProfile(String str, String str2) {
        this.reactEmitter.emit(str, str2);
    }

    public void openRankResultScreen(Intent intent) {
        Intent intent2 = intent;
        try {
            String stringExtra = intent2.getStringExtra("TournamentId");
            String stringExtra2 = intent2.getStringExtra(TQConstants.SESSION_ID);
            int intExtra = intent2.getIntExtra("Score", 0);
            int intExtra2 = intent2.getIntExtra(TQConstants.USER_MAX_SCORE, 0);
            long longExtra = intent2.getLongExtra("GameId", 0);
            MLogger.d(TAG, "openRankResultScreen: ", stringExtra, stringExtra2);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TQConstants.SESSION_ID, stringExtra2);
            jSONObject2.put("Score", intExtra);
            jSONObject2.put(TQConstants.USER_MAX_SCORE, intExtra2);
            jSONObject2.put("GameId", longExtra);
            jSONObject.put("getLeaderboardOnly", true);
            jSONObject.put("gameSession", jSONObject2);
            try {
                this.reactEmitter.emit(Constant.GAME_SCORE, jSONObject.toString());
                MLogger.d(TAG, "openRankResultScreen: ", jSONObject);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            MLogger.d(TAG, "openRankResultScreen: ", e);
        }
    }

    public void processNotification() {
        MLogger.d("workmanger", "completed succesfully", "processnotif");
        try {
            WorkManagerImpl.getInstance(getApplicationContext()).enqueue(new OneTimeWorkRequest.Builder(NotificationWorker.class).build());
        } catch (Exception unused) {
        }
    }

    public void publishResult(String str) {
    }

    public void registerBroadcastForIntegrity(BroadcastReceiver broadcastReceiver2) {
        MLogger.d(TAG, "registerBroadcastForIntegrity: ", Boolean.valueOf(this.isRegister));
        this.isRegister = true;
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.INTEGRITY_EVENT));
    }

    public void registerBroadcastToMqttSubscriptionRequestReceiver(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.ACTION_MQTT_SUBSCRIPTION));
    }

    public void registerBroadcastToSetContentView(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.SET_REACT_CONTENT));
    }

    public void registerLocalBroadcastForCancelNotification(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Constant.NOTIFICATION_CANCELLED));
    }

    public void registerLocalBroadcastForUpdateProgress(BroadcastReceiver broadcastReceiver2) {
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver2, new IntentFilter(Event.BIND_SERVICE_EVENT));
    }

    public void registerReceivers() {
        registerBroadcastToSetContentView(this.mSetContentViewReceiver);
        registerBroadcastToRecordingMonitoring(this.mRecordingMonitorReceiver);
        registerBroadcastToBackgroundTask(this.mBackgroundTaskReceiver);
        registerInstallReceiver(this.mInstallBroadCastReceiver);
        registerLocalBroadcastForCancelNotification(this.notificationCancelReciever);
        registerBroadcastForGeoSpoofingAlert(this.geoSpoofingDetectedReceiver);
        registerReceiver(this.mGameDisconnectReceiver, new IntentFilter(Constant.ACTION_GAME_DISCONNECTION));
    }

    @TargetApi(23)
    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        requestPermissions(strArr, i);
    }

    public void saveEventSentForInstall(int i, String str, boolean z) {
        MPLApplication instance = MPLApplication.getInstance();
        MSharedPreferencesUtils.saveBooleanInNormalPref(instance, "install_apk_event_for_" + i + "_sent_" + str, z);
    }

    public void sendUpdateInfoToServer() {
        String str;
        int lastInstalledAppVersion = MSharedPreferencesUtils.getLastInstalledAppVersion();
        int installedAppVersionCode = MBuildConfigUtils.getInstalledAppVersionCode();
        MLogger.d(TAG, "lastInstalledVersion", Integer.valueOf(lastInstalledAppVersion), "currentInstalledVersion", Integer.valueOf(installedAppVersionCode));
        if (MSharedPreferencesUtils.shouldSendAppUpdatedEvent()) {
            UpdaterAnalytics.sendAppUpdatedEvent();
            DBInteractor.resetCriticalDownloadStartInBackground();
        } else {
            MSharedPreferencesUtils.setLastInstalledAppVersionEvent(MBuildConfigUtils.getInstalledAppVersionCodeGradle());
        }
        if (lastInstalledAppVersion != installedAppVersionCode && lastInstalledAppVersion < installedAppVersionCode && MSharedPreferencesUtils.isUserLoggedIn()) {
            String str2 = ApiEndPoints.UPDATE_APK_NOTIFY_URL;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
            outline73.append(MSharedPreferencesUtils.getAccessUserToken());
            arrayList.add(new MHeader("Authorization", outline73.toString()));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("androidPrevious", lastInstalledAppVersion);
                jSONObject.put("androidCurrent", MBuildConfigUtils.getInstalledAppVersionCodeGradle());
                jSONObject.put("reactPrevious", MSharedPreferencesUtils.getLastInstalledReactVersion());
                jSONObject.put("reactCurrent", MBuildConfigUtils.getCurrentReactVersionGradle());
                jSONObject.put("osType", "ANDROID");
                jSONObject.put("osVersion", VERSION.RELEASE);
                jSONObject.put("sdkVersion", VERSION.SDK_INT);
                str = jSONObject.toString();
            } catch (JSONException e2) {
                MLogger.i(TAG, "postDataToServer", e2);
                str = "";
            }
            MLogger.d(TAG, "sendUpdateInfoToServer: ", str);
            NetworkUtils.doPostRequest(new NetworkCallParams.Builder().setUrl(str2).setConnectionTimeOut(10000).setWriteTimeOut(10000).setMHeaders(arrayList).setReadTimeOut(10000).setRetryOption(true).setMRequestBody(str).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    MLogger.e(IResponseListener.TAG, "onResponseFail: ", exc);
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess: ", str);
                    MSharedPreferencesUtils.setLastInstalledAppVersion(MBuildConfigUtils.getInstalledAppVersionCodeGradle());
                    MSharedPreferencesUtils.setLastInstalledReactVersion(MBuildConfigUtils.getCurrentReactVersionGradle());
                }
            }, "update_call");
        }
    }

    public void sendUserInfoToFreshChat(int i, String str) {
        String str2;
        try {
            String lowerCase = MBuildConfigUtils.getCountryCode().toLowerCase();
            String str3 = lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + "@mplsupport.com";
            if (TextUtils.isEmpty(lowerCase) || !"US".equalsIgnoreCase(lowerCase)) {
                str2 = String.valueOf(i);
            } else {
                str3 = lowerCase + Constants.ACCEPT_TIME_SEPARATOR_SERVER + CountryUtils.getUniqueIdForThirdPartySDKs() + "@mplsupport.com";
                str2 = CountryUtils.getUniqueIdForThirdPartySDKs();
            }
            MLogger.d(TAG, "sendUserInfoToFreshChat: \"countryCode:\"", lowerCase, "\"email:\"", str3);
            FreshchatUser user = Freshchat.getInstance(getApplicationContext()).getUser();
            user.setFirstName(str);
            user.setEmail(str3);
            FreshchatNotificationConfig freshchatNotificationConfig = new FreshchatNotificationConfig();
            freshchatNotificationConfig.setSmallIcon(R.drawable.ic_stat_mpl);
            freshchatNotificationConfig.setLargeIcon(R.mipmap.ic_launcher);
            Freshchat.getInstance(getApplicationContext()).setNotificationConfig(freshchatNotificationConfig);
            String restoreId = user.getRestoreId();
            if (!TextUtils.isEmpty(restoreId)) {
                Freshchat.getInstance(this).identifyUser(str2, restoreId);
                MLogger.d(TAG, "onReceive:1 FreshChat ", restoreId);
            } else {
                String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(getApplicationContext(), "freshChatRestoreId", "");
                if (!TextUtils.isEmpty(stringInNormalPref)) {
                    Freshchat.getInstance(this).identifyUser(str2, stringInNormalPref);
                    MLogger.d(TAG, "onReceive:2 FreshChat ", stringInNormalPref);
                } else {
                    Freshchat.getInstance(this).identifyUser(str2, null);
                }
            }
            Freshchat.getInstance(getApplicationContext()).setUser(user);
            Freshchat.getInstance(getApplicationContext()).setUserProperty("Country", MBuildConfigUtils.getCountryCode());
            LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(this.broadcastReceiver, new IntentFilter(Freshchat.FRESHCHAT_USER_RESTORE_ID_GENERATED));
        } catch (MethodNotAllowedException e2) {
            MLogger.printStackTrace(e2);
        }
    }

    public void setImagePickerListener(PaymentCallBackListener paymentCallBackListener) {
        this.mImagePickerCallBackListener = paymentCallBackListener;
    }

    public void setPaymentListener(PaymentCallBackListener paymentCallBackListener) {
        MLogger.d(TAG, "setPaymentListener: ");
        this.mPaymentCallBackListener = paymentCallBackListener;
    }

    public void setScreenSecure(Boolean bool) {
        if (getWindow() != null) {
            runOnUiThread(new Runnable(bool) {
                public final /* synthetic */ Boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MPLReactContainerActivity.this.lambda$setScreenSecure$26$MPLReactContainerActivity(this.f$1);
                }
            });
        }
    }

    public void setUpView() {
        MLogger.d(Constant.LOADING_TAG, "setUpView: ");
        SplashScreenBinding inflate = SplashScreenBinding.inflate(LayoutInflater.from(this));
        this.mBinding = inflate;
        setContentView((View) inflate.getRoot());
        SplashScreenBinding splashScreenBinding = this.mBinding;
        LottieAnimationView lottieAnimationView = splashScreenBinding.dynamicSplashImageLottie;
        ProgressBar progressBar = splashScreenBinding.splashProgress;
        if (!(lottieAnimationView == null || progressBar == null)) {
            setSplashImage(lottieAnimationView, progressBar, false);
        }
        this.mReactRootView = new ReactRootView(this);
        RecyclerView recyclerView = this.mBinding.updateItemList;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
            this.mBinding.updateItemList.setLayoutManager(new LinearLayoutManager(this));
        }
        this.mBinding.errorView.setVisibility(8);
        this.mBinding.releaseNoteLayoutMain.setVisibility(8);
        slideDown(this.mBinding.errorView);
        slideDown(this.mBinding.releaseNoteLayoutMain);
        this.mBinding.btnDownload.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MPLReactContainerActivity.this.lambda$setUpView$0$MPLReactContainerActivity(view);
            }
        });
        sendDauEventToCleverTap();
        CleverTapAnalyticsUtils.saveRandomString(this);
    }

    public void showMultiScreenDialog(TYPE type) {
        super.showMultiScreenDialog(type);
        MLogger.d(TAG, "showMultiScreenDialog: ");
        DialogData dialogData = new DialogData();
        String string = getString(R.string.multi_screen_dialog_message);
        dialogData.setDialogType(TYPE.SPLIT_SCREEN);
        if (type == TYPE.ORIENTATION_DIALOG) {
            string = getString(R.string.orientation_dialog_message);
            dialogData.setDialogType(TYPE.ORIENTATION_DIALOG);
            dialogData.setPopUpName("Landscape Screen Pop Up");
        }
        dialogData.setBody(string);
        dialogData.setShouldCloseApp(true);
        suspiciousAppsFound(dialogData);
    }

    public void showNativeGeoSpoofingDetectedDialogue() {
        try {
            NonSealedApkFragment.newInstance(getString(R.string.gps_spoof_title), getString(R.string.gps_spoof_message), getString(R.string.ok_got_it), true, Constant.NATIVE_GPS_SPOOFING_DIALOG).show(getSupportFragmentManager(), (String) "native_gps_spoofing");
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.POP_UP_NAME, "Native GPS Spoofer Pop Up");
            CleverTapAnalyticsUtils.sendEvent((String) "Android GPS Spoofer", hashMap);
        } catch (Exception unused) {
        }
    }

    public void splitedOnCreate() {
        registerReceivers();
        new IntegrityAppCheck().execute(new Void[0]);
        DownloadProgressReceiver downloadProgressReceiver = new DownloadProgressReceiver(new Handler());
        resultReceiver = downloadProgressReceiver;
        downloadProgressReceiver.setReceiver(this);
        this.mRobotoBoldFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Roboto-Bold.ttf");
        this.mRobotoRegularFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Roboto-Regular.ttf");
        activityStarted = true;
        AppsFlyerLib.getInstance().sendPushNotificationData(this);
        new FetchNotificationData(false).execute(new Intent[]{getIntent()});
        integrityCheck();
        this.isReactInitHappened = false;
        MLogger.d(Constant.LOADING_TAG, "splitedOnCreate: ");
    }

    public void startPokerGame(JSONObject jSONObject) {
    }

    public void startReactAfterAnimation(boolean z) {
        MLogger.d(TAG, "startReactAfterAnimation() called with: isReactLoad = [" + z + CMapParser.MARK_END_OF_ARRAY);
        this.isAnimationEnded = true;
        if (this.isReactLoadCalled && !z) {
            MLogger.d(TAG, "startReactAfterAnimation:setSplashImage React loaded called from animation end ");
            setReactView();
        }
    }

    public void startSendingEvents() {
        MLogger.d(TAG, "startSendingEvents:Initializing Sendind data to kafka ");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Accept", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.addAll(CommonUtils.getCommonHeaders());
            if (KafkaUtils.getAnalyticsConfig().getHeaders() != null && !KafkaUtils.getAnalyticsConfig().getHeaders().isEmpty()) {
                KafkaUtils.getAnalyticsConfig().getHeaders().clear();
            }
            KafkaUtils.getAnalyticsConfig().setHeaders(arrayList);
            KafkaUtils.getAnalyticsConfig().setLogEnabled(MBuildConfigUtils.isLogEnabled());
            KafkaUtils.getAnalyticsHelper().setConfig(KafkaUtils.getAnalyticsConfig());
            KafkaUtils.getAnalyticsHelper().initiateSendingEvent();
        } catch (Exception e2) {
            MLogger.e(TAG, "startSendingEvents: ", e2);
        }
        MLogger.d(TAG, "startSendingEvents() called[END]");
    }

    public void toggleUserFollowStatus(int i, boolean z) {
        String str = z ? "/profiles/follow" : "/profiles/unfollow";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
        outline73.append(MSharedPreferencesUtils.getAccessUserToken());
        arrayList.add(new MHeader("Authorization", outline73.toString()));
        NetworkCallParams.Builder builder = new NetworkCallParams.Builder();
        NetworkCallParams.Builder url = builder.setUrl(MBuildConfigUtils.getMainUrl() + str);
        NetworkUtils.doPostRequest(url.setMRequestBody("{\"followUserId\":" + i + "}").setMHeaders(arrayList).build(), new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                MLogger.e(IResponseListener.TAG, "onResponseFail: ", exc);
            }

            public void progressResponse(long j, long j2, boolean z) {
            }

            public void onResponseSuccess(String str) {
                MLogger.d(IResponseListener.TAG, "onResponseSuccess: ", str);
            }
        }, z ? "follow" : "unfollow");
    }

    public void unregisterScreenShotFileObserver() {
        try {
            if (this.mScreenShotContentObserver != null) {
                getContentResolver().unregisterContentObserver(this.mScreenShotContentObserver);
                this.mScreenShotContentObserver = null;
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "unregisterScreenShotFileObserver: ");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:99|100|101|102|(2:104|105)(2:106|(1:110))|111|112|113|114|115|(1:119)|(1:131)(5:123|(2:126|124)|174|127|(1:129)(1:130))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:114:0x057d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateView(com.mpl.androidapp.updater.util.StatusType r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            java.lang.String r3 = "AppUpdateCheck:"
            r0[r2] = r3
            r4 = 1
            java.lang.String r5 = "updateView"
            r0[r4] = r5
            java.lang.String r6 = r18.toString()
            r7 = 2
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r0[r7] = r6
            java.lang.String r6 = "MPLReactContainerActivity"
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r2] = r5
            java.lang.String r5 = r18.toString()
            r0[r4] = r5
            java.lang.String r5 = "AppLoading"
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            android.graphics.Typeface r9 = r1.mRobotoBoldFont
            r0.setTypeface(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            android.graphics.Typeface r9 = r1.mRobotoRegularFont
            r0.setTypeface(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            android.graphics.Typeface r9 = r1.mRobotoRegularFont
            r0.setTypeface(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            android.graphics.Typeface r9 = r1.mRobotoRegularFont
            r0.setTypeface(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            android.graphics.Typeface r9 = r1.mRobotoRegularFont
            r0.setTypeface(r9)
            int r0 = r18.ordinal()
            r9 = 8
            if (r0 == 0) goto L_0x07e8
            java.lang.String r10 = "Pop Up Name"
            java.lang.String r11 = "IS Critical"
            java.lang.String r12 = "Pop Up Shown"
            java.lang.String r13 = "ID"
            java.lang.String r14 = ""
            if (r0 == r4) goto L_0x072e
            r15 = 17
            r2 = 2131952483(0x7f130363, float:1.954141E38)
            if (r0 == r15) goto L_0x068f
            r15 = 2131952510(0x7f13037e, float:1.9541465E38)
            java.lang.String r16 = "updateView:PROCEED "
            switch(r0) {
                case 3: goto L_0x04af;
                case 4: goto L_0x048a;
                case 5: goto L_0x03e0;
                case 6: goto L_0x03a0;
                case 7: goto L_0x032e;
                case 8: goto L_0x02c0;
                case 9: goto L_0x024c;
                case 10: goto L_0x01e9;
                case 11: goto L_0x0185;
                case 12: goto L_0x010c;
                case 13: goto L_0x00c9;
                case 14: goto L_0x0080;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0857
        L_0x0080:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x0092
            r0.setVisibility(r9)
        L_0x0092:
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.PLAY_STORE_DOWNLOAD_CRITICAL
            r1.buttonStatus = r0
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131952666(0x7f13041a, float:1.9541781E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131952665(0x7f130419, float:1.954178E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            r0 = 2131952664(0x7f130418, float:1.9541777E38)
            java.lang.String r0 = r1.getString(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r2 = r1.mBinding
            android.widget.Button r2 = r2.btnDownload
            r2.setText(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            goto L_0x0857
        L_0x00c9:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.String r2 = "updateView:INIT_REACT "
            r3 = 0
            r0[r3] = r2
            java.lang.Boolean r2 = r1.isAppIntegrityFail
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideDown(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x00e9
            r0.setVisibility(r9)
        L_0x00e9:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.pushProfileEvent(r0)
            java.lang.Boolean r0 = r1.isAppIntegrityFail
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0105
            r17.setReactView()
            goto L_0x0857
        L_0x0105:
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r1.updateView(r0)
            goto L_0x0857
        L_0x010c:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x011e
            r0.setVisibility(r9)
        L_0x011e:
            java.lang.String r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getRootStatusMsg()
            com.mpl.androidapp.databinding.SplashScreenBinding r3 = r1.mBinding
            android.widget.TextView r3 = r3.txtStatus
            r4 = 2131952745(0x7f130469, float:1.9541941E38)
            java.lang.String r4 = r1.getString(r4)
            r3.setText(r4)
            java.lang.String r14 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeInNormalPref()     // Catch:{ Exception -> 0x0135 }
            goto L_0x0136
        L_0x0135:
        L_0x0136:
            boolean r3 = android.text.TextUtils.isEmpty(r14)
            if (r3 != 0) goto L_0x0150
            boolean r3 = r13.equalsIgnoreCase(r14)
            if (r3 == 0) goto L_0x0150
            com.mpl.androidapp.databinding.SplashScreenBinding r3 = r1.mBinding
            android.widget.TextView r3 = r3.txtStatus
            r4 = 2131952746(0x7f13046a, float:1.9541943E38)
            java.lang.String r4 = r1.getString(r4)
            r3.setText(r4)
        L_0x0150:
            com.mpl.androidapp.databinding.SplashScreenBinding r3 = r1.mBinding
            android.widget.TextView r3 = r3.txtMessage
            r3.setText(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r3 = 0
            r0.setVisibility(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.ROOT_STATUS
            r1.buttonStatus = r0
            goto L_0x0857
        L_0x0185:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x0197
            r0.setVisibility(r9)
        L_0x0197:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131952838(0x7f1304c6, float:1.954213E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131952837(0x7f1304c5, float:1.9542128E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 2131952836(0x7f1304c4, float:1.9542126E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INSTALL_APK_LOW_STORAGE
            r1.buttonStatus = r0
            java.lang.String r0 = "low_storage_message_app"
            r1.sendLowStorageEventToReact(r0)
            goto L_0x0857
        L_0x01e9:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x01fb
            r0.setVisibility(r9)
        L_0x01fb:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131951951(0x7f13014f, float:1.954033E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131951950(0x7f13014e, float:1.9540329E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            boolean r0 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()
            if (r0 != 0) goto L_0x0229
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isProAppDownloadRequired()
            if (r0 == 0) goto L_0x0224
            goto L_0x0229
        L_0x0224:
            java.lang.String r0 = r1.getString(r15)
            goto L_0x0230
        L_0x0229:
            r0 = 2131951949(0x7f13014d, float:1.9540327E38)
            java.lang.String r0 = r1.getString(r0)
        L_0x0230:
            com.mpl.androidapp.databinding.SplashScreenBinding r2 = r1.mBinding
            android.widget.Button r2 = r2.btnDownload
            r2.setText(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.MIN_ROOT_VERSION_FAILED
            r1.buttonStatus = r0
            goto L_0x0857
        L_0x024c:
            r1.skipLaunchData = r4     // Catch:{ Exception -> 0x02ab }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView     // Catch:{ Exception -> 0x02ab }
            r1.slideUp(r0)     // Catch:{ Exception -> 0x02ab }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain     // Catch:{ Exception -> 0x02ab }
            if (r0 == 0) goto L_0x0262
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain     // Catch:{ Exception -> 0x02ab }
            r0.setVisibility(r9)     // Catch:{ Exception -> 0x02ab }
        L_0x0262:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            android.widget.TextView r0 = r0.txtStatus     // Catch:{ Exception -> 0x02ab }
            r2 = 2131952337(0x7f1302d1, float:1.9541114E38)
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x02ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x02ab }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            android.widget.TextView r0 = r0.txtMessage     // Catch:{ Exception -> 0x02ab }
            r2 = 2131952338(0x7f1302d2, float:1.9541116E38)
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x02ab }
            r0.setText(r2)     // Catch:{ Exception -> 0x02ab }
            boolean r0 = com.mpl.androidapp.utils.MBuildConfigUtils.isCashApp()     // Catch:{ Exception -> 0x02ab }
            if (r0 != 0) goto L_0x0290
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isProAppDownloadRequired()     // Catch:{ Exception -> 0x02ab }
            if (r0 == 0) goto L_0x028b
            goto L_0x0290
        L_0x028b:
            java.lang.String r0 = r1.getString(r15)     // Catch:{ Exception -> 0x02ab }
            goto L_0x0297
        L_0x0290:
            r0 = 2131952336(0x7f1302d0, float:1.9541112E38)
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x02ab }
        L_0x0297:
            com.mpl.androidapp.databinding.SplashScreenBinding r2 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            android.widget.Button r2 = r2.btnDownload     // Catch:{ Exception -> 0x02ab }
            r2.setText(r0)     // Catch:{ Exception -> 0x02ab }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x02ab }
            android.widget.TextView r0 = r0.storageTxt     // Catch:{ Exception -> 0x02ab }
            r0.setVisibility(r9)     // Catch:{ Exception -> 0x02ab }
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL     // Catch:{ Exception -> 0x02ab }
            r1.buttonStatus = r0     // Catch:{ Exception -> 0x02ab }
            goto L_0x0857
        L_0x02ab:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = " exception in INSTALLED_APK_INTEGRITY_FAIL"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline39(r0, r3)
            r3 = 0
            r2[r3] = r0
            com.mpl.androidapp.utils.MLogger.d(r6, r2)
            goto L_0x0857
        L_0x02c0:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x02d2
            r0.setVisibility(r9)
        L_0x02d2:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131952487(0x7f130367, float:1.9541418E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131952488(0x7f130368, float:1.954142E38)
            java.lang.String r3 = r1.getString(r2)
            r0.setText(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 2131951992(0x7f130178, float:1.9540414E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.NO_STORAGE
            r1.buttonStatus = r0
            java.lang.String r0 = "no_storage_available"
            r1.sendLowStorageEventToReact(r0)
            goto L_0x0857
        L_0x032e:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r3 = 0
            r0[r3] = r16
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x0348
            r0.setVisibility(r9)
        L_0x0348:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ImageView r0 = r0.imgAction
            r3 = 2131231323(0x7f08025b, float:1.8078724E38)
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r1, r3)
            r0.setImageDrawable(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r3 = 2131952482(0x7f130362, float:1.9541408E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r3 = 2131952484(0x7f130364, float:1.9541412E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r3 = 0
            r0.setVisibility(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INTERNET_ABSENT
            r1.buttonStatus = r0
            goto L_0x0857
        L_0x03a0:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideDown(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r2 = 0
            r0[r2] = r16
            java.lang.Boolean r2 = r1.isAppIntegrityFail
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            boolean r0 = r1.isReactInitHappened
            if (r0 != 0) goto L_0x03d1
            java.lang.Boolean r0 = r1.isAppIntegrityFail
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x03d1
            long r2 = java.lang.System.currentTimeMillis()
            r1.reactStartProcess = r2
            r17.init()
            goto L_0x0857
        L_0x03d1:
            java.lang.Boolean r0 = r1.isAppIntegrityFail
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0857
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INSTALLED_APK_INTEGRITY_FAIL
            r1.updateView(r0)
            goto L_0x0857
        L_0x03e0:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r2 = 0
            r0[r2] = r3
            java.lang.String r2 = "updateView:Downloading Critical Update "
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x03fe
            r0.setVisibility(r9)
        L_0x03fe:
            java.lang.String r14 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeInNormalPref()     // Catch:{ Exception -> 0x0403 }
            goto L_0x0404
        L_0x0403:
        L_0x0404:
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x042d
            boolean r0 = r13.equalsIgnoreCase(r14)
            if (r0 == 0) goto L_0x042d
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131951881(0x7f130109, float:1.954019E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131951883(0x7f13010b, float:1.9540193E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            goto L_0x0449
        L_0x042d:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131951880(0x7f130108, float:1.9540187E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131951882(0x7f13010a, float:1.9540191E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
        L_0x0449:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ImageView r0 = r0.imgAction
            r2 = 2131231275(0x7f08022b, float:1.8078626E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.DOWNLOADED_APK_INTEGRITY_FAIL
            r1.buttonStatus = r0
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r3 = "updateView() called:DOWNLOADED_APK_INTEGRITY_FAIL checkUpdateAvailableCall"
            r0[r2] = r3
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            com.mpl.androidapp.updater.AppInitialization r0 = r1.initialization
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.DOWNLOADED_APK_INTEGRITY_FAIL
            r0.checkUpdateAvailableCall(r1, r2)
            goto L_0x0857
        L_0x048a:
            r2 = 0
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r2] = r3
            java.lang.String r2 = "updateView:Checking For update is called "
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideDown(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x04a6
            r0.setVisibility(r9)
        L_0x04a6:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            goto L_0x0857
        L_0x04af:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r2 = 0
            r0[r2] = r3
            java.lang.String r2 = "updateView:Need to install APK "
            r0[r4] = r2
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isNewUpdaterChangeRequired()
            if (r0 != 0) goto L_0x052e
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x04d3
            r0.setVisibility(r9)
        L_0x04d3:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131952322(0x7f1302c2, float:1.9541083E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131952324(0x7f1302c4, float:1.9541088E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 2131952323(0x7f1302c3, float:1.9541086E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ImageView r0 = r0.imgAction
            r2 = 2131231276(0x7f08022c, float:1.8078628E38)
            android.graphics.drawable.Drawable r2 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
            r0.setImageDrawable(r2)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INSTALL
            r1.buttonStatus = r0
            goto L_0x0624
        L_0x052e:
            r0 = 0
            boolean r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUpdaterV2Enabled()     // Catch:{ Exception -> 0x060b }
            java.lang.String r3 = "@@ updater2"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x060b }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x060b }
            r15 = 0
            r5[r15] = r9     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.utils.MLogger.v(r3, r5)     // Catch:{ Exception -> 0x060b }
            java.lang.String r3 = "releasePoints"
            if (r2 != 0) goto L_0x055b
            com.mpl.androidapp.MPLApplication r0 = com.mpl.androidapp.MPLApplication.getInstance()     // Catch:{ Exception -> 0x060b }
            java.lang.String r2 = "releaseNotes"
            java.lang.String r5 = "{}"
            java.lang.String r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getStringInNormalPref(r0, r2, r5)     // Catch:{ Exception -> 0x060b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x060b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x060b }
            org.json.JSONArray r0 = r2.optJSONArray(r3)     // Catch:{ Exception -> 0x060b }
            goto L_0x0574
        L_0x055b:
            java.lang.String r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getReleaseNotesV2()     // Catch:{ Exception -> 0x060b }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x060b }
            r5.<init>(r2)     // Catch:{ Exception -> 0x060b }
            boolean r2 = r5.has(r3)     // Catch:{ Exception -> 0x060b }
            if (r2 == 0) goto L_0x0574
            org.json.JSONArray r2 = r5.optJSONArray(r3)     // Catch:{ Exception -> 0x060b }
            if (r2 == 0) goto L_0x0574
            org.json.JSONArray r0 = r5.optJSONArray(r3)     // Catch:{ Exception -> 0x060b }
        L_0x0574:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x060b }
            r2.<init>()     // Catch:{ Exception -> 0x060b }
            java.lang.String r14 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeInNormalPref()     // Catch:{ Exception -> 0x057d }
        L_0x057d:
            com.mpl.androidapp.databinding.SplashScreenBinding r3 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            android.widget.Button r3 = r3.releaseNoteBtnDownload     // Catch:{ Exception -> 0x060b }
            android.graphics.Typeface r5 = r1.mRobotoRegularFont     // Catch:{ Exception -> 0x060b }
            r3.setTypeface(r5)     // Catch:{ Exception -> 0x060b }
            boolean r3 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x060b }
            if (r3 != 0) goto L_0x05a0
            boolean r3 = r13.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x060b }
            if (r3 == 0) goto L_0x05a0
            com.mpl.androidapp.databinding.SplashScreenBinding r3 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            android.widget.Button r3 = r3.releaseNoteBtnDownload     // Catch:{ Exception -> 0x060b }
            r5 = 2131952326(0x7f1302c6, float:1.9541092E38)
            java.lang.String r5 = r1.getString(r5)     // Catch:{ Exception -> 0x060b }
            r3.setText(r5)     // Catch:{ Exception -> 0x060b }
        L_0x05a0:
            if (r0 == 0) goto L_0x0606
            int r3 = r0.length()     // Catch:{ Exception -> 0x060b }
            if (r3 <= 0) goto L_0x0606
            r1.hasReleaseNotes = r4     // Catch:{ Exception -> 0x060b }
            r3 = 0
        L_0x05ab:
            int r5 = r0.length()     // Catch:{ Exception -> 0x060b }
            if (r3 >= r5) goto L_0x05cc
            org.json.JSONObject r5 = r0.optJSONObject(r3)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.react.UpdateItem r9 = new com.mpl.androidapp.react.UpdateItem     // Catch:{ Exception -> 0x060b }
            java.lang.String r13 = "iconUrl"
            java.lang.String r13 = r5.optString(r13)     // Catch:{ Exception -> 0x060b }
            java.lang.String r14 = "updateDesc"
            java.lang.String r5 = r5.optString(r14)     // Catch:{ Exception -> 0x060b }
            r9.<init>(r13, r5)     // Catch:{ Exception -> 0x060b }
            r2.add(r9)     // Catch:{ Exception -> 0x060b }
            int r3 = r3 + 1
            goto L_0x05ab
        L_0x05cc:
            int r0 = r2.size()     // Catch:{ Exception -> 0x060b }
            if (r0 <= 0) goto L_0x0602
            com.mpl.androidapp.react.UpdateItem r0 = new com.mpl.androidapp.react.UpdateItem     // Catch:{ Exception -> 0x060b }
            r0.<init>()     // Catch:{ Exception -> 0x060b }
            r3 = 0
            r2.add(r3, r0)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain     // Catch:{ Exception -> 0x060b }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.react.UpdateListAdapter r0 = new com.mpl.androidapp.react.UpdateListAdapter     // Catch:{ Exception -> 0x060b }
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.databinding.SplashScreenBinding r2 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            androidx.recyclerview.widget.RecyclerView r2 = r2.updateItemList     // Catch:{ Exception -> 0x060b }
            r2.setAdapter(r0)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            android.widget.Button r0 = r0.releaseNoteBtnDownload     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.react.-$$Lambda$MPLReactContainerActivity$CeDA-UedBrSYEOk-iYGePDVktn0 r2 = new com.mpl.androidapp.react.-$$Lambda$MPLReactContainerActivity$CeDA-UedBrSYEOk-iYGePDVktn0     // Catch:{ Exception -> 0x060b }
            r2.<init>()     // Catch:{ Exception -> 0x060b }
            r0.setOnClickListener(r2)     // Catch:{ Exception -> 0x060b }
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding     // Catch:{ Exception -> 0x060b }
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteContainer     // Catch:{ Exception -> 0x060b }
            r1.slideUp(r0)     // Catch:{ Exception -> 0x060b }
            goto L_0x0624
        L_0x0602:
            r1.updateItemArrayList(r2, r4, r4)     // Catch:{ Exception -> 0x060b }
            goto L_0x0624
        L_0x0606:
            r3 = 0
            r1.updateItemArrayList(r2, r3, r4)     // Catch:{ Exception -> 0x060b }
            goto L_0x0624
        L_0x060b:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = "updateView: "
            r5 = 0
            r2[r5] = r3
            java.lang.String r0 = r0.getLocalizedMessage()
            r2[r4] = r0
            com.mpl.androidapp.utils.MLogger.e(r6, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.updateItemArrayList(r0, r5, r5)
        L_0x0624:
            boolean r0 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUpdaterV2Enabled()     // Catch:{ Exception -> 0x0857 }
            if (r0 == 0) goto L_0x067e
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0857 }
            r0.<init>()     // Catch:{ Exception -> 0x0857 }
            boolean r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()     // Catch:{ Exception -> 0x0857 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x0857 }
            r0.put(r11, r2)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Update Version"
            int r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUpdater2Version()     // Catch:{ Exception -> 0x0857 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0857 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Is Skippable"
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.canSkipPopup()     // Catch:{ Exception -> 0x0857 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0857 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Entry Point"
            java.lang.String r3 = "Splash Screen"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Eligibility Criteria"
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getEligibilityCriteria()     // Catch:{ Exception -> 0x0857 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Has Release Notes"
            boolean r3 = r1.hasReleaseNotes     // Catch:{ Exception -> 0x0857 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0857 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Install App Update"
            r0.put(r10, r2)     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Updater Version"
            r0.put(r2, r8)     // Catch:{ Exception -> 0x0857 }
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent(r12, r0)     // Catch:{ Exception -> 0x0857 }
            goto L_0x0857
        L_0x067e:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0857 }
            r0.<init>()     // Catch:{ Exception -> 0x0857 }
            java.lang.String r2 = "Pop Up Title"
            java.lang.String r3 = "App Update Available"
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0857 }
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent(r12, r0)     // Catch:{ Exception -> 0x0857 }
            goto L_0x0857
        L_0x068f:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r3 = "updateView:GENERIC_CONNECTION_ERROR "
            r4 = 0
            r0[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r5, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x06ab
            r0.setVisibility(r9)
        L_0x06ab:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ImageView r0 = r0.imgAction
            r3 = 2131231291(0x7f08023b, float:1.8078659E38)
            r0.setImageResource(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            java.lang.String r14 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeInNormalPref()     // Catch:{ Exception -> 0x06c1 }
            goto L_0x06c2
        L_0x06c1:
        L_0x06c2:
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x06eb
            boolean r0 = r13.equalsIgnoreCase(r14)
            if (r0 == 0) goto L_0x06eb
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r3 = 2131952263(0x7f130287, float:1.9540964E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r3 = 2131952265(0x7f130289, float:1.9540968E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
            goto L_0x0707
        L_0x06eb:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r3 = 2131952262(0x7f130286, float:1.9540962E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r3 = 2131952264(0x7f130288, float:1.9540966E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setText(r3)
        L_0x0707:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r3 = 0
            r0.setVisibility(r3)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r9)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.GENERIC_CONNECTION_ERROR
            r1.buttonStatus = r0
            goto L_0x0857
        L_0x072e:
            r1.skipLaunchData = r4
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r2 = 0
            r0[r2] = r3
            java.lang.String r3 = "updateView:Download APK is getting called"
            r0[r4] = r3
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            if (r0 == 0) goto L_0x074c
            r0.setVisibility(r2)
        L_0x074c:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x0755
            r0.setVisibility(r9)
        L_0x0755:
            java.lang.String r14 = com.mpl.androidapp.utils.CountryUtils.getCountryCodeInNormalPref()     // Catch:{ Exception -> 0x075a }
            goto L_0x075b
        L_0x075a:
        L_0x075b:
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x0784
            boolean r0 = r13.equalsIgnoreCase(r14)
            if (r0 == 0) goto L_0x0784
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131951881(0x7f130109, float:1.954019E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131951883(0x7f13010b, float:1.9540193E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            goto L_0x07a0
        L_0x0784:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131951880(0x7f130108, float:1.9540187E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131951882(0x7f13010a, float:1.9540191E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
        L_0x07a0:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r2)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "Critical Update Downloading"
            r0.put(r10, r2)
            int r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUpdater2Version()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "Update Version"
            r0.put(r3, r2)
            boolean r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.put(r11, r2)
            java.lang.String r2 = "Updater Version"
            r0.put(r2, r8)
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendEvent(r12, r0)
            goto L_0x0857
        L_0x07e8:
            r1.skipLaunchData = r4
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.errorView
            r1.slideUp(r0)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.releaseNoteLayoutMain
            if (r0 == 0) goto L_0x07fa
            r0.setVisibility(r9)
        L_0x07fa:
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtStatus
            r2 = 2131952339(0x7f1302d3, float:1.9541118E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtMessage
            r2 = 2131952340(0x7f1302d4, float:1.954112E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r2 = 2131951914(0x7f13012a, float:1.9540256E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setText(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.Button r0 = r0.btnDownload
            r0.setVisibility(r9)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.ProgressBar r0 = r0.progress
            r2 = 0
            r0.setVisibility(r2)
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.txtProgress
            r0.setVisibility(r2)
            com.mpl.androidapp.updater.util.StatusType r0 = com.mpl.androidapp.updater.util.StatusType.INTEGRITY_BUNDLE_RESOURCE_FAIL
            r1.buttonStatus = r0
            r1.buttonStatus = r0
            com.mpl.androidapp.databinding.SplashScreenBinding r0 = r1.mBinding
            android.widget.TextView r0 = r0.storageTxt
            r0.setVisibility(r9)
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r3 = "updateView() called:INTEGRITY_BUNDLE_RESOURCE_FAIL checkUpdateAvailableCall"
            r0[r2] = r3
            com.mpl.androidapp.utils.MLogger.d(r6, r0)
            com.mpl.androidapp.updater.AppInitialization r0 = r1.initialization
            com.mpl.androidapp.updater.util.StatusType r2 = com.mpl.androidapp.updater.util.StatusType.INTEGRITY_BUNDLE_RESOURCE_FAIL
            r0.checkUpdateAvailableCall(r1, r2)
        L_0x0857:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.MPLReactContainerActivity.updateView(com.mpl.androidapp.updater.util.StatusType):void");
    }

    private void submitGameScore(String str) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("submitGameScore called with: ", str));
        try {
            MSharedPreferencesUtils.setIsUserPlayingGame(false);
            if (this.reactEmitter != null) {
                if (TextUtils.isEmpty(str)) {
                    this.reactEmitter.emit(Constant.GAME_SCORE, "Quit game");
                } else if (str.startsWith("quitGame")) {
                    String trim = str.replace("quitGame", "").trim();
                    MLogger.d(TAG, "Data emit to react: " + trim);
                    this.reactEmitter.emit(Constant.GAME_SCORE, trim);
                } else {
                    RCTDeviceEventEmitter rCTDeviceEventEmitter = this.reactEmitter;
                    rCTDeviceEventEmitter.emit(Constant.GAME_SCORE, "{\"gameSession\":" + calculateGameSubmitData(str) + "}");
                }
                this.isSubmitScoreRequire = false;
                this.mScore = null;
                this.mResultIntentAfterUnity = null;
                return;
            }
            MLogger.e(TAG, "submitGameScore react context or emitter is null");
        } catch (Error | Exception e2) {
            MLogger.e(TAG, "submitGameScore", e2);
        }
    }
}
