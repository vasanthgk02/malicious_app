package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphRequestBatch.OnProgressCallback;
import com.facebook.internal.Validate;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!H\u0016R\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "Lcom/facebook/RequestOutputStream;", "out", "Ljava/io/OutputStream;", "requests", "Lcom/facebook/GraphRequestBatch;", "progressMap", "", "Lcom/facebook/GraphRequest;", "Lcom/facebook/RequestProgress;", "maxProgress", "", "(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V", "<set-?>", "batchProgress", "getBatchProgress", "()J", "currentRequestProgress", "lastReportedProgress", "getMaxProgress", "threshold", "addProgress", "", "size", "close", "reportBatchProgress", "setCurrentRequest", "request", "write", "buffer", "", "offset", "", "length", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProgressOutputStream.kt */
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    public long batchProgress;
    public RequestProgress currentRequestProgress;
    public long lastReportedProgress;
    public final long maxProgress;
    public final Map<GraphRequest, RequestProgress> progressMap;
    public final GraphRequestBatch requests;
    public final long threshold = FacebookSdk.onProgressThreshold.get();

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        // Intrinsics.checkNotNullParameter(outputStream, "out");
        // Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        // Intrinsics.checkNotNullParameter(map, "progressMap");
        super(outputStream);
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.sdkInitialized();
    }

    /* renamed from: reportBatchProgress$lambda-0  reason: not valid java name */
    public static final void m135reportBatchProgress$lambda0(Callback callback, ProgressOutputStream progressOutputStream) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(progressOutputStream, "this$0");
        ((OnProgressCallback) callback).onBatchProgress(progressOutputStream.requests, progressOutputStream.batchProgress, progressOutputStream.maxProgress);
    }

    public final void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            long j2 = requestProgress.progress + j;
            requestProgress.progress = j2;
            if (j2 >= requestProgress.lastReportedProgress + requestProgress.threshold || j2 >= requestProgress.maxProgress) {
                requestProgress.reportProgress();
            }
        }
        long j3 = this.batchProgress + j;
        this.batchProgress = j3;
        if (j3 >= this.lastReportedProgress + this.threshold || j3 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }

    public final void reportBatchProgress() {
        Boolean bool;
        if (this.batchProgress > this.lastReportedProgress) {
            for (Callback next : this.requests.callbacks) {
                if (next instanceof OnProgressCallback) {
                    Handler handler = this.requests.callbackHandler;
                    if (handler == null) {
                        bool = null;
                    } else {
                        bool = Boolean.valueOf(handler.post(new Runnable(this) {
                            public final /* synthetic */ ProgressOutputStream f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                ProgressOutputStream.m135reportBatchProgress$lambda0(Callback.this, this.f$1);
                            }
                        }));
                    }
                    if (bool == null) {
                        ((OnProgressCallback) next).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1);
    }
}
