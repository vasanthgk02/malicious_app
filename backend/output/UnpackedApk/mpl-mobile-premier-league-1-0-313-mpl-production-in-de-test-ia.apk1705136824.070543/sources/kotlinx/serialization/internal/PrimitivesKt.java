package kotlinx.serialization.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0004\"\b\b\u0000\u0010\u0010*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00100\u0002H\u0000\u001a\f\u0010\u0011\u001a\u00020\n*\u00020\nH\u0002\"2\u0010\u0000\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00040\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"BUILTIN_SERIALIZERS", "", "Lkotlin/reflect/KClass;", "", "Lkotlinx/serialization/KSerializer;", "getBUILTIN_SERIALIZERS$annotations", "()V", "PrimitiveDescriptorSafe", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "checkName", "", "builtinSerializerOrNull", "T", "capitalize", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Primitives.kt */
public final class PrimitivesKt {
    public static final Map<KClass<? extends Object>, KSerializer<? extends Object>> BUILTIN_SERIALIZERS = ArraysKt___ArraysJvmKt.mapOf(new Pair(Reflection.getOrCreateKotlinClass(String.class), TypeUtilsKt.serializer(StringCompanionObject.INSTANCE)), new Pair(Reflection.getOrCreateKotlinClass(Character.TYPE), CharSerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(char[].class), CharArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Double.TYPE), DoubleSerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(double[].class), DoubleArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Float.TYPE), FloatSerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(float[].class), FloatArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Long.TYPE), TypeUtilsKt.serializer(LongCompanionObject.INSTANCE)), new Pair(Reflection.getOrCreateKotlinClass(long[].class), LongArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Integer.TYPE), TypeUtilsKt.serializer(IntCompanionObject.INSTANCE)), new Pair(Reflection.getOrCreateKotlinClass(int[].class), IntArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Short.TYPE), TypeUtilsKt.serializer(ShortCompanionObject.INSTANCE)), new Pair(Reflection.getOrCreateKotlinClass(short[].class), ShortArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Byte.TYPE), TypeUtilsKt.serializer(ByteCompanionObject.INSTANCE)), new Pair(Reflection.getOrCreateKotlinClass(byte[].class), ByteArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Boolean.TYPE), BooleanSerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(boolean[].class), BooleanArraySerializer.INSTANCE), new Pair(Reflection.getOrCreateKotlinClass(Unit.class), UnitSerializer.INSTANCE));

    public static final SerialDescriptor PrimitiveDescriptorSafe(String str, PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, "kind");
        for (KClass<? extends Object> simpleName : BUILTIN_SERIALIZERS.keySet()) {
            String simpleName2 = simpleName.getSimpleName();
            Intrinsics.checkNotNull(simpleName2);
            String capitalize = capitalize(simpleName2);
            if (!CharsKt__CharKt.equals(str, Intrinsics.stringPlus("kotlin.", capitalize), true)) {
                if (CharsKt__CharKt.equals(str, capitalize, true)) {
                }
            }
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", str, " there already exist ");
            outline80.append(capitalize(capitalize));
            outline80.append("Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
            throw new IllegalArgumentException(CharsKt__CharKt.trimIndent(outline80.toString()));
        }
        return new PrimitiveSerialDescriptor(str, primitiveKind);
    }

    public static final <T> KSerializer<T> builtinSerializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return BUILTIN_SERIALIZERS.get(kClass);
    }

    public static final String capitalize(String str) {
        String str2;
        if (!(str.length() > 0)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        if (Character.isLowerCase(charAt)) {
            String valueOf = String.valueOf(charAt);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            str2 = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            if (str2.length() <= 1) {
                str2 = String.valueOf(Character.toTitleCase(charAt));
            } else if (charAt != 329) {
                char charAt2 = str2.charAt(0);
                Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                String substring = str2.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                Intrinsics.checkNotNullExpressionValue(substring.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(Locale.ROOT)");
                str2 = charAt2 + r3;
            }
        } else {
            str2 = String.valueOf(charAt);
        }
        sb.append(str2.toString());
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }
}
