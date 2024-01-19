package com.inca.security.Proxy;

import android.content.Context;
import android.support.multidex.MultiDex;
import com.inca.security.DexProtect.Binder;
import com.mpl.androidapp.MPLApplication;

public class AppGuardProxyApplication extends MPLApplication {
    public static native String IiIiIiiiii(Context context);

    private native void IiIiiIiIiI(Context context);

    public static native String iIIiIIiIIi();

    static {
        try {
            if (Binder.getABI() == 0) {
                System.loadLibrary("compatible");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        MultiDex.install(context);
        try {
            if (Binder.getABI() == 0) {
                iIiIiIiIii.iIiIIiIiiI(context, context.getClassLoader());
            }
        } catch (UnsatisfiedLinkError unused) {
        }
        super.attachBaseContext(context);
    }

    public void onCreate() {
        super.onCreate();
        JNISoxProxy.setApplicationContext(getApplicationContext());
        IiIiiIiIiI(this);
    }
}
