package extern.okhttp3.internal.connection;

import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import extern.okhttp3.Interceptor;
import extern.okhttp3.Interceptor.Chain;
import extern.okhttp3.OkHttpClient;
import extern.okhttp3.Request;
import extern.okhttp3.Response;
import extern.okhttp3.internal.http.RealInterceptorChain;
import java.io.IOException;

public final class ConnectInterceptor implements Interceptor {
    public final OkHttpClient client;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public Response intercept(Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        StreamAllocation streamAllocation = realInterceptorChain.streamAllocation();
        return realInterceptorChain.proceed(request, streamAllocation, streamAllocation.newStream(this.client, chain, !request.method().equals(HttpGetRequest.METHOD_GET)), streamAllocation.connection());
    }
}
