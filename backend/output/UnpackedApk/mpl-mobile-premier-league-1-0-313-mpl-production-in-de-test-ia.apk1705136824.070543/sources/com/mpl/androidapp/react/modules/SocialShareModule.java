package com.mpl.androidapp.react.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.Html;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.share.Sharer$Result;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareLinkContent.Builder;
import com.facebook.share.widget.ShareDialog;
import com.facebook.share.widget.ShareDialog.Companion;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.backgroundmanager.BackgroundTaskHandler;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.updater.util.GEUtil;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.GpsUtilsV2;
import com.mpl.androidapp.utils.GpsUtilsV2.OnGpsListenerV2;
import com.mpl.androidapp.utils.LocationUtils;
import com.mpl.androidapp.utils.LocationUtils.ILocationListener;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.ShareFile;
import com.mpl.androidapp.utils.Util;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.SMTEventParamKeys;
import com.rudderstack.android.sdk.core.RudderTraits;
import com.twitter.sdk.android.tweetcomposer.TweetComposer$Builder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import org.apache.fontbox.cmap.CMap;
import org.json.JSONObject;

@ReactModule(name = "SocialShareModule")
public class SocialShareModule extends ReactContextBaseJavaModule {
    public static final String E_CALLBACK_ERROR = "E_CALLBACK_ERROR";
    public static final String E_PERMISSIONS_MISSING = "E_PERMISSION_MISSING";
    public static final int PERMISSION_LOCATION = 2398;
    public static final int SHARE_TO_WHATSAPP = 1003;
    public static final int SHARE_TO_WHATSAPP_TO_NUMBER = 1033;
    public static final String TAG = "SocialShareModule";
    public CallbackManager callbackManager;
    public Promise mApkPromise;
    public boolean mDefaultLocale = true;
    public Promise mLocationPromise;
    public Promise mPromise;
    public Promise mPromiseWhats;
    public final ReactApplicationContext reactContext;

    public class APKInfo {
        public File mApkFile;
        public String mApkName;
        public String mApkVersionCode;
        public String mApkVersionName;
        public String mReceiverNumber;
        public String mSendExtraText;

        public APKInfo() {
        }

        public File getApkFile() {
            return this.mApkFile;
        }

        public String getApkName() {
            return this.mApkName;
        }

        public String getApkVersionCode() {
            return this.mApkVersionCode;
        }

        public String getApkVersionName() {
            return this.mApkVersionName;
        }

        public String getReceiverNumber() {
            return this.mReceiverNumber;
        }

        public String getSendExtraText() {
            return this.mSendExtraText;
        }

        public void setApkFile(File file) {
            this.mApkFile = file;
        }

        public void setApkFilePath(File file) {
            this.mApkFile = file;
        }

        public void setApkName(String str) {
            this.mApkName = str;
        }

        public void setApkVersionCode(String str) {
            this.mApkVersionCode = str;
        }

        public void setApkVersionName(String str) {
            this.mApkVersionName = str;
        }

        public void setReceiverNumber(String str) {
            this.mReceiverNumber = str;
        }

        public void setSendExtraText(String str) {
            this.mSendExtraText = str;
        }
    }

    public class FetchApk extends AsyncTask<APKInfo, Void, Intent> {
        public FetchApk() {
        }

        public void onPreExecute() {
            super.onPreExecute();
        }

        public Intent doInBackground(APKInfo... aPKInfoArr) {
            if (aPKInfoArr == null || aPKInfoArr.length <= 0) {
                return null;
            }
            return SocialShareModule.this.createShareIntent(aPKInfoArr[0]);
        }

        public void onPostExecute(Intent intent) {
            super.onPostExecute(intent);
            if (SocialShareModule.this.mApkPromise != null) {
                SocialShareModule.this.mApkPromise.resolve(Boolean.TRUE);
                SocialShareModule.this.mApkPromise = null;
            }
            if (intent != null && SocialShareModule.this.getCurrentActivity() != null) {
                SocialShareModule.this.showToast();
                Util.startActivityForResultSafely(SocialShareModule.this.getCurrentActivity(), intent, SocialShareModule.SHARE_TO_WHATSAPP);
            }
        }
    }

