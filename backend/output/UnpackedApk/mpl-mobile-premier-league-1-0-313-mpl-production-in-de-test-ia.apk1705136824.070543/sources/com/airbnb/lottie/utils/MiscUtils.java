package com.airbnb.lottie.utils;

import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.KeyPath;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public class MiscUtils {
    public static PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean contains(float f2, float f3, float f4) {
        return f2 >= f3 && f2 <= f4;
    }

    public static int floorMod(float f2, float f3) {
        int i = (int) f2;
        int i2 = (int) f3;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    public static float lerp(float f2, float f3, float f4) {
        return GeneratedOutlineSupport.outline3(f3, f2, f4, f2);
    }

    public static int lerp(int i, int i2, float f2) {
        return (int) ((f2 * ((float) (i2 - i))) + ((float) i));
    }

    public static void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static double clamp(double d2, double d3, double d4) {
        return Math.max(d3, Math.min(d4, d2));
    }
}
