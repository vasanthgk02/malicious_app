package androidx.lifecycle;

import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "close", "", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: ViewModel.kt */
public final class CloseableCoroutineScope implements Closeable, CoroutineScope {
    public final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(CoroutineContext coroutineContext2) {
        Intrinsics.checkNotNullParameter(coroutineContext2, "context");
        this.coroutineContext = coroutineContext2;
    }

    public void close() {
        TypeUtilsKt.cancel$default(this.coroutineContext, (CancellationException) null, 1, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}