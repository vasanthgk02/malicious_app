package okhttp3.internal.ws;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.ws.RealWebSocket.Streams;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/ws/RealWebSocket$$special$$inlined$schedule$1"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1 extends Task {
    public final /* synthetic */ WebSocketExtensions $extensions$inlined;
    public final /* synthetic */ String $name;
    public final /* synthetic */ String $name$inlined;
    public final /* synthetic */ long $pingIntervalNanos$inlined;
    public final /* synthetic */ Streams $streams$inlined;
    public final /* synthetic */ RealWebSocket this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RealWebSocket$initReaderAndWriter$$inlined$synchronized$lambda$1(String str, String str2, long j, RealWebSocket realWebSocket, String str3, Streams streams, WebSocketExtensions webSocketExtensions) {
        // this.$name = str;
        // this.$pingIntervalNanos$inlined = j;
        // this.this$0 = realWebSocket;
        // this.$name$inlined = str3;
        // this.$streams$inlined = streams;
        // this.$extensions$inlined = webSocketExtensions;
        super(str2, false, 2, null);
    }

    public long runOnce() {
        this.this$0.writePingFrame$okhttp();
        return this.$pingIntervalNanos$inlined;
    }
}
