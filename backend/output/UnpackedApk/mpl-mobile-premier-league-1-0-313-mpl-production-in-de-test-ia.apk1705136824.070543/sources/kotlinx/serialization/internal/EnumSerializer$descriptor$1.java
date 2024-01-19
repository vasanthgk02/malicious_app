package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind.OBJECT;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: Enums.kt */
public final class EnumSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public final /* synthetic */ String $serialName;
    public final /* synthetic */ EnumSerializer<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public EnumSerializer$descriptor$1(EnumSerializer<T> enumSerializer, String str) {
        // this.this$0 = enumSerializer;
        // this.$serialName = str;
        super(1);
    }

    public Object invoke(Object obj) {
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        T[] tArr = this.this$0.values;
        String str = this.$serialName;
        for (T name : tArr) {
            SerialDescriptor buildSerialDescriptor$default = TypeUtilsKt.buildSerialDescriptor$default(str + '.' + name.name(), OBJECT.INSTANCE, new SerialDescriptor[0], null, 8);
            ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, tArr[r10].name(), buildSerialDescriptor$default, null, false, 12);
        }
        return Unit.INSTANCE;
    }
}
