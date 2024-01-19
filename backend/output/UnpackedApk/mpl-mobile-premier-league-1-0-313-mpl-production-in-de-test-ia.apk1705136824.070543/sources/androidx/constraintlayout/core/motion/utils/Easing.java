package androidx.constraintlayout.core.motion.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintStream;
import java.util.Arrays;

public class Easing {
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", "linear"};
    public static Easing sDefault = new Easing();
    public String str = "identity";

    public static class CubicEasing extends Easing {
        public double x1;
        public double x2;
        public double y1;
        public double y2;

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.y1 = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.x2 = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.y2 = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        public double get(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 0.01d) {
                d3 *= 0.5d;
                d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double x = getX(d5);
            double d6 = d4 + d3;
            double x3 = getX(d6);
            double y = getY(d5);
            return (((d2 - x) * (getY(d6) - y)) / (x3 - x)) + y;
        }

        public double getDiff(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 1.0E-4d) {
                d3 *= 0.5d;
                d4 = getX(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (getY(d6) - getY(d5)) / (getX(d6) - getX(d5));
        }

        public final double getX(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.x2 * d6) + (this.x1 * d5) + (d2 * d2 * d2);
        }

        public final double getY(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.y2 * d6) + (this.y1 * d5) + (d2 * d2 * d2);
        }
    }

    public static Easing getInterpolator(String str2) {
        if (str2 == null) {
            return null;
        }
        if (str2.startsWith("cubic")) {
            return new CubicEasing(str2);
        }
        if (str2.startsWith("spline")) {
            return new StepCurve(str2);
        }
        if (str2.startsWith("Schlick")) {
            return new Schlick(str2);
        }
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1354466595:
                if (str2.equals("accelerate")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1263948740:
                if (str2.equals("decelerate")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1197605014:
                if (str2.equals("anticipate")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1102672091:
                if (str2.equals("linear")) {
                    c2 = 3;
                    break;
                }
                break;
            case -749065269:
                if (str2.equals("overshoot")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1312628413:
                if (str2.equals("standard")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
        }
        if (c2 == 1) {
            return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
        }
        if (c2 == 2) {
            return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
        }
        if (c2 == 3) {
            return new CubicEasing("cubic(1, 1, 0, 0)");
        }
        if (c2 == 4) {
            return new CubicEasing("cubic(0.36, 0, 0.66, -0.56)");
        }
        if (c2 == 5) {
            return new CubicEasing("cubic(0.34, 1.56, 0.64, 1)");
        }
        PrintStream printStream = System.err;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
        outline73.append(Arrays.toString(NAMED_EASING));
        printStream.println(outline73.toString());
        return sDefault;
    }

    public double get(double d2) {
        return d2;
    }

    public double getDiff(double d2) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }
}
