package kotlinx.serialization.internal;

import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "A", "B", "C", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Tuples.kt */
public final class TripleSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public final /* synthetic */ TripleSerializer<A, B, C> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TripleSerializer$descriptor$1(TripleSerializer<A, B, C> tripleSerializer) {
        // this.this$0 = tripleSerializer;
        super(1);
    }

    public Object invoke(Object obj) {
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "first", this.this$0.aSerializer.getDescriptor(), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, AnonymousClass27.SECOND, this.this$0.bSerializer.getDescriptor(), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "third", this.this$0.cSerializer.getDescriptor(), null, false, 12);
        return Unit.INSTANCE;
    }
}
