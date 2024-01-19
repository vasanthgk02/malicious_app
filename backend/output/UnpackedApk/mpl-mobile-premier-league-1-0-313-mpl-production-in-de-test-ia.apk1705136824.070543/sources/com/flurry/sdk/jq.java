package com.flurry.sdk;

import android.content.Context;
import java.io.File;

public class jq {

    /* renamed from: d  reason: collision with root package name */
    public final File f1695d;

    /* renamed from: e  reason: collision with root package name */
    public String f1696e;

    public jq(Context context) {
        this.f1695d = context.getFileStreamPath(".flurryinstallreceiver.");
        "Referrer file name if it exists:  " + this.f1695d;
    }
}
