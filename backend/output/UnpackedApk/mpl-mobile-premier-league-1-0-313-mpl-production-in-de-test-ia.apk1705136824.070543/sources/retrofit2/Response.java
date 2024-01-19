package retrofit2;

import java.util.Objects;
import okhttp3.Headers;
import okhttp3.ResponseBody;

public final class Response<T> {
    public final T body;
    public final ResponseBody errorBody;
    public final okhttp3.Response rawResponse;

    public Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    public static <T> Response<T> success(T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public int code() {
        return this.rawResponse.code();
    }

    public Headers headers() {
        return this.rawResponse.headers();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
