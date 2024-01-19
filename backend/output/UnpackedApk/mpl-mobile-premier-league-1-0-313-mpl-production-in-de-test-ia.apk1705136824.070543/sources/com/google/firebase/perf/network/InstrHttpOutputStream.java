package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric.Builder;
import java.io.IOException;
import java.io.OutputStream;

public final class InstrHttpOutputStream extends OutputStream {
    public long bytesWritten = -1;
    public NetworkRequestMetricBuilder networkMetricBuilder;
    public final OutputStream outputStream;
    public final Timer timer;

    public InstrHttpOutputStream(OutputStream outputStream2, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer2) {
        this.outputStream = outputStream2;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timer = timer2;
    }

    public void close() throws IOException {
        long j = this.bytesWritten;
        if (j != -1) {
            this.networkMetricBuilder.setRequestPayloadBytes(j);
        }
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.networkMetricBuilder;
        long durationMicros = this.timer.getDurationMicros();
        Builder builder = networkRequestMetricBuilder.builder;
        builder.copyOnWrite();
        NetworkRequestMetric networkRequestMetric = (NetworkRequestMetric) builder.instance;
        networkRequestMetric.bitField0_ |= 256;
        networkRequestMetric.timeToRequestCompletedUs_ = durationMicros;
        try {
            this.outputStream.close();
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void flush() throws IOException {
        try {
            this.outputStream.flush();
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void write(int i) throws IOException {
        try {
            this.outputStream.write(i);
            long j = this.bytesWritten + 1;
            this.bytesWritten = j;
            this.networkMetricBuilder.setRequestPayloadBytes(j);
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.outputStream.write(bArr);
            long length = this.bytesWritten + ((long) bArr.length);
            this.bytesWritten = length;
            this.networkMetricBuilder.setRequestPayloadBytes(length);
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.outputStream.write(bArr, i, i2);
            long j = this.bytesWritten + ((long) i2);
            this.bytesWritten = j;
            this.networkMetricBuilder.setRequestPayloadBytes(j);
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }
}
