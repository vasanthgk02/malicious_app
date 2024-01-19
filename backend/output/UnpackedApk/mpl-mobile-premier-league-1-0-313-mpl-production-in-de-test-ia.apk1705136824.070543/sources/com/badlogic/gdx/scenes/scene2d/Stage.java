package com.badlogic.gdx.scenes.scene2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.ui.Table.Debug;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener$FocusEvent;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

public class Stage extends InputAdapter implements Disposable {
    public static boolean debug;
    public boolean actionsRequestRendering = true;
    public final Batch batch;
    public final Color debugColor = new Color(0.0f, 1.0f, 0.0f, 0.85f);
    public ShapeRenderer debugShapes;
    public Debug debugTableUnderMouse = Debug.none;
    public Actor keyboardFocus;
    public Actor mouseOverActor;
    public int mouseScreenX;
    public int mouseScreenY;
    public boolean ownsBatch;
    public final Actor[] pointerOverActors = new Actor[20];
    public final int[] pointerScreenX = new int[20];
    public final int[] pointerScreenY = new int[20];
    public final boolean[] pointerTouched = new boolean[20];
    public Group root;
    public Actor scrollFocus;
    public final Vector2 tempCoords = new Vector2();
    public final SnapshotArray<TouchFocus> touchFocuses = new SnapshotArray<>(true, 4, TouchFocus.class);
    public ScalingViewport viewport;

    public static final class TouchFocus implements Poolable {
        public int button;
        public EventListener listener;
        public Actor listenerActor;
        public int pointer;
        public Actor target;

        public void reset() {
            this.listenerActor = null;
            this.listener = null;
            this.target = null;
        }
    }

    public Stage(ScalingViewport scalingViewport) {
        SpriteBatch spriteBatch = new SpriteBatch();
        this.viewport = scalingViewport;
        this.batch = spriteBatch;
        Group group = new Group();
        this.root = group;
        group.setStage(this);
        AndroidGraphics androidGraphics = (AndroidGraphics) k.graphics;
        scalingViewport.update(androidGraphics.width, androidGraphics.height, true);
        this.ownsBatch = true;
    }

    public void addTouchFocus(EventListener eventListener, Actor actor, Actor actor2, int i, int i2) {
        TouchFocus touchFocus = (TouchFocus) Pools.obtain(TouchFocus.class);
        touchFocus.listenerActor = actor;
        touchFocus.target = actor2;
        touchFocus.listener = eventListener;
        touchFocus.pointer = i;
        touchFocus.button = i2;
        this.touchFocuses.add(touchFocus);
    }

