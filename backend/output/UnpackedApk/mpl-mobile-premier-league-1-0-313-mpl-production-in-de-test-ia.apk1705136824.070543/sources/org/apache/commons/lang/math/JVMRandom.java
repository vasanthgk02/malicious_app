package org.apache.commons.lang.math;

import java.util.Random;

public final class JVMRandom extends Random {
    public static final long serialVersionUID = 1;
    public boolean constructed;

    public JVMRandom() {
        this.constructed = false;
        this.constructed = true;
    }

    public boolean nextBoolean() {
        return Math.random() > 0.5d;
    }

    public void nextBytes(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public double nextDouble() {
        return Math.random();
    }

    public float nextFloat() {
        return (float) Math.random();
    }

    public synchronized double nextGaussian() {
        throw new UnsupportedOperationException();
    }

    public int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

    public long nextLong() {
        return nextLong(Long.MAX_VALUE);
    }

    public synchronized void setSeed(long j) {
        if (this.constructed) {
            throw new UnsupportedOperationException();
        }
    }

    public static long nextLong(long j) {
        if (j > 0) {
            return (long) (Math.random() * ((double) j));
        }
        throw new IllegalArgumentException("Upper bound for nextInt must be positive");
    }

    public int nextInt(int i) {
        if (i > 0) {
            return (int) (Math.random() * ((double) i));
        }
        throw new IllegalArgumentException("Upper bound for nextInt must be positive");
    }
}
