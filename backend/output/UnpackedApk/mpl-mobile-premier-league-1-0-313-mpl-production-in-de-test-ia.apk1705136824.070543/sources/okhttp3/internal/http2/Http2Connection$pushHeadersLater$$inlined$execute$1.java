package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$pushHeadersLater$$inlined$execute$1 extends Task {
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ boolean $inFinished$inlined;
    public final /* synthetic */ String $name;
    public final /* synthetic */ List $requestHeaders$inlined;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Http2Connection$pushHeadersLater$$inlined$execute$1(String str, boolean z, String str2, boolean z2, Http2Connection http2Connection, int i, List list, boolean z3) {
        // this.$name = str;
        // this.$cancelable = z;
        // this.this$0 = http2Connection;
        // this.$streamId$inlined = i;
        // this.$requestHeaders$inlined = list;
        // this.$inFinished$inlined = z3;
        super(str2, z2);
    }

    public long runOnce() {
        boolean onHeaders = this.this$0.pushObserver.onHeaders(this.$streamId$inlined, this.$requestHeaders$inlined, this.$inFinished$inlined);
        if (onHeaders) {
            try {
                this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
            } catch (IOException unused) {
            }
        }
        if (onHeaders || this.$inFinished$inlined) {
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            }
        }
        return -1;
    }
}
