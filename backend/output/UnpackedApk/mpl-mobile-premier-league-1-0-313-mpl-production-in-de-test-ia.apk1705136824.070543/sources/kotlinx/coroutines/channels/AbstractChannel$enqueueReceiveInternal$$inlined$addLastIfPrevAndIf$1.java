package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
public final class AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 extends CondAddOp {
    public final /* synthetic */ AbstractChannel this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
        // this.this$0 = abstractChannel;
        super(lockFreeLinkedListNode);
    }

    public Object prepare(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
        if (this.this$0.isBufferEmpty()) {
            return null;
        }
        return LockFreeLinkedListKt.CONDITION_FALSE;
    }
}
