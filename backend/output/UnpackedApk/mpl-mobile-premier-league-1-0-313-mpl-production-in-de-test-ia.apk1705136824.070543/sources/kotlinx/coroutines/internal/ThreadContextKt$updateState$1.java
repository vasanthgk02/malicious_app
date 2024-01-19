package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreadContext.kt */
public final class ThreadContextKt$updateState$1 extends Lambda implements Function2<ThreadState, Element, ThreadState> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    public ThreadContextKt$updateState$1() {
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        ThreadState threadState = (ThreadState) obj;
        Element element = (Element) obj2;
        if (element instanceof ThreadContextElement) {
            ThreadContextElement<Object> threadContextElement = (ThreadContextElement) element;
            Object updateThreadContext = threadContextElement.updateThreadContext(threadState.context);
            Object[] objArr = threadState.values;
            int i = threadState.i;
            objArr[i] = updateThreadContext;
            ThreadContextElement<Object>[] threadContextElementArr = threadState.elements;
            threadState.i = i + 1;
            threadContextElementArr[i] = threadContextElement;
        }
        return threadState;
    }
}
