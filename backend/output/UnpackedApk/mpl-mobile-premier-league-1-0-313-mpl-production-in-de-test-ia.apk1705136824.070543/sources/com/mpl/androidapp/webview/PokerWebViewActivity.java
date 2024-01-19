package com.mpl.androidapp.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReactMethod;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.miniprofile.utils.InternetConnectionInfo;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.RNConstant;
import com.mpl.androidapp.ui.ErrorDialogBottomSheet;
import com.mpl.androidapp.ui.ErrorDialogBottomSheet.ActionItemClickListener;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeFour;
import com.mpl.androidapp.updater.downloadmanager.utils.DownServTimePoints.PropertyTimeOne;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.webview.ct.utils.UtilWebGameEndToEndEvent;
import com.mpl.androidapp.webview.utils.CustomWebViewCallback;
import com.mpl.androidapp.webview.utils.WebViewCallback;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.mpl.androidapp.webview.view.dialogs.DownloadMngServiceChkDialog;
import com.mpl.androidapp.webview.view.dialogs.DownloadMngServiceChkDialog.Callback;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.netcore.android.SMTConfigConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONArray;
import org.json.JSONObject;

public class PokerWebViewActivity extends Hilt_PokerWebViewActivity implements OnClickListener, ActionItemClickListener, Callback, WebViewCallback {
    public static String[] PERMISSIONS_REQ = {SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY};
    public static final int REQUEST_CODE_PERMISSION = 2;
    public static final String TAG = "TestingWebViewActivity-->";
    public final String DOWNLOAD_MANAGER_PACKAGE_NAME = "com.android.providers.downloads";
    public final int DOWNLOAD_MANAGER_SERVICE_CODE = 1002;
    public final BroadcastReceiver assetDownloadProgress = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            PokerWebViewActivity.this.viewModel.handleBroadcast(intent);
        }
    };
    public boolean ebLoderEnabled = true;
    public ErrorDialogBottomSheet errorDialogBottomSheet;
    public String gameName;
    public AppCompatTextView header;
    public final HashMap<Integer, Integer> idProgress = new HashMap<>();
    public PokerWebViewActivity instance;
    public boolean isPokerLoaded = false;
    public String mAssetsDownloadUrl;
    public ConstraintLayout mAssetsLoadingLayout;
    public ProgressBar mAssetsProgress;
    public int mAssetsVersion;
    public String mAuthHeader;
    public String mAvatar;
    public String mBaseUrl;
    public String mConfigUrl;
    public String mDisplayName;
    public long mGameIconClickTime;
    public int mGameId;
    public RelativeLayout mHeaderLayout;
    public String mInvoiceContentDisposition;
    public long mInvoiceContentLength;
    public String mInvoiceMimetype;
    public String mInvoiceUrl;
    public String mInvoiceUserAgent;
    public FrameLayout mMPLErrorView;
    public WebView mMPLWebView;
    public JSONObject mPostJsonData;
    public String mRedirectionTournamentId;
    public String mRedirectionType;
    public String mSecretKey;
    public String mUniqueSessionId;
    public BroadcastReceiver mWifiReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!InternetConnectionInfo.INSTANCE.isNetworkAvailable(PokerWebViewActivity.this)) {
                PokerWebViewActivity.this.showNetworkErrorText();
            } else {
                PokerWebViewActivity.this.hideNetworkErrorText();
            }
        }
    };
    public AppCompatTextView networkErrorText;
    public int oldVersion;
    public AppCompatTextView progressText;
    public AppCompatTextView tipsText;
    public PokerWebViewVm viewModel;
    public Handler visibilityHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            MLogger.d(PokerWebViewActivity.TAG, "handleMessage:visibilityHandler ");
            PokerWebViewActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    PokerWebViewActivity.this.isPokerLoaded = true;
                    PokerWebViewActivity.this.sendAppScreenViewEvent("Poker Lobby Screen", true);
                    if (PokerWebViewActivity.this.mMPLWebView != null) {
                        PokerWebViewActivity.this.mMPLWebView.setVisibility(0);
                    }
                    ConstraintLayout constraintLayout = PokerWebViewActivity.this.mAssetsLoadingLayout;
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(8);
                    }
                }
            });
            return false;
        }
    });
    public WakeLock wakeLock;

    private void acquireScreenWakeLock(Context context) {
        MLogger.d(TAG, "acquireScreenWakeLock: ");
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            this.wakeLock = powerManager.newWakeLock(805306394, "webview:podcast");
        }
        WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.acquire();
        }
    }

    /* access modifiers changed from: private */
    public void changeOrientation(String str) {
        if (SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE.equalsIgnoreCase(str)) {
            setRequestedOrientation(6);
        } else if ("sensor".equalsIgnoreCase(str)) {
            setRequestedOrientation(10);
        } else {
            setRequestedOrientation(7);
        }
        updateHeaderUI(str);
    }

    private void checkAssets(boolean z) {
        MLogger.d(TAG, "checkAssets: ");
        if (isAssetsAvailable()) {
            MLogger.d(TAG, "startPartnerPWA:Game code available Starting Game ");
            this.mAssetsProgress.setIndeterminate(true);
            makePokerLoadAPICall();
            UtilWebGameEndToEndEvent.INSTANCE.assetAlreadyDownloaded(this.mGameId);
            return;
        }
        MLogger.d(TAG, "startPartnerPWA:Game code available Downloading Asset");
        this.mAssetsLoadingLayout.setVisibility(0);
        this.mHeaderLayout.setVisibility(0);
        sendAppScreenViewEvent("Poker Loader Screen", false);
        downloadPokerAssets(z);
        UtilWebGameEndToEndEvent.INSTANCE.assetDownloadInitiated(this.mGameId);
    }

    private boolean checkIfDownloadServiceIsEnabled() {
        int applicationEnabledSetting = getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
    }

    /* access modifiers changed from: private */
    public void deleteDownloadedAssets() {
        if (isAssetsAvailable()) {
            MLogger.d(TAG, "onRetryClick: Assets Available");
            File webViewBundleOutputFile = FileUtils.getWebViewBundleOutputFile(this, String.valueOf(this.mGameId), this.mAssetsVersion);
            if (webViewBundleOutputFile != null && webViewBundleOutputFile.exists()) {
                CommonUtils.deleteDir(webViewBundleOutputFile);
                MLogger.d(TAG, "onRetryClick: Assets Available, Deleting");
            }
        }
    }

    private void downloadFile(String str, String str2, int i, int i2, boolean z) {
        try {
            this.idProgress.put(Integer.valueOf(this.mGameId), Integer.valueOf(0));
            sendPokerAssetsAvailableEvent(str, str2, i, i2, z);
            int i3 = i;
            File webViewBundleOutputFile = FileUtils.getWebViewBundleOutputFile(this, String.valueOf(this.mGameId), i);
            if (!webViewBundleOutputFile.exists()) {
                webViewBundleOutputFile.createNewFile();
            }
            String str3 = str;
            Builder destinationFileName = new Builder().setUrl(str).setDestinationFilePath(webViewBundleOutputFile.getAbsolutePath()).setDestinationFileName("webApp.zip");
            if (ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("poker.enable.assets.new.configV2", false)) {
                destinationFileName.setPriority(1);
                destinationFileName.setRetryOption(true);
                int i4 = 30000;
                if (ConfigManager.getNormalConfig() != null) {
                    i4 = ConfigManager.getNormalConfig().optInt("poker.assets.timeout.millisecond", 30000);
                }
                destinationFileName.setConnectionTimeOut(i4);
                destinationFileName.setReadTimeOut(i4);
                destinationFileName.setWriteTimeOut(i4);
                destinationFileName.setPingInterval(i4);
            } else if (ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("poker.enable.assets.new.config", false)) {
                destinationFileName.setPriority(1);
                destinationFileName.setRetryOption(true);
                destinationFileName.setConnectionTimeOut(Integer.MAX_VALUE);
                destinationFileName.setReadTimeOut(Integer.MAX_VALUE);
                destinationFileName.setWriteTimeOut(Integer.MAX_VALUE);
                destinationFileName.setPingInterval(Integer.MAX_VALUE);
            }
            NetworkCallParams build = destinationFileName.build();
            final String str4 = str;
            final String str5 = str2;
            final int i5 = i;
            final int i6 = i2;
            final boolean z2 = z;
            AnonymousClass2 r1 = new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    try {
                        if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean("poker.retry.enabled", false)) {
                            PokerWebViewActivity.this.showError("Fail to download assets", str4);
                            PokerWebViewActivity.this.sendPokerAssetsFailedEvent(str4, str5, i5, i6, z2, exc);
                        }
                        if (PokerWebViewActivity.this.getSupportFragmentManager() == null || PokerWebViewActivity.this.getSupportFragmentManager().isDestroyed()) {
                            PokerWebViewActivity.this.showError("Fail to download assets", str4);
                        } else {
                            PokerWebViewActivity.this.errorDialogBottomSheet = ErrorDialogBottomSheet.newInstance(new Bundle());
                            PokerWebViewActivity.this.errorDialogBottomSheet.show(PokerWebViewActivity.this.getSupportFragmentManager(), IResponseListener.TAG);
                        }
                        PokerWebViewActivity.this.deleteDownloadedAssets();
                        PokerWebViewActivity.this.sendPokerAssetsFailedEvent(str4, str5, i5, i6, z2, exc);
                    } catch (Exception unused) {
                        PokerWebViewActivity.this.showError("Fail to download assets", str4);
                    }
                }

                public void progressResponse(long j, long j2, boolean z) {
                    float f2 = (float) j;
                    float f3 = (float) j2;
                    int i = (int) ((f2 / f3) * 100.0f);
                    int intValue = PokerWebViewActivity.this.idProgress.containsKey(Integer.valueOf(PokerWebViewActivity.this.mGameId)) ? ((Integer) PokerWebViewActivity.this.idProgress.get(Integer.valueOf(PokerWebViewActivity.this.mGameId))).intValue() : 0;
                    if (i % 2 == 0 && intValue < i && i < 100) {
                        PokerWebViewActivity.this.idProgress.put(Integer.valueOf(PokerWebViewActivity.this.mGameId), Integer.valueOf(i));
                        PokerWebViewActivity.this.publishProgress(f2 / 1048576.0f, f3 / 1048576.0f, i);
                    }
                }

                public void onResponseSuccess(String str) {
                    PokerWebViewActivity.this.sendPokerAssetsSuccessEvent(str4, str5, i5, i6, z2);
                    if (FileInteractor.performWebAssetsFileOperationAfterDownload(PokerWebViewActivity.this.instance, String.valueOf(PokerWebViewActivity.this.mGameId), i5, i6)) {
                        PokerWebViewActivity.this.sendPokerAssetsInstallEvent(str4, str5, i5, i6, true, z2);
                        MSharedPreferencesUtils.saveIntInNormalPref(PokerWebViewActivity.this.instance, Constant.POKER_ZIP_VERSION, i5);
                        PokerWebViewActivity.this.makePokerLoadAPICall();
                        return;
                    }
                    PokerWebViewActivity.this.sendPokerAssetsInstallEvent(str4, str5, i5, i6, false, z2);
                    MLogger.d(IResponseListener.TAG, "onResponseSuccess:downloadFile Downloading is failed ");
                }
            };
            NetworkUtils.downloadFile(build, r1);
        } catch (Exception e2) {
            MLogger.e(TAG, "downloadFile", e2);
        }
    }

    private void downloadFileV2(String str, String str2, int i, int i2, boolean z) {
        int i3 = i;
        int i4 = i2;
        String str3 = str;
        String str4 = str2;
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("downloadFileV2() called with: downloadUrl = [", str, "], downloadingHash = [", str2, "], newVersion = [");
        outline82.append(i3);
        outline82.append("], oldVersion = [");
        outline82.append(i4);
        outline82.append("], isRetry = [");
        boolean z2 = z;
        MLogger.d(TAG, GeneratedOutlineSupport.outline66(outline82, z2, CMapParser.MARK_END_OF_ARRAY));
        sendPokerAssetsAvailableEvent(str, str2, i, i2, z);
        this.viewModel.syncWebViewFolder(i4, i3, this.mGameId);
        this.viewModel.setTournamentId(this.mRedirectionTournamentId);
        this.viewModel.prepareGameAssets(this.mGameId, str, this.gameName, i4, this.mAssetsVersion, str2, 0, z2);
        this.viewModel.prepareDownloadTaskParams();
        this.viewModel.initiatePokerDownload();
    }

    private void downloadPokerAssets(boolean z) {
        MLogger.d(TAG, "downloadPokerAssets: ");
        this.oldVersion = MSharedPreferencesUtils.getIntInNormalPref(this, Constant.POKER_ZIP_VERSION, 0);
        this.viewModel.setDownloadFileV2(AssetsUtils.isNewDownloaderPoker());
        if (this.viewModel.isDownloadFileV2()) {
            registerRecievers();
            registerWifiReceiver();
            if (!isDownLoadServiceCheckEnabled() || checkIfDownloadServiceIsEnabled()) {
                downloadFileV2(this.mAssetsDownloadUrl, "", this.mAssetsVersion, this.oldVersion, z);
                return;
            }
            initServiceCheck();
            return;
        }
        downloadFile(this.mAssetsDownloadUrl, "", this.mAssetsVersion, this.oldVersion, z);
    }

    public static Intent getLaunchingIntent(Activity activity) {
        MLogger.d(TAG, "getLaunchingIntent: ");
        Intent intent = new Intent(activity, PokerWebViewActivity.class);
        intent.addFlags(65536);
        intent.addFlags(131072);
        return intent;
    }

    /* access modifiers changed from: private */
    public void hideNetworkErrorText() {
        try {
            runOnUiThread(new Runnable() {
                public final void run() {
                    PokerWebViewActivity.this.lambda$hideNetworkErrorText$4$PokerWebViewActivity();
                }
            });
        } catch (Exception unused) {
        }
    }

    private void hideSystemUI() {
        MLogger.d(TAG, "hideSystemUI() called");
        if (getWindow() != null && getWindow().getDecorView() != null) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    private void initServiceCheck() {
        if (!checkIfDownloadServiceIsEnabled()) {
            DownloadMngServiceChkDialog downloadMngServiceChkDialog = new DownloadMngServiceChkDialog();
            downloadMngServiceChkDialog.setCallback(this);
            downloadMngServiceChkDialog.show(getSupportFragmentManager(), (String) DownloadMngServiceChkDialog.TAG_DOWNLOAD_SERVICE_DIALOG);
            return;
        }
        downloadPokerAssets(true);
    }

    private void initViews() {
        WebView webView = (WebView) findViewById(R.id.mpl_webview);
        this.mMPLWebView = webView;
        webView.setBackgroundColor(0);
        this.mMPLErrorView = (FrameLayout) findViewById(R.id.error_webview);
        this.mHeaderLayout = (RelativeLayout) findViewById(R.id.header_layout);
        this.mAssetsLoadingLayout = (ConstraintLayout) findViewById(R.id.assets_loading_layout);
        this.mAssetsProgress = (ProgressBar) findViewById(R.id.assets_download_progress);
        this.progressText = (AppCompatTextView) findViewById(R.id.progress_text);
        this.tipsText = (AppCompatTextView) findViewById(R.id.tips_text);
        this.networkErrorText = (AppCompatTextView) findViewById(R.id.network_error);
        setTipsText();
        this.header = (AppCompatTextView) findViewById(R.id.header);
        findViewById(R.id.webview_back).setOnClickListener(this);
        findViewById(R.id.webview_ok).setOnClickListener(this);
        this.mMPLWebView.setVisibility(8);
        this.mAssetsLoadingLayout.setVisibility(0);
        this.mHeaderLayout.setVisibility(0);
    }

    private boolean isAssetsAvailable() {
        boolean isWebViewBundleAvailable = FileUtils.isWebViewBundleAvailable(this, String.valueOf(this.mGameId), Constant.POKER_ASSETS_FOLDER_NAME, (long) this.mAssetsVersion);
        MLogger.d(TAG, "isAssetsAvailable: ", Boolean.valueOf(isWebViewBundleAvailable));
        return isWebViewBundleAvailable;
    }

    public static boolean isDownLoadServiceCheckEnabled() {
        if (ConfigManager.getPlatformConfig() == null || !ConfigManager.getPlatformConfig().optBoolean("game.change.download.method.pokerV2.isServiceCheckEnabled", false)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void loadFromLocalInWebView(JSONObject jSONObject) {
        MLogger.d(TAG, "loadFromLocalInWebView: ");
        runOnUiThread(new Runnable(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PokerWebViewActivity.this.lambda$loadFromLocalInWebView$5$PokerWebViewActivity(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public void makePokerLoadAPICall() {
        UtilWebGameEndToEndEvent.INSTANCE.gameApiInitiated(this.mGameId);
        PropertyTimeFour.INSTANCE.setStartPoint(System.currentTimeMillis());
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new MHeader("Authorization", "Bearer " + MSharedPreferencesUtils.getAccessUserToken()));
            if (this.mPostJsonData.has("Profile")) {
                this.mPostJsonData.remove("Profile");
            }
            if (this.mPostJsonData.has("assetsVersion")) {
                this.mPostJsonData.remove("assetsVersion");
            }
            if (this.mPostJsonData.has("assetsDownloadUrl")) {
                this.mPostJsonData.remove("assetsDownloadUrl");
            }
            if (this.mPostJsonData.has(PaymentConstants.CLIENT_ID_CAMEL)) {
                this.mPostJsonData.remove(PaymentConstants.CLIENT_ID_CAMEL);
            }
            if (this.mPostJsonData.has("userId")) {
                this.mPostJsonData.remove("userId");
            }
            final String str = MBuildConfigUtils.getMainUrl() + ApiEndPoints.POKER_API_CALL;
            NetworkUtils.doPostRequest(new Builder().setMHeaders(arrayList).setMRequestBody(this.mPostJsonData.toString()).setUrl(str).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setRetryOption(true).build(), new IResponseListener<String>() {
                public void onResponseFail(Exception exc) {
                    try {
                        MLogger.e(IResponseListener.TAG, "onFailure:makePokerLoadAPICall ");
                        String str = "";
                        if (!(exc == null || exc.getMessage() == null)) {
                            str = exc.getMessage();
                        }
                        PokerWebViewActivity pokerWebViewActivity = PokerWebViewActivity.this;
                        pokerWebViewActivity.showError("Fail in post call,makePokerLoadAPICall Reason:onFailure:" + str, str);
                    } catch (Exception unused) {
                        MLogger.e(IResponseListener.TAG, "onFailure:makePokerLoadAPICall ");
                        PokerWebViewActivity.this.showError("Fail in post call,makePokerLoadAPICall Reason:onFailure:", str);
                    }
                    UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(PokerWebViewActivity.this.mGameId, exc.getMessage());
                }

                public void progressResponse(long j, long j2, boolean z) {
                }

                public void onResponseSuccess(String str) {
                    try {
                        PropertyTimeFour.INSTANCE.logCtEvent(PokerWebViewActivity.this.mGameId);
                        MLogger.d(IResponseListener.TAG, "onResponse:postPokerData ", str);
                        if (PokerWebViewActivity.this.mMPLWebView == null) {
                            MLogger.e(IResponseListener.TAG, "onResponse:postPokerData:WebView is null");
                            PokerWebViewActivity.this.showError("onResponse:postPokerData:WebView is null", str);
                        } else if (NetworkUtils.isValidResponse(str)) {
                            JSONObject jSONObject = new JSONObject(str);
                            String str2 = null;
                            if (!jSONObject.isNull("payload")) {
                                str2 = jSONObject.optJSONObject("payload").optString("ebResponse", "");
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                JSONObject jSONObject2 = new JSONObject(str2);
                                String optString = jSONObject2.optJSONObject("data").optJSONObject("attributes").optString("redirect-url");
                                if (!TextUtils.isEmpty(optString)) {
                                    UtilWebGameEndToEndEvent.INSTANCE.gameApiSuccessful(PokerWebViewActivity.this.mGameId);
                                    PokerWebViewActivity.this.loadFromLocalInWebView(jSONObject2);
                                    return;
                                }
                                UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(PokerWebViewActivity.this.mGameId, "Response postPokerData:postPokerData: redirect url not found");
                                PokerWebViewActivity.this.showError("Response postPokerData:postPokerData: redirect url not found", optString);
                                return;
                            }
                            UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(PokerWebViewActivity.this.mGameId, "Response postPokerData:postPokerData: redirect url not found");
                            PokerWebViewActivity.this.showError("Response postPokerData:postPokerData: redirect url not found", str);
                        } else {
                            if (str == null) {
                                str = "";
                            }
                            String str3 = "Response fail:postPokerData: " + str;
                            UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(PokerWebViewActivity.this.mGameId, str3);
                            PokerWebViewActivity.this.showError(str3, str);
                        }
                    } catch (Exception e2) {
                        MLogger.e(IResponseListener.TAG, "onResponse:postPokerData:Exception ", e2);
                        if (!TextUtils.isEmpty(e2.getMessage())) {
                            PokerWebViewActivity.this.showError(e2.getMessage(), str);
                        } else {
                            PokerWebViewActivity.this.showError("postPokerData : Exception in loading response after post call", str);
                        }
                        PokerWebViewActivity.this.showToast("Something went wrong. Please re-start Game");
                        UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(PokerWebViewActivity.this.mGameId, e2.getMessage());
                    }
                }
            }, "poker_web_loading");
        } catch (Exception unused) {
            showError("Fail to get access token", "For Launching URL");
            UtilWebGameEndToEndEvent.INSTANCE.gameApiFailure(this.mGameId, "Fail to get access token");
        }
    }

    private void processWebLoading() {
        MLogger.d(TAG, "processWebLoading: ");
        try {
            if (getIntent() == null) {
                showError("Intent is null", "");
            } else {
                String stringExtra = getIntent().getStringExtra("postData");
                this.mBaseUrl = getIntent().getStringExtra(RNConstant.EXTRA_WEB_LOAD_URL);
                this.mGameId = getIntent().getIntExtra("gameId", 0);
                this.gameName = getIntent().getStringExtra("gameName");
                this.mConfigUrl = getIntent().getStringExtra(RNConstant.EXTRA_WEB_CONFIG_URL);
                this.mAuthHeader = getIntent().getStringExtra(RNConstant.EXTRA_WEB_LOAD_HEADER);
                this.mSecretKey = getIntent().getStringExtra(RNConstant.EXTRA_WEB_SECRET_KEY);
                this.mGameIconClickTime = getIntent().getLongExtra(RNConstant.EXTRA_GAME_ICON_CLICK_TIME, 0);
                this.mRedirectionType = getIntent().getStringExtra("type");
                this.mRedirectionTournamentId = getIntent().getStringExtra("tournamentId");
                this.mPostJsonData = null;
                if (stringExtra != null && !TextUtils.isEmpty(this.mBaseUrl) && !TextUtils.isEmpty(stringExtra)) {
                    if (CommonUtils.isJSONValid(stringExtra)) {
                        this.mPostJsonData = new JSONObject(stringExtra);
                        this.mUniqueSessionId = UUID.randomUUID() + "_" + MSharedPreferencesUtils.getUserIdInNormalPref(this.instance.getApplicationContext());
                        webViewSetting();
                        if (this.mPostJsonData != null) {
                            this.mAssetsVersion = this.mPostJsonData.optInt("assetsVersion", 0);
                            this.mAssetsDownloadUrl = this.mPostJsonData.optString("assetsDownloadUrl", "");
                            if (this.mPostJsonData.has("Profile")) {
                                JSONObject optJSONObject = this.mPostJsonData.optJSONObject("Profile");
                                if (optJSONObject != null && optJSONObject.has("displayName")) {
                                    this.mDisplayName = optJSONObject.optString("displayName", "");
                                }
                                if (optJSONObject != null && optJSONObject.has("avatar")) {
                                    this.mAvatar = optJSONObject.optString("avatar", "");
                                }
                            }
                        }
                        checkAssets(false);
                        UtilWebGameEndToEndEvent.INSTANCE.gameTileClicked(this.mGameId);
                    }
                }
                showError("Post data or loading url is empty", "");
                UtilWebGameEndToEndEvent.INSTANCE.gameTileClicked(this.mGameId);
            }
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                showError(e2.getMessage(), "");
            } else {
                showError("Parsing Error", "");
            }
        }
        acquireScreenWakeLock(this.instance);
    }

    /* access modifiers changed from: private */
    public void publishProgress(float f2, float f3, int i) {
        try {
            runOnUiThread(new Runnable(i, f3, f2) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ float f$2;
                public final /* synthetic */ float f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    PokerWebViewActivity.this.lambda$publishProgress$2$PokerWebViewActivity(this.f$1, this.f$2, this.f$3);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void redirectToHelpDesk() {
        try {
            Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("action", "OPEN_DEEP_LINK");
            intent.putExtra("actionTaken", "payment");
            bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Support\",\"param\":{\"supportType\":\"CHAT\",\"isDeepLink\":true,\"isPoker\":true,\"pokerGameId\":" + this.mGameId + "}}}");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }

    /* access modifiers changed from: private */
    public void redirectToLeaderBoard() {
        try {
            Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("action", "OPEN_DEEP_LINK");
            intent.putExtra("actionTaken", "LeaderBoard");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gameId", this.mGameId);
            jSONObject.put("fromScreen", PokerWebViewVm.GAME_NAME_POKER);
            jSONObject.put("from", PokerWebViewVm.GAME_NAME_POKER);
            bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GameLeaderboard\",\"param\":" + jSONObject.toString() + "}}");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }

    /* access modifiers changed from: private */
    public void redirectToLockedCashHomeScreen() {
        try {
            Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("action", "OPEN_DEEP_LINK");
            intent.putExtra("actionTaken", "LeaderBoard");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gameId", this.mGameId);
            jSONObject.put("fromScreen", PokerWebViewVm.GAME_NAME_POKER);
            jSONObject.put("from", PokerWebViewVm.GAME_NAME_POKER);
            bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LockedCashHomeScreen\",\"param\":" + jSONObject.toString() + "}}");
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }

    /* access modifiers changed from: private */
    public void redirectToReact(String str) {
        try {
            Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("action", "OPEN_DEEP_LINK");
            intent.putExtra("actionTaken", "payment");
            bundle.putString("actionParams", str);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }

    private void registerLiveData() {
        this.viewModel.getProgressLiveData().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PokerWebViewActivity.this.lambda$registerLiveData$10$PokerWebViewActivity((ProgressPokerData) obj);
            }
        });
        this.viewModel.getBooleanViewObserve().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PokerWebViewActivity.this.lambda$registerLiveData$11$PokerWebViewActivity((PokerViewData) obj);
            }
        });
        this.viewModel.getPokerAssetDownloadFailObserver().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PokerWebViewActivity.this.lambda$registerLiveData$12$PokerWebViewActivity((PokerDownloadAssetFailData) obj);
            }
        });
    }

    private void registerRecievers() {
        IntentFilter intentFilter = new IntentFilter(Constants.WEB_VIEW_ASSET_PROGRESS);
        intentFilter.addAction(Constants.WEB_VIEW_ASSET_PROGRESS_COMPLETE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.assetDownloadProgress, intentFilter);
    }

    private void registerWifiReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.paynimo.android.payment.util.Constant.INTENT_NETWORK_STATUS);
        registerReceiver(this.mWifiReceiver, intentFilter);
    }

    private void sendPokerAssetsAvailableEvent(String str, String str2, int i, int i2, boolean z) {
        try {
            GameAssets gameAssets = new GameAssets();
            gameAssets.setAssetVersion(i);
            gameAssets.setGameId(this.mGameId);
            gameAssets.setUrl(str);
            gameAssets.setGameName(TextUtils.isEmpty(this.gameName) ? PokerWebViewVm.GAME_NAME_POKER : this.gameName);
            gameAssets.setGameVersion(i2);
            gameAssets.setHash(str2);
            gameAssets.setSize(0);
            gameAssets.setRetry(z);
            UpdaterAnalytics.gameAssetsAvailableEvent(gameAssets.getGameName(), this.mGameId, false, gameAssets);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void sendPokerAssetsFailedEvent(String str, String str2, int i, int i2, boolean z, Exception exc) {
        try {
            GameAssets gameAssets = new GameAssets();
            gameAssets.setAssetVersion(i);
            gameAssets.setGameId(this.mGameId);
            gameAssets.setUrl(str);
            gameAssets.setGameName(TextUtils.isEmpty(this.gameName) ? PokerWebViewVm.GAME_NAME_POKER : this.gameName);
            gameAssets.setGameVersion(i2);
            gameAssets.setHash(str2);
            gameAssets.setSize(0);
            gameAssets.setRetry(z);
            UpdaterAnalytics.gameAssetsDownloadFailedEvent(gameAssets.getGameName(), this.mGameId, 0, false, gameAssets, exc);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void sendPokerAssetsInstallEvent(String str, String str2, int i, int i2, boolean z, boolean z2) {
        try {
            GameAssets gameAssets = new GameAssets();
            gameAssets.setAssetVersion(i);
            gameAssets.setGameId(this.mGameId);
            gameAssets.setUrl(str);
            gameAssets.setGameName(TextUtils.isEmpty(this.gameName) ? PokerWebViewVm.GAME_NAME_POKER : this.gameName);
            gameAssets.setGameVersion(i2);
            gameAssets.setHash(str2);
            gameAssets.setSize(0);
            gameAssets.setRetry(z2);
            UpdaterAnalytics.gameAssetsInstalledEvent(gameAssets.getGameName(), this.mGameId, gameAssets, z, false);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void sendPokerAssetsSuccessEvent(String str, String str2, int i, int i2, boolean z) {
        try {
            GameAssets gameAssets = new GameAssets();
            gameAssets.setAssetVersion(i);
            gameAssets.setGameId(this.mGameId);
            gameAssets.setUrl(str);
            gameAssets.setGameName(TextUtils.isEmpty(this.gameName) ? PokerWebViewVm.GAME_NAME_POKER : this.gameName);
            gameAssets.setGameVersion(i2);
            gameAssets.setHash(str2);
            gameAssets.setSize(0);
            gameAssets.setRetry(z);
            UpdaterAnalytics.gameAssetsDownloadedEvent(gameAssets.getGameName(), this.mGameId, 0, false, gameAssets);
        } catch (Exception unused) {
        }
    }

    private void sendWebLaunchEvent(JSONObject jSONObject) {
        try {
            CleverTapAnalyticsUtils.sendWebAppOpenEvent(Util.jsonToMap(jSONObject));
        } catch (Exception unused) {
        }
    }

    private void sendWebViewDisconnectedEvent(String str, String str2) {
        try {
            if (this.mPostJsonData != null) {
                this.mPostJsonData.put(EventsConstants.FAIL_REASON, str);
                this.mPostJsonData.put("App Start Fail Time", System.currentTimeMillis());
                this.mPostJsonData.put("Redirect Url", str2);
                this.mPostJsonData.put("Unique Session ID", this.mUniqueSessionId);
                if (this.mPostJsonData.has("oAuthToken")) {
                    this.mPostJsonData.remove("oAuthToken");
                }
                if (this.mPostJsonData.has("oAuth")) {
                    this.mPostJsonData.remove("oAuth");
                }
                if (this.mPostJsonData.has("Authorization")) {
                    this.mPostJsonData.remove("Authorization");
                }
                this.mPostJsonData.put("Game Name", TextUtils.isEmpty(this.gameName) ? PokerWebViewVm.GAME_NAME_POKER : this.gameName);
                this.mPostJsonData.put("Game ID", this.mGameId == 0 ? 1000167 : this.mGameId);
                CleverTapAnalyticsUtils.sendWebAppOpenFailedEvent(this.mPostJsonData);
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "sendWebViewDisconnectedEvent: ");
        }
    }

    private void setTipsText() {
        JSONArray jSONArray = null;
        try {
            if (!(ConfigManager.getNormalConfig() == null || ConfigManager.getNormalConfig().optJSONArray("poker.tips.messages") == null)) {
                jSONArray = ConfigManager.getNormalConfig().optJSONArray("poker.tips.messages");
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                jSONArray.put("Cards are randomly distributed to ensure fair gaming");
                jSONArray.put("Cards dealt are unpredictable, non-repeatable and uniformly distributed");
                jSONArray.put("RNG+ software ensures there is no tampering & no manual control");
                jSONArray.put("100% fair & no bots allowed");
                jSONArray.put("Our enhanced fraud detection systems ensure fair gaming");
                jSONArray.put("2,7 off suit is considered the worst hand in Poker");
                jSONArray.put("1 in every 17 hands, you can be dealt a pocket pair!");
                jSONArray.put("First versions of poker chips were made from ivory, wood, clay & bone");
                jSONArray.put("Early games of poker were played with a deck of just 20 cards");
                jSONArray.put("There are around 133 million possible 7 card combinations in NLH poker");
            }
            this.tipsText.setText(jSONArray.getString(new Random().nextInt(jSONArray.length())));
        } catch (Exception unused) {
            this.tipsText.setText("Cards are randomly distributed to ensure fair gaming");
        }
    }

    /* access modifiers changed from: private */
    public void showError(String str, String str2) {
        FrameLayout frameLayout = this.mMPLErrorView;
        if (frameLayout != null && frameLayout.getVisibility() != 0) {
            try {
                sendWebViewDisconnectedEvent(str, str2);
                runOnUiThread(new Runnable() {
                    public final void run() {
                        PokerWebViewActivity.this.lambda$showError$7$PokerWebViewActivity();
                    }
                });
            } catch (Exception unused) {
                MLogger.e(TAG, "showError: ");
            }
        }
    }

    /* access modifiers changed from: private */
    public void showNetworkErrorText() {
        try {
            runOnUiThread(new Runnable() {
                public final void run() {
                    PokerWebViewActivity.this.lambda$showNetworkErrorText$3$PokerWebViewActivity();
                }
            });
        } catch (Exception unused) {
        }
    }

    private void showOverlayDialog(String str, String str2, String str3, String str4) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
                    if (layoutInflater != null) {
                        View inflate = layoutInflater.inflate(R.layout.ok_cancel_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        AlertDialog.Builder builder = new AlertDialog.Builder(this.instance);
                        Typeface createFromAsset = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Bold.ttf");
                        Typeface createFromAsset2 = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/RobotoCondensed-Regular.ttf");
                        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
                        textView.setTypeface(createFromAsset);
                        textView.setText(str);
                        TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_msg);
                        textView2.setTypeface(createFromAsset2);
                        textView2.setText(str2);
                        Button button = (Button) inflate.findViewById(R.id.dialog_ok);
                        Button button2 = (Button) inflate.findViewById(R.id.dialog_cancel);
                        button.setTypeface(createFromAsset);
                        button2.setTypeface(createFromAsset);
                        button.setText(str3);
                        button2.setText(str4);
                        builder.setView(inflate);
                        builder.setCancelable(false);
                        AlertDialog create = builder.create();
                        button.setOnClickListener(new OnClickListener(create) {
                            public final /* synthetic */ AlertDialog f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                PokerWebViewActivity.this.lambda$showOverlayDialog$0$PokerWebViewActivity(this.f$1, view);
                            }
                        });
                        button2.setOnClickListener(new OnClickListener(create) {
                            public final /* synthetic */ AlertDialog f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                PokerWebViewActivity.this.lambda$showOverlayDialog$1$PokerWebViewActivity(this.f$1, view);
                            }
                        });
                        if (!isFinishing() && create != null && !create.isShowing()) {
                            create.show();
                            sendPopUpShownEvent();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            MLogger.e(TAG, "showDialog: ", e2);
        }
    }

    /* access modifiers changed from: private */
    public void showToast(String str) {
        runOnUiThread(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PokerWebViewActivity.this.lambda$showToast$6$PokerWebViewActivity(this.f$1);
            }
        });
    }

    private void unRegisterNetworkCheckReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (Exception e2) {
            MLogger.d(TAG, e2.getMessage());
        }
    }

    private void unRegisterRecievers() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.assetDownloadProgress);
    }

    private void updateHeaderUI(String str) {
        runOnUiThread(new Runnable(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PokerWebViewActivity.this.lambda$updateHeaderUI$9$PokerWebViewActivity(this.f$1);
            }
        });
    }

    private boolean verifyPermissions(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, SMTConfigConstants.WRITE_STORAGE_PERMISSION_MF_KEY) == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(activity, PERMISSIONS_REQ, 2);
        return false;
    }

    private void webViewSetting() {
        this.mMPLWebView.setBackgroundColor(0);
        this.mMPLWebView.setLayerType(2, null);
        WebSettings settings = this.mMPLWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        settings.setAppCacheEnabled(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(false);
        setMixedContentMode(this.mMPLWebView, "always");
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(true);
        settings.setBuiltInZoomControls(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDefaultTextEncodingName(WebViewGamesContainer.ENCODING_NAME);
        if (VERSION.SDK_INT >= 26) {
            this.mMPLWebView.setRendererPriorityPolicy(2, true);
        }
        if (CompoundButtonCompat.isFeatureSupported("FORCE_DARK")) {
            MLogger.d(TAG, "webViewSetting: Dark mode is on, Disabling it");
            CompoundButtonCompat.setForceDark(settings, 0);
        }
        this.mMPLWebView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void closeWeb() {
                MLogger.d(PokerWebViewActivity.TAG, "closeWebView: ");
                PokerWebViewActivity.this.closeWebView();
            }

            @JavascriptInterface
            public void closeWebViewWithReason(String str, String str2) {
                MLogger.d(PokerWebViewActivity.TAG, "closeWebViewWithReason: ");
                PokerWebViewActivity.this.showError(str, str2);
            }

            @JavascriptInterface
            public void openDeepLink(String str) {
                MLogger.d(PokerWebViewActivity.TAG, "openDeepLink: ", str);
                PokerWebViewActivity.this.redirectToReact(str);
            }

            @JavascriptInterface
            public void openLeaderBoard() {
                MLogger.d(PokerWebViewActivity.TAG, "openLeaderBoard: ");
                PokerWebViewActivity.this.redirectToLeaderBoard();
            }

            @JavascriptInterface
            public void performAction(final String str) {
                PokerWebViewActivity.this.runOnUiThread(new Runnable() {
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r4 = this;
                            java.lang.String r0 = r3
                            int r1 = r0.hashCode()
                            switch(r1) {
                                case -1989560243: goto L_0x005b;
                                case -1735624867: goto L_0x0051;
                                case -1635177780: goto L_0x0047;
                                case -790251142: goto L_0x003d;
                                case -564950136: goto L_0x0033;
                                case -339461814: goto L_0x0029;
                                case -100757501: goto L_0x001e;
                                case 64218584: goto L_0x0014;
                                case 831485225: goto L_0x000a;
                                default: goto L_0x0009;
                            }
                        L_0x0009:
                            goto L_0x0065
                        L_0x000a:
                            java.lang.String r1 = "ORIENTATION_SENSOR"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 2
                            goto L_0x0066
                        L_0x0014:
                            java.lang.String r1 = "CLOSE"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 3
                            goto L_0x0066
                        L_0x001e:
                            java.lang.String r1 = "APP_LOADED"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 8
                            goto L_0x0066
                        L_0x0029:
                            java.lang.String r1 = "ORIENTATION_PORTRAIT"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 1
                            goto L_0x0066
                        L_0x0033:
                            java.lang.String r1 = "LockedCashHomeScreen"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 7
                            goto L_0x0066
                        L_0x003d:
                            java.lang.String r1 = "helpDesk"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 5
                            goto L_0x0066
                        L_0x0047:
                            java.lang.String r1 = "ORIENTATION_LANDSCAPE"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 0
                            goto L_0x0066
                        L_0x0051:
                            java.lang.String r1 = "leaderBoard"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 6
                            goto L_0x0066
                        L_0x005b:
                            java.lang.String r1 = "CLOSE_WEB"
                            boolean r0 = r0.equals(r1)
                            if (r0 == 0) goto L_0x0065
                            r0 = 4
                            goto L_0x0066
                        L_0x0065:
                            r0 = -1
                        L_0x0066:
                            switch(r0) {
                                case 0: goto L_0x00c5;
                                case 1: goto L_0x00bb;
                                case 2: goto L_0x00b1;
                                case 3: goto L_0x00a9;
                                case 4: goto L_0x00a9;
                                case 5: goto L_0x00a1;
                                case 6: goto L_0x0099;
                                case 7: goto L_0x0091;
                                case 8: goto L_0x0083;
                                default: goto L_0x0069;
                            }
                        L_0x0069:
                            java.lang.String r0 = r3
                            java.lang.String r1 = "addMoney_"
                            boolean r0 = r0.contains(r1)
                            if (r0 == 0) goto L_0x00ce
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            java.lang.String r2 = r3
                            java.lang.String r3 = ""
                            java.lang.String r1 = r2.replace(r1, r3)
                            r0.startPayment(r1)
                            goto L_0x00ce
                        L_0x0083:
                            com.mpl.androidapp.webview.ct.utils.UtilWebGameEndToEndEvent r0 = com.mpl.androidapp.webview.ct.utils.UtilWebGameEndToEndEvent.INSTANCE
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r1 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r1 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            int r1 = r1.mGameId
                            r0.webGameLoadSuccessful(r1)
                            goto L_0x00ce
                        L_0x0091:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            r0.redirectToLockedCashHomeScreen()
                            goto L_0x00ce
                        L_0x0099:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            r0.redirectToLeaderBoard()
                            goto L_0x00ce
                        L_0x00a1:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            r0.redirectToHelpDesk()
                            goto L_0x00ce
                        L_0x00a9:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            r0.closeWebView()
                            goto L_0x00ce
                        L_0x00b1:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            java.lang.String r1 = "sensor"
                            r0.changeOrientation(r1)
                            goto L_0x00ce
                        L_0x00bb:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            java.lang.String r1 = "portrait"
                            r0.changeOrientation(r1)
                            goto L_0x00ce
                        L_0x00c5:
                            com.mpl.androidapp.webview.PokerWebViewActivity$4 r0 = com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.this
                            com.mpl.androidapp.webview.PokerWebViewActivity r0 = com.mpl.androidapp.webview.PokerWebViewActivity.this
                            java.lang.String r1 = "landscape"
                            r0.changeOrientation(r1)
                        L_0x00ce:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.webview.PokerWebViewActivity.AnonymousClass4.AnonymousClass1.run():void");
                    }
                });
            }

            @JavascriptInterface
            public void sendEvent(String str, String str2) {
                CleverTapAnalyticsUtils.sendEvent(str, str2);
            }
        }, WebViewGamesContainer.WEB_JAVASCRIPT_NAME);
        this.mMPLWebView.setDownloadListener(new DownloadListener() {
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                PokerWebViewActivity.this.lambda$webViewSetting$8$PokerWebViewActivity(str, str2, str3, str4, j);
            }
        });
        if (this.ebLoderEnabled) {
            this.mMPLWebView.setWebViewClient(new WebViewClient());
            return;
        }
        CustomWebViewCallback customWebViewCallback = new CustomWebViewCallback();
        customWebViewCallback.setCallback(this);
        customWebViewCallback.initiate(this.mMPLWebView);
    }

    public void cancelActionClicked() {
        finish();
    }

    public void closeWebView() {
        MLogger.e(TAG, "closeWebView");
        releaseScreenWakeLock();
        Handler handler = this.visibilityHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Intent intent = getIntent();
        intent.putExtra("isExamFinished", false);
        intent.putExtra("gameId", this.mGameId);
        if (this.mGameId != 788) {
            setResult(-1, intent);
            finish();
            return;
        }
        intent.putExtra("actionTaken", "homeRedirect");
        startActivity(intent);
    }

    public void downloadInvoice(String str, String str2, String str3, String str4, long j) {
        Request request = new Request(Uri.parse(str));
        request.setMimeType(str4);
        request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(str));
        request.addRequestHeader("User-Agent", str2);
        request.setDescription("Downloading file...");
        request.setTitle(URLUtil.guessFileName(str, str3, str4));
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str, str3, str4));
        ((DownloadManager) getSystemService(Constant.DOWNLOAD)).enqueue(request);
        showToast("Downloading File");
    }

    @ReactMethod
    public void enableDownloadManager() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            startActivity(intent);
            startActivityForResult(intent, 1002);
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    public void initViewModel() {
        this.viewModel = (PokerWebViewVm) new ViewModelProvider(this).get(PokerWebViewVm.class);
    }

    public void initiateSettings() {
        enableDownloadManager();
    }

    public /* synthetic */ void lambda$hideNetworkErrorText$4$PokerWebViewActivity() {
        this.networkErrorText.setVisibility(4);
    }

    public /* synthetic */ void lambda$loadFromLocalInWebView$5$PokerWebViewActivity(JSONObject jSONObject) {
        if (this.mMPLWebView != null) {
            File webViewBundleLoadingPath = FileUtils.webViewBundleLoadingPath(this.instance, String.valueOf(this.mGameId), Constant.POKER_ASSETS_FOLDER_NAME, (long) this.mAssetsVersion);
            String str = Uri.fromFile(webViewBundleLoadingPath).toString() + "?auth=" + jSONObject.optJSONObject("data").optString("id") + "&lang=en&configURL=" + this.mConfigUrl;
            if (!TextUtils.isEmpty(this.mRedirectionType)) {
                StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "&page=");
                outline78.append(this.mRedirectionType);
                str = outline78.toString();
            }
            if (!TextUtils.isEmpty(this.mRedirectionTournamentId)) {
                StringBuilder outline782 = GeneratedOutlineSupport.outline78(str, "&tournamentId=");
                outline782.append(this.mRedirectionTournamentId);
                str = outline782.toString();
            }
            StringBuilder outline783 = GeneratedOutlineSupport.outline78(str, "&ebLoderEnabled=");
            outline783.append(this.ebLoderEnabled);
            String sb = outline783.toString();
            sendWebLaunchEvent(jSONObject);
            UtilWebGameEndToEndEvent.INSTANCE.webGameLoadInitiated(this.mGameId);
            this.mMPLWebView.loadUrl(sb);
            boolean booleanInNormalPref = MSharedPreferencesUtils.getBooleanInNormalPref(this, "is_poker_first_launch", true);
            if (booleanInNormalPref) {
                MSharedPreferencesUtils.saveBooleanInNormalPref(this, "is_poker_first_launch", false);
            }
            this.visibilityHandler.sendEmptyMessageDelayed(0, (!booleanInNormalPref || !AssetsUtils.isPokerGameId(MBuildConfigUtils.getLaunchingGameId())) ? 4000 : 8000);
            return;
        }
        showError("loadFromLocalInWebView:postPokerData:WebView is null", "Error in loading URL");
    }

    public /* synthetic */ void lambda$publishProgress$2$PokerWebViewActivity(int i, float f2, float f3) {
        this.mAssetsProgress.setProgress(i);
        if (f2 > 0.0f) {
            this.progressText.setText(getString(R.string.poker_progress_description, new Object[]{Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(i)}));
            return;
        }
        this.progressText.setText(getString(R.string.poker_progress_description, new Object[]{Float.valueOf(f3), Double.valueOf(0.0d), Integer.valueOf(i)}));
    }

    public /* synthetic */ void lambda$registerLiveData$10$PokerWebViewActivity(ProgressPokerData progressPokerData) {
        if (progressPokerData != null) {
            publishProgress(((float) progressPokerData.getDownloaded()) / 1048576.0f, ((float) progressPokerData.getTotalSize()) / 1048576.0f, progressPokerData.getProgress());
        }
    }

    public /* synthetic */ void lambda$registerLiveData$11$PokerWebViewActivity(PokerViewData pokerViewData) {
        unRegisterRecievers();
        unRegisterNetworkCheckReceiver(this.mWifiReceiver);
        FileInteractor.getWebAssetsFolder(this, pokerViewData.getGameId(), pokerViewData.getNewVersion(), false);
        makePokerLoadAPICall();
    }

    public /* synthetic */ void lambda$registerLiveData$12$PokerWebViewActivity(PokerDownloadAssetFailData pokerDownloadAssetFailData) {
        deleteDownloadedAssets(pokerDownloadAssetFailData.getGameId(), pokerDownloadAssetFailData.getNewVersion());
        checkAssets(true);
    }

    public /* synthetic */ void lambda$showError$7$PokerWebViewActivity() {
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        FrameLayout frameLayout = this.mMPLErrorView;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    public /* synthetic */ void lambda$showNetworkErrorText$3$PokerWebViewActivity() {
        this.networkErrorText.setVisibility(0);
    }

    public /* synthetic */ void lambda$showOverlayDialog$0$PokerWebViewActivity(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
            closeWebView();
            sendButtonClickEvent("Okay");
        }
    }

    public /* synthetic */ void lambda$showOverlayDialog$1$PokerWebViewActivity(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
            sendButtonClickEvent("Cancel");
        }
    }

    public /* synthetic */ void lambda$showToast$6$PokerWebViewActivity(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    public /* synthetic */ void lambda$updateHeaderUI$9$PokerWebViewActivity(String str) {
        if ("sensor".equalsIgnoreCase(str) || SMTConfigConstants.SCREEN_ORIENTATION_LANDSCAPE.equalsIgnoreCase(str)) {
            this.mHeaderLayout.setVisibility(8);
        } else {
            this.mHeaderLayout.setVisibility(0);
        }
    }

    public /* synthetic */ void lambda$webViewSetting$8$PokerWebViewActivity(String str, String str2, String str3, String str4, long j) {
        if (verifyPermissions(this)) {
            downloadInvoice(str, str2, str3, str4, j);
            return;
        }
        this.mInvoiceUrl = str;
        this.mInvoiceUserAgent = str2;
        this.mInvoiceContentDisposition = str3;
        this.mInvoiceMimetype = str4;
        this.mInvoiceContentLength = j;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1002) {
            return;
        }
        if (!InternetConnectionInfo.INSTANCE.isNetworkAvailable(this)) {
            showError("Internet is disconnected after returning from download manager settings screen", "");
        } else if (isDownLoadServiceCheckEnabled()) {
            initServiceCheck();
        }
    }

    public void onBackPressed() {
        MLogger.d(TAG, "onBackPressed: ");
        WebView webView = this.mMPLWebView;
        if (webView == null) {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        } else if (webView.canGoBack()) {
            this.mMPLWebView.goBack();
        } else {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        }
    }

    public void onCancelClick() {
        closeWebView();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.webview_back /*2131363668*/:
                onWebViewBackClicked();
                return;
            case R.id.webview_ok /*2131363669*/:
                onWebViewOkClicked();
                return;
            default:
                return;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hideSystemUI();
    }

    public void onCreate(Bundle bundle) {
        hideSystemUI();
        super.onCreate(bundle);
        MLogger.d(TAG, "onCreate: ");
        this.ebLoderEnabled = ConfigManager.getPlatformConfig().optBoolean("ebLoderEnabled", true);
        PropertyTimeOne.INSTANCE.setStartPoint(System.currentTimeMillis());
        setContentView((int) R.layout.activity_poker_web_view);
        initViewModel();
        this.instance = this;
        initViews();
        processWebLoading();
        registerLiveData();
    }

    public void onDestroy() {
        closeWebView();
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.destroy();
            this.mMPLWebView = null;
        }
        getWindow().clearFlags(8192);
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    public void onError() {
        showError("Fail to download assets", "");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MLogger.d(TAG, "onNewIntent: ");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2 && iArr.length > 0 && iArr[0] == 0) {
            downloadInvoice(this.mInvoiceUrl, this.mInvoiceUserAgent, this.mInvoiceContentDisposition, this.mInvoiceMimetype, this.mInvoiceContentLength);
            return;
        }
        showToast("Permission not accepted!");
    }

    public void onRetryClick(ErrorDialogBottomSheet errorDialogBottomSheet2) {
        errorDialogBottomSheet2.dismissAllowingStateLoss();
        deleteDownloadedAssets();
        checkAssets(true);
    }

    public void onWebViewBackClicked() {
        showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
    }

    public void onWebViewOkClicked() {
        closeWebView();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        hideSystemUI();
    }

    public void releaseScreenWakeLock() {
        WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null && wakeLock2.isHeld()) {
            this.wakeLock.release();
        }
    }

    public void sendAppScreenViewEvent(String str, boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Screen Name", str);
            hashMap.put("Previous Screen Name", "App Home Screen");
            hashMap.put("Assets available", Boolean.valueOf(z));
            if (this.mGameIconClickTime != 0) {
                hashMap.put("User Wait Time", Long.valueOf(System.currentTimeMillis() - this.mGameIconClickTime));
            }
            CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.EVENT_APP_SCREEN_VIEWED, hashMap);
        } catch (Exception unused) {
        }
    }

    public void sendButtonClickEvent(String str) {
        HashMap hashMap = new HashMap();
        if (this.isPokerLoaded) {
            hashMap.put("Screen Name", "Exit Poker Lobby Screen");
        } else {
            hashMap.put("Screen Name", "Exit Poker Loading Screen");
        }
        hashMap.put(EventsConstants.CTA, str);
        CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
    }

    public void sendPopUpShownEvent() {
        HashMap hashMap = new HashMap();
        if (this.isPokerLoaded) {
            hashMap.put(EventsConstants.POP_UP_NAME, "Exit Poker Lobby Screen");
        } else {
            hashMap.put(EventsConstants.POP_UP_NAME, "Exit Poker Loading Screen");
        }
        CleverTapAnalyticsUtils.sendEvent((String) EventsConstants.POP_UP_SHOWN, hashMap);
    }

    public void setMixedContentMode(WebView webView, String str) {
        if (str == null || "never".equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if ("always".equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    public void startPayment(String str) {
        try {
            if (TextUtils.isDigitsOnly(str)) {
                Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
                Bundle bundle = new Bundle();
                this.mPostJsonData.put("startFor", "payment");
                bundle.putString("action", "OPEN_DEEP_LINK");
                intent.putExtra("actionTaken", "payment");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("entryFee", str);
                jSONObject.put("amount", str);
                jSONObject.put("from", Constant.POKER_DIR_NAME);
                jSONObject.put("gameId", this.mGameId);
                jSONObject.put("game", this.mPostJsonData);
                bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"AddMoney\",\"param\":" + jSONObject.toString() + "}}");
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                return;
            }
            Toast.makeText(this.instance, "Amount should be int", 1).show();
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }

    public void webViewLoading(boolean z) {
        this.mAssetsProgress.setIndeterminate(true);
        if (z) {
            this.mMPLWebView.setVisibility(8);
            this.mAssetsLoadingLayout.setVisibility(0);
            return;
        }
        this.mMPLWebView.setVisibility(0);
        this.mAssetsLoadingLayout.setVisibility(8);
    }

    private void deleteDownloadedAssets(int i, int i2) {
        if (isAssetsAvailable()) {
            MLogger.d(TAG, "onRetryClick: Assets Available");
            File webViewBundleOutputFile = FileUtils.getWebViewBundleOutputFile(this, String.valueOf(i), i2);
            if (webViewBundleOutputFile != null && webViewBundleOutputFile.exists()) {
                CommonUtils.deleteDir(webViewBundleOutputFile);
                MLogger.d(TAG, "onRetryClick: Assets Available, Deleting");
            }
        }
    }
}
