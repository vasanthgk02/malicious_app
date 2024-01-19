package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnUndeliveredElement.kt */
public final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ E $element;
    public final /* synthetic */ Function1<E, Unit> $this_bindCancellationFun;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public OnUndeliveredElementKt$bindCancellationFun$1(Function1<? super E, Unit> function1, E e2, CoroutineContext coroutineContext) {
        // this.$this_bindCancellationFun = function1;
        // this.$element = e2;
        // this.$context = coroutineContext;
        super(1);
    }

    public Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        Function1<E, Unit> function1 = this.$this_bindCancellationFun;
        E e2 = this.$element;
        CoroutineContext coroutineContext = this.$context;
        UndeliveredElementException callUndeliveredElementCatchingException = TypeUtilsKt.callUndeliveredElementCatchingException(function1, e2, null);
        if (callUndeliveredElementCatchingException != null) {
            TypeUtilsKt.handleCoroutineException(coroutineContext, callUndeliveredElementCatchingException);
        }
        return Unit.INSTANCE;
    }
}
