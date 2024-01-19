package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Pool;

public class ModelInstance implements RenderableProvider {
    public static boolean defaultShareKeyframes = true;
    public final Array<Animation> animations;
    public final Array<Material> materials;
    public final Model model;
    public final Array<Node> nodes;
    public Matrix4 transform;
    public Object userData;

    public ModelInstance(Model model2) {
        this(model2, (String[]) null);
    }

    private void copyNodes(Array<Node> array) {
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.nodes.add(((Node) array.get(i2)).copy());
        }
        invalidate();
    }

    private void invalidate(Node node) {
        int i = node.parts.size;
        for (int i2 = 0; i2 < i; i2++) {
            NodePart nodePart = (NodePart) node.parts.get(i2);
            ArrayMap<Node, Matrix4> arrayMap = nodePart.invBoneBindTransforms;
            if (arrayMap != null) {
                for (int i3 = 0; i3 < arrayMap.size; i3++) {
                    K[] kArr = arrayMap.keys;
                    ((Node[]) kArr)[i3] = getNode(((Node[]) kArr)[i3].id);
                }
            }
            if (!this.materials.contains(nodePart.material, true)) {
                int indexOf = this.materials.indexOf(nodePart.material, false);
                if (indexOf < 0) {
                    Array<Material> array = this.materials;
                    Material copy = nodePart.material.copy();
                    nodePart.material = copy;
                    array.add(copy);
                } else {
                    nodePart.material = (Material) this.materials.get(indexOf);
                }
            }
        }
        int childCount = node.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            invalidate(node.getChild(i4));
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox);
    }

    public void calculateTransforms() {
        int i = this.nodes.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) this.nodes.get(i2)).calculateTransforms(true);
        }
        for (int i3 = 0; i3 < i; i3++) {
            ((Node) this.nodes.get(i3)).calculateBoneTransforms(true);
        }
    }

    public ModelInstance copy() {
        return new ModelInstance(this);
    }

    public void copyAnimation(Animation animation) {
        copyAnimation(animation, defaultShareKeyframes);
    }

    public void copyAnimations(Iterable<Animation> iterable) {
        for (Animation copyAnimation : iterable) {
            copyAnimation(copyAnimation, defaultShareKeyframes);
        }
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        int i = this.nodes.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) this.nodes.get(i2)).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public Animation getAnimation(String str) {
        return getAnimation(str, false);
    }

    public Material getMaterial(String str) {
        return getMaterial(str, true);
    }

    public Node getNode(String str) {
        return getNode(str, true);
    }

    public Renderable getRenderable(Renderable renderable) {
        return getRenderable(renderable, (Node) this.nodes.get(0));
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        ArrayIterator it = this.nodes.iterator();
        while (it.hasNext()) {
            getRenderables((Node) it.next(), array, pool);
        }
    }

    public ModelInstance(Model model2, String str, boolean z) {
        this(model2, null, str, false, false, z);
    }

    public void copyAnimation(Animation animation, boolean z) {
        Animation animation2 = new Animation();
        animation2.id = animation.id;
        animation2.duration = animation.duration;
        ArrayIterator it = animation.nodeAnimations.iterator();
        while (it.hasNext()) {
            NodeAnimation nodeAnimation = (NodeAnimation) it.next();
            Node node = getNode(nodeAnimation.node.id);
            if (node != null) {
                NodeAnimation nodeAnimation2 = new NodeAnimation();
                nodeAnimation2.node = node;
                if (z) {
                    nodeAnimation2.translation = nodeAnimation.translation;
                    nodeAnimation2.rotation = nodeAnimation.rotation;
                    nodeAnimation2.scaling = nodeAnimation.scaling;
                } else {
                    if (nodeAnimation.translation != null) {
                        nodeAnimation2.translation = new Array<>();
                        ArrayIterator it2 = nodeAnimation.translation.iterator();
                        while (it2.hasNext()) {
                            NodeKeyframe nodeKeyframe = (NodeKeyframe) it2.next();
                            nodeAnimation2.translation.add(new NodeKeyframe(nodeKeyframe.keytime, nodeKeyframe.value));
                        }
                    }
                    if (nodeAnimation.rotation != null) {
                        nodeAnimation2.rotation = new Array<>();
                        ArrayIterator it3 = nodeAnimation.rotation.iterator();
                        while (it3.hasNext()) {
                            NodeKeyframe nodeKeyframe2 = (NodeKeyframe) it3.next();
                            nodeAnimation2.rotation.add(new NodeKeyframe(nodeKeyframe2.keytime, nodeKeyframe2.value));
                        }
                    }
                    if (nodeAnimation.scaling != null) {
                        nodeAnimation2.scaling = new Array<>();
                        ArrayIterator it4 = nodeAnimation.scaling.iterator();
                        while (it4.hasNext()) {
                            NodeKeyframe nodeKeyframe3 = (NodeKeyframe) it4.next();
                            nodeAnimation2.scaling.add(new NodeKeyframe(nodeKeyframe3.keytime, nodeKeyframe3.value));
                        }
                    }
                }
                if (nodeAnimation2.translation != null || nodeAnimation2.rotation != null || nodeAnimation2.scaling != null) {
                    animation2.nodeAnimations.add(nodeAnimation2);
                }
            }
        }
        if (animation2.nodeAnimations.size > 0) {
            this.animations.add(animation2);
        }
    }

    public Animation getAnimation(String str, boolean z) {
        int i = this.animations.size;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                Animation animation = (Animation) this.animations.get(i2);
                if (animation.id.equalsIgnoreCase(str)) {
                    return animation;
                }
                i2++;
            }
        } else {
            while (i2 < i) {
                Animation animation2 = (Animation) this.animations.get(i2);
                if (animation2.id.equals(str)) {
                    return animation2;
                }
                i2++;
            }
        }
        return null;
    }

    public Material getMaterial(String str, boolean z) {
        int i = this.materials.size;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                Material material = (Material) this.materials.get(i2);
                if (material.id.equalsIgnoreCase(str)) {
                    return material;
                }
                i2++;
            }
        } else {
            while (i2 < i) {
                Material material2 = (Material) this.materials.get(i2);
                if (material2.id.equals(str)) {
                    return material2;
                }
                i2++;
            }
        }
        return null;
    }

    public Node getNode(String str, boolean z) {
        return getNode(str, z, false);
    }

    public Renderable getRenderable(Renderable renderable, Node node) {
        return getRenderable(renderable, node, (NodePart) node.parts.get(0));
    }

    public ModelInstance(Model model2, Matrix4 matrix4, String str, boolean z) {
        this(model2, matrix4, str, false, false, z);
    }

    public void copyAnimations(Iterable<Animation> iterable, boolean z) {
        for (Animation copyAnimation : iterable) {
            copyAnimation(copyAnimation, z);
        }
    }

    public Node getNode(String str, boolean z, boolean z2) {
        return Node.getNode(this.nodes, str, z, z2);
    }

    public Renderable getRenderable(Renderable renderable, Node node, NodePart nodePart) {
        nodePart.setRenderable(renderable);
        if (nodePart.bones == null) {
            Matrix4 matrix4 = this.transform;
            if (matrix4 != null) {
                Matrix4 matrix42 = renderable.worldTransform;
                matrix42.set(matrix4);
                matrix42.mul(node.globalTransform);
                renderable.userData = this.userData;
                return renderable;
            }
        }
        Matrix4 matrix43 = this.transform;
        if (matrix43 != null) {
            renderable.worldTransform.set(matrix43);
        } else {
            renderable.worldTransform.idt();
        }
        renderable.userData = this.userData;
        return renderable;
    }

    public void getRenderables(Node node, Array<Renderable> array, Pool<Renderable> pool) {
        Array<NodePart> array2 = node.parts;
        if (array2.size > 0) {
            ArrayIterator it = array2.iterator();
            while (it.hasNext()) {
                NodePart nodePart = (NodePart) it.next();
                if (nodePart.enabled) {
                    array.add(getRenderable((Renderable) pool.obtain(), node, nodePart));
                }
            }
        }
        for (Node renderables : node.getChildren()) {
            getRenderables(renderables, array, pool);
        }
    }

    public ModelInstance(Model model2, String str, boolean z, boolean z2) {
        this(model2, null, str, true, z, z2);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, String str, boolean z, boolean z2) {
        this(model2, matrix4, str, true, z, z2);
    }

    private void copyNodes(Array<Node> array, String... strArr) {
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            Node node = (Node) array.get(i2);
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (strArr[i3].equals(node.id)) {
                    this.nodes.add(node.copy());
                    break;
                } else {
                    i3++;
                }
            }
        }
        invalidate();
    }

    public ModelInstance(Model model2, String str, boolean z, boolean z2, boolean z3) {
        this(model2, null, str, z, z2, z3);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, String str, boolean z, boolean z2, boolean z3) {
        this(model2, matrix4, str, z, z2, z3, defaultShareKeyframes);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.model = model2;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        Node node = model2.getNode(str, z);
        Array<Node> array = this.nodes;
        Node copy = node.copy();
        array.add(copy);
        if (z3) {
            this.transform.mul(z2 ? node.globalTransform : node.localTransform);
            copy.translation.set(0.0f, 0.0f, 0.0f);
            copy.rotation.idt();
            copy.scale.set(1.0f, 1.0f, 1.0f);
        } else if (z2 && copy.hasParent()) {
            this.transform.mul(node.getParent().globalTransform);
        }
        invalidate();
        copyAnimations(model2.animations, z4);
        calculateTransforms();
    }

    private void copyNodes(Array<Node> array, Array<String> array2) {
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            Node node = (Node) array.get(i2);
            ArrayIterator it = array2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((String) it.next()).equals(node.id)) {
                        this.nodes.add(node.copy());
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        invalidate();
    }

    private void invalidate() {
        int i = this.nodes.size;
        for (int i2 = 0; i2 < i; i2++) {
            invalidate((Node) this.nodes.get(i2));
        }
    }

    public ModelInstance(Model model2, String... strArr) {
        this(model2, (Matrix4) null, strArr);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, String... strArr) {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.model = model2;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        if (strArr == null) {
            copyNodes(model2.nodes);
        } else {
            copyNodes(model2.nodes, strArr);
        }
        copyAnimations(model2.animations, defaultShareKeyframes);
        calculateTransforms();
    }

    public ModelInstance(Model model2, Array<String> array) {
        this(model2, (Matrix4) null, array);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, Array<String> array) {
        this(model2, matrix4, array, defaultShareKeyframes);
    }

    public ModelInstance(Model model2, Matrix4 matrix4, Array<String> array, boolean z) {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.model = model2;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        copyNodes(model2.nodes, array);
        copyAnimations(model2.animations, z);
        calculateTransforms();
    }

    public ModelInstance(Model model2, Vector3 vector3) {
        this(model2);
        Matrix4 matrix4 = this.transform;
        matrix4.idt();
        float[] fArr = matrix4.val;
        fArr[12] = vector3.x;
        fArr[13] = vector3.y;
        fArr[14] = vector3.z;
    }

    public ModelInstance(Model model2, float f2, float f3, float f4) {
        this(model2);
        this.transform.setToTranslation(f2, f3, f4);
    }

    public ModelInstance(Model model2, Matrix4 matrix4) {
        this(model2, matrix4, (String[]) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ModelInstance(com.badlogic.gdx.graphics.g3d.ModelInstance r3) {
        /*
            r2 = this;
            com.badlogic.gdx.math.Matrix4 r0 = r3.transform
            if (r0 == 0) goto L_0x000d
            com.badlogic.gdx.math.Matrix4 r1 = new com.badlogic.gdx.math.Matrix4
            r1.<init>(r0)
            r2.<init>(r3, r1)
            return
        L_0x000d:
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.ModelInstance.<init>(com.badlogic.gdx.graphics.g3d.ModelInstance):void");
    }

    public ModelInstance(ModelInstance modelInstance, Matrix4 matrix4) {
        this(modelInstance, matrix4, defaultShareKeyframes);
    }

    public ModelInstance(ModelInstance modelInstance, Matrix4 matrix4, boolean z) {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.model = modelInstance.model;
        this.transform = matrix4 == null ? new Matrix4() : matrix4;
        copyNodes(modelInstance.nodes);
        copyAnimations(modelInstance.animations, z);
        calculateTransforms();
    }
}
