package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElementSerializers.kt */
public final class JsonElementSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {
    public static final JsonElementSerializer$descriptor$1 INSTANCE = new JsonElementSerializer$descriptor$1();

    public JsonElementSerializer$descriptor$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonPrimitive", new JsonElementSerializersKt$defer$1(AnonymousClass1.INSTANCE), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonNull", new JsonElementSerializersKt$defer$1(AnonymousClass2.INSTANCE), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonLiteral", new JsonElementSerializersKt$defer$1(AnonymousClass3.INSTANCE), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonObject", new JsonElementSerializersKt$defer$1(AnonymousClass4.INSTANCE), null, false, 12);
        ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonArray", new JsonElementSerializersKt$defer$1(AnonymousClass5.INSTANCE), null, false, 12);
        return Unit.INSTANCE;
    }
}
