package com.mpl.androidapp.updater.repo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.deviceinfo.DeviceInfo;
import com.mpl.androidapp.updater.AppInitialization;
import com.mpl.androidapp.updater.interactor.DBInteractor;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.util.ResponseUtil;
import com.mpl.androidapp.updater.util.ServiceUtil;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.updater.util.UpdaterConstant.Api;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.network.modules.MClient;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.network.modules.request.MOkHttpDownloadRequest.Builder;
import com.mpl.network.modules.request.RequestPriority;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class BundleUpdater extends Service {
    public static final int ID = 2000;
    public static final String TAG = "BundleUpdater";
    public final Semaphore lock = new Semaphore(1);
    public final IBinder mBinder = new BundleBinder();
    public Messenger mClientMessenger;

    public class BundleBinder extends Binder {
        public BundleBinder() {
        }

        public void setMessenger(Messenger messenger) {
            MLogger.d(BundleUpdater.TAG, "*********************");
            MLogger.d(BundleUpdater.TAG, "Bundle update service connected");
            MLogger.d(BundleUpdater.TAG, "*********************");
            BundleUpdater.this.mClientMessenger = messenger;
        }
    }

    /* access modifiers changed from: private */
    public void downloadFile(final String str, final String str2, final Semaphore semaphore) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    MLogger.d(BundleUpdater.TAG, "available Semaphore permits now: " + semaphore.availablePermits());
                    semaphore.acquire();
                    MLogger.d(BundleUpdater.TAG, "Start downloading");
                    File reactBundleOutputFile = FileUtils.getReactBundleOutputFile(BundleUpdater.this, DBInteractor.getRNBundleDownloadProgressVersionCode());
                    if (!reactBundleOutputFile.exists()) {
                        reactBundleOutputFile.createNewFile();
                    }
                    MClient.executeAsync(new Builder().setUrl(str).setDestFileName(Constant.ZIP_FILE).setHeaders(CommonUtils.getCommonHeaders()).setDestFile(reactBundleOutputFile).setDownloadedSize((long) ((int) reactBundleOutputFile.length())).setRequestPriority(RequestPriority.LOW).setRetryOnConnectionFailure(true).setResponseListener(new IResponseListener<String>() {
                        public void onResponseFail(Exception exc) {
                            MLogger.e(IResponseListener.TAG, "", exc);
                            MLogger.d(IResponseListener.TAG, "Bundle Downloading failed !!!");
                            BundleUpdater.this.sendFailureStatusToEventPublisher();
                            semaphore.release();
                            BundleUpdater.this.stopSelf();
                        }

                        public void progressResponse(long j, long j2, boolean z) {
                        }

                        public void onResponseSuccess(String str) {
                            int currentRNBundleVersionCode = DBInteractor.getCurrentRNBundleVersionCode();
                            DBInteractor.setCurrentRNBundleVersionCode(DBInteractor.getRNBundleDownloadProgressVersionCode());
                            FileInteractor.performFileOperationAfterDownload(BundleUpdater.this, currentRNBundleVersionCode);
                            DBInteractor.setIsFirstTimeLoad();
                            DBInteractor.setRNBundleHash(str2);
                            if (DBInteractor.getRNBundleReload()) {
                                DBInteractor.setCurrentDownloadedRNBundleVersionCode(DBInteractor.getCurrentRNBundleVersionCode());
                                AppInitialization.from(BundleUpdater.this).checkUpdateAvailableCall(BundleUpdater.this, StatusType.CHECKING_UPDATE);
                            } else {
                                DBInteractor.setCurrentDownloadedRNBundleVersionCode(currentRNBundleVersionCode);
                                EventPublishHelper.publishReactBundleDownloadedStatusEvent(BundleUpdater.this, StatusType.REACT_BUNDLE_DOWNLOADED);
                            }
                            String valueOf = String.valueOf(DBInteractor.getCurrentRNBundleVersionCode());
                            UpdaterAnalytics.setReactUpdateDownloadedEvent(valueOf, String.valueOf(currentRNBundleVersionCode));
                            UpdaterAnalytics.reactUpdatedInstalledEvent(valueOf, String.valueOf(currentRNBundleVersionCode));
                            MLogger.d(IResponseListener.TAG, "onResponseSuccess: react update successful ", valueOf, Integer.valueOf(currentRNBundleVersionCode));
                            semaphore.release();
                            BundleUpdater.this.stopSelf();
                        }
                    }).build());
                } catch (IOException | InterruptedException e2) {
                    MLogger.e(BundleUpdater.TAG, "", e2);
                } catch (Throwable th) {
                    semaphore.release();
                    throw th;
                }
                semaphore.release();
            }
        }).start();
    }

    private void executeTask() {
        try {
            DownloadHelper.getInstance().getDownloadUrl(Api.BASE_URL + Api.REACT_BUNDLE + DBInteractor.getRNBundleDownloadProgressVersionCode(), "bundle_download_v2", new ResponseListener() {
                public void onFailure(String str) {
                    BundleUpdater.this.sendFailureStatusToEventPublisher();
                }

                public void onSuccess(String str) {
                    ResponseUtil.parseRNBundleDownloadURL(str);
                    String rNBundleDownloadURL = DBInteractor.getRNBundleDownloadURL();
                    String rNBundleDownloadingHash = DBInteractor.getRNBundleDownloadingHash();
                    MLogger.d(BundleUpdater.TAG, "React Bundle response: ", str, Response.DOWNLOAD_URL, rNBundleDownloadURL, "downloadingHash", rNBundleDownloadingHash);
                    if (rNBundleDownloadURL == null || TextUtils.isEmpty(rNBundleDownloadURL)) {
                        EventPublishHelper.publishInitialStatusEvent(BundleUpdater.this, StatusType.GENERIC_CONNECTION_ERROR);
                        return;
                    }
                    BundleUpdater bundleUpdater = BundleUpdater.this;
                    bundleUpdater.downloadFile(rNBundleDownloadURL, rNBundleDownloadingHash, bundleUpdater.lock);
                }
            });
        } catch (Exception unused) {
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
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("sendFailureStatusToEventPublisher: ")));
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            MLogger.d(TAG, "onCreate: inside oreo");
            startForeground(2000, ServiceUtil.getNotification(this, "Please wait update is going on."));
        }
        MLogger.d(TAG, "onCreate() called");
    }

    public void onDestroy() {
        super.onDestroy();
        if (VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        MLogger.d(TAG, "onDestroy() called");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        executeTask();
        return super.onStartCommand(intent, i, i2);
    }

    public void onTaskRemoved(Intent intent) {
    }
}
