package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public int f4378a = 0;

    /* renamed from: a  reason: collision with other field name */
    public String f230a = "";

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof r)) {
            r rVar = (r) obj;
            if (!TextUtils.isEmpty(rVar.f230a) && rVar.f230a.equals(this.f230a)) {
                return true;
            }
        }
        return false;
    }
}
