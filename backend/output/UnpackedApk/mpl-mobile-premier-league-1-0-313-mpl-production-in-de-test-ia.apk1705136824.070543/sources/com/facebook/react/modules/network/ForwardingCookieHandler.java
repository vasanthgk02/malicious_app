package com.facebook.react.modules.network;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;

public class ForwardingCookieHandler extends CookieHandler {
    public final ReactContext mContext;
    public CookieManager mCookieManager;
    public final CookieSaver mCookieSaver = new CookieSaver();

    public class CookieSaver {
        public final Handler mHandler;

        public CookieSaver() {
            this.mHandler = new Handler(Looper.getMainLooper(), new Callback(ForwardingCookieHandler.this) {
                public boolean handleMessage(Message message) {
                    if (message.what != 1) {
                        return false;
                    }
                    CookieSaver cookieSaver = CookieSaver.this;
                    cookieSaver.mHandler.removeMessages(1);
                    ForwardingCookieHandler.access$400(ForwardingCookieHandler.this, new Runnable() {
                        public void run() {
                            ForwardingCookieHandler.access$200();
                            CookieManager cookieManager = ForwardingCookieHandler.this.getCookieManager();
                            if (cookieManager != null) {
                                cookieManager.flush();
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }

    public ForwardingCookieHandler(ReactContext reactContext) {
        this.mContext = reactContext;
    }

    public static /* synthetic */ boolean access$200() {
        return false;
    }

    public static void access$400(ForwardingCookieHandler forwardingCookieHandler, final Runnable runnable) {
        if (forwardingCookieHandler != null) {
            new GuardedAsyncTask<Void, Void>(forwardingCookieHandler, forwardingCookieHandler.mContext) {
                public void doInBackgroundGuarded(Object[] objArr) {
                    Void[] voidArr = (Void[]) objArr;
                    runnable.run();
                }
            }.execute(new Void[0]);
            return;
        }
        throw null;
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager == null) {
            return Collections.emptyMap();
        }
        String cookie = cookieManager.getCookie(uri.toString());
        if (TextUtils.isEmpty(cookie)) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap(Names.COOKIE, Collections.singletonList(cookie));
    }

    public final CookieManager getCookieManager() {
        if (this.mCookieManager == null) {
            try {
                this.mCookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException unused) {
                return null;
            } catch (Exception e2) {
                if (e2.getMessage() != null && e2.getClass().getCanonicalName().equals("android.webkit.WebViewFactory.MissingWebViewPackageException")) {
                    return null;
                }
                throw e2;
            }
        }
        return this.mCookieManager;
    }

    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        String uri2 = uri.toString();
        for (Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (str != null) {
                if (str.equalsIgnoreCase("Set-cookie") || str.equalsIgnoreCase("Set-cookie2")) {
                    List<String> list = (List) next.getValue();
                    CookieManager cookieManager = getCookieManager();
                    if (cookieManager == null) {
                        continue;
                    } else {
                        for (String str2 : list) {
                            CookieManager cookieManager2 = getCookieManager();
                            if (cookieManager2 != null) {
                                cookieManager2.setCookie(uri2, str2, null);
                            }
                        }
                        cookieManager.flush();
                        if (this.mCookieSaver == null) {
                            throw null;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }
}
