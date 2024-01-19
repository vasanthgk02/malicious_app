package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.IMAdRequest.ErrorCode;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.container.IMWebView.ViewState;
import com.inmobi.androidsdk.ai.controller.util.Utils;
import com.inmobi.androidsdk.impl.AdUnit;
import com.inmobi.androidsdk.impl.AdUnit.AdActionNames;
import com.inmobi.androidsdk.impl.AdUnit.AdTypes;
import com.inmobi.androidsdk.impl.ClickProcessingTask;
import com.inmobi.androidsdk.impl.ConfigConstants;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.UserInfo;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import com.inmobi.androidsdk.impl.net.RequestResponseManager.ActionType;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IMAdView extends RelativeLayout {
    public static final int INMOBI_AD_UNIT_120X600 = 13;
    public static final int INMOBI_AD_UNIT_300X250 = 10;
    public static final int INMOBI_AD_UNIT_320X48 = 9;
    public static final int INMOBI_AD_UNIT_320X50 = 15;
    public static final int INMOBI_AD_UNIT_468X60 = 12;
    public static final int INMOBI_AD_UNIT_728X90 = 11;
    public static final String INMOBI_INTERNAL_TAG = "ref-__in__rt";
    public static final String INMOBI_REF_TAG = "ref-tag";
    private static final int LISTENER_EVENT_AD_REQUEST_COMPLETED = 100;
    private static final int LISTENER_EVENT_AD_REQUEST_FAILED = 101;
    private static final int LISTENER_EVENT_DISMISS_AD_SCREEN = 103;
    private static final int LISTENER_EVENT_LEAVE_APPLICATION = 104;
    private static final int LISTENER_EVENT_SHOW_AD_SCREEN = 102;
    private static final int MSG_AD_LEAVE_SCREEN = 106;
    private static final int MSG_CLICK_PROCESSING_DONE = 102;
    private static final int MSG_POOR_AD_CLOSED = 104;
    private static final int MSG_POOR_AD_OPEN = 105;
    private static final int MSG_REFRESH_AD = 100;
    private static final int MSG_SEARCH_AD_CLICKED = 103;
    private static final int MSG_SWAP_AD = 101;
    public static final int REFRESH_INTERVAL_DEFAULT = 60;
    private static final int REFRESH_INTERVAL_MINIMUM = 20;
    public static final int REFRESH_INTERVAL_OFF = -1;
    private static final String TEMPLATE_BG_COLOR_GRADIENT = "<style>#im_c { background: -webkit-gradient(linear, left top, left bottom, from(#BGCOLOR1), to(#BGCOLOR2)) !important;\tbackground: -moz-linear-gradient(top,  #BGCOLOR1,  #BGCOLOR2) !important;} </style>";
    private static final String TEMPLATE_BG_COLOR_SOLID = "<style>#im_c { \tbackground:#BGCOLOR1 !important;} </style>";
    private static final String TEMPLATE_TEXT_COLOR = "<style>#im_text {\tcolor:#TEXTCOLOR !important;} </style>";
    private Animation animFirstHalf;
    private Animation animSecHalf;
    private String baseUrlString;
    private String bgColor1;
    private String bgColor2;
    private boolean canGiveCallback;
    private AtomicBoolean downloadingNewAd;
    /* access modifiers changed from: private */
    public boolean isFirstLoad;
    private boolean loadingWebView1;
    /* access modifiers changed from: private */
    public Activity mActivity;
    private int mAdSlot;
    /* access modifiers changed from: private */
    public AdUnit mAdUnit;
    /* access modifiers changed from: private */
    public AnimationController mAnimController;
    private AnimationListener mAnimationListener;
    /* access modifiers changed from: private */
    public AnimationType mAnimationType;
    private String mAppId;
    private Handler mHandler;
    private HttpRequestCallback mHttpReqCallback;
    /* access modifiers changed from: private */
    public IMAdListener mIMAdListener;
    private IMAdRequest mIMAdRequest;
    private IMWebViewListener mImWebViewListener;
    /* access modifiers changed from: private */
    public int mRefreshInterval;
    private OnTouchListener mTouchListener;
    private UserInfo mUserInfo;
    /* access modifiers changed from: private */
    public long prevAdFetchTimestamp;
    private AtomicBoolean processingAdClick;
    private boolean testMode;
    private String textColor;
    /* access modifiers changed from: private */
    public LinearLayout transpLinearLayout;
    /* access modifiers changed from: private */
    public IMWebView webView1;
    /* access modifiers changed from: private */
    public IMWebView webView2;

    public enum AnimationType {
        ANIMATION_OFF,
        ROTATE_HORIZONTAL_AXIS,
        ANIMATION_ALPHA,
        ROTATE_VERTICAL_AXIS
    }

    private IMAdView(Context context) {
        super(context);
        this.mRefreshInterval = 60;
        this.loadingWebView1 = true;
        this.downloadingNewAd = new AtomicBoolean();
        this.processingAdClick = new AtomicBoolean();
        this.mAdUnit = null;
        this.prevAdFetchTimestamp = 0;
        this.isFirstLoad = true;
        this.mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.canGiveCallback = true;
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        if (IMAdView.this.mRefreshInterval != -1) {
                            if (!IMAdView.this.mActivity.hasWindowFocus()) {
                                Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_FOCUS);
                            } else {
                                IMAdView.this.loadNewAd();
                            }
                            sendEmptyMessageDelayed(100, (long) (IMAdView.this.mRefreshInterval * 1000));
                            return;
                        }
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR /*101*/:
                        if (IMAdView.this.isFirstLoad) {
                            IMAdView.this.swapWebView();
                            IMAdView.this.isFirstLoad = false;
                        } else if (IMAdView.this.mAnimationType == AnimationType.ANIMATION_OFF) {
                            IMAdView.this.swapWebView();
                        } else {
                            IMAdView.this.mAnimController.animateAndSwapWebView(IMAdView.this.mAnimationType);
                        }
                        IMAdView.this.prevAdFetchTimestamp = System.currentTimeMillis();
                        IMAdView.this.performCallbackNotification(100, null);
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL /*102*/:
                        IMAdView.this.setProcessingAdClick(false);
                        return;
                    case 103:
                        IMAdView.this.adClicked();
                        return;
                    case 104:
                        IMAdView.this.performCallbackNotification(103, null);
                        return;
                    case IMAdView.MSG_POOR_AD_OPEN /*105*/:
                        IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                        return;
                    case IMAdView.MSG_AD_LEAVE_SCREEN /*106*/:
                        IMAdView.this.performCallbackNotification(104, null);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mTouchListener = new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "onTouch: view: " + v + ", event: " + event);
                }
                if (IMAdView.this.webView1 != null && v.equals(IMAdView.this.webView1)) {
                    v.requestFocusFromTouch();
                } else if (IMAdView.this.webView2 != null && v.equals(IMAdView.this.webView2)) {
                    v.requestFocusFromTouch();
                } else if (event.getAction() == 1) {
                    IMAdView.this.setNormalBGColor();
                    IMAdView.this.adClicked();
                } else if (event.getAction() == 0) {
                    if (IMAdView.this.isProcessingAdClick() || IMAdView.this.isDownloadingNewAd() || IMAdView.this.mAdUnit == null) {
                        IMAdView.this.setNormalBGColor();
                    } else {
                        IMAdView.this.setHighlightedBGColor();
                    }
                } else if (event.getAction() == 3) {
                    IMAdView.this.setNormalBGColor();
                } else if (event.getAction() == 4) {
                    IMAdView.this.setNormalBGColor();
                }
                return true;
            }
        };
        this.mAnimationListener = new AnimationListener() {
            public void onAnimationEnd(Animation anim) {
                boolean z = false;
                try {
                    if (anim.equals(IMAdView.this.getAnimFirstHalf())) {
                        IMAdView.this.removeAllViews();
                        if (IMAdView.this.isLoadingWebView1()) {
                            IMAdView.this.addView(IMAdView.this.webView1);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView1.requestFocusFromTouch();
                            }
                        } else {
                            IMAdView.this.addView(IMAdView.this.webView2);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView2.requestFocusFromTouch();
                            }
                        }
                        if (!(IMAdView.this.mAdUnit.getAdType() == AdTypes.RICH_MEDIA || IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search)) {
                            IMAdView.this.addView(IMAdView.this.transpLinearLayout);
                        }
                        IMAdView.this.startAnimation(IMAdView.this.getAnimSecHalf());
                        return;
                    }
                    IMAdView iMAdView = IMAdView.this;
                    if (!IMAdView.this.isLoadingWebView1()) {
                        z = true;
                    }
                    iMAdView.setLoadingWebView1(z);
                    IMAdView.this.setDownloadingNewAd(false);
                    IMAdView.this.setNormalBGColor();
                } catch (Exception e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Error animating banner ads");
                    }
                }
            }

            public void onAnimationRepeat(Animation anim) {
            }

            public void onAnimationStart(Animation anim) {
            }
        };
        this.mHttpReqCallback = new HttpRequestCallback() {
            public void notifyResult(int status, final Object data) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, ">>> Got HTTP REQUEST callback. Status: " + status + " ,data=" + data);
                }
                if (status == 0) {
                    IMAdView.this.mActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            IMAdView.this.mAdUnit = (AdUnit) data;
                            IMAdView.this.displayAd(IMAdView.this.mAdUnit);
                        }
                    });
                } else if (status == 1) {
                    IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, (ErrorCode) data);
                    IMAdView.this.setDownloadingNewAd(false);
                }
            }
        };
        this.mImWebViewListener = new IMWebViewListener() {
            public boolean onResizeClose() {
                return false;
            }

            public boolean onResize() {
                return false;
            }

            public boolean onReady() {
                return false;
            }

            public boolean onExpandClose() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onExpand() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }

            public boolean onEventFired() {
                return false;
            }

            public void handleRequest(String url) {
            }

            public boolean onLeaveApplication() {
                IMAdView.this.performCallbackNotification(104, null);
                return false;
            }

            public boolean onDismissAdScreen() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onShowScreen() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }
        };
    }

    public IMAdView(Activity activity, int adSlot, String appId) {
        super(activity);
        this.mRefreshInterval = 60;
        this.loadingWebView1 = true;
        this.downloadingNewAd = new AtomicBoolean();
        this.processingAdClick = new AtomicBoolean();
        this.mAdUnit = null;
        this.prevAdFetchTimestamp = 0;
        this.isFirstLoad = true;
        this.mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.canGiveCallback = true;
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        if (IMAdView.this.mRefreshInterval != -1) {
                            if (!IMAdView.this.mActivity.hasWindowFocus()) {
                                Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_FOCUS);
                            } else {
                                IMAdView.this.loadNewAd();
                            }
                            sendEmptyMessageDelayed(100, (long) (IMAdView.this.mRefreshInterval * 1000));
                            return;
                        }
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR /*101*/:
                        if (IMAdView.this.isFirstLoad) {
                            IMAdView.this.swapWebView();
                            IMAdView.this.isFirstLoad = false;
                        } else if (IMAdView.this.mAnimationType == AnimationType.ANIMATION_OFF) {
                            IMAdView.this.swapWebView();
                        } else {
                            IMAdView.this.mAnimController.animateAndSwapWebView(IMAdView.this.mAnimationType);
                        }
                        IMAdView.this.prevAdFetchTimestamp = System.currentTimeMillis();
                        IMAdView.this.performCallbackNotification(100, null);
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL /*102*/:
                        IMAdView.this.setProcessingAdClick(false);
                        return;
                    case 103:
                        IMAdView.this.adClicked();
                        return;
                    case 104:
                        IMAdView.this.performCallbackNotification(103, null);
                        return;
                    case IMAdView.MSG_POOR_AD_OPEN /*105*/:
                        IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                        return;
                    case IMAdView.MSG_AD_LEAVE_SCREEN /*106*/:
                        IMAdView.this.performCallbackNotification(104, null);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mTouchListener = new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "onTouch: view: " + v + ", event: " + event);
                }
                if (IMAdView.this.webView1 != null && v.equals(IMAdView.this.webView1)) {
                    v.requestFocusFromTouch();
                } else if (IMAdView.this.webView2 != null && v.equals(IMAdView.this.webView2)) {
                    v.requestFocusFromTouch();
                } else if (event.getAction() == 1) {
                    IMAdView.this.setNormalBGColor();
                    IMAdView.this.adClicked();
                } else if (event.getAction() == 0) {
                    if (IMAdView.this.isProcessingAdClick() || IMAdView.this.isDownloadingNewAd() || IMAdView.this.mAdUnit == null) {
                        IMAdView.this.setNormalBGColor();
                    } else {
                        IMAdView.this.setHighlightedBGColor();
                    }
                } else if (event.getAction() == 3) {
                    IMAdView.this.setNormalBGColor();
                } else if (event.getAction() == 4) {
                    IMAdView.this.setNormalBGColor();
                }
                return true;
            }
        };
        this.mAnimationListener = new AnimationListener() {
            public void onAnimationEnd(Animation anim) {
                boolean z = false;
                try {
                    if (anim.equals(IMAdView.this.getAnimFirstHalf())) {
                        IMAdView.this.removeAllViews();
                        if (IMAdView.this.isLoadingWebView1()) {
                            IMAdView.this.addView(IMAdView.this.webView1);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView1.requestFocusFromTouch();
                            }
                        } else {
                            IMAdView.this.addView(IMAdView.this.webView2);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView2.requestFocusFromTouch();
                            }
                        }
                        if (!(IMAdView.this.mAdUnit.getAdType() == AdTypes.RICH_MEDIA || IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search)) {
                            IMAdView.this.addView(IMAdView.this.transpLinearLayout);
                        }
                        IMAdView.this.startAnimation(IMAdView.this.getAnimSecHalf());
                        return;
                    }
                    IMAdView iMAdView = IMAdView.this;
                    if (!IMAdView.this.isLoadingWebView1()) {
                        z = true;
                    }
                    iMAdView.setLoadingWebView1(z);
                    IMAdView.this.setDownloadingNewAd(false);
                    IMAdView.this.setNormalBGColor();
                } catch (Exception e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Error animating banner ads");
                    }
                }
            }

            public void onAnimationRepeat(Animation anim) {
            }

            public void onAnimationStart(Animation anim) {
            }
        };
        this.mHttpReqCallback = new HttpRequestCallback() {
            public void notifyResult(int status, final Object data) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, ">>> Got HTTP REQUEST callback. Status: " + status + " ,data=" + data);
                }
                if (status == 0) {
                    IMAdView.this.mActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            IMAdView.this.mAdUnit = (AdUnit) data;
                            IMAdView.this.displayAd(IMAdView.this.mAdUnit);
                        }
                    });
                } else if (status == 1) {
                    IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, (ErrorCode) data);
                    IMAdView.this.setDownloadingNewAd(false);
                }
            }
        };
        this.mImWebViewListener = new IMWebViewListener() {
            public boolean onResizeClose() {
                return false;
            }

            public boolean onResize() {
                return false;
            }

            public boolean onReady() {
                return false;
            }

            public boolean onExpandClose() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onExpand() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }

            public boolean onEventFired() {
                return false;
            }

            public void handleRequest(String url) {
            }

            public boolean onLeaveApplication() {
                IMAdView.this.performCallbackNotification(104, null);
                return false;
            }

            public boolean onDismissAdScreen() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onShowScreen() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }
        };
        this.baseUrlString = "http://www.inmobi.com/" + Integer.toString(Utils.incrementBaseUrl()) + "/";
        initialize(activity, adSlot, appId);
    }

    public IMAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRefreshInterval = 60;
        this.loadingWebView1 = true;
        this.downloadingNewAd = new AtomicBoolean();
        this.processingAdClick = new AtomicBoolean();
        this.mAdUnit = null;
        this.prevAdFetchTimestamp = 0;
        this.isFirstLoad = true;
        this.mAnimationType = AnimationType.ROTATE_HORIZONTAL_AXIS;
        this.canGiveCallback = true;
        this.mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 100:
                        if (IMAdView.this.mRefreshInterval != -1) {
                            if (!IMAdView.this.mActivity.hasWindowFocus()) {
                                Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_FOCUS);
                            } else {
                                IMAdView.this.loadNewAd();
                            }
                            sendEmptyMessageDelayed(100, (long) (IMAdView.this.mRefreshInterval * 1000));
                            return;
                        }
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR /*101*/:
                        if (IMAdView.this.isFirstLoad) {
                            IMAdView.this.swapWebView();
                            IMAdView.this.isFirstLoad = false;
                        } else if (IMAdView.this.mAnimationType == AnimationType.ANIMATION_OFF) {
                            IMAdView.this.swapWebView();
                        } else {
                            IMAdView.this.mAnimController.animateAndSwapWebView(IMAdView.this.mAnimationType);
                        }
                        IMAdView.this.prevAdFetchTimestamp = System.currentTimeMillis();
                        IMAdView.this.performCallbackNotification(100, null);
                        return;
                    case IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL /*102*/:
                        IMAdView.this.setProcessingAdClick(false);
                        return;
                    case 103:
                        IMAdView.this.adClicked();
                        return;
                    case 104:
                        IMAdView.this.performCallbackNotification(103, null);
                        return;
                    case IMAdView.MSG_POOR_AD_OPEN /*105*/:
                        IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                        return;
                    case IMAdView.MSG_AD_LEAVE_SCREEN /*106*/:
                        IMAdView.this.performCallbackNotification(104, null);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mTouchListener = new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "onTouch: view: " + v + ", event: " + event);
                }
                if (IMAdView.this.webView1 != null && v.equals(IMAdView.this.webView1)) {
                    v.requestFocusFromTouch();
                } else if (IMAdView.this.webView2 != null && v.equals(IMAdView.this.webView2)) {
                    v.requestFocusFromTouch();
                } else if (event.getAction() == 1) {
                    IMAdView.this.setNormalBGColor();
                    IMAdView.this.adClicked();
                } else if (event.getAction() == 0) {
                    if (IMAdView.this.isProcessingAdClick() || IMAdView.this.isDownloadingNewAd() || IMAdView.this.mAdUnit == null) {
                        IMAdView.this.setNormalBGColor();
                    } else {
                        IMAdView.this.setHighlightedBGColor();
                    }
                } else if (event.getAction() == 3) {
                    IMAdView.this.setNormalBGColor();
                } else if (event.getAction() == 4) {
                    IMAdView.this.setNormalBGColor();
                }
                return true;
            }
        };
        this.mAnimationListener = new AnimationListener() {
            public void onAnimationEnd(Animation anim) {
                boolean z = false;
                try {
                    if (anim.equals(IMAdView.this.getAnimFirstHalf())) {
                        IMAdView.this.removeAllViews();
                        if (IMAdView.this.isLoadingWebView1()) {
                            IMAdView.this.addView(IMAdView.this.webView1);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView1.requestFocusFromTouch();
                            }
                        } else {
                            IMAdView.this.addView(IMAdView.this.webView2);
                            if (IMAdView.this.mAdUnit != null && IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                                IMAdView.this.webView2.requestFocusFromTouch();
                            }
                        }
                        if (!(IMAdView.this.mAdUnit.getAdType() == AdTypes.RICH_MEDIA || IMAdView.this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search)) {
                            IMAdView.this.addView(IMAdView.this.transpLinearLayout);
                        }
                        IMAdView.this.startAnimation(IMAdView.this.getAnimSecHalf());
                        return;
                    }
                    IMAdView iMAdView = IMAdView.this;
                    if (!IMAdView.this.isLoadingWebView1()) {
                        z = true;
                    }
                    iMAdView.setLoadingWebView1(z);
                    IMAdView.this.setDownloadingNewAd(false);
                    IMAdView.this.setNormalBGColor();
                } catch (Exception e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "Error animating banner ads");
                    }
                }
            }

            public void onAnimationRepeat(Animation anim) {
            }

            public void onAnimationStart(Animation anim) {
            }
        };
        this.mHttpReqCallback = new HttpRequestCallback() {
            public void notifyResult(int status, final Object data) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, ">>> Got HTTP REQUEST callback. Status: " + status + " ,data=" + data);
                }
                if (status == 0) {
                    IMAdView.this.mActivity.runOnUiThread(new Runnable() {
                        public void run() {
                            IMAdView.this.mAdUnit = (AdUnit) data;
                            IMAdView.this.displayAd(IMAdView.this.mAdUnit);
                        }
                    });
                } else if (status == 1) {
                    IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, (ErrorCode) data);
                    IMAdView.this.setDownloadingNewAd(false);
                }
            }
        };
        this.mImWebViewListener = new IMWebViewListener() {
            public boolean onResizeClose() {
                return false;
            }

            public boolean onResize() {
                return false;
            }

            public boolean onReady() {
                return false;
            }

            public boolean onExpandClose() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onExpand() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }

            public boolean onEventFired() {
                return false;
            }

            public void handleRequest(String url) {
            }

            public boolean onLeaveApplication() {
                IMAdView.this.performCallbackNotification(104, null);
                return false;
            }

            public boolean onDismissAdScreen() {
                IMAdView.this.performCallbackNotification(103, null);
                return false;
            }

            public boolean onShowScreen() {
                IMAdView.this.performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL, null);
                return false;
            }
        };
        this.baseUrlString = "http://www.inmobi.com/" + Integer.toString(Utils.incrementBaseUrl()) + "/";
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMAdView Constructor context: " + context);
        }
        String appId = attrs.getAttributeValue(null, "appId");
        int addSlot = attrs.getAttributeIntValue(null, "adSlot", -1);
        if (appId == null || appId.trim().equals(Constants.QA_SERVER_URL)) {
            throw new IllegalArgumentException(ConfigConstants.MSG_APP_ID);
        } else if (addSlot < 0) {
            throw new IllegalArgumentException(ConfigConstants.MSG_AD_SLOT);
        } else {
            initialize((Activity) context, addSlot, appId);
        }
    }

    public void setRefTagParam(String key, String value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key or value cannot be null");
        } else if (key.trim().equals(Constants.QA_SERVER_URL) || value.trim().equals(Constants.QA_SERVER_URL)) {
            throw new IllegalArgumentException("Key or value cannot be empty");
        } else {
            this.mUserInfo.setRefTagKey(key.toLowerCase());
            this.mUserInfo.setRefTagValue(value.toLowerCase());
        }
    }

    private void initialize(Activity activity, int adSlot, String appId) {
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        } else if (adSlot < 0) {
            throw new IllegalArgumentException("Ad Slot value cannot be negative");
        } else if (appId == null) {
            throw new NullPointerException("App ID cannot be null");
        } else if (appId.trim().equalsIgnoreCase(Constants.QA_SERVER_URL)) {
            throw new IllegalArgumentException("App ID cannot be empty");
        } else {
            this.mAppId = appId;
            this.mAdSlot = adSlot;
            this.mActivity = activity;
            if (this.webView1 == null) {
                this.webView1 = new IMWebView(this.mActivity, this.mImWebViewListener, false, false);
            }
            if (this.webView2 == null) {
                this.webView2 = new IMWebView(this.mActivity, this.mImWebViewListener, false, false);
                addView(this.webView2);
            }
            if (this.transpLinearLayout == null) {
                this.transpLinearLayout = new LinearLayout(this.mActivity);
                this.transpLinearLayout.setLayoutParams(new LayoutParams(-1, -1));
                this.transpLinearLayout.setOnTouchListener(this.mTouchListener);
                this.transpLinearLayout.setBackgroundColor(0);
                addView(this.transpLinearLayout);
            }
            updateUserInfo();
            this.mAnimController = new AnimationController(this, this.mAnimationListener);
        }
    }

    /* access modifiers changed from: private */
    public void displayAd(AdUnit newAd) {
        IMWebView currentWebView;
        if (newAd != null && AdTypes.NONE != newAd.getAdType() && newAd.getCDATABlock() != null) {
            StringBuffer htmlStringBuf = new StringBuffer(newAd.getCDATABlock());
            if (newAd.getAdType() == AdTypes.TEXT) {
                applyBGandTextColor(htmlStringBuf);
            }
            String htmlString = htmlStringBuf.toString().replaceAll("%", "%25");
            if (isLoadingWebView1()) {
                if (this.webView1 == null) {
                    this.webView1 = new IMWebView(this.mActivity, this.mImWebViewListener, false, false);
                }
                currentWebView = this.webView1;
            } else {
                if (this.webView2 == null) {
                    this.webView2 = new IMWebView(this.mActivity, this.mImWebViewListener, false, false);
                }
                currentWebView = this.webView2;
            }
            if (newAd.getAdActionName() == AdActionNames.AdActionName_Search) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "It came to AdActionType_Search method of displayad");
                }
                currentWebView.requestOnSearchAdClicked(this.mHandler.obtainMessage(103));
            }
            currentWebView.setAdUnit(newAd);
            currentWebView.requestOnPageFinishedCallback(this.mHandler.obtainMessage(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR));
            currentWebView.reinitializeExpandProperties();
            currentWebView.loadDataWithBaseURL(this.baseUrlString, "<html><head><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no,maximum-scale=1\"><meta http-equiv=\"Content-Type\" content=\"text/html charset=utf-16le\"></head><body style=\"margin:0;padding:0\">" + htmlString + "</body></html>", "text/html", null, this.baseUrlString);
        }
    }

    private void applyBGandTextColor(StringBuffer htmlStringBuf) {
        if (this.bgColor1 != null) {
            if (this.bgColor2 != null) {
                htmlStringBuf.append(TEMPLATE_BG_COLOR_GRADIENT.replaceAll("#BGCOLOR1", this.bgColor1).replaceAll("#BGCOLOR2", this.bgColor2));
            } else {
                htmlStringBuf.append(TEMPLATE_BG_COLOR_SOLID.replaceAll("#BGCOLOR1", this.bgColor1));
            }
        }
        if (this.textColor != null) {
            htmlStringBuf.append(TEMPLATE_TEXT_COLOR.replaceAll("#TEXTCOLOR", this.textColor));
        }
    }

    private void updateUserInfo() {
        if (this.mUserInfo == null) {
            this.mUserInfo = new UserInfo(this.mActivity.getApplicationContext());
            DisplayMetrics metrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            float density = metrics.density;
            Display display = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay();
            int width = display.getWidth();
            int height = display.getHeight();
            this.mUserInfo.setScreenDensity(String.valueOf(density));
            this.mUserInfo.setScreenSize(width + "X" + height);
            try {
                if (this.webView1 != null && this.mUserInfo.getPhoneDefaultUserAgent().equals(Constants.QA_SERVER_URL)) {
                    this.mUserInfo.setPhoneDefaultUserAgent(this.webView1.getSettings().getUserAgentString());
                }
            } catch (Exception e) {
                Log.w(Constants.LOGGING_TAG, "Exception occured while setting user agent" + e);
            }
        }
        this.mUserInfo.setAdUnitSlot(String.valueOf(this.mAdSlot));
        this.mUserInfo.updateInfo(this.mAppId, this.mIMAdRequest);
    }

    /* access modifiers changed from: private */
    public void swapWebView() {
        boolean z = false;
        try {
            removeAllViews();
            if (isLoadingWebView1()) {
                addView(this.webView1);
                if (this.mAdUnit != null && this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                    this.webView1.requestFocusFromTouch();
                }
            } else {
                addView(this.webView2);
                if (this.mAdUnit != null && this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search) {
                    this.webView2.requestFocusFromTouch();
                }
            }
            if (!(this.mAdUnit.getAdType() == AdTypes.RICH_MEDIA || this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_Search)) {
                addView(this.transpLinearLayout);
            }
            if (!isLoadingWebView1()) {
                z = true;
            }
            setLoadingWebView1(z);
            setDownloadingNewAd(false);
            setNormalBGColor();
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Error swapping banner ads");
            }
        }
    }

    public synchronized void loadNewAd() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, " ");
            Log.e(Constants.LOGGING_TAG, ">>>> Start loading new Ad <<<<");
        }
        try {
            if (isDownloadingNewAd()) {
                performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, ErrorCode.AD_DOWNLOAD_IN_PROGRESS);
            } else if (isProcessingAdClick()) {
                performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, ErrorCode.AD_CLICK_IN_PROGRESS);
            } else if (!canShowAd()) {
                performCallbackNotification(IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR, ErrorCode.INVALID_REQUEST);
            } else {
                setDownloadingNewAd(true);
                updateUserInfo();
                new RequestResponseManager(this.mActivity.getApplicationContext()).asyncRequestAd(this.mUserInfo, ActionType.AdRequest, this.mHttpReqCallback);
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Error in loading ad", e);
            }
        }
    }

    public void loadNewAd(IMAdRequest imAdRequest) {
        if (imAdRequest != null) {
            this.testMode = imAdRequest.isTestMode();
            setIMAdRequest(imAdRequest);
        }
        loadNewAd();
    }

    private boolean canShowAd() {
        long currTime = System.currentTimeMillis();
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Time Gap: " + (currTime - this.prevAdFetchTimestamp));
        }
        if (currTime - this.prevAdFetchTimestamp < 20000) {
            Log.w(Constants.LOGGING_TAG, "Ad cannot be refreshed now, as the minimum refresh interval is20 seconds.");
            return false;
        } else if (0 == 0 && !this.testMode && !Utils.validateAppId(this.mAppId)) {
            return false;
        } else {
            if (this.mAdSlot >= 0) {
                return true;
            }
            Log.v(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_SLOT_2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean isDownloadingNewAd() {
        return this.downloadingNewAd.get();
    }

    /* access modifiers changed from: private */
    public void setDownloadingNewAd(boolean downloadingNewAd2) {
        this.downloadingNewAd.set(downloadingNewAd2);
    }

    /* access modifiers changed from: private */
    public boolean isProcessingAdClick() {
        IMWebView currWebView;
        if (this.processingAdClick.get()) {
            return true;
        }
        if (isLoadingWebView1()) {
            currWebView = this.webView2;
        } else {
            currWebView = this.webView1;
        }
        String state = currWebView.getState();
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Current Ad State: " + state);
        }
        if (ViewState.EXPANDED.toString().equalsIgnoreCase(state) || ViewState.RESIZED.toString().equalsIgnoreCase(state) || ViewState.EXPANDING.toString().equalsIgnoreCase(state)) {
            Log.w(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_STATE);
            return true;
        } else if (!currWebView.isBusy()) {
            return false;
        } else {
            Log.w(Constants.LOGGING_TAG, ConfigConstants.MSG_AD_BUSY);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void setProcessingAdClick(boolean processingAdClick2) {
        this.processingAdClick.set(processingAdClick2);
    }

    /* access modifiers changed from: private */
    public boolean isLoadingWebView1() {
        return this.loadingWebView1;
    }

    /* access modifiers changed from: private */
    public void setLoadingWebView1(boolean loadingWebView12) {
        this.loadingWebView1 = loadingWebView12;
        if (loadingWebView12) {
            this.webView1.deinit();
            this.webView1 = null;
            return;
        }
        this.webView2.deinit();
        this.webView2 = null;
    }

    /* access modifiers changed from: 0000 */
    public Animation getAnimFirstHalf() {
        return this.animFirstHalf;
    }

    /* access modifiers changed from: 0000 */
    public void setAnimFirstHalf(Animation animFirstHalf2) {
        this.animFirstHalf = animFirstHalf2;
    }

    /* access modifiers changed from: 0000 */
    public Animation getAnimSecHalf() {
        return this.animSecHalf;
    }

    /* access modifiers changed from: 0000 */
    public void setAnimSecHalf(Animation animSecHalf2) {
        this.animSecHalf = animSecHalf2;
    }

    /* access modifiers changed from: private */
    public void performCallbackNotification(final int event, final ErrorCode errorCode) {
        if (!this.canGiveCallback) {
            Log.w(Constants.LOGGING_TAG, ConfigConstants.MSG_CALL_BACK);
        } else if (this.mIMAdListener != null) {
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

                /* JADX WARNING: Removed duplicated region for block: B:19:? A[Catch:{ Exception -> 0x0012 }, RETURN, SYNTHETIC] */
                /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r4 = this;
                        int r1 = r3     // Catch:{ Exception -> 0x0012 }
                        switch(r1) {
                            case 100: goto L_0x0006;
                            case 101: goto L_0x001f;
                            case 102: goto L_0x0060;
                            case 103: goto L_0x0054;
                            case 104: goto L_0x006c;
                            default: goto L_0x0005;
                        }     // Catch:{ Exception -> 0x0012 }
                    L_0x0005:
                        return
                    L_0x0006:
                        com.inmobi.androidsdk.IMAdView r1 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdListener r1 = r1.mIMAdListener     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdView r2 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        r1.onAdRequestCompleted(r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x0005
                    L_0x0012:
                        r0 = move-exception
                        boolean r1 = com.inmobi.androidsdk.impl.Constants.DEBUG
                        if (r1 == 0) goto L_0x0005
                        java.lang.String r1 = "InMobiAndroidSDK_3.5.0"
                        java.lang.String r2 = "Exception giving callback to the publisher"
                        android.util.Log.w(r1, r2, r0)
                        goto L_0x0005
                    L_0x001f:
                        int[] r1 = $SWITCH_TABLE$com$inmobi$androidsdk$IMAdRequest$ErrorCode()     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdRequest$ErrorCode r2 = r4     // Catch:{ Exception -> 0x0012 }
                        int r2 = r2.ordinal()     // Catch:{ Exception -> 0x0012 }
                        r1 = r1[r2]     // Catch:{ Exception -> 0x0012 }
                        switch(r1) {
                            case 2: goto L_0x0044;
                            case 3: goto L_0x003c;
                            case 4: goto L_0x002e;
                            case 5: goto L_0x002e;
                            case 6: goto L_0x004c;
                            default: goto L_0x002e;
                        }     // Catch:{ Exception -> 0x0012 }
                    L_0x002e:
                        com.inmobi.androidsdk.IMAdView r1 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdListener r1 = r1.mIMAdListener     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdView r2 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdRequest$ErrorCode r3 = r4     // Catch:{ Exception -> 0x0012 }
                        r1.onAdRequestFailed(r2, r3)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x0005
                    L_0x003c:
                        java.lang.String r1 = "InMobiAndroidSDK_3.5.0"
                        java.lang.String r2 = "Ad click in progress. Your request cannot be processed at this time. Try again later."
                        android.util.Log.w(r1, r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x002e
                    L_0x0044:
                        java.lang.String r1 = "InMobiAndroidSDK_3.5.0"
                        java.lang.String r2 = "Ad download in progress. Your request cannot be processed at this time. Try again later."
                        android.util.Log.w(r1, r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x002e
                    L_0x004c:
                        java.lang.String r1 = "InMobiAndroidSDK_3.5.0"
                        java.lang.String r2 = "Ad request successful, but no ad was returned due to lack of ad inventory."
                        android.util.Log.w(r1, r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x002e
                    L_0x0054:
                        com.inmobi.androidsdk.IMAdView r1 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdListener r1 = r1.mIMAdListener     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdView r2 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        r1.onDismissAdScreen(r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x0005
                    L_0x0060:
                        com.inmobi.androidsdk.IMAdView r1 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdListener r1 = r1.mIMAdListener     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdView r2 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        r1.onShowAdScreen(r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x0005
                    L_0x006c:
                        com.inmobi.androidsdk.IMAdView r1 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdListener r1 = r1.mIMAdListener     // Catch:{ Exception -> 0x0012 }
                        com.inmobi.androidsdk.IMAdView r2 = com.inmobi.androidsdk.IMAdView.this     // Catch:{ Exception -> 0x0012 }
                        r1.onLeaveApplication(r2)     // Catch:{ Exception -> 0x0012 }
                        goto L_0x0005
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.inmobi.androidsdk.IMAdView.AnonymousClass6.run():void");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void adClicked() {
        try {
            if (this.mAdUnit != null && !isProcessingAdClick()) {
                setProcessingAdClick(true);
                if (this.mAdUnit.getTargetUrl() != null) {
                    IMBrowserActivity.requestCallbackOnClosed(this.mHandler.obtainMessage(104));
                    new ClickProcessingTask(this.mAdUnit, this.mUserInfo, this.mActivity, this.mHandler.obtainMessage(IMBrowserActivity.EXTRA_BROWSER_EXPAND_URL), this.mHandler.obtainMessage(MSG_POOR_AD_OPEN), this.mHandler.obtainMessage(MSG_AD_LEAVE_SCREEN), this.mImWebViewListener).execute(new Void[]{null});
                }
            }
        } catch (Exception exception) {
            if (Constants.DEBUG) {
                exception.printStackTrace();
                Log.w(Constants.LOGGING_TAG, "Exception processing ad click", exception);
            }
            setProcessingAdClick(false);
        }
        setNormalBGColor();
    }

    /* access modifiers changed from: private */
    public void setHighlightedBGColor() {
        try {
            int bgColor = Color.argb(100, 0, 0, 0);
            if (this.webView2 != null) {
                this.webView2.setBackgroundColor(bgColor);
            }
            if (this.webView1 != null) {
                this.webView1.setBackgroundColor(bgColor);
            }
            this.transpLinearLayout.setBackgroundColor(bgColor);
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Error setHighlightedBGColor");
            }
        }
    }

    /* access modifiers changed from: private */
    public void setNormalBGColor() {
        try {
            if (this.webView2 != null) {
                this.webView2.setBackgroundColor(0);
            }
            if (this.webView1 != null) {
                this.webView1.setBackgroundColor(0);
            }
            this.transpLinearLayout.setBackgroundColor(0);
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Error setNormalBGColor");
            }
        }
    }

    public void setAdBackgroundColor(String color) {
        if (validateColor(color)) {
            this.bgColor1 = color;
            displayAd(this.mAdUnit);
        }
    }

    public void setAdBackgroundGradientColor(String topColor, String bottomColor) {
        if (validateColor(topColor) || validateColor(bottomColor)) {
            this.bgColor1 = topColor;
            this.bgColor2 = bottomColor;
            displayAd(this.mAdUnit);
        }
    }

    public void setAdTextColor(String color) {
        if (validateColor(color)) {
            this.textColor = color;
            displayAd(this.mAdUnit);
        }
    }

    private boolean validateColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null");
        }
        int length = color.length();
        if (color.startsWith("#") && (length == 4 || length == 7)) {
            return true;
        }
        throw new IllegalArgumentException("color should be of the format #rgb or #rrggbb ");
    }

    public void setRefreshInterval(int refreshInterval) {
        if (refreshInterval == -1) {
            this.mRefreshInterval = -1;
            this.mHandler.removeMessages(100);
        } else if (refreshInterval < REFRESH_INTERVAL_MINIMUM) {
            throw new IllegalArgumentException("Refresh Interval cannot be less than 20 seconds.");
        } else {
            this.mRefreshInterval = refreshInterval;
            this.mHandler.removeMessages(100);
            this.mHandler.sendEmptyMessageDelayed(100, (long) (refreshInterval * 1000));
        }
    }

    public void setAnimationType(AnimationType animationType) {
        this.mAnimationType = animationType;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "onAttachedToWindow");
        }
        this.canGiveCallback = true;
        setRefreshInterval(this.mRefreshInterval);
        if (this.mRefreshInterval != -1) {
            loadNewAd();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IMWebView currWebView;
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "onDetachedFromWindow");
        }
        this.canGiveCallback = false;
        setRefreshInterval(-1);
        if (isLoadingWebView1()) {
            currWebView = this.webView2;
        } else {
            currWebView = this.webView1;
        }
        if (currWebView != null) {
            currWebView.deinit();
        }
    }

    public IMAdListener getIMAdListener() {
        return this.mIMAdListener;
    }

    public void setIMAdListener(IMAdListener imAdListener) {
        this.mIMAdListener = imAdListener;
    }

    public IMAdRequest getIMAdRequest() {
        return this.mIMAdRequest;
    }

    public void setIMAdRequest(IMAdRequest imAdRequest) {
        this.mIMAdRequest = imAdRequest;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public void setAppId(String appId) {
        this.mAppId = appId;
    }

    public int getAdSlot() {
        return this.mAdSlot;
    }

    public void setAdSlot(int adSlot) {
        this.mAdSlot = adSlot;
    }
}