    public SocialShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new BaseActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                if (SocialShareModule.this.callbackManager != null) {
                    SocialShareModule.this.callbackManager.onActivityResult(i, i2, intent);
                }
                if (SocialShareModule.this.mPromise != null && i == 1003) {
                    if (i2 == -1) {
                        SocialShareModule.this.mPromise.resolve("Success");
                    } else {
                        SocialShareModule.this.mPromise.reject((String) "fail", (String) "Failed to share on WhatsApp");
                    }
                    SocialShareModule.this.mPromise = null;
                }
                if (i != 1025) {
                    return;
                }
                if (i2 == -1) {
                    if (SocialShareModule.this.mLocationPromise != null) {
                        SocialShareModule socialShareModule = SocialShareModule.this;
                        socialShareModule.getAddressAfterLocationEnableV2(socialShareModule.mLocationPromise);
                    }
                } else if (i2 == 0) {
                    MLogger.d(SocialShareModule.TAG, "Setting change Dialogue cancelled by user!");
                    if (SocialShareModule.this.mLocationPromise != null) {
                        SocialShareModule.this.mLocationPromise.reject((String) "E_CALLBACK_ERROR", (String) "User Cancelled the settings change dialogue");
                    }
                }
            }
        });
        this.reactContext = reactApplicationContext;
        try {
            this.mDefaultLocale = ConfigManager.getPlatformConfig().optBoolean("location.default.locale", true);
        } catch (Exception e2) {
            MLogger.e(TAG, e2.getMessage());
        }
    }

    private void createAndSaveApkFile(String str, String str2, String str3, Promise promise) {
        this.mApkPromise = promise;
        if (Util.isWhatsappPresent(this.reactContext)) {
            File file = new File(GEUtil.getGameDirInternalStoragePath(this.reactContext) + "/ShareApplication/", GeneratedOutlineSupport.outline52("MPL_UseCode_", str, ".apk"));
            if (file.exists()) {
                MLogger.d(TAG, "file already present deleting file:", Boolean.valueOf(file.delete()));
            }
            if (Util.externalStorageAvailableSpace()) {
                APKInfo apkFile = getApkFile(this.reactContext.getApplicationContext(), str, str2, str3);
                new FetchApk().execute(new APKInfo[]{apkFile});
                return;
            }
            Promise promise2 = this.mApkPromise;
            if (promise2 != null) {
                promise2.reject((String) "fail", (String) "Need more space to share app!");
                this.mApkPromise = null;
            }
            Toast.makeText(this.reactContext, "Need more space to share app!", 0).show();
            return;
        }
        Promise promise3 = this.mApkPromise;
        if (promise3 != null) {
            promise3.reject((String) "fail", (String) "WhatsApp is not installed");
            this.mApkPromise = null;
        }
        Toast.makeText(this.reactContext, "WhatsApp is not installed", 0).show();
    }

    /* access modifiers changed from: private */
    public Intent createShareIntent(APKInfo aPKInfo) {
        String str;
        String str2;
        Intent intent = null;
        try {
            Intent intent2 = new Intent("android.intent.action.MAIN");
            try {
                intent2.setAction("android.intent.action.SEND");
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(CMap.SPACE);
                if (TextUtils.isEmpty(aPKInfo.getApkName())) {
                    str = aPKInfo.mApkVersionCode;
                } else {
                    str = "MPL_UseCode_" + aPKInfo.getApkName() + ".apk";
                }
                sb.append(str);
                objArr[0] = sb.toString();
                MLogger.d(TAG, objArr);
                File file = new File(GEUtil.getGameDirInternalStoragePath(this.reactContext) + "/ShareApplication");
                if (!file.exists()) {
                    MLogger.d(TAG, "createAndSaveApkFile:creating new dir ", Boolean.valueOf(file.mkdirs()));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(file.getPath());
                sb2.append("/");
                if (TextUtils.isEmpty(aPKInfo.getApkName())) {
                    str2 = aPKInfo.mApkVersionCode;
                } else {
                    str2 = "MPL_UseCode_" + aPKInfo.getApkName();
                }
                sb2.append(str2);
                sb2.append(".apk");
                File file2 = new File(sb2.toString());
                if (file2.exists()) {
                    MLogger.d(TAG, "createAndSaveApkFile:apk already present deleting apk ", Boolean.valueOf(file2.delete()));
                }
                MLogger.d(TAG, "createAndSaveApkFile:creating new file ", Boolean.valueOf(file2.createNewFile()));
                FileInputStream fileInputStream = new FileInputStream(aPKInfo.mApkFile);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
                MLogger.d(TAG, "createAndSaveApkFile:File copied. ");
                intent2.setAction("android.intent.action.SEND");
                ShareFile shareFile = new ShareFile(Uri.fromFile(file2).toString(), this.reactContext);
                if (!shareFile.isFile()) {
                    return intent2;
                }
                Uri uri = shareFile.getURI();
                intent2.setType(shareFile.getType());
                intent2.putExtra("android.intent.extra.STREAM", uri);
                intent2.addFlags(1);
                if (!TextUtils.isEmpty(aPKInfo.getSendExtraText())) {
                    intent2.putExtra("android.intent.extra.TEXT", aPKInfo.getSendExtraText());
                    intent2.putExtra("android.intent.extra.HTML_TEXT", Html.fromHtml("<h1>" + aPKInfo.getSendExtraText() + "</h1>"));
                    intent2.putExtra("android.intent.extra.SUBJECT", aPKInfo.getSendExtraText());
                    intent2.putExtra("android.intent.extra.REFERRER_NAME", "amit");
                    intent2.putExtra("android.intent.extra.REFERRER", "singh");
                }
                intent2.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
                int savedCountryCallingCode = CountryUtils.getSavedCountryCallingCode();
                if (TextUtils.isEmpty(aPKInfo.getReceiverNumber()) || savedCountryCallingCode == 0) {
                    return intent2;
                }
                intent2.putExtra("jid", savedCountryCallingCode + aPKInfo.getReceiverNumber() + "@s.whatsapp.net");
                return intent2;
            } catch (IOException e2) {
                e = e2;
                intent = intent2;
                MLogger.e(TAG, "createAndSaveApkFile: ", e);
                return intent;
            }
        } catch (IOException e3) {
            e = e3;
            MLogger.e(TAG, "createAndSaveApkFile: ", e);
            return intent;
        }
    }

    /* access modifiers changed from: private */
    public void getAddressAfterLocationEnableV2(final Promise promise) {
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
                MLogger.d(SocialShareModule.TAG, "getAddressAfterLocationEnable:call:1 ");
                if (SocialShareModule.this.getCurrentActivity() == null) {
                    MLogger.d(SocialShareModule.TAG, "getAddressAfterLocationEnable:call:3 ");
                    promise.reject((String) "E_CALLBACK_ERROR", (String) "Activity is null");
                } else if (ContextCompat.checkSelfPermission(SocialShareModule.this.getCurrentActivity(), SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) == 0 || ContextCompat.checkSelfPermission(SocialShareModule.this.getCurrentActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    SocialShareModule.this.startLocationRequest(fusedLocationClient, promise);
                } else {
                    MLogger.d(SocialShareModule.TAG, "getAddressAfterLocationEnable:call:2 ");
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
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                MLogger.d(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("getAddressFromLatLong:Exception--->")));
            } else {
                MLogger.d(TAG, "getAddressFromLatLong:Exception");
            }
            promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error");
        }
    }

    private APKInfo getApkFile(Context context, String str, String str2, String str3) {
        APKInfo aPKInfo = null;
        try {
            new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.LAUNCHER");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String str4 = applicationInfo.packageName;
            String str5 = packageInfo.versionName;
            int i = packageInfo.versionCode;
            File file = new File(applicationInfo.publicSourceDir);
            if (file.exists()) {
                MLogger.d(TAG, str4 + " = " + file.getName(), "versionName: ", str5, "versionCode: ", Integer.valueOf(i));
            }
            APKInfo aPKInfo2 = new APKInfo();
            try {
                aPKInfo2.setApkFilePath(file);
                aPKInfo2.setApkVersionCode(String.valueOf(i));
                aPKInfo2.setApkVersionName(str5);
                aPKInfo2.setApkName(str);
                aPKInfo2.setReceiverNumber(str2);
                aPKInfo2.setSendExtraText(str3);
                return aPKInfo2;
            } catch (NameNotFoundException e2) {
                e = e2;
                aPKInfo = aPKInfo2;
            }
        } catch (NameNotFoundException e3) {
            e = e3;
            MLogger.printStackTrace(e);
            return aPKInfo;
        }
    }

    private void getCurrentLocation(final FusedLocationProviderClient fusedLocationProviderClient, final Promise promise) {
        MLogger.d(TAG, "trying to detect current location");
        Task<Location> currentLocation = fusedLocationProviderClient.getCurrentLocation(100, new CancellationTokenSource().zza);
        AnonymousClass6 r1 = new OnSuccessListener<Location>() {
            /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A[Catch:{ Exception -> 0x0074 }] */
            /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(android.location.Location r10) {
                /*
                    r9 = this;
                    java.lang.String r0 = "E_CALLBACK_ERROR"
                    com.mpl.androidapp.react.modules.SocialShareModule r1 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    r2 = 0
                    r3 = 1
                    java.lang.String r4 = "SocialShareModule"
                    if (r1 == 0) goto L_0x0058
                    com.mpl.androidapp.react.modules.SocialShareModule r1 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    boolean r1 = r1.isFinishing()     // Catch:{ Exception -> 0x0074 }
                    if (r1 != 0) goto L_0x0058
                    if (r10 == 0) goto L_0x005f
                    java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r5 = "get Location Current onSuccess:location is not null "
                    r1[r2] = r5     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.utils.MLogger.d(r4, r1)     // Catch:{ Exception -> 0x0074 }
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SocialShareModule r5 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r5 = r5.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0074 }
                    r1.<init>(r5, r6)     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SocialShareModule r5 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
                    boolean r5 = r5.mDefaultLocale     // Catch:{ Exception -> 0x0074 }
                    if (r5 != 0) goto L_0x0050
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SocialShareModule r5 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
                    android.app.Activity r5 = r5.getCurrentActivity()     // Catch:{ Exception -> 0x0074 }
                    java.util.Locale r6 = new java.util.Locale     // Catch:{ Exception -> 0x0074 }
                    java.lang.String r7 = "en"
                    java.lang.String r8 = "US"
                    r6.<init>(r7, r8)     // Catch:{ Exception -> 0x0074 }
                    r1.<init>(r5, r6)     // Catch:{ Exception -> 0x0074 }
                L_0x0050:
                    com.mpl.androidapp.react.modules.SocialShareModule r5 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
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
                    java.lang.String r1 = "current location was null, fetching last known loaction instead"
                    r10[r2] = r1     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.utils.MLogger.d(r4, r10)     // Catch:{ Exception -> 0x0074 }
                    com.mpl.androidapp.react.modules.SocialShareModule r10 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0074 }
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
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.AnonymousClass6.onSuccess(android.location.Location):void");
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
        MLogger.d(TAG, "Trying to detect Last known location");
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
                    java.lang.String r3 = "SocialShareModule"
                    if (r9 == 0) goto L_0x000e
                    boolean r4 = android.location.Geocoder.isPresent()     // Catch:{ Exception -> 0x0096 }
                    if (r4 != 0) goto L_0x003c
                L_0x000e:
                    java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r5 = "onSuccess: last known location is null "
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
                    com.mpl.androidapp.react.modules.SocialShareModule$7$1 r5 = new com.mpl.androidapp.react.modules.SocialShareModule$7$1     // Catch:{ Exception -> 0x0096 }
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
                    com.mpl.androidapp.react.modules.SocialShareModule r1 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    if (r1 == 0) goto L_0x008e
                    com.mpl.androidapp.react.modules.SocialShareModule r1 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r1 = r1.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    boolean r1 = r1.isFinishing()     // Catch:{ Exception -> 0x0096 }
                    if (r1 != 0) goto L_0x008e
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SocialShareModule r2 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r2 = r2.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    java.util.Locale r3 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0096 }
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SocialShareModule r2 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
                    boolean r2 = r2.mDefaultLocale     // Catch:{ Exception -> 0x0096 }
                    if (r2 != 0) goto L_0x0086
                    android.location.Geocoder r1 = new android.location.Geocoder     // Catch:{ Exception -> 0x0096 }
                    com.mpl.androidapp.react.modules.SocialShareModule r2 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
                    android.app.Activity r2 = r2.getCurrentActivity()     // Catch:{ Exception -> 0x0096 }
                    java.util.Locale r3 = new java.util.Locale     // Catch:{ Exception -> 0x0096 }
                    java.lang.String r4 = "en"
                    java.lang.String r5 = "US"
                    r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0096 }
                    r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0096 }
                L_0x0086:
                    com.mpl.androidapp.react.modules.SocialShareModule r2 = com.mpl.androidapp.react.modules.SocialShareModule.this     // Catch:{ Exception -> 0x0096 }
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
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.AnonymousClass7.onSuccess(android.location.Location):void");
            }
        });
    }

    private boolean hasValidKey(String str, ReadableMap readableMap) {
        return readableMap.hasKey(str) && !readableMap.isNull(str);
    }

    @ReactMethod
    private void openWhatsAppText(String str, Promise promise) {
        if (Util.isWhatsappPresent(this.reactContext)) {
            try {
                this.mPromise = promise;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", str);
                intent.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
                if (this.reactContext.getCurrentActivity() != null) {
                    this.reactContext.getCurrentActivity().startActivityForResult(intent, SHARE_TO_WHATSAPP);
                }
            } catch (Exception e2) {
                this.mPromise.reject((String) "fail", e2.getMessage());
            }
        } else {
            this.mPromise.reject((String) "fail", (String) "WhatsApp is not installed");
            Toast.makeText(this.reactContext, "WhatsApp is not installed", 0).show();
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
                            MLogger.d(SocialShareModule.TAG, "Exception in callback.call()");
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
            MLogger.d(TAG, "Exception in callback.call()");
        }
    }

    private void sendThroughWhatApp(String str, String str2) {
        try {
            if (getCurrentActivity() != null) {
                PackageManager packageManager = getCurrentActivity().getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW");
                if (CountryUtils.getSavedCountryCallingCode() != 0) {
                    intent.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + r2 + str + "&text=" + URLEncoder.encode(str2, "UTF-8")));
                    if (intent.resolveActivity(packageManager) != null) {
                        getCurrentActivity().startActivity(intent);
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "sendThroughWhatApp: ", e2);
        }
    }

    @ReactMethod
    private void shareThroughFaceBook(ReadableMap readableMap, final Promise promise) {
        boolean z = true;
        MLogger.d(TAG, "shareThroughFaceBook() called: " + readableMap);
        if (this.reactContext.getCurrentActivity() != null) {
            this.callbackManager = new CallbackManagerImpl();
            ShareDialog shareDialog = new ShareDialog(this.reactContext.getCurrentActivity());
            shareDialog.registerCallback(this.callbackManager, new FacebookCallback<Sharer$Result>() {
                public void onCancel() {
                    MLogger.d(SocialShareModule.TAG, "Facebook share  OnCancel");
                    promise.reject((String) "fail", (String) "Share cancel by User");
                }

                public void onError(FacebookException facebookException) {
                    MLogger.d(SocialShareModule.TAG, "Facebook share onError", facebookException);
                    promise.reject((String) "fail", (String) "Error in Share");
                }

                public void onSuccess(Sharer$Result sharer$Result) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Facebook share :");
                    outline73.append(sharer$Result.postId);
                    MLogger.d(SocialShareModule.TAG, outline73.toString());
                    promise.resolve("Success");
                }
            });
            if (hasValidKey("message", readableMap)) {
                String string = readableMap.getString("message");
                Class<ShareLinkContent> cls = ShareLinkContent.class;
                Companion companion = ShareDialog.Companion;
                Intrinsics.checkNotNullParameter(cls, "contentType");
                if (!companion.canShowWebTypeCheck(cls)) {
                    DialogFeature feature = companion.getFeature(cls);
                    if (!(feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature))) {
                        z = false;
                    }
                }
                if (z) {
                    Builder builder = new Builder();
                    builder.contentUrl = Uri.parse(string);
                    shareDialog.showImpl(new ShareLinkContent(builder, null), FacebookDialogBase.BASE_AUTOMATIC_MODE);
                    return;
                }
                promise.reject((String) "fail", (String) "fb call error");
            }
        }
    }

    /* access modifiers changed from: private */
    public void showToast() {
        if (getCurrentActivity() != null) {
            DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
            if (downloadProgressReceiver != null) {
                downloadProgressReceiver.send(10, null);
            }
        }
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
                            MLogger.d(SocialShareModule.TAG, "Time take to get location--->" + (((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d));
                            if (SocialShareModule.this.getCurrentActivity() == null || SocialShareModule.this.getCurrentActivity().isFinishing()) {
                                promise.reject((String) "E_CALLBACK_ERROR", (String) "current activity null or is finishing");
                                return;
                            }
                            Geocoder geocoder = new Geocoder(SocialShareModule.this.getCurrentActivity(), Locale.getDefault());
                            if (!SocialShareModule.this.mDefaultLocale) {
                                geocoder = new Geocoder(SocialShareModule.this.getCurrentActivity(), new Locale(HyperVergeKycCapture.EN, "US"));
                            }
                            SocialShareModule.this.getAddressFromLatLong(geocoder, location, promise);
                        } catch (Exception unused) {
                            promise.reject((String) "E_CALLBACK_ERROR", (String) "Exception in onLocationFetchSuccess");
                        }
                    }

                    public void onLocationFetchedFailed(String str) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Time take to fail (Seconds)--->");
                        outline73.append(((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d);
                        MLogger.d(SocialShareModule.TAG, outline73.toString());
                        promise.reject((String) "E_CALLBACK_ERROR", str);
                    }

                    public void onLocationMocked() {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Time take to detect mock (Seconds)--->");
                        outline73.append(((double) (System.currentTimeMillis() - valueOf.longValue())) / 1000.0d);
                        MLogger.d(SocialShareModule.TAG, outline73.toString());
                        if (SocialShareModule.this.getCurrentActivity() != null && (SocialShareModule.this.getCurrentActivity() instanceof MPLReactContainerActivity)) {
                            ((MPLReactContainerActivity) SocialShareModule.this.getCurrentActivity()).showNativeGeoSpoofingDetectedDialogue();
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

    @ReactMethod
    public void getAddressV2(final Promise promise) {
        MLogger.d(TAG, "getAddressV2 called");
        if (getCurrentActivity() != null) {
            this.mLocationPromise = promise;
            new GpsUtilsV2(getCurrentActivity()).turnGPSOn(new OnGpsListenerV2() {
                public void gpsStatus(boolean z) {
                    SocialShareModule.this.mLocationPromise = null;
                    if (z) {
                        SocialShareModule.this.getAddressAfterLocationEnableV2(promise);
                        return;
                    }
                    promise.reject((String) "E_CALLBACK_ERROR", (String) "Unknown error");
                    MLogger.d(SocialShareModule.TAG, "gpsStatus-->isGPSEnable returns false");
                }
            });
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void isAppInstalled(String str, Promise promise) {
        promise.resolve(Boolean.valueOf(Util.isAppInstalled(getCurrentActivity(), str)));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|7|8|9|10|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x005d */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openFileWithOtherApps(java.lang.String r9, java.lang.String r10, com.facebook.react.bridge.Promise r11) {
        /*
            r8 = this;
            java.lang.String r0 = "NO_APP_PRESENT"
            java.lang.String r1 = "NO_SUCH_FILE"
            java.lang.String r2 = "ERROR"
            java.lang.String r3 = "SocialShareModule"
            r4 = 0
            r5 = 1
            android.app.Activity r6 = r8.getCurrentActivity()     // Catch:{ Exception -> 0x0080 }
            if (r6 == 0) goto L_0x0073
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0080 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x0080 }
            boolean r9 = r6.exists()     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0068
            android.app.Activity r9 = r8.getCurrentActivity()     // Catch:{ Exception -> 0x0080 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0080 }
            r1.<init>()     // Catch:{ Exception -> 0x0080 }
            android.app.Activity r7 = r8.getCurrentActivity()     // Catch:{ Exception -> 0x0080 }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x0080 }
            r1.append(r7)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r7 = ".provider"
            r1.append(r7)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0080 }
            android.net.Uri r9 = androidx.core.content.FileProvider.getUriForFile(r9, r1, r6)     // Catch:{ Exception -> 0x0080 }
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x0080 }
            java.lang.String r6 = "android.intent.action.VIEW"
            r1.<init>(r6)     // Catch:{ Exception -> 0x0080 }
            r1.setDataAndType(r9, r10)     // Catch:{ Exception -> 0x0080 }
            r9 = 67108865(0x4000001, float:1.504633E-36)
            r1.addFlags(r9)     // Catch:{ Exception -> 0x0080 }
            android.app.Activity r9 = r8.getCurrentActivity()     // Catch:{ Exception -> 0x005d }
            r9.startActivity(r1)     // Catch:{ Exception -> 0x005d }
            java.lang.String r9 = "SUCCESS"
            r11.resolve(r9)     // Catch:{ Exception -> 0x005d }
            goto L_0x0098
        L_0x005d:
            r11.resolve(r0)     // Catch:{ Exception -> 0x0080 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0080 }
            r9[r4] = r0     // Catch:{ Exception -> 0x0080 }
            com.mpl.androidapp.utils.MLogger.d(r3, r9)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0098
        L_0x0068:
            r11.resolve(r1)     // Catch:{ Exception -> 0x0080 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0080 }
            r9[r4] = r1     // Catch:{ Exception -> 0x0080 }
            com.mpl.androidapp.utils.MLogger.d(r3, r9)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0098
        L_0x0073:
            r11.resolve(r2)     // Catch:{ Exception -> 0x0080 }
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0080 }
            java.lang.String r10 = "Activity was null in openFileWithOtherApps"
            r9[r4] = r10     // Catch:{ Exception -> 0x0080 }
            com.mpl.androidapp.utils.MLogger.d(r3, r9)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0098
        L_0x0080:
            r9 = move-exception
            r11.resolve(r2)
            java.lang.String r10 = r9.getMessage()
            if (r10 == 0) goto L_0x008f
            java.lang.String r9 = r9.getMessage()
            goto L_0x0091
        L_0x008f:
            java.lang.String r9 = "Exception in openFileWithOtherApps"
        L_0x0091:
            java.lang.Object[] r10 = new java.lang.Object[r5]
            r10[r4] = r9
            com.mpl.androidapp.utils.MLogger.d(r3, r10)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.openFileWithOtherApps(java.lang.String, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2 A[Catch:{ Exception -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openNativeImageAndTextShare(com.facebook.react.bridge.ReadableMap r10) {
        /*
            r9 = this;
            java.lang.String r0 = "subject"
            java.lang.String r1 = "message"
            r2 = 1
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x00cc }
            java.lang.String r4 = "android.intent.action.MAIN"
            r3.<init>(r4)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r4 = "android.intent.action.SEND"
            r3.setAction(r4)     // Catch:{ Exception -> 0x00cc }
            boolean r4 = r9.hasValidKey(r0, r10)     // Catch:{ Exception -> 0x00cc }
            if (r4 == 0) goto L_0x0020
            java.lang.String r4 = "android.intent.extra.SUBJECT"
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r4, r0)     // Catch:{ Exception -> 0x00cc }
        L_0x0020:
            boolean r0 = r9.hasValidKey(r1, r10)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r4 = "android.intent.extra.STREAM"
            java.lang.String r5 = "android.intent.extra.TEXT"
            java.lang.String r6 = "url"
            if (r0 == 0) goto L_0x007c
            boolean r0 = r9.hasValidKey(r6, r10)     // Catch:{ Exception -> 0x00cc }
            if (r0 == 0) goto L_0x007c
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x00cc }
            java.lang.String r7 = r10.getString(r6)     // Catch:{ Exception -> 0x00cc }
            com.facebook.react.bridge.ReactApplicationContext r8 = r9.reactContext     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r7, r8)     // Catch:{ Exception -> 0x00cc }
            boolean r7 = r0.isFile()     // Catch:{ Exception -> 0x00cc }
            if (r7 == 0) goto L_0x005c
            android.net.Uri r6 = r0.getURI()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x00cc }
            r3.setType(r0)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r4, r6)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r10 = r10.getString(r1)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r5, r10)     // Catch:{ Exception -> 0x00cc }
            r3.addFlags(r2)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00ba
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc }
            r0.<init>()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x00cc }
            r0.append(r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r10 = r10.getString(r6)     // Catch:{ Exception -> 0x00cc }
            r0.append(r10)     // Catch:{ Exception -> 0x00cc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r5, r10)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00ba
        L_0x007c:
            boolean r0 = r9.hasValidKey(r6, r10)     // Catch:{ Exception -> 0x00cc }
            if (r0 == 0) goto L_0x00ad
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x00cc }
            java.lang.String r1 = r10.getString(r6)     // Catch:{ Exception -> 0x00cc }
            com.facebook.react.bridge.ReactApplicationContext r7 = r9.reactContext     // Catch:{ Exception -> 0x00cc }
            r0.<init>(r1, r7)     // Catch:{ Exception -> 0x00cc }
            boolean r1 = r0.isFile()     // Catch:{ Exception -> 0x00cc }
            if (r1 == 0) goto L_0x00a5
            android.net.Uri r10 = r0.getURI()     // Catch:{ Exception -> 0x00cc }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x00cc }
            r3.setType(r0)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r4, r10)     // Catch:{ Exception -> 0x00cc }
            r3.addFlags(r2)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00ba
        L_0x00a5:
            java.lang.String r10 = r10.getString(r6)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r5, r10)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00ba
        L_0x00ad:
            boolean r0 = r9.hasValidKey(r1, r10)     // Catch:{ Exception -> 0x00cc }
            if (r0 == 0) goto L_0x00ba
            java.lang.String r10 = r10.getString(r1)     // Catch:{ Exception -> 0x00cc }
            r3.putExtra(r5, r10)     // Catch:{ Exception -> 0x00cc }
        L_0x00ba:
            com.facebook.react.bridge.ReactApplicationContext r10 = r9.reactContext     // Catch:{ Exception -> 0x00cc }
            android.app.Activity r10 = r10.getCurrentActivity()     // Catch:{ Exception -> 0x00cc }
            if (r10 == 0) goto L_0x00e8
            com.facebook.react.bridge.ReactApplicationContext r10 = r9.reactContext     // Catch:{ Exception -> 0x00cc }
            android.app.Activity r10 = r10.getCurrentActivity()     // Catch:{ Exception -> 0x00cc }
            r10.startActivity(r3)     // Catch:{ Exception -> 0x00cc }
            goto L_0x00e8
        L_0x00cc:
            r10 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r1 = 0
            java.lang.String r2 = "Error/n"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r10 = r10.toString()
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r0[r1] = r10
            java.lang.String r10 = "SocialShareModule"
            com.mpl.androidapp.utils.MLogger.e(r10, r0)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.openNativeImageAndTextShare(com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void openTwitterAppImageText(ReadableMap readableMap, Promise promise) {
        TweetComposer$Builder tweetComposer$Builder = new TweetComposer$Builder(this.reactContext.getCurrentActivity());
        if (Util.isTwitterPresent(this.reactContext)) {
            try {
                this.mPromise = promise;
                if (hasValidKey("url", readableMap)) {
                    ShareFile shareFile = new ShareFile(readableMap.getString("url"), this.reactContext);
                    if (shareFile.isFile()) {
                        Uri uri = shareFile.getURI();
                        if (uri == null) {
                            throw new IllegalArgumentException("imageUri must not be null.");
                        } else if (tweetComposer$Builder.imageUri == null) {
                            tweetComposer$Builder.imageUri = uri;
                        } else {
                            throw new IllegalStateException("imageUri already set.");
                        }
                    }
                }
                if (hasValidKey("message", readableMap)) {
                    String string = readableMap.getString("message");
                    if (string == null) {
                        throw new IllegalArgumentException("text must not be null.");
                    } else if (tweetComposer$Builder.text == null) {
                        tweetComposer$Builder.text = string;
                    } else {
                        throw new IllegalStateException("text already set.");
                    }
                }
                tweetComposer$Builder.show();
                promise.resolve("Success");
            } catch (Exception e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error/n");
                outline73.append(e2.toString());
                MLogger.e(TAG, outline73.toString());
                Promise promise2 = this.mPromise;
                if (promise2 != null) {
                    promise2.reject((String) "fail", e2.getMessage());
                }
            }
        } else {
            Promise promise3 = this.mPromise;
            if (promise3 != null) {
                promise3.reject((String) "fail", (String) "Twitter is not installed");
            }
            Toast.makeText(this.reactContext, "Twitter is not installed", 0).show();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d4 A[Catch:{ Exception -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openWhatsAppImageText(com.facebook.react.bridge.ReadableMap r11, com.facebook.react.bridge.Promise r12) {
        /*
            r10 = this;
            java.lang.String r0 = "subject"
            java.lang.String r1 = "message"
            com.facebook.react.bridge.ReactApplicationContext r2 = r10.reactContext
            boolean r2 = com.mpl.androidapp.utils.Util.isWhatsappPresent(r2)
            java.lang.String r3 = "fail"
            r4 = 0
            if (r2 == 0) goto L_0x0107
            r2 = 1
            r10.mPromise = r12     // Catch:{ Exception -> 0x00e0 }
            android.content.Intent r12 = new android.content.Intent     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r5 = "android.intent.action.MAIN"
            r12.<init>(r5)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r5 = "android.intent.action.SEND"
            r12.setAction(r5)     // Catch:{ Exception -> 0x00e0 }
            boolean r5 = r10.hasValidKey(r0, r11)     // Catch:{ Exception -> 0x00e0 }
            if (r5 == 0) goto L_0x002d
            java.lang.String r5 = "android.intent.extra.SUBJECT"
            java.lang.String r0 = r11.getString(r0)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r5, r0)     // Catch:{ Exception -> 0x00e0 }
        L_0x002d:
            boolean r0 = r10.hasValidKey(r1, r11)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r5 = "android.intent.extra.STREAM"
            java.lang.String r6 = "android.intent.extra.TEXT"
            java.lang.String r7 = "url"
            if (r0 == 0) goto L_0x0089
            boolean r0 = r10.hasValidKey(r7, r11)     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x0089
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r8 = r11.getString(r7)     // Catch:{ Exception -> 0x00e0 }
            com.facebook.react.bridge.ReactApplicationContext r9 = r10.reactContext     // Catch:{ Exception -> 0x00e0 }
            r0.<init>(r8, r9)     // Catch:{ Exception -> 0x00e0 }
            boolean r8 = r0.isFile()     // Catch:{ Exception -> 0x00e0 }
            if (r8 == 0) goto L_0x0069
            android.net.Uri r7 = r0.getURI()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x00e0 }
            r12.setType(r0)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r5, r7)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r11 = r11.getString(r1)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r6, r11)     // Catch:{ Exception -> 0x00e0 }
            r12.addFlags(r2)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00c7
        L_0x0069:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e0 }
            r0.<init>()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ Exception -> 0x00e0 }
            r0.append(r1)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = " "
            r0.append(r1)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r11 = r11.getString(r7)     // Catch:{ Exception -> 0x00e0 }
            r0.append(r11)     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r11 = r0.toString()     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r6, r11)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00c7
        L_0x0089:
            boolean r0 = r10.hasValidKey(r7, r11)     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x00ba
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r1 = r11.getString(r7)     // Catch:{ Exception -> 0x00e0 }
            com.facebook.react.bridge.ReactApplicationContext r8 = r10.reactContext     // Catch:{ Exception -> 0x00e0 }
            r0.<init>(r1, r8)     // Catch:{ Exception -> 0x00e0 }
            boolean r1 = r0.isFile()     // Catch:{ Exception -> 0x00e0 }
            if (r1 == 0) goto L_0x00b2
            android.net.Uri r11 = r0.getURI()     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x00e0 }
            r12.setType(r0)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r5, r11)     // Catch:{ Exception -> 0x00e0 }
            r12.addFlags(r2)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r11 = r11.getString(r7)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r6, r11)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x00c7
        L_0x00ba:
            boolean r0 = r10.hasValidKey(r1, r11)     // Catch:{ Exception -> 0x00e0 }
            if (r0 == 0) goto L_0x00c7
            java.lang.String r11 = r11.getString(r1)     // Catch:{ Exception -> 0x00e0 }
            r12.putExtra(r6, r11)     // Catch:{ Exception -> 0x00e0 }
        L_0x00c7:
            java.lang.String r11 = "com.whatsapp"
            r12.setPackage(r11)     // Catch:{ Exception -> 0x00e0 }
            com.facebook.react.bridge.ReactApplicationContext r11 = r10.reactContext     // Catch:{ Exception -> 0x00e0 }
            android.app.Activity r11 = r11.getCurrentActivity()     // Catch:{ Exception -> 0x00e0 }
            if (r11 == 0) goto L_0x0119
            com.facebook.react.bridge.ReactApplicationContext r11 = r10.reactContext     // Catch:{ Exception -> 0x00e0 }
            android.app.Activity r11 = r11.getCurrentActivity()     // Catch:{ Exception -> 0x00e0 }
            r0 = 1003(0x3eb, float:1.406E-42)
            r11.startActivityForResult(r12, r0)     // Catch:{ Exception -> 0x00e0 }
            goto L_0x0119
        L_0x00e0:
            r11 = move-exception
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.String r0 = "Error/n"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r11.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12[r4] = r0
            java.lang.String r0 = "SocialShareModule"
            com.mpl.androidapp.utils.MLogger.e(r0, r12)
            com.facebook.react.bridge.Promise r12 = r10.mPromise
            if (r12 == 0) goto L_0x0119
            java.lang.String r11 = r11.getMessage()
            r12.reject(r3, r11)
            goto L_0x0119
        L_0x0107:
            com.facebook.react.bridge.Promise r11 = r10.mPromise
            java.lang.String r12 = "WhatsApp is not installed"
            if (r11 == 0) goto L_0x0110
            r11.reject(r3, r12)
        L_0x0110:
            com.facebook.react.bridge.ReactApplicationContext r11 = r10.reactContext
            android.widget.Toast r11 = android.widget.Toast.makeText(r11, r12, r4)
            r11.show()
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.openWhatsAppImageText(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0107 A[Catch:{ Exception -> 0x011b }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0115 A[Catch:{ Exception -> 0x011b }] */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openWhatsAppImageTextToNumber(com.facebook.react.bridge.ReadableMap r13, com.facebook.react.bridge.Promise r14) {
        /*
            r12 = this;
            java.lang.String r0 = "number"
            java.lang.String r1 = "subject"
            java.lang.String r2 = "message"
            com.facebook.react.bridge.ReactApplicationContext r3 = r12.reactContext
            boolean r3 = com.mpl.androidapp.utils.Util.isWhatsappPresent(r3)
            r4 = 0
            java.lang.String r5 = "fail"
            if (r3 == 0) goto L_0x013e
            r3 = 1
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x011b }
            java.lang.String r7 = "android.intent.action.MAIN"
            r6.<init>(r7)     // Catch:{ Exception -> 0x011b }
            java.lang.String r7 = "android.intent.action.SEND"
            r6.setAction(r7)     // Catch:{ Exception -> 0x011b }
            boolean r7 = r12.hasValidKey(r1, r13)     // Catch:{ Exception -> 0x011b }
            if (r7 == 0) goto L_0x002d
            java.lang.String r7 = "android.intent.extra.SUBJECT"
            java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r7, r1)     // Catch:{ Exception -> 0x011b }
        L_0x002d:
            boolean r1 = r12.hasValidKey(r2, r13)     // Catch:{ Exception -> 0x011b }
            java.lang.String r7 = "android.intent.extra.STREAM"
            java.lang.String r8 = "android.intent.extra.TEXT"
            java.lang.String r9 = "url"
            if (r1 == 0) goto L_0x0089
            boolean r1 = r12.hasValidKey(r9, r13)     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x0089
            com.mpl.androidapp.utils.ShareFile r1 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x011b }
            java.lang.String r10 = r13.getString(r9)     // Catch:{ Exception -> 0x011b }
            com.facebook.react.bridge.ReactApplicationContext r11 = r12.reactContext     // Catch:{ Exception -> 0x011b }
            r1.<init>(r10, r11)     // Catch:{ Exception -> 0x011b }
            boolean r10 = r1.isFile()     // Catch:{ Exception -> 0x011b }
            if (r10 == 0) goto L_0x0069
            android.net.Uri r9 = r1.getURI()     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x011b }
            r6.setType(r1)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r7, r9)     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r13.getString(r2)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r8, r1)     // Catch:{ Exception -> 0x011b }
            r6.addFlags(r3)     // Catch:{ Exception -> 0x011b }
            goto L_0x00c7
        L_0x0069:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b }
            r1.<init>()     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x011b }
            r1.append(r2)     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = r13.getString(r9)     // Catch:{ Exception -> 0x011b }
            r1.append(r2)     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r8, r1)     // Catch:{ Exception -> 0x011b }
            goto L_0x00c7
        L_0x0089:
            boolean r1 = r12.hasValidKey(r9, r13)     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00ba
            com.mpl.androidapp.utils.ShareFile r1 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = r13.getString(r9)     // Catch:{ Exception -> 0x011b }
            com.facebook.react.bridge.ReactApplicationContext r10 = r12.reactContext     // Catch:{ Exception -> 0x011b }
            r1.<init>(r2, r10)     // Catch:{ Exception -> 0x011b }
            boolean r2 = r1.isFile()     // Catch:{ Exception -> 0x011b }
            if (r2 == 0) goto L_0x00b2
            android.net.Uri r2 = r1.getURI()     // Catch:{ Exception -> 0x011b }
            java.lang.String r1 = r1.getType()     // Catch:{ Exception -> 0x011b }
            r6.setType(r1)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r7, r2)     // Catch:{ Exception -> 0x011b }
            r6.addFlags(r3)     // Catch:{ Exception -> 0x011b }
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r1 = r13.getString(r9)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r8, r1)     // Catch:{ Exception -> 0x011b }
            goto L_0x00c7
        L_0x00ba:
            boolean r1 = r12.hasValidKey(r2, r13)     // Catch:{ Exception -> 0x011b }
            if (r1 == 0) goto L_0x00c7
            java.lang.String r1 = r13.getString(r2)     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r8, r1)     // Catch:{ Exception -> 0x011b }
        L_0x00c7:
            int r1 = com.mpl.androidapp.utils.CountryUtils.getSavedCountryCallingCode()     // Catch:{ Exception -> 0x011b }
            java.lang.String r2 = r13.getString(r0)     // Catch:{ Exception -> 0x011b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x011b }
            if (r2 != 0) goto L_0x00f5
            if (r1 == 0) goto L_0x00f5
            java.lang.String r2 = "jid"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b }
            r7.<init>()     // Catch:{ Exception -> 0x011b }
            r7.append(r1)     // Catch:{ Exception -> 0x011b }
            java.lang.String r13 = r13.getString(r0)     // Catch:{ Exception -> 0x011b }
            r7.append(r13)     // Catch:{ Exception -> 0x011b }
            java.lang.String r13 = "@s.whatsapp.net"
            r7.append(r13)     // Catch:{ Exception -> 0x011b }
            java.lang.String r13 = r7.toString()     // Catch:{ Exception -> 0x011b }
            r6.putExtra(r2, r13)     // Catch:{ Exception -> 0x011b }
            goto L_0x00fa
        L_0x00f5:
            java.lang.String r13 = "Number is null"
            r14.reject(r5, r13)     // Catch:{ Exception -> 0x011b }
        L_0x00fa:
            java.lang.String r13 = "com.whatsapp"
            r6.setPackage(r13)     // Catch:{ Exception -> 0x011b }
            com.facebook.react.bridge.ReactApplicationContext r13 = r12.reactContext     // Catch:{ Exception -> 0x011b }
            android.app.Activity r13 = r13.getCurrentActivity()     // Catch:{ Exception -> 0x011b }
            if (r13 == 0) goto L_0x0115
            r12.mPromiseWhats = r14     // Catch:{ Exception -> 0x011b }
            com.facebook.react.bridge.ReactApplicationContext r13 = r12.reactContext     // Catch:{ Exception -> 0x011b }
            android.app.Activity r13 = r13.getCurrentActivity()     // Catch:{ Exception -> 0x011b }
            r0 = 1003(0x3eb, float:1.406E-42)
            r13.startActivityForResult(r6, r0)     // Catch:{ Exception -> 0x011b }
            goto L_0x014c
        L_0x0115:
            java.lang.String r13 = "Activity is null"
            r14.reject(r5, r13)     // Catch:{ Exception -> 0x011b }
            goto L_0x014c
        L_0x011b:
            r13 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r1 = "Error/n"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r2 = r13.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r4] = r1
            java.lang.String r1 = "SocialShareModule"
            com.mpl.androidapp.utils.MLogger.e(r1, r0)
            java.lang.String r13 = r13.getMessage()
            r14.reject(r5, r13)
            goto L_0x014c
        L_0x013e:
            com.facebook.react.bridge.ReactApplicationContext r13 = r12.reactContext
            java.lang.String r0 = "WhatsApp is not installed"
            android.widget.Toast r13 = android.widget.Toast.makeText(r13, r0, r4)
            r13.show()
            r14.reject(r5, r0)
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.openWhatsAppImageTextToNumber(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void openWhatsAppTextToNumber(String str, String str2, Promise promise) {
        if (!Util.isWhatsappPresent(this.reactContext)) {
            promise.reject((String) "fail", (String) "WhatsApp is not installed");
            Toast.makeText(this.reactContext, "WhatsApp is not installed", 0).show();
        } else if (getCurrentActivity() != null) {
            if (CountryUtils.getSavedCountryCallingCode() != 0) {
                PackageManager packageManager = getCurrentActivity().getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.setPackage(SocialPkgName.WHATSAPP_PACKAGE_NAME);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + r0 + str2 + "&text=" + URLEncoder.encode(str, "UTF-8")));
                    if (intent.resolveActivity(packageManager) != null) {
                        getCurrentActivity().startActivity(intent);
                    }
                    promise.resolve("Success");
                } catch (Exception e2) {
                    promise.reject((String) "fail", (String) "Error");
                    MLogger.printStackTrace(e2);
                }
            } else {
                promise.reject((String) "fail", (String) "Country Code is empty");
            }
        } else {
            promise.reject((String) "fail", (String) "Error");
        }
    }

    @ReactMethod
    public void saveCurrentScreenName(final String str) {
        BackgroundTaskHandler.execute(new Runnable() {
            public void run() {
                CommonUtils.saveCurrentScreenName(str);
            }
        });
    }

    @ReactMethod
    public void sendApkFile(Promise promise) {
        createAndSaveApkFile(MSharedPreferencesUtils.getUserReferralCode(), "", "", promise);
    }

    @ReactMethod
    public void sendApkFileToNumber(String str) {
        if (str.length() == 10) {
            createAndSaveApkFile("", str, "", null);
        } else {
            createAndSaveApkFile(str, "", "", null);
        }
    }

    @ReactMethod
    public void sendApkFileToNumberWithCode(String str, String str2) {
        createAndSaveApkFile(str, str2, "", null);
    }

    @ReactMethod
    public void sendApkFileWithText(String str) {
        createAndSaveApkFile("", "", str, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ee A[SYNTHETIC, Splitter:B:39:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013e A[Catch:{ Exception -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01bd  */
    @com.facebook.react.bridge.ReactMethod
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shareThroughApp(com.facebook.react.bridge.ReadableMap r14, com.facebook.react.bridge.Promise r15) {
        /*
            r13 = this;
            java.lang.String r0 = "subject"
            java.lang.String r1 = "appName"
            java.lang.String r2 = "Share Fail"
            java.lang.String r3 = "fail"
            java.lang.String r4 = "message"
            java.lang.String r5 = "SocialShareModule"
            r6 = 0
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x01cc }
            java.lang.String r8 = "shareThroughApp: "
            r7[r6] = r8     // Catch:{ Exception -> 0x01cc }
            com.mpl.androidapp.utils.MLogger.d(r5, r7)     // Catch:{ Exception -> 0x01cc }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = "android.intent.action.SEND"
            r6.<init>(r7)     // Catch:{ Exception -> 0x01cc }
            boolean r7 = r13.hasValidKey(r0, r14)     // Catch:{ Exception -> 0x01cc }
            if (r7 == 0) goto L_0x002d
            java.lang.String r7 = "android.intent.extra.SUBJECT"
            java.lang.String r0 = r14.getString(r0)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r7, r0)     // Catch:{ Exception -> 0x01cc }
        L_0x002d:
            boolean r0 = r13.hasValidKey(r4, r14)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r7 = "android.intent.extra.STREAM"
            java.lang.String r8 = "text/plain"
            java.lang.String r9 = "android.intent.extra.TEXT"
            java.lang.String r10 = "url"
            if (r0 == 0) goto L_0x0096
            boolean r0 = r13.hasValidKey(r10, r14)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x0096
            java.lang.String r0 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x0096
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x01cc }
            java.lang.String r11 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            com.facebook.react.bridge.ReactApplicationContext r12 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            r0.<init>(r11, r12)     // Catch:{ Exception -> 0x01cc }
            boolean r11 = r0.isFile()     // Catch:{ Exception -> 0x01cc }
            if (r11 == 0) goto L_0x0076
            android.net.Uri r10 = r0.getURI()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x01cc }
            r6.setType(r0)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r7, r10)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = r14.getString(r4)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r9, r0)     // Catch:{ Exception -> 0x01cc }
            r0 = 1
            r6.addFlags(r0)     // Catch:{ Exception -> 0x01ca }
            goto L_0x00e2
        L_0x0076:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cc }
            r0.<init>()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r14.getString(r4)     // Catch:{ Exception -> 0x01cc }
            r0.append(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = " "
            r0.append(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            r0.append(r4)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r9, r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x00e2
        L_0x0096:
            boolean r0 = r13.hasValidKey(r10, r14)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x00d2
            java.lang.String r0 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x00d2
            com.mpl.androidapp.utils.ShareFile r0 = new com.mpl.androidapp.utils.ShareFile     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            com.facebook.react.bridge.ReactApplicationContext r11 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            r0.<init>(r4, r11)     // Catch:{ Exception -> 0x01cc }
            boolean r4 = r0.isFile()     // Catch:{ Exception -> 0x01cc }
            if (r4 == 0) goto L_0x00ca
            android.net.Uri r4 = r0.getURI()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = r0.getType()     // Catch:{ Exception -> 0x01cc }
            r6.setType(r0)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r7, r4)     // Catch:{ Exception -> 0x01cc }
            r0 = 1
            r6.addFlags(r0)     // Catch:{ Exception -> 0x01ca }
            goto L_0x00e2
        L_0x00ca:
            java.lang.String r0 = r14.getString(r10)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r9, r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x00e2
        L_0x00d2:
            boolean r0 = r13.hasValidKey(r4, r14)     // Catch:{ Exception -> 0x01cc }
            if (r0 == 0) goto L_0x00e2
            java.lang.String r0 = r14.getString(r4)     // Catch:{ Exception -> 0x01cc }
            r6.putExtra(r9, r0)     // Catch:{ Exception -> 0x01cc }
            r6.setType(r8)     // Catch:{ Exception -> 0x01cc }
        L_0x00e2:
            boolean r0 = r14.hasKey(r1)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r4 = "Choose App To Share"
            java.lang.String r7 = "Success"
            java.lang.String r9 = "shareThroughApp: Activity null"
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = r14.getString(r1)     // Catch:{ Exception -> 0x01cc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01cc }
            if (r0 != 0) goto L_0x0136
            java.lang.String r0 = r14.getString(r1)     // Catch:{ Exception -> 0x01cc }
            r6.setPackage(r0)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r14 = r14.getString(r1)     // Catch:{ Exception -> 0x01cc }
            java.lang.String r0 = "com.instagram.android"
            boolean r14 = r14.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x01cc }
            if (r14 == 0) goto L_0x010e
            r6.setType(r8)     // Catch:{ Exception -> 0x01cc }
        L_0x010e:
            com.facebook.react.bridge.ReactApplicationContext r14 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            android.app.Activity r14 = r14.getCurrentActivity()     // Catch:{ Exception -> 0x01cc }
            if (r14 == 0) goto L_0x0128
            r15.resolve(r7)     // Catch:{ Exception -> 0x01cc }
            com.facebook.react.bridge.ReactApplicationContext r14 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            android.app.Activity r14 = r14.getCurrentActivity()     // Catch:{ Exception -> 0x01cc }
            android.content.Intent r0 = android.content.Intent.createChooser(r6, r4)     // Catch:{ Exception -> 0x01cc }
            r14.startActivity(r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ea
        L_0x0128:
            r0 = 1
            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01ca }
            r0 = 0
            r14[r0] = r9     // Catch:{ Exception -> 0x01cc }
            com.mpl.androidapp.utils.MLogger.e(r5, r14)     // Catch:{ Exception -> 0x01cc }
            r15.reject(r3, r2)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ea
        L_0x0136:
            com.facebook.react.bridge.ReactApplicationContext r14 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            android.app.Activity r14 = r14.getCurrentActivity()     // Catch:{ Exception -> 0x01cc }
            if (r14 == 0) goto L_0x01bd
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x01cc }
            r14.<init>()     // Catch:{ Exception -> 0x01cc }
            com.facebook.react.bridge.ReactApplicationContext r0 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            android.app.Activity r0 = r0.getCurrentActivity()     // Catch:{ Exception -> 0x01cc }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x01cc }
            r1 = 0
            java.util.List r0 = r0.queryIntentActivities(r6, r1)     // Catch:{ Exception -> 0x01cc }
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x01cc }
            if (r1 != 0) goto L_0x01b0
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01cc }
        L_0x015c:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x01cc }
            if (r1 == 0) goto L_0x0185
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x01cc }
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1     // Catch:{ Exception -> 0x01cc }
            android.content.pm.ActivityInfo r8 = r1.activityInfo     // Catch:{ Exception -> 0x01cc }
            java.lang.String r8 = r8.packageName     // Catch:{ Exception -> 0x01cc }
            java.lang.String r9 = r8.toLowerCase()     // Catch:{ Exception -> 0x01cc }
            java.lang.String r10 = "com.mpl.androidapp"
            boolean r9 = r9.contains(r10)     // Catch:{ Exception -> 0x01cc }
            if (r9 == 0) goto L_0x015c
            android.content.ComponentName r9 = new android.content.ComponentName     // Catch:{ Exception -> 0x01cc }
            android.content.pm.ActivityInfo r1 = r1.activityInfo     // Catch:{ Exception -> 0x01cc }
            java.lang.String r1 = r1.name     // Catch:{ Exception -> 0x01cc }
            r9.<init>(r8, r1)     // Catch:{ Exception -> 0x01cc }
            r14.add(r9)     // Catch:{ Exception -> 0x01cc }
            goto L_0x015c
        L_0x0185:
            r15.resolve(r7)     // Catch:{ Exception -> 0x01cc }
            android.content.Intent r0 = android.content.Intent.createChooser(r6, r4)     // Catch:{ Exception -> 0x01cc }
            boolean r1 = r14.isEmpty()     // Catch:{ Exception -> 0x01cc }
            if (r1 != 0) goto L_0x01a6
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01cc }
            r4 = 24
            if (r1 < r4) goto L_0x01a6
            java.lang.String r1 = "android.intent.extra.EXCLUDE_COMPONENTS"
            r4 = 0
            android.content.ComponentName[] r4 = new android.content.ComponentName[r4]     // Catch:{ Exception -> 0x01cc }
            java.lang.Object[] r14 = r14.toArray(r4)     // Catch:{ Exception -> 0x01cc }
            android.os.Parcelable[] r14 = (android.os.Parcelable[]) r14     // Catch:{ Exception -> 0x01cc }
            r0.putExtra(r1, r14)     // Catch:{ Exception -> 0x01cc }
        L_0x01a6:
            com.facebook.react.bridge.ReactApplicationContext r14 = r13.reactContext     // Catch:{ Exception -> 0x01cc }
            android.app.Activity r14 = r14.getCurrentActivity()     // Catch:{ Exception -> 0x01cc }
            r14.startActivity(r0)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ea
        L_0x01b0:
            r0 = 1
            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01ca }
            r0 = 0
            r14[r0] = r9     // Catch:{ Exception -> 0x01cc }
            com.mpl.androidapp.utils.MLogger.e(r5, r14)     // Catch:{ Exception -> 0x01cc }
            r15.reject(r3, r2)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ea
        L_0x01bd:
            r0 = 1
            java.lang.Object[] r14 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01ca }
            r0 = 0
            r14[r0] = r9     // Catch:{ Exception -> 0x01cc }
            com.mpl.androidapp.utils.MLogger.e(r5, r14)     // Catch:{ Exception -> 0x01cc }
            r15.reject(r3, r2)     // Catch:{ Exception -> 0x01cc }
            goto L_0x01ea
        L_0x01ca:
            r14 = move-exception
            goto L_0x01ce
        L_0x01cc:
            r14 = move-exception
            r0 = 1
        L_0x01ce:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "Error/n"
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.String r14 = r14.toString()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r1 = 0
            r0[r1] = r14
            com.mpl.androidapp.utils.MLogger.e(r5, r0)
            r15.reject(r3, r2)
        L_0x01ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.modules.SocialShareModule.shareThroughApp(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void shareThroughEmail(String str, Promise promise) {
        MLogger.d(TAG, "shareThroughEmail: ");
        if (getCurrentActivity() != null) {
            CommonUtils.openEmailApps(getCurrentActivity(), str, promise);
            promise.resolve("success");
        }
    }

    @ReactMethod
    public void shareThroughSMS(String str, Promise promise) {
        MLogger.d(TAG, "shareThroughSMS: ");
        if (getCurrentActivity() != null) {
            CommonUtils.shareThroughSms(getCurrentActivity(), str, promise);
        }
    }
}
