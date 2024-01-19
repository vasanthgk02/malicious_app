package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.net.URLDecoder;

public abstract class CTInAppBasePartialHtmlFragment extends CTInAppBasePartialFragment implements OnTouchListener, OnLongClickListener {
    public final GestureDetector gd = new GestureDetector(new GestureListener(null));
    public CTInAppWebView webView;

    public class GestureListener extends SimpleOnGestureListener {
        public GestureListener(AnonymousClass1 r2) {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f2) > 200.0f) {
                remove(false);
                return true;
            } else if (motionEvent2.getX() - motionEvent.getX() <= 120.0f || Math.abs(f2) <= 200.0f) {
                return false;
            } else {
                remove(true);
                return true;
            }
        }

        public final boolean remove(boolean z) {
            TranslateAnimation translateAnimation;
            AnimationSet animationSet = new AnimationSet(true);
            if (z) {
                translateAnimation = new TranslateAnimation(0.0f, (float) CTInAppBasePartialHtmlFragment.this.getScaledPixels(50), 0.0f, 0.0f);
            } else {
                translateAnimation = new TranslateAnimation(0.0f, (float) (-CTInAppBasePartialHtmlFragment.this.getScaledPixels(50)), 0.0f, 0.0f);
            }
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setDuration(300);
            animationSet.setFillAfter(true);
            animationSet.setFillEnabled(true);
            animationSet.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    CTInAppBasePartialHtmlFragment.this.didDismiss(null);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            CTInAppBasePartialHtmlFragment.this.webView.startAnimation(animationSet);
            return true;
        }
    }

    public class InAppWebViewClient extends WebViewClient {
        public InAppWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                Bundle allKeyValuePairs = k.getAllKeyValuePairs(str, false);
                if (allKeyValuePairs.containsKey("wzrk_c2a")) {
                    String string = allKeyValuePairs.getString("wzrk_c2a");
                    if (string != null) {
                        String[] split = string.split("__dl__");
                        if (split.length == 2) {
                            allKeyValuePairs.putString("wzrk_c2a", URLDecoder.decode(split[0], "UTF-8"));
                            str = split[1];
                        }
                    }
                }
                CTInAppBasePartialHtmlFragment cTInAppBasePartialHtmlFragment = CTInAppBasePartialHtmlFragment.this;
                InAppListener listener = cTInAppBasePartialHtmlFragment.getListener();
                if (listener != null) {
                    listener.inAppNotificationDidClick(cTInAppBasePartialHtmlFragment.inAppNotification, allKeyValuePairs, null);
                }
                Logger.d("Executing call to action for in-app: " + str);
                CTInAppBasePartialHtmlFragment.this.fireUrlThroughIntent(str, allKeyValuePairs);
            } catch (Throwable th) {
                Logger.v((String) "Error parsing the in-app notification action!", th);
            }
            return true;
        }
    }

    public abstract ViewGroup getLayout(View view);

    public abstract View getView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        reDrawInApp();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View view = getView(layoutInflater, viewGroup);
            ViewGroup layout = getLayout(view);
            CTInAppWebView cTInAppWebView = new CTInAppWebView(this.context, this.inAppNotification.width, this.inAppNotification.height, this.inAppNotification.widthPercentage, this.inAppNotification.heightPercentage);
            this.webView = cTInAppWebView;
            this.webView.setWebViewClient(new InAppWebViewClient());
            this.webView.setOnTouchListener(this);
            this.webView.setOnLongClickListener(this);
            if (layout == null) {
                return view;
            }
            layout.addView(this.webView);
            return view;
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.accountId, "Fragment view not created", th);
            return null;
        }
    }

    public boolean onLongClick(View view) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gd.onTouchEvent(motionEvent) || motionEvent.getAction() == 2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        reDrawInApp();
    }

    public final void reDrawInApp() {
        this.webView.updateDimension();
        Point point = this.webView.dim;
        int i = point.y;
        int i2 = point.x;
        float f2 = getResources().getDisplayMetrics().density;
        String str = this.inAppNotification.html;
        String outline44 = GeneratedOutlineSupport.outline44("<style>body{width:", (int) (((float) i2) / f2), "px; height: ", (int) (((float) i) / f2), "px; margin: 0; padding:0;}</style>");
        String replaceFirst = str.replaceFirst("<head>", "<head>" + outline44);
        Logger.v("Density appears to be " + f2);
        this.webView.setInitialScale((int) (f2 * 100.0f));
        this.webView.loadDataWithBaseURL(null, replaceFirst, RNCWebViewManager.HTML_MIME_TYPE, WebViewGamesContainer.ENCODING_NAME, null);
    }
}
