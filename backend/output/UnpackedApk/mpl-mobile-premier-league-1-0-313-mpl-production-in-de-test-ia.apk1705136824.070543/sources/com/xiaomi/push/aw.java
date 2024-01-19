package com.xiaomi.push;

import android.content.Context;

public class aw {

    /* renamed from: a  reason: collision with root package name */
    public static volatile aw f4465a;

    /* renamed from: a  reason: collision with other field name */
    public Context f327a;

    public aw(Context context) {
        this.f327a = context;
    }

    public static aw a(Context context) {
        if (f4465a == null) {
            synchronized (aw.class) {
                try {
                    if (f4465a == null) {
                        f4465a = new aw(context);
                    }
                }
            }
        }
        return f4465a;
    }

    @Deprecated
    public void a(String str, String str2, String str3, String str4) {
    }
}
