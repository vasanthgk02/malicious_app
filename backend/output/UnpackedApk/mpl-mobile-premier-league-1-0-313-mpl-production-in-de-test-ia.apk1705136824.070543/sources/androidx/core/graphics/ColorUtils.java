package androidx.core.graphics;

import android.graphics.Color;
import com.android.tools.r8.GeneratedOutlineSupport;
import sfs2x.client.entities.invitation.InvitationReply;

public final class ColorUtils {
    public static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = compositeColors(i, i2);
            }
            double calculateLuminance = calculateLuminance(i) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("background can not be translucent: #");
        outline73.append(Integer.toHexString(i2));
        throw new IllegalArgumentException(outline73.toString());
    }

    public static double calculateLuminance(int i) {
        double d2;
        double d3;
        double d4;
        double d5;
        double[] dArr = TEMP_ARRAY.get();
        if (dArr == null) {
            dArr = new double[3];
            TEMP_ARRAY.set(dArr);
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (dArr.length == 3) {
            double d6 = ((double) red) / 255.0d;
            if (d6 < 0.04045d) {
                d2 = d6 / 12.92d;
            } else {
                d2 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            double d7 = ((double) green) / 255.0d;
            if (d7 < 0.04045d) {
                d4 = d7 / 12.92d;
                d3 = 2.4d;
            } else {
                d3 = 2.4d;
                d4 = Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            }
            double d8 = ((double) blue) / 255.0d;
            if (d8 < 0.04045d) {
                d5 = d8 / 12.92d;
            } else {
                d5 = Math.pow((d8 + 0.055d) / 1.055d, d3);
            }
            dArr[0] = ((0.1805d * d5) + (0.3576d * d4) + (0.4124d * d2)) * 100.0d;
            dArr[1] = ((0.0722d * d5) + (0.7152d * d4) + (0.2126d * d2)) * 100.0d;
            double d9 = d5 * 0.9505d;
            dArr[2] = (d9 + (d4 * 0.1192d) + (d2 * 0.0193d)) * 100.0d;
            return dArr[1] / 100.0d;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha2) * (255 - alpha)) / InvitationReply.EXPIRED);
        return Color.argb(i3, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, i3), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, i3), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    public static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((255 - i2) * (i3 * i4)) + ((i * InvitationReply.EXPIRED) * i2)) / (i5 * InvitationReply.EXPIRED);
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & 16777215) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
