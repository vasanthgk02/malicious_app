package org.apache.commons.lang.builder;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;

public class ToStringBuilder {
    public static ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
    public final StringBuffer buffer;
    public final Object object;
    public final ToStringStyle style;

    public ToStringBuilder(Object obj) {
        this(obj, getDefaultStyle(), null);
    }

    public static ToStringStyle getDefaultStyle() {
        return defaultStyle;
    }

    public static String reflectionToString(Object obj) {
        return ReflectionToStringBuilder.toString(obj);
    }

    public static void setDefaultStyle(ToStringStyle toStringStyle) {
        if (toStringStyle != null) {
            defaultStyle = toStringStyle;
            return;
        }
        throw new IllegalArgumentException("The style must not be null");
    }

    public ToStringBuilder append(boolean z) {
        this.style.append(this.buffer, (String) null, z);
        return this;
    }

    public ToStringBuilder appendAsObjectToString(Object obj) {
        ObjectUtils.appendIdentityToString(getStringBuffer(), obj);
        return this;
    }

    public ToStringBuilder appendSuper(String str) {
        if (str != null) {
            this.style.appendSuper(this.buffer, str);
        }
        return this;
    }

    public ToStringBuilder appendToString(String str) {
        if (str != null) {
            this.style.appendToString(this.buffer, str);
        }
        return this;
    }

    public Object getObject() {
        return this.object;
    }

    public StringBuffer getStringBuffer() {
        return this.buffer;
    }

    public ToStringStyle getStyle() {
        return this.style;
    }

    public String toString() {
        if (getObject() == null) {
            getStringBuffer().append(getStyle().getNullText());
        } else {
            this.style.appendEnd(getStringBuffer(), getObject());
        }
        return getStringBuffer().toString();
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        this(obj, toStringStyle, null);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle);
    }

    public ToStringBuilder append(boolean[] zArr) {
        this.style.append(this.buffer, (String) null, zArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        toStringStyle = toStringStyle == null ? getDefaultStyle() : toStringStyle;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.buffer = stringBuffer;
        this.style = toStringStyle;
        this.object = obj;
        toStringStyle.appendStart(stringBuffer, obj);
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, false, null);
    }

    public ToStringBuilder append(byte b2) {
        this.style.append(this.buffer, (String) null, b2);
        return this;
    }

    public static String reflectionToString(Object obj, ToStringStyle toStringStyle, boolean z, Class cls) {
        return ReflectionToStringBuilder.toString(obj, toStringStyle, z, false, cls);
    }

    public ToStringBuilder append(byte[] bArr) {
        this.style.append(this.buffer, (String) null, bArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(char c2) {
        this.style.append(this.buffer, (String) null, c2);
        return this;
    }

    public ToStringBuilder append(char[] cArr) {
        this.style.append(this.buffer, (String) null, cArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(double d2) {
        this.style.append(this.buffer, (String) null, d2);
        return this;
    }

    public ToStringBuilder append(double[] dArr) {
        this.style.append(this.buffer, (String) null, dArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(float f2) {
        this.style.append(this.buffer, (String) null, f2);
        return this;
    }

    public ToStringBuilder append(float[] fArr) {
        this.style.append(this.buffer, (String) null, fArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(int i) {
        this.style.append(this.buffer, (String) null, i);
        return this;
    }

    public ToStringBuilder append(int[] iArr) {
        this.style.append(this.buffer, (String) null, iArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(long j) {
        this.style.append(this.buffer, (String) null, j);
        return this;
    }

    public ToStringBuilder append(long[] jArr) {
        this.style.append(this.buffer, (String) null, jArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(Object obj) {
        this.style.append(this.buffer, (String) null, obj, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(Object[] objArr) {
        this.style.append(this.buffer, (String) null, objArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(short s) {
        this.style.append(this.buffer, (String) null, s);
        return this;
    }

    public ToStringBuilder append(short[] sArr) {
        this.style.append(this.buffer, (String) null, sArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, boolean z) {
        this.style.append(this.buffer, str, z);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr) {
        this.style.append(this.buffer, str, zArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, boolean[] zArr, boolean z) {
        this.style.append(this.buffer, str, zArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, byte b2) {
        this.style.append(this.buffer, str, b2);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr) {
        this.style.append(this.buffer, str, bArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, byte[] bArr, boolean z) {
        this.style.append(this.buffer, str, bArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, char c2) {
        this.style.append(this.buffer, str, c2);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr) {
        this.style.append(this.buffer, str, cArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, char[] cArr, boolean z) {
        this.style.append(this.buffer, str, cArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, double d2) {
        this.style.append(this.buffer, str, d2);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr) {
        this.style.append(this.buffer, str, dArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, double[] dArr, boolean z) {
        this.style.append(this.buffer, str, dArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, float f2) {
        this.style.append(this.buffer, str, f2);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr) {
        this.style.append(this.buffer, str, fArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, float[] fArr, boolean z) {
        this.style.append(this.buffer, str, fArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, int i) {
        this.style.append(this.buffer, str, i);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr) {
        this.style.append(this.buffer, str, iArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, int[] iArr, boolean z) {
        this.style.append(this.buffer, str, iArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, long j) {
        this.style.append(this.buffer, str, j);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr) {
        this.style.append(this.buffer, str, jArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, long[] jArr, boolean z) {
        this.style.append(this.buffer, str, jArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, Object obj) {
        this.style.append(this.buffer, str, obj, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, Object obj, boolean z) {
        this.style.append(this.buffer, str, obj, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr) {
        this.style.append(this.buffer, str, objArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, Object[] objArr, boolean z) {
        this.style.append(this.buffer, str, objArr, BooleanUtils.toBooleanObject(z));
        return this;
    }

    public ToStringBuilder append(String str, short s) {
        this.style.append(this.buffer, str, s);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr) {
        this.style.append(this.buffer, str, sArr, (Boolean) null);
        return this;
    }

    public ToStringBuilder append(String str, short[] sArr, boolean z) {
        this.style.append(this.buffer, str, sArr, BooleanUtils.toBooleanObject(z));
        return this;
    }
}
