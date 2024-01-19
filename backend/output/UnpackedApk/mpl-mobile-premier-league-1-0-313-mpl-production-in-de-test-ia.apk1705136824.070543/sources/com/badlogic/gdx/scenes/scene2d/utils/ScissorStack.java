package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class ScissorStack {
    public static Array<Rectangle> scissors = new Array<>();
    public static Vector3 tmp = new Vector3();

    static {
        new Rectangle();
    }
}
