package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl.LockCont;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Mutex.kt */
public final class MutexImpl$LockCont$tryResumeLockWaiter$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ MutexImpl this$0;
    public final /* synthetic */ LockCont this$1;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl mutexImpl, LockCont lockCont) {
        // this.this$0 = mutexImpl;
        // this.this$1 = lockCont;
        super(1);
    }

    public Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.this$0.unlock(this.this$1.owner);
        return Unit.INSTANCE;
    }
}
