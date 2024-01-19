package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "defaultMainDelayOptIn", "", "initializeDefaultDelay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultExecutor.kt */
public final class DefaultExecutorKt {
    public static final Delay DefaultDelay;
    public static final boolean defaultMainDelayOptIn;

    static {
        Delay delay;
        boolean systemProp = TypeUtilsKt.systemProp("kotlinx.coroutines.main.delay", false);
        defaultMainDelayOptIn = systemProp;
        if (!systemProp) {
            delay = DefaultExecutor.INSTANCE;
        } else {
            MainCoroutineDispatcher main = Dispatchers.getMain();
            delay = ((main.getImmediate() instanceof MissingMainCoroutineDispatcher) || !(main instanceof Delay)) ? DefaultExecutor.INSTANCE : (Delay) main;
        }
        DefaultDelay = delay;
    }
}
