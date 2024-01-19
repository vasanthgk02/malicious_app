package org.apache.pdfbox.util;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class Vector {
    public final float x;
    public final float y;

    public Vector(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Vector scale(float f2) {
        return new Vector(this.x * f2, this.y * f2);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
        outline73.append(this.x);
        outline73.append(", ");
        outline73.append(this.y);
        outline73.append(")");
        return outline73.toString();
    }
}
