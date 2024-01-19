package com.badlogic.gdx.scenes.scene2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Pools;

public class Actor {
    public final Array<Action> actions = new Array<>(true, 0);
    public final DelayedRemovalArray<EventListener> captureListeners = new DelayedRemovalArray<>(0);
    public final Color color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
    public boolean debug;
    public float height;
    public final DelayedRemovalArray<EventListener> listeners = new DelayedRemovalArray<>(0);
    public String name;
    public float originX;
    public float originY;
    public Group parent;
    public float rotation;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public Stage stage;
    public Touchable touchable = Touchable.enabled;
    public boolean visible = true;
    public float width;
    public float x;
    public float y;

    public void act(float f2) {
        int i;
        Array<Action> array = this.actions;
        if (array.size != 0) {
            Stage stage2 = this.stage;
            if (stage2 != null && stage2.actionsRequestRendering) {
                ((AndroidGraphics) k.graphics).requestRendering();
            }
            int i2 = 0;
            while (i2 < array.size) {
                try {
                    Action action = (Action) array.get(i2);
                    if (action.act(f2) && i2 < array.size) {
                        if (((Action) array.get(i2)) == action) {
                            i = i2;
                        } else {
                            i = array.indexOf(action, true);
                        }
                        if (i != -1) {
                            array.removeIndex(i);
                            action.setActor(null);
                            i2--;
                        }
                    }
                    i2++;
                } catch (RuntimeException e2) {
                    String actor = toString();
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Actor: ");
                    outline73.append(actor.substring(0, Math.min(actor.length(), 128)));
                    throw new RuntimeException(outline73.toString(), e2);
                }
            }
        }
    }

    public void addAction(Action action) {
        action.setActor(this);
        this.actions.add(action);
        Stage stage2 = this.stage;
        if (stage2 != null && stage2.actionsRequestRendering) {
            ((AndroidGraphics) k.graphics).requestRendering();
        }
    }

    public boolean addListener(EventListener eventListener) {
        if (eventListener == null) {
            throw new IllegalArgumentException("listener cannot be null.");
        } else if (this.listeners.contains(eventListener, true)) {
            return false;
        } else {
            this.listeners.add(eventListener);
            return true;
        }
    }

