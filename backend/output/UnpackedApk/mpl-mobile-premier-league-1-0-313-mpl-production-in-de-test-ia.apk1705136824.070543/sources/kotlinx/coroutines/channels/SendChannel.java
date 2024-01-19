package kotlinx.coroutines.channels;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J-\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00100\u0012H'J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\u0016\u001a\u00028\u0000H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R$\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Channel.kt */
public interface SendChannel<E> {
    boolean close(Throwable th);

    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    Object m989trySendJP2dKIU(E e2);
}
