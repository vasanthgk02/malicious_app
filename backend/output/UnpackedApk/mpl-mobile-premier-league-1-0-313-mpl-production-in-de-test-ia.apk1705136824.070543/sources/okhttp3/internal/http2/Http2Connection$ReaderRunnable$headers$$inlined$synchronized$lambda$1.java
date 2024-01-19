package okhttp3.internal.http2;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection.ReaderRunnable;
import okhttp3.internal.platform.Platform;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/http2/Http2Connection$ReaderRunnable$$special$$inlined$execute$1"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1 extends Task {
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ List $headerBlock$inlined;
    public final /* synthetic */ boolean $inFinished$inlined;
    public final /* synthetic */ String $name;
    public final /* synthetic */ Http2Stream $newStream$inlined;
    public final /* synthetic */ Http2Stream $stream$inlined;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ ReaderRunnable this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, Http2Stream http2Stream, ReaderRunnable readerRunnable, Http2Stream http2Stream2, int i, List list, boolean z3) {
        // this.$name = str;
        // this.$cancelable = z;
        // this.$newStream$inlined = http2Stream;
        // this.this$0 = readerRunnable;
        // this.$stream$inlined = http2Stream2;
        // this.$streamId$inlined = i;
        // this.$headerBlock$inlined = list;
        // this.$inFinished$inlined = z3;
        super(str2, z2);
    }

    public long runOnce() {
        try {
            this.this$0.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
        } catch (IOException e2) {
            Platform platform = Platform.Companion.get();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Http2Connection.Listener failure for ");
            outline73.append(this.this$0.this$0.getConnectionName$okhttp());
            platform.log(outline73.toString(), 4, e2);
            try {
                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e2);
            } catch (IOException unused) {
            }
        }
        return -1;
    }
}
