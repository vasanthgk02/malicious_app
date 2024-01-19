package com.freshchat.consumer.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

public interface FreshchatWebViewListener {
    void onLocaleChangedByWebView(WeakReference<Context> weakReference);
}
