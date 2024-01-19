package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "result", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineContext.kt */
public final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, Element, CoroutineContext> {
    public final /* synthetic */ boolean $isNewCoroutine;
    public final /* synthetic */ Ref$ObjectRef<CoroutineContext> $leftoverContext;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CoroutineContextKt$foldCopies$folded$1(Ref$ObjectRef<CoroutineContext> ref$ObjectRef, boolean z) {
        // this.$leftoverContext = ref$ObjectRef;
        // this.$isNewCoroutine = z;
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        Element element = (Element) obj2;
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        Element element2 = ((CoroutineContext) this.$leftoverContext.element).get(element.getKey());
        if (element2 == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.$isNewCoroutine) {
                copyableThreadContextElement = copyableThreadContextElement.copyForChild();
            }
            return coroutineContext.plus(copyableThreadContextElement);
        }
        Ref$ObjectRef<CoroutineContext> ref$ObjectRef = this.$leftoverContext;
        ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).mergeForChild(element2));
    }
}
