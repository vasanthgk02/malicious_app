package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.ArrayMap;

public class Node {
    public final Array<Node> children = new Array<>(true, 2);
    public final Matrix4 globalTransform = new Matrix4();
    public String id;
    public boolean inheritTransform = true;
    public boolean isAnimated;
    public final Matrix4 localTransform = new Matrix4();
    public Node parent;
    public Array<NodePart> parts = new Array<>(true, 2);
    public final Quaternion rotation = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
    public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
    public final Vector3 translation = new Vector3();

    public static Node getNode(Array<Node> array, String str, boolean z, boolean z2) {
        int i = array.size;
        if (z2) {
            for (int i2 = 0; i2 < i; i2++) {
                Node node = (Node) array.get(i2);
                if (node.id.equalsIgnoreCase(str)) {
                    return node;
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                Node node2 = (Node) array.get(i3);
                if (node2.id.equals(str)) {
                    return node2;
                }
            }
        }
        if (z) {
            for (int i4 = 0; i4 < i; i4++) {
                Node node3 = getNode(((Node) array.get(i4)).children, str, true, z2);
                if (node3 != null) {
                    return node3;
                }
            }
        }
        return null;
    }

    public <T extends Node> int addChild(T t) {
        return insertChild(-1, t);
    }

    public <T extends Node> int addChildren(Iterable<T> iterable) {
        return insertChildren(-1, iterable);
    }

    public <T extends Node> void attachTo(T t) {
        t.addChild(this);
    }

    public void calculateBoneTransforms(boolean z) {
        ArrayIterator it = this.parts.iterator();
        while (it.hasNext()) {
            NodePart nodePart = (NodePart) it.next();
            ArrayMap<Node, Matrix4> arrayMap = nodePart.invBoneBindTransforms;
            if (arrayMap != null) {
                Matrix4[] matrix4Arr = nodePart.bones;
                if (matrix4Arr != null) {
                    int i = arrayMap.size;
                    if (i == matrix4Arr.length) {
                        for (int i2 = 0; i2 < i; i2++) {
                            Matrix4 matrix4 = nodePart.bones[i2];
                            matrix4.set(((Node[]) nodePart.invBoneBindTransforms.keys)[i2].globalTransform);
                            matrix4.mul(((Matrix4[]) nodePart.invBoneBindTransforms.values)[i2]);
                        }
                    }
                }
            }
        }
        if (z) {
            ArrayIterator it2 = this.children.iterator();
            while (it2.hasNext()) {
                ((Node) it2.next()).calculateBoneTransforms(true);
            }
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox);
    }

    public Matrix4 calculateLocalTransform() {
        if (!this.isAnimated) {
            this.localTransform.set(this.translation, this.rotation, this.scale);
        }
        return this.localTransform;
    }

    public void calculateTransforms(boolean z) {
        calculateLocalTransform();
        calculateWorldTransform();
        if (z) {
            ArrayIterator it = this.children.iterator();
            while (it.hasNext()) {
                ((Node) it.next()).calculateTransforms(true);
            }
        }
    }

    public Matrix4 calculateWorldTransform() {
        if (this.inheritTransform) {
            Node node = this.parent;
            if (node != null) {
                Matrix4 matrix4 = this.globalTransform;
                matrix4.set(node.globalTransform);
                matrix4.mul(this.localTransform);
                return this.globalTransform;
            }
        }
        this.globalTransform.set(this.localTransform);
        return this.globalTransform;
    }

    public Node copy() {
        return new Node().set(this);
    }

    public void detach() {
        Node node = this.parent;
        if (node != null) {
            node.removeChild(this);
            this.parent = null;
        }
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        return extendBoundingBox(boundingBox, true);
    }

    public Node getChild(int i) {
        return (Node) this.children.get(i);
    }

    public int getChildCount() {
        return this.children.size;
    }

    public Iterable<Node> getChildren() {
        return this.children;
    }

    public Node getParent() {
        return this.parent;
    }

    public boolean hasChildren() {
        Array<Node> array = this.children;
        return array != null && array.size > 0;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T, code=com.badlogic.gdx.graphics.g3d.model.Node, for r4v0, types: [T, com.badlogic.gdx.graphics.g3d.model.Node, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.badlogic.gdx.graphics.g3d.model.Node> int insertChild(int r3, com.badlogic.gdx.graphics.g3d.model.Node r4) {
        /*
            r2 = this;
            r0 = r2
        L_0x0001:
            if (r0 == 0) goto L_0x0012
            if (r0 == r4) goto L_0x000a
            com.badlogic.gdx.graphics.g3d.model.Node r0 = r0.getParent()
            goto L_0x0001
        L_0x000a:
            com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r4 = "Cannot add a parent as a child"
            r3.<init>(r4)
            throw r3
        L_0x0012:
            com.badlogic.gdx.graphics.g3d.model.Node r0 = r4.getParent()
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.removeChild(r4)
            if (r0 == 0) goto L_0x001f
            goto L_0x0027
        L_0x001f:
            com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r4 = "Could not remove child from its current parent"
            r3.<init>(r4)
            throw r3
        L_0x0027:
            if (r3 < 0) goto L_0x0034
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.model.Node> r0 = r2.children
            int r1 = r0.size
            if (r3 < r1) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            r0.insert(r3, r4)
            goto L_0x003c
        L_0x0034:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.model.Node> r3 = r2.children
            int r0 = r3.size
            r3.add(r4)
            r3 = r0
        L_0x003c:
            r4.parent = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.model.Node.insertChild(int, com.badlogic.gdx.graphics.g3d.model.Node):int");
    }

    public <T extends Node> int insertChildren(int i, Iterable<T> iterable) {
        if (i < 0 || i > this.children.size) {
            i = this.children.size;
        }
        int i2 = i;
        for (T insertChild : iterable) {
            insertChild(i2, insertChild);
            i2++;
        }
        return i;
    }

    public <T extends Node> boolean removeChild(T t) {
        if (!this.children.removeValue(t, true)) {
            return false;
        }
        t.parent = null;
        return true;
    }

    public Node set(Node node) {
        detach();
        this.id = node.id;
        this.isAnimated = node.isAnimated;
        this.inheritTransform = node.inheritTransform;
        this.translation.set(node.translation);
        this.rotation.set(node.rotation);
        this.scale.set(node.scale);
        this.localTransform.set(node.localTransform);
        this.globalTransform.set(node.globalTransform);
        this.parts.clear();
        ArrayIterator it = node.parts.iterator();
        while (it.hasNext()) {
            this.parts.add(((NodePart) it.next()).copy());
        }
        this.children.clear();
        for (Node copy : node.getChildren()) {
            addChild(copy.copy());
        }
        return this;
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, boolean z) {
        int i = this.parts.size;
        for (int i2 = 0; i2 < i; i2++) {
            NodePart nodePart = (NodePart) this.parts.get(i2);
            if (nodePart.enabled) {
                MeshPart meshPart = nodePart.meshPart;
                if (z) {
                    meshPart.mesh.extendBoundingBox(boundingBox, meshPart.offset, meshPart.size, this.globalTransform);
                } else {
                    meshPart.mesh.extendBoundingBox(boundingBox, meshPart.offset, meshPart.size);
                }
            }
        }
        int i3 = this.children.size;
        for (int i4 = 0; i4 < i3; i4++) {
            ((Node) this.children.get(i4)).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public Node getChild(String str, boolean z, boolean z2) {
        return getNode(this.children, str, z, z2);
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, boolean z) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox, z);
    }
}
