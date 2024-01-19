package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ObjectSerializer.kt */
public final class ObjectSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {
    public final /* synthetic */ String $serialName;
    public final /* synthetic */ ObjectSerializer<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ObjectSerializer$descriptor$2(String str, ObjectSerializer<T> objectSerializer) {
        // this.$serialName = str;
        // this.this$0 = objectSerializer;
        super(0);
    }

    public Object invoke() {
        final ObjectSerializer<T> objectSerializer = this.this$0;
        return TypeUtilsKt.buildSerialDescriptor(this.$serialName, OBJECT.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public Object invoke(Object obj) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                List<? extends Annotation> list = objectSerializer._annotations;
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                classSerialDescriptorBuilder.annotations = list;
                return Unit.INSTANCE;
            }
        });
    }
}
