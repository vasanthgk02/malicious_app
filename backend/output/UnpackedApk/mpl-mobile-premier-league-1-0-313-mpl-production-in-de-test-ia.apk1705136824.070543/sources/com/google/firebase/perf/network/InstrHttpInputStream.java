package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.io.IOException;
import java.io.InputStream;

public final class InstrHttpInputStream extends InputStream {
    public long bytesRead = -1;
    public final InputStream inputStream;
    public final NetworkRequestMetricBuilder networkMetricBuilder;
    public long timeToResponseInitiated;
    public long timeToResponseLastRead = -1;
    public final Timer timer;

    public InstrHttpInputStream(InputStream inputStream2, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer2) {
        this.timer = timer2;
        this.inputStream = inputStream2;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timeToResponseInitiated = ((NetworkRequestMetric) networkRequestMetricBuilder.builder.instance).timeToResponseInitiatedUs_;
    }

    public int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void close() throws IOException {
        long durationMicros = this.timer.getDurationMicros();
        if (this.timeToResponseLastRead == -1) {
            this.timeToResponseLastRead = durationMicros;
        }
        try {
            this.inputStream.close();
            if (this.bytesRead != -1) {
                this.networkMetricBuilder.setResponsePayloadBytes(this.bytesRead);
            }
            if (this.timeToResponseInitiated != -1) {
                this.networkMetricBuilder.setTimeToResponseInitiatedMicros(this.timeToResponseInitiated);
            }
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timeToResponseLastRead);
            this.networkMetricBuilder.build();
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void mark(int i) {
        this.inputStream.mark(i);
    }

    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    public int read() throws IOException {
        try {
            int read = this.inputStream.read();
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + 1;
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public void reset() throws IOException {
        try {
            this.inputStream.reset();
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public long skip(long j) throws IOException {
        try {
            long skip = this.inputStream.skip(j);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (skip == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            } else {
                long j2 = this.bytesRead + skip;
                this.bytesRead = j2;
                this.networkMetricBuilder.setResponsePayloadBytes(j2);
            }
            return skip;
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.inputStream.read(bArr, i, i2);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + ((long) read);
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.inputStream.read(bArr);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j = this.bytesRead + ((long) read);
                this.bytesRead = j;
                this.networkMetricBuilder.setResponsePayloadBytes(j);
            }
            return read;
        } catch (IOException e2) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e2;
        }
    }
}
