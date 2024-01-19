package com.google.android.apps.nbu.paisa.inapp.client.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.apps.nbu.paisa.inapp.aidl.IIsReadyToPayService;
import com.google.android.apps.nbu.paisa.inapp.aidl.IIsReadyToPayServiceCallback.Stub;
import com.google.android.apps.nbu.paisa.inapp.aidl.IsReadyToPayRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@SuppressLint({"PackageManagerGetSignatures"})
public final class PaymentsClient {
    public TezPackageInfo tezPackageInfo;

    public static final class IsReadyToPayServiceConnection implements ServiceConnection {
        public final Context applicationContext;
        public final TaskCompletionSource<Boolean> isReadyToPayCompletionSource;
        public IIsReadyToPayService isReadyToPayService;
        public final String request;
        public Boolean serviceBound = Boolean.TRUE;

        public IsReadyToPayServiceConnection(TaskCompletionSource<Boolean> taskCompletionSource, String str, Context context) {
            this.isReadyToPayCompletionSource = taskCompletionSource;
            this.request = str;
            this.applicationContext = context.getApplicationContext();
        }

        public final synchronized void disconnect() {
            if (this.serviceBound.booleanValue()) {
                this.serviceBound = Boolean.FALSE;
                this.applicationContext.unbindService(this);
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AnonymousClass1 r3 = new Stub() {
            };
            IIsReadyToPayService asInterface = IIsReadyToPayService.Stub.asInterface(iBinder);
            this.isReadyToPayService = asInterface;
            try {
                asInterface.isReadyToPay(new IsReadyToPayRequest(this.request), r3);
            } catch (RemoteException e2) {
                throw new RuntimeException("isReadyToPay error: ", e2);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            disconnect();
        }
    }

    public final Intent getPlayStoreIntent(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(String.format("market://details?id=%s", new Object[]{getTezPackageInfo(context).packageName})));
        return intent;
    }

    public final Intent getTezIntent(Context context, String str) {
        Bundle outline14 = GeneratedOutlineSupport.outline14("paymentDataRequestJson", str);
        Intent intent = new Intent("com.google.android.apps.nbu.paisa.user.LOAD_PAYMENT_DATA");
        intent.setPackage(getTezPackageInfo(context).packageName);
        intent.putExtras(outline14);
        return intent;
    }

    public final TezPackageInfo getTezPackageInfo(Context context) {
        if (this.tezPackageInfo == null) {
            this.tezPackageInfo = new TezPackageInfo(context, R$raw.tez_inapp_api_config);
        }
        return this.tezPackageInfo;
    }

    public Task<Boolean> isReadyToPay(Context context, String str) throws NoSuchAlgorithmException {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!isTezInstalled(context, 2)) {
            taskCompletionSource.zza.zzb(Boolean.FALSE);
            return taskCompletionSource.zza;
        }
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("com.google.android.apps.nbu.paisa.user.inapp.sdk.service.IS_READY_TO_PAY");
        intent.setPackage(this.tezPackageInfo.packageName);
        try {
            if (!applicationContext.bindService(intent, new IsReadyToPayServiceConnection(taskCompletionSource, str, applicationContext), 1)) {
                taskCompletionSource.zza.zzb(Boolean.FALSE);
            }
            return taskCompletionSource.zza;
        } catch (SecurityException e2) {
            throw e2;
        }
    }

    public boolean isTezInstalled(Context context, int i) throws NoSuchAlgorithmException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getTezPackageInfo(context).packageName, 64);
            if ((i & 2) == 2) {
                long j = getTezPackageInfo(context).minimumTezSdkVersion;
                String.format("Tez package version: %d [minimum: %d]", new Object[]{Integer.valueOf(packageInfo.versionCode), Long.valueOf(j)});
                if (((long) packageInfo.versionCode) < j) {
                    return false;
                }
            }
            if (packageInfo.signatures.length != 1) {
                return false;
            }
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(packageInfo.signatures[0].toByteArray());
            byte[] bArr = getTezPackageInfo(context).signatureHash;
            String.format("Tez signature: %s [expected: %s]", new Object[]{Base64.encodeToString(digest, 2), Base64.encodeToString(bArr, 2)});
            return Arrays.equals(digest, bArr);
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public void loadPaymentData(Activity activity, String str, int i) throws NoSuchAlgorithmException {
        Context applicationContext = activity.getApplicationContext();
        if (!isTezInstalled(applicationContext, 2)) {
            activity.startActivity(getPlayStoreIntent(applicationContext));
            return;
        }
        try {
            activity.startActivityForResult(getTezIntent(applicationContext, str), i);
        } catch (ActivityNotFoundException unused) {
            activity.startActivity(getPlayStoreIntent(applicationContext));
        }
    }
}
