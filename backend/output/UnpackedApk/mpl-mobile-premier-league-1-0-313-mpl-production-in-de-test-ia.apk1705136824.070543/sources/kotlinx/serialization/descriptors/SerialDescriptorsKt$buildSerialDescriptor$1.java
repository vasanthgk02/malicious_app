package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptors.kt */
public final class SerialDescriptorsKt$buildSerialDescriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public static final SerialDescriptorsKt$buildSerialDescriptor$1 INSTANCE = new SerialDescriptorsKt$buildSerialDescriptor$1();

    public SerialDescriptorsKt$buildSerialDescriptor$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((ClassSerialDescriptorBuilder) obj, "$this$null");
        return Unit.INSTANCE;
    }
}
