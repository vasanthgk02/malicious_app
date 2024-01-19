package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoroutinesRoom.kt */
public final class CoroutinesRoom$Companion$execute$4$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CancellationSignal $cancellationSignal;
    public final /* synthetic */ Job $job;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CoroutinesRoom$Companion$execute$4$1(CancellationSignal cancellationSignal, Job job) {
        // this.$cancellationSignal = cancellationSignal;
        // this.$job = job;
        super(1);
    }

    public Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        CancellationSignal cancellationSignal = this.$cancellationSignal;
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        cancellationSignal.cancel();
        TypeUtilsKt.cancel$default(this.$job, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
