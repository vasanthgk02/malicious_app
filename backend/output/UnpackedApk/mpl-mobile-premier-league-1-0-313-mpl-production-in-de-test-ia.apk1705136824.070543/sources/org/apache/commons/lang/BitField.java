package org.apache.commons.lang;

public class BitField {
    public final int _mask;
    public final int _shift_count;

    public BitField(int i) {
        this._mask = i;
        int i2 = 0;
        if (i != 0) {
            while ((i & 1) == 0) {
                i2++;
                i >>= 1;
            }
        }
        this._shift_count = i2;
    }

    public int clear(int i) {
        return i & (~this._mask);
    }

    public byte clearByte(byte b2) {
        return (byte) clear(b2);
    }

    public short clearShort(short s) {
        return (short) clear(s);
    }

    public int getRawValue(int i) {
        return i & this._mask;
    }

    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    public int getValue(int i) {
        return getRawValue(i) >> this._shift_count;
    }

    public boolean isAllSet(int i) {
        int i2 = this._mask;
        return (i & i2) == i2;
    }

    public boolean isSet(int i) {
        return (i & this._mask) != 0;
    }

    public int set(int i) {
        return i | this._mask;
    }

    public int setBoolean(int i, boolean z) {
        return z ? set(i) : clear(i);
    }

    public byte setByte(byte b2) {
        return (byte) set(b2);
    }

    public byte setByteBoolean(byte b2, boolean z) {
        return z ? setByte(b2) : clearByte(b2);
    }

    public short setShort(short s) {
        return (short) set(s);
    }

    public short setShortBoolean(short s, boolean z) {
        return z ? setShort(s) : clearShort(s);
    }

    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    public int setValue(int i, int i2) {
        int i3 = this._mask;
        return (i & (~i3)) | ((i2 << this._shift_count) & i3);
    }
}
