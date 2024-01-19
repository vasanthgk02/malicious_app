package com.inmobi.androidsdk.impl;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Message;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.ai.container.IMWebView.IMWebViewListener;
import com.inmobi.androidsdk.impl.AdUnit.AdActionNames;
import com.inmobi.androidsdk.impl.net.HttpRequestBuilder;
import com.inmobi.androidsdk.impl.net.RequestResponseManager;
import java.util.ArrayList;
import java.util.List;

public class ClickProcessingTask extends AsyncTask<Void, Void, String> {
    private final AdUnit mAdUnit;
    private final Context mAppContext;
    private IMWebViewListener mImWebViewListener;
    private Message mMessage;
    private final UserInfo mUserInfo;
    private Message onLeaveMessage;
    private Message onShowMessage;

    public ClickProcessingTask(AdUnit adunit, UserInfo uInfo, Context appCtx, Message message, Message onShowmessage, Message onLeavemessage, IMWebViewListener mImWebviewlistener) {
        this.mAdUnit = adunit;
        this.mUserInfo = uInfo;
        this.mAppContext = appCtx;
        this.mMessage = message;
        this.onShowMessage = onShowmessage;
        this.onLeaveMessage = onLeavemessage;
        this.mImWebViewListener = mImWebviewlistener;
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... params) {
        String targetRedirectUrl = null;
        try {
            RequestResponseManager requestResponseManager = new RequestResponseManager(this.mAppContext);
            List<String> arrayData = new ArrayList<>();
            arrayData.add("x-mkhoj-adactiontype");
            arrayData.add(this.mAdUnit.getAdActionName().toString());
            targetRedirectUrl = requestResponseManager.initiateClick(this.mAdUnit.getTargetUrl(), this.mUserInfo, arrayData);
            String newAdActionName = requestResponseManager.getNewAdActionType();
            if (newAdActionName != null) {
                this.mAdUnit.setAdActionName(AdUnit.adActionNamefromString(newAdActionName));
            }
        } catch (Exception exception) {
            Log.w(Constants.LOGGING_TAG, "Encountered generic exception initiating click", exception);
        }
        return targetRedirectUrl;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String targetRedirectUrl) {
        finishAdClick(targetRedirectUrl);
        try {
            if (this.mMessage != null) {
                this.mMessage.sendToTarget();
            }
        } catch (Exception e) {
        }
    }

    private void finishAdClick(String targetUrl) {
        if (targetUrl != null) {
            try {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "Click target URL: " + targetUrl);
                    Log.d(Constants.LOGGING_TAG, "AdActionName: " + this.mAdUnit.getAdActionName());
                }
                if (this.mAdUnit.getAdActionName() == AdActionNames.AdActionName_SMS) {
                    sendSMS(targetUrl);
                    if (this.onLeaveMessage != null) {
                        this.onLeaveMessage.sendToTarget();
                    }
                } else if (this.mAdUnit.getAdActionName() != AdActionNames.AdActionName_Web && this.mAdUnit.getAdActionName() != AdActionNames.AdActionName_Search) {
                    Intent adActionIntent = new Intent("android.intent.action.VIEW", Uri.parse(targetUrl));
                    adActionIntent.addFlags(268435456);
                    this.mAppContext.startActivity(adActionIntent);
                    if (this.onLeaveMessage != null) {
                        this.onLeaveMessage.sendToTarget();
                    }
                } else if (targetUrl.startsWith("https:") || targetUrl.startsWith("market:") || targetUrl.contains("play.google.com") || targetUrl.contains("market.android.com")) {
                    Intent adActionIntent2 = new Intent("android.intent.action.VIEW", Uri.parse(targetUrl));
                    adActionIntent2.addFlags(268435456);
                    this.mAppContext.startActivity(adActionIntent2);
                    if (this.onLeaveMessage != null) {
                        this.onLeaveMessage.sendToTarget();
                    }
                } else {
                    Intent intent = new Intent(this.mAppContext, IMBrowserActivity.class);
                    intent.putExtra(IMBrowserActivity.EXTRA_URL, targetUrl);
                    intent.putExtra(IMBrowserActivity.EXTRA_BROWSER_ACTIVITY_TYPE, IMBrowserActivity.EXTRA_BROWSER_STATUS_BAR);
                    intent.putExtra("FIRST_INSTANCE", "yes");
                    IMBrowserActivity.setWebViewListener(this.mImWebViewListener);
                    this.mAppContext.startActivity(intent);
                    if (this.onShowMessage != null) {
                        this.onShowMessage.sendToTarget();
                    }
                }
            } catch (ActivityNotFoundException exception) {
                Log.w(Constants.LOGGING_TAG, "Operation could not be performed : " + targetUrl, exception);
            } catch (Exception exception2) {
                Log.w(Constants.LOGGING_TAG, "Error executing post click actions on URL : " + targetUrl, exception2);
            }
        }
    }

    private void sendSMS(String targetUrl) {
        String extraData = null;
        int index = targetUrl.indexOf("&Body=", 0);
        if (index > 0) {
            extraData = targetUrl.substring("&Body=".length() + index);
            targetUrl = targetUrl.substring(0, index);
        }
        Intent adActionIntent = new Intent("android.intent.action.SENDTO", Uri.parse(targetUrl));
        adActionIntent.addFlags(268435456);
        adActionIntent.putExtra("compose_mode", true);
        if (extraData != null) {
            adActionIntent.putExtra("sms_body", HttpRequestBuilder.getURLDecoded(extraData, "UTF-8"));
        }
        this.mAppContext.startActivity(adActionIntent);
    }
}
