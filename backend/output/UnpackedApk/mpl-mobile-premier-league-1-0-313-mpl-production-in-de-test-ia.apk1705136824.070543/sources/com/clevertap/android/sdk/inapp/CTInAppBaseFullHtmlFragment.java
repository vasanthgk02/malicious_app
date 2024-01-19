package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CTWebInterface;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.net.URLDecoder;

public abstract class CTInAppBaseFullHtmlFragment extends CTInAppBaseFullFragment {
    public CTInAppWebView webView;

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
                CTInAppBaseFullHtmlFragment cTInAppBaseFullHtmlFragment = CTInAppBaseFullHtmlFragment.this;
                InAppListener listener = cTInAppBaseFullHtmlFragment.getListener();
                if (listener != null) {
                    listener.inAppNotificationDidClick(cTInAppBaseFullHtmlFragment.inAppNotification, allKeyValuePairs, null);
                }
                Logger.d("Executing call to action for in-app: " + str);
                CTInAppBaseFullHtmlFragment.this.fireUrlThroughIntent(str, allKeyValuePairs);
            } catch (Throwable th) {
                Logger.v((String) "Error parsing the in-app notification action!", th);
            }
            return true;
        }
    }

    public LayoutParams getLayoutParamsForCloseButton() {
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(2, this.webView.getId());
        layoutParams.addRule(1, this.webView.getId());
        int i = -(getScaledPixels(40) / 2);
        layoutParams.setMargins(i, 0, 0, i);
        return layoutParams;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        reDrawInApp();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            View inflate = layoutInflater.inflate(R$layout.inapp_html_full, viewGroup, false);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R$id.inapp_html_full_relative_layout);
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(13);
            char c2 = this.inAppNotification.position;
            if (c2 == 'b') {
                layoutParams.addRule(12);
            } else if (c2 == 'c') {
                layoutParams.addRule(13);
            } else if (c2 == 'l') {
                layoutParams.addRule(9);
            } else if (c2 == 'r') {
                layoutParams.addRule(11);
            } else if (c2 == 't') {
                layoutParams.addRule(10);
            }
            layoutParams.setMargins(0, 0, 0, 0);
            CTInAppWebView cTInAppWebView = new CTInAppWebView(this.context, this.inAppNotification.width, this.inAppNotification.height, this.inAppNotification.widthPercentage, this.inAppNotification.heightPercentage);
            this.webView = cTInAppWebView;
            this.webView.setWebViewClient(new InAppWebViewClient());
            if (this.inAppNotification.jsEnabled) {
                this.webView.getSettings().setJavaScriptEnabled(true);
                this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                this.webView.getSettings().setAllowContentAccess(false);
                this.webView.getSettings().setAllowFileAccess(false);
                this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
                this.webView.addJavascriptInterface(new CTWebInterface(CleverTapAPI.instanceWithConfig(getActivity(), this.config)), "CleverTap");
            }
            if (this.inAppNotification.darkenScreen) {
                relativeLayout.setBackground(new ColorDrawable(-1157627904));
            } else {
                relativeLayout.setBackground(new ColorDrawable(0));
            }
            relativeLayout.addView(this.webView, layoutParams);
            if (!this.inAppNotification.showClose) {
                return inflate;
            }
            this.closeImageView = new CloseImageView(this.context);
            LayoutParams layoutParamsForCloseButton = getLayoutParamsForCloseButton();
            this.closeImageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    CTInAppBaseFullHtmlFragment.this.didDismiss(null);
                }
            });
            relativeLayout.addView(this.closeImageView, layoutParamsForCloseButton);
            return inflate;
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.accountId, "Fragment view not created", th);
            return null;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        reDrawInApp();
    }

    public final void reDrawInApp() {
        this.webView.updateDimension();
        if (this.inAppNotification.customInAppUrl.isEmpty()) {
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
            return;
        }
        String str2 = this.inAppNotification.customInAppUrl;
        this.webView.setWebViewClient(new WebViewClient());
        this.webView.loadUrl(str2);
    }
}
