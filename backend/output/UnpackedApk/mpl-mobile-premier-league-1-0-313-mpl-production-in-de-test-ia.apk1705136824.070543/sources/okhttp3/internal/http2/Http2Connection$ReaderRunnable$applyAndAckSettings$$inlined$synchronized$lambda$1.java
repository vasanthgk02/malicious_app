package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection.ReaderRunnable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0006"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/http2/Http2Connection$ReaderRunnable$$special$$inlined$execute$2", "okhttp3/internal/http2/Http2Connection$ReaderRunnable$$special$$inlined$synchronized$lambda$1"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1 extends Task {
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ boolean $clearPrevious$inlined;
    public final /* synthetic */ Ref$LongRef $delta$inlined;
    public final /* synthetic */ String $name;
    public final /* synthetic */ Ref$ObjectRef $newPeerSettings$inlined;
    public final /* synthetic */ Settings $settings$inlined;
    public final /* synthetic */ Ref$ObjectRef $streamsToNotify$inlined;
    public final /* synthetic */ ReaderRunnable this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, ReaderRunnable readerRunnable, Ref$ObjectRef ref$ObjectRef, boolean z3, Settings settings, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
        // this.$name = str;
        // this.$cancelable = z;
        // this.this$0 = readerRunnable;
        // this.$newPeerSettings$inlined = ref$ObjectRef;
        // this.$clearPrevious$inlined = z3;
        // this.$settings$inlined = settings;
        // this.$delta$inlined = ref$LongRef;
        // this.$streamsToNotify$inlined = ref$ObjectRef2;
        super(str2, z2);
    }

    public long runOnce() {
        this.this$0.this$0.getListener$okhttp().onSettings(this.this$0.this$0, (Settings) this.$newPeerSettings$inlined.element);
        return -1;
    }
}
