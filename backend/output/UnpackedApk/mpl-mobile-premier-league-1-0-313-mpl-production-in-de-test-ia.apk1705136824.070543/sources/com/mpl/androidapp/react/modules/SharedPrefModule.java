package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.freshchat.consumer.sdk.Freshchat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.cleverTap.MplCtEventInitiate.CtEventConstants;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.game.ApkInfo;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.rules.DownloadRules;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.updater.util.UpdaterConstant.SharedPref;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.DeviceUtils;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.GpsUtils;
import com.mpl.androidapp.utils.GpsUtils.onGpsListener;
import com.mpl.androidapp.utils.LocaleHelper;
import com.mpl.androidapp.utils.LocationUtils;
import com.mpl.androidapp.utils.LocationUtils.ILocationListener;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.ScreenTrace;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.webview.repositories.WebFlowRepository;
import com.mpl.androidapp.webview.services.WebFlowGamesService;
import com.mpl.androidapp.webview.services.WebFlowServiceImpl;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.securepreferences.MPreferences;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.BaseConstants;
import com.rudderstack.android.sdk.core.RudderTraits;
import io.hansel.actions.configs.HanselConfigs;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "SharedPrefModule")
public class SharedPrefModule extends ReactContextBaseJavaModule implements WebFlowServiceImpl {
    public static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    public static final String E_PERMISSIONS_MISSING = "E_PERMISSION_MISSING";
    public static final int PERMISSION_LOCATION = 2398;
    public static final String TAG = "SharedPrefModule";
    public String gameConfigJson;
    public final ActivityEventListener mActivityListener = new ActivityEventListener() {
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i != 1024) {
                return;
            }
            if (i2 == -1) {
                if (SharedPrefModule.this.mLocationPromise != null) {
                    SharedPrefModule sharedPrefModule = SharedPrefModule.this;
                    sharedPrefModule.getAddressAfterLocationEnable(sharedPrefModule.mLocationPromise);
                }
            } else if (i2 == 0) {
                MLogger.d(SharedPrefModule.TAG, "Setting change Dialogue cancelled by user!");
                if (SharedPrefModule.this.mLocationPromise != null) {
                    SharedPrefModule.this.mLocationPromise.reject((String) "E_CALLBACK_ERROR", (String) "User Cancelled the settings change dialogue");
                }
            }
        }

        public void onNewIntent(Intent intent) {
            MLogger.d(SharedPrefModule.TAG, "onNewIntent: ");
        }
    };
    public final Context mContext;
    public boolean mDefaultLocale = true;
    public Promise mLocationPromise;
    public onSharePrefInteraction onSharePrefInteractionListerner;
    public ScreenTrace screenTrace;
    public int thirdPartyGameIntentFlags = 1954643968;
    public int thirdPartyWebIntentFlags = 402718720;

    public interface onSharePrefInteraction {
        void downloadPokerAssets(JSONObject jSONObject);

        void startPokerGame(JSONObject jSONObject);
    }

    public SharedPrefModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
        reactApplicationContext.addActivityEventListener(this.mActivityListener);
        if (getCurrentActivity() != null) {
            this.onSharePrefInteractionListerner = (onSharePrefInteraction) getCurrentActivity();
        }
        try {
            this.mDefaultLocale = ConfigManager.getPlatformConfig().optBoolean("location.default.locale", true);
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
    }

    public static String createScreenShotImagePath(Activity activity) {
        MLogger.d(TAG, "createScreenShotImagePath:1 ");
        try {
            return CommonUtils.takeReferralScreenshot(activity).optString("imgPath", "");
        } catch (Exception e2) {
            MLogger.e(TAG, "shareInAppScreenShot:1 ", e2);
            return "";
        }
    }

    /* access modifiers changed from: private */
    public void getAddressAfterLocationEnable(final Promise promise) {
        MLogger.d(TAG, "getAddressAfterLocationEnable: ");
        if (getCurrentActivity() == null || ((MPLReactContainerActivity) getCurrentActivity()).getFusedLocationClient() == null) {
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error");
            MLogger.d(TAG, "either current activity is null or fusedLocationclient is returned null");
            return;
        }
        final FusedLocationProviderClient fusedLocationClient = ((MPLReactContainerActivity) getCurrentActivity()).getFusedLocationClient();
        if (ContextCompat.checkSelfPermission(getCurrentActivity(), SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) == 0 || ContextCompat.checkSelfPermission(getCurrentActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            startLocationRequest(fusedLocationClient, promise);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(SMTConfigConstants.LOCATION_PERMISSION_MF_KEY);
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        permissionsCheck(getCurrentActivity(), promise, arrayList, new Callable<Void>() {
            public Void call() throws Exception {
                MLogger.d(SharedPrefModule.TAG, "getAddressAfterLocationEnable:call:1 ");
                if (SharedPrefModule.this.getCurrentActivity() == null) {
                    MLogger.d(SharedPrefModule.TAG, "getAddressAfterLocationEnable:call:3 ");
                    promise.reject((String) "E_CALLBACK_ERROR", (String) "Activity is null");
                } else if (ContextCompat.checkSelfPermission(SharedPrefModule.this.getCurrentActivity(), SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) == 0 || ContextCompat.checkSelfPermission(SharedPrefModule.this.getCurrentActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    SharedPrefModule.this.startLocationRequest(fusedLocationClient, promise);
                } else {
                    MLogger.d(SharedPrefModule.TAG, "getAddressAfterLocationEnable:call:2 ");
                    promise.reject((String) "E_CALLBACK_ERROR", (String) "Permission not present");
                }
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public void getAddressFromLatLong(Geocoder geocoder, Location location, Promise promise) {
        try {
            List<Address> fromLocation = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (fromLocation != null) {
                if (fromLocation.size() != 0) {
                    MLogger.d(TAG, "getAddressFromLatLong:Address is not null ");
                    Address address = fromLocation.get(0);
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(SMTEventParamKeys.SMT_LATITUDE, String.valueOf(address.getLatitude()));
                    jSONObject.put("long", String.valueOf(address.getLongitude()));
                    jSONObject.put("city", address.getLocality());
                    jSONObject.put("state", address.getAdminArea());
                    jSONObject.put("country", address.getCountryName());
                    jSONObject.put("countryCode", address.getCountryCode());
                    jSONObject.put("featureName", address.getFeatureName());
                    jSONObject.put("subAdminArea", address.getSubAdminArea());
                    for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
                        arrayList.add(address.getAddressLine(i));
                    }
                    jSONObject.put(RudderTraits.ADDRESS_KEY, TextUtils.join("\n", arrayList));
                    if (MPLApplication.getMplAnalytics() != null) {
                        MPLApplication.getMplAnalytics().pushLocationV2(location);
                    }
                    MSharedPreferencesUtils.setLocationProps(MPLApplication.getInstance(), jSONObject.toString());
                    promise.resolve(jSONObject.toString());
                    return;
                }
            }
            MLogger.d(TAG, "getAddressFromLatLong:Address is null ");
            promise.reject((String) "E_CALLBACK_ERROR", (String) "No Address found");
        } catch (Exception unused) {
            MLogger.d(TAG, "getAddressFromLatLong:Exception");
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error");
        }
    }

    private void getCurrentLocation(final FusedLocationProviderClient fusedLocationProviderClient, final Promise promise) {
        MLogger.d(TAG, "trying to detect current location");
        Task<Location> currentLocation = fusedLocationProviderClient.getCurrentLocation(100, new CancellationTokenSource().zza);
        AnonymousClass7 r1 = new OnSuccessListener<Location>() {
            /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A[Catch:{ Exception -> 0x0074 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(android.location.Location r10) {
                /*
                    r9 = this;
                    java.lang.String r0 = "E_CALLBACK_ERROR"
                    com.mpl.androidapp.react.modules.SharedPrefModule r1 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    r2 = 0
                    r3 = 1
                    java.lang.String r4 = "SharedPrefModule"
                    if (r1 == 0) goto L_0x0058
                    com.mpl.androidapp.react.modules.SharedPrefModule r1 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    boolean r1 = r1.isFinishing()     // Catch:{ Exception -> 0x0074 }
                    if (r1 != 0) goto L_0x0058
                    if (r10 == 0) goto L_0x005f
                    java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r5 = "onSuccess: current location is not null "
                    r1[r2] = r5     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.utils.MLogger.d(r4, r1)     // Catch:{ Exception -> 0x0074 }
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r5 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r5 = r5.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0074 }
                    r1.<init>(r5, r6)     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r5 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    boolean r5 = r5.mDefaultLocale     // Catch:{ Exception -> 0x0074 }
                    if (r5 != 0) goto L_0x0050
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r5 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r5 = r5.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    java.util.Locale r6 = new java.util.Locale     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r7 = "en"
                    java.lang.String r8 = "US"
                    r6.<init>(r7, r8)     // Catch:{ Exception -> 0x0074 }
                    r1.<init>(r5, r6)     // Catch:{ Exception -> 0x0074 }
                L_0x0050:
                    com.mpl.androidapp.react.modules.SharedPrefModule r5 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    com.facebook.react.bridge.Promise r6 = r5     // Catch:{ Exception -> 0x0074 }
                    r5.getAddressFromLatLong(r1, r10, r6)     // Catch:{ Exception -> 0x0074 }
                    goto L_0x005f
                L_0x0058:
                    com.facebook.react.bridge.Promise r1 = r5     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r5 = "Current Activity was null"
                    r1.reject(r0, r5)     // Catch:{ Exception -> 0x0074 }
                L_0x005f:
                    if (r10 != 0) goto L_0x007b
                    java.lang.Object[] r10 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r1 = "current location was null, fetching last known location instead"
                    r10[r2] = r1     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.utils.MLogger.d(r4, r10)     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r10 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0074 }
                    com.google.android.gms.location.FusedLocationProviderClient r1 = r4     // Catch:{ Exception -> 0x0074 }
                    com.facebook.react.bridge.Promise r2 = r5     // Catch:{ Exception -> 0x0074 }
                    r10.getLastKnownLocation(r1, r2)     // Catch:{ Exception -> 0x0074 }
                    goto L_0x007b
                L_0x0074:
                    com.facebook.react.bridge.Promise r10 = r5
                    java.lang.String r1 = "Exception in onSuccess"
                    r10.reject(r0, r1)
                L_0x007b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SharedPrefModule.AnonymousClass7.onSuccess(android.location.Location):void");
            }
        };
        zzw zzw = (zzw) currentLocation;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r1);
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void getLastKnownLocation(final FusedLocationProviderClient fusedLocationProviderClient, final Promise promise) {
        MLogger.d(TAG, "trying to detect last known location");
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(getCurrentActivity(), (OnSuccessListener<? super TResult>) new OnSuccessListener<Location>() {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
                if (android.location.Geocoder.isPresent() == false) goto L_0x000e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(android.location.Location r9) {
                /*
                    r8 = this;
                    java.lang.String r0 = "E_CALLBACK_ERROR"
                    r1 = 0
                    r2 = 1
                    java.lang.String r3 = "SharedPrefModule"
                    if (r9 == 0) goto L_0x000e
                    boolean r4 = android.location.Geocoder.isPresent()     // Catch:{ Exception -> 0x0096 }
                    if (r4 != 0) goto L_0x003c
                L_0x000e:
                    java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r5 = "onSuccess:Last known location is null "
                    r4[r1] = r5     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.utils.MLogger.d(r3, r4)     // Catch:{ Exception -> 0x0096 }
                    java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r5 = "onSuccess:Attempting to get a new location!"
                    r4[r1] = r5     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.utils.MLogger.d(r3, r4)     // Catch:{ Exception -> 0x0096 }
                    com.google.android.gms.location.LocationRequest r4 = com.google.android.gms.location.LocationRequest.create()     // Catch:{ Exception -> 0x0096 }
                    r5 = 100
                    r4.setPriority(r5)     // Catch:{ Exception -> 0x0096 }
                    r5 = 1000(0x3e8, double:4.94E-321)
                    r4.setInterval(r5)     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SharedPrefModule$8$1 r5 = new com.mpl.androidapp.react.modules.SharedPrefModule$8$1     // Catch:{ Exception -> 0x0096 }
                    r5.<init>()     // Catch:{ Exception -> 0x0096 }
                    com.google.android.gms.location.FusedLocationProviderClient r6 = r4     // Catch:{ Exception -> 0x0096 }
                    android.os.Looper r7 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0096 }
                    r6.requestLocationUpdates(r4, r5, r7)     // Catch:{ Exception -> 0x0096 }
                L_0x003c:
                    if (r9 == 0) goto L_0x009d
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r4 = "onSuccess:last known location is not null "
                    r2[r1] = r4     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.utils.MLogger.d(r3, r2)     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r1 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    if (r1 == 0) goto L_0x008e
                    com.mpl.androidapp.react.modules.SharedPrefModule r1 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    boolean r1 = r1.isFinishing()     // Catch:{ Exception -> 0x0096 }
                    if (r1 != 0) goto L_0x008e
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r2 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r2 = r2.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0096 }
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r2 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    boolean r2 = r2.mDefaultLocale     // Catch:{ Exception -> 0x0096 }
                    if (r2 != 0) goto L_0x0086
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SharedPrefModule r2 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r2 = r2.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    java.util.Locale r3 = new java.util.Locale     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r4 = "en"
                    java.lang.String r5 = "US"
                    r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0096 }
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0096 }
                L_0x0086:
                    com.mpl.androidapp.react.modules.SharedPrefModule r2 = com.mpl.androidapp.react.modules.SharedPrefModule.this     // Catch:{ Exception -> 0x0096 }
                    com.facebook.react.bridge.Promise r3 = r5     // Catch:{ Exception -> 0x0096 }
                    r2.getAddressFromLatLong(r1, r9, r3)     // Catch:{ Exception -> 0x0096 }
                    goto L_0x009d
                L_0x008e:
                    com.facebook.react.bridge.Promise r9 = r5     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r1 = "current activity null or is finishing"
                    r9.reject(r0, r1)     // Catch:{ Exception -> 0x0096 }
                    goto L_0x009d
                L_0x0096:
                    com.facebook.react.bridge.Promise r9 = r5
                    java.lang.String r1 = "Exception in onSuccess"
                    r9.reject(r0, r1)
                L_0x009d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SharedPrefModule.AnonymousClass8.onSuccess(android.location.Location):void");
            }
        });
    }

    private String getSessionTolken(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("status");
                if (!jSONObject2.has("code")) {
                    MLogger.i(TAG, "Key code is present");
                } else if (jSONObject2.optInt("code") != 200) {
                    MLogger.i(TAG, "Session API has failed");
                } else if (jSONObject.has("payload")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("payload");
                    if (jSONObject3.has("token")) {
                        return jSONObject3.optString("token");
                    }
                } else {
                    MLogger.i(TAG, "Payload key is not present");
                }
            } else {
                MLogger.i(TAG, "Status key is not present");
            }
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void launchThirdPartyGame(ApkInfo apkInfo, JSONObject jSONObject, String str, Boolean bool) {
        int i;
        JSONObject jSONObject2 = jSONObject;
        String str2 = str;
        try {
            MLogger.d(TAG, "launchThirdPartyGame: ", str2);
            if (getCurrentActivity() != null) {
                String packageName = apkInfo.getPackageName();
                String mainActivity = apkInfo.getMainActivity();
                String redirectUrl = apkInfo.getRedirectUrl();
                boolean isCredentialEnabled = apkInfo.isCredentialEnabled();
                boolean shouldLaunchPlayStore = apkInfo.getShouldLaunchPlayStore();
                boolean shouldLaunchSameInstance = apkInfo.shouldLaunchSameInstance();
                int launchingIndex = apkInfo.getLaunchingIndex();
                boolean isShouldAlwaysOpenPS = apkInfo.isShouldAlwaysOpenPS();
                if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(mainActivity)) {
                    Object[] objArr = new Object[3];
                    objArr[0] = "launchThirdPartyGame: PackageName or main activity is empty";
                    objArr[1] = packageName;
                    i = 2;
                    try {
                        objArr[2] = mainActivity;
                        MLogger.e(TAG, objArr);
                    } catch (Exception e2) {
                        e = e2;
                        Object[] objArr2 = new Object[i];
                        objArr2[0] = "launchThirdPartyGame: ";
                        objArr2[1] = e;
                        MLogger.e(TAG, objArr2);
                    }
                } else {
                    Intent intent = new Intent();
                    try {
                        intent.addFlags(this.thirdPartyGameIntentFlags);
                        if (Util.appInstalledOrNot(getCurrentActivity(), packageName)) {
                            if (!isShouldAlwaysOpenPS || !shouldLaunchPlayStore) {
                                intent.setComponent(new ComponentName(packageName, mainActivity));
                                if (isCredentialEnabled) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    if (bool.booleanValue()) {
                                        jSONObject3.put("sessionToken", str2);
                                    } else {
                                        jSONObject3.put("oAuthToken", str2);
                                    }
                                    jSONObject3.put(GameConstant.GAME_LOG_ENABLED, MBuildConfigUtils.isLogEnabled());
                                    jSONObject3.put(TQConstants.ENVIRONMENT, MBuildConfigUtils.getBuildFlavor().contains(BaseConstants.DEVELOPMENT) ? "Dev" : TQConstants.ENVIRONMENT_PROD);
                                    jSONObject3.put("marketIndex", launchingIndex);
                                    if (jSONObject2.has(WebViewGameVm.KEY_INTERNAL_ROUTE_OBJECT) && jSONObject2.optJSONObject(WebViewGameVm.KEY_INTERNAL_ROUTE_OBJECT) != null) {
                                        jSONObject3.put("navigateTo", jSONObject2.optJSONObject(WebViewGameVm.KEY_INTERNAL_ROUTE_OBJECT));
                                    }
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("mplData", jSONObject3);
                                    intent.putExtra("mpl", jSONObject4.toString());
                                    intent.setPackage(packageName);
                                }
                                if (shouldLaunchSameInstance) {
                                    intent.setFlags(0);
                                    getCurrentActivity().startActivityForResult(intent, Constant.REQUEST_CODE_FOR_EXTERNAL_GAME_PLAY);
                                    return;
                                }
                                getCurrentActivity().startActivity(intent);
                            } else if (!TextUtils.isEmpty(redirectUrl)) {
                                Util.openLinkInBrowser(getCurrentActivity(), redirectUrl);
                            } else {
                                Util.openAppInPlayStore(getCurrentActivity(), packageName);
                            }
                        } else if (shouldLaunchPlayStore) {
                            Util.openAppInPlayStore(getCurrentActivity(), packageName);
                        } else {
                            Util.openLinkInBrowser(getCurrentActivity(), redirectUrl);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = 2;
                        Object[] objArr22 = new Object[i];
                        objArr22[0] = "launchThirdPartyGame: ";
                        objArr22[1] = e;
                        MLogger.e(TAG, objArr22);
                    }
                }
            } else {
                MLogger.e(TAG, "launchThirdPartyGame: Current activity is null");
            }
        } catch (Exception e4) {
            e = e4;
            i = 2;
            Object[] objArr222 = new Object[i];
            objArr222[0] = "launchThirdPartyGame: ";
            objArr222[1] = e;
            MLogger.e(TAG, objArr222);
        }
    }

    private void permissionsCheck(Activity activity, final Promise promise, List<String> list, final Callable<Void> callable) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (ContextCompat.checkSelfPermission(activity, next) != 0) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            ((PermissionAwareActivity) activity).requestPermissions((String[]) arrayList.toArray(new String[0]), 2398, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    if (i == 2398) {
                        for (int i2 : iArr) {
                            if (i2 == -1) {
                                promise.reject((String) "E_PERMISSION_MISSING", (String) "Required permission missing");
                                return true;
                            }
                        }
                        try {
                            callable.call();
                        } catch (Exception e2) {
                            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error", (Throwable) e2);
                        }
                    }
                    return true;
                }
            });
            return;
        }
        try {
            callable.call();
        } catch (Exception e2) {
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error", (Throwable) e2);
        }
    }

    private void processAuthFlow(String str) {
        try {
            MLogger.d(TAG, "launchThirdPartyApplication: ");
            final ApkInfo apkInfo = (ApkInfo) new Gson().fromJson(str, ApkInfo.class);
            final JSONObject jSONObject = new JSONObject(str);
            if (apkInfo.isSecureAuth()) {
                NetworkUtils.getThirdPartyAuth(ApiEndPoints.THIRD_PARTY_AUTH_URL, new IResponseListener<String>() {
                    public void onResponseFail(Exception exc) {
                        MLogger.e(SharedPrefModule.TAG, "onResponseFail:launchThirdPartyApplication ", exc);
                    }

                    public void progressResponse(long j, long j2, boolean z) {
                    }

                    public void onResponseSuccess(String str) {
                        JSONObject apiResponse = NetworkUtils.getApiResponse(str);
                        String str2 = "";
                        if (apiResponse != null) {
                            str2 = apiResponse.optString("cgameAuthToken", str2);
                        }
                        MLogger.d(SharedPrefModule.TAG, "onResponseSuccess:launchThirdPartyApplication ", str2);
                        if (!TextUtils.isEmpty(str2)) {
                            SharedPrefModule.this.launchThirdPartyGame(apkInfo, jSONObject, str2, Boolean.FALSE);
                            return;
                        }
                        MLogger.e(SharedPrefModule.TAG, "onResponseSuccess:launchThirdPartyApplication Access token is empty ");
                    }
                });
            } else {
                launchThirdPartyGame(apkInfo, jSONObject, MSharedPreferencesUtils.getAccessUserToken(), Boolean.FALSE);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "launchThirdPartyApplication:launchThirdPartyApplication ", e2);
        }
    }

    private void processSessionFlow(String str, Gson gson) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("gameId")) {
                int optInt = jSONObject.optInt("gameId");
                String deviceId = MSharedPreferencesUtils.getDeviceId();
                int id = MSharedPreferencesUtils.getUserInfo().getId();
                String userName = MSharedPreferencesUtils.getUserName();
                String avatar = MSharedPreferencesUtils.getUserInfo().getAvatar();
                if (deviceId == null || userName == null || avatar == null) {
                    MLogger.i(TAG, "Some inputs are missing");
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("gameId", optInt);
                jSONObject2.put(Constant.HEADER_ANDROID_DEVICE_ID, deviceId);
                jSONObject2.put("userId", id);
                jSONObject2.put("name", userName);
                jSONObject2.put("avatarUrl", avatar);
                new WebFlowRepository(new WebFlowGamesService(gson)).getSessionToken(this, jSONObject2);
                return;
            }
            MLogger.i(TAG, "Game id is not present");
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
    }

    private void sendWebLaunchEvent(JSONObject jSONObject) {
        String optString = jSONObject.optString("GameName", "");
        if (TextUtils.isEmpty(optString)) {
            optString = jSONObject.optString("name", "");
        }
        String optString2 = jSONObject.optString(CtEventConstants.TOURNAMENT_NAME, "");
        String optString3 = jSONObject.optString("redirectUrl", "");
        boolean z = false;
        int optInt = jSONObject.optInt("TournamentId", 0);
        if (optInt == 0) {
            optInt = jSONObject.optInt("BattleId", 0);
        }
        int optInt2 = jSONObject.optInt("GameId", 0);
        if (optInt2 == 0) {
            optInt2 = jSONObject.optInt("id", 0);
        }
        boolean optBoolean = jSONObject.optBoolean("IsSponsored", false);
        HashMap outline87 = GeneratedOutlineSupport.outline87("Game Name", optString);
        outline87.put("App Start Time", Long.valueOf(System.currentTimeMillis()));
        outline87.put("Tournament Name", optString2);
        outline87.put(EventsConstants.PARAMS_TOURNAMENT_ID, Integer.valueOf(optInt));
        outline87.put("Is Sponsor", Boolean.valueOf(optBoolean));
        outline87.put("Redirect Url", optString3);
        outline87.put("Game ID", Integer.valueOf(optInt2));
        if (optString3 != null && !TextUtils.isEmpty(optString3)) {
            z = true;
        }
        outline87.put("Is Success", Boolean.valueOf(z));
        CleverTapAnalyticsUtils.sendWebAppOpenEvent(outline87);
    }

    public static void setShieldCustomValues(HashMap<String, String> hashMap) {
        try {
            hashMap.put("APP Version Name", String.valueOf(MBuildConfigUtils.getInstalledAppVersionNameGradle()));
            hashMap.put("APP Version Code", String.valueOf(MBuildConfigUtils.getInstalledAppVersionCodeGradle()));
            hashMap.put(EventsConstants.IS_CASH_APP, String.valueOf(MBuildConfigUtils.isCashApp()));
            hashMap.put(EventsConstants.ANDROID_APP_TYPE, String.valueOf(MBuildConfigUtils.getAppType()));
            DeviceUtils.setCustomShieldData("Login Screen", hashMap);
        } catch (Exception e2) {
            MLogger.e(TAG, "setShieldCustomValues: ", e2);
        }
    }

    public static void shareInAppScreenShot(Activity activity, String str, String str2, boolean z, String str3, String str4, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                CommonUtils.showScreenshotImage((FragmentActivity) activity, str3, str, str2, z, str4, z2);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "shareInAppScreenShot: ", e2);
        }
    }

    private void startBrainBaaziPWA() {
    }

    /* access modifiers changed from: private */
    public void startLocationRequest(FusedLocationProviderClient fusedLocationProviderClient, final Promise promise) {
        if (ConfigManager.getPlatformConfig().optBoolean("location.isLocationFlowV2Enabled", false)) {
            MLogger.d(TAG, "Starting New Location Flow");
            if (getCurrentActivity() != null) {
                final Long valueOf = Long.valueOf(System.currentTimeMillis());
                new LocationUtils(fusedLocationProviderClient).startLocationRequest(getCurrentActivity(), new ILocationListener() {
                    public void onLocationFetchSuccess(Location location) {
                        try {
                            MLogger.d(SharedPrefModule.TAG, "Time take to get location--->" + (((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d));
                            if (SharedPrefModule.this.getCurrentActivity() == null || SharedPrefModule.this.getCurrentActivity().isFinishing()) {
                                promise.reject((String) "E_CALLBACK_ERROR", (String) "current activity null or is finishing");
                                return;
                            }
                            Geocoder geocoder = new Geocoder(SharedPrefModule.this.getCurrentActivity(), Locale.getDefault());
                            if (!SharedPrefModule.this.mDefaultLocale) {
                                geocoder = new Geocoder(SharedPrefModule.this.getCurrentActivity(), new Locale(HyperVergeKycCapture.EN, "US"));
                            }
                            SharedPrefModule.this.getAddressFromLatLong(geocoder, location, promise);
                        } catch (Exception unused) {
                            promise.reject((String) "E_CALLBACK_ERROR", (String) "Exception in onLocationFetchSuccess");
                        }
                    }

                    public void onLocationFetchedFailed(String str) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Time take to fail (Seconds)--->");
                        outline73.append(((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d);
                        MLogger.d(SharedPrefModule.TAG, outline73.toString());
                        promise.reject((String) "E_CALLBACK_ERROR", str);
                    }

                    public void onLocationMocked() {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Time take to detect mock (Seconds)--->");
                        outline73.append(((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d);
                        MLogger.d(SharedPrefModule.TAG, outline73.toString());
                        if (SharedPrefModule.this.getCurrentActivity() != null && (SharedPrefModule.this.getCurrentActivity() instanceof MPLReactContainerActivity)) {
                            ((MPLReactContainerActivity) SharedPrefModule.this.getCurrentActivity()).showNativeGeoSpoofingDetectedDialogue();
                        }
                        promise.reject((String) "E_CALLBACK_ERROR", (String) "Location was mocked");
                    }
                });
                return;
            }
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Current Activity was null");
            return;
        }
        MLogger.d(TAG, "Starting Old Location Flow");
        if (ConfigManager.getPlatformConfig().optBoolean("location.addressFromCurrentLocationEnabled", false)) {
            getCurrentLocation(fusedLocationProviderClient, promise);
        } else {
            getLastKnownLocation(fusedLocationProviderClient, promise);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x02be A[SYNTHETIC, Splitter:B:123:0x02be] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03b4 A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03c3 A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142 A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014c A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x017b A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0184 A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018f A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019a A[Catch:{ Exception -> 0x03d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01bc A[Catch:{ Exception -> 0x03d9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startPartnerPWA(java.lang.String r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            java.lang.String r2 = "previewVideo"
            java.lang.String r3 = "redirectConfigUrl"
            java.lang.String r4 = "tournamentId"
            java.lang.String r5 = "type"
            java.lang.String r6 = "redirectActivity"
            java.lang.String r7 = "assets"
            java.lang.String r8 = "android"
            java.lang.String r9 = "platforms"
            java.lang.String r10 = "startPartnerPWA: "
            java.lang.String r11 = "SharedPrefModule"
            r13 = 0
            if (r0 == 0) goto L_0x03f9
            boolean r14 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x03f4 }
            if (r14 != 0) goto L_0x03f9
            boolean r14 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r25)     // Catch:{ Exception -> 0x03f4 }
            if (r14 == 0) goto L_0x03f9
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x03f4 }
            r14.<init>(r0)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r0 = "isPoker"
            boolean r0 = r14.optBoolean(r0, r13)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r15 = "GameId"
            int r15 = r14.optInt(r15, r13)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r12 = "id"
            if (r15 != 0) goto L_0x0040
            int r15 = r14.optInt(r12, r13)     // Catch:{ Exception -> 0x03f4 }
        L_0x0040:
            r13 = 1000067(0xf4283, float:1.401392E-39)
            if (r15 != r13) goto L_0x009c
            com.mpl.androidapp.react.modules.SharedPrefModule$onSharePrefInteraction r0 = r1.onSharePrefInteractionListerner     // Catch:{ Exception -> 0x03f4 }
            if (r0 != 0) goto L_0x0057
            android.app.Activity r0 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x0057
            android.app.Activity r0 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            com.mpl.androidapp.react.modules.SharedPrefModule$onSharePrefInteraction r0 = (com.mpl.androidapp.react.modules.SharedPrefModule.onSharePrefInteraction) r0     // Catch:{ Exception -> 0x03f4 }
            r1.onSharePrefInteractionListerner = r0     // Catch:{ Exception -> 0x03f4 }
        L_0x0057:
            com.mpl.androidapp.updater.gameengine.GEInteractor r0 = com.mpl.androidapp.updater.gameengine.GEInteractor.getInstance()     // Catch:{ Exception -> 0x03f4 }
            android.app.Activity r2 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            boolean r0 = r0.isAssetsAvailable(r2, r15)     // Catch:{ Exception -> 0x03f4 }
            if (r0 != 0) goto L_0x008a
            android.app.Activity r0 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            java.util.List r0 = com.mpl.androidapp.utils.AssetsConfigReader.listOfGameAssetsAvailableArray(r0)     // Catch:{ Exception -> 0x03f4 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x03f4 }
            boolean r0 = r0.contains(r2)     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x0078
            goto L_0x008a
        L_0x0078:
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r2 = "startPartnerPWA:Game code available Downloading Asset"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x03f4 }
            com.mpl.androidapp.utils.MLogger.d(r11, r0)     // Catch:{ Exception -> 0x03f4 }
            com.mpl.androidapp.react.modules.SharedPrefModule$onSharePrefInteraction r0 = r1.onSharePrefInteractionListerner     // Catch:{ Exception -> 0x03f4 }
            r0.downloadPokerAssets(r14)     // Catch:{ Exception -> 0x03f4 }
            goto L_0x0415
        L_0x008a:
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r2 = "startPartnerPWA:Game code available Starting Game "
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x03f4 }
            com.mpl.androidapp.utils.MLogger.d(r11, r0)     // Catch:{ Exception -> 0x03f4 }
            com.mpl.androidapp.react.modules.SharedPrefModule$onSharePrefInteraction r0 = r1.onSharePrefInteractionListerner     // Catch:{ Exception -> 0x03f4 }
            r0.startPokerGame(r14)     // Catch:{ Exception -> 0x03f4 }
            goto L_0x0415
        L_0x009c:
            java.lang.String r13 = "avatar"
            r16 = r4
            java.lang.String r4 = "extraInfo"
            r17 = r5
            java.lang.String r5 = "redirectAuth"
            r18 = r3
            java.lang.String r3 = "redirectUrl"
            r19 = r2
            java.lang.String r2 = ""
            r20 = r7
            r7 = 1000167(0xf42e7, float:1.401532E-39)
            if (r15 == r7) goto L_0x0230
            if (r0 == 0) goto L_0x00b9
            goto L_0x0230
        L_0x00b9:
            java.lang.String r0 = "game"
            boolean r0 = r14.has(r0)     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x00da
            android.app.Activity r0 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x00da
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x03f4 }
            android.app.Activity r2 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            java.lang.Class<com.mpl.androidapp.FantasyWebViewActivity> r3 = com.mpl.androidapp.FantasyWebViewActivity.class
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x03f4 }
            android.app.Activity r2 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f4 }
            r2.startActivity(r0)     // Catch:{ Exception -> 0x03f4 }
            return
        L_0x00da:
            boolean r0 = r14.has(r4)     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x010a
            java.lang.String r0 = r14.optString(r4)     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x010a
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03f4 }
            if (r4 != 0) goto L_0x010a
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x03f4 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x03f4 }
            boolean r0 = r4.has(r3)     // Catch:{ Exception -> 0x03f4 }
            if (r0 == 0) goto L_0x00fc
            java.lang.String r0 = r4.optString(r3, r2)     // Catch:{ Exception -> 0x03f4 }
            goto L_0x00fd
        L_0x00fc:
            r0 = r2
        L_0x00fd:
            boolean r7 = r4.has(r5)     // Catch:{ Exception -> 0x03f4 }
            if (r7 == 0) goto L_0x0108
            java.lang.String r4 = r4.optString(r5, r2)     // Catch:{ Exception -> 0x03f4 }
            goto L_0x010c
        L_0x0108:
            r4 = r2
            goto L_0x010c
        L_0x010a:
            r0 = r2
            r4 = r0
        L_0x010c:
            java.lang.String r7 = r14.optString(r2, r2)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r8 = r14.optString(r6, r2)     // Catch:{ Exception -> 0x03f4 }
            java.lang.String r9 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAccessUserToken()     // Catch:{ Exception -> 0x03f4 }
            r21 = r11
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x022b }
            r22 = r10
            java.lang.String r10 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserProfile()     // Catch:{ Exception -> 0x03ed }
            r11.<init>(r10)     // Catch:{ Exception -> 0x03ed }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x03ed }
            r10.<init>()     // Catch:{ Exception -> 0x03ed }
            r16 = r4
            r1 = 0
            int r4 = r11.optInt(r12, r1)     // Catch:{ Exception -> 0x03d9 }
            r10.put(r12, r4)     // Catch:{ Exception -> 0x03d9 }
            org.json.JSONObject r4 = com.mpl.androidapp.config.ConfigManager.getPlatformConfig()     // Catch:{ Exception -> 0x03d9 }
            r25 = r0
            java.lang.String r0 = "poker.username.enabled"
            boolean r0 = r4.optBoolean(r0, r1)     // Catch:{ Exception -> 0x03d9 }
            if (r0 == 0) goto L_0x014c
            java.lang.String r0 = "displayName"
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserNameForUser()     // Catch:{ Exception -> 0x03d9 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x03d9 }
            goto L_0x0155
        L_0x014c:
            java.lang.String r0 = "displayName"
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserName()     // Catch:{ Exception -> 0x03d9 }
            r10.put(r0, r1)     // Catch:{ Exception -> 0x03d9 }
        L_0x0155:
            java.lang.String r0 = r11.optString(r13, r2)     // Catch:{ Exception -> 0x03d9 }
            r10.put(r13, r0)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "Profile"
            r14.put(r0, r10)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "oAuthToken"
            r14.put(r0, r9)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "oAuth"
            r14.put(r0, r9)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "userId"
            r1 = 0
            int r4 = r11.optInt(r12, r1)     // Catch:{ Exception -> 0x03d9 }
            r14.put(r0, r4)     // Catch:{ Exception -> 0x03d9 }
            boolean r0 = r14.has(r3)     // Catch:{ Exception -> 0x03d9 }
            if (r0 == 0) goto L_0x017e
            r14.remove(r3)     // Catch:{ Exception -> 0x03d9 }
        L_0x017e:
            boolean r0 = r14.has(r5)     // Catch:{ Exception -> 0x03d9 }
            if (r0 == 0) goto L_0x0187
            r14.remove(r5)     // Catch:{ Exception -> 0x03d9 }
        L_0x0187:
            java.lang.String r0 = "redirectPackage"
            boolean r0 = r14.has(r0)     // Catch:{ Exception -> 0x03d9 }
            if (r0 == 0) goto L_0x0194
            java.lang.String r0 = "redirectPackage"
            r14.remove(r0)     // Catch:{ Exception -> 0x03d9 }
        L_0x0194:
            boolean r0 = r14.has(r6)     // Catch:{ Exception -> 0x03d9 }
            if (r0 == 0) goto L_0x019d
            r14.remove(r6)     // Catch:{ Exception -> 0x03d9 }
        L_0x019d:
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x03d9 }
            if (r1 != 0) goto L_0x01b8
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x03d9 }
            if (r1 != 0) goto L_0x01b8
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x03d9 }
            r0.<init>()     // Catch:{ Exception -> 0x03d9 }
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch:{ Exception -> 0x03d9 }
            r1.<init>(r7, r8)     // Catch:{ Exception -> 0x03d9 }
            r0.setComponent(r1)     // Catch:{ Exception -> 0x03d9 }
            goto L_0x01c7
        L_0x01b8:
            r1 = 788(0x314, float:1.104E-42)
            if (r15 != r1) goto L_0x01c7
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x03d9 }
            android.app.Activity r1 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03d9 }
            java.lang.Class<com.mpl.androidapp.FantasyWebViewActivity> r3 = com.mpl.androidapp.FantasyWebViewActivity.class
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x03d9 }
        L_0x01c7:
            android.app.Activity r1 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03d9 }
            if (r1 == 0) goto L_0x021a
            if (r0 == 0) goto L_0x021a
            boolean r1 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x03d9 }
            if (r1 != 0) goto L_0x021a
            java.lang.String r1 = "loadUrl"
            r3 = r25
            r0.putExtra(r1, r3)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "authHeader"
            r4 = r16
            r0.putExtra(r1, r4)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "gameId"
            r0.putExtra(r1, r15)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "userAuth"
            r0.putExtra(r1, r9)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "postData"
            java.lang.String r3 = r14.toString()     // Catch:{ Exception -> 0x03d9 }
            r0.putExtra(r1, r3)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "gameName"
            java.lang.String r3 = "name"
            java.lang.String r2 = r14.optString(r3, r2)     // Catch:{ Exception -> 0x03d9 }
            r0.putExtra(r1, r2)     // Catch:{ Exception -> 0x03d9 }
            r1 = r24
            r1.sendWebLaunchEvent(r14)     // Catch:{ Exception -> 0x03ed }
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03ed }
            r2 = 0
            r3[r2] = r22     // Catch:{ Exception -> 0x03ed }
            r6 = r21
            com.mpl.androidapp.utils.MLogger.d(r6, r3)     // Catch:{ Exception -> 0x03f1 }
            android.app.Activity r2 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f1 }
            r2.startActivity(r0)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x0415
        L_0x021a:
            r1 = r24
            r6 = r21
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03f1 }
            java.lang.String r2 = "startPartnerPWA: not able to start web app"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x03f1 }
            com.mpl.androidapp.utils.MLogger.e(r6, r0)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x0415
        L_0x022b:
            r0 = move-exception
            r22 = r10
            goto L_0x03ee
        L_0x0230:
            r22 = r10
            r6 = r11
            android.app.Activity r0 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f1 }
            if (r0 == 0) goto L_0x03dd
            org.json.JSONObject r0 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            java.lang.String r7 = "https://about.mpl.live/how-to-play-poker/"
            if (r0 == 0) goto L_0x02b1
            org.json.JSONObject r0 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r8)     // Catch:{ Exception -> 0x03f1 }
            if (r0 == 0) goto L_0x02b1
            org.json.JSONObject r0 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r8)     // Catch:{ Exception -> 0x03f1 }
            r10 = r20
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x03f1 }
            if (r0 == 0) goto L_0x02b1
            org.json.JSONObject r0 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r8)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x03f1 }
            r11 = r19
            java.lang.String r0 = r0.optString(r11)     // Catch:{ Exception -> 0x03f1 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x03f1 }
            if (r0 != 0) goto L_0x02b1
            org.json.JSONObject r0 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r8)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x03f1 }
            java.lang.String r0 = r0.optString(r11)     // Catch:{ Exception -> 0x03f1 }
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r9 = r14.optJSONObject(r9)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r8 = r9.optJSONObject(r8)     // Catch:{ Exception -> 0x03f1 }
            org.json.JSONObject r8 = r8.optJSONObject(r10)     // Catch:{ Exception -> 0x03f1 }
            java.lang.String r9 = "previewTournamentVideo"
            java.lang.String r8 = r8.optString(r9)     // Catch:{ Exception -> 0x03f1 }
            android.text.Spanned r8 = android.text.Html.fromHtml(r8)     // Catch:{ Exception -> 0x03f1 }
            if (r0 == 0) goto L_0x02a4
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03f1 }
            goto L_0x02a5
        L_0x02a4:
            r0 = r7
        L_0x02a5:
            if (r8 == 0) goto L_0x02ab
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x03f1 }
        L_0x02ab:
            r23 = r7
            r7 = r0
            r0 = r23
            goto L_0x02b2
        L_0x02b1:
            r0 = r7
        L_0x02b2:
            boolean r8 = r14.has(r4)     // Catch:{ Exception -> 0x03f1 }
            java.lang.String r9 = "secretKey"
            java.lang.String r10 = "assetsDownloadUrl"
            java.lang.String r11 = "assetsVersion"
            if (r8 == 0) goto L_0x0324
            java.lang.String r4 = r14.optString(r4)     // Catch:{ Exception -> 0x03f1 }
            if (r4 == 0) goto L_0x0324
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x03f1 }
            if (r8 != 0) goto L_0x0324
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x03f1 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x03f1 }
            boolean r4 = r8.has(r3)     // Catch:{ Exception -> 0x03f1 }
            if (r4 == 0) goto L_0x02da
            java.lang.String r3 = r8.optString(r3, r2)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x02db
        L_0x02da:
            r3 = r2
        L_0x02db:
            r4 = r18
            boolean r12 = r8.has(r4)     // Catch:{ Exception -> 0x03f1 }
            if (r12 == 0) goto L_0x02e8
            java.lang.String r4 = r8.optString(r4, r2)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x02e9
        L_0x02e8:
            r4 = r2
        L_0x02e9:
            boolean r12 = r8.has(r5)     // Catch:{ Exception -> 0x03f1 }
            if (r12 == 0) goto L_0x02f4
            java.lang.String r5 = r8.optString(r5, r2)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x02f5
        L_0x02f4:
            r5 = r2
        L_0x02f5:
            boolean r12 = r8.has(r9)     // Catch:{ Exception -> 0x03f1 }
            if (r12 == 0) goto L_0x0300
            java.lang.String r12 = r8.optString(r9, r2)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x0301
        L_0x0300:
            r12 = r2
        L_0x0301:
            boolean r18 = r8.has(r11)     // Catch:{ Exception -> 0x03f1 }
            r25 = r3
            if (r18 == 0) goto L_0x030f
            r3 = 1
            int r18 = r8.optInt(r11, r3)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x0311
        L_0x030f:
            r18 = 1
        L_0x0311:
            boolean r3 = r8.has(r10)     // Catch:{ Exception -> 0x03f1 }
            if (r3 == 0) goto L_0x031e
            java.lang.String r3 = "http://mplpoker.evenbetpoker.com/html5.zip"
            java.lang.String r3 = r8.optString(r10, r3)     // Catch:{ Exception -> 0x03f1 }
            goto L_0x031f
        L_0x031e:
            r3 = r2
        L_0x031f:
            r8 = r5
            r5 = r4
            r4 = r25
            goto L_0x032b
        L_0x0324:
            r3 = r2
            r4 = r3
            r5 = r4
            r8 = r5
            r12 = r8
            r18 = 1
        L_0x032b:
            android.app.Activity r19 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03f1 }
            r21 = r6
            android.content.Intent r6 = com.mpl.androidapp.webview.PokerWebViewActivity.getLaunchingIntent(r19)     // Catch:{ Exception -> 0x03ed }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x03d9 }
            r19 = r14
            java.lang.String r14 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserProfile()     // Catch:{ Exception -> 0x03d9 }
            r1.<init>(r14)     // Catch:{ Exception -> 0x03d9 }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x03d9 }
            r14.<init>()     // Catch:{ Exception -> 0x03d9 }
            r20 = r15
            java.lang.String r15 = "nick"
            r25 = r9
            java.lang.String r9 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserName()     // Catch:{ Exception -> 0x03d9 }
            r14.put(r15, r9)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r9 = java.lang.String.valueOf(r18)     // Catch:{ Exception -> 0x03d9 }
            r14.put(r11, r9)     // Catch:{ Exception -> 0x03d9 }
            r14.put(r10, r3)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = r1.optString(r13, r2)     // Catch:{ Exception -> 0x03d9 }
            r14.put(r13, r1)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "howToPlay"
            r14.put(r1, r7)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r1 = "tournamentHowToPlay"
            r14.put(r1, r0)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "postData"
            java.lang.String r1 = r14.toString()     // Catch:{ Exception -> 0x03d9 }
            r6.putExtra(r0, r1)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "loadUrl"
            r6.putExtra(r0, r4)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "configUrl"
            r6.putExtra(r0, r5)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "authHeader"
            r6.putExtra(r0, r8)     // Catch:{ Exception -> 0x03d9 }
            r0 = r25
            r6.putExtra(r0, r12)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "gameId"
            r15 = r20
            r6.putExtra(r0, r15)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "gameName"
            java.lang.String r1 = "Poker"
            r6.putExtra(r0, r1)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "gameIconClickTime"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03d9 }
            r6.putExtra(r0, r3)     // Catch:{ Exception -> 0x03d9 }
            java.lang.String r0 = "userAuth"
            java.lang.String r1 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getAccessUserToken()     // Catch:{ Exception -> 0x03d9 }
            r6.putExtra(r0, r1)     // Catch:{ Exception -> 0x03d9 }
            r1 = r17
            r0 = r19
            boolean r3 = r0.has(r1)     // Catch:{ Exception -> 0x03d9 }
            if (r3 == 0) goto L_0x03bb
            java.lang.String r3 = r0.optString(r1, r2)     // Catch:{ Exception -> 0x03d9 }
            r6.putExtra(r1, r3)     // Catch:{ Exception -> 0x03d9 }
        L_0x03bb:
            r1 = r16
            boolean r3 = r0.has(r1)     // Catch:{ Exception -> 0x03d9 }
            if (r3 == 0) goto L_0x03ca
            java.lang.String r2 = r0.optString(r1, r2)     // Catch:{ Exception -> 0x03d9 }
            r6.putExtra(r1, r2)     // Catch:{ Exception -> 0x03d9 }
        L_0x03ca:
            android.app.Activity r1 = r24.getCurrentActivity()     // Catch:{ Exception -> 0x03d9 }
            r2 = 1008(0x3f0, float:1.413E-42)
            r1.startActivityForResult(r6, r2)     // Catch:{ Exception -> 0x03d9 }
            r1 = r24
            r1.sendWebLaunchEvent(r0)     // Catch:{ Exception -> 0x03ed }
            goto L_0x0415
        L_0x03d9:
            r0 = move-exception
            r1 = r24
            goto L_0x03ee
        L_0x03dd:
            r21 = r6
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x03ed }
            java.lang.String r2 = "startPartnerPWA: CurrentActivity in null"
            r3 = 0
            r0[r3] = r2     // Catch:{ Exception -> 0x03ed }
            r2 = r21
            com.mpl.androidapp.utils.MLogger.d(r2, r0)     // Catch:{ Exception -> 0x0408 }
            goto L_0x0415
        L_0x03ed:
            r0 = move-exception
        L_0x03ee:
            r2 = r21
            goto L_0x0409
        L_0x03f1:
            r0 = move-exception
            r2 = r6
            goto L_0x0409
        L_0x03f4:
            r0 = move-exception
            r22 = r10
            r2 = r11
            goto L_0x0409
        L_0x03f9:
            r22 = r10
            r2 = r11
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0408 }
            java.lang.String r3 = "startPartnerPWA: Not able to open"
            r4 = 0
            r0[r4] = r3     // Catch:{ Exception -> 0x0408 }
            com.mpl.androidapp.utils.MLogger.e(r2, r0)     // Catch:{ Exception -> 0x0408 }
            goto L_0x0415
        L_0x0408:
            r0 = move-exception
        L_0x0409:
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r22
            r4 = 1
            r3[r4] = r0
            com.mpl.androidapp.utils.MLogger.e(r2, r3)
        L_0x0415:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SharedPrefModule.startPartnerPWA(java.lang.String):void");
    }

    @ReactMethod
    public void addShortCutOnHomeScreen(String str, final Promise promise) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("icon");
            int optInt = new JSONObject(jSONObject.optString("actionParams", "{}")).optJSONObject(OneSingnalConstant.PARAM_ACTION_PAYLOAD).optJSONObject("param").optInt("id");
            jSONObject.put("gameId", optInt);
            File file = new File(GEUtil.getGameDirInternalStoragePath(this.mContext), "GameIcon");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, optInt + ".png");
            try {
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
            } catch (IOException e2) {
                MLogger.printStackTrace(e2);
            }
            Builder destinationFilePath = new Builder().setUrl(optString).setDestinationFilePath(file2.getAbsolutePath());
            NetworkUtils.downloadFile(destinationFilePath.setDestinationFileName(optInt + ".png").build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    promise.resolve(Boolean.TRUE);
                    if (SharedPrefModule.this.getCurrentActivity() != null) {
                        SharedPrefModule.this.getCurrentActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                if (SharedPrefModule.this.getCurrentActivity() != null) {
                                    Toast.makeText(SharedPrefModule.this.getCurrentActivity(), SharedPrefModule.this.getCurrentActivity().getResources().getString(R.string.shortcut_fail), 0).show();
                                }
                            }
                        });
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    promise.resolve(Boolean.TRUE);
                    if (SharedPrefModule.this.getCurrentActivity() != null) {
                        CommonUtils.addShortcut(SharedPrefModule.this.getCurrentActivity(), jSONObject, str);
                    }
                }
            });
        } catch (Exception e3) {
            MLogger.printStackTrace(e3);
        }
    }

    @ReactMethod
    public void changeLocale(String str) {
        String language = LocaleHelper.getLanguage(MPLApplication.getInstance());
        MLogger.d(TAG, "changeLocale:1 ", "currentLocale: ", language, "localLanguage: ", str);
        String changeLanguageCode = LocaleHelper.changeLanguageCode(str);
        MLogger.d(TAG, "changeLocale:2 ", "currentLocale: ", language, "localLanguage: ", changeLanguageCode);
        LocaleHelper.setLocale(MPLApplication.getInstance().getBaseContext(), changeLanguageCode);
    }

    @ReactMethod
    public void clearAllData() {
        MSharedPreferencesUtils.clearApplicationUserData(MPLApplication.getInstance());
    }

    @ReactMethod
    public void closeApp() {
        Process.killProcess(Process.myPid());
    }

    @ReactMethod
    public void contains(String str, boolean z, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(MPreferences.contains(str, z)));
        } catch (Exception unused) {
            promise.resolve(Boolean.FALSE);
        }
    }

    @ReactMethod
    public void delete(String str, boolean z) {
        try {
            MPreferences.remove(str, z);
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void deleteReleaseNotes() {
        if (getCurrentActivity() != null) {
            MSharedPreferencesUtils.deleteNormalPref(getCurrentActivity(), Response.RELEASE_NOTES);
            MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), SharedPref.IS_RELEASE_NOTES_SCREEN_REQUIRED, false);
            if (!MSharedPreferencesUtils.getReleaseNotesV2().equals("{}")) {
                MSharedPreferencesUtils.deleteNormalPref(getCurrentActivity(), ConfigConstant.UPDATES2_RELEASE_NOTE);
                if (!MSharedPreferencesUtils.getReleasePoints().isEmpty()) {
                    MSharedPreferencesUtils.deleteNormalPref(getCurrentActivity(), ConfigConstant.UPDATES2_RELEASE_POINTS);
                }
            }
        }
    }

    @ReactMethod
    public void dismissNotification(int i) {
        try {
            if (getCurrentActivity() != null) {
                ((NotificationManager) getCurrentActivity().getSystemService("notification")).cancel(i);
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in dismissNotification : ")));
        }
    }

    @ReactMethod
    public void freshChat() {
        Freshchat.showConversations(getReactApplicationContext());
    }

    @ReactMethod
    public void get(String str, boolean z, Promise promise) {
        try {
            if (TextUtils.isEmpty(str) || !Constant.HOME_DATA.equalsIgnoreCase(str)) {
                promise.resolve(MPreferences.getString(str, null, z));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prefFileName", "com.mpl.androidapp.home");
                jSONObject.put("prefType", NetworkingModule.REQUEST_BODY_KEY_STRING);
                jSONObject.put("prefKey", Constant.HOME_DATA);
                jSONObject.put("prefDefaultValue", "");
                getValueFromPref(jSONObject.toString(), promise);
            } catch (Exception e2) {
                MLogger.e(TAG, "get: ", e2);
                promise.reject((String) "fail", (String) "Not able to find value");
            }
        } catch (Exception unused) {
            promise.reject((String) "fail", (String) "Not able to find value");
        }
    }

    @ReactMethod
    public void getAddress(final Promise promise) {
        MLogger.d(TAG, "getAddress called");
        if (getCurrentActivity() != null) {
            this.mLocationPromise = promise;
            new GpsUtils(getCurrentActivity()).turnGPSOn(new onGpsListener() {
                public void gpsStatus(boolean z) {
                    SharedPrefModule.this.mLocationPromise = null;
                    if (z) {
                        SharedPrefModule.this.getAddressAfterLocationEnable(promise);
                    } else {
                        promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error");
                    }
                }
            });
        }
    }

    @ReactMethod
    public void getCampaignSegmentKey(Promise promise) {
        try {
            promise.resolve(MBuildConfigUtils.getApkType());
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in getApkType ")));
        }
    }

    public Map<String, Object> getConstants() {
        boolean z = true;
        MLogger.d(TAG, "getConstants:MainLaunchingActivity ");
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.CONFIG_JSON_CONSTANT, MSharedPreferencesUtils.getConfigJson());
        hashMap.put(Constant.PLATFORM_CONFIG_JSON_CONSTANT, MSharedPreferencesUtils.getPlatConfigJson());
        hashMap.put(Constant.HANSEL_CONFIG_JSON_CONSTANT, MSharedPreferencesUtils.getHanselConfig());
        hashMap.put(Constant.CONFIG_COUNTRY_JSON_CONSTANT, MSharedPreferencesUtils.getCountryConfig());
        hashMap.put(Constant.CONFIG_CALLING_COUNTRY_JSON_CONSTANT, MSharedPreferencesUtils.getCallingCountryConfig());
        hashMap.put("locale", MSharedPreferencesUtils.getLocale());
        hashMap.put(Constant.COUNTRY_DATA, MSharedPreferencesUtils.getCountryData());
        hashMap.put(Constant.COUNTRY_DATA_LOGIN, MSharedPreferencesUtils.getCountryDataLogin());
        hashMap.put("language", MSharedPreferencesUtils.getUserSelectedLangauge());
        hashMap.put(Constant.ISCASHAPP, Boolean.valueOf(MBuildConfigUtils.isCashApp() || MSharedPreferencesUtils.isProAppDownloadRequired()));
        hashMap.put("accessToken", MSharedPreferencesUtils.getAccessUserToken());
        hashMap.put(Constant.PROFILE, MSharedPreferencesUtils.getProfile());
        hashMap.put(Constant.CHAT_TOKEN, MSharedPreferencesUtils.getChatToken());
        hashMap.put(ConfigConstant.IS_GUEST_USER_LOGIN, Boolean.valueOf(MSharedPreferencesUtils.getGuestUserLogin()));
        hashMap.put(Constant.IS_USER_LOGGED_IN, Boolean.valueOf(MSharedPreferencesUtils.isUserLoggedInTokenAvailable()));
        hashMap.put("fetchLoginInfo", Boolean.FALSE);
        hashMap.put(Constant.HOME_DATA, MSharedPreferencesUtils.getHomeData());
        hashMap.put(Constant.WEB_CLIENT_ID, MBuildConfigUtils.getWebClientID());
        hashMap.put(Constant.PRELOGIN_CAROUSAL_ENABLED, Boolean.valueOf(MBuildConfigUtils.getPreLoginCarousalEnabled()));
        if (ConfigManager.getPlatformConfig() != null) {
            hashMap.put(Constant.RUMMY_LEADERBOARD_REVAMP_ENABLED, Boolean.valueOf(ConfigManager.getPlatformConfig().optBoolean("rummy.leaderboard.revamp.enabled", false)));
            hashMap.put(Constant.IS_LOGIN_REVAMP_ENABLED, Boolean.valueOf(ConfigManager.getPlatformConfig().optBoolean("login.revamp.enable", false)));
        }
        hashMap.put(Constant.IS_REWARDBOT_ENABLED, MSharedPreferencesUtils.getRewardbotData());
        hashMap.put(Constant.IS_HOME_REVAMP_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean("home_revamp_enabled", false)));
        hashMap.put(Constant.PWF_FOOTER_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.PWF_FOOTER_ENABLED, false)));
        hashMap.put(Constant.IS_GAMES_REVAMP_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean("games_revamp_enabled", false)));
        hashMap.put(Constant.IS_NEW_GAME_VIEW, Boolean.valueOf(HanselConfigs.getBoolean("game_view_revamp_enabled", false)));
        hashMap.put(Constant.IS_SUPPORT_REVAMP, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_SUPPORT_REVAMP, false)));
        hashMap.put(Constant.IS_TEAM_CLASH_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_TEAM_CLASH_ENABLED, false)));
        hashMap.put(Constant.IS_QUICK_BATTLE_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_QUICK_BATTLE_ENABLED, false)));
        hashMap.put(Constant.IS_NEW_PWF_REFERRAL_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_NEW_PWF_REFERRAL_ENABLED, false)));
        hashMap.put(Constant.IS_SYNC_GAMES_ENABLED_PWF, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_SYNC_GAMES_ENABLED_PWF, false)));
        hashMap.put(Constant.IS_PWF_FOOTER_FANTASY_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_PWF_FOOTER_FANTASY_ENABLED, false)));
        hashMap.put(Constant.IS_PWF_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_PWF_ENABLED, false)));
        hashMap.put(Constant.SHOW_PUBLIC_TOURNAMENTS_PWF, Boolean.valueOf(HanselConfigs.getBoolean(Constant.SHOW_PUBLIC_TOURNAMENTS_PWF, false)));
        hashMap.put(Constant.CHAMPIONS_LEAGUE, Boolean.valueOf(HanselConfigs.getBoolean(Constant.CHAMPIONS_LEAGUE, false)));
        hashMap.put(Constant.IS_POWER_LEAGUE_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_POWER_LEAGUE_ENABLED, false)));
        hashMap.put(Constant.IS_NEW_GAMES_SEARCH_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean(Constant.IS_NEW_GAMES_SEARCH_ENABLED, false)));
        hashMap.put(Constant.IS_FANTASY_CONTEST_DETAIL_REVAMP_ENABLED_V2, Boolean.valueOf(HanselConfigs.getBoolean("superteam_contestDetail_v2_enabled_v2", false)));
        hashMap.put(Constant.IS_FANTASY_CONTEST_DETAIL_LIST_REVAMP_V3_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean("superteam_contests_v3_enabled", false)));
        hashMap.put(Constant.IS_FANTASY_PREVIEW_REVAMP_ENABLED, Boolean.valueOf(HanselConfigs.getBoolean("superteam_preview_team_v2_enabled", false)));
        hashMap.put(Constant.ENV, Constant.SET_ENV);
        hashMap.put(Constant.BASE_URL, MBuildConfigUtils.getMainUrl());
        hashMap.put(Constant.IS_LOG_ENABLED, Boolean.valueOf(MBuildConfigUtils.isLogEnabled() && MBuildConfigUtils.isDebuggable()));
        if (!MBuildConfigUtils.isDevelopmentModeEnabled() || !MBuildConfigUtils.isDebuggable()) {
            z = false;
        }
        hashMap.put(Constant.IS_DEBUG_MODE_ENABLED, Boolean.valueOf(z));
        hashMap.put(Constant.SPONSOR_DIR_NAME, FileUtils.getSponsorDir(this.mContext.getApplicationContext()));
        hashMap.put(Constant.SCREENSHOTS_DIR_NAME, FileUtils.getScreenshotsDir(this.mContext.getApplicationContext()) + "/");
        hashMap.put("is1v1", Boolean.TRUE);
        hashMap.put(Constant.REACT_APP_VERSION_CODE, Integer.valueOf(DBInteractor.getCurrentRNBundleVersionCode()));
        hashMap.put(Constant.ANDROID_APP_VERSION_CODE, Integer.valueOf(MBuildConfigUtils.getInstalledAppVersionCode()));
        hashMap.put(Constant.BUILD_NUMBER, Integer.valueOf(MBuildConfigUtils.getBuildNumber()));
        hashMap.put(Constant.ANDROID_API_VERSION, Integer.valueOf(VERSION.SDK_INT));
        hashMap.put(Constant.ANDROID_REGION_CODE, MBuildConfigUtils.getCountryCode());
        hashMap.put(Constant.ROUTE_LOGIN_REFERRAL, Boolean.valueOf(MBuildConfigUtils.getRouteLoginReferral()));
        hashMap.put(Constant.ANDROID_MIN_VERSION_FOR_CHECKING, Integer.valueOf(MBuildConfigUtils.getMinVersionForChecking()));
        hashMap.put("buildTime", MBuildConfigUtils.getBuildTime());
        hashMap.put(Constant.ENV, MBuildConfigUtils.getEnv());
        hashMap.put(Constant.HEADER_APK_TYPE, MBuildConfigUtils.getApkType());
        hashMap.put("game_id", Integer.valueOf(MBuildConfigUtils.getLaunchingGameId()));
        hashMap.put(Constant.SENTRY_DSN, MBuildConfigUtils.getSentryDsnKey());
        hashMap.put("isSamosa", Boolean.FALSE);
        hashMap.put("platformFtueEnabled", Boolean.valueOf(MBuildConfigUtils.isPlatformFtueEnabled()));
        hashMap.put("telegramPackageName", SocialPkgName.TELEGRAM_PACKAGE_NAME);
        hashMap.put("instagramPackageName", SocialPkgName.INSTAGRAM_PACKAGE_NAME);
        hashMap.put("fbMessengerPackageName", "com.facebook.orca");
        hashMap.put("fbPackageName", "com.facebook.katana");
        hashMap.put(Constant.APP_LAUNCH_TS, Long.valueOf(MSharedPreferencesUtils.getLongInNormalPref(MPLApplication.getInstance(), "app_launch_loading_time", System.currentTimeMillis())));
        hashMap.put(Constant.DECLUTTER_ENABLED, Boolean.valueOf(MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), Constant.DECLUTTER_ENABLED, false)));
        hashMap.put(Constant.IS_IA_ENABLED, Boolean.valueOf(MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), Constant.IS_IA_ENABLED, false)));
        hashMap.put(Constant.IS_DECLUTTER_IA_ENABLED, Boolean.valueOf(MSharedPreferencesUtils.getBooleanInNormalPref(MPLApplication.getInstance(), Constant.IS_DECLUTTER_IA_ENABLED, false)));
        hashMap.put(Constant.SEARCH_APPLICATION_ID, MBuildConfigUtils.getSearchApplicationId());
        hashMap.put(Constant.SEARCH_API_KEY, MBuildConfigUtils.getSearchAPIKey());
        hashMap.put(Constant.IN_BRAIN_CLIENT_ID, MBuildConfigUtils.getInBrainClientId());
        hashMap.put(Constant.IN_BRAIN_API_SECRET, MBuildConfigUtils.getInBrainClientSecret());
        hashMap.put(Constant.IS_ATT_ENABLED, Boolean.FALSE);
        hashMap.put(Constant.USER_EXP_API_KEY, MBuildConfigUtils.getUserExpAppKey());
        return hashMap;
    }

    @ReactMethod
    public void getInstallApkVersion(String str, Promise promise) {
        if (getCurrentActivity() == null || !Util.appInstalledOrNot(getCurrentActivity(), str)) {
            promise.reject((String) "fail", (String) "Failed to Load App Status");
        } else {
            promise.resolve(String.valueOf(Util.getInstalledApkVersion(getCurrentActivity(), str)));
        }
    }

    @ReactMethod
    public void getKeys(boolean z, Promise promise) {
        Object[] objArr;
        try {
            Map<String, ?> all = MPreferences.getAll(z);
            if (all != null) {
                Set<String> keySet = all.keySet();
                if (keySet == null) {
                    objArr = null;
                } else {
                    objArr = keySet.toArray();
                }
                promise.resolve(Arrays.toString(objArr));
                return;
            }
            promise.resolve(Arrays.toString(new String[0]));
        } catch (Exception e2) {
            MLogger.e(TAG, "getKeys", e2);
            promise.reject((String) "fail", (String) "Not able to find value");
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void getOneSignalId(Promise promise) {
        String oneSignalId = MSharedPreferencesUtils.getOneSignalId();
        if (TextUtils.isEmpty(oneSignalId)) {
            promise.resolve("");
        } else {
            promise.resolve(oneSignalId);
        }
    }

    @ReactMethod
    public void getOneSignalPushToken(Promise promise) {
        String oneSignalPushToken = MSharedPreferencesUtils.getOneSignalPushToken();
        if (TextUtils.isEmpty(oneSignalPushToken)) {
            promise.resolve("");
        } else {
            promise.resolve(oneSignalPushToken);
        }
    }

    @ReactMethod
    public void getSecondLaunchKey(String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constant.APP_ICON_CLICK_TIME_V2, MPreferences.getString(Constant.APP_ICON_CLICK_TIME_V2, null, false));
            jSONObject.put("warm_launch", MSharedPreferencesUtils.getBooleanInNormalPref(getReactApplicationContext(), "warm_launch", false));
            promise.resolve(jSONObject.toString());
        } catch (Exception unused) {
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void getValueFromPref(String str, Promise promise) {
        if (getCurrentActivity() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("prefFileName");
                String optString2 = jSONObject.optString("prefType");
                String optString3 = jSONObject.optString("prefKey");
                String optString4 = jSONObject.optString("prefDefaultValue");
                if (optString != null && !TextUtils.isEmpty(optString)) {
                    if ("int".equalsIgnoreCase(optString2)) {
                        promise.resolve(Integer.valueOf(MSharedPreferencesUtils.getIntInNormalPref(getCurrentActivity(), optString, optString3, Integer.parseInt(optString4))));
                    } else if ("boolean".equalsIgnoreCase(optString2)) {
                        promise.resolve(Boolean.valueOf(MSharedPreferencesUtils.getBooleanInNormalPref(getCurrentActivity(), optString, optString3, Boolean.parseBoolean(optString4))));
                    } else if ("long".equalsIgnoreCase(optString2)) {
                        promise.resolve(Long.valueOf(MSharedPreferencesUtils.getLongInNormalPref(getCurrentActivity(), optString, optString3, Long.parseLong(optString4))));
                    } else if ("float".equalsIgnoreCase(optString2)) {
                        promise.resolve(Float.valueOf(MSharedPreferencesUtils.getFloatInNormalPref(getCurrentActivity(), optString, optString3, Float.parseFloat(optString4))));
                    } else {
                        promise.resolve(MSharedPreferencesUtils.getStringInNormalPref(getCurrentActivity(), optString, optString3, optString4));
                    }
                }
            } catch (Exception unused) {
                promise.resolve(null);
            }
        } else {
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void guestUserLoggedOut() {
        MLogger.d(TAG, "guestuserlogin");
        MSharedPreferencesUtils.setGuestUserLogin(false);
        MSharedPreferencesUtils.saveIntInNormalPref(this.mContext, Constant.USER_ID_NORMAL, MSharedPreferencesUtils.getUserIdInNormalPrefV2(getReactApplicationContext()));
    }

    @ReactMethod
    public void guestUserLogin() {
        MLogger.d(TAG, "guestuserlogin");
        MSharedPreferencesUtils.setGuestUserLogin(true);
    }

    @ReactMethod
    public void hideSplash() {
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(20, null);
        }
    }

    @ReactMethod
    public void homePageLoaded() {
        MLogger.d(TAG, "homePageLoaded: ");
        DownloadRules.downloadNonCriticalUpdate(MPLApplication.getInstance());
        EventPublishHelper.publishProceedHomeData(MPLApplication.getInstance());
    }

    @ReactMethod
    public void homePageLoadedV2() {
        MLogger.d(TAG, "homePageLoadedV2");
    }

    @ReactMethod
    public void isAppInstalled(String str, Promise promise) {
        if (getCurrentActivity() != null) {
            promise.resolve(Boolean.valueOf(Util.appInstalledOrNot(getCurrentActivity(), str)));
        } else {
            promise.reject((String) "fail", (String) "Failed to get App Status");
        }
    }

    @ReactMethod
    public void isNotificationPermissionGranted(Promise promise) {
        if (VERSION.SDK_INT >= 33) {
            promise.resolve(Boolean.valueOf(NotificationManagerCompat.from(this.mContext).areNotificationsEnabled()));
        } else {
            promise.resolve(Boolean.TRUE);
        }
    }

    @ReactMethod
    public void launchThirdPartyApplication(String str) {
        this.gameConfigJson = str;
        Gson gson = new Gson();
        if (((ApkInfo) gson.fromJson(str, ApkInfo.class)).getAuthUrl().isEmpty()) {
            processAuthFlow(str);
        } else {
            processSessionFlow(str, gson);
        }
    }

    @ReactMethod
    public void logout() {
        if (getCurrentActivity() != null) {
            MSharedPreferencesUtils.deleteAllPref(getCurrentActivity(), false);
        }
    }

    @ReactMethod
    public void logoutAndRestart(boolean z) {
        if (getCurrentActivity() != null) {
            MSharedPreferencesUtils.deleteAllPrefAndRestart(getCurrentActivity(), z);
        }
    }

    @ReactMethod
    public void onCompleteHomePageLoaded() {
        EventPublishHelper.publishOnCompleteHomePageLoaded(MPLApplication.getInstance());
        MLogger.d(TAG, "onCompleteHomePageLoaded");
    }

    @ReactMethod
    public void onUserLoggedOut() {
        MLogger.d(TAG, "onUserLoggedOut() called");
        MSharedPreferencesUtils.deleteAllPref(MPLApplication.getInstance(), true);
    }

    @ReactMethod
    public void openAppInPlayStore(String str) {
        if (getCurrentActivity() != null) {
            Util.openAppInPlayStore(getCurrentActivity(), str);
        }
    }

    @ReactMethod
    public void openBrainBaazi() {
        if (getCurrentActivity() != null) {
            startBrainBaaziPWA();
        }
    }

    @ReactMethod
    public void openEmailApps() {
        if (getCurrentActivity() != null) {
            CommonUtils.openEmailApps(getCurrentActivity(), null);
        }
    }

    @ReactMethod
    public void openNotificationSetting() {
        String packageName = this.mContext.getPackageName();
        try {
            Intent intent = new Intent();
            if (VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
                if (VERSION.SDK_INT >= 28) {
                    intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                }
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", packageName);
                intent.putExtra("app_uid", this.mContext.getApplicationInfo().uid);
            }
            this.mContext.startActivity(intent);
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
    }

    @ReactMethod
    public void openOtherApplication(String str) {
        if (getCurrentActivity() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setComponent(new ComponentName("com.google.android.youtube", "com.google.android.youtube.PlayerActivity"));
            if (getCurrentActivity().getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                getCurrentActivity().startActivity(intent);
            }
        }
    }

    @ReactMethod
    public void openPartnerGame(String str) {
        startPartnerPWA(str);
    }

    @ReactMethod
    public void openThirdPartyApplication(String str) {
        try {
            MLogger.d(TAG, "openThirdPartyApplication: ");
            final JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("packageName", "");
            String optString2 = jSONObject.optString("mainActivity", "");
            String optString3 = jSONObject.optString("redirectUrl", "");
            boolean optBoolean = jSONObject.optBoolean("isPlayStoreApp", true);
            boolean optBoolean2 = jSONObject.optBoolean("isCredentialEnabled", false);
            boolean optBoolean3 = jSONObject.optBoolean("shouldAlwaysOpenPS", false);
            int optInt = jSONObject.optInt("launchingIndex", 0);
            int optInt2 = jSONObject.optInt("gameId", 0);
            boolean optBoolean4 = jSONObject.optBoolean("isSecureAuth", false);
            final ApkInfo apkInfo = new ApkInfo();
            apkInfo.setPackageName(optString);
            apkInfo.setMainActivity(optString2);
            apkInfo.setRedirectUrl(optString3);
            apkInfo.setPlayStoreApp(optBoolean);
            apkInfo.setShouldLaunchPlayStore(optBoolean);
            apkInfo.setCredentialEnabled(optBoolean2);
            apkInfo.setShouldAlwaysOpenPS(optBoolean3);
            apkInfo.setLaunchingIndex(optInt);
            apkInfo.setGameId(Integer.valueOf(optInt2));
            apkInfo.setSecureAuth(optBoolean4);
            if (optBoolean4) {
                NetworkUtils.getThirdPartyAuth(ApiEndPoints.THIRD_PARTY_AUTH_URL, new IResponseListener<String>() {
                    public void onResponseFail(Exception exc) {
                        MLogger.e(IResponseListener.TAG, "onResponseFail:openThirdPartyApplication ", exc);
                    }

                    public void progressResponse(long j, long j2, boolean z) {
                    }

                    public void onResponseSuccess(String str) {
                        JSONObject apiResponse = NetworkUtils.getApiResponse(str);
                        String str2 = "";
                        if (apiResponse != null) {
                            str2 = apiResponse.optString("cgameAuthToken", str2);
                        }
                        MLogger.d(SharedPrefModule.TAG, "onResponseSuccess:openThirdPartyApplication ", str2);
                        if (!TextUtils.isEmpty(str2)) {
                            SharedPrefModule.this.launchThirdPartyGame(apkInfo, jSONObject, str2, Boolean.FALSE);
                            return;
                        }
                        MLogger.e(SharedPrefModule.TAG, "onResponseSuccess:openThirdPartyApplication Access token is empty ");
                    }
                });
            } else {
                launchThirdPartyGame(apkInfo, jSONObject, MSharedPreferencesUtils.getAccessUserToken(), Boolean.FALSE);
            }
        } catch (Exception unused) {
            Toast.makeText(MPLApplication.getInstance(), "Some thing went wrong", 0).show();
        }
    }

    @ReactMethod
    public void put(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str) || !Constant.HOME_DATA.equalsIgnoreCase(str)) {
                MPreferences.putString(str, str2, z);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prefFileName", "com.mpl.androidapp.home");
                jSONObject.put("prefType", NetworkingModule.REQUEST_BODY_KEY_STRING);
                jSONObject.put("prefKey", Constant.HOME_DATA);
                jSONObject.put("prefDefaultValue", str2);
                saveValueFromPref(jSONObject.toString());
            } catch (Exception e2) {
                MLogger.e(TAG, "put: ", e2);
            }
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void recommendedApps(Promise promise) {
        if (getCurrentActivity() != null) {
            CommonUtils.getRecommendedApp(getCurrentActivity(), promise);
        }
    }

    @ReactMethod
    public void recordScreenTrace(final String str) {
        MLogger.d(TAG, GeneratedOutlineSupport.outline50("RecordScreenTrace start ", str));
        try {
            if (getCurrentActivity() != null) {
                getCurrentActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        SharedPrefModule sharedPrefModule = SharedPrefModule.this;
                        sharedPrefModule.screenTrace = new ScreenTrace(sharedPrefModule.getCurrentActivity(), str);
                        if (SharedPrefModule.this.screenTrace.isScreenTraceSupported()) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("RecordScreenTrace started ");
                            outline73.append(str);
                            MLogger.d(SharedPrefModule.TAG, outline73.toString());
                            SharedPrefModule.this.screenTrace.recordScreenTrace();
                            return;
                        }
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("RecordScreenTrace not supported ");
                        outline732.append(str);
                        MLogger.d(SharedPrefModule.TAG, outline732.toString());
                    }
                });
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in recordScreenTrace ")));
        }
    }

    @ReactMethod
    public void resetKeyboardInput(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                InputMethodManager inputMethodManager = (InputMethodManager) SharedPrefModule.this.getReactApplicationContext().getBaseContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    inputMethodManager.restartInput(resolveView);
                    try {
                        ((TextView) resolveView).setText("");
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    @ReactMethod
    public void restartApp() {
        MLogger.d(TAG, "restartApp called");
        if (getCurrentActivity() != null) {
            CommonUtils.restartMPL(getCurrentActivity());
        }
    }

    @ReactMethod
    public void saveUserInfo(ReadableMap readableMap) {
        MLogger.d(TAG, "saveUserInfo: " + readableMap);
        try {
            HashMap hashMap = new HashMap();
            if (readableMap != null && readableMap.hasKey("mobileNumber") && !TextUtils.isEmpty(readableMap.getString("mobileNumber"))) {
                MSharedPreferencesUtils.saveStringInNormalPref(this.mContext, Constant.USER_MOBILE_NUMBER_NORMAL_V2, readableMap.getString("mobileNumber"));
                hashMap.put("mobile_number", readableMap.getString("mobileNumber"));
            }
            if (!(readableMap == null || !readableMap.hasKey("userId") || readableMap.getInt("userId") == 0)) {
                MSharedPreferencesUtils.saveIntInNormalPref(this.mContext, Constant.USER_USER_ID_NORMAL_V2, readableMap.getInt("userId"));
                hashMap.put("user_id", String.valueOf(readableMap.getInt("userId")));
            }
            if (readableMap != null && readableMap.hasKey(Constant.HASHED_UNIQUE_ID) && !TextUtils.isEmpty(readableMap.getString(Constant.HASHED_UNIQUE_ID))) {
                MSharedPreferencesUtils.saveStringInNormalPref(this.mContext, Constant.USER_SUID_NORMAL_V2, readableMap.getString(Constant.HASHED_UNIQUE_ID));
            }
            setShieldCustomValues(hashMap);
        } catch (Exception e2) {
            MLogger.e(TAG, "saveUserInfo: ", e2);
        }
    }

    @ReactMethod
    public void saveValueFromPref(String str) {
        if (getCurrentActivity() != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("prefFileName");
                String optString2 = jSONObject.optString("prefType");
                String optString3 = jSONObject.optString("prefKey");
                String optString4 = jSONObject.optString("prefDefaultValue");
                if ("int".equalsIgnoreCase(optString2)) {
                    MSharedPreferencesUtils.saveIntInNormalPref(getCurrentActivity(), optString, optString3, Integer.parseInt(optString4));
                } else if ("boolean".equalsIgnoreCase(optString2)) {
                    MSharedPreferencesUtils.saveBooleanInNormalPref(getCurrentActivity(), optString, optString3, Boolean.parseBoolean(optString4));
                } else if ("long".equalsIgnoreCase(optString2)) {
                    MSharedPreferencesUtils.saveLongInNormalPref(getCurrentActivity(), optString, optString3, Long.parseLong(optString4));
                } else if ("float".equalsIgnoreCase(optString2)) {
                    MSharedPreferencesUtils.saveFloatInNormalPref(getCurrentActivity(), optString, optString3, Float.parseFloat(optString4));
                } else {
                    MSharedPreferencesUtils.saveStringInNormalPref(getCurrentActivity(), optString, optString3, optString4);
                }
            } catch (Exception e2) {
                MLogger.e(TAG, "saveValueFromPref: ", e2);
            }
        } else {
            MLogger.e(TAG, "saveValueFromPref: activity is null");
        }
    }

    @ReactMethod
    public void sendScreenTrace() {
        try {
            if (getCurrentActivity() != null) {
                getCurrentActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        if (SharedPrefModule.this.screenTrace != null) {
                            MLogger.d(SharedPrefModule.TAG, "sendScreenTrace start");
                            SharedPrefModule.this.screenTrace.sendScreenTrace();
                        }
                    }
                });
            }
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in sendScreenTrace ")));
        }
    }

    public void sessionApiFailure(String str) {
        MLogger.e(TAG, str);
    }

    public void sessionApiSuccess(String str) {
        try {
            String sessionTolken = getSessionTolken(str);
            if (sessionTolken == null || sessionTolken.length() <= 0) {
                MLogger.e(TAG, "Invalid Session token");
                return;
            }
            launchThirdPartyGame((ApkInfo) new Gson().fromJson(this.gameConfigJson, ApkInfo.class), new JSONObject(this.gameConfigJson), sessionTolken, Boolean.TRUE);
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
    }

    @ReactMethod
    public void setCleverTapMarketingOptOut() {
        if (MPLApplication.getMplAnalytics() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.USER_MSG_EMAIL_CLEVER_TAP, Boolean.FALSE);
            hashMap.put(EventsConstants.USER_MSG_PUSH_CLEVER_TAP, Boolean.FALSE);
            hashMap.put(EventsConstants.USER_MSG_SMS_CLEVER_TAP, Boolean.FALSE);
            hashMap.put("MSG-push-all", Boolean.FALSE);
            MPLApplication.getMplAnalytics().pushProfileEventV2(hashMap);
        }
    }

    @ReactMethod
    public void setCleverTapOptOut() {
        if (MPLApplication.getMplAnalytics() != null) {
            MPLApplication.getMplAnalytics().stopLoggingEvent();
        }
    }

    @ReactMethod
    public void setFirebaseCustomKeys(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            CustomKeysAndValues.Builder builder = new CustomKeysAndValues.Builder();
            for (int i = 0; i <= jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                builder.putString(jSONObject.getString("key"), jSONObject.getString(HSLCriteriaBuilder.VALUE));
            }
            FirebaseCrashlytics.getInstance().setCustomKeys(builder.build());
        } catch (JSONException e2) {
            MLogger.e(TAG, "setFirebaseCustomKeys", e2);
        }
    }

    @ReactMethod
    public void setFirebaseCustomTag(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
    }

    @ReactMethod
    public void setFirebaseException(ReadableMap readableMap) {
        String str = "";
        String string = readableMap.hasKey("message") ? readableMap.getString("message") : str;
        if (readableMap.hasKey("stackTrace")) {
            str = readableMap.getString("stackTrace");
        }
        FirebaseCrashlytics.getInstance().recordException(new Exception(GeneratedOutlineSupport.outline53("message: ", string, " stackTrace: ", str)));
    }

    @ReactMethod
    public void setScreenOrientation(String str) {
        if (getCurrentActivity() != null && !TextUtils.isEmpty(str)) {
            getCurrentActivity().setRequestedOrientation(str.equals(SMTConfigConstants.SCREEN_ORIENTATION_PORTRAIT) ? 1 : 0);
        }
    }

    @ReactMethod
    public void shareScreenShot(String str, String str2, Promise promise) {
        try {
            if (getCurrentActivity() != null) {
                boolean optBoolean = ConfigManager.getPlatformConfig().optBoolean(GameConstant.GAME_IS_SCREEN_SHARE_UI_DISABLED, false);
                String optString = ConfigManager.getNormalConfig().optString(GameConstant.GAME_IS_SCREEN_SHARE_OPTION, "default");
                MPLApplication instance = MPLApplication.getInstance();
                final String str3 = str;
                final String str4 = str2;
                final String str5 = optString;
                final boolean z = optBoolean;
                AnonymousClass10 r5 = new Callback() {
                    public void invoke(Object... objArr) {
                        SharedPrefModule.shareInAppScreenShot(SharedPrefModule.this.getCurrentActivity(), str3.replace("{URL}", objArr[0]), str4, false, SharedPrefModule.createScreenShotImagePath(SharedPrefModule.this.getCurrentActivity()), str5, z);
                    }
                };
                final String str6 = str;
                final String str7 = str2;
                final String str8 = optString;
                final boolean z2 = optBoolean;
                AnonymousClass11 r52 = new Callback() {
                    public void invoke(Object... objArr) {
                        SharedPrefModule.shareInAppScreenShot(SharedPrefModule.this.getCurrentActivity(), str6.replace("{URL}", ConfigManager.getReferralNudgeConfig().optString("default.url", "")), str7, false, SharedPrefModule.createScreenShotImagePath(SharedPrefModule.this.getCurrentActivity()), str8, z2);
                    }
                };
                CommonUtils.createAppsFlyerReferralLink(instance, "{}", new PromiseImpl(r5, r52));
            } else {
                MLogger.d(TAG, "shareScreenShot: Current Activity is null");
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "shareScreenShot: ", e2);
        }
        promise.resolve("resolve");
    }

    @ReactMethod
    public void shareTeam() {
    }

    @ReactMethod
    public void shouldSkipFTUE(Promise promise) {
        boolean z = false;
        if (getCurrentActivity() != null && MSharedPreferencesUtils.getBooleanInNormalPref(getCurrentActivity(), "shouldSkipFTUE", false)) {
            z = true;
        }
        promise.resolve(Boolean.valueOf(z));
    }

    @ReactMethod
    public void showAppInbox() {
        DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
        if (downloadProgressReceiver != null) {
            downloadProgressReceiver.send(16, null);
        }
    }

    @ReactMethod
    public void showBackgroundRunningDialog() {
        if (getCurrentActivity() != null) {
            Util.startPowerSaverIntent(getCurrentActivity());
        }
    }

    @ReactMethod
    public void showCustomToast(String str) {
        Util.showCustomToast(str);
    }

    @ReactMethod
    public void startAppseeRecording() {
    }

    @ReactMethod
    public void startScreenShot() {
        MLogger.d(TAG, "startScreenShot: ");
        if (getCurrentActivity() != null && getCurrentActivity().getWindow() != null) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                public void run() {
                    if (SharedPrefModule.this.getCurrentActivity() != null) {
                        SharedPrefModule.this.getCurrentActivity().getWindow().clearFlags(8192);
                    }
                }
            });
        }
    }

    @ReactMethod
    public void stopAppseeRecording() {
    }

    @ReactMethod
    public void stopScreenShot() {
        MLogger.d(TAG, "stopScreenShot: ");
        if (getCurrentActivity() != null && getCurrentActivity().getWindow() != null) {
            getCurrentActivity().runOnUiThread(new Runnable() {
                public void run() {
                    if (SharedPrefModule.this.getCurrentActivity() != null) {
                        SharedPrefModule.this.getCurrentActivity().getWindow().setFlags(8192, 8192);
                    }
                }
            });
        }
    }

    @ReactMethod
    public void switchServer() {
        if (getCurrentActivity() != null) {
            MSharedPreferencesUtils.deleteAllPref(getCurrentActivity(), true);
        }
    }

    @ReactMethod
    public void takeScreenShot(String str, Promise promise) {
        try {
            if (getCurrentActivity() != null) {
                JSONObject takeScreenshot = CommonUtils.takeScreenshot(getCurrentActivity(), str);
                if (takeScreenshot != null) {
                    promise.resolve(takeScreenshot.toString());
                } else {
                    promise.reject((String) "Error", (String) "Not able to create screenshot because json is null");
                }
            } else {
                promise.reject((String) "Error", (String) "Not able to create screenshot because current activity is null");
            }
        } catch (Exception e2) {
            promise.reject((String) "Error", e2.getMessage());
        }
    }

    @ReactMethod
    public void testCall() {
    }

    @ReactMethod
    public void userLoggedIn() {
        EventPublishHelper.publishProceedAfterLoginData(MPLApplication.getInstance());
    }

    @ReactMethod
    public void delete(String str) {
        try {
            MPreferences.remove(str, false);
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void contains(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(MPreferences.contains(str, false)));
        } catch (Exception unused) {
            promise.resolve(Boolean.FALSE);
        }
    }

    @ReactMethod
    public void openBrainBaazi(String str) {
        startBrainBaaziPWA();
    }

    public static String createScreenShotImagePath(Activity activity, View view) {
        MLogger.d(TAG, "createScreenShotImagePath:2 ");
        try {
            return CommonUtils.takeReferralScreenshot(activity, view).optString("imgPath", "");
        } catch (Exception e2) {
            MLogger.e(TAG, "shareInAppScreenShot:2 ", e2);
            return "";
        }
    }

    @ReactMethod
    public void getKeys(Promise promise) {
        Object[] objArr;
        Map<String, ?> all = MPreferences.getAll(false);
        if (all != null) {
            Set<String> keySet = all.keySet();
            if (keySet == null) {
                objArr = null;
            } else {
                objArr = keySet.toArray();
            }
            promise.resolve(Arrays.toString(objArr));
            return;
        }
        promise.resolve(Arrays.toString(new String[0]));
    }

    @ReactMethod
    public void put(String str, String str2) {
        try {
            MPreferences.putString(str, str2, false);
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void get(String str, Promise promise) {
        try {
            promise.resolve(MPreferences.getString(str, null, false));
        } catch (Exception unused) {
            promise.resolve(null);
        }
    }
}
