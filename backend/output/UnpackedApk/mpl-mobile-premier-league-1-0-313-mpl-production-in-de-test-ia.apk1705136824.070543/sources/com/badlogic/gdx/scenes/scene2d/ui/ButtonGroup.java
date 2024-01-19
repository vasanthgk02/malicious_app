package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Array;

public class ButtonGroup<T extends Button> {
    public final Array<T> buttons = new Array<>();
    public Array<T> checkedButtons = new Array<>(true, 1);
    public T lastChecked;
    public int maxCheckCount = 1;
    public int minCheckCount = 1;
    public boolean uncheckLast = true;

    public void add(T t) {
        t.buttonGroup = null;
        boolean z = t.isChecked || this.buttons.size < this.minCheckCount;
        t.setChecked(false, t.programmaticChangeEvents);
        t.buttonGroup = this;
        this.buttons.add(t);
        t.setChecked(z, t.programmaticChangeEvents);
    }

    public int getCheckedIndex() {
        Array<T> array = this.checkedButtons;
        if (array.size > 0) {
            return this.buttons.indexOf(array.get(0), true);
        }
        return -1;
    }

    public void setChecked(String str) {
        if (str != null) {
            int i = 0;
            int i2 = this.buttons.size;
            while (i < i2) {
                Button button = (Button) this.buttons.get(i);
                if (!(button instanceof TextButton) || !str.contentEquals(((TextButton) button).label.text)) {
                    i++;
                } else {
                    button.setChecked(true, button.programmaticChangeEvents);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("text cannot be null.");
    }
}
