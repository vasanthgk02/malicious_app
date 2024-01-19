package kotlinx.coroutines.flow.internal;

import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "count", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class SafeCollector_commonKt$checkContext$result$1 extends Lambda implements Function2<Integer, Element, Integer> {
    public final /* synthetic */ SafeCollector<?> $this_checkContext;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SafeCollector_commonKt$checkContext$result$1(SafeCollector<?> safeCollector) {
        // this.$this_checkContext = safeCollector;
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        Element element = (Element) obj2;
        Key<?> key = element.getKey();
        Element element2 = this.$this_checkContext.collectContext.get(key);
        if (key != Job.Key) {
            return Integer.valueOf(element != element2 ? LinearLayoutManager.INVALID_OFFSET : intValue + 1);
        }
        Job job = (Job) element2;
        Job job2 = (Job) element;
        while (true) {
            if (job2 != null) {
                if (job2 == job || !(job2 instanceof ScopeCoroutine)) {
                    break;
                }
                ChildHandle childHandle = (ChildHandle) ((ScopeCoroutine) job2)._parentHandle;
                job2 = childHandle != null ? childHandle.getParent() : null;
            } else {
                job2 = null;
                break;
            }
        }
        if (job2 == job) {
            if (job != null) {
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job2 + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
