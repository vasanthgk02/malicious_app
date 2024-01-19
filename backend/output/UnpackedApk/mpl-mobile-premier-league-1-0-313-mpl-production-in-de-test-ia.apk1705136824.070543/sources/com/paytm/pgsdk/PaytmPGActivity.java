package com.paytm.pgsdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.resources.TextAppearanceConfig;
import java.util.HashMap;

public class PaytmPGActivity extends Activity {
    public Dialog mDlg;
    public volatile Bundle mParams;
    public volatile ProgressBar mProgress;
    public volatile PaytmWebView mWV;
    public boolean mbHideHeader;
    public boolean mbSendAllChecksumResponseParametersToPGServer;
    public String paramsString;
    public String urlString;

    public final synchronized void cancelTransaction() {
        TextAppearanceConfig.debugLog("Displaying Confirmation Dialog");
        Builder builder = new Builder(this, 16974374);
        builder.setTitle("Cancel Transaction");
        builder.setMessage("Are you sure you want to cancel transaction");
        builder.setPositiveButton("Yes", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PaytmPGActivity.this.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                PaytmPGActivity.this.mDlg.dismiss();
            }
        });
        AlertDialog create = builder.create();
        this.mDlg = create;
        create.show();
    }

    public final synchronized boolean initUI() {
        try {
            if (getIntent() != null) {
                this.mbHideHeader = getIntent().getBooleanExtra("HIDE_HEADER", false);
                this.mbSendAllChecksumResponseParametersToPGServer = getIntent().getBooleanExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", false);
            }
            TextAppearanceConfig.debugLog("Hide Header " + this.mbHideHeader);
            TextAppearanceConfig.debugLog("Initializing the UI of Transaction Page...");
            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setLayoutParams(new LayoutParams(-1, -2));
            relativeLayout2.setId(1);
            relativeLayout2.setBackgroundColor(Color.parseColor("#bdbdbd"));
            Button button = new Button(this, null, 16842825);
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.leftMargin = (int) (getResources().getDisplayMetrics().density * 5.0f);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TextAppearanceConfig.debugLog("User pressed back button which is present in Header Bar.");
                    PaytmPGActivity.this.cancelTransaction();
                }
            });
            button.setLayoutParams(layoutParams);
            button.setText("Cancel");
            TextView textView = new TextView(this);
            LayoutParams layoutParams2 = new LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            textView.setLayoutParams(layoutParams2);
            textView.setTextColor(-16777216);
            textView.setText("Paytm Payments");
            relativeLayout2.addView(button);
            relativeLayout2.addView(textView);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            LayoutParams layoutParams3 = new LayoutParams(-1, -1);
            layoutParams3.addRule(3, relativeLayout2.getId());
            relativeLayout3.setLayoutParams(layoutParams3);
            this.mWV = new PaytmWebView(this);
            this.mWV.setVisibility(8);
            this.mWV.setLayoutParams(new LayoutParams(-1, -1));
            this.mProgress = new ProgressBar(this, null, 16842873);
            LayoutParams layoutParams4 = new LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            this.mProgress.setLayoutParams(layoutParams4);
            relativeLayout3.addView(this.mWV);
            relativeLayout3.addView(this.mProgress);
            relativeLayout.addView(relativeLayout2);
            relativeLayout.addView(relativeLayout3);
            if (this.mbHideHeader) {
                relativeLayout2.setVisibility(8);
            }
            requestWindowFeature(1);
            setContentView(relativeLayout);
            TextAppearanceConfig.debugLog("Initialized UI of Transaction Page.");
        } catch (Exception e2) {
            TextAppearanceConfig.debugLog("Some exception occurred while initializing UI.");
            TextAppearanceConfig.printStackTrace(e2);
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        PaytmPGService.getService().getmPaymentTransactionCallback().onBackPressedCancelTransaction();
        super.onBackPressed();
    }

    public synchronized void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            onRestore(bundle);
        }
        if (initUI()) {
            startTransaction();
        } else {
            finish();
            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = PaytmPGService.getService().getmPaymentTransactionCallback();
            if (paytmPaymentTransactionCallback != null) {
                paytmPaymentTransactionCallback.someUIErrorOccurred("Some error occured while initializing UI of Payment Gateway Activity");
            }
        }
    }

    public synchronized void onDestroy() {
        super.onDestroy();
        try {
            PaytmPGService.getService().stopService();
        } catch (Exception e2) {
            PaytmPGService.getService().stopService();
            TextAppearanceConfig.debugLog("Some exception occurred while destroying the PaytmPGActivity.");
            TextAppearanceConfig.printStackTrace(e2);
        }
        return;
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        TextAppearanceConfig.debugLog("User pressed key and key code is " + i);
        if (i == 4) {
            TextAppearanceConfig.debugLog("User pressed hard key back button");
            cancelTransaction();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onRestore(Bundle bundle) {
        if (SaveReferences.getInstance().isProduction) {
            PaytmPGService.getProductionService();
        } else {
            PaytmPGService.getStagingService();
        }
        TextAppearanceConfig.debugLog("Came in onRestoreInstanceState");
        this.mbHideHeader = bundle.getBoolean("HIDE_HEADER");
        this.mbSendAllChecksumResponseParametersToPGServer = bundle.getBoolean("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER");
        this.mParams = bundle.getBundle("Parameters");
        this.paramsString = bundle.getString("Parameters_String");
        this.urlString = bundle.getString("Url_String");
        PaytmPGService.getService().mOrder = new PaytmOrder((HashMap) bundle.getSerializable("Paytm_Order"));
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TextAppearanceConfig.debugLog("Came in onSaveInstanceState");
        bundle.putBoolean("HIDE_HEADER", this.mbHideHeader);
        bundle.putBoolean("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", this.mbSendAllChecksumResponseParametersToPGServer);
        bundle.putBundle("Parameters", this.mParams);
        bundle.putString("Parameters_String", this.paramsString);
        bundle.putString("Url_String", this.urlString);
        bundle.putSerializable("Paytm_Order", PaytmPGService.getService().mOrder.requestParamMap);
    }

    public final synchronized void startTransaction() {
        TextAppearanceConfig.debugLog("Starting the Process...");
        if (!(getIntent() == null || getIntent().getBundleExtra("Parameters") == null)) {
            this.mParams = getIntent().getBundleExtra("Parameters");
            if (this.mParams != null && this.mParams.size() > 0) {
                TextAppearanceConfig.debugLog("Starting the Client Authentication...");
                if (PaytmPGService.getService() != null) {
                    this.mWV.setVisibility(0);
                    this.mWV.postUrl(PaytmPGService.getService().mPGURL, TextAppearanceConfig.getURLEncodedStringFromBundle(this.mParams).getBytes());
                    this.mWV.requestFocus(130);
                    if (PaytmPGService.getService().mOrder.requestParamMap.get("prenotificationurl") != null) {
                        Intent intent = new Intent(getApplicationContext(), IntentServicePreNotification.class);
                        intent.putExtra("url", PaytmPGService.getService().mOrder.requestParamMap.get("prenotificationurl"));
                        getApplicationContext().startService(intent);
                    }
                }
            }
        }
    }
}
