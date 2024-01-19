package kotlin.reflect.jvm.internal.impl.load.java;

import com.mpl.androidapp.utils.Constant;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.CharsKt__CharKt;

/* compiled from: JvmAbi.kt */
public final class JvmAbi {
    public static final JvmAbi INSTANCE = null;
    public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName((String) "kotlin.jvm.JvmField");

    static {
        Intrinsics.checkNotNullExpressionValue(ClassId.topLevel(new FqName((String) "kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    public static final String getterName(String str) {
        Intrinsics.checkNotNullParameter(str, "propertyName");
        return startsWithIsPrefix(str) ? str : Intrinsics.stringPlus(Constant.GET, TypeUtilsKt.capitalizeAsciiOnly(str));
    }

    public static final String setterName(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "propertyName");
        if (startsWithIsPrefix(str)) {
            str2 = str.substring(2);
            Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).substring(startIndex)");
        } else {
            str2 = TypeUtilsKt.capitalizeAsciiOnly(str);
        }
        return Intrinsics.stringPlus("set", str2);
    }

    public static final boolean startsWithIsPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        boolean z = false;
        if (!CharsKt__CharKt.startsWith$default(str, (String) "is", false, 2) || str.length() == 2) {
            return false;
        }
        char charAt = str.charAt(2);
        if (Intrinsics.compare(97, (int) charAt) > 0 || Intrinsics.compare((int) charAt, 122) > 0) {
            z = true;
        }
        return z;
    }
}
