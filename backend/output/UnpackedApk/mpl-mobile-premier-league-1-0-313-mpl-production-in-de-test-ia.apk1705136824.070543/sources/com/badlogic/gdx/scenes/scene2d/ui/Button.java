package com.badlogic.gdx.scenes.scene2d.ui;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.SnapshotArray;

public class Button extends Table {
    public ButtonGroup buttonGroup;
    public ClickListener clickListener;
    public boolean isChecked;
    public boolean programmaticChangeEvents = true;
    public ButtonStyle style;

    public static class ButtonStyle {
        public Drawable checked;
        public Drawable checkedDown;
        public Drawable checkedFocused;
        public float checkedOffsetX;
        public float checkedOffsetY;
        public Drawable checkedOver;
        public Drawable down;
        public Drawable focused;
        public Drawable over;
        public float pressedOffsetX;
        public float pressedOffsetY;
        public float unpressedOffsetX;
        public float unpressedOffsetY;
        public Drawable up;
    }

    public Button() {
        this.touchable = Touchable.enabled;
        AnonymousClass1 r0 = new ClickListener() {
            public void clicked(InputEvent inputEvent, float f2, float f3) {
                Button button = Button.this;
                if (button != null) {
                    button.setChecked(!button.isChecked, true);
                    return;
                }
                throw null;
            }
        };
        this.clickListener = r0;
        addListener(r0);
    }

    public void draw(Batch batch, float f2) {
        float f3;
        float f4;
        validate();
        setBackground(getBackgroundDrawable());
        if (isPressed()) {
            ButtonStyle buttonStyle = this.style;
            f3 = buttonStyle.pressedOffsetX;
            f4 = buttonStyle.pressedOffsetY;
        } else if (this.isChecked) {
            ButtonStyle buttonStyle2 = this.style;
            f3 = buttonStyle2.checkedOffsetX;
            f4 = buttonStyle2.checkedOffsetY;
        } else {
            ButtonStyle buttonStyle3 = this.style;
            f3 = buttonStyle3.unpressedOffsetX;
            f4 = buttonStyle3.unpressedOffsetY;
        }
        boolean z = (f3 == 0.0f && f4 == 0.0f) ? false : true;
        SnapshotArray<Actor> snapshotArray = this.children;
        if (z) {
            for (int i = 0; i < snapshotArray.size; i++) {
                ((Actor) snapshotArray.get(i)).moveBy(f3, f4);
            }
        }
        super.draw(batch, f2);
        if (z) {
            for (int i2 = 0; i2 < snapshotArray.size; i2++) {
                ((Actor) snapshotArray.get(i2)).moveBy(-f3, -f4);
            }
        }
        Stage stage = this.stage;
        if (stage != null && stage.actionsRequestRendering && isPressed() != this.clickListener.pressed) {
            ((AndroidGraphics) k.graphics).requestRendering();
        }
    }

    public Drawable getBackgroundDrawable() {
        if (isPressed()) {
            if (this.isChecked) {
                Drawable drawable = this.style.checkedDown;
                if (drawable != null) {
                    return drawable;
                }
            }
            Drawable drawable2 = this.style.down;
            if (drawable2 != null) {
                return drawable2;
            }
        }
        if (isOver()) {
            if (this.isChecked) {
                Drawable drawable3 = this.style.checkedOver;
                if (drawable3 != null) {
                    return drawable3;
                }
            } else {
                Drawable drawable4 = this.style.over;
                if (drawable4 != null) {
                    return drawable4;
                }
            }
        }
        Stage stage = this.stage;
        boolean z = stage != null && stage.keyboardFocus == this;
        if (this.isChecked) {
            if (z) {
                Drawable drawable5 = this.style.checkedFocused;
                if (drawable5 != null) {
                    return drawable5;
                }
            }
            Drawable drawable6 = this.style.checked;
            if (drawable6 != null) {
                return drawable6;
            }
            if (isOver()) {
                Drawable drawable7 = this.style.over;
                if (drawable7 != null) {
                    return drawable7;
                }
            }
        }
        if (z) {
            Drawable drawable8 = this.style.focused;
            if (drawable8 != null) {
                return drawable8;
            }
        }
        return this.style.up;
    }

    public float getMinHeight() {
        return getPrefHeight();
    }

    public float getMinWidth() {
        return getPrefWidth();
    }

    public float getPrefHeight() {
        float prefHeight = super.getPrefHeight();
        Drawable drawable = this.style.up;
        if (drawable != null) {
            prefHeight = Math.max(prefHeight, drawable.getMinHeight());
        }
        Drawable drawable2 = this.style.down;
        if (drawable2 != null) {
            prefHeight = Math.max(prefHeight, drawable2.getMinHeight());
        }
        Drawable drawable3 = this.style.checked;
        return drawable3 != null ? Math.max(prefHeight, drawable3.getMinHeight()) : prefHeight;
    }

    public float getPrefWidth() {
        float prefWidth = super.getPrefWidth();
        Drawable drawable = this.style.up;
        if (drawable != null) {
            prefWidth = Math.max(prefWidth, drawable.getMinWidth());
        }
        Drawable drawable2 = this.style.down;
        if (drawable2 != null) {
            prefWidth = Math.max(prefWidth, drawable2.getMinWidth());
        }
        Drawable drawable3 = this.style.checked;
        return drawable3 != null ? Math.max(prefWidth, drawable3.getMinWidth()) : prefWidth;
    }

    public boolean isOver() {
        ClickListener clickListener2 = this.clickListener;
        return clickListener2.over || clickListener2.pressed;
    }

    public boolean isPressed() {
        ClickListener clickListener2 = this.clickListener;
        if (clickListener2.pressed) {
            return true;
        }
        long j = clickListener2.visualPressedTime;
        if (j > 0) {
            if (j > System.currentTimeMillis()) {
                return true;
            }
            clickListener2.visualPressedTime = 0;
        }
        return false;
    }

    public void setChecked(boolean z) {
        setChecked(z, this.programmaticChangeEvents);
    }

    public void setChecked(boolean z, boolean z2) {
        boolean z3 = this.isChecked;
        if (z3 != z) {
            ButtonGroup buttonGroup2 = this.buttonGroup;
            if (buttonGroup2 != null) {
                if (buttonGroup2 != null) {
                    boolean z4 = false;
                    if (z3 != z) {
                        if (!z) {
                            Array<T> array = buttonGroup2.checkedButtons;
                            if (array.size > buttonGroup2.minCheckCount) {
                                array.removeValue(this, true);
                            }
                        } else {
                            int i = buttonGroup2.maxCheckCount;
                            if (i != -1 && buttonGroup2.checkedButtons.size >= i) {
                                if (buttonGroup2.uncheckLast) {
                                    int i2 = buttonGroup2.minCheckCount;
                                    buttonGroup2.minCheckCount = 0;
                                    buttonGroup2.lastChecked.setChecked(false);
                                    buttonGroup2.minCheckCount = i2;
                                }
                            }
                            buttonGroup2.checkedButtons.add(this);
                            buttonGroup2.lastChecked = this;
                        }
                        z4 = true;
                    }
                    if (!z4) {
                        return;
                    }
                } else {
                    throw null;
                }
            }
            this.isChecked = z;
            if (z2) {
                ChangeEvent changeEvent = (ChangeEvent) Pools.obtain(ChangeEvent.class);
                if (fire(changeEvent)) {
                    this.isChecked = !z;
                }
                Pools.free(changeEvent);
            }
        }
    }
}
