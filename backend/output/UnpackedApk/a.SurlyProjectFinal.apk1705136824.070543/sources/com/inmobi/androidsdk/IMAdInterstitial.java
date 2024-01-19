package com.inmobi.androidsdk;

import a.SurlyProjectFinal.R;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.controller.util.Utils;
import com.inmobi.androidsdk.impl.AdUnit;
import com.inmobi.androidsdk.impl.AdUnit.AdTypes;
import com.inmobi.androidsdk.impl.ConfigConstants;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType;

public class IMAdInterstitial {
    private static final int LISTENER_EVENT_AD_REQUEST_FAILED = 101;
    private static final int LISTENER_EVENT_AD_REQUEST_LOADED = 100;
    private static final int LISTENER_EVENT_DISMISS_AD_SCREEN = 103;
    private static final int LISTENER_EVENT_LEAVE_AD_SCREEN = 104;
    private static final int LISTENER_EVENT_SHOW_AD_SCREEN = 102;
    private static final int MSG_INTERSTITIAL_CLOSED = 304;
    private static final int MSG_INTERSTITIAL_READY = 303;
    private static final int REFRESH_INTERVAL_MINIMUM = 20;
    private String baseUrlString = ("http://www.inmobi.com/" + Integer.toString(Utils.incrementBaseUrl()) + "/");
    /* access modifiers changed from: private */
    public IMWebViewListener imWebViewListener = new IMWebViewListener() {
        public boolean onReady() {
            return false;
        }

        public boolean onResize() {
            return false;
        }

        public boolean onExpand() {
            IMAdInterstitial.this.state = State.ACTIVE;
            IMAdInterstitial.this.performCallbackNotification(102, null);
            return false;
        }

        public boolean onExpandClose() {
            return false;
        }

        public boolean onResizeClose() {
            return false;
        }

        public boolean onEventFired() {
            return false;
        }

        public boolean onLeaveApplication() {
            IMAdInterstitial.this.performCallbackNotification(IMAdInterstitial.LISTENER_EVENT_LEAVE_AD_SCREEN, null);
            return false;
        }

        public boolean onDismissAdScreen() {
            IMAdInterstitial.this.performCallbackNotification(IMAdInterstitial.LISTENER_EVENT_DISMISS_AD_SCREEN, null);
            return false;
        }

        public boolean onShowScreen() {
            IMAdInterstitial.this.performCallbackNotification(102, null);
            return false;
        }

        public void handleRequest(String url) {
        }
    };
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public AdUnit mAdUnit;
    private String mAppId;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case IMAdInterstitial.MSG_INTERSTITIAL_READY /*303*/:
                    IMAdInterstitial.this.state = State.READY;
                    IMAdInterstitial.this.performCallbackNotification(100, null);
                    return;
                case IMAdInterstitial.MSG_INTERSTITIAL_CLOSED /*304*/:
                    IMAdInterstitial.this.state = State.INIT;
                    IMAdInterstitial.this.performCallbackNotification(IMAdInterstitial.LISTENER_EVENT_DISMISS_AD_SCREEN, null);
                    IMAdInterstitial.this.mIMWebView = null;
                    return;
                default:
                    return;
            }
        }
    };
    private HttpRequestCallback mHttpReqCallback = new HttpRequestCallback() {
        public void notifyResult(int status, final Object data) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, ">>> Got HTTP REQUEST callback. Status: " + status + " ,data=" + data);
            }
            if (status == 0) {
                IMAdInterstitial.this.mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            IMAdInterstitial.this.mAdUnit = (AdUnit) data;
                            if (IMAdInterstitial.this.mIMWebView == null) {
                                IMAdInterstitial.this.mIMWebView = new IMWebView(IMAdInterstitial.this.mActivity, IMAdInterstitial.this.imWebViewListener, true, false);
                            }
                            IMAdInterstitial.this.loadAd(IMAdInterstitial.this.mAdUnit);
                        } catch (Exception e) {
                            if (Constants.DEBUG) {
                                Log.d(Constants.LOGGING_TAG, "Error retriving ad", e);
                            }
                            IMAdInterstitial.this.state = State.INIT;
                            IMAdInterstitial.this.performCallbackNotification(101, ErrorCode.INTERNAL_ERROR);
                        }
                    }
                });
            } else if (status == 1) {
                IMAdInterstitial.this.state = State.INIT;
                IMAdInterstitial.this.performCallbackNotification(101, (ErrorCode) data);
            }
        }
    };
    /* access modifiers changed from: private */
    public IMAdInterstitialListener mIMAdInterstitialListener;
    private IMAdRequest mIMAdRequest;
    /* access modifiers changed from: private */
    public IMWebView mIMWebView;
    private UserInfo mUserInfo;
    /* access modifiers changed from: private */
    public long prevAdFetchTimestamp = 0;
    /* access modifiers changed from: private */
    public State state = State.INIT;

    public enum State {
        INIT,
        READY,
        LOADING,
        ACTIVE
    }

    public IMAdInterstitial(Activity activity, String appId) {
        if (activity == null) {
            throw new NullPointerException("activity cannot be null");
        } else if (appId == null) {
            throw new NullPointerException("site-id cannot be null");
        } else if (appId.trim().equalsIgnoreCase(Constants.QA_SERVER_URL)) {
            throw new IllegalArgumentException("site-id cannot be empty");
        } else {
            this.mActivity = activity;
            this.mAppId = appId;
            updateUserInfo();
        }
    }

    public State getState() {
        return this.state;
    }

    public void loadNewAd(IMAdRequest imAdRequest) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, " ");
            Log.e(Constants.LOGGING_TAG, ">>>> Start loading new Interstitial Ad <<<<");
        }
        if (!canShowAd(imAdRequest)) {
            performCallbackNotification(101, ErrorCode.INVALID_REQUEST);
        } else if (this.state == State.LOADING) {
            performCallbackNotification(101, ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
        } else if (this.state == State.ACTIVE) {
            Log.w(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_ACTIVE);
            performCallbackNotification(101, ErrorCode.INVALID_REQUEST);
        } else {
            this.state = State.LOADING;
            this.mIMAdRequest = imAdRequest;
            updateUserInfo();
            new RequestResponseManager(this.mActivity).asyncRequestAd(this.mUserInfo, ActionType.AdRequest_Interstitial, this.mHttpReqCallback);
        }
    }

    private boolean canShowAd(IMAdRequest imAdrequest) {
        boolean testMode;
        long currTime = System.currentTimeMillis();
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Time gap: " + (currTime - this.prevAdFetchTimestamp));
        }
        if (currTime - this.prevAdFetchTimestamp < 20000) {
            Log.v(Constants.LOGGING_TAG, "Ad cannot be refreshed now, as the minimum refresh interval is20 seconds.");
            return false;
        }
        if (imAdrequest == null) {
            testMode = false;
        } else {
            testMode = imAdrequest.isTestMode();
        }
        if (0 != 0 || testMode || Utils.validateAppId(this.mAppId)) {
            return true;
        }
        return false;
    }

    private void updateUserInfo() {
        if (this.mUserInfo == null) {
            this.mUserInfo = new UserInfo(this.mActivity);
            DisplayMetrics metrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            float density = metrics.density;
            Display display = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();
            this.mUserInfo.setScreenDensity(String.valueOf(density));
            this.mUserInfo.setScreenSize(width + "X" + height);
            try {
                if (this.mUserInfo.getPhoneDefaultUserAgent().equals(Constants.QA_SERVER_URL)) {
                    this.mUserInfo.setPhoneDefaultUserAgent(new WebView(this.mActivity).getSettings().getUserAgentString());
                }
            } catch (Exception e) {
                Log.w(Constants.LOGGING_TAG, "Exception occured while setting user agent" + e);
            }
        }
        this.mUserInfo.updateInfo(this.mAppId, this.mIMAdRequest);
        int adSlotSize = 14;
        if (VERSION.SDK_INT == 11 || VERSION.SDK_INT == 12 || VERSION.SDK_INT == 13) {
            adSlotSize = 17;
        }
        this.mUserInfo.setAdUnitSlot(String.valueOf(adSlotSize));
    }

    public void show() {
        try {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Showing the Interstitial Ad.");
            }
            if (this.state != State.READY) {
                throw new IllegalStateException("Interstitial ad is not in the 'READY' state. Current state: " + this.state);
            } else if (this.mAdUnit != null) {
                this.mIMWebView.setAdUnit(this.mAdUnit);
                this.mIMWebView.requestOnInterstitialClosed(this.mHandler.obtainMessage(MSG_INTERSTITIAL_CLOSED));
                this.mIMWebView.changeContentAreaForInterstitials();
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Error showing ad", e);
            }
        }
    }

    public IMAdInterstitialListener getImAdInterstitialListener() {
        return this.mIMAdInterstitialListener;
    }

    public void setImAdInterstitialListener(IMAdInterstitialListener imAdInterstitialListener) {
        this.mIMAdInterstitialListener = imAdInterstitialListener;
    }

    /* access modifiers changed from: private */
    public void performCallbackNotification(final int event, final ErrorCode errorCode) {
        if (this.mIMAdInterstitialListener != null) {
            this.mActivity.runOnUiThread(new Runnable() {
                private static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode;

                static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode() {
                    int[] iArr = $SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode;
                    if (iArr == null) {
                        iArr = new int[ErrorCode.values().length];
                        try {
                            iArr[ErrorCode.AD_CLICK_IN_PROGRESS.ordinal()] = 3;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[ErrorCode.AD_DOWNLOAD_IN_PROGRESS.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        try {
                            iArr[ErrorCode.INTERNAL_ERROR.ordinal()] = 5;
                        } catch (NoSuchFieldError e3) {
                        }
                        try {
                            iArr[ErrorCode.INVALID_REQUEST.ordinal()] = 1;
                        } catch (NoSuchFieldError e4) {
                        }
                        try {
                            iArr[ErrorCode.NETWORK_ERROR.ordinal()] = 4;
                        } catch (NoSuchFieldError e5) {
                        }
                        try {
                            iArr[ErrorCode.NO_FILL.ordinal()] = 6;
                        } catch (NoSuchFieldError e6) {
                        }
                        $SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode = iArr;
                    }
                    return iArr;
                }

                public void run() {
                    switch (event) {
                        case 100:
                            IMAdInterstitial.this.prevAdFetchTimestamp = System.currentTimeMillis();
                            IMAdInterstitial.this.mIMAdInterstitialListener.onAdRequestLoaded(IMAdInterstitial.this);
                            return;
                        case 101:
                            switch ($SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode()[errorCode.ordinal()]) {
                                case 2:
                                    Log.i(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_DOWNLOAD);
                                    break;
                                case R.styleable.com_cauly_android_ad_AdView_age /*3*/:
                                    Log.i(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_CLICK);
                                    break;
                            }
                            IMAdInterstitial.this.mIMAdInterstitialListener.onAdRequestFailed(IMAdInterstitial.this, errorCode);
                            return;
                        case 102:
                            IMAdInterstitial.this.mIMAdInterstitialListener.onShowAdScreen(IMAdInterstitial.this);
                            return;
                        case IMAdInterstitial.LISTENER_EVENT_DISMISS_AD_SCREEN /*103*/:
                            IMAdInterstitial.this.mIMAdInterstitialListener.onDismissAdScreen(IMAdInterstitial.this);
                            return;
                        case IMAdInterstitial.LISTENER_EVENT_LEAVE_AD_SCREEN /*104*/:
                            IMAdInterstitial.this.mIMAdInterstitialListener.onLeaveApplication(IMAdInterstitial.this);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void loadAd(AdUnit newAd) {
        if (newAd != null && AdTypes.NONE != newAd.getAdType() && newAd.getCDATABlock() != null) {
            String htmlString = new StringBuffer(newAd.getCDATABlock()).toString().replaceAll("%", "%25");
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Final HTML String: " + htmlString);
            }
            this.mIMWebView.requestOnPageFinishedCallback(this.mHandler.obtainMessage(MSG_INTERSTITIAL_READY));
            this.mIMWebView.loadDataWithBaseURL(this.baseUrlString, "<html><head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,maximum-scale=1\"><meta http-equiv=\"Content-Type\" content=\"text/html charset=utf-16le\"></head><body style=\"margin:0;padding:0\">" + htmlString + "</body></html>", "text/html", null, this.baseUrlString);
        }
    }
}
