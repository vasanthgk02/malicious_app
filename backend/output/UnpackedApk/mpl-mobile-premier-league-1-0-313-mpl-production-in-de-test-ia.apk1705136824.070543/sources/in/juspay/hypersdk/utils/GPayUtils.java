package in.juspay.hypersdk.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient;
import com.google.android.apps.nbu.paisa.inapp.client.api.Wallet;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import in.juspay.hypersdk.core.JuspayLogger;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.Labels.SDK;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentConstants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.ApiCall;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.services.FileProviderService;

public class GPayUtils {
    public static final String LOG_TAG = "GPayUtils";

    public static void handleError(SdkTracker sdkTracker, String str, Callback callback) {
        Bundle bundle = new Bundle();
        Message obtain = Message.obtain();
        obtain.what = PaymentConstants.GPAY_CONSTANT;
        bundle.putBoolean("error", true);
        bundle.putString("error_msg", str);
        sdkTracker.trackAction(ApiCall.SDK, "error", SDK.GPAY_UTILS, "handleerror", bundle);
        obtain.setData(bundle);
        callback.handleMessage(obtain);
    }

    @Keep
    public static void isGPayReadyToPay(Activity activity, Callback callback) {
        JuspayServices juspayServices = new JuspayServices(activity, null);
        FileProviderService fileProviderService = juspayServices.getFileProviderService();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            isReady(juspayServices, fileProviderService.readFromFile(activity.getApplicationContext(), "payments/in.juspay.gpay/gpay_ready_payload.json"), callback);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, ApiCall.SDK, SDK.GPAY_UTILS, "Exception while checking if GPay SDK is ready", e2);
            handleError(sdkTracker, e2.toString(), callback);
        }
    }

    public static void isReady(JuspayServices juspayServices, String str, Callback callback) {
        Context context = juspayServices.getContext();
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        Bundle bundle = new Bundle();
        Message obtain = Message.obtain();
        obtain.what = PaymentConstants.GPAY_CONSTANT;
        if (IntegrationUtils.isClassPresent("com.google.android.gms.common.api.ApiException", "com.google.android.gms.tasks.OnCompleteListener", "com.google.android.gms.tasks.Task", "com.google.android.apps.nbu.paisa.inapp.client.api.Wallet", "com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient")) {
            PaymentsClient paymentsClient = Wallet.paymentsClient;
            final boolean isGooglePayInstalled = paymentsClient.isGooglePayInstalled(context, 2);
            final boolean isGooglePayInstalled2 = paymentsClient.isGooglePayInstalled(context, 1);
            if (isGooglePayInstalled) {
                Task<Boolean> isReadyToPay = paymentsClient.isReadyToPay(context, str);
                final Bundle bundle2 = bundle;
                final SdkTracker sdkTracker2 = sdkTracker;
                final Message message = obtain;
                final Callback callback2 = callback;
                AnonymousClass1 r1 = new OnCompleteListener<Boolean>() {
                    public void onComplete(Task<Boolean> task) {
                        try {
                            boolean booleanValue = ((Boolean) task.getResult(ApiException.class)).booleanValue();
                            bundle2.putBoolean("error", false);
                            bundle2.putBoolean("can_open", booleanValue);
                            bundle2.putBoolean("in_app_supported", isGooglePayInstalled);
                            bundle2.putBoolean("in_app_sdk", booleanValue);
                            bundle2.putBoolean("upi_intent", isGooglePayInstalled2);
                            sdkTracker2.trackApiCalls(ApiCall.SDK, "info", SDK.GPAY_UTILS, null, null, null, Long.valueOf(System.currentTimeMillis()), "isready", bundle2, null);
                            message.setData(bundle2);
                            callback2.handleMessage(message);
                        } catch (Exception e2) {
                            JuspayLogger.e(GPayUtils.LOG_TAG, "error while extracting the result: ", e2);
                            GPayUtils.handleError(sdkTracker2, e2.toString(), callback2);
                        }
                    }
                };
                isReadyToPay.addOnCompleteListener(r1);
                return;
            }
            bundle.putBoolean("error", false);
            bundle.putBoolean("can_open", isGooglePayInstalled2);
            bundle.putBoolean("in_app_supported", false);
            bundle.putBoolean("in_app_sdk", false);
            bundle.putBoolean("upi_intent", isGooglePayInstalled2);
            sdkTracker.trackAction(ApiCall.SDK, "info", SDK.GPAY_UTILS, "isready", bundle);
            obtain.setData(bundle);
            callback.handleMessage(obtain);
            return;
        }
        handleError(sdkTracker, "gpay class file not fount in path", callback);
    }

    public static void pay(Fragment fragment, String str) {
        if (IntegrationUtils.isClassPresent("com.google.android.apps.nbu.paisa.inapp.client.api.Wallet", "com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient")) {
            PaymentsClient paymentsClient = Wallet.paymentsClient;
            Context context = fragment.getContext();
            if (!paymentsClient.isTezInstalled(context, 2)) {
                fragment.startActivity(paymentsClient.getPlayStoreIntent(context));
                return;
            }
            try {
                fragment.startActivityForResult(paymentsClient.getTezIntent(context, str), 114);
            } catch (ActivityNotFoundException e2) {
                String.valueOf(e2).length();
                fragment.startActivity(paymentsClient.getPlayStoreIntent(context));
            }
        } else {
            throw new Exception("gpay class file not fount in path");
        }
    }
}
