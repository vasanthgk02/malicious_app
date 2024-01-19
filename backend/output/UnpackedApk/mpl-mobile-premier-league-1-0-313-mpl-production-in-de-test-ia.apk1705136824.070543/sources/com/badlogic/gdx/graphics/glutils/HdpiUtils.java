package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;

public class HdpiUtils {
    public static HdpiMode mode = HdpiMode.Logical;

    public static void glScissor(int i, int i2, int i3, int i4) {
        if (mode == HdpiMode.Logical) {
            Graphics graphics = k.graphics;
            if (!(((AndroidGraphics) graphics).width == ((AndroidGraphics) graphics).width && ((AndroidGraphics) graphics).height == ((AndroidGraphics) graphics).height)) {
                k.gl.glScissor(toBackBufferX(i), toBackBufferY(i2), toBackBufferX(i3), toBackBufferY(i4));
                return;
            }
        }
        k.gl.glScissor(i, i2, i3, i4);
    }

    public static void glViewport(int i, int i2, int i3, int i4) {
        if (mode == HdpiMode.Logical) {
            Graphics graphics = k.graphics;
            if (!(((AndroidGraphics) graphics).width == ((AndroidGraphics) graphics).width && ((AndroidGraphics) graphics).height == ((AndroidGraphics) graphics).height)) {
                k.gl.glViewport(toBackBufferX(i), toBackBufferY(i2), toBackBufferX(i3), toBackBufferY(i4));
                return;
            }
        }
        k.gl.glViewport(i, i2, i3, i4);
    }

    public static void setMode(HdpiMode hdpiMode) {
        mode = hdpiMode;
    }

    public static int toBackBufferX(int i) {
        Graphics graphics = k.graphics;
        return (int) (((float) (i * ((AndroidGraphics) graphics).width)) / ((float) ((AndroidGraphics) graphics).width));
    }

    public static int toBackBufferY(int i) {
        Graphics graphics = k.graphics;
        return (int) (((float) (i * ((AndroidGraphics) graphics).height)) / ((float) ((AndroidGraphics) graphics).height));
    }

    public static int toLogicalX(int i) {
        Graphics graphics = k.graphics;
        return (int) (((float) (i * ((AndroidGraphics) graphics).width)) / ((float) ((AndroidGraphics) graphics).width));
    }

    public static int toLogicalY(int i) {
        Graphics graphics = k.graphics;
        return (int) (((float) (i * ((AndroidGraphics) graphics).height)) / ((float) ((AndroidGraphics) graphics).height));
    }
}
