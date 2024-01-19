package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class ActorGestureListener implements EventListener {
    public static final Vector2 tmpCoords = new Vector2();
    public static final Vector2 tmpCoords2 = new Vector2();
    public Actor actor;
    public final GestureDetector detector;
    public InputEvent event;

    public ActorGestureListener(float f2, float f3, float f4, float f5) {
        GestureDetector gestureDetector = new GestureDetector(f2, f3, f4, f5, new GestureAdapter() {
            public final Vector2 initialPointer1 = new Vector2();
            public final Vector2 initialPointer2 = new Vector2();
            public final Vector2 pointer1 = new Vector2();
            public final Vector2 pointer2 = new Vector2();

            public boolean fling(float f2, float f3, int i) {
                Vector2 vector2 = ActorGestureListener.tmpCoords;
                vector2.x = f2;
                vector2.y = f3;
                stageToLocalAmount(vector2);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                Vector2 vector22 = ActorGestureListener.tmpCoords;
                actorGestureListener.fling(inputEvent, vector22.x, vector22.y, i);
                return true;
            }

            public boolean longPress(float f2, float f3) {
                Actor actor = ActorGestureListener.this.actor;
                Vector2 vector2 = ActorGestureListener.tmpCoords;
                vector2.x = f2;
                vector2.y = f3;
                Group group = actor.parent;
                if (group != null) {
                    group.stageToLocalCoordinates(vector2);
                }
                actor.parentToLocalCoordinates(vector2);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                Actor actor2 = actorGestureListener.actor;
                if (actorGestureListener != null) {
                    return false;
                }
                throw null;
            }

            public boolean pan(float f2, float f3, float f4, float f5) {
                Vector2 vector2 = ActorGestureListener.tmpCoords;
                vector2.x = f4;
                vector2.y = f5;
                stageToLocalAmount(vector2);
                Vector2 vector22 = ActorGestureListener.tmpCoords;
                float f6 = vector22.x;
                float f7 = vector22.y;
                Actor actor = ActorGestureListener.this.actor;
                vector22.x = f2;
                vector22.y = f3;
                Group group = actor.parent;
                if (group != null) {
                    group.stageToLocalCoordinates(vector22);
                }
                actor.parentToLocalCoordinates(vector22);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                Vector2 vector23 = ActorGestureListener.tmpCoords;
                actorGestureListener.pan(inputEvent, vector23.x, vector23.y, f6, f7);
                return true;
            }

            public boolean panStop(float f2, float f3, int i, int i2) {
                Actor actor = ActorGestureListener.this.actor;
                Vector2 vector2 = ActorGestureListener.tmpCoords;
                vector2.x = f2;
                vector2.y = f3;
                Group group = actor.parent;
                if (group != null) {
                    group.stageToLocalCoordinates(vector2);
                }
                actor.parentToLocalCoordinates(vector2);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                Vector2 vector22 = ActorGestureListener.tmpCoords;
                actorGestureListener.panStop(inputEvent, vector22.x, vector22.y, i, i2);
                return true;
            }

            public boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24) {
                Actor actor = ActorGestureListener.this.actor;
                Vector2 vector25 = this.initialPointer1;
                vector25.set(vector2);
                Group group = actor.parent;
                if (group != null) {
                    group.stageToLocalCoordinates(vector25);
                }
                actor.parentToLocalCoordinates(vector25);
                Actor actor2 = ActorGestureListener.this.actor;
                Vector2 vector26 = this.initialPointer2;
                vector26.set(vector22);
                Group group2 = actor2.parent;
                if (group2 != null) {
                    group2.stageToLocalCoordinates(vector26);
                }
                actor2.parentToLocalCoordinates(vector26);
                Actor actor3 = ActorGestureListener.this.actor;
                Vector2 vector27 = this.pointer1;
                vector27.set(vector23);
                Group group3 = actor3.parent;
                if (group3 != null) {
                    group3.stageToLocalCoordinates(vector27);
                }
                actor3.parentToLocalCoordinates(vector27);
                Actor actor4 = ActorGestureListener.this.actor;
                Vector2 vector28 = this.pointer2;
                vector28.set(vector24);
                Group group4 = actor4.parent;
                if (group4 != null) {
                    group4.stageToLocalCoordinates(vector28);
                }
                actor4.parentToLocalCoordinates(vector28);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                if (actorGestureListener != null) {
                    return true;
                }
                throw null;
            }

            public final void stageToLocalAmount(Vector2 vector2) {
                Actor actor = ActorGestureListener.this.actor;
                Group group = actor.parent;
                if (group != null) {
                    Group group2 = group.parent;
                    if (group2 != null) {
                        group2.stageToLocalCoordinates(vector2);
                    }
                    group.parentToLocalCoordinates(vector2);
                }
                actor.parentToLocalCoordinates(vector2);
                Actor actor2 = ActorGestureListener.this.actor;
                Vector2 vector22 = ActorGestureListener.tmpCoords2;
                vector22.x = 0.0f;
                vector22.y = 0.0f;
                Group group3 = actor2.parent;
                if (group3 != null) {
                    Group group4 = group3.parent;
                    if (group4 != null) {
                        group4.stageToLocalCoordinates(vector22);
                    }
                    group3.parentToLocalCoordinates(vector22);
                }
                actor2.parentToLocalCoordinates(vector22);
                vector2.x -= vector22.x;
                vector2.y -= vector22.y;
            }

            public boolean tap(float f2, float f3, int i, int i2) {
                Actor actor = ActorGestureListener.this.actor;
                Vector2 vector2 = ActorGestureListener.tmpCoords;
                vector2.x = f2;
                vector2.y = f3;
                Group group = actor.parent;
                if (group != null) {
                    group.stageToLocalCoordinates(vector2);
                }
                actor.parentToLocalCoordinates(vector2);
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                if (actorGestureListener != null) {
                    return true;
                }
                throw null;
            }

            public boolean zoom(float f2, float f3) {
                ActorGestureListener actorGestureListener = ActorGestureListener.this;
                InputEvent inputEvent = actorGestureListener.event;
                if (actorGestureListener != null) {
                    return true;
                }
                throw null;
            }
        });
        this.detector = gestureDetector;
    }

    public abstract void fling(InputEvent inputEvent, float f2, float f3, int i);

    public boolean handle(Event event2) {
        if (!(event2 instanceof InputEvent)) {
            return false;
        }
        InputEvent inputEvent = (InputEvent) event2;
        int ordinal = inputEvent.type.ordinal();
        if (ordinal == 0) {
            this.actor = inputEvent.listenerActor;
            this.detector.touchDown(inputEvent.stageX, inputEvent.stageY, inputEvent.pointer, inputEvent.button);
            Actor actor2 = this.actor;
            Vector2 vector2 = tmpCoords;
            float f2 = inputEvent.stageX;
            float f3 = inputEvent.stageY;
            vector2.x = f2;
            vector2.y = f3;
            Group group = actor2.parent;
            if (group != null) {
                Group group2 = group.parent;
                if (group2 != null) {
                    group2.stageToLocalCoordinates(vector2);
                }
                group.parentToLocalCoordinates(vector2);
            }
            actor2.parentToLocalCoordinates(vector2);
            Vector2 vector22 = tmpCoords;
            touchDown(inputEvent, vector22.x, vector22.y, inputEvent.pointer, inputEvent.button);
            if (inputEvent.touchFocus) {
                inputEvent.stage.addTouchFocus(this, inputEvent.listenerActor, inputEvent.targetActor, inputEvent.pointer, inputEvent.button);
            }
            return true;
        } else if (ordinal != 1) {
            if (ordinal != 2) {
                return false;
            }
            this.event = inputEvent;
            this.actor = inputEvent.listenerActor;
            this.detector.touchDragged(inputEvent.stageX, inputEvent.stageY, inputEvent.pointer);
            return true;
        } else if (inputEvent.isTouchFocusCancel()) {
            this.detector.reset();
            return false;
        } else {
            this.event = inputEvent;
            this.actor = inputEvent.listenerActor;
            this.detector.touchUp(inputEvent.stageX, inputEvent.stageY, inputEvent.pointer, inputEvent.button);
            Actor actor3 = this.actor;
            Vector2 vector23 = tmpCoords;
            float f4 = inputEvent.stageX;
            float f5 = inputEvent.stageY;
            vector23.x = f4;
            vector23.y = f5;
            Group group3 = actor3.parent;
            if (group3 != null) {
                Group group4 = group3.parent;
                if (group4 != null) {
                    group4.stageToLocalCoordinates(vector23);
                }
                group3.parentToLocalCoordinates(vector23);
            }
            actor3.parentToLocalCoordinates(vector23);
            return true;
        }
    }

    public abstract void pan(InputEvent inputEvent, float f2, float f3, float f4, float f5);

    public void panStop(InputEvent inputEvent, float f2, float f3, int i, int i2) {
    }

    public void touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
    }
}
