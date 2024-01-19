package com.mpl.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.MLogger;
import org.json.JSONObject;

public class FantasyWebViewActivity extends WebViewActivity {
    public static final String TAG = "FantasyWebView-->";

    public void closeWebView() {
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.stopLoading();
            this.mMPLWebView.removeAllViews();
            this.mMPLWebView.clearFocus();
            this.mMPLWebView.clearCache(true);
            this.mMPLWebView.clearFormData();
            this.mMPLWebView.clearHistory();
            this.mMPLWebView.clearMatches();
            this.mMPLWebView.onPause();
        }
        releaseScreenWakeLock();
        finishAndRemoveTask();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        MLogger.d(TAG, "onRestoreInstanceState: ");
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.restoreState(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MLogger.d(TAG, "onSaveInstanceState: ");
        WebView webView = this.mMPLWebView;
        if (webView != null) {
            webView.saveState(bundle);
        }
    }

    public void startPayment(String str) {
        try {
            Intent intent = new Intent(MPLApplication.getInstance(), MPLReactContainerActivity.class);
            Bundle bundle = new Bundle();
            this.mPostJsonData.put("startFor", "payment");
            bundle.putString("action", "OPEN_DEEP_LINK");
            intent.putExtra("actionTaken", "payment");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("entryFee", str);
            jSONObject.put("amount", str);
            jSONObject.put("from", "fantasyPredication");
            jSONObject.put("game", this.mPostJsonData);
            bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"AddMoney\",\"param\":" + jSONObject.toString() + "}}");
            intent.putExtras(bundle);
            startActivity(intent);
        } catch (Exception unused) {
            MLogger.d(TAG, "startPayment: ");
        }
    }
}
