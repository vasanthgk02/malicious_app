package com.badlogic.gdx.scenes.scene2d.actions;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;

public class AlphaAction extends TemporalAction {
    public Color color;
    public float end;
    public float start;

    public void begin() {
        if (this.color == null) {
            this.color = this.target.color;
        }
        this.start = this.color.f3306a;
    }

    public void reset() {
        super.reset();
        this.color = null;
    }

    public void update(float f2) {
        if (f2 == 0.0f) {
            this.color.f3306a = this.start;
        } else if (f2 == 1.0f) {
            this.color.f3306a = this.end;
        } else {
            Color color2 = this.color;
            float f3 = this.start;
            color2.f3306a = GeneratedOutlineSupport.outline3(this.end, f3, f2, f3);
        }
    }
}
