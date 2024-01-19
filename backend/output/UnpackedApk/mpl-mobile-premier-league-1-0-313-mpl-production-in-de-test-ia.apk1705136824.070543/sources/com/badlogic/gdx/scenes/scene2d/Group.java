package com.badlogic.gdx.scenes.scene2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.Stage.TouchFocus;
import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;

public class Group extends Actor implements Cullable {
    public static final Vector2 tmp = new Vector2();
    public final SnapshotArray<Actor> children = new SnapshotArray<>(true, 4, Actor.class);
    public final Matrix4 computedTransform = new Matrix4();
    public Rectangle cullingArea;
    public final Matrix4 oldTransform = new Matrix4();
    public boolean transform = true;
    public final Affine2 worldTransform = new Affine2();

    public void act(float f2) {
        super.act(f2);
        Actor[] actorArr = (Actor[]) this.children.begin();
        int i = this.children.size;
        for (int i2 = 0; i2 < i; i2++) {
            actorArr[i2].act(f2);
        }
        this.children.end();
    }

    public void addActor(Actor actor) {
        Group group = actor.parent;
        if (group != null) {
            if (group != this) {
                group.removeActor(actor, false);
            } else {
                return;
            }
        }
        this.children.add(actor);
        actor.parent = this;
        actor.setStage(this.stage);
        childrenChanged();
    }

    public void addActorAfter(Actor actor, Actor actor2) {
        Group group = actor2.parent;
        if (group != null) {
            if (group != this) {
                group.removeActor(actor2, false);
            } else {
                return;
            }
        }
        int indexOf = this.children.indexOf(actor, true);
        SnapshotArray<Actor> snapshotArray = this.children;
        if (indexOf == snapshotArray.size || indexOf == -1) {
            this.children.add(actor2);
        } else {
            snapshotArray.insert(indexOf + 1, actor2);
        }
        actor2.parent = this;
        actor2.setStage(this.stage);
        childrenChanged();
    }

    public void addActorBefore(Actor actor, Actor actor2) {
        Group group = actor2.parent;
        if (group != null) {
            if (group != this) {
                group.removeActor(actor2, false);
            } else {
                return;
            }
        }
        this.children.insert(this.children.indexOf(actor, true), actor2);
        actor2.parent = this;
        actor2.setStage(this.stage);
        childrenChanged();
    }

    public void childrenChanged() {
    }

    public void clearChildren() {
        Actor[] actorArr = (Actor[]) this.children.begin();
        int i = this.children.size;
        for (int i2 = 0; i2 < i; i2++) {
            Actor actor = actorArr[i2];
            actor.setStage(null);
            actor.parent = null;
        }
        this.children.end();
        this.children.clear();
        childrenChanged();
    }

    public Matrix4 computeTransform() {
        Affine2 affine2 = this.worldTransform;
        float f2 = this.originX;
        float f3 = this.originY;
        float f4 = this.rotation;
        float f5 = this.scaleX;
        float f6 = this.scaleY;
        affine2.m02 = this.x + f2;
        affine2.m12 = this.y + f3;
        if (f4 == 0.0f) {
            affine2.m00 = f5;
            affine2.m01 = 0.0f;
            affine2.m10 = 0.0f;
            affine2.m11 = f6;
        } else {
            float sinDeg = MathUtils.sinDeg(f4);
            float cosDeg = MathUtils.cosDeg(f4);
            affine2.m00 = cosDeg * f5;
            affine2.m01 = (-sinDeg) * f6;
            affine2.m10 = sinDeg * f5;
            affine2.m11 = cosDeg * f6;
        }
        if (!(f2 == 0.0f && f3 == 0.0f)) {
            float f7 = -f2;
            float f8 = -f3;
            float f9 = affine2.m02;
            affine2.m02 = GeneratedOutlineSupport.outline4(affine2.m01, f8, affine2.m00 * f7, f9);
            float f10 = affine2.m12;
            affine2.m12 = GeneratedOutlineSupport.outline4(affine2.m11, f8, affine2.m10 * f7, f10);
        }
        Group group = this.parent;
        while (group != null && !group.transform) {
            group = group.parent;
        }
        if (group != null) {
            Affine2 affine22 = group.worldTransform;
            float f11 = affine22.m00;
            float f12 = affine2.m00;
            float f13 = affine22.m01;
            float f14 = affine2.m10;
            float f15 = (f13 * f14) + (f11 * f12);
            float f16 = affine2.m01;
            float f17 = affine2.m11;
            float f18 = (f13 * f17) + (f11 * f16);
            float f19 = affine2.m02;
            float f20 = affine2.m12;
            float f21 = (f13 * f20) + (f11 * f19) + affine22.m02;
            float f22 = affine22.m10;
            float f23 = affine22.m11;
            float f24 = f14 * f23;
            float f25 = f17 * f23;
            affine2.m00 = f15;
            affine2.m01 = f18;
            affine2.m02 = f21;
            affine2.m10 = f24 + (f12 * f22);
            affine2.m11 = f25 + (f16 * f22);
            affine2.m12 = (f23 * f20) + (f22 * f19) + affine22.m12;
        }
        Matrix4 matrix4 = this.computedTransform;
        float[] fArr = matrix4.val;
        fArr[0] = affine2.m00;
        fArr[1] = affine2.m10;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = affine2.m01;
        fArr[5] = affine2.m11;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = affine2.m02;
        fArr[13] = affine2.m12;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
        return matrix4;
    }

