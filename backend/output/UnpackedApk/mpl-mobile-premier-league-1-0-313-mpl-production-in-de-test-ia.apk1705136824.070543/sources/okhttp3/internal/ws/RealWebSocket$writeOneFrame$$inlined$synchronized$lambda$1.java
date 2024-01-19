package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.concurrent.Task;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp", "okhttp3/internal/ws/RealWebSocket$$special$$inlined$execute$1"}, k = 1, mv = {1, 4, 0})
/* compiled from: TaskQueue.kt */
public final class RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1 extends Task {
    public final /* synthetic */ boolean $cancelable;
    public final /* synthetic */ Ref$ObjectRef $messageOrClose$inlined;
    public final /* synthetic */ String $name;
    public final /* synthetic */ ByteString $pong$inlined;
    public final /* synthetic */ Ref$ObjectRef $readerToClose$inlined;
    public final /* synthetic */ Ref$IntRef $receivedCloseCode$inlined;
    public final /* synthetic */ Ref$ObjectRef $receivedCloseReason$inlined;
    public final /* synthetic */ Ref$ObjectRef $streamsToClose$inlined;
    public final /* synthetic */ WebSocketWriter $writer$inlined;
    public final /* synthetic */ Ref$ObjectRef $writerToClose$inlined;
    public final /* synthetic */ RealWebSocket this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RealWebSocket$writeOneFrame$$inlined$synchronized$lambda$1(String str, boolean z, String str2, boolean z2, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        // this.$name = str;
        // this.$cancelable = z;
        // this.this$0 = realWebSocket;
        // this.$writer$inlined = webSocketWriter;
        // this.$pong$inlined = byteString;
        // this.$messageOrClose$inlined = ref$ObjectRef;
        // this.$receivedCloseCode$inlined = ref$IntRef;
        // this.$receivedCloseReason$inlined = ref$ObjectRef2;
        // this.$streamsToClose$inlined = ref$ObjectRef3;
        // this.$readerToClose$inlined = ref$ObjectRef4;
        // this.$writerToClose$inlined = ref$ObjectRef5;
        super(str2, z2);
    }

    public long runOnce() {
        this.this$0.cancel();
        return -1;
    }
}
