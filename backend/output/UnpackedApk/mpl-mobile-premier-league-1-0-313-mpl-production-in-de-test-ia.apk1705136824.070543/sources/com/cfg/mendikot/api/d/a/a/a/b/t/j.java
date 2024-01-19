package com.cfg.mendikot.api.d.a.a.a.b.t;

import com.android.tools.r8.GeneratedOutlineSupport;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final int f2312a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2313b;

    /* renamed from: c  reason: collision with root package name */
    public int f2314c;

    public j(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i <= i2) {
            this.f2312a = i;
            this.f2313b = i2;
            this.f2314c = i;
        } else {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
    }

    public void a(int i) {
        if (i < this.f2312a) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("pos: ", i, " < lowerBound: ");
            outline74.append(this.f2312a);
            throw new IndexOutOfBoundsException(outline74.toString());
        } else if (i <= this.f2313b) {
            this.f2314c = i;
        } else {
            StringBuilder outline742 = GeneratedOutlineSupport.outline74("pos: ", i, " > upperBound: ");
            outline742.append(this.f2313b);
            throw new IndexOutOfBoundsException(outline742.toString());
        }
    }

    public String toString() {
        StringBuilder outline72 = GeneratedOutlineSupport.outline72('[');
        outline72.append(Integer.toString(this.f2312a));
        outline72.append('>');
        outline72.append(Integer.toString(this.f2314c));
        outline72.append('>');
        outline72.append(Integer.toString(this.f2313b));
        outline72.append(']');
        return outline72.toString();
    }
}
