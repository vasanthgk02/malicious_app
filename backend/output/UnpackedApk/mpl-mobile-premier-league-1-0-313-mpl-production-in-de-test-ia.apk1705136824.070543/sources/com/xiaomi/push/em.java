package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;

public class em {

    /* renamed from: a  reason: collision with root package name */
    public final byte f4765a;

    /* renamed from: a  reason: collision with other field name */
    public final String f754a;

    /* renamed from: a  reason: collision with other field name */
    public final short f755a;

    public em() {
        this("", 0, 0);
    }

    public em(String str, byte b2, short s) {
        this.f754a = str;
        this.f4765a = b2;
        this.f755a = s;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<TField name:'");
        outline73.append(this.f754a);
        outline73.append("' type:");
        outline73.append(this.f4765a);
        outline73.append(" field-id:");
        return GeneratedOutlineSupport.outline57(outline73, this.f755a, ">");
    }
}
