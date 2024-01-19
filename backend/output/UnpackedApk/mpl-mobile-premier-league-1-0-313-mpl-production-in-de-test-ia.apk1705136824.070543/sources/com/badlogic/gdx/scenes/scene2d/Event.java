package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.utils.Pool.Poolable;

public class Event implements Poolable {
    public boolean bubbles = true;
    public boolean cancelled;
    public boolean handled;
    public Actor listenerActor;
    public Stage stage;
    public boolean stopped;
    public Actor targetActor;

    public void reset() {
        this.stage = null;
        this.targetActor = null;
        this.listenerActor = null;
        this.bubbles = true;
        this.handled = false;
        this.stopped = false;
        this.cancelled = false;
    }
}
