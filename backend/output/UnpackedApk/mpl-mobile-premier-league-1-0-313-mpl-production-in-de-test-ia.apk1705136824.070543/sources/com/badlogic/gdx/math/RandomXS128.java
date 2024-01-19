package com.badlogic.gdx.math;

import java.util.Random;

public class RandomXS128 extends Random {
    public long seed0;
    public long seed1;

    public RandomXS128() {
        setSeed(new Random().nextLong());
    }

    public static final long murmurHash3(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    public final int next(int i) {
        return (int) (nextLong() & ((1 << i) - 1));
    }

    public boolean nextBoolean() {
        return (nextLong() & 1) != 0;
    }

    public void nextBytes(byte[] bArr) {
        int length = bArr.length;
        while (length != 0) {
            int i = length < 8 ? length : 8;
            long nextLong = nextLong();
            while (true) {
                int i2 = i - 1;
                if (i != 0) {
                    length--;
                    bArr[length] = (byte) ((int) nextLong);
                    nextLong >>= 8;
                    i = i2;
                }
            }
        }
    }

    public double nextDouble() {
        return ((double) (nextLong() >>> 11)) * 1.1102230246251565E-16d;
    }

    public float nextFloat() {
        return (float) (((double) (nextLong() >>> 40)) * 5.960464477539063E-8d);
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public long nextLong() {
        long j = this.seed0;
        long j2 = this.seed1;
        this.seed0 = j2;
        long j3 = j ^ (j << 23);
        long j4 = ((j3 >>> 17) ^ (j3 ^ j2)) ^ (j2 >>> 26);
        this.seed1 = j4;
        return j4 + j2;
    }

    public void setSeed(long j) {
        if (j == 0) {
            j = Long.MIN_VALUE;
        }
        long murmurHash3 = murmurHash3(j);
        long murmurHash32 = murmurHash3(murmurHash3);
        this.seed0 = murmurHash3;
        this.seed1 = murmurHash32;
    }

    public int nextInt(int i) {
        long nextLong;
        long j;
        long j2 = (long) i;
        if (j2 > 0) {
            do {
                nextLong = nextLong() >>> 1;
                j = nextLong % j2;
            } while ((j2 - 1) + (nextLong - j) < 0);
            return (int) j;
        }
        throw new IllegalArgumentException("n must be positive");
    }
}
