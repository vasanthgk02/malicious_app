package org.apache.commons.lang.p002enum;

import in.juspay.hypersdk.core.InflateView;
import org.apache.commons.lang.ClassUtils;
import org.apache.fontbox.cmap.CMapParser;

/* renamed from: org.apache.commons.lang.enum.ValuedEnum  reason: invalid package */
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

    public int compareTo(Object obj) {
        return this.iValue - ((ValuedEnum) obj).iValue;
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