    public void clearActions() {
        for (int i = this.actions.size - 1; i >= 0; i--) {
            ((Action) this.actions.get(i)).setActor(null);
        }
        this.actions.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0162 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean clipBegin(float r18, float r19, float r20, float r21) {
        /*
            r17 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = 0
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x0167
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 > 0) goto L_0x0010
            goto L_0x0167
        L_0x0010:
            r4 = r17
            com.badlogic.gdx.scenes.scene2d.Stage r5 = r4.stage
            if (r5 != 0) goto L_0x0017
            return r2
        L_0x0017:
            com.badlogic.gdx.math.Rectangle r6 = com.badlogic.gdx.math.Rectangle.tmp
            r7 = r18
            r6.x = r7
            r7 = r19
            r6.y = r7
            r6.width = r0
            r6.height = r1
            java.lang.Class<com.badlogic.gdx.math.Rectangle> r0 = com.badlogic.gdx.math.Rectangle.class
            java.lang.Object r0 = com.badlogic.gdx.utils.Pools.obtain(r0)
            com.badlogic.gdx.math.Rectangle r0 = (com.badlogic.gdx.math.Rectangle) r0
            com.badlogic.gdx.graphics.glutils.ShapeRenderer r1 = r5.debugShapes
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.isDrawing()
            if (r1 == 0) goto L_0x003e
            com.badlogic.gdx.graphics.glutils.ShapeRenderer r1 = r5.debugShapes
            com.badlogic.gdx.math.Matrix4 r1 = r1.getTransformMatrix()
            goto L_0x0044
        L_0x003e:
            com.badlogic.gdx.graphics.g2d.Batch r1 = r5.batch
            com.badlogic.gdx.math.Matrix4 r1 = r1.getTransformMatrix()
        L_0x0044:
            com.badlogic.gdx.utils.viewport.ScalingViewport r5 = r5.viewport
            com.badlogic.gdx.graphics.Camera r13 = r5.camera
            int r7 = r5.screenX
            float r14 = (float) r7
            int r7 = r5.screenY
            float r15 = (float) r7
            int r7 = r5.screenWidth
            float r12 = (float) r7
            int r5 = r5.screenHeight
            float r5 = (float) r5
            com.badlogic.gdx.math.Vector3 r7 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            float r8 = r6.x
            float r9 = r6.y
            r7.set(r8, r9, r3)
            com.badlogic.gdx.math.Vector3 r7 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            r7.mul(r1)
            com.badlogic.gdx.math.Vector3 r8 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            r7 = r13
            r9 = r14
            r10 = r15
            r11 = r12
            r16 = r12
            r12 = r5
            r7.project(r8, r9, r10, r11, r12)
            com.badlogic.gdx.math.Vector3 r7 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            float r8 = r7.x
            r0.x = r8
            float r8 = r7.y
            r0.y = r8
            float r8 = r6.x
            float r9 = r6.width
            float r8 = r8 + r9
            float r9 = r6.y
            float r6 = r6.height
            float r9 = r9 + r6
            r7.set(r8, r9, r3)
            com.badlogic.gdx.math.Vector3 r6 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            r6.mul(r1)
            com.badlogic.gdx.math.Vector3 r8 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            r7 = r13
            r9 = r14
            r11 = r16
            r7.project(r8, r9, r10, r11, r12)
            com.badlogic.gdx.math.Vector3 r1 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.tmp
            float r5 = r1.x
            float r6 = r0.x
            float r5 = r5 - r6
            r0.width = r5
            float r1 = r1.y
            float r5 = r0.y
            float r1 = r1 - r5
            r0.height = r1
            int r1 = java.lang.Math.round(r6)
            float r1 = (float) r1
            r0.x = r1
            float r1 = r0.y
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            r0.y = r1
            float r1 = r0.width
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            r0.width = r1
            float r1 = r0.height
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            r0.height = r1
            float r1 = r0.width
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x00d3
            float r1 = -r1
            r0.width = r1
            float r5 = r0.x
            float r5 = r5 - r1
            r0.x = r5
        L_0x00d3:
            float r1 = r0.height
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x00e1
            float r1 = -r1
            r0.height = r1
            float r3 = r0.y
            float r3 = r3 - r1
            r0.y = r3
        L_0x00e1:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> r1 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.scissors
            int r3 = r1.size
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 1
            if (r3 != 0) goto L_0x00ff
            float r1 = r0.width
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x013d
            float r1 = r0.height
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f7
            goto L_0x013d
        L_0x00f7:
            com.badlogic.gdx.graphics.GL20 r1 = co.hyperverge.hypersnapsdk.c.k.gl
            r3 = 3089(0xc11, float:4.329E-42)
            r1.glEnable(r3)
            goto L_0x014b
        L_0x00ff:
            int r3 = r3 - r6
            java.lang.Object r1 = r1.get(r3)
            com.badlogic.gdx.math.Rectangle r1 = (com.badlogic.gdx.math.Rectangle) r1
            float r3 = r1.x
            float r7 = r0.x
            float r3 = java.lang.Math.max(r3, r7)
            float r7 = r1.x
            float r8 = r1.width
            float r7 = r7 + r8
            float r8 = r0.x
            float r9 = r0.width
            float r8 = r8 + r9
            float r7 = java.lang.Math.min(r7, r8)
            float r7 = r7 - r3
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x0122
            goto L_0x013d
        L_0x0122:
            float r8 = r1.y
            float r9 = r0.y
            float r8 = java.lang.Math.max(r8, r9)
            float r9 = r1.y
            float r1 = r1.height
            float r9 = r9 + r1
            float r1 = r0.y
            float r10 = r0.height
            float r1 = r1 + r10
            float r1 = java.lang.Math.min(r9, r1)
            float r1 = r1 - r8
            int r9 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x013f
        L_0x013d:
            r1 = 0
            goto L_0x0160
        L_0x013f:
            r0.x = r3
            r0.y = r8
            r0.width = r7
            float r1 = java.lang.Math.max(r5, r1)
            r0.height = r1
        L_0x014b:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.math.Rectangle> r1 = com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.scissors
            r1.add(r0)
            float r1 = r0.x
            int r1 = (int) r1
            float r3 = r0.y
            int r3 = (int) r3
            float r5 = r0.width
            int r5 = (int) r5
            float r7 = r0.height
            int r7 = (int) r7
            com.badlogic.gdx.graphics.glutils.HdpiUtils.glScissor(r1, r3, r5, r7)
            r1 = 1
        L_0x0160:
            if (r1 == 0) goto L_0x0163
            return r6
        L_0x0163:
            com.badlogic.gdx.utils.Pools.free(r0)
            return r2
        L_0x0167:
            r4 = r17
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.Actor.clipBegin(float, float, float, float):boolean");
    }

    public void clipEnd() {
        Rectangle rectangle = (Rectangle) ScissorStack.scissors.pop();
        Array<Rectangle> array = ScissorStack.scissors;
        if (array.size == 0) {
            k.gl.glDisable(GL20.GL_SCISSOR_TEST);
        } else {
            Rectangle rectangle2 = (Rectangle) array.peek();
            HdpiUtils.glScissor((int) rectangle2.x, (int) rectangle2.y, (int) rectangle2.width, (int) rectangle2.height);
        }
        Pools.free(rectangle);
    }

    public void draw(Batch batch, float f2) {
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        drawDebugBounds(shapeRenderer);
    }

    public void drawDebugBounds(ShapeRenderer shapeRenderer) {
        if (this.debug) {
            shapeRenderer.set(ShapeType.Line);
            Stage stage2 = this.stage;
            if (stage2 != null) {
                shapeRenderer.setColor(stage2.debugColor);
            }
            shapeRenderer.rect(this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        notify(r7, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r7.stopped == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r7 = r7.cancelled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        notify(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r7.bubbles != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r7 = r7.cancelled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (r7.stopped == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r7 = r7.cancelled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r3 = r0.size;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        if (r4 >= r3) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        ((com.badlogic.gdx.scenes.scene2d.Group) r1[r4]).notify(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r7.stopped == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        r7 = r7.cancelled;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006d, code lost:
        r7 = r7.cancelled;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fire(com.badlogic.gdx.scenes.scene2d.Event r7) {
        /*
            r6 = this;
            com.badlogic.gdx.scenes.scene2d.Stage r0 = r7.stage
            if (r0 != 0) goto L_0x0008
            com.badlogic.gdx.scenes.scene2d.Stage r0 = r6.stage
            r7.stage = r0
        L_0x0008:
            r7.targetActor = r6
            java.lang.Class<com.badlogic.gdx.utils.Array> r0 = com.badlogic.gdx.utils.Array.class
            java.lang.Object r0 = com.badlogic.gdx.utils.Pools.obtain(r0)
            com.badlogic.gdx.utils.Array r0 = (com.badlogic.gdx.utils.Array) r0
            com.badlogic.gdx.scenes.scene2d.Group r1 = r6.parent
        L_0x0014:
            if (r1 == 0) goto L_0x001c
            r0.add(r1)
            com.badlogic.gdx.scenes.scene2d.Group r1 = r1.parent
            goto L_0x0014
        L_0x001c:
            T[] r1 = r0.items     // Catch:{ all -> 0x0070 }
            int r2 = r0.size     // Catch:{ all -> 0x0070 }
            r3 = 1
            int r2 = r2 - r3
        L_0x0022:
            if (r2 < 0) goto L_0x003b
            r4 = r1[r2]     // Catch:{ all -> 0x0070 }
            com.badlogic.gdx.scenes.scene2d.Group r4 = (com.badlogic.gdx.scenes.scene2d.Group) r4     // Catch:{ all -> 0x0070 }
            r4.notify(r7, r3)     // Catch:{ all -> 0x0070 }
            boolean r4 = r7.stopped     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0038
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
        L_0x0031:
            r0.clear()
            com.badlogic.gdx.utils.Pools.free(r0)
            return r7
        L_0x0038:
            int r2 = r2 + -1
            goto L_0x0022
        L_0x003b:
            r6.notify(r7, r3)     // Catch:{ all -> 0x0070 }
            boolean r2 = r7.stopped     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0045
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
            goto L_0x0031
        L_0x0045:
            r2 = 0
            r6.notify(r7, r2)     // Catch:{ all -> 0x0070 }
            boolean r3 = r7.bubbles     // Catch:{ all -> 0x0070 }
            if (r3 != 0) goto L_0x0050
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
            goto L_0x0031
        L_0x0050:
            boolean r3 = r7.stopped     // Catch:{ all -> 0x0070 }
            if (r3 == 0) goto L_0x0057
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
            goto L_0x0031
        L_0x0057:
            int r3 = r0.size     // Catch:{ all -> 0x0070 }
            r4 = 0
        L_0x005a:
            if (r4 >= r3) goto L_0x006d
            r5 = r1[r4]     // Catch:{ all -> 0x0070 }
            com.badlogic.gdx.scenes.scene2d.Group r5 = (com.badlogic.gdx.scenes.scene2d.Group) r5     // Catch:{ all -> 0x0070 }
            r5.notify(r7, r2)     // Catch:{ all -> 0x0070 }
            boolean r5 = r7.stopped     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x006a
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
            goto L_0x0031
        L_0x006a:
            int r4 = r4 + 1
            goto L_0x005a
        L_0x006d:
            boolean r7 = r7.cancelled     // Catch:{ all -> 0x0070 }
            goto L_0x0031
        L_0x0070:
            r7 = move-exception
            r0.clear()
            com.badlogic.gdx.utils.Pools.free(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.scenes.scene2d.Actor.fire(com.badlogic.gdx.scenes.scene2d.Event):boolean");
    }

    public Actor hit(float f2, float f3, boolean z) {
        Actor actor = null;
        if ((z && this.touchable != Touchable.enabled) || !this.visible) {
            return null;
        }
        if (f2 >= 0.0f && f2 < this.width && f3 >= 0.0f && f3 < this.height) {
            actor = this;
        }
        return actor;
    }

    public boolean isDescendantOf(Actor actor) {
        if (actor != null) {
            Actor actor2 = this;
            while (actor2 != actor) {
                actor2 = actor2.parent;
                if (actor2 == null) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("actor cannot be null.");
    }

    public void moveBy(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            this.x += f2;
            this.y += f3;
        }
    }

    public boolean notify(Event event, boolean z) {
        if (event.targetActor != null) {
            DelayedRemovalArray<EventListener> delayedRemovalArray = z ? this.captureListeners : this.listeners;
            if (delayedRemovalArray.size == 0) {
                return event.cancelled;
            }
            event.listenerActor = this;
            if (event.stage == null) {
                event.stage = this.stage;
            }
            try {
                delayedRemovalArray.iterating++;
                int i = delayedRemovalArray.size;
                for (int i2 = 0; i2 < i; i2++) {
                    if (((EventListener) delayedRemovalArray.get(i2)).handle(event)) {
                        event.handled = true;
                    }
                }
                delayedRemovalArray.end();
                return event.cancelled;
            } catch (RuntimeException e2) {
                String actor = toString();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Actor: ");
                outline73.append(actor.substring(0, Math.min(actor.length(), 128)));
                throw new RuntimeException(outline73.toString(), e2);
            }
        } else {
            throw new IllegalArgumentException("The event target cannot be null.");
        }
    }

    public Vector2 parentToLocalCoordinates(Vector2 vector2) {
        float f2 = this.rotation;
        float f3 = this.scaleX;
        float f4 = this.scaleY;
        float f5 = this.x;
        float f6 = this.y;
        if (f2 != 0.0f) {
            double d2 = (double) (f2 * 0.017453292f);
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float f7 = this.originX;
            float f8 = this.originY;
            float f9 = (vector2.x - f5) - f7;
            float f10 = (vector2.y - f6) - f8;
            vector2.x = (((f10 * sin) + (f9 * cos)) / f3) + f7;
            vector2.y = (((f10 * cos) + (f9 * (-sin))) / f4) + f8;
        } else if (f3 == 1.0f && f4 == 1.0f) {
            vector2.x -= f5;
            vector2.y -= f6;
        } else {
            float f11 = this.originX;
            float f12 = this.originY;
            vector2.x = (((vector2.x - f5) - f11) / f3) + f11;
            vector2.y = (((vector2.y - f6) - f12) / f4) + f12;
        }
        return vector2;
    }

    public void scaleChanged() {
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        if (!(this.x == f2 && this.y == f3)) {
            this.x = f2;
            this.y = f3;
        }
        if (this.width != f4 || this.height != f5) {
            this.width = f4;
            this.height = f5;
            sizeChanged();
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
        if (z) {
            Stage.debug = true;
        }
    }

    public void setHeight(float f2) {
        if (this.height != f2) {
            this.height = f2;
            ((WidgetGroup) this).invalidate();
        }
    }

    public void setPosition(float f2, float f3) {
        if (this.x != f2 || this.y != f3) {
            this.x = f2;
            this.y = f3;
        }
    }

    public void setScale(float f2) {
        if (this.scaleX != f2 || this.scaleY != f2) {
            this.scaleX = f2;
            this.scaleY = f2;
            scaleChanged();
        }
    }

    public void setSize(float f2, float f3) {
        if (this.width != f2 || this.height != f3) {
            this.width = f2;
            this.height = f3;
            sizeChanged();
        }
    }

    public void setStage(Stage stage2) {
        this.stage = stage2;
    }

    public void setY(float f2) {
        if (this.y != f2) {
            this.y = f2;
        }
    }

    public void sizeChanged() {
    }

    public Vector2 stageToLocalCoordinates(Vector2 vector2) {
        Group group = this.parent;
        if (group != null) {
            group.stageToLocalCoordinates(vector2);
        }
        parentToLocalCoordinates(vector2);
        return vector2;
    }

    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String name2 = getClass().getName();
        int lastIndexOf = name2.lastIndexOf(46);
        return lastIndexOf != -1 ? name2.substring(lastIndexOf + 1) : name2;
    }
}
