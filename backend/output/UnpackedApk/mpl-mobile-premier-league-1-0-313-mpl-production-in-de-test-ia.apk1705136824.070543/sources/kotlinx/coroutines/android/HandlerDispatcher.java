package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandlerDispatcher.kt */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public HandlerDispatcher() {
    }

    public HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
