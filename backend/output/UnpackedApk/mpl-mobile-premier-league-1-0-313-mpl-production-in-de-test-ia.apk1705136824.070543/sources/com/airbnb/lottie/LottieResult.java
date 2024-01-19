package com.airbnb.lottie;

import java.util.Arrays;

public final class LottieResult<V> {
    public final Throwable exception;
    public final V value;

    public LottieResult(V v) {
        this.value = v;
        this.exception = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        V v = this.value;
        if (v != null && v.equals(lottieResult.value)) {
            return true;
        }
        Throwable th = this.exception;
        if (th == null || lottieResult.exception == null) {
            return false;
        }
        return th.toString().equals(this.exception.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.value, this.exception});
    }

    public LottieResult(Throwable th) {
        this.exception = th;
        this.value = null;
    }
}
