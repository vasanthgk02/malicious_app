package org.apache.commons.lang.enums;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.InflateView;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang.ClassUtils;
import org.apache.fontbox.cmap.CMapParser;

public abstract class ValuedEnum extends Enum {
    public static final long serialVersionUID = -7129650521543789085L;
    public final int iValue;

    public ValuedEnum(String str, int i) {
        super(str);
        this.iValue = i;
    }

    public static Enum getEnum(Class cls, int i) {
        if (cls != null) {
            for (ValuedEnum valuedEnum : Enum.getEnumList(cls)) {
                if (valuedEnum.getValue() == i) {
                    return valuedEnum;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("The Enum Class must not be null");
    }

    private int getValueInOtherClassLoader(Object obj) {
        try {
            return ((Integer) obj.getClass().getMethod("getValue", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            throw new IllegalStateException("This should not happen");
        }
    }

    public int compareTo(Object obj) {
        int i;
        int i2;
        if (obj == this) {
            return 0;
        }
        if (obj.getClass() == ValuedEnum.class) {
            i2 = this.iValue;
            i = ((ValuedEnum) obj).iValue;
        } else if (obj.getClass().getName().equals(ValuedEnum.class.getName())) {
            i2 = this.iValue;
            i = getValueInOtherClassLoader(obj);
        } else {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71("Different enum class '");
            outline71.append(ClassUtils.getShortClassName((Class) obj.getClass()));
            outline71.append("'");
            throw new ClassCastException(outline71.toString());
        }
        return i2 - i;
    }

    public final int getValue() {
        return this.iValue;
    }

    public String toString() {
        if (this.iToString == null) {
            String shortClassName = ClassUtils.getShortClassName(getEnumClass());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(shortClassName);
            stringBuffer.append("[");
            stringBuffer.append(getName());
            stringBuffer.append(InflateView.SETTER_EQUALS);
            stringBuffer.append(getValue());
            stringBuffer.append(CMapParser.MARK_END_OF_ARRAY);
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