    public void draw(Batch batch, float f2) {
        if (this.transform) {
            Matrix4 computeTransform = computeTransform();
            this.oldTransform.set(batch.getTransformMatrix());
            batch.setTransformMatrix(computeTransform);
        }
        drawChildren(batch, f2);
        if (this.transform) {
            batch.setTransformMatrix(this.oldTransform);
        }
    }

    public void drawChildren(Batch batch, float f2) {
        float f3;
        Batch batch2 = batch;
        float f4 = this.color.f3306a * f2;
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArr = (Actor[]) snapshotArray.begin();
        Rectangle rectangle = this.cullingArea;
        int i = 0;
        if (rectangle != null) {
            float f5 = rectangle.x;
            float f6 = rectangle.width + f5;
            float f7 = rectangle.y;
            float f8 = rectangle.height + f7;
            if (this.transform) {
                int i2 = snapshotArray.size;
                while (i < i2) {
                    Actor actor = actorArr[i];
                    if (actor.visible) {
                        float f9 = actor.x;
                        float f10 = actor.y;
                        if (f9 <= f6 && f10 <= f8 && f9 + actor.width >= f5 && f10 + actor.height >= f7) {
                            actor.draw(batch2, f4);
                        }
                    }
                    i++;
                }
            } else {
                float f11 = this.x;
                float f12 = this.y;
                this.x = 0.0f;
                this.y = 0.0f;
                int i3 = snapshotArray.size;
                while (i < i3) {
                    Actor actor2 = actorArr[i];
                    if (actor2.visible) {
                        float f13 = actor2.x;
                        float f14 = actor2.y;
                        if (f13 <= f6 && f14 <= f8) {
                            f3 = f8;
                            if (actor2.width + f13 >= f5 && actor2.height + f14 >= f7) {
                                actor2.x = f13 + f11;
                                actor2.y = f14 + f12;
                                actor2.draw(batch2, f4);
                                actor2.x = f13;
                                actor2.y = f14;
                            }
                            i++;
                            f8 = f3;
                        }
                    }
                    f3 = f8;
                    i++;
                    f8 = f3;
                }
                this.x = f11;
                this.y = f12;
            }
        } else if (this.transform) {
            int i4 = snapshotArray.size;
            while (i < i4) {
                Actor actor3 = actorArr[i];
                if (actor3.visible) {
                    actor3.draw(batch2, f4);
                }
                i++;
            }
        } else {
            float f15 = this.x;
            float f16 = this.y;
            this.x = 0.0f;
            this.y = 0.0f;
            int i5 = snapshotArray.size;
            while (i < i5) {
                Actor actor4 = actorArr[i];
                if (actor4.visible) {
                    float f17 = actor4.x;
                    float f18 = actor4.y;
                    actor4.x = f17 + f15;
                    actor4.y = f18 + f16;
                    actor4.draw(batch2, f4);
                    actor4.x = f17;
                    actor4.y = f18;
                }
                i++;
            }
            this.x = f15;
            this.y = f16;
        }
        snapshotArray.end();
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        drawDebugBounds(shapeRenderer);
        if (this.transform) {
            Matrix4 computeTransform = computeTransform();
            this.oldTransform.set(shapeRenderer.getTransformMatrix());
            shapeRenderer.setTransformMatrix(computeTransform);
            shapeRenderer.flush();
        }
        drawDebugChildren(shapeRenderer);
        if (this.transform) {
            shapeRenderer.setTransformMatrix(this.oldTransform);
        }
    }

