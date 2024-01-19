package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

public final class RequestBuilder {
    public static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    public final HttpUrl baseUrl;
    public RequestBody body;
    public MediaType contentType;
    public Builder formBuilder;
    public final boolean hasBody;
    public final Headers.Builder headersBuilder;
    public final String method;
    public MultipartBody.Builder multipartBuilder;
    public String relativeUrl;
    public final Request.Builder requestBuilder = new Request.Builder();
    public HttpUrl.Builder urlBuilder;

    public static class ContentTypeOverridingRequestBody extends RequestBody {
        public final MediaType contentType;
        public final RequestBody delegate;

        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        if (z2) {
            this.formBuilder = new Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.contentType = MediaType.get(str2);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Malformed content type: ", str2), e2);
            }
        } else {
            this.headersBuilder.add(str, str2);
        }
    }

    public void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.baseUrl.newBuilder(str3);
            this.urlBuilder = newBuilder;
            if (newBuilder != null) {
                this.relativeUrl = null;
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Malformed URL. Base: ");
                outline73.append(this.baseUrl);
                outline73.append(", Relative: ");
                outline73.append(this.relativeUrl);
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        if (z) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }
}
