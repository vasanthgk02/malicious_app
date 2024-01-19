package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.CharsKt__CharKt;

/* compiled from: methodSignatureMapping.kt */
public final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = new JvmTypeFactoryImpl();

    public Object boxType(Object obj) {
        JvmType jvmType = (JvmType) obj;
        Intrinsics.checkNotNullParameter(jvmType, "possiblyPrimitiveType");
        if (!(jvmType instanceof Primitive)) {
            return jvmType;
        }
        JvmPrimitiveType jvmPrimitiveType = ((Primitive) jvmType).jvmPrimitiveType;
        if (jvmPrimitiveType == null) {
            return jvmType;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(jvmPrimitiveType.getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(internalName);
    }

    public Object createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        switch (primitiveType.ordinal()) {
            case 0:
                JvmType jvmType = JvmType.Companion;
                return JvmType.BOOLEAN;
            case 1:
                JvmType jvmType2 = JvmType.Companion;
                return JvmType.CHAR;
            case 2:
                JvmType jvmType3 = JvmType.Companion;
                return JvmType.BYTE;
            case 3:
                JvmType jvmType4 = JvmType.Companion;
                return JvmType.SHORT;
            case 4:
                JvmType jvmType5 = JvmType.Companion;
                return JvmType.INT;
            case 5:
                JvmType jvmType6 = JvmType.Companion;
                return JvmType.FLOAT;
            case 6:
                JvmType jvmType7 = JvmType.Companion;
                return JvmType.LONG;
            case 7:
                JvmType jvmType8 = JvmType.Companion;
                return JvmType.DOUBLE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public Object getJavaLangClassType() {
        return createObjectType((String) "java/lang/Class");
    }

    public JvmType createFromString(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        JvmType jvmType;
        JvmType object;
        Intrinsics.checkNotNullParameter(str, "representation");
        boolean z = false;
        boolean z2 = str.length() > 0;
        if (!_Assertions.ENABLED || z2) {
            char charAt = str.charAt(0);
            JvmPrimitiveType[] values = JvmPrimitiveType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    jvmPrimitiveType = null;
                    break;
                }
                jvmPrimitiveType = values[i];
                if (jvmPrimitiveType.getDesc().charAt(0) == charAt) {
                    break;
                }
                i++;
            }
            if (jvmPrimitiveType != null) {
                return new Primitive(jvmPrimitiveType);
            }
            if (charAt == 'V') {
                jvmType = new Primitive(null);
            } else {
                if (charAt == '[') {
                    String substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    object = new Array(createFromString(substring));
                } else {
                    if (charAt == 'L') {
                        Intrinsics.checkNotNullParameter(str, "<this>");
                        if (str.length() > 0 && CharsKt__CharKt.equals(str.charAt(CharsKt__CharKt.getLastIndex(str)), (char) DefaultObjectDumpFormatter.TOKEN_DIVIDER, false)) {
                            z = true;
                        }
                    }
                    if (!_Assertions.ENABLED || z) {
                        String substring2 = str.substring(1, str.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        object = new Object(substring2);
                    } else {
                        throw new AssertionError(GeneratedOutlineSupport.outline52("Type that is not primitive nor array should be Object, but '", str, "' was found"));
                    }
                }
                jvmType = object;
            }
            return jvmType;
        }
        throw new AssertionError("empty string as JvmType");
    }

    public Object createObjectType(String str) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        return new Object(str);
    }

    public String toString(JvmType jvmType) {
        Intrinsics.checkNotNullParameter(jvmType, "type");
        if (jvmType instanceof Array) {
            return Intrinsics.stringPlus("[", toString(((Array) jvmType).elementType));
        }
        if (jvmType instanceof Primitive) {
            JvmPrimitiveType jvmPrimitiveType = ((Primitive) jvmType).jvmPrimitiveType;
            if (jvmPrimitiveType != null) {
                String desc = jvmPrimitiveType.getDesc();
                if (desc != null) {
                    return desc;
                }
            }
            return DefaultSFSDataSerializer.FIELD_VALUE_KEY;
        } else if (jvmType instanceof Object) {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline72('L'), ((Object) jvmType).internalName, DefaultObjectDumpFormatter.TOKEN_DIVIDER);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
