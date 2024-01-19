package com.cardinalcommerce.shared.cs.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2109a = true;

    /* renamed from: b  reason: collision with root package name */
    public String f2110b = "";

    public void a(String str) {
        if (!this.f2110b.equals("")) {
            str = GeneratedOutlineSupport.outline63(new StringBuilder(), this.f2110b, ",", str);
        }
        this.f2110b = str;
    }

    public void a(boolean z) {
        if (!z) {
            this.f2109a = false;
        }
    }

    public void a(boolean z, String str) {
        if (!z) {
            a(false);
            a(str);
        }
    }
}
