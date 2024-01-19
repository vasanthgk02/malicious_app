package com.razorpay;

import android.app.Activity;

public final class g__v_$5 implements Callback {
    public /* synthetic */ Object a_$P$$3bb8a87a;

    public g__v_$5(Object obj) {
        this.a_$P$$3bb8a87a = obj;
    }

    public final void run(K$$z$ k$$z$) {
        if (k$$z$.G__G_() != null) {
            try {
                String versionFromJsonString = BaseUtils.getVersionFromJsonString(k$$z$.G__G_(), (String) ((Class) L__R$.G__G_(18, 64047, 18)).getField("a_$P$").get(null));
                String localVersion = BaseUtils.getLocalVersion((Activity) ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredField("R$$r_").get(this.a_$P$$3bb8a87a), (String) ((Class) L__R$.G__G_(18, 64047, 18)).getField("a_$P$").get(null));
                if (!localVersion.equals(versionFromJsonString)) {
                    Object obj = this.a_$P$$3bb8a87a;
                    Object[] objArr = new Object[2];
                    objArr[1] = versionFromJsonString;
                    objArr[0] = obj;
                    ((Class) L__R$.G__G_(18, 64047, 18)).getDeclaredMethod("G__G_", new Class[]{(Class) L__R$.G__G_(18, 64047, 18), String.class}).invoke(null, objArr);
                    return;
                }
                "OTPElf on latest version: ".concat(localVersion);
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2, "error", "Could not extract version from server json");
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
