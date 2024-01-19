package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

public abstract class Value {
    public static Value maxHeight = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getMaxHeight();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.height;
            }
            return f2;
        }
    };
    public static Value maxWidth = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getMaxWidth();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.width;
            }
            return f2;
        }
    };
    public static Value minHeight = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getMinHeight();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.height;
            }
            return f2;
        }
    };
    public static Value minWidth = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getMinWidth();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.width;
            }
            return f2;
        }
    };
    public static Value prefHeight = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getPrefHeight();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.height;
            }
            return f2;
        }
    };
    public static Value prefWidth = new Value() {
        public float get(Actor actor) {
            float f2;
            if (actor instanceof Layout) {
                return ((Layout) actor).getPrefWidth();
            }
            if (actor == null) {
                f2 = 0.0f;
            } else {
                f2 = actor.width;
            }
            return f2;
        }
    };
    public static final Fixed zero = new Fixed(0.0f);

    public static class Fixed extends Value {
        public static final Fixed[] cache = new Fixed[111];
        public final float value;

        public Fixed(float f2) {
            this.value = f2;
        }

        public static Fixed valueOf(float f2) {
            if (f2 == 0.0f) {
                return Value.zero;
            }
            if (f2 >= -10.0f && f2 <= 100.0f) {
                int i = (int) f2;
                if (f2 == ((float) i)) {
                    Fixed[] fixedArr = cache;
                    int i2 = i + 10;
                    Fixed fixed = fixedArr[i2];
                    if (fixed == null) {
                        fixed = new Fixed(f2);
                        fixedArr[i2] = fixed;
                    }
                    return fixed;
                }
            }
            return new Fixed(f2);
        }

        public float get(Actor actor) {
            return this.value;
        }

        public String toString() {
            return Float.toString(this.value);
        }
    }

    public abstract float get(Actor actor);
}
