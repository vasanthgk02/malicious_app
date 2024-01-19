package com.paytm.pgsdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.material.resources.TextAppearanceConfig;

public class PaytmPGService {
    public static volatile PaytmPGService mService;
    public volatile PaytmOrder mOrder;
    public volatile String mPGURL;
    public volatile PaytmPaymentTransactionCallback mPaymentTransactionCallback;
    public volatile String mStatusQueryURL;
    public volatile boolean mbServiceRunning;

    public static synchronized PaytmPGService getProductionService() {
        PaytmPGService service;
        synchronized (PaytmPGService.class) {
            try {
                service = getService();
                service.mStatusQueryURL = "https://secure.paytm.in/oltp/HANDLER_INTERNAL/TXNSTATUS";
                service.mPGURL = "https://securegw.paytm.in/theia/processTransaction";
                SaveReferences.getInstance().isProduction = true;
            }
        }
        return service;
    }

    public static synchronized PaytmPGService getService() {
        PaytmPGService paytmPGService;
        synchronized (PaytmPGService.class) {
            try {
                if (mService == null) {
                    TextAppearanceConfig.debugLog("Creating an instance of Paytm PG Service...");
                    mService = new PaytmPGService();
                    TextAppearanceConfig.debugLog("Created a new instance of Paytm PG Service.");
                }
            } catch (Exception e2) {
                TextAppearanceConfig.printStackTrace(e2);
            }
            paytmPGService = mService;
        }
        return paytmPGService;
    }

    public static synchronized PaytmPGService getStagingService() {
        PaytmPGService service;
        synchronized (PaytmPGService.class) {
            try {
                service = getService();
                service.mStatusQueryURL = "https://pguat.paytm.com/oltp/HANDLER_INTERNAL/TXNSTATUS";
                service.mPGURL = "https://securegw-stage.paytm.in/theia/processTransaction";
                SaveReferences.getInstance().isProduction = false;
            }
        }
        return service;
    }

    public void enableLog(Context context) {
        ApplicationInfo applicationInfo;
        boolean z = false;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            int i = applicationInfo.flags & 2;
            applicationInfo.flags = i;
            if (i != 0) {
                z = true;
            }
            Log.ENABLE_DEBUG_LOG = z;
            return;
        }
        Log.ENABLE_DEBUG_LOG = false;
    }

    public PaytmPaymentTransactionCallback getmPaymentTransactionCallback() {
        if (this.mPaymentTransactionCallback == null) {
            return SaveReferences.getInstance().paytmPaymentTransactionCallback;
        }
        return this.mPaymentTransactionCallback;
    }

    public synchronized void stopService() {
        mService = null;
        TextAppearanceConfig.debugLog("Service Stopped.");
    }
}
