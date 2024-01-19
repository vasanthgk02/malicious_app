package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import java.util.Comparator;

public class DefaultRenderableSorter implements RenderableSorter, Comparator<Renderable> {
    public Camera camera;
    public final Vector3 tmpV1 = new Vector3();
    public final Vector3 tmpV2 = new Vector3();

    private Vector3 getTranslation(Matrix4 matrix4, Vector3 vector3, Vector3 vector32) {
        if (vector3.isZero()) {
            matrix4.getTranslation(vector32);
        } else {
            boolean z = false;
            if (!MathUtils.isEqual(matrix4.val[0], 1.0f) || !MathUtils.isEqual(matrix4.val[5], 1.0f) || !MathUtils.isEqual(matrix4.val[10], 1.0f) || !MathUtils.isZero(matrix4.val[4]) || !MathUtils.isZero(matrix4.val[8]) || !MathUtils.isZero(matrix4.val[1]) || !MathUtils.isZero(matrix4.val[9]) || !MathUtils.isZero(matrix4.val[2]) || !MathUtils.isZero(matrix4.val[6])) {
                z = true;
            }
            if (!z) {
                matrix4.getTranslation(vector32);
                vector32.add(vector3);
            } else {
                vector32.set(vector3);
                vector32.mul(matrix4);
            }
        }
        return vector32;
    }

    public void sort(Camera camera2, Array<Renderable> array) {
        this.camera = camera2;
        array.sort(this);
    }

    public int compare(Renderable renderable, Renderable renderable2) {
        int i = 0;
        int i2 = 1;
        boolean z = renderable.material.has(BlendingAttribute.Type) && ((BlendingAttribute) renderable.material.get(BlendingAttribute.Type)).blended;
        if (z != (renderable2.material.has(BlendingAttribute.Type) && ((BlendingAttribute) renderable2.material.get(BlendingAttribute.Type)).blended)) {
            if (!z) {
                i2 = -1;
            }
            return i2;
        }
        getTranslation(renderable.worldTransform, renderable.meshPart.center, this.tmpV1);
        getTranslation(renderable2.worldTransform, renderable2.meshPart.center, this.tmpV2);
        float dst2 = (float) (((int) (this.camera.position.dst2(this.tmpV1) * 1000.0f)) - ((int) (this.camera.position.dst2(this.tmpV2) * 1000.0f)));
        if (dst2 < 0.0f) {
            i = -1;
        } else if (dst2 > 0.0f) {
            i = 1;
        }
        if (z) {
            i = -i;
        }
        return i;
    }
}
