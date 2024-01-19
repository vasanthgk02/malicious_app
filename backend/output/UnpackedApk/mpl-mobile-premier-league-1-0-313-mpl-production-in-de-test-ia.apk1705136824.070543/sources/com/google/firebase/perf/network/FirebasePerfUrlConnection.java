package com.google.firebase.perf.network;

import androidx.annotation.Keep;
import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class FirebasePerfUrlConnection {
    @Keep
    public static Object getContent(URL url) throws IOException {
        TransportManager transportManager = TransportManager.instance;
        Timer timer = new Timer();
        timer.reset();
        long j = timer.timeInMicros;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(transportManager);
        try {
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, networkRequestMetricBuilder).getContent();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, networkRequestMetricBuilder).getContent();
            }
            return openConnection.getContent();
        } catch (IOException e2) {
            networkRequestMetricBuilder.setRequestStartTimeMicros(j);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilder.setUrl(url.toString());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static Object instrument(Object obj) throws IOException {
        if (obj instanceof HttpsURLConnection) {
            return new InstrHttpsURLConnection((HttpsURLConnection) obj, new Timer(), new NetworkRequestMetricBuilder(TransportManager.instance));
        }
        return obj instanceof HttpURLConnection ? new InstrHttpURLConnection((HttpURLConnection) obj, new Timer(), new NetworkRequestMetricBuilder(TransportManager.instance)) : obj;
    }

    @Keep
    public static InputStream openStream(URL url) throws IOException {
        TransportManager transportManager = TransportManager.instance;
        Timer timer = new Timer();
        timer.reset();
        long j = timer.timeInMicros;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(transportManager);
        try {
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, networkRequestMetricBuilder).getInputStream();
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, networkRequestMetricBuilder).getInputStream();
            }
            return openConnection.getInputStream();
        } catch (IOException e2) {
            networkRequestMetricBuilder.setRequestStartTimeMicros(j);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilder.setUrl(url.toString());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }

    @Keep
    public static Object getContent(URL url, Class[] clsArr) throws IOException {
        TransportManager transportManager = TransportManager.instance;
        Timer timer = new Timer();
        timer.reset();
        long j = timer.timeInMicros;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = new NetworkRequestMetricBuilder(transportManager);
        try {
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpsURLConnection) {
                return new InstrHttpsURLConnection((HttpsURLConnection) openConnection, timer, networkRequestMetricBuilder).delegate.getContent(clsArr);
            }
            if (openConnection instanceof HttpURLConnection) {
                return new InstrHttpURLConnection((HttpURLConnection) openConnection, timer, networkRequestMetricBuilder).delegate.getContent(clsArr);
            }
            return openConnection.getContent(clsArr);
        } catch (IOException e2) {
            networkRequestMetricBuilder.setRequestStartTimeMicros(j);
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(timer.getDurationMicros());
            networkRequestMetricBuilder.setUrl(url.toString());
            NetworkRequestMetricBuilderUtil.logError(networkRequestMetricBuilder);
            throw e2;
        }
    }
}
