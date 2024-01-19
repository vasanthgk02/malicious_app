package com.inca.security.Proxy;

import android.os.Handler.Callback;
import android.os.Message;

public class AppGuardProxyHandler implements Callback {
    private static AppGuardProxyHandler mInstance;

    private native boolean iiIiIIiIIi(Message message);

    public static synchronized AppGuardProxyHandler getInstance() {
        AppGuardProxyHandler appGuardProxyHandler;
        synchronized (AppGuardProxyHandler.class) {
            if (mInstance == null) {
                mInstance = new AppGuardProxyHandler();
            }
            appGuardProxyHandler = mInstance;
        }
        return appGuardProxyHandler;
    }

    private AppGuardProxyHandler() {
    }

    public boolean handleMessage(Message message) {
        return iiIiIIiIIi(message);
    }
}
