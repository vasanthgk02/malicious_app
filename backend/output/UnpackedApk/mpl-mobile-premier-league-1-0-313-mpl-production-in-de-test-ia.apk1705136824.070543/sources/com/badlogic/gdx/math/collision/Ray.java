package com.badlogic.gdx.math.collision;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class Ray implements Serializable {
    public static final long serialVersionUID = -620692054835390878L;
    public final Vector3 direction = new Vector3();
    public final Vector3 origin = new Vector3();

    public Ray() {
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Ray.class) {
            return false;
        }
        Ray ray = (Ray) obj;
        if (!this.direction.equals(ray.direction) || !this.origin.equals(ray.origin)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.origin.hashCode() + ((this.direction.hashCode() + 73) * 73);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ray [");
        outline73.append(this.origin);
        outline73.append(":");
        outline73.append(this.direction);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public Ray(Vector3 vector3, Vector3 vector32) {
        this.origin.set(vector3);
        Vector3 vector33 = this.direction;
        vector33.set(vector32);
        vector33.nor();
    }
}
