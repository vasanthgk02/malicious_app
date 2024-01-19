package okhttp3.internal.http;

import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.razorpay.AnalyticsConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: HttpMethod.kt */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    public static final boolean permitsRequestBody(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.METHOD);
        return !Intrinsics.areEqual(str, HttpGetRequest.METHOD_GET) && !Intrinsics.areEqual(str, BuildConfig.SCM_BRANCH);
    }

    public static final boolean requiresRequestBody(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.METHOD);
        return Intrinsics.areEqual(str, RNCWebViewManager.HTTP_METHOD_POST) || Intrinsics.areEqual(str, "PUT") || Intrinsics.areEqual(str, "PATCH") || Intrinsics.areEqual(str, "PROPPATCH") || Intrinsics.areEqual(str, "REPORT");
    }

    public final boolean invalidatesCache(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.METHOD);
        return Intrinsics.areEqual(str, RNCWebViewManager.HTTP_METHOD_POST) || Intrinsics.areEqual(str, "PATCH") || Intrinsics.areEqual(str, "PUT") || Intrinsics.areEqual(str, "DELETE") || Intrinsics.areEqual(str, "MOVE");
    }

    public final boolean redirectsToGet(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.METHOD);
        return !Intrinsics.areEqual(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.METHOD);
        return Intrinsics.areEqual(str, "PROPFIND");
    }
}
