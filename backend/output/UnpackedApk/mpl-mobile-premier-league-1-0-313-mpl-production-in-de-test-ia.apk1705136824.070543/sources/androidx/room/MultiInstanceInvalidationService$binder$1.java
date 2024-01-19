package androidx.room;

import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationService.Stub;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"androidx/room/MultiInstanceInvalidationService$binder$1", "Landroidx/room/IMultiInstanceInvalidationService$Stub;", "broadcastInvalidation", "", "clientId", "", "tables", "", "", "(I[Ljava/lang/String;)V", "registerCallback", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "name", "unregisterCallback", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationService.kt */
public final class MultiInstanceInvalidationService$binder$1 extends Stub {
    public final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void broadcastInvalidation(int i, String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (multiInstanceInvalidationService.callbackList) {
            String str = multiInstanceInvalidationService.clientNames.get(Integer.valueOf(i));
            if (str != null) {
                int beginBroadcast = multiInstanceInvalidationService.callbackList.beginBroadcast();
                int i2 = 0;
                while (i2 < beginBroadcast) {
                    try {
                        Object broadcastCookie = multiInstanceInvalidationService.callbackList.getBroadcastCookie(i2);
                        Intrinsics.checkNotNull(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                        int intValue = ((Integer) broadcastCookie).intValue();
                        String str2 = multiInstanceInvalidationService.clientNames.get(Integer.valueOf(intValue));
                        if (i != intValue && Intrinsics.areEqual(str, str2)) {
                            try {
                                multiInstanceInvalidationService.callbackList.getBroadcastItem(i2).onInvalidation(strArr);
                            } catch (RemoteException unused) {
                            }
                        }
                        i2++;
                    } catch (Throwable th) {
                        multiInstanceInvalidationService.callbackList.finishBroadcast();
                        throw th;
                    }
                }
                multiInstanceInvalidationService.callbackList.finishBroadcast();
            }
        }
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (multiInstanceInvalidationService.callbackList) {
            int i2 = multiInstanceInvalidationService.maxClientId + 1;
            multiInstanceInvalidationService.maxClientId = i2;
            if (multiInstanceInvalidationService.callbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i2))) {
                multiInstanceInvalidationService.clientNames.put(Integer.valueOf(i2), str);
                i = i2;
            } else {
                multiInstanceInvalidationService.maxClientId--;
            }
        }
        return i;
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
        Intrinsics.checkNotNullParameter(iMultiInstanceInvalidationCallback, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
        synchronized (multiInstanceInvalidationService.callbackList) {
            multiInstanceInvalidationService.callbackList.unregister(iMultiInstanceInvalidationCallback);
            String remove = multiInstanceInvalidationService.clientNames.remove(Integer.valueOf(i));
        }
    }
}
