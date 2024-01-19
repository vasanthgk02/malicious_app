package com.google.zxing.aztec.encoder;

public final class State {
    public static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    public final int binaryShiftByteCount;
    public final int bitCount;
    public final int mode;
    public final Token token;

    public State(Token token2, int i, int i2, int i3) {
        this.token = token2;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    public State addBinaryShiftChar(int i) {
        Token token2 = this.token;
        int i2 = this.mode;
        int i3 = this.bitCount;
        if (i2 == 4 || i2 == 2) {
            int i4 = HighLevelEncoder.LATCH_TABLE[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            if (token2 != null) {
                i3 += i6;
                token2 = new SimpleToken(token2, i5, i6);
                i2 = 0;
            } else {
                throw null;
            }
        }
        int i7 = this.binaryShiftByteCount;
        State state = new State(token2, i2, this.binaryShiftByteCount + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i + 1) : state;
    }

    public State endBinaryShift(int i) {
        int i2 = this.binaryShiftByteCount;
        if (i2 == 0) {
            return this;
        }
        Token token2 = this.token;
        int i3 = i - i2;
        if (token2 != null) {
            return new State(new BinaryShiftToken(token2, i3, i2), this.mode, 0, this.bitCount);
        }
        throw null;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i2 = state.binaryShiftByteCount;
        if (i2 > 0) {
            int i3 = this.binaryShiftByteCount;
            if (i3 == 0 || i3 > i2) {
                i += 10;
            }
        }
        return i <= state.bitCount;
    }

    public State latchAndAppend(int i, int i2) {
        int i3 = this.bitCount;
        Token token2 = this.token;
        int i4 = this.mode;
        if (i != i4) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            if (token2 != null) {
                i3 += i7;
                token2 = new SimpleToken(token2, i6, i7);
            } else {
                throw null;
            }
        }
        int i8 = i == 2 ? 4 : 5;
        if (token2 != null) {
            return new State(new SimpleToken(token2, i2, i8), i, 0, i3 + i8);
        }
        throw null;
    }

    public State shiftAndAppend(int i, int i2) {
        Token token2 = this.token;
        int i3 = this.mode == 2 ? 4 : 5;
        int i4 = HighLevelEncoder.SHIFT_TABLE[this.mode][i];
        if (token2 != null) {
            return new State(new SimpleToken(new SimpleToken(token2, i4, i3), i2, 5), this.mode, 0, this.bitCount + i3 + 5);
        }
        throw null;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
