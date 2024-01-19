package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveArrayDescriptor;", "Lkotlinx/serialization/internal/ListLikeDescriptor;", "primitive", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "serialName", "", "getSerialName", "()Ljava/lang/String;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CollectionDescriptors.kt */
public final class PrimitiveArrayDescriptor extends ListLikeDescriptor {
    public final String serialName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PrimitiveArrayDescriptor(SerialDescriptor serialDescriptor) {
        // Intrinsics.checkNotNullParameter(serialDescriptor, "primitive");
        super(serialDescriptor, null);
        this.serialName = Intrinsics.stringPlus(serialDescriptor.getSerialName(), "Array");
    }

    public String getSerialName() {
        return this.serialName;
    }
}
