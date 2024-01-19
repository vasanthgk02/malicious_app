package org.apache.commons.lang.mutable;

import java.io.Serializable;
import org.apache.commons.lang.BooleanUtils;

public class MutableBoolean implements Mutable, Serializable, Comparable {
    public static final long serialVersionUID = -4830728138360036487L;
    public boolean value;

    public MutableBoolean() {
    }

    public boolean booleanValue() {
        return this.value;
    }

    public int compareTo(Object obj) {
        boolean z = ((MutableBoolean) obj).value;
        boolean z2 = this.value;
        if (z2 == z) {
            return 0;
        }
        return z2 ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableBoolean) || this.value != ((MutableBoolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public Object getValue() {
        return BooleanUtils.toBooleanObject(this.value);
    }

    public int hashCode() {
        return (this.value ? Boolean.TRUE : Boolean.FALSE).hashCode();
    }

    public void setValue(boolean z) {
        this.value = z;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableBoolean(boolean z) {
        this.value = z;
    }

    public void setValue(Object obj) {
        setValue(((Boolean) obj).booleanValue());
    }

    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }
}
