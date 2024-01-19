package com.mpl.androidapp.react.modules;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import com.google.gson.Gson;
import com.mpl.androidapp.R;
import com.mpl.androidapp.config.ConfigConstant;
import com.mpl.androidapp.notification.NotificationBuilder;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.Util;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOkHttpDownloadRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import com.netcore.android.SMTConfigConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "FileDownloadHelperModule")
public class FileDownloadHelperModule extends ReactContextBaseJavaModule {
    public static final String TAG = "FileDownloadHelperModule";
    public boolean isRegistered = false;
    public final ArrayList<Long> list = new ArrayList<>();
    public final Context mContext;
    public final BroadcastReceiver onComplete = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            FileDownloadHelperModule.this.list.remove(Long.valueOf(longExtra));
            if (FileDownloadHelperModule.this.list.isEmpty()) {
                MLogger.e(FileDownloadHelperModule.TAG, "INSIDE", GeneratedOutlineSupport.outline45("", longExtra));
                new NotificationBuilder(FileDownloadHelperModule.this.mContext).createVideoDownloadIntent((int) longExtra, MSharedPreferencesUtils.getStringPref("video_" + longExtra, "", false));
                FileDownloadHelperModule.this.mContext.unregisterReceiver(FileDownloadHelperModule.this.onComplete);
                FileDownloadHelperModule.this.isRegistered = false;
            }
        }
    };

    public FileDownloadHelperModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mContext = reactApplicationContext.getBaseContext();
    }

    @ReactMethod
    private void extractZip(File file, File file2) {
        new Thread(new Runnable(file, file2) {
            public final /* synthetic */ File f$0;
            public final /* synthetic */ File f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                FileDownloadHelperModule.lambda$extractZip$0(this.f$0, this.f$1);
            }
        }).start();
    }

    public static /* synthetic */ void lambda$extractZip$0(File file, File file2) {
        try {
            CommonUtils.extractZipFile(file, file2);
        } catch (IOException e2) {
            MLogger.e(TAG, "", e2);
        }
    }

    private void requestPermissions(String str, final Promise promise, final String str2) {
        if (getCurrentActivity() != null) {
            ((MPLReactContainerActivity) getCurrentActivity()).requestPermissions(new String[]{str}, 2000, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                    MLogger.d(FileDownloadHelperModule.TAG, "permissions.length", Integer.valueOf(strArr.length), "grantResults.length", Integer.valueOf(iArr.length));
                    if (iArr.length > 0 && iArr[0] == 0) {
                        FileDownloadHelperModule.this.startDownloadFile(str2, promise);
                    }
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void sendVideoDownloadedFailedEvent(JSONObject jSONObject) {
        try {
            CleverTapAnalyticsUtils.sendEvent((String) "Video Download Success", Util.jsonToMap(jSONObject));
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
        }
    }

    private void sendVideoDownloadedInitiatedEvent(String str) {
        CleverTapAnalyticsUtils.sendEvent((String) "Video Download Initiated", str);
    }

    /* access modifiers changed from: private */
    public void sendVideoDownloadedSuccessEvent(JSONObject jSONObject) {
        try {
            CleverTapAnalyticsUtils.sendEvent((String) "Video Download Failed", Util.jsonToMap(jSONObject));
        } catch (JSONException e2) {
            MLogger.printStackTrace(e2);
        }
    }

    private void showToast() {
        Context context = this.mContext;
        Toast.makeText(context, context.getString(R.string.apk_integrity_install_fail), 1).show();
    }

    private void startDownload(String str, String str2) {
        Uri parse = Uri.parse(str);
        MLogger.d(TAG, "startDownload: ", parse.getLastPathSegment());
        String absolutePath = new File(Environment.DIRECTORY_DOWNLOADS, GeneratedOutlineSupport.outline50("MplVideos/", str2)).getAbsolutePath();
        Request request = new Request(parse);
        request.setAllowedNetworkTypes(3);
        request.setNotificationVisibility(1);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Downloading video from ");
        outline73.append(MBuildConfigUtils.getAppName());
        request.setTitle(outline73.toString());
        request.setVisibleInDownloadsUi(true);
        request.setAllowedOverRoaming(true);
        request.setAllowedOverMetered(true);
        request.setDescription("Share on YouTube after Download Completed");
        Context applicationContext = this.mContext.getApplicationContext();
        String str3 = Environment.DIRECTORY_DOWNLOADS;
        request.setDestinationInExternalFilesDir(applicationContext, str3, "MplVideos/" + str2);
        long enqueue = ((DownloadManager) this.mContext.getSystemService(Constant.DOWNLOAD)).enqueue(request);
        MSharedPreferencesUtils.putStringPref("video_" + enqueue, absolutePath, false);
        this.list.add(Long.valueOf(enqueue));
    }

    /* access modifiers changed from: private */
    public void startDownloadFile(String str, Promise promise) {
        String str2;
        String str3 = str;
        Promise promise2 = promise;
        try {
            boolean booleanPref = MSharedPreferencesUtils.getBooleanPref(ConfigConstant.DOWNLOAD_THROUGH_DOWNLOADER, false, false);
            if (!this.isRegistered) {
                this.mContext.registerReceiver(this.onComplete, new IntentFilter(Constants.FILTER_DOWNLOAD_COMPLETE));
                this.isRegistered = true;
            }
            NotificationBuilder notificationBuilder = new NotificationBuilder(this.mContext);
            Promise[] promiseArr = {promise2};
            if (GEInteractor.getInstance().isSpaceAvailable(this.mContext)) {
                Gson gson = new Gson();
                int currentTimeMillis = (int) System.currentTimeMillis();
                NetworkCallParams networkCallParams = (NetworkCallParams) gson.fromJson(str3, NetworkCallParams.class);
                JSONObject optJSONObject = new JSONObject(str3).optJSONObject("videoParams");
                if (TextUtils.isEmpty(networkCallParams.getDestinationFileName())) {
                    str2 = "MPL_Video_" + currentTimeMillis + ".mp4";
                } else {
                    str2 = networkCallParams.getDestinationFileName();
                }
                String str4 = str2;
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MplVideos");
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = new File(file, str4);
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e2) {
                        MLogger.printStackTrace(e2);
                    }
                }
                if (booleanPref) {
                    File file3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "MplVideos");
                    if (!file3.exists()) {
                        file3.mkdir();
                    }
                    startDownload(networkCallParams.getUrl(), "MPL_Video_" + currentTimeMillis + ".mp4");
                    if (promiseArr[0] != null) {
                        promiseArr[0].resolve(Boolean.TRUE);
                        promiseArr[0] = null;
                        return;
                    }
                    return;
                }
                Builder builder = new Builder();
                builder.setUrl(networkCallParams.getUrl());
                builder.setDestFile(file2);
                builder.setDestFileName(str4);
                builder.setRequestPriority(RequestPriority.LOW);
                builder.setHeaders(CommonUtils.getCommonHeaders());
                final Promise[] promiseArr2 = promiseArr;
                final NotificationBuilder notificationBuilder2 = notificationBuilder;
                final int i = currentTimeMillis;
                final JSONObject jSONObject = optJSONObject;
                AnonymousClass1 r1 = new IResponseListener<String>() {
                    public void onResponseFail(Exception exc) {
                        MLogger.d(IResponseListener.TAG, "onResponseFail:", exc);
                        Promise[] promiseArr = promiseArr2;
                        if (promiseArr[0] != null) {
                            promiseArr[0].reject((String) Constant.NETWORK_ERROR, exc.toString());
                        }
                        FileDownloadHelperModule.this.sendVideoDownloadedFailedEvent(jSONObject);
                        notificationBuilder2.createFailNotification(i);
                    }

                    public void progressResponse(long j, long j2, boolean z) {
                        Promise[] promiseArr = promiseArr2;
                        if (promiseArr[0] != null) {
                            promiseArr[0].resolve(Boolean.TRUE);
                            promiseArr2[0] = null;
                        }
                        int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                        Object[] objArr = new Object[3];
                        objArr[0] = "progressResponse: ";
                        objArr[1] = Integer.valueOf(i);
                        int i2 = i % 10;
                        objArr[2] = Boolean.valueOf(i2 == 0);
                        MLogger.d(IResponseListener.TAG, objArr);
                        if (i2 == 0) {
                            notificationBuilder2.createProgressNotification(i, i);
                        }
                        MLogger.d(IResponseListener.TAG, i + "");
                    }

                    public void onResponseSuccess(String str) {
                        MLogger.d(IResponseListener.TAG, "onResponseSuccess:", str);
                        Promise[] promiseArr = promiseArr2;
                        if (promiseArr[0] != null) {
                            promiseArr[0].resolve(str);
                        }
                        notificationBuilder2.createVideoDownloadIntent(i, str);
                        FileDownloadHelperModule.this.sendVideoDownloadedSuccessEvent(jSONObject);
                    }
                };
                builder.setResponseListener(r1);
                builder.setTag("post_request" + currentTimeMillis);
                builder.setConnectTimeout(Math.max(networkCallParams.getConnectionTimeOut(), 10000));
                builder.setReadTimeout(Math.max(networkCallParams.getReadTimeOut(), 10000));
                builder.setWriteTimeout(Math.max(networkCallParams.getWriteTimeOut(), 10000));
                builder.setPingInterval(Math.max(networkCallParams.getPingInterval(), 10000));
                builder.setRetryOnConnectionFailure(networkCallParams.isRetryOption());
                if (!TextUtils.isEmpty(networkCallParams.getHost())) {
                    builder.setHost(networkCallParams.getHost());
                }
                if (!TextUtils.isEmpty(networkCallParams.getScheme())) {
                    builder.setScheme(networkCallParams.getScheme());
                }
                if (networkCallParams.getPort() > 0) {
                    builder.setPort(networkCallParams.getPort());
                }
                builder.setRetryOnConnectionFailure(true);
                MClient.executeAsync(builder.build());
                return;
            }
            promise2.reject((String) Constant.NETWORK_ERROR, (String) "No space on device");
        } catch (Exception unused) {
        }
    }

    @ReactMethod
    public void downloadFile(String str, Promise promise) {
        if (Util.hasPermission(this.mContext, SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY)) {
            startDownloadFile(str, promise);
        } else if (getCurrentActivity() != null) {
            requestPermissions(SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY, promise, str);
        } else {
            promise.reject((String) Constant.NETWORK_ERROR, (String) "Permission not granted");
        }
    }

    @ReactMethod
    public void downloadFileToExternalStorage(String str, final Promise promise) {
        try {
            if (getCurrentActivity() != null) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url", "");
                String optString2 = jSONObject.optString(Constants.DOWNLOADER_FILE_NAME, "");
                if (!TextUtils.isEmpty(optString)) {
                    if (!TextUtils.isEmpty(optString2)) {
                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), optString2);
                        NetworkUtils.downloadFile(new NetworkCallParams.Builder().setUrl(optString).setDestinationFilePath(file.getAbsolutePath()).setDestinationFileName(file.getName()).build(), new IResponseListener<String>() {
                            public void onResponseFail(Exception exc) {
                                promise.reject((String) "fail", exc.getMessage());
                            }

                            public void progressResponse(long j, long j2, boolean z) {
                            }

                            public void onResponseSuccess(String str) {
                                promise.resolve(str);
                            }
                        });
                        return;
                    }
                }
                promise.reject((String) "fail", (String) "Url or file name is empty");
                return;
            }
            promise.reject((String) "fail", (String) "Activity is null");
        } catch (Exception e2) {
            promise.reject((String) "fail", e2.getMessage());
        }
    }

    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void isDirAvailableOnExternalStorage(String str, Promise promise) {
    }

    @ReactMethod
    public void isDownloadDirAvailableOnExternalStorage(String str, Promise promise) {
        File file;
        if (getCurrentActivity() != null) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (externalStoragePublicDirectory != null && !externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdir();
            }
            file = new File(externalStoragePublicDirectory, str);
            if (!file.exists()) {
                file.mkdir();
            }
        } else {
            file = null;
        }
        promise.resolve(Boolean.valueOf(file != null && file.exists()));
    }

    @ReactMethod
    public void isPathAvailable(String str, Promise promise) {
        if (TextUtils.isEmpty(str)) {
            promise.resolve(Boolean.FALSE);
        } else {
            promise.resolve(Boolean.valueOf(FileUtils.isSponsorFileAvailable(this.mContext, str)));
        }
    }
}
