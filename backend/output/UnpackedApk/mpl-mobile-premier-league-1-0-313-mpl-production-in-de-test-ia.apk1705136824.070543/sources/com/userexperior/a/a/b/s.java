package com.userexperior.a.a.b;

public final class s implements CharSequence {

    /* renamed from: a  reason: collision with root package name */
    public char[] f3718a;

    public final char charAt(int i) {
        return this.f3718a[i];
    }

    public final int length() {
        return this.f3718a.length;
    }

    public final CharSequence subSequence(int i, int i2) {
        return new String(this.f3718a, i, i2 - i);
    }
}
