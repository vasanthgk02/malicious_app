package com.razorpay;

import android.app.Activity;

public class g__v_$1 implements Callback {
    public /* synthetic */ Object R$$r_$3bb8a87a;
    public /* synthetic */ String d__1_;

    public g__v_$1(Object obj, String str) {
        this.R$$r_$3bb8a87a = obj;
        this.d__1_ = str;
    }

    public final void run(K$$z$ k$$z$) {
        if (k$$z$.G__G_() != null) {
            String decryptFile = BaseUtils.decryptFile(k$$z$.G__G_());
            if (decryptFile != null) {
                if (BaseUtils.storeFileInInternal((Activity) ((Class) L__R$.G__G_(18, 64047, 18)).getField("R$$r_").get(this.R$$r_$3bb8a87a), BaseUtils.getVersionedAssetName(this.d__1_, Y$_o$.J$_0_().l_$w$()), k$$z$.G__G_())) {
                    Object obj = this.R$$r_$3bb8a87a;
                    try {
                        Object[] objArr = new Object[2];
                        objArr[1] = decryptFile;
                        objArr[0] = obj;
                        ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredMethod("a_$P$", new Class[]{(Class) L__R$.G__G_(18, 64047, 18), String.class}).invoke(null, objArr);
                        BaseUtils.updateLocalVersion((Activity) ((Class) L__R$.G__G_(18, 64047, 18)).getField("R$$r_").get(this.R$$r_$3bb8a87a), (String) ((Class) L__R$.G__G_(18, 64047, 18)).getField("a_$P$").get(null), this.d__1_);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
            }
        }
    }
}
