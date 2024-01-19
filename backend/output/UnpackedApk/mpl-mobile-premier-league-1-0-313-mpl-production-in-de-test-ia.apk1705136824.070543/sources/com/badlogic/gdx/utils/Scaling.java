package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Vector2;

public enum Scaling {
    fit,
    contain,
    fill,
    fillX,
    fillY,
    stretch,
    stretchX,
    stretchY,
    none;
    
    public static final Vector2 temp = null;

    /* access modifiers changed from: public */
    static {
        temp = new Vector2();
    }

    public Vector2 apply(float f2, float f3, float f4, float f5) {
        switch (ordinal()) {
            case 0:
                float f6 = f5 / f4 > f3 / f2 ? f4 / f2 : f5 / f3;
                Vector2 vector2 = temp;
                vector2.x = f2 * f6;
                vector2.y = f3 * f6;
                break;
            case 1:
                float f7 = f5 / f4 > f3 / f2 ? f4 / f2 : f5 / f3;
                if (f7 > 1.0f) {
                    f7 = 1.0f;
                }
                Vector2 vector22 = temp;
                vector22.x = f2 * f7;
                vector22.y = f3 * f7;
                break;
            case 2:
                float f8 = f5 / f4 < f3 / f2 ? f4 / f2 : f5 / f3;
                Vector2 vector23 = temp;
                vector23.x = f2 * f8;
                vector23.y = f3 * f8;
                break;
            case 3:
                float f9 = f4 / f2;
                Vector2 vector24 = temp;
                vector24.x = f2 * f9;
                vector24.y = f3 * f9;
                break;
            case 4:
                float f10 = f5 / f3;
                Vector2 vector25 = temp;
                vector25.x = f2 * f10;
                vector25.y = f3 * f10;
                break;
            case 5:
                Vector2 vector26 = temp;
                vector26.x = f4;
                vector26.y = f5;
                break;
            case 6:
                Vector2 vector27 = temp;
                vector27.x = f4;
                vector27.y = f3;
                break;
            case 7:
                Vector2 vector28 = temp;
                vector28.x = f2;
                vector28.y = f5;
                break;
            case 8:
                Vector2 vector29 = temp;
                vector29.x = f2;
                vector29.y = f3;
                break;
        }
        return temp;
    }
}
