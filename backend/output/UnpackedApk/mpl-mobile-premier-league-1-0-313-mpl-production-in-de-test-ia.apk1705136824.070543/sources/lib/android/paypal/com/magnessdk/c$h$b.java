package lib.android.paypal.com.magnessdk;

import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.reactnativecommunity.webview.RNCWebViewManager;

public enum c$h$b {
    POST(RNCWebViewManager.HTTP_METHOD_POST),
    GET(HttpGetRequest.METHOD_GET);
    

    /* renamed from: c  reason: collision with root package name */
    public final String f6054c;

    /* access modifiers changed from: public */
    c$h$b(String str) {
        this.f6054c = str;
    }

    public String toString() {
        return this.f6054c;
    }
}
