package kotlinx.serialization.json.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.SerialKind.ENUM;
import kotlinx.serialization.descriptors.StructureKind.LIST;
import kotlinx.serialization.descriptors.StructureKind.MAP;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import org.apache.commons.lang.text.ExtendedMessageFormat;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H$J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J!\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0014J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0015H\u0014J\u0010\u00104\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00105\u001a\u0002062\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020\u0017H\u0004J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020\u0017H\u0002J\u0014\u0010C\u001a\u00020D*\u00020@2\u0006\u0010E\u001a\u00020\u0017H\u0002J?\u0010B\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020F*\u00020@2\u0006\u0010B\u001a\u00020\u00172\u0019\u0010G\u001a\u0015\u0012\u0004\u0012\u00020@\u0012\u0006\u0012\u0004\u0018\u0001H!0H¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010JR\u0010\u0010\b\u001a\u00020\t8\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0001\u0003KLM¨\u0006N"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJsonElement", "decodeNotNullMark", "", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescriptor", "decodeTaggedFloat", "", "decodeTaggedInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "endStructure", "", "getPrimitiveValue", "Lkotlinx/serialization/json/JsonPrimitive;", "unparsedPrimitive", "primitive", "asLiteral", "Lkotlinx/serialization/json/JsonLiteral;", "type", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
public abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    public final JsonConfiguration configuration;
    public final Json json;

    public AbstractJsonTreeDecoder(Json json2, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this.json = json2;
        this.configuration = json2.configuration;
    }

    public static final Void access$unparsedPrimitive(AbstractJsonTreeDecoder abstractJsonTreeDecoder, String str) {
        throw TypeUtilsKt.JsonDecodingException(-1, "Failed to parse '" + str + ExtendedMessageFormat.QUOTE, abstractJsonTreeDecoder.currentObject().toString());
    }

    public final JsonLiteral asLiteral(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral = jsonPrimitive instanceof JsonLiteral ? (JsonLiteral) jsonPrimitive : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw TypeUtilsKt.JsonDecodingException(-1, "Unexpected 'null' when " + str + " was expected");
    }

    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual(kind, LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            Json json2 = this.json;
            if (currentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json2, (JsonArray) currentObject);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected ");
            outline73.append(Reflection.getOrCreateKotlinClass(JsonArray.class));
            outline73.append(" as the serialized body of ");
            outline73.append(serialDescriptor.getSerialName());
            outline73.append(", but had ");
            outline73.append(Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            throw TypeUtilsKt.JsonDecodingException(-1, outline73.toString());
        } else if (Intrinsics.areEqual(kind, MAP.INSTANCE)) {
            Json json3 = this.json;
            SerialDescriptor carrierDescriptor = TypeUtilsKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json3.serializersModule);
            SerialKind kind2 = carrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual(kind2, ENUM.INSTANCE)) {
                Json json4 = this.json;
                if (currentObject instanceof JsonObject) {
                    return new JsonTreeMapDecoder(json4, (JsonObject) currentObject);
                }
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Expected ");
                outline732.append(Reflection.getOrCreateKotlinClass(JsonObject.class));
                outline732.append(" as the serialized body of ");
                outline732.append(serialDescriptor.getSerialName());
                outline732.append(", but had ");
                outline732.append(Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                throw TypeUtilsKt.JsonDecodingException(-1, outline732.toString());
            } else if (json3.configuration.allowStructuredMapKeys) {
                Json json5 = this.json;
                if (currentObject instanceof JsonArray) {
                    return new JsonTreeListDecoder(json5, (JsonArray) currentObject);
                }
                StringBuilder outline733 = GeneratedOutlineSupport.outline73("Expected ");
                outline733.append(Reflection.getOrCreateKotlinClass(JsonArray.class));
                outline733.append(" as the serialized body of ");
                outline733.append(serialDescriptor.getSerialName());
                outline733.append(", but had ");
                outline733.append(Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                throw TypeUtilsKt.JsonDecodingException(-1, outline733.toString());
            } else {
                throw TypeUtilsKt.InvalidKeyKindException(carrierDescriptor);
            }
        } else {
            Json json6 = this.json;
            if (currentObject instanceof JsonObject) {
                JsonTreeDecoder jsonTreeDecoder = new JsonTreeDecoder(json6, (JsonObject) currentObject, null, null, 12);
                return jsonTreeDecoder;
            }
            StringBuilder outline734 = GeneratedOutlineSupport.outline73("Expected ");
            outline734.append(Reflection.getOrCreateKotlinClass(JsonObject.class));
            outline734.append(" as the serialized body of ");
            outline734.append(serialDescriptor.getSerialName());
            outline734.append(", but had ");
            outline734.append(Reflection.getOrCreateKotlinClass(currentObject.getClass()));
            throw TypeUtilsKt.JsonDecodingException(-1, outline734.toString());
        }
    }

    public abstract JsonElement currentElement(String str);

    public final JsonElement currentObject() {
        String str = (String) getCurrentTagOrNull();
        JsonElement currentElement = str == null ? null : currentElement(str);
        return currentElement == null ? getValue() : currentElement;
    }

    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return TypeUtilsKt.decodeSerializableValuePolymorphic(this, deserializationStrategy);
    }

    public boolean decodeTaggedBoolean(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonPrimitive primitiveValue = getPrimitiveValue(str);
        if (this.json.configuration.isLenient || !asLiteral(primitiveValue, "boolean").isString) {
            try {
                Intrinsics.checkNotNullParameter(primitiveValue, "<this>");
                Boolean booleanStrictOrNull = StringOpsKt.toBooleanStrictOrNull(primitiveValue.getContent());
                if (booleanStrictOrNull != null) {
                    return booleanStrictOrNull.booleanValue();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException unused) {
                access$unparsedPrimitive(this, "boolean");
                throw null;
            }
        } else {
            throw TypeUtilsKt.JsonDecodingException(-1, GeneratedOutlineSupport.outline52("Boolean literal for key '", str, "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON."), currentObject().toString());
        }
    }

    public byte decodeTaggedByte(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        try {
            int i = TypeUtilsKt.getInt(getPrimitiveValue(str));
            boolean z = false;
            if (-128 <= i && i <= 127) {
                z = true;
            }
            Number valueOf = z ? Byte.valueOf((byte) i) : null;
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            access$unparsedPrimitive(this, "byte");
            throw null;
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "byte");
            throw null;
        }
    }

    public char decodeTaggedChar(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        try {
            String content = getPrimitiveValue(str).getContent();
            Intrinsics.checkNotNullParameter(content, "<this>");
            int length = content.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            } else if (length == 1) {
                return content.charAt(0);
            } else {
                throw new IllegalArgumentException("Char sequence has more than one element.");
            }
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "char");
            throw null;
        }
    }

    public double decodeTaggedDouble(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonPrimitive primitiveValue = getPrimitiveValue(str);
        try {
            Intrinsics.checkNotNullParameter(primitiveValue, "<this>");
            double parseDouble = Double.parseDouble(primitiveValue.getContent());
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!(!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble))) {
                    throw TypeUtilsKt.InvalidFloatingPointDecoded(Double.valueOf(parseDouble), str, currentObject().toString());
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "double");
            throw null;
        }
    }

    public float decodeTaggedFloat(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonPrimitive primitiveValue = getPrimitiveValue(str);
        try {
            Intrinsics.checkNotNullParameter(primitiveValue, "<this>");
            float parseFloat = Float.parseFloat(primitiveValue.getContent());
            if (!this.json.configuration.allowSpecialFloatingPointValues) {
                if (!(!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat))) {
                    throw TypeUtilsKt.InvalidFloatingPointDecoded(Float.valueOf(parseFloat), str, currentObject().toString());
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "float");
            throw null;
        }
    }

    public int decodeTaggedInt(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        try {
            return TypeUtilsKt.getInt(getPrimitiveValue(str));
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "int");
            throw null;
        }
    }

    public long decodeTaggedLong(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonPrimitive primitiveValue = getPrimitiveValue(str);
        try {
            Intrinsics.checkNotNullParameter(primitiveValue, "<this>");
            return Long.parseLong(primitiveValue.getContent());
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "long");
            throw null;
        }
    }

    public short decodeTaggedShort(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        try {
            int i = TypeUtilsKt.getInt(getPrimitiveValue(str));
            boolean z = false;
            if (-32768 <= i && i <= 32767) {
                z = true;
            }
            Number valueOf = z ? Short.valueOf((short) i) : null;
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            access$unparsedPrimitive(this, "short");
            throw null;
        } catch (IllegalArgumentException unused) {
            access$unparsedPrimitive(this, "short");
            throw null;
        }
    }

    public String decodeTaggedString(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonPrimitive primitiveValue = getPrimitiveValue(str);
        if (!this.json.configuration.isLenient && !asLiteral(primitiveValue, NetworkingModule.REQUEST_BODY_KEY_STRING).isString) {
            throw TypeUtilsKt.JsonDecodingException(-1, GeneratedOutlineSupport.outline52("String literal for key '", str, "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON."), currentObject().toString());
        } else if (!(primitiveValue instanceof JsonNull)) {
            return primitiveValue.getContent();
        } else {
            throw TypeUtilsKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
        }
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
    }

    public Json getJson() {
        return this.json;
    }

    public final JsonPrimitive getPrimitiveValue(String str) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        JsonElement currentElement = currentElement(str);
        JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw TypeUtilsKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + str + ", found " + currentElement, currentObject().toString());
    }

    public SerializersModule getSerializersModule() {
        return this.json.serializersModule;
    }

    public abstract JsonElement getValue();
}
