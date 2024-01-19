package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback.Stub;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.InvalidationTracker.ObserverWrapper;
import androidx.room.MultiInstanceInvalidationClient.AnonymousClass1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$callback$1", "Landroidx/room/IMultiInstanceInvalidationCallback$Stub;", "onInvalidation", "", "tables", "", "", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MultiInstanceInvalidationClient.kt */
public final class MultiInstanceInvalidationClient$callback$1 extends Stub {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        Intrinsics.checkNotNullParameter(multiInstanceInvalidationClient, "this$0");
        Intrinsics.checkNotNullParameter(strArr, "$tables");
        InvalidationTracker invalidationTracker = multiInstanceInvalidationClient.invalidationTracker;
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        if (invalidationTracker != null) {
            Intrinsics.checkNotNullParameter(strArr2, "tables");
            synchronized (invalidationTracker.observerMap) {
                Iterator it = invalidationTracker.observerMap.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    Intrinsics.checkNotNullExpressionValue(entry, "(observer, wrapper)");
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (((AnonymousClass1) ((Observer) entry.getKey())) == null) {
                        throw null;
                    }
                }
            }
            return;
        }
        throw null;
    }

    public void onInvalidation(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "tables");
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
        multiInstanceInvalidationClient.executor.execute(new Runnable(strArr) {
            public final /* synthetic */ String[] f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(MultiInstanceInvalidationClient.this, this.f$1);
            }
        });
    }
}
