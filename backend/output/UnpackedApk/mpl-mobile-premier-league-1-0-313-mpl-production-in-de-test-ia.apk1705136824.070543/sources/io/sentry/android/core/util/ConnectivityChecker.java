package io.sentry.android.core.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.razorpay.AnalyticsConstants;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.IBuildInfoProvider;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class ConnectivityChecker {

    public enum Status {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    public static Status getConnectionStatus(Context context, ILogger iLogger) {
        ConnectivityManager connectivityManager = getConnectivityManager(context, iLogger);
        if (connectivityManager == null) {
            return Status.UNKNOWN;
        }
        return getConnectionStatus(context, connectivityManager, iLogger);
    }

    @SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    public static String getConnectionType(Context context, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider) {
        boolean z;
        ConnectivityManager connectivityManager = getConnectivityManager(context, iLogger);
        if (connectivityManager == null) {
            return null;
        }
        boolean z2 = false;
        if (!Permissions.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.log(SentryLevel.INFO, (String) "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        boolean z3 = true;
        if (iBuildInfoProvider.getSdkInfoVersion() >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                iLogger.log(SentryLevel.INFO, (String) "Network is null and cannot check network status", new Object[0]);
                return null;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                iLogger.log(SentryLevel.INFO, (String) "NetworkCapabilities is null and cannot check network type", new Object[0]);
                return null;
            }
            boolean hasTransport = networkCapabilities.hasTransport(3);
            z = networkCapabilities.hasTransport(1);
            z3 = networkCapabilities.hasTransport(0);
            z2 = hasTransport;
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                iLogger.log(SentryLevel.INFO, (String) "NetworkInfo is null, there's no active network.", new Object[0]);
                return null;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    z = true;
                } else if (type != 9) {
                    z = false;
                } else {
                    z = false;
                    z2 = true;
                }
                z3 = false;
            } else {
                z = false;
            }
        }
        if (z2) {
            return "ethernet";
        }
        if (z) {
            return AnalyticsConstants.WIFI;
        }
        if (z3) {
            return AnalyticsConstants.CELLULAR;
        }
        return null;
    }

    public static ConnectivityManager getConnectivityManager(Context context, ILogger iLogger) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            iLogger.log(SentryLevel.INFO, (String) "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    public static Status getConnectionStatus(Context context, ConnectivityManager connectivityManager, ILogger iLogger) {
        if (!Permissions.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            iLogger.log(SentryLevel.INFO, (String) "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return Status.NO_PERMISSION;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            iLogger.log(SentryLevel.INFO, (String) "NetworkInfo is null, there's no active network.", new Object[0]);
            return Status.NOT_CONNECTED;
        }
        return activeNetworkInfo.isConnected() ? Status.CONNECTED : Status.NOT_CONNECTED;
    }
}
