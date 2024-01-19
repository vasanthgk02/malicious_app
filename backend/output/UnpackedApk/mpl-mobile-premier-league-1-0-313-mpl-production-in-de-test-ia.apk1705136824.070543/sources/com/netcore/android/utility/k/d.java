package com.netcore.android.utility.k;

import android.os.Build.VERSION;
import java.util.Objects;

/* compiled from: SMTEncryptionHelper */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final a f1324a;

    public d(String str) {
        if (!Objects.equals(str, "AES/GCM/NoPadding") || VERSION.SDK_INT < 23) {
            this.f1324a = null;
        } else {
            this.f1324a = new b();
        }
    }

    public static d a(String str) {
        return new d(str);
    }

    public a a() {
        return this.f1324a;
    }
}
