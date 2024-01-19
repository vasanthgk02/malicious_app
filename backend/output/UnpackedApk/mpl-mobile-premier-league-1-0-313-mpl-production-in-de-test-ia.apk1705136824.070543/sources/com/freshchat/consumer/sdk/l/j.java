package com.freshchat.consumer.sdk.l;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.d;

public class j extends b {
    private void F(Context context, String str) {
        if (!as.isEmpty(str)) {
            User bF = d.bF(context);
            if (!as.o(str, bF.getEmail())) {
                bF.setEmail(str);
                d.b(context, bF);
            }
        }
    }

    private String cf(Context context) {
        return w(context).bi();
    }

    private e w(Context context) {
        return e.i(context);
    }

    public String C(Context context) {
        return w(context).bj();
    }

    public void D(Context context, String str) {
        w(context).bn(str);
        if (as.isEmpty(cf(context))) {
            F(context, str);
        }
    }

    public String cd(Context context) {
        return w(context).hA();
    }

    public String ce(Context context) {
        String hA = w(context).hA();
        return as.a(hA) ? hA : cf(context);
    }
}
