package com.unity3d.player;

import android.os.Build.VERSION;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3500a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f3501b = true;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f3502c = (VERSION.SDK_INT >= 23);

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3503d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f3504e = (f3502c ? new g() : null);

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 24) {
            z = false;
        }
        f3503d = z;
    }
}