    public void drawDebugChildren(ShapeRenderer shapeRenderer) {
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArr = (Actor[]) snapshotArray.begin();
        int i = 0;
        if (this.transform) {
            int i2 = snapshotArray.size;
            while (i < i2) {
                Actor actor = actorArr[i];
                if (actor.visible && (actor.debug || (actor instanceof Group))) {
                    actor.drawDebug(shapeRenderer);
                }
                i++;
            }
            shapeRenderer.flush();
        } else {
            float f2 = this.x;
            float f3 = this.y;
            this.x = 0.0f;
            this.y = 0.0f;
            int i3 = snapshotArray.size;
            while (i < i3) {
                Actor actor2 = actorArr[i];
                if (actor2.visible && (actor2.debug || (actor2 instanceof Group))) {
                    float f4 = actor2.x;
                    float f5 = actor2.y;
                    actor2.x = f4 + f2;
                    actor2.y = f5 + f3;
                    actor2.drawDebug(shapeRenderer);
                    actor2.x = f4;
                    actor2.y = f5;
                }
                i++;
            }
            this.x = f2;
            this.y = f3;
        }
        snapshotArray.end();
    }

    public Actor hit(float f2, float f3, boolean z) {
        if ((z && this.touchable == Touchable.disabled) || !this.visible) {
            return null;
        }
        Vector2 vector2 = tmp;
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArr = (Actor[]) snapshotArray.items;
        for (int i = snapshotArray.size - 1; i >= 0; i--) {
            Actor actor = actorArr[i];
            vector2.x = f2;
            vector2.y = f3;
            actor.parentToLocalCoordinates(vector2);
            Actor hit = actor.hit(vector2.x, vector2.y, z);
            if (hit != null) {
                return hit;
            }
        }
        return super.hit(f2, f3, z);
    }

    public boolean removeActor(Actor actor) {
        return removeActor(actor, true);
    }

    public Actor removeActorAt(int i, boolean z) {
        Actor actor = (Actor) this.children.removeIndex(i);
        if (z) {
            Stage stage = this.stage;
            if (stage != null) {
                SnapshotArray<TouchFocus> snapshotArray = stage.touchFocuses;
                TouchFocus[] touchFocusArr = (TouchFocus[]) snapshotArray.begin();
                int i2 = snapshotArray.size;
                InputEvent inputEvent = null;
                for (int i3 = 0; i3 < i2; i3++) {
                    TouchFocus touchFocus = touchFocusArr[i3];
                    if (touchFocus.listenerActor == actor && snapshotArray.removeValue(touchFocus, true)) {
                        if (inputEvent == null) {
                            inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
                            inputEvent.stage = stage;
                            inputEvent.type = Type.touchUp;
                            inputEvent.stageX = -2.1474836E9f;
                            inputEvent.stageY = -2.1474836E9f;
                        }
                        inputEvent.targetActor = touchFocus.target;
                        inputEvent.listenerActor = touchFocus.listenerActor;
                        inputEvent.pointer = touchFocus.pointer;
                        inputEvent.button = touchFocus.button;
                        touchFocus.listener.handle(inputEvent);
                    }
                }
                snapshotArray.end();
                if (inputEvent != null) {
                    Pools.free(inputEvent);
                }
                Actor actor2 = stage.scrollFocus;
                if (actor2 != null && actor2.isDescendantOf(actor)) {
                    stage.setScrollFocus(null);
                }
                Actor actor3 = stage.keyboardFocus;
                if (actor3 != null && actor3.isDescendantOf(actor)) {
                    stage.setKeyboardFocus(null);
                }
            }
        }
        actor.parent = null;
        actor.setStage(null);
        childrenChanged();
        return actor;
    }

    public void setCullingArea(Rectangle rectangle) {
        this.cullingArea = rectangle;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        SnapshotArray<Actor> snapshotArray = this.children;
        Actor[] actorArr = (Actor[]) snapshotArray.items;
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            actorArr[i2].setStage(stage);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        toString(sb, 1);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public boolean removeActor(Actor actor, boolean z) {
        int indexOf = this.children.indexOf(actor, true);
        if (indexOf == -1) {
            return false;
        }
        removeActorAt(indexOf, z);
        return true;
    }

    public void toString(StringBuilder sb, int i) {
        sb.append(super.toString());
        sb.append(10);
        Actor[] actorArr = (Actor[]) this.children.begin();
        int i2 = this.children.size;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                sb.append("|  ");
            }
            Actor actor = actorArr[i3];
            if (actor instanceof Group) {
                ((Group) actor).toString(sb, i + 1);
            } else {
                sb.append(actor);
                sb.append(10);
            }
        }
        this.children.end();
    }
}
