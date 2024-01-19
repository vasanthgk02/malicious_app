package kotlinx.serialization.internal;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Tuples.kt */
public final class MapEntrySerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public final /* synthetic */ KSerializer<K> $keySerializer;
    public final /* synthetic */ KSerializer<V> $valueSerializer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public MapEntrySerializer$descriptor$1(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        // this.$keySerializer = kSerializer;
        // this.$valueSerializer = kSerializer2;
        super(1);
    }

    public Object invoke(Object obj) {
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "key", this.$keySerializer.getDescriptor(), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, HSLCriteriaBuilder.VALUE, this.$valueSerializer.getDescriptor(), null, false, 12);
        return Unit.INSTANCE;
    }
}
