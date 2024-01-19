package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public class BaseAnimationController {
    public static final Transform tmpT = new Transform();
    public static final ObjectMap<Node, Transform> transforms = new ObjectMap<>();
    public boolean applying = false;
    public final ModelInstance target;
    public final Pool<Transform> transformPool = new Pool<Transform>() {
        public Transform newObject() {
            return new Transform();
        }
    };

    public static final class Transform implements Poolable {
        public final Quaternion rotation = new Quaternion();
        public final Vector3 scale = new Vector3(1.0f, 1.0f, 1.0f);
        public final Vector3 translation = new Vector3();

        public Transform idt() {
            this.translation.set(0.0f, 0.0f, 0.0f);
            this.rotation.idt();
            this.scale.set(1.0f, 1.0f, 1.0f);
            return this;
        }

        public Transform lerp(Transform transform, float f2) {
            return lerp(transform.translation, transform.rotation, transform.scale, f2);
        }

        public void reset() {
            idt();
        }

        public Transform set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
            this.translation.set(vector3);
            this.rotation.set(quaternion);
            this.scale.set(vector32);
            return this;
        }

        public Matrix4 toMatrix4(Matrix4 matrix4) {
            matrix4.set(this.translation, this.rotation, this.scale);
            return matrix4;
        }

        public String toString() {
            return this.translation.toString() + " - " + this.rotation.toString() + " - " + this.scale.toString();
        }

        public Transform lerp(Vector3 vector3, Quaternion quaternion, Vector3 vector32, float f2) {
            this.translation.lerp(vector3, f2);
            this.rotation.slerp(quaternion, f2);
            this.scale.lerp(vector32, f2);
            return this;
        }

        public Transform set(Transform transform) {
            return set(transform.translation, transform.rotation, transform.scale);
        }
    }

    public BaseAnimationController(ModelInstance modelInstance) {
        this.target = modelInstance;
    }

    public static final void applyNodeAnimationBlending(NodeAnimation nodeAnimation, ObjectMap<Node, Transform> objectMap, Pool<Transform> pool, float f2, float f3) {
        V v;
        Node node = nodeAnimation.node;
        node.isAnimated = true;
        Transform nodeAnimationTransform = getNodeAnimationTransform(nodeAnimation, f3);
        int locateKey = objectMap.locateKey(node);
        if (locateKey < 0) {
            v = null;
        } else {
            v = objectMap.valueTable[locateKey];
        }
        Transform transform = (Transform) v;
        if (transform != null) {
            if (f2 > 0.999999f) {
                transform.set(nodeAnimationTransform);
            } else {
                transform.lerp(nodeAnimationTransform, f2);
            }
        } else if (f2 > 0.999999f) {
            objectMap.put(node, ((Transform) pool.obtain()).set(nodeAnimationTransform));
        } else {
            objectMap.put(node, ((Transform) pool.obtain()).set(node.translation, node.rotation, node.scale).lerp(nodeAnimationTransform, f2));
        }
    }

    public static final void applyNodeAnimationDirectly(NodeAnimation nodeAnimation, float f2) {
        Node node = nodeAnimation.node;
        node.isAnimated = true;
        getNodeAnimationTransform(nodeAnimation, f2).toMatrix4(node.localTransform);
    }

    public static final <T> int getFirstKeyframeIndexAtTime(Array<NodeKeyframe<T>> array, float f2) {
        int i = array.size - 1;
        int i2 = 0;
        if (i > 0 && f2 >= ((NodeKeyframe) array.get(0)).keytime && f2 <= ((NodeKeyframe) array.get(i)).keytime) {
            while (i2 < i) {
                int i3 = (i2 + i) / 2;
                int i4 = i3 + 1;
                if (f2 > ((NodeKeyframe) array.get(i4)).keytime) {
                    i2 = i4;
                } else if (f2 >= ((NodeKeyframe) array.get(i3)).keytime) {
                    return i3;
                } else {
                    i = i3 - 1;
                }
            }
        }
        return i2;
    }

    public static final Transform getNodeAnimationTransform(NodeAnimation nodeAnimation, float f2) {
        Transform transform = tmpT;
        getTranslationAtTime(nodeAnimation, f2, transform.translation);
        getRotationAtTime(nodeAnimation, f2, transform.rotation);
        getScalingAtTime(nodeAnimation, f2, transform.scale);
        return transform;
    }

    public static final Quaternion getRotationAtTime(NodeAnimation nodeAnimation, float f2, Quaternion quaternion) {
        Array<NodeKeyframe<Quaternion>> array = nodeAnimation.rotation;
        if (array == null) {
            quaternion.set(nodeAnimation.node.rotation);
            return quaternion;
        } else if (array.size == 1) {
            quaternion.set((Quaternion) ((NodeKeyframe) array.get(0)).value);
            return quaternion;
        } else {
            int firstKeyframeIndexAtTime = getFirstKeyframeIndexAtTime(array, f2);
            NodeKeyframe nodeKeyframe = (NodeKeyframe) nodeAnimation.rotation.get(firstKeyframeIndexAtTime);
            quaternion.set((Quaternion) nodeKeyframe.value);
            int i = firstKeyframeIndexAtTime + 1;
            Array<NodeKeyframe<Quaternion>> array2 = nodeAnimation.rotation;
            if (i < array2.size) {
                NodeKeyframe nodeKeyframe2 = (NodeKeyframe) array2.get(i);
                float f3 = nodeKeyframe.keytime;
                quaternion.slerp((Quaternion) nodeKeyframe2.value, (f2 - f3) / (nodeKeyframe2.keytime - f3));
            }
            return quaternion;
        }
    }

    public static final Vector3 getScalingAtTime(NodeAnimation nodeAnimation, float f2, Vector3 vector3) {
        Array<NodeKeyframe<Vector3>> array = nodeAnimation.scaling;
        if (array == null) {
            vector3.set(nodeAnimation.node.scale);
            return vector3;
        } else if (array.size == 1) {
            vector3.set((Vector3) ((NodeKeyframe) array.get(0)).value);
            return vector3;
        } else {
            int firstKeyframeIndexAtTime = getFirstKeyframeIndexAtTime(array, f2);
            NodeKeyframe nodeKeyframe = (NodeKeyframe) nodeAnimation.scaling.get(firstKeyframeIndexAtTime);
            vector3.set((Vector3) nodeKeyframe.value);
            int i = firstKeyframeIndexAtTime + 1;
            Array<NodeKeyframe<Vector3>> array2 = nodeAnimation.scaling;
            if (i < array2.size) {
                NodeKeyframe nodeKeyframe2 = (NodeKeyframe) array2.get(i);
                float f3 = nodeKeyframe.keytime;
                vector3.lerp((Vector3) nodeKeyframe2.value, (f2 - f3) / (nodeKeyframe2.keytime - f3));
            }
            return vector3;
        }
    }

    public static final Vector3 getTranslationAtTime(NodeAnimation nodeAnimation, float f2, Vector3 vector3) {
        Array<NodeKeyframe<Vector3>> array = nodeAnimation.translation;
        if (array == null) {
            vector3.set(nodeAnimation.node.translation);
            return vector3;
        } else if (array.size == 1) {
            vector3.set((Vector3) ((NodeKeyframe) array.get(0)).value);
            return vector3;
        } else {
            int firstKeyframeIndexAtTime = getFirstKeyframeIndexAtTime(array, f2);
            NodeKeyframe nodeKeyframe = (NodeKeyframe) nodeAnimation.translation.get(firstKeyframeIndexAtTime);
            vector3.set((Vector3) nodeKeyframe.value);
            int i = firstKeyframeIndexAtTime + 1;
            Array<NodeKeyframe<Vector3>> array2 = nodeAnimation.translation;
            if (i < array2.size) {
                NodeKeyframe nodeKeyframe2 = (NodeKeyframe) array2.get(i);
                float f3 = nodeKeyframe.keytime;
                vector3.lerp((Vector3) nodeKeyframe2.value, (f2 - f3) / (nodeKeyframe2.keytime - f3));
            }
            return vector3;
        }
    }

    public void apply(Animation animation, float f2, float f3) {
        if (this.applying) {
            applyAnimation(transforms, this.transformPool, f3, animation, f2);
            return;
        }
        throw new GdxRuntimeException((String) "You must call begin() before adding an animation");
    }

    public void applyAnimation(Animation animation, float f2) {
        if (!this.applying) {
            applyAnimation(null, null, 1.0f, animation, f2);
            this.target.calculateTransforms();
            return;
        }
        throw new GdxRuntimeException((String) "Call end() first");
    }

    public void applyAnimations(Animation animation, float f2, Animation animation2, float f3, float f4) {
        if (animation2 == null || f4 == 0.0f) {
            applyAnimation(animation, f2);
        } else if (animation == null || f4 == 1.0f) {
            applyAnimation(animation2, f3);
        } else if (!this.applying) {
            begin();
            apply(animation, f2, 1.0f);
            apply(animation2, f3, f4);
            end();
        } else {
            throw new GdxRuntimeException((String) "Call end() first");
        }
    }

    public void begin() {
        if (!this.applying) {
            this.applying = true;
            return;
        }
        throw new GdxRuntimeException((String) "You must call end() after each call to being()");
    }

    public void end() {
        if (this.applying) {
            Entries entries = transforms.entries();
            if (entries != null) {
                while (entries.hasNext()) {
                    Entry entry = (Entry) entries.next();
                    ((Transform) entry.value).toMatrix4(((Node) entry.key).localTransform);
                    this.transformPool.free(entry.value);
                }
                transforms.clear();
                this.target.calculateTransforms();
                this.applying = false;
                return;
            }
            throw null;
        }
        throw new GdxRuntimeException((String) "You must call begin() first");
    }

    public void removeAnimation(Animation animation) {
        ArrayIterator it = animation.nodeAnimations.iterator();
        while (it.hasNext()) {
            ((NodeAnimation) it.next()).node.isAnimated = false;
        }
    }

    public static void applyAnimation(ObjectMap<Node, Transform> objectMap, Pool<Transform> pool, float f2, Animation animation, float f3) {
        if (objectMap == null) {
            ArrayIterator it = animation.nodeAnimations.iterator();
            while (it.hasNext()) {
                applyNodeAnimationDirectly((NodeAnimation) it.next(), f3);
            }
            return;
        }
        Keys keys = objectMap.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                ((Node) keys.next()).isAnimated = false;
            }
            ArrayIterator it2 = animation.nodeAnimations.iterator();
            while (it2.hasNext()) {
                applyNodeAnimationBlending((NodeAnimation) it2.next(), objectMap, pool, f2, f3);
            }
            Entries entries = objectMap.entries();
            if (entries != null) {
                while (entries.hasNext()) {
                    Entry entry = (Entry) entries.next();
                    K k = entry.key;
                    if (!((Node) k).isAnimated) {
                        ((Node) k).isAnimated = true;
                        ((Transform) entry.value).lerp(((Node) k).translation, ((Node) k).rotation, ((Node) k).scale, f2);
                    }
                }
                return;
            }
            throw null;
        }
        throw null;
    }
}
