package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class FirebasePerfHttpClient {
    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long nanoTime = System.nanoTime();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri());
            networkRequestMetricBuilder.setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            long nanoTime2 = System.nanoTime();
            networkRequestMetricBuilder.setRequestStartTimeMicros(micros);
            HttpResponse execute = httpClient.execute(httpHost, httpRequest);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime2));
            networkRequestMetricBuilder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilder.build();
            return execute;
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long nanoTime = System.nanoTime();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri());
            networkRequestMetricBuilder.setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            long nanoTime2 = System.nanoTime();
            networkRequestMetricBuilder.setRequestStartTimeMicros(micros);
            HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime2));
            networkRequestMetricBuilder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilder.build();
            return execute;
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long nanoTime = System.nanoTime();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpUriRequest.getURI().toString());
            networkRequestMetricBuilder.setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            long nanoTime2 = System.nanoTime();
            networkRequestMetricBuilder.setRequestStartTimeMicros(micros);
            HttpResponse execute = httpClient.execute(httpUriRequest);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime2));
            networkRequestMetricBuilder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilder.build();
            return execute;
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        long nanoTime = System.nanoTime();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpUriRequest.getURI().toString());
            networkRequestMetricBuilder.setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            long micros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            long nanoTime2 = System.nanoTime();
            networkRequestMetricBuilder.setRequestStartTimeMicros(micros);
            HttpResponse execute = httpClient.execute(httpUriRequest, httpContext);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime2));
            networkRequestMetricBuilder.setHttpResponseCode(execute.getStatusLine().getStatusCode());
            Long apacheHttpMessageContentLength2 = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(execute);
            if (apacheHttpMessageContentLength2 != null) {
                networkRequestMetricBuilder.setResponsePayloadBytes(apacheHttpMessageContentLength2.longValue());
            }
            String apacheHttpResponseContentType = NetworkRequestMetricBuilderUtil.getApacheHttpResponseContentType(execute);
            if (apacheHttpResponseContentType != null) {
                networkRequestMetricBuilder.setResponseContentType(apacheHttpResponseContentType);
            }
            networkRequestMetricBuilder.build();
            return execute;
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - nanoTime));
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler) throws IOException {
        Timer timer = new Timer();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpUriRequest.getURI().toString());
            networkRequestMetricBuilder.setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilder.setRequestStartTimeMicros(timer.timeInMicros);
            return httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilder));
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<T> responseHandler, HttpContext httpContext) throws IOException {
        Timer timer = new Timer();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpUriRequest.getURI().toString());
            networkRequestMetricBuilder.setHttpMethod(httpUriRequest.getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpUriRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilder.setRequestStartTimeMicros(timer.timeInMicros);
            return httpClient.execute(httpUriRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilder), httpContext);
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        Timer timer = new Timer();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri());
            networkRequestMetricBuilder.setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilder.setRequestStartTimeMicros(timer.timeInMicros);
            return httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilder));
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        Timer timer = new Timer();
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(TransportManager.instance);
        try {
            networkRequestMetricBuilder.setUrl(httpHost.toURI() + httpRequest.getRequestLine().getUri());
            networkRequestMetricBuilder.setHttpMethod(httpRequest.getRequestLine().getMethod());
            Long apacheHttpMessageContentLength = NetworkRequestMetricBuilderUtil.getApacheHttpMessageContentLength(httpRequest);
            if (apacheHttpMessageContentLength != null) {
                networkRequestMetricBuilder.setRequestPayloadBytes(apacheHttpMessageContentLength.longValue());
            }
            timer.reset();
            networkRequestMetricBuilder.setRequestStartTimeMicros(timer.timeInMicros);
            return httpClient.execute(httpHost, httpRequest, new InstrumentApacheHttpResponseHandler(responseHandler, timer, networkRequestMetricBuilder), httpContext);
        } catch (IOException e2) {
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }
}
