package kotlinx.coroutines;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Future.kt */
public final class CancelFutureOnCancel extends CancelHandler {
    public final Future<?> future;

    public CancelFutureOnCancel(Future<?> future2) {
        this.future = future2;
    }

    public Object invoke(Object obj) {
        if (((Throwable) obj) != null) {
            this.future.cancel(false);
        }
        return Unit.INSTANCE;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CancelFutureOnCancel[");
        outline73.append(this.future);
        outline73.append(']');
        return outline73.toString();
    }

    public void invoke(Throwable th) {
        if (th != null) {
            this.future.cancel(false);
        }
    }
}
