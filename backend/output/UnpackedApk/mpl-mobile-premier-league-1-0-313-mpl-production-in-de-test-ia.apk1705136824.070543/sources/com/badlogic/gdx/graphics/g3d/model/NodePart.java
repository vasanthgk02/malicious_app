package com.badlogic.gdx.graphics.g3d.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ArrayMap;
import java.util.Arrays;

public class NodePart {
    public Matrix4[] bones;
    public boolean enabled = true;
    public ArrayMap<Node, Matrix4> invBoneBindTransforms;
    public Material material;
    public MeshPart meshPart;

    public NodePart() {
    }

    public NodePart copy() {
        return new NodePart().set(this);
    }

    public NodePart set(NodePart nodePart) {
        this.meshPart = new MeshPart(nodePart.meshPart);
        this.material = nodePart.material;
        this.enabled = nodePart.enabled;
        ArrayMap<Node, Matrix4> arrayMap = nodePart.invBoneBindTransforms;
        if (arrayMap == null) {
            this.invBoneBindTransforms = null;
            this.bones = null;
        } else {
            ArrayMap<Node, Matrix4> arrayMap2 = this.invBoneBindTransforms;
            int i = 0;
            if (arrayMap2 == null) {
                this.invBoneBindTransforms = new ArrayMap<>(true, arrayMap.size, Node.class, Matrix4.class);
            } else {
                Arrays.fill(arrayMap2.keys, 0, arrayMap2.size, null);
                Arrays.fill(arrayMap2.values, 0, arrayMap2.size, null);
                arrayMap2.size = 0;
            }
            ArrayMap<Node, Matrix4> arrayMap3 = this.invBoneBindTransforms;
            ArrayMap<Node, Matrix4> arrayMap4 = nodePart.invBoneBindTransforms;
            if (arrayMap3 != null) {
                int i2 = arrayMap4.size;
                if (i2 + 0 <= i2) {
                    int i3 = (arrayMap3.size + i2) - 0;
                    if (i3 >= arrayMap3.keys.length) {
                        arrayMap3.resize(Math.max(8, (int) (((float) i3) * 1.75f)));
                    }
                    System.arraycopy(arrayMap4.keys, 0, arrayMap3.keys, arrayMap3.size, i2);
                    System.arraycopy(arrayMap4.values, 0, arrayMap3.values, arrayMap3.size, i2);
                    arrayMap3.size += i2;
                    Matrix4[] matrix4Arr = this.bones;
                    if (matrix4Arr == null || matrix4Arr.length != this.invBoneBindTransforms.size) {
                        this.bones = new Matrix4[this.invBoneBindTransforms.size];
                    }
                    while (true) {
                        Matrix4[] matrix4Arr2 = this.bones;
                        if (i >= matrix4Arr2.length) {
                            break;
                        }
                        if (matrix4Arr2[i] == null) {
                            matrix4Arr2[i] = new Matrix4();
                        }
                        i++;
                    }
                } else {
                    StringBuilder outline75 = GeneratedOutlineSupport.outline75("offset + length must be <= size: ", 0, " + ", i2, " <= ");
                    outline75.append(arrayMap4.size);
                    throw new IllegalArgumentException(outline75.toString());
                }
            } else {
                throw null;
            }
        }
        return this;
    }

    public Renderable setRenderable(Renderable renderable) {
        renderable.material = this.material;
        renderable.meshPart.set(this.meshPart);
        renderable.bones = this.bones;
        return renderable;
    }

    public NodePart(MeshPart meshPart2, Material material2) {
        this.meshPart = meshPart2;
        this.material = material2;
    }
}
