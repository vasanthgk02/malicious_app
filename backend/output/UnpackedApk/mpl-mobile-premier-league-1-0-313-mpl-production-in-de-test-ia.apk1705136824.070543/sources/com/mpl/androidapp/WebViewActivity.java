package com.mpl.androidapp;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.databinding.ActivityWebViewBinding;
import com.mpl.androidapp.react.RNConstant;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.DialogData;
import com.mpl.androidapp.utils.DialogData.TYPE;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.mpl.payment.braintree.BraintreeConstants;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.fontbox.cmap.CMapParser;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewActivity extends MPLBaseActivity implements OnClickListener {
    public static final String TAG = "MPLWebViewActivity";
    public JSONObject extraInfo;
    public String gameName;
    public WebViewActivity instance;
    public boolean isAudioSupport = false;
    public boolean isExamFinished = false;
    public boolean isRemoteVideoRendering;
    public boolean isVideoSupport = false;
    public String mAgoraId;
    public String mAuthHeader;
    public String mAvatar;
    public ActivityWebViewBinding mBinding;
    public int mChannelMemberCount;
    public String mChannelName;
    public String mDisplayName;
    public AlertDialog mFraudAlertDialog;
    public int mGameId;
    public WebView mMPLWebView;
    public JSONObject mPostJsonData;
    public boolean mResumeTimer = false;
    public long mTournamentId;
    public String mUniqueSessionId;
    public int mUserId;
    public boolean shouldCloseOnError = true;
    public boolean shouldParseJson;
    public WakeLock wakeLock;

    public class MPLWebViewClient extends WebViewClient {
        public MPLWebViewClient() {
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
            MLogger.d(WebViewActivity.TAG, "doUpdateVisitedHistory: ", str, Boolean.valueOf(z));
            if (str != null && !TextUtils.isEmpty(str) && (str.endsWith("/webview/thank-you") || str.endsWith("/webview/close"))) {
                WebViewActivity.this.isExamFinished = true;
                WebViewActivity.this.closeWebView();
            } else if (str != null && !TextUtils.isEmpty(str) && str.endsWith("/webview/close-app")) {
                WebViewActivity.this.closeWebView();
            } else if (str != null && !TextUtils.isEmpty(str) && str.endsWith("/thankyou")) {
                WebViewActivity.this.closeWebView();
            } else if (str != null && !TextUtils.isEmpty(str) && str.contains("/addMoney")) {
                String[] split = str.split("/");
                if (split != null && split.length > 0 && split[split.length - 1] != null) {
                    String str2 = split[split.length - 1];
                    MLogger.d(WebViewActivity.TAG, "amount to add", str2);
                    if (TextUtils.isDigitsOnly(str2)) {
                        WebViewActivity.this.startPayment(split[split.length - 1]);
                        return;
                    }
                    MLogger.d(WebViewActivity.TAG, "Amount should be int found: ", str2);
                    Toast.makeText(WebViewActivity.this.getApplicationContext(), "Amount should be int", 1).show();
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            MLogger.d(WebViewActivity.TAG, "onPageFinished: ");
            if (WebViewActivity.this.mBinding.loadingProgress != null) {
                WebViewActivity.this.mBinding.loadingProgress.setVisibility(8);
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                if (str.endsWith("/webview/thank-you") || str.endsWith("/webview/close")) {
                    WebViewActivity.this.closeWebView();
                }
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            MLogger.d(WebViewActivity.TAG, "onPageStarted: ", str);
            webView.setBackgroundColor(0);
            webView.setLayerType(2, null);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (WebViewActivity.this.mGameId != 55 && WebViewActivity.this.mGameId != 788 && WebViewActivity.this.shouldCloseOnError) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                webViewActivity.showError(i + ":onReceivedError:" + str, str2);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? "" : webResourceRequest.getUrl().toString();
            if (webResourceResponse == null) {
                str = "Something went wrong";
            } else if (webResourceResponse.getReasonPhrase() != null) {
                str = webResourceResponse.getStatusCode() + ":onReceivedHttpError:" + webResourceResponse.getReasonPhrase();
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("onReceivedHttpError ");
                outline73.append(webResourceResponse.getStatusCode());
                str = outline73.toString();
            }
            if (WebViewActivity.this.mGameId != 55 && WebViewActivity.this.mGameId != 788 && WebViewActivity.this.shouldCloseOnError) {
                WebViewActivity.this.showError(str, uri);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            MLogger.d(WebViewActivity.TAG, "onReceivedSslError: ");
            if (sslError != null) {
                try {
                    WebViewActivity webViewActivity = WebViewActivity.this;
                    webViewActivity.showError("onReceivedSslError: " + sslError, sslError.getUrl());
                } catch (Exception unused) {
                    WebViewActivity.this.showError("Something went wrong in onReceivedSslError", "");
                }
            } else {
                WebViewActivity.this.showError("Something went wrong", "");
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            MLogger.d(WebViewActivity.TAG, "onRenderProcessGone: ");
            if (VERSION.SDK_INT < 26 || renderProcessGoneDetail.didCrash()) {
                if (!(WebViewActivity.this.mGameId == 55 || WebViewActivity.this.mGameId == 788)) {
                    WebViewActivity.this.showError("onRenderProcessGone", "");
                }
                return false;
            }
            if (!(WebViewActivity.this.mGameId == 55 || WebViewActivity.this.mGameId == 788)) {
                WebViewActivity.this.showError("System killed the WebView rendering process to reclaim memory. Recreating...", "");
            }
            return true;
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            MLogger.d(WebViewActivity.TAG, "onReceivedError: ");
            String str = "";
            String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? str : webResourceRequest.getUrl().toString();
            if (webResourceError != null) {
                if (VERSION.SDK_INT < 23) {
                    str = "Something went wrong in onReceivedError";
                } else if (webResourceError.getDescription() != null) {
                    str = webResourceError.getErrorCode() + ":onReceivedError:" + webResourceError.getDescription().toString();
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("onReceivedError");
                    outline73.append(webResourceError.getErrorCode());
                    str = outline73.toString();
                }
            }
            MLogger.d(WebViewActivity.TAG, "onReceivedError: ", str);
            MLogger.t(WebViewActivity.this.instance, 0, str);
            if (WebViewActivity.this.mGameId != 55 && WebViewActivity.this.mGameId != 788 && WebViewActivity.this.shouldCloseOnError) {
                WebViewActivity.this.showError(str, uri);
            }
        }
    }

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
    public void initWebViewLoadAfterPostCall(final JSONObject jSONObject, final String str) {
        MLogger.d(TAG, "initWebViewLoadAfterPostCall: ", jSONObject, str);
        runOnUiThread(new Runnable() {
            public void run() {
                WebViewActivity webViewActivity = WebViewActivity.this;
                if (webViewActivity.mMPLWebView != null) {
                    if (webViewActivity.mGameId == 1000053) {
                        WebViewActivity.this.mMPLWebView.clearCache(true);
                    }
                    WebViewActivity.this.mMPLWebView.loadUrl(jSONObject.optString("url"));
                    return;
                }
                webViewActivity.showError("WebView is null", str);
            }
        });
    }

    public static /* synthetic */ void lambda$showOverlayDialog$2(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private void openSettingApplication() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    private void sendWebViewDisconnectedEvent(String str, String str2) {
        try {
            MLogger.d(TAG, "sendWebViewDisconnectedEvent: ", str, str2);
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
                CleverTapAnalyticsUtils.sendWebAppOpenFailedEvent(this.mPostJsonData);
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "sendWebViewDisconnectedEvent: ");
        }
    }

    private void showAlertDialog(AlertDialog alertDialog) {
        if (!isFinishing() && alertDialog != null && !alertDialog.isShowing()) {
            alertDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public void showError(String str, String str2) {
        FrameLayout frameLayout = this.mBinding.errorWebview;
        if (frameLayout != null && frameLayout.getVisibility() != 0) {
            try {
                MLogger.d(TAG, "showError() called with: failReason = [" + str + "], redirectUrl = [" + str2 + CMapParser.MARK_END_OF_ARRAY);
                sendWebViewDisconnectedEvent(str, str2);
                runOnUiThread(new Runnable() {
                    public final void run() {
                        WebViewActivity.this.lambda$showError$0$WebViewActivity();
                    }
                });
            } catch (Exception unused) {
                MLogger.e(TAG, "showError: ");
            }
        }
    }

    private void showOverlayDialog(String str, String str2, String str3, String str4) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
                    if (layoutInflater != null) {
                        View inflate = layoutInflater.inflate(R.layout.ok_cancel_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        Builder builder = new Builder(this.instance);
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
                                WebViewActivity.this.lambda$showOverlayDialog$1$WebViewActivity(this.f$1, view);
                            }
                        });
                        button2.setOnClickListener(new OnClickListener(create) {
                            public final /* synthetic */ AlertDialog f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void onClick(View view) {
                                WebViewActivity.lambda$showOverlayDialog$2(this.f$0, view);
                            }
                        });
                        showAlertDialog(create);
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
                WebViewActivity.this.lambda$showToast$3$WebViewActivity(this.f$1);
            }
        });
    }

    private void suspiciousAppsFound(DialogData dialogData) {
        try {
            if (!isFinishing()) {
                if (!isDestroyed()) {
                    if (this.mFraudAlertDialog == null || !this.mFraudAlertDialog.isShowing()) {
                        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.suspicious_app_found_dialog, (ViewGroup) findViewById(R.id.error_root_dialog));
                        Builder builder = new Builder(this);
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
                        this.mFraudAlertDialog = builder.create();
                        button.setOnClickListener(new OnClickListener(dialogData) {
                            public final /* synthetic */ DialogData f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onClick(View view) {
                                WebViewActivity.this.lambda$suspiciousAppsFound$4$WebViewActivity(this.f$1, view);
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

    public void FullScreenCall() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public void closeWebView() {
        MLogger.e(TAG, "closeWebView");
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        WebView webView = this.mMPLWebView;
        if (!(webView == null || this.mGameId == 788)) {
            webView.stopLoading();
            this.mMPLWebView.clearFocus();
            this.mMPLWebView.clearCache(true);
            this.mMPLWebView.clearFormData();
            this.mMPLWebView.clearHistory();
            this.mMPLWebView.clearMatches();
            this.mMPLWebView.onPause();
        }
        releaseScreenWakeLock();
        Intent intent = getIntent();
        intent.putExtra("isExamFinished", this.isExamFinished);
        intent.putExtra("gameId", this.mGameId);
        if (this.mGameId != 788) {
            setResult(-1, intent);
            finish();
            return;
        }
        intent.putExtra("actionTaken", "homeRedirect");
        startActivity(intent);
    }

    public /* synthetic */ void lambda$showError$0$WebViewActivity() {
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.setVisibility(8);
        }
        FrameLayout frameLayout = this.mBinding.errorWebview;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        ProgressBar progressBar = this.mBinding.loadingProgress;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$showOverlayDialog$1$WebViewActivity(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
            closeWebView();
        }
    }

    public /* synthetic */ void lambda$showToast$3$WebViewActivity(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    public /* synthetic */ void lambda$suspiciousAppsFound$4$WebViewActivity(DialogData dialogData, View view) {
        AlertDialog alertDialog = this.mFraudAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!dialogData.isShouldCloseApp()) {
            openSettingApplication();
        } else {
            System.exit(0);
        }
    }

    public void onBackPressed() {
        if (this.mGameId != 788 || this.mMPLWebView == null || !MSharedPreferencesUtils.shouldHandleBackButtonFromWebView()) {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        } else if (!this.mMPLWebView.canGoBack()) {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        } else if (this.mMPLWebView.getOriginalUrl().endsWith("/new ")) {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        } else if (this.mMPLWebView.copyBackForwardList() == null || this.mMPLWebView.copyBackForwardList().getCurrentIndex() != 1) {
            this.mMPLWebView.goBack();
        } else {
            showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.webview_back /*2131363668*/:
                showOverlayDialog(getString(R.string.webview_close_title), getString(R.string.webview_close_message), getString(R.string.okay), getString(R.string.cancel));
                return;
            case R.id.webview_ok /*2131363669*/:
                closeWebView();
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFlags(8192, 8192);
        getWindow().addFlags(128);
        super.onCreate(bundle);
        MLogger.d(TAG, "onCreate: ");
        setTheme(R.style.AppThemeUnity);
        ActivityWebViewBinding inflate = ActivityWebViewBinding.inflate(LayoutInflater.from(this));
        this.mBinding = inflate;
        setContentView((View) inflate.getRoot());
        this.mMPLWebView = this.mBinding.mplWebview;
        this.instance = this;
        try {
            if (getIntent() == null) {
                showError("Intent is null", "");
            } else {
                Intent intent = getIntent();
                String str = TAG;
                String stringExtra = intent.getStringExtra("postData");
                Intent intent2 = getIntent();
                String str2 = BraintreeConstants.NS_EXTRAINFO;
                String stringExtra2 = intent2.getStringExtra(RNConstant.EXTRA_WEB_LOAD_URL);
                String str3 = "shouldParseJson";
                String str4 = "shouldCloseOnError";
                this.mGameId = getIntent().getIntExtra("gameId", 0);
                String stringExtra3 = getIntent().getStringExtra("gameName");
                this.gameName = stringExtra3;
                if (TextUtils.isEmpty(stringExtra3)) {
                    this.mBinding.gameName.setText(MBuildConfigUtils.getAppName());
                } else {
                    this.mBinding.gameName.setText(this.gameName);
                }
                this.mAuthHeader = getIntent().getStringExtra(RNConstant.EXTRA_WEB_LOAD_HEADER);
                getIntent().getStringExtra(RNConstant.EXTRA_USER_AUTH);
                this.mPostJsonData = null;
                if (stringExtra != null && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra)) {
                    if (CommonUtils.isJSONValid(stringExtra)) {
                        this.mPostJsonData = new JSONObject(stringExtra);
                        this.mUniqueSessionId = UUID.randomUUID() + "_" + MSharedPreferencesUtils.getUserIdInNormalPref(this.instance.getApplicationContext());
                        if (this.mPostJsonData != null) {
                            if (this.mPostJsonData.has("TournamentId") && this.mPostJsonData.optLong("TournamentId", -1) > 0) {
                                this.mTournamentId = this.mPostJsonData.optLong("TournamentId", -1);
                            }
                            if (this.mPostJsonData.has("IsAudioSupport")) {
                                this.isAudioSupport = this.mPostJsonData.optBoolean("IsAudioSupport", false);
                            }
                            if (this.mPostJsonData.has("IsVideoSupport")) {
                                this.isVideoSupport = this.mPostJsonData.optBoolean("IsVideoSupport", false);
                            }
                            if (this.mPostJsonData.has("AgoraId") && !TextUtils.isEmpty(this.mPostJsonData.optString("AgoraId"))) {
                                this.mAgoraId = this.mPostJsonData.optString("AgoraId", "");
                            }
                            if (this.mPostJsonData.has("BattleId") && this.mPostJsonData.optLong("BattleId", -1) > 0) {
                                this.mTournamentId = this.mPostJsonData.optLong("BattleId", -1);
                            }
                            if (this.mPostJsonData.has("ResumeTimer") && this.mPostJsonData.optBoolean("ResumeTimer", false)) {
                                this.mResumeTimer = this.mPostJsonData.optBoolean("ResumeTimer", false);
                            }
                            this.mUserId = MSharedPreferencesUtils.getUserIdInNormalPref(this.instance.getApplicationContext());
                            if (this.mPostJsonData.has("Profile")) {
                                JSONObject optJSONObject = this.mPostJsonData.optJSONObject("Profile");
                                if (optJSONObject != null && optJSONObject.has("displayName")) {
                                    this.mDisplayName = optJSONObject.optString("displayName", "");
                                }
                                if (optJSONObject != null && optJSONObject.has("avatar")) {
                                    this.mAvatar = optJSONObject.optString("avatar", "");
                                }
                            }
                            String str5 = str4;
                            if (this.mPostJsonData.has(str5)) {
                                this.shouldCloseOnError = this.mPostJsonData.optBoolean(str5, true);
                            }
                            String str6 = str3;
                            if (this.mPostJsonData.has(str6)) {
                                this.shouldParseJson = this.mPostJsonData.optBoolean(str6, false);
                            }
                            String str7 = str2;
                            if (this.mPostJsonData.has(str7) && !TextUtils.isEmpty(this.mPostJsonData.getString(str7)) && CommonUtils.isJSONValid(this.mPostJsonData.getString(str7))) {
                                JSONObject jSONObject = new JSONObject(this.mPostJsonData.getString(str7));
                                this.extraInfo = jSONObject;
                                if (jSONObject != null) {
                                    if (jSONObject.has(str5)) {
                                        this.shouldCloseOnError = this.extraInfo.optBoolean(str5, true);
                                    }
                                    if (this.extraInfo.has(str6)) {
                                        this.shouldParseJson = this.extraInfo.optBoolean(str6, false);
                                    }
                                    if (this.extraInfo.has("AgoraId")) {
                                        this.mAgoraId = this.extraInfo.optString("AgoraId");
                                    }
                                    if (this.extraInfo.has("IsAudioSupport")) {
                                        this.isAudioSupport = this.extraInfo.optBoolean("IsAudioSupport", false);
                                    }
                                    if (this.extraInfo.has("IsVideoSupport")) {
                                        this.isVideoSupport = this.extraInfo.optBoolean("IsVideoSupport", false);
                                    }
                                }
                            }
                        }
                        if (!this.shouldParseJson) {
                            this.shouldParseJson = ConfigManager.shouldParseResponse(this.mGameId);
                        }
                        if (MBuildConfigUtils.isLogEnabled()) {
                            getWindow().clearFlags(8192);
                        }
                        MLogger.d(str, "onCreate: ", "shouldCloseOnError: ", Boolean.valueOf(this.shouldCloseOnError), "shouldParseJson:", Boolean.valueOf(this.shouldParseJson));
                        this.mMPLWebView.setBackgroundColor(0);
                        this.mMPLWebView.setLayerType(2, null);
                        if (this.mGameId == 788) {
                            this.mMPLWebView.getSettings().setLoadsImagesAutomatically(true);
                            this.mMPLWebView.getSettings().setAppCacheEnabled(true);
                            this.mMPLWebView.getSettings().setAllowFileAccess(true);
                            this.mMPLWebView.getSettings().setAllowFileAccessFromFileURLs(true);
                            this.mMPLWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);
                            this.mMPLWebView.getSettings().setCacheMode(-1);
                            this.mMPLWebView.getSettings().setDatabaseEnabled(true);
                            getWindow().clearFlags(8192);
                        } else {
                            this.mMPLWebView.getSettings().setAppCacheEnabled(false);
                            this.mMPLWebView.getSettings().setAllowFileAccess(false);
                            this.mMPLWebView.getSettings().setAllowFileAccessFromFileURLs(false);
                            this.mMPLWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
                            this.mMPLWebView.getSettings().setCacheMode(2);
                            this.mMPLWebView.getSettings().setDatabaseEnabled(false);
                            this.mMPLWebView.clearFormData();
                            this.mMPLWebView.clearHistory();
                            this.mMPLWebView.clearMatches();
                            this.mMPLWebView.clearSslPreferences();
                            this.mMPLWebView.clearCache(true);
                        }
                        this.mMPLWebView.setVisibility(0);
                        this.mMPLWebView.setBackgroundColor(0);
                        this.mMPLWebView.getSettings().setJavaScriptEnabled(true);
                        this.mMPLWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                        this.mMPLWebView.getSettings().setDomStorageEnabled(true);
                        this.mMPLWebView.getSettings().setLoadWithOverviewMode(true);
                        this.mMPLWebView.getSettings().setUseWideViewPort(true);
                        this.mMPLWebView.getSettings().setBuiltInZoomControls(false);
                        this.mMPLWebView.getSettings().setSupportZoom(false);
                        this.mMPLWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                        this.mMPLWebView.getSettings().setPluginState(PluginState.ON_DEMAND);
                        this.mMPLWebView.setWebViewClient(new MPLWebViewClient());
                        this.mMPLWebView.setOverScrollMode(1);
                        this.mMPLWebView.setScrollBarStyle(0);
                        this.mMPLWebView.setBackgroundColor(Color.argb(1, 0, 0, 0));
                        this.mMPLWebView.setWebChromeClient(new WebChromeClient() {
                            public void onCloseWindow(WebView webView) {
                                super.onCloseWindow(webView);
                                MLogger.d(WebViewActivity.TAG, "WebChromeClient", "onWebChromeClient", "onCloseWindow: ");
                                WebViewActivity.this.closeWebView();
                            }

                            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                                if (consoleMessage == null || consoleMessage.message() == null || TextUtils.isEmpty(consoleMessage.message()) || !consoleMessage.message().contains("close webView")) {
                                    return super.onConsoleMessage(consoleMessage);
                                }
                                WebViewActivity.this.closeWebView();
                                return false;
                            }

                            public void onPermissionRequest(PermissionRequest permissionRequest) {
                                if (permissionRequest != null) {
                                    permissionRequest.grant(permissionRequest.getResources());
                                }
                            }
                        });
                        this.mMPLWebView.addJavascriptInterface(new Object() {
                            @JavascriptInterface
                            public void closeWebView() {
                                MLogger.d(WebViewActivity.TAG, "closeWebView: ");
                                WebViewActivity.this.showError("Closed by client", "No Url specified");
                            }

                            @JavascriptInterface
                            public void closeWebViewWithReason(String str, String str2) {
                                MLogger.d(WebViewActivity.TAG, "closeWebViewWithReason: ");
                                WebViewActivity.this.showError(str, str2);
                            }

                            @JavascriptInterface
                            public int getMemberCount() {
                                MLogger.d(WebViewActivity.TAG, "getMemberCount: ", Integer.valueOf(WebViewActivity.this.mChannelMemberCount));
                                return WebViewActivity.this.mChannelMemberCount;
                            }

                            @JavascriptInterface
                            public void performAction(final String str) {
                                MLogger.d(WebViewActivity.TAG, "performAction: ", str);
                                WebViewActivity.this.runOnUiThread(new Runnable() {
                                    /* Code decompiled incorrectly, please refer to instructions dump. */
                                    public void run() {
                                        /*
                                            r4 = this;
                                            java.lang.String r0 = r4
                                            int r1 = r0.hashCode()
                                            r2 = 10
                                            r3 = 9
                                            switch(r1) {
                                                case -1989581158: goto L_0x0076;
                                                case -1780933082: goto L_0x006b;
                                                case -768410510: goto L_0x0060;
                                                case -291070982: goto L_0x0056;
                                                case -209991475: goto L_0x004c;
                                                case -3141713: goto L_0x0042;
                                                case 125409947: goto L_0x0038;
                                                case 138424729: goto L_0x002e;
                                                case 505428372: goto L_0x0024;
                                                case 599349077: goto L_0x001a;
                                                case 1552621278: goto L_0x000f;
                                                default: goto L_0x000d;
                                            }
                                        L_0x000d:
                                            goto L_0x0081
                                        L_0x000f:
                                            java.lang.String r1 = "HIDE_CHAT_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 4
                                            goto L_0x0082
                                        L_0x001a:
                                            java.lang.String r1 = "HIDE_VIDEO_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 3
                                            goto L_0x0082
                                        L_0x0024:
                                            java.lang.String r1 = "SHOW_ALL_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 2
                                            goto L_0x0082
                                        L_0x002e:
                                            java.lang.String r1 = "SHOW_CHAT_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 0
                                            goto L_0x0082
                                        L_0x0038:
                                            java.lang.String r1 = "CLOSE_STREAMING"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 6
                                            goto L_0x0082
                                        L_0x0042:
                                            java.lang.String r1 = "HIDE_ALL_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 5
                                            goto L_0x0082
                                        L_0x004c:
                                            java.lang.String r1 = "CLOSE_CHATTING"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 7
                                            goto L_0x0082
                                        L_0x0056:
                                            java.lang.String r1 = "SHOW_VIDEO_UI"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 1
                                            goto L_0x0082
                                        L_0x0060:
                                            java.lang.String r1 = "CLOSE_WEBVIEW"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 9
                                            goto L_0x0082
                                        L_0x006b:
                                            java.lang.String r1 = "SHOW_ERROR"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 10
                                            goto L_0x0082
                                        L_0x0076:
                                            java.lang.String r1 = "CLOSE_ALL"
                                            boolean r0 = r0.equals(r1)
                                            if (r0 == 0) goto L_0x0081
                                            r0 = 8
                                            goto L_0x0082
                                        L_0x0081:
                                            r0 = -1
                                        L_0x0082:
                                            if (r0 == r3) goto L_0x0093
                                            if (r0 == r2) goto L_0x0087
                                            goto L_0x0098
                                        L_0x0087:
                                            com.mpl.androidapp.WebViewActivity$2 r0 = com.mpl.androidapp.WebViewActivity.AnonymousClass2.this
                                            com.mpl.androidapp.WebViewActivity r0 = com.mpl.androidapp.WebViewActivity.this
                                            java.lang.String r1 = "Closed by App"
                                            java.lang.String r2 = "default url"
                                            r0.showError(r1, r2)
                                            goto L_0x0098
                                        L_0x0093:
                                            com.mpl.androidapp.WebViewActivity$2 r0 = com.mpl.androidapp.WebViewActivity.AnonymousClass2.this
                                            r0.closeWebView()
                                        L_0x0098:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.WebViewActivity.AnonymousClass2.AnonymousClass1.run():void");
                                    }
                                });
                            }

                            @JavascriptInterface
                            public void sendContentSize(float f2, float f3) {
                            }

                            @JavascriptInterface
                            public void sendEvent(String str, String str2) {
                                MLogger.d(WebViewActivity.TAG, "sendEvent: ", str, str2);
                                CleverTapAnalyticsUtils.sendEvent(str, str2);
                            }
                        }, WebViewGamesContainer.WEB_JAVASCRIPT_NAME);
                        if (TextUtils.isEmpty(this.mAgoraId)) {
                            this.mAgoraId = getString(R.string.private_app_id);
                        }
                        postURL(stringExtra2, this.mPostJsonData);
                    }
                }
                showError("Post data or loading url is empty", "");
            }
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                showError(e2.getMessage(), "");
            } else {
                showError("Parsing Error", "");
            }
        }
        acquireScreenWakeLock(this.instance);
        this.mBinding.webviewOk.setOnClickListener(this);
        this.mBinding.webviewBack.setOnClickListener(this);
    }

    public void onDestroy() {
        MLogger.d(TAG, "onDestroy: ");
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.destroy();
            this.mMPLWebView = null;
        }
        getWindow().clearFlags(8192);
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        MLogger.d(TAG, "onPause: ");
        WebView webView = this.mMPLWebView;
        if (webView != null && this.mGameId != 788) {
            webView.onPause();
            this.mMPLWebView.pauseTimers();
            this.mMPLWebView.stopLoading();
        }
    }

    public void onResume() {
        super.onResume();
        MLogger.d(TAG, "onResume: ");
        FullScreenCall();
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.onResume();
        }
        if (this.mMPLWebView == null) {
            return;
        }
        if (this.mResumeTimer || this.mGameId == 96) {
            this.mMPLWebView.resumeTimers();
        }
    }

    public void onStop() {
        super.onStop();
        int i = this.mGameId;
        if (i == 55) {
            if (MSharedPreferencesUtils.shouldCloseWebViewOnPause()) {
                MLogger.d(TAG, "onStop: ", "Closing exam WebView");
                closeWebView();
            } else {
                MLogger.d(TAG, "onStop: ", "Not closing exam WebView");
            }
        } else if (i != 788) {
            closeWebView();
        } else if (MSharedPreferencesUtils.shouldCloseFantasyWebViewOnPause()) {
            MLogger.d(TAG, "onStop: ", "Closing Fantasy WebView");
            closeWebView();
        } else {
            MLogger.d(TAG, "onStop: ", "Not closing exam WebView");
        }
        MLogger.d(TAG, "onStop: ");
    }

    public void postURL(String str, JSONObject jSONObject) {
        Object obj;
        String str2;
        final String str3;
        char c2;
        char c3;
        String str4;
        String str5 = str;
        JSONObject jSONObject2 = jSONObject;
        Request.Builder builder = new Request.Builder();
        int i = this.mGameId;
        if (i == 1000053) {
            builder.addHeader("Auth-Q", this.mAuthHeader);
            builder.addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
            str3 = str5;
            obj = "postURL";
            str2 = TAG;
        } else {
            obj = "postURL";
            String str6 = TAG;
            if (i == 55) {
                builder.addHeader("client", "mpl");
                builder.addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
                builder.addHeader("Authorization", this.mAuthHeader);
                str3 = str;
            } else {
                String str7 = "Authorization";
                String str8 = "User id is zero";
                String str9 = "contestId";
                if (i == 788) {
                    builder.addHeader("client", "mpl");
                    builder.addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
                    builder.addHeader("key", this.mAuthHeader);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("user_id", jSONObject2.optInt("userId", 0));
                        jSONObject3.put(Constant.PROFILE, jSONObject2.optJSONObject("Profile"));
                        if (jSONObject2.has("oAuthToken")) {
                            jSONObject3.put("oAuthToken", jSONObject2.optString("oAuthToken", ""));
                        } else if (jSONObject2.has("oAuth")) {
                            jSONObject3.put("oAuthToken", jSONObject2.optString("oAuth", ""));
                        }
                        if (jSONObject2.has("matchId")) {
                            jSONObject3.put("matchId", jSONObject2.optInt("matchId"));
                        }
                        String str10 = str9;
                        if (jSONObject2.has(str10)) {
                            jSONObject3.put(str10, jSONObject2.optInt(str10));
                        }
                        if (jSONObject3.optInt("user_id") == 0) {
                            String str11 = str8;
                            Toast.makeText(getApplicationContext(), str11, 0).show();
                            str4 = str;
                            try {
                                showError(str11, str4);
                                return;
                            } catch (Exception e2) {
                                e = e2;
                                Toast.makeText(getApplicationContext(), "Parse Exception", 0).show();
                                showError("Parse Exception", str4);
                                MLogger.e(str6, "postURL: ", e);
                                return;
                            }
                        } else {
                            str3 = str;
                            jSONObject2 = jSONObject3;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str4 = str;
                        Toast.makeText(getApplicationContext(), "Parse Exception", 0).show();
                        showError("Parse Exception", str4);
                        MLogger.e(str6, "postURL: ", e);
                        return;
                    }
                } else {
                    str3 = str;
                    str2 = str6;
                    builder.addHeader("client", "mpl");
                    builder.addHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE);
                    builder.addHeader("key", this.mAuthHeader);
                    builder.addHeader(str7, this.mAuthHeader);
                    try {
                        if (jSONObject2.has("Profile") && !jSONObject2.has(Constant.PROFILE)) {
                            jSONObject2.put(Constant.PROFILE, jSONObject2.optJSONObject("Profile"));
                        }
                    } catch (JSONException unused) {
                        MLogger.e(str2, obj);
                    }
                }
            }
            str2 = str6;
        }
        builder.url(str3);
        try {
            jSONObject2.put("UniqueSessionId", this.mUniqueSessionId);
            c3 = 1;
            c2 = 0;
        } catch (JSONException unused2) {
            c3 = 1;
            c2 = 0;
            MLogger.e(str2, obj);
        }
        Object[] objArr = new Object[4];
        objArr[c2] = "postURL:Url ";
        objArr[c3] = str3;
        objArr[2] = "postData: ";
        objArr[3] = jSONObject2;
        MLogger.d(str2, objArr);
        builder.post(RequestBody.create(MediaType.parse(DefaultSettingsSpiCall.ACCEPT_JSON_VALUE), jSONObject2.toString().getBytes()));
        Request build = builder.build();
        OkHttpClient.Builder builder2 = new OkHttpClient.Builder();
        builder2.readTimeout(30000, TimeUnit.MILLISECONDS);
        builder2.writeTimeout(30000, TimeUnit.MILLISECONDS);
        builder2.connectTimeout(30000, TimeUnit.MILLISECONDS);
        builder2.retryOnConnectionFailure(true);
        FirebasePerfOkHttpClient.enqueue(builder2.build().newCall(build), new Callback() {
            public /* synthetic */ void lambda$onResponse$0$WebViewActivity$3(String str) {
                WebViewActivity.this.mMPLWebView.loadData(str, "text/html; charset=utf-8", WebViewGamesContainer.ENCODING_NAME);
            }

            public /* synthetic */ void lambda$onResponse$1$WebViewActivity$3(Response response, String str) {
                WebViewActivity webViewActivity = WebViewActivity.this;
                if (webViewActivity.mMPLWebView != null) {
                    if (webViewActivity.mGameId == 1000053) {
                        WebViewActivity.this.mMPLWebView.clearCache(true);
                    }
                    WebViewActivity.this.mMPLWebView.loadUrl(response.request().url().toString());
                    return;
                }
                webViewActivity.showError("onResponse:WebView is null", str);
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x0043 A[Catch:{ Exception -> 0x005c }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onFailure(okhttp3.Call r8, java.io.IOException r9) {
                /*
                    r7 = this;
                    java.lang.String r0 = "Fail in post call, Reason:onFailure:"
                    java.lang.String r1 = "onFailure: "
                    java.lang.String r2 = "MPLWebViewActivity"
                    r3 = 0
                    r4 = 1
                    java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x005c }
                    r5[r3] = r1     // Catch:{ Exception -> 0x005c }
                    com.mpl.androidapp.utils.MLogger.e(r2, r5)     // Catch:{ Exception -> 0x005c }
                    okhttp3.Request r5 = r8.request()     // Catch:{ Exception -> 0x005c }
                    java.lang.String r6 = ""
                    if (r5 == 0) goto L_0x003c
                    okhttp3.Request r5 = r8.request()     // Catch:{ Exception -> 0x005c }
                    okhttp3.HttpUrl r5 = r5.url()     // Catch:{ Exception -> 0x005c }
                    if (r5 == 0) goto L_0x003c
                    okhttp3.Request r5 = r8.request()     // Catch:{ Exception -> 0x005c }
                    okhttp3.HttpUrl r5 = r5.url()     // Catch:{ Exception -> 0x005c }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005c }
                    if (r5 == 0) goto L_0x003c
                    okhttp3.Request r8 = r8.request()     // Catch:{ Exception -> 0x005c }
                    okhttp3.HttpUrl r8 = r8.url()     // Catch:{ Exception -> 0x005c }
                    java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x005c }
                    goto L_0x003d
                L_0x003c:
                    r8 = r6
                L_0x003d:
                    java.lang.String r5 = r9.getMessage()     // Catch:{ Exception -> 0x005c }
                    if (r5 == 0) goto L_0x0047
                    java.lang.String r6 = r9.getMessage()     // Catch:{ Exception -> 0x005c }
                L_0x0047:
                    com.mpl.androidapp.WebViewActivity r9 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x005c }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
                    r5.<init>()     // Catch:{ Exception -> 0x005c }
                    r5.append(r0)     // Catch:{ Exception -> 0x005c }
                    r5.append(r6)     // Catch:{ Exception -> 0x005c }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005c }
                    r9.showError(r5, r8)     // Catch:{ Exception -> 0x005c }
                    goto L_0x006a
                L_0x005c:
                    java.lang.Object[] r8 = new java.lang.Object[r4]
                    r8[r3] = r1
                    com.mpl.androidapp.utils.MLogger.e(r2, r8)
                    com.mpl.androidapp.WebViewActivity r8 = com.mpl.androidapp.WebViewActivity.this
                    java.lang.String r9 = r4
                    r8.showError(r0, r9)
                L_0x006a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.WebViewActivity.AnonymousClass3.onFailure(okhttp3.Call, java.io.IOException):void");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:22:0x009c, code lost:
                if (r1.optInt("status") != 200) goto L_0x009e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a8, code lost:
                if (r1.optInt("code") == 200) goto L_0x00aa;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ae, code lost:
                if (r1.has("url") == false) goto L_0x00c3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b8, code lost:
                if (android.text.TextUtils.isEmpty(r1.optString("url")) != false) goto L_0x00c3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ba, code lost:
                com.mpl.androidapp.WebViewActivity.access$500(r9.this$0, r1, r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResponse(okhttp3.Call r10, okhttp3.Response r11) {
                /*
                    r9 = this;
                    java.lang.String r10 = "code"
                    java.lang.String r0 = "status"
                    java.lang.String r1 = "onResponse:WebView is null"
                    java.lang.String r2 = "onResponse: "
                    java.lang.String r3 = "MPLWebViewActivity"
                    r4 = 2
                    r5 = 0
                    r6 = 1
                    java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x014d }
                    r7[r5] = r2     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.d(r3, r7)     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.WebViewActivity r7 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    android.webkit.WebView r7 = r7.mMPLWebView     // Catch:{ Exception -> 0x014d }
                    if (r7 != 0) goto L_0x002a
                    java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x014d }
                    r10[r5] = r1     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.e(r3, r10)     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = r4     // Catch:{ Exception -> 0x014d }
                    r10.showError(r1, r11)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x002a:
                    boolean r1 = r11.isSuccessful()     // Catch:{ Exception -> 0x014d }
                    if (r1 == 0) goto L_0x0119
                    com.mpl.androidapp.WebViewActivity r1 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    int r1 = r1.mGameId     // Catch:{ Exception -> 0x014d }
                    r7 = 788(0x314, float:1.104E-42)
                    if (r1 != r7) goto L_0x0073
                    okhttp3.ResponseBody r10 = r11.body()     // Catch:{ Exception -> 0x014d }
                    if (r10 == 0) goto L_0x005f
                    okhttp3.ResponseBody r10 = r11.body()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r10 = r10.string()     // Catch:{ Exception -> 0x014d }
                    java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x014d }
                    r11[r5] = r2     // Catch:{ Exception -> 0x014d }
                    r11[r6] = r10     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.d(r3, r11)     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.WebViewActivity r11 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    android.webkit.WebView r11 = r11.mMPLWebView     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.-$$Lambda$WebViewActivity$3$dahlvG3baRxppG6ykv2wPnYrPts r0 = new com.mpl.androidapp.-$$Lambda$WebViewActivity$3$dahlvG3baRxppG6ykv2wPnYrPts     // Catch:{ Exception -> 0x014d }
                    r0.<init>(r10)     // Catch:{ Exception -> 0x014d }
                    r11.post(r0)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x005f:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = "Response is null"
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x014d }
                    r10.showError(r11, r0)     // Catch:{ Exception -> 0x014d }
                    java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = "onResponse:response body is null "
                    r10[r5] = r11     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.e(r3, r10)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x0073:
                    com.mpl.androidapp.WebViewActivity r1 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    boolean r1 = r1.shouldParseJson     // Catch:{ Exception -> 0x014d }
                    if (r1 == 0) goto L_0x010a
                    okhttp3.ResponseBody r1 = r11.body()     // Catch:{ Exception -> 0x014d }
                    if (r1 == 0) goto L_0x00f6
                    okhttp3.ResponseBody r11 = r11.body()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = r11.string()     // Catch:{ Exception -> 0x014d }
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x014d }
                    r1.<init>(r11)     // Catch:{ Exception -> 0x014d }
                    boolean r2 = r1.has(r0)     // Catch:{ Exception -> 0x014d }
                    r7 = 200(0xc8, float:2.8E-43)
                    java.lang.String r8 = "url"
                    if (r2 == 0) goto L_0x009e
                    int r0 = r1.optInt(r0)     // Catch:{ Exception -> 0x014d }
                    if (r0 == r7) goto L_0x00aa
                L_0x009e:
                    boolean r0 = r1.has(r10)     // Catch:{ Exception -> 0x014d }
                    if (r0 == 0) goto L_0x00c3
                    int r10 = r1.optInt(r10)     // Catch:{ Exception -> 0x014d }
                    if (r10 != r7) goto L_0x00c3
                L_0x00aa:
                    boolean r10 = r1.has(r8)     // Catch:{ Exception -> 0x014d }
                    if (r10 == 0) goto L_0x00c3
                    java.lang.String r10 = r1.optString(r8)     // Catch:{ Exception -> 0x014d }
                    boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x014d }
                    if (r10 != 0) goto L_0x00c3
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = r4     // Catch:{ Exception -> 0x014d }
                    r10.initWebViewLoadAfterPostCall(r1, r11)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x00c3:
                    boolean r10 = r1.has(r8)     // Catch:{ Exception -> 0x014d }
                    if (r10 == 0) goto L_0x00dc
                    java.lang.String r10 = r1.optString(r8)     // Catch:{ Exception -> 0x014d }
                    boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x014d }
                    if (r10 != 0) goto L_0x00dc
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = r4     // Catch:{ Exception -> 0x014d }
                    r10.initWebViewLoadAfterPostCall(r1, r11)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x00dc:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
                    r0.<init>()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r1 = "onResponse:Redirect url is null after post call:"
                    r0.append(r1)     // Catch:{ Exception -> 0x014d }
                    r0.append(r11)     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = r0.toString()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x014d }
                    r10.showError(r11, r0)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x00f6:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = "onResponse:Response is null"
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x014d }
                    r10.showError(r11, r0)     // Catch:{ Exception -> 0x014d }
                    java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x014d }
                    java.lang.String r11 = "onResponse:response body is null"
                    r10[r5] = r11     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.e(r3, r10)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x010a:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    android.webkit.WebView r10 = r10.mMPLWebView     // Catch:{ Exception -> 0x014d }
                    java.lang.String r0 = r4     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.-$$Lambda$WebViewActivity$3$jzCDsJaxNLBA72K3BMWIiTNKJWM r1 = new com.mpl.androidapp.-$$Lambda$WebViewActivity$3$jzCDsJaxNLBA72K3BMWIiTNKJWM     // Catch:{ Exception -> 0x014d }
                    r1.<init>(r11, r0)     // Catch:{ Exception -> 0x014d }
                    r10.post(r1)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x0119:
                    java.lang.String r10 = ""
                    okhttp3.ResponseBody r0 = r11.body()     // Catch:{ Exception -> 0x014d }
                    if (r0 == 0) goto L_0x0129
                    okhttp3.ResponseBody r10 = r11.body()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r10 = r10.string()     // Catch:{ Exception -> 0x014d }
                L_0x0129:
                    com.mpl.androidapp.WebViewActivity r11 = com.mpl.androidapp.WebViewActivity.this     // Catch:{ Exception -> 0x014d }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
                    r0.<init>()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r1 = "Response fail: "
                    r0.append(r1)     // Catch:{ Exception -> 0x014d }
                    r0.append(r10)     // Catch:{ Exception -> 0x014d }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x014d }
                    java.lang.String r1 = r4     // Catch:{ Exception -> 0x014d }
                    r11.showError(r0, r1)     // Catch:{ Exception -> 0x014d }
                    java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x014d }
                    java.lang.String r0 = "onResponse:Response fail "
                    r11[r5] = r0     // Catch:{ Exception -> 0x014d }
                    r11[r6] = r10     // Catch:{ Exception -> 0x014d }
                    com.mpl.androidapp.utils.MLogger.e(r3, r11)     // Catch:{ Exception -> 0x014d }
                    goto L_0x017f
                L_0x014d:
                    r10 = move-exception
                    java.lang.Object[] r11 = new java.lang.Object[r4]
                    java.lang.String r0 = "onResponse:Exception "
                    r11[r5] = r0
                    r11[r6] = r10
                    com.mpl.androidapp.utils.MLogger.e(r3, r11)
                    java.lang.String r11 = r10.getMessage()
                    boolean r11 = android.text.TextUtils.isEmpty(r11)
                    if (r11 != 0) goto L_0x016f
                    com.mpl.androidapp.WebViewActivity r11 = com.mpl.androidapp.WebViewActivity.this
                    java.lang.String r10 = r10.getMessage()
                    java.lang.String r0 = r4
                    r11.showError(r10, r0)
                    goto L_0x0178
                L_0x016f:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this
                    java.lang.String r11 = r4
                    java.lang.String r0 = "Exception in loading response after post call"
                    r10.showError(r0, r11)
                L_0x0178:
                    com.mpl.androidapp.WebViewActivity r10 = com.mpl.androidapp.WebViewActivity.this
                    java.lang.String r11 = "Something went wrong. Please re-start Game"
                    r10.showToast(r11)
                L_0x017f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.WebViewActivity.AnonymousClass3.onResponse(okhttp3.Call, okhttp3.Response):void");
            }
        });
    }

    public void releaseScreenWakeLock() {
        WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            MLogger.d(TAG, "releaseScreenWakeLock: ", Boolean.valueOf(wakeLock2.isHeld()));
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
        }
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

    public void startPayment(String str) {
    }
}
