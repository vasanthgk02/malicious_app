package com.badlogic.gdx.scenes.scene2d.utils;

import a.a.l.g;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.cfg.mendikot.b;
import java.util.Map.Entry;

public abstract class ChangeListener implements EventListener {

    public static class ChangeEvent extends Event {
    }

    public boolean handle(Event event) {
        if (!(event instanceof ChangeEvent)) {
            return false;
        }
        Actor actor = event.targetActor;
        String str = ((ChangeEvent) event).targetActor.name;
        for (Entry next : b.this.k.entrySet()) {
            ((g) next.getValue()).setVisible(((String) next.getKey()).contains(str));
        }
        return false;
    }
}
