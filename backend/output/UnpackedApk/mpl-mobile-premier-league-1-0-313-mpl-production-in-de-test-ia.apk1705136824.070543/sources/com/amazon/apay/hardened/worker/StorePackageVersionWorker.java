package com.amazon.apay.hardened.worker;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.core.widget.CompoundButtonCompat;
import androidx.work.ListenableWorker.Result;
import androidx.work.ListenableWorker.Result.Success;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.netcore.android.SMTEventParamKeys;

public class StorePackageVersionWorker extends Worker {

    /* renamed from: a  reason: collision with root package name */
    public static String f3260a;

    /* renamed from: b  reason: collision with root package name */
    public static PackageManager f3261b;

    public StorePackageVersionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        f3260a = context.getPackageName();
        f3261b = context.getPackageManager();
    }

    public Result doWork() {
        String str;
        CompoundButtonCompat.f957b.a(SMTEventParamKeys.SMT_APP_ID, f3260a);
        try {
            str = f3261b.getPackageInfo("in.amazon.mShop.android.shopping", 0).versionName;
        } catch (NameNotFoundException unused) {
            str = null;
        }
        CompoundButtonCompat.f957b.a("amazonShoppingIndiaAppVersion", str);
        return new Success();
    }
}
