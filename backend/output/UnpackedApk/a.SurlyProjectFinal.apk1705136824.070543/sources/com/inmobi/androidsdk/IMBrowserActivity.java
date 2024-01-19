package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.ai.container.IMWebView.ViewState;
import com.inmobi.androidsdk.impl.Constants;

public class IMBrowserActivity extends Activity {
    private static final int BUTTON_BAR_ID = 100;
    public static final String EXTRA_ADUNIT = "extra_adunit";
    public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
    public static final int EXTRA_BROWSER_CLOSE = 100;
    public static final int EXTRA_BROWSER_EXPAND_URL = 102;
    public static final int EXTRA_BROWSER_STATUS_BAR = 101;
    public static final String EXTRA_URL = "extra_url";
    /* access modifiers changed from: private */
    public static IMWebView mIntWebview;
    private static Message mMsgOnPoorAdClosed;
    /* access modifiers changed from: private */
    public static IMWebView mOriginalWebview;
    private static IMWebView mWebview;
    private static IMWebViewListener mWebviewListener;
    private boolean expandeduse;
    private String firstInstance;
    private boolean interstitialuse;
    /* access modifiers changed from: private */
    public IMWebView mBrowserWebview;
    private float mDensity;
    /* access modifiers changed from: private */
    public ImageView mForwardButton;
    private WebViewClient mWebViewClient = new WebViewClient() {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (IMBrowserActivity.this.mForwardButton != null) {
                IMBrowserActivity.this.mForwardButton.setImageBitmap(IMWebView.bitmapFromJar("assets/next_arrow_inactive.png"));
            }
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (IMBrowserActivity.this.mForwardButton != null) {
                if (view.canGoForward()) {
                    IMBrowserActivity.this.mForwardButton.setImageBitmap(IMWebView.bitmapFromJar("assets/next_arrow_active.png"));
                } else {
                    IMBrowserActivity.this.mForwardButton.setImageBitmap(IMWebView.bitmapFromJar("assets/next_arrow_inactive.png"));
                }
            }
            CookieSyncManager.getInstance().sync();
        }
    };
    RelativeLayout rlParent;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.mDensity = getResources().getDisplayMetrics().density;
        int devicewidth = getResources().getDisplayMetrics().widthPixels;
        int deviceheight = getResources().getDisplayMetrics().heightPixels;
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int expandWidth = bundle.getInt("EXPAND_WIDTH");
        int expandHeight = bundle.getInt("EXPAND_HEIGHT");
        boolean expandcustomclose = bundle.getBoolean("EXPAND_CUSTOM_CLOSE");
        String expandOrientation = bundle.getString("EXPAND_ORIENTATION");
        int expandbackgroundid = bundle.getInt("EXPAND_BACKGROUND_ID");
        String interstitialOrientation = bundle.getString("INTERSTITIAL_ORIENTATION");
        String tempCheck = i.getStringExtra(EXTRA_URL);
        this.firstInstance = i.getStringExtra("FIRST_INSTANCE");
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMBrowserActivity-> onCreate");
        }
        if (tempCheck != null || expandOrientation != null || interstitialOrientation != null) {
            if (expandOrientation != null) {
                this.expandeduse = true;
                this.interstitialuse = false;
                mWebview.setExpandedActivity(this);
                mOriginalWebview.setExpandedActivity(this);
                mOriginalWebview.replaceByPlaceholder();
                if (expandOrientation.equals("portrait")) {
                    setRequestedOrientation(1);
                    if (devicewidth > deviceheight) {
                        int temt = devicewidth;
                        devicewidth = deviceheight;
                        deviceheight = temt;
                    }
                } else {
                    setRequestedOrientation(0);
                    if (deviceheight > devicewidth) {
                        int temt2 = devicewidth;
                        devicewidth = deviceheight;
                        deviceheight = temt2;
                    }
                }
                if (expandWidth <= 0 || expandHeight <= 0) {
                    expandHeight = deviceheight;
                    expandWidth = devicewidth;
                }
                if (expandWidth > devicewidth) {
                    expandWidth = devicewidth;
                }
                if (expandHeight > deviceheight) {
                    expandHeight = deviceheight;
                }
                FrameLayout backGround = new FrameLayout(this);
                LayoutParams bgfl = new LayoutParams(-1, -1);
                backGround.setId(expandbackgroundid);
                LayoutParams fl = new LayoutParams(expandWidth, expandHeight);
                RelativeLayout relativeLayout = new RelativeLayout(this);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(expandWidth, expandHeight);
                relativeLayout.addView(mWebview, layoutParams);
                buildCloseButton(relativeLayout, expandcustomclose);
                backGround.addView(relativeLayout, fl);
                setContentView(backGround, bgfl);
                mWebview.videoValidateWidth = expandWidth;
                mOriginalWebview.videoValidateWidth = expandWidth;
                mOriginalWebview.setState(ViewState.EXPANDED);
                synchronized (mOriginalWebview.mutex) {
                    mOriginalWebview.isMutexAquired.set(false);
                    mOriginalWebview.mutex.notifyAll();
                }
                if (mOriginalWebview.mIsExpandUrlValid) {
                    mWebview.loadUrl(bundle.getString("EXPAND_WITH_URL"));
                }
                if (mOriginalWebview.mListener != null) {
                    mOriginalWebview.mListener.onExpand();
                }
            } else if (interstitialOrientation != null) {
                this.expandeduse = true;
                this.interstitialuse = true;
                mIntWebview.setExpandedActivity(this);
                if (interstitialOrientation.equals("portrait")) {
                    setRequestedOrientation(1);
                } else if (interstitialOrientation.equals("landscape")) {
                    setRequestedOrientation(0);
                }
                RelativeLayout relativeLayout2 = new RelativeLayout(this);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(10);
                relativeLayout2.addView(mIntWebview, layoutParams2);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) (50.0f * this.mDensity), (int) (50.0f * this.mDensity));
                ImageView imageView = new ImageView(this);
                if (!bundle.getBoolean("INTERSTITIAL_CUSTOM_CLOSE")) {
                    imageView.setImageBitmap(IMWebView.bitmapFromJar("assets/close_button.png"));
                } else {
                    imageView.setImageBitmap(IMWebView.bitmapFromJar("assets/close_transparent.png"));
                }
                layoutParams3.addRule(11);
                imageView.setId(bundle.getInt("INTERSTITIAL_CLOSE_ID"));
                relativeLayout2.addView(imageView, layoutParams3);
                AnonymousClass2 r0 = new OnClickListener() {
                    public void onClick(View arg0) {
                        IMWebView.userInitiatedClose = true;
                        IMBrowserActivity.mIntWebview.close();
                    }
                };
                imageView.setOnClickListener(r0);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
                relativeLayout2.setId(bundle.getInt("INTERSTTIAL_BACKGROUND_ID"));
                relativeLayout2.setBackgroundColor(-16777216);
                setContentView(relativeLayout2, layoutParams4);
                if (mIntWebview.mListener != null) {
                    mIntWebview.mListener.onExpand();
                }
                mIntWebview.setViewable(true);
            } else {
                this.expandeduse = false;
                this.interstitialuse = false;
                RelativeLayout relativeLayout3 = new RelativeLayout(this);
                this.rlParent = relativeLayout3;
                IMWebView iMWebView = new IMWebView(this, mWebviewListener, true, true);
                this.mBrowserWebview = iMWebView;
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams5.addRule(10);
                this.rlParent.setBackgroundColor(-1);
                this.rlParent.addView(this.mBrowserWebview, layoutParams5);
                buildStatusBar(this.rlParent);
                this.mBrowserWebview.getSettings().setJavaScriptEnabled(true);
                this.mBrowserWebview.setExternalWebViewClient(this.mWebViewClient);
                this.mBrowserWebview.getSettings().setUseWideViewPort(true);
                this.mBrowserWebview.loadUrl(i.getStringExtra(EXTRA_URL));
                CookieSyncManager.createInstance(this);
                CookieSyncManager.getInstance().startSync();
                setContentView(this.rlParent);
            }
        }
    }

    private void buildCloseButton(ViewGroup parent, boolean customclose) {
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams((int) (this.mDensity * 50.0f), (int) (this.mDensity * 50.0f));
        lp2.addRule(11);
        ImageView imgView = new ImageView(this);
        if (customclose) {
            imgView.setImageBitmap(IMWebView.bitmapFromJar("assets/close_transparent.png"));
        } else {
            imgView.setImageBitmap(IMWebView.bitmapFromJar("assets/close_button.png"));
        }
        parent.addView(imgView, lp2);
        imgView.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                IMWebView.userInitiatedClose = true;
                IMBrowserActivity.mOriginalWebview.close();
            }
        });
    }

    private void buildStatusBar(ViewGroup parent) {
        LinearLayout layButtonBar = new LinearLayout(this);
        layButtonBar.setOrientation(0);
        layButtonBar.setId(100);
        layButtonBar.setWeightSum(100.0f);
        layButtonBar.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });
        layButtonBar.setBackgroundDrawable(new BitmapDrawable(IMWebView.bitmapFromJar("assets/bkgrnd.png")));
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, (int) (44.0f * this.mDensity));
        lp.addRule(12);
        parent.addView(layButtonBar, lp);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams((int) (this.mDensity * 20.0f), (int) (this.mDensity * 20.0f));
        lp2.weight = 25.0f;
        lp2.gravity = 16;
        ImageView closeButton = new ImageView(this);
        closeButton.setImageBitmap(IMWebView.bitmapFromJar("assets/close_icon.png"));
        closeButton.setBackgroundColor(17170445);
        layButtonBar.addView(closeButton, lp2);
        closeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                IMBrowserActivity.this.finish();
            }
        });
        ImageView refreshButton = new ImageView(this);
        refreshButton.setImageBitmap(IMWebView.bitmapFromJar("assets/refresh.png"));
        refreshButton.setBackgroundColor(17170445);
        layButtonBar.addView(refreshButton, lp2);
        refreshButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                IMBrowserActivity.this.mBrowserWebview.doHidePlayers();
                IMBrowserActivity.this.mBrowserWebview.reload();
            }
        });
        ImageView backButton = new ImageView(this);
        backButton.setImageBitmap(IMWebView.bitmapFromJar("assets/previous_arrow_active.png"));
        backButton.setBackgroundColor(17170445);
        layButtonBar.addView(backButton, lp2);
        backButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if (IMBrowserActivity.this.mBrowserWebview.canGoBack()) {
                    IMBrowserActivity.this.mBrowserWebview.goBack();
                } else {
                    IMBrowserActivity.this.finish();
                }
            }
        });
        this.mForwardButton = new ImageView(this);
        this.mForwardButton.setImageBitmap(IMWebView.bitmapFromJar("assets/next_arrow_inactive.png"));
        this.mForwardButton.setBackgroundColor(17170445);
        layButtonBar.addView(this.mForwardButton, lp2);
        this.mForwardButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if (IMBrowserActivity.this.mBrowserWebview.canGoForward()) {
                    IMBrowserActivity.this.mBrowserWebview.goForward();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.mBrowserWebview != null && !this.expandeduse) {
                this.mBrowserWebview.releaseAllPlayers();
            }
            if (mMsgOnPoorAdClosed != null && !this.expandeduse && this.firstInstance != null) {
                mMsgOnPoorAdClosed.sendToTarget();
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in onDestroy", e);
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            IMWebView.userInitiatedClose = true;
            if (this.expandeduse && !this.interstitialuse) {
                mOriginalWebview.close();
                return true;
            } else if (this.expandeduse && this.interstitialuse) {
                mIntWebview.close();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    public static void requestCallbackOnClosed(Message msgOnPoorAdClosed) {
        mMsgOnPoorAdClosed = msgOnPoorAdClosed;
    }

    public static void setWebView(IMWebView mwebview) {
        mWebview = mwebview;
    }

    public static void setIntWebView(IMWebView mintwebview) {
        mIntWebview = mintwebview;
    }

    public static void setOriginalWebView(IMWebView mowebview) {
        mOriginalWebview = mowebview;
    }

    public static void setWebViewListener(IMWebViewListener mwebviewlistener) {
        mWebviewListener = mwebviewlistener;
    }
}
