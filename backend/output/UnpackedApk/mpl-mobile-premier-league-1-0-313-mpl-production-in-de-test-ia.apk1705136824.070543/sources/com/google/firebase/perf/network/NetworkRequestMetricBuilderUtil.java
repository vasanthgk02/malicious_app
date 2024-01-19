package com.google.firebase.perf.network;

import com.facebook.react.modules.network.NetworkingModule;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric.Builder;
import com.google.firebase.perf.v1.NetworkRequestMetric.NetworkClientErrorReason;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

public final class NetworkRequestMetricBuilderUtil {
    public static final Pattern FLG_USER_AGENT_PATTERN = Pattern.compile("(^|.*\\s)datatransport/\\S+ android/($|\\s.*)");

    public static Long getApacheHttpMessageContentLength(HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
        } catch (NumberFormatException unused) {
            AndroidLogger.getInstance().debug("The content-length value is not a valid number");
        }
        return null;
    }

    public static String getApacheHttpResponseContentType(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader(NetworkingModule.CONTENT_TYPE_HEADER_NAME);
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    public static boolean isAllowedUserAgent(String str) {
        return str == null || !FLG_USER_AGENT_PATTERN.matcher(str).matches();
    }

    public static void logError(NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        if (!((NetworkRequestMetric) networkRequestMetricBuilder.builder.instance).hasHttpResponseCode()) {
            Builder builder = networkRequestMetricBuilder.builder;
            NetworkClientErrorReason networkClientErrorReason = NetworkClientErrorReason.GENERIC_CLIENT_ERROR;
            builder.copyOnWrite();
            NetworkRequestMetric.access$1000((NetworkRequestMetric) builder.instance, networkClientErrorReason);
        }
        networkRequestMetricBuilder.build();
    }
}
