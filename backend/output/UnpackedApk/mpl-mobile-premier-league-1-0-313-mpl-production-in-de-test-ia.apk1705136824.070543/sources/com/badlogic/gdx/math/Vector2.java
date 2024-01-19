package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class Vector2 implements Serializable {
    public static final long serialVersionUID = 913902788239530931L;
    public float x;
    public float y;

    public Vector2() {
    }

    public float dst(Vector2 vector2) {
        float f2 = vector2.x - this.x;
        float f3 = vector2.y - this.y;
        return (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Vector2.class != obj.getClass()) {
            return false;
        }
        Vector2 vector2 = (Vector2) obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(vector2.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(vector2.y);
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.x) + 31) * 31) + Float.floatToIntBits(this.y);
    }

    public Vector2 nor() {
        float f2 = this.x;
        float f3 = this.y;
        float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
        if (sqrt != 0.0f) {
            this.x /= sqrt;
            this.y /= sqrt;
        }
        return this;
    }

    public Vector2 set(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("(");
        outline73.append(this.x);
        outline73.append(",");
        outline73.append(this.y);
        outline73.append(")");
        return outline73.toString();
    }

    public Vector2(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }
}
