package kotlin.reflect.jvm.internal.impl.resolve.sam;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: SamConversionResolverImpl.kt */
public final class SamConversionResolverImpl implements SamConversionResolver {
    public SamConversionResolverImpl(StorageManager storageManager, Iterable<? extends Object> iterable) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        storageManager.createCacheWithNullableValues();
    }
}
