package androidx.room;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.room.IMultiInstanceInvalidationService.Stub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$serviceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationClient.kt */
public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$serviceConnection$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(iBinder, "service");
        this.this$0.service = Stub.asInterface(iBinder);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        multiInstanceInvalidationClient.executor.execute(multiInstanceInvalidationClient.setUpRunnable);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        multiInstanceInvalidationClient.executor.execute(multiInstanceInvalidationClient.removeObserverRunnable);
        this.this$0.service = null;
    }
}
