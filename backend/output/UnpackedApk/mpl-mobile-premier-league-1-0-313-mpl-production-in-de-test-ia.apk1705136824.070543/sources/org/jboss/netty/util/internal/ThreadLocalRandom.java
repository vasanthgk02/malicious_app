package org.jboss.netty.util.internal;

import java.util.Random;

public final class ThreadLocalRandom extends Random {
    public static final long addend = 11;
    public static final ThreadLocal<ThreadLocalRandom> localRandom = new ThreadLocal<ThreadLocalRandom>() {
        public ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
    };
    public static final long mask = 281474976710655L;
    public static final long multiplier = 25214903917L;
    public static final long serialVersionUID = -5851777807851030925L;
    public boolean initialized;
    public long pad0;
    public long pad1;
    public long pad2;
    public long pad3;
    public long pad4;
    public long pad5;
    public long pad6;
    public long pad7;
    public long rnd;

    public static ThreadLocalRandom current() {
        return localRandom.get();
    }

    public int next(int i) {
        long j = ((this.rnd * multiplier) + 11) & mask;
        this.rnd = j;
        return (int) (j >>> (48 - i));
    }

    public void setSeed(long j) {
        if (!this.initialized) {
            this.initialized = true;
            this.rnd = (j ^ multiplier) & mask;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
