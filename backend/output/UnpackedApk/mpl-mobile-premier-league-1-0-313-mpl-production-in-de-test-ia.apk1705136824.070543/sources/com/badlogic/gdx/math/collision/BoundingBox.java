package com.badlogic.gdx.math.collision;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class BoundingBox implements Serializable {
    public static final long serialVersionUID = -1286036817192127343L;
    public final Vector3 cnt = new Vector3();
    public final Vector3 dim = new Vector3();
    public final Vector3 max = new Vector3();
    public final Vector3 min = new Vector3();

    public BoundingBox() {
        Vector3 vector3 = this.min;
        vector3.set(0.0f, 0.0f, 0.0f);
        Vector3 vector32 = this.max;
        vector32.set(0.0f, 0.0f, 0.0f);
        set(vector3, vector32);
    }

    public static final float max(float f2, float f3) {
        return f2 > f3 ? f2 : f3;
    }

    public static final float min(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public BoundingBox ext(Vector3 vector3) {
        Vector3 vector32 = this.min;
        vector32.set(min(vector32.x, vector3.x), min(this.min.y, vector3.y), min(this.min.z, vector3.z));
        Vector3 vector33 = this.max;
        vector33.set(Math.max(vector33.x, vector3.x), Math.max(this.max.y, vector3.y), Math.max(this.max.z, vector3.z));
        set(vector32, vector33);
        return this;
    }

    public BoundingBox inf() {
        this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.cnt.set(0.0f, 0.0f, 0.0f);
        this.dim.set(0.0f, 0.0f, 0.0f);
        return this;
    }

    public BoundingBox set(Vector3 vector3, Vector3 vector32) {
        Vector3 vector33 = this.min;
        float f2 = vector3.x;
        float f3 = vector32.x;
        if (f2 >= f3) {
            f2 = f3;
        }
        float f4 = vector3.y;
        float f5 = vector32.y;
        if (f4 >= f5) {
            f4 = f5;
        }
        float f6 = vector3.z;
        float f7 = vector32.z;
        if (f6 >= f7) {
            f6 = f7;
        }
        vector33.set(f2, f4, f6);
        Vector3 vector34 = this.max;
        float f8 = vector3.x;
        float f9 = vector32.x;
        if (f8 <= f9) {
            f8 = f9;
        }
        float f10 = vector3.y;
        float f11 = vector32.y;
        if (f10 <= f11) {
            f10 = f11;
        }
        float f12 = vector3.z;
        float f13 = vector32.z;
        if (f12 <= f13) {
            f12 = f13;
        }
        vector34.set(f8, f10, f12);
        Vector3 vector35 = this.cnt;
        vector35.set(this.min);
        vector35.add(this.max);
        vector35.scl(0.5f);
        Vector3 vector36 = this.dim;
        vector36.set(this.max);
        vector36.sub(this.min);
        return this;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        outline73.append(this.min);
        outline73.append("|");
        outline73.append(this.max);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public BoundingBox ext(BoundingBox boundingBox) {
        Vector3 vector3 = this.min;
        vector3.set(min(vector3.x, boundingBox.min.x), min(this.min.y, boundingBox.min.y), min(this.min.z, boundingBox.min.z));
        Vector3 vector32 = this.max;
        vector32.set(max(vector32.x, boundingBox.max.x), max(this.max.y, boundingBox.max.y), max(this.max.z, boundingBox.max.z));
        set(vector3, vector32);
        return this;
    }

    public BoundingBox ext(float f2, float f3, float f4) {
        Vector3 vector3 = this.min;
        vector3.set(min(vector3.x, f2), min(this.min.y, f3), min(this.min.z, f4));
        Vector3 vector32 = this.max;
        vector32.set(max(vector32.x, f2), max(this.max.y, f3), max(this.max.z, f4));
        set(vector3, vector32);
        return this;
    }
}
