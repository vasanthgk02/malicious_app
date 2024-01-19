package com.shield.android.c;

import java.util.function.Function;
import java8.util.concurrent.CompletableFuture;

/* renamed from: com.shield.android.c.-$$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ implements Function {
    public static final /* synthetic */ $$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ INSTANCE = new $$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ();

    private /* synthetic */ $$Lambda$OnnVhR9f8NdektaZb7jvsjK2PrQ() {
    }

    public final Object apply(Object obj) {
        return (Long) ((CompletableFuture) obj).join();
    }
}
