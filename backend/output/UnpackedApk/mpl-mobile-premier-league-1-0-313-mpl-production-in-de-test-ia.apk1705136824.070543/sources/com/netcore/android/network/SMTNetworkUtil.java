package com.netcore.android.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.netcore.android.logger.SMTLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/netcore/android/network/SMTNetworkUtil;", "", "Landroid/content/Context;", "context", "", "hasInternetConnection", "(Landroid/content/Context;)Z", "hasInternetConnectionAvailable", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNetworkUtil.kt */
public final class SMTNetworkUtil {
    public static final SMTNetworkUtil INSTANCE = new SMTNetworkUtil();

    public final boolean hasInternetConnection(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            sMTLogger.internal("SMTNetworkUtil", "Value of networkInfo : " + activeNetworkInfo);
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final boolean hasInternetConnectionAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (VERSION.SDK_INT >= 23) {
            Object systemService = context.getSystemService("connectivity");
            if (systemService != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                SMTLogger.INSTANCE.v("NetworkUtil", "connectivityManager not is null");
                Network activeNetwork = connectivityManager.getActiveNetwork();
                Intrinsics.checkNotNullExpressionValue(activeNetwork, "connectivityManager.activeNetwork");
                SMTLogger.INSTANCE.v("NetworkUtil", "network not is null");
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                    return false;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
        }
        return true;
    }
}
