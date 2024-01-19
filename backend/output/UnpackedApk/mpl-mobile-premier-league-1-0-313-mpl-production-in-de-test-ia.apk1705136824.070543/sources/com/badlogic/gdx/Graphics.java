package com.badlogic.gdx;

import com.android.tools.r8.GeneratedOutlineSupport;

public interface Graphics {

    public static class BufferFormat {

        /* renamed from: a  reason: collision with root package name */
        public final int f3301a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3302b;
        public final boolean coverageSampling;
        public final int depth;
        public final int g;
        public final int r;
        public final int samples;
        public final int stencil;

        public BufferFormat(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
            this.r = i;
            this.g = i2;
            this.f3302b = i3;
            this.f3301a = i4;
            this.depth = i5;
            this.stencil = i6;
            this.samples = i7;
            this.coverageSampling = z;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("r: ");
            outline73.append(this.r);
            outline73.append(", g: ");
            outline73.append(this.g);
            outline73.append(", b: ");
            outline73.append(this.f3302b);
            outline73.append(", a: ");
            outline73.append(this.f3301a);
            outline73.append(", depth: ");
            outline73.append(this.depth);
            outline73.append(", stencil: ");
            outline73.append(this.stencil);
            outline73.append(", num samples: ");
            outline73.append(this.samples);
            outline73.append(", coverage sampling: ");
            outline73.append(this.coverageSampling);
            return outline73.toString();
        }
    }
}
