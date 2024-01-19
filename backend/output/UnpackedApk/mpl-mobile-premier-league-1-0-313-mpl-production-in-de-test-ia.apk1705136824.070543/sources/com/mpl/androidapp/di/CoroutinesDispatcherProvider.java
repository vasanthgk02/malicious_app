package com.mpl.androidapp.di;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/di/CoroutinesDispatcherProvider;", "", "()V", "main", "Lkotlinx/coroutines/CoroutineDispatcher;", "computation", "io", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getComputation", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getIo", "getMain", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineDispatcherProvider.kt */
public final class CoroutinesDispatcherProvider {
    public final CoroutineDispatcher computation;

    /* renamed from: io  reason: collision with root package name */
    public final CoroutineDispatcher f959io;
    public final CoroutineDispatcher main;

    public CoroutinesDispatcherProvider(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "main");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "computation");
        Intrinsics.checkNotNullParameter(coroutineDispatcher3, "io");
        this.main = coroutineDispatcher;
        this.computation = coroutineDispatcher2;
        this.f959io = coroutineDispatcher3;
    }

    public static /* synthetic */ CoroutinesDispatcherProvider copy$default(CoroutinesDispatcherProvider coroutinesDispatcherProvider, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = coroutinesDispatcherProvider.main;
        }
        if ((i & 2) != 0) {
            coroutineDispatcher2 = coroutinesDispatcherProvider.computation;
        }
        if ((i & 4) != 0) {
            coroutineDispatcher3 = coroutinesDispatcherProvider.f959io;
        }
        return coroutinesDispatcherProvider.copy(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3);
    }

    public final CoroutineDispatcher component1() {
        return this.main;
    }

    public final CoroutineDispatcher component2() {
        return this.computation;
    }

    public final CoroutineDispatcher component3() {
        return this.f959io;
    }

    public final CoroutinesDispatcherProvider copy(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "main");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "computation");
        Intrinsics.checkNotNullParameter(coroutineDispatcher3, "io");
        return new CoroutinesDispatcherProvider(coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoroutinesDispatcherProvider)) {
            return false;
        }
        CoroutinesDispatcherProvider coroutinesDispatcherProvider = (CoroutinesDispatcherProvider) obj;
        return Intrinsics.areEqual(this.main, coroutinesDispatcherProvider.main) && Intrinsics.areEqual(this.computation, coroutinesDispatcherProvider.computation) && Intrinsics.areEqual(this.f959io, coroutinesDispatcherProvider.f959io);
    }

    public final CoroutineDispatcher getComputation() {
        return this.computation;
    }

    public final CoroutineDispatcher getIo() {
        return this.f959io;
    }

    public final CoroutineDispatcher getMain() {
        return this.main;
    }

    public int hashCode() {
        int hashCode = this.computation.hashCode();
        return this.f959io.hashCode() + ((hashCode + (this.main.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CoroutinesDispatcherProvider(main=");
        outline73.append(this.main);
        outline73.append(", computation=");
        outline73.append(this.computation);
        outline73.append(", io=");
        outline73.append(this.f959io);
        outline73.append(')');
        return outline73.toString();
    }

    public CoroutinesDispatcherProvider() {
        this(Dispatchers.getMain(), Dispatchers.Default, Dispatchers.IO);
    }
}
