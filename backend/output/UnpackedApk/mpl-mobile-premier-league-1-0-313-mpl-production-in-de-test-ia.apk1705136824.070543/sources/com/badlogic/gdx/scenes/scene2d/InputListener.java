package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.math.Vector2;

public class InputListener implements EventListener {
    public static final Vector2 tmpCoords = new Vector2();

    public void enter(InputEvent inputEvent, float f2, float f3, int i, Actor actor) {
    }

    public void exit(InputEvent inputEvent, float f2, float f3, int i, Actor actor) {
    }

    public boolean handle(Event event) {
        if (!(event instanceof InputEvent)) {
            return false;
        }
        InputEvent inputEvent = (InputEvent) event;
        int ordinal = inputEvent.type.ordinal();
        if (ordinal == 7 || ordinal == 8 || ordinal == 9) {
            return false;
        }
        Actor actor = inputEvent.listenerActor;
        Vector2 vector2 = tmpCoords;
        float f2 = inputEvent.stageX;
        float f3 = inputEvent.stageY;
        vector2.x = f2;
        vector2.y = f3;
        Group group = actor.parent;
        if (group != null) {
            Group group2 = group.parent;
            if (group2 != null) {
                group2.stageToLocalCoordinates(vector2);
            }
            group.parentToLocalCoordinates(vector2);
        }
        actor.parentToLocalCoordinates(vector2);
        switch (inputEvent.type.ordinal()) {
            case 0:
                Vector2 vector22 = tmpCoords;
                boolean z = touchDown(inputEvent, vector22.x, vector22.y, inputEvent.pointer, inputEvent.button);
                if (z && inputEvent.touchFocus) {
                    inputEvent.stage.addTouchFocus(this, inputEvent.listenerActor, inputEvent.targetActor, inputEvent.pointer, inputEvent.button);
                }
                return z;
            case 1:
                Vector2 vector23 = tmpCoords;
                touchUp(inputEvent, vector23.x, vector23.y, inputEvent.pointer, inputEvent.button);
                return true;
            case 2:
                Vector2 vector24 = tmpCoords;
                touchDragged(inputEvent, vector24.x, vector24.y, inputEvent.pointer);
                return true;
            case 3:
                Vector2 vector25 = tmpCoords;
                return mouseMoved(inputEvent, vector25.x, vector25.y);
            case 4:
                Vector2 vector26 = tmpCoords;
                enter(inputEvent, vector26.x, vector26.y, inputEvent.pointer, inputEvent.relatedActor);
                return false;
            case 5:
                Vector2 vector27 = tmpCoords;
                exit(inputEvent, vector27.x, vector27.y, inputEvent.pointer, inputEvent.relatedActor);
                return false;
            case 6:
                Vector2 vector28 = tmpCoords;
                return scrolled(inputEvent, vector28.x, vector28.y, inputEvent.scrollAmountX, inputEvent.scrollAmountY);
            default:
                return false;
        }
    }

    public boolean mouseMoved(InputEvent inputEvent, float f2, float f3) {
        return false;
    }

    public boolean scrolled(InputEvent inputEvent, float f2, float f3, float f4, float f5) {
        return false;
    }

    public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
        return false;
    }

    public void touchDragged(InputEvent inputEvent, float f2, float f3, int i) {
    }

    public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
    }
}
