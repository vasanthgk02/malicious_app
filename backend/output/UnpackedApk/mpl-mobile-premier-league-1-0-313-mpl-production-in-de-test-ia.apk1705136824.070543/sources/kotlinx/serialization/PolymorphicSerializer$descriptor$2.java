package kotlinx.serialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextDescriptor;
import kotlinx.serialization.descriptors.PolymorphicKind.OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "T", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PolymorphicSerializer.kt */
public final class PolymorphicSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {
    public final /* synthetic */ PolymorphicSerializer<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PolymorphicSerializer$descriptor$2(PolymorphicSerializer<T> polymorphicSerializer) {
        // this.this$0 = polymorphicSerializer;
        super(0);
    }

    public Object invoke() {
        final PolymorphicSerializer<T> polymorphicSerializer = this.this$0;
        SerialDescriptor buildSerialDescriptor = TypeUtilsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", OPEN.INSTANCE, new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() {
            public Object invoke(Object obj) {
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
                TypeUtilsKt.serializer(StringCompanionObject.INSTANCE);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "type", StringSerializer.descriptor, null, false, 12);
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("kotlinx.serialization.Polymorphic<");
                outline73.append(polymorphicSerializer.baseClass.getSimpleName());
                outline73.append('>');
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, HSLCriteriaBuilder.VALUE, TypeUtilsKt.buildSerialDescriptor$default(outline73.toString(), CONTEXTUAL.INSTANCE, new SerialDescriptor[0], null, 8), null, false, 12);
                List<? extends Annotation> list = polymorphicSerializer._annotations;
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                classSerialDescriptorBuilder.annotations = list;
                return Unit.INSTANCE;
            }
        });
        KClass<T> kClass = this.this$0.baseClass;
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "context");
        return new ContextDescriptor(buildSerialDescriptor, kClass);
    }
}
