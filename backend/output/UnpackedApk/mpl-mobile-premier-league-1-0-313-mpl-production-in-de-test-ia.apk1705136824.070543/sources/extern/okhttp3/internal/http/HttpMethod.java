package extern.okhttp3.internal.http;

import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.reactnativecommunity.webview.RNCWebViewManager;

public final class HttpMethod {
    public static boolean invalidatesCache(String str) {
        return str.equals(RNCWebViewManager.HTTP_METHOD_POST) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals(RNCWebViewManager.HTTP_METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean permitsRequestBody(String str) {
        return !str.equals(HttpGetRequest.METHOD_GET) && !str.equals(BuildConfig.SCM_BRANCH);
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    private HttpMethod() {
    }
}