    public void cancelTouchFocusExcept(EventListener eventListener, Actor actor) {
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.touchUp;
        inputEvent.stageX = -2.1474836E9f;
        inputEvent.stageY = -2.1474836E9f;
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArr = (TouchFocus[]) snapshotArray.begin();
        int i = snapshotArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            TouchFocus touchFocus = touchFocusArr[i2];
            if (!(touchFocus.listener == eventListener && touchFocus.listenerActor == actor) && snapshotArray.removeValue(touchFocus, true)) {
                inputEvent.targetActor = touchFocus.target;
                inputEvent.listenerActor = touchFocus.listenerActor;
                inputEvent.pointer = touchFocus.pointer;
                inputEvent.button = touchFocus.button;
                touchFocus.listener.handle(inputEvent);
            }
        }
        snapshotArray.end();
        Pools.free(inputEvent);
    }

    public final void disableDebug(Actor actor, Actor actor2) {
        if (actor != actor2) {
            actor.setDebug(false);
            if (actor instanceof Group) {
                SnapshotArray<Actor> snapshotArray = ((Group) actor).children;
                int i = snapshotArray.size;
                for (int i2 = 0; i2 < i; i2++) {
                    disableDebug((Actor) snapshotArray.get(i2), actor2);
                }
            }
        }
    }

    public void dispose() {
        setScrollFocus(null);
        setKeyboardFocus(null);
        cancelTouchFocusExcept(null, null);
        Group group = this.root;
        group.clearActions();
        group.listeners.clear();
        group.captureListeners.clear();
        group.clearChildren();
        if (this.ownsBatch) {
            this.batch.dispose();
        }
    }

    public final Actor fireEnterAndExit(Actor actor, int i, int i2, int i3) {
        Class cls = InputEvent.class;
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) i;
        vector2.y = (float) i2;
        screenToStageCoordinates(vector2);
        Vector2 vector22 = this.tempCoords;
        Actor hit = hit(vector22.x, vector22.y, true);
        if (hit == actor) {
            return actor;
        }
        if (actor != null) {
            InputEvent inputEvent = (InputEvent) Pools.obtain(cls);
            inputEvent.stage = this;
            Vector2 vector23 = this.tempCoords;
            inputEvent.stageX = vector23.x;
            inputEvent.stageY = vector23.y;
            inputEvent.pointer = i3;
            inputEvent.type = Type.exit;
            inputEvent.relatedActor = hit;
            actor.fire(inputEvent);
            Pools.free(inputEvent);
        }
        if (hit != null) {
            InputEvent inputEvent2 = (InputEvent) Pools.obtain(cls);
            inputEvent2.stage = this;
            Vector2 vector24 = this.tempCoords;
            inputEvent2.stageX = vector24.x;
            inputEvent2.stageY = vector24.y;
            inputEvent2.pointer = i3;
            inputEvent2.type = Type.enter;
            inputEvent2.relatedActor = actor;
            hit.fire(inputEvent2);
            Pools.free(inputEvent2);
        }
        return hit;
    }

    public Actor hit(float f2, float f3, boolean z) {
        Group group = this.root;
        Vector2 vector2 = this.tempCoords;
        vector2.x = f2;
        vector2.y = f3;
        group.parentToLocalCoordinates(vector2);
        Group group2 = this.root;
        Vector2 vector22 = this.tempCoords;
        return group2.hit(vector22.x, vector22.y, z);
    }

    public boolean isInsideViewport(int i, int i2) {
        ScalingViewport scalingViewport = this.viewport;
        int i3 = scalingViewport.screenX;
        int i4 = scalingViewport.screenWidth + i3;
        int i5 = scalingViewport.screenY;
        int i6 = scalingViewport.screenHeight + i5;
        int i7 = (((AndroidGraphics) k.graphics).height - 1) - i2;
        return i >= i3 && i < i4 && i7 >= i5 && i7 < i6;
    }

    public boolean keyDown(int i) {
        Actor actor = this.keyboardFocus;
        if (actor == null) {
            actor = this.root;
        }
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.keyDown;
        inputEvent.keyCode = i;
        actor.fire(inputEvent);
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean keyTyped(char c2) {
        Actor actor = this.keyboardFocus;
        if (actor == null) {
            actor = this.root;
        }
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.keyTyped;
        inputEvent.character = c2;
        actor.fire(inputEvent);
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean keyUp(int i) {
        Actor actor = this.keyboardFocus;
        if (actor == null) {
            actor = this.root;
        }
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.keyUp;
        inputEvent.keyCode = i;
        actor.fire(inputEvent);
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean mouseMoved(int i, int i2) {
        this.mouseScreenX = i;
        this.mouseScreenY = i2;
        if (!isInsideViewport(i, i2)) {
            return false;
        }
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) i;
        vector2.y = (float) i2;
        screenToStageCoordinates(vector2);
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.mouseMoved;
        Vector2 vector22 = this.tempCoords;
        float f2 = vector22.x;
        inputEvent.stageX = f2;
        float f3 = vector22.y;
        inputEvent.stageY = f3;
        Actor hit = hit(f2, f3, true);
        if (hit == null) {
            hit = this.root;
        }
        hit.fire(inputEvent);
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public Vector2 screenToStageCoordinates(Vector2 vector2) {
        ScalingViewport scalingViewport = this.viewport;
        scalingViewport.tmp.set(vector2.x, vector2.y, 1.0f);
        scalingViewport.camera.unproject(scalingViewport.tmp, (float) scalingViewport.screenX, (float) scalingViewport.screenY, (float) scalingViewport.screenWidth, (float) scalingViewport.screenHeight);
        Vector3 vector3 = scalingViewport.tmp;
        float f2 = vector3.x;
        float f3 = vector3.y;
        vector2.x = f2;
        vector2.y = f3;
        return vector2;
    }

    public boolean scrolled(float f2, float f3) {
        Actor actor = this.scrollFocus;
        if (actor == null) {
            actor = this.root;
        }
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) this.mouseScreenX;
        vector2.y = (float) this.mouseScreenY;
        screenToStageCoordinates(vector2);
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.stage = this;
        inputEvent.type = Type.scrolled;
        inputEvent.scrollAmountX = f2;
        inputEvent.scrollAmountY = f3;
        Vector2 vector22 = this.tempCoords;
        inputEvent.stageX = vector22.x;
        inputEvent.stageY = vector22.y;
        actor.fire(inputEvent);
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean setKeyboardFocus(Actor actor) {
        if (this.keyboardFocus == null) {
            return true;
        }
        FocusListener$FocusEvent focusListener$FocusEvent = (FocusListener$FocusEvent) Pools.obtain(FocusListener$FocusEvent.class);
        focusListener$FocusEvent.stage = this;
        FocusListener$FocusEvent.Type type = FocusListener$FocusEvent.Type.keyboard;
        Actor actor2 = this.keyboardFocus;
        if (actor2 != null) {
            actor2.fire(focusListener$FocusEvent);
        }
        boolean z = true ^ focusListener$FocusEvent.cancelled;
        if (z) {
            this.keyboardFocus = null;
        }
        Pools.free(focusListener$FocusEvent);
        return z;
    }

    public boolean setScrollFocus(Actor actor) {
        if (this.scrollFocus == actor) {
            return true;
        }
        FocusListener$FocusEvent focusListener$FocusEvent = (FocusListener$FocusEvent) Pools.obtain(FocusListener$FocusEvent.class);
        focusListener$FocusEvent.stage = this;
        FocusListener$FocusEvent.Type type = FocusListener$FocusEvent.Type.scroll;
        Actor actor2 = this.scrollFocus;
        if (actor2 != null) {
            actor2.fire(focusListener$FocusEvent);
        }
        boolean z = !focusListener$FocusEvent.cancelled;
        if (z) {
            this.scrollFocus = actor;
            if (actor != null) {
                actor.fire(focusListener$FocusEvent);
                z = !focusListener$FocusEvent.cancelled;
                if (!z) {
                    this.scrollFocus = actor2;
                }
            }
        }
        Pools.free(focusListener$FocusEvent);
        return z;
    }

    public boolean touchDown(int i, int i2, int i3, int i4) {
        if (!isInsideViewport(i, i2)) {
            return false;
        }
        this.pointerTouched[i3] = true;
        this.pointerScreenX[i3] = i;
        this.pointerScreenY[i3] = i2;
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) i;
        vector2.y = (float) i2;
        screenToStageCoordinates(vector2);
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.type = Type.touchDown;
        inputEvent.stage = this;
        Vector2 vector22 = this.tempCoords;
        float f2 = vector22.x;
        inputEvent.stageX = f2;
        float f3 = vector22.y;
        inputEvent.stageY = f3;
        inputEvent.pointer = i3;
        inputEvent.button = i4;
        Actor hit = hit(f2, f3, true);
        if (hit == null) {
            Group group = this.root;
            if (group.touchable == Touchable.enabled) {
                group.fire(inputEvent);
            }
        } else {
            hit.fire(inputEvent);
        }
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean touchDragged(int i, int i2, int i3) {
        this.pointerScreenX[i3] = i;
        this.pointerScreenY[i3] = i2;
        this.mouseScreenX = i;
        this.mouseScreenY = i2;
        if (this.touchFocuses.size == 0) {
            return false;
        }
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) i;
        vector2.y = (float) i2;
        screenToStageCoordinates(vector2);
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.type = Type.touchDragged;
        inputEvent.stage = this;
        Vector2 vector22 = this.tempCoords;
        inputEvent.stageX = vector22.x;
        inputEvent.stageY = vector22.y;
        inputEvent.pointer = i3;
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArr = (TouchFocus[]) snapshotArray.begin();
        int i4 = snapshotArray.size;
        for (int i5 = 0; i5 < i4; i5++) {
            TouchFocus touchFocus = touchFocusArr[i5];
            if (touchFocus.pointer == i3 && snapshotArray.contains(touchFocus, true)) {
                inputEvent.targetActor = touchFocus.target;
                inputEvent.listenerActor = touchFocus.listenerActor;
                if (touchFocus.listener.handle(inputEvent)) {
                    inputEvent.handled = true;
                }
            }
        }
        snapshotArray.end();
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }

    public boolean touchUp(int i, int i2, int i3, int i4) {
        this.pointerTouched[i3] = false;
        this.pointerScreenX[i3] = i;
        this.pointerScreenY[i3] = i2;
        if (this.touchFocuses.size == 0) {
            return false;
        }
        Vector2 vector2 = this.tempCoords;
        vector2.x = (float) i;
        vector2.y = (float) i2;
        screenToStageCoordinates(vector2);
        InputEvent inputEvent = (InputEvent) Pools.obtain(InputEvent.class);
        inputEvent.type = Type.touchUp;
        inputEvent.stage = this;
        Vector2 vector22 = this.tempCoords;
        inputEvent.stageX = vector22.x;
        inputEvent.stageY = vector22.y;
        inputEvent.pointer = i3;
        inputEvent.button = i4;
        SnapshotArray<TouchFocus> snapshotArray = this.touchFocuses;
        TouchFocus[] touchFocusArr = (TouchFocus[]) snapshotArray.begin();
        int i5 = snapshotArray.size;
        for (int i6 = 0; i6 < i5; i6++) {
            TouchFocus touchFocus = touchFocusArr[i6];
            if (touchFocus.pointer == i3 && touchFocus.button == i4 && snapshotArray.removeValue(touchFocus, true)) {
                inputEvent.targetActor = touchFocus.target;
                inputEvent.listenerActor = touchFocus.listenerActor;
                if (touchFocus.listener.handle(inputEvent)) {
                    inputEvent.handled = true;
                }
                Pools.free(touchFocus);
            }
        }
        snapshotArray.end();
        boolean z = inputEvent.handled;
        Pools.free(inputEvent);
        return z;
    }
}
