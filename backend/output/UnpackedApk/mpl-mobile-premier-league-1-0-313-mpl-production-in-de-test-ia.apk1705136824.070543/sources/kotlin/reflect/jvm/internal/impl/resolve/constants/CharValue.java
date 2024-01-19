package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char c2) {
        super(Character.valueOf(c2));
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        if (builtIns != null) {
            SimpleType primitiveKotlinType = builtIns.getPrimitiveKotlinType(PrimitiveType.CHAR);
            if (primitiveKotlinType != null) {
                Intrinsics.checkNotNullExpressionValue(primitiveKotlinType, "module.builtIns.charType");
                return primitiveKotlinType;
            }
            KotlinBuiltIns.$$$reportNull$$$0(61);
            throw null;
        }
        throw null;
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = Integer.valueOf(((Character) this.value).charValue());
        char charValue = ((Character) this.value).charValue();
        if (charValue == 8) {
            str = "\\b";
        } else if (charValue == 9) {
            str = "\\t";
        } else if (charValue == 10) {
            str = "\\n";
        } else if (charValue == 12) {
            str = "\\f";
        } else if (charValue == 13) {
            str = "\\r";
        } else {
            byte type = (byte) Character.getType(charValue);
            if (!(type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19)) {
                z = true;
            }
            str = z ? String.valueOf(charValue) : ColorPropConverter.PREFIX_ATTR;
        }
        objArr[1] = str;
        return GeneratedOutlineSupport.outline70(objArr, 2, "\\u%04X ('%s')", "java.lang.String.format(this, *args)");
    }
}
