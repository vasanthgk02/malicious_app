package okhttp3.internal.http2;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection.ReaderRunnable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$ReaderRunnable$ping$$inlined$execute$1 extends Task {
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ String $name;
    public final /* synthetic */ int $payload1$inlined;
    public final /* synthetic */ int $payload2$inlined;
    public final /* synthetic */ ReaderRunnable this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Http2Connection$ReaderRunnable$ping$$inlined$execute$1(String str, boolean z, String str2, boolean z2, ReaderRunnable readerRunnable, int i, int i2) {
        // this.$name = str;
        // this.$cancelable = z;
        // this.this$0 = readerRunnable;
        // this.$payload1$inlined = i;
        // this.$payload2$inlined = i2;
        super(str2, z2);
    }

    public long runOnce() {
        this.this$0.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
        return -1;
    }
}
