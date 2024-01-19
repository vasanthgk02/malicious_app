package com.netcore.android.f;

import android.location.Location;

/* compiled from: SMTLocationCallback.kt */
public interface b {
    void onLocationFetchFailed(Exception exc);

    void onLocationFetchSuccess(Location location);
}
