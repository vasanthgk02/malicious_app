package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FirebasePerfOkHttpClient {
    @Keep
    public static void enqueue(Call call, Callback callback) {
        Timer timer = new Timer();
        Callback callback2 = callback;
        InstrumentOkHttpEnqueueCallback instrumentOkHttpEnqueueCallback = new InstrumentOkHttpEnqueueCallback(callback2, TransportManager.instance, timer, timer.timeInMicros);
        call.enqueue(instrumentOkHttpEnqueueCallback);
    }

    @Keep
    public static Response execute(Call call) throws IOException {
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long nanoTime = System.nanoTime();
        try {
            Response execute = call.execute();
            sendNetworkMetric(execute, networkRequestMetricBuilder, micros, TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            return execute;
        } catch (IOException e2) {
            Request request = call.request();
            if (request != null) {
                HttpUrl url = request.url();
                if (url != null) {
                    networkRequestMetricBuilder.setUrl(url.url().toString());
                }
                if (request.method() != null) {
                    networkRequestMetricBuilder.setHttpMethod(request.method());
                }
            }
            networkRequestMetricBuilder.setRequestStartTimeMicros(micros);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    public static void sendNetworkMetric(Response response, NetworkRequestMetricBuilder networkRequestMetricBuilder, long j, long j2) throws IOException {
        Request request = response.request();
        if (request != null) {
            networkRequestMetricBuilder.setUrl(request.url().url().toString());
            networkRequestMetricBuilder.setHttpMethod(request.method());
            if (request.body() != null) {
                long contentLength = request.body().contentLength();
                if (contentLength != -1) {
                    networkRequestMetricBuilder.setRequestPayloadBytes(contentLength);
                }
            }
            ResponseBody body = response.body();
            if (body != null) {
                long contentLength2 = body.contentLength();
                if (contentLength2 != -1) {
                    networkRequestMetricBuilder.setResponsePayloadBytes(contentLength2);
                }
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    networkRequestMetricBuilder.setResponseContentType(contentType.toString());
                }
            }
            networkRequestMetricBuilder.setHttpResponseCode(response.code());
            networkRequestMetricBuilder.setRequestStartTimeMicros(j);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(j2);
            networkRequestMetricBuilder.build();
        }
    }
}
