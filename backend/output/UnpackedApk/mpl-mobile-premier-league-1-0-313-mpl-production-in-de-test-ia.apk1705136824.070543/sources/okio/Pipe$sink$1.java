package okio;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.squareup.picasso.Utils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: Pipe.kt */
public final class Pipe$sink$1 implements Sink {
    public final /* synthetic */ Pipe this$0;
    public final Timeout timeout = new Timeout();

    public Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r1 == null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r0 = r11.this$0;
        r2 = r1.timeout();
        r0 = r0.sink().timeout();
        r3 = r2.timeoutNanos();
        r2.timeout(okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r2.timeoutNanos()), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        if (r2.hasDeadline() == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        r5 = r2.deadlineNanoTime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        if (r0.hasDeadline() == false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        r2.deadlineNanoTime(java.lang.Math.min(r2.deadlineNanoTime(), r0.deadlineNanoTime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b1, code lost:
        if (r0.hasDeadline() != false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b3, code lost:
        r2.deadlineNanoTime(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00bb, code lost:
        if (r0.hasDeadline() == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bd, code lost:
        r2.deadlineNanoTime(r0.deadlineNanoTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d6, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d7, code lost:
        r2.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e0, code lost:
        if (r0.hasDeadline() != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e2, code lost:
        r2.clearDeadline();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e5, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r11 = this;
            okio.Pipe r0 = r11.this$0
            okio.Buffer r0 = r0.getBuffer$okio()
            monitor-enter(r0)
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            boolean r1 = r1.getSinkClosed$okio()     // Catch:{ all -> 0x00ef }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            okio.Sink r1 = r1.getFoldedSink$okio()     // Catch:{ all -> 0x00ef }
            if (r1 == 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            boolean r1 = r1.getSourceClosed$okio()     // Catch:{ all -> 0x00ef }
            if (r1 == 0) goto L_0x003c
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x00ef }
            long r1 = r1.size()     // Catch:{ all -> 0x00ef }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0033
            goto L_0x003c
        L_0x0033:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x00ef }
            throw r1     // Catch:{ all -> 0x00ef }
        L_0x003c:
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            r2 = 1
            r1.setSinkClosed$okio(r2)     // Catch:{ all -> 0x00ef }
            okio.Pipe r1 = r11.this$0     // Catch:{ all -> 0x00ef }
            okio.Buffer r1 = r1.getBuffer$okio()     // Catch:{ all -> 0x00ef }
            if (r1 == 0) goto L_0x00e7
            r1.notifyAll()     // Catch:{ all -> 0x00ef }
            r1 = 0
        L_0x004e:
            monitor-exit(r0)
            if (r1 == 0) goto L_0x00e6
            okio.Pipe r0 = r11.this$0
            okio.Timeout r2 = r1.timeout()
            okio.Sink r0 = r0.sink()
            okio.Timeout r0 = r0.timeout()
            long r3 = r2.timeoutNanos()
            okio.Timeout$Companion r5 = okio.Timeout.Companion
            long r6 = r0.timeoutNanos()
            long r8 = r2.timeoutNanos()
            long r5 = r5.minTimeout(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r5, r7)
            boolean r5 = r2.hasDeadline()
            if (r5 == 0) goto L_0x00b7
            long r5 = r2.deadlineNanoTime()
            boolean r7 = r0.hasDeadline()
            if (r7 == 0) goto L_0x0095
            long r7 = r2.deadlineNanoTime()
            long r9 = r0.deadlineNanoTime()
            long r7 = java.lang.Math.min(r7, r9)
            r2.deadlineNanoTime(r7)
        L_0x0095:
            r1.close()     // Catch:{ all -> 0x00a7 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r1)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e6
            r2.deadlineNanoTime(r5)
            goto L_0x00e6
        L_0x00a7:
            r1 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r7)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00b6
            r2.deadlineNanoTime(r5)
        L_0x00b6:
            throw r1
        L_0x00b7:
            boolean r5 = r0.hasDeadline()
            if (r5 == 0) goto L_0x00c4
            long r5 = r0.deadlineNanoTime()
            r2.deadlineNanoTime(r5)
        L_0x00c4:
            r1.close()     // Catch:{ all -> 0x00d6 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r1)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e6
            r2.clearDeadline()
            goto L_0x00e6
        L_0x00d6:
            r1 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r2.timeout(r3, r5)
            boolean r0 = r0.hasDeadline()
            if (r0 == 0) goto L_0x00e5
            r2.clearDeadline()
        L_0x00e5:
            throw r1
        L_0x00e6:
            return
        L_0x00e7:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException     // Catch:{ all -> 0x00ef }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Object"
            r1.<init>(r2)     // Catch:{ all -> 0x00ef }
            throw r1     // Catch:{ all -> 0x00ef }
        L_0x00ef:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public void flush() {
        Sink foldedSink$okio;
        synchronized (this.this$0.getBuffer$okio()) {
            if (!(!this.this$0.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.this$0.getCanceled$okio()) {
                foldedSink$okio = this.this$0.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (this.this$0.getSourceClosed$okio()) {
                        if (this.this$0.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    foldedSink$okio = null;
                }
            } else {
                throw new IOException(Utils.VERB_CANCELED);
            }
        }
        if (foldedSink$okio != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = foldedSink$okio.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    foldedSink$okio.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    foldedSink$okio.flush();
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void write(Buffer buffer, long j) {
        Sink sink;
        Intrinsics.checkNotNullParameter(buffer, DefaultSettingsSpiCall.SOURCE_PARAM);
        synchronized (this.this$0.getBuffer$okio()) {
            if (!(!this.this$0.getSinkClosed$okio())) {
                throw new IllegalStateException("closed".toString());
            } else if (!this.this$0.getCanceled$okio()) {
                while (true) {
                    if (j <= 0) {
                        sink = null;
                        break;
                    }
                    sink = this.this$0.getFoldedSink$okio();
                    if (sink != null) {
                        break;
                    } else if (!this.this$0.getSourceClosed$okio()) {
                        long maxBufferSize$okio = this.this$0.getMaxBufferSize$okio() - this.this$0.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.waitUntilNotified(this.this$0.getBuffer$okio());
                            if (this.this$0.getCanceled$okio()) {
                                throw new IOException(Utils.VERB_CANCELED);
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j);
                            this.this$0.getBuffer$okio().write(buffer, min);
                            j -= min;
                            Buffer buffer$okio = this.this$0.getBuffer$okio();
                            if (buffer$okio != null) {
                                buffer$okio.notifyAll();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
            } else {
                throw new IOException(Utils.VERB_CANCELED);
            }
        }
        if (sink != null) {
            Pipe pipe = this.this$0;
            Timeout timeout2 = sink.timeout();
            Timeout timeout3 = pipe.sink().timeout();
            long timeoutNanos = timeout2.timeoutNanos();
            timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                long deadlineNanoTime = timeout2.deadlineNanoTime();
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(deadlineNanoTime);
                    }
                }
            } else {
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                }
                try {
                    sink.write(buffer, j);
                } finally {
                    timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    if (timeout3.hasDeadline()) {
                        timeout2.clearDeadline();
                    }
                }
            }
        }
    }
}
