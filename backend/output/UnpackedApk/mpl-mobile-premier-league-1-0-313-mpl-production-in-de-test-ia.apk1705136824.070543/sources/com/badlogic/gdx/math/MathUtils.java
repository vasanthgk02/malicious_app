package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Random;

public final class MathUtils {
    public static Random random = new RandomXS128();

    public static class Sin {
        public static final float[] table = new float[16384];

        static {
            for (int i = 0; i < 16384; i++) {
                table[i] = (float) Math.sin((double) (((((float) i) + 0.5f) / 16384.0f) * 6.2831855f));
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                float f2 = (float) i2;
                table[((int) (45.511112f * f2)) & 16383] = (float) Math.sin((double) (f2 * 0.017453292f));
            }
        }
    }

    public static int ceil(float f2) {
        return 16384 - ((int) (16384.0d - ((double) f2)));
    }

    public static float clamp(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static float cos(float f2) {
        return Sin.table[((int) ((f2 + 1.5707964f) * 2607.5945f)) & 16383];
    }

    public static float cosDeg(float f2) {
        return Sin.table[((int) ((f2 + 90.0f) * 45.511112f)) & 16383];
    }

    public static boolean isEqual(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.0E-6f;
    }

    public static boolean isPowerOfTwo(int i) {
        return i != 0 && (i & (i + -1)) == 0;
    }

    public static boolean isZero(float f2) {
        return Math.abs(f2) <= 1.0E-6f;
    }

    public static int nextPowerOfTwo(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public static int random(int i) {
        return random.nextInt(i + 1);
    }

    public static float sin(float f2) {
        return Sin.table[((int) (f2 * 2607.5945f)) & 16383];
    }

    public static float sinDeg(float f2) {
        return Sin.table[((int) (f2 * 45.511112f)) & 16383];
    }

    public static boolean isEqual(float f2, float f3, float f4) {
        return Math.abs(f2 - f3) <= f4;
    }

    public static float random() {
        return random.nextFloat();
    }

    public static float random(float f2) {
        return random.nextFloat() * f2;
    }

    public static float random(float f2, float f3) {
        return GeneratedOutlineSupport.outline3(f3, f2, random.nextFloat(), f2);
    }
}
