package kotlinx.serialization.json;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind.STRING;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.json.internal.StringOpsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/JsonLiteralSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonLiteral;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElementSerializers.kt */
public final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {
    public static final JsonLiteralSerializer INSTANCE = new JsonLiteralSerializer();
    public static final SerialDescriptor descriptor = TypeUtilsKt.PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", STRING.INSTANCE);

    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement decodeJsonElement = TypeUtilsKt.asJsonDecoder(decoder).decodeJsonElement();
        if (decodeJsonElement instanceof JsonLiteral) {
            return (JsonLiteral) decodeJsonElement;
        }
        throw TypeUtilsKt.JsonDecodingException(-1, Intrinsics.stringPlus("Unexpected JSON element, expected JsonLiteral, had ", Reflection.getOrCreateKotlinClass(decodeJsonElement.getClass())), decodeJsonElement.toString());
    }

    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, Object obj) {
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(jsonLiteral, HSLCriteriaBuilder.VALUE);
        TypeUtilsKt.access$verify(encoder);
        if (jsonLiteral.isString) {
            encoder.encodeString(jsonLiteral.content);
            return;
        }
        Intrinsics.checkNotNullParameter(jsonLiteral, "<this>");
        Long longOrNull = CharsKt__CharKt.toLongOrNull(jsonLiteral.content);
        if (longOrNull == null) {
            ULong uLongOrNull = CharsKt__CharKt.toULongOrNull(jsonLiteral.content);
            if (uLongOrNull == null) {
                Intrinsics.checkNotNullParameter(jsonLiteral, "<this>");
                Double doubleOrNull = TypeUtilsKt.toDoubleOrNull(jsonLiteral.content);
                if (doubleOrNull == null) {
                    Intrinsics.checkNotNullParameter(jsonLiteral, "<this>");
                    Boolean booleanStrictOrNull = StringOpsKt.toBooleanStrictOrNull(jsonLiteral.content);
                    if (booleanStrictOrNull == null) {
                        encoder.encodeString(jsonLiteral.content);
                    } else {
                        encoder.encodeBoolean(booleanStrictOrNull.booleanValue());
                    }
                } else {
                    encoder.encodeDouble(doubleOrNull.doubleValue());
                }
            } else {
                long j = uLongOrNull.data;
                ULongSerializer uLongSerializer = ULongSerializer.INSTANCE;
                encoder.encodeInline(ULongSerializer.descriptor).encodeLong(j);
            }
        } else {
            encoder.encodeLong(longOrNull.longValue());
        }
    }
}
