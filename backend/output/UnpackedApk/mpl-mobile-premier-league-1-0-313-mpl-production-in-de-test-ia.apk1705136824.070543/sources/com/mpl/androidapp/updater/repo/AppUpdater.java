package com.mpl.androidapp.updater.repo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.updater.IntegrityCheck;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.util.ResponseUtil;
import com.mpl.androidapp.updater.util.ServiceUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant.Api;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.updater.util.UpdaterConstant.SharedPref;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOkHttpDownloadRequest;
import com.mpl.network.modules.request.RequestPriority;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import org.apache.fontbox.cmap.CMapParser;

public class AppUpdater extends Service {
    public static final int ID = 1000;
    public static final String TAG = "AppUpdater";
    public static int internalProgress;
    public final Semaphore lock = new Semaphore(1);
    public final IBinder mBinder = new AppBinder();
    public Messenger mClientMessenger;
    public Builder notification;

    public class AppBinder extends Binder {
        public AppBinder() {
        }

        public void setMessenger(Messenger messenger) {
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "*********************");
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "App update service connected");
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "*********************");
            AppUpdater.this.mClientMessenger = messenger;
        }
    }

    /* access modifiers changed from: private */
    public void downloadFile(String str, String str2, Semaphore semaphore) {
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "downloadFile:", "internalProgress: ", Integer.valueOf(internalProgress), "downloadURL: ", str, "downloadHash: ", str2);
        if (semaphore.availablePermits() == 1) {
            try {
                semaphore.acquire();
                final boolean updaterV2Enabled = MSharedPreferencesUtils.getUpdaterV2Enabled();
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "available Semaphore permits now: ", Integer.valueOf(semaphore.availablePermits()));
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "Start downloading: ", "isUpdaterV2Enabled: ", Boolean.valueOf(updaterV2Enabled));
                String str3 = DBInteractor.getAppDownloadProgressVersionCode() + ".apk";
                if (updaterV2Enabled) {
                    str3 = MSharedPreferencesUtils.getUpdater2Version() + ".apk";
                }
                File apkOutputFile = FileUtils.getApkOutputFile(this, DBInteractor.getAppDownloadProgressVersionCode());
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "Filename:  ", str3, "File Path:  ", apkOutputFile.getAbsolutePath());
                if (apkOutputFile.isDirectory()) {
                    MLogger.d("AppUpdater", "downloadFile:File is Directory ");
                }
                if (apkOutputFile.exists()) {
                    MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "downloadFile does exists, Deleting it:", Boolean.valueOf(apkOutputFile.delete()));
                }
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "downloadFile Creating new file:", Boolean.valueOf(apkOutputFile.createNewFile()));
                int length = (int) apkOutputFile.length();
                MSharedPreferencesUtils.setTimeTakenToDownload(0);
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "downloadFile Size: ", Integer.valueOf(length), "downloadFile internalProgress: ", Integer.valueOf(internalProgress));
                internalProgress = 0;
                final long currentTimeMillis = System.currentTimeMillis();
                MOkHttpDownloadRequest.Builder retryOnConnectionFailure = new MOkHttpDownloadRequest.Builder().setUrl(r0 + "?ts=" + System.currentTimeMillis()).setDestFileName(str3).setHeaders(CommonUtils.getCommonHeaders()).setDestFile(apkOutputFile).setDownloadedSize((long) length).setRequestPriority(RequestPriority.LOW).setRetryOnConnectionFailure(true);
                final String str4 = str2;
                final Semaphore semaphore2 = semaphore;
                final File file = apkOutputFile;
                AnonymousClass2 r11 = new IResponseListener<String>() {
                    public void onResponseFail(Exception exc) {
                        MLogger.e(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "downloadFile:", exc);
                        MLogger.e(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "downloadFile:outFile exists", Boolean.valueOf(file.exists()));
                        AppUpdater.this.publishProgress(Constant.APK_DOWNLOAD_FAILED_CODE, updaterV2Enabled);
                        AppUpdater.this.sendFailureStatusToEventPublisher();
                        MLogger.d(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "App Downloading failed !!!");
                        semaphore2.release();
                        try {
                            if (MPLApplication.getInstance() != null) {
                                MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), SharedPref.IS_RELEASE_NOTES_SCREEN_REQUIRED, false);
                            }
                        } catch (Exception unused) {
                            MLogger.e(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "onResponseFail: ");
                        }
                        AppUpdater.this.sendToCleverTap(0, false, (exc == null || !TextUtils.isEmpty(exc.getLocalizedMessage())) ? "Something went wrong" : exc.getLocalizedMessage());
                        AppUpdater.this.stopForeground(true);
                        AppUpdater.this.stopSelf();
                    }

                    public void progressResponse(long j, long j2, boolean z) {
                        int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                        if (i % 10 == 0 && AppUpdater.internalProgress < i) {
                            AppUpdater.internalProgress = i;
                            AppUpdater.this.publishProgress(i, updaterV2Enabled);
                        }
                    }

                    public void onResponseSuccess(String str) {
                        boolean z;
                        MLogger.d(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, GeneratedOutlineSupport.outline50("App Downloading Successful !!! File Path", str));
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("App Downloading Successful !!! file Hash ");
                        outline73.append(str4);
                        MLogger.d(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, outline73.toString());
                        boolean updaterV2Enabled = MSharedPreferencesUtils.getUpdaterV2Enabled();
                        DBInteractor.setCurrentDownloadedAppVersionCode(DBInteractor.getAppDownloadProgressVersionCode());
                        DBInteractor.setAppHash(str4);
                        semaphore2.release();
                        boolean ApkIntegrityCheck = IntegrityCheck.ApkIntegrityCheck(file);
                        EventPublishHelper.publishInitialStatusEvent(AppUpdater.this, StatusType.INSTALL);
                        MLogger.d(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "Time Taken For Down Load: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        MSharedPreferencesUtils.setTimeTakenToDownload(System.currentTimeMillis() - currentTimeMillis);
                        try {
                            boolean isUpdateCriticalInUpdaterV2 = MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2();
                            boolean isCriticalUpdate = MSharedPreferencesUtils.isCriticalUpdate();
                            if (!updaterV2Enabled) {
                                String valueOf = String.valueOf(DBInteractor.getCurrentDownloadedAppVersionCode());
                                if (!isCriticalUpdate) {
                                    if (!isUpdateCriticalInUpdaterV2) {
                                        z = false;
                                        UpdaterAnalytics.appUpdateDownloadEvent(valueOf, z);
                                    }
                                }
                                z = true;
                                UpdaterAnalytics.appUpdateDownloadEvent(valueOf, z);
                            }
                            if (MPLApplication.getInstance() != null) {
                                MSharedPreferencesUtils.saveBooleanInNormalPref(MPLApplication.getInstance(), SharedPref.IS_RELEASE_NOTES_SCREEN_REQUIRED, true);
                            }
                        } catch (Exception e2) {
                            MLogger.e(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "onResponseSuccess: ", e2);
                        }
                        File apkOutputFile = FileUtils.getApkOutputFile(AppUpdater.this, DBInteractor.getAppDownloadProgressVersionCode());
                        MLogger.d(IResponseListener.TAG, Constant.APP_UPDATE_CHECK, "onResponseSuccess: ", Boolean.valueOf(ApkIntegrityCheck));
                        if (ApkIntegrityCheck) {
                            AppUpdater appUpdater = AppUpdater.this;
                            ServiceUtil.createUpdaterInstallNotification(appUpdater, FileUtils.getApkOutputFile(appUpdater, DBInteractor.getAppDownloadProgressVersionCode()));
                            int length = (int) apkOutputFile.length();
                            if (updaterV2Enabled) {
                                AppUpdater.this.sendToCleverTap(length, true, "");
                            }
                        } else {
                            ServiceUtil.updaterDownloadIssueNotification(AppUpdater.this);
                            if (updaterV2Enabled) {
                                AppUpdater.this.sendToCleverTap(0, false, "Download apk corrupted");
                            }
                        }
                        AppUpdater.this.stopForeground(true);
                        AppUpdater.this.stopSelf();
                    }
                };
                MClient.executeAsync(retryOnConnectionFailure.setResponseListener(r11).build());
            } catch (IOException | InterruptedException e2) {
                MLogger.e("AppUpdater", Constant.APP_UPDATE_CHECK, "", e2);
                semaphore.release();
            }
        }
    }

    private void executeTask(String str) {
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "executeTask: ", Integer.valueOf(internalProgress));
        boolean updaterV2Enabled = MSharedPreferencesUtils.getUpdaterV2Enabled();
        boolean isUpdateAvailableInUpdaterV2 = MSharedPreferencesUtils.isUpdateAvailableInUpdaterV2();
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "executeTask: ", "isUpdaterV2Enabled: ", Boolean.valueOf(updaterV2Enabled), "updateAvailableInUpdaterV2: ", Boolean.valueOf(isUpdateAvailableInUpdaterV2));
        if (!updaterV2Enabled || !isUpdateAvailableInUpdaterV2) {
            DownloadHelper.getInstance().getDownloadUrl(Api.BASE_URL + Api.ANDROID + DBInteractor.getAppDownloadProgressVersionCode(), str, "apk_download", new ResponseListener() {
                public void onFailure(String str) {
                    MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onFailure: App download url");
                    AppUpdater.this.sendFailureStatusToEventPublisher();
                    AppUpdater.this.stopSelf();
                }

                public void onSuccess(String str) {
                    ResponseUtil.parseAndroidAppDownloadURL(str);
                    String appDownloadURL = DBInteractor.getAppDownloadURL();
                    String appDownloadingHash = DBInteractor.getAppDownloadingHash();
                    MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "APK response: ", str);
                    MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, Response.DOWNLOAD_URL, appDownloadURL, "downloadingHash", appDownloadingHash);
                    if (appDownloadURL == null || TextUtils.isEmpty(appDownloadURL)) {
                        EventPublishHelper.publishInitialStatusEvent(AppUpdater.this, StatusType.GENERIC_CONNECTION_ERROR);
                        AppUpdater.this.stopSelf();
                        return;
                    }
                    AppUpdater appUpdater = AppUpdater.this;
                    appUpdater.downloadFile(appDownloadURL, appDownloadingHash, appUpdater.lock);
                }
            });
            return;
        }
        String apkUrl = MSharedPreferencesUtils.getApkUrl();
        String updateSha = MSharedPreferencesUtils.getUpdateSha();
        if (apkUrl.isEmpty() || updateSha.isEmpty()) {
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "empty url or sha");
            stopForeground(true);
            stopSelf();
            return;
        }
        downloadFile(apkUrl, updateSha, this.lock);
    }

    private void publishForegroundServiceNotification() {
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "publishForegroundServiceNotification: ");
        long currentTimeMillis = System.currentTimeMillis();
        if (VERSION.SDK_INT >= 26) {
            boolean updaterV2Enabled = MSharedPreferencesUtils.getUpdaterV2Enabled();
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate: ", "isUpdaterV2Enabled: ", Boolean.valueOf(updaterV2Enabled), "Time Taken: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (updaterV2Enabled) {
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate: Updater V2 Enabled Starting new updater flow [START]", "Time Taken: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                Builder createUpdaterDownloadNotification = ServiceUtil.createUpdaterDownloadNotification(this, false);
                this.notification = createUpdaterDownloadNotification;
                startForeground(1000, createUpdaterDownloadNotification.build());
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate: Updater V2 Enabled Starting new updater flow [END]", "Time Taken: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate: Updater V2 is not enabled Starting Old updater");
            startForeground(1000, ServiceUtil.getNotification(getApplicationContext(), "Please wait update is going on."));
        }
    }

    /* access modifiers changed from: private */
    public void publishProgress(int i, boolean z) {
        if (this.mClientMessenger != null) {
            try {
                if (VERSION.SDK_INT >= 26) {
                    MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "progressResponse: inside oreo");
                    if (this.notification != null && z) {
                        ServiceUtil.updateAppDownloadNotificationProgress(getApplicationContext(), 1000, i, this.notification);
                    }
                }
                Message obtain = Message.obtain(null, 1);
                Bundle bundle = new Bundle();
                bundle.putInt("progress", i);
                MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "publishProgress() called with: progress = [" + i + CMapParser.MARK_END_OF_ARRAY);
                obtain.setData(bundle);
                this.mClientMessenger.send(obtain);
            } catch (RemoteException unused) {
                MLogger.e("AppUpdater", Constant.APP_UPDATE_CHECK, "publishProgress() called with: error");
            }
        } else {
            MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "publishProgress app messenger is null");
        }
    }

    /* access modifiers changed from: private */
    public void sendFailureStatusToEventPublisher() {
        try {
            if (new DeviceInfo(getApplicationContext()).isInternetAvailable(getApplicationContext())) {
                EventPublishHelper.publishInitialStatusEvent(this, StatusType.GENERIC_CONNECTION_ERROR);
            } else {
                EventPublishHelper.publishInitialStatusEvent(this, StatusType.INTERNET_ABSENT);
            }
        } catch (Exception e2) {
            MLogger.e("AppUpdater", Constant.APP_UPDATE_CHECK, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("sendFailureStatusToEventPublisher: ")));
        }
    }

    /* access modifiers changed from: private */
    public void sendToCleverTap(int i, boolean z, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(EventsConstants.IS_CRITICAL, Boolean.valueOf(MSharedPreferencesUtils.isUpdateCriticalInUpdaterV2()));
            hashMap.put(EventsConstants.UPDATE_VERSION, Integer.valueOf(MSharedPreferencesUtils.getUpdater2Version()));
            hashMap.put(EventsConstants.IS_SKIPPABLE, Boolean.valueOf(MSharedPreferencesUtils.canSkipPopup()));
            hashMap.put(EventsConstants.TIME_TO_DOWNLOAD, Long.valueOf(MSharedPreferencesUtils.getTimeTakenToDownload()));
            hashMap.put(EventsConstants.DOWNLOAD_URL, MSharedPreferencesUtils.getApkUrl());
            hashMap.put(EventsConstants.DOWNLOAD_SIZE, Integer.valueOf(i));
            hashMap.put("Is Success", Boolean.valueOf(z));
            hashMap.put(EventsConstants.FAIL_REASON, str);
            hashMap.put("Entry Point", MSharedPreferencesUtils.getEntryPoint());
            hashMap.put(EventsConstants.ELIGIBILITY_CRITERIA, MSharedPreferencesUtils.getEligibilityCriteria());
            hashMap.put(EventsConstants.UPDATER_VERSION, Integer.valueOf(2));
            CleverTapAnalyticsUtils.sendEvent((String) UpdaterAnalytics.APP_UPDATE_DOWNLOAD, hashMap);
        } catch (Exception e2) {
            if (!TextUtils.isEmpty(e2.getMessage())) {
                MLogger.e("AppUpdater", Constant.APP_UPDATE_CHECK, "sendToCleverTap: ", e2.getMessage());
                return;
            }
            MLogger.e("AppUpdater", Constant.APP_UPDATE_CHECK, "sendToCleverTap: ");
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate() called [START]");
        publishForegroundServiceNotification();
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onCreate() called [END]");
    }

    public void onDestroy() {
        super.onDestroy();
        if (VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        stopSelf();
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onDestroy() called");
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        MLogger.d("AppUpdater", "onRebind: ");
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onStart: ", Integer.valueOf(i));
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onStartCommand:[START]");
        try {
            publishForegroundServiceNotification();
            String str = "";
            if (intent != null && intent.hasExtra(Constant.EXTRA_ACCESS_TOKEN)) {
                str = intent.getStringExtra(Constant.EXTRA_ACCESS_TOKEN);
            }
            executeTask(str);
        } catch (Exception unused) {
        }
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onStartCommand:[END]");
        return super.onStartCommand(intent, i, i2);
    }

    public void onTaskRemoved(Intent intent) {
        MLogger.d("AppUpdater", Constant.APP_UPDATE_CHECK, "onTaskRemoved: ");
    }
}
