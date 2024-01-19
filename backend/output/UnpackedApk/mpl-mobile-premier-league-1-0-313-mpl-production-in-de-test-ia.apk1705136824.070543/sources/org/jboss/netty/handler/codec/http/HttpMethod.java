package org.jboss.netty.handler.codec.http;

import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.HashMap;
import java.util.Map;

public class HttpMethod implements Comparable<HttpMethod> {
    public static final HttpMethod CONNECT = new HttpMethod("CONNECT");
    public static final HttpMethod DELETE = new HttpMethod("DELETE");
    public static final HttpMethod GET = new HttpMethod(HttpGetRequest.METHOD_GET);
    public static final HttpMethod HEAD = new HttpMethod(BuildConfig.SCM_BRANCH);
    public static final HttpMethod OPTIONS = new HttpMethod("OPTIONS");
    public static final HttpMethod PATCH = new HttpMethod("PATCH");
    public static final HttpMethod POST = new HttpMethod(RNCWebViewManager.HTTP_METHOD_POST);
    public static final HttpMethod PUT = new HttpMethod("PUT");
    public static final HttpMethod TRACE = new HttpMethod("TRACE");
    public static final Map<String, HttpMethod> methodMap;
    public final String name;

    static {
        HashMap hashMap = new HashMap();
        methodMap = hashMap;
        hashMap.put(OPTIONS.toString(), OPTIONS);
        methodMap.put(GET.toString(), GET);
        methodMap.put(HEAD.toString(), HEAD);
        methodMap.put(POST.toString(), POST);
        methodMap.put(PUT.toString(), PUT);
        methodMap.put(PATCH.toString(), PATCH);
        methodMap.put(DELETE.toString(), DELETE);
        methodMap.put(TRACE.toString(), TRACE);
        methodMap.put(CONNECT.toString(), CONNECT);
    }

    public HttpMethod(String str) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.length() != 0) {
                for (int i = 0; i < upperCase.length(); i++) {
                    if (Character.isISOControl(upperCase.charAt(i)) || Character.isWhitespace(upperCase.charAt(i))) {
                        throw new IllegalArgumentException("invalid character in name");
                    }
                }
                this.name = upperCase;
                return;
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException("name");
    }

    public static HttpMethod valueOf(String str) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.length() != 0) {
                HttpMethod httpMethod = methodMap.get(upperCase);
                if (httpMethod != null) {
                    return httpMethod;
                }
                return new HttpMethod(upperCase);
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException("name");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpMethod)) {
            return false;
        }
        return getName().equals(((HttpMethod) obj).getName());
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public String toString() {
        return getName();
    }

    public int compareTo(HttpMethod httpMethod) {
        return getName().compareTo(httpMethod.getName());
    }
}
