package com.facebook.yoga;

public class YogaValue {
    public final YogaUnit unit;
    public final float value;

    static {
        YogaUnit yogaUnit = YogaUnit.UNDEFINED;
        YogaUnit yogaUnit2 = YogaUnit.POINT;
        YogaUnit yogaUnit3 = YogaUnit.AUTO;
    }

    public YogaValue(float f2, int i) {
        YogaUnit fromInt = YogaUnit.fromInt(i);
        this.value = f2;
        this.unit = fromInt;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YogaValue)) {
            return false;
        }
        YogaValue yogaValue = (YogaValue) obj;
        YogaUnit yogaUnit = this.unit;
        if (yogaUnit != yogaValue.unit) {
            return false;
        }
        if (yogaUnit == YogaUnit.UNDEFINED || yogaUnit == YogaUnit.AUTO || Float.compare(this.value, yogaValue.value) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.unit.intValue() + Float.floatToIntBits(this.value);
    }

    public String toString() {
        int ordinal = this.unit.ordinal();
        if (ordinal == 0) {
            return "undefined";
        }
        if (ordinal == 1) {
            return Float.toString(this.value);
        }
        if (ordinal == 2) {
            return this.value + "%";
        } else if (ordinal == 3) {
            return "auto";
        } else {
            throw new IllegalStateException();
        }
    }
}
