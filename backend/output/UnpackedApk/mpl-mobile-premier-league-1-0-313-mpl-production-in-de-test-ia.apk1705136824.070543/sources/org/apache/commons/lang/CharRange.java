package org.apache.commons.lang;

import java.io.Serializable;

public final class CharRange implements Serializable {
    public static final long serialVersionUID = 8270183163158333422L;
    public final char end;
    public transient String iToString;
    public final boolean negated;
    public final char start;

    public CharRange(char c2) {
        this(c2, c2, false);
    }

    public boolean contains(char c2) {
        return (c2 >= this.start && c2 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (!(this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated)) {
            z = false;
        }
        return z;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return (this.end * 7) + this.start + 'S' + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuffer stringBuffer = new StringBuffer(4);
            if (isNegated()) {
                stringBuffer.append('^');
            }
            stringBuffer.append(this.start);
            if (this.start != this.end) {
                stringBuffer.append('-');
                stringBuffer.append(this.end);
            }
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }

    public CharRange(char c2, boolean z) {
        this(c2, c2, z);
    }

    public boolean contains(CharRange charRange) {
        if (charRange != null) {
            boolean z = true;
            if (this.negated) {
                if (charRange.negated) {
                    if (this.start < charRange.start || this.end > charRange.end) {
                        z = false;
                    }
                    return z;
                }
                if (charRange.end >= this.start && charRange.start <= this.end) {
                    z = false;
                }
                return z;
            } else if (charRange.negated) {
                if (!(this.start == 0 && this.end == 65535)) {
                    z = false;
                }
                return z;
            } else {
                if (this.start > charRange.start || this.end < charRange.end) {
                    z = false;
                }
                return z;
            }
        } else {
            throw new IllegalArgumentException("The Range must not be null");
        }
    }

    public CharRange(char c2, char c3) {
        this(c2, c3, false);
    }

    public CharRange(char c2, char c3, boolean z) {
        if (c2 > c3) {
            char c4 = c3;
            c3 = c2;
            c2 = c4;
        }
        this.start = c2;
        this.end = c3;
        this.negated = z;
    }
}
