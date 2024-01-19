package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/internal/HashMapClassDesc;", "Lkotlinx/serialization/internal/MapLikeDescriptor;", "keyDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "valueDesc", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CollectionDescriptors.kt */
public final class HashMapClassDesc extends MapLikeDescriptor {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public HashMapClassDesc(SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        // Intrinsics.checkNotNullParameter(serialDescriptor, "keyDesc");
        // Intrinsics.checkNotNullParameter(serialDescriptor2, "valueDesc");
        super("kotlin.collections.HashMap", serialDescriptor, serialDescriptor2, null);
    }
}
